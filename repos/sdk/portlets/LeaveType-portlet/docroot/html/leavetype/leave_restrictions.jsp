<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL name="addOrUpdateLeaveRestrictions"
	var="addOrUpdateLeaveRestrictions"></portlet:actionURL>
<%
	Map leaveInfo = (Map) request.getSession()
			.getAttribute("leaveInfo");
	System.out.println("edit leave info is" + leaveInfo);
	Long leaveTypeId = (Long) leaveInfo.get("leaveTypeId");
	LeaveRestriction leaveRestriction = (LeaveRestriction) leaveInfo
			.get("editLeaveRestriction");
%>
<div class="panel">
	<div class="panel-heading">
		<h4>Apply/Assign Restrictions</h4>
	</div>
	<div class="panel-body">
		<aui:form action="<%=addOrUpdateLeaveRestrictions%>"
			name="formLeaveRuleApplyRestriction"
			id="formLeaveRuleApplyRestriction">
			<aui:input name="leaveTypeId" type="hidden" value="<%=leaveTypeId%>"></aui:input>
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
								type="checkbox" style="float: none; display: inline;"
								name="cannotExceedBalance"></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="cannotExceedBalance_defaultEss" label="Default ESS"
											type="checkbox" name="cannotExceedBalance_defaultEss"
											value=""></aui:input>
								</label></li>
							</ol>
						</td>
						<td>
							<ol>

								<%
									List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay
												.getCompanyId());
										for (Role role : roles) {
								%>

								<li><aui:input
										id='<%="cannotExceedBalance" + role.getName()%>'
										type="checkbox"
										name='<%="cannotExceedBalance" + role.getName()%>'
										label="<%=role.getName()%>"></aui:input></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
					<tr>
						<td>Don't allow partial day leave.<br></br> <aui:input
								label="" id="cannotApplyForPartialDay" type="checkbox"
								style="float: none; display: inline;"
								name="cannotApplyForPartialDay"></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="cannotApplyForPartialDay_defaultEss" label="Default ESS"
											type="checkbox" name="cannotApplyForPartialDay_defaultEss"
											value=""></aui:input>
								</label></li>
							</ol>
						</td>
						<td>
							<ol>

								<%
									for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="cannotApplyForPartialDay" + role.getName()%>'
											type="checkbox"
											name='<%="cannotApplyForPartialDay" + role.getName()%>'
											value="<%=role.getRoleId()%>" label="<%=role.getName()%>"></aui:input>

								</label></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
					<tr>
						<td>Don't allow if employee answers NO to below question.
							Show the error message that comes afterwards. <br></br> <aui:input
								label="Questions" id="questions"
								style="float: none; display: inline;" name="termsQuestion"></aui:input>
							<aui:input label="Error Message" id="errorTextIfTermsDeclined"
								style="float: none; display: inline;"
								name="errorTextIfTermsDeclined"></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="ifAtermsQuestion_defaultEss" label="Default ESS"
											type="checkbox" name="ifAtermsQuestion_defaultEss" value="2"></aui:input>
								</label></li>
							</ol>
						</td>
						<td>
							<ol>

								<%
									for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="ifATermsQuestion" + role.getName()%>' type="checkbox"
											name='<%="ifATermsQuestion" + role.getName()%>'
											label="<%=role.getName()%>"></aui:input>

								</label></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
					<tr>
						<td>Don't allow if Service Period is less than <br></br> <aui:input
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6" value=""
								style="float: none; display: inline;"
								name="minimumServicePeriod" label="Minimum Service Period"></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="isMinServiceApplicable_defaultEss" label="Default ESS"
											name="isMinServiceApplicable_defaultEss" value=""></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>

								<%
									for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isMinimumServicePeriodApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isMinimumServicePeriodApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"></aui:input>

								</label></li>
								<%
									}
								%>
							</ol>
						</td>

					</tr>
					<tr>
						<td>Don't allow if number of consecutive leave days exceed <br></br>
							<aui:input id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								value="" style="float: none; display: inline;"
								name="maxConsecutiveLeaves" label="Max ConsecutiveLeaves"></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="isMaxConsecutiveLeavesApplicable_defaultEss"
											label="Default ESS" type="checkbox"
											name="isMaxConsecutiveLeavesApplicable_defaultEss"></aui:input>
								</label></li>
							</ol>

						</td>
						<td>
							<ol>

								<%
									for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isMaxConsecutiveLeavesApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isMaxConsecutiveLeavesApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"></aui:input>
								</label></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
					<tr>
						<td>Don't allow if no child found aged less than <br></br> <aui:input
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								style="float: none; display: inline;"
								name="maxSmallChildAgeApplicable"
								label="Max Small Child Age Applicable"></aui:input><label>months</label>
						</td>
						<td>
							<ol>
								<li><label> <aui:input id="apply_restrict_1_2"
											label="Default ESS"
											name="isSmallChildCriterionApplicable_defaultEss"
											type="checkbox"></aui:input>
								</label></li>
							</ol>
						</td>
						<td>
							<ol>

								<%
									for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isSmallChildCriterionApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isSmallChildCriterionApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"></aui:input>

								</label></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
			</table>
			<aui:button value="Save" name="leaveRestrictionsButton" type="submit"
				id="leaveRestrictionsButton" class="button btn-success"></aui:button>
		</aui:form>
	</div>
</div>