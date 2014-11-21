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
 * This class is a wrapper for {@link EmpPersonalDetails}.
 * </p>
 *
 * @author rknowsys
 * @see EmpPersonalDetails
 * @generated
 */
public class EmpPersonalDetailsWrapper implements EmpPersonalDetails,
	ModelWrapper<EmpPersonalDetails> {
	public EmpPersonalDetailsWrapper(EmpPersonalDetails empPersonalDetails) {
		_empPersonalDetails = empPersonalDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpPersonalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpPersonalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empPersonalDetailsId", getEmpPersonalDetailsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("otherId", getOtherId());
		attributes.put("licenseNo", getLicenseNo());
		attributes.put("licenseExpDate", getLicenseExpDate());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("dateOfBirth", getDateOfBirth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empPersonalDetailsId = (Long)attributes.get("empPersonalDetailsId");

		if (empPersonalDetailsId != null) {
			setEmpPersonalDetailsId(empPersonalDetailsId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
		}

		String otherId = (String)attributes.get("otherId");

		if (otherId != null) {
			setOtherId(otherId);
		}

		String licenseNo = (String)attributes.get("licenseNo");

		if (licenseNo != null) {
			setLicenseNo(licenseNo);
		}

		Date licenseExpDate = (Date)attributes.get("licenseExpDate");

		if (licenseExpDate != null) {
			setLicenseExpDate(licenseExpDate);
		}

		Long gender = (Long)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long maritalStatus = (Long)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}
	}

	/**
	* Returns the primary key of this EmpPersonalDetails.
	*
	* @return the primary key of this EmpPersonalDetails
	*/
	@Override
	public long getPrimaryKey() {
		return _empPersonalDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpPersonalDetails.
	*
	* @param primaryKey the primary key of this EmpPersonalDetails
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empPersonalDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp personal details ID of this EmpPersonalDetails.
	*
	* @return the emp personal details ID of this EmpPersonalDetails
	*/
	@Override
	public long getEmpPersonalDetailsId() {
		return _empPersonalDetails.getEmpPersonalDetailsId();
	}

	/**
	* Sets the emp personal details ID of this EmpPersonalDetails.
	*
	* @param empPersonalDetailsId the emp personal details ID of this EmpPersonalDetails
	*/
	@Override
	public void setEmpPersonalDetailsId(long empPersonalDetailsId) {
		_empPersonalDetails.setEmpPersonalDetailsId(empPersonalDetailsId);
	}

	/**
	* Returns the employee ID of this EmpPersonalDetails.
	*
	* @return the employee ID of this EmpPersonalDetails
	*/
	@Override
	public long getEmployeeId() {
		return _empPersonalDetails.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpPersonalDetails.
	*
	* @param employeeId the employee ID of this EmpPersonalDetails
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empPersonalDetails.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpPersonalDetails.
	*
	* @return the group ID of this EmpPersonalDetails
	*/
	@Override
	public long getGroupId() {
		return _empPersonalDetails.getGroupId();
	}

	/**
	* Sets the group ID of this EmpPersonalDetails.
	*
	* @param groupId the group ID of this EmpPersonalDetails
	*/
	@Override
	public void setGroupId(long groupId) {
		_empPersonalDetails.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpPersonalDetails.
	*
	* @return the company ID of this EmpPersonalDetails
	*/
	@Override
	public long getCompanyId() {
		return _empPersonalDetails.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpPersonalDetails.
	*
	* @param companyId the company ID of this EmpPersonalDetails
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empPersonalDetails.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpPersonalDetails.
	*
	* @return the user ID of this EmpPersonalDetails
	*/
	@Override
	public long getUserId() {
		return _empPersonalDetails.getUserId();
	}

	/**
	* Sets the user ID of this EmpPersonalDetails.
	*
	* @param userId the user ID of this EmpPersonalDetails
	*/
	@Override
	public void setUserId(long userId) {
		_empPersonalDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpPersonalDetails.
	*
	* @return the user uuid of this EmpPersonalDetails
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empPersonalDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpPersonalDetails.
	*
	* @param userUuid the user uuid of this EmpPersonalDetails
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empPersonalDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpPersonalDetails.
	*
	* @return the create date of this EmpPersonalDetails
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empPersonalDetails.getCreateDate();
	}

	/**
	* Sets the create date of this EmpPersonalDetails.
	*
	* @param createDate the create date of this EmpPersonalDetails
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empPersonalDetails.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpPersonalDetails.
	*
	* @return the modified date of this EmpPersonalDetails
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empPersonalDetails.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpPersonalDetails.
	*
	* @param modifiedDate the modified date of this EmpPersonalDetails
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empPersonalDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the first name of this EmpPersonalDetails.
	*
	* @return the first name of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getFirstName() {
		return _empPersonalDetails.getFirstName();
	}

	/**
	* Sets the first name of this EmpPersonalDetails.
	*
	* @param firstName the first name of this EmpPersonalDetails
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_empPersonalDetails.setFirstName(firstName);
	}

	/**
	* Returns the last name of this EmpPersonalDetails.
	*
	* @return the last name of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getLastName() {
		return _empPersonalDetails.getLastName();
	}

	/**
	* Sets the last name of this EmpPersonalDetails.
	*
	* @param lastName the last name of this EmpPersonalDetails
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_empPersonalDetails.setLastName(lastName);
	}

	/**
	* Returns the middle name of this EmpPersonalDetails.
	*
	* @return the middle name of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _empPersonalDetails.getMiddleName();
	}

	/**
	* Sets the middle name of this EmpPersonalDetails.
	*
	* @param middleName the middle name of this EmpPersonalDetails
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_empPersonalDetails.setMiddleName(middleName);
	}

	/**
	* Returns the employee no of this EmpPersonalDetails.
	*
	* @return the employee no of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getEmployeeNo() {
		return _empPersonalDetails.getEmployeeNo();
	}

	/**
	* Sets the employee no of this EmpPersonalDetails.
	*
	* @param employeeNo the employee no of this EmpPersonalDetails
	*/
	@Override
	public void setEmployeeNo(java.lang.String employeeNo) {
		_empPersonalDetails.setEmployeeNo(employeeNo);
	}

	/**
	* Returns the other ID of this EmpPersonalDetails.
	*
	* @return the other ID of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getOtherId() {
		return _empPersonalDetails.getOtherId();
	}

	/**
	* Sets the other ID of this EmpPersonalDetails.
	*
	* @param otherId the other ID of this EmpPersonalDetails
	*/
	@Override
	public void setOtherId(java.lang.String otherId) {
		_empPersonalDetails.setOtherId(otherId);
	}

	/**
	* Returns the license no of this EmpPersonalDetails.
	*
	* @return the license no of this EmpPersonalDetails
	*/
	@Override
	public java.lang.String getLicenseNo() {
		return _empPersonalDetails.getLicenseNo();
	}

	/**
	* Sets the license no of this EmpPersonalDetails.
	*
	* @param licenseNo the license no of this EmpPersonalDetails
	*/
	@Override
	public void setLicenseNo(java.lang.String licenseNo) {
		_empPersonalDetails.setLicenseNo(licenseNo);
	}

	/**
	* Returns the license exp date of this EmpPersonalDetails.
	*
	* @return the license exp date of this EmpPersonalDetails
	*/
	@Override
	public java.util.Date getLicenseExpDate() {
		return _empPersonalDetails.getLicenseExpDate();
	}

	/**
	* Sets the license exp date of this EmpPersonalDetails.
	*
	* @param licenseExpDate the license exp date of this EmpPersonalDetails
	*/
	@Override
	public void setLicenseExpDate(java.util.Date licenseExpDate) {
		_empPersonalDetails.setLicenseExpDate(licenseExpDate);
	}

	/**
	* Returns the gender of this EmpPersonalDetails.
	*
	* @return the gender of this EmpPersonalDetails
	*/
	@Override
	public long getGender() {
		return _empPersonalDetails.getGender();
	}

	/**
	* Sets the gender of this EmpPersonalDetails.
	*
	* @param gender the gender of this EmpPersonalDetails
	*/
	@Override
	public void setGender(long gender) {
		_empPersonalDetails.setGender(gender);
	}

	/**
	* Returns the marital status of this EmpPersonalDetails.
	*
	* @return the marital status of this EmpPersonalDetails
	*/
	@Override
	public long getMaritalStatus() {
		return _empPersonalDetails.getMaritalStatus();
	}

	/**
	* Sets the marital status of this EmpPersonalDetails.
	*
	* @param maritalStatus the marital status of this EmpPersonalDetails
	*/
	@Override
	public void setMaritalStatus(long maritalStatus) {
		_empPersonalDetails.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the nationality ID of this EmpPersonalDetails.
	*
	* @return the nationality ID of this EmpPersonalDetails
	*/
	@Override
	public long getNationalityId() {
		return _empPersonalDetails.getNationalityId();
	}

	/**
	* Sets the nationality ID of this EmpPersonalDetails.
	*
	* @param nationalityId the nationality ID of this EmpPersonalDetails
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_empPersonalDetails.setNationalityId(nationalityId);
	}

	/**
	* Returns the date of birth of this EmpPersonalDetails.
	*
	* @return the date of birth of this EmpPersonalDetails
	*/
	@Override
	public java.util.Date getDateOfBirth() {
		return _empPersonalDetails.getDateOfBirth();
	}

	/**
	* Sets the date of birth of this EmpPersonalDetails.
	*
	* @param dateOfBirth the date of birth of this EmpPersonalDetails
	*/
	@Override
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		_empPersonalDetails.setDateOfBirth(dateOfBirth);
	}

	@Override
	public boolean isNew() {
		return _empPersonalDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empPersonalDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empPersonalDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empPersonalDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empPersonalDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empPersonalDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empPersonalDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empPersonalDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empPersonalDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empPersonalDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empPersonalDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpPersonalDetailsWrapper((EmpPersonalDetails)_empPersonalDetails.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpPersonalDetails empPersonalDetails) {
		return _empPersonalDetails.compareTo(empPersonalDetails);
	}

	@Override
	public int hashCode() {
		return _empPersonalDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> toCacheModel() {
		return _empPersonalDetails.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails toEscapedModel() {
		return new EmpPersonalDetailsWrapper(_empPersonalDetails.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails toUnescapedModel() {
		return new EmpPersonalDetailsWrapper(_empPersonalDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empPersonalDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empPersonalDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empPersonalDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpPersonalDetailsWrapper)) {
			return false;
		}

		EmpPersonalDetailsWrapper empPersonalDetailsWrapper = (EmpPersonalDetailsWrapper)obj;

		if (Validator.equals(_empPersonalDetails,
					empPersonalDetailsWrapper._empPersonalDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpPersonalDetails getWrappedEmpPersonalDetails() {
		return _empPersonalDetails;
	}

	@Override
	public EmpPersonalDetails getWrappedModel() {
		return _empPersonalDetails;
	}

	@Override
	public void resetOriginalValues() {
		_empPersonalDetails.resetOriginalValues();
	}

	private EmpPersonalDetails _empPersonalDetails;
}