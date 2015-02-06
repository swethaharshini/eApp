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

package com.rknowsys.eapp.hrm.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.BulkUpdate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BulkUpdate in entity cache.
 *
 * @author rknowsys
 * @see BulkUpdate
 * @generated
 */
public class BulkUpdateCacheModel implements CacheModel<BulkUpdate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{bulkupdateId=");
		sb.append(bulkupdateId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", employeeNo=");
		sb.append(employeeNo);
		sb.append(", employeeName=");
		sb.append(employeeName);
		sb.append(", employmentStatus=");
		sb.append(employmentStatus);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", jobtitleId=");
		sb.append(jobtitleId);
		sb.append(", subunit=");
		sb.append(subunit);
		sb.append(", subunitId=");
		sb.append(subunitId);
		sb.append(", location=");
		sb.append(location);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", workshift=");
		sb.append(workshift);
		sb.append(", shiftId=");
		sb.append(shiftId);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", supervisor=");
		sb.append(supervisor);
		sb.append(", empStatus=");
		sb.append(empStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BulkUpdate toEntityModel() {
		BulkUpdateImpl bulkUpdateImpl = new BulkUpdateImpl();

		bulkUpdateImpl.setBulkupdateId(bulkupdateId);
		bulkUpdateImpl.setEmployeeId(employeeId);
		bulkUpdateImpl.setEmployeeNo(employeeNo);

		if (employeeName == null) {
			bulkUpdateImpl.setEmployeeName(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setEmployeeName(employeeName);
		}

		if (employmentStatus == null) {
			bulkUpdateImpl.setEmploymentStatus(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setEmploymentStatus(employmentStatus);
		}

		if (jobTitle == null) {
			bulkUpdateImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setJobTitle(jobTitle);
		}

		bulkUpdateImpl.setJobtitleId(jobtitleId);

		if (subunit == null) {
			bulkUpdateImpl.setSubunit(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setSubunit(subunit);
		}

		bulkUpdateImpl.setSubunitId(subunitId);

		if (location == null) {
			bulkUpdateImpl.setLocation(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setLocation(location);
		}

		bulkUpdateImpl.setLocationId(locationId);

		if (workshift == null) {
			bulkUpdateImpl.setWorkshift(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setWorkshift(workshift);
		}

		bulkUpdateImpl.setShiftId(shiftId);

		if (joiningDate == Long.MIN_VALUE) {
			bulkUpdateImpl.setJoiningDate(null);
		}
		else {
			bulkUpdateImpl.setJoiningDate(new Date(joiningDate));
		}

		if (supervisor == null) {
			bulkUpdateImpl.setSupervisor(StringPool.BLANK);
		}
		else {
			bulkUpdateImpl.setSupervisor(supervisor);
		}

		bulkUpdateImpl.setEmpStatus(empStatus);

		bulkUpdateImpl.resetOriginalValues();

		return bulkUpdateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bulkupdateId = objectInput.readLong();
		employeeId = objectInput.readLong();
		employeeNo = objectInput.readLong();
		employeeName = objectInput.readUTF();
		employmentStatus = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		jobtitleId = objectInput.readLong();
		subunit = objectInput.readUTF();
		subunitId = objectInput.readLong();
		location = objectInput.readUTF();
		locationId = objectInput.readLong();
		workshift = objectInput.readUTF();
		shiftId = objectInput.readLong();
		joiningDate = objectInput.readLong();
		supervisor = objectInput.readUTF();
		empStatus = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bulkupdateId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(employeeNo);

		if (employeeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeName);
		}

		if (employmentStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employmentStatus);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		objectOutput.writeLong(jobtitleId);

		if (subunit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subunit);
		}

		objectOutput.writeLong(subunitId);

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeLong(locationId);

		if (workshift == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workshift);
		}

		objectOutput.writeLong(shiftId);
		objectOutput.writeLong(joiningDate);

		if (supervisor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supervisor);
		}

		objectOutput.writeLong(empStatus);
	}

	public long bulkupdateId;
	public long employeeId;
	public long employeeNo;
	public String employeeName;
	public String employmentStatus;
	public String jobTitle;
	public long jobtitleId;
	public String subunit;
	public long subunitId;
	public String location;
	public long locationId;
	public String workshift;
	public long shiftId;
	public long joiningDate;
	public String supervisor;
	public long empStatus;
}