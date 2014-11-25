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
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpPersonalDetailsClp extends BaseModelImpl<EmpPersonalDetails>
	implements EmpPersonalDetails {
	public EmpPersonalDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpPersonalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpPersonalDetails.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empPersonalDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpPersonalDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empPersonalDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empPersonalDetailsId", getEmpPersonalDetailsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("otherId", getOtherId());
		attributes.put("licenseNo", getLicenseNo());
		attributes.put("licenseExpDate", getLicenseExpDate());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("dateOfBirth", getDateOfBirth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empPersonalDetailsId = (Long)attributes.get("empPersonalDetailsId");

		if (empPersonalDetailsId != null) {
			setEmpPersonalDetailsId(empPersonalDetailsId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
		}

		String otherId = (String)attributes.get("otherId");

		if (otherId != null) {
			setOtherId(otherId);
		}

		String licenseNo = (String)attributes.get("licenseNo");

		if (licenseNo != null) {
			setLicenseNo(licenseNo);
		}

		Date licenseExpDate = (Date)attributes.get("licenseExpDate");

		if (licenseExpDate != null) {
			setLicenseExpDate(licenseExpDate);
		}

		Long gender = (Long)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long maritalStatus = (Long)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}
	}

	@Override
	public long getEmpPersonalDetailsId() {
		return _empPersonalDetailsId;
	}

	@Override
	public void setEmpPersonalDetailsId(long empPersonalDetailsId) {
		_empPersonalDetailsId = empPersonalDetailsId;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpPersonalDetailsId",
						long.class);

				method.invoke(_empPersonalDetailsRemoteModel,
					empPersonalDetailsId);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, employeeId);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, groupId);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, companyId);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, userId);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empPersonalDetailsRemoteModel, createDate);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empPersonalDetailsRemoteModel, modifiedDate);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, firstName);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddleName() {
		return _middleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, middleName);
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

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeNo", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, employeeNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherId() {
		return _otherId;
	}

	@Override
	public void setOtherId(String otherId) {
		_otherId = otherId;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherId", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, otherId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLicenseNo() {
		return _licenseNo;
	}

	@Override
	public void setLicenseNo(String licenseNo) {
		_licenseNo = licenseNo;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseNo", String.class);

				method.invoke(_empPersonalDetailsRemoteModel, licenseNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLicenseExpDate() {
		return _licenseExpDate;
	}

	@Override
	public void setLicenseExpDate(Date licenseExpDate) {
		_licenseExpDate = licenseExpDate;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseExpDate", Date.class);

				method.invoke(_empPersonalDetailsRemoteModel, licenseExpDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGender() {
		return _gender;
	}

	@Override
	public void setGender(long gender) {
		_gender = gender;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMaritalStatus() {
		return _maritalStatus;
	}

	@Override
	public void setMaritalStatus(long maritalStatus) {
		_maritalStatus = maritalStatus;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaritalStatus", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, maritalStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNationalityId() {
		return _nationalityId;
	}

	@Override
	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalityId", long.class);

				method.invoke(_empPersonalDetailsRemoteModel, nationalityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;

		if (_empPersonalDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _empPersonalDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfBirth", Date.class);

				method.invoke(_empPersonalDetailsRemoteModel, dateOfBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpPersonalDetailsRemoteModel() {
		return _empPersonalDetailsRemoteModel;
	}

	public void setEmpPersonalDetailsRemoteModel(
		BaseModel<?> empPersonalDetailsRemoteModel) {
		_empPersonalDetailsRemoteModel = empPersonalDetailsRemoteModel;
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

		Class<?> remoteModelClass = _empPersonalDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empPersonalDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpPersonalDetailsLocalServiceUtil.addEmpPersonalDetails(this);
		}
		else {
			EmpPersonalDetailsLocalServiceUtil.updateEmpPersonalDetails(this);
		}
	}

	@Override
	public EmpPersonalDetails toEscapedModel() {
		return (EmpPersonalDetails)ProxyUtil.newProxyInstance(EmpPersonalDetails.class.getClassLoader(),
			new Class[] { EmpPersonalDetails.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpPersonalDetailsClp clone = new EmpPersonalDetailsClp();

		clone.setEmpPersonalDetailsId(getEmpPersonalDetailsId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setMiddleName(getMiddleName());
		clone.setEmployeeNo(getEmployeeNo());
		clone.setOtherId(getOtherId());
		clone.setLicenseNo(getLicenseNo());
		clone.setLicenseExpDate(getLicenseExpDate());
		clone.setGender(getGender());
		clone.setMaritalStatus(getMaritalStatus());
		clone.setNationalityId(getNationalityId());
		clone.setDateOfBirth(getDateOfBirth());

		return clone;
	}

	@Override
	public int compareTo(EmpPersonalDetails empPersonalDetails) {
		long primaryKey = empPersonalDetails.getPrimaryKey();

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

		if (!(obj instanceof EmpPersonalDetailsClp)) {
			return false;
		}

		EmpPersonalDetailsClp empPersonalDetails = (EmpPersonalDetailsClp)obj;

		long primaryKey = empPersonalDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{empPersonalDetailsId=");
		sb.append(getEmpPersonalDetailsId());
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
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", employeeNo=");
		sb.append(getEmployeeNo());
		sb.append(", otherId=");
		sb.append(getOtherId());
		sb.append(", licenseNo=");
		sb.append(getLicenseNo());
		sb.append(", licenseExpDate=");
		sb.append(getLicenseExpDate());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", maritalStatus=");
		sb.append(getMaritalStatus());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", dateOfBirth=");
		sb.append(getDateOfBirth());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpPersonalDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empPersonalDetailsId</column-name><column-value><![CDATA[");
		sb.append(getEmpPersonalDetailsId());
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
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNo</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherId</column-name><column-value><![CDATA[");
		sb.append(getOtherId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>licenseNo</column-name><column-value><![CDATA[");
		sb.append(getLicenseNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>licenseExpDate</column-name><column-value><![CDATA[");
		sb.append(getLicenseExpDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritalStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfBirth</column-name><column-value><![CDATA[");
		sb.append(getDateOfBirth());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empPersonalDetailsId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _employeeNo;
	private String _otherId;
	private String _licenseNo;
	private Date _licenseExpDate;
	private long _gender;
	private long _maritalStatus;
	private long _nationalityId;
	private Date _dateOfBirth;
	private BaseModel<?> _empPersonalDetailsRemoteModel;
}