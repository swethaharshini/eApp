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
public class LanguageSoap implements Serializable {
	public static LanguageSoap toSoapModel(Language model) {
		LanguageSoap soapModel = new LanguageSoap();

		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLanguageName(model.getLanguageName());

		return soapModel;
	}

	public static LanguageSoap[] toSoapModels(Language[] models) {
		LanguageSoap[] soapModels = new LanguageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LanguageSoap[][] toSoapModels(Language[][] models) {
		LanguageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LanguageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LanguageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LanguageSoap[] toSoapModels(List<Language> models) {
		List<LanguageSoap> soapModels = new ArrayList<LanguageSoap>(models.size());

		for (Language model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LanguageSoap[soapModels.size()]);
	}

	public LanguageSoap() {
	}

	public long getPrimaryKey() {
		return _languageId;
	}

	public void setPrimaryKey(long pk) {
		setLanguageId(pk);
	}

	public long getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(long languageId) {
		_languageId = languageId;
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

	public String getLanguageName() {
		return _languageName;
	}

	public void setLanguageName(String languageName) {
		_languageName = languageName;
	}

	private long _languageId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _languageName;
}