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
public class EmpSalaryComponentSoap implements Serializable {
	public static EmpSalaryComponentSoap toSoapModel(EmpSalaryComponent model) {
		EmpSalaryComponentSoap soapModel = new EmpSalaryComponentSoap();

		soapModel.setEmpSalaryEarningId(model.getEmpSalaryEarningId());
		soapModel.setEmpSalaryId(model.getEmpSalaryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setSalaryComponentId(model.getSalaryComponentId());
		soapModel.setAmount(model.getAmount());
		soapModel.setEffectiveDate(model.getEffectiveDate());

		return soapModel;
	}

	public static EmpSalaryComponentSoap[] toSoapModels(
		EmpSalaryComponent[] models) {
		EmpSalaryComponentSoap[] soapModels = new EmpSalaryComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSalaryComponentSoap[][] toSoapModels(
		EmpSalaryComponent[][] models) {
		EmpSalaryComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSalaryComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSalaryComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSalaryComponentSoap[] toSoapModels(
		List<EmpSalaryComponent> models) {
		List<EmpSalaryComponentSoap> soapModels = new ArrayList<EmpSalaryComponentSoap>(models.size());

		for (EmpSalaryComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSalaryComponentSoap[soapModels.size()]);
	}

	public EmpSalaryComponentSoap() {
	}

	public long getPrimaryKey() {
		return _empSalaryEarningId;
	}

	public void setPrimaryKey(long pk) {
		setEmpSalaryEarningId(pk);
	}

	public long getEmpSalaryEarningId() {
		return _empSalaryEarningId;
	}

	public void setEmpSalaryEarningId(long empSalaryEarningId) {
		_empSalaryEarningId = empSalaryEarningId;
	}

	public long getEmpSalaryId() {
		return _empSalaryId;
	}

	public void setEmpSalaryId(long empSalaryId) {
		_empSalaryId = empSalaryId;
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

	public long getSalaryComponentId() {
		return _salaryComponentId;
	}

	public void setSalaryComponentId(long salaryComponentId) {
		_salaryComponentId = salaryComponentId;
	}

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	private long _empSalaryEarningId;
	private long _empSalaryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _salaryComponentId;
	private long _amount;
	private Date _effectiveDate;
}