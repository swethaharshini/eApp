<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateMembership" var="updateMembership">
</portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#addEmpMembership').hide();
  });
   var addButton=A.one('#<portlet:namespace />empMembershipAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace />empMembershipAdd').hide();
   A.one('#<portlet:namespace />empMembershipDelete').hide();
   A.one('#addEmpMembership').show();
   });
   var cancelButton=A.one('#<portlet:namespace />cancelMembership');
   cancelButton.on('click',function()
   {
	   A.one('#addEmpMembership').hide();
	   A.one('#<portlet:namespace />empMembershipAdd').show();
       A.one('#<portlet:namespace />empMembershipDelete').show();
   });
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
%>
<div id="addEmpMembership" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-membership"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmployeeMembership" id="addEmployeeMembership"
			action="<%=updateMembership%>" method="post">
			<div class="form-horizontal">
				<aui:input name="empMemId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="memFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="emp_membership" label="01_membership"
					inlineLabel="left" showRequiredLabel="false">
				<%
				List<Membership> membershipList = MembershipLocalServiceUtil
								.getMemberships(-1, -1);
						Iterator membershipList2 = membershipList.iterator();
						while (membershipList2.hasNext()) {
							Membership membership = (Membership) membershipList2
									.next();
				%>
				<aui:option value="<%=membership.getMembershipName()%>"
				label="<%=membership.getMembershipName()%>"></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:select name="sub_paid_by" label="01_subscription-paid-by">
				<aui:option>Individual</aui:option>
				<aui:option>Company</aui:option>
				</aui:select>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitMembershipDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelMembership" name="cancelMembership"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div id="empMembershipAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_membership"/></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empMembershipAdd" name="empMembershipAdd" value="Add" cssClass="button btn-primary"></aui:button>
			<aui:button id="empMembershipDelete" value="Delete" name="empMembershipDelete" cssClass="button btn-danger"></aui:button>
		</div>
	</div>
</div>
