<%@ include file="/html/leavetype/init.jsp"%>
<html><head>
<style type="text/css">
.aui select,.aui input[type="text"]{

border-radius:5px;
}
/* input#smallInput{
width: 61px;
} */
</style>
<aui:script>
AUI().ready('event', 'node', function(A){
 A.one('#monthaccrual').hide();
 A.one('#startaccruallabel').hide();
 A.one('#biweeklyaccrual').hide();
 A.one('#firstaccrualoptionforth').hide();
});
function selectFrequency(){
alert("Hi");
 var x = A.one('#accrualfrequency').get('value');
 alert(x);
}
</aui:script>


</head><body> 
<aui:form name="leaveAccrualRuleForm" id="leaveAccrualRuleForm">
<div class="panel">
	<div class="panel-heading">
		<h4>Accrual Rules</h4>
	</div>
	<div class="panel-body">
	
	<div class="row-fluid">
	<div class="span3"><label>Accrual Frequency</label></div>
	<div class="span4">
	  <select name="accrualFrequency" id="accrualfrequency" onChange="selectFrequency()">
				<option value="0"> Annual</option>
				<option value="1">Monthly</option>
				<option value="2">Weekly</option>
				<option value="3">Bi-Weekly</option>
				<option value="4">Semi-Monthly</option>
	 </select>
	 </div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>Accrual Every</label><label id="startaccruallabel">Start Accrual on</label> </div>
	<div class="span4">
	
	<select id="monthaccrual" name="monthAccrual">
	 <option value="1">1 Month</option>
	 <option value="2">2 Month</option>
	 <option value="3">3 Month</option>
	 <option value="4">4 Month</option>
	 <option value="5">5 Month</option>
	 <option value="6">6 Month</option>
	</select>
	<select name="annualAccrual">
				<option>1 Year</option>
	</select>
	
	<select name="biWeeklyAccrual" id="biweeklyaccrual">
				<option value="1st Week of Leave Period">1st Week of Leave Period</option>
				<option value="2nd Week of Leave Period">2nd Week of Leave Period</option>
	</select>
	
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>Day Of Crediting to Employee</label></div>
	<div class="span4">

	<aui:select  name="weeklyAccrual" label="">
				<aui:option>Sunday</aui:option>
				<aui:option>Monday</aui:option>
				<aui:option>Tuesday</aui:option>
				<aui:option>Wednesday</aui:option>
				<aui:option>Thursday</aui:option>
				<aui:option>Friday</aui:option>
				<aui:option>Saturday</aui:option>
			</aui:select>
	
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>Accrual Valid from</label></div>
	<div class="span4">
	 <aui:select name="accrualValidity" label="">
				<aui:option>Date of Accrual</aui:option>
				<aui:option>Leave Period Start Date</aui:option>
			</aui:select>
	</div>
	<div class="span5"></div>
	</div>
	<div class="row-fluid">
	<div class="span3"><label>First Accrual Of New Employees</label></div>
	<div class="span9">
	<select name="firstAccrual">
				<option>Always Accrue Full Amount</option>
				<option>Skip First Accrual</option>
				<option>Accrue full amount if joined in first half year</option>
				<option id="firstaccrualoptionforth">Accrue full amount if joined before 15th of month</option>
				<option>Prorate First Accrual</option>
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