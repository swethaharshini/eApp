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
public class LeavePeriodSoap implements Serializable {
	public static LeavePeriodSoap toSoapModel(LeavePeriod model) {
		LeavePeriodSoap soapModel = new LeavePeriodSoap();

		soapModel.setLeavePeriodId(model.getLeavePeriodId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static LeavePeriodSoap[] toSoapModels(LeavePeriod[] models) {
		LeavePeriodSoap[] soapModels = new LeavePeriodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeavePeriodSoap[][] toSoapModels(LeavePeriod[][] models) {
		LeavePeriodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeavePeriodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeavePeriodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeavePeriodSoap[] toSoapModels(List<LeavePeriod> models) {
		List<LeavePeriodSoap> soapModels = new ArrayList<LeavePeriodSoap>(models.size());

		for (LeavePeriod model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeavePeriodSoap[soapModels.size()]);
	}

	public LeavePeriodSoap() {
	}

	public long getPrimaryKey() {
		return _leavePeriodId;
	}

	public void setPrimaryKey(long pk) {
		setLeavePeriodId(pk);
	}

	public long getLeavePeriodId() {
		return _leavePeriodId;
	}

	public void setLeavePeriodId(long leavePeriodId) {
		_leavePeriodId = leavePeriodId;
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

	public int getStartMonth() {
		return _startMonth;
	}

	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;
	}

	public int getStartDate() {
		return _startDate;
	}

	public void setStartDate(int startDate) {
		_startDate = startDate;
	}

	public String getEndDate() {
		return _endDate;
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	private long _leavePeriodId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private int _startMonth;
	private int _startDate;
	private String _endDate;
}