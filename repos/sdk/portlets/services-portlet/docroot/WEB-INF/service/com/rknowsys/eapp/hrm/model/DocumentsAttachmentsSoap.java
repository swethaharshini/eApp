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
public class DocumentsAttachmentsSoap implements Serializable {
	public static DocumentsAttachmentsSoap toSoapModel(
		DocumentsAttachments model) {
		DocumentsAttachmentsSoap soapModel = new DocumentsAttachmentsSoap();

		soapModel.setDocumentAttachmentId(model.getDocumentAttachmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setAttachmentTypeId(model.getAttachmentTypeId());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setDescription(model.getDescription());
		soapModel.setUuid(model.getUuid());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setFileType(model.getFileType());

		return soapModel;
	}

	public static DocumentsAttachmentsSoap[] toSoapModels(
		DocumentsAttachments[] models) {
		DocumentsAttachmentsSoap[] soapModels = new DocumentsAttachmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentsAttachmentsSoap[][] toSoapModels(
		DocumentsAttachments[][] models) {
		DocumentsAttachmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentsAttachmentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentsAttachmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentsAttachmentsSoap[] toSoapModels(
		List<DocumentsAttachments> models) {
		List<DocumentsAttachmentsSoap> soapModels = new ArrayList<DocumentsAttachmentsSoap>(models.size());

		for (DocumentsAttachments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentsAttachmentsSoap[soapModels.size()]);
	}

	public DocumentsAttachmentsSoap() {
	}

	public long getPrimaryKey() {
		return _documentAttachmentId;
	}

	public void setPrimaryKey(long pk) {
		setDocumentAttachmentId(pk);
	}

	public long getDocumentAttachmentId() {
		return _documentAttachmentId;
	}

	public void setDocumentAttachmentId(long documentAttachmentId) {
		_documentAttachmentId = documentAttachmentId;
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

	public long getAttachmentTypeId() {
		return _attachmentTypeId;
	}

	public void setAttachmentTypeId(long attachmentTypeId) {
		_attachmentTypeId = attachmentTypeId;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	private long _documentAttachmentId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _attachmentTypeId;
	private long _documentId;
	private String _description;
	private String _uuid;
	private String _fileName;
	private long _fileSize;
	private String _fileType;
}