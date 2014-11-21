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

import com.rknowsys.eapp.hrm.model.Holiday;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Holiday in entity cache.
 *
 * @author rknowsys
 * @see Holiday
 * @generated
 */
public class HolidayCacheModel implements CacheModel<Holiday>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{holidayId=");
		sb.append(holidayId);
		sb.append(", holidayName=");
		sb.append(holidayName);
		sb.append(", isAnnual=");
		sb.append(isAnnual);
		sb.append(", isFullDay=");
		sb.append(isFullDay);
		sb.append(", holidayDate=");
		sb.append(holidayDate);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
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
	public Holiday toEntityModel() {
		HolidayImpl holidayImpl = new HolidayImpl();

		holidayImpl.setHolidayId(holidayId);

		if (holidayName == null) {
			holidayImpl.setHolidayName(StringPool.BLANK);
		}
		else {
			holidayImpl.setHolidayName(holidayName);
		}

		holidayImpl.setIsAnnual(isAnnual);
		holidayImpl.setIsFullDay(isFullDay);

		if (holidayDate == Long.MIN_VALUE) {
			holidayImpl.setHolidayDate(null);
		}
		else {
			holidayImpl.setHolidayDate(new Date(holidayDate));
		}

		holidayImpl.setNationalityId(nationalityId);
		holidayImpl.setGroupId(groupId);
		holidayImpl.setCompanyId(companyId);
		holidayImpl.setUserId(userId);

		if (userName == null) {
			holidayImpl.setUserName(StringPool.BLANK);
		}
		else {
			holidayImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			holidayImpl.setCreateDate(null);
		}
		else {
			holidayImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			holidayImpl.setModifiedDate(null);
		}
		else {
			holidayImpl.setModifiedDate(new Date(modifiedDate));
		}

		holidayImpl.resetOriginalValues();

		return holidayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		holidayId = objectInput.readLong();
		holidayName = objectInput.readUTF();
		isAnnual = objectInput.readBoolean();
		isFullDay = objectInput.readBoolean();
		holidayDate = objectInput.readLong();
		nationalityId = objectInput.readLong();
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
		objectOutput.writeLong(holidayId);

		if (holidayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(holidayName);
		}

		objectOutput.writeBoolean(isAnnual);
		objectOutput.writeBoolean(isFullDay);
		objectOutput.writeLong(holidayDate);
		objectOutput.writeLong(nationalityId);
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

	public long holidayId;
	public String holidayName;
	public boolean isAnnual;
	public boolean isFullDay;
	public long holidayDate;
	public long nationalityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}