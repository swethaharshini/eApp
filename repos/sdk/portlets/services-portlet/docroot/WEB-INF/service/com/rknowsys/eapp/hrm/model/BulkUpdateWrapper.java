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
 * This class is a wrapper for {@link BulkUpdate}.
 * </p>
 *
 * @author rknowsys
 * @see BulkUpdate
 * @generated
 */
public class BulkUpdateWrapper implements BulkUpdate, ModelWrapper<BulkUpdate> {
	public BulkUpdateWrapper(BulkUpdate bulkUpdate) {
		_bulkUpdate = bulkUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return BulkUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return BulkUpdate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bulkupdateId", getBulkupdateId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("employeeName", getEmployeeName());
		attributes.put("employmentStatus", getEmploymentStatus());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobtitleId", getJobtitleId());
		attributes.put("subunit", getSubunit());
		attributes.put("subunitId", getSubunitId());
		attributes.put("location", getLocation());
		attributes.put("locationId", getLocationId());
		attributes.put("workshift", getWorkshift());
		attributes.put("shiftId", getShiftId());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("supervisor", getSupervisor());
		attributes.put("empStatus", getEmpStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bulkupdateId = (Long)attributes.get("bulkupdateId");

		if (bulkupdateId != null) {
			setBulkupdateId(bulkupdateId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long employeeNo = (Long)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
		}

		String employeeName = (String)attributes.get("employeeName");

		if (employeeName != null) {
			setEmployeeName(employeeName);
		}

		String employmentStatus = (String)attributes.get("employmentStatus");

		if (employmentStatus != null) {
			setEmploymentStatus(employmentStatus);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Long jobtitleId = (Long)attributes.get("jobtitleId");

		if (jobtitleId != null) {
			setJobtitleId(jobtitleId);
		}

		String subunit = (String)attributes.get("subunit");

		if (subunit != null) {
			setSubunit(subunit);
		}

		Long subunitId = (Long)attributes.get("subunitId");

		if (subunitId != null) {
			setSubunitId(subunitId);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String workshift = (String)attributes.get("workshift");

		if (workshift != null) {
			setWorkshift(workshift);
		}

		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		String supervisor = (String)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}

		Long empStatus = (Long)attributes.get("empStatus");

		if (empStatus != null) {
			setEmpStatus(empStatus);
		}
	}

	/**
	* Returns the primary key of this bulk update.
	*
	* @return the primary key of this bulk update
	*/
	@Override
	public long getPrimaryKey() {
		return _bulkUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bulk update.
	*
	* @param primaryKey the primary key of this bulk update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bulkUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bulkupdate ID of this bulk update.
	*
	* @return the bulkupdate ID of this bulk update
	*/
	@Override
	public long getBulkupdateId() {
		return _bulkUpdate.getBulkupdateId();
	}

	/**
	* Sets the bulkupdate ID of this bulk update.
	*
	* @param bulkupdateId the bulkupdate ID of this bulk update
	*/
	@Override
	public void setBulkupdateId(long bulkupdateId) {
		_bulkUpdate.setBulkupdateId(bulkupdateId);
	}

	/**
	* Returns the employee ID of this bulk update.
	*
	* @return the employee ID of this bulk update
	*/
	@Override
	public long getEmployeeId() {
		return _bulkUpdate.getEmployeeId();
	}

	/**
	* Sets the employee ID of this bulk update.
	*
	* @param employeeId the employee ID of this bulk update
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_bulkUpdate.setEmployeeId(employeeId);
	}

	/**
	* Returns the employee no of this bulk update.
	*
	* @return the employee no of this bulk update
	*/
	@Override
	public long getEmployeeNo() {
		return _bulkUpdate.getEmployeeNo();
	}

	/**
	* Sets the employee no of this bulk update.
	*
	* @param employeeNo the employee no of this bulk update
	*/
	@Override
	public void setEmployeeNo(long employeeNo) {
		_bulkUpdate.setEmployeeNo(employeeNo);
	}

	/**
	* Returns the employee name of this bulk update.
	*
	* @return the employee name of this bulk update
	*/
	@Override
	public java.lang.String getEmployeeName() {
		return _bulkUpdate.getEmployeeName();
	}

	/**
	* Sets the employee name of this bulk update.
	*
	* @param employeeName the employee name of this bulk update
	*/
	@Override
	public void setEmployeeName(java.lang.String employeeName) {
		_bulkUpdate.setEmployeeName(employeeName);
	}

	/**
	* Returns the employment status of this bulk update.
	*
	* @return the employment status of this bulk update
	*/
	@Override
	public java.lang.String getEmploymentStatus() {
		return _bulkUpdate.getEmploymentStatus();
	}

	/**
	* Sets the employment status of this bulk update.
	*
	* @param employmentStatus the employment status of this bulk update
	*/
	@Override
	public void setEmploymentStatus(java.lang.String employmentStatus) {
		_bulkUpdate.setEmploymentStatus(employmentStatus);
	}

	/**
	* Returns the job title of this bulk update.
	*
	* @return the job title of this bulk update
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _bulkUpdate.getJobTitle();
	}

	/**
	* Sets the job title of this bulk update.
	*
	* @param jobTitle the job title of this bulk update
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_bulkUpdate.setJobTitle(jobTitle);
	}

	/**
	* Returns the jobtitle ID of this bulk update.
	*
	* @return the jobtitle ID of this bulk update
	*/
	@Override
	public long getJobtitleId() {
		return _bulkUpdate.getJobtitleId();
	}

	/**
	* Sets the jobtitle ID of this bulk update.
	*
	* @param jobtitleId the jobtitle ID of this bulk update
	*/
	@Override
	public void setJobtitleId(long jobtitleId) {
		_bulkUpdate.setJobtitleId(jobtitleId);
	}

	/**
	* Returns the subunit of this bulk update.
	*
	* @return the subunit of this bulk update
	*/
	@Override
	public java.lang.String getSubunit() {
		return _bulkUpdate.getSubunit();
	}

	/**
	* Sets the subunit of this bulk update.
	*
	* @param subunit the subunit of this bulk update
	*/
	@Override
	public void setSubunit(java.lang.String subunit) {
		_bulkUpdate.setSubunit(subunit);
	}

	/**
	* Returns the subunit ID of this bulk update.
	*
	* @return the subunit ID of this bulk update
	*/
	@Override
	public long getSubunitId() {
		return _bulkUpdate.getSubunitId();
	}

	/**
	* Sets the subunit ID of this bulk update.
	*
	* @param subunitId the subunit ID of this bulk update
	*/
	@Override
	public void setSubunitId(long subunitId) {
		_bulkUpdate.setSubunitId(subunitId);
	}

	/**
	* Returns the location of this bulk update.
	*
	* @return the location of this bulk update
	*/
	@Override
	public java.lang.String getLocation() {
		return _bulkUpdate.getLocation();
	}

	/**
	* Sets the location of this bulk update.
	*
	* @param location the location of this bulk update
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_bulkUpdate.setLocation(location);
	}

	/**
	* Returns the location ID of this bulk update.
	*
	* @return the location ID of this bulk update
	*/
	@Override
	public long getLocationId() {
		return _bulkUpdate.getLocationId();
	}

	/**
	* Sets the location ID of this bulk update.
	*
	* @param locationId the location ID of this bulk update
	*/
	@Override
	public void setLocationId(long locationId) {
		_bulkUpdate.setLocationId(locationId);
	}

	/**
	* Returns the workshift of this bulk update.
	*
	* @return the workshift of this bulk update
	*/
	@Override
	public java.lang.String getWorkshift() {
		return _bulkUpdate.getWorkshift();
	}

	/**
	* Sets the workshift of this bulk update.
	*
	* @param workshift the workshift of this bulk update
	*/
	@Override
	public void setWorkshift(java.lang.String workshift) {
		_bulkUpdate.setWorkshift(workshift);
	}

	/**
	* Returns the shift ID of this bulk update.
	*
	* @return the shift ID of this bulk update
	*/
	@Override
	public long getShiftId() {
		return _bulkUpdate.getShiftId();
	}

	/**
	* Sets the shift ID of this bulk update.
	*
	* @param shiftId the shift ID of this bulk update
	*/
	@Override
	public void setShiftId(long shiftId) {
		_bulkUpdate.setShiftId(shiftId);
	}

	/**
	* Returns the joining date of this bulk update.
	*
	* @return the joining date of this bulk update
	*/
	@Override
	public java.util.Date getJoiningDate() {
		return _bulkUpdate.getJoiningDate();
	}

	/**
	* Sets the joining date of this bulk update.
	*
	* @param joiningDate the joining date of this bulk update
	*/
	@Override
	public void setJoiningDate(java.util.Date joiningDate) {
		_bulkUpdate.setJoiningDate(joiningDate);
	}

	/**
	* Returns the supervisor of this bulk update.
	*
	* @return the supervisor of this bulk update
	*/
	@Override
	public java.lang.String getSupervisor() {
		return _bulkUpdate.getSupervisor();
	}

	/**
	* Sets the supervisor of this bulk update.
	*
	* @param supervisor the supervisor of this bulk update
	*/
	@Override
	public void setSupervisor(java.lang.String supervisor) {
		_bulkUpdate.setSupervisor(supervisor);
	}

	/**
	* Returns the emp status of this bulk update.
	*
	* @return the emp status of this bulk update
	*/
	@Override
	public long getEmpStatus() {
		return _bulkUpdate.getEmpStatus();
	}

	/**
	* Sets the emp status of this bulk update.
	*
	* @param empStatus the emp status of this bulk update
	*/
	@Override
	public void setEmpStatus(long empStatus) {
		_bulkUpdate.setEmpStatus(empStatus);
	}

	@Override
	public boolean isNew() {
		return _bulkUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bulkUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bulkUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bulkUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bulkUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bulkUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bulkUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bulkUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bulkUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bulkUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bulkUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BulkUpdateWrapper((BulkUpdate)_bulkUpdate.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.BulkUpdate bulkUpdate) {
		return _bulkUpdate.compareTo(bulkUpdate);
	}

	@Override
	public int hashCode() {
		return _bulkUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.BulkUpdate> toCacheModel() {
		return _bulkUpdate.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate toEscapedModel() {
		return new BulkUpdateWrapper(_bulkUpdate.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate toUnescapedModel() {
		return new BulkUpdateWrapper(_bulkUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bulkUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bulkUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bulkUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BulkUpdateWrapper)) {
			return false;
		}

		BulkUpdateWrapper bulkUpdateWrapper = (BulkUpdateWrapper)obj;

		if (Validator.equals(_bulkUpdate, bulkUpdateWrapper._bulkUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BulkUpdate getWrappedBulkUpdate() {
		return _bulkUpdate;
	}

	@Override
	public BulkUpdate getWrappedModel() {
		return _bulkUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_bulkUpdate.resetOriginalValues();
	}

	private BulkUpdate _bulkUpdate;
}