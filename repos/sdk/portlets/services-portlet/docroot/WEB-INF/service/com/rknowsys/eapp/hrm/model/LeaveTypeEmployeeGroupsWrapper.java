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
 * This class is a wrapper for {@link LeaveTypeEmployeeGroups}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeEmployeeGroups
 * @generated
 */
public class LeaveTypeEmployeeGroupsWrapper implements LeaveTypeEmployeeGroups,
	ModelWrapper<LeaveTypeEmployeeGroups> {
	public LeaveTypeEmployeeGroupsWrapper(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		_leaveTypeEmployeeGroups = leaveTypeEmployeeGroups;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveTypeEmployeeGroups.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveTypeEmployeeGroups.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeEmployeeGroupId", getLeaveTypeEmployeeGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("groupName", getGroupName());
		attributes.put("forJobTitles", getForJobTitles());
		attributes.put("forJobCategories", getForJobCategories());
		attributes.put("forEmploymentStatus", getForEmploymentStatus());
		attributes.put("forGender", getForGender());
		attributes.put("forFemale", getForFemale());
		attributes.put("forMale", getForMale());
		attributes.put("forYearsOfService", getForYearsOfService());
		attributes.put("fromYears", getFromYears());
		attributes.put("toYears", getToYears());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeEmployeeGroupId = (Long)attributes.get(
				"leaveTypeEmployeeGroupId");

		if (leaveTypeEmployeeGroupId != null) {
			setLeaveTypeEmployeeGroupId(leaveTypeEmployeeGroupId);
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

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
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
	}

	/**
	* Returns the primary key of this leave type employee groups.
	*
	* @return the primary key of this leave type employee groups
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveTypeEmployeeGroups.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave type employee groups.
	*
	* @param primaryKey the primary key of this leave type employee groups
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveTypeEmployeeGroups.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave type employee group ID of this leave type employee groups.
	*
	* @return the leave type employee group ID of this leave type employee groups
	*/
	@Override
	public long getLeaveTypeEmployeeGroupId() {
		return _leaveTypeEmployeeGroups.getLeaveTypeEmployeeGroupId();
	}

	/**
	* Sets the leave type employee group ID of this leave type employee groups.
	*
	* @param leaveTypeEmployeeGroupId the leave type employee group ID of this leave type employee groups
	*/
	@Override
	public void setLeaveTypeEmployeeGroupId(long leaveTypeEmployeeGroupId) {
		_leaveTypeEmployeeGroups.setLeaveTypeEmployeeGroupId(leaveTypeEmployeeGroupId);
	}

	/**
	* Returns the company ID of this leave type employee groups.
	*
	* @return the company ID of this leave type employee groups
	*/
	@Override
	public long getCompanyId() {
		return _leaveTypeEmployeeGroups.getCompanyId();
	}

	/**
	* Sets the company ID of this leave type employee groups.
	*
	* @param companyId the company ID of this leave type employee groups
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveTypeEmployeeGroups.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave type employee groups.
	*
	* @return the group ID of this leave type employee groups
	*/
	@Override
	public long getGroupId() {
		return _leaveTypeEmployeeGroups.getGroupId();
	}

	/**
	* Sets the group ID of this leave type employee groups.
	*
	* @param groupId the group ID of this leave type employee groups
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveTypeEmployeeGroups.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave type employee groups.
	*
	* @return the create date of this leave type employee groups
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveTypeEmployeeGroups.getCreateDate();
	}

	/**
	* Sets the create date of this leave type employee groups.
	*
	* @param createDate the create date of this leave type employee groups
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveTypeEmployeeGroups.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave type employee groups.
	*
	* @return the modified date of this leave type employee groups
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveTypeEmployeeGroups.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave type employee groups.
	*
	* @param modifiedDate the modified date of this leave type employee groups
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveTypeEmployeeGroups.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave type employee groups.
	*
	* @return the user ID of this leave type employee groups
	*/
	@Override
	public long getUserId() {
		return _leaveTypeEmployeeGroups.getUserId();
	}

	/**
	* Sets the user ID of this leave type employee groups.
	*
	* @param userId the user ID of this leave type employee groups
	*/
	@Override
	public void setUserId(long userId) {
		_leaveTypeEmployeeGroups.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave type employee groups.
	*
	* @return the user uuid of this leave type employee groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroups.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave type employee groups.
	*
	* @param userUuid the user uuid of this leave type employee groups
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveTypeEmployeeGroups.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave type employee groups.
	*
	* @return the leave type ID of this leave type employee groups
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveTypeEmployeeGroups.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave type employee groups.
	*
	* @param leaveTypeId the leave type ID of this leave type employee groups
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeEmployeeGroups.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the group name of this leave type employee groups.
	*
	* @return the group name of this leave type employee groups
	*/
	@Override
	public java.lang.String getGroupName() {
		return _leaveTypeEmployeeGroups.getGroupName();
	}

	/**
	* Sets the group name of this leave type employee groups.
	*
	* @param groupName the group name of this leave type employee groups
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_leaveTypeEmployeeGroups.setGroupName(groupName);
	}

	/**
	* Returns the for job titles of this leave type employee groups.
	*
	* @return the for job titles of this leave type employee groups
	*/
	@Override
	public boolean getForJobTitles() {
		return _leaveTypeEmployeeGroups.getForJobTitles();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for job titles.
	*
	* @return <code>true</code> if this leave type employee groups is for job titles; <code>false</code> otherwise
	*/
	@Override
	public boolean isForJobTitles() {
		return _leaveTypeEmployeeGroups.isForJobTitles();
	}

	/**
	* Sets whether this leave type employee groups is for job titles.
	*
	* @param forJobTitles the for job titles of this leave type employee groups
	*/
	@Override
	public void setForJobTitles(boolean forJobTitles) {
		_leaveTypeEmployeeGroups.setForJobTitles(forJobTitles);
	}

	/**
	* Returns the for job categories of this leave type employee groups.
	*
	* @return the for job categories of this leave type employee groups
	*/
	@Override
	public boolean getForJobCategories() {
		return _leaveTypeEmployeeGroups.getForJobCategories();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for job categories.
	*
	* @return <code>true</code> if this leave type employee groups is for job categories; <code>false</code> otherwise
	*/
	@Override
	public boolean isForJobCategories() {
		return _leaveTypeEmployeeGroups.isForJobCategories();
	}

	/**
	* Sets whether this leave type employee groups is for job categories.
	*
	* @param forJobCategories the for job categories of this leave type employee groups
	*/
	@Override
	public void setForJobCategories(boolean forJobCategories) {
		_leaveTypeEmployeeGroups.setForJobCategories(forJobCategories);
	}

	/**
	* Returns the for employment status of this leave type employee groups.
	*
	* @return the for employment status of this leave type employee groups
	*/
	@Override
	public boolean getForEmploymentStatus() {
		return _leaveTypeEmployeeGroups.getForEmploymentStatus();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for employment status.
	*
	* @return <code>true</code> if this leave type employee groups is for employment status; <code>false</code> otherwise
	*/
	@Override
	public boolean isForEmploymentStatus() {
		return _leaveTypeEmployeeGroups.isForEmploymentStatus();
	}

	/**
	* Sets whether this leave type employee groups is for employment status.
	*
	* @param forEmploymentStatus the for employment status of this leave type employee groups
	*/
	@Override
	public void setForEmploymentStatus(boolean forEmploymentStatus) {
		_leaveTypeEmployeeGroups.setForEmploymentStatus(forEmploymentStatus);
	}

	/**
	* Returns the for gender of this leave type employee groups.
	*
	* @return the for gender of this leave type employee groups
	*/
	@Override
	public boolean getForGender() {
		return _leaveTypeEmployeeGroups.getForGender();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for gender.
	*
	* @return <code>true</code> if this leave type employee groups is for gender; <code>false</code> otherwise
	*/
	@Override
	public boolean isForGender() {
		return _leaveTypeEmployeeGroups.isForGender();
	}

	/**
	* Sets whether this leave type employee groups is for gender.
	*
	* @param forGender the for gender of this leave type employee groups
	*/
	@Override
	public void setForGender(boolean forGender) {
		_leaveTypeEmployeeGroups.setForGender(forGender);
	}

	/**
	* Returns the for female of this leave type employee groups.
	*
	* @return the for female of this leave type employee groups
	*/
	@Override
	public boolean getForFemale() {
		return _leaveTypeEmployeeGroups.getForFemale();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for female.
	*
	* @return <code>true</code> if this leave type employee groups is for female; <code>false</code> otherwise
	*/
	@Override
	public boolean isForFemale() {
		return _leaveTypeEmployeeGroups.isForFemale();
	}

	/**
	* Sets whether this leave type employee groups is for female.
	*
	* @param forFemale the for female of this leave type employee groups
	*/
	@Override
	public void setForFemale(boolean forFemale) {
		_leaveTypeEmployeeGroups.setForFemale(forFemale);
	}

	/**
	* Returns the for male of this leave type employee groups.
	*
	* @return the for male of this leave type employee groups
	*/
	@Override
	public boolean getForMale() {
		return _leaveTypeEmployeeGroups.getForMale();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for male.
	*
	* @return <code>true</code> if this leave type employee groups is for male; <code>false</code> otherwise
	*/
	@Override
	public boolean isForMale() {
		return _leaveTypeEmployeeGroups.isForMale();
	}

	/**
	* Sets whether this leave type employee groups is for male.
	*
	* @param forMale the for male of this leave type employee groups
	*/
	@Override
	public void setForMale(boolean forMale) {
		_leaveTypeEmployeeGroups.setForMale(forMale);
	}

	/**
	* Returns the for years of service of this leave type employee groups.
	*
	* @return the for years of service of this leave type employee groups
	*/
	@Override
	public boolean getForYearsOfService() {
		return _leaveTypeEmployeeGroups.getForYearsOfService();
	}

	/**
	* Returns <code>true</code> if this leave type employee groups is for years of service.
	*
	* @return <code>true</code> if this leave type employee groups is for years of service; <code>false</code> otherwise
	*/
	@Override
	public boolean isForYearsOfService() {
		return _leaveTypeEmployeeGroups.isForYearsOfService();
	}

	/**
	* Sets whether this leave type employee groups is for years of service.
	*
	* @param forYearsOfService the for years of service of this leave type employee groups
	*/
	@Override
	public void setForYearsOfService(boolean forYearsOfService) {
		_leaveTypeEmployeeGroups.setForYearsOfService(forYearsOfService);
	}

	/**
	* Returns the from years of this leave type employee groups.
	*
	* @return the from years of this leave type employee groups
	*/
	@Override
	public java.lang.String getFromYears() {
		return _leaveTypeEmployeeGroups.getFromYears();
	}

	/**
	* Sets the from years of this leave type employee groups.
	*
	* @param fromYears the from years of this leave type employee groups
	*/
	@Override
	public void setFromYears(java.lang.String fromYears) {
		_leaveTypeEmployeeGroups.setFromYears(fromYears);
	}

	/**
	* Returns the to years of this leave type employee groups.
	*
	* @return the to years of this leave type employee groups
	*/
	@Override
	public java.lang.String getToYears() {
		return _leaveTypeEmployeeGroups.getToYears();
	}

	/**
	* Sets the to years of this leave type employee groups.
	*
	* @param toYears the to years of this leave type employee groups
	*/
	@Override
	public void setToYears(java.lang.String toYears) {
		_leaveTypeEmployeeGroups.setToYears(toYears);
	}

	@Override
	public boolean isNew() {
		return _leaveTypeEmployeeGroups.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveTypeEmployeeGroups.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveTypeEmployeeGroups.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveTypeEmployeeGroups.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveTypeEmployeeGroups.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveTypeEmployeeGroups.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveTypeEmployeeGroups.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveTypeEmployeeGroups.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveTypeEmployeeGroups.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveTypeEmployeeGroups.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveTypeEmployeeGroups.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveTypeEmployeeGroupsWrapper((LeaveTypeEmployeeGroups)_leaveTypeEmployeeGroups.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		return _leaveTypeEmployeeGroups.compareTo(leaveTypeEmployeeGroups);
	}

	@Override
	public int hashCode() {
		return _leaveTypeEmployeeGroups.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> toCacheModel() {
		return _leaveTypeEmployeeGroups.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups toEscapedModel() {
		return new LeaveTypeEmployeeGroupsWrapper(_leaveTypeEmployeeGroups.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups toUnescapedModel() {
		return new LeaveTypeEmployeeGroupsWrapper(_leaveTypeEmployeeGroups.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveTypeEmployeeGroups.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveTypeEmployeeGroups.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeEmployeeGroups.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveTypeEmployeeGroupsWrapper)) {
			return false;
		}

		LeaveTypeEmployeeGroupsWrapper leaveTypeEmployeeGroupsWrapper = (LeaveTypeEmployeeGroupsWrapper)obj;

		if (Validator.equals(_leaveTypeEmployeeGroups,
					leaveTypeEmployeeGroupsWrapper._leaveTypeEmployeeGroups)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveTypeEmployeeGroups getWrappedLeaveTypeEmployeeGroups() {
		return _leaveTypeEmployeeGroups;
	}

	@Override
	public LeaveTypeEmployeeGroups getWrappedModel() {
		return _leaveTypeEmployeeGroups;
	}

	@Override
	public void resetOriginalValues() {
		_leaveTypeEmployeeGroups.resetOriginalValues();
	}

	private LeaveTypeEmployeeGroups _leaveTypeEmployeeGroups;
}