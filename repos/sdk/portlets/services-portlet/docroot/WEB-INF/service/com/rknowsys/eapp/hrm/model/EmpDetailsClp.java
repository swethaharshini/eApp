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
import com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpDetailsClp extends BaseModelImpl<EmpDetails>
	implements EmpDetails {
	public EmpDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDetails.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empdetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpdetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empdetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empdetailsId", getEmpdetailsId());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("title", getTitle());
		attributes.put("employmentstatus", getEmploymentstatus());
		attributes.put("name", getName());
		attributes.put("supervisor", getSupervisor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empdetailsId = (Long)attributes.get("empdetailsId");

		if (empdetailsId != null) {
			setEmpdetailsId(empdetailsId);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String employmentstatus = (String)attributes.get("employmentstatus");

		if (employmentstatus != null) {
			setEmploymentstatus(employmentstatus);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String supervisor = (String)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}
	}

	@Override
	public long getEmpdetailsId() {
		return _empdetailsId;
	}

	@Override
	public void setEmpdetailsId(long empdetailsId) {
		_empdetailsId = empdetailsId;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpdetailsId", long.class);

				method.invoke(_empDetailsRemoteModel, empdetailsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeNo() {
		return _employeeNo;
	}

	@Override
	public void setEmployeeNo(String employeeNo) {
		_employeeNo = employeeNo;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeNo", String.class);

				method.invoke(_empDetailsRemoteModel, employeeNo);
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

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empDetailsRemoteModel, companyId);
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

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empDetailsRemoteModel, userId);
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

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empDetailsRemoteModel, createDate);
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

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empDetailsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_empDetailsRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_empDetailsRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_empDetailsRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmploymentstatus() {
		return _employmentstatus;
	}

	@Override
	public void setEmploymentstatus(String employmentstatus) {
		_employmentstatus = employmentstatus;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentstatus",
						String.class);

				method.invoke(_empDetailsRemoteModel, employmentstatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_empDetailsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisor() {
		return _supervisor;
	}

	@Override
	public void setSupervisor(String supervisor) {
		_supervisor = supervisor;

		if (_empDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisor", String.class);

				method.invoke(_empDetailsRemoteModel, supervisor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpDetailsRemoteModel() {
		return _empDetailsRemoteModel;
	}

	public void setEmpDetailsRemoteModel(BaseModel<?> empDetailsRemoteModel) {
		_empDetailsRemoteModel = empDetailsRemoteModel;
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

		Class<?> remoteModelClass = _empDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpDetailsLocalServiceUtil.addEmpDetails(this);
		}
		else {
			EmpDetailsLocalServiceUtil.updateEmpDetails(this);
		}
	}

	@Override
	public EmpDetails toEscapedModel() {
		return (EmpDetails)ProxyUtil.newProxyInstance(EmpDetails.class.getClassLoader(),
			new Class[] { EmpDetails.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpDetailsClp clone = new EmpDetailsClp();

		clone.setEmpdetailsId(getEmpdetailsId());
		clone.setEmployeeNo(getEmployeeNo());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setTitle(getTitle());
		clone.setEmploymentstatus(getEmploymentstatus());
		clone.setName(getName());
		clone.setSupervisor(getSupervisor());

		return clone;
	}

	@Override
	public int compareTo(EmpDetails empDetails) {
		long primaryKey = empDetails.getPrimaryKey();

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

		if (!(obj instanceof EmpDetailsClp)) {
			return false;
		}

		EmpDetailsClp empDetails = (EmpDetailsClp)obj;

		long primaryKey = empDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{empdetailsId=");
		sb.append(getEmpdetailsId());
		sb.append(", employeeNo=");
		sb.append(getEmployeeNo());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", employmentstatus=");
		sb.append(getEmploymentstatus());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", supervisor=");
		sb.append(getSupervisor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empdetailsId</column-name><column-value><![CDATA[");
		sb.append(getEmpdetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNo</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNo());
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
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentstatus</column-name><column-value><![CDATA[");
		sb.append(getEmploymentstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisor</column-name><column-value><![CDATA[");
		sb.append(getSupervisor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empdetailsId;
	private String _employeeNo;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _title;
	private String _employmentstatus;
	private String _name;
	private String _supervisor;
	private BaseModel<?> _empDetailsRemoteModel;
}