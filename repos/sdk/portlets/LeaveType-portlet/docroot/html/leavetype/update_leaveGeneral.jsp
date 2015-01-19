<%@page import="com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"%>
<%@ include file="/html/leavetype/init.jsp"%>
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
<%
	Map leaveInfo = (Map) request.getSession()
			.getAttribute("leaveInfo");
	System.out.println("edit leave info is" + leaveInfo);

	String activeJsp = (String) leaveInfo.get("jsp");
	LeaveType editLeaveType = (LeaveType) leaveInfo
			.get("editLeaveType");
	LeaveGeneral leaveGeneral = (LeaveGeneral) leaveInfo
			.get("editLeaveGeneral");
	LeaveRuleApplicable leaveRuleApplicable = (LeaveRuleApplicable) leaveInfo
			.get("leaveRuleApplicable");
	LeaveRestriction leaveRestriction = (LeaveRestriction) leaveInfo
			.get("editLeaveRestriction");
	System.out.println("LeaveType = " + editLeaveType);
	System.out.println("leaveGeneral = " + leaveGeneral);
	System.out.println("leaveRuleApplicable = " + leaveRuleApplicable);
%>
<div id="leaveGeneralDetails">
	<ul class="span3 side-nav" id="test">
		<div id="leaveTypeName">
				<h3><%=editLeaveType.getLeaveTypeName()%></h3>
		</div>
		<c:choose>
			<c:when test='<%=activeJsp.equals("generalJsp")%>'>
				<li class="active"><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>
			<c:when test='<%=activeJsp.equals("leaveruleapplicabilityJsp")%>'>
				<li><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li class="active"><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>
			<c:when test='<%=activeJsp.equals("restrictionsJsp")%>'>
				<li><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li class="active"><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>
			<c:when test='<%=activeJsp.equals("restrictgroupsJsp")%>'>
				<li><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li class="active"><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>
			<c:when test='<%=activeJsp.equals("accrualrulesJsp")%>'>
				<li><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li class="active"><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>
			<c:when test='<%=activeJsp.equals("carryforwardJsp")%>'>
				<li><a href="#general"><i class="icon-th-large"></i><liferay-ui:message
							key="General"></liferay-ui:message></a></li>
				<li><a href="#whoCanApply"><i class="icon-user"></i><liferay-ui:message
							key="Who Can Apply"></liferay-ui:message></a></li>
				<li><a href="#applyRestrictions"><i class="icon-time"></i><liferay-ui:message
							key="Apply/Assign Leave Restrictions"></liferay-ui:message></a></li>
				<li><a href="#restrictToGroups"><i class="icon-group"></i><liferay-ui:message
							key="Employee Groups"></liferay-ui:message></a></li>
				<li><a href="#accrualRules"><i class="icon-info-sign"></i><liferay-ui:message
							key="Accrual Rules"></liferay-ui:message></a></li>
				<li class="active"><a href="#carryForwardRules"><i class="icon-forward"></i><liferay-ui:message
							key="Carry Forward Rules"></liferay-ui:message></a></li>
			</c:when>

		</c:choose>
	</ul>
	<div class="tab-content">
		<div id="general" class="tab-pane">
			<jsp:include page="/html/leavetype/leave_general.jsp" />
		</div>
		<div id="whoCanApply" class="tab-pane">
			<%
				if (leaveRuleApplicable == null) {
					System.out.println("leaveRuleApplicable is null");
			%>
			<jsp:include page="/html/leavetype/leave_applicability.jsp" />
			<%
				} else {
					System.out.println("leaveRuleApplicable is not null");
			%>
			<jsp:include page="/html/leavetype/editleave_applicability.jsp" />
			<%
				}
			%>
		</div>
		<div id="applyRestrictions" class="tab-pane">
			<%
				if (leaveRestriction == null) {
					System.out.println("leaveRestriction is null");
			%>
			<jsp:include page="/html/leavetype/leave_restrictions.jsp" />
			<%
				} else {
			%>
			<jsp:include page="/html/leavetype/editleave_restrictions.jsp" />
			<%
				}
			%>
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
