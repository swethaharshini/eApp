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
 * This class is a wrapper for {@link Workshift}.
 * </p>
 *
 * @author rknowsys
 * @see Workshift
 * @generated
 */
public class WorkshiftWrapper implements Workshift, ModelWrapper<Workshift> {
	public WorkshiftWrapper(Workshift workshift) {
		_workshift = workshift;
	}

	@Override
	public Class<?> getModelClass() {
		return Workshift.class;
	}

	@Override
	public String getModelClassName() {
		return Workshift.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shiftId", getShiftId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("workshiftName", getWorkshiftName());
		attributes.put("fromWorkHours", getFromWorkHours());
		attributes.put("toWorkHours", getToWorkHours());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
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

		String workshiftName = (String)attributes.get("workshiftName");

		if (workshiftName != null) {
			setWorkshiftName(workshiftName);
		}

		Date fromWorkHours = (Date)attributes.get("fromWorkHours");

		if (fromWorkHours != null) {
			setFromWorkHours(fromWorkHours);
		}

		Date toWorkHours = (Date)attributes.get("toWorkHours");

		if (toWorkHours != null) {
			setToWorkHours(toWorkHours);
		}
	}

	/**
	* Returns the primary key of this workshift.
	*
	* @return the primary key of this workshift
	*/
	@Override
	public long getPrimaryKey() {
		return _workshift.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workshift.
	*
	* @param primaryKey the primary key of this workshift
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workshift.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the shift ID of this workshift.
	*
	* @return the shift ID of this workshift
	*/
	@Override
	public long getShiftId() {
		return _workshift.getShiftId();
	}

	/**
	* Sets the shift ID of this workshift.
	*
	* @param shiftId the shift ID of this workshift
	*/
	@Override
	public void setShiftId(long shiftId) {
		_workshift.setShiftId(shiftId);
	}

	/**
	* Returns the company ID of this workshift.
	*
	* @return the company ID of this workshift
	*/
	@Override
	public long getCompanyId() {
		return _workshift.getCompanyId();
	}

	/**
	* Sets the company ID of this workshift.
	*
	* @param companyId the company ID of this workshift
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workshift.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this workshift.
	*
	* @return the group ID of this workshift
	*/
	@Override
	public long getGroupId() {
		return _workshift.getGroupId();
	}

	/**
	* Sets the group ID of this workshift.
	*
	* @param groupId the group ID of this workshift
	*/
	@Override
	public void setGroupId(long groupId) {
		_workshift.setGroupId(groupId);
	}

	/**
	* Returns the create date of this workshift.
	*
	* @return the create date of this workshift
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workshift.getCreateDate();
	}

	/**
	* Sets the create date of this workshift.
	*
	* @param createDate the create date of this workshift
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workshift.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this workshift.
	*
	* @return the modified date of this workshift
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workshift.getModifiedDate();
	}

	/**
	* Sets the modified date of this workshift.
	*
	* @param modifiedDate the modified date of this workshift
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workshift.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this workshift.
	*
	* @return the user ID of this workshift
	*/
	@Override
	public long getUserId() {
		return _workshift.getUserId();
	}

	/**
	* Sets the user ID of this workshift.
	*
	* @param userId the user ID of this workshift
	*/
	@Override
	public void setUserId(long userId) {
		_workshift.setUserId(userId);
	}

	/**
	* Returns the user uuid of this workshift.
	*
	* @return the user uuid of this workshift
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshift.getUserUuid();
	}

	/**
	* Sets the user uuid of this workshift.
	*
	* @param userUuid the user uuid of this workshift
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workshift.setUserUuid(userUuid);
	}

	/**
	* Returns the workshift name of this workshift.
	*
	* @return the workshift name of this workshift
	*/
	@Override
	public java.lang.String getWorkshiftName() {
		return _workshift.getWorkshiftName();
	}

	/**
	* Sets the workshift name of this workshift.
	*
	* @param workshiftName the workshift name of this workshift
	*/
	@Override
	public void setWorkshiftName(java.lang.String workshiftName) {
		_workshift.setWorkshiftName(workshiftName);
	}

	/**
	* Returns the from work hours of this workshift.
	*
	* @return the from work hours of this workshift
	*/
	@Override
	public java.util.Date getFromWorkHours() {
		return _workshift.getFromWorkHours();
	}

	/**
	* Sets the from work hours of this workshift.
	*
	* @param fromWorkHours the from work hours of this workshift
	*/
	@Override
	public void setFromWorkHours(java.util.Date fromWorkHours) {
		_workshift.setFromWorkHours(fromWorkHours);
	}

	/**
	* Returns the to work hours of this workshift.
	*
	* @return the to work hours of this workshift
	*/
	@Override
	public java.util.Date getToWorkHours() {
		return _workshift.getToWorkHours();
	}

	/**
	* Sets the to work hours of this workshift.
	*
	* @param toWorkHours the to work hours of this workshift
	*/
	@Override
	public void setToWorkHours(java.util.Date toWorkHours) {
		_workshift.setToWorkHours(toWorkHours);
	}

	@Override
	public boolean isNew() {
		return _workshift.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workshift.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workshift.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workshift.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workshift.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workshift.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workshift.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workshift.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workshift.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workshift.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workshift.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkshiftWrapper((Workshift)_workshift.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Workshift workshift) {
		return _workshift.compareTo(workshift);
	}

	@Override
	public int hashCode() {
		return _workshift.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Workshift> toCacheModel() {
		return _workshift.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Workshift toEscapedModel() {
		return new WorkshiftWrapper(_workshift.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Workshift toUnescapedModel() {
		return new WorkshiftWrapper(_workshift.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workshift.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workshift.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshift.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkshiftWrapper)) {
			return false;
		}

		WorkshiftWrapper workshiftWrapper = (WorkshiftWrapper)obj;

		if (Validator.equals(_workshift, workshiftWrapper._workshift)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Workshift getWrappedWorkshift() {
		return _workshift;
	}

	@Override
	public Workshift getWrappedModel() {
		return _workshift;
	}

	@Override
	public void resetOriginalValues() {
		_workshift.resetOriginalValues();
	}

	private Workshift _workshift;
}