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
import com.rknowsys.eapp.hrm.service.EmpLanguageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpLanguageClp extends BaseModelImpl<EmpLanguage>
	implements EmpLanguage {
	public EmpLanguageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpLanguage.class;
	}

	@Override
	public String getModelClassName() {
		return EmpLanguage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empLanguageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpLanguageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empLanguageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empLanguageId", getEmpLanguageId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("languageId", getLanguageId());
		attributes.put("languageSkill", getLanguageSkill());
		attributes.put("languageFluency", getLanguageFluency());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empLanguageId = (Long)attributes.get("empLanguageId");

		if (empLanguageId != null) {
			setEmpLanguageId(empLanguageId);
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

		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String languageSkill = (String)attributes.get("languageSkill");

		if (languageSkill != null) {
			setLanguageSkill(languageSkill);
		}

		String languageFluency = (String)attributes.get("languageFluency");

		if (languageFluency != null) {
			setLanguageFluency(languageFluency);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public long getEmpLanguageId() {
		return _empLanguageId;
	}

	@Override
	public void setEmpLanguageId(long empLanguageId) {
		_empLanguageId = empLanguageId;

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpLanguageId", long.class);

				method.invoke(_empLanguageRemoteModel, empLanguageId);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empLanguageRemoteModel, employeeId);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empLanguageRemoteModel, groupId);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empLanguageRemoteModel, companyId);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empLanguageRemoteModel, createDate);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empLanguageRemoteModel, modifiedDate);
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

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empLanguageRemoteModel, userId);
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
	public long getLanguageId() {
		return _languageId;
	}

	@Override
	public void setLanguageId(long languageId) {
		_languageId = languageId;

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageId", long.class);

				method.invoke(_empLanguageRemoteModel, languageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageSkill() {
		return _languageSkill;
	}

	@Override
	public void setLanguageSkill(String languageSkill) {
		_languageSkill = languageSkill;

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageSkill", String.class);

				method.invoke(_empLanguageRemoteModel, languageSkill);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageFluency() {
		return _languageFluency;
	}

	@Override
	public void setLanguageFluency(String languageFluency) {
		_languageFluency = languageFluency;

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageFluency",
						String.class);

				method.invoke(_empLanguageRemoteModel, languageFluency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_empLanguageRemoteModel != null) {
			try {
				Class<?> clazz = _empLanguageRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_empLanguageRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpLanguageRemoteModel() {
		return _empLanguageRemoteModel;
	}

	public void setEmpLanguageRemoteModel(BaseModel<?> empLanguageRemoteModel) {
		_empLanguageRemoteModel = empLanguageRemoteModel;
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

		Class<?> remoteModelClass = _empLanguageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empLanguageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpLanguageLocalServiceUtil.addEmpLanguage(this);
		}
		else {
			EmpLanguageLocalServiceUtil.updateEmpLanguage(this);
		}
	}

	@Override
	public EmpLanguage toEscapedModel() {
		return (EmpLanguage)ProxyUtil.newProxyInstance(EmpLanguage.class.getClassLoader(),
			new Class[] { EmpLanguage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpLanguageClp clone = new EmpLanguageClp();

		clone.setEmpLanguageId(getEmpLanguageId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLanguageId(getLanguageId());
		clone.setLanguageSkill(getLanguageSkill());
		clone.setLanguageFluency(getLanguageFluency());
		clone.setComments(getComments());

		return clone;
	}

	@Override
	public int compareTo(EmpLanguage empLanguage) {
		long primaryKey = empLanguage.getPrimaryKey();

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

		if (!(obj instanceof EmpLanguageClp)) {
			return false;
		}

		EmpLanguageClp empLanguage = (EmpLanguageClp)obj;

		long primaryKey = empLanguage.getPrimaryKey();

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

		sb.append("{empLanguageId=");
		sb.append(getEmpLanguageId());
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
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", languageSkill=");
		sb.append(getLanguageSkill());
		sb.append(", languageFluency=");
		sb.append(getLanguageFluency());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpLanguage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empLanguageId</column-name><column-value><![CDATA[");
		sb.append(getEmpLanguageId());
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
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageSkill</column-name><column-value><![CDATA[");
		sb.append(getLanguageSkill());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageFluency</column-name><column-value><![CDATA[");
		sb.append(getLanguageFluency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empLanguageId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _languageId;
	private String _languageSkill;
	private String _languageFluency;
	private String _comments;
	private BaseModel<?> _empLanguageRemoteModel;
}