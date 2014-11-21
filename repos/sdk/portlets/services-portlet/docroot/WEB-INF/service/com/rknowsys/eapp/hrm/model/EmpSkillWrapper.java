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
 * This class is a wrapper for {@link EmpSkill}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSkill
 * @generated
 */
public class EmpSkillWrapper implements EmpSkill, ModelWrapper<EmpSkill> {
	public EmpSkillWrapper(EmpSkill empSkill) {
		_empSkill = empSkill;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpSkill.class;
	}

	@Override
	public String getModelClassName() {
		return EmpSkill.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empSkillId", getEmpSkillId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("skillId", getSkillId());
		attributes.put("years", getYears());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empSkillId = (Long)attributes.get("empSkillId");

		if (empSkillId != null) {
			setEmpSkillId(empSkillId);
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

		Long skillId = (Long)attributes.get("skillId");

		if (skillId != null) {
			setSkillId(skillId);
		}

		String years = (String)attributes.get("years");

		if (years != null) {
			setYears(years);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this emp skill.
	*
	* @return the primary key of this emp skill
	*/
	@Override
	public long getPrimaryKey() {
		return _empSkill.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp skill.
	*
	* @param primaryKey the primary key of this emp skill
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empSkill.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp skill ID of this emp skill.
	*
	* @return the emp skill ID of this emp skill
	*/
	@Override
	public long getEmpSkillId() {
		return _empSkill.getEmpSkillId();
	}

	/**
	* Sets the emp skill ID of this emp skill.
	*
	* @param empSkillId the emp skill ID of this emp skill
	*/
	@Override
	public void setEmpSkillId(long empSkillId) {
		_empSkill.setEmpSkillId(empSkillId);
	}

	/**
	* Returns the employee ID of this emp skill.
	*
	* @return the employee ID of this emp skill
	*/
	@Override
	public long getEmployeeId() {
		return _empSkill.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp skill.
	*
	* @param employeeId the employee ID of this emp skill
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empSkill.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp skill.
	*
	* @return the group ID of this emp skill
	*/
	@Override
	public long getGroupId() {
		return _empSkill.getGroupId();
	}

	/**
	* Sets the group ID of this emp skill.
	*
	* @param groupId the group ID of this emp skill
	*/
	@Override
	public void setGroupId(long groupId) {
		_empSkill.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp skill.
	*
	* @return the company ID of this emp skill
	*/
	@Override
	public long getCompanyId() {
		return _empSkill.getCompanyId();
	}

	/**
	* Sets the company ID of this emp skill.
	*
	* @param companyId the company ID of this emp skill
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empSkill.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp skill.
	*
	* @return the create date of this emp skill
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empSkill.getCreateDate();
	}

	/**
	* Sets the create date of this emp skill.
	*
	* @param createDate the create date of this emp skill
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empSkill.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp skill.
	*
	* @return the modified date of this emp skill
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empSkill.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp skill.
	*
	* @param modifiedDate the modified date of this emp skill
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empSkill.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp skill.
	*
	* @return the user ID of this emp skill
	*/
	@Override
	public long getUserId() {
		return _empSkill.getUserId();
	}

	/**
	* Sets the user ID of this emp skill.
	*
	* @param userId the user ID of this emp skill
	*/
	@Override
	public void setUserId(long userId) {
		_empSkill.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp skill.
	*
	* @return the user uuid of this emp skill
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSkill.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp skill.
	*
	* @param userUuid the user uuid of this emp skill
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empSkill.setUserUuid(userUuid);
	}

	/**
	* Returns the skill ID of this emp skill.
	*
	* @return the skill ID of this emp skill
	*/
	@Override
	public long getSkillId() {
		return _empSkill.getSkillId();
	}

	/**
	* Sets the skill ID of this emp skill.
	*
	* @param skillId the skill ID of this emp skill
	*/
	@Override
	public void setSkillId(long skillId) {
		_empSkill.setSkillId(skillId);
	}

	/**
	* Returns the years of this emp skill.
	*
	* @return the years of this emp skill
	*/
	@Override
	public java.lang.String getYears() {
		return _empSkill.getYears();
	}

	/**
	* Sets the years of this emp skill.
	*
	* @param years the years of this emp skill
	*/
	@Override
	public void setYears(java.lang.String years) {
		_empSkill.setYears(years);
	}

	/**
	* Returns the comments of this emp skill.
	*
	* @return the comments of this emp skill
	*/
	@Override
	public java.lang.String getComments() {
		return _empSkill.getComments();
	}

	/**
	* Sets the comments of this emp skill.
	*
	* @param comments the comments of this emp skill
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_empSkill.setComments(comments);
	}

	@Override
	public boolean isNew() {
		return _empSkill.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empSkill.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empSkill.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empSkill.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empSkill.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empSkill.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empSkill.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empSkill.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empSkill.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empSkill.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empSkill.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpSkillWrapper((EmpSkill)_empSkill.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpSkill empSkill) {
		return _empSkill.compareTo(empSkill);
	}

	@Override
	public int hashCode() {
		return _empSkill.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpSkill> toCacheModel() {
		return _empSkill.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSkill toEscapedModel() {
		return new EmpSkillWrapper(_empSkill.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSkill toUnescapedModel() {
		return new EmpSkillWrapper(_empSkill.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empSkill.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empSkill.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empSkill.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpSkillWrapper)) {
			return false;
		}

		EmpSkillWrapper empSkillWrapper = (EmpSkillWrapper)obj;

		if (Validator.equals(_empSkill, empSkillWrapper._empSkill)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpSkill getWrappedEmpSkill() {
		return _empSkill;
	}

	@Override
	public EmpSkill getWrappedModel() {
		return _empSkill;
	}

	@Override
	public void resetOriginalValues() {
		_empSkill.resetOriginalValues();
	}

	private EmpSkill _empSkill;
}