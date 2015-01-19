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
		<h3>Apply/Assign Restrictions</h3>
	</div>
	<div class="panel-body">
		<aui:form action="<%=addOrUpdateLeaveRestrictions%>"
			name="formLeaveRuleApplyRestriction"
			id="formLeaveRuleApplyRestriction">
			<aui:input name="leaveTypeId" type="hidden" value="<%=leaveTypeId%>"></aui:input>
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th rowspan="2" style="vertical-align:middle" width="30%">Restriction</th>
						<th colspan="2"  width="70%">Restriction to user roles</th>
					</tr>
					<tr>
						<th>Apply</th>
						<th>Assign</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Don't allow more than current leave net balance. Net
							Balance = [Total Entitlements] - [Leave Taken + Leave Scheduled +
							Leave Pending Approval] <br></br> <aui:input
								label="Use projected balance for future dates"
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								type="checkbox" name="cannotExceedBalance"></aui:input>
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
						<td>
						<aui:input label="Don't allow partial day leave" id="cannotApplyForPartialDay" type="checkbox" name="cannotApplyForPartialDay"></aui:input>
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
								 name="termsQuestion"></aui:input>
							<aui:input label="Error Message" id="errorTextIfTermsDeclined"
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
						<td>Don't allow if Service Period is less than <br></br> 
						<label>Minimum Service Period</label>
						<div class="input-append">
							<input id="leaveTypeRuleApplyRestriction_tbxFilterPram6" type="text" value="" name="minimumServicePeriod" />
							<span class="add-on">months</span>
						</div>
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
						<label>Max ConsecutiveLeaves</label>
						<div class="input-append">
							<input id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								value="" name="maxConsecutiveLeaves" type="text"/>
								<span class="add-on">months</span>
						</div>
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
						<td>Don't allow if no child found aged less than <br></br> 
							<label>Max Small Child Age Applicable</label>
							<div class="input-append">
								<input id="leaveTypeRuleApplyRestriction_tbxFilterPram6" name="maxSmallChildAgeApplicable" type="text" />
								<span class="add-on">months</span>
							</div>
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
				</tbody>
			</table>
			<aui:button value="Save" name="leaveRestrictionsButton" type="submit"
				id="leaveRestrictionsButton" class="button btn-success"></aui:button>
		</aui:form>
	</div>
</div>