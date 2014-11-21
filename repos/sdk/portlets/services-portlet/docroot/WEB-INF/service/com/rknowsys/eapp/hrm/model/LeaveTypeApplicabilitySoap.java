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
public class LeaveTypeApplicabilitySoap implements Serializable {
	public static LeaveTypeApplicabilitySoap toSoapModel(
		LeaveTypeApplicability model) {
		LeaveTypeApplicabilitySoap soapModel = new LeaveTypeApplicabilitySoap();

		soapModel.setLeaveTypeApplicabilityId(model.getLeaveTypeApplicabilityId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setIfYearsOfServiceCriterionApplicable(model.getIfYearsOfServiceCriterionApplicable());
		soapModel.setMinYearsOfService(model.getMinYearsOfService());
		soapModel.setMaxYearsOfService(model.getMaxYearsOfService());

		return soapModel;
	}

	public static LeaveTypeApplicabilitySoap[] toSoapModels(
		LeaveTypeApplicability[] models) {
		LeaveTypeApplicabilitySoap[] soapModels = new LeaveTypeApplicabilitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeApplicabilitySoap[][] toSoapModels(
		LeaveTypeApplicability[][] models) {
		LeaveTypeApplicabilitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveTypeApplicabilitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveTypeApplicabilitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeApplicabilitySoap[] toSoapModels(
		List<LeaveTypeApplicability> models) {
		List<LeaveTypeApplicabilitySoap> soapModels = new ArrayList<LeaveTypeApplicabilitySoap>(models.size());

		for (LeaveTypeApplicability model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveTypeApplicabilitySoap[soapModels.size()]);
	}

	public LeaveTypeApplicabilitySoap() {
	}

	public long getPrimaryKey() {
		return _leaveTypeApplicabilityId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveTypeApplicabilityId(pk);
	}

	public long getLeaveTypeApplicabilityId() {
		return _leaveTypeApplicabilityId;
	}

	public void setLeaveTypeApplicabilityId(long leaveTypeApplicabilityId) {
		_leaveTypeApplicabilityId = leaveTypeApplicabilityId;
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

	public boolean getIfYearsOfServiceCriterionApplicable() {
		return _ifYearsOfServiceCriterionApplicable;
	}

	public boolean isIfYearsOfServiceCriterionApplicable() {
		return _ifYearsOfServiceCriterionApplicable;
	}

	public void setIfYearsOfServiceCriterionApplicable(
		boolean ifYearsOfServiceCriterionApplicable) {
		_ifYearsOfServiceCriterionApplicable = ifYearsOfServiceCriterionApplicable;
	}

	public String getMinYearsOfService() {
		return _minYearsOfService;
	}

	public void setMinYearsOfService(String minYearsOfService) {
		_minYearsOfService = minYearsOfService;
	}

	public String getMaxYearsOfService() {
		return _maxYearsOfService;
	}

	public void setMaxYearsOfService(String maxYearsOfService) {
		_maxYearsOfService = maxYearsOfService;
	}

	private long _leaveTypeApplicabilityId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private boolean _ifYearsOfServiceCriterionApplicable;
	private String _minYearsOfService;
	private String _maxYearsOfService;
}