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
public class EmpEducationSoap implements Serializable {
	public static EmpEducationSoap toSoapModel(EmpEducation model) {
		EmpEducationSoap soapModel = new EmpEducationSoap();

		soapModel.setEmpEducationId(model.getEmpEducationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setEducationId(model.getEducationId());
		soapModel.setInstitute(model.getInstitute());
		soapModel.setMajor(model.getMajor());
		soapModel.setYear(model.getYear());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static EmpEducationSoap[] toSoapModels(EmpEducation[] models) {
		EmpEducationSoap[] soapModels = new EmpEducationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpEducationSoap[][] toSoapModels(EmpEducation[][] models) {
		EmpEducationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpEducationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpEducationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpEducationSoap[] toSoapModels(List<EmpEducation> models) {
		List<EmpEducationSoap> soapModels = new ArrayList<EmpEducationSoap>(models.size());

		for (EmpEducation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpEducationSoap[soapModels.size()]);
	}

	public EmpEducationSoap() {
	}

	public long getPrimaryKey() {
		return _empEducationId;
	}

	public void setPrimaryKey(long pk) {
		setEmpEducationId(pk);
	}

	public long getEmpEducationId() {
		return _empEducationId;
	}

	public void setEmpEducationId(long empEducationId) {
		_empEducationId = empEducationId;
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

	public long getEducationId() {
		return _educationId;
	}

	public void setEducationId(long educationId) {
		_educationId = educationId;
	}

	public String getInstitute() {
		return _institute;
	}

	public void setInstitute(String institute) {
		_institute = institute;
	}

	public String getMajor() {
		return _major;
	}

	public void setMajor(String major) {
		_major = major;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private long _empEducationId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _educationId;
	private String _institute;
	private String _major;
	private String _year;
	private Date _startDate;
	private Date _endDate;
}