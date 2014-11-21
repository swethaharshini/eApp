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
public class EmpLicenseSoap implements Serializable {
	public static EmpLicenseSoap toSoapModel(EmpLicense model) {
		EmpLicenseSoap soapModel = new EmpLicenseSoap();

		soapModel.setEmpLicenseId(model.getEmpLicenseId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLicenseId(model.getLicenseId());
		soapModel.setLicenseNumber(model.getLicenseNumber());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setExpiryDate(model.getExpiryDate());

		return soapModel;
	}

	public static EmpLicenseSoap[] toSoapModels(EmpLicense[] models) {
		EmpLicenseSoap[] soapModels = new EmpLicenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpLicenseSoap[][] toSoapModels(EmpLicense[][] models) {
		EmpLicenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpLicenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpLicenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpLicenseSoap[] toSoapModels(List<EmpLicense> models) {
		List<EmpLicenseSoap> soapModels = new ArrayList<EmpLicenseSoap>(models.size());

		for (EmpLicense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpLicenseSoap[soapModels.size()]);
	}

	public EmpLicenseSoap() {
	}

	public long getPrimaryKey() {
		return _empLicenseId;
	}

	public void setPrimaryKey(long pk) {
		setEmpLicenseId(pk);
	}

	public long getEmpLicenseId() {
		return _empLicenseId;
	}

	public void setEmpLicenseId(long empLicenseId) {
		_empLicenseId = empLicenseId;
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

	public long getLicenseId() {
		return _licenseId;
	}

	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	private long _empLicenseId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _licenseId;
	private String _licenseNumber;
	private Date _issuedDate;
	private Date _expiryDate;
}