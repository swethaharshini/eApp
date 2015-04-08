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
 * This class is a wrapper for {@link Documents}.
 * </p>
 *
 * @author rknowsys
 * @see Documents
 * @generated
 */
public class DocumentsWrapper implements Documents, ModelWrapper<Documents> {
	public DocumentsWrapper(Documents documents) {
		_documents = documents;
	}

	@Override
	public Class<?> getModelClass() {
		return Documents.class;
	}

	@Override
	public String getModelClassName() {
		return Documents.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("topic", getTopic());
		attributes.put("category", getCategory());
		attributes.put("description", getDescription());
		attributes.put("publishDate", getPublishDate());
		attributes.put("status", getStatus());
		attributes.put("admin", getAdmin());
		attributes.put("supervisor", getSupervisor());
		attributes.put("allEmployees", getAllEmployees());
		attributes.put("publishedTo", getPublishedTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
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

		String topic = (String)attributes.get("topic");

		if (topic != null) {
			setTopic(topic);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean admin = (Boolean)attributes.get("admin");

		if (admin != null) {
			setAdmin(admin);
		}

		Boolean supervisor = (Boolean)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}

		Boolean allEmployees = (Boolean)attributes.get("allEmployees");

		if (allEmployees != null) {
			setAllEmployees(allEmployees);
		}

		String publishedTo = (String)attributes.get("publishedTo");

		if (publishedTo != null) {
			setPublishedTo(publishedTo);
		}
	}

	/**
	* Returns the primary key of this documents.
	*
	* @return the primary key of this documents
	*/
	@Override
	public long getPrimaryKey() {
		return _documents.getPrimaryKey();
	}

	/**
	* Sets the primary key of this documents.
	*
	* @param primaryKey the primary key of this documents
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_documents.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document ID of this documents.
	*
	* @return the document ID of this documents
	*/
	@Override
	public long getDocumentId() {
		return _documents.getDocumentId();
	}

	/**
	* Sets the document ID of this documents.
	*
	* @param documentId the document ID of this documents
	*/
	@Override
	public void setDocumentId(long documentId) {
		_documents.setDocumentId(documentId);
	}

	/**
	* Returns the company ID of this documents.
	*
	* @return the company ID of this documents
	*/
	@Override
	public long getCompanyId() {
		return _documents.getCompanyId();
	}

	/**
	* Sets the company ID of this documents.
	*
	* @param companyId the company ID of this documents
	*/
	@Override
	public void setCompanyId(long companyId) {
		_documents.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this documents.
	*
	* @return the group ID of this documents
	*/
	@Override
	public long getGroupId() {
		return _documents.getGroupId();
	}

	/**
	* Sets the group ID of this documents.
	*
	* @param groupId the group ID of this documents
	*/
	@Override
	public void setGroupId(long groupId) {
		_documents.setGroupId(groupId);
	}

	/**
	* Returns the create date of this documents.
	*
	* @return the create date of this documents
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _documents.getCreateDate();
	}

	/**
	* Sets the create date of this documents.
	*
	* @param createDate the create date of this documents
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_documents.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this documents.
	*
	* @return the modified date of this documents
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _documents.getModifiedDate();
	}

	/**
	* Sets the modified date of this documents.
	*
	* @param modifiedDate the modified date of this documents
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_documents.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this documents.
	*
	* @return the user ID of this documents
	*/
	@Override
	public long getUserId() {
		return _documents.getUserId();
	}

	/**
	* Sets the user ID of this documents.
	*
	* @param userId the user ID of this documents
	*/
	@Override
	public void setUserId(long userId) {
		_documents.setUserId(userId);
	}

	/**
	* Returns the user uuid of this documents.
	*
	* @return the user uuid of this documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documents.getUserUuid();
	}

	/**
	* Sets the user uuid of this documents.
	*
	* @param userUuid the user uuid of this documents
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_documents.setUserUuid(userUuid);
	}

	/**
	* Returns the topic of this documents.
	*
	* @return the topic of this documents
	*/
	@Override
	public java.lang.String getTopic() {
		return _documents.getTopic();
	}

	/**
	* Sets the topic of this documents.
	*
	* @param topic the topic of this documents
	*/
	@Override
	public void setTopic(java.lang.String topic) {
		_documents.setTopic(topic);
	}

	/**
	* Returns the category of this documents.
	*
	* @return the category of this documents
	*/
	@Override
	public java.lang.String getCategory() {
		return _documents.getCategory();
	}

	/**
	* Sets the category of this documents.
	*
	* @param category the category of this documents
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_documents.setCategory(category);
	}

	/**
	* Returns the description of this documents.
	*
	* @return the description of this documents
	*/
	@Override
	public java.lang.String getDescription() {
		return _documents.getDescription();
	}

	/**
	* Sets the description of this documents.
	*
	* @param description the description of this documents
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_documents.setDescription(description);
	}

	/**
	* Returns the publish date of this documents.
	*
	* @return the publish date of this documents
	*/
	@Override
	public java.util.Date getPublishDate() {
		return _documents.getPublishDate();
	}

	/**
	* Sets the publish date of this documents.
	*
	* @param publishDate the publish date of this documents
	*/
	@Override
	public void setPublishDate(java.util.Date publishDate) {
		_documents.setPublishDate(publishDate);
	}

	/**
	* Returns the status of this documents.
	*
	* @return the status of this documents
	*/
	@Override
	public boolean getStatus() {
		return _documents.getStatus();
	}

	/**
	* Returns <code>true</code> if this documents is status.
	*
	* @return <code>true</code> if this documents is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _documents.isStatus();
	}

	/**
	* Sets whether this documents is status.
	*
	* @param status the status of this documents
	*/
	@Override
	public void setStatus(boolean status) {
		_documents.setStatus(status);
	}

	/**
	* Returns the admin of this documents.
	*
	* @return the admin of this documents
	*/
	@Override
	public boolean getAdmin() {
		return _documents.getAdmin();
	}

	/**
	* Returns <code>true</code> if this documents is admin.
	*
	* @return <code>true</code> if this documents is admin; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdmin() {
		return _documents.isAdmin();
	}

	/**
	* Sets whether this documents is admin.
	*
	* @param admin the admin of this documents
	*/
	@Override
	public void setAdmin(boolean admin) {
		_documents.setAdmin(admin);
	}

	/**
	* Returns the supervisor of this documents.
	*
	* @return the supervisor of this documents
	*/
	@Override
	public boolean getSupervisor() {
		return _documents.getSupervisor();
	}

	/**
	* Returns <code>true</code> if this documents is supervisor.
	*
	* @return <code>true</code> if this documents is supervisor; <code>false</code> otherwise
	*/
	@Override
	public boolean isSupervisor() {
		return _documents.isSupervisor();
	}

	/**
	* Sets whether this documents is supervisor.
	*
	* @param supervisor the supervisor of this documents
	*/
	@Override
	public void setSupervisor(boolean supervisor) {
		_documents.setSupervisor(supervisor);
	}

	/**
	* Returns the all employees of this documents.
	*
	* @return the all employees of this documents
	*/
	@Override
	public boolean getAllEmployees() {
		return _documents.getAllEmployees();
	}

	/**
	* Returns <code>true</code> if this documents is all employees.
	*
	* @return <code>true</code> if this documents is all employees; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllEmployees() {
		return _documents.isAllEmployees();
	}

	/**
	* Sets whether this documents is all employees.
	*
	* @param allEmployees the all employees of this documents
	*/
	@Override
	public void setAllEmployees(boolean allEmployees) {
		_documents.setAllEmployees(allEmployees);
	}

	/**
	* Returns the published to of this documents.
	*
	* @return the published to of this documents
	*/
	@Override
	public java.lang.String getPublishedTo() {
		return _documents.getPublishedTo();
	}

	/**
	* Sets the published to of this documents.
	*
	* @param publishedTo the published to of this documents
	*/
	@Override
	public void setPublishedTo(java.lang.String publishedTo) {
		_documents.setPublishedTo(publishedTo);
	}

	@Override
	public boolean isNew() {
		return _documents.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_documents.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _documents.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documents.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _documents.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _documents.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_documents.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _documents.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_documents.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_documents.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_documents.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentsWrapper((Documents)_documents.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Documents documents) {
		return _documents.compareTo(documents);
	}

	@Override
	public int hashCode() {
		return _documents.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Documents> toCacheModel() {
		return _documents.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Documents toEscapedModel() {
		return new DocumentsWrapper(_documents.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Documents toUnescapedModel() {
		return new DocumentsWrapper(_documents.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _documents.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _documents.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_documents.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentsWrapper)) {
			return false;
		}

		DocumentsWrapper documentsWrapper = (DocumentsWrapper)obj;

		if (Validator.equals(_documents, documentsWrapper._documents)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Documents getWrappedDocuments() {
		return _documents;
	}

	@Override
	public Documents getWrappedModel() {
		return _documents;
	}

	@Override
	public void resetOriginalValues() {
		_documents.resetOriginalValues();
	}

	private Documents _documents;
}