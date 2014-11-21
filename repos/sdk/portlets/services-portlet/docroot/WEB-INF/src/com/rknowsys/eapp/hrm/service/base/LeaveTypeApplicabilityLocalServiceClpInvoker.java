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

import com.rknowsys.eapp.hrm.service.LeaveTypeApplicabilityLocalServiceUtil;

import java.util.Arrays;

/**
 * @author rknowsys
 * @generated
 */
public class LeaveTypeApplicabilityLocalServiceClpInvoker {
	public LeaveTypeApplicabilityLocalServiceClpInvoker() {
		_methodName0 = "addLeaveTypeApplicability";

		_methodParameterTypes0 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName1 = "createLeaveTypeApplicability";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLeaveTypeApplicability";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLeaveTypeApplicability";

		_methodParameterTypes3 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
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

		_methodName10 = "fetchLeaveTypeApplicability";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLeaveTypeApplicability";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLeaveTypeApplicabilities";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLeaveTypeApplicabilitiesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLeaveTypeApplicability";

		_methodParameterTypes15 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName16 = "addJobTitleLeaveTypeApplicability";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addJobTitleLeaveTypeApplicability";

		_methodParameterTypes17 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName18 = "addJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteJobTitleLeaveTypeApplicability";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteJobTitleLeaveTypeApplicability";

		_methodParameterTypes22 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName23 = "deleteJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getJobTitleLeaveTypeApplicabilitiesCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasJobTitleLeaveTypeApplicability";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setJobTitleLeaveTypeApplicabilities";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName32 = "addEmploymentStatusLeaveTypeApplicability";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "addEmploymentStatusLeaveTypeApplicability";

		_methodParameterTypes33 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName34 = "addEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes34 = new String[] { "long", "long[][]" };

		_methodName35 = "addEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes35 = new String[] { "long", "java.util.List" };

		_methodName36 = "clearEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "deleteEmploymentStatusLeaveTypeApplicability";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "deleteEmploymentStatusLeaveTypeApplicability";

		_methodParameterTypes38 = new String[] {
				"long", "com.rknowsys.eapp.hrm.model.LeaveTypeApplicability"
			};

		_methodName39 = "deleteEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes39 = new String[] { "long", "long[][]" };

		_methodName40 = "deleteEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes40 = new String[] { "long", "java.util.List" };

		_methodName41 = "getEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes41 = new String[] { "long" };

		_methodName42 = "getEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes42 = new String[] { "long", "int", "int" };

		_methodName43 = "getEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes43 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName44 = "getEmploymentStatusLeaveTypeApplicabilitiesCount";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "hasEmploymentStatusLeaveTypeApplicability";

		_methodParameterTypes45 = new String[] { "long", "long" };

		_methodName46 = "hasEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "setEmploymentStatusLeaveTypeApplicabilities";

		_methodParameterTypes47 = new String[] { "long", "long[][]" };

		_methodName264 = "getBeanIdentifier";

		_methodParameterTypes264 = new String[] {  };

		_methodName265 = "setBeanIdentifier";

		_methodParameterTypes265 = new String[] { "java.lang.String" };

		_methodName270 = "findByLeaveTypeId";

		_methodParameterTypes270 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.addLeaveTypeApplicability((com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.createLeaveTypeApplicability(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.deleteLeaveTypeApplicability(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.deleteLeaveTypeApplicability((com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.fetchLeaveTypeApplicability(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getLeaveTypeApplicability(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getLeaveTypeApplicabilities(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getLeaveTypeApplicabilitiesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.updateLeaveTypeApplicability((com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addJobTitleLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addJobTitleLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.clearJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteJobTitleLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteJobTitleLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getJobTitleLeaveTypeApplicabilitiesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.hasJobTitleLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.hasJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.setJobTitleLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addEmploymentStatusLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addEmploymentStatusLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[1]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.addEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability>)arguments[1]);

			return null;
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.clearEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteEmploymentStatusLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteEmploymentStatusLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				(com.rknowsys.eapp.hrm.model.LeaveTypeApplicability)arguments[1]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.deleteEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability>)arguments[1]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getEmploymentStatusLeaveTypeApplicabilitiesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.hasEmploymentStatusLeaveTypeApplicability(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.hasEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.setEmploymentStatusLeaveTypeApplicabilities(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName264.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes264, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName265.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes265, parameterTypes)) {
			LeaveTypeApplicabilityLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName270.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes270, parameterTypes)) {
			return LeaveTypeApplicabilityLocalServiceUtil.findByLeaveTypeId(((Long)arguments[0]).longValue());
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
	private String _methodName264;
	private String[] _methodParameterTypes264;
	private String _methodName265;
	private String[] _methodParameterTypes265;
	private String _methodName270;
	private String[] _methodParameterTypes270;
}