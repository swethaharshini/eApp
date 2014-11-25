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
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class SalaryComponentClp extends BaseModelImpl<SalaryComponent>
	implements SalaryComponent {
	public SalaryComponentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SalaryComponent.class;
	}

	@Override
	public String getModelClassName() {
		return SalaryComponent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _salaryComponentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSalaryComponentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _salaryComponentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("salaryComponentId", getSalaryComponentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("componentName", getComponentName());
		attributes.put("type", getType());
		attributes.put("onlyCTC", getOnlyCTC());
		attributes.put("valueType", getValueType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long salaryComponentId = (Long)attributes.get("salaryComponentId");

		if (salaryComponentId != null) {
			setSalaryComponentId(salaryComponentId);
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

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		Boolean type = (Boolean)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean onlyCTC = (Boolean)attributes.get("onlyCTC");

		if (onlyCTC != null) {
			setOnlyCTC(onlyCTC);
		}

		String valueType = (String)attributes.get("valueType");

		if (valueType != null) {
			setValueType(valueType);
		}
	}

	@Override
	public long getSalaryComponentId() {
		return _salaryComponentId;
	}

	@Override
	public void setSalaryComponentId(long salaryComponentId) {
		_salaryComponentId = salaryComponentId;

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setSalaryComponentId",
						long.class);

				method.invoke(_salaryComponentRemoteModel, salaryComponentId);
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

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_salaryComponentRemoteModel, companyId);
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

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_salaryComponentRemoteModel, groupId);
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

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_salaryComponentRemoteModel, createDate);
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

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_salaryComponentRemoteModel, modifiedDate);
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

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_salaryComponentRemoteModel, userId);
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
	public String getComponentName() {
		return _componentName;
	}

	@Override
	public void setComponentName(String componentName) {
		_componentName = componentName;

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setComponentName", String.class);

				method.invoke(_salaryComponentRemoteModel, componentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getType() {
		return _type;
	}

	@Override
	public boolean isType() {
		return _type;
	}

	@Override
	public void setType(boolean type) {
		_type = type;

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setType", boolean.class);

				method.invoke(_salaryComponentRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOnlyCTC() {
		return _onlyCTC;
	}

	@Override
	public boolean isOnlyCTC() {
		return _onlyCTC;
	}

	@Override
	public void setOnlyCTC(boolean onlyCTC) {
		_onlyCTC = onlyCTC;

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setOnlyCTC", boolean.class);

				method.invoke(_salaryComponentRemoteModel, onlyCTC);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValueType() {
		return _valueType;
	}

	@Override
	public void setValueType(String valueType) {
		_valueType = valueType;

		if (_salaryComponentRemoteModel != null) {
			try {
				Class<?> clazz = _salaryComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setValueType", String.class);

				method.invoke(_salaryComponentRemoteModel, valueType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSalaryComponentRemoteModel() {
		return _salaryComponentRemoteModel;
	}

	public void setSalaryComponentRemoteModel(
		BaseModel<?> salaryComponentRemoteModel) {
		_salaryComponentRemoteModel = salaryComponentRemoteModel;
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

		Class<?> remoteModelClass = _salaryComponentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_salaryComponentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SalaryComponentLocalServiceUtil.addSalaryComponent(this);
		}
		else {
			SalaryComponentLocalServiceUtil.updateSalaryComponent(this);
		}
	}

	@Override
	public SalaryComponent toEscapedModel() {
		return (SalaryComponent)ProxyUtil.newProxyInstance(SalaryComponent.class.getClassLoader(),
			new Class[] { SalaryComponent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SalaryComponentClp clone = new SalaryComponentClp();

		clone.setSalaryComponentId(getSalaryComponentId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setComponentName(getComponentName());
		clone.setType(getType());
		clone.setOnlyCTC(getOnlyCTC());
		clone.setValueType(getValueType());

		return clone;
	}

	@Override
	public int compareTo(SalaryComponent salaryComponent) {
		long primaryKey = salaryComponent.getPrimaryKey();

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

		if (!(obj instanceof SalaryComponentClp)) {
			return false;
		}

		SalaryComponentClp salaryComponent = (SalaryComponentClp)obj;

		long primaryKey = salaryComponent.getPrimaryKey();

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

		sb.append("{salaryComponentId=");
		sb.append(getSalaryComponentId());
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
		sb.append(", componentName=");
		sb.append(getComponentName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", onlyCTC=");
		sb.append(getOnlyCTC());
		sb.append(", valueType=");
		sb.append(getValueType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.SalaryComponent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>salaryComponentId</column-name><column-value><![CDATA[");
		sb.append(getSalaryComponentId());
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
			"<column><column-name>componentName</column-name><column-value><![CDATA[");
		sb.append(getComponentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>onlyCTC</column-name><column-value><![CDATA[");
		sb.append(getOnlyCTC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valueType</column-name><column-value><![CDATA[");
		sb.append(getValueType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _salaryComponentId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _componentName;
	private boolean _type;
	private boolean _onlyCTC;
	private String _valueType;
	private BaseModel<?> _salaryComponentRemoteModel;
}