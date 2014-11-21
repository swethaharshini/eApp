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
import com.rknowsys.eapp.hrm.service.EmpSubordinateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpSubordinateClp extends BaseModelImpl<EmpSubordinate>
	implements EmpSubordinate {
	public EmpSubordinateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSubordinate.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSubordinate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empSubordinateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpSubordinateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empSubordinateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSubordinateId", getEmpSubordinateId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reporterEmployeeId", getReporterEmployeeId());
		attributes.put("reportingMethod", getReportingMethod());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSubordinateId = (Long)attributes.get("empSubordinateId");

		if (empSubordinateId != null) {
			setEmpSubordinateId(empSubordinateId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long reporterEmployeeId = (Long)attributes.get("reporterEmployeeId");

		if (reporterEmployeeId != null) {
			setReporterEmployeeId(reporterEmployeeId);
		}

		Long reportingMethod = (Long)attributes.get("reportingMethod");

		if (reportingMethod != null) {
			setReportingMethod(reportingMethod);
		}
	}

	@Override
	public long getEmpSubordinateId() {
		return _empSubordinateId;
	}

	@Override
	public void setEmpSubordinateId(long empSubordinateId) {
		_empSubordinateId = empSubordinateId;

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpSubordinateId",
						long.class);

				method.invoke(_empSubordinateRemoteModel, empSubordinateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empSubordinateRemoteModel, employeeId);
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

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empSubordinateRemoteModel, groupId);
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

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empSubordinateRemoteModel, companyId);
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

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empSubordinateRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empSubordinateRemoteModel, createDate);
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

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empSubordinateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReporterEmployeeId() {
		return _reporterEmployeeId;
	}

	@Override
	public void setReporterEmployeeId(long reporterEmployeeId) {
		_reporterEmployeeId = reporterEmployeeId;

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setReporterEmployeeId",
						long.class);

				method.invoke(_empSubordinateRemoteModel, reporterEmployeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReportingMethod() {
		return _reportingMethod;
	}

	@Override
	public void setReportingMethod(long reportingMethod) {
		_reportingMethod = reportingMethod;

		if (_empSubordinateRemoteModel != null) {
			try {
				Class<?> clazz = _empSubordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setReportingMethod", long.class);

				method.invoke(_empSubordinateRemoteModel, reportingMethod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpSubordinateRemoteModel() {
		return _empSubordinateRemoteModel;
	}

	public void setEmpSubordinateRemoteModel(
		BaseModel<?> empSubordinateRemoteModel) {
		_empSubordinateRemoteModel = empSubordinateRemoteModel;
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

		Class<?> remoteModelClass = _empSubordinateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empSubordinateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpSubordinateLocalServiceUtil.addEmpSubordinate(this);
		}
		else {
			EmpSubordinateLocalServiceUtil.updateEmpSubordinate(this);
		}
	}

	@Override
	public EmpSubordinate toEscapedModel() {
		return (EmpSubordinate)ProxyUtil.newProxyInstance(EmpSubordinate.class.getClassLoader(),
			new Class[] { EmpSubordinate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpSubordinateClp clone = new EmpSubordinateClp();

		clone.setEmpSubordinateId(getEmpSubordinateId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setReporterEmployeeId(getReporterEmployeeId());
		clone.setReportingMethod(getReportingMethod());

		return clone;
	}

	@Override
	public int compareTo(EmpSubordinate empSubordinate) {
		long primaryKey = empSubordinate.getPrimaryKey();

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

		if (!(obj instanceof EmpSubordinateClp)) {
			return false;
		}

		EmpSubordinateClp empSubordinate = (EmpSubordinateClp)obj;

		long primaryKey = empSubordinate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{empSubordinateId=");
		sb.append(getEmpSubordinateId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", reporterEmployeeId=");
		sb.append(getReporterEmployeeId());
		sb.append(", reportingMethod=");
		sb.append(getReportingMethod());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpSubordinate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empSubordinateId</column-name><column-value><![CDATA[");
		sb.append(getEmpSubordinateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>reporterEmployeeId</column-name><column-value><![CDATA[");
		sb.append(getReporterEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportingMethod</column-name><column-value><![CDATA[");
		sb.append(getReportingMethod());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empSubordinateId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _reporterEmployeeId;
	private long _reportingMethod;
	private BaseModel<?> _empSubordinateRemoteModel;
}