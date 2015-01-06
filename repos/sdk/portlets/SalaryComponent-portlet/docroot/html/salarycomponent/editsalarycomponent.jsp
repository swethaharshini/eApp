<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.model.SalaryComponent"%>
<%@ include file="/html/salarycomponent/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Salary Component</title>
<portlet:actionURL var="savesalarycomponent" name="saveSalaryComponent">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/salarycomponent/list.jsp" />
</portlet:renderURL>
<style type="text/css">
#editsalarycomponentMessage,em {
	color: red;
}
</style>
<aui:script>
AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#editsalarycomponentMessage').transition('fadeOut');
},1000)
 });

</aui:script>
</head>
<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"salarycomponentName-empty-error")){%>
<p id="editsalarycomponentMessage"><liferay-ui:message key="Please Enter SalarycomponentName"/></p>
<%} 
 %>
<%
SalaryComponent salaryComponent = (SalaryComponent) portletSession.getAttribute("editsalarycomponent");
%>


<aui:form  action="<%=savesalarycomponent.toString()%>">
<div class="row-fluid">
 <input name="<portlet:namespace/>salarycomponentId" type="hidden" id="salarycomponentId" value="<%=salaryComponent.getSalaryComponentId()%>">
<aui:input name="componentName" id="componentname" showRequiredLabel="false" label="Component Name" inlineLabel="left" value="<%=salaryComponent.getComponentName()%>"><aui:validator name="required"></aui:validator> </aui:input>
</div>

<div class="row-fluid">
<div class="span2"><label>Type</label></div>


  <%
  if(salaryComponent.getType().equals("Earning")){
%>
<div class="span2">  <aui:input name="type" type="radio" checked="true" value="Earning" label="Earning" inlineField="true"></aui:input></div>

<div class="span2"> <aui:input name="type" type="radio" value="Deduction" label="Deduction" inlineField="true"></aui:input></div>
 <%}
   else if(salaryComponent.getType().equals("Deduction")){
%>
<div class="span2">  <aui:input name="type" type="radio" value="Earning" label="Earning" inlineField="true"></aui:input></div>

<div class="span2"> <aui:input name="type" type="radio" checked="true" value="Deduction" label="Deduction" inlineField="true"></aui:input></div>
<%}
  
%>
<div class="span6"></div>

</div>
<br/>
<div class="row-fluid">
 <div class="span2"><label>Add to</label></div>
 <%
  if(salaryComponent.getTotalPayable().equals("Yes")){
 %>
 <div class="span2"> <aui:input name="totalPayable" type="checkbox" checked="true" label="Total Payable" inlineField="true"></aui:input></div>
 <%}
  else if(salaryComponent.getTotalPayable().equals("No")){
%>
 <div class="span2"> <aui:input name="totalPayable" type="checkbox" label="Total Payable" inlineField="true"></aui:input></div>
 <%}
  else{
 %>
 <div class="span2"> <aui:input name="totalPayable" type="checkbox" label="Total Payable" inlineField="true"></aui:input></div>
 <%
  }
   if(salaryComponent.getCostToCompany().equals("Yes")){
  %>
 <div class="span2"><aui:input name="costToCompany" type="checkbox" checked="true"  label="Cost to Company" inlineField="true"></aui:input></div>
 <%}
   else if(salaryComponent.getCostToCompany().equals("No")){
 %>
   <div class="span2"><aui:input name="costToCompany" type="checkbox" label="Cost to Company" inlineField="true"></aui:input></div>
  <%}
   else{
 %>
 <div class="span2"><aui:input name="costToCompany" type="checkbox" label="Cost to Company" inlineField="true"></aui:input></div>
  <%
  }
 %>
 <div class="span6"></div>
</div>
<br/>
<div class="row-fluid">
  <div class="span2"><label>valueType</label></div>
  <%
   if(salaryComponent.getValueType().equals("Amount")){
  %>
 <div class="span2"><aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Amount"></aui:input></div>
 <div class="span2"> <aui:input type="checkbox" name="valueType" inlineField="true" label="Percentage"></aui:input></div>
 <%}
   else if(salaryComponent.getValueType().equals("Percentage")){
 %>
 <div class="span2"><aui:input type="checkbox"  name="valueType" inlineField="true" label="Amount"></aui:input></div>
 <div class="span2"> <aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Percentage"></aui:input></div>
 <%}
   else if(salaryComponent.getValueType().equals("Amount,Percentage")){
 %>
 <div class="span2"><aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Amount"></aui:input></div>
 <div class="span2"> <aui:input type="checkbox" checked="true" name="valueType" inlineField="true" label="Percentage"></aui:input></div>
 <%}
   else{
 %>
 <div class="span2"><aui:input type="checkbox"  name="valueType" inlineField="true" label="Amount"></aui:input></div>
 <div class="span2"> <aui:input type="checkbox" name="valueType" inlineField="true" label="Percentage"></aui:input></div>
  <%}
   
 %>
 <div class="span6"></div>
</div>
<br/>
<aui:button type="submit" value="Submit"/> <aui:button type="reset" href="<%=listview%>" value="Cancel"/>

</aui:form>




</body>
</html>