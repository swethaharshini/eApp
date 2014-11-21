<%@page import="com.rknowsys.eapp.hrm.service.LeaveTypeApplicabilityLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeaveTypeApplicability"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leavetype/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carry Forward Rules</title>
<portlet:actionURL var="saveLeaveTypeApplicability" name="saveLeaveTypeApplicability">
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

 <jsp:useBean id="editLeaveTypeApplicability" type="com.rknowsys.eapp.ui.LeaveTypeApplicability" scope="request" />
 
 <div id="editLeaveTypeApplicabilityForm">
 <aui:form name="myForm" action="<%=saveLeaveTypeApplicability.toString()%>">
		<aui:input name="leaveTypeApplicabilityId" type="hidden" value="<%=editLeaveTypeApplicability.getLeaveTypeApplicabilityId() %>"/>




          <%
           List<IdNamePair> idNameList = editLeaveTypeApplicability.getJobTitles();
           List<IdNamePair> idApplicabilityList = editLeaveTypeApplicability.getApplicableToJobTitles();
           int i = 0;
           for (IdNamePair idName:idNameList) { %>
				<div class="span12">
					<div class="span2">
						<label><%=idName.getName() %></label>
					</div>
					<div class="span5">
						<aui:input name="jobTitleId" type="checkbox" label="" value="<%=idName.getId() %>" checked="<%=\"true\".equalsIgnoreCase(idApplicabilityList.get(i).getName() ) %>" />
					</div>
				</div>
             <% i++;
             } 
             %>
<hr />		

          <%
           idNameList = editLeaveTypeApplicability.getEmploymentStatuses();
           idApplicabilityList = editLeaveTypeApplicability.getApplicableToEmploymentStatuses();
           int j = 0;
           for (IdNamePair idName:idNameList) { %>
				<div class="span12">
					<div class="span2">
						<label><%=idName.getName() %></label>
					</div>
					<div class="span5">
						<aui:input name="employmentStatusId" type="checkbox" label="" value="<%=idName.getId() %>" checked="<%=\"true\".equalsIgnoreCase(idApplicabilityList.get(j).getName() ) %>" />
					</div>
				</div>
             <% j++;
             } 
             %>



<hr />

				<div class="span12">
					<div class="span2">
						<aui:input name="ifYearsOfServiceCriterionApplicable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveTypeApplicability.getIfYearsOfServiceCriterionApplicable()) %>" />
					</div>
					<div class="span5">
						<label>And Service</label>
					</div>
				</div>
				<div class="span12">
						<label>Only employees with joined dates and corresponding years of service will be allowed to apply for this leave type</label>
				</div>
 
				<div class="span12">
					<div class="span3">
						<label>From</label>
					</div>
					<div class="span5">
						<aui:input name="minYearsOfService" type="text" label="" value="<%=editLeaveTypeApplicability.getMinYearsOfService() %>"/>
					</div>
					<div class="span2">
						<label>(Years)</label>
					</div>
				</div>
 
				<div class="span12">
					<div class="span3">
						<label>To Less Than</label>
					</div>
					<div class="span5">
						<aui:input name="maxYearsOfService" type="text" label="" value="<%=editLeaveTypeApplicability.getMaxYearsOfService() %>"/>
					</div>
					<div class="span2">
						<label>(Years)</label>
					</div>
				</div>
				

		<div class="span12">
			<aui:button type="submit" id="save" value="Save" />
		</div>

</aui:form>
</div>

 </body>

</html>