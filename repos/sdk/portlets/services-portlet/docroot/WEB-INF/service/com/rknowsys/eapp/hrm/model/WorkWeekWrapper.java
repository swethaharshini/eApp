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
 * This class is a wrapper for {@link WorkWeek}.
 * </p>
 *
 * @author rknowsys
 * @see WorkWeek
 * @generated
 */
public class WorkWeekWrapper implements WorkWeek, ModelWrapper<WorkWeek> {
	public WorkWeekWrapper(WorkWeek workWeek) {
		_workWeek = workWeek;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkWeek.class;
	}

	@Override
	public String getModelClassName() {
		return WorkWeek.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workWeekId", getWorkWeekId());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("mondayWorkSchedule", getMondayWorkSchedule());
		attributes.put("tuesdayWorkSchedule", getTuesdayWorkSchedule());
		attributes.put("wednesdayWorkSchedule", getWednesdayWorkSchedule());
		attributes.put("thursdayWorkSchedule", getThursdayWorkSchedule());
		attributes.put("fridayWorkSchedule", getFridayWorkSchedule());
		attributes.put("saturdayWorkSchedule", getSaturdayWorkSchedule());
		attributes.put("sundayWorkSchedule", getSundayWorkSchedule());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workWeekId = (Long)attributes.get("workWeekId");

		if (workWeekId != null) {
			setWorkWeekId(workWeekId);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		Integer mondayWorkSchedule = (Integer)attributes.get(
				"mondayWorkSchedule");

		if (mondayWorkSchedule != null) {
			setMondayWorkSchedule(mondayWorkSchedule);
		}

		Integer tuesdayWorkSchedule = (Integer)attributes.get(
				"tuesdayWorkSchedule");

		if (tuesdayWorkSchedule != null) {
			setTuesdayWorkSchedule(tuesdayWorkSchedule);
		}

		Integer wednesdayWorkSchedule = (Integer)attributes.get(
				"wednesdayWorkSchedule");

		if (wednesdayWorkSchedule != null) {
			setWednesdayWorkSchedule(wednesdayWorkSchedule);
		}

		Integer thursdayWorkSchedule = (Integer)attributes.get(
				"thursdayWorkSchedule");

		if (thursdayWorkSchedule != null) {
			setThursdayWorkSchedule(thursdayWorkSchedule);
		}

		Integer fridayWorkSchedule = (Integer)attributes.get(
				"fridayWorkSchedule");

		if (fridayWorkSchedule != null) {
			setFridayWorkSchedule(fridayWorkSchedule);
		}

		Integer saturdayWorkSchedule = (Integer)attributes.get(
				"saturdayWorkSchedule");

		if (saturdayWorkSchedule != null) {
			setSaturdayWorkSchedule(saturdayWorkSchedule);
		}

		Integer sundayWorkSchedule = (Integer)attributes.get(
				"sundayWorkSchedule");

		if (sundayWorkSchedule != null) {
			setSundayWorkSchedule(sundayWorkSchedule);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this WorkWeek.
	*
	* @return the primary key of this WorkWeek
	*/
	@Override
	public long getPrimaryKey() {
		return _workWeek.getPrimaryKey();
	}

	/**
	* Sets the primary key of this WorkWeek.
	*
	* @param primaryKey the primary key of this WorkWeek
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workWeek.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the work week ID of this WorkWeek.
	*
	* @return the work week ID of this WorkWeek
	*/
	@Override
	public long getWorkWeekId() {
		return _workWeek.getWorkWeekId();
	}

	/**
	* Sets the work week ID of this WorkWeek.
	*
	* @param workWeekId the work week ID of this WorkWeek
	*/
	@Override
	public void setWorkWeekId(long workWeekId) {
		_workWeek.setWorkWeekId(workWeekId);
	}

	/**
	* Returns the nationality ID of this WorkWeek.
	*
	* @return the nationality ID of this WorkWeek
	*/
	@Override
	public long getNationalityId() {
		return _workWeek.getNationalityId();
	}

	/**
	* Sets the nationality ID of this WorkWeek.
	*
	* @param nationalityId the nationality ID of this WorkWeek
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_workWeek.setNationalityId(nationalityId);
	}

	/**
	* Returns the monday work schedule of this WorkWeek.
	*
	* @return the monday work schedule of this WorkWeek
	*/
	@Override
	public int getMondayWorkSchedule() {
		return _workWeek.getMondayWorkSchedule();
	}

	/**
	* Sets the monday work schedule of this WorkWeek.
	*
	* @param mondayWorkSchedule the monday work schedule of this WorkWeek
	*/
	@Override
	public void setMondayWorkSchedule(int mondayWorkSchedule) {
		_workWeek.setMondayWorkSchedule(mondayWorkSchedule);
	}

	/**
	* Returns the tuesday work schedule of this WorkWeek.
	*
	* @return the tuesday work schedule of this WorkWeek
	*/
	@Override
	public int getTuesdayWorkSchedule() {
		return _workWeek.getTuesdayWorkSchedule();
	}

	/**
	* Sets the tuesday work schedule of this WorkWeek.
	*
	* @param tuesdayWorkSchedule the tuesday work schedule of this WorkWeek
	*/
	@Override
	public void setTuesdayWorkSchedule(int tuesdayWorkSchedule) {
		_workWeek.setTuesdayWorkSchedule(tuesdayWorkSchedule);
	}

	/**
	* Returns the wednesday work schedule of this WorkWeek.
	*
	* @return the wednesday work schedule of this WorkWeek
	*/
	@Override
	public int getWednesdayWorkSchedule() {
		return _workWeek.getWednesdayWorkSchedule();
	}

	/**
	* Sets the wednesday work schedule of this WorkWeek.
	*
	* @param wednesdayWorkSchedule the wednesday work schedule of this WorkWeek
	*/
	@Override
	public void setWednesdayWorkSchedule(int wednesdayWorkSchedule) {
		_workWeek.setWednesdayWorkSchedule(wednesdayWorkSchedule);
	}

	/**
	* Returns the thursday work schedule of this WorkWeek.
	*
	* @return the thursday work schedule of this WorkWeek
	*/
	@Override
	public int getThursdayWorkSchedule() {
		return _workWeek.getThursdayWorkSchedule();
	}

	/**
	* Sets the thursday work schedule of this WorkWeek.
	*
	* @param thursdayWorkSchedule the thursday work schedule of this WorkWeek
	*/
	@Override
	public void setThursdayWorkSchedule(int thursdayWorkSchedule) {
		_workWeek.setThursdayWorkSchedule(thursdayWorkSchedule);
	}

	/**
	* Returns the friday work schedule of this WorkWeek.
	*
	* @return the friday work schedule of this WorkWeek
	*/
	@Override
	public int getFridayWorkSchedule() {
		return _workWeek.getFridayWorkSchedule();
	}

	/**
	* Sets the friday work schedule of this WorkWeek.
	*
	* @param fridayWorkSchedule the friday work schedule of this WorkWeek
	*/
	@Override
	public void setFridayWorkSchedule(int fridayWorkSchedule) {
		_workWeek.setFridayWorkSchedule(fridayWorkSchedule);
	}

	/**
	* Returns the saturday work schedule of this WorkWeek.
	*
	* @return the saturday work schedule of this WorkWeek
	*/
	@Override
	public int getSaturdayWorkSchedule() {
		return _workWeek.getSaturdayWorkSchedule();
	}

	/**
	* Sets the saturday work schedule of this WorkWeek.
	*
	* @param saturdayWorkSchedule the saturday work schedule of this WorkWeek
	*/
	@Override
	public void setSaturdayWorkSchedule(int saturdayWorkSchedule) {
		_workWeek.setSaturdayWorkSchedule(saturdayWorkSchedule);
	}

	/**
	* Returns the sunday work schedule of this WorkWeek.
	*
	* @return the sunday work schedule of this WorkWeek
	*/
	@Override
	public int getSundayWorkSchedule() {
		return _workWeek.getSundayWorkSchedule();
	}

	/**
	* Sets the sunday work schedule of this WorkWeek.
	*
	* @param sundayWorkSchedule the sunday work schedule of this WorkWeek
	*/
	@Override
	public void setSundayWorkSchedule(int sundayWorkSchedule) {
		_workWeek.setSundayWorkSchedule(sundayWorkSchedule);
	}

	/**
	* Returns the group ID of this WorkWeek.
	*
	* @return the group ID of this WorkWeek
	*/
	@Override
	public long getGroupId() {
		return _workWeek.getGroupId();
	}

	/**
	* Sets the group ID of this WorkWeek.
	*
	* @param groupId the group ID of this WorkWeek
	*/
	@Override
	public void setGroupId(long groupId) {
		_workWeek.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this WorkWeek.
	*
	* @return the company ID of this WorkWeek
	*/
	@Override
	public long getCompanyId() {
		return _workWeek.getCompanyId();
	}

	/**
	* Sets the company ID of this WorkWeek.
	*
	* @param companyId the company ID of this WorkWeek
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workWeek.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this WorkWeek.
	*
	* @return the user ID of this WorkWeek
	*/
	@Override
	public long getUserId() {
		return _workWeek.getUserId();
	}

	/**
	* Sets the user ID of this WorkWeek.
	*
	* @param userId the user ID of this WorkWeek
	*/
	@Override
	public void setUserId(long userId) {
		_workWeek.setUserId(userId);
	}

	/**
	* Returns the user uuid of this WorkWeek.
	*
	* @return the user uuid of this WorkWeek
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeek.getUserUuid();
	}

	/**
	* Sets the user uuid of this WorkWeek.
	*
	* @param userUuid the user uuid of this WorkWeek
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workWeek.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this WorkWeek.
	*
	* @return the user name of this WorkWeek
	*/
	@Override
	public java.lang.String getUserName() {
		return _workWeek.getUserName();
	}

	/**
	* Sets the user name of this WorkWeek.
	*
	* @param userName the user name of this WorkWeek
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_workWeek.setUserName(userName);
	}

	/**
	* Returns the create date of this WorkWeek.
	*
	* @return the create date of this WorkWeek
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workWeek.getCreateDate();
	}

	/**
	* Sets the create date of this WorkWeek.
	*
	* @param createDate the create date of this WorkWeek
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workWeek.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this WorkWeek.
	*
	* @return the modified date of this WorkWeek
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workWeek.getModifiedDate();
	}

	/**
	* Sets the modified date of this WorkWeek.
	*
	* @param modifiedDate the modified date of this WorkWeek
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workWeek.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _workWeek.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workWeek.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workWeek.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workWeek.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workWeek.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workWeek.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workWeek.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workWeek.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workWeek.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workWeek.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workWeek.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkWeekWrapper((WorkWeek)_workWeek.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.WorkWeek workWeek) {
		return _workWeek.compareTo(workWeek);
	}

	@Override
	public int hashCode() {
		return _workWeek.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.WorkWeek> toCacheModel() {
		return _workWeek.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek toEscapedModel() {
		return new WorkWeekWrapper(_workWeek.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek toUnescapedModel() {
		return new WorkWeekWrapper(_workWeek.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workWeek.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workWeek.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workWeek.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkWeekWrapper)) {
			return false;
		}

		WorkWeekWrapper workWeekWrapper = (WorkWeekWrapper)obj;

		if (Validator.equals(_workWeek, workWeekWrapper._workWeek)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkWeek getWrappedWorkWeek() {
		return _workWeek;
	}

	@Override
	public WorkWeek getWrappedModel() {
		return _workWeek;
	}

	@Override
	public void resetOriginalValues() {
		_workWeek.resetOriginalValues();
	}

	private WorkWeek _workWeek;
}