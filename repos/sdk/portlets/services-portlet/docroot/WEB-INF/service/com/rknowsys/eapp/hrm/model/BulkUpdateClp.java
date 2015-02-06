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

import com.rknowsys.eapp.hrm.service.BulkUpdateLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class BulkUpdateClp extends BaseModelImpl<BulkUpdate>
	implements BulkUpdate {
	public BulkUpdateClp() {
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
	public long getPrimaryKey() {
		return _bulkupdateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBulkupdateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bulkupdateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getBulkupdateId() {
		return _bulkupdateId;
	}

	@Override
	public void setBulkupdateId(long bulkupdateId) {
		_bulkupdateId = bulkupdateId;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setBulkupdateId", long.class);

				method.invoke(_bulkUpdateRemoteModel, bulkupdateId);
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

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_bulkUpdateRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeNo() {
		return _employeeNo;
	}

	@Override
	public void setEmployeeNo(long employeeNo) {
		_employeeNo = employeeNo;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeNo", long.class);

				method.invoke(_bulkUpdateRemoteModel, employeeNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeName() {
		return _employeeName;
	}

	@Override
	public void setEmployeeName(String employeeName) {
		_employeeName = employeeName;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeName", String.class);

				method.invoke(_bulkUpdateRemoteModel, employeeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmploymentStatus() {
		return _employmentStatus;
	}

	@Override
	public void setEmploymentStatus(String employmentStatus) {
		_employmentStatus = employmentStatus;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentStatus",
						String.class);

				method.invoke(_bulkUpdateRemoteModel, employmentStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_bulkUpdateRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobtitleId() {
		return _jobtitleId;
	}

	@Override
	public void setJobtitleId(long jobtitleId) {
		_jobtitleId = jobtitleId;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setJobtitleId", long.class);

				method.invoke(_bulkUpdateRemoteModel, jobtitleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubunit() {
		return _subunit;
	}

	@Override
	public void setSubunit(String subunit) {
		_subunit = subunit;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubunit", String.class);

				method.invoke(_bulkUpdateRemoteModel, subunit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubunitId() {
		return _subunitId;
	}

	@Override
	public void setSubunitId(long subunitId) {
		_subunitId = subunitId;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubunitId", long.class);

				method.invoke(_bulkUpdateRemoteModel, subunitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_bulkUpdateRemoteModel, location);
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

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_bulkUpdateRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkshift() {
		return _workshift;
	}

	@Override
	public void setWorkshift(String workshift) {
		_workshift = workshift;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkshift", String.class);

				method.invoke(_bulkUpdateRemoteModel, workshift);
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

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setShiftId", long.class);

				method.invoke(_bulkUpdateRemoteModel, shiftId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJoiningDate() {
		return _joiningDate;
	}

	@Override
	public void setJoiningDate(Date joiningDate) {
		_joiningDate = joiningDate;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setJoiningDate", Date.class);

				method.invoke(_bulkUpdateRemoteModel, joiningDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisor() {
		return _supervisor;
	}

	@Override
	public void setSupervisor(String supervisor) {
		_supervisor = supervisor;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisor", String.class);

				method.invoke(_bulkUpdateRemoteModel, supervisor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmpStatus() {
		return _empStatus;
	}

	@Override
	public void setEmpStatus(long empStatus) {
		_empStatus = empStatus;

		if (_bulkUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _bulkUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpStatus", long.class);

				method.invoke(_bulkUpdateRemoteModel, empStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBulkUpdateRemoteModel() {
		return _bulkUpdateRemoteModel;
	}

	public void setBulkUpdateRemoteModel(BaseModel<?> bulkUpdateRemoteModel) {
		_bulkUpdateRemoteModel = bulkUpdateRemoteModel;
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

		Class<?> remoteModelClass = _bulkUpdateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bulkUpdateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BulkUpdateLocalServiceUtil.addBulkUpdate(this);
		}
		else {
			BulkUpdateLocalServiceUtil.updateBulkUpdate(this);
		}
	}

	@Override
	public BulkUpdate toEscapedModel() {
		return (BulkUpdate)ProxyUtil.newProxyInstance(BulkUpdate.class.getClassLoader(),
			new Class[] { BulkUpdate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BulkUpdateClp clone = new BulkUpdateClp();

		clone.setBulkupdateId(getBulkupdateId());
		clone.setEmployeeId(getEmployeeId());
		clone.setEmployeeNo(getEmployeeNo());
		clone.setEmployeeName(getEmployeeName());
		clone.setEmploymentStatus(getEmploymentStatus());
		clone.setJobTitle(getJobTitle());
		clone.setJobtitleId(getJobtitleId());
		clone.setSubunit(getSubunit());
		clone.setSubunitId(getSubunitId());
		clone.setLocation(getLocation());
		clone.setLocationId(getLocationId());
		clone.setWorkshift(getWorkshift());
		clone.setShiftId(getShiftId());
		clone.setJoiningDate(getJoiningDate());
		clone.setSupervisor(getSupervisor());
		clone.setEmpStatus(getEmpStatus());

		return clone;
	}

	@Override
	public int compareTo(BulkUpdate bulkUpdate) {
		long primaryKey = bulkUpdate.getPrimaryKey();

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

		if (!(obj instanceof BulkUpdateClp)) {
			return false;
		}

		BulkUpdateClp bulkUpdate = (BulkUpdateClp)obj;

		long primaryKey = bulkUpdate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{bulkupdateId=");
		sb.append(getBulkupdateId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", employeeNo=");
		sb.append(getEmployeeNo());
		sb.append(", employeeName=");
		sb.append(getEmployeeName());
		sb.append(", employmentStatus=");
		sb.append(getEmploymentStatus());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", jobtitleId=");
		sb.append(getJobtitleId());
		sb.append(", subunit=");
		sb.append(getSubunit());
		sb.append(", subunitId=");
		sb.append(getSubunitId());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", workshift=");
		sb.append(getWorkshift());
		sb.append(", shiftId=");
		sb.append(getShiftId());
		sb.append(", joiningDate=");
		sb.append(getJoiningDate());
		sb.append(", supervisor=");
		sb.append(getSupervisor());
		sb.append(", empStatus=");
		sb.append(getEmpStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.BulkUpdate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bulkupdateId</column-name><column-value><![CDATA[");
		sb.append(getBulkupdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNo</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeName</column-name><column-value><![CDATA[");
		sb.append(getEmployeeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentStatus</column-name><column-value><![CDATA[");
		sb.append(getEmploymentStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobtitleId</column-name><column-value><![CDATA[");
		sb.append(getJobtitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subunit</column-name><column-value><![CDATA[");
		sb.append(getSubunit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subunitId</column-name><column-value><![CDATA[");
		sb.append(getSubunitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workshift</column-name><column-value><![CDATA[");
		sb.append(getWorkshift());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shiftId</column-name><column-value><![CDATA[");
		sb.append(getShiftId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joiningDate</column-name><column-value><![CDATA[");
		sb.append(getJoiningDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisor</column-name><column-value><![CDATA[");
		sb.append(getSupervisor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empStatus</column-name><column-value><![CDATA[");
		sb.append(getEmpStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bulkupdateId;
	private long _employeeId;
	private long _employeeNo;
	private String _employeeName;
	private String _employmentStatus;
	private String _jobTitle;
	private long _jobtitleId;
	private String _subunit;
	private long _subunitId;
	private String _location;
	private long _locationId;
	private String _workshift;
	private long _shiftId;
	private Date _joiningDate;
	private String _supervisor;
	private long _empStatus;
	private BaseModel<?> _bulkUpdateRemoteModel;
}