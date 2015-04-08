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

import com.rknowsys.eapp.hrm.service.LeaveGeneralLocalServiceUtil;

import java.util.Arrays;

/**
 * @author rknowsys
 * @generated
 */
public class LeaveGeneralLocalServiceClpInvoker {
	public LeaveGeneralLocalServiceClpInvoker() {
		_methodName0 = "addLeaveGeneral";

		_methodParameterTypes0 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveGeneral"
			};

		_methodName1 = "createLeaveGeneral";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLeaveGeneral";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLeaveGeneral";

		_methodParameterTypes3 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveGeneral"
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

		_methodName10 = "fetchLeaveGeneral";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLeaveGeneral";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLeaveGenerals";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLeaveGeneralsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLeaveGeneral";

		_methodParameterTypes15 = new String[] {
				"com.rknowsys.eapp.hrm.model.LeaveGeneral"
			};

		_methodName260 = "getBeanIdentifier";

		_methodParameterTypes260 = new String[] {  };

		_methodName261 = "setBeanIdentifier";

		_methodParameterTypes261 = new String[] { "java.lang.String" };

		_methodName266 = "findByLeaveTypeId";

		_methodParameterTypes266 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.addLeaveGeneral((com.rknowsys.eapp.hrm.model.LeaveGeneral)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.createLeaveGeneral(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.deleteLeaveGeneral(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.deleteLeaveGeneral((com.rknowsys.eapp.hrm.model.LeaveGeneral)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.fetchLeaveGeneral(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.getLeaveGeneral(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.getLeaveGenerals(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.getLeaveGeneralsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.updateLeaveGeneral((com.rknowsys.eapp.hrm.model.LeaveGeneral)arguments[0]);
		}

		if (_methodName260.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes260, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName261.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes261, parameterTypes)) {
			LeaveGeneralLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName266.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes266, parameterTypes)) {
			return LeaveGeneralLocalServiceUtil.findByLeaveTypeId(((Long)arguments[0]).longValue());
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
	private String _methodName260;
	private String[] _methodParameterTypes260;
	private String _methodName261;
	private String[] _methodParameterTypes261;
	private String _methodName266;
	private String[] _methodParameterTypes266;
}