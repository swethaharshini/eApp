<%@ include file="/html/leavetype/init.jsp"%>
<html><head> 
<aui:script>
var selectedValue=A.one("#maximumAmountToCarryForward").get('value');
if(selectedValue.equalsIgnoreCase("Specify the maximum number"))
{
}
</aui:script>
</head><body>
<aui:form>
<div class="panel">
	<div class="panel-heading">
		<h4>Carry Forward Rules</h4>
	</div>
	<div class="panel-body">
	<div class="row-fluid">
	<div class="span4"><label>Include overdrawn leave when carrying forward leave balance</label></div>
	<div class="span4">
	  <aui:input name="includeOverdrawnLeaveWhenCarrying"
			label="" type="checkbox"></aui:input>
	 </div>
	<div class="span4"></div>
	</div>
	<div class="row-fluid">
	<div class="span4"><label>Maximum amount to carry forward</label></div>
	<div class="span4">
	 <aui:select name="maximumAmountToCarryForward" id="maximumAmountToCarryForward"
		label="">
		<aui:option value="Specify the maximum number" selected="true">Specify the maximum number</aui:option>
		<aui:option value="All remaining days">All remaining days</aui:option>
		</aui:select>
	 </div>
	<div class="span4"> 
	 <aui:input name="" label=""><aui:validator name="number"></aui:validator> </aui:input>
	</div>
	</div>
	<div class="row-fluid">
	<div class="span4"><label>Carry forward negative values</label></div>
	<div class="span4">
	 <aui:input name="carryForwardNegetiveRules"
		label="" type="checkbox"></aui:input>
	 </div>
	<div class="span4"></div>
	</div>
	<div class="row-fluid">
	<div class="span4"><label>Expire after</label></div>
	<div class="span4">
	  <aui:input name="expireAfter" label=""></aui:input>
	 </div>
	<div class="span4">
	 <aui:select name="leaveExpireFrequency" label="">
		<aui:option>Weeks</aui:option>
		<aui:option>Months</aui:option>
		<aui:option>Years</aui:option>
	</aui:select>
	</div>
	</div>
	<hr/>
	<aui:button type="submit" value="save" cssClass="button btn-success"></aui:button>
	</div>

</div>

<div class="panel">
	<div class="panel-heading">
		<h4>Specific Rules for Employee Groups</h4>
	</div>
	<div class="panel-body">
 <aui:button type="button" value="Add"/>
 <hr/>
 <%-- <table class="table hover">
 <tr>
  <th></th>
  <th>Group Name</th>
  <th>Include overdrawn leave when carrying forward leave balance</th>
  <th>Maximum amount to carry forward</th>
  <th>Carry forward negative values</th>
  <th colspan="2">Expire after</th>
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
  <aui:input name="" label="" type="checkbox"></aui:input>
 </td>
 <td>
  <aui:select name="">
   <aui:option value="Specify the maximum number" selected="true">Specify the maximum number</aui:option>
   <aui:option value="All remaining days">All remaining days</aui:option>
  </aui:select>
 
 </td>
 <td>
 <aui:input name="" label="" type="checkbox"></aui:input>
 </td>
 <td></td>
 <td>
  <aui:select name="">
    <aui:option value="Months">Months</aui:option>
   <aui:option value="Weeks" selected="true">Weeks</aui:option>
   <aui:option value="Days">Days</aui:option>
  </aui:select>
 </td>
 </tr>
</table> --%>

</div>
</div>




</aui:form>
</body></html>