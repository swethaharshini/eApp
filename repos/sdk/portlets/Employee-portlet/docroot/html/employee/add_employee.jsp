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
			<div class="container-fluid">
				<aui:input name="employeeId" type="hidden" />
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="firstName" type="text" showRequiredLabel="false"
							inlineLabel="left" label="01_firstName">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="middleName" type="text" label="01_middleName">
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="lastName" type="text" showRequiredLabel="false"
							inlineLabel="left" label="01_lastName">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="employee_no" label="01_emp-no"
							inlineLabel="left">
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input id="emp_photograph" name="emp_photograph" label="01_image" type="file"
							inlineLabel="left">
							<aui:validator name="acceptFiles">'jpeg,jpg,png,git,img'</aui:validator>
							</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span1">
						<aui:input name="createLoginDetails" id="createLoginDetails"
							label="" type="checkbox" 
							/>
					</div>
					<div class="span1"></div>
					<div class="span10">
						<label><b><liferay-ui:message key="01_create-emp-login-details"/></b></label>
					</div>
				</div>
				<div id="createLoginDetailsDiv">
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="user_name" label="01_assigned-user-name"></aui:input>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="password" label="01_password" type="password"></aui:input>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="confirm_password" label="01_confirm-password"
							 type="password">
							 <aui:validator name="equalTo">'#<portlet:namespace />password'</aui:validator>
							 </aui:input>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
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
					</div>
				</div>
				<aui:button type="submit" value="Submit"
					cssClass="button btn-primary" id="submitEmployee" />
				<aui:button type="reset" value="Cancel" id="cancel"
					cssClass="button btn-danger" />
			</div>
		</aui:form>
	</div>
</div>

