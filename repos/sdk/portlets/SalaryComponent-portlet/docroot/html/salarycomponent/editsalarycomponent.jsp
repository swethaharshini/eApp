<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.model.SalaryComponent"%>
<%@ include file="/html/salarycomponent/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Salary Component</title>
<portlet:actionURL var="savesalarycomponent" name="saveSalaryComponent">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/salarycomponent/list.jsp" />
</portlet:renderURL>
<aui:script>
AUI().ready('event', 'node','transition',function(A){
A.one('#<portlet:namespace/>componentname').focus();
  setTimeout(function(){
    A.one('#editsalarycomponentMessage').transition('fadeOut');
    A.one('#editsalarycomponentMessage').hide();
},2000)
 });

</aui:script>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"salarycomponentName-empty-error")){%>
<p id="editsalarycomponentMessage" class="alert alert-error"><liferay-ui:message key="Please Enter SalarycomponentName"/></p>
<%} 
 %>
<%
SalaryComponent salaryComponent = (SalaryComponent) portletSession.getAttribute("editsalarycomponent");
%>
<div class="panel">
	<div class="panel-heading">
		<h4>Edit</h4>
	</div>
	<div class="panel-body">
		<div class="form-horizontal clearfix">
			<aui:form  action="<%=savesalarycomponent.toString()%>">
			 <input name="<portlet:namespace/>salarycomponentId" type="hidden" id="salarycomponentId" value="<%=salaryComponent.getSalaryComponentId()%>">
			<aui:input name="componentName" id="componentname" showRequiredLabel="false" label="Component Name" inlineLabel="left" value="<%=salaryComponent.getComponentName()%>"><aui:validator name="required"></aui:validator> </aui:input>
			<div class="control-group">
				<label class="control-label">Type</label>
				<%
				if(salaryComponent.getType().equals("Earning")){
				%>
				<aui:input name="type" type="radio" checked="true" value="Earning" label="Earning" inlineField="true"></aui:input>
				<aui:input name="type" type="radio" value="Deduction" label="Deduction" inlineField="true"></aui:input>
				<%}
				else if(salaryComponent.getType().equals("Deduction")){
				%>
				<aui:input name="type" type="radio" value="Earning" label="Earning" inlineField="true"></aui:input>
				<aui:input name="type" type="radio" checked="true" value="Deduction" label="Deduction" inlineField="true"></aui:input>
				<%}
				
				%>
			</div>
			<div class="control-group">
				<label class="control-label">Add to</label>
				 <%
				if(salaryComponent.getTotalPayable().equals("Yes")){
				%>
				<aui:input name="totalPayable" type="checkbox" checked="true" label="Total Payable" inlineField="true"></aui:input>
				<%}
				else if(salaryComponent.getTotalPayable().equals("No")){
				%>
				<aui:input name="totalPayable" type="checkbox" label="Total Payable" inlineField="true"></aui:input>
				<%}
				else{
				%>
				<aui:input name="totalPayable" type="checkbox" label="Total Payable" inlineField="true"></aui:input>
				<%
				}
				 if(salaryComponent.getCostToCompany().equals("Yes")){
				%>
				<aui:input name="costToCompany" type="checkbox" checked="true"  label="Cost to Company" inlineField="true"></aui:input>
				<%}
				else if(salaryComponent.getCostToCompany().equals("No")){
				%>
				<aui:input name="costToCompany" type="checkbox" label="Cost to Company" inlineField="true"></aui:input>
				<%}
				else{
				%>
				<aui:input name="costToCompany" type="checkbox" label="Cost to Company" inlineField="true"></aui:input>
				<%
				}
				%>
			 </div>
			 <div class="control-group">
				<label class="control-label">valueType</label>
				  <%
				if(salaryComponent.getValueType().equals("Amount")){
				%>
				<aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Amount"></aui:input>
				<aui:input type="checkbox" name="valueType" inlineField="true" label="Percentage"></aui:input>
				<%}
				else if(salaryComponent.getValueType().equals("Percentage")){
				%>
				<aui:input type="checkbox"  name="valueType" inlineField="true" label="Amount"></aui:input>
				<aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Percentage"></aui:input>
				<%}
				else if(salaryComponent.getValueType().equals("Amount,Percentage")){
				%>
				<aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Amount"></aui:input>
				<aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Percentage"></aui:input>
				<%}
				else{
				%>
				<aui:input type="checkbox"  name="valueType" inlineField="true" label="Amount"></aui:input>
				<aui:input type="checkbox" name="valueType" inlineField="true" label="Percentage"></aui:input>
				<%}
				
				%>
			</div>
			<div class="controls">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
				<a class="btn btn-danger" href="<%=listview%>" id ="Cancel"><i class="icon-remove"></i> Cancel</a>
			</div>
			</aui:form>
		
		</div>
	</div>
</div>