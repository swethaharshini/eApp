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
 * This class is a wrapper for {@link LeaveRuleApplicable}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveRuleApplicable
 * @generated
 */
public class LeaveRuleApplicableWrapper implements LeaveRuleApplicable,
	ModelWrapper<LeaveRuleApplicable> {
	public LeaveRuleApplicableWrapper(LeaveRuleApplicable leaveRuleApplicable) {
		_leaveRuleApplicable = leaveRuleApplicable;
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

	/**
	* Returns the primary key of this leave rule applicable.
	*
	* @return the primary key of this leave rule applicable
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveRuleApplicable.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave rule applicable.
	*
	* @param primaryKey the primary key of this leave rule applicable
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveRuleApplicable.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave rule applicable ID of this leave rule applicable.
	*
	* @return the leave rule applicable ID of this leave rule applicable
	*/
	@Override
	public long getLeaveRuleApplicableId() {
		return _leaveRuleApplicable.getLeaveRuleApplicableId();
	}

	/**
	* Sets the leave rule applicable ID of this leave rule applicable.
	*
	* @param leaveRuleApplicableId the leave rule applicable ID of this leave rule applicable
	*/
	@Override
	public void setLeaveRuleApplicableId(long leaveRuleApplicableId) {
		_leaveRuleApplicable.setLeaveRuleApplicableId(leaveRuleApplicableId);
	}

	/**
	* Returns the company ID of this leave rule applicable.
	*
	* @return the company ID of this leave rule applicable
	*/
	@Override
	public long getCompanyId() {
		return _leaveRuleApplicable.getCompanyId();
	}

	/**
	* Sets the company ID of this leave rule applicable.
	*
	* @param companyId the company ID of this leave rule applicable
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveRuleApplicable.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave rule applicable.
	*
	* @return the group ID of this leave rule applicable
	*/
	@Override
	public long getGroupId() {
		return _leaveRuleApplicable.getGroupId();
	}

	/**
	* Sets the group ID of this leave rule applicable.
	*
	* @param groupId the group ID of this leave rule applicable
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveRuleApplicable.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave rule applicable.
	*
	* @return the create date of this leave rule applicable
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveRuleApplicable.getCreateDate();
	}

	/**
	* Sets the create date of this leave rule applicable.
	*
	* @param createDate the create date of this leave rule applicable
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveRuleApplicable.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave rule applicable.
	*
	* @return the modified date of this leave rule applicable
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveRuleApplicable.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave rule applicable.
	*
	* @param modifiedDate the modified date of this leave rule applicable
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveRuleApplicable.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave rule applicable.
	*
	* @return the user ID of this leave rule applicable
	*/
	@Override
	public long getUserId() {
		return _leaveRuleApplicable.getUserId();
	}

	/**
	* Sets the user ID of this leave rule applicable.
	*
	* @param userId the user ID of this leave rule applicable
	*/
	@Override
	public void setUserId(long userId) {
		_leaveRuleApplicable.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave rule applicable.
	*
	* @return the user uuid of this leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicable.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave rule applicable.
	*
	* @param userUuid the user uuid of this leave rule applicable
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveRuleApplicable.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave rule applicable.
	*
	* @return the leave type ID of this leave rule applicable
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveRuleApplicable.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave rule applicable.
	*
	* @param leaveTypeId the leave type ID of this leave rule applicable
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveRuleApplicable.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the for female of this leave rule applicable.
	*
	* @return the for female of this leave rule applicable
	*/
	@Override
	public boolean getForFemale() {
		return _leaveRuleApplicable.getForFemale();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for female.
	*
	* @return <code>true</code> if this leave rule applicable is for female; <code>false</code> otherwise
	*/
	@Override
	public boolean isForFemale() {
		return _leaveRuleApplicable.isForFemale();
	}

	/**
	* Sets whether this leave rule applicable is for female.
	*
	* @param forFemale the for female of this leave rule applicable
	*/
	@Override
	public void setForFemale(boolean forFemale) {
		_leaveRuleApplicable.setForFemale(forFemale);
	}

	/**
	* Returns the for male of this leave rule applicable.
	*
	* @return the for male of this leave rule applicable
	*/
	@Override
	public boolean getForMale() {
		return _leaveRuleApplicable.getForMale();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for male.
	*
	* @return <code>true</code> if this leave rule applicable is for male; <code>false</code> otherwise
	*/
	@Override
	public boolean isForMale() {
		return _leaveRuleApplicable.isForMale();
	}

	/**
	* Sets whether this leave rule applicable is for male.
	*
	* @param forMale the for male of this leave rule applicable
	*/
	@Override
	public void setForMale(boolean forMale) {
		_leaveRuleApplicable.setForMale(forMale);
	}

	/**
	* Returns the for years of service of this leave rule applicable.
	*
	* @return the for years of service of this leave rule applicable
	*/
	@Override
	public boolean getForYearsOfService() {
		return _leaveRuleApplicable.getForYearsOfService();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for years of service.
	*
	* @return <code>true</code> if this leave rule applicable is for years of service; <code>false</code> otherwise
	*/
	@Override
	public boolean isForYearsOfService() {
		return _leaveRuleApplicable.isForYearsOfService();
	}

	/**
	* Sets whether this leave rule applicable is for years of service.
	*
	* @param forYearsOfService the for years of service of this leave rule applicable
	*/
	@Override
	public void setForYearsOfService(boolean forYearsOfService) {
		_leaveRuleApplicable.setForYearsOfService(forYearsOfService);
	}

	/**
	* Returns the from years of this leave rule applicable.
	*
	* @return the from years of this leave rule applicable
	*/
	@Override
	public java.lang.String getFromYears() {
		return _leaveRuleApplicable.getFromYears();
	}

	/**
	* Sets the from years of this leave rule applicable.
	*
	* @param fromYears the from years of this leave rule applicable
	*/
	@Override
	public void setFromYears(java.lang.String fromYears) {
		_leaveRuleApplicable.setFromYears(fromYears);
	}

	/**
	* Returns the to years of this leave rule applicable.
	*
	* @return the to years of this leave rule applicable
	*/
	@Override
	public java.lang.String getToYears() {
		return _leaveRuleApplicable.getToYears();
	}

	/**
	* Sets the to years of this leave rule applicable.
	*
	* @param toYears the to years of this leave rule applicable
	*/
	@Override
	public void setToYears(java.lang.String toYears) {
		_leaveRuleApplicable.setToYears(toYears);
	}

	/**
	* Returns the for job titles of this leave rule applicable.
	*
	* @return the for job titles of this leave rule applicable
	*/
	@Override
	public boolean getForJobTitles() {
		return _leaveRuleApplicable.getForJobTitles();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for job titles.
	*
	* @return <code>true</code> if this leave rule applicable is for job titles; <code>false</code> otherwise
	*/
	@Override
	public boolean isForJobTitles() {
		return _leaveRuleApplicable.isForJobTitles();
	}

	/**
	* Sets whether this leave rule applicable is for job titles.
	*
	* @param forJobTitles the for job titles of this leave rule applicable
	*/
	@Override
	public void setForJobTitles(boolean forJobTitles) {
		_leaveRuleApplicable.setForJobTitles(forJobTitles);
	}

	/**
	* Returns the for job categories of this leave rule applicable.
	*
	* @return the for job categories of this leave rule applicable
	*/
	@Override
	public boolean getForJobCategories() {
		return _leaveRuleApplicable.getForJobCategories();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for job categories.
	*
	* @return <code>true</code> if this leave rule applicable is for job categories; <code>false</code> otherwise
	*/
	@Override
	public boolean isForJobCategories() {
		return _leaveRuleApplicable.isForJobCategories();
	}

	/**
	* Sets whether this leave rule applicable is for job categories.
	*
	* @param forJobCategories the for job categories of this leave rule applicable
	*/
	@Override
	public void setForJobCategories(boolean forJobCategories) {
		_leaveRuleApplicable.setForJobCategories(forJobCategories);
	}

	/**
	* Returns the for employment status of this leave rule applicable.
	*
	* @return the for employment status of this leave rule applicable
	*/
	@Override
	public boolean getForEmploymentStatus() {
		return _leaveRuleApplicable.getForEmploymentStatus();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for employment status.
	*
	* @return <code>true</code> if this leave rule applicable is for employment status; <code>false</code> otherwise
	*/
	@Override
	public boolean isForEmploymentStatus() {
		return _leaveRuleApplicable.isForEmploymentStatus();
	}

	/**
	* Sets whether this leave rule applicable is for employment status.
	*
	* @param forEmploymentStatus the for employment status of this leave rule applicable
	*/
	@Override
	public void setForEmploymentStatus(boolean forEmploymentStatus) {
		_leaveRuleApplicable.setForEmploymentStatus(forEmploymentStatus);
	}

	/**
	* Returns the for gender of this leave rule applicable.
	*
	* @return the for gender of this leave rule applicable
	*/
	@Override
	public boolean getForGender() {
		return _leaveRuleApplicable.getForGender();
	}

	/**
	* Returns <code>true</code> if this leave rule applicable is for gender.
	*
	* @return <code>true</code> if this leave rule applicable is for gender; <code>false</code> otherwise
	*/
	@Override
	public boolean isForGender() {
		return _leaveRuleApplicable.isForGender();
	}

	/**
	* Sets whether this leave rule applicable is for gender.
	*
	* @param forGender the for gender of this leave rule applicable
	*/
	@Override
	public void setForGender(boolean forGender) {
		_leaveRuleApplicable.setForGender(forGender);
	}

	@Override
	public boolean isNew() {
		return _leaveRuleApplicable.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveRuleApplicable.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveRuleApplicable.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveRuleApplicable.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveRuleApplicable.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveRuleApplicable.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveRuleApplicable.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveRuleApplicable.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveRuleApplicable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveRuleApplicable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveRuleApplicable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveRuleApplicableWrapper((LeaveRuleApplicable)_leaveRuleApplicable.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable) {
		return _leaveRuleApplicable.compareTo(leaveRuleApplicable);
	}

	@Override
	public int hashCode() {
		return _leaveRuleApplicable.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> toCacheModel() {
		return _leaveRuleApplicable.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable toEscapedModel() {
		return new LeaveRuleApplicableWrapper(_leaveRuleApplicable.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable toUnescapedModel() {
		return new LeaveRuleApplicableWrapper(_leaveRuleApplicable.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveRuleApplicable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveRuleApplicable.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicable.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRuleApplicableWrapper)) {
			return false;
		}

		LeaveRuleApplicableWrapper leaveRuleApplicableWrapper = (LeaveRuleApplicableWrapper)obj;

		if (Validator.equals(_leaveRuleApplicable,
					leaveRuleApplicableWrapper._leaveRuleApplicable)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveRuleApplicable getWrappedLeaveRuleApplicable() {
		return _leaveRuleApplicable;
	}

	@Override
	public LeaveRuleApplicable getWrappedModel() {
		return _leaveRuleApplicable;
	}

	@Override
	public void resetOriginalValues() {
		_leaveRuleApplicable.resetOriginalValues();
	}

	private LeaveRuleApplicable _leaveRuleApplicable;
}