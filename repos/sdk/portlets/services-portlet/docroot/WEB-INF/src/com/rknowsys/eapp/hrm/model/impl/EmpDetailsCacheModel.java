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

import com.rknowsys.eapp.hrm.model.EmpDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpDetails in entity cache.
 *
 * @author rknowsys
 * @see EmpDetails
 * @generated
 */
public class EmpDetailsCacheModel implements CacheModel<EmpDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empdetailsId=");
		sb.append(empdetailsId);
		sb.append(", employeeNo=");
		sb.append(employeeNo);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", employmentstatus=");
		sb.append(employmentstatus);
		sb.append(", name=");
		sb.append(name);
		sb.append(", supervisor=");
		sb.append(supervisor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpDetails toEntityModel() {
		EmpDetailsImpl empDetailsImpl = new EmpDetailsImpl();

		empDetailsImpl.setEmpdetailsId(empdetailsId);

		if (employeeNo == null) {
			empDetailsImpl.setEmployeeNo(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setEmployeeNo(employeeNo);
		}

		empDetailsImpl.setCompanyId(companyId);
		empDetailsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empDetailsImpl.setCreateDate(null);
		}
		else {
			empDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empDetailsImpl.setModifiedDate(null);
		}
		else {
			empDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			empDetailsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			empDetailsImpl.setLastName(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setLastName(lastName);
		}

		if (title == null) {
			empDetailsImpl.setTitle(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setTitle(title);
		}

		if (employmentstatus == null) {
			empDetailsImpl.setEmploymentstatus(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setEmploymentstatus(employmentstatus);
		}

		if (name == null) {
			empDetailsImpl.setName(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setName(name);
		}

		if (supervisor == null) {
			empDetailsImpl.setSupervisor(StringPool.BLANK);
		}
		else {
			empDetailsImpl.setSupervisor(supervisor);
		}

		empDetailsImpl.resetOriginalValues();

		return empDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empdetailsId = objectInput.readLong();
		employeeNo = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		title = objectInput.readUTF();
		employmentstatus = objectInput.readUTF();
		name = objectInput.readUTF();
		supervisor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empdetailsId);

		if (employeeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeNo);
		}

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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (employmentstatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employmentstatus);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (supervisor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supervisor);
		}
	}

	public long empdetailsId;
	public String employeeNo;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String title;
	public String employmentstatus;
	public String name;
	public String supervisor;
}