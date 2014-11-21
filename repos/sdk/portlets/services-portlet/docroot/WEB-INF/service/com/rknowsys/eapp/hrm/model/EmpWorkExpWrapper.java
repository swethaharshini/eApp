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
 * This class is a wrapper for {@link EmpWorkExp}.
 * </p>
 *
 * @author rknowsys
 * @see EmpWorkExp
 * @generated
 */
public class EmpWorkExpWrapper implements EmpWorkExp, ModelWrapper<EmpWorkExp> {
	public EmpWorkExpWrapper(EmpWorkExp empWorkExp) {
		_empWorkExp = empWorkExp;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpWorkExp.class;
	}

	@Override
	public String getModelClassName() {
		return EmpWorkExp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empWorkExpId", getEmpWorkExpId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("company", getCompany());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empWorkExpId = (Long)attributes.get("empWorkExpId");

		if (empWorkExpId != null) {
			setEmpWorkExpId(empWorkExpId);
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

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	* Returns the primary key of this EmpWorkExp.
	*
	* @return the primary key of this EmpWorkExp
	*/
	@Override
	public long getPrimaryKey() {
		return _empWorkExp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpWorkExp.
	*
	* @param primaryKey the primary key of this EmpWorkExp
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empWorkExp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp work exp ID of this EmpWorkExp.
	*
	* @return the emp work exp ID of this EmpWorkExp
	*/
	@Override
	public long getEmpWorkExpId() {
		return _empWorkExp.getEmpWorkExpId();
	}

	/**
	* Sets the emp work exp ID of this EmpWorkExp.
	*
	* @param empWorkExpId the emp work exp ID of this EmpWorkExp
	*/
	@Override
	public void setEmpWorkExpId(long empWorkExpId) {
		_empWorkExp.setEmpWorkExpId(empWorkExpId);
	}

	/**
	* Returns the employee ID of this EmpWorkExp.
	*
	* @return the employee ID of this EmpWorkExp
	*/
	@Override
	public long getEmployeeId() {
		return _empWorkExp.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpWorkExp.
	*
	* @param employeeId the employee ID of this EmpWorkExp
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empWorkExp.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpWorkExp.
	*
	* @return the group ID of this EmpWorkExp
	*/
	@Override
	public long getGroupId() {
		return _empWorkExp.getGroupId();
	}

	/**
	* Sets the group ID of this EmpWorkExp.
	*
	* @param groupId the group ID of this EmpWorkExp
	*/
	@Override
	public void setGroupId(long groupId) {
		_empWorkExp.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpWorkExp.
	*
	* @return the company ID of this EmpWorkExp
	*/
	@Override
	public long getCompanyId() {
		return _empWorkExp.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpWorkExp.
	*
	* @param companyId the company ID of this EmpWorkExp
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empWorkExp.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpWorkExp.
	*
	* @return the user ID of this EmpWorkExp
	*/
	@Override
	public long getUserId() {
		return _empWorkExp.getUserId();
	}

	/**
	* Sets the user ID of this EmpWorkExp.
	*
	* @param userId the user ID of this EmpWorkExp
	*/
	@Override
	public void setUserId(long userId) {
		_empWorkExp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpWorkExp.
	*
	* @return the user uuid of this EmpWorkExp
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExp.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpWorkExp.
	*
	* @param userUuid the user uuid of this EmpWorkExp
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empWorkExp.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmpWorkExp.
	*
	* @return the create date of this EmpWorkExp
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empWorkExp.getCreateDate();
	}

	/**
	* Sets the create date of this EmpWorkExp.
	*
	* @param createDate the create date of this EmpWorkExp
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empWorkExp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpWorkExp.
	*
	* @return the modified date of this EmpWorkExp
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empWorkExp.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpWorkExp.
	*
	* @param modifiedDate the modified date of this EmpWorkExp
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empWorkExp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company of this EmpWorkExp.
	*
	* @return the company of this EmpWorkExp
	*/
	@Override
	public java.lang.String getCompany() {
		return _empWorkExp.getCompany();
	}

	/**
	* Sets the company of this EmpWorkExp.
	*
	* @param company the company of this EmpWorkExp
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_empWorkExp.setCompany(company);
	}

	/**
	* Returns the job title of this EmpWorkExp.
	*
	* @return the job title of this EmpWorkExp
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _empWorkExp.getJobTitle();
	}

	/**
	* Sets the job title of this EmpWorkExp.
	*
	* @param jobTitle the job title of this EmpWorkExp
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_empWorkExp.setJobTitle(jobTitle);
	}

	/**
	* Returns the from date of this EmpWorkExp.
	*
	* @return the from date of this EmpWorkExp
	*/
	@Override
	public java.util.Date getFromDate() {
		return _empWorkExp.getFromDate();
	}

	/**
	* Sets the from date of this EmpWorkExp.
	*
	* @param fromDate the from date of this EmpWorkExp
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_empWorkExp.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this EmpWorkExp.
	*
	* @return the to date of this EmpWorkExp
	*/
	@Override
	public java.util.Date getToDate() {
		return _empWorkExp.getToDate();
	}

	/**
	* Sets the to date of this EmpWorkExp.
	*
	* @param toDate the to date of this EmpWorkExp
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_empWorkExp.setToDate(toDate);
	}

	/**
	* Returns the comment of this EmpWorkExp.
	*
	* @return the comment of this EmpWorkExp
	*/
	@Override
	public java.lang.String getComment() {
		return _empWorkExp.getComment();
	}

	/**
	* Sets the comment of this EmpWorkExp.
	*
	* @param comment the comment of this EmpWorkExp
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_empWorkExp.setComment(comment);
	}

	@Override
	public boolean isNew() {
		return _empWorkExp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empWorkExp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empWorkExp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empWorkExp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empWorkExp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empWorkExp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empWorkExp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empWorkExp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empWorkExp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empWorkExp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empWorkExp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpWorkExpWrapper((EmpWorkExp)_empWorkExp.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp) {
		return _empWorkExp.compareTo(empWorkExp);
	}

	@Override
	public int hashCode() {
		return _empWorkExp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpWorkExp> toCacheModel() {
		return _empWorkExp.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp toEscapedModel() {
		return new EmpWorkExpWrapper(_empWorkExp.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp toUnescapedModel() {
		return new EmpWorkExpWrapper(_empWorkExp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empWorkExp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empWorkExp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empWorkExp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpWorkExpWrapper)) {
			return false;
		}

		EmpWorkExpWrapper empWorkExpWrapper = (EmpWorkExpWrapper)obj;

		if (Validator.equals(_empWorkExp, empWorkExpWrapper._empWorkExp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpWorkExp getWrappedEmpWorkExp() {
		return _empWorkExp;
	}

	@Override
	public EmpWorkExp getWrappedModel() {
		return _empWorkExp;
	}

	@Override
	public void resetOriginalValues() {
		_empWorkExp.resetOriginalValues();
	}

	private EmpWorkExp _empWorkExp;
}