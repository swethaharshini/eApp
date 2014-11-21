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
 * This class is a wrapper for {@link EmpEmergencyContact}.
 * </p>
 *
 * @author rknowsys
 * @see EmpEmergencyContact
 * @generated
 */
public class EmpEmergencyContactWrapper implements EmpEmergencyContact,
	ModelWrapper<EmpEmergencyContact> {
	public EmpEmergencyContactWrapper(EmpEmergencyContact empEmergencyContact) {
		_empEmergencyContact = empEmergencyContact;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpEmergencyContact.class;
	}

	@Override
	public String getModelClassName() {
		return EmpEmergencyContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empEmergencyContactId", getEmpEmergencyContactId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("relationship", getRelationship());
		attributes.put("homeTelephone", getHomeTelephone());
		attributes.put("mobile", getMobile());
		attributes.put("workTelephone", getWorkTelephone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empEmergencyContactId = (Long)attributes.get(
				"empEmergencyContactId");

		if (empEmergencyContactId != null) {
			setEmpEmergencyContactId(empEmergencyContactId);
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

		String homeTelephone = (String)attributes.get("homeTelephone");

		if (homeTelephone != null) {
			setHomeTelephone(homeTelephone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String workTelephone = (String)attributes.get("workTelephone");

		if (workTelephone != null) {
			setWorkTelephone(workTelephone);
		}
	}

	/**
	* Returns the primary key of this EmpEmergencyContact.
	*
	* @return the primary key of this EmpEmergencyContact
	*/
	@Override
	public long getPrimaryKey() {
		return _empEmergencyContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpEmergencyContact.
	*
	* @param primaryKey the primary key of this EmpEmergencyContact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empEmergencyContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp emergency contact ID of this EmpEmergencyContact.
	*
	* @return the emp emergency contact ID of this EmpEmergencyContact
	*/
	@Override
	public long getEmpEmergencyContactId() {
		return _empEmergencyContact.getEmpEmergencyContactId();
	}

	/**
	* Sets the emp emergency contact ID of this EmpEmergencyContact.
	*
	* @param empEmergencyContactId the emp emergency contact ID of this EmpEmergencyContact
	*/
	@Override
	public void setEmpEmergencyContactId(long empEmergencyContactId) {
		_empEmergencyContact.setEmpEmergencyContactId(empEmergencyContactId);
	}

	/**
	* Returns the employee ID of this EmpEmergencyContact.
	*
	* @return the employee ID of this EmpEmergencyContact
	*/
	@Override
	public long getEmployeeId() {
		return _empEmergencyContact.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpEmergencyContact.
	*
	* @param employeeId the employee ID of this EmpEmergencyContact
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empEmergencyContact.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpEmergencyContact.
	*
	* @return the group ID of this EmpEmergencyContact
	*/
	@Override
	public long getGroupId() {
		return _empEmergencyContact.getGroupId();
	}

	/**
	* Sets the group ID of this EmpEmergencyContact.
	*
	* @param groupId the group ID of this EmpEmergencyContact
	*/
	@Override
	public void setGroupId(long groupId) {
		_empEmergencyContact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpEmergencyContact.
	*
	* @return the company ID of this EmpEmergencyContact
	*/
	@Override
	public long getCompanyId() {
		return _empEmergencyContact.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpEmergencyContact.
	*
	* @param companyId the company ID of this EmpEmergencyContact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empEmergencyContact.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpEmergencyContact.
	*
	* @return the user ID of this EmpEmergencyContact
	*/
	@Override
	public long getUserId() {
		return _empEmergencyContact.getUserId();
	}

	/**
	* Sets the user ID of this EmpEmergencyContact.
	*
	* @param userId the user ID of this EmpEmergencyContact
	*/
	@Override
	public void setUserId(long userId) {
		_empEmergencyContact.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpEmergencyContact.
	*
	* @return the user uuid of this EmpEmergencyContact
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empEmergencyContact.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpEmergencyContact.
	*
	* @param userUuid the user uuid of this EmpEmergencyContact
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empEmergencyContact.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpEmergencyContact.
	*
	* @return the create date of this EmpEmergencyContact
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empEmergencyContact.getCreateDate();
	}

	/**
	* Sets the create date of this EmpEmergencyContact.
	*
	* @param createDate the create date of this EmpEmergencyContact
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empEmergencyContact.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpEmergencyContact.
	*
	* @return the modified date of this EmpEmergencyContact
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empEmergencyContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpEmergencyContact.
	*
	* @param modifiedDate the modified date of this EmpEmergencyContact
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empEmergencyContact.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this EmpEmergencyContact.
	*
	* @return the name of this EmpEmergencyContact
	*/
	@Override
	public java.lang.String getName() {
		return _empEmergencyContact.getName();
	}

	/**
	* Sets the name of this EmpEmergencyContact.
	*
	* @param name the name of this EmpEmergencyContact
	*/
	@Override
	public void setName(java.lang.String name) {
		_empEmergencyContact.setName(name);
	}

	/**
	* Returns the relationship of this EmpEmergencyContact.
	*
	* @return the relationship of this EmpEmergencyContact
	*/
	@Override
	public java.lang.String getRelationship() {
		return _empEmergencyContact.getRelationship();
	}

	/**
	* Sets the relationship of this EmpEmergencyContact.
	*
	* @param relationship the relationship of this EmpEmergencyContact
	*/
	@Override
	public void setRelationship(java.lang.String relationship) {
		_empEmergencyContact.setRelationship(relationship);
	}

	/**
	* Returns the home telephone of this EmpEmergencyContact.
	*
	* @return the home telephone of this EmpEmergencyContact
	*/
	@Override
	public java.lang.String getHomeTelephone() {
		return _empEmergencyContact.getHomeTelephone();
	}

	/**
	* Sets the home telephone of this EmpEmergencyContact.
	*
	* @param homeTelephone the home telephone of this EmpEmergencyContact
	*/
	@Override
	public void setHomeTelephone(java.lang.String homeTelephone) {
		_empEmergencyContact.setHomeTelephone(homeTelephone);
	}

	/**
	* Returns the mobile of this EmpEmergencyContact.
	*
	* @return the mobile of this EmpEmergencyContact
	*/
	@Override
	public java.lang.String getMobile() {
		return _empEmergencyContact.getMobile();
	}

	/**
	* Sets the mobile of this EmpEmergencyContact.
	*
	* @param mobile the mobile of this EmpEmergencyContact
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_empEmergencyContact.setMobile(mobile);
	}

	/**
	* Returns the work telephone of this EmpEmergencyContact.
	*
	* @return the work telephone of this EmpEmergencyContact
	*/
	@Override
	public java.lang.String getWorkTelephone() {
		return _empEmergencyContact.getWorkTelephone();
	}

	/**
	* Sets the work telephone of this EmpEmergencyContact.
	*
	* @param workTelephone the work telephone of this EmpEmergencyContact
	*/
	@Override
	public void setWorkTelephone(java.lang.String workTelephone) {
		_empEmergencyContact.setWorkTelephone(workTelephone);
	}

	@Override
	public boolean isNew() {
		return _empEmergencyContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empEmergencyContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empEmergencyContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empEmergencyContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empEmergencyContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empEmergencyContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empEmergencyContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empEmergencyContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empEmergencyContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empEmergencyContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empEmergencyContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpEmergencyContactWrapper((EmpEmergencyContact)_empEmergencyContact.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact) {
		return _empEmergencyContact.compareTo(empEmergencyContact);
	}

	@Override
	public int hashCode() {
		return _empEmergencyContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> toCacheModel() {
		return _empEmergencyContact.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact toEscapedModel() {
		return new EmpEmergencyContactWrapper(_empEmergencyContact.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact toUnescapedModel() {
		return new EmpEmergencyContactWrapper(_empEmergencyContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empEmergencyContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empEmergencyContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empEmergencyContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpEmergencyContactWrapper)) {
			return false;
		}

		EmpEmergencyContactWrapper empEmergencyContactWrapper = (EmpEmergencyContactWrapper)obj;

		if (Validator.equals(_empEmergencyContact,
					empEmergencyContactWrapper._empEmergencyContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpEmergencyContact getWrappedEmpEmergencyContact() {
		return _empEmergencyContact;
	}

	@Override
	public EmpEmergencyContact getWrappedModel() {
		return _empEmergencyContact;
	}

	@Override
	public void resetOriginalValues() {
		_empEmergencyContact.resetOriginalValues();
	}

	private EmpEmergencyContact _empEmergencyContact;
}