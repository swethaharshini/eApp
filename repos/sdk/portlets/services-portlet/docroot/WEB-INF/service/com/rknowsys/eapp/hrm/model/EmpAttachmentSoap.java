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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class EmpAttachmentSoap implements Serializable {
	public static EmpAttachmentSoap toSoapModel(EmpAttachment model) {
		EmpAttachmentSoap soapModel = new EmpAttachmentSoap();

		soapModel.setEmpAttachmentId(model.getEmpAttachmentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAttachmentTypeId(model.getAttachmentTypeId());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setFileType(model.getFileType());
		soapModel.setFile(model.getFile());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static EmpAttachmentSoap[] toSoapModels(EmpAttachment[] models) {
		EmpAttachmentSoap[] soapModels = new EmpAttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpAttachmentSoap[][] toSoapModels(EmpAttachment[][] models) {
		EmpAttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpAttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpAttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpAttachmentSoap[] toSoapModels(List<EmpAttachment> models) {
		List<EmpAttachmentSoap> soapModels = new ArrayList<EmpAttachmentSoap>(models.size());

		for (EmpAttachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpAttachmentSoap[soapModels.size()]);
	}

	public EmpAttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _empAttachmentId;
	}

	public void setPrimaryKey(long pk) {
		setEmpAttachmentId(pk);
	}

	public long getEmpAttachmentId() {
		return _empAttachmentId;
	}

	public void setEmpAttachmentId(long empAttachmentId) {
		_empAttachmentId = empAttachmentId;
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

	public long getAttachmentTypeId() {
		return _attachmentTypeId;
	}

	public void setAttachmentTypeId(long attachmentTypeId) {
		_attachmentTypeId = attachmentTypeId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getFileSize() {
		return _fileSize;
	}

	public void setFileSize(long fileSize) {
		_fileSize = fileSize;
	}

	public String getFileType() {
		return _fileType;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public Blob getFile() {
		return _file;
	}

	public void setFile(Blob file) {
		_file = file;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _empAttachmentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _attachmentTypeId;
	private String _fileName;
	private long _fileSize;
	private String _fileType;
	private Blob _file;
	private String _comment;
}