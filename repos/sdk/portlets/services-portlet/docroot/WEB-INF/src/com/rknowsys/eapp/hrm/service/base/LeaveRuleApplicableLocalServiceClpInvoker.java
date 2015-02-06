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

package com.rknowsys.eapp.hrm.service.base;

import com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalServiceUtil;

import java.util.Arrays;

/**
 * @author rknowsys
 * @generated
 */
public class LeaveRuleApplicableLocalServiceClpInvoker {
	public LeaveRuleApplicableLocalServiceClpInvoker() {
		_methodName0 = "addLeaveRuleApplicable";

		_methodParameterTypes0 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName1 = "createLeaveRuleApplicable";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLeaveRuleApplicable";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLeaveRuleApplicable";

		_methodParameterTypes3 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLeaveRuleApplicable";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLeaveRuleApplicable";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLeaveRuleApplicables";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLeaveRuleApplicablesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLeaveRuleApplicable";

		_methodParameterTypes15 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName16 = "addJobCategoryLeaveRuleApplicable";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addJobCategoryLeaveRuleApplicable";

		_methodParameterTypes17 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName18 = "addJobCategoryLeaveRuleApplicables";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addJobCategoryLeaveRuleApplicables";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearJobCategoryLeaveRuleApplicables";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteJobCategoryLeaveRuleApplicable";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteJobCategoryLeaveRuleApplicable";

		_methodParameterTypes22 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName23 = "deleteJobCategoryLeaveRuleApplicables";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteJobCategoryLeaveRuleApplicables";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getJobCategoryLeaveRuleApplicables";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getJobCategoryLeaveRuleApplicables";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getJobCategoryLeaveRuleApplicables";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getJobCategoryLeaveRuleApplicablesCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasJobCategoryLeaveRuleApplicable";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasJobCategoryLeaveRuleApplicables";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setJobCategoryLeaveRuleApplicables";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName32 = "addJobTitleLeaveRuleApplicable";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "addJobTitleLeaveRuleApplicable";

		_methodParameterTypes33 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName34 = "addJobTitleLeaveRuleApplicables";

		_methodParameterTypes34 = new String[] { "long", "long[][]" };

		_methodName35 = "addJobTitleLeaveRuleApplicables";

		_methodParameterTypes35 = new String[] { "long", "java.util.List" };

		_methodName36 = "clearJobTitleLeaveRuleApplicables";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "deleteJobTitleLeaveRuleApplicable";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "deleteJobTitleLeaveRuleApplicable";

		_methodParameterTypes38 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName39 = "deleteJobTitleLeaveRuleApplicables";

		_methodParameterTypes39 = new String[] { "long", "long[][]" };

		_methodName40 = "deleteJobTitleLeaveRuleApplicables";

		_methodParameterTypes40 = new String[] { "long", "java.util.List" };

		_methodName41 = "getJobTitleLeaveRuleApplicables";

		_methodParameterTypes41 = new String[] { "long" };

		_methodName42 = "getJobTitleLeaveRuleApplicables";

		_methodParameterTypes42 = new String[] { "long", "int", "int" };

		_methodName43 = "getJobTitleLeaveRuleApplicables";

		_methodParameterTypes43 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName44 = "getJobTitleLeaveRuleApplicablesCount";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "hasJobTitleLeaveRuleApplicable";

		_methodParameterTypes45 = new String[] { "long", "long" };

		_methodName46 = "hasJobTitleLeaveRuleApplicables";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "setJobTitleLeaveRuleApplicables";

		_methodParameterTypes47 = new String[] { "long", "long[][]" };

		_methodName48 = "addEmploymentStatusLeaveRuleApplicable";

		_methodParameterTypes48 = new String[] { "long", "long" };

		_methodName49 = "addEmploymentStatusLeaveRuleApplicable";

		_methodParameterTypes49 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName50 = "addEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes50 = new String[] { "long", "long[][]" };

		_methodName51 = "addEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes51 = new String[] { "long", "java.util.List" };

		_methodName52 = "clearEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes52 = new String[] { "long" };

		_methodName53 = "deleteEmploymentStatusLeaveRuleApplicable";

		_methodParameterTypes53 = new String[] { "long", "long" };

		_methodName54 = "deleteEmploymentStatusLeaveRuleApplicable";

		_methodParameterTypes54 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"
			};

		_methodName55 = "deleteEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes55 = new String[] { "long", "long[][]" };

		_methodName56 = "deleteEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes56 = new String[] { "long", "java.util.List" };

		_methodName57 = "getEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes58 = new String[] { "long", "int", "int" };

		_methodName59 = "getEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes59 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName60 = "getEmploymentStatusLeaveRuleApplicablesCount";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "hasEmploymentStatusLeaveRuleApplicable";

		_methodParameterTypes61 = new String[] { "long", "long" };

		_methodName62 = "hasEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "setEmploymentStatusLeaveRuleApplicables";

		_methodParameterTypes63 = new String[] { "long", "long[][]" };

		_methodName288 = "getBeanIdentifier";

		_methodParameterTypes288 = new String[] {  };

		_methodName289 = "setBeanIdentifier";

		_methodParameterTypes289 = new String[] { "java.lang.String" };

		_methodName294 = "findByLeaveTypeId";

		_methodParameterTypes294 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.addLeaveRuleApplicable((com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.createLeaveRuleApplicable(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.deleteLeaveRuleApplicable(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.deleteLeaveRuleApplicable((com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.fetchLeaveRuleApplicable(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getLeaveRuleApplicable(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getLeaveRuleApplicables(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getLeaveRuleApplicablesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.updateLeaveRuleApplicable((com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobCategoryLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobCategoryLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.clearJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobCategoryLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobCategoryLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobCategoryLeaveRuleApplicablesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasJobCategoryLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.setJobCategoryLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.clearJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobTitleLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobTitleLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getJobTitleLeaveRuleApplicablesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasJobTitleLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.setJobTitleLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addEmploymentStatusLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addEmploymentStatusLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.addEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.clearEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteEmploymentStatusLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteEmploymentStatusLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveRuleApplicable)arguments[1]);

			return null;
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.deleteEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable>)arguments[1]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getEmploymentStatusLeaveRuleApplicablesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasEmploymentStatusLeaveRuleApplicable(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.hasEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.setEmploymentStatusLeaveRuleApplicables(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName288.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName289.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes289, parameterTypes)) {
			LeaveRuleApplicableLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName294.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes294, parameterTypes)) {
			return LeaveRuleApplicableLocalServiceUtil.findByLeaveTypeId(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName288;
	private String[] _methodParameterTypes288;
	private String _methodName289;
	private String[] _methodParameterTypes289;
	private String _methodName294;
	private String[] _methodParameterTypes294;
}