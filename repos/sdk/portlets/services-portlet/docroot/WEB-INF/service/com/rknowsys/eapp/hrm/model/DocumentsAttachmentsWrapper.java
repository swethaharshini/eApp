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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentsAttachments}.
 * </p>
 *
 * @author rknowsys
 * @see DocumentsAttachments
 * @generated
 */
public class DocumentsAttachmentsWrapper implements DocumentsAttachments,
	ModelWrapper<DocumentsAttachments> {
	public DocumentsAttachmentsWrapper(
		DocumentsAttachments documentsAttachments) {
		_documentsAttachments = documentsAttachments;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentsAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentsAttachments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentAttachmentId", getDocumentAttachmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("attachmentTypeId", getAttachmentTypeId());
		attributes.put("documentId", getDocumentId());
		attributes.put("description", getDescription());
		attributes.put("uuid", getUuid());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileType", getFileType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentAttachmentId = (Long)attributes.get("documentAttachmentId");

		if (documentAttachmentId != null) {
			setDocumentAttachmentId(documentAttachmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long attachmentTypeId = (Long)attributes.get("attachmentTypeId");

		if (attachmentTypeId != null) {
			setAttachmentTypeId(attachmentTypeId);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileSize = (Long)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}
	}

	/**
	* Returns the primary key of this documents attachments.
	*
	* @return the primary key of this documents attachments
	*/
	@Override
	public long getPrimaryKey() {
		return _documentsAttachments.getPrimaryKey();
	}

	/**
	* Sets the primary key of this documents attachments.
	*
	* @param primaryKey the primary key of this documents attachments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_documentsAttachments.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document attachment ID of this documents attachments.
	*
	* @return the document attachment ID of this documents attachments
	*/
	@Override
	public long getDocumentAttachmentId() {
		return _documentsAttachments.getDocumentAttachmentId();
	}

	/**
	* Sets the document attachment ID of this documents attachments.
	*
	* @param documentAttachmentId the document attachment ID of this documents attachments
	*/
	@Override
	public void setDocumentAttachmentId(long documentAttachmentId) {
		_documentsAttachments.setDocumentAttachmentId(documentAttachmentId);
	}

	/**
	* Returns the company ID of this documents attachments.
	*
	* @return the company ID of this documents attachments
	*/
	@Override
	public long getCompanyId() {
		return _documentsAttachments.getCompanyId();
	}

	/**
	* Sets the company ID of this documents attachments.
	*
	* @param companyId the company ID of this documents attachments
	*/
	@Override
	public void setCompanyId(long companyId) {
		_documentsAttachments.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this documents attachments.
	*
	* @return the group ID of this documents attachments
	*/
	@Override
	public long getGroupId() {
		return _documentsAttachments.getGroupId();
	}

	/**
	* Sets the group ID of this documents attachments.
	*
	* @param groupId the group ID of this documents attachments
	*/
	@Override
	public void setGroupId(long groupId) {
		_documentsAttachments.setGroupId(groupId);
	}

	/**
	* Returns the create date of this documents attachments.
	*
	* @return the create date of this documents attachments
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _documentsAttachments.getCreateDate();
	}

	/**
	* Sets the create date of this documents attachments.
	*
	* @param createDate the create date of this documents attachments
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_documentsAttachments.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this documents attachments.
	*
	* @return the modified date of this documents attachments
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _documentsAttachments.getModifiedDate();
	}

	/**
	* Sets the modified date of this documents attachments.
	*
	* @param modifiedDate the modified date of this documents attachments
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_documentsAttachments.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this documents attachments.
	*
	* @return the user ID of this documents attachments
	*/
	@Override
	public long getUserId() {
		return _documentsAttachments.getUserId();
	}

	/**
	* Sets the user ID of this documents attachments.
	*
	* @param userId the user ID of this documents attachments
	*/
	@Override
	public void setUserId(long userId) {
		_documentsAttachments.setUserId(userId);
	}

	/**
	* Returns the user uuid of this documents attachments.
	*
	* @return the user uuid of this documents attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachments.getUserUuid();
	}

	/**
	* Sets the user uuid of this documents attachments.
	*
	* @param userUuid the user uuid of this documents attachments
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_documentsAttachments.setUserUuid(userUuid);
	}

	/**
	* Returns the attachment type ID of this documents attachments.
	*
	* @return the attachment type ID of this documents attachments
	*/
	@Override
	public long getAttachmentTypeId() {
		return _documentsAttachments.getAttachmentTypeId();
	}

	/**
	* Sets the attachment type ID of this documents attachments.
	*
	* @param attachmentTypeId the attachment type ID of this documents attachments
	*/
	@Override
	public void setAttachmentTypeId(long attachmentTypeId) {
		_documentsAttachments.setAttachmentTypeId(attachmentTypeId);
	}

	/**
	* Returns the document ID of this documents attachments.
	*
	* @return the document ID of this documents attachments
	*/
	@Override
	public long getDocumentId() {
		return _documentsAttachments.getDocumentId();
	}

	/**
	* Sets the document ID of this documents attachments.
	*
	* @param documentId the document ID of this documents attachments
	*/
	@Override
	public void setDocumentId(long documentId) {
		_documentsAttachments.setDocumentId(documentId);
	}

	/**
	* Returns the description of this documents attachments.
	*
	* @return the description of this documents attachments
	*/
	@Override
	public java.lang.String getDescription() {
		return _documentsAttachments.getDescription();
	}

	/**
	* Sets the description of this documents attachments.
	*
	* @param description the description of this documents attachments
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_documentsAttachments.setDescription(description);
	}

	/**
	* Returns the uuid of this documents attachments.
	*
	* @return the uuid of this documents attachments
	*/
	@Override
	public java.lang.String getUuid() {
		return _documentsAttachments.getUuid();
	}

	/**
	* Sets the uuid of this documents attachments.
	*
	* @param uuid the uuid of this documents attachments
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_documentsAttachments.setUuid(uuid);
	}

	/**
	* Returns the file name of this documents attachments.
	*
	* @return the file name of this documents attachments
	*/
	@Override
	public java.lang.String getFileName() {
		return _documentsAttachments.getFileName();
	}

	/**
	* Sets the file name of this documents attachments.
	*
	* @param fileName the file name of this documents attachments
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_documentsAttachments.setFileName(fileName);
	}

	/**
	* Returns the file size of this documents attachments.
	*
	* @return the file size of this documents attachments
	*/
	@Override
	public long getFileSize() {
		return _documentsAttachments.getFileSize();
	}

	/**
	* Sets the file size of this documents attachments.
	*
	* @param fileSize the file size of this documents attachments
	*/
	@Override
	public void setFileSize(long fileSize) {
		_documentsAttachments.setFileSize(fileSize);
	}

	/**
	* Returns the file type of this documents attachments.
	*
	* @return the file type of this documents attachments
	*/
	@Override
	public java.lang.String getFileType() {
		return _documentsAttachments.getFileType();
	}

	/**
	* Sets the file type of this documents attachments.
	*
	* @param fileType the file type of this documents attachments
	*/
	@Override
	public void setFileType(java.lang.String fileType) {
		_documentsAttachments.setFileType(fileType);
	}

	@Override
	public boolean isNew() {
		return _documentsAttachments.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_documentsAttachments.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _documentsAttachments.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentsAttachments.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _documentsAttachments.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _documentsAttachments.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_documentsAttachments.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _documentsAttachments.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_documentsAttachments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_documentsAttachments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_documentsAttachments.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentsAttachmentsWrapper((DocumentsAttachments)_documentsAttachments.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.DocumentsAttachments documentsAttachments) {
		return _documentsAttachments.compareTo(documentsAttachments);
	}

	@Override
	public int hashCode() {
		return _documentsAttachments.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.DocumentsAttachments> toCacheModel() {
		return _documentsAttachments.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments toEscapedModel() {
		return new DocumentsAttachmentsWrapper(_documentsAttachments.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments toUnescapedModel() {
		return new DocumentsAttachmentsWrapper(_documentsAttachments.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _documentsAttachments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _documentsAttachments.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_documentsAttachments.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentsAttachmentsWrapper)) {
			return false;
		}

		DocumentsAttachmentsWrapper documentsAttachmentsWrapper = (DocumentsAttachmentsWrapper)obj;

		if (Validator.equals(_documentsAttachments,
					documentsAttachmentsWrapper._documentsAttachments)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DocumentsAttachments getWrappedDocumentsAttachments() {
		return _documentsAttachments;
	}

	@Override
	public DocumentsAttachments getWrappedModel() {
		return _documentsAttachments;
	}

	@Override
	public void resetOriginalValues() {
		_documentsAttachments.resetOriginalValues();
	}

	private DocumentsAttachments _documentsAttachments;
}