<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
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
								checked="<%=leaveRestriction.getCannotExceedBalance()%>"
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
									System.out.println("CantExceedBalForRoleIds === "
												+ leaveRestriction.getCantExceedBalForRoleIds());
										String[] cannotExceedBalanceArray = leaveRestriction
												.getCantExceedBalForRoleIds().split(",");
										List<Long> cannotExceedBalanceIds = new ArrayList<Long>();
										for (int i = 0; i < cannotExceedBalanceArray.length; i++) {
											if (cannotExceedBalanceArray[i].equals("")
													|| cannotExceedBalanceArray[i] == null
													|| cannotExceedBalanceArray[i].equals("null")) {
												System.out
														.println("Empty value in cannotExceedBalanceArray");
											} else {
												cannotExceedBalanceIds.add(Long
														.parseLong(cannotExceedBalanceArray[i]));
											}
										}
										List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay
												.getCompanyId());
										for (Role role : roles) {
								%>

								<li><aui:input
										id='<%="cannotExceedBalance" + role.getName()%>'
										type="checkbox"
										name='<%="cannotExceedBalance" + role.getName()%>'
										checked="<%=cannotExceedBalanceIds.contains(role
								.getRoleId()) ? true : false%>"
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
								name="cannotApplyForPartialDay"
								checked="<%=leaveRestriction.getCannotApplyForPartialDay()%>"></aui:input>
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
									System.out.println("CantApplyPartialDayForRoleIds === "
												+ leaveRestriction.getCantApplyPartialDayForRoleIds());
										String[] cantApplyPartialDayForRoleIdsArray = leaveRestriction
												.getCantApplyPartialDayForRoleIds().split(",");
										System.out.println("1111======="
												+ cantApplyPartialDayForRoleIdsArray.length + " ##### "
												+ cantApplyPartialDayForRoleIdsArray);
										List<Long> cantApplyPartialDayForRoleIds = new ArrayList<Long>();
										for (int i = 0; i < cantApplyPartialDayForRoleIdsArray.length; i++) {
											if (cantApplyPartialDayForRoleIdsArray[i].equals("")
													|| cantApplyPartialDayForRoleIdsArray[i] == null
													|| cantApplyPartialDayForRoleIdsArray[i]
															.equals("null")) {
												System.out
														.println("Empty value in cantApplyPartialDayForRoleIdsArray");
											} else {
												cantApplyPartialDayForRoleIds
														.add(Long
																.parseLong(cantApplyPartialDayForRoleIdsArray[i]));
											}

										}
										for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="cannotApplyForPartialDay" + role.getName()%>'
											type="checkbox"
											name='<%="cannotApplyForPartialDay" + role.getName()%>'
											value="<%=role.getRoleId()%>" label="<%=role.getName()%>"
											checked="<%=cantApplyPartialDayForRoleIds.contains(role
								.getRoleId()) ? true : false%>"></aui:input>

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
								style="float: none; display: inline;" name="termsQuestion"
								value="<%=leaveRestriction.getTermsQuestion()%>"></aui:input> <aui:input
								label="Error Message" id="errorTextIfTermsDeclined"
								style="float: none; display: inline;"
								name="errorTextIfTermsDeclined"
								value="<%=leaveRestriction.getErrorTextIfTermsDeclined()%>"></aui:input>
						</td>
						<td>
							<ol>
								<li><label> <aui:input
											id="ifAtermsQuestion_defaultEss" label="Default ESS"
											type="checkbox" name="ifAtermsQuestion_defaultEss" value=""></aui:input>
								</label></li>
							</ol>
						</td>
						<td>
							<ol>

								<%
									System.out.println("TermsQsnForRoleIds === "
												+ leaveRestriction.getTermsQsnForRoleIds());
										String[] termsQsnForRoleIdsArray = leaveRestriction
												.getTermsQsnForRoleIds().split(",");
										List<Long> termsQsnForRoleIds = new ArrayList<Long>();
										for (int i = 0; i < termsQsnForRoleIdsArray.length; i++) {
											if (termsQsnForRoleIdsArray[i].equals("")
													|| termsQsnForRoleIdsArray[i] == null
													|| termsQsnForRoleIdsArray[i].equals("null")) {
												System.out
														.println("Empty value in termsQsnForRoleIdsArray");
											} else {

												termsQsnForRoleIds.add(Long
														.parseLong(termsQsnForRoleIdsArray[i]));
											}
										}
										for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="ifATermsQuestion" + role.getName()%>' type="checkbox"
											name='<%="ifATermsQuestion" + role.getName()%>'
											label="<%=role.getName()%>"
											checked="<%=termsQsnForRoleIds.contains(role.getRoleId()) ? true
								: false%>"></aui:input>

								</label></li>
								<%
									}
								%>
							</ol>
						</td>
					</tr>
					<tr>
						<td>Don't allow if Service Period is less than <br></br> <aui:input
								id="leaveTypeRuleApplyRestriction_tbxFilterPram6"
								value="<%=leaveRestriction.getMinimumServicePeriod()%>"
								style="float: none; display: inline;"
								name="minimumServicePeriod" label="Minimum ServicePeriod"></aui:input><label>months</label>
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
									System.out.println("MinServicePeriodForRoleIds === "
												+ leaveRestriction.getMinServicePeriodForRoleIds());
										String[] minServicePeriodForRoleIdsArray = leaveRestriction
												.getMinServicePeriodForRoleIds().split(",");
										List<Long> minServicePeriodForRoleIds = new ArrayList<Long>();
										for (int i = 0; i < minServicePeriodForRoleIdsArray.length; i++) {
											if (minServicePeriodForRoleIdsArray[i].equals("")
													|| minServicePeriodForRoleIdsArray[i] == null
													|| minServicePeriodForRoleIdsArray[i]
															.equals("null")) {
												System.out
														.println("Empty value in minServicePeriodForRoleIdsArray");
											} else {
												minServicePeriodForRoleIds.add(Long
														.parseLong(minServicePeriodForRoleIdsArray[i]));
											}
										}
										for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isMinimumServicePeriodApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isMinimumServicePeriodApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"
											checked="<%=minServicePeriodForRoleIds.contains(role
								.getRoleId()) ? true : false%>"></aui:input>

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
								value="<%=leaveRestriction.getMaxConsecutiveLeaves()%>"
								style="float: none; display: inline;"
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
									System.out.println("MaxConsecLeavesForRoleIds === "
												+ leaveRestriction.getMaxConsecLeavesForRoleIds());
										String[] maxConsecLeavesForRoleIdsArray = leaveRestriction
												.getMaxConsecLeavesForRoleIds().split(",");
										List<Long> maxConsecLeavesForRoleIds = new ArrayList<Long>();
										for (int i = 0; i < maxConsecLeavesForRoleIdsArray.length; i++) {
											if (maxConsecLeavesForRoleIdsArray[i].equals("")
													|| maxConsecLeavesForRoleIdsArray[i] == null
													|| maxConsecLeavesForRoleIdsArray[i].equals("null")) {
												System.out
														.println("Empty value in maxConsecLeavesForRoleIdsArray");
											} else {
												maxConsecLeavesForRoleIds.add(Long
														.parseLong(maxConsecLeavesForRoleIdsArray[i]));
											}
										}
										for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isMaxConsecutiveLeavesApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isMaxConsecutiveLeavesApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"
											checked="<%=maxConsecLeavesForRoleIds.contains(role
								.getRoleId()) ? true : false%>"></aui:input>
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
								label="Max Small Child Age Applicable"
								value="<%=leaveRestriction.getMaxSmallChildAgeApplicable()%>"></aui:input><label>months</label>
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
									System.out.println("MaxSmallChildAgeForRoleIds === "
												+ leaveRestriction.getMaxSmallChildAgeForRoleIds());
										String[] maxSmallChildAgeForRoleIdsArray = leaveRestriction
												.getMaxSmallChildAgeForRoleIds().split(",");
										List<Long> maxSmallChildAgeForRoleIds = new ArrayList<Long>();
										for (int i = 0; i < maxSmallChildAgeForRoleIdsArray.length; i++) {
											if (maxSmallChildAgeForRoleIdsArray[i].equals("")
													|| maxSmallChildAgeForRoleIdsArray[i] == null
													|| maxSmallChildAgeForRoleIdsArray[i]
															.equals("null")) {
												System.out
														.println("Empty value in maxSmallChildAgeForRoleIdsArray");
											} else {
												maxSmallChildAgeForRoleIds.add(Long
														.parseLong(maxSmallChildAgeForRoleIdsArray[i]));
											}
										}
										for (Role role : roles) {
								%>

								<li><label> <aui:input
											id='<%="isSmallChildCriterionApplicable"
								+ role.getName()%>'
											type="checkbox"
											name='<%="isSmallChildCriterionApplicable"
								+ role.getName()%>'
											label="<%=role.getName()%>"
											checked="<%=maxSmallChildAgeForRoleIds.contains(role
								.getRoleId()) ? true : false%>"></aui:input>

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