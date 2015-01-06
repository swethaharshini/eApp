<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="saveEmpDetails" var="saveEmpDetails"></portlet:actionURL>
<aui:script use="aui-base,aui-node">
var A=new AUI();
A.ready(function()
{
 A.one("#createLoginDetailsDiv").hide();
});
	  var checkbox_obj= A.one('input[name=<portlet:namespace/>createLoginDetailsCheckbox]')
	  checkbox_obj.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>createLoginDetailsCheckbox]:checked'))
	   {
	  A.one("#createLoginDetailsDiv").show();
	  }
	  else
	  {
	   A.one("#createLoginDetailsDiv").hide();
	  }
	  });
</aui:script>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-emp"></liferay-ui:message></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmployeeForm" id="addEmployeeForm"
			action="<%=saveEmpDetails%>" method="post" enctype="multipart/form-data">
			<div class="form-horizontal add-employee">
				<aui:input name="employeeId" type="hidden" />
				<aui:input name="firstName" type="text" showRequiredLabel="false" label="01_firstName">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="middleName" type="text" label="01_middleName">
				</aui:input>
				<aui:input name="lastName" type="text" showRequiredLabel="false" label="01_lastName">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="employee_no" label="01_emp-no"></aui:input>
				<aui:input id="emp_photograph" name="emp_photograph" label="01_image" type="file"></aui:input>
				<div class="login-details">
				<aui:input name="createLoginDetails" id="createLoginDetails" label="" type="checkbox" />
				<label><b><liferay-ui:message key="01_create-emp-login-details"/></b></label>
				</div>
				<div id="createLoginDetailsDiv">
					<aui:input name="user_name" label="01_assigned-user-name"></aui:input>
					<aui:input name="password" label="01_password" type="password"></aui:input>
					<aui:input name="confirm_password" label="01_confirm-password"
					 type="password">
					  <aui:validator name="equalTo">'#<portlet:namespace />password'</aui:validator></aui:input>
				</div>
				<aui:select name="location" label="01_location" inlineLabel="left">
				<aui:option value="-1">--Select--</aui:option>
					<%
						List l = LocationLocalServiceUtil.getLocations(-1, -1);
								Iterator locations = l.iterator();
								while (locations.hasNext()) {
									Location locations2 = (Location) locations.next();
					%>
					<aui:option value="<%=locations2.getLocationId()%>"><%=locations2.getName()%></aui:option>
					<%
						}
					%>
				</aui:select>
				 <div class="control-group">
					<div class="controls">
						<aui:button type="submit" value="Submit"
							cssClass="button btn-primary" id="submitEmployee" />
						<aui:button type="reset" value="Cancel" id="cancel"
							cssClass="button btn-danger" />
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>

