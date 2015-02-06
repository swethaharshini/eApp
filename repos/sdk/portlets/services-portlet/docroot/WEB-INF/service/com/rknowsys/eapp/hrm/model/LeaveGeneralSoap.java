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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class LeaveGeneralSoap implements Serializable {
	public static LeaveGeneralSoap toSoapModel(LeaveGeneral model) {
		LeaveGeneralSoap soapModel = new LeaveGeneralSoap();

		soapModel.setLeaveGeneralId(model.getLeaveGeneralId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setLeavePeriodTypeId(model.getLeavePeriodTypeId());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setStartDayOfMonth(model.getStartDayOfMonth());
		soapModel.setDuration(model.getDuration());
		soapModel.setIfEmployeesCanApply(model.getIfEmployeesCanApply());
		soapModel.setIfAdminCanAssign(model.getIfAdminCanAssign());
		soapModel.setIfAdminCanManageEntitlements(model.getIfAdminCanManageEntitlements());
		soapModel.setIfLeaveAccruable(model.getIfLeaveAccruable());
		soapModel.setIfCarryForwardable(model.getIfCarryForwardable());
		soapModel.setShowProjectBalance(model.getShowProjectBalance());
		soapModel.setEnableAttachment(model.getEnableAttachment());
		soapModel.setIsAttachmentMandatory(model.getIsAttachmentMandatory());

		return soapModel;
	}

	public static LeaveGeneralSoap[] toSoapModels(LeaveGeneral[] models) {
		LeaveGeneralSoap[] soapModels = new LeaveGeneralSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveGeneralSoap[][] toSoapModels(LeaveGeneral[][] models) {
		LeaveGeneralSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveGeneralSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveGeneralSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveGeneralSoap[] toSoapModels(List<LeaveGeneral> models) {
		List<LeaveGeneralSoap> soapModels = new ArrayList<LeaveGeneralSoap>(models.size());

		for (LeaveGeneral model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveGeneralSoap[soapModels.size()]);
	}

	public LeaveGeneralSoap() {
	}

	public long getPrimaryKey() {
		return _leaveGeneralId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveGeneralId(pk);
	}

	public long getLeaveGeneralId() {
		return _leaveGeneralId;
	}

	public void setLeaveGeneralId(long leaveGeneralId) {
		_leaveGeneralId = leaveGeneralId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public int getLeavePeriodTypeId() {
		return _leavePeriodTypeId;
	}

	public void setLeavePeriodTypeId(int leavePeriodTypeId) {
		_leavePeriodTypeId = leavePeriodTypeId;
	}

	public int getStartMonth() {
		return _startMonth;
	}

	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;
	}

	public int getStartDayOfMonth() {
		return _startDayOfMonth;
	}

	public void setStartDayOfMonth(int startDayOfMonth) {
		_startDayOfMonth = startDayOfMonth;
	}

	public String getDuration() {
		return _duration;
	}

	public void setDuration(String duration) {
		_duration = duration;
	}

	public boolean getIfEmployeesCanApply() {
		return _ifEmployeesCanApply;
	}

	public boolean isIfEmployeesCanApply() {
		return _ifEmployeesCanApply;
	}

	public void setIfEmployeesCanApply(boolean ifEmployeesCanApply) {
		_ifEmployeesCanApply = ifEmployeesCanApply;
	}

	public boolean getIfAdminCanAssign() {
		return _ifAdminCanAssign;
	}

	public boolean isIfAdminCanAssign() {
		return _ifAdminCanAssign;
	}

	public void setIfAdminCanAssign(boolean ifAdminCanAssign) {
		_ifAdminCanAssign = ifAdminCanAssign;
	}

	public boolean getIfAdminCanManageEntitlements() {
		return _ifAdminCanManageEntitlements;
	}

	public boolean isIfAdminCanManageEntitlements() {
		return _ifAdminCanManageEntitlements;
	}

	public void setIfAdminCanManageEntitlements(
		boolean ifAdminCanManageEntitlements) {
		_ifAdminCanManageEntitlements = ifAdminCanManageEntitlements;
	}

	public boolean getIfLeaveAccruable() {
		return _ifLeaveAccruable;
	}

	public boolean isIfLeaveAccruable() {
		return _ifLeaveAccruable;
	}

	public void setIfLeaveAccruable(boolean ifLeaveAccruable) {
		_ifLeaveAccruable = ifLeaveAccruable;
	}

	public boolean getIfCarryForwardable() {
		return _ifCarryForwardable;
	}

	public boolean isIfCarryForwardable() {
		return _ifCarryForwardable;
	}

	public void setIfCarryForwardable(boolean ifCarryForwardable) {
		_ifCarryForwardable = ifCarryForwardable;
	}

	public boolean getShowProjectBalance() {
		return _showProjectBalance;
	}

	public boolean isShowProjectBalance() {
		return _showProjectBalance;
	}

	public void setShowProjectBalance(boolean showProjectBalance) {
		_showProjectBalance = showProjectBalance;
	}

	public boolean getEnableAttachment() {
		return _enableAttachment;
	}

	public boolean isEnableAttachment() {
		return _enableAttachment;
	}

	public void setEnableAttachment(boolean enableAttachment) {
		_enableAttachment = enableAttachment;
	}

	public boolean getIsAttachmentMandatory() {
		return _isAttachmentMandatory;
	}

	public boolean isIsAttachmentMandatory() {
		return _isAttachmentMandatory;
	}

	public void setIsAttachmentMandatory(boolean isAttachmentMandatory) {
		_isAttachmentMandatory = isAttachmentMandatory;
	}

	private long _leaveGeneralId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private int _leavePeriodTypeId;
	private int _startMonth;
	private int _startDayOfMonth;
	private String _duration;
	private boolean _ifEmployeesCanApply;
	private boolean _ifAdminCanAssign;
	private boolean _ifAdminCanManageEntitlements;
	private boolean _ifLeaveAccruable;
	private boolean _ifCarryForwardable;
	private boolean _showProjectBalance;
	private boolean _enableAttachment;
	private boolean _isAttachmentMandatory;
}