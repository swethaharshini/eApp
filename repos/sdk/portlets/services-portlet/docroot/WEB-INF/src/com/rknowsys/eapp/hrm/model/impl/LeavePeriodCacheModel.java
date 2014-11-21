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

import com.rknowsys.eapp.hrm.model.LeavePeriod;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeavePeriod in entity cache.
 *
 * @author rknowsys
 * @see LeavePeriod
 * @generated
 */
public class LeavePeriodCacheModel implements CacheModel<LeavePeriod>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{leavePeriodId=");
		sb.append(leavePeriodId);
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
		sb.append(", startMonth=");
		sb.append(startMonth);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeavePeriod toEntityModel() {
		LeavePeriodImpl leavePeriodImpl = new LeavePeriodImpl();

		leavePeriodImpl.setLeavePeriodId(leavePeriodId);
		leavePeriodImpl.setCompanyId(companyId);
		leavePeriodImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leavePeriodImpl.setCreateDate(null);
		}
		else {
			leavePeriodImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leavePeriodImpl.setModifiedDate(null);
		}
		else {
			leavePeriodImpl.setModifiedDate(new Date(modifiedDate));
		}

		leavePeriodImpl.setUserId(userId);
		leavePeriodImpl.setStartMonth(startMonth);
		leavePeriodImpl.setStartDate(startDate);

		if (endDate == null) {
			leavePeriodImpl.setEndDate(StringPool.BLANK);
		}
		else {
			leavePeriodImpl.setEndDate(endDate);
		}

		leavePeriodImpl.resetOriginalValues();

		return leavePeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leavePeriodId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		startMonth = objectInput.readInt();
		startDate = objectInput.readInt();
		endDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leavePeriodId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeInt(startMonth);
		objectOutput.writeInt(startDate);

		if (endDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endDate);
		}
	}

	public long leavePeriodId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public int startMonth;
	public int startDate;
	public String endDate;
}