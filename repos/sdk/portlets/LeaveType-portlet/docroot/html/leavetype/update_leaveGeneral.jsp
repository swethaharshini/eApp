<%@ include file="/html/leavetype/init.jsp" %>
<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    var tabView=new Y.TabView(
      {
        srcNode: '#leaveGeneralDetails',
        stacked:true
      }
    ).render();
    tabView.after ('tab:selectedChange', function (e) {
   <!-- add the functions that need to be executed on tab change -->
    });
  }
);
</aui:script>
<%Map leaveInfo=(Map)request.getSession().getAttribute("leaveGeneralForLeaveType"); 
		System.out.println("edit leave info is"+leaveInfo ); 
		LeaveType editLeaveType=(LeaveType)leaveInfo.get("editLeaveType");%>
<div id="leaveGeneralDetails">
<ul class="span3" id="test">
		<div id="leaveTypeName" class="panel">
			<div class="panel-heading">
				<h3><%=editLeaveType.getLeaveTypeName()%></h3>
			</div>
		</div>
	<%-- <c:choose>
		<c:when test='<%= jsp.equals("jsp0") || jsp.equals("jsp1") %>'> --%> 
		<li class="active" ><a href="#general" ><liferay-ui:message key="General"></liferay-ui:message></a></li>
		<li><a href="#whoCanApply" ><liferay-ui:message key="Who Can Apply"></liferay-ui:message></a></li>
		<li><a href="#applyRestrictions" ><liferay-ui:message key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
		<li><a href="#restrictToGroups"><liferay-ui:message key="Employee Groups"></liferay-ui:message></a></li>
		<li><a href="#accrualRules"><liferay-ui:message key="Accrual Rules"></liferay-ui:message></a></li>
		<li><a href="#carryForwardRules"><liferay-ui:message key="Carry Forward Rules"></liferay-ui:message></a></li>

		</ul>
	<div class="tab-content">
		<div id="general" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_general.jsp" />
		</div>
		<div id="whoCanApply" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_applicability.jsp" />
		</div>
		<div id="applyRestrictions" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_restrictions.jsp" />
		</div>
		<div id="restrictToGroups" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_restrictTo_groups.jsp" />
		</div>
		<div id="accrualRules" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_accrual_rules.jsp" />
		</div>
		<div id="carryForwardRules" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_carryForward_rules.jsp" />
		</div>
	</div>
</div>
		