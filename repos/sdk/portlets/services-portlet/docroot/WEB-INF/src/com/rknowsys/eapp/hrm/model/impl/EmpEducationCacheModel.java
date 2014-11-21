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

import com.rknowsys.eapp.hrm.model.EmpEducation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpEducation in entity cache.
 *
 * @author rknowsys
 * @see EmpEducation
 * @generated
 */
public class EmpEducationCacheModel implements CacheModel<EmpEducation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empEducationId=");
		sb.append(empEducationId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", educationId=");
		sb.append(educationId);
		sb.append(", institute=");
		sb.append(institute);
		sb.append(", major=");
		sb.append(major);
		sb.append(", year=");
		sb.append(year);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpEducation toEntityModel() {
		EmpEducationImpl empEducationImpl = new EmpEducationImpl();

		empEducationImpl.setEmpEducationId(empEducationId);
		empEducationImpl.setEmployeeId(employeeId);
		empEducationImpl.setGroupId(groupId);
		empEducationImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empEducationImpl.setCreateDate(null);
		}
		else {
			empEducationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empEducationImpl.setModifiedDate(null);
		}
		else {
			empEducationImpl.setModifiedDate(new Date(modifiedDate));
		}

		empEducationImpl.setUserId(userId);
		empEducationImpl.setEducationId(educationId);

		if (institute == null) {
			empEducationImpl.setInstitute(StringPool.BLANK);
		}
		else {
			empEducationImpl.setInstitute(institute);
		}

		if (major == null) {
			empEducationImpl.setMajor(StringPool.BLANK);
		}
		else {
			empEducationImpl.setMajor(major);
		}

		if (year == null) {
			empEducationImpl.setYear(StringPool.BLANK);
		}
		else {
			empEducationImpl.setYear(year);
		}

		if (startDate == Long.MIN_VALUE) {
			empEducationImpl.setStartDate(null);
		}
		else {
			empEducationImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			empEducationImpl.setEndDate(null);
		}
		else {
			empEducationImpl.setEndDate(new Date(endDate));
		}

		empEducationImpl.resetOriginalValues();

		return empEducationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empEducationId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		educationId = objectInput.readLong();
		institute = objectInput.readUTF();
		major = objectInput.readUTF();
		year = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empEducationId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(educationId);

		if (institute == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(institute);
		}

		if (major == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(major);
		}

		if (year == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(year);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long empEducationId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long educationId;
	public String institute;
	public String major;
	public String year;
	public long startDate;
	public long endDate;
}