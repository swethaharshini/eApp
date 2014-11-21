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
public class SalaryComponentSoap implements Serializable {
	public static SalaryComponentSoap toSoapModel(SalaryComponent model) {
		SalaryComponentSoap soapModel = new SalaryComponentSoap();

		soapModel.setSalaryComponentId(model.getSalaryComponentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setComponentName(model.getComponentName());
		soapModel.setType(model.getType());
		soapModel.setOnlyCTC(model.getOnlyCTC());
		soapModel.setValueType(model.getValueType());

		return soapModel;
	}

	public static SalaryComponentSoap[] toSoapModels(SalaryComponent[] models) {
		SalaryComponentSoap[] soapModels = new SalaryComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalaryComponentSoap[][] toSoapModels(
		SalaryComponent[][] models) {
		SalaryComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalaryComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalaryComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalaryComponentSoap[] toSoapModels(
		List<SalaryComponent> models) {
		List<SalaryComponentSoap> soapModels = new ArrayList<SalaryComponentSoap>(models.size());

		for (SalaryComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalaryComponentSoap[soapModels.size()]);
	}

	public SalaryComponentSoap() {
	}

	public long getPrimaryKey() {
		return _salaryComponentId;
	}

	public void setPrimaryKey(long pk) {
		setSalaryComponentId(pk);
	}

	public long getSalaryComponentId() {
		return _salaryComponentId;
	}

	public void setSalaryComponentId(long salaryComponentId) {
		_salaryComponentId = salaryComponentId;
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

	public String getComponentName() {
		return _componentName;
	}

	public void setComponentName(String componentName) {
		_componentName = componentName;
	}

	public boolean getType() {
		return _type;
	}

	public boolean isType() {
		return _type;
	}

	public void setType(boolean type) {
		_type = type;
	}

	public boolean getOnlyCTC() {
		return _onlyCTC;
	}

	public boolean isOnlyCTC() {
		return _onlyCTC;
	}

	public void setOnlyCTC(boolean onlyCTC) {
		_onlyCTC = onlyCTC;
	}

	public String getValueType() {
		return _valueType;
	}

	public void setValueType(String valueType) {
		_valueType = valueType;
	}

	private long _salaryComponentId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _componentName;
	private boolean _type;
	private boolean _onlyCTC;
	private String _valueType;
}