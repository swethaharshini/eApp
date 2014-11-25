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

import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpEmergencyContact in entity cache.
 *
 * @author rknowsys
 * @see EmpEmergencyContact
 * @generated
 */
public class EmpEmergencyContactCacheModel implements CacheModel<EmpEmergencyContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empEmergencyContactId=");
		sb.append(empEmergencyContactId);
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
		sb.append(", homeTelephone=");
		sb.append(homeTelephone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", workTelephone=");
		sb.append(workTelephone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpEmergencyContact toEntityModel() {
		EmpEmergencyContactImpl empEmergencyContactImpl = new EmpEmergencyContactImpl();

		empEmergencyContactImpl.setEmpEmergencyContactId(empEmergencyContactId);
		empEmergencyContactImpl.setEmployeeId(employeeId);
		empEmergencyContactImpl.setGroupId(groupId);
		empEmergencyContactImpl.setCompanyId(companyId);
		empEmergencyContactImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empEmergencyContactImpl.setCreateDate(null);
		}
		else {
			empEmergencyContactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empEmergencyContactImpl.setModifiedDate(null);
		}
		else {
			empEmergencyContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			empEmergencyContactImpl.setName(StringPool.BLANK);
		}
		else {
			empEmergencyContactImpl.setName(name);
		}

		if (relationship == null) {
			empEmergencyContactImpl.setRelationship(StringPool.BLANK);
		}
		else {
			empEmergencyContactImpl.setRelationship(relationship);
		}

		if (homeTelephone == null) {
			empEmergencyContactImpl.setHomeTelephone(StringPool.BLANK);
		}
		else {
			empEmergencyContactImpl.setHomeTelephone(homeTelephone);
		}

		if (mobile == null) {
			empEmergencyContactImpl.setMobile(StringPool.BLANK);
		}
		else {
			empEmergencyContactImpl.setMobile(mobile);
		}

		if (workTelephone == null) {
			empEmergencyContactImpl.setWorkTelephone(StringPool.BLANK);
		}
		else {
			empEmergencyContactImpl.setWorkTelephone(workTelephone);
		}

		empEmergencyContactImpl.resetOriginalValues();

		return empEmergencyContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empEmergencyContactId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		relationship = objectInput.readUTF();
		homeTelephone = objectInput.readUTF();
		mobile = objectInput.readUTF();
		workTelephone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empEmergencyContactId);
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

		if (homeTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeTelephone);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (workTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workTelephone);
		}
	}

	public long empEmergencyContactId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String relationship;
	public String homeTelephone;
	public String mobile;
	public String workTelephone;
}