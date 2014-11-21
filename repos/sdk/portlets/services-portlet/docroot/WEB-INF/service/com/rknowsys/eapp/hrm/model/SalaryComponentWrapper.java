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
 * This class is a wrapper for {@link SalaryComponent}.
 * </p>
 *
 * @author rknowsys
 * @see SalaryComponent
 * @generated
 */
public class SalaryComponentWrapper implements SalaryComponent,
	ModelWrapper<SalaryComponent> {
	public SalaryComponentWrapper(SalaryComponent salaryComponent) {
		_salaryComponent = salaryComponent;
	}

	@Override
	public Class<?> getModelClass() {
		return SalaryComponent.class;
	}

	@Override
	public String getModelClassName() {
		return SalaryComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("salaryComponentId", getSalaryComponentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("componentName", getComponentName());
		attributes.put("type", getType());
		attributes.put("onlyCTC", getOnlyCTC());
		attributes.put("valueType", getValueType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long salaryComponentId = (Long)attributes.get("salaryComponentId");

		if (salaryComponentId != null) {
			setSalaryComponentId(salaryComponentId);
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

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		Boolean type = (Boolean)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean onlyCTC = (Boolean)attributes.get("onlyCTC");

		if (onlyCTC != null) {
			setOnlyCTC(onlyCTC);
		}

		String valueType = (String)attributes.get("valueType");

		if (valueType != null) {
			setValueType(valueType);
		}
	}

	/**
	* Returns the primary key of this salary component.
	*
	* @return the primary key of this salary component
	*/
	@Override
	public long getPrimaryKey() {
		return _salaryComponent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this salary component.
	*
	* @param primaryKey the primary key of this salary component
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_salaryComponent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the salary component ID of this salary component.
	*
	* @return the salary component ID of this salary component
	*/
	@Override
	public long getSalaryComponentId() {
		return _salaryComponent.getSalaryComponentId();
	}

	/**
	* Sets the salary component ID of this salary component.
	*
	* @param salaryComponentId the salary component ID of this salary component
	*/
	@Override
	public void setSalaryComponentId(long salaryComponentId) {
		_salaryComponent.setSalaryComponentId(salaryComponentId);
	}

	/**
	* Returns the company ID of this salary component.
	*
	* @return the company ID of this salary component
	*/
	@Override
	public long getCompanyId() {
		return _salaryComponent.getCompanyId();
	}

	/**
	* Sets the company ID of this salary component.
	*
	* @param companyId the company ID of this salary component
	*/
	@Override
	public void setCompanyId(long companyId) {
		_salaryComponent.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this salary component.
	*
	* @return the group ID of this salary component
	*/
	@Override
	public long getGroupId() {
		return _salaryComponent.getGroupId();
	}

	/**
	* Sets the group ID of this salary component.
	*
	* @param groupId the group ID of this salary component
	*/
	@Override
	public void setGroupId(long groupId) {
		_salaryComponent.setGroupId(groupId);
	}

	/**
	* Returns the create date of this salary component.
	*
	* @return the create date of this salary component
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _salaryComponent.getCreateDate();
	}

	/**
	* Sets the create date of this salary component.
	*
	* @param createDate the create date of this salary component
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_salaryComponent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this salary component.
	*
	* @return the modified date of this salary component
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _salaryComponent.getModifiedDate();
	}

	/**
	* Sets the modified date of this salary component.
	*
	* @param modifiedDate the modified date of this salary component
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_salaryComponent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this salary component.
	*
	* @return the user ID of this salary component
	*/
	@Override
	public long getUserId() {
		return _salaryComponent.getUserId();
	}

	/**
	* Sets the user ID of this salary component.
	*
	* @param userId the user ID of this salary component
	*/
	@Override
	public void setUserId(long userId) {
		_salaryComponent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this salary component.
	*
	* @return the user uuid of this salary component
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponent.getUserUuid();
	}

	/**
	* Sets the user uuid of this salary component.
	*
	* @param userUuid the user uuid of this salary component
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_salaryComponent.setUserUuid(userUuid);
	}

	/**
	* Returns the component name of this salary component.
	*
	* @return the component name of this salary component
	*/
	@Override
	public java.lang.String getComponentName() {
		return _salaryComponent.getComponentName();
	}

	/**
	* Sets the component name of this salary component.
	*
	* @param componentName the component name of this salary component
	*/
	@Override
	public void setComponentName(java.lang.String componentName) {
		_salaryComponent.setComponentName(componentName);
	}

	/**
	* Returns the type of this salary component.
	*
	* @return the type of this salary component
	*/
	@Override
	public boolean getType() {
		return _salaryComponent.getType();
	}

	/**
	* Returns <code>true</code> if this salary component is type.
	*
	* @return <code>true</code> if this salary component is type; <code>false</code> otherwise
	*/
	@Override
	public boolean isType() {
		return _salaryComponent.isType();
	}

	/**
	* Sets whether this salary component is type.
	*
	* @param type the type of this salary component
	*/
	@Override
	public void setType(boolean type) {
		_salaryComponent.setType(type);
	}

	/**
	* Returns the only c t c of this salary component.
	*
	* @return the only c t c of this salary component
	*/
	@Override
	public boolean getOnlyCTC() {
		return _salaryComponent.getOnlyCTC();
	}

	/**
	* Returns <code>true</code> if this salary component is only c t c.
	*
	* @return <code>true</code> if this salary component is only c t c; <code>false</code> otherwise
	*/
	@Override
	public boolean isOnlyCTC() {
		return _salaryComponent.isOnlyCTC();
	}

	/**
	* Sets whether this salary component is only c t c.
	*
	* @param onlyCTC the only c t c of this salary component
	*/
	@Override
	public void setOnlyCTC(boolean onlyCTC) {
		_salaryComponent.setOnlyCTC(onlyCTC);
	}

	/**
	* Returns the value type of this salary component.
	*
	* @return the value type of this salary component
	*/
	@Override
	public java.lang.String getValueType() {
		return _salaryComponent.getValueType();
	}

	/**
	* Sets the value type of this salary component.
	*
	* @param valueType the value type of this salary component
	*/
	@Override
	public void setValueType(java.lang.String valueType) {
		_salaryComponent.setValueType(valueType);
	}

	@Override
	public boolean isNew() {
		return _salaryComponent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_salaryComponent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _salaryComponent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_salaryComponent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _salaryComponent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _salaryComponent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_salaryComponent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _salaryComponent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_salaryComponent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_salaryComponent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_salaryComponent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SalaryComponentWrapper((SalaryComponent)_salaryComponent.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent) {
		return _salaryComponent.compareTo(salaryComponent);
	}

	@Override
	public int hashCode() {
		return _salaryComponent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.SalaryComponent> toCacheModel() {
		return _salaryComponent.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent toEscapedModel() {
		return new SalaryComponentWrapper(_salaryComponent.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent toUnescapedModel() {
		return new SalaryComponentWrapper(_salaryComponent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _salaryComponent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _salaryComponent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_salaryComponent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalaryComponentWrapper)) {
			return false;
		}

		SalaryComponentWrapper salaryComponentWrapper = (SalaryComponentWrapper)obj;

		if (Validator.equals(_salaryComponent,
					salaryComponentWrapper._salaryComponent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SalaryComponent getWrappedSalaryComponent() {
		return _salaryComponent;
	}

	@Override
	public SalaryComponent getWrappedModel() {
		return _salaryComponent;
	}

	@Override
	public void resetOriginalValues() {
		_salaryComponent.resetOriginalValues();
	}

	private SalaryComponent _salaryComponent;
}