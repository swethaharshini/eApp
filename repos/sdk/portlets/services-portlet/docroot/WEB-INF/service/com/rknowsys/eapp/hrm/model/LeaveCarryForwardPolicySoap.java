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
public class LeaveCarryForwardPolicySoap implements Serializable {
	public static LeaveCarryForwardPolicySoap toSoapModel(
		LeaveCarryForwardPolicy model) {
		LeaveCarryForwardPolicySoap soapModel = new LeaveCarryForwardPolicySoap();

		soapModel.setLeaveCarryForwardPolicyId(model.getLeaveCarryForwardPolicyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setExpiryDuration(model.getExpiryDuration());
		soapModel.setExpiryDurationUOM(model.getExpiryDurationUOM());
		soapModel.setIsMaxCarryForwardLimitApplicable(model.getIsMaxCarryForwardLimitApplicable());
		soapModel.setMaxCarryForwardLimit(model.getMaxCarryForwardLimit());

		return soapModel;
	}

	public static LeaveCarryForwardPolicySoap[] toSoapModels(
		LeaveCarryForwardPolicy[] models) {
		LeaveCarryForwardPolicySoap[] soapModels = new LeaveCarryForwardPolicySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveCarryForwardPolicySoap[][] toSoapModels(
		LeaveCarryForwardPolicy[][] models) {
		LeaveCarryForwardPolicySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveCarryForwardPolicySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveCarryForwardPolicySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveCarryForwardPolicySoap[] toSoapModels(
		List<LeaveCarryForwardPolicy> models) {
		List<LeaveCarryForwardPolicySoap> soapModels = new ArrayList<LeaveCarryForwardPolicySoap>(models.size());

		for (LeaveCarryForwardPolicy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveCarryForwardPolicySoap[soapModels.size()]);
	}

	public LeaveCarryForwardPolicySoap() {
	}

	public long getPrimaryKey() {
		return _leaveCarryForwardPolicyId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveCarryForwardPolicyId(pk);
	}

	public long getLeaveCarryForwardPolicyId() {
		return _leaveCarryForwardPolicyId;
	}

	public void setLeaveCarryForwardPolicyId(long leaveCarryForwardPolicyId) {
		_leaveCarryForwardPolicyId = leaveCarryForwardPolicyId;
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

	public int getExpiryDuration() {
		return _expiryDuration;
	}

	public void setExpiryDuration(int expiryDuration) {
		_expiryDuration = expiryDuration;
	}

	public String getExpiryDurationUOM() {
		return _expiryDurationUOM;
	}

	public void setExpiryDurationUOM(String expiryDurationUOM) {
		_expiryDurationUOM = expiryDurationUOM;
	}

	public boolean getIsMaxCarryForwardLimitApplicable() {
		return _isMaxCarryForwardLimitApplicable;
	}

	public boolean isIsMaxCarryForwardLimitApplicable() {
		return _isMaxCarryForwardLimitApplicable;
	}

	public void setIsMaxCarryForwardLimitApplicable(
		boolean isMaxCarryForwardLimitApplicable) {
		_isMaxCarryForwardLimitApplicable = isMaxCarryForwardLimitApplicable;
	}

	public String getMaxCarryForwardLimit() {
		return _maxCarryForwardLimit;
	}

	public void setMaxCarryForwardLimit(String maxCarryForwardLimit) {
		_maxCarryForwardLimit = maxCarryForwardLimit;
	}

	private long _leaveCarryForwardPolicyId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private int _expiryDuration;
	private String _expiryDurationUOM;
	private boolean _isMaxCarryForwardLimitApplicable;
	private String _maxCarryForwardLimit;
}