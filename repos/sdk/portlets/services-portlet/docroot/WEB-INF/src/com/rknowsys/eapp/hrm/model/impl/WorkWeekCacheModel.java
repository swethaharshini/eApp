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

import com.rknowsys.eapp.hrm.model.WorkWeek;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkWeek in entity cache.
 *
 * @author rknowsys
 * @see WorkWeek
 * @generated
 */
public class WorkWeekCacheModel implements CacheModel<WorkWeek>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{workWeekId=");
		sb.append(workWeekId);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
		sb.append(", mondayWorkSchedule=");
		sb.append(mondayWorkSchedule);
		sb.append(", tuesdayWorkSchedule=");
		sb.append(tuesdayWorkSchedule);
		sb.append(", wednesdayWorkSchedule=");
		sb.append(wednesdayWorkSchedule);
		sb.append(", thursdayWorkSchedule=");
		sb.append(thursdayWorkSchedule);
		sb.append(", fridayWorkSchedule=");
		sb.append(fridayWorkSchedule);
		sb.append(", saturdayWorkSchedule=");
		sb.append(saturdayWorkSchedule);
		sb.append(", sundayWorkSchedule=");
		sb.append(sundayWorkSchedule);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkWeek toEntityModel() {
		WorkWeekImpl workWeekImpl = new WorkWeekImpl();

		workWeekImpl.setWorkWeekId(workWeekId);
		workWeekImpl.setNationalityId(nationalityId);
		workWeekImpl.setMondayWorkSchedule(mondayWorkSchedule);
		workWeekImpl.setTuesdayWorkSchedule(tuesdayWorkSchedule);
		workWeekImpl.setWednesdayWorkSchedule(wednesdayWorkSchedule);
		workWeekImpl.setThursdayWorkSchedule(thursdayWorkSchedule);
		workWeekImpl.setFridayWorkSchedule(fridayWorkSchedule);
		workWeekImpl.setSaturdayWorkSchedule(saturdayWorkSchedule);
		workWeekImpl.setSundayWorkSchedule(sundayWorkSchedule);
		workWeekImpl.setGroupId(groupId);
		workWeekImpl.setCompanyId(companyId);
		workWeekImpl.setUserId(userId);

		if (userName == null) {
			workWeekImpl.setUserName(StringPool.BLANK);
		}
		else {
			workWeekImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workWeekImpl.setCreateDate(null);
		}
		else {
			workWeekImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workWeekImpl.setModifiedDate(null);
		}
		else {
			workWeekImpl.setModifiedDate(new Date(modifiedDate));
		}

		workWeekImpl.resetOriginalValues();

		return workWeekImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workWeekId = objectInput.readLong();
		nationalityId = objectInput.readLong();
		mondayWorkSchedule = objectInput.readInt();
		tuesdayWorkSchedule = objectInput.readInt();
		wednesdayWorkSchedule = objectInput.readInt();
		thursdayWorkSchedule = objectInput.readInt();
		fridayWorkSchedule = objectInput.readInt();
		saturdayWorkSchedule = objectInput.readInt();
		sundayWorkSchedule = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workWeekId);
		objectOutput.writeLong(nationalityId);
		objectOutput.writeInt(mondayWorkSchedule);
		objectOutput.writeInt(tuesdayWorkSchedule);
		objectOutput.writeInt(wednesdayWorkSchedule);
		objectOutput.writeInt(thursdayWorkSchedule);
		objectOutput.writeInt(fridayWorkSchedule);
		objectOutput.writeInt(saturdayWorkSchedule);
		objectOutput.writeInt(sundayWorkSchedule);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long workWeekId;
	public long nationalityId;
	public int mondayWorkSchedule;
	public int tuesdayWorkSchedule;
	public int wednesdayWorkSchedule;
	public int thursdayWorkSchedule;
	public int fridayWorkSchedule;
	public int saturdayWorkSchedule;
	public int sundayWorkSchedule;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}