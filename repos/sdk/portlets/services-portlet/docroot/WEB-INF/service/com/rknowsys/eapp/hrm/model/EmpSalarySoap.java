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
public class EmpSalarySoap implements Serializable {
	public static EmpSalarySoap toSoapModel(EmpSalary model) {
		EmpSalarySoap soapModel = new EmpSalarySoap();

		soapModel.setEmpSalaryId(model.getEmpSalaryId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setPayGradeId(model.getPayGradeId());
		soapModel.setPayGradeCurrencyId(model.getPayGradeCurrencyId());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static EmpSalarySoap[] toSoapModels(EmpSalary[] models) {
		EmpSalarySoap[] soapModels = new EmpSalarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSalarySoap[][] toSoapModels(EmpSalary[][] models) {
		EmpSalarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSalarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSalarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSalarySoap[] toSoapModels(List<EmpSalary> models) {
		List<EmpSalarySoap> soapModels = new ArrayList<EmpSalarySoap>(models.size());

		for (EmpSalary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSalarySoap[soapModels.size()]);
	}

	public EmpSalarySoap() {
	}

	public long getPrimaryKey() {
		return _empSalaryId;
	}

	public void setPrimaryKey(long pk) {
		setEmpSalaryId(pk);
	}

	public long getEmpSalaryId() {
		return _empSalaryId;
	}

	public void setEmpSalaryId(long empSalaryId) {
		_empSalaryId = empSalaryId;
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

	public long getPayGradeId() {
		return _payGradeId;
	}

	public void setPayGradeId(long payGradeId) {
		_payGradeId = payGradeId;
	}

	public long getPayGradeCurrencyId() {
		return _payGradeCurrencyId;
	}

	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrencyId = payGradeCurrencyId;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _empSalaryId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _payGradeId;
	private long _payGradeCurrencyId;
	private String _comment;
}