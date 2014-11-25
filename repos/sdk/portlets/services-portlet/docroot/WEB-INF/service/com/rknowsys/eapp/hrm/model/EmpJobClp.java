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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpJobClp extends BaseModelImpl<EmpJob> implements EmpJob {
	public EmpJobClp() {
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
	public long getPrimaryKey() {
		return _empJobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empJobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmpJobId() {
		return _empJobId;
	}

	@Override
	public void setEmpJobId(long empJobId) {
		_empJobId = empJobId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpJobId", long.class);

				method.invoke(_empJobRemoteModel, empJobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empJobRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empJobRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empJobRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empJobRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empJobRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empJobRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getJoinedDate() {
		return _joinedDate;
	}

	@Override
	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinedDate", Date.class);

				method.invoke(_empJobRemoteModel, joinedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getProbationEndDate() {
		return _probationEndDate;
	}

	@Override
	public void setProbationEndDate(Date probationEndDate) {
		_probationEndDate = probationEndDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setProbationEndDate",
						Date.class);

				method.invoke(_empJobRemoteModel, probationEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPermanentDate() {
		return _permanentDate;
	}

	@Override
	public void setPermanentDate(Date permanentDate) {
		_permanentDate = permanentDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setPermanentDate", Date.class);

				method.invoke(_empJobRemoteModel, permanentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobTitleId() {
		return _jobTitleId;
	}

	@Override
	public void setJobTitleId(long jobTitleId) {
		_jobTitleId = jobTitleId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitleId", long.class);

				method.invoke(_empJobRemoteModel, jobTitleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentStatusId",
						long.class);

				method.invoke(_empJobRemoteModel, employmentStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobCategoryId() {
		return _jobCategoryId;
	}

	@Override
	public void setJobCategoryId(long jobCategoryId) {
		_jobCategoryId = jobCategoryId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobCategoryId", long.class);

				method.invoke(_empJobRemoteModel, jobCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubUnitId() {
		return _subUnitId;
	}

	@Override
	public void setSubUnitId(long subUnitId) {
		_subUnitId = subUnitId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setSubUnitId", long.class);

				method.invoke(_empJobRemoteModel, subUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_empJobRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_empJobRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShiftId() {
		return _shiftId;
	}

	@Override
	public void setShiftId(long shiftId) {
		_shiftId = shiftId;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setShiftId", long.class);

				method.invoke(_empJobRemoteModel, shiftId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_empJobRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEmploymentContractStartDate() {
		return _employmentContractStartDate;
	}

	@Override
	public void setEmploymentContractStartDate(Date employmentContractStartDate) {
		_employmentContractStartDate = employmentContractStartDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentContractStartDate",
						Date.class);

				method.invoke(_empJobRemoteModel, employmentContractStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEmploymentContractEndDate() {
		return _employmentContractEndDate;
	}

	@Override
	public void setEmploymentContractEndDate(Date employmentContractEndDate) {
		_employmentContractEndDate = employmentContractEndDate;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentContractEndDate",
						Date.class);

				method.invoke(_empJobRemoteModel, employmentContractEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getContractDetails() {
		return _contractDetails;
	}

	@Override
	public void setContractDetails(Blob contractDetails) {
		_contractDetails = contractDetails;

		if (_empJobRemoteModel != null) {
			try {
				Class<?> clazz = _empJobRemoteModel.getClass();

				Method method = clazz.getMethod("setContractDetails", Blob.class);

				method.invoke(_empJobRemoteModel, contractDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpJobRemoteModel() {
		return _empJobRemoteModel;
	}

	public void setEmpJobRemoteModel(BaseModel<?> empJobRemoteModel) {
		_empJobRemoteModel = empJobRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _empJobRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_empJobRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpJobLocalServiceUtil.addEmpJob(this);
		}
		else {
			EmpJobLocalServiceUtil.updateEmpJob(this);
		}
	}

	@Override
	public EmpJob toEscapedModel() {
		return (EmpJob)ProxyUtil.newProxyInstance(EmpJob.class.getClassLoader(),
			new Class[] { EmpJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpJobClp clone = new EmpJobClp();

		clone.setEmpJobId(getEmpJobId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setJoinedDate(getJoinedDate());
		clone.setProbationEndDate(getProbationEndDate());
		clone.setPermanentDate(getPermanentDate());
		clone.setJobTitleId(getJobTitleId());
		clone.setEmploymentStatusId(getEmploymentStatusId());
		clone.setJobCategoryId(getJobCategoryId());
		clone.setSubUnitId(getSubUnitId());
		clone.setLocationId(getLocationId());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setShiftId(getShiftId());
		clone.setComments(getComments());
		clone.setEmploymentContractStartDate(getEmploymentContractStartDate());
		clone.setEmploymentContractEndDate(getEmploymentContractEndDate());
		clone.setContractDetails(getContractDetails());

		return clone;
	}

	@Override
	public int compareTo(EmpJob empJob) {
		long primaryKey = empJob.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpJobClp)) {
			return false;
		}

		EmpJobClp empJob = (EmpJobClp)obj;

		long primaryKey = empJob.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{empJobId=");
		sb.append(getEmpJobId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", joinedDate=");
		sb.append(getJoinedDate());
		sb.append(", probationEndDate=");
		sb.append(getProbationEndDate());
		sb.append(", permanentDate=");
		sb.append(getPermanentDate());
		sb.append(", jobTitleId=");
		sb.append(getJobTitleId());
		sb.append(", employmentStatusId=");
		sb.append(getEmploymentStatusId());
		sb.append(", jobCategoryId=");
		sb.append(getJobCategoryId());
		sb.append(", subUnitId=");
		sb.append(getSubUnitId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", shiftId=");
		sb.append(getShiftId());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", employmentContractStartDate=");
		sb.append(getEmploymentContractStartDate());
		sb.append(", employmentContractEndDate=");
		sb.append(getEmploymentContractEndDate());
		sb.append(", contractDetails=");
		sb.append(getContractDetails());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empJobId</column-name><column-value><![CDATA[");
		sb.append(getEmpJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinedDate</column-name><column-value><![CDATA[");
		sb.append(getJoinedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>probationEndDate</column-name><column-value><![CDATA[");
		sb.append(getProbationEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permanentDate</column-name><column-value><![CDATA[");
		sb.append(getPermanentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitleId</column-name><column-value><![CDATA[");
		sb.append(getJobTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentStatusId</column-name><column-value><![CDATA[");
		sb.append(getEmploymentStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobCategoryId</column-name><column-value><![CDATA[");
		sb.append(getJobCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subUnitId</column-name><column-value><![CDATA[");
		sb.append(getSubUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shiftId</column-name><column-value><![CDATA[");
		sb.append(getShiftId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentContractStartDate</column-name><column-value><![CDATA[");
		sb.append(getEmploymentContractStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentContractEndDate</column-name><column-value><![CDATA[");
		sb.append(getEmploymentContractEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractDetails</column-name><column-value><![CDATA[");
		sb.append(getContractDetails());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empJobId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private Date _joinedDate;
	private Date _probationEndDate;
	private Date _permanentDate;
	private long _jobTitleId;
	private long _employmentStatusId;
	private long _jobCategoryId;
	private long _subUnitId;
	private long _locationId;
	private Date _effectiveDate;
	private long _shiftId;
	private String _comments;
	private Date _employmentContractStartDate;
	private Date _employmentContractEndDate;
	private Blob _contractDetails;
	private BaseModel<?> _empJobRemoteModel;
}