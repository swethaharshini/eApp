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
import com.rknowsys.eapp.hrm.service.LeaveAccrualLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveAccrualClp extends BaseModelImpl<LeaveAccrual>
	implements LeaveAccrual {
	public LeaveAccrualClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveAccrual.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveAccrual.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveAccrualId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveAccrualId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveAccrualId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveAccrualId", getLeaveAccrualId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("accrualFrequency", getAccrualFrequency());
		attributes.put("accrueEvery", getAccrueEvery());
		attributes.put("dayOfCredit", getDayOfCredit());
		attributes.put("accrualStartsOn", getAccrualStartsOn());
		attributes.put("monthOfCredit", getMonthOfCredit());
		attributes.put("accrualValidFrom", getAccrualValidFrom());
		attributes.put("firstAccrual", getFirstAccrual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveAccrualId = (Long)attributes.get("leaveAccrualId");

		if (leaveAccrualId != null) {
			setLeaveAccrualId(leaveAccrualId);
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

		String accrualFrequency = (String)attributes.get("accrualFrequency");

		if (accrualFrequency != null) {
			setAccrualFrequency(accrualFrequency);
		}

		Integer accrueEvery = (Integer)attributes.get("accrueEvery");

		if (accrueEvery != null) {
			setAccrueEvery(accrueEvery);
		}

		Integer dayOfCredit = (Integer)attributes.get("dayOfCredit");

		if (dayOfCredit != null) {
			setDayOfCredit(dayOfCredit);
		}

		String accrualStartsOn = (String)attributes.get("accrualStartsOn");

		if (accrualStartsOn != null) {
			setAccrualStartsOn(accrualStartsOn);
		}

		Integer monthOfCredit = (Integer)attributes.get("monthOfCredit");

		if (monthOfCredit != null) {
			setMonthOfCredit(monthOfCredit);
		}

		String accrualValidFrom = (String)attributes.get("accrualValidFrom");

		if (accrualValidFrom != null) {
			setAccrualValidFrom(accrualValidFrom);
		}

		String firstAccrual = (String)attributes.get("firstAccrual");

		if (firstAccrual != null) {
			setFirstAccrual(firstAccrual);
		}
	}

	@Override
	public long getLeaveAccrualId() {
		return _leaveAccrualId;
	}

	@Override
	public void setLeaveAccrualId(long leaveAccrualId) {
		_leaveAccrualId = leaveAccrualId;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveAccrualId", long.class);

				method.invoke(_leaveAccrualRemoteModel, leaveAccrualId);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveAccrualRemoteModel, companyId);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveAccrualRemoteModel, groupId);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveAccrualRemoteModel, createDate);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveAccrualRemoteModel, modifiedDate);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveAccrualRemoteModel, userId);
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

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveAccrualRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccrualFrequency() {
		return _accrualFrequency;
	}

	@Override
	public void setAccrualFrequency(String accrualFrequency) {
		_accrualFrequency = accrualFrequency;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setAccrualFrequency",
						String.class);

				method.invoke(_leaveAccrualRemoteModel, accrualFrequency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAccrueEvery() {
		return _accrueEvery;
	}

	@Override
	public void setAccrueEvery(int accrueEvery) {
		_accrueEvery = accrueEvery;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setAccrueEvery", int.class);

				method.invoke(_leaveAccrualRemoteModel, accrueEvery);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDayOfCredit() {
		return _dayOfCredit;
	}

	@Override
	public void setDayOfCredit(int dayOfCredit) {
		_dayOfCredit = dayOfCredit;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOfCredit", int.class);

				method.invoke(_leaveAccrualRemoteModel, dayOfCredit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccrualStartsOn() {
		return _accrualStartsOn;
	}

	@Override
	public void setAccrualStartsOn(String accrualStartsOn) {
		_accrualStartsOn = accrualStartsOn;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setAccrualStartsOn",
						String.class);

				method.invoke(_leaveAccrualRemoteModel, accrualStartsOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMonthOfCredit() {
		return _monthOfCredit;
	}

	@Override
	public void setMonthOfCredit(int monthOfCredit) {
		_monthOfCredit = monthOfCredit;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setMonthOfCredit", int.class);

				method.invoke(_leaveAccrualRemoteModel, monthOfCredit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccrualValidFrom() {
		return _accrualValidFrom;
	}

	@Override
	public void setAccrualValidFrom(String accrualValidFrom) {
		_accrualValidFrom = accrualValidFrom;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setAccrualValidFrom",
						String.class);

				method.invoke(_leaveAccrualRemoteModel, accrualValidFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstAccrual() {
		return _firstAccrual;
	}

	@Override
	public void setFirstAccrual(String firstAccrual) {
		_firstAccrual = firstAccrual;

		if (_leaveAccrualRemoteModel != null) {
			try {
				Class<?> clazz = _leaveAccrualRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstAccrual", String.class);

				method.invoke(_leaveAccrualRemoteModel, firstAccrual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveAccrualRemoteModel() {
		return _leaveAccrualRemoteModel;
	}

	public void setLeaveAccrualRemoteModel(BaseModel<?> leaveAccrualRemoteModel) {
		_leaveAccrualRemoteModel = leaveAccrualRemoteModel;
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

		Class<?> remoteModelClass = _leaveAccrualRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveAccrualRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveAccrualLocalServiceUtil.addLeaveAccrual(this);
		}
		else {
			LeaveAccrualLocalServiceUtil.updateLeaveAccrual(this);
		}
	}

	@Override
	public LeaveAccrual toEscapedModel() {
		return (LeaveAccrual)ProxyUtil.newProxyInstance(LeaveAccrual.class.getClassLoader(),
			new Class[] { LeaveAccrual.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveAccrualClp clone = new LeaveAccrualClp();

		clone.setLeaveAccrualId(getLeaveAccrualId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setAccrualFrequency(getAccrualFrequency());
		clone.setAccrueEvery(getAccrueEvery());
		clone.setDayOfCredit(getDayOfCredit());
		clone.setAccrualStartsOn(getAccrualStartsOn());
		clone.setMonthOfCredit(getMonthOfCredit());
		clone.setAccrualValidFrom(getAccrualValidFrom());
		clone.setFirstAccrual(getFirstAccrual());

		return clone;
	}

	@Override
	public int compareTo(LeaveAccrual leaveAccrual) {
		long primaryKey = leaveAccrual.getPrimaryKey();

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

		if (!(obj instanceof LeaveAccrualClp)) {
			return false;
		}

		LeaveAccrualClp leaveAccrual = (LeaveAccrualClp)obj;

		long primaryKey = leaveAccrual.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{leaveAccrualId=");
		sb.append(getLeaveAccrualId());
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
		sb.append(", accrualFrequency=");
		sb.append(getAccrualFrequency());
		sb.append(", accrueEvery=");
		sb.append(getAccrueEvery());
		sb.append(", dayOfCredit=");
		sb.append(getDayOfCredit());
		sb.append(", accrualStartsOn=");
		sb.append(getAccrualStartsOn());
		sb.append(", monthOfCredit=");
		sb.append(getMonthOfCredit());
		sb.append(", accrualValidFrom=");
		sb.append(getAccrualValidFrom());
		sb.append(", firstAccrual=");
		sb.append(getFirstAccrual());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveAccrual");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveAccrualId</column-name><column-value><![CDATA[");
		sb.append(getLeaveAccrualId());
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
			"<column><column-name>accrualFrequency</column-name><column-value><![CDATA[");
		sb.append(getAccrualFrequency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accrueEvery</column-name><column-value><![CDATA[");
		sb.append(getAccrueEvery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayOfCredit</column-name><column-value><![CDATA[");
		sb.append(getDayOfCredit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accrualStartsOn</column-name><column-value><![CDATA[");
		sb.append(getAccrualStartsOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthOfCredit</column-name><column-value><![CDATA[");
		sb.append(getMonthOfCredit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accrualValidFrom</column-name><column-value><![CDATA[");
		sb.append(getAccrualValidFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstAccrual</column-name><column-value><![CDATA[");
		sb.append(getFirstAccrual());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveAccrualId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private String _accrualFrequency;
	private int _accrueEvery;
	private int _dayOfCredit;
	private String _accrualStartsOn;
	private int _monthOfCredit;
	private String _accrualValidFrom;
	private String _firstAccrual;
	private BaseModel<?> _leaveAccrualRemoteModel;
}