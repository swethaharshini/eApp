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
public class LeaveTypeSoap implements Serializable {
	public static LeaveTypeSoap toSoapModel(LeaveType model) {
		LeaveTypeSoap soapModel = new LeaveTypeSoap();

		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setNationalityId(model.getNationalityId());
		soapModel.setLeaveTypeName(model.getLeaveTypeName());
		soapModel.setIsSituational(model.getIsSituational());

		return soapModel;
	}

	public static LeaveTypeSoap[] toSoapModels(LeaveType[] models) {
		LeaveTypeSoap[] soapModels = new LeaveTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeSoap[][] toSoapModels(LeaveType[][] models) {
		LeaveTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeSoap[] toSoapModels(List<LeaveType> models) {
		List<LeaveTypeSoap> soapModels = new ArrayList<LeaveTypeSoap>(models.size());

		for (LeaveType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveTypeSoap[soapModels.size()]);
	}

	public LeaveTypeSoap() {
	}

	public long getPrimaryKey() {
		return _leaveTypeId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveTypeId(pk);
	}

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
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

	public long getNationalityId() {
		return _nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	public String getLeaveTypeName() {
		return _leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		_leaveTypeName = leaveTypeName;
	}

	public boolean getIsSituational() {
		return _isSituational;
	}

	public boolean isIsSituational() {
		return _isSituational;
	}

	public void setIsSituational(boolean isSituational) {
		_isSituational = isSituational;
	}

	private long _leaveTypeId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _nationalityId;
	private String _leaveTypeName;
	private boolean _isSituational;
}