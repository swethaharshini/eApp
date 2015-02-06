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
 * This class is a wrapper for {@link LeaveGeneral}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveGeneral
 * @generated
 */
public class LeaveGeneralWrapper implements LeaveGeneral,
	ModelWrapper<LeaveGeneral> {
	public LeaveGeneralWrapper(LeaveGeneral leaveGeneral) {
		_leaveGeneral = leaveGeneral;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveGeneral.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveGeneral.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveGeneralId", getLeaveGeneralId());
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
		attributes.put("showProjectBalance", getShowProjectBalance());
		attributes.put("enableAttachment", getEnableAttachment());
		attributes.put("isAttachmentMandatory", getIsAttachmentMandatory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveGeneralId = (Long)attributes.get("leaveGeneralId");

		if (leaveGeneralId != null) {
			setLeaveGeneralId(leaveGeneralId);
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

		Boolean showProjectBalance = (Boolean)attributes.get(
				"showProjectBalance");

		if (showProjectBalance != null) {
			setShowProjectBalance(showProjectBalance);
		}

		Boolean enableAttachment = (Boolean)attributes.get("enableAttachment");

		if (enableAttachment != null) {
			setEnableAttachment(enableAttachment);
		}

		Boolean isAttachmentMandatory = (Boolean)attributes.get(
				"isAttachmentMandatory");

		if (isAttachmentMandatory != null) {
			setIsAttachmentMandatory(isAttachmentMandatory);
		}
	}

	/**
	* Returns the primary key of this leave general.
	*
	* @return the primary key of this leave general
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveGeneral.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave general.
	*
	* @param primaryKey the primary key of this leave general
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveGeneral.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave general ID of this leave general.
	*
	* @return the leave general ID of this leave general
	*/
	@Override
	public long getLeaveGeneralId() {
		return _leaveGeneral.getLeaveGeneralId();
	}

	/**
	* Sets the leave general ID of this leave general.
	*
	* @param leaveGeneralId the leave general ID of this leave general
	*/
	@Override
	public void setLeaveGeneralId(long leaveGeneralId) {
		_leaveGeneral.setLeaveGeneralId(leaveGeneralId);
	}

	/**
	* Returns the company ID of this leave general.
	*
	* @return the company ID of this leave general
	*/
	@Override
	public long getCompanyId() {
		return _leaveGeneral.getCompanyId();
	}

	/**
	* Sets the company ID of this leave general.
	*
	* @param companyId the company ID of this leave general
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveGeneral.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave general.
	*
	* @return the group ID of this leave general
	*/
	@Override
	public long getGroupId() {
		return _leaveGeneral.getGroupId();
	}

	/**
	* Sets the group ID of this leave general.
	*
	* @param groupId the group ID of this leave general
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveGeneral.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave general.
	*
	* @return the create date of this leave general
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveGeneral.getCreateDate();
	}

	/**
	* Sets the create date of this leave general.
	*
	* @param createDate the create date of this leave general
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveGeneral.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave general.
	*
	* @return the modified date of this leave general
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveGeneral.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave general.
	*
	* @param modifiedDate the modified date of this leave general
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveGeneral.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave general.
	*
	* @return the user ID of this leave general
	*/
	@Override
	public long getUserId() {
		return _leaveGeneral.getUserId();
	}

	/**
	* Sets the user ID of this leave general.
	*
	* @param userId the user ID of this leave general
	*/
	@Override
	public void setUserId(long userId) {
		_leaveGeneral.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave general.
	*
	* @return the user uuid of this leave general
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveGeneral.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave general.
	*
	* @param userUuid the user uuid of this leave general
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveGeneral.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave general.
	*
	* @return the leave type ID of this leave general
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveGeneral.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave general.
	*
	* @param leaveTypeId the leave type ID of this leave general
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveGeneral.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the leave period type ID of this leave general.
	*
	* @return the leave period type ID of this leave general
	*/
	@Override
	public int getLeavePeriodTypeId() {
		return _leaveGeneral.getLeavePeriodTypeId();
	}

	/**
	* Sets the leave period type ID of this leave general.
	*
	* @param leavePeriodTypeId the leave period type ID of this leave general
	*/
	@Override
	public void setLeavePeriodTypeId(int leavePeriodTypeId) {
		_leaveGeneral.setLeavePeriodTypeId(leavePeriodTypeId);
	}

	/**
	* Returns the start month of this leave general.
	*
	* @return the start month of this leave general
	*/
	@Override
	public int getStartMonth() {
		return _leaveGeneral.getStartMonth();
	}

	/**
	* Sets the start month of this leave general.
	*
	* @param startMonth the start month of this leave general
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_leaveGeneral.setStartMonth(startMonth);
	}

	/**
	* Returns the start day of month of this leave general.
	*
	* @return the start day of month of this leave general
	*/
	@Override
	public int getStartDayOfMonth() {
		return _leaveGeneral.getStartDayOfMonth();
	}

	/**
	* Sets the start day of month of this leave general.
	*
	* @param startDayOfMonth the start day of month of this leave general
	*/
	@Override
	public void setStartDayOfMonth(int startDayOfMonth) {
		_leaveGeneral.setStartDayOfMonth(startDayOfMonth);
	}

	/**
	* Returns the duration of this leave general.
	*
	* @return the duration of this leave general
	*/
	@Override
	public java.lang.String getDuration() {
		return _leaveGeneral.getDuration();
	}

	/**
	* Sets the duration of this leave general.
	*
	* @param duration the duration of this leave general
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_leaveGeneral.setDuration(duration);
	}

	/**
	* Returns the if employees can apply of this leave general.
	*
	* @return the if employees can apply of this leave general
	*/
	@Override
	public boolean getIfEmployeesCanApply() {
		return _leaveGeneral.getIfEmployeesCanApply();
	}

	/**
	* Returns <code>true</code> if this leave general is if employees can apply.
	*
	* @return <code>true</code> if this leave general is if employees can apply; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfEmployeesCanApply() {
		return _leaveGeneral.isIfEmployeesCanApply();
	}

	/**
	* Sets whether this leave general is if employees can apply.
	*
	* @param ifEmployeesCanApply the if employees can apply of this leave general
	*/
	@Override
	public void setIfEmployeesCanApply(boolean ifEmployeesCanApply) {
		_leaveGeneral.setIfEmployeesCanApply(ifEmployeesCanApply);
	}

	/**
	* Returns the if admin can assign of this leave general.
	*
	* @return the if admin can assign of this leave general
	*/
	@Override
	public boolean getIfAdminCanAssign() {
		return _leaveGeneral.getIfAdminCanAssign();
	}

	/**
	* Returns <code>true</code> if this leave general is if admin can assign.
	*
	* @return <code>true</code> if this leave general is if admin can assign; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfAdminCanAssign() {
		return _leaveGeneral.isIfAdminCanAssign();
	}

	/**
	* Sets whether this leave general is if admin can assign.
	*
	* @param ifAdminCanAssign the if admin can assign of this leave general
	*/
	@Override
	public void setIfAdminCanAssign(boolean ifAdminCanAssign) {
		_leaveGeneral.setIfAdminCanAssign(ifAdminCanAssign);
	}

	/**
	* Returns the if admin can manage entitlements of this leave general.
	*
	* @return the if admin can manage entitlements of this leave general
	*/
	@Override
	public boolean getIfAdminCanManageEntitlements() {
		return _leaveGeneral.getIfAdminCanManageEntitlements();
	}

	/**
	* Returns <code>true</code> if this leave general is if admin can manage entitlements.
	*
	* @return <code>true</code> if this leave general is if admin can manage entitlements; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfAdminCanManageEntitlements() {
		return _leaveGeneral.isIfAdminCanManageEntitlements();
	}

	/**
	* Sets whether this leave general is if admin can manage entitlements.
	*
	* @param ifAdminCanManageEntitlements the if admin can manage entitlements of this leave general
	*/
	@Override
	public void setIfAdminCanManageEntitlements(
		boolean ifAdminCanManageEntitlements) {
		_leaveGeneral.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
	}

	/**
	* Returns the if leave accruable of this leave general.
	*
	* @return the if leave accruable of this leave general
	*/
	@Override
	public boolean getIfLeaveAccruable() {
		return _leaveGeneral.getIfLeaveAccruable();
	}

	/**
	* Returns <code>true</code> if this leave general is if leave accruable.
	*
	* @return <code>true</code> if this leave general is if leave accruable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfLeaveAccruable() {
		return _leaveGeneral.isIfLeaveAccruable();
	}

	/**
	* Sets whether this leave general is if leave accruable.
	*
	* @param ifLeaveAccruable the if leave accruable of this leave general
	*/
	@Override
	public void setIfLeaveAccruable(boolean ifLeaveAccruable) {
		_leaveGeneral.setIfLeaveAccruable(ifLeaveAccruable);
	}

	/**
	* Returns the if carry forwardable of this leave general.
	*
	* @return the if carry forwardable of this leave general
	*/
	@Override
	public boolean getIfCarryForwardable() {
		return _leaveGeneral.getIfCarryForwardable();
	}

	/**
	* Returns <code>true</code> if this leave general is if carry forwardable.
	*
	* @return <code>true</code> if this leave general is if carry forwardable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfCarryForwardable() {
		return _leaveGeneral.isIfCarryForwardable();
	}

	/**
	* Sets whether this leave general is if carry forwardable.
	*
	* @param ifCarryForwardable the if carry forwardable of this leave general
	*/
	@Override
	public void setIfCarryForwardable(boolean ifCarryForwardable) {
		_leaveGeneral.setIfCarryForwardable(ifCarryForwardable);
	}

	/**
	* Returns the show project balance of this leave general.
	*
	* @return the show project balance of this leave general
	*/
	@Override
	public boolean getShowProjectBalance() {
		return _leaveGeneral.getShowProjectBalance();
	}

	/**
	* Returns <code>true</code> if this leave general is show project balance.
	*
	* @return <code>true</code> if this leave general is show project balance; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowProjectBalance() {
		return _leaveGeneral.isShowProjectBalance();
	}

	/**
	* Sets whether this leave general is show project balance.
	*
	* @param showProjectBalance the show project balance of this leave general
	*/
	@Override
	public void setShowProjectBalance(boolean showProjectBalance) {
		_leaveGeneral.setShowProjectBalance(showProjectBalance);
	}

	/**
	* Returns the enable attachment of this leave general.
	*
	* @return the enable attachment of this leave general
	*/
	@Override
	public boolean getEnableAttachment() {
		return _leaveGeneral.getEnableAttachment();
	}

	/**
	* Returns <code>true</code> if this leave general is enable attachment.
	*
	* @return <code>true</code> if this leave general is enable attachment; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableAttachment() {
		return _leaveGeneral.isEnableAttachment();
	}

	/**
	* Sets whether this leave general is enable attachment.
	*
	* @param enableAttachment the enable attachment of this leave general
	*/
	@Override
	public void setEnableAttachment(boolean enableAttachment) {
		_leaveGeneral.setEnableAttachment(enableAttachment);
	}

	/**
	* Returns the is attachment mandatory of this leave general.
	*
	* @return the is attachment mandatory of this leave general
	*/
	@Override
	public boolean getIsAttachmentMandatory() {
		return _leaveGeneral.getIsAttachmentMandatory();
	}

	/**
	* Returns <code>true</code> if this leave general is is attachment mandatory.
	*
	* @return <code>true</code> if this leave general is is attachment mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsAttachmentMandatory() {
		return _leaveGeneral.isIsAttachmentMandatory();
	}

	/**
	* Sets whether this leave general is is attachment mandatory.
	*
	* @param isAttachmentMandatory the is attachment mandatory of this leave general
	*/
	@Override
	public void setIsAttachmentMandatory(boolean isAttachmentMandatory) {
		_leaveGeneral.setIsAttachmentMandatory(isAttachmentMandatory);
	}

	@Override
	public boolean isNew() {
		return _leaveGeneral.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveGeneral.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveGeneral.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveGeneral.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveGeneral.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveGeneral.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveGeneral.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveGeneral.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveGeneral.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveGeneral.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveGeneral.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveGeneralWrapper((LeaveGeneral)_leaveGeneral.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.LeaveGeneral leaveGeneral) {
		return _leaveGeneral.compareTo(leaveGeneral);
	}

	@Override
	public int hashCode() {
		return _leaveGeneral.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveGeneral> toCacheModel() {
		return _leaveGeneral.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveGeneral toEscapedModel() {
		return new LeaveGeneralWrapper(_leaveGeneral.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveGeneral toUnescapedModel() {
		return new LeaveGeneralWrapper(_leaveGeneral.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveGeneral.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveGeneral.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveGeneral.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveGeneralWrapper)) {
			return false;
		}

		LeaveGeneralWrapper leaveGeneralWrapper = (LeaveGeneralWrapper)obj;

		if (Validator.equals(_leaveGeneral, leaveGeneralWrapper._leaveGeneral)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveGeneral getWrappedLeaveGeneral() {
		return _leaveGeneral;
	}

	@Override
	public LeaveGeneral getWrappedModel() {
		return _leaveGeneral;
	}

	@Override
	public void resetOriginalValues() {
		_leaveGeneral.resetOriginalValues();
	}

	private LeaveGeneral _leaveGeneral;
}