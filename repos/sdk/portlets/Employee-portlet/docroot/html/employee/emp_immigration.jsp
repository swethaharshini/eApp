<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addImmigrationDetails"
	var="addImmigrationDetails" ></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#empImmigrationAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />immigrationAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>immigrationAdd').hide();
   A.one('#<portlet:namespace/>immigrationDelete').hide();
   A.one('#empImmigrationAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelImmigrationDetails');
   cancelButton.on('click',function()
   {
    A.one('#empImmigrationAdd').hide();
    A.one('#empImmigrationAddDelete').show();
    A.one('#<portlet:namespace/>immigrationAdd').show();
   A.one('#<portlet:namespace/>immigrationDelete').show();
   })
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute(
			"empId");
	long employeeId = (Long)empId.get("empId");
	String jsp=(String)empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery dependentDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpImmigrationDocument.class,
					PortletClassLoaderUtil.getClassLoader());
	dependentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpImmigrationDocument> empImmigrationDocument =EmpImmigrationDocumentLocalServiceUtil
			.dynamicQuery(dependentDynamicQuery);
%>
<div id="empImmigrationAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Immigration</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addImmigration" id="addImmigration"
			action="<%=addImmigrationDetails %>" method="post">
			<aui:input name="empImgId" value="<%=employeeId %>" type="hidden"></aui:input>
			<aui:input name="immiFileId" value="<%=fileEntryId %>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span10">
					<div class="span3">
						<label>Document</label>
					</div>
					<div class="span4">
						<aui:input inlineLabel="right" name="document_type" type="radio"
							value="Passport" label="01_passport" disabled="true" />
					</div>
					<div class="span2">
						<aui:input checked="<%=true%>" inlineLabel="right" name="document_type"
							type="radio" value="Visa" label="01_visa" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="img_number" label="01_number"
						showRequiredLabel="false" inlineLabel="left">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="img_issued_date" id="imgIssueDate"
						label="01_issued-date" cssClass="dateEmployee" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="img_exp_date" id="imgExpDate" label="01_expiry-date"
						inlineLabel="left" cssClass="dateEmployee" ></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="eligible_status" label="01_eligible-status"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="issued_by" label="01_issued-by">
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="review_date" id="reviewDate" label="01_review-date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="img_comments" type="textarea" label="01_comments"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitImmigrationDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
			id="cancelImmigrationDetails" name="cancelImmigrationDetails" ></aui:button>
		</aui:form>
	</div>
</div>
<div id="empImmigrationAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Immigration Records</h3>
	</div>
	<div class="panel-body">
		<aui:button id="immigrationAdd" name="immigrationAdd" value="Add"
		cssClass="button btn-primary"></aui:button>
		<aui:button id="immigrationDelete" value="Delete"
			name="immigrationDelete" cssClass="button btn-danger"></aui:button>
			<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpImmigrationDocument"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpImmigrationDocument> immigrationDetails = empImmigrationDocument;
							results = immigrationDetails;
							total = immigrationDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpImmigrationDocument"
				modelVar="id">
				<liferay-ui:search-container-column-text name="01_document" property="docType" />
				<liferay-ui:search-container-column-text name="01_number"
					property="docNumber" />
				<liferay-ui:search-container-column-text name="01_issued-by" property="issuedBy" />
				<liferay-ui:search-container-column-text name="01_issued-date"
					property="issuedDate" />
				<liferay-ui:search-container-column-text name="01_expiry-date"
					property="expiryDate" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
