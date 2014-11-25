<%@ include file="/html/leavetype/init.jsp"%>
<%!	long nationalityId=0l;long leaveTypeId=0l;
		boolean isSituational=false;
		String leaveTypeName=""; %>
<%LeaveType editLeaveType=(LeaveType)request.getSession().getAttribute("editLeaveType"); 
		System.out.println("edit leave type list"+editLeaveType );
		if(editLeaveType!=null)
		{
			nationalityId=editLeaveType.getNationalityId()!=0?editLeaveType.getNationalityId():0;
			isSituational=editLeaveType.isIsSituational()!=false?editLeaveType.getIsSituational():true;
			leaveTypeName=editLeaveType.getLeaveTypeName()!=null?editLeaveType.getLeaveTypeName():"";
			leaveTypeId=editLeaveType.getLeaveTypeId()!=0?editLeaveType.getLeaveTypeId():0;
		}
		%>
		
<portlet:actionURL name="addOrUpdateLeaveType" var="saveLeaveType"></portlet:actionURL>
<div class="panel">
	<div class="panel-heading">
		<h3>Leave Type</h3>
	</div>
	<div class="panel-body">
		<aui:form name="myForm" action="<%=saveLeaveType.toString()%>">
			<aui:input name="leaveTypeId" type="hidden"
				value="<%=leaveTypeId %>" />

			<div class="span12">
				<div class="span2">
					<label>Country *</label>
				</div>
				<div class="span3">
					<aui:select type="select" name="nationalityId" label="">
						<aui:option value="0" selected="<%=nationalityId==0 %>">--Select--</aui:option>
						
						<%List<Nationality> nationalities = NationalityLocalServiceUtil
								.getNationalities(-1, -1);
						
							Iterator<Nationality> nationality = nationalities.iterator();
							while (nationality.hasNext()) {
								Nationality leaveTypeNationality = nationality.next(); %>
						<aui:option selected="<%=nationalityId==leaveTypeNationality.getNationalityId()%>"
							value="<%=leaveTypeNationality.getNationalityId() %>">
							<%=leaveTypeNationality.getName() %>
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

					<aui:input name="leaveTypeName" type="text" label=""
						value="<%=leaveTypeName %>" />
				</div>
			</div>


			<div class="span12">
				<div class="span2">
					<label>Is entitlement situational</label>
				</div>
				<div class="span3">
					<aui:input name="isSituational" type="checkbox" label=""
						checked="<%=isSituational %>" />
				</div>
			</div>

			<div class="span12">
				<aui:button type="submit" id="save" value="save" />
			</div>

		</aui:form>
	</div>
</div>