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
public class EmpDirectDepositSoap implements Serializable {
	public static EmpDirectDepositSoap toSoapModel(EmpDirectDeposit model) {
		EmpDirectDepositSoap soapModel = new EmpDirectDepositSoap();

		soapModel.setEmpDirectDepositId(model.getEmpDirectDepositId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setAmount(model.getAmount());
		soapModel.setAccountNumber(model.getAccountNumber());
		soapModel.setBankName(model.getBankName());
		soapModel.setAccountType(model.getAccountType());
		soapModel.setBranchLocation(model.getBranchLocation());
		soapModel.setRoutingNumber(model.getRoutingNumber());

		return soapModel;
	}

	public static EmpDirectDepositSoap[] toSoapModels(EmpDirectDeposit[] models) {
		EmpDirectDepositSoap[] soapModels = new EmpDirectDepositSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpDirectDepositSoap[][] toSoapModels(
		EmpDirectDeposit[][] models) {
		EmpDirectDepositSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpDirectDepositSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpDirectDepositSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpDirectDepositSoap[] toSoapModels(
		List<EmpDirectDeposit> models) {
		List<EmpDirectDepositSoap> soapModels = new ArrayList<EmpDirectDepositSoap>(models.size());

		for (EmpDirectDeposit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpDirectDepositSoap[soapModels.size()]);
	}

	public EmpDirectDepositSoap() {
	}

	public long getPrimaryKey() {
		return _empDirectDepositId;
	}

	public void setPrimaryKey(long pk) {
		setEmpDirectDepositId(pk);
	}

	public long getEmpDirectDepositId() {
		return _empDirectDepositId;
	}

	public void setEmpDirectDepositId(long empDirectDepositId) {
		_empDirectDepositId = empDirectDepositId;
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

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
	}

	public long getAccountNumber() {
		return _accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		_accountNumber = accountNumber;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getAccountType() {
		return _accountType;
	}

	public void setAccountType(String accountType) {
		_accountType = accountType;
	}

	public String getBranchLocation() {
		return _branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		_branchLocation = branchLocation;
	}

	public String getRoutingNumber() {
		return _routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		_routingNumber = routingNumber;
	}

	private long _empDirectDepositId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _amount;
	private long _accountNumber;
	private String _bankName;
	private String _accountType;
	private String _branchLocation;
	private String _routingNumber;
}