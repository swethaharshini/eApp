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
 * This class is a wrapper for {@link EmpLicense}.
 * </p>
 *
 * @author rknowsys
 * @see EmpLicense
 * @generated
 */
public class EmpLicenseWrapper implements EmpLicense, ModelWrapper<EmpLicense> {
	public EmpLicenseWrapper(EmpLicense empLicense) {
		_empLicense = empLicense;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpLicense.class;
	}

	@Override
	public String getModelClassName() {
		return EmpLicense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empLicenseId", getEmpLicenseId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("licenseId", getLicenseId());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("expiryDate", getExpiryDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empLicenseId = (Long)attributes.get("empLicenseId");

		if (empLicenseId != null) {
			setEmpLicenseId(empLicenseId);
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

		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}
	}

	/**
	* Returns the primary key of this emp license.
	*
	* @return the primary key of this emp license
	*/
	@Override
	public long getPrimaryKey() {
		return _empLicense.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp license.
	*
	* @param primaryKey the primary key of this emp license
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empLicense.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp license ID of this emp license.
	*
	* @return the emp license ID of this emp license
	*/
	@Override
	public long getEmpLicenseId() {
		return _empLicense.getEmpLicenseId();
	}

	/**
	* Sets the emp license ID of this emp license.
	*
	* @param empLicenseId the emp license ID of this emp license
	*/
	@Override
	public void setEmpLicenseId(long empLicenseId) {
		_empLicense.setEmpLicenseId(empLicenseId);
	}

	/**
	* Returns the employee ID of this emp license.
	*
	* @return the employee ID of this emp license
	*/
	@Override
	public long getEmployeeId() {
		return _empLicense.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp license.
	*
	* @param employeeId the employee ID of this emp license
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empLicense.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp license.
	*
	* @return the group ID of this emp license
	*/
	@Override
	public long getGroupId() {
		return _empLicense.getGroupId();
	}

	/**
	* Sets the group ID of this emp license.
	*
	* @param groupId the group ID of this emp license
	*/
	@Override
	public void setGroupId(long groupId) {
		_empLicense.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp license.
	*
	* @return the company ID of this emp license
	*/
	@Override
	public long getCompanyId() {
		return _empLicense.getCompanyId();
	}

	/**
	* Sets the company ID of this emp license.
	*
	* @param companyId the company ID of this emp license
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empLicense.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp license.
	*
	* @return the create date of this emp license
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empLicense.getCreateDate();
	}

	/**
	* Sets the create date of this emp license.
	*
	* @param createDate the create date of this emp license
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empLicense.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp license.
	*
	* @return the modified date of this emp license
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empLicense.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp license.
	*
	* @param modifiedDate the modified date of this emp license
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empLicense.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp license.
	*
	* @return the user ID of this emp license
	*/
	@Override
	public long getUserId() {
		return _empLicense.getUserId();
	}

	/**
	* Sets the user ID of this emp license.
	*
	* @param userId the user ID of this emp license
	*/
	@Override
	public void setUserId(long userId) {
		_empLicense.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp license.
	*
	* @return the user uuid of this emp license
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLicense.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp license.
	*
	* @param userUuid the user uuid of this emp license
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empLicense.setUserUuid(userUuid);
	}

	/**
	* Returns the license ID of this emp license.
	*
	* @return the license ID of this emp license
	*/
	@Override
	public long getLicenseId() {
		return _empLicense.getLicenseId();
	}

	/**
	* Sets the license ID of this emp license.
	*
	* @param licenseId the license ID of this emp license
	*/
	@Override
	public void setLicenseId(long licenseId) {
		_empLicense.setLicenseId(licenseId);
	}

	/**
	* Returns the license number of this emp license.
	*
	* @return the license number of this emp license
	*/
	@Override
	public java.lang.String getLicenseNumber() {
		return _empLicense.getLicenseNumber();
	}

	/**
	* Sets the license number of this emp license.
	*
	* @param licenseNumber the license number of this emp license
	*/
	@Override
	public void setLicenseNumber(java.lang.String licenseNumber) {
		_empLicense.setLicenseNumber(licenseNumber);
	}

	/**
	* Returns the issued date of this emp license.
	*
	* @return the issued date of this emp license
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _empLicense.getIssuedDate();
	}

	/**
	* Sets the issued date of this emp license.
	*
	* @param issuedDate the issued date of this emp license
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_empLicense.setIssuedDate(issuedDate);
	}

	/**
	* Returns the expiry date of this emp license.
	*
	* @return the expiry date of this emp license
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _empLicense.getExpiryDate();
	}

	/**
	* Sets the expiry date of this emp license.
	*
	* @param expiryDate the expiry date of this emp license
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_empLicense.setExpiryDate(expiryDate);
	}

	@Override
	public boolean isNew() {
		return _empLicense.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empLicense.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empLicense.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empLicense.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empLicense.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empLicense.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empLicense.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empLicense.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empLicense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empLicense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empLicense.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpLicenseWrapper((EmpLicense)_empLicense.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpLicense empLicense) {
		return _empLicense.compareTo(empLicense);
	}

	@Override
	public int hashCode() {
		return _empLicense.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpLicense> toCacheModel() {
		return _empLicense.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpLicense toEscapedModel() {
		return new EmpLicenseWrapper(_empLicense.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpLicense toUnescapedModel() {
		return new EmpLicenseWrapper(_empLicense.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empLicense.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empLicense.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empLicense.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpLicenseWrapper)) {
			return false;
		}

		EmpLicenseWrapper empLicenseWrapper = (EmpLicenseWrapper)obj;

		if (Validator.equals(_empLicense, empLicenseWrapper._empLicense)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpLicense getWrappedEmpLicense() {
		return _empLicense;
	}

	@Override
	public EmpLicense getWrappedModel() {
		return _empLicense;
	}

	@Override
	public void resetOriginalValues() {
		_empLicense.resetOriginalValues();
	}

	private EmpLicense _empLicense;
}