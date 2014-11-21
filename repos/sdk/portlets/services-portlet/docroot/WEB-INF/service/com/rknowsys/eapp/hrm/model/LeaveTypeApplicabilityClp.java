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
import com.rknowsys.eapp.hrm.service.LeaveTypeApplicabilityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveTypeApplicabilityClp extends BaseModelImpl<LeaveTypeApplicability>
	implements LeaveTypeApplicability {
	public LeaveTypeApplicabilityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveTypeApplicability.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveTypeApplicability.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveTypeApplicabilityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveTypeApplicabilityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveTypeApplicabilityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeApplicabilityId", getLeaveTypeApplicabilityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("ifYearsOfServiceCriterionApplicable",
			getIfYearsOfServiceCriterionApplicable());
		attributes.put("minYearsOfService", getMinYearsOfService());
		attributes.put("maxYearsOfService", getMaxYearsOfService());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeApplicabilityId = (Long)attributes.get(
				"leaveTypeApplicabilityId");

		if (leaveTypeApplicabilityId != null) {
			setLeaveTypeApplicabilityId(leaveTypeApplicabilityId);
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

		Boolean ifYearsOfServiceCriterionApplicable = (Boolean)attributes.get(
				"ifYearsOfServiceCriterionApplicable");

		if (ifYearsOfServiceCriterionApplicable != null) {
			setIfYearsOfServiceCriterionApplicable(ifYearsOfServiceCriterionApplicable);
		}

		String minYearsOfService = (String)attributes.get("minYearsOfService");

		if (minYearsOfService != null) {
			setMinYearsOfService(minYearsOfService);
		}

		String maxYearsOfService = (String)attributes.get("maxYearsOfService");

		if (maxYearsOfService != null) {
			setMaxYearsOfService(maxYearsOfService);
		}
	}

	@Override
	public long getLeaveTypeApplicabilityId() {
		return _leaveTypeApplicabilityId;
	}

	@Override
	public void setLeaveTypeApplicabilityId(long leaveTypeApplicabilityId) {
		_leaveTypeApplicabilityId = leaveTypeApplicabilityId;

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeApplicabilityId",
						long.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel,
					leaveTypeApplicabilityId);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, companyId);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, groupId);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, createDate);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, modifiedDate);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, userId);
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

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfYearsOfServiceCriterionApplicable() {
		return _ifYearsOfServiceCriterionApplicable;
	}

	@Override
	public boolean isIfYearsOfServiceCriterionApplicable() {
		return _ifYearsOfServiceCriterionApplicable;
	}

	@Override
	public void setIfYearsOfServiceCriterionApplicable(
		boolean ifYearsOfServiceCriterionApplicable) {
		_ifYearsOfServiceCriterionApplicable = ifYearsOfServiceCriterionApplicable;

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setIfYearsOfServiceCriterionApplicable",
						boolean.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel,
					ifYearsOfServiceCriterionApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMinYearsOfService() {
		return _minYearsOfService;
	}

	@Override
	public void setMinYearsOfService(String minYearsOfService) {
		_minYearsOfService = minYearsOfService;

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setMinYearsOfService",
						String.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel,
					minYearsOfService);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaxYearsOfService() {
		return _maxYearsOfService;
	}

	@Override
	public void setMaxYearsOfService(String maxYearsOfService) {
		_maxYearsOfService = maxYearsOfService;

		if (_leaveTypeApplicabilityRemoteModel != null) {
			try {
				Class<?> clazz = _leaveTypeApplicabilityRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxYearsOfService",
						String.class);

				method.invoke(_leaveTypeApplicabilityRemoteModel,
					maxYearsOfService);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveTypeApplicabilityRemoteModel() {
		return _leaveTypeApplicabilityRemoteModel;
	}

	public void setLeaveTypeApplicabilityRemoteModel(
		BaseModel<?> leaveTypeApplicabilityRemoteModel) {
		_leaveTypeApplicabilityRemoteModel = leaveTypeApplicabilityRemoteModel;
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

		Class<?> remoteModelClass = _leaveTypeApplicabilityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveTypeApplicabilityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveTypeApplicabilityLocalServiceUtil.addLeaveTypeApplicability(this);
		}
		else {
			LeaveTypeApplicabilityLocalServiceUtil.updateLeaveTypeApplicability(this);
		}
	}

	@Override
	public LeaveTypeApplicability toEscapedModel() {
		return (LeaveTypeApplicability)ProxyUtil.newProxyInstance(LeaveTypeApplicability.class.getClassLoader(),
			new Class[] { LeaveTypeApplicability.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveTypeApplicabilityClp clone = new LeaveTypeApplicabilityClp();

		clone.setLeaveTypeApplicabilityId(getLeaveTypeApplicabilityId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setIfYearsOfServiceCriterionApplicable(getIfYearsOfServiceCriterionApplicable());
		clone.setMinYearsOfService(getMinYearsOfService());
		clone.setMaxYearsOfService(getMaxYearsOfService());

		return clone;
	}

	@Override
	public int compareTo(LeaveTypeApplicability leaveTypeApplicability) {
		long primaryKey = leaveTypeApplicability.getPrimaryKey();

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

		if (!(obj instanceof LeaveTypeApplicabilityClp)) {
			return false;
		}

		LeaveTypeApplicabilityClp leaveTypeApplicability = (LeaveTypeApplicabilityClp)obj;

		long primaryKey = leaveTypeApplicability.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{leaveTypeApplicabilityId=");
		sb.append(getLeaveTypeApplicabilityId());
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
		sb.append(", ifYearsOfServiceCriterionApplicable=");
		sb.append(getIfYearsOfServiceCriterionApplicable());
		sb.append(", minYearsOfService=");
		sb.append(getMinYearsOfService());
		sb.append(", maxYearsOfService=");
		sb.append(getMaxYearsOfService());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveTypeApplicability");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveTypeApplicabilityId</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeApplicabilityId());
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
			"<column><column-name>ifYearsOfServiceCriterionApplicable</column-name><column-value><![CDATA[");
		sb.append(getIfYearsOfServiceCriterionApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minYearsOfService</column-name><column-value><![CDATA[");
		sb.append(getMinYearsOfService());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxYearsOfService</column-name><column-value><![CDATA[");
		sb.append(getMaxYearsOfService());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveTypeApplicabilityId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private boolean _ifYearsOfServiceCriterionApplicable;
	private String _minYearsOfService;
	private String _maxYearsOfService;
	private BaseModel<?> _leaveTypeApplicabilityRemoteModel;
}