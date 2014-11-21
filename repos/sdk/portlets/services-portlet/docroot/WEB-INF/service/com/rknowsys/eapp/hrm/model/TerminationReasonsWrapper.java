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
 * This class is a wrapper for {@link TerminationReasons}.
 * </p>
 *
 * @author rknowsys
 * @see TerminationReasons
 * @generated
 */
public class TerminationReasonsWrapper implements TerminationReasons,
	ModelWrapper<TerminationReasons> {
	public TerminationReasonsWrapper(TerminationReasons terminationReasons) {
		_terminationReasons = terminationReasons;
	}

	@Override
	public Class<?> getModelClass() {
		return TerminationReasons.class;
	}

	@Override
	public String getModelClassName() {
		return TerminationReasons.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("terminationreasonsId", getTerminationreasonsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("terminationreasonsName", getTerminationreasonsName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long terminationreasonsId = (Long)attributes.get("terminationreasonsId");

		if (terminationreasonsId != null) {
			setTerminationreasonsId(terminationreasonsId);
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

		String terminationreasonsName = (String)attributes.get(
				"terminationreasonsName");

		if (terminationreasonsName != null) {
			setTerminationreasonsName(terminationreasonsName);
		}
	}

	/**
	* Returns the primary key of this termination reasons.
	*
	* @return the primary key of this termination reasons
	*/
	@Override
	public long getPrimaryKey() {
		return _terminationReasons.getPrimaryKey();
	}

	/**
	* Sets the primary key of this termination reasons.
	*
	* @param primaryKey the primary key of this termination reasons
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_terminationReasons.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the terminationreasons ID of this termination reasons.
	*
	* @return the terminationreasons ID of this termination reasons
	*/
	@Override
	public long getTerminationreasonsId() {
		return _terminationReasons.getTerminationreasonsId();
	}

	/**
	* Sets the terminationreasons ID of this termination reasons.
	*
	* @param terminationreasonsId the terminationreasons ID of this termination reasons
	*/
	@Override
	public void setTerminationreasonsId(long terminationreasonsId) {
		_terminationReasons.setTerminationreasonsId(terminationreasonsId);
	}

	/**
	* Returns the company ID of this termination reasons.
	*
	* @return the company ID of this termination reasons
	*/
	@Override
	public long getCompanyId() {
		return _terminationReasons.getCompanyId();
	}

	/**
	* Sets the company ID of this termination reasons.
	*
	* @param companyId the company ID of this termination reasons
	*/
	@Override
	public void setCompanyId(long companyId) {
		_terminationReasons.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this termination reasons.
	*
	* @return the group ID of this termination reasons
	*/
	@Override
	public long getGroupId() {
		return _terminationReasons.getGroupId();
	}

	/**
	* Sets the group ID of this termination reasons.
	*
	* @param groupId the group ID of this termination reasons
	*/
	@Override
	public void setGroupId(long groupId) {
		_terminationReasons.setGroupId(groupId);
	}

	/**
	* Returns the create date of this termination reasons.
	*
	* @return the create date of this termination reasons
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _terminationReasons.getCreateDate();
	}

	/**
	* Sets the create date of this termination reasons.
	*
	* @param createDate the create date of this termination reasons
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_terminationReasons.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this termination reasons.
	*
	* @return the modified date of this termination reasons
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _terminationReasons.getModifiedDate();
	}

	/**
	* Sets the modified date of this termination reasons.
	*
	* @param modifiedDate the modified date of this termination reasons
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_terminationReasons.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this termination reasons.
	*
	* @return the user ID of this termination reasons
	*/
	@Override
	public long getUserId() {
		return _terminationReasons.getUserId();
	}

	/**
	* Sets the user ID of this termination reasons.
	*
	* @param userId the user ID of this termination reasons
	*/
	@Override
	public void setUserId(long userId) {
		_terminationReasons.setUserId(userId);
	}

	/**
	* Returns the user uuid of this termination reasons.
	*
	* @return the user uuid of this termination reasons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasons.getUserUuid();
	}

	/**
	* Sets the user uuid of this termination reasons.
	*
	* @param userUuid the user uuid of this termination reasons
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_terminationReasons.setUserUuid(userUuid);
	}

	/**
	* Returns the terminationreasons name of this termination reasons.
	*
	* @return the terminationreasons name of this termination reasons
	*/
	@Override
	public java.lang.String getTerminationreasonsName() {
		return _terminationReasons.getTerminationreasonsName();
	}

	/**
	* Sets the terminationreasons name of this termination reasons.
	*
	* @param terminationreasonsName the terminationreasons name of this termination reasons
	*/
	@Override
	public void setTerminationreasonsName(
		java.lang.String terminationreasonsName) {
		_terminationReasons.setTerminationreasonsName(terminationreasonsName);
	}

	@Override
	public boolean isNew() {
		return _terminationReasons.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_terminationReasons.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _terminationReasons.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_terminationReasons.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _terminationReasons.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _terminationReasons.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_terminationReasons.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _terminationReasons.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_terminationReasons.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_terminationReasons.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_terminationReasons.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TerminationReasonsWrapper((TerminationReasons)_terminationReasons.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons) {
		return _terminationReasons.compareTo(terminationReasons);
	}

	@Override
	public int hashCode() {
		return _terminationReasons.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.TerminationReasons> toCacheModel() {
		return _terminationReasons.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons toEscapedModel() {
		return new TerminationReasonsWrapper(_terminationReasons.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons toUnescapedModel() {
		return new TerminationReasonsWrapper(_terminationReasons.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _terminationReasons.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _terminationReasons.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_terminationReasons.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TerminationReasonsWrapper)) {
			return false;
		}

		TerminationReasonsWrapper terminationReasonsWrapper = (TerminationReasonsWrapper)obj;

		if (Validator.equals(_terminationReasons,
					terminationReasonsWrapper._terminationReasons)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TerminationReasons getWrappedTerminationReasons() {
		return _terminationReasons;
	}

	@Override
	public TerminationReasons getWrappedModel() {
		return _terminationReasons;
	}

	@Override
	public void resetOriginalValues() {
		_terminationReasons.resetOriginalValues();
	}

	private TerminationReasons _terminationReasons;
}