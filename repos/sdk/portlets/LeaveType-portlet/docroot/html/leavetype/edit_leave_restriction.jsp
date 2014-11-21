<%@page import="com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeaveRestriction"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leavetype/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Restrictions</title>
<portlet:actionURL var="saveLeaveRestriction" name="saveLeaveRestriction">
</portlet:actionURL>

<%-- 
<portlet:renderURL var="initialView">
 </portlet:renderURL>

 --%>
 
<%-- 
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editLeaveRuleForm').show();
                     
      }
    );
  }
);

</aui:script>
 --%>
 </head>

<body>

 <jsp:useBean id="editLeaveRestriction" type="com.rknowsys.eapp.ui.LeaveRestriction" scope="request" />
 
 	<div id="editLeaveRestrictionForm">
 		<aui:form name="myForm" action="<%=saveLeaveRestriction.toString()%>">
			<aui:input name="leaveRestrictionId" type="hidden" value="<%=editLeaveRestriction.getLeaveRestrictionId() %>"/>

			<div class="span12">
				<div class="span2">
					<aui:input name="cannotExceedBalance" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getCannotExceedBalance()) %>" />
				</div>
				<div class="span9">
					<label>Don't allow more than current leave net balance. Net Balance = [Entitlement + BF] - [Taken + Scheduled + CF + PendingApproval]</label>
				</div>
			</div>

			<div class="span12">
				<div class="span2">
					<aui:input name="ifATermsQuestion" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getIfATermsQuestion()) %>" />
				</div>
				<div class="span9">
					 <label>Don't allow partial day leave.</label>
				</div>
			</div>
	
			<div class="span12">
				<div class="span2">
					<aui:input name="cannotApplyForPartialDay" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getCannotApplyForPartialDay()) %>" />
				</div>
				<div class="span9">
					 <label>Don't allow if employee answer NO to below question. Show the error message that comes afterwards</label>
				</div>
			</div>
			<div class="span12">
				<div class="span2">
					<label>Question</label>
				</div>
				<div class="span9">
			 		<aui:input name="termsQuestion" type="text" label="" value="<%=editLeaveRestriction.getTermsQuestion() %>"/>
				</div>
			</div>
	
			<div class="span12">
				<div class="span2">
					<label>Error Message</label>
				</div>
				<div class="span9">
			 		<aui:input name="errorTextIfTermsDeclined" type="text" label="" value="<%=editLeaveRestriction.getErrorTextIfTermsDeclined() %>"/>
				</div>
			</div>
			<div class="span12">
				<div class="span1">
					<aui:input name="isMinimumServicePeriodApplicable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getIsMinimumServicePeriodApplicable()) %>" />
				</div>
				<div class="span5">
					<label>Don't allow if Service Period less than</label>
				</div>
				<div class="span3">
			 		<aui:input name="minimumServicePeriod" type="text" label="" value="<%=editLeaveRestriction.getMinimumServicePeriod() %>"/>
				</div>
				<div class="span2">
					<label>months</label>
				</div>
			</div>
	
			<div class="span12">
				<div class="span1">
					<aui:input name="isMaxConsecutiveLeavesApplicable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getIsMaxConsecutiveLeavesApplicable()) %>" />
				</div>
				<div class="span5">
					<label>Don't allow if number of consecutive leave days exceed</label>
				</div>
				<div class="span3">
			 		<aui:input name="maxConsecutiveLeaves" type="text" label="" value="<%=editLeaveRestriction.getMaxConsecutiveLeaves() %>"/>
				</div>
				<div class="span2">
					<label>&nbsp;</label>
				</div>
			</div>
	
			<div class="span12">
				<div class="span1">
					<aui:input name="isSmallChildCriterionApplicable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRestriction.getIsSmallChildCriterionApplicable()) %>" />
				</div>
				<div class="span5">
					<label>Don't allow if no child found aged less than</label>
				</div>
				<div class="span3">
			 		<aui:input name="maxSmallChildAgeApplicable" type="text" label="" value="<%=editLeaveRestriction.getMaxSmallChildAgeApplicable() %>"/>
				</div>
				<div class="span2">
					<label>months</label>
				</div>
			</div>

		<div class="span12">
			<aui:button type="submit" id="save" value="Save" />
		</div>

</aui:form>
</div>

 </body>

</html>