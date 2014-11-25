/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.rknowsys.eapp.hrm.model.DocCategoryClp;
import com.rknowsys.eapp.hrm.model.EducationClp;
import com.rknowsys.eapp.hrm.model.EmpAttachmentClp;
import com.rknowsys.eapp.hrm.model.EmpContactDetailsClp;
import com.rknowsys.eapp.hrm.model.EmpDependentClp;
import com.rknowsys.eapp.hrm.model.EmpDetailsClp;
import com.rknowsys.eapp.hrm.model.EmpDirectDepositClp;
import com.rknowsys.eapp.hrm.model.EmpEducationClp;
import com.rknowsys.eapp.hrm.model.EmpEmergencyContactClp;
import com.rknowsys.eapp.hrm.model.EmpImmigrationDocumentClp;
import com.rknowsys.eapp.hrm.model.EmpJobClp;
import com.rknowsys.eapp.hrm.model.EmpLanguageClp;
import com.rknowsys.eapp.hrm.model.EmpLicenseClp;
import com.rknowsys.eapp.hrm.model.EmpMembershipClp;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetailsClp;
import com.rknowsys.eapp.hrm.model.EmpSalaryClp;
import com.rknowsys.eapp.hrm.model.EmpSalaryComponentClp;
import com.rknowsys.eapp.hrm.model.EmpSkillClp;
import com.rknowsys.eapp.hrm.model.EmpSubordinateClp;
import com.rknowsys.eapp.hrm.model.EmpSupervisorClp;
import com.rknowsys.eapp.hrm.model.EmpWorkExpClp;
import com.rknowsys.eapp.hrm.model.EmployeeClp;
import com.rknowsys.eapp.hrm.model.EmploymentStatusClp;
import com.rknowsys.eapp.hrm.model.HolidayClp;
import com.rknowsys.eapp.hrm.model.InterviewClp;
import com.rknowsys.eapp.hrm.model.JobCategoryClp;
import com.rknowsys.eapp.hrm.model.JobTitleClp;
import com.rknowsys.eapp.hrm.model.LanguageClp;
import com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicyClp;
import com.rknowsys.eapp.hrm.model.LeavePeriodClp;
import com.rknowsys.eapp.hrm.model.LeaveRestrictionClp;
import com.rknowsys.eapp.hrm.model.LeaveRuleClp;
import com.rknowsys.eapp.hrm.model.LeaveTypeApplicabilityClp;
import com.rknowsys.eapp.hrm.model.LeaveTypeClp;
import com.rknowsys.eapp.hrm.model.LicenseClp;
import com.rknowsys.eapp.hrm.model.LocationClp;
import com.rknowsys.eapp.hrm.model.MembershipClp;
import com.rknowsys.eapp.hrm.model.NationalityClp;
import com.rknowsys.eapp.hrm.model.NewsClp;
import com.rknowsys.eapp.hrm.model.OrganizationClp;
import com.rknowsys.eapp.hrm.model.PayGradeClp;
import com.rknowsys.eapp.hrm.model.PayGradeCurrencyClp;
import com.rknowsys.eapp.hrm.model.ReportingMethodsClp;
import com.rknowsys.eapp.hrm.model.SalaryComponentClp;
import com.rknowsys.eapp.hrm.model.SkillClp;
import com.rknowsys.eapp.hrm.model.SubUnitClp;
import com.rknowsys.eapp.hrm.model.TerminationReasonsClp;
import com.rknowsys.eapp.hrm.model.WorkWeekClp;
import com.rknowsys.eapp.hrm.model.WorkshiftClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rknowsys
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"services-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"services-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "services-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DocCategoryClp.class.getName())) {
			return translateInputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(EducationClp.class.getName())) {
			return translateInputEducation(oldModel);
		}

		if (oldModelClassName.equals(EmpAttachmentClp.class.getName())) {
			return translateInputEmpAttachment(oldModel);
		}

		if (oldModelClassName.equals(EmpContactDetailsClp.class.getName())) {
			return translateInputEmpContactDetails(oldModel);
		}

		if (oldModelClassName.equals(EmpDependentClp.class.getName())) {
			return translateInputEmpDependent(oldModel);
		}

		if (oldModelClassName.equals(EmpDetailsClp.class.getName())) {
			return translateInputEmpDetails(oldModel);
		}

		if (oldModelClassName.equals(EmpDirectDepositClp.class.getName())) {
			return translateInputEmpDirectDeposit(oldModel);
		}

		if (oldModelClassName.equals(EmpEducationClp.class.getName())) {
			return translateInputEmpEducation(oldModel);
		}

		if (oldModelClassName.equals(EmpEmergencyContactClp.class.getName())) {
			return translateInputEmpEmergencyContact(oldModel);
		}

		if (oldModelClassName.equals(EmpImmigrationDocumentClp.class.getName())) {
			return translateInputEmpImmigrationDocument(oldModel);
		}

		if (oldModelClassName.equals(EmpJobClp.class.getName())) {
			return translateInputEmpJob(oldModel);
		}

		if (oldModelClassName.equals(EmpLanguageClp.class.getName())) {
			return translateInputEmpLanguage(oldModel);
		}

		if (oldModelClassName.equals(EmpLicenseClp.class.getName())) {
			return translateInputEmpLicense(oldModel);
		}

		if (oldModelClassName.equals(EmployeeClp.class.getName())) {
			return translateInputEmployee(oldModel);
		}

		if (oldModelClassName.equals(EmploymentStatusClp.class.getName())) {
			return translateInputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(EmpMembershipClp.class.getName())) {
			return translateInputEmpMembership(oldModel);
		}

		if (oldModelClassName.equals(EmpPersonalDetailsClp.class.getName())) {
			return translateInputEmpPersonalDetails(oldModel);
		}

		if (oldModelClassName.equals(EmpSalaryClp.class.getName())) {
			return translateInputEmpSalary(oldModel);
		}

		if (oldModelClassName.equals(EmpSalaryComponentClp.class.getName())) {
			return translateInputEmpSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(EmpSkillClp.class.getName())) {
			return translateInputEmpSkill(oldModel);
		}

		if (oldModelClassName.equals(EmpSubordinateClp.class.getName())) {
			return translateInputEmpSubordinate(oldModel);
		}

		if (oldModelClassName.equals(EmpSupervisorClp.class.getName())) {
			return translateInputEmpSupervisor(oldModel);
		}

		if (oldModelClassName.equals(EmpWorkExpClp.class.getName())) {
			return translateInputEmpWorkExp(oldModel);
		}

		if (oldModelClassName.equals(HolidayClp.class.getName())) {
			return translateInputHoliday(oldModel);
		}

		if (oldModelClassName.equals(InterviewClp.class.getName())) {
			return translateInputInterview(oldModel);
		}

		if (oldModelClassName.equals(JobCategoryClp.class.getName())) {
			return translateInputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(JobTitleClp.class.getName())) {
			return translateInputJobTitle(oldModel);
		}

		if (oldModelClassName.equals(LanguageClp.class.getName())) {
			return translateInputLanguage(oldModel);
		}

		if (oldModelClassName.equals(LeaveCarryForwardPolicyClp.class.getName())) {
			return translateInputLeaveCarryForwardPolicy(oldModel);
		}

		if (oldModelClassName.equals(LeavePeriodClp.class.getName())) {
			return translateInputLeavePeriod(oldModel);
		}

		if (oldModelClassName.equals(LeaveRestrictionClp.class.getName())) {
			return translateInputLeaveRestriction(oldModel);
		}

		if (oldModelClassName.equals(LeaveRuleClp.class.getName())) {
			return translateInputLeaveRule(oldModel);
		}

		if (oldModelClassName.equals(LeaveTypeClp.class.getName())) {
			return translateInputLeaveType(oldModel);
		}

		if (oldModelClassName.equals(LeaveTypeApplicabilityClp.class.getName())) {
			return translateInputLeaveTypeApplicability(oldModel);
		}

		if (oldModelClassName.equals(LicenseClp.class.getName())) {
			return translateInputLicense(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
		}

		if (oldModelClassName.equals(MembershipClp.class.getName())) {
			return translateInputMembership(oldModel);
		}

		if (oldModelClassName.equals(NationalityClp.class.getName())) {
			return translateInputNationality(oldModel);
		}

		if (oldModelClassName.equals(NewsClp.class.getName())) {
			return translateInputNews(oldModel);
		}

		if (oldModelClassName.equals(OrganizationClp.class.getName())) {
			return translateInputOrganization(oldModel);
		}

		if (oldModelClassName.equals(PayGradeClp.class.getName())) {
			return translateInputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(PayGradeCurrencyClp.class.getName())) {
			return translateInputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(ReportingMethodsClp.class.getName())) {
			return translateInputReportingMethods(oldModel);
		}

		if (oldModelClassName.equals(SalaryComponentClp.class.getName())) {
			return translateInputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(SkillClp.class.getName())) {
			return translateInputSkill(oldModel);
		}

		if (oldModelClassName.equals(SubUnitClp.class.getName())) {
			return translateInputSubUnit(oldModel);
		}

		if (oldModelClassName.equals(TerminationReasonsClp.class.getName())) {
			return translateInputTerminationReasons(oldModel);
		}

		if (oldModelClassName.equals(WorkshiftClp.class.getName())) {
			return translateInputWorkshift(oldModel);
		}

		if (oldModelClassName.equals(WorkWeekClp.class.getName())) {
			return translateInputWorkWeek(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp oldClpModel = (DocCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEducation(BaseModel<?> oldModel) {
		EducationClp oldClpModel = (EducationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEducationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpAttachment(BaseModel<?> oldModel) {
		EmpAttachmentClp oldClpModel = (EmpAttachmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpAttachmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpContactDetails(BaseModel<?> oldModel) {
		EmpContactDetailsClp oldClpModel = (EmpContactDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpContactDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpDependent(BaseModel<?> oldModel) {
		EmpDependentClp oldClpModel = (EmpDependentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpDependentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpDetails(BaseModel<?> oldModel) {
		EmpDetailsClp oldClpModel = (EmpDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpDirectDeposit(BaseModel<?> oldModel) {
		EmpDirectDepositClp oldClpModel = (EmpDirectDepositClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpDirectDepositRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpEducation(BaseModel<?> oldModel) {
		EmpEducationClp oldClpModel = (EmpEducationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpEducationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpEmergencyContact(
		BaseModel<?> oldModel) {
		EmpEmergencyContactClp oldClpModel = (EmpEmergencyContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpEmergencyContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpImmigrationDocument(
		BaseModel<?> oldModel) {
		EmpImmigrationDocumentClp oldClpModel = (EmpImmigrationDocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpImmigrationDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpJob(BaseModel<?> oldModel) {
		EmpJobClp oldClpModel = (EmpJobClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpJobRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpLanguage(BaseModel<?> oldModel) {
		EmpLanguageClp oldClpModel = (EmpLanguageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpLanguageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpLicense(BaseModel<?> oldModel) {
		EmpLicenseClp oldClpModel = (EmpLicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmployee(BaseModel<?> oldModel) {
		EmployeeClp oldClpModel = (EmployeeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp oldClpModel = (EmploymentStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmploymentStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpMembership(BaseModel<?> oldModel) {
		EmpMembershipClp oldClpModel = (EmpMembershipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpMembershipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpPersonalDetails(BaseModel<?> oldModel) {
		EmpPersonalDetailsClp oldClpModel = (EmpPersonalDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpPersonalDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpSalary(BaseModel<?> oldModel) {
		EmpSalaryClp oldClpModel = (EmpSalaryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpSalaryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpSalaryComponent(BaseModel<?> oldModel) {
		EmpSalaryComponentClp oldClpModel = (EmpSalaryComponentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpSalaryComponentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpSkill(BaseModel<?> oldModel) {
		EmpSkillClp oldClpModel = (EmpSkillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpSkillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpSubordinate(BaseModel<?> oldModel) {
		EmpSubordinateClp oldClpModel = (EmpSubordinateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpSubordinateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpSupervisor(BaseModel<?> oldModel) {
		EmpSupervisorClp oldClpModel = (EmpSupervisorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpSupervisorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpWorkExp(BaseModel<?> oldModel) {
		EmpWorkExpClp oldClpModel = (EmpWorkExpClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpWorkExpRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHoliday(BaseModel<?> oldModel) {
		HolidayClp oldClpModel = (HolidayClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHolidayRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInterview(BaseModel<?> oldModel) {
		InterviewClp oldClpModel = (InterviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInterviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp oldClpModel = (JobCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobTitle(BaseModel<?> oldModel) {
		JobTitleClp oldClpModel = (JobTitleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobTitleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLanguage(BaseModel<?> oldModel) {
		LanguageClp oldClpModel = (LanguageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLanguageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveCarryForwardPolicy(
		BaseModel<?> oldModel) {
		LeaveCarryForwardPolicyClp oldClpModel = (LeaveCarryForwardPolicyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveCarryForwardPolicyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeavePeriod(BaseModel<?> oldModel) {
		LeavePeriodClp oldClpModel = (LeavePeriodClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeavePeriodRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveRestriction(BaseModel<?> oldModel) {
		LeaveRestrictionClp oldClpModel = (LeaveRestrictionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveRestrictionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveRule(BaseModel<?> oldModel) {
		LeaveRuleClp oldClpModel = (LeaveRuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveRuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveType(BaseModel<?> oldModel) {
		LeaveTypeClp oldClpModel = (LeaveTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaveTypeApplicability(
		BaseModel<?> oldModel) {
		LeaveTypeApplicabilityClp oldClpModel = (LeaveTypeApplicabilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaveTypeApplicabilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLicense(BaseModel<?> oldModel) {
		LicenseClp oldClpModel = (LicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocation(BaseModel<?> oldModel) {
		LocationClp oldClpModel = (LocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembership(BaseModel<?> oldModel) {
		MembershipClp oldClpModel = (MembershipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNationality(BaseModel<?> oldModel) {
		NationalityClp oldClpModel = (NationalityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNationalityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNews(BaseModel<?> oldModel) {
		NewsClp oldClpModel = (NewsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNewsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganization(BaseModel<?> oldModel) {
		OrganizationClp oldClpModel = (OrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp oldClpModel = (PayGradeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp oldClpModel = (PayGradeCurrencyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeCurrencyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReportingMethods(BaseModel<?> oldModel) {
		ReportingMethodsClp oldClpModel = (ReportingMethodsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReportingMethodsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp oldClpModel = (SalaryComponentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSalaryComponentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSkill(BaseModel<?> oldModel) {
		SkillClp oldClpModel = (SkillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubUnit(BaseModel<?> oldModel) {
		SubUnitClp oldClpModel = (SubUnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTerminationReasons(BaseModel<?> oldModel) {
		TerminationReasonsClp oldClpModel = (TerminationReasonsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTerminationReasonsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkshift(BaseModel<?> oldModel) {
		WorkshiftClp oldClpModel = (WorkshiftClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkshiftRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkWeek(BaseModel<?> oldModel) {
		WorkWeekClp oldClpModel = (WorkWeekClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkWeekRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl")) {
			return translateOutputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EducationImpl")) {
			return translateOutputEducation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpAttachmentImpl")) {
			return translateOutputEmpAttachment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsImpl")) {
			return translateOutputEmpContactDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpDependentImpl")) {
			return translateOutputEmpDependent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpDetailsImpl")) {
			return translateOutputEmpDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositImpl")) {
			return translateOutputEmpDirectDeposit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpEducationImpl")) {
			return translateOutputEmpEducation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactImpl")) {
			return translateOutputEmpEmergencyContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentImpl")) {
			return translateOutputEmpImmigrationDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpJobImpl")) {
			return translateOutputEmpJob(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpLanguageImpl")) {
			return translateOutputEmpLanguage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpLicenseImpl")) {
			return translateOutputEmpLicense(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmployeeImpl")) {
			return translateOutputEmployee(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmploymentStatusImpl")) {
			return translateOutputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpMembershipImpl")) {
			return translateOutputEmpMembership(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsImpl")) {
			return translateOutputEmpPersonalDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpSalaryImpl")) {
			return translateOutputEmpSalary(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentImpl")) {
			return translateOutputEmpSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpSkillImpl")) {
			return translateOutputEmpSkill(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpSubordinateImpl")) {
			return translateOutputEmpSubordinate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpSupervisorImpl")) {
			return translateOutputEmpSupervisor(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmpWorkExpImpl")) {
			return translateOutputEmpWorkExp(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.HolidayImpl")) {
			return translateOutputHoliday(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.InterviewImpl")) {
			return translateOutputInterview(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobCategoryImpl")) {
			return translateOutputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobTitleImpl")) {
			return translateOutputJobTitle(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LanguageImpl")) {
			return translateOutputLanguage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyImpl")) {
			return translateOutputLeaveCarryForwardPolicy(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeavePeriodImpl")) {
			return translateOutputLeavePeriod(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionImpl")) {
			return translateOutputLeaveRestriction(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeaveRuleImpl")) {
			return translateOutputLeaveRule(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeaveTypeImpl")) {
			return translateOutputLeaveType(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityImpl")) {
			return translateOutputLeaveTypeApplicability(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LicenseImpl")) {
			return translateOutputLicense(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.MembershipImpl")) {
			return translateOutputMembership(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NationalityImpl")) {
			return translateOutputNationality(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NewsImpl")) {
			return translateOutputNews(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.OrganizationImpl")) {
			return translateOutputOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeImpl")) {
			return translateOutputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyImpl")) {
			return translateOutputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.ReportingMethodsImpl")) {
			return translateOutputReportingMethods(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SalaryComponentImpl")) {
			return translateOutputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SkillImpl")) {
			return translateOutputSkill(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SubUnitImpl")) {
			return translateOutputSubUnit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.TerminationReasonsImpl")) {
			return translateOutputTerminationReasons(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkshiftImpl")) {
			return translateOutputWorkshift(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkWeekImpl")) {
			return translateOutputWorkWeek(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchDocCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchDocCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEducationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEducationException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpDependentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpDependentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpDetailsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpDetailsException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpEducationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpEducationException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpJobException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpJobException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpLanguageException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpLanguageException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpLicenseException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpLicenseException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmployeeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmployeeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpMembershipException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpMembershipException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpSalaryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpSalaryException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpSkillException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpSkillException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchHolidayException")) {
			return new com.rknowsys.eapp.hrm.NoSuchHolidayException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchInterviewException")) {
			return new com.rknowsys.eapp.hrm.NoSuchInterviewException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobTitleException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobTitleException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLanguageException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLanguageException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLeavePeriodException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeavePeriodException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLeaveRuleException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeaveRuleException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLeaveTypeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeaveTypeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLicenseException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLicenseException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLocationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLocationException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchMembershipException")) {
			return new com.rknowsys.eapp.hrm.NoSuchMembershipException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNationalityException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNationalityException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNewsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNewsException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchOrganizationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchOrganizationException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchPayGradeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchReportingMethodsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchReportingMethodsException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchSalaryComponentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSalaryComponentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSkillException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSkillException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSubUnitException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSubUnitException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchWorkshiftException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkshiftException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchWorkWeekException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkWeekException();
		}

		return throwable;
	}

	public static Object translateOutputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp newModel = new DocCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEducation(BaseModel<?> oldModel) {
		EducationClp newModel = new EducationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEducationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpAttachment(BaseModel<?> oldModel) {
		EmpAttachmentClp newModel = new EmpAttachmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpAttachmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpContactDetails(BaseModel<?> oldModel) {
		EmpContactDetailsClp newModel = new EmpContactDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpContactDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpDependent(BaseModel<?> oldModel) {
		EmpDependentClp newModel = new EmpDependentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpDependentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpDetails(BaseModel<?> oldModel) {
		EmpDetailsClp newModel = new EmpDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpDirectDeposit(BaseModel<?> oldModel) {
		EmpDirectDepositClp newModel = new EmpDirectDepositClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpDirectDepositRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpEducation(BaseModel<?> oldModel) {
		EmpEducationClp newModel = new EmpEducationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpEducationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpEmergencyContact(
		BaseModel<?> oldModel) {
		EmpEmergencyContactClp newModel = new EmpEmergencyContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpEmergencyContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpImmigrationDocument(
		BaseModel<?> oldModel) {
		EmpImmigrationDocumentClp newModel = new EmpImmigrationDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpImmigrationDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpJob(BaseModel<?> oldModel) {
		EmpJobClp newModel = new EmpJobClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpJobRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpLanguage(BaseModel<?> oldModel) {
		EmpLanguageClp newModel = new EmpLanguageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpLanguageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpLicense(BaseModel<?> oldModel) {
		EmpLicenseClp newModel = new EmpLicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmployee(BaseModel<?> oldModel) {
		EmployeeClp newModel = new EmployeeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp newModel = new EmploymentStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmploymentStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpMembership(BaseModel<?> oldModel) {
		EmpMembershipClp newModel = new EmpMembershipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpMembershipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpPersonalDetails(
		BaseModel<?> oldModel) {
		EmpPersonalDetailsClp newModel = new EmpPersonalDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpPersonalDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpSalary(BaseModel<?> oldModel) {
		EmpSalaryClp newModel = new EmpSalaryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpSalaryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpSalaryComponent(
		BaseModel<?> oldModel) {
		EmpSalaryComponentClp newModel = new EmpSalaryComponentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpSalaryComponentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpSkill(BaseModel<?> oldModel) {
		EmpSkillClp newModel = new EmpSkillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpSkillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpSubordinate(BaseModel<?> oldModel) {
		EmpSubordinateClp newModel = new EmpSubordinateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpSubordinateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpSupervisor(BaseModel<?> oldModel) {
		EmpSupervisorClp newModel = new EmpSupervisorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpSupervisorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpWorkExp(BaseModel<?> oldModel) {
		EmpWorkExpClp newModel = new EmpWorkExpClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpWorkExpRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHoliday(BaseModel<?> oldModel) {
		HolidayClp newModel = new HolidayClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHolidayRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInterview(BaseModel<?> oldModel) {
		InterviewClp newModel = new InterviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInterviewRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp newModel = new JobCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobTitle(BaseModel<?> oldModel) {
		JobTitleClp newModel = new JobTitleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobTitleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLanguage(BaseModel<?> oldModel) {
		LanguageClp newModel = new LanguageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLanguageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveCarryForwardPolicy(
		BaseModel<?> oldModel) {
		LeaveCarryForwardPolicyClp newModel = new LeaveCarryForwardPolicyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveCarryForwardPolicyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeavePeriod(BaseModel<?> oldModel) {
		LeavePeriodClp newModel = new LeavePeriodClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeavePeriodRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveRestriction(BaseModel<?> oldModel) {
		LeaveRestrictionClp newModel = new LeaveRestrictionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveRestrictionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveRule(BaseModel<?> oldModel) {
		LeaveRuleClp newModel = new LeaveRuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveRuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveType(BaseModel<?> oldModel) {
		LeaveTypeClp newModel = new LeaveTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaveTypeApplicability(
		BaseModel<?> oldModel) {
		LeaveTypeApplicabilityClp newModel = new LeaveTypeApplicabilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaveTypeApplicabilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLicense(BaseModel<?> oldModel) {
		LicenseClp newModel = new LicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocation(BaseModel<?> oldModel) {
		LocationClp newModel = new LocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembership(BaseModel<?> oldModel) {
		MembershipClp newModel = new MembershipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNationality(BaseModel<?> oldModel) {
		NationalityClp newModel = new NationalityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNationalityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNews(BaseModel<?> oldModel) {
		NewsClp newModel = new NewsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNewsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganization(BaseModel<?> oldModel) {
		OrganizationClp newModel = new OrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp newModel = new PayGradeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp newModel = new PayGradeCurrencyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeCurrencyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReportingMethods(BaseModel<?> oldModel) {
		ReportingMethodsClp newModel = new ReportingMethodsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReportingMethodsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp newModel = new SalaryComponentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSalaryComponentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSkill(BaseModel<?> oldModel) {
		SkillClp newModel = new SkillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubUnit(BaseModel<?> oldModel) {
		SubUnitClp newModel = new SubUnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubUnitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTerminationReasons(
		BaseModel<?> oldModel) {
		TerminationReasonsClp newModel = new TerminationReasonsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTerminationReasonsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkshift(BaseModel<?> oldModel) {
		WorkshiftClp newModel = new WorkshiftClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkshiftRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkWeek(BaseModel<?> oldModel) {
		WorkWeekClp newModel = new WorkWeekClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkWeekRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}