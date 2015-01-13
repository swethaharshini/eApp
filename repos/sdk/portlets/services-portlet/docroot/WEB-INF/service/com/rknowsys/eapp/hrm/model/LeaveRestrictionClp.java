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
		attributes.put("cantExceedBalForRoleIds", getCantExceedBalForRoleIds());
		attributes.put("cannotApplyForPartialDay", getCannotApplyForPartialDay());
		attributes.put("cantApplyPartialDayForRoleIds",
			getCantApplyPartialDayForRoleIds());
		attributes.put("termsQuestion", getTermsQuestion());
		attributes.put("termsQsnForRoleIds", getTermsQsnForRoleIds());
		attributes.put("errorTextIfTermsDeclined", getErrorTextIfTermsDeclined());
		attributes.put("minimumServicePeriod", getMinimumServicePeriod());
		attributes.put("minServicePeriodForRoleIds",
			getMinServicePeriodForRoleIds());
		attributes.put("maxConsecutiveLeaves", getMaxConsecutiveLeaves());
		attributes.put("maxConsecLeavesForRoleIds",
			getMaxConsecLeavesForRoleIds());
		attributes.put("maxSmallChildAgeApplicable",
			getMaxSmallChildAgeApplicable());
		attributes.put("maxSmallChildAgeForRoleIds",
			getMaxSmallChildAgeForRoleIds());

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

		String cantExceedBalForRoleIds = (String)attributes.get(
				"cantExceedBalForRoleIds");

		if (cantExceedBalForRoleIds != null) {
			setCantExceedBalForRoleIds(cantExceedBalForRoleIds);
		}

		Boolean cannotApplyForPartialDay = (Boolean)attributes.get(
				"cannotApplyForPartialDay");

		if (cannotApplyForPartialDay != null) {
			setCannotApplyForPartialDay(cannotApplyForPartialDay);
		}

		String cantApplyPartialDayForRoleIds = (String)attributes.get(
				"cantApplyPartialDayForRoleIds");

		if (cantApplyPartialDayForRoleIds != null) {
			setCantApplyPartialDayForRoleIds(cantApplyPartialDayForRoleIds);
		}

		String termsQuestion = (String)attributes.get("termsQuestion");

		if (termsQuestion != null) {
			setTermsQuestion(termsQuestion);
		}

		String termsQsnForRoleIds = (String)attributes.get("termsQsnForRoleIds");

		if (termsQsnForRoleIds != null) {
			setTermsQsnForRoleIds(termsQsnForRoleIds);
		}

		String errorTextIfTermsDeclined = (String)attributes.get(
				"errorTextIfTermsDeclined");

		if (errorTextIfTermsDeclined != null) {
			setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
		}

		String minimumServicePeriod = (String)attributes.get(
				"minimumServicePeriod");

		if (minimumServicePeriod != null) {
			setMinimumServicePeriod(minimumServicePeriod);
		}

		String minServicePeriodForRoleIds = (String)attributes.get(
				"minServicePeriodForRoleIds");

		if (minServicePeriodForRoleIds != null) {
			setMinServicePeriodForRoleIds(minServicePeriodForRoleIds);
		}

		String maxConsecutiveLeaves = (String)attributes.get(
				"maxConsecutiveLeaves");

		if (maxConsecutiveLeaves != null) {
			setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		}

		String maxConsecLeavesForRoleIds = (String)attributes.get(
				"maxConsecLeavesForRoleIds");

		if (maxConsecLeavesForRoleIds != null) {
			setMaxConsecLeavesForRoleIds(maxConsecLeavesForRoleIds);
		}

		String maxSmallChildAgeApplicable = (String)attributes.get(
				"maxSmallChildAgeApplicable");

		if (maxSmallChildAgeApplicable != null) {
			setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		}

		String maxSmallChildAgeForRoleIds = (String)attributes.get(
				"maxSmallChildAgeForRoleIds");

		if (maxSmallChildAgeForRoleIds != null) {
			setMaxSmallChildAgeForRoleIds(maxSmallChildAgeForRoleIds);
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
	public String getCantExceedBalForRoleIds() {
		return _cantExceedBalForRoleIds;
	}

	@Override
	public void setCantExceedBalForRoleIds(String cantExceedBalForRoleIds) {
		_cantExceedBalForRoleIds = cantExceedBalForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCantExceedBalForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					cantExceedBalForRoleIds);
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
	public String getCantApplyPartialDayForRoleIds() {
		return _cantApplyPartialDayForRoleIds;
	}

	@Override
	public void setCantApplyPartialDayForRoleIds(
		String cantApplyPartialDayForRoleIds) {
		_cantApplyPartialDayForRoleIds = cantApplyPartialDayForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setCantApplyPartialDayForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					cantApplyPartialDayForRoleIds);
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
	public String getTermsQsnForRoleIds() {
		return _termsQsnForRoleIds;
	}

	@Override
	public void setTermsQsnForRoleIds(String termsQsnForRoleIds) {
		_termsQsnForRoleIds = termsQsnForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setTermsQsnForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel, termsQsnForRoleIds);
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
	public String getMinServicePeriodForRoleIds() {
		return _minServicePeriodForRoleIds;
	}

	@Override
	public void setMinServicePeriodForRoleIds(String minServicePeriodForRoleIds) {
		_minServicePeriodForRoleIds = minServicePeriodForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMinServicePeriodForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					minServicePeriodForRoleIds);
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
	public String getMaxConsecLeavesForRoleIds() {
		return _maxConsecLeavesForRoleIds;
	}

	@Override
	public void setMaxConsecLeavesForRoleIds(String maxConsecLeavesForRoleIds) {
		_maxConsecLeavesForRoleIds = maxConsecLeavesForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxConsecLeavesForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					maxConsecLeavesForRoleIds);
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

	@Override
	public String getMaxSmallChildAgeForRoleIds() {
		return _maxSmallChildAgeForRoleIds;
	}

	@Override
	public void setMaxSmallChildAgeForRoleIds(String maxSmallChildAgeForRoleIds) {
		_maxSmallChildAgeForRoleIds = maxSmallChildAgeForRoleIds;

		if (_leaveRestrictionRemoteModel != null) {
			try {
				Class<?> clazz = _leaveRestrictionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxSmallChildAgeForRoleIds",
						String.class);

				method.invoke(_leaveRestrictionRemoteModel,
					maxSmallChildAgeForRoleIds);
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
		clone.setCantExceedBalForRoleIds(getCantExceedBalForRoleIds());
		clone.setCannotApplyForPartialDay(getCannotApplyForPartialDay());
		clone.setCantApplyPartialDayForRoleIds(getCantApplyPartialDayForRoleIds());
		clone.setTermsQuestion(getTermsQuestion());
		clone.setTermsQsnForRoleIds(getTermsQsnForRoleIds());
		clone.setErrorTextIfTermsDeclined(getErrorTextIfTermsDeclined());
		clone.setMinimumServicePeriod(getMinimumServicePeriod());
		clone.setMinServicePeriodForRoleIds(getMinServicePeriodForRoleIds());
		clone.setMaxConsecutiveLeaves(getMaxConsecutiveLeaves());
		clone.setMaxConsecLeavesForRoleIds(getMaxConsecLeavesForRoleIds());
		clone.setMaxSmallChildAgeApplicable(getMaxSmallChildAgeApplicable());
		clone.setMaxSmallChildAgeForRoleIds(getMaxSmallChildAgeForRoleIds());

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
		StringBundler sb = new StringBundler(41);

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
		sb.append(", cantExceedBalForRoleIds=");
		sb.append(getCantExceedBalForRoleIds());
		sb.append(", cannotApplyForPartialDay=");
		sb.append(getCannotApplyForPartialDay());
		sb.append(", cantApplyPartialDayForRoleIds=");
		sb.append(getCantApplyPartialDayForRoleIds());
		sb.append(", termsQuestion=");
		sb.append(getTermsQuestion());
		sb.append(", termsQsnForRoleIds=");
		sb.append(getTermsQsnForRoleIds());
		sb.append(", errorTextIfTermsDeclined=");
		sb.append(getErrorTextIfTermsDeclined());
		sb.append(", minimumServicePeriod=");
		sb.append(getMinimumServicePeriod());
		sb.append(", minServicePeriodForRoleIds=");
		sb.append(getMinServicePeriodForRoleIds());
		sb.append(", maxConsecutiveLeaves=");
		sb.append(getMaxConsecutiveLeaves());
		sb.append(", maxConsecLeavesForRoleIds=");
		sb.append(getMaxConsecLeavesForRoleIds());
		sb.append(", maxSmallChildAgeApplicable=");
		sb.append(getMaxSmallChildAgeApplicable());
		sb.append(", maxSmallChildAgeForRoleIds=");
		sb.append(getMaxSmallChildAgeForRoleIds());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

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
			"<column><column-name>cantExceedBalForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getCantExceedBalForRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cannotApplyForPartialDay</column-name><column-value><![CDATA[");
		sb.append(getCannotApplyForPartialDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cantApplyPartialDayForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getCantApplyPartialDayForRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termsQuestion</column-name><column-value><![CDATA[");
		sb.append(getTermsQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termsQsnForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getTermsQsnForRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorTextIfTermsDeclined</column-name><column-value><![CDATA[");
		sb.append(getErrorTextIfTermsDeclined());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minimumServicePeriod</column-name><column-value><![CDATA[");
		sb.append(getMinimumServicePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minServicePeriodForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getMinServicePeriodForRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxConsecutiveLeaves</column-name><column-value><![CDATA[");
		sb.append(getMaxConsecutiveLeaves());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxConsecLeavesForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getMaxConsecLeavesForRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxSmallChildAgeApplicable</column-name><column-value><![CDATA[");
		sb.append(getMaxSmallChildAgeApplicable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxSmallChildAgeForRoleIds</column-name><column-value><![CDATA[");
		sb.append(getMaxSmallChildAgeForRoleIds());
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
	private String _cantExceedBalForRoleIds;
	private boolean _cannotApplyForPartialDay;
	private String _cantApplyPartialDayForRoleIds;
	private String _termsQuestion;
	private String _termsQsnForRoleIds;
	private String _errorTextIfTermsDeclined;
	private String _minimumServicePeriod;
	private String _minServicePeriodForRoleIds;
	private String _maxConsecutiveLeaves;
	private String _maxConsecLeavesForRoleIds;
	private String _maxSmallChildAgeApplicable;
	private String _maxSmallChildAgeForRoleIds;
	private BaseModel<?> _leaveRestrictionRemoteModel;
}