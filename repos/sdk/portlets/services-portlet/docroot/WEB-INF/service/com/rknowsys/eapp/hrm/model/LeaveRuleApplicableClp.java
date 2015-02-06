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
import com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveRuleApplicableClp extends BaseModelImpl<LeaveRuleApplicable>
	implements LeaveRuleApplicable {
	public LeaveRuleApplicableClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRuleApplicable.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRuleApplicable.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveRuleApplicableId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveRuleApplicableId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveRuleApplicableId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveRuleApplicableId", getLeaveRuleApplicableId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("forFemale", getForFemale());
		attributes.put("forMale", getForMale());
		attributes.put("forYearsOfService", getForYearsOfService());
		attributes.put("fromYears", getFromYears());
		attributes.put("toYears", getToYears());
		attributes.put("forJobTitles", getForJobTitles());
		attributes.put("forJobCategories", getForJobCategories());
		attributes.put("forEmploymentStatus", getForEmploymentStatus());
		attributes.put("forGender", getForGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveRuleApplicableId = (Long)attributes.get(
				"leaveRuleApplicableId");

		if (leaveRuleApplicableId != null) {
			setLeaveRuleApplicableId(leaveRuleApplicableId);
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

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Boolean forFemale = (Boolean)attributes.get("forFemale");

		if (forFemale != null) {
			setForFemale(forFemale);
		}

		Boolean forMale = (Boolean)attributes.get("forMale");

		if (forMale != null) {
			setForMale(forMale);
		}

		Boolean forYearsOfService = (Boolean)attributes.get("forYearsOfService");

		if (forYearsOfService != null) {
			setForYearsOfService(forYearsOfService);
		}

		String fromYears = (String)attributes.get("fromYears");

		if (fromYears != null) {
			setFromYears(fromYears);
		}

		String toYears = (String)attributes.get("toYears");

		if (toYears != null) {
			setToYears(toYears);
		}

		Boolean forJobTitles = (Boolean)attributes.get("forJobTitles");

		if (forJobTitles != null) {
			setForJobTitles(forJobTitles);
		}

		Boolean forJobCategories = (Boolean)attributes.get("forJobCategories");

		if (forJobCategories != null) {
			setForJobCategories(forJobCategories);
		}

		Boolean forEmploymentStatus = (Boolean)attributes.get(
				"forEmploymentStatus");

		if (forEmploymentStatus != null) {
			setForEmploymentStatus(forEmploymentStatus);
		}

		Boolean forGender = (Boolean)attributes.get("forGender");

		if (forGender != null) {
			setForGender(forGender);
		}
	}

	@Override
	public long getLeaveRuleApplicableId() {
		return _leaveRuleApplicableId;
	}

	@Override
	public void setLeaveRuleApplicableId(long leaveRuleApplicableId) {
		_leaveRuleApplicableId = leaveRuleApplicableId;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRuleApplicableId",
						long.class);

				method.invoke(_leaveRuleApplicableRemoteModel,
					leaveRuleApplicableId);
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

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveRuleApplicableRemoteModel, companyId);
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

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveRuleApplicableRemoteModel, groupId);
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

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveRuleApplicableRemoteModel, createDate);
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

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveRuleApplicableRemoteModel, modifiedDate);
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

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveRuleApplicableRemoteModel, userId);
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
	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveRuleApplicableRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForFemale() {
		return _forFemale;
	}

	@Override
	public boolean isForFemale() {
		return _forFemale;
	}

	@Override
	public void setForFemale(boolean forFemale) {
		_forFemale = forFemale;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForFemale", boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forFemale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForMale() {
		return _forMale;
	}

	@Override
	public boolean isForMale() {
		return _forMale;
	}

	@Override
	public void setForMale(boolean forMale) {
		_forMale = forMale;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForMale", boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forMale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForYearsOfService() {
		return _forYearsOfService;
	}

	@Override
	public boolean isForYearsOfService() {
		return _forYearsOfService;
	}

	@Override
	public void setForYearsOfService(boolean forYearsOfService) {
		_forYearsOfService = forYearsOfService;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForYearsOfService",
						boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forYearsOfService);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromYears() {
		return _fromYears;
	}

	@Override
	public void setFromYears(String fromYears) {
		_fromYears = fromYears;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setFromYears", String.class);

				method.invoke(_leaveRuleApplicableRemoteModel, fromYears);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToYears() {
		return _toYears;
	}

	@Override
	public void setToYears(String toYears) {
		_toYears = toYears;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setToYears", String.class);

				method.invoke(_leaveRuleApplicableRemoteModel, toYears);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForJobTitles() {
		return _forJobTitles;
	}

	@Override
	public boolean isForJobTitles() {
		return _forJobTitles;
	}

	@Override
	public void setForJobTitles(boolean forJobTitles) {
		_forJobTitles = forJobTitles;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForJobTitles", boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forJobTitles);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForJobCategories() {
		return _forJobCategories;
	}

	@Override
	public boolean isForJobCategories() {
		return _forJobCategories;
	}

	@Override
	public void setForJobCategories(boolean forJobCategories) {
		_forJobCategories = forJobCategories;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForJobCategories",
						boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forJobCategories);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForEmploymentStatus() {
		return _forEmploymentStatus;
	}

	@Override
	public boolean isForEmploymentStatus() {
		return _forEmploymentStatus;
	}

	@Override
	public void setForEmploymentStatus(boolean forEmploymentStatus) {
		_forEmploymentStatus = forEmploymentStatus;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForEmploymentStatus",
						boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel,
					forEmploymentStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForGender() {
		return _forGender;
	}

	@Override
	public boolean isForGender() {
		return _forGender;
	}

	@Override
	public void setForGender(boolean forGender) {
		_forGender = forGender;

		if (_leaveRuleApplicableRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRuleApplicableRemoteModel.getClass();

				Method method = clazz.getMethod("setForGender", boolean.class);

				method.invoke(_leaveRuleApplicableRemoteModel, forGender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveRuleApplicableRemoteModel() {
		return _leaveRuleApplicableRemoteModel;
	}

	public void setLeaveRuleApplicableRemoteModel(
		BaseModel<?> leaveRuleApplicableRemoteModel) {
		_leaveRuleApplicableRemoteModel = leaveRuleApplicableRemoteModel;
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

		Class<?> remoteModelClass = _leaveRuleApplicableRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveRuleApplicableRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveRuleApplicableLocalServiceUtil.addLeaveRuleApplicable(this);
		}
		else {
			LeaveRuleApplicableLocalServiceUtil.updateLeaveRuleApplicable(this);
		}
	}

	@Override
	public LeaveRuleApplicable toEscapedModel() {
		return (LeaveRuleApplicable)ProxyUtil.newProxyInstance(LeaveRuleApplicable.class.getClassLoader(),
			new Class[] { LeaveRuleApplicable.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveRuleApplicableClp clone = new LeaveRuleApplicableClp();

		clone.setLeaveRuleApplicableId(getLeaveRuleApplicableId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setForFemale(getForFemale());
		clone.setForMale(getForMale());
		clone.setForYearsOfService(getForYearsOfService());
		clone.setFromYears(getFromYears());
		clone.setToYears(getToYears());
		clone.setForJobTitles(getForJobTitles());
		clone.setForJobCategories(getForJobCategories());
		clone.setForEmploymentStatus(getForEmploymentStatus());
		clone.setForGender(getForGender());

		return clone;
	}

	@Override
	public int compareTo(LeaveRuleApplicable leaveRuleApplicable) {
		long primaryKey = leaveRuleApplicable.getPrimaryKey();

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

		if (!(obj instanceof LeaveRuleApplicableClp)) {
			return false;
		}

		LeaveRuleApplicableClp leaveRuleApplicable = (LeaveRuleApplicableClp)obj;

		long primaryKey = leaveRuleApplicable.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveRuleApplicableId=");
		sb.append(getLeaveRuleApplicableId());
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
		sb.append(", leaveTypeId=");
		sb.append(getLeaveTypeId());
		sb.append(", forFemale=");
		sb.append(getForFemale());
		sb.append(", forMale=");
		sb.append(getForMale());
		sb.append(", forYearsOfService=");
		sb.append(getForYearsOfService());
		sb.append(", fromYears=");
		sb.append(getFromYears());
		sb.append(", toYears=");
		sb.append(getToYears());
		sb.append(", forJobTitles=");
		sb.append(getForJobTitles());
		sb.append(", forJobCategories=");
		sb.append(getForJobCategories());
		sb.append(", forEmploymentStatus=");
		sb.append(getForEmploymentStatus());
		sb.append(", forGender=");
		sb.append(getForGender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveRuleApplicable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveRuleApplicableId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRuleApplicableId());
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
			"<column><column-name>leaveTypeId</column-name><column-value><![CDATA[");
		sb.append(getLeaveTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forFemale</column-name><column-value><![CDATA[");
		sb.append(getForFemale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forMale</column-name><column-value><![CDATA[");
		sb.append(getForMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forYearsOfService</column-name><column-value><![CDATA[");
		sb.append(getForYearsOfService());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromYears</column-name><column-value><![CDATA[");
		sb.append(getFromYears());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toYears</column-name><column-value><![CDATA[");
		sb.append(getToYears());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forJobTitles</column-name><column-value><![CDATA[");
		sb.append(getForJobTitles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forJobCategories</column-name><column-value><![CDATA[");
		sb.append(getForJobCategories());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forEmploymentStatus</column-name><column-value><![CDATA[");
		sb.append(getForEmploymentStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forGender</column-name><column-value><![CDATA[");
		sb.append(getForGender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveRuleApplicableId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private boolean _forFemale;
	private boolean _forMale;
	private boolean _forYearsOfService;
	private String _fromYears;
	private String _toYears;
	private boolean _forJobTitles;
	private boolean _forJobCategories;
	private boolean _forEmploymentStatus;
	private boolean _forGender;
	private BaseModel<?> _leaveRuleApplicableRemoteModel;
}