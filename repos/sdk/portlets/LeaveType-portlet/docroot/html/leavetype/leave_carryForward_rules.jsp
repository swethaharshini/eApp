<%@ include file="/html/leavetype/init.jsp"%>
<aui:script>
var selectedValue=A.one("#maximumAmountToCarryForward").get('value');
if(selectedValue.equalsIgnoreCase("Specify the maximum number"))
{
}
</aui:script>
<div class="panel">
	<div class="panel-heading">
		<h3>Carry Forward Rules</h3>
	</div>
	<div class="panel-body">
		<aui:input name="includeOverdrawnLeaveWhenCarrying"
			label="Include overdrawn leave when carrying forward leave balance"
			type="checkbox"></aui:input>
	</div>
	<aui:select name="maximumAmountToCarryForward" id="maximumAmountToCarryForward"
		label="Maximum amount to carry forward">
		<aui:option value="Specify the maximum number">Specify the maximum number</aui:option>
		<aui:option value="All remaining days">All remaining days</aui:option>
		</aui:select>
	<aui:input name="carryForwardNegetiveRules"
		label="Carry forward negative values" type="checkbox"></aui:input>
	<aui:input name="expireAfter" label="Expire after"></aui:input>
	<aui:select name="leaveExpireFrequency" label="">
		<aui:option>Weeks</aui:option>
		<aui:option>Months</aui:option>
		<aui:option>Years</aui:option>
	</aui:select>
	<div class="panel-footer">
	<aui:button type="submit" value="save" cssClass="button btn-success"></aui:button>
	</div>
</div>