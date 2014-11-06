<%@page import="com.rknowsys.eapp.hrm.service.LeaveRuleLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeaveRule"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leavetype/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Rule</title>
<portlet:actionURL var="saveLeaveRule" name="saveLeaveRule">
</portlet:actionURL>

<portlet:renderURL var="initialView">
 </portlet:renderURL>
 
 <portlet:resourceURL var="resourceURL" id="resourceURL"/>


 <style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>

<aui:script>
AUI().ready('event', 'node', function(A){

var selectedValue = A.one('#<portlet:namespace/>leavePeriodTypeId').get('value');
   // alert("selectedValue = " + selectedValue);
    switch (selectedValue) { 
                        
          case '0': //Statements executed when the result of expression matches value1 [break;]
                       //alert("case 0"); 
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').hide();
                       break;
                     
          case '1': //Statements executed the result of expression matches value2 [break;]
                       //alert("case 1");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').show();
                       A.one('#customLeavePeriodDiv').hide();
		  			   break;                  
		           
          case '2': //Statements executed when the result of expression matches valueN [break;]
                       //alert("case 2");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').show();
                       break;
                       
          default: //Statements executed when none of the values match the value of the expression [break;] }					    
	                    //alert("case default");
	                    A.one('#defaultDiv').show();
                        A.one('#durationDiv').hide();
                        A.one('#customLeavePeriodDiv').hide();
                        break;
                       
	}
  //alert("On ready done!");
 });

AUI().use(
  'aui-node',
  function(A) {
    var node =A.one('#<portlet:namespace/>leavePeriodTypeId');
    node.on(
      'change',
      function() {
         //alert("In on change!");
                         var selectedValue = A.one('#<portlet:namespace/>leavePeriodTypeId').get('value');
    //alert("selectedValue = " + selectedValue);
    switch (selectedValue) { 
                        
          case '0': //Statements executed when the result of expression matches value1 [break;]
                       //alert("case 0"); 
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').hide();
                       break;
                     
          case '1': //Statements executed the result of expression matches value2 [break;]
                       //alert("case 1");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').show();
                       A.one('#customLeavePeriodDiv').hide();
		  			   break;                  
		           
          case '2': //Statements executed when the result of expression matches valueN [break;]
                       //alert("case 2");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').show();
                       break;
                       
          default: //Statements executed when none of the values match the value of the expression [break;] }					    
	                    //alert("case default");
	                    A.one('#defaultDiv').show();
                        A.one('#durationDiv').hide();
                        A.one('#customLeavePeriodDiv').hide();
                        break;
                       
	}
                     
      }
    );
  }
);

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
</head>

<body>

 <jsp:useBean id="editLeaveRule" type="com.rknowsys.eapp.ui.LeaveRule" scope="request" />
 
 <div id="editLeaveRuleForm">
 <aui:form name="myForm" action="<%=saveLeaveRule.toString()%>">
		<aui:input name="leaveRuleId" type="hidden" value="<%=editLeaveRule.getLeaveRuleId() %>"/>


		<div class="span12">
			<div class="span4">
				<label>Leave Period *</label>
			</div>
			<div class="span8">		
		  		<aui:select type="select" name="leavePeriodTypeId" label="" >
		          <%    
		           List<IdNamePair> idNameList = editLeaveRule.getLeavePeriodTypeOptions(); 
		    		String storedId=editLeaveRule.getLeavePeriodType();
		           for (IdNamePair idName:idNameList) { %>
		             <aui:option selected="<%=idName.getId().equals(storedId)%>"
		                        value="<%=idName.getId() %>">
		                 <%=idName.getName()%>
		             </aui:option>
		             <% } %>
		
		   		</aui:select>
			</div>
		</div>

<div id="customLeavePeriodDiv">
		<div class="span12">
			<div class="span4">
				<label>Start Month *</label>
			</div>
			<div class="span8">		
		  		<aui:select type="select" name="startMonth" label="" >
		    		<aui:option value="-1">--Select--</aui:option>
		          <%    
		           List<IdNamePair> idNameList = editLeaveRule.getStartMonthOptions(); 
		    		String storedId=editLeaveRule.getStartMonth();
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
			<div class="span4">
				<label>Start Date *</label>
		</div>
		<div class="span8">
		
		 <aui:input name="startDayOfMonth" type="text" label="" value="<%=editLeaveRule.getStartDayOfMonth() %>"/>
			</div>
		</div>
</div>

<div id="durationDiv">
		<div class="span12">
			<div class="span4">
				<label>Duration *</label>
			</div>
			<div class="span8">		
		  		<aui:select type="select" name="duration" label="" >
		    		<aui:option value="-1">--Select--</aui:option>
		          <%    
		           List<IdNamePair> idNameList = editLeaveRule.getDurationOptions(); 
		    		String storedId=editLeaveRule.getDuration();
		           for (IdNamePair idName:idNameList) { %>
		             <aui:option selected="<%=idName.getId().equals(storedId)%>"
		                        value="<%=idName.getId() %>">
		                 <%=idName.getName()%>
		             </aui:option>
		             <% } %>
		
		   		</aui:select>
			</div>
		</div>
</div>
<div id="defaultDiv">
		<div class="span12">
			<div class="span4">
				<label>Employees can apply for this leave type</label>
			</div>
			<div class="span8">
				 <aui:input name="ifEmployeesCanApply" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRule.getIfEmployeesCanApply()) %>" />
			</div>
		</div>

		<div class="span12">
			<div class="span4">
				<label>Admin or supervisor can assign leave to employees</label>
			</div>
			<div class="span8">
				 <aui:input name="ifAdminCanAssign" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRule.getIfAdminCanAssign()) %>" />
			</div>
		</div>

		<div class="span12">
			<div class="span4">
				<label>Admin can add and adjust leave entitlements</label>
			</div>
			<div class="span8">
				 <aui:input name="ifAdminCanManageEntitlements" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRule.getIfAdminCanManageEntitlements()) %>" />
			</div>
		</div>

		<div class="span12">
			<div class="span4">
				<label>Enable leave accrue</label>
			</div>
			<div class="span8">
				 <aui:input name="ifLeaveAccruable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRule.getIfLeaveAccruable()) %>" />
			</div>
		</div>

		<div class="span12">
			<div class="span4">
				<label>Enable leave carried forward</label>
			</div>
			<div class="span8">
				 <aui:input name="ifCarryForwardable" type="checkbox" label="" checked="<%=\"true\".equalsIgnoreCase(editLeaveRule.getIfCarryForwardable()) %>" />
			</div>
		</div>
</div>

		<div class="span12">
			<aui:button type="submit" id="save" value="save" />
		</div>

</aui:form>
</div>


<portlet:actionURL var="editLeaveRestriction" name="editLeaveRestriction">
</portlet:actionURL>
<portlet:actionURL var="editLeaveCarryForwardPolicy" name="editLeaveCarryForwardPolicy">
</portlet:actionURL>
<portlet:actionURL var="editLeaveTypeApplicability" name="editLeaveTypeApplicability">
</portlet:actionURL>


<div>
	<aui:form name="myForm2" action="<%=editLeaveRestriction.toString()%>">
			<aui:button type="submit" id="save" value="Go To Leave Restriction" />
	</aui:form>>
	<aui:form name="myForm3" action="<%=editLeaveCarryForwardPolicy.toString()%>">
			<aui:button type="submit" id="save" value="Go To Leave Carry Forward" />
	</aui:form>>
	<aui:form name="myForm4" action="<%=editLeaveTypeApplicability.toString()%>">
			<aui:button type="submit" id="save" value="Go To Type Applicability" />
	</aui:form>>
</div>

 </body>

</html>