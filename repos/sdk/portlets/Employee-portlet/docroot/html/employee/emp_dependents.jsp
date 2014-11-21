<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateAssignedDependents"
	var="updateAssignedDependents" ></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#assignedDependentAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />dependentAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>dependentAdd').hide();
   A.one('#<portlet:namespace/>dependentDelete').hide();
   A.one('#assignedDependentAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelDependentDetails');
   cancelButton.on('click',function()
   {
	   A.one('#assignedDependentAdd').hide();
	   A.one('#assignedDependentAddDelete').show();
	   A.one('#<portlet:namespace/>dependentAdd').show();
       A.one('#<portlet:namespace/>dependentDelete').show();
   });
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute(
			"empId");
	long employeeId = (Long)empId.get("empId");
	String jsp=(String)empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	String dependentName, dependentRelation, dependentDOB;
	DynamicQuery dependentDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpDependent.class,
					PortletClassLoaderUtil.getClassLoader());
	dependentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpDependent> empDependentDetails = EmpDependentLocalServiceUtil
			.dynamicQuery(dependentDynamicQuery);
%>
<div id="assignedDependentAdd" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-dependent"></liferay-ui:message></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addDependent" id="addDependent"
			action="<%=updateAssignedDependents%>" method="post">
			<aui:input name="empDependentId" value="<%=employeeId %>" type="hidden" />
			<aui:input name="dependentFileId" value="<%=fileEntryId %>" type="hidden" />
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="dependent_name" label="01_name"
						 inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="dependent_relationship" label="01_relationship"
				 inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitDependentDetails"></aui:button>
			<aui:button type="reset" value="Cancel" id="cancelDependentDetails"
			cssClass="button btn-danger" name="cancelDependentDetails"></aui:button>
		</aui:form>
	</div>
</div>
<div id="assignedDependentAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Dependents</h3>
	</div>
	<div class="panel-body">
		<aui:button id="dependentAdd" name="dependentAdd" value="Add" 
		cssClass="button btn-primary"></aui:button>
		<aui:button id="dependentDelete" value="Delete" name="dependentDelete"
		cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpDependent"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpDependent> dependentDetails = empDependentDetails;
							results = dependentDetails;
							total = dependentDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpDependent"
				modelVar="id">
				<liferay-ui:search-container-column-text name="01_name" property="name" />
				<liferay-ui:search-container-column-text name="01_relation"
					property="relationship" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
