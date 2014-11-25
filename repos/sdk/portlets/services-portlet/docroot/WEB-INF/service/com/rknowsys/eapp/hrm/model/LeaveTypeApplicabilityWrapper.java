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
 * This class is a wrapper for {@link LeaveTypeApplicability}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeApplicability
 * @generated
 */
public class LeaveTypeApplicabilityWrapper implements LeaveTypeApplicability,
	ModelWrapper<LeaveTypeApplicability> {
	public LeaveTypeApplicabilityWrapper(
		LeaveTypeApplicability leaveTypeApplicability) {
		_leaveTypeApplicability = leaveTypeApplicability;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveTypeApplicability.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveTypeApplicability.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeApplicabilityId", getLeaveTypeApplicabilityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("ifYearsOfServiceCriterionApplicable",
			getIfYearsOfServiceCriterionApplicable());
		attributes.put("minYearsOfService", getMinYearsOfService());
		attributes.put("maxYearsOfService", getMaxYearsOfService());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeApplicabilityId = (Long)attributes.get(
				"leaveTypeApplicabilityId");

		if (leaveTypeApplicabilityId != null) {
			setLeaveTypeApplicabilityId(leaveTypeApplicabilityId);
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

		Boolean ifYearsOfServiceCriterionApplicable = (Boolean)attributes.get(
				"ifYearsOfServiceCriterionApplicable");

		if (ifYearsOfServiceCriterionApplicable != null) {
			setIfYearsOfServiceCriterionApplicable(ifYearsOfServiceCriterionApplicable);
		}

		String minYearsOfService = (String)attributes.get("minYearsOfService");

		if (minYearsOfService != null) {
			setMinYearsOfService(minYearsOfService);
		}

		String maxYearsOfService = (String)attributes.get("maxYearsOfService");

		if (maxYearsOfService != null) {
			setMaxYearsOfService(maxYearsOfService);
		}
	}

	/**
	* Returns the primary key of this leave type applicability.
	*
	* @return the primary key of this leave type applicability
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveTypeApplicability.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave type applicability.
	*
	* @param primaryKey the primary key of this leave type applicability
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveTypeApplicability.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave type applicability ID of this leave type applicability.
	*
	* @return the leave type applicability ID of this leave type applicability
	*/
	@Override
	public long getLeaveTypeApplicabilityId() {
		return _leaveTypeApplicability.getLeaveTypeApplicabilityId();
	}

	/**
	* Sets the leave type applicability ID of this leave type applicability.
	*
	* @param leaveTypeApplicabilityId the leave type applicability ID of this leave type applicability
	*/
	@Override
	public void setLeaveTypeApplicabilityId(long leaveTypeApplicabilityId) {
		_leaveTypeApplicability.setLeaveTypeApplicabilityId(leaveTypeApplicabilityId);
	}

	/**
	* Returns the company ID of this leave type applicability.
	*
	* @return the company ID of this leave type applicability
	*/
	@Override
	public long getCompanyId() {
		return _leaveTypeApplicability.getCompanyId();
	}

	/**
	* Sets the company ID of this leave type applicability.
	*
	* @param companyId the company ID of this leave type applicability
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveTypeApplicability.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave type applicability.
	*
	* @return the group ID of this leave type applicability
	*/
	@Override
	public long getGroupId() {
		return _leaveTypeApplicability.getGroupId();
	}

	/**
	* Sets the group ID of this leave type applicability.
	*
	* @param groupId the group ID of this leave type applicability
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveTypeApplicability.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave type applicability.
	*
	* @return the create date of this leave type applicability
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveTypeApplicability.getCreateDate();
	}

	/**
	* Sets the create date of this leave type applicability.
	*
	* @param createDate the create date of this leave type applicability
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveTypeApplicability.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave type applicability.
	*
	* @return the modified date of this leave type applicability
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveTypeApplicability.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave type applicability.
	*
	* @param modifiedDate the modified date of this leave type applicability
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveTypeApplicability.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave type applicability.
	*
	* @return the user ID of this leave type applicability
	*/
	@Override
	public long getUserId() {
		return _leaveTypeApplicability.getUserId();
	}

	/**
	* Sets the user ID of this leave type applicability.
	*
	* @param userId the user ID of this leave type applicability
	*/
	@Override
	public void setUserId(long userId) {
		_leaveTypeApplicability.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave type applicability.
	*
	* @return the user uuid of this leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicability.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave type applicability.
	*
	* @param userUuid the user uuid of this leave type applicability
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveTypeApplicability.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave type applicability.
	*
	* @return the leave type ID of this leave type applicability
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveTypeApplicability.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave type applicability.
	*
	* @param leaveTypeId the leave type ID of this leave type applicability
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeApplicability.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the if years of service criterion applicable of this leave type applicability.
	*
	* @return the if years of service criterion applicable of this leave type applicability
	*/
	@Override
	public boolean getIfYearsOfServiceCriterionApplicable() {
		return _leaveTypeApplicability.getIfYearsOfServiceCriterionApplicable();
	}

	/**
	* Returns <code>true</code> if this leave type applicability is if years of service criterion applicable.
	*
	* @return <code>true</code> if this leave type applicability is if years of service criterion applicable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfYearsOfServiceCriterionApplicable() {
		return _leaveTypeApplicability.isIfYearsOfServiceCriterionApplicable();
	}

	/**
	* Sets whether this leave type applicability is if years of service criterion applicable.
	*
	* @param ifYearsOfServiceCriterionApplicable the if years of service criterion applicable of this leave type applicability
	*/
	@Override
	public void setIfYearsOfServiceCriterionApplicable(
		boolean ifYearsOfServiceCriterionApplicable) {
		_leaveTypeApplicability.setIfYearsOfServiceCriterionApplicable(ifYearsOfServiceCriterionApplicable);
	}

	/**
	* Returns the min years of service of this leave type applicability.
	*
	* @return the min years of service of this leave type applicability
	*/
	@Override
	public java.lang.String getMinYearsOfService() {
		return _leaveTypeApplicability.getMinYearsOfService();
	}

	/**
	* Sets the min years of service of this leave type applicability.
	*
	* @param minYearsOfService the min years of service of this leave type applicability
	*/
	@Override
	public void setMinYearsOfService(java.lang.String minYearsOfService) {
		_leaveTypeApplicability.setMinYearsOfService(minYearsOfService);
	}

	/**
	* Returns the max years of service of this leave type applicability.
	*
	* @return the max years of service of this leave type applicability
	*/
	@Override
	public java.lang.String getMaxYearsOfService() {
		return _leaveTypeApplicability.getMaxYearsOfService();
	}

	/**
	* Sets the max years of service of this leave type applicability.
	*
	* @param maxYearsOfService the max years of service of this leave type applicability
	*/
	@Override
	public void setMaxYearsOfService(java.lang.String maxYearsOfService) {
		_leaveTypeApplicability.setMaxYearsOfService(maxYearsOfService);
	}

	@Override
	public boolean isNew() {
		return _leaveTypeApplicability.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveTypeApplicability.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveTypeApplicability.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveTypeApplicability.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveTypeApplicability.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveTypeApplicability.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveTypeApplicability.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveTypeApplicability.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveTypeApplicability.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveTypeApplicability.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveTypeApplicability.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveTypeApplicabilityWrapper((LeaveTypeApplicability)_leaveTypeApplicability.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability) {
		return _leaveTypeApplicability.compareTo(leaveTypeApplicability);
	}

	@Override
	public int hashCode() {
		return _leaveTypeApplicability.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> toCacheModel() {
		return _leaveTypeApplicability.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability toEscapedModel() {
		return new LeaveTypeApplicabilityWrapper(_leaveTypeApplicability.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability toUnescapedModel() {
		return new LeaveTypeApplicabilityWrapper(_leaveTypeApplicability.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveTypeApplicability.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveTypeApplicability.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicability.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveTypeApplicabilityWrapper)) {
			return false;
		}

		LeaveTypeApplicabilityWrapper leaveTypeApplicabilityWrapper = (LeaveTypeApplicabilityWrapper)obj;

		if (Validator.equals(_leaveTypeApplicability,
					leaveTypeApplicabilityWrapper._leaveTypeApplicability)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveTypeApplicability getWrappedLeaveTypeApplicability() {
		return _leaveTypeApplicability;
	}

	@Override
	public LeaveTypeApplicability getWrappedModel() {
		return _leaveTypeApplicability;
	}

	@Override
	public void resetOriginalValues() {
		_leaveTypeApplicability.resetOriginalValues();
	}

	private LeaveTypeApplicability _leaveTypeApplicability;
}