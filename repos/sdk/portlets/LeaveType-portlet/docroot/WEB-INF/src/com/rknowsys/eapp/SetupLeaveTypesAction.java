package com.rknowsys.eapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy;
import com.rknowsys.eapp.hrm.model.LeaveRestriction;
import com.rknowsys.eapp.hrm.model.LeaveRule;
import com.rknowsys.eapp.hrm.model.LeaveType;
import com.rknowsys.eapp.hrm.model.LeaveTypeApplicability;
import com.rknowsys.eapp.hrm.model.Nationality;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRuleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeApplicabilityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class SetupLeaveTypesAction extends MVCPortlet {

	private static final String LEAVE_TYPE_ID = "leaveTypeId";
	private static Logger log = Logger.getLogger(SetupLeaveTypesAction.class);

	/**
	 * <p>
	 * This method inserts new ContactDetails record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveLeaveType(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {

		log.info("inside saveLeaveType...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		ParamUtil.print(actionRequest);
		com.rknowsys.eapp.ui.LeaveType leaveTypeUI = new com.rknowsys.eapp.ui.LeaveType();

		try {
			String id = ParamUtil.getString(actionRequest, LEAVE_TYPE_ID);
			LeaveType leaveType = null;

			if (id == null || id.isEmpty()) {

				log.info("inside if loop...");

				leaveType = LeaveTypeLocalServiceUtil.createLeaveType(CounterLocalServiceUtil.increment());
				leaveType.setCreateDate(new Date());
				setAuditFields(themeDisplay, leaveType);
				setLeaveType(actionRequest, leaveType);

				leaveType = LeaveTypeLocalServiceUtil.addLeaveType(leaveType);
				System.out.println("b4 setting leavetypeid in session=" + leaveType.getLeaveTypeId());
				actionRequest.getPortletSession().setAttribute(LEAVE_TYPE_ID, leaveType.getLeaveTypeId());
				System.out.println("to chk if set, from session, s = "
						+ actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID));
				// add default recods for 1. Leave Rule, 2.applicability,
				// 3.restrictions,
				// 4. accrual rules and 5.carry forward rule records

				// add default recods for 1. Leave Rule
				LeaveRule leaveRule = LeaveRuleLocalServiceUtil.createLeaveRule(CounterLocalServiceUtil.increment());
				setDefaultLeaveRule(leaveRule);
				leaveRule.setCreateDate(new Date());
				setAuditFields(themeDisplay, leaveRule);
				leaveRule.setLeaveTypeId(leaveType.getLeaveTypeId());
				LeaveRuleLocalServiceUtil.addLeaveRule(leaveRule);

				// add default recods for 2.applicability
				LeaveTypeApplicability leaveTypeApplicability = LeaveTypeApplicabilityLocalServiceUtil
						.createLeaveTypeApplicability(CounterLocalServiceUtil.increment());
				setDefaultLeaveTypeApplicability(leaveTypeApplicability);
				leaveTypeApplicability.setCreateDate(new Date());
				setAuditFields(themeDisplay, leaveTypeApplicability);
				leaveTypeApplicability.setLeaveTypeId(leaveType.getLeaveTypeId());
				LeaveTypeApplicabilityLocalServiceUtil.addLeaveTypeApplicability(leaveTypeApplicability);
				// LeaveTypeApplicabilityLocalServiceUtil.a

				// add default recods for 3.restrictions,
				LeaveRestriction leaveRestriction = LeaveRestrictionLocalServiceUtil
						.createLeaveRestriction(CounterLocalServiceUtil.increment());
				setDefaultLeaveRestriction(leaveRestriction);
				leaveRestriction.setCreateDate(new Date());
				setAuditFields(themeDisplay, leaveRestriction);
				leaveRestriction.setLeaveTypeId(leaveType.getLeaveTypeId());
				LeaveRestrictionLocalServiceUtil.addLeaveRestriction(leaveRestriction);

				// add default recods for 5.carry forward rule records
				LeaveCarryForwardPolicy leaveCarryForwardPolicy = LeaveCarryForwardPolicyLocalServiceUtil
						.createLeaveCarryForwardPolicy(CounterLocalServiceUtil.increment());
				setDefaultLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
				leaveCarryForwardPolicy.setCreateDate(new Date());
				setAuditFields(themeDisplay, leaveCarryForwardPolicy);
				leaveCarryForwardPolicy.setLeaveTypeId(leaveType.getLeaveTypeId());
				LeaveCarryForwardPolicyLocalServiceUtil.addLeaveCarryForwardPolicy(leaveCarryForwardPolicy);

				leaveTypeUI.setLeaveTypeId(String.valueOf(leaveType.getLeaveTypeId()));

				log.info("b4 fwding LeaveTypeId == " + leaveTypeUI.getLeaveTypeId());

				List<LeaveType> leaveTypeList = LeaveTypeLocalServiceUtil.getLeaveTypes(0,
						LeaveTypeLocalServiceUtil.getLeaveTypesCount());
				List<com.rknowsys.eapp.ui.LeaveType> leaveTypeListUI = new ArrayList<com.rknowsys.eapp.ui.LeaveType>();
				System.out.println("leaveType count =" + LeaveTypeLocalServiceUtil.getLeaveTypesCount());
				System.out.println("size of list=" + leaveTypeList.size());
				System.out.println(leaveTypeList);
				setLeaveTypeListUI(leaveTypeList, leaveTypeListUI);
				System.out.println(leaveTypeUI);

				actionRequest.setAttribute("leaveTypeList", leaveTypeListUI);
				actionResponse.setRenderParameter("jspPage", "/html/leavetype/list_leave_types.jsp");

				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long leaveTypeId = Long.parseLong(id);

				leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
				setAuditFields(themeDisplay, leaveType);
				setLeaveType(actionRequest, leaveType);
				leaveType = LeaveTypeLocalServiceUtil.updateLeaveType(leaveType);

				log.info("b4 fwding LeaveTypeId == " + leaveTypeUI.getLeaveTypeId());

				List<LeaveType> leaveTypeList = LeaveTypeLocalServiceUtil.getLeaveTypes(0,
						LeaveTypeLocalServiceUtil.getLeaveTypesCount());
				List<com.rknowsys.eapp.ui.LeaveType> leaveTypeListUI = new ArrayList<com.rknowsys.eapp.ui.LeaveType>();
				System.out.println("leaveType count =" + LeaveTypeLocalServiceUtil.getLeaveTypesCount());
				System.out.println("size of list=" + leaveTypeList.size());
				System.out.println(leaveTypeList);
				setLeaveTypeListUI(leaveTypeList, leaveTypeListUI);
				System.out.println(leaveTypeUI);

				actionRequest.setAttribute("leaveTypeList", leaveTypeListUI);
				actionResponse.setRenderParameter("jspPage", "/html/leavetype/list_leave_types.jsp");

				log.info("end of else block");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveContactDetails method");

	}

	private void setDefaultLeaveRule(LeaveRule leaveRule) {

		leaveRule.setIfAdminCanAssign(false);
		leaveRule.setIfAdminCanManageEntitlements(false);
		leaveRule.setIfCarryForwardable(false);
		leaveRule.setIfEmployeesCanApply(false);
		leaveRule.setIfLeaveAccruable(false);
		leaveRule.setLeavePeriodTypeId(0);
	}

	private void initializeLeaveTypeUI(com.rknowsys.eapp.ui.LeaveType leaveTypeUI) throws SystemException {

		leaveTypeUI.setIsSituational("false");
		leaveTypeUI.setNationalityId("-1");
		leaveTypeUI.setLeaveTypeName("");
		// orgCountries=NationalityLocalServiceUtil.getNationalities(organizationId);
		List<Nationality> orgCountries = NationalityLocalServiceUtil.getNationalities(0,
				NationalityLocalServiceUtil.getNationalitiesCount());
		List<IdNamePair> orgCountriesList = new ArrayList<IdNamePair>();
		if (orgCountries != null && orgCountries.size() > 0) {
			for (Nationality orgCountry : orgCountries) {
				orgCountriesList
						.add(new IdNamePair(String.valueOf(orgCountry.getNationalityId()), orgCountry.getName()));
			}
		}
		leaveTypeUI.setOrgCountries(orgCountriesList);

	}

	private void setLeaveType(ActionRequest actionRequest, LeaveType leaveType) throws SystemException {

		System.out.println(ParamUtil.getLong(actionRequest, "nationalityId"));
		leaveType.setNationalityId(ParamUtil.getLong(actionRequest, "nationalityId"));
		leaveType.setLeaveTypeName(ParamUtil.getString(actionRequest, "leaveTypeName"));
		leaveType.setIsSituational(ParamUtil.getBoolean(actionRequest, "isSituational"));
	}

	private void setLeaveRule(ActionRequest actionRequest, LeaveRule leaveRule) throws SystemException {

		int leavePeriodTypeId = ParamUtil.getInteger(actionRequest, "leavePeriodTypeId");
		leaveRule.setLeavePeriodTypeId(leavePeriodTypeId);
		System.out.println("leavePeriodTypeId ="+leavePeriodTypeId);
		if (leavePeriodTypeId == 0) {
			leaveRule.setDuration(null);
			leaveRule.setStartMonth(-1);
			leaveRule.setStartDayOfMonth(0);
		}
		if (leavePeriodTypeId == 1) {
			leaveRule.setDuration(ParamUtil.getString(actionRequest, "duration"));
			leaveRule.setStartMonth(-1);
			leaveRule.setStartDayOfMonth(0);
		}
		if (leavePeriodTypeId == 2) {
			leaveRule.setDuration(null);
			leaveRule.setStartMonth(ParamUtil.getInteger(actionRequest, "startMonth"));
			leaveRule.setStartDayOfMonth(ParamUtil.getInteger(actionRequest, "startDayOfMonth"));
		}

		String ifEmployeesCanApply = ParamUtil.getString(actionRequest, "ifEmployeesCanApply");
		if (ifEmployeesCanApply == null || ifEmployeesCanApply.equals("false")) {
			System.out.println("in if of ifEmployeesCanApply");
			leaveRule.setIfEmployeesCanApply(false);
		} else {
			System.out.println("in else of ifEmployeesCanApply");
			leaveRule.setIfEmployeesCanApply(true);
		}

		String ifAdminCanAssign = ParamUtil.getString(actionRequest, "ifAdminCanAssign");
		if (ifAdminCanAssign == null || ifAdminCanAssign.equals("false")) {
			System.out.println("in if of ifAdminCanAssign");
			leaveRule.setIfAdminCanAssign(false);
		} else {
			System.out.println("in else of ifAdminCanAssign");
			leaveRule.setIfAdminCanAssign(true);
		}

		String ifAdminCanManageEntitlements = ParamUtil.getString(actionRequest, "ifAdminCanManageEntitlements");
		if (ifAdminCanManageEntitlements == null || ifAdminCanManageEntitlements.equals("false")) {
			System.out.println("in if of ifAdminCanManageEntitlements");
			leaveRule.setIfAdminCanManageEntitlements(false);
		} else {
			System.out.println("in else of ifAdminCanManageEntitlements");
			leaveRule.setIfAdminCanManageEntitlements(true);
		}

		String ifLeaveAccruable = ParamUtil.getString(actionRequest, "ifLeaveAccruable");
		if (ifLeaveAccruable == null || ifLeaveAccruable.equals("false")) {
			System.out.println("in if of ifLeaveAccruable");
			leaveRule.setIfLeaveAccruable(false);
		} else {
			System.out.println("in else of ifLeaveAccruable");
			leaveRule.setIfLeaveAccruable(true);
		}

		String ifCarryForwardable = ParamUtil.getString(actionRequest, "ifCarryForwardable");
		if (ifCarryForwardable == null || ifCarryForwardable.equals("false")) {
			System.out.println("in if of ifCarryForwardable");
			leaveRule.setIfCarryForwardable(false);
		} else {
			System.out.println("in else of ifCarryForwardable");
			leaveRule.setIfCarryForwardable(true);
		}
	}

	private void setLeaveRestriction(ActionRequest actionRequest, LeaveRestriction leaveRestriction)
			throws SystemException {

		String cannotExceedBalance = ParamUtil.getString(actionRequest, "cannotExceedBalance");
		if (cannotExceedBalance == null || cannotExceedBalance.equals("false")) {
			System.out.println("in if of cannotExceedBalance");
			leaveRestriction.setCannotExceedBalance(false);
		} else {
			System.out.println("in else of cannotExceedBalance");
			leaveRestriction.setCannotExceedBalance(true);
		}

		String cannotApplyForPartialDay = ParamUtil.getString(actionRequest, "cannotApplyForPartialDay");
		if (cannotApplyForPartialDay == null || cannotApplyForPartialDay.equals("false")) {
			leaveRestriction.setCannotApplyForPartialDay(false);
		} else {
			leaveRestriction.setCannotApplyForPartialDay(true);
		}

		String ifATermsQuestion = ParamUtil.getString(actionRequest, "ifATermsQuestion");
		if (ifATermsQuestion == null || ifATermsQuestion.equals("false")) {
			leaveRestriction.setIfATermsQuestion(false);
		} else {
			leaveRestriction.setIfATermsQuestion(true);
		}

		String isMinimumServicePeriodApplicable = ParamUtil
				.getString(actionRequest, "isMinimumServicePeriodApplicable");
		if (isMinimumServicePeriodApplicable == null || isMinimumServicePeriodApplicable.equals("false")) {
			leaveRestriction.setIsMinimumServicePeriodApplicable(false);
		} else {
			leaveRestriction.setIsMinimumServicePeriodApplicable(true);
		}

		String isMaxConsecutiveLeavesApplicable = ParamUtil
				.getString(actionRequest, "isMaxConsecutiveLeavesApplicable");
		if (isMaxConsecutiveLeavesApplicable == null || isMaxConsecutiveLeavesApplicable.equals("false")) {
			leaveRestriction.setIsMaxConsecutiveLeavesApplicable(false);
		} else {
			leaveRestriction.setIsMaxConsecutiveLeavesApplicable(true);
		}

		String isSmallChildCriterionApplicable = ParamUtil.getString(actionRequest, "isSmallChildCriterionApplicable");
		if (isSmallChildCriterionApplicable == null || isSmallChildCriterionApplicable.equals("false")) {
			leaveRestriction.setIsSmallChildCriterionApplicable(false);
		} else {
			leaveRestriction.setIsSmallChildCriterionApplicable(true);
		}

		leaveRestriction.setTermsQuestion(ParamUtil.getString(actionRequest, "termsQuestion"));
		leaveRestriction.setErrorTextIfTermsDeclined(ParamUtil.getString(actionRequest, "errorTextIfTermsDeclined"));
		leaveRestriction.setMinimumServicePeriod(ParamUtil.getString(actionRequest, "minimumServicePeriod"));
		leaveRestriction.setMaxConsecutiveLeaves(ParamUtil.getString(actionRequest, "maxConsecutiveLeaves"));
		leaveRestriction
				.setMaxSmallChildAgeApplicable(ParamUtil.getString(actionRequest, "maxSmallChildAgeApplicable"));

	}

	private void setAuditFields(ThemeDisplay themeDisplay, LeaveType leaveType) {
		leaveType.setModifiedDate(new Date());
		leaveType.setCompanyId(themeDisplay.getCompanyId());
		leaveType.setGroupId(themeDisplay.getCompanyGroupId());
		leaveType.setUserId(themeDisplay.getUserId());
	}

	private void setAuditFields(ThemeDisplay themeDisplay, LeaveRule leaveRule) {
		leaveRule.setModifiedDate(new Date());
		leaveRule.setCompanyId(themeDisplay.getCompanyId());
		leaveRule.setGroupId(themeDisplay.getCompanyGroupId());
		leaveRule.setUserId(themeDisplay.getUserId());
	}

	/**
	 * <p>
	 * This method deletes the ContactDetails record from database based on
	 * ContactDetails record Id
	 * </p>
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {
		log.info("inside ... serveResource");
		ParamUtil.print(resourceRequest);
		try {
			LeaveTypeLocalServiceUtil.createLeaveType(CounterLocalServiceUtil.increment());
		} catch (SystemException e1) {

			e1.printStackTrace();
		}
        
		String[] idsArray = ParamUtil.getParameterValues(resourceRequest, "leaveTypeIds");

		log.info("idsArray== " + idsArray.length);
		for (int i = 0; i <= idsArray.length - 1; i++) {
			log.info(idsArray[i]);

		}
		for (int i = 0; i <= idsArray.length - 1; i++) {
			log.info(idsArray[i]);
			if (idsArray[i].equals("on")) {
				log.info("All records selected...");
			} else {
				try {
					long leaveTypeId = Long.parseLong(idsArray[i]);

					List<LeaveRule> leaveRules = LeaveRuleLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
					for (LeaveRule leaveRule : leaveRules) {
						LeaveRuleLocalServiceUtil.deleteLeaveRule(leaveRule);
					}

					System.out.println("1");
					List<LeaveTypeApplicability> leaveTypeApplicabilitys = LeaveTypeApplicabilityLocalServiceUtil
							.findByLeaveTypeId(leaveTypeId);
					System.out.println("2");
					for (LeaveTypeApplicability leaveTypeApplicability : leaveTypeApplicabilitys) {
						System.out.println("in delete leaveTypeApplicability  for loop");
						LeaveTypeApplicabilityLocalServiceUtil.deleteLeaveTypeApplicability(leaveTypeApplicability.getLeaveTypeApplicabilityId());
						System.out.println("in delete leaveTypeApplicability  for loop, after deleting");
					}

					List<LeaveRestriction> leaveRestrictions = LeaveRestrictionLocalServiceUtil
							.findByLeaveTypeId(leaveTypeId);
					for (LeaveRestriction leaveRestriction : leaveRestrictions) {
						LeaveRestrictionLocalServiceUtil.deleteLeaveRestriction(leaveRestriction);
					}

					List<LeaveCarryForwardPolicy> leaveCarryForwardPolicys = LeaveCarryForwardPolicyLocalServiceUtil
							.findByLeaveTypeId(leaveTypeId);
					for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : leaveCarryForwardPolicys) {
						LeaveCarryForwardPolicyLocalServiceUtil.deleteLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
					}
					LeaveTypeLocalServiceUtil.deleteLeaveType(LeaveTypeLocalServiceUtil.deleteLeaveType(Long
							.parseLong(idsArray[i])));

					log.info("end of try block in delete...");
				} catch (PortalException e) {

					e.printStackTrace();
					log.info("portal exception...");
				} catch (SystemException e) {

					e.printStackTrace();
					log.info("system exception...");
				}
			}

		}
		log.info("end of for loop..");

		log.info("end of delete method...");

	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		log.info("in doView method");

		List<com.rknowsys.eapp.ui.LeaveType> leaveTypeListUI = new ArrayList<com.rknowsys.eapp.ui.LeaveType>();
		try {
			List<LeaveType> leaveTypeList = LeaveTypeLocalServiceUtil.getLeaveTypes(0,
					LeaveTypeLocalServiceUtil.getLeaveTypesCount());
			System.out.println("leaveType count =" + LeaveTypeLocalServiceUtil.getLeaveTypesCount());
			System.out.println("size of list=" + leaveTypeList.size());
			System.out.println(leaveTypeList);
			setLeaveTypeListUI(leaveTypeList, leaveTypeListUI);

			renderRequest.setAttribute("leaveTypeList", leaveTypeListUI);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	private void setLeaveTypeListUI(List<LeaveType> leaveTypeList, List<com.rknowsys.eapp.ui.LeaveType> leaveTypeListUI)
			throws PortalException, SystemException {

		for (LeaveType leaveType : leaveTypeList) {
			com.rknowsys.eapp.ui.LeaveType leaveTypeUI = new com.rknowsys.eapp.ui.LeaveType();
			setLeaveTypeUI(leaveType, leaveTypeUI);
			leaveTypeListUI.add(leaveTypeUI);
		}
	}

	private void setLeaveTypeUI(LeaveType leaveType, com.rknowsys.eapp.ui.LeaveType leaveTypeUI)
			throws PortalException, SystemException {

		leaveTypeUI.setLeaveTypeId(String.valueOf(leaveType.getLeaveTypeId()));
		leaveTypeUI.setLeaveTypeName(leaveType.getLeaveTypeName());
		leaveTypeUI.setNationalityId(String.valueOf(leaveType.getNationalityId()));
		String isSituational = "false";
		if (leaveType.getIsSituational()) {
			isSituational = "true";
		}
		leaveTypeUI.setIsSituational(isSituational);
		System.out.println("nation id==" + leaveType.getNationalityId());
		leaveTypeUI.setCountryName(NationalityLocalServiceUtil.getNationality(leaveType.getNationalityId()).getName());
		List<Nationality> orgCountries = NationalityLocalServiceUtil.getNationalities(0,
				NationalityLocalServiceUtil.getNationalitiesCount());
		List<IdNamePair> orgCountriesList = new ArrayList<IdNamePair>();
		if (orgCountries != null && orgCountries.size() > 0) {
			for (Nationality orgCountry : orgCountries) {
				orgCountriesList
						.add(new IdNamePair(String.valueOf(orgCountry.getNationalityId()), orgCountry.getName()));
			}
		}
		leaveTypeUI.setOrgCountries(orgCountriesList);
	}

	/**
	 * <p>
	 * This method gets the single ContactDetails record from database based on
	 * the given ContactDetails Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single ContactDetails record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void addEditLeaveType(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside addEditLeaveType...");
		String s = ParamUtil.getString(actionRequest, "leaveTypeId");
		com.rknowsys.eapp.ui.LeaveType leaveTypeUI = new com.rknowsys.eapp.ui.LeaveType();

		if (s == null || s.isEmpty()) {
			initializeLeaveTypeUI(leaveTypeUI);
		} else {
			LeaveType leaveType = LeaveTypeLocalServiceUtil.getLeaveType(Long.parseLong(s));
			setLeaveTypeUI(leaveType, leaveTypeUI);

		}
		log.info("leaveTypeId == " + s);

		log.info(leaveTypeUI.getLeaveTypeName());
		actionRequest.setAttribute("editLeaveType", leaveTypeUI);
		actionResponse.setRenderParameter("jspPage", "/html/leavetype/add_edit_leave_type.jsp");
	}

	public void editLeaveRule(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside editLeaveRule...");
		String s = ParamUtil.getString(actionRequest, "leaveTypeId");
		System.out.println("b4 setting in session, s=" + s);
		actionRequest.getPortletSession().setAttribute(LEAVE_TYPE_ID, Long.parseLong(s));

		com.rknowsys.eapp.ui.LeaveRule leaveRuleUI = new com.rknowsys.eapp.ui.LeaveRule();

		LeaveRule leaveRule = LeaveRuleLocalServiceUtil.findByLeaveTypeId(Long.parseLong(s)).get(0);
		setLeaveRuleUI(leaveRule, leaveRuleUI);

		log.info("leaveRuleId == " + s);

		actionRequest.setAttribute("editLeaveRule", leaveRuleUI);
		actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_rule.jsp");
	}

	public void saveLeaveRule(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside editLeaveRule...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		ParamUtil.print(actionRequest);

		// log.info("leaveRuleId == " + s);

		try {
			String s = ParamUtil.getString(actionRequest, "leaveRuleId");
			com.rknowsys.eapp.ui.LeaveRule leaveRuleUI = new com.rknowsys.eapp.ui.LeaveRule();
			LeaveRule leaveRule = LeaveRuleLocalServiceUtil.getLeaveRule(Long.parseLong(s));
			// LeaveRule leaveRule =
			// LeaveRuleLocalServiceUtil.findByLeaveTypeId(Long.parseLong(s)).get(0);
			// setLeaveRuleUI(leaveRule, leaveRuleUI);
			setAuditFields(themeDisplay, leaveRule);
			setLeaveRule(actionRequest, leaveRule);
			leaveRule = LeaveRuleLocalServiceUtil.updateLeaveRule(leaveRule);
			setLeaveRuleUI(leaveRule, leaveRuleUI);
			log.info("b4 fwding LeaveRuleId == " + leaveRuleUI.getLeaveRuleId());
			actionRequest.setAttribute("editLeaveRule", leaveRuleUI);
			actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_rule.jsp");

			log.info("end of else block");

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveContactDetails method");
	}

	private void setLeaveRuleUI(LeaveRule leaveRule, com.rknowsys.eapp.ui.LeaveRule leaveRuleUI) {
		leaveRuleUI.setDuration(leaveRule.getDuration());

		String ifAdminCanAssign = "false";
		if (leaveRule.getIfAdminCanAssign()) {
			ifAdminCanAssign = "true";
		}
		leaveRuleUI.setIfAdminCanAssign(ifAdminCanAssign);

		String ifCarryForwardable = "false";
		if (leaveRule.getIfCarryForwardable()) {
			ifCarryForwardable = "true";
		}
		leaveRuleUI.setIfCarryForwardable(ifCarryForwardable);

		String ifAdminCanManageEntitlements = "false";
		if (leaveRule.getIfAdminCanManageEntitlements()) {
			ifAdminCanManageEntitlements = "true";
		}
		leaveRuleUI.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);

		String ifEmployeesCanApply = "false";
		if (leaveRule.getIfEmployeesCanApply()) {
			ifEmployeesCanApply = "true";
		}
		leaveRuleUI.setIfEmployeesCanApply(ifEmployeesCanApply);

		String ifLeaveAccruable = "false";
		if (leaveRule.getIfLeaveAccruable()) {
			ifLeaveAccruable = "true";
		}
		leaveRuleUI.setIfLeaveAccruable(ifLeaveAccruable);

		leaveRuleUI.setLeavePeriodType(String.valueOf(leaveRule.getLeavePeriodTypeId()));

		leaveRuleUI.setLeaveRuleId(String.valueOf(leaveRule.getLeaveRuleId()));
		leaveRuleUI.setStartDayOfMonth(String.valueOf(leaveRule.getStartDayOfMonth()));
		leaveRuleUI.setStartMonth(String.valueOf(leaveRule.getStartMonth()));
		leaveRuleUI.setDuration(leaveRule.getDuration());
	}

	private void setAuditFields(ThemeDisplay themeDisplay, LeaveRestriction leaveRestriction) {
		leaveRestriction.setModifiedDate(new Date());
		leaveRestriction.setCompanyId(themeDisplay.getCompanyId());
		leaveRestriction.setGroupId(themeDisplay.getCompanyGroupId());
		leaveRestriction.setUserId(themeDisplay.getUserId());

	}

	private void setDefaultLeaveRestriction(LeaveRestriction leaveRestriction) {
		leaveRestriction.setCannotApplyForPartialDay(false);
		leaveRestriction.setCannotExceedBalance(false);
		leaveRestriction.setIfATermsQuestion(false);
		leaveRestriction.setIsMaxConsecutiveLeavesApplicable(false);
		leaveRestriction.setIsMinimumServicePeriodApplicable(false);
		leaveRestriction.setIsSmallChildCriterionApplicable(false);
	}

	public void editLeaveRestriction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside editLeaveRestriction...");
		// String s = ParamUtil.getString(actionRequest, "leaveTypeId");
		Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
		System.out.println("from session, s = " + s);
		com.rknowsys.eapp.ui.LeaveRestriction leaveRestrictionUI = new com.rknowsys.eapp.ui.LeaveRestriction();

		LeaveRestriction leaveRestriction = LeaveRestrictionLocalServiceUtil.findByLeaveTypeId(s).get(0);
		setLeaveRestrictionUI(leaveRestriction, leaveRestrictionUI);

		log.info("leaveRestrictionId == " + s);

		actionRequest.setAttribute("editLeaveRestriction", leaveRestrictionUI);
		actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_restriction.jsp");
	}

	public void saveLeaveRestriction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside saveLeaveRestriction...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		ParamUtil.print(actionRequest);

		// log.info("leaveRuleId == " + s);

		try {

			Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
			System.out.println("from session, s = " + s);
			com.rknowsys.eapp.ui.LeaveRestriction leaveRestrictionUI = new com.rknowsys.eapp.ui.LeaveRestriction();

			LeaveRestriction leaveRestriction = LeaveRestrictionLocalServiceUtil.findByLeaveTypeId(s).get(0);
			// String s = ParamUtil.getString(actionRequest,
			// "leaveRestrictionId");
			// com.rknowsys.eapp.ui.LeaveRestriction leaveRestrictionUI = new
			// com.rknowsys.eapp.ui.LeaveRestriction();
			// LeaveRestriction leaveRestriction =
			// LeaveRestrictionLocalServiceUtil.getLeaveRestriction(Long.parseLong(s));
			setAuditFields(themeDisplay, leaveRestriction);
			setLeaveRestriction(actionRequest, leaveRestriction);
			leaveRestriction = LeaveRestrictionLocalServiceUtil.updateLeaveRestriction(leaveRestriction);
			setLeaveRestrictionUI(leaveRestriction, leaveRestrictionUI);
			log.info("b4 fwding LeaveRestrictionId == " + leaveRestrictionUI.getLeaveRestrictionId());
			actionRequest.setAttribute("editLeaveRestriction", leaveRestrictionUI);
			actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_restriction.jsp");

			log.info("end of else block");

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		}
		log.info("end of the saveContactDetails method");
	}

	private void setLeaveRestrictionUI(LeaveRestriction leaveRestriction,
			com.rknowsys.eapp.ui.LeaveRestriction leaveRestrictionUI) {

		leaveRestrictionUI.setTermsQuestion(leaveRestriction.getTermsQuestion());
		leaveRestrictionUI.setErrorTextIfTermsDeclined(leaveRestriction.getErrorTextIfTermsDeclined());
		leaveRestrictionUI.setMaxConsecutiveLeaves(leaveRestriction.getMaxConsecutiveLeaves());
		leaveRestrictionUI.setMaxSmallChildAgeApplicable(leaveRestriction.getMaxSmallChildAgeApplicable());
		leaveRestrictionUI.setMinimumServicePeriod(leaveRestriction.getMinimumServicePeriod());

		String cannotApplyForPartialDay = "false";
		if (leaveRestriction.getCannotApplyForPartialDay()) {
			cannotApplyForPartialDay = "true";
		}
		leaveRestrictionUI.setCannotApplyForPartialDay(cannotApplyForPartialDay);

		String cannotExceedBalance = "false";
		if (leaveRestriction.getCannotExceedBalance()) {
			cannotExceedBalance = "true";
		}
		leaveRestrictionUI.setCannotExceedBalance(cannotExceedBalance);

		String ifATermsQuestion = "false";
		if (leaveRestriction.getIfATermsQuestion()) {
			ifATermsQuestion = "true";
		}
		leaveRestrictionUI.setIfATermsQuestion(ifATermsQuestion);

		String isMinimumServicePeriodApplicable = "false";
		if (leaveRestriction.getIsMinimumServicePeriodApplicable()) {
			isMinimumServicePeriodApplicable = "true";
		}
		leaveRestrictionUI.setIsMinimumServicePeriodApplicable(isMinimumServicePeriodApplicable);

		String isMaxConsecutiveLeavesApplicable = "false";
		if (leaveRestriction.getIsMaxConsecutiveLeavesApplicable()) {
			isMaxConsecutiveLeavesApplicable = "true";
		}
		leaveRestrictionUI.setIsMaxConsecutiveLeavesApplicable(isMaxConsecutiveLeavesApplicable);

		String isSmallChildCriterionApplicable = "false";
		if (leaveRestriction.getIsSmallChildCriterionApplicable()) {
			isSmallChildCriterionApplicable = "true";
		}
		leaveRestrictionUI.setIsSmallChildCriterionApplicable(isSmallChildCriterionApplicable);

	}

	private void setAuditFields(ThemeDisplay themeDisplay, LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		leaveCarryForwardPolicy.setModifiedDate(new Date());
		leaveCarryForwardPolicy.setCompanyId(themeDisplay.getCompanyId());
		leaveCarryForwardPolicy.setGroupId(themeDisplay.getCompanyGroupId());
		leaveCarryForwardPolicy.setUserId(themeDisplay.getUserId());

	}

	private void setDefaultLeaveCarryForwardPolicy(LeaveCarryForwardPolicy leaveCarryForwardPolicy) {

		leaveCarryForwardPolicy.setIsMaxCarryForwardLimitApplicable(true);
	}

	public void editLeaveCarryForwardPolicy(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside editLeaveCarryForwardPolicy...");
		Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
		System.out.println("from session, s = " + s);
		com.rknowsys.eapp.ui.LeaveCarryForwardPolicy leaveCarryForwardPolicyUI = new com.rknowsys.eapp.ui.LeaveCarryForwardPolicy();
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = LeaveCarryForwardPolicyLocalServiceUtil.findByLeaveTypeId(s)
				.get(0);
		setLeaveCarryForwardPolicyUI(leaveCarryForwardPolicy, leaveCarryForwardPolicyUI);

		log.info("leaveCarryForwardPolicyId == " + s);

		actionRequest.setAttribute("editLeaveCarryForwardPolicy", leaveCarryForwardPolicyUI);
		actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_carry_forward_policy.jsp");
	}

	public void saveLeaveCarryForwardPolicy(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside saveLeaveCarryForwardPolicy...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		ParamUtil.print(actionRequest);

		// log.info("leaveRuleId == " + s);

		try {
			// String s = ParamUtil.getString(actionRequest,
			// "leaveCarryForwardPolicyId");
			// com.rknowsys.eapp.ui.LeaveCarryForwardPolicy
			// leaveCarryForwardPolicyUI = new
			// com.rknowsys.eapp.ui.LeaveCarryForwardPolicy();
			// LeaveCarryForwardPolicy leaveCarryForwardPolicy =
			// LeaveCarryForwardPolicyLocalServiceUtil
			// .getLeaveCarryForwardPolicy(Long.parseLong(s));

			Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
			System.out.println("from session, s = " + s);
			com.rknowsys.eapp.ui.LeaveCarryForwardPolicy leaveCarryForwardPolicyUI = new com.rknowsys.eapp.ui.LeaveCarryForwardPolicy();

			System.out.println("count of leave restriction recs = "
					+ LeaveCarryForwardPolicyLocalServiceUtil.findByLeaveTypeId(s).size());
			List<LeaveCarryForwardPolicy> listing = LeaveCarryForwardPolicyLocalServiceUtil.findByLeaveTypeId(s);
			for (LeaveCarryForwardPolicy one : listing) {
				System.out.println(one);
			}

			LeaveCarryForwardPolicy leaveCarryForwardPolicy = LeaveCarryForwardPolicyLocalServiceUtil
					.findByLeaveTypeId(s).get(0);
			setAuditFields(themeDisplay, leaveCarryForwardPolicy);
			setLeaveCarryForwardPolicy(actionRequest, leaveCarryForwardPolicy);
			leaveCarryForwardPolicy = LeaveCarryForwardPolicyLocalServiceUtil
					.updateLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
			setLeaveCarryForwardPolicyUI(leaveCarryForwardPolicy, leaveCarryForwardPolicyUI);
			log.info("b4 fwding LeaveCarryForwardPolicyId == "
					+ leaveCarryForwardPolicyUI.getLeaveCarryForwardPolicyId());
			actionRequest.setAttribute("editLeaveCarryForwardPolicy", leaveCarryForwardPolicyUI);
			actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_carry_forward_policy.jsp");

			log.info("end of else block");

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		}
		log.info("end of the saveContactDetails method");
	}

	private void setLeaveCarryForwardPolicyUI(LeaveCarryForwardPolicy leaveCarryForwardPolicy,
			com.rknowsys.eapp.ui.LeaveCarryForwardPolicy leaveCarryForwardPolicyUI) {

		leaveCarryForwardPolicyUI.setExpiryDuration(String.valueOf(leaveCarryForwardPolicy.getExpiryDuration()));
		leaveCarryForwardPolicyUI.setExpiryDurationUOM(leaveCarryForwardPolicy.getExpiryDurationUOM());

		String isMaxCarryForwardLimitApplicable = "false";
		if (leaveCarryForwardPolicy.getIsMaxCarryForwardLimitApplicable()) {
			isMaxCarryForwardLimitApplicable = "true";
		}
		leaveCarryForwardPolicyUI.setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);

		leaveCarryForwardPolicyUI.setMaxCarryForwardLimit(leaveCarryForwardPolicy.getMaxCarryForwardLimit());
	}

	private void setLeaveCarryForwardPolicy(ActionRequest actionRequest, LeaveCarryForwardPolicy leaveCarryForwardPolicy)
			throws SystemException {

		leaveCarryForwardPolicy.setExpiryDuration(ParamUtil.getInteger(actionRequest, "expiryDuration"));
		leaveCarryForwardPolicy.setExpiryDurationUOM(ParamUtil.getString(actionRequest, "expiryDurationUOM"));

		String isMaxCarryForwardLimitApplicable = ParamUtil
				.getString(actionRequest, "isMaxCarryForwardLimitApplicable");
		if (isMaxCarryForwardLimitApplicable == null || isMaxCarryForwardLimitApplicable.equals("false")) {
			leaveCarryForwardPolicy.setIsMaxCarryForwardLimitApplicable(false);
			leaveCarryForwardPolicy.setMaxCarryForwardLimit(null);
		} else {
			leaveCarryForwardPolicy.setIsMaxCarryForwardLimitApplicable(true);
			leaveCarryForwardPolicy.setMaxCarryForwardLimit(ParamUtil.getString(actionRequest, "maxCarryForwardLimit"));
		}
	}

	private void setAuditFields(ThemeDisplay themeDisplay, LeaveTypeApplicability leaveTypeApplicability) {
		leaveTypeApplicability.setModifiedDate(new Date());
		leaveTypeApplicability.setCompanyId(themeDisplay.getCompanyId());
		leaveTypeApplicability.setGroupId(themeDisplay.getCompanyGroupId());
		leaveTypeApplicability.setUserId(themeDisplay.getUserId());

	}

	private void setDefaultLeaveTypeApplicability(LeaveTypeApplicability leaveTypeApplicability) {
		leaveTypeApplicability.setIfYearsOfServiceCriterionApplicable(false);
	}

	public void editLeaveTypeApplicability(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside editTypeApplicability...");
		Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
		System.out.println("from session, s = " + s);
		com.rknowsys.eapp.ui.LeaveTypeApplicability leaveTypeApplicabilityUI = new com.rknowsys.eapp.ui.LeaveTypeApplicability();
		LeaveTypeApplicability leaveTypeApplicability = LeaveTypeApplicabilityLocalServiceUtil.findByLeaveTypeId(s)
				.get(0);
		setLeaveTypeApplicabilityUI(leaveTypeApplicability, leaveTypeApplicabilityUI);
		System.out.println(leaveTypeApplicabilityUI);
		log.info("leaveTypeApplicabilityId == " + s);

		actionRequest.setAttribute("editLeaveTypeApplicability", leaveTypeApplicabilityUI);
		actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_type_applicability.jsp");
	}

	public void saveLeaveTypeApplicability(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside saveTypeApplicability...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// log.info("company Id == " + themeDisplay.getCompanyId());
		// log.info("userId = " + themeDisplay.getUserId());
		// log.info("groupId = " + themeDisplay.getCompanyGroupId());
		ParamUtil.print(actionRequest);
		System.out.println("after params");
		// log.info("leaveRuleId == " + s);

		try {

			String[] aaa = ParamUtil.getParameterValues(actionRequest, "jobTitleId");
			System.out.println(Arrays.asList(aaa));

			Long s = (Long) actionRequest.getPortletSession().getAttribute(LEAVE_TYPE_ID);
			System.out.println("from session, s = " + s);
			com.rknowsys.eapp.ui.LeaveTypeApplicability leaveTypeApplicabilityUI = new com.rknowsys.eapp.ui.LeaveTypeApplicability();

			System.out.println("count of leave TypeApplicability recs = "
					+ LeaveTypeApplicabilityLocalServiceUtil.findByLeaveTypeId(s).size());
			List<LeaveTypeApplicability> listing = LeaveTypeApplicabilityLocalServiceUtil.findByLeaveTypeId(s);
			for (LeaveTypeApplicability one : listing) {
				System.out.println(one);
			}

			LeaveTypeApplicability leaveTypeApplicability = LeaveTypeApplicabilityLocalServiceUtil.findByLeaveTypeId(s)
					.get(0);
			setAuditFields(themeDisplay, leaveTypeApplicability);
			setLeaveTypeApplicability(actionRequest, leaveTypeApplicability);
			leaveTypeApplicability = LeaveTypeApplicabilityLocalServiceUtil
					.updateLeaveTypeApplicability(leaveTypeApplicability);

			setLinkages(actionRequest, leaveTypeApplicability);

			setLeaveTypeApplicabilityUI(leaveTypeApplicability, leaveTypeApplicabilityUI);
			System.out.println(leaveTypeApplicabilityUI);
			log.info("b4 fwding LeaveTypeApplicabilityId == " + leaveTypeApplicabilityUI.getLeaveTypeApplicabilityId());
			actionRequest.setAttribute("editLeaveTypeApplicability", leaveTypeApplicabilityUI);
			// actionResponse.setRenderParameter("jspPage",
			// "/html/leavetype/edit_type_applicability.jsp");
			actionResponse.setRenderParameter("jspPage", "/html/leavetype/edit_leave_type_applicability.jsp");
			log.info("end of else block");

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		}
		log.info("end of the saveContactDetails method");
	}

	private void setLinkages(ActionRequest actionRequest, LeaveTypeApplicability leaveTypeApplicability)
			throws SystemException {
		String[] jobTitleIds = ParamUtil.getParameterValues(actionRequest, "jobTitleId");
		String[] empStatuses = ParamUtil.getParameterValues(actionRequest, "employmentStatusId");
		List<Long> jobTitleIdsList = new ArrayList<Long>();
		List<Long> empStatusesList = new ArrayList<Long>();
		for (String jobTitleId : jobTitleIds) {
			if (!jobTitleId.equals("false")) {
				jobTitleIdsList.add(Long.parseLong(jobTitleId));
			}
		}
		for (String empStatus : empStatuses) {
			if (!empStatus.equals("false")) {
				empStatusesList.add(Long.parseLong(empStatus));
			}
		}

		long[] jobTitleIdsPList = new long[jobTitleIdsList.size()];
		long[] empStatusesPList = new long[empStatusesList.size()];
		int i = 0;
		for (Long jobTitleId : jobTitleIdsList) {
			jobTitleIdsPList[i] = jobTitleId.longValue();
			i++;
		}

		int j = 0;
		for (Long empStatus : empStatusesList) {
			empStatusesPList[j] = empStatus.longValue();
			j++;
		}
		JobTitleLocalServiceUtil.setLeaveTypeApplicabilityJobTitles(
				leaveTypeApplicability.getLeaveTypeApplicabilityId(), jobTitleIdsPList);
		EmploymentStatusLocalServiceUtil.setLeaveTypeApplicabilityEmploymentStatuses(
				leaveTypeApplicability.getLeaveTypeApplicabilityId(), empStatusesPList);
	}

	private void setLeaveTypeApplicabilityUI(LeaveTypeApplicability leaveTypeApplicability,
			com.rknowsys.eapp.ui.LeaveTypeApplicability leaveTypeApplicabilityUI) throws SystemException {

		List<JobTitle> jobTitles = JobTitleLocalServiceUtil.getJobTitles(0,
				JobTitleLocalServiceUtil.getJobTitlesCount());

		List<IdNamePair> jobTitlesList = new ArrayList<IdNamePair>();
		for (JobTitle jobTitle : jobTitles) {
			jobTitlesList.add(new IdNamePair(String.valueOf(jobTitle.getJobTitleId()), jobTitle.getTitle()));
		}
		leaveTypeApplicabilityUI.setJobTitles(jobTitlesList);

		List<JobTitle> jTitles = JobTitleLocalServiceUtil.getLeaveTypeApplicabilityJobTitles(leaveTypeApplicability
				.getLeaveTypeApplicabilityId());
		List<IdNamePair> applicableToJobTitles = new ArrayList<IdNamePair>();
		boolean matchFound = false;
		for (JobTitle jobTitle : jobTitles) {
			if (jTitles != null && jTitles.size() > 0) {
				for (JobTitle jTitle : jTitles) {
					matchFound = false;
					if (jTitle.getJobTitleId() == jobTitle.getJobTitleId()) {
						matchFound = true;
						break;
					}
				}
				if (matchFound) {
					applicableToJobTitles.add(new IdNamePair(String.valueOf(jobTitle.getJobTitleId()), Boolean.TRUE
							.toString()));
				} else {
					applicableToJobTitles.add(new IdNamePair(String.valueOf(jobTitle.getJobTitleId()), Boolean.FALSE
							.toString()));
				}
			} else {
				applicableToJobTitles.add(new IdNamePair(String.valueOf(jobTitle.getJobTitleId()), Boolean.FALSE
						.toString()));
			}

		}
		leaveTypeApplicabilityUI.setApplicableToJobTitles(applicableToJobTitles);

		List<EmploymentStatus> employmentStatuses = EmploymentStatusLocalServiceUtil.getEmploymentStatuses(0,
				EmploymentStatusLocalServiceUtil.getEmploymentStatusesCount());

		List<IdNamePair> employmentStatusesList = new ArrayList<IdNamePair>();
		for (EmploymentStatus employmentStatus : employmentStatuses) {
			employmentStatusesList.add(new IdNamePair(String.valueOf(employmentStatus.getEmploymentStatusId()),
					employmentStatus.getEmploymentstatus()));
		}
		leaveTypeApplicabilityUI.setEmploymentStatuses(employmentStatusesList);

		List<EmploymentStatus> eStatuses = EmploymentStatusLocalServiceUtil
				.getLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicability.getLeaveTypeApplicabilityId());
		List<IdNamePair> applicableToEmploymentStatuses = new ArrayList<IdNamePair>();
		matchFound = false;
		for (EmploymentStatus employmentStatus : employmentStatuses) {
			if (eStatuses != null && eStatuses.size() > 0) {
				for (EmploymentStatus eStatus : eStatuses) {
					matchFound = false;
					if (eStatus.getEmploymentStatusId() == employmentStatus.getEmploymentStatusId()) {
						matchFound = true;
						break;
					}
				}
				if (matchFound) {
					applicableToEmploymentStatuses.add(new IdNamePair(String.valueOf(employmentStatus
							.getEmploymentStatusId()), Boolean.TRUE.toString()));
				} else {
					applicableToEmploymentStatuses.add(new IdNamePair(String.valueOf(employmentStatus
							.getEmploymentStatusId()), Boolean.FALSE.toString()));
				}
			} else {
				applicableToEmploymentStatuses.add(new IdNamePair(String.valueOf(employmentStatus
						.getEmploymentStatusId()), Boolean.FALSE.toString()));
			}
		}

		leaveTypeApplicabilityUI.setApplicableToEmploymentStatuses(applicableToEmploymentStatuses);

		String ifYearsOfServiceCriterionApplicable = "false";
		if (leaveTypeApplicability.getIfYearsOfServiceCriterionApplicable()) {
			ifYearsOfServiceCriterionApplicable = "true";
		}
		leaveTypeApplicabilityUI.setIfYearsOfServiceCriterionApplicable(ifYearsOfServiceCriterionApplicable);

		leaveTypeApplicabilityUI.setMaxYearsOfService(leaveTypeApplicability.getMaxYearsOfService());
		leaveTypeApplicabilityUI.setMinYearsOfService(leaveTypeApplicability.getMinYearsOfService());

	}

	private void setLeaveTypeApplicability(ActionRequest actionRequest, LeaveTypeApplicability leaveTypeApplicability)
			throws SystemException {

		// leaveTypeApplicability.set
		// .setExpiryDuration(ParamUtil.getInteger(actionRequest,
		// "expiryDuration"));

		String ifYearsOfServiceCriterionApplicable = ParamUtil.getString(actionRequest,
				"ifYearsOfServiceCriterionApplicable");
		if (ifYearsOfServiceCriterionApplicable == null || ifYearsOfServiceCriterionApplicable.equals("false")) {
			leaveTypeApplicability.setIfYearsOfServiceCriterionApplicable(false);
			leaveTypeApplicability.setMinYearsOfService(null);
			leaveTypeApplicability.setMaxYearsOfService(null);
		} else {
			leaveTypeApplicability.setIfYearsOfServiceCriterionApplicable(true);
			leaveTypeApplicability.setMinYearsOfService(ParamUtil.getString(actionRequest, "minYearsOfService"));
			leaveTypeApplicability.setMaxYearsOfService(ParamUtil.getString(actionRequest, "maxYearsOfService"));
		}
		//
		// leaveCarryForwardPolicy.setMaxCarryForwardLimit(ParamUtil.getString(actionRequest,
		// "maxCarryForwardLimit"));

	}

}
