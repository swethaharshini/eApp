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
import com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class LeaveRestrictionClp extends BaseModelImpl<LeaveRestriction>
	implements LeaveRestriction {
	public LeaveRestrictionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRestriction.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRestriction.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _leaveRestrictionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveRestrictionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveRestrictionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveRestrictionId", getLeaveRestrictionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("cannotExceedBalance", getCannotExceedBalance());
		attributes.put("cannotApplyForPartialDay", getCannotApplyForPartialDay());
		attributes.put("ifATermsQuestion", getIfATermsQuestion());
		attributes.put("termsQuestion", getTermsQuestion());
		attributes.put("errorTextIfTermsDeclined", getErrorTextIfTermsDeclined());
		attributes.put("isMinimumServicePeriodApplicable",
			getIsMinimumServicePeriodApplicable());
		attributes.put("minimumServicePeriod", getMinimumServicePeriod());
		attributes.put("isMaxConsecutiveLeavesApplicable",
			getIsMaxConsecutiveLeavesApplicable());
		attributes.put("maxConsecutiveLeaves", getMaxConsecutiveLeaves());
		attributes.put("isSmallChildCriterionApplicable",
			getIsSmallChildCriterionApplicable());
		attributes.put("maxSmallChildAgeApplicable",
			getMaxSmallChildAgeApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveRestrictionId = (Long)attributes.get("leaveRestrictionId");

		if (leaveRestrictionId != null) {
			setLeaveRestrictionId(leaveRestrictionId);
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

		Boolean cannotExceedBalance = (Boolean)attributes.get(
				"cannotExceedBalance");

		if (cannotExceedBalance != null) {
			setCannotExceedBalance(cannotExceedBalance);
		}

		Boolean cannotApplyForPartialDay = (Boolean)attributes.get(
				"cannotApplyForPartialDay");

		if (cannotApplyForPartialDay != null) {
			setCannotApplyForPartialDay(cannotApplyForPartialDay);
		}

		Boolean ifATermsQuestion = (Boolean)attributes.get("ifATermsQuestion");

		if (ifATermsQuestion != null) {
			setIfATermsQuestion(ifATermsQuestion);
		}

		String termsQuestion = (String)attributes.get("termsQuestion");

		if (termsQuestion != null) {
			setTermsQuestion(termsQuestion);
		}

		String errorTextIfTermsDeclined = (String)attributes.get(
				"errorTextIfTermsDeclined");

		if (errorTextIfTermsDeclined != null) {
			setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
		}

		Boolean isMinimumServicePeriodApplicable = (Boolean)attributes.get(
				"isMinimumServicePeriodApplicable");

		if (isMinimumServicePeriodApplicable != null) {
			setIsMinimumServicePeriodApplicable(isMinimumServicePeriodApplicable);
		}

		String minimumServicePeriod = (String)attributes.get(
				"minimumServicePeriod");

		if (minimumServicePeriod != null) {
			setMinimumServicePeriod(minimumServicePeriod);
		}

		Boolean isMaxConsecutiveLeavesApplicable = (Boolean)attributes.get(
				"isMaxConsecutiveLeavesApplicable");

		if (isMaxConsecutiveLeavesApplicable != null) {
			setIsMaxConsecutiveLeavesApplicable(isMaxConsecutiveLeavesApplicable);
		}

		String maxConsecutiveLeaves = (String)attributes.get(
				"maxConsecutiveLeaves");

		if (maxConsecutiveLeaves != null) {
			setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		}

		Boolean isSmallChildCriterionApplicable = (Boolean)attributes.get(
				"isSmallChildCriterionApplicable");

		if (isSmallChildCriterionApplicable != null) {
			setIsSmallChildCriterionApplicable(isSmallChildCriterionApplicable);
		}

		String maxSmallChildAgeApplicable = (String)attributes.get(
				"maxSmallChildAgeApplicable");

		if (maxSmallChildAgeApplicable != null) {
			setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		}
	}

	@Override
	public long getLeaveRestrictionId() {
		return _leaveRestrictionId;
	}

	@Override
	public void setLeaveRestrictionId(long leaveRestrictionId) {
		_leaveRestrictionId = leaveRestrictionId;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRestrictionId",
						long.class);

				method.invoke(_leaveRestrictionRemoteModel, leaveRestrictionId);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leaveRestrictionRemoteModel, companyId);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leaveRestrictionRemoteModel, groupId);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leaveRestrictionRemoteModel, createDate);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leaveRestrictionRemoteModel, modifiedDate);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaveRestrictionRemoteModel, userId);
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

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTypeId", long.class);

				method.invoke(_leaveRestrictionRemoteModel, leaveTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCannotExceedBalance() {
		return _cannotExceedBalance;
	}

	@Override
	public boolean isCannotExceedBalance() {
		return _cannotExceedBalance;
	}

	@Override
	public void setCannotExceedBalance(boolean cannotExceedBalance) {
		_cannotExceedBalance = cannotExceedBalance;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCannotExceedBalance",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel, cannotExceedBalance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	@Override
	public boolean isCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	@Override
	public void setCannotApplyForPartialDay(boolean cannotApplyForPartialDay) {
		_cannotApplyForPartialDay = cannotApplyForPartialDay;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCannotApplyForPartialDay",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel,
					cannotApplyForPartialDay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIfATermsQuestion() {
		return _ifATermsQuestion;
	}

	@Override
	public boolean isIfATermsQuestion() {
		return _ifATermsQuestion;
	}

	@Override
	public void setIfATermsQuestion(boolean ifATermsQuestion) {
		_ifATermsQuestion = ifATermsQuestion;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setIfATermsQuestion",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel, ifATermsQuestion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTermsQuestion() {
		return _termsQuestion;
	}

	@Override
	public void setTermsQuestion(String termsQuestion) {
		_termsQuestion = termsQuestion;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setTermsQuestion", String.class);

				method.invoke(_leaveRestrictionRemoteModel, termsQuestion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorTextIfTermsDeclined() {
		return _errorTextIfTermsDeclined;
	}

	@Override
	public void setErrorTextIfTermsDeclined(String errorTextIfTermsDeclined) {
		_errorTextIfTermsDeclined = errorTextIfTermsDeclined;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorTextIfTermsDeclined",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					errorTextIfTermsDeclined);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMinimumServicePeriodApplicable() {
		return _isMinimumServicePeriodApplicable;
	}

	@Override
	public boolean isIsMinimumServicePeriodApplicable() {
		return _isMinimumServicePeriodApplicable;
	}

	@Override
	public void setIsMinimumServicePeriodApplicable(
		boolean isMinimumServicePeriodApplicable) {
		_isMinimumServicePeriodApplicable = isMinimumServicePeriodApplicable;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMinimumServicePeriodApplicable",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel,
					isMinimumServicePeriodApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMinimumServicePeriod() {
		return _minimumServicePeriod;
	}

	@Override
	public void setMinimumServicePeriod(String minimumServicePeriod) {
		_minimumServicePeriod = minimumServicePeriod;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMinimumServicePeriod",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel, minimumServicePeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMaxConsecutiveLeavesApplicable() {
		return _isMaxConsecutiveLeavesApplicable;
	}

	@Override
	public boolean isIsMaxConsecutiveLeavesApplicable() {
		return _isMaxConsecutiveLeavesApplicable;
	}

	@Override
	public void setIsMaxConsecutiveLeavesApplicable(
		boolean isMaxConsecutiveLeavesApplicable) {
		_isMaxConsecutiveLeavesApplicable = isMaxConsecutiveLeavesApplicable;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMaxConsecutiveLeavesApplicable",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel,
					isMaxConsecutiveLeavesApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaxConsecutiveLeaves() {
		return _maxConsecutiveLeaves;
	}

	@Override
	public void setMaxConsecutiveLeaves(String maxConsecutiveLeaves) {
		_maxConsecutiveLeaves = maxConsecutiveLeaves;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxConsecutiveLeaves",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel, maxConsecutiveLeaves);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsSmallChildCriterionApplicable() {
		return _isSmallChildCriterionApplicable;
	}

	@Override
	public boolean isIsSmallChildCriterionApplicable() {
		return _isSmallChildCriterionApplicable;
	}

	@Override
	public void setIsSmallChildCriterionApplicable(
		boolean isSmallChildCriterionApplicable) {
		_isSmallChildCriterionApplicable = isSmallChildCriterionApplicable;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSmallChildCriterionApplicable",
						boolean.class);

				method.invoke(_leaveRestrictionRemoteModel,
					isSmallChildCriterionApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaxSmallChildAgeApplicable() {
		return _maxSmallChildAgeApplicable;
	}

	@Override
	public void setMaxSmallChildAgeApplicable(String maxSmallChildAgeApplicable) {
		_maxSmallChildAgeApplicable = maxSmallChildAgeApplicable;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxSmallChildAgeApplicable",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					maxSmallChildAgeApplicable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaveRestrictionRemoteModel() {
		return _leaveRestrictionRemoteModel;
	}

	public void setLeaveRestrictionRemoteModel(
		BaseModel<?> leaveRestrictionRemoteModel) {
		_leaveRestrictionRemoteModel = leaveRestrictionRemoteModel;
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

		Class<?> remoteModelClass = _leaveRestrictionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaveRestrictionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaveRestrictionLocalServiceUtil.addLeaveRestriction(this);
		}
		else {
			LeaveRestrictionLocalServiceUtil.updateLeaveRestriction(this);
		}
	}

	@Override
	public LeaveRestriction toEscapedModel() {
		return (LeaveRestriction)ProxyUtil.newProxyInstance(LeaveRestriction.class.getClassLoader(),
			new Class[] { LeaveRestriction.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaveRestrictionClp clone = new LeaveRestrictionClp();

		clone.setLeaveRestrictionId(getLeaveRestrictionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setLeaveTypeId(getLeaveTypeId());
		clone.setCannotExceedBalance(getCannotExceedBalance());
		clone.setCannotApplyForPartialDay(getCannotApplyForPartialDay());
		clone.setIfATermsQuestion(getIfATermsQuestion());
		clone.setTermsQuestion(getTermsQuestion());
		clone.setErrorTextIfTermsDeclined(getErrorTextIfTermsDeclined());
		clone.setIsMinimumServicePeriodApplicable(getIsMinimumServicePeriodApplicable());
		clone.setMinimumServicePeriod(getMinimumServicePeriod());
		clone.setIsMaxConsecutiveLeavesApplicable(getIsMaxConsecutiveLeavesApplicable());
		clone.setMaxConsecutiveLeaves(getMaxConsecutiveLeaves());
		clone.setIsSmallChildCriterionApplicable(getIsSmallChildCriterionApplicable());
		clone.setMaxSmallChildAgeApplicable(getMaxSmallChildAgeApplicable());

		return clone;
	}

	@Override
	public int compareTo(LeaveRestriction leaveRestriction) {
		long primaryKey = leaveRestriction.getPrimaryKey();

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

		if (!(obj instanceof LeaveRestrictionClp)) {
			return false;
		}

		LeaveRestrictionClp leaveRestriction = (LeaveRestrictionClp)obj;

		long primaryKey = leaveRestriction.getPrimaryKey();

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

		sb.append("{leaveRestrictionId=");
		sb.append(getLeaveRestrictionId());
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
		sb.append(", cannotExceedBalance=");
		sb.append(getCannotExceedBalance());
		sb.append(", cannotApplyForPartialDay=");
		sb.append(getCannotApplyForPartialDay());
		sb.append(", ifATermsQuestion=");
		sb.append(getIfATermsQuestion());
		sb.append(", termsQuestion=");
		sb.append(getTermsQuestion());
		sb.append(", errorTextIfTermsDeclined=");
		sb.append(getErrorTextIfTermsDeclined());
		sb.append(", isMinimumServicePeriodApplicable=");
		sb.append(getIsMinimumServicePeriodApplicable());
		sb.append(", minimumServicePeriod=");
		sb.append(getMinimumServicePeriod());
		sb.append(", isMaxConsecutiveLeavesApplicable=");
		sb.append(getIsMaxConsecutiveLeavesApplicable());
		sb.append(", maxConsecutiveLeaves=");
		sb.append(getMaxConsecutiveLeaves());
		sb.append(", isSmallChildCriterionApplicable=");
		sb.append(getIsSmallChildCriterionApplicable());
		sb.append(", maxSmallChildAgeApplicable=");
		sb.append(getMaxSmallChildAgeApplicable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.LeaveRestriction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>leaveRestrictionId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRestrictionId());
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
			"<column><column-name>cannotExceedBalance</column-name><column-value><![CDATA[");
		sb.append(getCannotExceedBalance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cannotApplyForPartialDay</column-name><column-value><![CDATA[");
		sb.append(getCannotApplyForPartialDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifATermsQuestion</column-name><column-value><![CDATA[");
		sb.append(getIfATermsQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termsQuestion</column-name><column-value><![CDATA[");
		sb.append(getTermsQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorTextIfTermsDeclined</column-name><column-value><![CDATA[");
		sb.append(getErrorTextIfTermsDeclined());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMinimumServicePeriodApplicable</column-name><column-value><![CDATA[");
		sb.append(getIsMinimumServicePeriodApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumServicePeriod</column-name><column-value><![CDATA[");
		sb.append(getMinimumServicePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMaxConsecutiveLeavesApplicable</column-name><column-value><![CDATA[");
		sb.append(getIsMaxConsecutiveLeavesApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxConsecutiveLeaves</column-name><column-value><![CDATA[");
		sb.append(getMaxConsecutiveLeaves());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSmallChildCriterionApplicable</column-name><column-value><![CDATA[");
		sb.append(getIsSmallChildCriterionApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxSmallChildAgeApplicable</column-name><column-value><![CDATA[");
		sb.append(getMaxSmallChildAgeApplicable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _leaveRestrictionId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _leaveTypeId;
	private boolean _cannotExceedBalance;
	private boolean _cannotApplyForPartialDay;
	private boolean _ifATermsQuestion;
	private String _termsQuestion;
	private String _errorTextIfTermsDeclined;
	private boolean _isMinimumServicePeriodApplicable;
	private String _minimumServicePeriod;
	private boolean _isMaxConsecutiveLeavesApplicable;
	private String _maxConsecutiveLeaves;
	private boolean _isSmallChildCriterionApplicable;
	private String _maxSmallChildAgeApplicable;
	private BaseModel<?> _leaveRestrictionRemoteModel;
}