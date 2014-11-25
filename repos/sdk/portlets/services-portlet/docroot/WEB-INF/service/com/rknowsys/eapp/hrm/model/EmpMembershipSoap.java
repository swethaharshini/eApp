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
public class EmpMembershipSoap implements Serializable {
	public static EmpMembershipSoap toSoapModel(EmpMembership model) {
		EmpMembershipSoap soapModel = new EmpMembershipSoap();

		soapModel.setEmpMembershipId(model.getEmpMembershipId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setMembershipId(model.getMembershipId());
		soapModel.setSubscriptionPaidBy(model.getSubscriptionPaidBy());
		soapModel.setSubscriptionAmt(model.getSubscriptionAmt());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setCommenceDate(model.getCommenceDate());
		soapModel.setRenewalDate(model.getRenewalDate());

		return soapModel;
	}

	public static EmpMembershipSoap[] toSoapModels(EmpMembership[] models) {
		EmpMembershipSoap[] soapModels = new EmpMembershipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpMembershipSoap[][] toSoapModels(EmpMembership[][] models) {
		EmpMembershipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpMembershipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpMembershipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpMembershipSoap[] toSoapModels(List<EmpMembership> models) {
		List<EmpMembershipSoap> soapModels = new ArrayList<EmpMembershipSoap>(models.size());

		for (EmpMembership model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpMembershipSoap[soapModels.size()]);
	}

	public EmpMembershipSoap() {
	}

	public long getPrimaryKey() {
		return _empMembershipId;
	}

	public void setPrimaryKey(long pk) {
		setEmpMembershipId(pk);
	}

	public long getEmpMembershipId() {
		return _empMembershipId;
	}

	public void setEmpMembershipId(long empMembershipId) {
		_empMembershipId = empMembershipId;
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

	public long getMembershipId() {
		return _membershipId;
	}

	public void setMembershipId(long membershipId) {
		_membershipId = membershipId;
	}

	public String getSubscriptionPaidBy() {
		return _subscriptionPaidBy;
	}

	public void setSubscriptionPaidBy(String subscriptionPaidBy) {
		_subscriptionPaidBy = subscriptionPaidBy;
	}

	public long getSubscriptionAmt() {
		return _subscriptionAmt;
	}

	public void setSubscriptionAmt(long subscriptionAmt) {
		_subscriptionAmt = subscriptionAmt;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public Date getCommenceDate() {
		return _commenceDate;
	}

	public void setCommenceDate(Date commenceDate) {
		_commenceDate = commenceDate;
	}

	public Date getRenewalDate() {
		return _renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		_renewalDate = renewalDate;
	}

	private long _empMembershipId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _membershipId;
	private String _subscriptionPaidBy;
	private long _subscriptionAmt;
	private String _currency;
	private Date _commenceDate;
	private Date _renewalDate;
}