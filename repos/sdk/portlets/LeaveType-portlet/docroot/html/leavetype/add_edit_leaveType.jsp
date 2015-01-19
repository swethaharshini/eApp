<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL name="addOrUpdateLeaveType" var="saveLeaveType"></portlet:actionURL>
<portlet:renderURL var="cancel">
<portlet:param name="mvcPath" value="/html/leavetype/list_leaveType.jsp"/>
</portlet:renderURL>
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
	
	<aui:input name="leaveTypeName" type="text" label="Name"
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