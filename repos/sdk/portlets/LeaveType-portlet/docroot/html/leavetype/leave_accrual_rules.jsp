<%@ include file="/html/leavetype/init.jsp"%>
<html>
<portlet:actionURL var="saveaccrualrules" name="addOrUpdateLeaveAccrualRules"></portlet:actionURL>
<head>
<style type="text/css">
.aui select,.aui input[type="text"]{

border-radius:5px;
}
</style>
<aui:script>
AUI().ready('event', 'node', function(A){
 A.one('#monthaccrual').hide();
 A.one('#startaccruallabel').hide();
 A.one('#biweeklyaccrual').hide();
 A.one('#firstaccrualoptionforth').hide();
 A.one('#monthlyAccrual').hide();
 A.one('#eachMonth').hide();
 A.one('#weeklyAccrual').hide();
});
function selectFrequency(){

 var x = A.one('#accrualfrequency').get('value');
if(x==1){
  A.one('#secondrow').show();
  A.one('#accrualevery').show();
  A.one('#monthaccrual').show();
  A.one('#annualAccrual').hide();
  A.one('#firstaccrualoptionthird').hide();
  A.one('#firstaccrualoptionforth').show();
  A.one('#monthlyAccrual').show();
  A.one('#monthlist').hide();
   A.one('#eachMonth').hide();
   A.one('#eachMonth').hide();
 A.one('#weeklyAccrual').hide();
}

if(x==0){
  A.one('#secondrow').show();
   A.one('#startaccruallabel').hide();
 A.one('#biweeklyaccrual').hide();
  A.one('#accrualevery').show();
  A.one('#monthlist').show();
   A.one('#eachMonth').hide();
    A.one('#weeklyAccrual').hide();
     A.one('#monthlyAccrual').hide();
  A.one('#monthaccrual').hide();
  A.one('#annualAccrual').show();
  A.one('#firstaccrualoptionthird').show();
  A.one('#firstaccrualoptionforth').hide();
}
if(x==2){
 
 A.one('#accrualevery').hide();
 A.one('#startaccruallabel').hide();
  A.one('#monthaccrual').hide();
  A.one('#annualAccrual').hide();
  A.one('#biweeklyaccrual').hide();
  A.one('#monthlist').hide();
   A.one('#monthlyAccrual').hide();
 A.one('#weeklyAccrual').show();
 A.one('#proratefirstaccrual').hide();
 A.one('#firstaccrualoptionthird').hide();
  A.one('#firstaccrualoptionforth').hide();
  A.one('#secondrow').hide();
}
if(x==3){
A.one('#secondrow').show();
  A.one('#accrualevery').hide();
  A.one('#startaccruallabel').show();
  A.one('#monthaccrual').hide();
  A.one('#annualAccrual').hide();
  A.one('#biweeklyaccrual').show();
  A.one('#monthlist').hide();
   A.one('#monthlyAccrual').hide();
    A.one('#eachMonth').hide();
  A.one('#weeklyAccrual').show();
  A.one('#proratefirstaccrual').hide();
 A.one('#firstaccrualoptionthird').hide();
  A.one('#firstaccrualoptionforth').hide();
}
if(x==4){
 A.one('#monthlist').hide();
 A.one('#accrualevery').hide();
 A.one('#startaccruallabel').hide();
 A.one('#monthaccrual').hide();
  A.one('#annualAccrual').hide();
  A.one('#biweeklyaccrual').hide();
 A.one('#monthlyAccrual').hide();
 A.one('#weeklyAccrual').hide();
 A.one('#eachMonth').show();
 A.one('#proratefirstaccrual').hide();
 A.one('#firstaccrualoptionthird').hide();
  A.one('#firstaccrualoptionforth').hide();
 A.one('#secondrow').hide();
}
}
</aui:script>


</head><body> 
<%Map leaveInfo=(Map)request.getSession(false).getAttribute(
		"leaveInfo");
		LeaveType editLeaveType=(LeaveType)leaveInfo.get("editLeaveType");
	%>
<aui:form name="leaveAccrualRuleForm" id="leaveAccrualRuleForm" action="<%=saveaccrualrules.toString()%>">
<div class="panel">
	<div class="panel-heading">
		<h4>Accrual Rules</h4>
	</div>
	<div class="panel-body">
	<aui:input name="leaveTypeId" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"></aui:input>
	<div class="row-fluid">
	<div class="span3"><label>Accrual Frequency</label></div>
	<div class="span4">
	  <select name="<portlet:namespace/>accrualFrequency" id="accrualfrequency" onChange="selectFrequency()">
				<option value="0"> Annual</option>
				<option value="1">Monthly</option>
				<option value="2">Weekly</option>
				<option value="3">Bi-Weekly</option>
				<option value="4">Semi-Monthly</option>
	 </select>
	 </div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid" id="secondrow">
	<div class="span3"><label id="accrualevery">Accrual Every</label><label id="startaccruallabel">Start Accrual on</label> </div>
	<div class="span4">
	
	<select id="monthaccrual" name="<portlet:namespace/>monthAccrual">
	 <option value="1 Month">1 Month</option>
	 <option value="2 Month">2 Month</option>
	 <option value="3 Month">3 Month</option>
	 <option value="4 Month">4 Month</option>
	 <option value="5 Month">5 Month</option>
	 <option value="6 Month">6 Month</option>
	</select>
	<select name="<portlet:namespace/>annualAccrual" id="annualAccrual">
				<option>1 Year</option>
	</select>
	
	<select name="<portlet:namespace/>biWeeklyAccrual" id="biweeklyaccrual">
				<option value="1st Week of Leave Period">1st Week of Leave Period</option>
				<option value="2nd Week of Leave Period">2nd Week of Leave Period</option>
	</select>
	
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>Day Of Crediting to Employee</label></div>
	<div class="span4">
	
	<select  name="<portlet:namespace/>monthlist" id="monthlist">
				<option>January</option>
				<option>February</option>
				<option>March</option>
				<option>April</option>
				<option>May</option>
				<option>June</option>
				<option>July</option>
				<option>August</option>
				<option>September</option>
				<option>October</option>
				<option>November</option>
				<option>December</option>
			</select>
	<select  name="<portlet:namespace/>weeklyAccrual" id="weeklyAccrual">
				<option>Sunday</option>
				<option>Monday</option>
				<option>Tuesday</option>
				<option>Wednesday</option>
				<option>Thursday</option>
				<option>Friday</option>
				<option>Saturday</option>
			</select>
	<select  name="<portlet:namespace/>monthlyAccrual" id="monthlyAccrual">
				<option>First Day of month</option>
				<option>Last Day of Month</option>
				<option>Hire Date and hire Date monthly anniversary</option>
					
			</select>
	<label id="eachMonth">1st and 15th of Each Month</label>
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>Accrual Valid from</label></div>
	<div class="span4">
	 <select name="<portlet:namespace/>accrualValidity">
				<option>Date of Accrual</option>
				<option>Leave Period Start Date</option>
			</select>
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>First Accrual Of New Employees</label></div>
	<div class="span9">
	<select name="<portlet:namespace/>firstAccrual">
				<option>Always Accrue Full Amount</option>
				<option>Skip First Accrual</option>
				<option id="firstaccrualoptionthird">Accrue full amount if joined in first half year</option>
				<option id="firstaccrualoptionforth">Accrue full amount if joined before 15th of month</option>
				<option id="proratefirstaccrual">Prorate First Accrual</option>
			</select>
	
	</div>
	
	</div>		
			
			<hr>
			
				<aui:button type="submit" cssClass="button btn-success"></aui:button>
		
	</div>
</div>
<div class="panel">
	<div class="panel-heading">
		<h4>Leave Entitlements Per Employee Group</h4>
	</div>
	<div class="panel-body">
 <aui:button type="button" value="Add"/>
 <hr/>
 <table class="table hover">
 <tr>
  <th></th>
  <th>Group Name</th>
  <th>Days to Accrue</th>
  <th colspan="3">When to stop accrual</th>
  </tr>
 
 <tr>
 <td>1</td>
 <td>
  <aui:select name="">
   <aui:option value="Default" selected="true">Default</aui:option>
   <aui:option>--Select--</aui:option>
  </aui:select>
 </td>
 <td>
  <aui:input name="" type="text" id="smallInput"><aui:validator name="number"></aui:validator></aui:input>
 </td>
 <td>
  <aui:select name="">
    <aui:option value="Do not Stop">Do not Stop</aui:option>
   <aui:option value="When Entitlement reaches" selected="true">When Entitlement reaches</aui:option>
   <aui:option value="When(balance-overdrawn)reaches">When(balance-overdrawn)reaches</aui:option>
  </aui:select>
 
 </td>
 <td colspan="3">
<%--  <aui:input name="" type="text" id="smallInput"><aui:validator name="number"></aui:validator></aui:input> --%>
 </td>
 </tr>
</table>

</div>
</div>

</aui:form>
</body> </html>