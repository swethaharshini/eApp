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
 * This class is a wrapper for {@link DocumentCategories}.
 * </p>
 *
 * @author rknowsys
 * @see DocumentCategories
 * @generated
 */
public class DocumentCategoriesWrapper implements DocumentCategories,
	ModelWrapper<DocumentCategories> {
	public DocumentCategoriesWrapper(DocumentCategories documentCategories) {
		_documentCategories = documentCategories;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentCategories.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentCategories.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentcategoryId", getDocumentcategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentCategory", getDocumentCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentcategoryId = (Long)attributes.get("documentcategoryId");

		if (documentcategoryId != null) {
			setDocumentcategoryId(documentcategoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String documentCategory = (String)attributes.get("documentCategory");

		if (documentCategory != null) {
			setDocumentCategory(documentCategory);
		}
	}

	/**
	* Returns the primary key of this document categories.
	*
	* @return the primary key of this document categories
	*/
	@Override
	public long getPrimaryKey() {
		return _documentCategories.getPrimaryKey();
	}

	/**
	* Sets the primary key of this document categories.
	*
	* @param primaryKey the primary key of this document categories
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_documentCategories.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the documentcategory ID of this document categories.
	*
	* @return the documentcategory ID of this document categories
	*/
	@Override
	public long getDocumentcategoryId() {
		return _documentCategories.getDocumentcategoryId();
	}

	/**
	* Sets the documentcategory ID of this document categories.
	*
	* @param documentcategoryId the documentcategory ID of this document categories
	*/
	@Override
	public void setDocumentcategoryId(long documentcategoryId) {
		_documentCategories.setDocumentcategoryId(documentcategoryId);
	}

	/**
	* Returns the company ID of this document categories.
	*
	* @return the company ID of this document categories
	*/
	@Override
	public long getCompanyId() {
		return _documentCategories.getCompanyId();
	}

	/**
	* Sets the company ID of this document categories.
	*
	* @param companyId the company ID of this document categories
	*/
	@Override
	public void setCompanyId(long companyId) {
		_documentCategories.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this document categories.
	*
	* @return the group ID of this document categories
	*/
	@Override
	public long getGroupId() {
		return _documentCategories.getGroupId();
	}

	/**
	* Sets the group ID of this document categories.
	*
	* @param groupId the group ID of this document categories
	*/
	@Override
	public void setGroupId(long groupId) {
		_documentCategories.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this document categories.
	*
	* @return the user ID of this document categories
	*/
	@Override
	public long getUserId() {
		return _documentCategories.getUserId();
	}

	/**
	* Sets the user ID of this document categories.
	*
	* @param userId the user ID of this document categories
	*/
	@Override
	public void setUserId(long userId) {
		_documentCategories.setUserId(userId);
	}

	/**
	* Returns the user uuid of this document categories.
	*
	* @return the user uuid of this document categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategories.getUserUuid();
	}

	/**
	* Sets the user uuid of this document categories.
	*
	* @param userUuid the user uuid of this document categories
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_documentCategories.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this document categories.
	*
	* @return the create date of this document categories
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _documentCategories.getCreateDate();
	}

	/**
	* Sets the create date of this document categories.
	*
	* @param createDate the create date of this document categories
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_documentCategories.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this document categories.
	*
	* @return the modified date of this document categories
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _documentCategories.getModifiedDate();
	}

	/**
	* Sets the modified date of this document categories.
	*
	* @param modifiedDate the modified date of this document categories
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_documentCategories.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the document category of this document categories.
	*
	* @return the document category of this document categories
	*/
	@Override
	public java.lang.String getDocumentCategory() {
		return _documentCategories.getDocumentCategory();
	}

	/**
	* Sets the document category of this document categories.
	*
	* @param documentCategory the document category of this document categories
	*/
	@Override
	public void setDocumentCategory(java.lang.String documentCategory) {
		_documentCategories.setDocumentCategory(documentCategory);
	}

	@Override
	public boolean isNew() {
		return _documentCategories.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_documentCategories.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _documentCategories.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentCategories.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _documentCategories.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _documentCategories.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_documentCategories.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _documentCategories.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_documentCategories.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_documentCategories.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_documentCategories.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentCategoriesWrapper((DocumentCategories)_documentCategories.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories) {
		return _documentCategories.compareTo(documentCategories);
	}

	@Override
	public int hashCode() {
		return _documentCategories.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.DocumentCategories> toCacheModel() {
		return _documentCategories.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories toEscapedModel() {
		return new DocumentCategoriesWrapper(_documentCategories.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories toUnescapedModel() {
		return new DocumentCategoriesWrapper(_documentCategories.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _documentCategories.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _documentCategories.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_documentCategories.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentCategoriesWrapper)) {
			return false;
		}

		DocumentCategoriesWrapper documentCategoriesWrapper = (DocumentCategoriesWrapper)obj;

		if (Validator.equals(_documentCategories,
					documentCategoriesWrapper._documentCategories)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DocumentCategories getWrappedDocumentCategories() {
		return _documentCategories;
	}

	@Override
	public DocumentCategories getWrappedModel() {
		return _documentCategories;
	}

	@Override
	public void resetOriginalValues() {
		_documentCategories.resetOriginalValues();
	}

	private DocumentCategories _documentCategories;
}