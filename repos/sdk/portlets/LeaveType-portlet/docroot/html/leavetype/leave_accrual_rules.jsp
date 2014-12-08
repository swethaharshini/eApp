<%@ include file="/html/leavetype/init.jsp"%>
<div class="panel">
	<div class="panel-heading">
		<h3>Accrual Rules</h3>
	</div>
	<div class="panel-body">
		<aui:form name="leaveAccrualRuleForm" id="leaveAccrualRuleForm">
			<aui:select name="accrualFrequency" label="Accrual Frequency">
				<aui:option value="0"> Annual</aui:option>
				<aui:option value="1">Monthly</aui:option>
				<aui:option value="2">Weekly</aui:option>
				<aui:option value="3">Bi-Weekly</aui:option>
				<aui:option value="4">Semi-Weekly</aui:option>
				<aui:option></aui:option>
			</aui:select>
			<aui:select name="annualAccrual" label="Accrue Every">
				<aui:option>1 Year</aui:option>
				<aui:option>2 Year</aui:option>
				<aui:option>3 Year</aui:option>
			</aui:select>
			<aui:select name="monthlyAccrual" label="Accrue Every">
				<aui:option>1 Month</aui:option>
				<aui:option>2 Month</aui:option>
				<aui:option>3 Month</aui:option>
				<aui:option>4 Month</aui:option>
				<aui:option>5 Month</aui:option>
			</aui:select>
			<aui:select name="weeklyAccrual" label="Day Of Crediting to Employee">
				<aui:option>Sunday</aui:option>
				<aui:option>Monday</aui:option>
				<aui:option>Tuesday</aui:option>
				<aui:option>Wednesday</aui:option>
				<aui:option>Thursday</aui:option>
				<aui:option>Friday</aui:option>
				<aui:option>Saturday</aui:option>
			</aui:select>
			<aui:select name="biWeeklyAccrual" label="Start Accrual on">
				<aui:option>1st Week of Leave Period</aui:option>
				<aui:option>2nd Week of Leave Period</aui:option>
			</aui:select>
			<aui:select name="accrualValidity" label="Accrual Valid from">
				<aui:option>Date of Accrual</aui:option>
				<aui:option>Leave Period Start Date</aui:option>
			</aui:select>
			<aui:select name="firstAccrual" label="First Accrual">
				<aui:option>Always Accrue Full Amount</aui:option>
				<aui:option>Skip First Accrual</aui:option>
				<aui:option>Accrue full amount if joined in first half year</aui:option>
				<aui:option>Prorate First Accrual</aui:option>
			</aui:select>
			<hr>
			<h2>Proration Settings</h2>
				<ol>
					<li>   <aui:select label="Proration Method"
						id="leaveTypeRuleAccrualRule_prorationMethod" class="valid"
						name="leaveTypeRuleAccrualRule[prorationMethod]">
							<aui:option value="default">Default</aui:option>
					</aui:select></li>
				</ol>
				<div id="eq_label">
					<label> Prorated Amount = </label>
				</div>
				<div class="eq_container">
					<span class="nom"> Accrual Amount <span class="operator">

							× </span> <aui:select id="leaveTypeRuleAccrualRule_default_numerator"
						class="valid" name="leaveTypeRuleAccrualRule[default][numerator]" label=" ">
							<aui:option value="remaining_working" selected="selected">

								Remaining working days in the year</aui:option>
							<aui:option value="total_working">Total working days in the
								year</aui:option>
							<aui:option value="remaining_calendar">Remaining calendar
								days in the year</aui:option>
							<aui:option value="total_calendar">Total calendar days in
								the year</aui:option>
							<aui:option value="fixed">Fixed Number</aui:option>
					</aui:select> <aui:input id="leaveTypeRuleAccrualRule_default_numerator_input"
						type="text" label=""
						name="leaveTypeRuleAccrualRule[default][numerator_input]"
						style="display: inline;"></aui:input>

					</span> <span class="den"> <aui:select label=""
						id="leaveTypeRuleAccrualRule_default_denominator" class="valid"
						name="leaveTypeRuleAccrualRule[default][denominator]">
							<aui:option value="remaining_working" selected="selected">

								Remaining working days in the year</aui:option>
							<aui:option value="total_working">Total working days in the
								year</aui:option>
							<aui:option value="remaining_calendar">Remaining calendar
								days in the year</aui:option>
							<aui:option value="total_calendar">Total calendar days in
								the year</aui:option>
							<aui:option value="fixed">Fixed Number</aui:option>
					</aui:select> <aui:input id="leaveTypeRuleAccrualRule_default_denominator_input"
						type="text"
						name="leaveTypeRuleAccrualRule[default][denominator_input]"
						style="display: none;"></aui:input>
					</span>

				</div>
				<aui:button type="submit" cssClass="button btn-success"></aui:button>
		</aui:form>
	</div>
</div>