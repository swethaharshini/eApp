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
public class EmpWorkExpSoap implements Serializable {
	public static EmpWorkExpSoap toSoapModel(EmpWorkExp model) {
		EmpWorkExpSoap soapModel = new EmpWorkExpSoap();

		soapModel.setEmpWorkExpId(model.getEmpWorkExpId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompany(model.getCompany());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static EmpWorkExpSoap[] toSoapModels(EmpWorkExp[] models) {
		EmpWorkExpSoap[] soapModels = new EmpWorkExpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpWorkExpSoap[][] toSoapModels(EmpWorkExp[][] models) {
		EmpWorkExpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpWorkExpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpWorkExpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpWorkExpSoap[] toSoapModels(List<EmpWorkExp> models) {
		List<EmpWorkExpSoap> soapModels = new ArrayList<EmpWorkExpSoap>(models.size());

		for (EmpWorkExp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpWorkExpSoap[soapModels.size()]);
	}

	public EmpWorkExpSoap() {
	}

	public long getPrimaryKey() {
		return _empWorkExpId;
	}

	public void setPrimaryKey(long pk) {
		setEmpWorkExpId(pk);
	}

	public long getEmpWorkExpId() {
		return _empWorkExpId;
	}

	public void setEmpWorkExpId(long empWorkExpId) {
		_empWorkExpId = empWorkExpId;
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

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _empWorkExpId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _company;
	private String _jobTitle;
	private Date _fromDate;
	private Date _toDate;
	private String _comment;
}