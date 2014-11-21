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
 * This class is a wrapper for {@link LeaveRule}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveRule
 * @generated
 */
public class LeaveRuleWrapper implements LeaveRule, ModelWrapper<LeaveRule> {
	public LeaveRuleWrapper(LeaveRule leaveRule) {
		_leaveRule = leaveRule;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRule.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveRuleId", getLeaveRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("leavePeriodTypeId", getLeavePeriodTypeId());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startDayOfMonth", getStartDayOfMonth());
		attributes.put("duration", getDuration());
		attributes.put("ifEmployeesCanApply", getIfEmployeesCanApply());
		attributes.put("ifAdminCanAssign", getIfAdminCanAssign());
		attributes.put("ifAdminCanManageEntitlements",
			getIfAdminCanManageEntitlements());
		attributes.put("ifLeaveAccruable", getIfLeaveAccruable());
		attributes.put("ifCarryForwardable", getIfCarryForwardable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveRuleId = (Long)attributes.get("leaveRuleId");

		if (leaveRuleId != null) {
			setLeaveRuleId(leaveRuleId);
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

		Integer leavePeriodTypeId = (Integer)attributes.get("leavePeriodTypeId");

		if (leavePeriodTypeId != null) {
			setLeavePeriodTypeId(leavePeriodTypeId);
		}

		Integer startMonth = (Integer)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		Integer startDayOfMonth = (Integer)attributes.get("startDayOfMonth");

		if (startDayOfMonth != null) {
			setStartDayOfMonth(startDayOfMonth);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Boolean ifEmployeesCanApply = (Boolean)attributes.get(
				"ifEmployeesCanApply");

		if (ifEmployeesCanApply != null) {
			setIfEmployeesCanApply(ifEmployeesCanApply);
		}

		Boolean ifAdminCanAssign = (Boolean)attributes.get("ifAdminCanAssign");

		if (ifAdminCanAssign != null) {
			setIfAdminCanAssign(ifAdminCanAssign);
		}

		Boolean ifAdminCanManageEntitlements = (Boolean)attributes.get(
				"ifAdminCanManageEntitlements");

		if (ifAdminCanManageEntitlements != null) {
			setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
		}

		Boolean ifLeaveAccruable = (Boolean)attributes.get("ifLeaveAccruable");

		if (ifLeaveAccruable != null) {
			setIfLeaveAccruable(ifLeaveAccruable);
		}

		Boolean ifCarryForwardable = (Boolean)attributes.get(
				"ifCarryForwardable");

		if (ifCarryForwardable != null) {
			setIfCarryForwardable(ifCarryForwardable);
		}
	}

	/**
	* Returns the primary key of this leave rule.
	*
	* @return the primary key of this leave rule
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveRule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave rule.
	*
	* @param primaryKey the primary key of this leave rule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveRule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave rule ID of this leave rule.
	*
	* @return the leave rule ID of this leave rule
	*/
	@Override
	public long getLeaveRuleId() {
		return _leaveRule.getLeaveRuleId();
	}

	/**
	* Sets the leave rule ID of this leave rule.
	*
	* @param leaveRuleId the leave rule ID of this leave rule
	*/
	@Override
	public void setLeaveRuleId(long leaveRuleId) {
		_leaveRule.setLeaveRuleId(leaveRuleId);
	}

	/**
	* Returns the company ID of this leave rule.
	*
	* @return the company ID of this leave rule
	*/
	@Override
	public long getCompanyId() {
		return _leaveRule.getCompanyId();
	}

	/**
	* Sets the company ID of this leave rule.
	*
	* @param companyId the company ID of this leave rule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveRule.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave rule.
	*
	* @return the group ID of this leave rule
	*/
	@Override
	public long getGroupId() {
		return _leaveRule.getGroupId();
	}

	/**
	* Sets the group ID of this leave rule.
	*
	* @param groupId the group ID of this leave rule
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveRule.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave rule.
	*
	* @return the create date of this leave rule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveRule.getCreateDate();
	}

	/**
	* Sets the create date of this leave rule.
	*
	* @param createDate the create date of this leave rule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveRule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave rule.
	*
	* @return the modified date of this leave rule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveRule.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave rule.
	*
	* @param modifiedDate the modified date of this leave rule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveRule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave rule.
	*
	* @return the user ID of this leave rule
	*/
	@Override
	public long getUserId() {
		return _leaveRule.getUserId();
	}

	/**
	* Sets the user ID of this leave rule.
	*
	* @param userId the user ID of this leave rule
	*/
	@Override
	public void setUserId(long userId) {
		_leaveRule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave rule.
	*
	* @return the user uuid of this leave rule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRule.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave rule.
	*
	* @param userUuid the user uuid of this leave rule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveRule.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave rule.
	*
	* @return the leave type ID of this leave rule
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveRule.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave rule.
	*
	* @param leaveTypeId the leave type ID of this leave rule
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveRule.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the leave period type ID of this leave rule.
	*
	* @return the leave period type ID of this leave rule
	*/
	@Override
	public int getLeavePeriodTypeId() {
		return _leaveRule.getLeavePeriodTypeId();
	}

	/**
	* Sets the leave period type ID of this leave rule.
	*
	* @param leavePeriodTypeId the leave period type ID of this leave rule
	*/
	@Override
	public void setLeavePeriodTypeId(int leavePeriodTypeId) {
		_leaveRule.setLeavePeriodTypeId(leavePeriodTypeId);
	}

	/**
	* Returns the start month of this leave rule.
	*
	* @return the start month of this leave rule
	*/
	@Override
	public int getStartMonth() {
		return _leaveRule.getStartMonth();
	}

	/**
	* Sets the start month of this leave rule.
	*
	* @param startMonth the start month of this leave rule
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_leaveRule.setStartMonth(startMonth);
	}

	/**
	* Returns the start day of month of this leave rule.
	*
	* @return the start day of month of this leave rule
	*/
	@Override
	public int getStartDayOfMonth() {
		return _leaveRule.getStartDayOfMonth();
	}

	/**
	* Sets the start day of month of this leave rule.
	*
	* @param startDayOfMonth the start day of month of this leave rule
	*/
	@Override
	public void setStartDayOfMonth(int startDayOfMonth) {
		_leaveRule.setStartDayOfMonth(startDayOfMonth);
	}

	/**
	* Returns the duration of this leave rule.
	*
	* @return the duration of this leave rule
	*/
	@Override
	public java.lang.String getDuration() {
		return _leaveRule.getDuration();
	}

	/**
	* Sets the duration of this leave rule.
	*
	* @param duration the duration of this leave rule
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_leaveRule.setDuration(duration);
	}

	/**
	* Returns the if employees can apply of this leave rule.
	*
	* @return the if employees can apply of this leave rule
	*/
	@Override
	public boolean getIfEmployeesCanApply() {
		return _leaveRule.getIfEmployeesCanApply();
	}

	/**
	* Returns <code>true</code> if this leave rule is if employees can apply.
	*
	* @return <code>true</code> if this leave rule is if employees can apply; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfEmployeesCanApply() {
		return _leaveRule.isIfEmployeesCanApply();
	}

	/**
	* Sets whether this leave rule is if employees can apply.
	*
	* @param ifEmployeesCanApply the if employees can apply of this leave rule
	*/
	@Override
	public void setIfEmployeesCanApply(boolean ifEmployeesCanApply) {
		_leaveRule.setIfEmployeesCanApply(ifEmployeesCanApply);
	}

	/**
	* Returns the if admin can assign of this leave rule.
	*
	* @return the if admin can assign of this leave rule
	*/
	@Override
	public boolean getIfAdminCanAssign() {
		return _leaveRule.getIfAdminCanAssign();
	}

	/**
	* Returns <code>true</code> if this leave rule is if admin can assign.
	*
	* @return <code>true</code> if this leave rule is if admin can assign; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfAdminCanAssign() {
		return _leaveRule.isIfAdminCanAssign();
	}

	/**
	* Sets whether this leave rule is if admin can assign.
	*
	* @param ifAdminCanAssign the if admin can assign of this leave rule
	*/
	@Override
	public void setIfAdminCanAssign(boolean ifAdminCanAssign) {
		_leaveRule.setIfAdminCanAssign(ifAdminCanAssign);
	}

	/**
	* Returns the if admin can manage entitlements of this leave rule.
	*
	* @return the if admin can manage entitlements of this leave rule
	*/
	@Override
	public boolean getIfAdminCanManageEntitlements() {
		return _leaveRule.getIfAdminCanManageEntitlements();
	}

	/**
	* Returns <code>true</code> if this leave rule is if admin can manage entitlements.
	*
	* @return <code>true</code> if this leave rule is if admin can manage entitlements; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfAdminCanManageEntitlements() {
		return _leaveRule.isIfAdminCanManageEntitlements();
	}

	/**
	* Sets whether this leave rule is if admin can manage entitlements.
	*
	* @param ifAdminCanManageEntitlements the if admin can manage entitlements of this leave rule
	*/
	@Override
	public void setIfAdminCanManageEntitlements(
		boolean ifAdminCanManageEntitlements) {
		_leaveRule.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
	}

	/**
	* Returns the if leave accruable of this leave rule.
	*
	* @return the if leave accruable of this leave rule
	*/
	@Override
	public boolean getIfLeaveAccruable() {
		return _leaveRule.getIfLeaveAccruable();
	}

	/**
	* Returns <code>true</code> if this leave rule is if leave accruable.
	*
	* @return <code>true</code> if this leave rule is if leave accruable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfLeaveAccruable() {
		return _leaveRule.isIfLeaveAccruable();
	}

	/**
	* Sets whether this leave rule is if leave accruable.
	*
	* @param ifLeaveAccruable the if leave accruable of this leave rule
	*/
	@Override
	public void setIfLeaveAccruable(boolean ifLeaveAccruable) {
		_leaveRule.setIfLeaveAccruable(ifLeaveAccruable);
	}

	/**
	* Returns the if carry forwardable of this leave rule.
	*
	* @return the if carry forwardable of this leave rule
	*/
	@Override
	public boolean getIfCarryForwardable() {
		return _leaveRule.getIfCarryForwardable();
	}

	/**
	* Returns <code>true</code> if this leave rule is if carry forwardable.
	*
	* @return <code>true</code> if this leave rule is if carry forwardable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfCarryForwardable() {
		return _leaveRule.isIfCarryForwardable();
	}

	/**
	* Sets whether this leave rule is if carry forwardable.
	*
	* @param ifCarryForwardable the if carry forwardable of this leave rule
	*/
	@Override
	public void setIfCarryForwardable(boolean ifCarryForwardable) {
		_leaveRule.setIfCarryForwardable(ifCarryForwardable);
	}

	@Override
	public boolean isNew() {
		return _leaveRule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveRule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveRule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveRule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveRule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveRule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveRule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveRule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveRule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveRule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveRule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveRuleWrapper((LeaveRule)_leaveRule.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.LeaveRule leaveRule) {
		return _leaveRule.compareTo(leaveRule);
	}

	@Override
	public int hashCode() {
		return _leaveRule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveRule> toCacheModel() {
		return _leaveRule.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRule toEscapedModel() {
		return new LeaveRuleWrapper(_leaveRule.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRule toUnescapedModel() {
		return new LeaveRuleWrapper(_leaveRule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveRule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveRule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRuleWrapper)) {
			return false;
		}

		LeaveRuleWrapper leaveRuleWrapper = (LeaveRuleWrapper)obj;

		if (Validator.equals(_leaveRule, leaveRuleWrapper._leaveRule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveRule getWrappedLeaveRule() {
		return _leaveRule;
	}

	@Override
	public LeaveRule getWrappedModel() {
		return _leaveRule;
	}

	@Override
	public void resetOriginalValues() {
		_leaveRule.resetOriginalValues();
	}

	private LeaveRule _leaveRule;
}