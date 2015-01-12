<%@page
	import="com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpDirectDeposit"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpDirectDeposits"
	name="updateEmpDirectDeposits" />
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#empDirectDepositsAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />depositAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace />depositAdd').hide();
   A.one('#<portlet:namespace />depositDelete').hide();
   A.one('#empDirectDepositsAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace />cancelDirectDeposit');
   cancelButton.on('click',function()
   {
	   A.one('#empDirectDepositsAdd').hide();
	   A.one('#depositAddDelete').show();
	   A.one('#<portlet:namespace />depositAdd').show();
       A.one('#<portlet:namespace />depositDelete').show();
   });
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId = (Long) empId.get("fileId");
	DynamicQuery empDepositDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpDirectDeposit.class,
					PortletClassLoaderUtil.getClassLoader());
	empDepositDynamicQuery.add(PropertyFactoryUtil
			.forName("employeeId").eq(employeeId));
	List<EmpDirectDeposit> empDirectDeposits = EmpDirectDepositLocalServiceUtil
			.dynamicQuery(empDepositDynamicQuery);
%>
<div id="empDirectDepositsAdd" class="panel">
	<div class="panel-heading">
		<h3>Direct Deposits</h3>
	</div>
	<div class="panel-body">
			<div class="form-horizontal">
	<aui:form name="empDirectDeposits" id="empDirectDeposits" method="post"
		action="<%=updateEmpDirectDeposits%>">
		<aui:input name="empDirId" value="<%=employeeId%>" type="hidden"></aui:input>
		<aui:input name="directFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:input name="deposit_amount" label="01_amount"></aui:input>
				<aui:input name="deposit_acnt_number" label="01_acnt-number"></aui:input>
				<aui:input name="fin_institute" label="01_name-financial-institute"></aui:input>
				<aui:select name="acnt_type" label="01_acnt-type">
					<aui:option value="check" label="01_check"></aui:option>
					<aui:option value="saving" label="01_saving"></aui:option>
				</aui:select>
				<aui:input name="branch_location" label="01_branch-location"></aui:input>
				<aui:input name="routing_number" label="01_routing-number"></aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" value="Save" id="submitDirectDeposits" cssClass="button btn-success"></aui:button>
						<aui:button  value="Cancel" id="cancelDirectDeposit" cssClass="button btn-danger"
						name="cancelDirectDeposit" type="reset" ></aui:button>
					</div>
				</div>
				</aui:form>
			</div>
		</div>
</div>
<liferay-portlet:renderURL varImpl="depositsURL">
	<portlet:param name="jsp" value="jsp11" />
	<portlet:param name="empId" value="<%=String.valueOf(employeeId)%>" />
	<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId)%>" />
</liferay-portlet:renderURL>
<div id="depositAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Direct Deposit Records</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="depositAdd" name="depositAdd" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="depositDelete"  value="Delete"
				cssClass="button btn-danger" name="depositDelete" ></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSupervisor"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>"
			iteratorURL="<%=depositsURL %>">
			<liferay-ui:search-container-results>
				<%
			List<EmpDirectDeposit> directDeposits = empDirectDeposits;
							results = ListUtil.subList(directDeposits,
									searchContainer.getStart(),
									searchContainer.getEnd());
							total = directDeposits.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
		%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpDirectDeposit"
				modelVar="id">
				<liferay-ui:search-container-column-text name="Amount"
					property="amount" />
				<liferay-ui:search-container-column-text name="Account Number"
					property="accountNumber" />
				<liferay-ui:search-container-column-text
					name="Financial Institution" property="bankName" />
				<liferay-ui:search-container-column-text name="Account Type"
					property="accountType" />
				<liferay-ui:search-container-column-text name="Branch Location"
					property="branchLocation" />
				<liferay-ui:search-container-column-text name="Routing Number"
					property="routingNumber" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>