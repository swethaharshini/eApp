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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmpJob}.
 * </p>
 *
 * @author rknowsys
 * @see EmpJob
 * @generated
 */
public class EmpJobWrapper implements EmpJob, ModelWrapper<EmpJob> {
	public EmpJobWrapper(EmpJob empJob) {
		_empJob = empJob;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpJob.class;
	}

	@Override
	public String getModelClassName() {
		return EmpJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empJobId", getEmpJobId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("probationEndDate", getProbationEndDate());
		attributes.put("permanentDate", getPermanentDate());
		attributes.put("jobTitleId", getJobTitleId());
		attributes.put("employmentStatusId", getEmploymentStatusId());
		attributes.put("jobCategoryId", getJobCategoryId());
		attributes.put("subUnitId", getSubUnitId());
		attributes.put("locationId", getLocationId());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("shiftId", getShiftId());
		attributes.put("comments", getComments());
		attributes.put("employmentContractStartDate",
			getEmploymentContractStartDate());
		attributes.put("employmentContractEndDate",
			getEmploymentContractEndDate());
		attributes.put("contractDetails", getContractDetails());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empJobId = (Long)attributes.get("empJobId");

		if (empJobId != null) {
			setEmpJobId(empJobId);
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

		Date joinedDate = (Date)attributes.get("joinedDate");

		if (joinedDate != null) {
			setJoinedDate(joinedDate);
		}

		Date probationEndDate = (Date)attributes.get("probationEndDate");

		if (probationEndDate != null) {
			setProbationEndDate(probationEndDate);
		}

		Date permanentDate = (Date)attributes.get("permanentDate");

		if (permanentDate != null) {
			setPermanentDate(permanentDate);
		}

		Long jobTitleId = (Long)attributes.get("jobTitleId");

		if (jobTitleId != null) {
			setJobTitleId(jobTitleId);
		}

		Long employmentStatusId = (Long)attributes.get("employmentStatusId");

		if (employmentStatusId != null) {
			setEmploymentStatusId(employmentStatusId);
		}

		Long jobCategoryId = (Long)attributes.get("jobCategoryId");

		if (jobCategoryId != null) {
			setJobCategoryId(jobCategoryId);
		}

		Long subUnitId = (Long)attributes.get("subUnitId");

		if (subUnitId != null) {
			setSubUnitId(subUnitId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date employmentContractStartDate = (Date)attributes.get(
				"employmentContractStartDate");

		if (employmentContractStartDate != null) {
			setEmploymentContractStartDate(employmentContractStartDate);
		}

		Date employmentContractEndDate = (Date)attributes.get(
				"employmentContractEndDate");

		if (employmentContractEndDate != null) {
			setEmploymentContractEndDate(employmentContractEndDate);
		}

		Blob contractDetails = (Blob)attributes.get("contractDetails");

		if (contractDetails != null) {
			setContractDetails(contractDetails);
		}
	}

	/**
	* Returns the primary key of this emp job.
	*
	* @return the primary key of this emp job
	*/
	@Override
	public long getPrimaryKey() {
		return _empJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp job.
	*
	* @param primaryKey the primary key of this emp job
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp job ID of this emp job.
	*
	* @return the emp job ID of this emp job
	*/
	@Override
	public long getEmpJobId() {
		return _empJob.getEmpJobId();
	}

	/**
	* Sets the emp job ID of this emp job.
	*
	* @param empJobId the emp job ID of this emp job
	*/
	@Override
	public void setEmpJobId(long empJobId) {
		_empJob.setEmpJobId(empJobId);
	}

	/**
	* Returns the employee ID of this emp job.
	*
	* @return the employee ID of this emp job
	*/
	@Override
	public long getEmployeeId() {
		return _empJob.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp job.
	*
	* @param employeeId the employee ID of this emp job
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empJob.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp job.
	*
	* @return the group ID of this emp job
	*/
	@Override
	public long getGroupId() {
		return _empJob.getGroupId();
	}

	/**
	* Sets the group ID of this emp job.
	*
	* @param groupId the group ID of this emp job
	*/
	@Override
	public void setGroupId(long groupId) {
		_empJob.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp job.
	*
	* @return the company ID of this emp job
	*/
	@Override
	public long getCompanyId() {
		return _empJob.getCompanyId();
	}

	/**
	* Sets the company ID of this emp job.
	*
	* @param companyId the company ID of this emp job
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empJob.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp job.
	*
	* @return the create date of this emp job
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empJob.getCreateDate();
	}

	/**
	* Sets the create date of this emp job.
	*
	* @param createDate the create date of this emp job
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empJob.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp job.
	*
	* @return the modified date of this emp job
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empJob.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp job.
	*
	* @param modifiedDate the modified date of this emp job
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empJob.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp job.
	*
	* @return the user ID of this emp job
	*/
	@Override
	public long getUserId() {
		return _empJob.getUserId();
	}

	/**
	* Sets the user ID of this emp job.
	*
	* @param userId the user ID of this emp job
	*/
	@Override
	public void setUserId(long userId) {
		_empJob.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp job.
	*
	* @return the user uuid of this emp job
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJob.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp job.
	*
	* @param userUuid the user uuid of this emp job
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empJob.setUserUuid(userUuid);
	}

	/**
	* Returns the joined date of this emp job.
	*
	* @return the joined date of this emp job
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _empJob.getJoinedDate();
	}

	/**
	* Sets the joined date of this emp job.
	*
	* @param joinedDate the joined date of this emp job
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_empJob.setJoinedDate(joinedDate);
	}

	/**
	* Returns the probation end date of this emp job.
	*
	* @return the probation end date of this emp job
	*/
	@Override
	public java.util.Date getProbationEndDate() {
		return _empJob.getProbationEndDate();
	}

	/**
	* Sets the probation end date of this emp job.
	*
	* @param probationEndDate the probation end date of this emp job
	*/
	@Override
	public void setProbationEndDate(java.util.Date probationEndDate) {
		_empJob.setProbationEndDate(probationEndDate);
	}

	/**
	* Returns the permanent date of this emp job.
	*
	* @return the permanent date of this emp job
	*/
	@Override
	public java.util.Date getPermanentDate() {
		return _empJob.getPermanentDate();
	}

	/**
	* Sets the permanent date of this emp job.
	*
	* @param permanentDate the permanent date of this emp job
	*/
	@Override
	public void setPermanentDate(java.util.Date permanentDate) {
		_empJob.setPermanentDate(permanentDate);
	}

	/**
	* Returns the job title ID of this emp job.
	*
	* @return the job title ID of this emp job
	*/
	@Override
	public long getJobTitleId() {
		return _empJob.getJobTitleId();
	}

	/**
	* Sets the job title ID of this emp job.
	*
	* @param jobTitleId the job title ID of this emp job
	*/
	@Override
	public void setJobTitleId(long jobTitleId) {
		_empJob.setJobTitleId(jobTitleId);
	}

	/**
	* Returns the employment status ID of this emp job.
	*
	* @return the employment status ID of this emp job
	*/
	@Override
	public long getEmploymentStatusId() {
		return _empJob.getEmploymentStatusId();
	}

	/**
	* Sets the employment status ID of this emp job.
	*
	* @param employmentStatusId the employment status ID of this emp job
	*/
	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_empJob.setEmploymentStatusId(employmentStatusId);
	}

	/**
	* Returns the job category ID of this emp job.
	*
	* @return the job category ID of this emp job
	*/
	@Override
	public long getJobCategoryId() {
		return _empJob.getJobCategoryId();
	}

	/**
	* Sets the job category ID of this emp job.
	*
	* @param jobCategoryId the job category ID of this emp job
	*/
	@Override
	public void setJobCategoryId(long jobCategoryId) {
		_empJob.setJobCategoryId(jobCategoryId);
	}

	/**
	* Returns the sub unit ID of this emp job.
	*
	* @return the sub unit ID of this emp job
	*/
	@Override
	public long getSubUnitId() {
		return _empJob.getSubUnitId();
	}

	/**
	* Sets the sub unit ID of this emp job.
	*
	* @param subUnitId the sub unit ID of this emp job
	*/
	@Override
	public void setSubUnitId(long subUnitId) {
		_empJob.setSubUnitId(subUnitId);
	}

	/**
	* Returns the location ID of this emp job.
	*
	* @return the location ID of this emp job
	*/
	@Override
	public long getLocationId() {
		return _empJob.getLocationId();
	}

	/**
	* Sets the location ID of this emp job.
	*
	* @param locationId the location ID of this emp job
	*/
	@Override
	public void setLocationId(long locationId) {
		_empJob.setLocationId(locationId);
	}

	/**
	* Returns the effective date of this emp job.
	*
	* @return the effective date of this emp job
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _empJob.getEffectiveDate();
	}

	/**
	* Sets the effective date of this emp job.
	*
	* @param effectiveDate the effective date of this emp job
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_empJob.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the shift ID of this emp job.
	*
	* @return the shift ID of this emp job
	*/
	@Override
	public long getShiftId() {
		return _empJob.getShiftId();
	}

	/**
	* Sets the shift ID of this emp job.
	*
	* @param shiftId the shift ID of this emp job
	*/
	@Override
	public void setShiftId(long shiftId) {
		_empJob.setShiftId(shiftId);
	}

	/**
	* Returns the comments of this emp job.
	*
	* @return the comments of this emp job
	*/
	@Override
	public java.lang.String getComments() {
		return _empJob.getComments();
	}

	/**
	* Sets the comments of this emp job.
	*
	* @param comments the comments of this emp job
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_empJob.setComments(comments);
	}

	/**
	* Returns the employment contract start date of this emp job.
	*
	* @return the employment contract start date of this emp job
	*/
	@Override
	public java.util.Date getEmploymentContractStartDate() {
		return _empJob.getEmploymentContractStartDate();
	}

	/**
	* Sets the employment contract start date of this emp job.
	*
	* @param employmentContractStartDate the employment contract start date of this emp job
	*/
	@Override
	public void setEmploymentContractStartDate(
		java.util.Date employmentContractStartDate) {
		_empJob.setEmploymentContractStartDate(employmentContractStartDate);
	}

	/**
	* Returns the employment contract end date of this emp job.
	*
	* @return the employment contract end date of this emp job
	*/
	@Override
	public java.util.Date getEmploymentContractEndDate() {
		return _empJob.getEmploymentContractEndDate();
	}

	/**
	* Sets the employment contract end date of this emp job.
	*
	* @param employmentContractEndDate the employment contract end date of this emp job
	*/
	@Override
	public void setEmploymentContractEndDate(
		java.util.Date employmentContractEndDate) {
		_empJob.setEmploymentContractEndDate(employmentContractEndDate);
	}

	/**
	* Returns the contract details of this emp job.
	*
	* @return the contract details of this emp job
	*/
	@Override
	public java.sql.Blob getContractDetails() {
		return _empJob.getContractDetails();
	}

	/**
	* Sets the contract details of this emp job.
	*
	* @param contractDetails the contract details of this emp job
	*/
	@Override
	public void setContractDetails(java.sql.Blob contractDetails) {
		_empJob.setContractDetails(contractDetails);
	}

	@Override
	public boolean isNew() {
		return _empJob.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empJob.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empJob.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empJob.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empJob.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empJob.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empJob.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empJob.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empJob.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empJob.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpJobWrapper((EmpJob)_empJob.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpJob empJob) {
		return _empJob.compareTo(empJob);
	}

	@Override
	public int hashCode() {
		return _empJob.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpJob> toCacheModel() {
		return _empJob.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob toEscapedModel() {
		return new EmpJobWrapper(_empJob.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob toUnescapedModel() {
		return new EmpJobWrapper(_empJob.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empJob.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empJob.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empJob.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpJobWrapper)) {
			return false;
		}

		EmpJobWrapper empJobWrapper = (EmpJobWrapper)obj;

		if (Validator.equals(_empJob, empJobWrapper._empJob)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpJob getWrappedEmpJob() {
		return _empJob;
	}

	@Override
	public EmpJob getWrappedModel() {
		return _empJob;
	}

	@Override
	public void resetOriginalValues() {
		_empJob.resetOriginalValues();
	}

	private EmpJob _empJob;
}