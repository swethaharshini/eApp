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
public class SkillSoap implements Serializable {
	public static SkillSoap toSoapModel(Skill model) {
		SkillSoap soapModel = new SkillSoap();

		soapModel.setSkillId(model.getSkillId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setSkillName(model.getSkillName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static SkillSoap[] toSoapModels(Skill[] models) {
		SkillSoap[] soapModels = new SkillSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkillSoap[][] toSoapModels(Skill[][] models) {
		SkillSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkillSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkillSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkillSoap[] toSoapModels(List<Skill> models) {
		List<SkillSoap> soapModels = new ArrayList<SkillSoap>(models.size());

		for (Skill model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkillSoap[soapModels.size()]);
	}

	public SkillSoap() {
	}

	public long getPrimaryKey() {
		return _skillId;
	}

	public void setPrimaryKey(long pk) {
		setSkillId(pk);
	}

	public long getSkillId() {
		return _skillId;
	}

	public void setSkillId(long skillId) {
		_skillId = skillId;
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

	public String getSkillName() {
		return _skillName;
	}

	public void setSkillName(String skillName) {
		_skillName = skillName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _skillId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _skillName;
	private String _description;
}