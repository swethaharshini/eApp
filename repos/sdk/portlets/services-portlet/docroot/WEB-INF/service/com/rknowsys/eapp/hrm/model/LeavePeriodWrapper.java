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
 * This class is a wrapper for {@link LeavePeriod}.
 * </p>
 *
 * @author rknowsys
 * @see LeavePeriod
 * @generated
 */
public class LeavePeriodWrapper implements LeavePeriod,
	ModelWrapper<LeavePeriod> {
	public LeavePeriodWrapper(LeavePeriod leavePeriod) {
		_leavePeriod = leavePeriod;
	}

	@Override
	public Class<?> getModelClass() {
		return LeavePeriod.class;
	}

	@Override
	public String getModelClassName() {
		return LeavePeriod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leavePeriodId", getLeavePeriodId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leavePeriodId = (Long)attributes.get("leavePeriodId");

		if (leavePeriodId != null) {
			setLeavePeriodId(leavePeriodId);
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

		Integer startMonth = (Integer)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		Integer startDate = (Integer)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this leave period.
	*
	* @return the primary key of this leave period
	*/
	@Override
	public long getPrimaryKey() {
		return _leavePeriod.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave period.
	*
	* @param primaryKey the primary key of this leave period
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leavePeriod.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave period ID of this leave period.
	*
	* @return the leave period ID of this leave period
	*/
	@Override
	public long getLeavePeriodId() {
		return _leavePeriod.getLeavePeriodId();
	}

	/**
	* Sets the leave period ID of this leave period.
	*
	* @param leavePeriodId the leave period ID of this leave period
	*/
	@Override
	public void setLeavePeriodId(long leavePeriodId) {
		_leavePeriod.setLeavePeriodId(leavePeriodId);
	}

	/**
	* Returns the company ID of this leave period.
	*
	* @return the company ID of this leave period
	*/
	@Override
	public long getCompanyId() {
		return _leavePeriod.getCompanyId();
	}

	/**
	* Sets the company ID of this leave period.
	*
	* @param companyId the company ID of this leave period
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leavePeriod.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave period.
	*
	* @return the group ID of this leave period
	*/
	@Override
	public long getGroupId() {
		return _leavePeriod.getGroupId();
	}

	/**
	* Sets the group ID of this leave period.
	*
	* @param groupId the group ID of this leave period
	*/
	@Override
	public void setGroupId(long groupId) {
		_leavePeriod.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave period.
	*
	* @return the create date of this leave period
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leavePeriod.getCreateDate();
	}

	/**
	* Sets the create date of this leave period.
	*
	* @param createDate the create date of this leave period
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leavePeriod.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave period.
	*
	* @return the modified date of this leave period
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leavePeriod.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave period.
	*
	* @param modifiedDate the modified date of this leave period
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leavePeriod.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave period.
	*
	* @return the user ID of this leave period
	*/
	@Override
	public long getUserId() {
		return _leavePeriod.getUserId();
	}

	/**
	* Sets the user ID of this leave period.
	*
	* @param userId the user ID of this leave period
	*/
	@Override
	public void setUserId(long userId) {
		_leavePeriod.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave period.
	*
	* @return the user uuid of this leave period
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leavePeriod.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave period.
	*
	* @param userUuid the user uuid of this leave period
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leavePeriod.setUserUuid(userUuid);
	}

	/**
	* Returns the start month of this leave period.
	*
	* @return the start month of this leave period
	*/
	@Override
	public int getStartMonth() {
		return _leavePeriod.getStartMonth();
	}

	/**
	* Sets the start month of this leave period.
	*
	* @param startMonth the start month of this leave period
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_leavePeriod.setStartMonth(startMonth);
	}

	/**
	* Returns the start date of this leave period.
	*
	* @return the start date of this leave period
	*/
	@Override
	public int getStartDate() {
		return _leavePeriod.getStartDate();
	}

	/**
	* Sets the start date of this leave period.
	*
	* @param startDate the start date of this leave period
	*/
	@Override
	public void setStartDate(int startDate) {
		_leavePeriod.setStartDate(startDate);
	}

	/**
	* Returns the end date of this leave period.
	*
	* @return the end date of this leave period
	*/
	@Override
	public java.lang.String getEndDate() {
		return _leavePeriod.getEndDate();
	}

	/**
	* Sets the end date of this leave period.
	*
	* @param endDate the end date of this leave period
	*/
	@Override
	public void setEndDate(java.lang.String endDate) {
		_leavePeriod.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _leavePeriod.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leavePeriod.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leavePeriod.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leavePeriod.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leavePeriod.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leavePeriod.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leavePeriod.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leavePeriod.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leavePeriod.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leavePeriod.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leavePeriod.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeavePeriodWrapper((LeavePeriod)_leavePeriod.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.LeavePeriod leavePeriod) {
		return _leavePeriod.compareTo(leavePeriod);
	}

	@Override
	public int hashCode() {
		return _leavePeriod.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeavePeriod> toCacheModel() {
		return _leavePeriod.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeavePeriod toEscapedModel() {
		return new LeavePeriodWrapper(_leavePeriod.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeavePeriod toUnescapedModel() {
		return new LeavePeriodWrapper(_leavePeriod.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leavePeriod.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leavePeriod.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leavePeriod.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeavePeriodWrapper)) {
			return false;
		}

		LeavePeriodWrapper leavePeriodWrapper = (LeavePeriodWrapper)obj;

		if (Validator.equals(_leavePeriod, leavePeriodWrapper._leavePeriod)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeavePeriod getWrappedLeavePeriod() {
		return _leavePeriod;
	}

	@Override
	public LeavePeriod getWrappedModel() {
		return _leavePeriod;
	}

	@Override
	public void resetOriginalValues() {
		_leavePeriod.resetOriginalValues();
	}

	private LeavePeriod _leavePeriod;
}