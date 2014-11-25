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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class EmpJobSoap implements Serializable {
	public static EmpJobSoap toSoapModel(EmpJob model) {
		EmpJobSoap soapModel = new EmpJobSoap();

		soapModel.setEmpJobId(model.getEmpJobId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setJoinedDate(model.getJoinedDate());
		soapModel.setProbationEndDate(model.getProbationEndDate());
		soapModel.setPermanentDate(model.getPermanentDate());
		soapModel.setJobTitleId(model.getJobTitleId());
		soapModel.setEmploymentStatusId(model.getEmploymentStatusId());
		soapModel.setJobCategoryId(model.getJobCategoryId());
		soapModel.setSubUnitId(model.getSubUnitId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setShiftId(model.getShiftId());
		soapModel.setComments(model.getComments());
		soapModel.setEmploymentContractStartDate(model.getEmploymentContractStartDate());
		soapModel.setEmploymentContractEndDate(model.getEmploymentContractEndDate());
		soapModel.setContractDetails(model.getContractDetails());

		return soapModel;
	}

	public static EmpJobSoap[] toSoapModels(EmpJob[] models) {
		EmpJobSoap[] soapModels = new EmpJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpJobSoap[][] toSoapModels(EmpJob[][] models) {
		EmpJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpJobSoap[] toSoapModels(List<EmpJob> models) {
		List<EmpJobSoap> soapModels = new ArrayList<EmpJobSoap>(models.size());

		for (EmpJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpJobSoap[soapModels.size()]);
	}

	public EmpJobSoap() {
	}

	public long getPrimaryKey() {
		return _empJobId;
	}

	public void setPrimaryKey(long pk) {
		setEmpJobId(pk);
	}

	public long getEmpJobId() {
		return _empJobId;
	}

	public void setEmpJobId(long empJobId) {
		_empJobId = empJobId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getJoinedDate() {
		return _joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;
	}

	public Date getProbationEndDate() {
		return _probationEndDate;
	}

	public void setProbationEndDate(Date probationEndDate) {
		_probationEndDate = probationEndDate;
	}

	public Date getPermanentDate() {
		return _permanentDate;
	}

	public void setPermanentDate(Date permanentDate) {
		_permanentDate = permanentDate;
	}

	public long getJobTitleId() {
		return _jobTitleId;
	}

	public void setJobTitleId(long jobTitleId) {
		_jobTitleId = jobTitleId;
	}

	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;
	}

	public long getJobCategoryId() {
		return _jobCategoryId;
	}

	public void setJobCategoryId(long jobCategoryId) {
		_jobCategoryId = jobCategoryId;
	}

	public long getSubUnitId() {
		return _subUnitId;
	}

	public void setSubUnitId(long subUnitId) {
		_subUnitId = subUnitId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public long getShiftId() {
		return _shiftId;
	}

	public void setShiftId(long shiftId) {
		_shiftId = shiftId;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public Date getEmploymentContractStartDate() {
		return _employmentContractStartDate;
	}

	public void setEmploymentContractStartDate(Date employmentContractStartDate) {
		_employmentContractStartDate = employmentContractStartDate;
	}

	public Date getEmploymentContractEndDate() {
		return _employmentContractEndDate;
	}

	public void setEmploymentContractEndDate(Date employmentContractEndDate) {
		_employmentContractEndDate = employmentContractEndDate;
	}

	public Blob getContractDetails() {
		return _contractDetails;
	}

	public void setContractDetails(Blob contractDetails) {
		_contractDetails = contractDetails;
	}

	private long _empJobId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private Date _joinedDate;
	private Date _probationEndDate;
	private Date _permanentDate;
	private long _jobTitleId;
	private long _employmentStatusId;
	private long _jobCategoryId;
	private long _subUnitId;
	private long _locationId;
	private Date _effectiveDate;
	private long _shiftId;
	private String _comments;
	private Date _employmentContractStartDate;
	private Date _employmentContractEndDate;
	private Blob _contractDetails;
}