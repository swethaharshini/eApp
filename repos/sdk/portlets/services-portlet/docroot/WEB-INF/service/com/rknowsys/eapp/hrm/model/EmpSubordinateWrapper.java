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
 * This class is a wrapper for {@link EmpSubordinate}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSubordinate
 * @generated
 */
public class EmpSubordinateWrapper implements EmpSubordinate,
	ModelWrapper<EmpSubordinate> {
	public EmpSubordinateWrapper(EmpSubordinate empSubordinate) {
		_empSubordinate = empSubordinate;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSubordinate.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSubordinate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSubordinateId", getEmpSubordinateId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reporterEmployeeId", getReporterEmployeeId());
		attributes.put("reportingMethod", getReportingMethod());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSubordinateId = (Long)attributes.get("empSubordinateId");

		if (empSubordinateId != null) {
			setEmpSubordinateId(empSubordinateId);
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

		Long reporterEmployeeId = (Long)attributes.get("reporterEmployeeId");

		if (reporterEmployeeId != null) {
			setReporterEmployeeId(reporterEmployeeId);
		}

		Long reportingMethod = (Long)attributes.get("reportingMethod");

		if (reportingMethod != null) {
			setReportingMethod(reportingMethod);
		}
	}

	/**
	* Returns the primary key of this EmpSubordinate.
	*
	* @return the primary key of this EmpSubordinate
	*/
	@Override
	public long getPrimaryKey() {
		return _empSubordinate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpSubordinate.
	*
	* @param primaryKey the primary key of this EmpSubordinate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empSubordinate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp subordinate ID of this EmpSubordinate.
	*
	* @return the emp subordinate ID of this EmpSubordinate
	*/
	@Override
	public long getEmpSubordinateId() {
		return _empSubordinate.getEmpSubordinateId();
	}

	/**
	* Sets the emp subordinate ID of this EmpSubordinate.
	*
	* @param empSubordinateId the emp subordinate ID of this EmpSubordinate
	*/
	@Override
	public void setEmpSubordinateId(long empSubordinateId) {
		_empSubordinate.setEmpSubordinateId(empSubordinateId);
	}

	/**
	* Returns the employee ID of this EmpSubordinate.
	*
	* @return the employee ID of this EmpSubordinate
	*/
	@Override
	public long getEmployeeId() {
		return _empSubordinate.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpSubordinate.
	*
	* @param employeeId the employee ID of this EmpSubordinate
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empSubordinate.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpSubordinate.
	*
	* @return the group ID of this EmpSubordinate
	*/
	@Override
	public long getGroupId() {
		return _empSubordinate.getGroupId();
	}

	/**
	* Sets the group ID of this EmpSubordinate.
	*
	* @param groupId the group ID of this EmpSubordinate
	*/
	@Override
	public void setGroupId(long groupId) {
		_empSubordinate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpSubordinate.
	*
	* @return the company ID of this EmpSubordinate
	*/
	@Override
	public long getCompanyId() {
		return _empSubordinate.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpSubordinate.
	*
	* @param companyId the company ID of this EmpSubordinate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empSubordinate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpSubordinate.
	*
	* @return the user ID of this EmpSubordinate
	*/
	@Override
	public long getUserId() {
		return _empSubordinate.getUserId();
	}

	/**
	* Sets the user ID of this EmpSubordinate.
	*
	* @param userId the user ID of this EmpSubordinate
	*/
	@Override
	public void setUserId(long userId) {
		_empSubordinate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpSubordinate.
	*
	* @return the user uuid of this EmpSubordinate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinate.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpSubordinate.
	*
	* @param userUuid the user uuid of this EmpSubordinate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empSubordinate.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpSubordinate.
	*
	* @return the create date of this EmpSubordinate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empSubordinate.getCreateDate();
	}

	/**
	* Sets the create date of this EmpSubordinate.
	*
	* @param createDate the create date of this EmpSubordinate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empSubordinate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpSubordinate.
	*
	* @return the modified date of this EmpSubordinate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empSubordinate.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpSubordinate.
	*
	* @param modifiedDate the modified date of this EmpSubordinate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empSubordinate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the reporter employee ID of this EmpSubordinate.
	*
	* @return the reporter employee ID of this EmpSubordinate
	*/
	@Override
	public long getReporterEmployeeId() {
		return _empSubordinate.getReporterEmployeeId();
	}

	/**
	* Sets the reporter employee ID of this EmpSubordinate.
	*
	* @param reporterEmployeeId the reporter employee ID of this EmpSubordinate
	*/
	@Override
	public void setReporterEmployeeId(long reporterEmployeeId) {
		_empSubordinate.setReporterEmployeeId(reporterEmployeeId);
	}

	/**
	* Returns the reporting method of this EmpSubordinate.
	*
	* @return the reporting method of this EmpSubordinate
	*/
	@Override
	public long getReportingMethod() {
		return _empSubordinate.getReportingMethod();
	}

	/**
	* Sets the reporting method of this EmpSubordinate.
	*
	* @param reportingMethod the reporting method of this EmpSubordinate
	*/
	@Override
	public void setReportingMethod(long reportingMethod) {
		_empSubordinate.setReportingMethod(reportingMethod);
	}

	@Override
	public boolean isNew() {
		return _empSubordinate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empSubordinate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empSubordinate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empSubordinate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empSubordinate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empSubordinate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empSubordinate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empSubordinate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empSubordinate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empSubordinate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empSubordinate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpSubordinateWrapper((EmpSubordinate)_empSubordinate.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate) {
		return _empSubordinate.compareTo(empSubordinate);
	}

	@Override
	public int hashCode() {
		return _empSubordinate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpSubordinate> toCacheModel() {
		return _empSubordinate.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate toEscapedModel() {
		return new EmpSubordinateWrapper(_empSubordinate.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate toUnescapedModel() {
		return new EmpSubordinateWrapper(_empSubordinate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empSubordinate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empSubordinate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empSubordinate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpSubordinateWrapper)) {
			return false;
		}

		EmpSubordinateWrapper empSubordinateWrapper = (EmpSubordinateWrapper)obj;

		if (Validator.equals(_empSubordinate,
					empSubordinateWrapper._empSubordinate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpSubordinate getWrappedEmpSubordinate() {
		return _empSubordinate;
	}

	@Override
	public EmpSubordinate getWrappedModel() {
		return _empSubordinate;
	}

	@Override
	public void resetOriginalValues() {
		_empSubordinate.resetOriginalValues();
	}

	private EmpSubordinate _empSubordinate;
}