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
public class EducationSoap implements Serializable {
	public static EducationSoap toSoapModel(Education model) {
		EducationSoap soapModel = new EducationSoap();

		soapModel.setEducationId(model.getEducationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setEduLevel(model.getEduLevel());

		return soapModel;
	}

	public static EducationSoap[] toSoapModels(Education[] models) {
		EducationSoap[] soapModels = new EducationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EducationSoap[][] toSoapModels(Education[][] models) {
		EducationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EducationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EducationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EducationSoap[] toSoapModels(List<Education> models) {
		List<EducationSoap> soapModels = new ArrayList<EducationSoap>(models.size());

		for (Education model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EducationSoap[soapModels.size()]);
	}

	public EducationSoap() {
	}

	public long getPrimaryKey() {
		return _educationId;
	}

	public void setPrimaryKey(long pk) {
		setEducationId(pk);
	}

	public long getEducationId() {
		return _educationId;
	}

	public void setEducationId(long educationId) {
		_educationId = educationId;
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

	public String getEduLevel() {
		return _eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		_eduLevel = eduLevel;
	}

	private long _educationId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _eduLevel;
}