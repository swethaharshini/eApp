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
import com.rknowsys.eapp.hrm.service.WorkWeekLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class WorkWeekClp extends BaseModelImpl<WorkWeek> implements WorkWeek {
	public WorkWeekClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkWeek.class;
	}

	@Override
	public String getModelClassName() {
		return WorkWeek.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workWeekId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkWeekId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workWeekId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workWeekId", getWorkWeekId());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("mondayWorkSchedule", getMondayWorkSchedule());
		attributes.put("tuesdayWorkSchedule", getTuesdayWorkSchedule());
		attributes.put("wednesdayWorkSchedule", getWednesdayWorkSchedule());
		attributes.put("thursdayWorkSchedule", getThursdayWorkSchedule());
		attributes.put("fridayWorkSchedule", getFridayWorkSchedule());
		attributes.put("saturdayWorkSchedule", getSaturdayWorkSchedule());
		attributes.put("sundayWorkSchedule", getSundayWorkSchedule());
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
		Long workWeekId = (Long)attributes.get("workWeekId");

		if (workWeekId != null) {
			setWorkWeekId(workWeekId);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		Integer mondayWorkSchedule = (Integer)attributes.get(
				"mondayWorkSchedule");

		if (mondayWorkSchedule != null) {
			setMondayWorkSchedule(mondayWorkSchedule);
		}

		Integer tuesdayWorkSchedule = (Integer)attributes.get(
				"tuesdayWorkSchedule");

		if (tuesdayWorkSchedule != null) {
			setTuesdayWorkSchedule(tuesdayWorkSchedule);
		}

		Integer wednesdayWorkSchedule = (Integer)attributes.get(
				"wednesdayWorkSchedule");

		if (wednesdayWorkSchedule != null) {
			setWednesdayWorkSchedule(wednesdayWorkSchedule);
		}

		Integer thursdayWorkSchedule = (Integer)attributes.get(
				"thursdayWorkSchedule");

		if (thursdayWorkSchedule != null) {
			setThursdayWorkSchedule(thursdayWorkSchedule);
		}

		Integer fridayWorkSchedule = (Integer)attributes.get(
				"fridayWorkSchedule");

		if (fridayWorkSchedule != null) {
			setFridayWorkSchedule(fridayWorkSchedule);
		}

		Integer saturdayWorkSchedule = (Integer)attributes.get(
				"saturdayWorkSchedule");

		if (saturdayWorkSchedule != null) {
			setSaturdayWorkSchedule(saturdayWorkSchedule);
		}

		Integer sundayWorkSchedule = (Integer)attributes.get(
				"sundayWorkSchedule");

		if (sundayWorkSchedule != null) {
			setSundayWorkSchedule(sundayWorkSchedule);
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
	public long getWorkWeekId() {
		return _workWeekId;
	}

	@Override
	public void setWorkWeekId(long workWeekId) {
		_workWeekId = workWeekId;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkWeekId", long.class);

				method.invoke(_workWeekRemoteModel, workWeekId);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalityId", long.class);

				method.invoke(_workWeekRemoteModel, nationalityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMondayWorkSchedule() {
		return _mondayWorkSchedule;
	}

	@Override
	public void setMondayWorkSchedule(int mondayWorkSchedule) {
		_mondayWorkSchedule = mondayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setMondayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, mondayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTuesdayWorkSchedule() {
		return _tuesdayWorkSchedule;
	}

	@Override
	public void setTuesdayWorkSchedule(int tuesdayWorkSchedule) {
		_tuesdayWorkSchedule = tuesdayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setTuesdayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, tuesdayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWednesdayWorkSchedule() {
		return _wednesdayWorkSchedule;
	}

	@Override
	public void setWednesdayWorkSchedule(int wednesdayWorkSchedule) {
		_wednesdayWorkSchedule = wednesdayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setWednesdayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, wednesdayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getThursdayWorkSchedule() {
		return _thursdayWorkSchedule;
	}

	@Override
	public void setThursdayWorkSchedule(int thursdayWorkSchedule) {
		_thursdayWorkSchedule = thursdayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setThursdayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, thursdayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFridayWorkSchedule() {
		return _fridayWorkSchedule;
	}

	@Override
	public void setFridayWorkSchedule(int fridayWorkSchedule) {
		_fridayWorkSchedule = fridayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setFridayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, fridayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSaturdayWorkSchedule() {
		return _saturdayWorkSchedule;
	}

	@Override
	public void setSaturdayWorkSchedule(int saturdayWorkSchedule) {
		_saturdayWorkSchedule = saturdayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setSaturdayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, saturdayWorkSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSundayWorkSchedule() {
		return _sundayWorkSchedule;
	}

	@Override
	public void setSundayWorkSchedule(int sundayWorkSchedule) {
		_sundayWorkSchedule = sundayWorkSchedule;

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setSundayWorkSchedule",
						int.class);

				method.invoke(_workWeekRemoteModel, sundayWorkSchedule);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workWeekRemoteModel, groupId);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workWeekRemoteModel, companyId);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_workWeekRemoteModel, userId);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_workWeekRemoteModel, userName);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_workWeekRemoteModel, createDate);
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

		if (_workWeekRemoteModel != null) {
			try {
				Class<?> clazz = _workWeekRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workWeekRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkWeekRemoteModel() {
		return _workWeekRemoteModel;
	}

	public void setWorkWeekRemoteModel(BaseModel<?> workWeekRemoteModel) {
		_workWeekRemoteModel = workWeekRemoteModel;
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

		Class<?> remoteModelClass = _workWeekRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workWeekRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkWeekLocalServiceUtil.addWorkWeek(this);
		}
		else {
			WorkWeekLocalServiceUtil.updateWorkWeek(this);
		}
	}

	@Override
	public WorkWeek toEscapedModel() {
		return (WorkWeek)ProxyUtil.newProxyInstance(WorkWeek.class.getClassLoader(),
			new Class[] { WorkWeek.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkWeekClp clone = new WorkWeekClp();

		clone.setWorkWeekId(getWorkWeekId());
		clone.setNationalityId(getNationalityId());
		clone.setMondayWorkSchedule(getMondayWorkSchedule());
		clone.setTuesdayWorkSchedule(getTuesdayWorkSchedule());
		clone.setWednesdayWorkSchedule(getWednesdayWorkSchedule());
		clone.setThursdayWorkSchedule(getThursdayWorkSchedule());
		clone.setFridayWorkSchedule(getFridayWorkSchedule());
		clone.setSaturdayWorkSchedule(getSaturdayWorkSchedule());
		clone.setSundayWorkSchedule(getSundayWorkSchedule());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(WorkWeek workWeek) {
		long primaryKey = workWeek.getPrimaryKey();

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

		if (!(obj instanceof WorkWeekClp)) {
			return false;
		}

		WorkWeekClp workWeek = (WorkWeekClp)obj;

		long primaryKey = workWeek.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{workWeekId=");
		sb.append(getWorkWeekId());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", mondayWorkSchedule=");
		sb.append(getMondayWorkSchedule());
		sb.append(", tuesdayWorkSchedule=");
		sb.append(getTuesdayWorkSchedule());
		sb.append(", wednesdayWorkSchedule=");
		sb.append(getWednesdayWorkSchedule());
		sb.append(", thursdayWorkSchedule=");
		sb.append(getThursdayWorkSchedule());
		sb.append(", fridayWorkSchedule=");
		sb.append(getFridayWorkSchedule());
		sb.append(", saturdayWorkSchedule=");
		sb.append(getSaturdayWorkSchedule());
		sb.append(", sundayWorkSchedule=");
		sb.append(getSundayWorkSchedule());
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
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.WorkWeek");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workWeekId</column-name><column-value><![CDATA[");
		sb.append(getWorkWeekId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mondayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getMondayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tuesdayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getTuesdayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wednesdayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getWednesdayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thursdayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getThursdayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fridayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getFridayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>saturdayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getSaturdayWorkSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sundayWorkSchedule</column-name><column-value><![CDATA[");
		sb.append(getSundayWorkSchedule());
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

	private long _workWeekId;
	private long _nationalityId;
	private int _mondayWorkSchedule;
	private int _tuesdayWorkSchedule;
	private int _wednesdayWorkSchedule;
	private int _thursdayWorkSchedule;
	private int _fridayWorkSchedule;
	private int _saturdayWorkSchedule;
	private int _sundayWorkSchedule;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _workWeekRemoteModel;
}