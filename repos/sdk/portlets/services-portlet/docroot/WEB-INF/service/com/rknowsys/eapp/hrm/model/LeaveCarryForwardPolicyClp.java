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
import com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveCarryForwardPolicyClp extends BaseModelImpl<LeaveCarryForwardPolicy>
	implements LeaveCarryForwardPolicy {
	public LeaveCarryForwardPolicyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveCarryForwardPolicy.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveCarryForwardPolicy.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveCarryForwardPolicyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveCarryForwardPolicyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveCarryForwardPolicyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveCarryForwardPolicyId",
			getLeaveCarryForwardPolicyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("expiryDuration", getExpiryDuration());
		attributes.put("expiryDurationUOM", getExpiryDurationUOM());
		attributes.put("isMaxCarryForwardLimitApplicable",
			getIsMaxCarryForwardLimitApplicable());
		attributes.put("maxCarryForwardLimit", getMaxCarryForwardLimit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveCarryForwardPolicyId = (Long)attributes.get(
				"leaveCarryForwardPolicyId");

		if (leaveCarryForwardPolicyId != null) {
			setLeaveCarryForwardPolicyId(leaveCarryForwardPolicyId);
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

		Integer expiryDuration = (Integer)attributes.get("expiryDuration");

		if (expiryDuration != null) {
			setExpiryDuration(expiryDuration);
		}

		String expiryDurationUOM = (String)attributes.get("expiryDurationUOM");

		if (expiryDurationUOM != null) {
			setExpiryDurationUOM(expiryDurationUOM);
		}

		Boolean isMaxCarryForwardLimitApplicable = (Boolean)attributes.get(
				"isMaxCarryForwardLimitApplicable");

		if (isMaxCarryForwardLimitApplicable != null) {
			setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);
		}

		String maxCarryForwardLimit = (String)attributes.get(
				"maxCarryForwardLimit");

		if (maxCarryForwardLimit != null) {
			setMaxCarryForwardLimit(maxCarryForwardLimit);
		}
	}

	@Override
	public long getLeaveCarryForwardPolicyId() {
		return _leaveCarryForwardPolicyId;
	}

	@Override
	public void setLeaveCarryForwardPolicyId(long leaveCarryForwardPolicyId) {
		_leaveCarryForwardPolicyId = leaveCarryForwardPolicyId;

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveCarryForwardPolicyId",
						long.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel,
					leaveCarryForwardPolicyId);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, companyId);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, groupId);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, createDate);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, modifiedDate);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, userId);
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

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getExpiryDuration() {
		return _expiryDuration;
	}

	@Override
	public void setExpiryDuration(int expiryDuration) {
		_expiryDuration = expiryDuration;

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDuration", int.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel,
					expiryDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiryDurationUOM() {
		return _expiryDurationUOM;
	}

	@Override
	public void setExpiryDurationUOM(String expiryDurationUOM) {
		_expiryDurationUOM = expiryDurationUOM;

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDurationUOM",
						String.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel,
					expiryDurationUOM);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMaxCarryForwardLimitApplicable() {
		return _isMaxCarryForwardLimitApplicable;
	}

	@Override
	public boolean isIsMaxCarryForwardLimitApplicable() {
		return _isMaxCarryForwardLimitApplicable;
	}

	@Override
	public void setIsMaxCarryForwardLimitApplicable(
		boolean isMaxCarryForwardLimitApplicable) {
		_isMaxCarryForwardLimitApplicable = isMaxCarryForwardLimitApplicable;

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMaxCarryForwardLimitApplicable",
						boolean.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel,
					isMaxCarryForwardLimitApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaxCarryForwardLimit() {
		return _maxCarryForwardLimit;
	}

	@Override
	public void setMaxCarryForwardLimit(String maxCarryForwardLimit) {
		_maxCarryForwardLimit = maxCarryForwardLimit;

		if (_leaveCarryForwardPolicyRemoteModel != null) {
			try {
				Class<?> clazz = _leaveCarryForwardPolicyRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxCarryForwardLimit",
						String.class);

				method.invoke(_leaveCarryForwardPolicyRemoteModel,
					maxCarryForwardLimit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveCarryForwardPolicyRemoteModel() {
		return _leaveCarryForwardPolicyRemoteModel;
	}

	public void setLeaveCarryForwardPolicyRemoteModel(
		BaseModel<?> leaveCarryForwardPolicyRemoteModel) {
		_leaveCarryForwardPolicyRemoteModel = leaveCarryForwardPolicyRemoteModel;
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

		Class<?> remoteModelClass = _leaveCarryForwardPolicyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveCarryForwardPolicyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveCarryForwardPolicyLocalServiceUtil.addLeaveCarryForwardPolicy(this);
		}
		else {
			LeaveCarryForwardPolicyLocalServiceUtil.updateLeaveCarryForwardPolicy(this);
		}
	}

	@Override
	public LeaveCarryForwardPolicy toEscapedModel() {
		return (LeaveCarryForwardPolicy)ProxyUtil.newProxyInstance(LeaveCarryForwardPolicy.class.getClassLoader(),
			new Class[] { LeaveCarryForwardPolicy.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveCarryForwardPolicyClp clone = new LeaveCarryForwardPolicyClp();

		clone.setLeaveCarryForwardPolicyId(getLeaveCarryForwardPolicyId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setExpiryDuration(getExpiryDuration());
		clone.setExpiryDurationUOM(getExpiryDurationUOM());
		clone.setIsMaxCarryForwardLimitApplicable(getIsMaxCarryForwardLimitApplicable());
		clone.setMaxCarryForwardLimit(getMaxCarryForwardLimit());

		return clone;
	}

	@Override
	public int compareTo(LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		long primaryKey = leaveCarryForwardPolicy.getPrimaryKey();

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

		if (!(obj instanceof LeaveCarryForwardPolicyClp)) {
			return false;
		}

		LeaveCarryForwardPolicyClp leaveCarryForwardPolicy = (LeaveCarryForwardPolicyClp)obj;

		long primaryKey = leaveCarryForwardPolicy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{leaveCarryForwardPolicyId=");
		sb.append(getLeaveCarryForwardPolicyId());
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
		sb.append(", expiryDuration=");
		sb.append(getExpiryDuration());
		sb.append(", expiryDurationUOM=");
		sb.append(getExpiryDurationUOM());
		sb.append(", isMaxCarryForwardLimitApplicable=");
		sb.append(getIsMaxCarryForwardLimitApplicable());
		sb.append(", maxCarryForwardLimit=");
		sb.append(getMaxCarryForwardLimit());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveCarryForwardPolicyId</column-name><column-value><![CDATA[");
		sb.append(getLeaveCarryForwardPolicyId());
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
			"<column><column-name>expiryDuration</column-name><column-value><![CDATA[");
		sb.append(getExpiryDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDurationUOM</column-name><column-value><![CDATA[");
		sb.append(getExpiryDurationUOM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMaxCarryForwardLimitApplicable</column-name><column-value><![CDATA[");
		sb.append(getIsMaxCarryForwardLimitApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxCarryForwardLimit</column-name><column-value><![CDATA[");
		sb.append(getMaxCarryForwardLimit());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveCarryForwardPolicyId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private int _expiryDuration;
	private String _expiryDurationUOM;
	private boolean _isMaxCarryForwardLimitApplicable;
	private String _maxCarryForwardLimit;
	private BaseModel<?> _leaveCarryForwardPolicyRemoteModel;
}