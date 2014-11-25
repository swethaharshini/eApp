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
import com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class HolidayClp extends BaseModelImpl<Holiday> implements Holiday {
	public HolidayClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Holiday.class;
	}

	@Override
	public String getModelClassName() {
		return Holiday.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _holidayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHolidayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _holidayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("holidayId", getHolidayId());
		attributes.put("holidayName", getHolidayName());
		attributes.put("isAnnual", getIsAnnual());
		attributes.put("isFullDay", getIsFullDay());
		attributes.put("holidayDate", getHolidayDate());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long holidayId = (Long)attributes.get("holidayId");

		if (holidayId != null) {
			setHolidayId(holidayId);
		}

		String holidayName = (String)attributes.get("holidayName");

		if (holidayName != null) {
			setHolidayName(holidayName);
		}

		Boolean isAnnual = (Boolean)attributes.get("isAnnual");

		if (isAnnual != null) {
			setIsAnnual(isAnnual);
		}

		Boolean isFullDay = (Boolean)attributes.get("isFullDay");

		if (isFullDay != null) {
			setIsFullDay(isFullDay);
		}

		Date holidayDate = (Date)attributes.get("holidayDate");

		if (holidayDate != null) {
			setHolidayDate(holidayDate);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getHolidayId() {
		return _holidayId;
	}

	@Override
	public void setHolidayId(long holidayId) {
		_holidayId = holidayId;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayId", long.class);

				method.invoke(_holidayRemoteModel, holidayId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHolidayName() {
		return _holidayName;
	}

	@Override
	public void setHolidayName(String holidayName) {
		_holidayName = holidayName;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayName", String.class);

				method.invoke(_holidayRemoteModel, holidayName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsAnnual() {
		return _isAnnual;
	}

	@Override
	public boolean isIsAnnual() {
		return _isAnnual;
	}

	@Override
	public void setIsAnnual(boolean isAnnual) {
		_isAnnual = isAnnual;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setIsAnnual", boolean.class);

				method.invoke(_holidayRemoteModel, isAnnual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsFullDay() {
		return _isFullDay;
	}

	@Override
	public boolean isIsFullDay() {
		return _isFullDay;
	}

	@Override
	public void setIsFullDay(boolean isFullDay) {
		_isFullDay = isFullDay;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setIsFullDay", boolean.class);

				method.invoke(_holidayRemoteModel, isFullDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getHolidayDate() {
		return _holidayDate;
	}

	@Override
	public void setHolidayDate(Date holidayDate) {
		_holidayDate = holidayDate;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidayDate", Date.class);

				method.invoke(_holidayRemoteModel, holidayDate);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalityId", long.class);

				method.invoke(_holidayRemoteModel, nationalityId);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_holidayRemoteModel, groupId);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_holidayRemoteModel, companyId);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_holidayRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_holidayRemoteModel, userName);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_holidayRemoteModel, createDate);
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

		if (_holidayRemoteModel != null) {
			try {
				Class<?> clazz = _holidayRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_holidayRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHolidayRemoteModel() {
		return _holidayRemoteModel;
	}

	public void setHolidayRemoteModel(BaseModel<?> holidayRemoteModel) {
		_holidayRemoteModel = holidayRemoteModel;
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

		Class<?> remoteModelClass = _holidayRemoteModel.getClass();

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

		Object returnValue = method.invoke(_holidayRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HolidayLocalServiceUtil.addHoliday(this);
		}
		else {
			HolidayLocalServiceUtil.updateHoliday(this);
		}
	}

	@Override
	public Holiday toEscapedModel() {
		return (Holiday)ProxyUtil.newProxyInstance(Holiday.class.getClassLoader(),
			new Class[] { Holiday.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HolidayClp clone = new HolidayClp();

		clone.setHolidayId(getHolidayId());
		clone.setHolidayName(getHolidayName());
		clone.setIsAnnual(getIsAnnual());
		clone.setIsFullDay(getIsFullDay());
		clone.setHolidayDate(getHolidayDate());
		clone.setNationalityId(getNationalityId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Holiday holiday) {
		long primaryKey = holiday.getPrimaryKey();

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

		if (!(obj instanceof HolidayClp)) {
			return false;
		}

		HolidayClp holiday = (HolidayClp)obj;

		long primaryKey = holiday.getPrimaryKey();

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

		sb.append("{holidayId=");
		sb.append(getHolidayId());
		sb.append(", holidayName=");
		sb.append(getHolidayName());
		sb.append(", isAnnual=");
		sb.append(getIsAnnual());
		sb.append(", isFullDay=");
		sb.append(getIsFullDay());
		sb.append(", holidayDate=");
		sb.append(getHolidayDate());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Holiday");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>holidayId</column-name><column-value><![CDATA[");
		sb.append(getHolidayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayName</column-name><column-value><![CDATA[");
		sb.append(getHolidayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAnnual</column-name><column-value><![CDATA[");
		sb.append(getIsAnnual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isFullDay</column-name><column-value><![CDATA[");
		sb.append(getIsFullDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidayDate</column-name><column-value><![CDATA[");
		sb.append(getHolidayDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _holidayId;
	private String _holidayName;
	private boolean _isAnnual;
	private boolean _isFullDay;
	private Date _holidayDate;
	private long _nationalityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _holidayRemoteModel;
}