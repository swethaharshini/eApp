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
import com.rknowsys.eapp.hrm.service.TerminationReasonsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class TerminationReasonsClp extends BaseModelImpl<TerminationReasons>
	implements TerminationReasons {
	public TerminationReasonsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TerminationReasons.class;
	}

	@Override
	public String getModelClassName() {
		return TerminationReasons.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _terminationreasonsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTerminationreasonsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _terminationreasonsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("terminationreasonsId", getTerminationreasonsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("terminationreasonsName", getTerminationreasonsName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long terminationreasonsId = (Long)attributes.get("terminationreasonsId");

		if (terminationreasonsId != null) {
			setTerminationreasonsId(terminationreasonsId);
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

		String terminationreasonsName = (String)attributes.get(
				"terminationreasonsName");

		if (terminationreasonsName != null) {
			setTerminationreasonsName(terminationreasonsName);
		}
	}

	@Override
	public long getTerminationreasonsId() {
		return _terminationreasonsId;
	}

	@Override
	public void setTerminationreasonsId(long terminationreasonsId) {
		_terminationreasonsId = terminationreasonsId;

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setTerminationreasonsId",
						long.class);

				method.invoke(_terminationReasonsRemoteModel,
					terminationreasonsId);
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

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_terminationReasonsRemoteModel, companyId);
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

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_terminationReasonsRemoteModel, groupId);
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

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_terminationReasonsRemoteModel, createDate);
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

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_terminationReasonsRemoteModel, modifiedDate);
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

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_terminationReasonsRemoteModel, userId);
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
	public String getTerminationreasonsName() {
		return _terminationreasonsName;
	}

	@Override
	public void setTerminationreasonsName(String terminationreasonsName) {
		_terminationreasonsName = terminationreasonsName;

		if (_terminationReasonsRemoteModel != null) {
			try {
				Class<?> clazz = _terminationReasonsRemoteModel.getClass();

				Method method = clazz.getMethod("setTerminationreasonsName",
						String.class);

				method.invoke(_terminationReasonsRemoteModel,
					terminationreasonsName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTerminationReasonsRemoteModel() {
		return _terminationReasonsRemoteModel;
	}

	public void setTerminationReasonsRemoteModel(
		BaseModel<?> terminationReasonsRemoteModel) {
		_terminationReasonsRemoteModel = terminationReasonsRemoteModel;
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

		Class<?> remoteModelClass = _terminationReasonsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_terminationReasonsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TerminationReasonsLocalServiceUtil.addTerminationReasons(this);
		}
		else {
			TerminationReasonsLocalServiceUtil.updateTerminationReasons(this);
		}
	}

	@Override
	public TerminationReasons toEscapedModel() {
		return (TerminationReasons)ProxyUtil.newProxyInstance(TerminationReasons.class.getClassLoader(),
			new Class[] { TerminationReasons.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TerminationReasonsClp clone = new TerminationReasonsClp();

		clone.setTerminationreasonsId(getTerminationreasonsId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setTerminationreasonsName(getTerminationreasonsName());

		return clone;
	}

	@Override
	public int compareTo(TerminationReasons terminationReasons) {
		long primaryKey = terminationReasons.getPrimaryKey();

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

		if (!(obj instanceof TerminationReasonsClp)) {
			return false;
		}

		TerminationReasonsClp terminationReasons = (TerminationReasonsClp)obj;

		long primaryKey = terminationReasons.getPrimaryKey();

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

		sb.append("{terminationreasonsId=");
		sb.append(getTerminationreasonsId());
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
		sb.append(", terminationreasonsName=");
		sb.append(getTerminationreasonsName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.TerminationReasons");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>terminationreasonsId</column-name><column-value><![CDATA[");
		sb.append(getTerminationreasonsId());
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
			"<column><column-name>terminationreasonsName</column-name><column-value><![CDATA[");
		sb.append(getTerminationreasonsName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _terminationreasonsId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _terminationreasonsName;
	private BaseModel<?> _terminationReasonsRemoteModel;
}