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
public class LeaveAccrualSoap implements Serializable {
	public static LeaveAccrualSoap toSoapModel(LeaveAccrual model) {
		LeaveAccrualSoap soapModel = new LeaveAccrualSoap();

		soapModel.setLeaveAccrualId(model.getLeaveAccrualId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setAccrualFrequency(model.getAccrualFrequency());
		soapModel.setAccrueEvery(model.getAccrueEvery());
		soapModel.setDayOfCredit(model.getDayOfCredit());
		soapModel.setAccrualStartsOn(model.getAccrualStartsOn());
		soapModel.setMonthOfCredit(model.getMonthOfCredit());
		soapModel.setAccrualValidFrom(model.getAccrualValidFrom());
		soapModel.setFirstAccrual(model.getFirstAccrual());

		return soapModel;
	}

	public static LeaveAccrualSoap[] toSoapModels(LeaveAccrual[] models) {
		LeaveAccrualSoap[] soapModels = new LeaveAccrualSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveAccrualSoap[][] toSoapModels(LeaveAccrual[][] models) {
		LeaveAccrualSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveAccrualSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveAccrualSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveAccrualSoap[] toSoapModels(List<LeaveAccrual> models) {
		List<LeaveAccrualSoap> soapModels = new ArrayList<LeaveAccrualSoap>(models.size());

		for (LeaveAccrual model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveAccrualSoap[soapModels.size()]);
	}

	public LeaveAccrualSoap() {
	}

	public long getPrimaryKey() {
		return _leaveAccrualId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveAccrualId(pk);
	}

	public long getLeaveAccrualId() {
		return _leaveAccrualId;
	}

	public void setLeaveAccrualId(long leaveAccrualId) {
		_leaveAccrualId = leaveAccrualId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public String getAccrualFrequency() {
		return _accrualFrequency;
	}

	public void setAccrualFrequency(String accrualFrequency) {
		_accrualFrequency = accrualFrequency;
	}

	public int getAccrueEvery() {
		return _accrueEvery;
	}

	public void setAccrueEvery(int accrueEvery) {
		_accrueEvery = accrueEvery;
	}

	public int getDayOfCredit() {
		return _dayOfCredit;
	}

	public void setDayOfCredit(int dayOfCredit) {
		_dayOfCredit = dayOfCredit;
	}

	public String getAccrualStartsOn() {
		return _accrualStartsOn;
	}

	public void setAccrualStartsOn(String accrualStartsOn) {
		_accrualStartsOn = accrualStartsOn;
	}

	public int getMonthOfCredit() {
		return _monthOfCredit;
	}

	public void setMonthOfCredit(int monthOfCredit) {
		_monthOfCredit = monthOfCredit;
	}

	public String getAccrualValidFrom() {
		return _accrualValidFrom;
	}

	public void setAccrualValidFrom(String accrualValidFrom) {
		_accrualValidFrom = accrualValidFrom;
	}

	public String getFirstAccrual() {
		return _firstAccrual;
	}

	public void setFirstAccrual(String firstAccrual) {
		_firstAccrual = firstAccrual;
	}

	private long _leaveAccrualId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private String _accrualFrequency;
	private int _accrueEvery;
	private int _dayOfCredit;
	private String _accrualStartsOn;
	private int _monthOfCredit;
	private String _accrualValidFrom;
	private String _firstAccrual;
}