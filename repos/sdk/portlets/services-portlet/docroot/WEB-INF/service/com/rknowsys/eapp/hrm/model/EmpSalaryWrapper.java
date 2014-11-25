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
 * This class is a wrapper for {@link EmpSalary}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSalary
 * @generated
 */
public class EmpSalaryWrapper implements EmpSalary, ModelWrapper<EmpSalary> {
	public EmpSalaryWrapper(EmpSalary empSalary) {
		_empSalary = empSalary;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSalary.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSalary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSalaryId", getEmpSalaryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("payGradeId", getPayGradeId());
		attributes.put("payGradeCurrencyId", getPayGradeCurrencyId());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSalaryId = (Long)attributes.get("empSalaryId");

		if (empSalaryId != null) {
			setEmpSalaryId(empSalaryId);
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

		Long payGradeId = (Long)attributes.get("payGradeId");

		if (payGradeId != null) {
			setPayGradeId(payGradeId);
		}

		Long payGradeCurrencyId = (Long)attributes.get("payGradeCurrencyId");

		if (payGradeCurrencyId != null) {
			setPayGradeCurrencyId(payGradeCurrencyId);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	* Returns the primary key of this emp salary.
	*
	* @return the primary key of this emp salary
	*/
	@Override
	public long getPrimaryKey() {
		return _empSalary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp salary.
	*
	* @param primaryKey the primary key of this emp salary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empSalary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp salary ID of this emp salary.
	*
	* @return the emp salary ID of this emp salary
	*/
	@Override
	public long getEmpSalaryId() {
		return _empSalary.getEmpSalaryId();
	}

	/**
	* Sets the emp salary ID of this emp salary.
	*
	* @param empSalaryId the emp salary ID of this emp salary
	*/
	@Override
	public void setEmpSalaryId(long empSalaryId) {
		_empSalary.setEmpSalaryId(empSalaryId);
	}

	/**
	* Returns the employee ID of this emp salary.
	*
	* @return the employee ID of this emp salary
	*/
	@Override
	public long getEmployeeId() {
		return _empSalary.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp salary.
	*
	* @param employeeId the employee ID of this emp salary
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empSalary.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp salary.
	*
	* @return the group ID of this emp salary
	*/
	@Override
	public long getGroupId() {
		return _empSalary.getGroupId();
	}

	/**
	* Sets the group ID of this emp salary.
	*
	* @param groupId the group ID of this emp salary
	*/
	@Override
	public void setGroupId(long groupId) {
		_empSalary.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp salary.
	*
	* @return the company ID of this emp salary
	*/
	@Override
	public long getCompanyId() {
		return _empSalary.getCompanyId();
	}

	/**
	* Sets the company ID of this emp salary.
	*
	* @param companyId the company ID of this emp salary
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empSalary.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp salary.
	*
	* @return the create date of this emp salary
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empSalary.getCreateDate();
	}

	/**
	* Sets the create date of this emp salary.
	*
	* @param createDate the create date of this emp salary
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empSalary.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp salary.
	*
	* @return the modified date of this emp salary
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empSalary.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp salary.
	*
	* @param modifiedDate the modified date of this emp salary
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empSalary.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp salary.
	*
	* @return the user ID of this emp salary
	*/
	@Override
	public long getUserId() {
		return _empSalary.getUserId();
	}

	/**
	* Sets the user ID of this emp salary.
	*
	* @param userId the user ID of this emp salary
	*/
	@Override
	public void setUserId(long userId) {
		_empSalary.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp salary.
	*
	* @return the user uuid of this emp salary
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalary.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp salary.
	*
	* @param userUuid the user uuid of this emp salary
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empSalary.setUserUuid(userUuid);
	}

	/**
	* Returns the pay grade ID of this emp salary.
	*
	* @return the pay grade ID of this emp salary
	*/
	@Override
	public long getPayGradeId() {
		return _empSalary.getPayGradeId();
	}

	/**
	* Sets the pay grade ID of this emp salary.
	*
	* @param payGradeId the pay grade ID of this emp salary
	*/
	@Override
	public void setPayGradeId(long payGradeId) {
		_empSalary.setPayGradeId(payGradeId);
	}

	/**
	* Returns the pay grade currency ID of this emp salary.
	*
	* @return the pay grade currency ID of this emp salary
	*/
	@Override
	public long getPayGradeCurrencyId() {
		return _empSalary.getPayGradeCurrencyId();
	}

	/**
	* Sets the pay grade currency ID of this emp salary.
	*
	* @param payGradeCurrencyId the pay grade currency ID of this emp salary
	*/
	@Override
	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_empSalary.setPayGradeCurrencyId(payGradeCurrencyId);
	}

	/**
	* Returns the comment of this emp salary.
	*
	* @return the comment of this emp salary
	*/
	@Override
	public java.lang.String getComment() {
		return _empSalary.getComment();
	}

	/**
	* Sets the comment of this emp salary.
	*
	* @param comment the comment of this emp salary
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_empSalary.setComment(comment);
	}

	@Override
	public boolean isNew() {
		return _empSalary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empSalary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empSalary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empSalary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empSalary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empSalary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empSalary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empSalary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empSalary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empSalary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empSalary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpSalaryWrapper((EmpSalary)_empSalary.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpSalary empSalary) {
		return _empSalary.compareTo(empSalary);
	}

	@Override
	public int hashCode() {
		return _empSalary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpSalary> toCacheModel() {
		return _empSalary.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary toEscapedModel() {
		return new EmpSalaryWrapper(_empSalary.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary toUnescapedModel() {
		return new EmpSalaryWrapper(_empSalary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empSalary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empSalary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empSalary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpSalaryWrapper)) {
			return false;
		}

		EmpSalaryWrapper empSalaryWrapper = (EmpSalaryWrapper)obj;

		if (Validator.equals(_empSalary, empSalaryWrapper._empSalary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpSalary getWrappedEmpSalary() {
		return _empSalary;
	}

	@Override
	public EmpSalary getWrappedModel() {
		return _empSalary;
	}

	@Override
	public void resetOriginalValues() {
		_empSalary.resetOriginalValues();
	}

	private EmpSalary _empSalary;
}