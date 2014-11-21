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
import com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpSalaryComponentClp extends BaseModelImpl<EmpSalaryComponent>
	implements EmpSalaryComponent {
	public EmpSalaryComponentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSalaryComponent.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSalaryComponent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empSalaryEarningId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpSalaryEarningId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empSalaryEarningId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSalaryEarningId", getEmpSalaryEarningId());
		attributes.put("empSalaryId", getEmpSalaryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("salaryComponentId", getSalaryComponentId());
		attributes.put("amount", getAmount());
		attributes.put("effectiveDate", getEffectiveDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSalaryEarningId = (Long)attributes.get("empSalaryEarningId");

		if (empSalaryEarningId != null) {
			setEmpSalaryEarningId(empSalaryEarningId);
		}

		Long empSalaryId = (Long)attributes.get("empSalaryId");

		if (empSalaryId != null) {
			setEmpSalaryId(empSalaryId);
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

		Long salaryComponentId = (Long)attributes.get("salaryComponentId");

		if (salaryComponentId != null) {
			setSalaryComponentId(salaryComponentId);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}
	}

	@Override
	public long getEmpSalaryEarningId() {
		return _empSalaryEarningId;
	}

	@Override
	public void setEmpSalaryEarningId(long empSalaryEarningId) {
		_empSalaryEarningId = empSalaryEarningId;

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpSalaryEarningId",
						long.class);

				method.invoke(_empSalaryComponentRemoteModel, empSalaryEarningId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmpSalaryId() {
		return _empSalaryId;
	}

	@Override
	public void setEmpSalaryId(long empSalaryId) {
		_empSalaryId = empSalaryId;

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpSalaryId", long.class);

				method.invoke(_empSalaryComponentRemoteModel, empSalaryId);
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

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empSalaryComponentRemoteModel, groupId);
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

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empSalaryComponentRemoteModel, companyId);
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

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empSalaryComponentRemoteModel, createDate);
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

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empSalaryComponentRemoteModel, modifiedDate);
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

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empSalaryComponentRemoteModel, userId);
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
	public long getSalaryComponentId() {
		return _salaryComponentId;
	}

	@Override
	public void setSalaryComponentId(long salaryComponentId) {
		_salaryComponentId = salaryComponentId;

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setSalaryComponentId",
						long.class);

				method.invoke(_empSalaryComponentRemoteModel, salaryComponentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(long amount) {
		_amount = amount;

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", long.class);

				method.invoke(_empSalaryComponentRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_empSalaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _empSalaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_empSalaryComponentRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpSalaryComponentRemoteModel() {
		return _empSalaryComponentRemoteModel;
	}

	public void setEmpSalaryComponentRemoteModel(
		BaseModel<?> empSalaryComponentRemoteModel) {
		_empSalaryComponentRemoteModel = empSalaryComponentRemoteModel;
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

		Class<?> remoteModelClass = _empSalaryComponentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empSalaryComponentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpSalaryComponentLocalServiceUtil.addEmpSalaryComponent(this);
		}
		else {
			EmpSalaryComponentLocalServiceUtil.updateEmpSalaryComponent(this);
		}
	}

	@Override
	public EmpSalaryComponent toEscapedModel() {
		return (EmpSalaryComponent)ProxyUtil.newProxyInstance(EmpSalaryComponent.class.getClassLoader(),
			new Class[] { EmpSalaryComponent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpSalaryComponentClp clone = new EmpSalaryComponentClp();

		clone.setEmpSalaryEarningId(getEmpSalaryEarningId());
		clone.setEmpSalaryId(getEmpSalaryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setSalaryComponentId(getSalaryComponentId());
		clone.setAmount(getAmount());
		clone.setEffectiveDate(getEffectiveDate());

		return clone;
	}

	@Override
	public int compareTo(EmpSalaryComponent empSalaryComponent) {
		long primaryKey = empSalaryComponent.getPrimaryKey();

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

		if (!(obj instanceof EmpSalaryComponentClp)) {
			return false;
		}

		EmpSalaryComponentClp empSalaryComponent = (EmpSalaryComponentClp)obj;

		long primaryKey = empSalaryComponent.getPrimaryKey();

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

		sb.append("{empSalaryEarningId=");
		sb.append(getEmpSalaryEarningId());
		sb.append(", empSalaryId=");
		sb.append(getEmpSalaryId());
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
		sb.append(", salaryComponentId=");
		sb.append(getSalaryComponentId());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpSalaryComponent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empSalaryEarningId</column-name><column-value><![CDATA[");
		sb.append(getEmpSalaryEarningId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empSalaryId</column-name><column-value><![CDATA[");
		sb.append(getEmpSalaryId());
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
			"<column><column-name>salaryComponentId</column-name><column-value><![CDATA[");
		sb.append(getSalaryComponentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empSalaryEarningId;
	private long _empSalaryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _salaryComponentId;
	private long _amount;
	private Date _effectiveDate;
	private BaseModel<?> _empSalaryComponentRemoteModel;
}