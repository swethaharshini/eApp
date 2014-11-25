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
 * This class is a wrapper for {@link Skill}.
 * </p>
 *
 * @author rknowsys
 * @see Skill
 * @generated
 */
public class SkillWrapper implements Skill, ModelWrapper<Skill> {
	public SkillWrapper(Skill skill) {
		_skill = skill;
	}

	@Override
	public Class<?> getModelClass() {
		return Skill.class;
	}

	@Override
	public String getModelClassName() {
		return Skill.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skillId", getSkillId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("skillName", getSkillName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skillId = (Long)attributes.get("skillId");

		if (skillId != null) {
			setSkillId(skillId);
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

		String skillName = (String)attributes.get("skillName");

		if (skillName != null) {
			setSkillName(skillName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this skill.
	*
	* @return the primary key of this skill
	*/
	@Override
	public long getPrimaryKey() {
		return _skill.getPrimaryKey();
	}

	/**
	* Sets the primary key of this skill.
	*
	* @param primaryKey the primary key of this skill
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skill.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the skill ID of this skill.
	*
	* @return the skill ID of this skill
	*/
	@Override
	public long getSkillId() {
		return _skill.getSkillId();
	}

	/**
	* Sets the skill ID of this skill.
	*
	* @param skillId the skill ID of this skill
	*/
	@Override
	public void setSkillId(long skillId) {
		_skill.setSkillId(skillId);
	}

	/**
	* Returns the company ID of this skill.
	*
	* @return the company ID of this skill
	*/
	@Override
	public long getCompanyId() {
		return _skill.getCompanyId();
	}

	/**
	* Sets the company ID of this skill.
	*
	* @param companyId the company ID of this skill
	*/
	@Override
	public void setCompanyId(long companyId) {
		_skill.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this skill.
	*
	* @return the group ID of this skill
	*/
	@Override
	public long getGroupId() {
		return _skill.getGroupId();
	}

	/**
	* Sets the group ID of this skill.
	*
	* @param groupId the group ID of this skill
	*/
	@Override
	public void setGroupId(long groupId) {
		_skill.setGroupId(groupId);
	}

	/**
	* Returns the create date of this skill.
	*
	* @return the create date of this skill
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _skill.getCreateDate();
	}

	/**
	* Sets the create date of this skill.
	*
	* @param createDate the create date of this skill
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_skill.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this skill.
	*
	* @return the modified date of this skill
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _skill.getModifiedDate();
	}

	/**
	* Sets the modified date of this skill.
	*
	* @param modifiedDate the modified date of this skill
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_skill.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this skill.
	*
	* @return the user ID of this skill
	*/
	@Override
	public long getUserId() {
		return _skill.getUserId();
	}

	/**
	* Sets the user ID of this skill.
	*
	* @param userId the user ID of this skill
	*/
	@Override
	public void setUserId(long userId) {
		_skill.setUserId(userId);
	}

	/**
	* Returns the user uuid of this skill.
	*
	* @return the user uuid of this skill
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skill.getUserUuid();
	}

	/**
	* Sets the user uuid of this skill.
	*
	* @param userUuid the user uuid of this skill
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_skill.setUserUuid(userUuid);
	}

	/**
	* Returns the skill name of this skill.
	*
	* @return the skill name of this skill
	*/
	@Override
	public java.lang.String getSkillName() {
		return _skill.getSkillName();
	}

	/**
	* Sets the skill name of this skill.
	*
	* @param skillName the skill name of this skill
	*/
	@Override
	public void setSkillName(java.lang.String skillName) {
		_skill.setSkillName(skillName);
	}

	/**
	* Returns the description of this skill.
	*
	* @return the description of this skill
	*/
	@Override
	public java.lang.String getDescription() {
		return _skill.getDescription();
	}

	/**
	* Sets the description of this skill.
	*
	* @param description the description of this skill
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_skill.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _skill.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_skill.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _skill.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skill.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _skill.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _skill.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skill.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skill.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_skill.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_skill.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skill.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SkillWrapper((Skill)_skill.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Skill skill) {
		return _skill.compareTo(skill);
	}

	@Override
	public int hashCode() {
		return _skill.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Skill> toCacheModel() {
		return _skill.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Skill toEscapedModel() {
		return new SkillWrapper(_skill.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Skill toUnescapedModel() {
		return new SkillWrapper(_skill.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skill.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _skill.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skill.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillWrapper)) {
			return false;
		}

		SkillWrapper skillWrapper = (SkillWrapper)obj;

		if (Validator.equals(_skill, skillWrapper._skill)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Skill getWrappedSkill() {
		return _skill;
	}

	@Override
	public Skill getWrappedModel() {
		return _skill;
	}

	@Override
	public void resetOriginalValues() {
		_skill.resetOriginalValues();
	}

	private Skill _skill;
}