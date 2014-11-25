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
 * This class is a wrapper for {@link LeaveCarryForwardPolicy}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveCarryForwardPolicy
 * @generated
 */
public class LeaveCarryForwardPolicyWrapper implements LeaveCarryForwardPolicy,
	ModelWrapper<LeaveCarryForwardPolicy> {
	public LeaveCarryForwardPolicyWrapper(
		LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		_leaveCarryForwardPolicy = leaveCarryForwardPolicy;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveCarryForwardPolicy.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveCarryForwardPolicy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveCarryForwardPolicyId",
			getLeaveCarryForwardPolicyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("expiryDuration", getExpiryDuration());
		attributes.put("expiryDurationUOM", getExpiryDurationUOM());
		attributes.put("isMaxCarryForwardLimitApplicable",
			getIsMaxCarryForwardLimitApplicable());
		attributes.put("maxCarryForwardLimit", getMaxCarryForwardLimit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveCarryForwardPolicyId = (Long)attributes.get(
				"leaveCarryForwardPolicyId");

		if (leaveCarryForwardPolicyId != null) {
			setLeaveCarryForwardPolicyId(leaveCarryForwardPolicyId);
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

		Integer expiryDuration = (Integer)attributes.get("expiryDuration");

		if (expiryDuration != null) {
			setExpiryDuration(expiryDuration);
		}

		String expiryDurationUOM = (String)attributes.get("expiryDurationUOM");

		if (expiryDurationUOM != null) {
			setExpiryDurationUOM(expiryDurationUOM);
		}

		Boolean isMaxCarryForwardLimitApplicable = (Boolean)attributes.get(
				"isMaxCarryForwardLimitApplicable");

		if (isMaxCarryForwardLimitApplicable != null) {
			setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);
		}

		String maxCarryForwardLimit = (String)attributes.get(
				"maxCarryForwardLimit");

		if (maxCarryForwardLimit != null) {
			setMaxCarryForwardLimit(maxCarryForwardLimit);
		}
	}

	/**
	* Returns the primary key of this leave carry forward policy.
	*
	* @return the primary key of this leave carry forward policy
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveCarryForwardPolicy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave carry forward policy.
	*
	* @param primaryKey the primary key of this leave carry forward policy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveCarryForwardPolicy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave carry forward policy ID of this leave carry forward policy.
	*
	* @return the leave carry forward policy ID of this leave carry forward policy
	*/
	@Override
	public long getLeaveCarryForwardPolicyId() {
		return _leaveCarryForwardPolicy.getLeaveCarryForwardPolicyId();
	}

	/**
	* Sets the leave carry forward policy ID of this leave carry forward policy.
	*
	* @param leaveCarryForwardPolicyId the leave carry forward policy ID of this leave carry forward policy
	*/
	@Override
	public void setLeaveCarryForwardPolicyId(long leaveCarryForwardPolicyId) {
		_leaveCarryForwardPolicy.setLeaveCarryForwardPolicyId(leaveCarryForwardPolicyId);
	}

	/**
	* Returns the company ID of this leave carry forward policy.
	*
	* @return the company ID of this leave carry forward policy
	*/
	@Override
	public long getCompanyId() {
		return _leaveCarryForwardPolicy.getCompanyId();
	}

	/**
	* Sets the company ID of this leave carry forward policy.
	*
	* @param companyId the company ID of this leave carry forward policy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveCarryForwardPolicy.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave carry forward policy.
	*
	* @return the group ID of this leave carry forward policy
	*/
	@Override
	public long getGroupId() {
		return _leaveCarryForwardPolicy.getGroupId();
	}

	/**
	* Sets the group ID of this leave carry forward policy.
	*
	* @param groupId the group ID of this leave carry forward policy
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveCarryForwardPolicy.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave carry forward policy.
	*
	* @return the create date of this leave carry forward policy
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveCarryForwardPolicy.getCreateDate();
	}

	/**
	* Sets the create date of this leave carry forward policy.
	*
	* @param createDate the create date of this leave carry forward policy
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveCarryForwardPolicy.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave carry forward policy.
	*
	* @return the modified date of this leave carry forward policy
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveCarryForwardPolicy.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave carry forward policy.
	*
	* @param modifiedDate the modified date of this leave carry forward policy
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveCarryForwardPolicy.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave carry forward policy.
	*
	* @return the user ID of this leave carry forward policy
	*/
	@Override
	public long getUserId() {
		return _leaveCarryForwardPolicy.getUserId();
	}

	/**
	* Sets the user ID of this leave carry forward policy.
	*
	* @param userId the user ID of this leave carry forward policy
	*/
	@Override
	public void setUserId(long userId) {
		_leaveCarryForwardPolicy.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave carry forward policy.
	*
	* @return the user uuid of this leave carry forward policy
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicy.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave carry forward policy.
	*
	* @param userUuid the user uuid of this leave carry forward policy
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveCarryForwardPolicy.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave carry forward policy.
	*
	* @return the leave type ID of this leave carry forward policy
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveCarryForwardPolicy.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave carry forward policy.
	*
	* @param leaveTypeId the leave type ID of this leave carry forward policy
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveCarryForwardPolicy.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the expiry duration of this leave carry forward policy.
	*
	* @return the expiry duration of this leave carry forward policy
	*/
	@Override
	public int getExpiryDuration() {
		return _leaveCarryForwardPolicy.getExpiryDuration();
	}

	/**
	* Sets the expiry duration of this leave carry forward policy.
	*
	* @param expiryDuration the expiry duration of this leave carry forward policy
	*/
	@Override
	public void setExpiryDuration(int expiryDuration) {
		_leaveCarryForwardPolicy.setExpiryDuration(expiryDuration);
	}

	/**
	* Returns the expiry duration u o m of this leave carry forward policy.
	*
	* @return the expiry duration u o m of this leave carry forward policy
	*/
	@Override
	public java.lang.String getExpiryDurationUOM() {
		return _leaveCarryForwardPolicy.getExpiryDurationUOM();
	}

	/**
	* Sets the expiry duration u o m of this leave carry forward policy.
	*
	* @param expiryDurationUOM the expiry duration u o m of this leave carry forward policy
	*/
	@Override
	public void setExpiryDurationUOM(java.lang.String expiryDurationUOM) {
		_leaveCarryForwardPolicy.setExpiryDurationUOM(expiryDurationUOM);
	}

	/**
	* Returns the is max carry forward limit applicable of this leave carry forward policy.
	*
	* @return the is max carry forward limit applicable of this leave carry forward policy
	*/
	@Override
	public boolean getIsMaxCarryForwardLimitApplicable() {
		return _leaveCarryForwardPolicy.getIsMaxCarryForwardLimitApplicable();
	}

	/**
	* Returns <code>true</code> if this leave carry forward policy is is max carry forward limit applicable.
	*
	* @return <code>true</code> if this leave carry forward policy is is max carry forward limit applicable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMaxCarryForwardLimitApplicable() {
		return _leaveCarryForwardPolicy.isIsMaxCarryForwardLimitApplicable();
	}

	/**
	* Sets whether this leave carry forward policy is is max carry forward limit applicable.
	*
	* @param isMaxCarryForwardLimitApplicable the is max carry forward limit applicable of this leave carry forward policy
	*/
	@Override
	public void setIsMaxCarryForwardLimitApplicable(
		boolean isMaxCarryForwardLimitApplicable) {
		_leaveCarryForwardPolicy.setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);
	}

	/**
	* Returns the max carry forward limit of this leave carry forward policy.
	*
	* @return the max carry forward limit of this leave carry forward policy
	*/
	@Override
	public java.lang.String getMaxCarryForwardLimit() {
		return _leaveCarryForwardPolicy.getMaxCarryForwardLimit();
	}

	/**
	* Sets the max carry forward limit of this leave carry forward policy.
	*
	* @param maxCarryForwardLimit the max carry forward limit of this leave carry forward policy
	*/
	@Override
	public void setMaxCarryForwardLimit(java.lang.String maxCarryForwardLimit) {
		_leaveCarryForwardPolicy.setMaxCarryForwardLimit(maxCarryForwardLimit);
	}

	@Override
	public boolean isNew() {
		return _leaveCarryForwardPolicy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveCarryForwardPolicy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveCarryForwardPolicy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveCarryForwardPolicy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveCarryForwardPolicy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveCarryForwardPolicy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveCarryForwardPolicy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveCarryForwardPolicy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveCarryForwardPolicy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveCarryForwardPolicy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveCarryForwardPolicy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveCarryForwardPolicyWrapper((LeaveCarryForwardPolicy)_leaveCarryForwardPolicy.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		return _leaveCarryForwardPolicy.compareTo(leaveCarryForwardPolicy);
	}

	@Override
	public int hashCode() {
		return _leaveCarryForwardPolicy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy> toCacheModel() {
		return _leaveCarryForwardPolicy.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy toEscapedModel() {
		return new LeaveCarryForwardPolicyWrapper(_leaveCarryForwardPolicy.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy toUnescapedModel() {
		return new LeaveCarryForwardPolicyWrapper(_leaveCarryForwardPolicy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveCarryForwardPolicy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveCarryForwardPolicy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveCarryForwardPolicy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveCarryForwardPolicyWrapper)) {
			return false;
		}

		LeaveCarryForwardPolicyWrapper leaveCarryForwardPolicyWrapper = (LeaveCarryForwardPolicyWrapper)obj;

		if (Validator.equals(_leaveCarryForwardPolicy,
					leaveCarryForwardPolicyWrapper._leaveCarryForwardPolicy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveCarryForwardPolicy getWrappedLeaveCarryForwardPolicy() {
		return _leaveCarryForwardPolicy;
	}

	@Override
	public LeaveCarryForwardPolicy getWrappedModel() {
		return _leaveCarryForwardPolicy;
	}

	@Override
	public void resetOriginalValues() {
		_leaveCarryForwardPolicy.resetOriginalValues();
	}

	private LeaveCarryForwardPolicy _leaveCarryForwardPolicy;
}