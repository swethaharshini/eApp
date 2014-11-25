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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmpAttachment}.
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachment
 * @generated
 */
public class EmpAttachmentWrapper implements EmpAttachment,
	ModelWrapper<EmpAttachment> {
	public EmpAttachmentWrapper(EmpAttachment empAttachment) {
		_empAttachment = empAttachment;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return EmpAttachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empAttachmentId", getEmpAttachmentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("attachmentTypeId", getAttachmentTypeId());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileType", getFileType());
		attributes.put("file", getFile());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empAttachmentId = (Long)attributes.get("empAttachmentId");

		if (empAttachmentId != null) {
			setEmpAttachmentId(empAttachmentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long attachmentTypeId = (Long)attributes.get("attachmentTypeId");

		if (attachmentTypeId != null) {
			setAttachmentTypeId(attachmentTypeId);
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

		Blob file = (Blob)attributes.get("file");

		if (file != null) {
			setFile(file);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	* Returns the primary key of this EmpAttachment.
	*
	* @return the primary key of this EmpAttachment
	*/
	@Override
	public long getPrimaryKey() {
		return _empAttachment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpAttachment.
	*
	* @param primaryKey the primary key of this EmpAttachment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empAttachment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp attachment ID of this EmpAttachment.
	*
	* @return the emp attachment ID of this EmpAttachment
	*/
	@Override
	public long getEmpAttachmentId() {
		return _empAttachment.getEmpAttachmentId();
	}

	/**
	* Sets the emp attachment ID of this EmpAttachment.
	*
	* @param empAttachmentId the emp attachment ID of this EmpAttachment
	*/
	@Override
	public void setEmpAttachmentId(long empAttachmentId) {
		_empAttachment.setEmpAttachmentId(empAttachmentId);
	}

	/**
	* Returns the employee ID of this EmpAttachment.
	*
	* @return the employee ID of this EmpAttachment
	*/
	@Override
	public long getEmployeeId() {
		return _empAttachment.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpAttachment.
	*
	* @param employeeId the employee ID of this EmpAttachment
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empAttachment.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpAttachment.
	*
	* @return the group ID of this EmpAttachment
	*/
	@Override
	public long getGroupId() {
		return _empAttachment.getGroupId();
	}

	/**
	* Sets the group ID of this EmpAttachment.
	*
	* @param groupId the group ID of this EmpAttachment
	*/
	@Override
	public void setGroupId(long groupId) {
		_empAttachment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpAttachment.
	*
	* @return the company ID of this EmpAttachment
	*/
	@Override
	public long getCompanyId() {
		return _empAttachment.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpAttachment.
	*
	* @param companyId the company ID of this EmpAttachment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empAttachment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpAttachment.
	*
	* @return the user ID of this EmpAttachment
	*/
	@Override
	public long getUserId() {
		return _empAttachment.getUserId();
	}

	/**
	* Sets the user ID of this EmpAttachment.
	*
	* @param userId the user ID of this EmpAttachment
	*/
	@Override
	public void setUserId(long userId) {
		_empAttachment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpAttachment.
	*
	* @return the user uuid of this EmpAttachment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAttachment.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpAttachment.
	*
	* @param userUuid the user uuid of this EmpAttachment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empAttachment.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpAttachment.
	*
	* @return the create date of this EmpAttachment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empAttachment.getCreateDate();
	}

	/**
	* Sets the create date of this EmpAttachment.
	*
	* @param createDate the create date of this EmpAttachment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empAttachment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpAttachment.
	*
	* @return the modified date of this EmpAttachment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empAttachment.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpAttachment.
	*
	* @param modifiedDate the modified date of this EmpAttachment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empAttachment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the attachment type ID of this EmpAttachment.
	*
	* @return the attachment type ID of this EmpAttachment
	*/
	@Override
	public long getAttachmentTypeId() {
		return _empAttachment.getAttachmentTypeId();
	}

	/**
	* Sets the attachment type ID of this EmpAttachment.
	*
	* @param attachmentTypeId the attachment type ID of this EmpAttachment
	*/
	@Override
	public void setAttachmentTypeId(long attachmentTypeId) {
		_empAttachment.setAttachmentTypeId(attachmentTypeId);
	}

	/**
	* Returns the file name of this EmpAttachment.
	*
	* @return the file name of this EmpAttachment
	*/
	@Override
	public java.lang.String getFileName() {
		return _empAttachment.getFileName();
	}

	/**
	* Sets the file name of this EmpAttachment.
	*
	* @param fileName the file name of this EmpAttachment
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_empAttachment.setFileName(fileName);
	}

	/**
	* Returns the file size of this EmpAttachment.
	*
	* @return the file size of this EmpAttachment
	*/
	@Override
	public long getFileSize() {
		return _empAttachment.getFileSize();
	}

	/**
	* Sets the file size of this EmpAttachment.
	*
	* @param fileSize the file size of this EmpAttachment
	*/
	@Override
	public void setFileSize(long fileSize) {
		_empAttachment.setFileSize(fileSize);
	}

	/**
	* Returns the file type of this EmpAttachment.
	*
	* @return the file type of this EmpAttachment
	*/
	@Override
	public java.lang.String getFileType() {
		return _empAttachment.getFileType();
	}

	/**
	* Sets the file type of this EmpAttachment.
	*
	* @param fileType the file type of this EmpAttachment
	*/
	@Override
	public void setFileType(java.lang.String fileType) {
		_empAttachment.setFileType(fileType);
	}

	/**
	* Returns the file of this EmpAttachment.
	*
	* @return the file of this EmpAttachment
	*/
	@Override
	public java.sql.Blob getFile() {
		return _empAttachment.getFile();
	}

	/**
	* Sets the file of this EmpAttachment.
	*
	* @param file the file of this EmpAttachment
	*/
	@Override
	public void setFile(java.sql.Blob file) {
		_empAttachment.setFile(file);
	}

	/**
	* Returns the comment of this EmpAttachment.
	*
	* @return the comment of this EmpAttachment
	*/
	@Override
	public java.lang.String getComment() {
		return _empAttachment.getComment();
	}

	/**
	* Sets the comment of this EmpAttachment.
	*
	* @param comment the comment of this EmpAttachment
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_empAttachment.setComment(comment);
	}

	@Override
	public boolean isNew() {
		return _empAttachment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empAttachment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empAttachment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empAttachment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empAttachment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empAttachment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empAttachment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empAttachment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empAttachment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empAttachment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empAttachment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpAttachmentWrapper((EmpAttachment)_empAttachment.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment) {
		return _empAttachment.compareTo(empAttachment);
	}

	@Override
	public int hashCode() {
		return _empAttachment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpAttachment> toCacheModel() {
		return _empAttachment.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpAttachment toEscapedModel() {
		return new EmpAttachmentWrapper(_empAttachment.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpAttachment toUnescapedModel() {
		return new EmpAttachmentWrapper(_empAttachment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empAttachment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empAttachment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empAttachment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpAttachmentWrapper)) {
			return false;
		}

		EmpAttachmentWrapper empAttachmentWrapper = (EmpAttachmentWrapper)obj;

		if (Validator.equals(_empAttachment, empAttachmentWrapper._empAttachment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpAttachment getWrappedEmpAttachment() {
		return _empAttachment;
	}

	@Override
	public EmpAttachment getWrappedModel() {
		return _empAttachment;
	}

	@Override
	public void resetOriginalValues() {
		_empAttachment.resetOriginalValues();
	}

	private EmpAttachment _empAttachment;
}