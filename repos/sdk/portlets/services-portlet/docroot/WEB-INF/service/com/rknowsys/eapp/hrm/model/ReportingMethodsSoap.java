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
public class ReportingMethodsSoap implements Serializable {
	public static ReportingMethodsSoap toSoapModel(ReportingMethods model) {
		ReportingMethodsSoap soapModel = new ReportingMethodsSoap();

		soapModel.setReportingmethodId(model.getReportingmethodId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setReportingmethodName(model.getReportingmethodName());

		return soapModel;
	}

	public static ReportingMethodsSoap[] toSoapModels(ReportingMethods[] models) {
		ReportingMethodsSoap[] soapModels = new ReportingMethodsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReportingMethodsSoap[][] toSoapModels(
		ReportingMethods[][] models) {
		ReportingMethodsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReportingMethodsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReportingMethodsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReportingMethodsSoap[] toSoapModels(
		List<ReportingMethods> models) {
		List<ReportingMethodsSoap> soapModels = new ArrayList<ReportingMethodsSoap>(models.size());

		for (ReportingMethods model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReportingMethodsSoap[soapModels.size()]);
	}

	public ReportingMethodsSoap() {
	}

	public long getPrimaryKey() {
		return _reportingmethodId;
	}

	public void setPrimaryKey(long pk) {
		setReportingmethodId(pk);
	}

	public long getReportingmethodId() {
		return _reportingmethodId;
	}

	public void setReportingmethodId(long reportingmethodId) {
		_reportingmethodId = reportingmethodId;
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

	public String getReportingmethodName() {
		return _reportingmethodName;
	}

	public void setReportingmethodName(String reportingmethodName) {
		_reportingmethodName = reportingmethodName;
	}

	private long _reportingmethodId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _reportingmethodName;
}