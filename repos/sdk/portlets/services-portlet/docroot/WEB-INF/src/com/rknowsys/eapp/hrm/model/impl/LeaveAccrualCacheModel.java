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

import com.rknowsys.eapp.hrm.model.LeaveAccrual;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveAccrual in entity cache.
 *
 * @author rknowsys
 * @see LeaveAccrual
 * @generated
 */
public class LeaveAccrualCacheModel implements CacheModel<LeaveAccrual>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{leaveAccrualId=");
		sb.append(leaveAccrualId);
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
		sb.append(", accrualFrequency=");
		sb.append(accrualFrequency);
		sb.append(", accrueEvery=");
		sb.append(accrueEvery);
		sb.append(", dayOfCredit=");
		sb.append(dayOfCredit);
		sb.append(", accrualStartsOn=");
		sb.append(accrualStartsOn);
		sb.append(", monthOfCredit=");
		sb.append(monthOfCredit);
		sb.append(", accrualValidFrom=");
		sb.append(accrualValidFrom);
		sb.append(", firstAccrual=");
		sb.append(firstAccrual);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveAccrual toEntityModel() {
		LeaveAccrualImpl leaveAccrualImpl = new LeaveAccrualImpl();

		leaveAccrualImpl.setLeaveAccrualId(leaveAccrualId);
		leaveAccrualImpl.setCompanyId(companyId);
		leaveAccrualImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveAccrualImpl.setCreateDate(null);
		}
		else {
			leaveAccrualImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveAccrualImpl.setModifiedDate(null);
		}
		else {
			leaveAccrualImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveAccrualImpl.setUserId(userId);
		leaveAccrualImpl.setLeaveTypeId(leaveTypeId);

		if (accrualFrequency == null) {
			leaveAccrualImpl.setAccrualFrequency(StringPool.BLANK);
		}
		else {
			leaveAccrualImpl.setAccrualFrequency(accrualFrequency);
		}

		leaveAccrualImpl.setAccrueEvery(accrueEvery);
		leaveAccrualImpl.setDayOfCredit(dayOfCredit);

		if (accrualStartsOn == null) {
			leaveAccrualImpl.setAccrualStartsOn(StringPool.BLANK);
		}
		else {
			leaveAccrualImpl.setAccrualStartsOn(accrualStartsOn);
		}

		leaveAccrualImpl.setMonthOfCredit(monthOfCredit);

		if (accrualValidFrom == null) {
			leaveAccrualImpl.setAccrualValidFrom(StringPool.BLANK);
		}
		else {
			leaveAccrualImpl.setAccrualValidFrom(accrualValidFrom);
		}

		if (firstAccrual == null) {
			leaveAccrualImpl.setFirstAccrual(StringPool.BLANK);
		}
		else {
			leaveAccrualImpl.setFirstAccrual(firstAccrual);
		}

		leaveAccrualImpl.resetOriginalValues();

		return leaveAccrualImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveAccrualId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		accrualFrequency = objectInput.readUTF();
		accrueEvery = objectInput.readInt();
		dayOfCredit = objectInput.readInt();
		accrualStartsOn = objectInput.readUTF();
		monthOfCredit = objectInput.readInt();
		accrualValidFrom = objectInput.readUTF();
		firstAccrual = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveAccrualId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);

		if (accrualFrequency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accrualFrequency);
		}

		objectOutput.writeInt(accrueEvery);
		objectOutput.writeInt(dayOfCredit);

		if (accrualStartsOn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accrualStartsOn);
		}

		objectOutput.writeInt(monthOfCredit);

		if (accrualValidFrom == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accrualValidFrom);
		}

		if (firstAccrual == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstAccrual);
		}
	}

	public long leaveAccrualId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public String accrualFrequency;
	public int accrueEvery;
	public int dayOfCredit;
	public String accrualStartsOn;
	public int monthOfCredit;
	public String accrualValidFrom;
	public String firstAccrual;
}