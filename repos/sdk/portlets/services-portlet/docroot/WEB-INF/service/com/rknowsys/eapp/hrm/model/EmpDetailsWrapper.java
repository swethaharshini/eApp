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
 * This class is a wrapper for {@link EmpDetails}.
 * </p>
 *
 * @author rknowsys
 * @see EmpDetails
 * @generated
 */
public class EmpDetailsWrapper implements EmpDetails, ModelWrapper<EmpDetails> {
	public EmpDetailsWrapper(EmpDetails empDetails) {
		_empDetails = empDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empdetailsId", getEmpdetailsId());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("title", getTitle());
		attributes.put("employmentstatus", getEmploymentstatus());
		attributes.put("name", getName());
		attributes.put("supervisor", getSupervisor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empdetailsId = (Long)attributes.get("empdetailsId");

		if (empdetailsId != null) {
			setEmpdetailsId(empdetailsId);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String employmentstatus = (String)attributes.get("employmentstatus");

		if (employmentstatus != null) {
			setEmploymentstatus(employmentstatus);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String supervisor = (String)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}
	}

	/**
	* Returns the primary key of this emp details.
	*
	* @return the primary key of this emp details
	*/
	@Override
	public long getPrimaryKey() {
		return _empDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp details.
	*
	* @param primaryKey the primary key of this emp details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the empdetails ID of this emp details.
	*
	* @return the empdetails ID of this emp details
	*/
	@Override
	public long getEmpdetailsId() {
		return _empDetails.getEmpdetailsId();
	}

	/**
	* Sets the empdetails ID of this emp details.
	*
	* @param empdetailsId the empdetails ID of this emp details
	*/
	@Override
	public void setEmpdetailsId(long empdetailsId) {
		_empDetails.setEmpdetailsId(empdetailsId);
	}

	/**
	* Returns the employee no of this emp details.
	*
	* @return the employee no of this emp details
	*/
	@Override
	public java.lang.String getEmployeeNo() {
		return _empDetails.getEmployeeNo();
	}

	/**
	* Sets the employee no of this emp details.
	*
	* @param employeeNo the employee no of this emp details
	*/
	@Override
	public void setEmployeeNo(java.lang.String employeeNo) {
		_empDetails.setEmployeeNo(employeeNo);
	}

	/**
	* Returns the company ID of this emp details.
	*
	* @return the company ID of this emp details
	*/
	@Override
	public long getCompanyId() {
		return _empDetails.getCompanyId();
	}

	/**
	* Sets the company ID of this emp details.
	*
	* @param companyId the company ID of this emp details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empDetails.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp details.
	*
	* @return the user ID of this emp details
	*/
	@Override
	public long getUserId() {
		return _empDetails.getUserId();
	}

	/**
	* Sets the user ID of this emp details.
	*
	* @param userId the user ID of this emp details
	*/
	@Override
	public void setUserId(long userId) {
		_empDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp details.
	*
	* @return the user uuid of this emp details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp details.
	*
	* @param userUuid the user uuid of this emp details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this emp details.
	*
	* @return the create date of this emp details
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empDetails.getCreateDate();
	}

	/**
	* Sets the create date of this emp details.
	*
	* @param createDate the create date of this emp details
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empDetails.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp details.
	*
	* @return the modified date of this emp details
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empDetails.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp details.
	*
	* @param modifiedDate the modified date of this emp details
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the first name of this emp details.
	*
	* @return the first name of this emp details
	*/
	@Override
	public java.lang.String getFirstName() {
		return _empDetails.getFirstName();
	}

	/**
	* Sets the first name of this emp details.
	*
	* @param firstName the first name of this emp details
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_empDetails.setFirstName(firstName);
	}

	/**
	* Returns the last name of this emp details.
	*
	* @return the last name of this emp details
	*/
	@Override
	public java.lang.String getLastName() {
		return _empDetails.getLastName();
	}

	/**
	* Sets the last name of this emp details.
	*
	* @param lastName the last name of this emp details
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_empDetails.setLastName(lastName);
	}

	/**
	* Returns the title of this emp details.
	*
	* @return the title of this emp details
	*/
	@Override
	public java.lang.String getTitle() {
		return _empDetails.getTitle();
	}

	/**
	* Sets the title of this emp details.
	*
	* @param title the title of this emp details
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_empDetails.setTitle(title);
	}

	/**
	* Returns the employmentstatus of this emp details.
	*
	* @return the employmentstatus of this emp details
	*/
	@Override
	public java.lang.String getEmploymentstatus() {
		return _empDetails.getEmploymentstatus();
	}

	/**
	* Sets the employmentstatus of this emp details.
	*
	* @param employmentstatus the employmentstatus of this emp details
	*/
	@Override
	public void setEmploymentstatus(java.lang.String employmentstatus) {
		_empDetails.setEmploymentstatus(employmentstatus);
	}

	/**
	* Returns the name of this emp details.
	*
	* @return the name of this emp details
	*/
	@Override
	public java.lang.String getName() {
		return _empDetails.getName();
	}

	/**
	* Sets the name of this emp details.
	*
	* @param name the name of this emp details
	*/
	@Override
	public void setName(java.lang.String name) {
		_empDetails.setName(name);
	}

	/**
	* Returns the supervisor of this emp details.
	*
	* @return the supervisor of this emp details
	*/
	@Override
	public java.lang.String getSupervisor() {
		return _empDetails.getSupervisor();
	}

	/**
	* Sets the supervisor of this emp details.
	*
	* @param supervisor the supervisor of this emp details
	*/
	@Override
	public void setSupervisor(java.lang.String supervisor) {
		_empDetails.setSupervisor(supervisor);
	}

	@Override
	public boolean isNew() {
		return _empDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpDetailsWrapper((EmpDetails)_empDetails.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpDetails empDetails) {
		return _empDetails.compareTo(empDetails);
	}

	@Override
	public int hashCode() {
		return _empDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpDetails> toCacheModel() {
		return _empDetails.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails toEscapedModel() {
		return new EmpDetailsWrapper(_empDetails.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails toUnescapedModel() {
		return new EmpDetailsWrapper(_empDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpDetailsWrapper)) {
			return false;
		}

		EmpDetailsWrapper empDetailsWrapper = (EmpDetailsWrapper)obj;

		if (Validator.equals(_empDetails, empDetailsWrapper._empDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpDetails getWrappedEmpDetails() {
		return _empDetails;
	}

	@Override
	public EmpDetails getWrappedModel() {
		return _empDetails;
	}

	@Override
	public void resetOriginalValues() {
		_empDetails.resetOriginalValues();
	}

	private EmpDetails _empDetails;
}