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

import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveRuleApplicable in entity cache.
 *
 * @author rknowsys
 * @see LeaveRuleApplicable
 * @generated
 */
public class LeaveRuleApplicableCacheModel implements CacheModel<LeaveRuleApplicable>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveRuleApplicableId=");
		sb.append(leaveRuleApplicableId);
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
		sb.append(", forJobTitles=");
		sb.append(forJobTitles);
		sb.append(", forJobCategories=");
		sb.append(forJobCategories);
		sb.append(", forEmploymentStatus=");
		sb.append(forEmploymentStatus);
		sb.append(", forGender=");
		sb.append(forGender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveRuleApplicable toEntityModel() {
		LeaveRuleApplicableImpl leaveRuleApplicableImpl = new LeaveRuleApplicableImpl();

		leaveRuleApplicableImpl.setLeaveRuleApplicableId(leaveRuleApplicableId);
		leaveRuleApplicableImpl.setCompanyId(companyId);
		leaveRuleApplicableImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveRuleApplicableImpl.setCreateDate(null);
		}
		else {
			leaveRuleApplicableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveRuleApplicableImpl.setModifiedDate(null);
		}
		else {
			leaveRuleApplicableImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveRuleApplicableImpl.setUserId(userId);
		leaveRuleApplicableImpl.setLeaveTypeId(leaveTypeId);
		leaveRuleApplicableImpl.setForFemale(forFemale);
		leaveRuleApplicableImpl.setForMale(forMale);
		leaveRuleApplicableImpl.setForYearsOfService(forYearsOfService);

		if (fromYears == null) {
			leaveRuleApplicableImpl.setFromYears(StringPool.BLANK);
		}
		else {
			leaveRuleApplicableImpl.setFromYears(fromYears);
		}

		if (toYears == null) {
			leaveRuleApplicableImpl.setToYears(StringPool.BLANK);
		}
		else {
			leaveRuleApplicableImpl.setToYears(toYears);
		}

		leaveRuleApplicableImpl.setForJobTitles(forJobTitles);
		leaveRuleApplicableImpl.setForJobCategories(forJobCategories);
		leaveRuleApplicableImpl.setForEmploymentStatus(forEmploymentStatus);
		leaveRuleApplicableImpl.setForGender(forGender);

		leaveRuleApplicableImpl.resetOriginalValues();

		return leaveRuleApplicableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveRuleApplicableId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		forFemale = objectInput.readBoolean();
		forMale = objectInput.readBoolean();
		forYearsOfService = objectInput.readBoolean();
		fromYears = objectInput.readUTF();
		toYears = objectInput.readUTF();
		forJobTitles = objectInput.readBoolean();
		forJobCategories = objectInput.readBoolean();
		forEmploymentStatus = objectInput.readBoolean();
		forGender = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveRuleApplicableId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);
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

		objectOutput.writeBoolean(forJobTitles);
		objectOutput.writeBoolean(forJobCategories);
		objectOutput.writeBoolean(forEmploymentStatus);
		objectOutput.writeBoolean(forGender);
	}

	public long leaveRuleApplicableId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public boolean forFemale;
	public boolean forMale;
	public boolean forYearsOfService;
	public String fromYears;
	public String toYears;
	public boolean forJobTitles;
	public boolean forJobCategories;
	public boolean forEmploymentStatus;
	public boolean forGender;
}