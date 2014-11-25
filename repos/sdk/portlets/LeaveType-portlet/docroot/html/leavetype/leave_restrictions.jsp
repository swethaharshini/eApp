<%@ include file="/html/leavetype/init.jsp"%>
<div class="panel">
	<div class="panel-heading">
		<h4>Apply/Assign Restrictions</h4>
	</div>
	<div class="panel-body">
		<aui:form action="" name="formLeaveRuleApplyRestriction"
			id="formLeaveRuleApplyRestriction">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th rowspan="2">Restriction</th>
						<th colspan="2">Restriction to user roles</th>
					</tr>
					<tr>
						<th>Apply</th>
						<th>Assign</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
				<tbody>

					<tr>
						<td>Don't allow more than current leave net balance. Net
							Balance = [Total Entitlements] - [Leave Taken + Leave Scheduled +
							Leave Pending Approval] <br></br> <aui:input
								label="Use projected balance for future dates"
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								type="checkbox" value="on" style="float: none; display: inline;"
								name=""></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS" type="checkbox"
											name=""
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow partial day leave.<br></br>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS" type="checkbox"
											name=""
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow if employee answers NO to below question.
							Show the error message that comes afterwards. <br></br> <aui:input
								label="Questions"
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6" value="on"
								style="float: none; display: inline;"
								name=""></aui:input>
							<aui:input label="Answers"
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6" value="on"
								style="float: none; display: inline;"
								name=""></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS" type="checkbox"
											name=""
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow if Service Period is less than <br></br> <aui:input
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6" value="on"
								style="float: none; display: inline;"
								name=""></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS"
											name="leaveTypeRuleApplyRestriction[apply_restrict_1][]"
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow if number of consecutive leave days exceed <br></br>
							<aui:input id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								value="on" style="float: none; display: inline;"
								name=""></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS" type="checkbox"
											name=""
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow if no child found aged less than <br></br> <aui:input
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6" value="on"
								style="float: none; display: inline;"
								name=""></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS"
											name=""
											value="2"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>
								<li><label> <aui:input id="assign_restrict_1_1"
											type="checkbox"
											name=""
											value="1" label="Global Admin"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_3"
											type="checkbox"
											name=""
											value="3" label="Default Supervisor"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_10"
											type="checkbox"
											name=""
											value="10" label="Regional Admin"></aui:input>
								</label></li>
								<li><label> <aui:input id="assign_restrict_1_14"
											type="checkbox"
											name=""
											value="14" label="Regional Administrator"></aui:input>

								</label></li>
								<li><label> <aui:input id="assign_restrict_1_28"
											type="checkbox"
											name=""
											value="28" label="Software Developer"></aui:input>
								</label></li>
							</ol>
						</td>

					</tr>
			</table>
			<aui:button value="Save" name="leaveRestrictionsButton"
				id="leaveRestrictionsButton" class="button btn-success"></aui:button>
		</aui:form>
	</div>
</div>