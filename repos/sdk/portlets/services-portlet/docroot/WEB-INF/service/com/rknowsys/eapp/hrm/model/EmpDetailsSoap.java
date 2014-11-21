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
public class EmpDetailsSoap implements Serializable {
	public static EmpDetailsSoap toSoapModel(EmpDetails model) {
		EmpDetailsSoap soapModel = new EmpDetailsSoap();

		soapModel.setEmpdetailsId(model.getEmpdetailsId());
		soapModel.setEmployeeNo(model.getEmployeeNo());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setTitle(model.getTitle());
		soapModel.setEmploymentstatus(model.getEmploymentstatus());
		soapModel.setName(model.getName());
		soapModel.setSupervisor(model.getSupervisor());

		return soapModel;
	}

	public static EmpDetailsSoap[] toSoapModels(EmpDetails[] models) {
		EmpDetailsSoap[] soapModels = new EmpDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpDetailsSoap[][] toSoapModels(EmpDetails[][] models) {
		EmpDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpDetailsSoap[] toSoapModels(List<EmpDetails> models) {
		List<EmpDetailsSoap> soapModels = new ArrayList<EmpDetailsSoap>(models.size());

		for (EmpDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpDetailsSoap[soapModels.size()]);
	}

	public EmpDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _empdetailsId;
	}

	public void setPrimaryKey(long pk) {
		setEmpdetailsId(pk);
	}

	public long getEmpdetailsId() {
		return _empdetailsId;
	}

	public void setEmpdetailsId(long empdetailsId) {
		_empdetailsId = empdetailsId;
	}

	public String getEmployeeNo() {
		return _employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		_employeeNo = employeeNo;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getEmploymentstatus() {
		return _employmentstatus;
	}

	public void setEmploymentstatus(String employmentstatus) {
		_employmentstatus = employmentstatus;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSupervisor() {
		return _supervisor;
	}

	public void setSupervisor(String supervisor) {
		_supervisor = supervisor;
	}

	private long _empdetailsId;
	private String _employeeNo;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _title;
	private String _employmentstatus;
	private String _name;
	private String _supervisor;
}