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
import com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class ReportingMethodsClp extends BaseModelImpl<ReportingMethods>
	implements ReportingMethods {
	public ReportingMethodsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ReportingMethods.class;
	}

	@Override
	public String getModelClassName() {
		return ReportingMethods.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reportingmethodId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportingmethodId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportingmethodId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportingmethodId", getReportingmethodId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("reportingmethodName", getReportingmethodName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportingmethodId = (Long)attributes.get("reportingmethodId");

		if (reportingmethodId != null) {
			setReportingmethodId(reportingmethodId);
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

		String reportingmethodName = (String)attributes.get(
				"reportingmethodName");

		if (reportingmethodName != null) {
			setReportingmethodName(reportingmethodName);
		}
	}

	@Override
	public long getReportingmethodId() {
		return _reportingmethodId;
	}

	@Override
	public void setReportingmethodId(long reportingmethodId) {
		_reportingmethodId = reportingmethodId;

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setReportingmethodId",
						long.class);

				method.invoke(_reportingMethodsRemoteModel, reportingmethodId);
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

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_reportingMethodsRemoteModel, companyId);
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

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_reportingMethodsRemoteModel, groupId);
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

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_reportingMethodsRemoteModel, createDate);
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

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_reportingMethodsRemoteModel, modifiedDate);
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

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_reportingMethodsRemoteModel, userId);
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
	public String getReportingmethodName() {
		return _reportingmethodName;
	}

	@Override
	public void setReportingmethodName(String reportingmethodName) {
		_reportingmethodName = reportingmethodName;

		if (_reportingMethodsRemoteModel != null) {
			try {
				Class<?> clazz = _reportingMethodsRemoteModel.getClass();

				Method method = clazz.getMethod("setReportingmethodName",
						String.class);

				method.invoke(_reportingMethodsRemoteModel, reportingmethodName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReportingMethodsRemoteModel() {
		return _reportingMethodsRemoteModel;
	}

	public void setReportingMethodsRemoteModel(
		BaseModel<?> reportingMethodsRemoteModel) {
		_reportingMethodsRemoteModel = reportingMethodsRemoteModel;
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

		Class<?> remoteModelClass = _reportingMethodsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_reportingMethodsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReportingMethodsLocalServiceUtil.addReportingMethods(this);
		}
		else {
			ReportingMethodsLocalServiceUtil.updateReportingMethods(this);
		}
	}

	@Override
	public ReportingMethods toEscapedModel() {
		return (ReportingMethods)ProxyUtil.newProxyInstance(ReportingMethods.class.getClassLoader(),
			new Class[] { ReportingMethods.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReportingMethodsClp clone = new ReportingMethodsClp();

		clone.setReportingmethodId(getReportingmethodId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setReportingmethodName(getReportingmethodName());

		return clone;
	}

	@Override
	public int compareTo(ReportingMethods reportingMethods) {
		long primaryKey = reportingMethods.getPrimaryKey();

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

		if (!(obj instanceof ReportingMethodsClp)) {
			return false;
		}

		ReportingMethodsClp reportingMethods = (ReportingMethodsClp)obj;

		long primaryKey = reportingMethods.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{reportingmethodId=");
		sb.append(getReportingmethodId());
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
		sb.append(", reportingmethodName=");
		sb.append(getReportingmethodName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.ReportingMethods");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportingmethodId</column-name><column-value><![CDATA[");
		sb.append(getReportingmethodId());
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
			"<column><column-name>reportingmethodName</column-name><column-value><![CDATA[");
		sb.append(getReportingmethodName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _reportingmethodId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _reportingmethodName;
	private BaseModel<?> _reportingMethodsRemoteModel;
}