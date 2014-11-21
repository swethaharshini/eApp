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
public class EmpDependentSoap implements Serializable {
	public static EmpDependentSoap toSoapModel(EmpDependent model) {
		EmpDependentSoap soapModel = new EmpDependentSoap();

		soapModel.setEmpDependentId(model.getEmpDependentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setRelationship(model.getRelationship());
		soapModel.setDateOfBirth(model.getDateOfBirth());

		return soapModel;
	}

	public static EmpDependentSoap[] toSoapModels(EmpDependent[] models) {
		EmpDependentSoap[] soapModels = new EmpDependentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpDependentSoap[][] toSoapModels(EmpDependent[][] models) {
		EmpDependentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpDependentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpDependentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpDependentSoap[] toSoapModels(List<EmpDependent> models) {
		List<EmpDependentSoap> soapModels = new ArrayList<EmpDependentSoap>(models.size());

		for (EmpDependent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpDependentSoap[soapModels.size()]);
	}

	public EmpDependentSoap() {
	}

	public long getPrimaryKey() {
		return _empDependentId;
	}

	public void setPrimaryKey(long pk) {
		setEmpDependentId(pk);
	}

	public long getEmpDependentId() {
		return _empDependentId;
	}

	public void setEmpDependentId(long empDependentId) {
		_empDependentId = empDependentId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRelationship() {
		return _relationship;
	}

	public void setRelationship(String relationship) {
		_relationship = relationship;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	private long _empDependentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _relationship;
	private Date _dateOfBirth;
}