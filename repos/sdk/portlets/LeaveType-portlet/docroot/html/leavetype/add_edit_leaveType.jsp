<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL name="addOrUpdateLeaveType" var="saveLeaveType"></portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="mvcPath" value="/html/leavetype/list_leaveType.jsp"/>
</portlet:renderURL>
<aui:script>
 AUI().ready('event', 'node','transition',function(A){
 A.one('#<portlet:namespace/>leaveTypeName').focus();
setTimeout(function(){
A.one('#addLeaveTypeMessage').transition('fadeOut');
A.one('#addLeaveTypeMessage').hide();
},2000)
});
</aui:script>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"leaveTypeName-empty-error")){%>
<p id="addLeaveTypeMessage" class="alert alert-error"><liferay-ui:message key="Please Enter LeaveTypeName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"leaveTypeName-duplicate-error")){
%>
<p id="addLeaveTypeMessage" class="alert alert-error"><liferay-ui:message key="LeaveTypeName already Exits"/></p>
<%} 
%>
<div class="form-horizontal clearfix">
	<aui:form name="myForm" action="<%=saveLeaveType.toString()%>">
	<aui:select type="select" name="nationalityId" label="Country *">
	<aui:option value="0" selected="true">--Select--</aui:option>
	
	<%List<Nationality> nationalities = NationalityLocalServiceUtil
		.getNationalities(-1, -1);
	
	Iterator<Nationality> nationality = nationalities.iterator();
	while (nationality.hasNext()) {
		Nationality leaveTypeNationality = nationality.next(); %>
	<aui:option 
		value="<%=leaveTypeNationality.getNationalityId() %>">
	<%=leaveTypeNationality.getName() %>
	</aui:option>
	<% } %>
	
	</aui:select>
	
	<aui:input name="leaveTypeName" type="text" label="Name" id="leaveTypeName"
		/>
	<div class="control-group">
		<div class="controls">
			<label class="checkbox">
				<input name="isSituational" type="checkbox" />
				Is entitlement situational
			</label>
			<aui:button type="submit" id="save" value="save" />
			<aui:button value="cancel" type="button" href="<%=cancel.toString()%>"></aui:button>
		</div>
	</div>
	</aui:form>
</div>