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
public class EmpSkillSoap implements Serializable {
	public static EmpSkillSoap toSoapModel(EmpSkill model) {
		EmpSkillSoap soapModel = new EmpSkillSoap();

		soapModel.setEmpSkillId(model.getEmpSkillId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setSkillId(model.getSkillId());
		soapModel.setYears(model.getYears());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static EmpSkillSoap[] toSoapModels(EmpSkill[] models) {
		EmpSkillSoap[] soapModels = new EmpSkillSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSkillSoap[][] toSoapModels(EmpSkill[][] models) {
		EmpSkillSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSkillSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSkillSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSkillSoap[] toSoapModels(List<EmpSkill> models) {
		List<EmpSkillSoap> soapModels = new ArrayList<EmpSkillSoap>(models.size());

		for (EmpSkill model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSkillSoap[soapModels.size()]);
	}

	public EmpSkillSoap() {
	}

	public long getPrimaryKey() {
		return _empSkillId;
	}

	public void setPrimaryKey(long pk) {
		setEmpSkillId(pk);
	}

	public long getEmpSkillId() {
		return _empSkillId;
	}

	public void setEmpSkillId(long empSkillId) {
		_empSkillId = empSkillId;
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

	public long getSkillId() {
		return _skillId;
	}

	public void setSkillId(long skillId) {
		_skillId = skillId;
	}

	public String getYears() {
		return _years;
	}

	public void setYears(String years) {
		_years = years;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _empSkillId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _skillId;
	private String _years;
	private String _comments;
}