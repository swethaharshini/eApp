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

package com.rknowsys.eapp.hrm.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.LeaveRuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveRuleClp extends BaseModelImpl<LeaveRule> implements LeaveRule {
	public LeaveRuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRule.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveRuleId", getLeaveRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("leavePeriodTypeId", getLeavePeriodTypeId());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startDayOfMonth", getStartDayOfMonth());
		attributes.put("duration", getDuration());
		attributes.put("ifEmployeesCanApply", getIfEmployeesCanApply());
		attributes.put("ifAdminCanAssign", getIfAdminCanAssign());
		attributes.put("ifAdminCanManageEntitlements",
			getIfAdminCanManageEntitlements());
		attributes.put("ifLeaveAccruable", getIfLeaveAccruable());
		attributes.put("ifCarryForwardable", getIfCarryForwardable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveRuleId = (Long)attributes.get("leaveRuleId");

		if (leaveRuleId != null) {
			setLeaveRuleId(leaveRuleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Integer leavePeriodTypeId = (Integer)attributes.get("leavePeriodTypeId");

		if (leavePeriodTypeId != null) {
			setLeavePeriodTypeId(leavePeriodTypeId);
		}

		Integer startMonth = (Integer)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		Integer startDayOfMonth = (Integer)attributes.get("startDayOfMonth");

		if (startDayOfMonth != null) {
			setStartDayOfMonth(startDayOfMonth);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Boolean ifEmployeesCanApply = (Boolean)attributes.get(
				"ifEmployeesCanApply");

		if (ifEmployeesCanApply != null) {
			setIfEmployeesCanApply(ifEmployeesCanApply);
		}

		Boolean ifAdminCanAssign = (Boolean)attributes.get("ifAdminCanAssign");

		if (ifAdminCanAssign != null) {
			setIfAdminCanAssign(ifAdminCanAssign);
		}

		Boolean ifAdminCanManageEntitlements = (Boolean)attributes.get(
				"ifAdminCanManageEntitlements");

		if (ifAdminCanManageEntitlements != null) {
			setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
		}

		Boolean ifLeaveAccruable = (Boolean)attributes.get("ifLeaveAccruable");

		if (ifLeaveAccruable != null) {
			setIfLeaveAccruable(ifLeaveAccruable);
		}

		Boolean ifCarryForwardable = (Boolean)attributes.get(
				"ifCarryForwardable");

		if (ifCarryForwardable != null) {
			setIfCarryForwardable(ifCarryForwardable);
		}
	}

	@Override
	public long getLeaveRuleId() {
		return _leaveRuleId;
	}

	@Override
	public void setLeaveRuleId(long leaveRuleId) {
		_leaveRuleId = leaveRuleId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRuleId", long.class);

				method.invoke(_leaveRuleRemoteModel, leaveRuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveRuleRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveRuleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveRuleRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveRuleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveRuleRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveRuleRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLeavePeriodTypeId() {
		return _leavePeriodTypeId;
	}

	@Override
	public void setLeavePeriodTypeId(int leavePeriodTypeId) {
		_leavePeriodTypeId = leavePeriodTypeId;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLeavePeriodTypeId",
						int.class);

				method.invoke(_leaveRuleRemoteModel, leavePeriodTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartMonth() {
		return _startMonth;
	}

	@Override
	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonth", int.class);

				method.invoke(_leaveRuleRemoteModel, startMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartDayOfMonth() {
		return _startDayOfMonth;
	}

	@Override
	public void setStartDayOfMonth(int startDayOfMonth) {
		_startDayOfMonth = startDayOfMonth;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDayOfMonth", int.class);

				method.invoke(_leaveRuleRemoteModel, startDayOfMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(String duration) {
		_duration = duration;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_leaveRuleRemoteModel, duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfEmployeesCanApply() {
		return _ifEmployeesCanApply;
	}

	@Override
	public boolean isIfEmployeesCanApply() {
		return _ifEmployeesCanApply;
	}

	@Override
	public void setIfEmployeesCanApply(boolean ifEmployeesCanApply) {
		_ifEmployeesCanApply = ifEmployeesCanApply;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setIfEmployeesCanApply",
						boolean.class);

				method.invoke(_leaveRuleRemoteModel, ifEmployeesCanApply);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfAdminCanAssign() {
		return _ifAdminCanAssign;
	}

	@Override
	public boolean isIfAdminCanAssign() {
		return _ifAdminCanAssign;
	}

	@Override
	public void setIfAdminCanAssign(boolean ifAdminCanAssign) {
		_ifAdminCanAssign = ifAdminCanAssign;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setIfAdminCanAssign",
						boolean.class);

				method.invoke(_leaveRuleRemoteModel, ifAdminCanAssign);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfAdminCanManageEntitlements() {
		return _ifAdminCanManageEntitlements;
	}

	@Override
	public boolean isIfAdminCanManageEntitlements() {
		return _ifAdminCanManageEntitlements;
	}

	@Override
	public void setIfAdminCanManageEntitlements(
		boolean ifAdminCanManageEntitlements) {
		_ifAdminCanManageEntitlements = ifAdminCanManageEntitlements;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setIfAdminCanManageEntitlements",
						boolean.class);

				method.invoke(_leaveRuleRemoteModel,
					ifAdminCanManageEntitlements);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfLeaveAccruable() {
		return _ifLeaveAccruable;
	}

	@Override
	public boolean isIfLeaveAccruable() {
		return _ifLeaveAccruable;
	}

	@Override
	public void setIfLeaveAccruable(boolean ifLeaveAccruable) {
		_ifLeaveAccruable = ifLeaveAccruable;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setIfLeaveAccruable",
						boolean.class);

				method.invoke(_leaveRuleRemoteModel, ifLeaveAccruable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfCarryForwardable() {
		return _ifCarryForwardable;
	}

	@Override
	public boolean isIfCarryForwardable() {
		return _ifCarryForwardable;
	}

	@Override
	public void setIfCarryForwardable(boolean ifCarryForwardable) {
		_ifCarryForwardable = ifCarryForwardable;

		if (_leaveRuleRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setIfCarryForwardable",
						boolean.class);

				method.invoke(_leaveRuleRemoteModel, ifCarryForwardable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveRuleRemoteModel() {
		return _leaveRuleRemoteModel;
	}

	public void setLeaveRuleRemoteModel(BaseModel<?> leaveRuleRemoteModel) {
		_leaveRuleRemoteModel = leaveRuleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _leaveRuleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_leaveRuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveRuleLocalServiceUtil.addLeaveRule(this);
		}
		else {
			LeaveRuleLocalServiceUtil.updateLeaveRule(this);
		}
	}

	@Override
	public LeaveRule toEscapedModel() {
		return (LeaveRule)ProxyUtil.newProxyInstance(LeaveRule.class.getClassLoader(),
			new Class[] { LeaveRule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveRuleClp clone = new LeaveRuleClp();

		clone.setLeaveRuleId(getLeaveRuleId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setLeavePeriodTypeId(getLeavePeriodTypeId());
		clone.setStartMonth(getStartMonth());
		clone.setStartDayOfMonth(getStartDayOfMonth());
		clone.setDuration(getDuration());
		clone.setIfEmployeesCanApply(getIfEmployeesCanApply());
		clone.setIfAdminCanAssign(getIfAdminCanAssign());
		clone.setIfAdminCanManageEntitlements(getIfAdminCanManageEntitlements());
		clone.setIfLeaveAccruable(getIfLeaveAccruable());
		clone.setIfCarryForwardable(getIfCarryForwardable());

		return clone;
	}

	@Override
	public int compareTo(LeaveRule leaveRule) {
		long primaryKey = leaveRule.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRuleClp)) {
			return false;
		}

		LeaveRuleClp leaveRule = (LeaveRuleClp)obj;

		long primaryKey = leaveRule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveRuleId=");
		sb.append(getLeaveRuleId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", leaveTypeId=");
		sb.append(getLeaveTypeId());
		sb.append(", leavePeriodTypeId=");
		sb.append(getLeavePeriodTypeId());
		sb.append(", startMonth=");
		sb.append(getStartMonth());
		sb.append(", startDayOfMonth=");
		sb.append(getStartDayOfMonth());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", ifEmployeesCanApply=");
		sb.append(getIfEmployeesCanApply());
		sb.append(", ifAdminCanAssign=");
		sb.append(getIfAdminCanAssign());
		sb.append(", ifAdminCanManageEntitlements=");
		sb.append(getIfAdminCanManageEntitlements());
		sb.append(", ifLeaveAccruable=");
		sb.append(getIfLeaveAccruable());
		sb.append(", ifCarryForwardable=");
		sb.append(getIfCarryForwardable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveRuleId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveTypeId</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leavePeriodTypeId</column-name><column-value><![CDATA[");
		sb.append(getLeavePeriodTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonth</column-name><column-value><![CDATA[");
		sb.append(getStartMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDayOfMonth</column-name><column-value><![CDATA[");
		sb.append(getStartDayOfMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifEmployeesCanApply</column-name><column-value><![CDATA[");
		sb.append(getIfEmployeesCanApply());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifAdminCanAssign</column-name><column-value><![CDATA[");
		sb.append(getIfAdminCanAssign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifAdminCanManageEntitlements</column-name><column-value><![CDATA[");
		sb.append(getIfAdminCanManageEntitlements());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifLeaveAccruable</column-name><column-value><![CDATA[");
		sb.append(getIfLeaveAccruable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifCarryForwardable</column-name><column-value><![CDATA[");
		sb.append(getIfCarryForwardable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveRuleId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private int _leavePeriodTypeId;
	private int _startMonth;
	private int _startDayOfMonth;
	private String _duration;
	private boolean _ifEmployeesCanApply;
	private boolean _ifAdminCanAssign;
	private boolean _ifAdminCanManageEntitlements;
	private boolean _ifLeaveAccruable;
	private boolean _ifCarryForwardable;
	private BaseModel<?> _leaveRuleRemoteModel;
}