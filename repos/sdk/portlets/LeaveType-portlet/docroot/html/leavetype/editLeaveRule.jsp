<%@ include file="/html/leavetype/init.jsp" %>
<%
ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

LeaveType leaveType = (LeaveType)rslt.getObject();
String leaveTypePK=String.valueOf(leaveType.getLeaveTypeId());
System.out.println("in edit.jsp, prk="+leaveTypePK);
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="addEditLeaveRule" name="editLeaveRule">
<portlet:param name="leaveTypeId" value="<%=leaveTypePK %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=addEditLeaveRule.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>