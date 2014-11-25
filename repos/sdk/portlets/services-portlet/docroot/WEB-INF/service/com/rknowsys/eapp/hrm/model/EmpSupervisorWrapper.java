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
 * This class is a wrapper for {@link EmpSupervisor}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSupervisor
 * @generated
 */
public class EmpSupervisorWrapper implements EmpSupervisor,
	ModelWrapper<EmpSupervisor> {
	public EmpSupervisorWrapper(EmpSupervisor empSupervisor) {
		_empSupervisor = empSupervisor;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSupervisor.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSupervisor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSupervisorId", getEmpSupervisorId());
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
		Long empSupervisorId = (Long)attributes.get("empSupervisorId");

		if (empSupervisorId != null) {
			setEmpSupervisorId(empSupervisorId);
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
	* Returns the primary key of this EmpSupervisor.
	*
	* @return the primary key of this EmpSupervisor
	*/
	@Override
	public long getPrimaryKey() {
		return _empSupervisor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpSupervisor.
	*
	* @param primaryKey the primary key of this EmpSupervisor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empSupervisor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp supervisor ID of this EmpSupervisor.
	*
	* @return the emp supervisor ID of this EmpSupervisor
	*/
	@Override
	public long getEmpSupervisorId() {
		return _empSupervisor.getEmpSupervisorId();
	}

	/**
	* Sets the emp supervisor ID of this EmpSupervisor.
	*
	* @param empSupervisorId the emp supervisor ID of this EmpSupervisor
	*/
	@Override
	public void setEmpSupervisorId(long empSupervisorId) {
		_empSupervisor.setEmpSupervisorId(empSupervisorId);
	}

	/**
	* Returns the employee ID of this EmpSupervisor.
	*
	* @return the employee ID of this EmpSupervisor
	*/
	@Override
	public long getEmployeeId() {
		return _empSupervisor.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpSupervisor.
	*
	* @param employeeId the employee ID of this EmpSupervisor
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empSupervisor.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpSupervisor.
	*
	* @return the group ID of this EmpSupervisor
	*/
	@Override
	public long getGroupId() {
		return _empSupervisor.getGroupId();
	}

	/**
	* Sets the group ID of this EmpSupervisor.
	*
	* @param groupId the group ID of this EmpSupervisor
	*/
	@Override
	public void setGroupId(long groupId) {
		_empSupervisor.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpSupervisor.
	*
	* @return the company ID of this EmpSupervisor
	*/
	@Override
	public long getCompanyId() {
		return _empSupervisor.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpSupervisor.
	*
	* @param companyId the company ID of this EmpSupervisor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empSupervisor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpSupervisor.
	*
	* @return the user ID of this EmpSupervisor
	*/
	@Override
	public long getUserId() {
		return _empSupervisor.getUserId();
	}

	/**
	* Sets the user ID of this EmpSupervisor.
	*
	* @param userId the user ID of this EmpSupervisor
	*/
	@Override
	public void setUserId(long userId) {
		_empSupervisor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpSupervisor.
	*
	* @return the user uuid of this EmpSupervisor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisor.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpSupervisor.
	*
	* @param userUuid the user uuid of this EmpSupervisor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empSupervisor.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpSupervisor.
	*
	* @return the create date of this EmpSupervisor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empSupervisor.getCreateDate();
	}

	/**
	* Sets the create date of this EmpSupervisor.
	*
	* @param createDate the create date of this EmpSupervisor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empSupervisor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpSupervisor.
	*
	* @return the modified date of this EmpSupervisor
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empSupervisor.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpSupervisor.
	*
	* @param modifiedDate the modified date of this EmpSupervisor
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empSupervisor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the reporter employee ID of this EmpSupervisor.
	*
	* @return the reporter employee ID of this EmpSupervisor
	*/
	@Override
	public long getReporterEmployeeId() {
		return _empSupervisor.getReporterEmployeeId();
	}

	/**
	* Sets the reporter employee ID of this EmpSupervisor.
	*
	* @param reporterEmployeeId the reporter employee ID of this EmpSupervisor
	*/
	@Override
	public void setReporterEmployeeId(long reporterEmployeeId) {
		_empSupervisor.setReporterEmployeeId(reporterEmployeeId);
	}

	/**
	* Returns the reporting method of this EmpSupervisor.
	*
	* @return the reporting method of this EmpSupervisor
	*/
	@Override
	public long getReportingMethod() {
		return _empSupervisor.getReportingMethod();
	}

	/**
	* Sets the reporting method of this EmpSupervisor.
	*
	* @param reportingMethod the reporting method of this EmpSupervisor
	*/
	@Override
	public void setReportingMethod(long reportingMethod) {
		_empSupervisor.setReportingMethod(reportingMethod);
	}

	@Override
	public boolean isNew() {
		return _empSupervisor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empSupervisor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empSupervisor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empSupervisor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empSupervisor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empSupervisor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empSupervisor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empSupervisor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empSupervisor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empSupervisor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empSupervisor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpSupervisorWrapper((EmpSupervisor)_empSupervisor.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor) {
		return _empSupervisor.compareTo(empSupervisor);
	}

	@Override
	public int hashCode() {
		return _empSupervisor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpSupervisor> toCacheModel() {
		return _empSupervisor.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor toEscapedModel() {
		return new EmpSupervisorWrapper(_empSupervisor.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor toUnescapedModel() {
		return new EmpSupervisorWrapper(_empSupervisor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empSupervisor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empSupervisor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empSupervisor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpSupervisorWrapper)) {
			return false;
		}

		EmpSupervisorWrapper empSupervisorWrapper = (EmpSupervisorWrapper)obj;

		if (Validator.equals(_empSupervisor, empSupervisorWrapper._empSupervisor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpSupervisor getWrappedEmpSupervisor() {
		return _empSupervisor;
	}

	@Override
	public EmpSupervisor getWrappedModel() {
		return _empSupervisor;
	}

	@Override
	public void resetOriginalValues() {
		_empSupervisor.resetOriginalValues();
	}

	private EmpSupervisor _empSupervisor;
}