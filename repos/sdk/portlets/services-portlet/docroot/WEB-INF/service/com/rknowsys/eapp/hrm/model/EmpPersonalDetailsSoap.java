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
public class EmpPersonalDetailsSoap implements Serializable {
	public static EmpPersonalDetailsSoap toSoapModel(EmpPersonalDetails model) {
		EmpPersonalDetailsSoap soapModel = new EmpPersonalDetailsSoap();

		soapModel.setEmpPersonalDetailsId(model.getEmpPersonalDetailsId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setEmployeeNo(model.getEmployeeNo());
		soapModel.setOtherId(model.getOtherId());
		soapModel.setLicenseNo(model.getLicenseNo());
		soapModel.setLicenseExpDate(model.getLicenseExpDate());
		soapModel.setGender(model.getGender());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setNationalityId(model.getNationalityId());
		soapModel.setDateOfBirth(model.getDateOfBirth());

		return soapModel;
	}

	public static EmpPersonalDetailsSoap[] toSoapModels(
		EmpPersonalDetails[] models) {
		EmpPersonalDetailsSoap[] soapModels = new EmpPersonalDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpPersonalDetailsSoap[][] toSoapModels(
		EmpPersonalDetails[][] models) {
		EmpPersonalDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpPersonalDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpPersonalDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpPersonalDetailsSoap[] toSoapModels(
		List<EmpPersonalDetails> models) {
		List<EmpPersonalDetailsSoap> soapModels = new ArrayList<EmpPersonalDetailsSoap>(models.size());

		for (EmpPersonalDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpPersonalDetailsSoap[soapModels.size()]);
	}

	public EmpPersonalDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _empPersonalDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setEmpPersonalDetailsId(pk);
	}

	public long getEmpPersonalDetailsId() {
		return _empPersonalDetailsId;
	}

	public void setEmpPersonalDetailsId(long empPersonalDetailsId) {
		_empPersonalDetailsId = empPersonalDetailsId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getEmployeeNo() {
		return _employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		_employeeNo = employeeNo;
	}

	public String getOtherId() {
		return _otherId;
	}

	public void setOtherId(String otherId) {
		_otherId = otherId;
	}

	public String getLicenseNo() {
		return _licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		_licenseNo = licenseNo;
	}

	public Date getLicenseExpDate() {
		return _licenseExpDate;
	}

	public void setLicenseExpDate(Date licenseExpDate) {
		_licenseExpDate = licenseExpDate;
	}

	public long getGender() {
		return _gender;
	}

	public void setGender(long gender) {
		_gender = gender;
	}

	public long getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(long maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public long getNationalityId() {
		return _nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	private long _empPersonalDetailsId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _employeeNo;
	private String _otherId;
	private String _licenseNo;
	private Date _licenseExpDate;
	private long _gender;
	private long _maritalStatus;
	private long _nationalityId;
	private Date _dateOfBirth;
}