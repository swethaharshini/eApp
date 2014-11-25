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
 * This class is a wrapper for {@link EmpLanguage}.
 * </p>
 *
 * @author rknowsys
 * @see EmpLanguage
 * @generated
 */
public class EmpLanguageWrapper implements EmpLanguage,
	ModelWrapper<EmpLanguage> {
	public EmpLanguageWrapper(EmpLanguage empLanguage) {
		_empLanguage = empLanguage;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpLanguage.class;
	}

	@Override
	public String getModelClassName() {
		return EmpLanguage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empLanguageId", getEmpLanguageId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("languageId", getLanguageId());
		attributes.put("languageSkill", getLanguageSkill());
		attributes.put("languageFluency", getLanguageFluency());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empLanguageId = (Long)attributes.get("empLanguageId");

		if (empLanguageId != null) {
			setEmpLanguageId(empLanguageId);
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

		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String languageSkill = (String)attributes.get("languageSkill");

		if (languageSkill != null) {
			setLanguageSkill(languageSkill);
		}

		String languageFluency = (String)attributes.get("languageFluency");

		if (languageFluency != null) {
			setLanguageFluency(languageFluency);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this emp language.
	*
	* @return the primary key of this emp language
	*/
	@Override
	public long getPrimaryKey() {
		return _empLanguage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp language.
	*
	* @param primaryKey the primary key of this emp language
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empLanguage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp language ID of this emp language.
	*
	* @return the emp language ID of this emp language
	*/
	@Override
	public long getEmpLanguageId() {
		return _empLanguage.getEmpLanguageId();
	}

	/**
	* Sets the emp language ID of this emp language.
	*
	* @param empLanguageId the emp language ID of this emp language
	*/
	@Override
	public void setEmpLanguageId(long empLanguageId) {
		_empLanguage.setEmpLanguageId(empLanguageId);
	}

	/**
	* Returns the employee ID of this emp language.
	*
	* @return the employee ID of this emp language
	*/
	@Override
	public long getEmployeeId() {
		return _empLanguage.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp language.
	*
	* @param employeeId the employee ID of this emp language
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empLanguage.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp language.
	*
	* @return the group ID of this emp language
	*/
	@Override
	public long getGroupId() {
		return _empLanguage.getGroupId();
	}

	/**
	* Sets the group ID of this emp language.
	*
	* @param groupId the group ID of this emp language
	*/
	@Override
	public void setGroupId(long groupId) {
		_empLanguage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp language.
	*
	* @return the company ID of this emp language
	*/
	@Override
	public long getCompanyId() {
		return _empLanguage.getCompanyId();
	}

	/**
	* Sets the company ID of this emp language.
	*
	* @param companyId the company ID of this emp language
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empLanguage.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp language.
	*
	* @return the create date of this emp language
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empLanguage.getCreateDate();
	}

	/**
	* Sets the create date of this emp language.
	*
	* @param createDate the create date of this emp language
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empLanguage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp language.
	*
	* @return the modified date of this emp language
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empLanguage.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp language.
	*
	* @param modifiedDate the modified date of this emp language
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empLanguage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp language.
	*
	* @return the user ID of this emp language
	*/
	@Override
	public long getUserId() {
		return _empLanguage.getUserId();
	}

	/**
	* Sets the user ID of this emp language.
	*
	* @param userId the user ID of this emp language
	*/
	@Override
	public void setUserId(long userId) {
		_empLanguage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp language.
	*
	* @return the user uuid of this emp language
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguage.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp language.
	*
	* @param userUuid the user uuid of this emp language
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empLanguage.setUserUuid(userUuid);
	}

	/**
	* Returns the language ID of this emp language.
	*
	* @return the language ID of this emp language
	*/
	@Override
	public long getLanguageId() {
		return _empLanguage.getLanguageId();
	}

	/**
	* Sets the language ID of this emp language.
	*
	* @param languageId the language ID of this emp language
	*/
	@Override
	public void setLanguageId(long languageId) {
		_empLanguage.setLanguageId(languageId);
	}

	/**
	* Returns the language skill of this emp language.
	*
	* @return the language skill of this emp language
	*/
	@Override
	public java.lang.String getLanguageSkill() {
		return _empLanguage.getLanguageSkill();
	}

	/**
	* Sets the language skill of this emp language.
	*
	* @param languageSkill the language skill of this emp language
	*/
	@Override
	public void setLanguageSkill(java.lang.String languageSkill) {
		_empLanguage.setLanguageSkill(languageSkill);
	}

	/**
	* Returns the language fluency of this emp language.
	*
	* @return the language fluency of this emp language
	*/
	@Override
	public java.lang.String getLanguageFluency() {
		return _empLanguage.getLanguageFluency();
	}

	/**
	* Sets the language fluency of this emp language.
	*
	* @param languageFluency the language fluency of this emp language
	*/
	@Override
	public void setLanguageFluency(java.lang.String languageFluency) {
		_empLanguage.setLanguageFluency(languageFluency);
	}

	/**
	* Returns the comments of this emp language.
	*
	* @return the comments of this emp language
	*/
	@Override
	public java.lang.String getComments() {
		return _empLanguage.getComments();
	}

	/**
	* Sets the comments of this emp language.
	*
	* @param comments the comments of this emp language
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_empLanguage.setComments(comments);
	}

	@Override
	public boolean isNew() {
		return _empLanguage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empLanguage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empLanguage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empLanguage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empLanguage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empLanguage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empLanguage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empLanguage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empLanguage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empLanguage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empLanguage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpLanguageWrapper((EmpLanguage)_empLanguage.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpLanguage empLanguage) {
		return _empLanguage.compareTo(empLanguage);
	}

	@Override
	public int hashCode() {
		return _empLanguage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpLanguage> toCacheModel() {
		return _empLanguage.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage toEscapedModel() {
		return new EmpLanguageWrapper(_empLanguage.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage toUnescapedModel() {
		return new EmpLanguageWrapper(_empLanguage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empLanguage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empLanguage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empLanguage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpLanguageWrapper)) {
			return false;
		}

		EmpLanguageWrapper empLanguageWrapper = (EmpLanguageWrapper)obj;

		if (Validator.equals(_empLanguage, empLanguageWrapper._empLanguage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpLanguage getWrappedEmpLanguage() {
		return _empLanguage;
	}

	@Override
	public EmpLanguage getWrappedModel() {
		return _empLanguage;
	}

	@Override
	public void resetOriginalValues() {
		_empLanguage.resetOriginalValues();
	}

	private EmpLanguage _empLanguage;
}