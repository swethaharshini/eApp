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
public class MembershipSoap implements Serializable {
	public static MembershipSoap toSoapModel(Membership model) {
		MembershipSoap soapModel = new MembershipSoap();

		soapModel.setMembershipId(model.getMembershipId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setMembershipName(model.getMembershipName());

		return soapModel;
	}

	public static MembershipSoap[] toSoapModels(Membership[] models) {
		MembershipSoap[] soapModels = new MembershipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipSoap[][] toSoapModels(Membership[][] models) {
		MembershipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipSoap[] toSoapModels(List<Membership> models) {
		List<MembershipSoap> soapModels = new ArrayList<MembershipSoap>(models.size());

		for (Membership model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipSoap[soapModels.size()]);
	}

	public MembershipSoap() {
	}

	public long getPrimaryKey() {
		return _membershipId;
	}

	public void setPrimaryKey(long pk) {
		setMembershipId(pk);
	}

	public long getMembershipId() {
		return _membershipId;
	}

	public void setMembershipId(long membershipId) {
		_membershipId = membershipId;
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

	public String getMembershipName() {
		return _membershipName;
	}

	public void setMembershipName(String membershipName) {
		_membershipName = membershipName;
	}

	private long _membershipId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _membershipName;
}