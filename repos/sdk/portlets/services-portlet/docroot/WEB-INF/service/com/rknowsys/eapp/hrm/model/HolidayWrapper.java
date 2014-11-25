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
 * This class is a wrapper for {@link Holiday}.
 * </p>
 *
 * @author rknowsys
 * @see Holiday
 * @generated
 */
public class HolidayWrapper implements Holiday, ModelWrapper<Holiday> {
	public HolidayWrapper(Holiday holiday) {
		_holiday = holiday;
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

	/**
	* Returns the primary key of this Holiday.
	*
	* @return the primary key of this Holiday
	*/
	@Override
	public long getPrimaryKey() {
		return _holiday.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Holiday.
	*
	* @param primaryKey the primary key of this Holiday
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_holiday.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the holiday ID of this Holiday.
	*
	* @return the holiday ID of this Holiday
	*/
	@Override
	public long getHolidayId() {
		return _holiday.getHolidayId();
	}

	/**
	* Sets the holiday ID of this Holiday.
	*
	* @param holidayId the holiday ID of this Holiday
	*/
	@Override
	public void setHolidayId(long holidayId) {
		_holiday.setHolidayId(holidayId);
	}

	/**
	* Returns the holiday name of this Holiday.
	*
	* @return the holiday name of this Holiday
	*/
	@Override
	public java.lang.String getHolidayName() {
		return _holiday.getHolidayName();
	}

	/**
	* Sets the holiday name of this Holiday.
	*
	* @param holidayName the holiday name of this Holiday
	*/
	@Override
	public void setHolidayName(java.lang.String holidayName) {
		_holiday.setHolidayName(holidayName);
	}

	/**
	* Returns the is annual of this Holiday.
	*
	* @return the is annual of this Holiday
	*/
	@Override
	public boolean getIsAnnual() {
		return _holiday.getIsAnnual();
	}

	/**
	* Returns <code>true</code> if this Holiday is is annual.
	*
	* @return <code>true</code> if this Holiday is is annual; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsAnnual() {
		return _holiday.isIsAnnual();
	}

	/**
	* Sets whether this Holiday is is annual.
	*
	* @param isAnnual the is annual of this Holiday
	*/
	@Override
	public void setIsAnnual(boolean isAnnual) {
		_holiday.setIsAnnual(isAnnual);
	}

	/**
	* Returns the is full day of this Holiday.
	*
	* @return the is full day of this Holiday
	*/
	@Override
	public boolean getIsFullDay() {
		return _holiday.getIsFullDay();
	}

	/**
	* Returns <code>true</code> if this Holiday is is full day.
	*
	* @return <code>true</code> if this Holiday is is full day; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsFullDay() {
		return _holiday.isIsFullDay();
	}

	/**
	* Sets whether this Holiday is is full day.
	*
	* @param isFullDay the is full day of this Holiday
	*/
	@Override
	public void setIsFullDay(boolean isFullDay) {
		_holiday.setIsFullDay(isFullDay);
	}

	/**
	* Returns the holiday date of this Holiday.
	*
	* @return the holiday date of this Holiday
	*/
	@Override
	public java.util.Date getHolidayDate() {
		return _holiday.getHolidayDate();
	}

	/**
	* Sets the holiday date of this Holiday.
	*
	* @param holidayDate the holiday date of this Holiday
	*/
	@Override
	public void setHolidayDate(java.util.Date holidayDate) {
		_holiday.setHolidayDate(holidayDate);
	}

	/**
	* Returns the nationality ID of this Holiday.
	*
	* @return the nationality ID of this Holiday
	*/
	@Override
	public long getNationalityId() {
		return _holiday.getNationalityId();
	}

	/**
	* Sets the nationality ID of this Holiday.
	*
	* @param nationalityId the nationality ID of this Holiday
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_holiday.setNationalityId(nationalityId);
	}

	/**
	* Returns the group ID of this Holiday.
	*
	* @return the group ID of this Holiday
	*/
	@Override
	public long getGroupId() {
		return _holiday.getGroupId();
	}

	/**
	* Sets the group ID of this Holiday.
	*
	* @param groupId the group ID of this Holiday
	*/
	@Override
	public void setGroupId(long groupId) {
		_holiday.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Holiday.
	*
	* @return the company ID of this Holiday
	*/
	@Override
	public long getCompanyId() {
		return _holiday.getCompanyId();
	}

	/**
	* Sets the company ID of this Holiday.
	*
	* @param companyId the company ID of this Holiday
	*/
	@Override
	public void setCompanyId(long companyId) {
		_holiday.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Holiday.
	*
	* @return the user ID of this Holiday
	*/
	@Override
	public long getUserId() {
		return _holiday.getUserId();
	}

	/**
	* Sets the user ID of this Holiday.
	*
	* @param userId the user ID of this Holiday
	*/
	@Override
	public void setUserId(long userId) {
		_holiday.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Holiday.
	*
	* @return the user uuid of this Holiday
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holiday.getUserUuid();
	}

	/**
	* Sets the user uuid of this Holiday.
	*
	* @param userUuid the user uuid of this Holiday
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_holiday.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this Holiday.
	*
	* @return the user name of this Holiday
	*/
	@Override
	public java.lang.String getUserName() {
		return _holiday.getUserName();
	}

	/**
	* Sets the user name of this Holiday.
	*
	* @param userName the user name of this Holiday
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_holiday.setUserName(userName);
	}

	/**
	* Returns the create date of this Holiday.
	*
	* @return the create date of this Holiday
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _holiday.getCreateDate();
	}

	/**
	* Sets the create date of this Holiday.
	*
	* @param createDate the create date of this Holiday
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_holiday.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Holiday.
	*
	* @return the modified date of this Holiday
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _holiday.getModifiedDate();
	}

	/**
	* Sets the modified date of this Holiday.
	*
	* @param modifiedDate the modified date of this Holiday
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_holiday.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _holiday.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_holiday.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _holiday.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_holiday.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _holiday.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _holiday.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_holiday.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _holiday.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_holiday.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_holiday.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_holiday.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HolidayWrapper((Holiday)_holiday.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Holiday holiday) {
		return _holiday.compareTo(holiday);
	}

	@Override
	public int hashCode() {
		return _holiday.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Holiday> toCacheModel() {
		return _holiday.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Holiday toEscapedModel() {
		return new HolidayWrapper(_holiday.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Holiday toUnescapedModel() {
		return new HolidayWrapper(_holiday.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _holiday.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _holiday.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_holiday.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HolidayWrapper)) {
			return false;
		}

		HolidayWrapper holidayWrapper = (HolidayWrapper)obj;

		if (Validator.equals(_holiday, holidayWrapper._holiday)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Holiday getWrappedHoliday() {
		return _holiday;
	}

	@Override
	public Holiday getWrappedModel() {
		return _holiday;
	}

	@Override
	public void resetOriginalValues() {
		_holiday.resetOriginalValues();
	}

	private Holiday _holiday;
}