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
public class BulkUpdateSoap implements Serializable {
	public static BulkUpdateSoap toSoapModel(BulkUpdate model) {
		BulkUpdateSoap soapModel = new BulkUpdateSoap();

		soapModel.setBulkupdateId(model.getBulkupdateId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmployeeNo(model.getEmployeeNo());
		soapModel.setEmployeeName(model.getEmployeeName());
		soapModel.setEmploymentStatus(model.getEmploymentStatus());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setJobtitleId(model.getJobtitleId());
		soapModel.setSubunit(model.getSubunit());
		soapModel.setSubunitId(model.getSubunitId());
		soapModel.setLocation(model.getLocation());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setWorkshift(model.getWorkshift());
		soapModel.setShiftId(model.getShiftId());
		soapModel.setJoiningDate(model.getJoiningDate());
		soapModel.setSupervisor(model.getSupervisor());
		soapModel.setEmpStatus(model.getEmpStatus());

		return soapModel;
	}

	public static BulkUpdateSoap[] toSoapModels(BulkUpdate[] models) {
		BulkUpdateSoap[] soapModels = new BulkUpdateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BulkUpdateSoap[][] toSoapModels(BulkUpdate[][] models) {
		BulkUpdateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BulkUpdateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BulkUpdateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BulkUpdateSoap[] toSoapModels(List<BulkUpdate> models) {
		List<BulkUpdateSoap> soapModels = new ArrayList<BulkUpdateSoap>(models.size());

		for (BulkUpdate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BulkUpdateSoap[soapModels.size()]);
	}

	public BulkUpdateSoap() {
	}

	public long getPrimaryKey() {
		return _bulkupdateId;
	}

	public void setPrimaryKey(long pk) {
		setBulkupdateId(pk);
	}

	public long getBulkupdateId() {
		return _bulkupdateId;
	}

	public void setBulkupdateId(long bulkupdateId) {
		_bulkupdateId = bulkupdateId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getEmployeeNo() {
		return _employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		_employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return _employeeName;
	}

	public void setEmployeeName(String employeeName) {
		_employeeName = employeeName;
	}

	public String getEmploymentStatus() {
		return _employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		_employmentStatus = employmentStatus;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public long getJobtitleId() {
		return _jobtitleId;
	}

	public void setJobtitleId(long jobtitleId) {
		_jobtitleId = jobtitleId;
	}

	public String getSubunit() {
		return _subunit;
	}

	public void setSubunit(String subunit) {
		_subunit = subunit;
	}

	public long getSubunitId() {
		return _subunitId;
	}

	public void setSubunitId(long subunitId) {
		_subunitId = subunitId;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public String getWorkshift() {
		return _workshift;
	}

	public void setWorkshift(String workshift) {
		_workshift = workshift;
	}

	public long getShiftId() {
		return _shiftId;
	}

	public void setShiftId(long shiftId) {
		_shiftId = shiftId;
	}

	public Date getJoiningDate() {
		return _joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		_joiningDate = joiningDate;
	}

	public String getSupervisor() {
		return _supervisor;
	}

	public void setSupervisor(String supervisor) {
		_supervisor = supervisor;
	}

	public long getEmpStatus() {
		return _empStatus;
	}

	public void setEmpStatus(long empStatus) {
		_empStatus = empStatus;
	}

	private long _bulkupdateId;
	private long _employeeId;
	private long _employeeNo;
	private String _employeeName;
	private String _employmentStatus;
	private String _jobTitle;
	private long _jobtitleId;
	private String _subunit;
	private long _subunitId;
	private String _location;
	private long _locationId;
	private String _workshift;
	private long _shiftId;
	private Date _joiningDate;
	private String _supervisor;
	private long _empStatus;
}