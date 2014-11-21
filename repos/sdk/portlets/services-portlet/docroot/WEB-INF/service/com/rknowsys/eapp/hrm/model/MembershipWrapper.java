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
 * This class is a wrapper for {@link Membership}.
 * </p>
 *
 * @author rknowsys
 * @see Membership
 * @generated
 */
public class MembershipWrapper implements Membership, ModelWrapper<Membership> {
	public MembershipWrapper(Membership membership) {
		_membership = membership;
	}

	@Override
	public Class<?> getModelClass() {
		return Membership.class;
	}

	@Override
	public String getModelClassName() {
		return Membership.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("membershipId", getMembershipId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("membershipName", getMembershipName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long membershipId = (Long)attributes.get("membershipId");

		if (membershipId != null) {
			setMembershipId(membershipId);
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

		String membershipName = (String)attributes.get("membershipName");

		if (membershipName != null) {
			setMembershipName(membershipName);
		}
	}

	/**
	* Returns the primary key of this membership.
	*
	* @return the primary key of this membership
	*/
	@Override
	public long getPrimaryKey() {
		return _membership.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership.
	*
	* @param primaryKey the primary key of this membership
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membership.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the membership ID of this membership.
	*
	* @return the membership ID of this membership
	*/
	@Override
	public long getMembershipId() {
		return _membership.getMembershipId();
	}

	/**
	* Sets the membership ID of this membership.
	*
	* @param membershipId the membership ID of this membership
	*/
	@Override
	public void setMembershipId(long membershipId) {
		_membership.setMembershipId(membershipId);
	}

	/**
	* Returns the company ID of this membership.
	*
	* @return the company ID of this membership
	*/
	@Override
	public long getCompanyId() {
		return _membership.getCompanyId();
	}

	/**
	* Sets the company ID of this membership.
	*
	* @param companyId the company ID of this membership
	*/
	@Override
	public void setCompanyId(long companyId) {
		_membership.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this membership.
	*
	* @return the group ID of this membership
	*/
	@Override
	public long getGroupId() {
		return _membership.getGroupId();
	}

	/**
	* Sets the group ID of this membership.
	*
	* @param groupId the group ID of this membership
	*/
	@Override
	public void setGroupId(long groupId) {
		_membership.setGroupId(groupId);
	}

	/**
	* Returns the create date of this membership.
	*
	* @return the create date of this membership
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _membership.getCreateDate();
	}

	/**
	* Sets the create date of this membership.
	*
	* @param createDate the create date of this membership
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_membership.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this membership.
	*
	* @return the modified date of this membership
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _membership.getModifiedDate();
	}

	/**
	* Sets the modified date of this membership.
	*
	* @param modifiedDate the modified date of this membership
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_membership.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this membership.
	*
	* @return the user ID of this membership
	*/
	@Override
	public long getUserId() {
		return _membership.getUserId();
	}

	/**
	* Sets the user ID of this membership.
	*
	* @param userId the user ID of this membership
	*/
	@Override
	public void setUserId(long userId) {
		_membership.setUserId(userId);
	}

	/**
	* Returns the user uuid of this membership.
	*
	* @return the user uuid of this membership
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membership.getUserUuid();
	}

	/**
	* Sets the user uuid of this membership.
	*
	* @param userUuid the user uuid of this membership
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_membership.setUserUuid(userUuid);
	}

	/**
	* Returns the membership name of this membership.
	*
	* @return the membership name of this membership
	*/
	@Override
	public java.lang.String getMembershipName() {
		return _membership.getMembershipName();
	}

	/**
	* Sets the membership name of this membership.
	*
	* @param membershipName the membership name of this membership
	*/
	@Override
	public void setMembershipName(java.lang.String membershipName) {
		_membership.setMembershipName(membershipName);
	}

	@Override
	public boolean isNew() {
		return _membership.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membership.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membership.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membership.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membership.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membership.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membership.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membership.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membership.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membership.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membership.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipWrapper((Membership)_membership.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Membership membership) {
		return _membership.compareTo(membership);
	}

	@Override
	public int hashCode() {
		return _membership.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Membership> toCacheModel() {
		return _membership.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Membership toEscapedModel() {
		return new MembershipWrapper(_membership.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Membership toUnescapedModel() {
		return new MembershipWrapper(_membership.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membership.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membership.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membership.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipWrapper)) {
			return false;
		}

		MembershipWrapper membershipWrapper = (MembershipWrapper)obj;

		if (Validator.equals(_membership, membershipWrapper._membership)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Membership getWrappedMembership() {
		return _membership;
	}

	@Override
	public Membership getWrappedModel() {
		return _membership;
	}

	@Override
	public void resetOriginalValues() {
		_membership.resetOriginalValues();
	}

	private Membership _membership;
}