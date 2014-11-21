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
 * This class is a wrapper for {@link Language}.
 * </p>
 *
 * @author rknowsys
 * @see Language
 * @generated
 */
public class LanguageWrapper implements Language, ModelWrapper<Language> {
	public LanguageWrapper(Language language) {
		_language = language;
	}

	@Override
	public Class<?> getModelClass() {
		return Language.class;
	}

	@Override
	public String getModelClassName() {
		return Language.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("languageId", getLanguageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("languageName", getLanguageName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
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

		String languageName = (String)attributes.get("languageName");

		if (languageName != null) {
			setLanguageName(languageName);
		}
	}

	/**
	* Returns the primary key of this language.
	*
	* @return the primary key of this language
	*/
	@Override
	public long getPrimaryKey() {
		return _language.getPrimaryKey();
	}

	/**
	* Sets the primary key of this language.
	*
	* @param primaryKey the primary key of this language
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_language.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the language ID of this language.
	*
	* @return the language ID of this language
	*/
	@Override
	public long getLanguageId() {
		return _language.getLanguageId();
	}

	/**
	* Sets the language ID of this language.
	*
	* @param languageId the language ID of this language
	*/
	@Override
	public void setLanguageId(long languageId) {
		_language.setLanguageId(languageId);
	}

	/**
	* Returns the company ID of this language.
	*
	* @return the company ID of this language
	*/
	@Override
	public long getCompanyId() {
		return _language.getCompanyId();
	}

	/**
	* Sets the company ID of this language.
	*
	* @param companyId the company ID of this language
	*/
	@Override
	public void setCompanyId(long companyId) {
		_language.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this language.
	*
	* @return the group ID of this language
	*/
	@Override
	public long getGroupId() {
		return _language.getGroupId();
	}

	/**
	* Sets the group ID of this language.
	*
	* @param groupId the group ID of this language
	*/
	@Override
	public void setGroupId(long groupId) {
		_language.setGroupId(groupId);
	}

	/**
	* Returns the create date of this language.
	*
	* @return the create date of this language
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _language.getCreateDate();
	}

	/**
	* Sets the create date of this language.
	*
	* @param createDate the create date of this language
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_language.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this language.
	*
	* @return the modified date of this language
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _language.getModifiedDate();
	}

	/**
	* Sets the modified date of this language.
	*
	* @param modifiedDate the modified date of this language
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_language.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this language.
	*
	* @return the user ID of this language
	*/
	@Override
	public long getUserId() {
		return _language.getUserId();
	}

	/**
	* Sets the user ID of this language.
	*
	* @param userId the user ID of this language
	*/
	@Override
	public void setUserId(long userId) {
		_language.setUserId(userId);
	}

	/**
	* Returns the user uuid of this language.
	*
	* @return the user uuid of this language
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _language.getUserUuid();
	}

	/**
	* Sets the user uuid of this language.
	*
	* @param userUuid the user uuid of this language
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_language.setUserUuid(userUuid);
	}

	/**
	* Returns the language name of this language.
	*
	* @return the language name of this language
	*/
	@Override
	public java.lang.String getLanguageName() {
		return _language.getLanguageName();
	}

	/**
	* Sets the language name of this language.
	*
	* @param languageName the language name of this language
	*/
	@Override
	public void setLanguageName(java.lang.String languageName) {
		_language.setLanguageName(languageName);
	}

	@Override
	public boolean isNew() {
		return _language.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_language.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _language.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_language.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _language.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _language.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_language.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _language.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_language.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_language.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_language.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LanguageWrapper((Language)_language.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Language language) {
		return _language.compareTo(language);
	}

	@Override
	public int hashCode() {
		return _language.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Language> toCacheModel() {
		return _language.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Language toEscapedModel() {
		return new LanguageWrapper(_language.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Language toUnescapedModel() {
		return new LanguageWrapper(_language.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _language.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _language.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_language.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LanguageWrapper)) {
			return false;
		}

		LanguageWrapper languageWrapper = (LanguageWrapper)obj;

		if (Validator.equals(_language, languageWrapper._language)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Language getWrappedLanguage() {
		return _language;
	}

	@Override
	public Language getWrappedModel() {
		return _language;
	}

	@Override
	public void resetOriginalValues() {
		_language.resetOriginalValues();
	}

	private Language _language;
}