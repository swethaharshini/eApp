<%-- <%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="saveEmpDetails" var="saveEmpDetails"></portlet:actionURL>
<portlet:renderURL var="backUrl">
<portlet:param name="mvcPath" value="/html/employee/employeelist.jsp"/>
</portlet:renderURL>
<aui:script use="aui-base,aui-nodeuse,aui-form-validator, aui-overlay-context-panel">
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
	 var validator1 = new A.FormValidator({
	 boundingBox: document.<portlet:namespace />addEmployeeForm,
	   rules: {
	         <portlet:namespace />location: {
	          required: true
	          }},
	   fieldStrings: {
	         <portlet:namespace />location: {
	         required: 'Please select employee location'
	          }}
	 });
	 var addCancel=A.one("#<portlet:namespace/>cancelAdd");
	 addCancel.on('click',function()
	 { 
	   window.location="<%= backUrl%>";
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
				<aui:select name="location" id="location" label="01_location" inlineLabel="left">
				<aui:option value="">--Select--</aui:option>
					<%
						List listRegions = RegionServiceUtil.getRegions();
								Iterator regions = listRegions.iterator();
								while (regions.hasNext()) {
									Region region = (Region) regions.next();
					%>
					<aui:option value="<%=region.getRegionId()%>"><%=region.getName()%></aui:option>
					<%
						}
					%>
				</aui:select>
				 <div class="control-group">
					<div class="controls">
						<aui:button type="submit" value="Submit"
							cssClass="button btn-primary" id="submitEmployee" />
						<aui:button type="reset" value="Cancel" id="cancelAdd" name="cancelAdd"
							cssClass="button btn-danger" />
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>

 --%>