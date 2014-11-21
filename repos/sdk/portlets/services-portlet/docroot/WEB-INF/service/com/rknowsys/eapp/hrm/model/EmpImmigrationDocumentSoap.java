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
public class EmpImmigrationDocumentSoap implements Serializable {
	public static EmpImmigrationDocumentSoap toSoapModel(
		EmpImmigrationDocument model) {
		EmpImmigrationDocumentSoap soapModel = new EmpImmigrationDocumentSoap();

		soapModel.setEmpImmigrationDocumentId(model.getEmpImmigrationDocumentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setDocType(model.getDocType());
		soapModel.setDocNumber(model.getDocNumber());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setEligibleStatus(model.getEligibleStatus());
		soapModel.setIssuedBy(model.getIssuedBy());
		soapModel.setEligibleReviewDate(model.getEligibleReviewDate());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static EmpImmigrationDocumentSoap[] toSoapModels(
		EmpImmigrationDocument[] models) {
		EmpImmigrationDocumentSoap[] soapModels = new EmpImmigrationDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpImmigrationDocumentSoap[][] toSoapModels(
		EmpImmigrationDocument[][] models) {
		EmpImmigrationDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpImmigrationDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpImmigrationDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpImmigrationDocumentSoap[] toSoapModels(
		List<EmpImmigrationDocument> models) {
		List<EmpImmigrationDocumentSoap> soapModels = new ArrayList<EmpImmigrationDocumentSoap>(models.size());

		for (EmpImmigrationDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpImmigrationDocumentSoap[soapModels.size()]);
	}

	public EmpImmigrationDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _empImmigrationDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setEmpImmigrationDocumentId(pk);
	}

	public long getEmpImmigrationDocumentId() {
		return _empImmigrationDocumentId;
	}

	public void setEmpImmigrationDocumentId(long empImmigrationDocumentId) {
		_empImmigrationDocumentId = empImmigrationDocumentId;
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

	public String getDocType() {
		return _docType;
	}

	public void setDocType(String docType) {
		_docType = docType;
	}

	public String getDocNumber() {
		return _docNumber;
	}

	public void setDocNumber(String docNumber) {
		_docNumber = docNumber;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public String getEligibleStatus() {
		return _eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		_eligibleStatus = eligibleStatus;
	}

	public String getIssuedBy() {
		return _issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		_issuedBy = issuedBy;
	}

	public Date getEligibleReviewDate() {
		return _eligibleReviewDate;
	}

	public void setEligibleReviewDate(Date eligibleReviewDate) {
		_eligibleReviewDate = eligibleReviewDate;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _empImmigrationDocumentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _docType;
	private String _docNumber;
	private Date _issuedDate;
	private Date _expiryDate;
	private String _eligibleStatus;
	private String _issuedBy;
	private Date _eligibleReviewDate;
	private String _comments;
}