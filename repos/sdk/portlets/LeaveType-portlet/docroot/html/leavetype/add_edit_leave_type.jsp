<%@page import="com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeaveType"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leavetype/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Holiday</title>
<portlet:actionURL var="saveLeaveType" name="saveLeaveType">
</portlet:actionURL>

<portlet:renderURL var="initialView">
 </portlet:renderURL>


 <style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editLeaveTypeForm').show();
                     
      }
    );
  }
);

<!-- 
AUI().ready('event', 'node', function(A){

  A.one('#editHolidayForm').show();
 
 });

 -->
</aui:script>
</head>

<body>

 <jsp:useBean id="editLeaveType" type="com.rknowsys.eapp.ui.LeaveType" scope="request" />
 
 <div id="editLeaveTypeForm">
 <aui:form name="myForm" action="<%=saveLeaveType.toString()%>">
		<aui:input name="leaveTypeId" type="hidden" value="<%=editLeaveType.getLeaveTypeId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Country *</label>
			</div>
			<div class="span3">		
		  		<aui:select type="select" name="nationalityId" label="" >
		    		<aui:option value="-1">--Select--</aui:option>
		          <%    
		           List<IdNamePair> idNameList = editLeaveType.getOrgCountries(); 
		    		String storedId=editLeaveType.getNationalityId();
		           for (IdNamePair idName:idNameList) { %>
		             <aui:option selected="<%=idName.getId().equals(storedId)%>"
		                        value="<%=idName.getId() %>">
		                 <%=idName.getName()%>
		             </aui:option>
		             <% } %>
		
		   		</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Name</label>
		</div>
		<div class="span3">
		
		 <aui:input name="leaveTypeName" type="text" label="" value="<%=editLeaveType.getLeaveTypeName() %>"/>
			</div>
		</div>


		<div class="span12">
			<div class="span2">
				<label>Is entitlement situational</label>
		</div>
		<div class="span3">
			 <aui:input name="isSituational" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveType.getIsSituational()) %>" />
		</div>
		</div>

		<div class="span12">
			<aui:button type="submit" id="save" value="save" />
		</div>

</aui:form>
</div>

 </body>

</html>