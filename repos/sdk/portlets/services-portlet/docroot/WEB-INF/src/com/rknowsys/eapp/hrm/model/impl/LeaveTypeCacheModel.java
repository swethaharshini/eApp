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

import com.rknowsys.eapp.hrm.model.LeaveType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveType in entity cache.
 *
 * @author rknowsys
 * @see LeaveType
 * @generated
 */
public class LeaveTypeCacheModel implements CacheModel<LeaveType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
		sb.append(", leaveTypeName=");
		sb.append(leaveTypeName);
		sb.append(", isSituational=");
		sb.append(isSituational);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveType toEntityModel() {
		LeaveTypeImpl leaveTypeImpl = new LeaveTypeImpl();

		leaveTypeImpl.setLeaveTypeId(leaveTypeId);
		leaveTypeImpl.setCompanyId(companyId);
		leaveTypeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveTypeImpl.setCreateDate(null);
		}
		else {
			leaveTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTypeImpl.setModifiedDate(null);
		}
		else {
			leaveTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTypeImpl.setUserId(userId);
		leaveTypeImpl.setNationalityId(nationalityId);

		if (leaveTypeName == null) {
			leaveTypeImpl.setLeaveTypeName(StringPool.BLANK);
		}
		else {
			leaveTypeImpl.setLeaveTypeName(leaveTypeName);
		}

		leaveTypeImpl.setIsSituational(isSituational);

		leaveTypeImpl.resetOriginalValues();

		return leaveTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTypeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		nationalityId = objectInput.readLong();
		leaveTypeName = objectInput.readUTF();
		isSituational = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(nationalityId);

		if (leaveTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leaveTypeName);
		}

		objectOutput.writeBoolean(isSituational);
	}

	public long leaveTypeId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long nationalityId;
	public String leaveTypeName;
	public boolean isSituational;
}