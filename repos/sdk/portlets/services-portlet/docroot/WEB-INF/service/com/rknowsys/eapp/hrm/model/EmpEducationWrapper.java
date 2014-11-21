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
 * This class is a wrapper for {@link EmpEducation}.
 * </p>
 *
 * @author rknowsys
 * @see EmpEducation
 * @generated
 */
public class EmpEducationWrapper implements EmpEducation,
	ModelWrapper<EmpEducation> {
	public EmpEducationWrapper(EmpEducation empEducation) {
		_empEducation = empEducation;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpEducation.class;
	}

	@Override
	public String getModelClassName() {
		return EmpEducation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empEducationId", getEmpEducationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("educationId", getEducationId());
		attributes.put("institute", getInstitute());
		attributes.put("major", getMajor());
		attributes.put("year", getYear());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empEducationId = (Long)attributes.get("empEducationId");

		if (empEducationId != null) {
			setEmpEducationId(empEducationId);
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

		Long educationId = (Long)attributes.get("educationId");

		if (educationId != null) {
			setEducationId(educationId);
		}

		String institute = (String)attributes.get("institute");

		if (institute != null) {
			setInstitute(institute);
		}

		String major = (String)attributes.get("major");

		if (major != null) {
			setMajor(major);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this emp education.
	*
	* @return the primary key of this emp education
	*/
	@Override
	public long getPrimaryKey() {
		return _empEducation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp education.
	*
	* @param primaryKey the primary key of this emp education
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empEducation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp education ID of this emp education.
	*
	* @return the emp education ID of this emp education
	*/
	@Override
	public long getEmpEducationId() {
		return _empEducation.getEmpEducationId();
	}

	/**
	* Sets the emp education ID of this emp education.
	*
	* @param empEducationId the emp education ID of this emp education
	*/
	@Override
	public void setEmpEducationId(long empEducationId) {
		_empEducation.setEmpEducationId(empEducationId);
	}

	/**
	* Returns the employee ID of this emp education.
	*
	* @return the employee ID of this emp education
	*/
	@Override
	public long getEmployeeId() {
		return _empEducation.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp education.
	*
	* @param employeeId the employee ID of this emp education
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empEducation.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp education.
	*
	* @return the group ID of this emp education
	*/
	@Override
	public long getGroupId() {
		return _empEducation.getGroupId();
	}

	/**
	* Sets the group ID of this emp education.
	*
	* @param groupId the group ID of this emp education
	*/
	@Override
	public void setGroupId(long groupId) {
		_empEducation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp education.
	*
	* @return the company ID of this emp education
	*/
	@Override
	public long getCompanyId() {
		return _empEducation.getCompanyId();
	}

	/**
	* Sets the company ID of this emp education.
	*
	* @param companyId the company ID of this emp education
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empEducation.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp education.
	*
	* @return the create date of this emp education
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empEducation.getCreateDate();
	}

	/**
	* Sets the create date of this emp education.
	*
	* @param createDate the create date of this emp education
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empEducation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp education.
	*
	* @return the modified date of this emp education
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empEducation.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp education.
	*
	* @param modifiedDate the modified date of this emp education
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empEducation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp education.
	*
	* @return the user ID of this emp education
	*/
	@Override
	public long getUserId() {
		return _empEducation.getUserId();
	}

	/**
	* Sets the user ID of this emp education.
	*
	* @param userId the user ID of this emp education
	*/
	@Override
	public void setUserId(long userId) {
		_empEducation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp education.
	*
	* @return the user uuid of this emp education
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empEducation.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp education.
	*
	* @param userUuid the user uuid of this emp education
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empEducation.setUserUuid(userUuid);
	}

	/**
	* Returns the education ID of this emp education.
	*
	* @return the education ID of this emp education
	*/
	@Override
	public long getEducationId() {
		return _empEducation.getEducationId();
	}

	/**
	* Sets the education ID of this emp education.
	*
	* @param educationId the education ID of this emp education
	*/
	@Override
	public void setEducationId(long educationId) {
		_empEducation.setEducationId(educationId);
	}

	/**
	* Returns the institute of this emp education.
	*
	* @return the institute of this emp education
	*/
	@Override
	public java.lang.String getInstitute() {
		return _empEducation.getInstitute();
	}

	/**
	* Sets the institute of this emp education.
	*
	* @param institute the institute of this emp education
	*/
	@Override
	public void setInstitute(java.lang.String institute) {
		_empEducation.setInstitute(institute);
	}

	/**
	* Returns the major of this emp education.
	*
	* @return the major of this emp education
	*/
	@Override
	public java.lang.String getMajor() {
		return _empEducation.getMajor();
	}

	/**
	* Sets the major of this emp education.
	*
	* @param major the major of this emp education
	*/
	@Override
	public void setMajor(java.lang.String major) {
		_empEducation.setMajor(major);
	}

	/**
	* Returns the year of this emp education.
	*
	* @return the year of this emp education
	*/
	@Override
	public java.lang.String getYear() {
		return _empEducation.getYear();
	}

	/**
	* Sets the year of this emp education.
	*
	* @param year the year of this emp education
	*/
	@Override
	public void setYear(java.lang.String year) {
		_empEducation.setYear(year);
	}

	/**
	* Returns the start date of this emp education.
	*
	* @return the start date of this emp education
	*/
	@Override
	public java.util.Date getStartDate() {
		return _empEducation.getStartDate();
	}

	/**
	* Sets the start date of this emp education.
	*
	* @param startDate the start date of this emp education
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_empEducation.setStartDate(startDate);
	}

	/**
	* Returns the end date of this emp education.
	*
	* @return the end date of this emp education
	*/
	@Override
	public java.util.Date getEndDate() {
		return _empEducation.getEndDate();
	}

	/**
	* Sets the end date of this emp education.
	*
	* @param endDate the end date of this emp education
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_empEducation.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _empEducation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empEducation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empEducation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empEducation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empEducation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empEducation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empEducation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empEducation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empEducation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empEducation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empEducation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpEducationWrapper((EmpEducation)_empEducation.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpEducation empEducation) {
		return _empEducation.compareTo(empEducation);
	}

	@Override
	public int hashCode() {
		return _empEducation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpEducation> toCacheModel() {
		return _empEducation.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpEducation toEscapedModel() {
		return new EmpEducationWrapper(_empEducation.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpEducation toUnescapedModel() {
		return new EmpEducationWrapper(_empEducation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empEducation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empEducation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empEducation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpEducationWrapper)) {
			return false;
		}

		EmpEducationWrapper empEducationWrapper = (EmpEducationWrapper)obj;

		if (Validator.equals(_empEducation, empEducationWrapper._empEducation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpEducation getWrappedEmpEducation() {
		return _empEducation;
	}

	@Override
	public EmpEducation getWrappedModel() {
		return _empEducation;
	}

	@Override
	public void resetOriginalValues() {
		_empEducation.resetOriginalValues();
	}

	private EmpEducation _empEducation;
}