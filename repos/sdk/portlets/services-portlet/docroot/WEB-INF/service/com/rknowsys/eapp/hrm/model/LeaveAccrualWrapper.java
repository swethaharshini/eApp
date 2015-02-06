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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeaveAccrual}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveAccrual
 * @generated
 */
public class LeaveAccrualWrapper implements LeaveAccrual,
	ModelWrapper<LeaveAccrual> {
	public LeaveAccrualWrapper(LeaveAccrual leaveAccrual) {
		_leaveAccrual = leaveAccrual;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveAccrual.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveAccrual.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveAccrualId", getLeaveAccrualId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("accrualFrequency", getAccrualFrequency());
		attributes.put("accrueEvery", getAccrueEvery());
		attributes.put("dayOfCredit", getDayOfCredit());
		attributes.put("accrualStartsOn", getAccrualStartsOn());
		attributes.put("monthOfCredit", getMonthOfCredit());
		attributes.put("accrualValidFrom", getAccrualValidFrom());
		attributes.put("firstAccrual", getFirstAccrual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveAccrualId = (Long)attributes.get("leaveAccrualId");

		if (leaveAccrualId != null) {
			setLeaveAccrualId(leaveAccrualId);
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

		String accrualFrequency = (String)attributes.get("accrualFrequency");

		if (accrualFrequency != null) {
			setAccrualFrequency(accrualFrequency);
		}

		Integer accrueEvery = (Integer)attributes.get("accrueEvery");

		if (accrueEvery != null) {
			setAccrueEvery(accrueEvery);
		}

		Integer dayOfCredit = (Integer)attributes.get("dayOfCredit");

		if (dayOfCredit != null) {
			setDayOfCredit(dayOfCredit);
		}

		String accrualStartsOn = (String)attributes.get("accrualStartsOn");

		if (accrualStartsOn != null) {
			setAccrualStartsOn(accrualStartsOn);
		}

		Integer monthOfCredit = (Integer)attributes.get("monthOfCredit");

		if (monthOfCredit != null) {
			setMonthOfCredit(monthOfCredit);
		}

		String accrualValidFrom = (String)attributes.get("accrualValidFrom");

		if (accrualValidFrom != null) {
			setAccrualValidFrom(accrualValidFrom);
		}

		String firstAccrual = (String)attributes.get("firstAccrual");

		if (firstAccrual != null) {
			setFirstAccrual(firstAccrual);
		}
	}

	/**
	* Returns the primary key of this leave accrual.
	*
	* @return the primary key of this leave accrual
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveAccrual.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave accrual.
	*
	* @param primaryKey the primary key of this leave accrual
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveAccrual.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave accrual ID of this leave accrual.
	*
	* @return the leave accrual ID of this leave accrual
	*/
	@Override
	public long getLeaveAccrualId() {
		return _leaveAccrual.getLeaveAccrualId();
	}

	/**
	* Sets the leave accrual ID of this leave accrual.
	*
	* @param leaveAccrualId the leave accrual ID of this leave accrual
	*/
	@Override
	public void setLeaveAccrualId(long leaveAccrualId) {
		_leaveAccrual.setLeaveAccrualId(leaveAccrualId);
	}

	/**
	* Returns the company ID of this leave accrual.
	*
	* @return the company ID of this leave accrual
	*/
	@Override
	public long getCompanyId() {
		return _leaveAccrual.getCompanyId();
	}

	/**
	* Sets the company ID of this leave accrual.
	*
	* @param companyId the company ID of this leave accrual
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveAccrual.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave accrual.
	*
	* @return the group ID of this leave accrual
	*/
	@Override
	public long getGroupId() {
		return _leaveAccrual.getGroupId();
	}

	/**
	* Sets the group ID of this leave accrual.
	*
	* @param groupId the group ID of this leave accrual
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveAccrual.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave accrual.
	*
	* @return the create date of this leave accrual
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveAccrual.getCreateDate();
	}

	/**
	* Sets the create date of this leave accrual.
	*
	* @param createDate the create date of this leave accrual
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveAccrual.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave accrual.
	*
	* @return the modified date of this leave accrual
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveAccrual.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave accrual.
	*
	* @param modifiedDate the modified date of this leave accrual
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveAccrual.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave accrual.
	*
	* @return the user ID of this leave accrual
	*/
	@Override
	public long getUserId() {
		return _leaveAccrual.getUserId();
	}

	/**
	* Sets the user ID of this leave accrual.
	*
	* @param userId the user ID of this leave accrual
	*/
	@Override
	public void setUserId(long userId) {
		_leaveAccrual.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave accrual.
	*
	* @return the user uuid of this leave accrual
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrual.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave accrual.
	*
	* @param userUuid the user uuid of this leave accrual
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveAccrual.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave accrual.
	*
	* @return the leave type ID of this leave accrual
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveAccrual.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave accrual.
	*
	* @param leaveTypeId the leave type ID of this leave accrual
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveAccrual.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the accrual frequency of this leave accrual.
	*
	* @return the accrual frequency of this leave accrual
	*/
	@Override
	public java.lang.String getAccrualFrequency() {
		return _leaveAccrual.getAccrualFrequency();
	}

	/**
	* Sets the accrual frequency of this leave accrual.
	*
	* @param accrualFrequency the accrual frequency of this leave accrual
	*/
	@Override
	public void setAccrualFrequency(java.lang.String accrualFrequency) {
		_leaveAccrual.setAccrualFrequency(accrualFrequency);
	}

	/**
	* Returns the accrue every of this leave accrual.
	*
	* @return the accrue every of this leave accrual
	*/
	@Override
	public int getAccrueEvery() {
		return _leaveAccrual.getAccrueEvery();
	}

	/**
	* Sets the accrue every of this leave accrual.
	*
	* @param accrueEvery the accrue every of this leave accrual
	*/
	@Override
	public void setAccrueEvery(int accrueEvery) {
		_leaveAccrual.setAccrueEvery(accrueEvery);
	}

	/**
	* Returns the day of credit of this leave accrual.
	*
	* @return the day of credit of this leave accrual
	*/
	@Override
	public int getDayOfCredit() {
		return _leaveAccrual.getDayOfCredit();
	}

	/**
	* Sets the day of credit of this leave accrual.
	*
	* @param dayOfCredit the day of credit of this leave accrual
	*/
	@Override
	public void setDayOfCredit(int dayOfCredit) {
		_leaveAccrual.setDayOfCredit(dayOfCredit);
	}

	/**
	* Returns the accrual starts on of this leave accrual.
	*
	* @return the accrual starts on of this leave accrual
	*/
	@Override
	public java.lang.String getAccrualStartsOn() {
		return _leaveAccrual.getAccrualStartsOn();
	}

	/**
	* Sets the accrual starts on of this leave accrual.
	*
	* @param accrualStartsOn the accrual starts on of this leave accrual
	*/
	@Override
	public void setAccrualStartsOn(java.lang.String accrualStartsOn) {
		_leaveAccrual.setAccrualStartsOn(accrualStartsOn);
	}

	/**
	* Returns the month of credit of this leave accrual.
	*
	* @return the month of credit of this leave accrual
	*/
	@Override
	public int getMonthOfCredit() {
		return _leaveAccrual.getMonthOfCredit();
	}

	/**
	* Sets the month of credit of this leave accrual.
	*
	* @param monthOfCredit the month of credit of this leave accrual
	*/
	@Override
	public void setMonthOfCredit(int monthOfCredit) {
		_leaveAccrual.setMonthOfCredit(monthOfCredit);
	}

	/**
	* Returns the accrual valid from of this leave accrual.
	*
	* @return the accrual valid from of this leave accrual
	*/
	@Override
	public java.lang.String getAccrualValidFrom() {
		return _leaveAccrual.getAccrualValidFrom();
	}

	/**
	* Sets the accrual valid from of this leave accrual.
	*
	* @param accrualValidFrom the accrual valid from of this leave accrual
	*/
	@Override
	public void setAccrualValidFrom(java.lang.String accrualValidFrom) {
		_leaveAccrual.setAccrualValidFrom(accrualValidFrom);
	}

	/**
	* Returns the first accrual of this leave accrual.
	*
	* @return the first accrual of this leave accrual
	*/
	@Override
	public java.lang.String getFirstAccrual() {
		return _leaveAccrual.getFirstAccrual();
	}

	/**
	* Sets the first accrual of this leave accrual.
	*
	* @param firstAccrual the first accrual of this leave accrual
	*/
	@Override
	public void setFirstAccrual(java.lang.String firstAccrual) {
		_leaveAccrual.setFirstAccrual(firstAccrual);
	}

	@Override
	public boolean isNew() {
		return _leaveAccrual.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveAccrual.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveAccrual.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveAccrual.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveAccrual.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveAccrual.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveAccrual.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveAccrual.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveAccrual.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveAccrual.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveAccrual.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveAccrualWrapper((LeaveAccrual)_leaveAccrual.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual) {
		return _leaveAccrual.compareTo(leaveAccrual);
	}

	@Override
	public int hashCode() {
		return _leaveAccrual.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveAccrual> toCacheModel() {
		return _leaveAccrual.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual toEscapedModel() {
		return new LeaveAccrualWrapper(_leaveAccrual.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual toUnescapedModel() {
		return new LeaveAccrualWrapper(_leaveAccrual.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveAccrual.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveAccrual.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveAccrual.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveAccrualWrapper)) {
			return false;
		}

		LeaveAccrualWrapper leaveAccrualWrapper = (LeaveAccrualWrapper)obj;

		if (Validator.equals(_leaveAccrual, leaveAccrualWrapper._leaveAccrual)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveAccrual getWrappedLeaveAccrual() {
		return _leaveAccrual;
	}

	@Override
	public LeaveAccrual getWrappedModel() {
		return _leaveAccrual;
	}

	@Override
	public void resetOriginalValues() {
		_leaveAccrual.resetOriginalValues();
	}

	private LeaveAccrual _leaveAccrual;
}