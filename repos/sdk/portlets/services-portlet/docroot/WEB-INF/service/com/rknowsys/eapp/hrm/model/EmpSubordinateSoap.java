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
public class EmpSubordinateSoap implements Serializable {
	public static EmpSubordinateSoap toSoapModel(EmpSubordinate model) {
		EmpSubordinateSoap soapModel = new EmpSubordinateSoap();

		soapModel.setEmpSubordinateId(model.getEmpSubordinateId());
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

	public static EmpSubordinateSoap[] toSoapModels(EmpSubordinate[] models) {
		EmpSubordinateSoap[] soapModels = new EmpSubordinateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSubordinateSoap[][] toSoapModels(EmpSubordinate[][] models) {
		EmpSubordinateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSubordinateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSubordinateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSubordinateSoap[] toSoapModels(List<EmpSubordinate> models) {
		List<EmpSubordinateSoap> soapModels = new ArrayList<EmpSubordinateSoap>(models.size());

		for (EmpSubordinate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSubordinateSoap[soapModels.size()]);
	}

	public EmpSubordinateSoap() {
	}

	public long getPrimaryKey() {
		return _empSubordinateId;
	}

	public void setPrimaryKey(long pk) {
		setEmpSubordinateId(pk);
	}

	public long getEmpSubordinateId() {
		return _empSubordinateId;
	}

	public void setEmpSubordinateId(long empSubordinateId) {
		_empSubordinateId = empSubordinateId;
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

	private long _empSubordinateId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _reporterEmployeeId;
	private long _reportingMethod;
}