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
 * This class is a wrapper for {@link EmpMembership}.
 * </p>
 *
 * @author rknowsys
 * @see EmpMembership
 * @generated
 */
public class EmpMembershipWrapper implements EmpMembership,
	ModelWrapper<EmpMembership> {
	public EmpMembershipWrapper(EmpMembership empMembership) {
		_empMembership = empMembership;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpMembership.class;
	}

	@Override
	public String getModelClassName() {
		return EmpMembership.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empMembershipId", getEmpMembershipId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("membershipId", getMembershipId());
		attributes.put("subscriptionPaidBy", getSubscriptionPaidBy());
		attributes.put("subscriptionAmt", getSubscriptionAmt());
		attributes.put("currency", getCurrency());
		attributes.put("commenceDate", getCommenceDate());
		attributes.put("renewalDate", getRenewalDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empMembershipId = (Long)attributes.get("empMembershipId");

		if (empMembershipId != null) {
			setEmpMembershipId(empMembershipId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long membershipId = (Long)attributes.get("membershipId");

		if (membershipId != null) {
			setMembershipId(membershipId);
		}

		String subscriptionPaidBy = (String)attributes.get("subscriptionPaidBy");

		if (subscriptionPaidBy != null) {
			setSubscriptionPaidBy(subscriptionPaidBy);
		}

		Long subscriptionAmt = (Long)attributes.get("subscriptionAmt");

		if (subscriptionAmt != null) {
			setSubscriptionAmt(subscriptionAmt);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Date commenceDate = (Date)attributes.get("commenceDate");

		if (commenceDate != null) {
			setCommenceDate(commenceDate);
		}

		Date renewalDate = (Date)attributes.get("renewalDate");

		if (renewalDate != null) {
			setRenewalDate(renewalDate);
		}
	}

	/**
	* Returns the primary key of this emp membership.
	*
	* @return the primary key of this emp membership
	*/
	@Override
	public long getPrimaryKey() {
		return _empMembership.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp membership.
	*
	* @param primaryKey the primary key of this emp membership
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empMembership.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp membership ID of this emp membership.
	*
	* @return the emp membership ID of this emp membership
	*/
	@Override
	public long getEmpMembershipId() {
		return _empMembership.getEmpMembershipId();
	}

	/**
	* Sets the emp membership ID of this emp membership.
	*
	* @param empMembershipId the emp membership ID of this emp membership
	*/
	@Override
	public void setEmpMembershipId(long empMembershipId) {
		_empMembership.setEmpMembershipId(empMembershipId);
	}

	/**
	* Returns the employee ID of this emp membership.
	*
	* @return the employee ID of this emp membership
	*/
	@Override
	public long getEmployeeId() {
		return _empMembership.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp membership.
	*
	* @param employeeId the employee ID of this emp membership
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empMembership.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp membership.
	*
	* @return the group ID of this emp membership
	*/
	@Override
	public long getGroupId() {
		return _empMembership.getGroupId();
	}

	/**
	* Sets the group ID of this emp membership.
	*
	* @param groupId the group ID of this emp membership
	*/
	@Override
	public void setGroupId(long groupId) {
		_empMembership.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp membership.
	*
	* @return the company ID of this emp membership
	*/
	@Override
	public long getCompanyId() {
		return _empMembership.getCompanyId();
	}

	/**
	* Sets the company ID of this emp membership.
	*
	* @param companyId the company ID of this emp membership
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empMembership.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp membership.
	*
	* @return the create date of this emp membership
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empMembership.getCreateDate();
	}

	/**
	* Sets the create date of this emp membership.
	*
	* @param createDate the create date of this emp membership
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empMembership.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp membership.
	*
	* @return the modified date of this emp membership
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empMembership.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp membership.
	*
	* @param modifiedDate the modified date of this emp membership
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empMembership.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp membership.
	*
	* @return the user ID of this emp membership
	*/
	@Override
	public long getUserId() {
		return _empMembership.getUserId();
	}

	/**
	* Sets the user ID of this emp membership.
	*
	* @param userId the user ID of this emp membership
	*/
	@Override
	public void setUserId(long userId) {
		_empMembership.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp membership.
	*
	* @return the user uuid of this emp membership
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empMembership.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp membership.
	*
	* @param userUuid the user uuid of this emp membership
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empMembership.setUserUuid(userUuid);
	}

	/**
	* Returns the membership ID of this emp membership.
	*
	* @return the membership ID of this emp membership
	*/
	@Override
	public long getMembershipId() {
		return _empMembership.getMembershipId();
	}

	/**
	* Sets the membership ID of this emp membership.
	*
	* @param membershipId the membership ID of this emp membership
	*/
	@Override
	public void setMembershipId(long membershipId) {
		_empMembership.setMembershipId(membershipId);
	}

	/**
	* Returns the subscription paid by of this emp membership.
	*
	* @return the subscription paid by of this emp membership
	*/
	@Override
	public java.lang.String getSubscriptionPaidBy() {
		return _empMembership.getSubscriptionPaidBy();
	}

	/**
	* Sets the subscription paid by of this emp membership.
	*
	* @param subscriptionPaidBy the subscription paid by of this emp membership
	*/
	@Override
	public void setSubscriptionPaidBy(java.lang.String subscriptionPaidBy) {
		_empMembership.setSubscriptionPaidBy(subscriptionPaidBy);
	}

	/**
	* Returns the subscription amt of this emp membership.
	*
	* @return the subscription amt of this emp membership
	*/
	@Override
	public long getSubscriptionAmt() {
		return _empMembership.getSubscriptionAmt();
	}

	/**
	* Sets the subscription amt of this emp membership.
	*
	* @param subscriptionAmt the subscription amt of this emp membership
	*/
	@Override
	public void setSubscriptionAmt(long subscriptionAmt) {
		_empMembership.setSubscriptionAmt(subscriptionAmt);
	}

	/**
	* Returns the currency of this emp membership.
	*
	* @return the currency of this emp membership
	*/
	@Override
	public java.lang.String getCurrency() {
		return _empMembership.getCurrency();
	}

	/**
	* Sets the currency of this emp membership.
	*
	* @param currency the currency of this emp membership
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_empMembership.setCurrency(currency);
	}

	/**
	* Returns the commence date of this emp membership.
	*
	* @return the commence date of this emp membership
	*/
	@Override
	public java.util.Date getCommenceDate() {
		return _empMembership.getCommenceDate();
	}

	/**
	* Sets the commence date of this emp membership.
	*
	* @param commenceDate the commence date of this emp membership
	*/
	@Override
	public void setCommenceDate(java.util.Date commenceDate) {
		_empMembership.setCommenceDate(commenceDate);
	}

	/**
	* Returns the renewal date of this emp membership.
	*
	* @return the renewal date of this emp membership
	*/
	@Override
	public java.util.Date getRenewalDate() {
		return _empMembership.getRenewalDate();
	}

	/**
	* Sets the renewal date of this emp membership.
	*
	* @param renewalDate the renewal date of this emp membership
	*/
	@Override
	public void setRenewalDate(java.util.Date renewalDate) {
		_empMembership.setRenewalDate(renewalDate);
	}

	@Override
	public boolean isNew() {
		return _empMembership.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empMembership.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empMembership.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empMembership.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empMembership.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empMembership.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empMembership.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empMembership.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empMembership.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empMembership.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empMembership.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpMembershipWrapper((EmpMembership)_empMembership.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpMembership empMembership) {
		return _empMembership.compareTo(empMembership);
	}

	@Override
	public int hashCode() {
		return _empMembership.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpMembership> toCacheModel() {
		return _empMembership.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpMembership toEscapedModel() {
		return new EmpMembershipWrapper(_empMembership.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpMembership toUnescapedModel() {
		return new EmpMembershipWrapper(_empMembership.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empMembership.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empMembership.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empMembership.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpMembershipWrapper)) {
			return false;
		}

		EmpMembershipWrapper empMembershipWrapper = (EmpMembershipWrapper)obj;

		if (Validator.equals(_empMembership, empMembershipWrapper._empMembership)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpMembership getWrappedEmpMembership() {
		return _empMembership;
	}

	@Override
	public EmpMembership getWrappedModel() {
		return _empMembership;
	}

	@Override
	public void resetOriginalValues() {
		_empMembership.resetOriginalValues();
	}

	private EmpMembership _empMembership;
}