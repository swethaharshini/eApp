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
public class LeaveRuleSoap implements Serializable {
	public static LeaveRuleSoap toSoapModel(LeaveRule model) {
		LeaveRuleSoap soapModel = new LeaveRuleSoap();

		soapModel.setLeaveRuleId(model.getLeaveRuleId());
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

		return soapModel;
	}

	public static LeaveRuleSoap[] toSoapModels(LeaveRule[] models) {
		LeaveRuleSoap[] soapModels = new LeaveRuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveRuleSoap[][] toSoapModels(LeaveRule[][] models) {
		LeaveRuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveRuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveRuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveRuleSoap[] toSoapModels(List<LeaveRule> models) {
		List<LeaveRuleSoap> soapModels = new ArrayList<LeaveRuleSoap>(models.size());

		for (LeaveRule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveRuleSoap[soapModels.size()]);
	}

	public LeaveRuleSoap() {
	}

	public long getPrimaryKey() {
		return _leaveRuleId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveRuleId(pk);
	}

	public long getLeaveRuleId() {
		return _leaveRuleId;
	}

	public void setLeaveRuleId(long leaveRuleId) {
		_leaveRuleId = leaveRuleId;
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

	private long _leaveRuleId;
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
}