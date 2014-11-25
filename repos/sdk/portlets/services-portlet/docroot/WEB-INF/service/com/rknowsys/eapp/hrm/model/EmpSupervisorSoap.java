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
public class EmpSupervisorSoap implements Serializable {
	public static EmpSupervisorSoap toSoapModel(EmpSupervisor model) {
		EmpSupervisorSoap soapModel = new EmpSupervisorSoap();

		soapModel.setEmpSupervisorId(model.getEmpSupervisorId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setReporterEmployeeId(model.getReporterEmployeeId());
		soapModel.setReportingMethod(model.getReportingMethod());

		return soapModel;
	}

	public static EmpSupervisorSoap[] toSoapModels(EmpSupervisor[] models) {
		EmpSupervisorSoap[] soapModels = new EmpSupervisorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSupervisorSoap[][] toSoapModels(EmpSupervisor[][] models) {
		EmpSupervisorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSupervisorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSupervisorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSupervisorSoap[] toSoapModels(List<EmpSupervisor> models) {
		List<EmpSupervisorSoap> soapModels = new ArrayList<EmpSupervisorSoap>(models.size());

		for (EmpSupervisor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSupervisorSoap[soapModels.size()]);
	}

	public EmpSupervisorSoap() {
	}

	public long getPrimaryKey() {
		return _empSupervisorId;
	}

	public void setPrimaryKey(long pk) {
		setEmpSupervisorId(pk);
	}

	public long getEmpSupervisorId() {
		return _empSupervisorId;
	}

	public void setEmpSupervisorId(long empSupervisorId) {
		_empSupervisorId = empSupervisorId;
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

	public long getReporterEmployeeId() {
		return _reporterEmployeeId;
	}

	public void setReporterEmployeeId(long reporterEmployeeId) {
		_reporterEmployeeId = reporterEmployeeId;
	}

	public long getReportingMethod() {
		return _reportingMethod;
	}

	public void setReportingMethod(long reportingMethod) {
		_reportingMethod = reportingMethod;
	}

	private long _empSupervisorId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _reporterEmployeeId;
	private long _reportingMethod;
}