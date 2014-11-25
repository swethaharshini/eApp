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

import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpPersonalDetails in entity cache.
 *
 * @author rknowsys
 * @see EmpPersonalDetails
 * @generated
 */
public class EmpPersonalDetailsCacheModel implements CacheModel<EmpPersonalDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{empPersonalDetailsId=");
		sb.append(empPersonalDetailsId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", employeeNo=");
		sb.append(employeeNo);
		sb.append(", otherId=");
		sb.append(otherId);
		sb.append(", licenseNo=");
		sb.append(licenseNo);
		sb.append(", licenseExpDate=");
		sb.append(licenseExpDate);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpPersonalDetails toEntityModel() {
		EmpPersonalDetailsImpl empPersonalDetailsImpl = new EmpPersonalDetailsImpl();

		empPersonalDetailsImpl.setEmpPersonalDetailsId(empPersonalDetailsId);
		empPersonalDetailsImpl.setEmployeeId(employeeId);
		empPersonalDetailsImpl.setGroupId(groupId);
		empPersonalDetailsImpl.setCompanyId(companyId);
		empPersonalDetailsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empPersonalDetailsImpl.setCreateDate(null);
		}
		else {
			empPersonalDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empPersonalDetailsImpl.setModifiedDate(null);
		}
		else {
			empPersonalDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			empPersonalDetailsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			empPersonalDetailsImpl.setLastName(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setLastName(lastName);
		}

		if (middleName == null) {
			empPersonalDetailsImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setMiddleName(middleName);
		}

		if (employeeNo == null) {
			empPersonalDetailsImpl.setEmployeeNo(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setEmployeeNo(employeeNo);
		}

		if (otherId == null) {
			empPersonalDetailsImpl.setOtherId(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setOtherId(otherId);
		}

		if (licenseNo == null) {
			empPersonalDetailsImpl.setLicenseNo(StringPool.BLANK);
		}
		else {
			empPersonalDetailsImpl.setLicenseNo(licenseNo);
		}

		if (licenseExpDate == Long.MIN_VALUE) {
			empPersonalDetailsImpl.setLicenseExpDate(null);
		}
		else {
			empPersonalDetailsImpl.setLicenseExpDate(new Date(licenseExpDate));
		}

		empPersonalDetailsImpl.setGender(gender);
		empPersonalDetailsImpl.setMaritalStatus(maritalStatus);
		empPersonalDetailsImpl.setNationalityId(nationalityId);

		if (dateOfBirth == Long.MIN_VALUE) {
			empPersonalDetailsImpl.setDateOfBirth(null);
		}
		else {
			empPersonalDetailsImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		empPersonalDetailsImpl.resetOriginalValues();

		return empPersonalDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empPersonalDetailsId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		employeeNo = objectInput.readUTF();
		otherId = objectInput.readUTF();
		licenseNo = objectInput.readUTF();
		licenseExpDate = objectInput.readLong();
		gender = objectInput.readLong();
		maritalStatus = objectInput.readLong();
		nationalityId = objectInput.readLong();
		dateOfBirth = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empPersonalDetailsId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (employeeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeNo);
		}

		if (otherId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherId);
		}

		if (licenseNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(licenseNo);
		}

		objectOutput.writeLong(licenseExpDate);
		objectOutput.writeLong(gender);
		objectOutput.writeLong(maritalStatus);
		objectOutput.writeLong(nationalityId);
		objectOutput.writeLong(dateOfBirth);
	}

	public long empPersonalDetailsId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String middleName;
	public String employeeNo;
	public String otherId;
	public String licenseNo;
	public long licenseExpDate;
	public long gender;
	public long maritalStatus;
	public long nationalityId;
	public long dateOfBirth;
}