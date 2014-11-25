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

import com.rknowsys.eapp.hrm.model.EmpLicense;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpLicense in entity cache.
 *
 * @author rknowsys
 * @see EmpLicense
 * @generated
 */
public class EmpLicenseCacheModel implements CacheModel<EmpLicense>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{empLicenseId=");
		sb.append(empLicenseId);
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
		sb.append(", licenseId=");
		sb.append(licenseId);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpLicense toEntityModel() {
		EmpLicenseImpl empLicenseImpl = new EmpLicenseImpl();

		empLicenseImpl.setEmpLicenseId(empLicenseId);
		empLicenseImpl.setEmployeeId(employeeId);
		empLicenseImpl.setGroupId(groupId);
		empLicenseImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empLicenseImpl.setCreateDate(null);
		}
		else {
			empLicenseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empLicenseImpl.setModifiedDate(null);
		}
		else {
			empLicenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		empLicenseImpl.setUserId(userId);
		empLicenseImpl.setLicenseId(licenseId);

		if (licenseNumber == null) {
			empLicenseImpl.setLicenseNumber(StringPool.BLANK);
		}
		else {
			empLicenseImpl.setLicenseNumber(licenseNumber);
		}

		if (issuedDate == Long.MIN_VALUE) {
			empLicenseImpl.setIssuedDate(null);
		}
		else {
			empLicenseImpl.setIssuedDate(new Date(issuedDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			empLicenseImpl.setExpiryDate(null);
		}
		else {
			empLicenseImpl.setExpiryDate(new Date(expiryDate));
		}

		empLicenseImpl.resetOriginalValues();

		return empLicenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empLicenseId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		licenseId = objectInput.readLong();
		licenseNumber = objectInput.readUTF();
		issuedDate = objectInput.readLong();
		expiryDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empLicenseId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(licenseId);

		if (licenseNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}

		objectOutput.writeLong(issuedDate);
		objectOutput.writeLong(expiryDate);
	}

	public long empLicenseId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long licenseId;
	public String licenseNumber;
	public long issuedDate;
	public long expiryDate;
}