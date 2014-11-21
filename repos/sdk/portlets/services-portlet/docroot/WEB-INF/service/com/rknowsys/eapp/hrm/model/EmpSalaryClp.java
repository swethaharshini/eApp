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
import com.rknowsys.eapp.hrm.service.EmpSalaryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpSalaryClp extends BaseModelImpl<EmpSalary> implements EmpSalary {
	public EmpSalaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSalary.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSalary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empSalaryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpSalaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empSalaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSalaryId", getEmpSalaryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("payGradeId", getPayGradeId());
		attributes.put("payGradeCurrencyId", getPayGradeCurrencyId());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSalaryId = (Long)attributes.get("empSalaryId");

		if (empSalaryId != null) {
			setEmpSalaryId(empSalaryId);
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

		Long payGradeId = (Long)attributes.get("payGradeId");

		if (payGradeId != null) {
			setPayGradeId(payGradeId);
		}

		Long payGradeCurrencyId = (Long)attributes.get("payGradeCurrencyId");

		if (payGradeCurrencyId != null) {
			setPayGradeCurrencyId(payGradeCurrencyId);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	@Override
	public long getEmpSalaryId() {
		return _empSalaryId;
	}

	@Override
	public void setEmpSalaryId(long empSalaryId) {
		_empSalaryId = empSalaryId;

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpSalaryId", long.class);

				method.invoke(_empSalaryRemoteModel, empSalaryId);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empSalaryRemoteModel, employeeId);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empSalaryRemoteModel, groupId);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empSalaryRemoteModel, companyId);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empSalaryRemoteModel, createDate);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empSalaryRemoteModel, modifiedDate);
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

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empSalaryRemoteModel, userId);
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
	public long getPayGradeId() {
		return _payGradeId;
	}

	@Override
	public void setPayGradeId(long payGradeId) {
		_payGradeId = payGradeId;

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPayGradeId", long.class);

				method.invoke(_empSalaryRemoteModel, payGradeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPayGradeCurrencyId() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrencyId = payGradeCurrencyId;

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPayGradeCurrencyId",
						long.class);

				method.invoke(_empSalaryRemoteModel, payGradeCurrencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_empSalaryRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_empSalaryRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpSalaryRemoteModel() {
		return _empSalaryRemoteModel;
	}

	public void setEmpSalaryRemoteModel(BaseModel<?> empSalaryRemoteModel) {
		_empSalaryRemoteModel = empSalaryRemoteModel;
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

		Class<?> remoteModelClass = _empSalaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empSalaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpSalaryLocalServiceUtil.addEmpSalary(this);
		}
		else {
			EmpSalaryLocalServiceUtil.updateEmpSalary(this);
		}
	}

	@Override
	public EmpSalary toEscapedModel() {
		return (EmpSalary)ProxyUtil.newProxyInstance(EmpSalary.class.getClassLoader(),
			new Class[] { EmpSalary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpSalaryClp clone = new EmpSalaryClp();

		clone.setEmpSalaryId(getEmpSalaryId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setPayGradeId(getPayGradeId());
		clone.setPayGradeCurrencyId(getPayGradeCurrencyId());
		clone.setComment(getComment());

		return clone;
	}

	@Override
	public int compareTo(EmpSalary empSalary) {
		long primaryKey = empSalary.getPrimaryKey();

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

		if (!(obj instanceof EmpSalaryClp)) {
			return false;
		}

		EmpSalaryClp empSalary = (EmpSalaryClp)obj;

		long primaryKey = empSalary.getPrimaryKey();

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

		sb.append("{empSalaryId=");
		sb.append(getEmpSalaryId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", payGradeId=");
		sb.append(getPayGradeId());
		sb.append(", payGradeCurrencyId=");
		sb.append(getPayGradeCurrencyId());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpSalary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empSalaryId</column-name><column-value><![CDATA[");
		sb.append(getEmpSalaryId());
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
			"<column><column-name>payGradeId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payGradeCurrencyId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeCurrencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empSalaryId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _payGradeId;
	private long _payGradeCurrencyId;
	private String _comment;
	private BaseModel<?> _empSalaryRemoteModel;
}