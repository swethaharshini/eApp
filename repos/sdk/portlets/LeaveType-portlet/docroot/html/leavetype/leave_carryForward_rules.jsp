<%@page import="com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy"%>
<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL name="addOrEditLeaveCryFwdRules"
	var="addOrEditLeaveCryFwdRules"></portlet:actionURL>
<html>
<%
	Map leaveTypeAndGeneral = (Map) request.getSession(false)
			.getAttribute("leaveInfo");
	LeaveCarryForwardPolicy editCryFwdPolicy = (LeaveCarryForwardPolicy) leaveTypeAndGeneral
			.get("leaveCarryForwardPolicy");
	int specifiedAmount = 0;
	boolean isMaxCaryFwdLmtApplicable = false;
	boolean areNegetiveValuesCarryFwdble = false;
	String expiryDurationUOM = "";
	String maxCarryForwardLImit = "";
	int expiryDuration = 0;
	long leaveTypeId = (Long) leaveTypeAndGeneral.get("leaveTypeId");
	if (editCryFwdPolicy != null) {
		leaveTypeId = editCryFwdPolicy.getLeaveTypeId();
		isMaxCaryFwdLmtApplicable = editCryFwdPolicy
				.getIsMaxCarryForwardLimitApplicable();
		areNegetiveValuesCarryFwdble = editCryFwdPolicy
				.getIsNegetiveValueCarryForwardble();
		expiryDurationUOM = editCryFwdPolicy.getExpiryDurationUOM();
		maxCarryForwardLImit = editCryFwdPolicy
				.getMaxCarryForwardLimit();
		expiryDuration = editCryFwdPolicy.getExpiryDuration();
		specifiedAmount = editCryFwdPolicy
				.getSpecifiedAmountToCarryForward();
	}
%>
<head>
<aui:script >
var A=new AUI();
A.ready(function(){
var maxCarryForwardLimit ='<%=maxCarryForwardLImit%>';

if(maxCarryForwardLimit==="All remaining days")
 {
 	A.one('#<portlet:namespace />specifiedAmount').hide();
 }
 window.toggleAmountField=function(nodeValue)
 {
 if(nodeValue==="All remaining days")
 {
 	A.one('#<portlet:namespace />specifiedAmount').hide();
 	A.one('#<portlet:namespace />specifiedAmount').set('value',0);
 }
 else
 {
    A.one('#<portlet:namespace />specifiedAmount').show();
 }
 };
 });
 var errorCaught=A.one("#specifiedAmount").get('value');
</aui:script>
</head>
<body>
	<aui:form name="saveCarryForwardRules" id="saveCarryForwardRules"
		action="<%=addOrEditLeaveCryFwdRules%>" method="post">
		<aui:input name="leaveTypeId" type="hidden"
			value="<%=String.valueOf(leaveTypeId)%>"></aui:input>
		<div class="panel">
			<div class="panel-heading">
				<h4>Carry Forward Rules</h4>
			</div>
			<div class="panel-body">
				<div class="row-fluid">
					<div class="span4">
						<label>Include overdrawn leave when carrying forward leave
							balance</label>
					</div>
					<div class="span4">
						<aui:input name="includeOverdrawnLeaveWhenCarrying" label=""
							type="checkbox" checked="<%=isMaxCaryFwdLmtApplicable%>"></aui:input>
					</div>
					<div class="span4"></div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<label>Maximum amount to carry forward</label>
					</div>
					<div class="span4">
						<aui:select name="maximumAmountToCarryForward"
							id="maximumAmountToCarryForward" label=""
							onChange="javascript:toggleAmountField(this.value);">
							<aui:option value="Specify the maximum number"
								selected='<%=editCryFwdPolicy == null
								|| maxCarryForwardLImit
										.equalsIgnoreCase("Specify the maximum number")%>'>Specify the maximum number</aui:option>
							<aui:option value="All remaining days"
								selected='<%=maxCarryForwardLImit
								.equalsIgnoreCase("All remaining days")%>'>All remaining days</aui:option>
						</aui:select>
					</div>
					<div class="span4">
						<aui:input name="specifiedAmount" id="specifiedAmount" label=""
							value='<%=specifiedAmount != 0 ? specifiedAmount : ""%>'>
							<aui:validator name="number"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<label>Carry forward negative values</label>
					</div>
					<div class="span4">
						<aui:input name="carryForwardNegetiveRules" label=""
							type="checkbox" checked="<%=areNegetiveValuesCarryFwdble%>"></aui:input>
					</div>
					<div class="span4"></div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<label>Expire after</label>
					</div>
					<div class="span4">
						<aui:input name="expireAfter" label=""
							value='<%=expiryDuration != 0 ? expiryDuration : ""%>'></aui:input>
					</div>
					<div class="span4">
						<aui:select name="leaveExpireFrequency" label="">
							<aui:option value="Weeks"
								selected='<%=expiryDurationUOM.equalsIgnoreCase("Weeks")%>'>Weeks</aui:option>
							<aui:option value="Months"
								selected='<%=expiryDurationUOM.equalsIgnoreCase("Months")%>'>Months</aui:option>
							<aui:option value="Years"
								selected='<%=expiryDurationUOM.equalsIgnoreCase("Years")%>'>Years</aui:option>
						</aui:select>
					</div>
				</div>
				<hr />
				<aui:button type="submit" value="save"></aui:button>
			</div>

		</div>
	</aui:form>
	<div class="panel">
		<div class="panel-heading">
			<h4>Specific Rules for Employee Groups</h4>
		</div>
		<div class="panel-body">
			<aui:button type="button" value="Add" />
			<hr />

		</div>
	</div>

</body>
</html>