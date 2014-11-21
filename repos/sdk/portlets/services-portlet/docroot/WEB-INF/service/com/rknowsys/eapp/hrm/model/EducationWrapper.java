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
 * This class is a wrapper for {@link Education}.
 * </p>
 *
 * @author rknowsys
 * @see Education
 * @generated
 */
public class EducationWrapper implements Education, ModelWrapper<Education> {
	public EducationWrapper(Education education) {
		_education = education;
	}

	@Override
	public Class<?> getModelClass() {
		return Education.class;
	}

	@Override
	public String getModelClassName() {
		return Education.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("educationId", getEducationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("eduLevel", getEduLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long educationId = (Long)attributes.get("educationId");

		if (educationId != null) {
			setEducationId(educationId);
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

		String eduLevel = (String)attributes.get("eduLevel");

		if (eduLevel != null) {
			setEduLevel(eduLevel);
		}
	}

	/**
	* Returns the primary key of this education.
	*
	* @return the primary key of this education
	*/
	@Override
	public long getPrimaryKey() {
		return _education.getPrimaryKey();
	}

	/**
	* Sets the primary key of this education.
	*
	* @param primaryKey the primary key of this education
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_education.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the education ID of this education.
	*
	* @return the education ID of this education
	*/
	@Override
	public long getEducationId() {
		return _education.getEducationId();
	}

	/**
	* Sets the education ID of this education.
	*
	* @param educationId the education ID of this education
	*/
	@Override
	public void setEducationId(long educationId) {
		_education.setEducationId(educationId);
	}

	/**
	* Returns the company ID of this education.
	*
	* @return the company ID of this education
	*/
	@Override
	public long getCompanyId() {
		return _education.getCompanyId();
	}

	/**
	* Sets the company ID of this education.
	*
	* @param companyId the company ID of this education
	*/
	@Override
	public void setCompanyId(long companyId) {
		_education.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this education.
	*
	* @return the group ID of this education
	*/
	@Override
	public long getGroupId() {
		return _education.getGroupId();
	}

	/**
	* Sets the group ID of this education.
	*
	* @param groupId the group ID of this education
	*/
	@Override
	public void setGroupId(long groupId) {
		_education.setGroupId(groupId);
	}

	/**
	* Returns the create date of this education.
	*
	* @return the create date of this education
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _education.getCreateDate();
	}

	/**
	* Sets the create date of this education.
	*
	* @param createDate the create date of this education
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_education.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this education.
	*
	* @return the modified date of this education
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _education.getModifiedDate();
	}

	/**
	* Sets the modified date of this education.
	*
	* @param modifiedDate the modified date of this education
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_education.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this education.
	*
	* @return the user ID of this education
	*/
	@Override
	public long getUserId() {
		return _education.getUserId();
	}

	/**
	* Sets the user ID of this education.
	*
	* @param userId the user ID of this education
	*/
	@Override
	public void setUserId(long userId) {
		_education.setUserId(userId);
	}

	/**
	* Returns the user uuid of this education.
	*
	* @return the user uuid of this education
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _education.getUserUuid();
	}

	/**
	* Sets the user uuid of this education.
	*
	* @param userUuid the user uuid of this education
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_education.setUserUuid(userUuid);
	}

	/**
	* Returns the edu level of this education.
	*
	* @return the edu level of this education
	*/
	@Override
	public java.lang.String getEduLevel() {
		return _education.getEduLevel();
	}

	/**
	* Sets the edu level of this education.
	*
	* @param eduLevel the edu level of this education
	*/
	@Override
	public void setEduLevel(java.lang.String eduLevel) {
		_education.setEduLevel(eduLevel);
	}

	@Override
	public boolean isNew() {
		return _education.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_education.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _education.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_education.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _education.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _education.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_education.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _education.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_education.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_education.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_education.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EducationWrapper((Education)_education.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Education education) {
		return _education.compareTo(education);
	}

	@Override
	public int hashCode() {
		return _education.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Education> toCacheModel() {
		return _education.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Education toEscapedModel() {
		return new EducationWrapper(_education.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Education toUnescapedModel() {
		return new EducationWrapper(_education.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _education.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _education.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_education.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EducationWrapper)) {
			return false;
		}

		EducationWrapper educationWrapper = (EducationWrapper)obj;

		if (Validator.equals(_education, educationWrapper._education)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Education getWrappedEducation() {
		return _education;
	}

	@Override
	public Education getWrappedModel() {
		return _education;
	}

	@Override
	public void resetOriginalValues() {
		_education.resetOriginalValues();
	}

	private Education _education;
}