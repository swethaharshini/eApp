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
 * This class is a wrapper for {@link EmpDependent}.
 * </p>
 *
 * @author rknowsys
 * @see EmpDependent
 * @generated
 */
public class EmpDependentWrapper implements EmpDependent,
	ModelWrapper<EmpDependent> {
	public EmpDependentWrapper(EmpDependent empDependent) {
		_empDependent = empDependent;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDependent.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDependent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empDependentId", getEmpDependentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("relationship", getRelationship());
		attributes.put("dateOfBirth", getDateOfBirth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empDependentId = (Long)attributes.get("empDependentId");

		if (empDependentId != null) {
			setEmpDependentId(empDependentId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String relationship = (String)attributes.get("relationship");

		if (relationship != null) {
			setRelationship(relationship);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}
	}

	/**
	* Returns the primary key of this emp dependent.
	*
	* @return the primary key of this emp dependent
	*/
	@Override
	public long getPrimaryKey() {
		return _empDependent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp dependent.
	*
	* @param primaryKey the primary key of this emp dependent
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empDependent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp dependent ID of this emp dependent.
	*
	* @return the emp dependent ID of this emp dependent
	*/
	@Override
	public long getEmpDependentId() {
		return _empDependent.getEmpDependentId();
	}

	/**
	* Sets the emp dependent ID of this emp dependent.
	*
	* @param empDependentId the emp dependent ID of this emp dependent
	*/
	@Override
	public void setEmpDependentId(long empDependentId) {
		_empDependent.setEmpDependentId(empDependentId);
	}

	/**
	* Returns the employee ID of this emp dependent.
	*
	* @return the employee ID of this emp dependent
	*/
	@Override
	public long getEmployeeId() {
		return _empDependent.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp dependent.
	*
	* @param employeeId the employee ID of this emp dependent
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empDependent.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp dependent.
	*
	* @return the group ID of this emp dependent
	*/
	@Override
	public long getGroupId() {
		return _empDependent.getGroupId();
	}

	/**
	* Sets the group ID of this emp dependent.
	*
	* @param groupId the group ID of this emp dependent
	*/
	@Override
	public void setGroupId(long groupId) {
		_empDependent.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp dependent.
	*
	* @return the company ID of this emp dependent
	*/
	@Override
	public long getCompanyId() {
		return _empDependent.getCompanyId();
	}

	/**
	* Sets the company ID of this emp dependent.
	*
	* @param companyId the company ID of this emp dependent
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empDependent.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp dependent.
	*
	* @return the user ID of this emp dependent
	*/
	@Override
	public long getUserId() {
		return _empDependent.getUserId();
	}

	/**
	* Sets the user ID of this emp dependent.
	*
	* @param userId the user ID of this emp dependent
	*/
	@Override
	public void setUserId(long userId) {
		_empDependent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp dependent.
	*
	* @return the user uuid of this emp dependent
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDependent.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp dependent.
	*
	* @param userUuid the user uuid of this emp dependent
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empDependent.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this emp dependent.
	*
	* @return the create date of this emp dependent
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empDependent.getCreateDate();
	}

	/**
	* Sets the create date of this emp dependent.
	*
	* @param createDate the create date of this emp dependent
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empDependent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp dependent.
	*
	* @return the modified date of this emp dependent
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empDependent.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp dependent.
	*
	* @param modifiedDate the modified date of this emp dependent
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empDependent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this emp dependent.
	*
	* @return the name of this emp dependent
	*/
	@Override
	public java.lang.String getName() {
		return _empDependent.getName();
	}

	/**
	* Sets the name of this emp dependent.
	*
	* @param name the name of this emp dependent
	*/
	@Override
	public void setName(java.lang.String name) {
		_empDependent.setName(name);
	}

	/**
	* Returns the relationship of this emp dependent.
	*
	* @return the relationship of this emp dependent
	*/
	@Override
	public java.lang.String getRelationship() {
		return _empDependent.getRelationship();
	}

	/**
	* Sets the relationship of this emp dependent.
	*
	* @param relationship the relationship of this emp dependent
	*/
	@Override
	public void setRelationship(java.lang.String relationship) {
		_empDependent.setRelationship(relationship);
	}

	/**
	* Returns the date of birth of this emp dependent.
	*
	* @return the date of birth of this emp dependent
	*/
	@Override
	public java.util.Date getDateOfBirth() {
		return _empDependent.getDateOfBirth();
	}

	/**
	* Sets the date of birth of this emp dependent.
	*
	* @param dateOfBirth the date of birth of this emp dependent
	*/
	@Override
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		_empDependent.setDateOfBirth(dateOfBirth);
	}

	@Override
	public boolean isNew() {
		return _empDependent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empDependent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empDependent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empDependent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empDependent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empDependent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empDependent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empDependent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empDependent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empDependent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empDependent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpDependentWrapper((EmpDependent)_empDependent.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpDependent empDependent) {
		return _empDependent.compareTo(empDependent);
	}

	@Override
	public int hashCode() {
		return _empDependent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpDependent> toCacheModel() {
		return _empDependent.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDependent toEscapedModel() {
		return new EmpDependentWrapper(_empDependent.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDependent toUnescapedModel() {
		return new EmpDependentWrapper(_empDependent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empDependent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empDependent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empDependent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpDependentWrapper)) {
			return false;
		}

		EmpDependentWrapper empDependentWrapper = (EmpDependentWrapper)obj;

		if (Validator.equals(_empDependent, empDependentWrapper._empDependent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpDependent getWrappedEmpDependent() {
		return _empDependent;
	}

	@Override
	public EmpDependent getWrappedModel() {
		return _empDependent;
	}

	@Override
	public void resetOriginalValues() {
		_empDependent.resetOriginalValues();
	}

	private EmpDependent _empDependent;
}