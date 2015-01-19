<%@page import="com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeavePeriod"%>
<%@page import="com.rknowsys.eapp.hrm.model.Employee"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leaveperiod/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Period</title>
<portlet:actionURL var="saveLeavePeriod" name="saveLeavePeriod">
</portlet:actionURL>

<%-- 
<portlet:resourceURL var="deleteemergencycontact" id="deleteEmergencyContact"/>
 --%>
 
<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/contactdetails/edit_contact_details.jsp" /> --%>
 </portlet:renderURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editLeavePeriodReadOnly').hide();
         A.one('#editLeavePeriodForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editLeavePeriodForm').hide();
 
 });

</aui:script>
</head>

<body>

 <jsp:useBean id="editLeavePeriod" type="com.rknowsys.eapp.ui.LeavePeriod" scope="request" />
 
 <div id="editLeavePeriodReadOnly" class="form-horizontal clearfix">
		<aui:input name="leavePeriodId" type="hidden" value="<%=editLeavePeriod.getLeavePeriodId() %>"/>
		<aui:select type="select" name="startMonth" label="Start Month" disabled="true" >
		<aui:option value="-1">--Select--</aui:option>
		<% 			
		      	List<IdNamePair> idNameList = editLeavePeriod.getMonths();
		String storedId=String.valueOf(editLeavePeriod.getStartMonth());
		      	for (IdNamePair idName:idNameList) { %>
		<aui:option selected="<%=idName.getId().equals(storedId)%>"
		value="<%=idName.getId() %>">
		<%=idName.getName()%>
		</aui:option>
		<% } %>
		</aui:select>
		<%--  <aui:input name="startMonth" type="text" label="" disabled="true" value="<%=editLeavePeriod.getStartMonth() %>"/> --%>
		<aui:input name="startDate" type="text" label="Start Date" disabled="true" value="<%=editLeavePeriod.getStartDate() %>"/>
		<aui:input name="endDate" type="text" label="End Date" disabled="true" value="<%=editLeavePeriod.getEndDate() %>"/>
		<aui:input name="currentLeavePeriod" type="text" label="Current Leave Period" disabled="true" value="<%=editLeavePeriod.getCurrentLeavePeriod()%>"/>
		<div class="control-group">
			<div class="controls">
				<aui:button type="button" id="edit" value="Edit" />
			</div>
		</div>
</div>



<div id="editLeavePeriodForm" class="form-horizontal clearfix">
	<aui:form name="myForm" action="<%=saveLeavePeriod.toString()%>">
	<aui:input name="leavePeriodId" type="hidden" value="<%=editLeavePeriod.getLeavePeriodId() %>"/>
	<aui:select type="select" name="startMonth" label="Start Month" >
	<aui:option value="-1">--Select--</aui:option>
	<% 			
	      	List<IdNamePair> idNameList = editLeavePeriod.getMonths();
	String storedId=String.valueOf(editLeavePeriod.getStartMonth());
	      	for (IdNamePair idName:idNameList) { %>
	<aui:option selected="<%=idName.getId().equals(storedId)%>"
	          value="<%=idName.getId() %>">
	  	<%=idName.getName()%>
	</aui:option>
	<% } %>
	</aui:select>
	<%--  <aui:input name="startMonth" type="text" label="" disabled="true" value="<%=editLeavePeriod.getStartMonth() %>"/> --%>
	<aui:input name="startDate" type="text" label="Start Date" value="<%=editLeavePeriod.getStartDate() %>"/>
	<aui:input name="endDate" type="text" label="End Date" disabled="true" value="<%=editLeavePeriod.getEndDate() %>"/>
	<aui:input name="currentLeavePeriod" type="text" label="Current Leave Period" disabled="true" value="<%=editLeavePeriod.getCurrentLeavePeriod()%>"/>	
	<div class="control-group">
		<div class="controls">
		<aui:button type="submit" id="save" value="Submit" />
		</div>
	</div>
	<%-- <aui:button  type="reset" value="Cancel" id ="cancel"/> --%>
	</aui:form>
</div>

</body>

</html>