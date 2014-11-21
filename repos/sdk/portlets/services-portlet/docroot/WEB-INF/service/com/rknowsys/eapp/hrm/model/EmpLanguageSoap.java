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
public class EmpLanguageSoap implements Serializable {
	public static EmpLanguageSoap toSoapModel(EmpLanguage model) {
		EmpLanguageSoap soapModel = new EmpLanguageSoap();

		soapModel.setEmpLanguageId(model.getEmpLanguageId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setLanguageSkill(model.getLanguageSkill());
		soapModel.setLanguageFluency(model.getLanguageFluency());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static EmpLanguageSoap[] toSoapModels(EmpLanguage[] models) {
		EmpLanguageSoap[] soapModels = new EmpLanguageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpLanguageSoap[][] toSoapModels(EmpLanguage[][] models) {
		EmpLanguageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpLanguageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpLanguageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpLanguageSoap[] toSoapModels(List<EmpLanguage> models) {
		List<EmpLanguageSoap> soapModels = new ArrayList<EmpLanguageSoap>(models.size());

		for (EmpLanguage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpLanguageSoap[soapModels.size()]);
	}

	public EmpLanguageSoap() {
	}

	public long getPrimaryKey() {
		return _empLanguageId;
	}

	public void setPrimaryKey(long pk) {
		setEmpLanguageId(pk);
	}

	public long getEmpLanguageId() {
		return _empLanguageId;
	}

	public void setEmpLanguageId(long empLanguageId) {
		_empLanguageId = empLanguageId;
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

	public long getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(long languageId) {
		_languageId = languageId;
	}

	public String getLanguageSkill() {
		return _languageSkill;
	}

	public void setLanguageSkill(String languageSkill) {
		_languageSkill = languageSkill;
	}

	public String getLanguageFluency() {
		return _languageFluency;
	}

	public void setLanguageFluency(String languageFluency) {
		_languageFluency = languageFluency;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _empLanguageId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _languageId;
	private String _languageSkill;
	private String _languageFluency;
	private String _comments;
}