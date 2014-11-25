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
import com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class WorkshiftClp extends BaseModelImpl<Workshift> implements Workshift {
	public WorkshiftClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Workshift.class;
	}

	@Override
	public String getModelClassName() {
		return Workshift.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _shiftId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setShiftId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shiftId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shiftId", getShiftId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("workshiftName", getWorkshiftName());
		attributes.put("fromWorkHours", getFromWorkHours());
		attributes.put("toWorkHours", getToWorkHours());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
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

		String workshiftName = (String)attributes.get("workshiftName");

		if (workshiftName != null) {
			setWorkshiftName(workshiftName);
		}

		Date fromWorkHours = (Date)attributes.get("fromWorkHours");

		if (fromWorkHours != null) {
			setFromWorkHours(fromWorkHours);
		}

		Date toWorkHours = (Date)attributes.get("toWorkHours");

		if (toWorkHours != null) {
			setToWorkHours(toWorkHours);
		}
	}

	@Override
	public long getShiftId() {
		return _shiftId;
	}

	@Override
	public void setShiftId(long shiftId) {
		_shiftId = shiftId;

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setShiftId", long.class);

				method.invoke(_workshiftRemoteModel, shiftId);
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

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workshiftRemoteModel, companyId);
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

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workshiftRemoteModel, groupId);
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

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_workshiftRemoteModel, createDate);
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

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workshiftRemoteModel, modifiedDate);
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

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_workshiftRemoteModel, userId);
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
	public String getWorkshiftName() {
		return _workshiftName;
	}

	@Override
	public void setWorkshiftName(String workshiftName) {
		_workshiftName = workshiftName;

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkshiftName", String.class);

				method.invoke(_workshiftRemoteModel, workshiftName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFromWorkHours() {
		return _fromWorkHours;
	}

	@Override
	public void setFromWorkHours(Date fromWorkHours) {
		_fromWorkHours = fromWorkHours;

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setFromWorkHours", Date.class);

				method.invoke(_workshiftRemoteModel, fromWorkHours);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getToWorkHours() {
		return _toWorkHours;
	}

	@Override
	public void setToWorkHours(Date toWorkHours) {
		_toWorkHours = toWorkHours;

		if (_workshiftRemoteModel != null) {
			try {
				Class<?> clazz = _workshiftRemoteModel.getClass();

				Method method = clazz.getMethod("setToWorkHours", Date.class);

				method.invoke(_workshiftRemoteModel, toWorkHours);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkshiftRemoteModel() {
		return _workshiftRemoteModel;
	}

	public void setWorkshiftRemoteModel(BaseModel<?> workshiftRemoteModel) {
		_workshiftRemoteModel = workshiftRemoteModel;
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

		Class<?> remoteModelClass = _workshiftRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workshiftRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkshiftLocalServiceUtil.addWorkshift(this);
		}
		else {
			WorkshiftLocalServiceUtil.updateWorkshift(this);
		}
	}

	@Override
	public Workshift toEscapedModel() {
		return (Workshift)ProxyUtil.newProxyInstance(Workshift.class.getClassLoader(),
			new Class[] { Workshift.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkshiftClp clone = new WorkshiftClp();

		clone.setShiftId(getShiftId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setWorkshiftName(getWorkshiftName());
		clone.setFromWorkHours(getFromWorkHours());
		clone.setToWorkHours(getToWorkHours());

		return clone;
	}

	@Override
	public int compareTo(Workshift workshift) {
		long primaryKey = workshift.getPrimaryKey();

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

		if (!(obj instanceof WorkshiftClp)) {
			return false;
		}

		WorkshiftClp workshift = (WorkshiftClp)obj;

		long primaryKey = workshift.getPrimaryKey();

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

		sb.append("{shiftId=");
		sb.append(getShiftId());
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
		sb.append(", workshiftName=");
		sb.append(getWorkshiftName());
		sb.append(", fromWorkHours=");
		sb.append(getFromWorkHours());
		sb.append(", toWorkHours=");
		sb.append(getToWorkHours());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Workshift");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shiftId</column-name><column-value><![CDATA[");
		sb.append(getShiftId());
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
			"<column><column-name>workshiftName</column-name><column-value><![CDATA[");
		sb.append(getWorkshiftName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromWorkHours</column-name><column-value><![CDATA[");
		sb.append(getFromWorkHours());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toWorkHours</column-name><column-value><![CDATA[");
		sb.append(getToWorkHours());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shiftId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _workshiftName;
	private Date _fromWorkHours;
	private Date _toWorkHours;
	private BaseModel<?> _workshiftRemoteModel;
}