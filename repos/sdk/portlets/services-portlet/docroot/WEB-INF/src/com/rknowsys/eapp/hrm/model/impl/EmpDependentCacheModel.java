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

import com.rknowsys.eapp.hrm.model.EmpDependent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpDependent in entity cache.
 *
 * @author rknowsys
 * @see EmpDependent
 * @generated
 */
public class EmpDependentCacheModel implements CacheModel<EmpDependent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{empDependentId=");
		sb.append(empDependentId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", relationship=");
		sb.append(relationship);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpDependent toEntityModel() {
		EmpDependentImpl empDependentImpl = new EmpDependentImpl();

		empDependentImpl.setEmpDependentId(empDependentId);
		empDependentImpl.setEmployeeId(employeeId);
		empDependentImpl.setGroupId(groupId);
		empDependentImpl.setCompanyId(companyId);
		empDependentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empDependentImpl.setCreateDate(null);
		}
		else {
			empDependentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empDependentImpl.setModifiedDate(null);
		}
		else {
			empDependentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			empDependentImpl.setName(StringPool.BLANK);
		}
		else {
			empDependentImpl.setName(name);
		}

		if (relationship == null) {
			empDependentImpl.setRelationship(StringPool.BLANK);
		}
		else {
			empDependentImpl.setRelationship(relationship);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			empDependentImpl.setDateOfBirth(null);
		}
		else {
			empDependentImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		empDependentImpl.resetOriginalValues();

		return empDependentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empDependentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		relationship = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empDependentId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (relationship == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relationship);
		}

		objectOutput.writeLong(dateOfBirth);
	}

	public long empDependentId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String relationship;
	public long dateOfBirth;
}