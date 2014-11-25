<%@ include file="/html/leavetype/init.jsp"%>
<div class="panel">
	<div class="panel-heading">
		<h3>Carry Forward Rules</h3>
	</div>
	<div class="panel-body">
		<aui:input name="includeOverdrawnLeaveWhenCarrying"
			label="Include overdrawn leave when carrying forward leave balance"
			type="checkbox"></aui:input>
	</div>
	<aui:input name="maximumAmountToCarryForward"
		label="Maximum amount to carry forward"></aui:input>
	<aui:input name="carryForwardNegetiveRules"
		label="Carry forward negative values" type="checkbox"></aui:input>
	<aui:input name="expireAfter" label="Expire after"></aui:input>
	<aui:select name="leaveExpireFrequency">
		<aui:option>Weeks</aui:option>
		<aui:option>Months</aui:option>
		<aui:option>Years</aui:option>
	</aui:select>
	<div class="panel-footer">
	<aui:button type="submit" value="save" cssClass="button btn-success"></aui:button>
	</div>
</div>