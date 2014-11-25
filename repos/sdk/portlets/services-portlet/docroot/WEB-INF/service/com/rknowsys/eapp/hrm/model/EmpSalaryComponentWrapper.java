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
 * This class is a wrapper for {@link EmpSalaryComponent}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSalaryComponent
 * @generated
 */
public class EmpSalaryComponentWrapper implements EmpSalaryComponent,
	ModelWrapper<EmpSalaryComponent> {
	public EmpSalaryComponentWrapper(EmpSalaryComponent empSalaryComponent) {
		_empSalaryComponent = empSalaryComponent;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSalaryComponent.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSalaryComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSalaryEarningId", getEmpSalaryEarningId());
		attributes.put("empSalaryId", getEmpSalaryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("salaryComponentId", getSalaryComponentId());
		attributes.put("amount", getAmount());
		attributes.put("effectiveDate", getEffectiveDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSalaryEarningId = (Long)attributes.get("empSalaryEarningId");

		if (empSalaryEarningId != null) {
			setEmpSalaryEarningId(empSalaryEarningId);
		}

		Long empSalaryId = (Long)attributes.get("empSalaryId");

		if (empSalaryId != null) {
			setEmpSalaryId(empSalaryId);
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

		Long salaryComponentId = (Long)attributes.get("salaryComponentId");

		if (salaryComponentId != null) {
			setSalaryComponentId(salaryComponentId);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}
	}

	/**
	* Returns the primary key of this emp salary component.
	*
	* @return the primary key of this emp salary component
	*/
	@Override
	public long getPrimaryKey() {
		return _empSalaryComponent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp salary component.
	*
	* @param primaryKey the primary key of this emp salary component
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empSalaryComponent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp salary earning ID of this emp salary component.
	*
	* @return the emp salary earning ID of this emp salary component
	*/
	@Override
	public long getEmpSalaryEarningId() {
		return _empSalaryComponent.getEmpSalaryEarningId();
	}

	/**
	* Sets the emp salary earning ID of this emp salary component.
	*
	* @param empSalaryEarningId the emp salary earning ID of this emp salary component
	*/
	@Override
	public void setEmpSalaryEarningId(long empSalaryEarningId) {
		_empSalaryComponent.setEmpSalaryEarningId(empSalaryEarningId);
	}

	/**
	* Returns the emp salary ID of this emp salary component.
	*
	* @return the emp salary ID of this emp salary component
	*/
	@Override
	public long getEmpSalaryId() {
		return _empSalaryComponent.getEmpSalaryId();
	}

	/**
	* Sets the emp salary ID of this emp salary component.
	*
	* @param empSalaryId the emp salary ID of this emp salary component
	*/
	@Override
	public void setEmpSalaryId(long empSalaryId) {
		_empSalaryComponent.setEmpSalaryId(empSalaryId);
	}

	/**
	* Returns the group ID of this emp salary component.
	*
	* @return the group ID of this emp salary component
	*/
	@Override
	public long getGroupId() {
		return _empSalaryComponent.getGroupId();
	}

	/**
	* Sets the group ID of this emp salary component.
	*
	* @param groupId the group ID of this emp salary component
	*/
	@Override
	public void setGroupId(long groupId) {
		_empSalaryComponent.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp salary component.
	*
	* @return the company ID of this emp salary component
	*/
	@Override
	public long getCompanyId() {
		return _empSalaryComponent.getCompanyId();
	}

	/**
	* Sets the company ID of this emp salary component.
	*
	* @param companyId the company ID of this emp salary component
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empSalaryComponent.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp salary component.
	*
	* @return the create date of this emp salary component
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empSalaryComponent.getCreateDate();
	}

	/**
	* Sets the create date of this emp salary component.
	*
	* @param createDate the create date of this emp salary component
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empSalaryComponent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp salary component.
	*
	* @return the modified date of this emp salary component
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empSalaryComponent.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp salary component.
	*
	* @param modifiedDate the modified date of this emp salary component
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empSalaryComponent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp salary component.
	*
	* @return the user ID of this emp salary component
	*/
	@Override
	public long getUserId() {
		return _empSalaryComponent.getUserId();
	}

	/**
	* Sets the user ID of this emp salary component.
	*
	* @param userId the user ID of this emp salary component
	*/
	@Override
	public void setUserId(long userId) {
		_empSalaryComponent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp salary component.
	*
	* @return the user uuid of this emp salary component
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponent.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp salary component.
	*
	* @param userUuid the user uuid of this emp salary component
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empSalaryComponent.setUserUuid(userUuid);
	}

	/**
	* Returns the salary component ID of this emp salary component.
	*
	* @return the salary component ID of this emp salary component
	*/
	@Override
	public long getSalaryComponentId() {
		return _empSalaryComponent.getSalaryComponentId();
	}

	/**
	* Sets the salary component ID of this emp salary component.
	*
	* @param salaryComponentId the salary component ID of this emp salary component
	*/
	@Override
	public void setSalaryComponentId(long salaryComponentId) {
		_empSalaryComponent.setSalaryComponentId(salaryComponentId);
	}

	/**
	* Returns the amount of this emp salary component.
	*
	* @return the amount of this emp salary component
	*/
	@Override
	public long getAmount() {
		return _empSalaryComponent.getAmount();
	}

	/**
	* Sets the amount of this emp salary component.
	*
	* @param amount the amount of this emp salary component
	*/
	@Override
	public void setAmount(long amount) {
		_empSalaryComponent.setAmount(amount);
	}

	/**
	* Returns the effective date of this emp salary component.
	*
	* @return the effective date of this emp salary component
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _empSalaryComponent.getEffectiveDate();
	}

	/**
	* Sets the effective date of this emp salary component.
	*
	* @param effectiveDate the effective date of this emp salary component
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_empSalaryComponent.setEffectiveDate(effectiveDate);
	}

	@Override
	public boolean isNew() {
		return _empSalaryComponent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empSalaryComponent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empSalaryComponent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empSalaryComponent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empSalaryComponent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empSalaryComponent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empSalaryComponent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empSalaryComponent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empSalaryComponent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empSalaryComponent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empSalaryComponent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpSalaryComponentWrapper((EmpSalaryComponent)_empSalaryComponent.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent) {
		return _empSalaryComponent.compareTo(empSalaryComponent);
	}

	@Override
	public int hashCode() {
		return _empSalaryComponent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> toCacheModel() {
		return _empSalaryComponent.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent toEscapedModel() {
		return new EmpSalaryComponentWrapper(_empSalaryComponent.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent toUnescapedModel() {
		return new EmpSalaryComponentWrapper(_empSalaryComponent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empSalaryComponent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empSalaryComponent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empSalaryComponent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpSalaryComponentWrapper)) {
			return false;
		}

		EmpSalaryComponentWrapper empSalaryComponentWrapper = (EmpSalaryComponentWrapper)obj;

		if (Validator.equals(_empSalaryComponent,
					empSalaryComponentWrapper._empSalaryComponent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpSalaryComponent getWrappedEmpSalaryComponent() {
		return _empSalaryComponent;
	}

	@Override
	public EmpSalaryComponent getWrappedModel() {
		return _empSalaryComponent;
	}

	@Override
	public void resetOriginalValues() {
		_empSalaryComponent.resetOriginalValues();
	}

	private EmpSalaryComponent _empSalaryComponent;
}