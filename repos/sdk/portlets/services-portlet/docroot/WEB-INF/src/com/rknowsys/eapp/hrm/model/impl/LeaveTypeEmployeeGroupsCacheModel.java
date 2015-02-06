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

import com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTypeEmployeeGroups in entity cache.
 *
 * @author rknowsys
 * @see LeaveTypeEmployeeGroups
 * @generated
 */
public class LeaveTypeEmployeeGroupsCacheModel implements CacheModel<LeaveTypeEmployeeGroups>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{leaveTypeEmployeeGroupId=");
		sb.append(leaveTypeEmployeeGroupId);
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
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", forJobTitles=");
		sb.append(forJobTitles);
		sb.append(", forJobCategories=");
		sb.append(forJobCategories);
		sb.append(", forEmploymentStatus=");
		sb.append(forEmploymentStatus);
		sb.append(", forGender=");
		sb.append(forGender);
		sb.append(", forFemale=");
		sb.append(forFemale);
		sb.append(", forMale=");
		sb.append(forMale);
		sb.append(", forYearsOfService=");
		sb.append(forYearsOfService);
		sb.append(", fromYears=");
		sb.append(fromYears);
		sb.append(", toYears=");
		sb.append(toYears);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveTypeEmployeeGroups toEntityModel() {
		LeaveTypeEmployeeGroupsImpl leaveTypeEmployeeGroupsImpl = new LeaveTypeEmployeeGroupsImpl();

		leaveTypeEmployeeGroupsImpl.setLeaveTypeEmployeeGroupId(leaveTypeEmployeeGroupId);
		leaveTypeEmployeeGroupsImpl.setCompanyId(companyId);
		leaveTypeEmployeeGroupsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveTypeEmployeeGroupsImpl.setCreateDate(null);
		}
		else {
			leaveTypeEmployeeGroupsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTypeEmployeeGroupsImpl.setModifiedDate(null);
		}
		else {
			leaveTypeEmployeeGroupsImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTypeEmployeeGroupsImpl.setUserId(userId);
		leaveTypeEmployeeGroupsImpl.setLeaveTypeId(leaveTypeId);

		if (groupName == null) {
			leaveTypeEmployeeGroupsImpl.setGroupName(StringPool.BLANK);
		}
		else {
			leaveTypeEmployeeGroupsImpl.setGroupName(groupName);
		}

		leaveTypeEmployeeGroupsImpl.setForJobTitles(forJobTitles);
		leaveTypeEmployeeGroupsImpl.setForJobCategories(forJobCategories);
		leaveTypeEmployeeGroupsImpl.setForEmploymentStatus(forEmploymentStatus);
		leaveTypeEmployeeGroupsImpl.setForGender(forGender);
		leaveTypeEmployeeGroupsImpl.setForFemale(forFemale);
		leaveTypeEmployeeGroupsImpl.setForMale(forMale);
		leaveTypeEmployeeGroupsImpl.setForYearsOfService(forYearsOfService);

		if (fromYears == null) {
			leaveTypeEmployeeGroupsImpl.setFromYears(StringPool.BLANK);
		}
		else {
			leaveTypeEmployeeGroupsImpl.setFromYears(fromYears);
		}

		if (toYears == null) {
			leaveTypeEmployeeGroupsImpl.setToYears(StringPool.BLANK);
		}
		else {
			leaveTypeEmployeeGroupsImpl.setToYears(toYears);
		}

		leaveTypeEmployeeGroupsImpl.resetOriginalValues();

		return leaveTypeEmployeeGroupsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTypeEmployeeGroupId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		groupName = objectInput.readUTF();
		forJobTitles = objectInput.readBoolean();
		forJobCategories = objectInput.readBoolean();
		forEmploymentStatus = objectInput.readBoolean();
		forGender = objectInput.readBoolean();
		forFemale = objectInput.readBoolean();
		forMale = objectInput.readBoolean();
		forYearsOfService = objectInput.readBoolean();
		fromYears = objectInput.readUTF();
		toYears = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveTypeEmployeeGroupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		objectOutput.writeBoolean(forJobTitles);
		objectOutput.writeBoolean(forJobCategories);
		objectOutput.writeBoolean(forEmploymentStatus);
		objectOutput.writeBoolean(forGender);
		objectOutput.writeBoolean(forFemale);
		objectOutput.writeBoolean(forMale);
		objectOutput.writeBoolean(forYearsOfService);

		if (fromYears == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromYears);
		}

		if (toYears == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toYears);
		}
	}

	public long leaveTypeEmployeeGroupId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public String groupName;
	public boolean forJobTitles;
	public boolean forJobCategories;
	public boolean forEmploymentStatus;
	public boolean forGender;
	public boolean forFemale;
	public boolean forMale;
	public boolean forYearsOfService;
	public String fromYears;
	public String toYears;
}