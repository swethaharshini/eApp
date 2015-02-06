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
public class LeaveTypeEmployeeGroupsSoap implements Serializable {
	public static LeaveTypeEmployeeGroupsSoap toSoapModel(
		LeaveTypeEmployeeGroups model) {
		LeaveTypeEmployeeGroupsSoap soapModel = new LeaveTypeEmployeeGroupsSoap();

		soapModel.setLeaveTypeEmployeeGroupId(model.getLeaveTypeEmployeeGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setForJobTitles(model.getForJobTitles());
		soapModel.setForJobCategories(model.getForJobCategories());
		soapModel.setForEmploymentStatus(model.getForEmploymentStatus());
		soapModel.setForGender(model.getForGender());
		soapModel.setForFemale(model.getForFemale());
		soapModel.setForMale(model.getForMale());
		soapModel.setForYearsOfService(model.getForYearsOfService());
		soapModel.setFromYears(model.getFromYears());
		soapModel.setToYears(model.getToYears());

		return soapModel;
	}

	public static LeaveTypeEmployeeGroupsSoap[] toSoapModels(
		LeaveTypeEmployeeGroups[] models) {
		LeaveTypeEmployeeGroupsSoap[] soapModels = new LeaveTypeEmployeeGroupsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeEmployeeGroupsSoap[][] toSoapModels(
		LeaveTypeEmployeeGroups[][] models) {
		LeaveTypeEmployeeGroupsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveTypeEmployeeGroupsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveTypeEmployeeGroupsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveTypeEmployeeGroupsSoap[] toSoapModels(
		List<LeaveTypeEmployeeGroups> models) {
		List<LeaveTypeEmployeeGroupsSoap> soapModels = new ArrayList<LeaveTypeEmployeeGroupsSoap>(models.size());

		for (LeaveTypeEmployeeGroups model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveTypeEmployeeGroupsSoap[soapModels.size()]);
	}

	public LeaveTypeEmployeeGroupsSoap() {
	}

	public long getPrimaryKey() {
		return _leaveTypeEmployeeGroupId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveTypeEmployeeGroupId(pk);
	}

	public long getLeaveTypeEmployeeGroupId() {
		return _leaveTypeEmployeeGroupId;
	}

	public void setLeaveTypeEmployeeGroupId(long leaveTypeEmployeeGroupId) {
		_leaveTypeEmployeeGroupId = leaveTypeEmployeeGroupId;
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

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public boolean getForJobTitles() {
		return _forJobTitles;
	}

	public boolean isForJobTitles() {
		return _forJobTitles;
	}

	public void setForJobTitles(boolean forJobTitles) {
		_forJobTitles = forJobTitles;
	}

	public boolean getForJobCategories() {
		return _forJobCategories;
	}

	public boolean isForJobCategories() {
		return _forJobCategories;
	}

	public void setForJobCategories(boolean forJobCategories) {
		_forJobCategories = forJobCategories;
	}

	public boolean getForEmploymentStatus() {
		return _forEmploymentStatus;
	}

	public boolean isForEmploymentStatus() {
		return _forEmploymentStatus;
	}

	public void setForEmploymentStatus(boolean forEmploymentStatus) {
		_forEmploymentStatus = forEmploymentStatus;
	}

	public boolean getForGender() {
		return _forGender;
	}

	public boolean isForGender() {
		return _forGender;
	}

	public void setForGender(boolean forGender) {
		_forGender = forGender;
	}

	public boolean getForFemale() {
		return _forFemale;
	}

	public boolean isForFemale() {
		return _forFemale;
	}

	public void setForFemale(boolean forFemale) {
		_forFemale = forFemale;
	}

	public boolean getForMale() {
		return _forMale;
	}

	public boolean isForMale() {
		return _forMale;
	}

	public void setForMale(boolean forMale) {
		_forMale = forMale;
	}

	public boolean getForYearsOfService() {
		return _forYearsOfService;
	}

	public boolean isForYearsOfService() {
		return _forYearsOfService;
	}

	public void setForYearsOfService(boolean forYearsOfService) {
		_forYearsOfService = forYearsOfService;
	}

	public String getFromYears() {
		return _fromYears;
	}

	public void setFromYears(String fromYears) {
		_fromYears = fromYears;
	}

	public String getToYears() {
		return _toYears;
	}

	public void setToYears(String toYears) {
		_toYears = toYears;
	}

	private long _leaveTypeEmployeeGroupId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private String _groupName;
	private boolean _forJobTitles;
	private boolean _forJobCategories;
	private boolean _forEmploymentStatus;
	private boolean _forGender;
	private boolean _forFemale;
	private boolean _forMale;
	private boolean _forYearsOfService;
	private String _fromYears;
	private String _toYears;
}