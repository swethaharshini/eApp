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
 * This class is a wrapper for {@link LeaveType}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveType
 * @generated
 */
public class LeaveTypeWrapper implements LeaveType, ModelWrapper<LeaveType> {
	public LeaveTypeWrapper(LeaveType leaveType) {
		_leaveType = leaveType;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveType.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("leaveTypeName", getLeaveTypeName());
		attributes.put("isSituational", getIsSituational());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
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

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		String leaveTypeName = (String)attributes.get("leaveTypeName");

		if (leaveTypeName != null) {
			setLeaveTypeName(leaveTypeName);
		}

		Boolean isSituational = (Boolean)attributes.get("isSituational");

		if (isSituational != null) {
			setIsSituational(isSituational);
		}
	}

	/**
	* Returns the primary key of this leave type.
	*
	* @return the primary key of this leave type
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave type.
	*
	* @param primaryKey the primary key of this leave type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave type ID of this leave type.
	*
	* @return the leave type ID of this leave type
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveType.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave type.
	*
	* @param leaveTypeId the leave type ID of this leave type
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveType.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the company ID of this leave type.
	*
	* @return the company ID of this leave type
	*/
	@Override
	public long getCompanyId() {
		return _leaveType.getCompanyId();
	}

	/**
	* Sets the company ID of this leave type.
	*
	* @param companyId the company ID of this leave type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveType.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave type.
	*
	* @return the group ID of this leave type
	*/
	@Override
	public long getGroupId() {
		return _leaveType.getGroupId();
	}

	/**
	* Sets the group ID of this leave type.
	*
	* @param groupId the group ID of this leave type
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveType.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave type.
	*
	* @return the create date of this leave type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveType.getCreateDate();
	}

	/**
	* Sets the create date of this leave type.
	*
	* @param createDate the create date of this leave type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave type.
	*
	* @return the modified date of this leave type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveType.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave type.
	*
	* @param modifiedDate the modified date of this leave type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave type.
	*
	* @return the user ID of this leave type
	*/
	@Override
	public long getUserId() {
		return _leaveType.getUserId();
	}

	/**
	* Sets the user ID of this leave type.
	*
	* @param userId the user ID of this leave type
	*/
	@Override
	public void setUserId(long userId) {
		_leaveType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave type.
	*
	* @return the user uuid of this leave type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveType.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave type.
	*
	* @param userUuid the user uuid of this leave type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveType.setUserUuid(userUuid);
	}

	/**
	* Returns the nationality ID of this leave type.
	*
	* @return the nationality ID of this leave type
	*/
	@Override
	public long getNationalityId() {
		return _leaveType.getNationalityId();
	}

	/**
	* Sets the nationality ID of this leave type.
	*
	* @param nationalityId the nationality ID of this leave type
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_leaveType.setNationalityId(nationalityId);
	}

	/**
	* Returns the leave type name of this leave type.
	*
	* @return the leave type name of this leave type
	*/
	@Override
	public java.lang.String getLeaveTypeName() {
		return _leaveType.getLeaveTypeName();
	}

	/**
	* Sets the leave type name of this leave type.
	*
	* @param leaveTypeName the leave type name of this leave type
	*/
	@Override
	public void setLeaveTypeName(java.lang.String leaveTypeName) {
		_leaveType.setLeaveTypeName(leaveTypeName);
	}

	/**
	* Returns the is situational of this leave type.
	*
	* @return the is situational of this leave type
	*/
	@Override
	public boolean getIsSituational() {
		return _leaveType.getIsSituational();
	}

	/**
	* Returns <code>true</code> if this leave type is is situational.
	*
	* @return <code>true</code> if this leave type is is situational; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSituational() {
		return _leaveType.isIsSituational();
	}

	/**
	* Sets whether this leave type is is situational.
	*
	* @param isSituational the is situational of this leave type
	*/
	@Override
	public void setIsSituational(boolean isSituational) {
		_leaveType.setIsSituational(isSituational);
	}

	@Override
	public boolean isNew() {
		return _leaveType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveTypeWrapper((LeaveType)_leaveType.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.LeaveType leaveType) {
		return _leaveType.compareTo(leaveType);
	}

	@Override
	public int hashCode() {
		return _leaveType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveType> toCacheModel() {
		return _leaveType.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveType toEscapedModel() {
		return new LeaveTypeWrapper(_leaveType.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveType toUnescapedModel() {
		return new LeaveTypeWrapper(_leaveType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveTypeWrapper)) {
			return false;
		}

		LeaveTypeWrapper leaveTypeWrapper = (LeaveTypeWrapper)obj;

		if (Validator.equals(_leaveType, leaveTypeWrapper._leaveType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveType getWrappedLeaveType() {
		return _leaveType;
	}

	@Override
	public LeaveType getWrappedModel() {
		return _leaveType;
	}

	@Override
	public void resetOriginalValues() {
		_leaveType.resetOriginalValues();
	}

	private LeaveType _leaveType;
}