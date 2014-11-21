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

package com.rknowsys.eapp.hrm.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.DocCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpAttachmentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpMembershipLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSalaryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSubordinateLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpWorkExpLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.InterviewLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRuleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeApplicabilityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.OrganizationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.TerminationReasonsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkWeekLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil;

/**
 * @author rknowsys
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			DocCategoryLocalServiceUtil.clearService();

			EducationLocalServiceUtil.clearService();

			EmpAttachmentLocalServiceUtil.clearService();

			EmpContactDetailsLocalServiceUtil.clearService();

			EmpDependentLocalServiceUtil.clearService();

			EmpDetailsLocalServiceUtil.clearService();

			EmpDirectDepositLocalServiceUtil.clearService();

			EmpEducationLocalServiceUtil.clearService();

			EmpEmergencyContactLocalServiceUtil.clearService();

			EmpImmigrationDocumentLocalServiceUtil.clearService();

			EmpJobLocalServiceUtil.clearService();

			EmpLanguageLocalServiceUtil.clearService();

			EmpLicenseLocalServiceUtil.clearService();

			EmployeeLocalServiceUtil.clearService();

			EmploymentStatusLocalServiceUtil.clearService();

			EmpMembershipLocalServiceUtil.clearService();

			EmpPersonalDetailsLocalServiceUtil.clearService();

			EmpSalaryLocalServiceUtil.clearService();

			EmpSalaryComponentLocalServiceUtil.clearService();

			EmpSkillLocalServiceUtil.clearService();

			EmpSubordinateLocalServiceUtil.clearService();

			EmpSupervisorLocalServiceUtil.clearService();

			EmpWorkExpLocalServiceUtil.clearService();

			HolidayLocalServiceUtil.clearService();

			InterviewLocalServiceUtil.clearService();

			JobCategoryLocalServiceUtil.clearService();

			JobTitleLocalServiceUtil.clearService();

			LanguageLocalServiceUtil.clearService();

			LeaveCarryForwardPolicyLocalServiceUtil.clearService();

			LeavePeriodLocalServiceUtil.clearService();

			LeaveRestrictionLocalServiceUtil.clearService();

			LeaveRuleLocalServiceUtil.clearService();

			LeaveTypeLocalServiceUtil.clearService();

			LeaveTypeApplicabilityLocalServiceUtil.clearService();

			LicenseLocalServiceUtil.clearService();

			LocationLocalServiceUtil.clearService();

			MembershipLocalServiceUtil.clearService();

			NationalityLocalServiceUtil.clearService();

			NewsLocalServiceUtil.clearService();

			OrganizationLocalServiceUtil.clearService();

			PayGradeLocalServiceUtil.clearService();

			PayGradeCurrencyLocalServiceUtil.clearService();

			ReportingMethodsLocalServiceUtil.clearService();

			SalaryComponentLocalServiceUtil.clearService();

			SkillLocalServiceUtil.clearService();

			SubUnitLocalServiceUtil.clearService();

			TerminationReasonsLocalServiceUtil.clearService();

			WorkshiftLocalServiceUtil.clearService();

			WorkWeekLocalServiceUtil.clearService();
		}
	}
}