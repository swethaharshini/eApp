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
 * This class is a wrapper for {@link NewsAttachments}.
 * </p>
 *
 * @author rknowsys
 * @see NewsAttachments
 * @generated
 */
public class NewsAttachmentsWrapper implements NewsAttachments,
	ModelWrapper<NewsAttachments> {
	public NewsAttachmentsWrapper(NewsAttachments newsAttachments) {
		_newsAttachments = newsAttachments;
	}

	@Override
	public Class<?> getModelClass() {
		return NewsAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return NewsAttachments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsAttachmentId", getNewsAttachmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("attachmentTypeId", getAttachmentTypeId());
		attributes.put("newsId", getNewsId());
		attributes.put("description", getDescription());
		attributes.put("uuid", getUuid());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileType", getFileType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsAttachmentId = (Long)attributes.get("newsAttachmentId");

		if (newsAttachmentId != null) {
			setNewsAttachmentId(newsAttachmentId);
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

		Long newsId = (Long)attributes.get("newsId");

		if (newsId != null) {
			setNewsId(newsId);
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
	* Returns the primary key of this news attachments.
	*
	* @return the primary key of this news attachments
	*/
	@Override
	public long getPrimaryKey() {
		return _newsAttachments.getPrimaryKey();
	}

	/**
	* Sets the primary key of this news attachments.
	*
	* @param primaryKey the primary key of this news attachments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_newsAttachments.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the news attachment ID of this news attachments.
	*
	* @return the news attachment ID of this news attachments
	*/
	@Override
	public long getNewsAttachmentId() {
		return _newsAttachments.getNewsAttachmentId();
	}

	/**
	* Sets the news attachment ID of this news attachments.
	*
	* @param newsAttachmentId the news attachment ID of this news attachments
	*/
	@Override
	public void setNewsAttachmentId(long newsAttachmentId) {
		_newsAttachments.setNewsAttachmentId(newsAttachmentId);
	}

	/**
	* Returns the company ID of this news attachments.
	*
	* @return the company ID of this news attachments
	*/
	@Override
	public long getCompanyId() {
		return _newsAttachments.getCompanyId();
	}

	/**
	* Sets the company ID of this news attachments.
	*
	* @param companyId the company ID of this news attachments
	*/
	@Override
	public void setCompanyId(long companyId) {
		_newsAttachments.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this news attachments.
	*
	* @return the group ID of this news attachments
	*/
	@Override
	public long getGroupId() {
		return _newsAttachments.getGroupId();
	}

	/**
	* Sets the group ID of this news attachments.
	*
	* @param groupId the group ID of this news attachments
	*/
	@Override
	public void setGroupId(long groupId) {
		_newsAttachments.setGroupId(groupId);
	}

	/**
	* Returns the create date of this news attachments.
	*
	* @return the create date of this news attachments
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _newsAttachments.getCreateDate();
	}

	/**
	* Sets the create date of this news attachments.
	*
	* @param createDate the create date of this news attachments
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_newsAttachments.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this news attachments.
	*
	* @return the modified date of this news attachments
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _newsAttachments.getModifiedDate();
	}

	/**
	* Sets the modified date of this news attachments.
	*
	* @param modifiedDate the modified date of this news attachments
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_newsAttachments.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this news attachments.
	*
	* @return the user ID of this news attachments
	*/
	@Override
	public long getUserId() {
		return _newsAttachments.getUserId();
	}

	/**
	* Sets the user ID of this news attachments.
	*
	* @param userId the user ID of this news attachments
	*/
	@Override
	public void setUserId(long userId) {
		_newsAttachments.setUserId(userId);
	}

	/**
	* Returns the user uuid of this news attachments.
	*
	* @return the user uuid of this news attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsAttachments.getUserUuid();
	}

	/**
	* Sets the user uuid of this news attachments.
	*
	* @param userUuid the user uuid of this news attachments
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_newsAttachments.setUserUuid(userUuid);
	}

	/**
	* Returns the attachment type ID of this news attachments.
	*
	* @return the attachment type ID of this news attachments
	*/
	@Override
	public long getAttachmentTypeId() {
		return _newsAttachments.getAttachmentTypeId();
	}

	/**
	* Sets the attachment type ID of this news attachments.
	*
	* @param attachmentTypeId the attachment type ID of this news attachments
	*/
	@Override
	public void setAttachmentTypeId(long attachmentTypeId) {
		_newsAttachments.setAttachmentTypeId(attachmentTypeId);
	}

	/**
	* Returns the news ID of this news attachments.
	*
	* @return the news ID of this news attachments
	*/
	@Override
	public long getNewsId() {
		return _newsAttachments.getNewsId();
	}

	/**
	* Sets the news ID of this news attachments.
	*
	* @param newsId the news ID of this news attachments
	*/
	@Override
	public void setNewsId(long newsId) {
		_newsAttachments.setNewsId(newsId);
	}

	/**
	* Returns the description of this news attachments.
	*
	* @return the description of this news attachments
	*/
	@Override
	public java.lang.String getDescription() {
		return _newsAttachments.getDescription();
	}

	/**
	* Sets the description of this news attachments.
	*
	* @param description the description of this news attachments
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_newsAttachments.setDescription(description);
	}

	/**
	* Returns the uuid of this news attachments.
	*
	* @return the uuid of this news attachments
	*/
	@Override
	public java.lang.String getUuid() {
		return _newsAttachments.getUuid();
	}

	/**
	* Sets the uuid of this news attachments.
	*
	* @param uuid the uuid of this news attachments
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_newsAttachments.setUuid(uuid);
	}

	/**
	* Returns the file name of this news attachments.
	*
	* @return the file name of this news attachments
	*/
	@Override
	public java.lang.String getFileName() {
		return _newsAttachments.getFileName();
	}

	/**
	* Sets the file name of this news attachments.
	*
	* @param fileName the file name of this news attachments
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_newsAttachments.setFileName(fileName);
	}

	/**
	* Returns the file size of this news attachments.
	*
	* @return the file size of this news attachments
	*/
	@Override
	public long getFileSize() {
		return _newsAttachments.getFileSize();
	}

	/**
	* Sets the file size of this news attachments.
	*
	* @param fileSize the file size of this news attachments
	*/
	@Override
	public void setFileSize(long fileSize) {
		_newsAttachments.setFileSize(fileSize);
	}

	/**
	* Returns the file type of this news attachments.
	*
	* @return the file type of this news attachments
	*/
	@Override
	public java.lang.String getFileType() {
		return _newsAttachments.getFileType();
	}

	/**
	* Sets the file type of this news attachments.
	*
	* @param fileType the file type of this news attachments
	*/
	@Override
	public void setFileType(java.lang.String fileType) {
		_newsAttachments.setFileType(fileType);
	}

	@Override
	public boolean isNew() {
		return _newsAttachments.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_newsAttachments.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _newsAttachments.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_newsAttachments.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _newsAttachments.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _newsAttachments.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_newsAttachments.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _newsAttachments.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_newsAttachments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_newsAttachments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_newsAttachments.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NewsAttachmentsWrapper((NewsAttachments)_newsAttachments.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments) {
		return _newsAttachments.compareTo(newsAttachments);
	}

	@Override
	public int hashCode() {
		return _newsAttachments.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.NewsAttachments> toCacheModel() {
		return _newsAttachments.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.NewsAttachments toEscapedModel() {
		return new NewsAttachmentsWrapper(_newsAttachments.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.NewsAttachments toUnescapedModel() {
		return new NewsAttachmentsWrapper(_newsAttachments.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _newsAttachments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _newsAttachments.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_newsAttachments.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsAttachmentsWrapper)) {
			return false;
		}

		NewsAttachmentsWrapper newsAttachmentsWrapper = (NewsAttachmentsWrapper)obj;

		if (Validator.equals(_newsAttachments,
					newsAttachmentsWrapper._newsAttachments)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NewsAttachments getWrappedNewsAttachments() {
		return _newsAttachments;
	}

	@Override
	public NewsAttachments getWrappedModel() {
		return _newsAttachments;
	}

	@Override
	public void resetOriginalValues() {
		_newsAttachments.resetOriginalValues();
	}

	private NewsAttachments _newsAttachments;
}