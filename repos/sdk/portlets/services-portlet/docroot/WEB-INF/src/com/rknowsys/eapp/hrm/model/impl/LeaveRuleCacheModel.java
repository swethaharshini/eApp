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

import com.rknowsys.eapp.hrm.model.LeaveRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveRule in entity cache.
 *
 * @author rknowsys
 * @see LeaveRule
 * @generated
 */
public class LeaveRuleCacheModel implements CacheModel<LeaveRule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveRuleId=");
		sb.append(leaveRuleId);
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
		sb.append(", leavePeriodTypeId=");
		sb.append(leavePeriodTypeId);
		sb.append(", startMonth=");
		sb.append(startMonth);
		sb.append(", startDayOfMonth=");
		sb.append(startDayOfMonth);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", ifEmployeesCanApply=");
		sb.append(ifEmployeesCanApply);
		sb.append(", ifAdminCanAssign=");
		sb.append(ifAdminCanAssign);
		sb.append(", ifAdminCanManageEntitlements=");
		sb.append(ifAdminCanManageEntitlements);
		sb.append(", ifLeaveAccruable=");
		sb.append(ifLeaveAccruable);
		sb.append(", ifCarryForwardable=");
		sb.append(ifCarryForwardable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveRule toEntityModel() {
		LeaveRuleImpl leaveRuleImpl = new LeaveRuleImpl();

		leaveRuleImpl.setLeaveRuleId(leaveRuleId);
		leaveRuleImpl.setCompanyId(companyId);
		leaveRuleImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveRuleImpl.setCreateDate(null);
		}
		else {
			leaveRuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveRuleImpl.setModifiedDate(null);
		}
		else {
			leaveRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveRuleImpl.setUserId(userId);
		leaveRuleImpl.setLeaveTypeId(leaveTypeId);
		leaveRuleImpl.setLeavePeriodTypeId(leavePeriodTypeId);
		leaveRuleImpl.setStartMonth(startMonth);
		leaveRuleImpl.setStartDayOfMonth(startDayOfMonth);

		if (duration == null) {
			leaveRuleImpl.setDuration(StringPool.BLANK);
		}
		else {
			leaveRuleImpl.setDuration(duration);
		}

		leaveRuleImpl.setIfEmployeesCanApply(ifEmployeesCanApply);
		leaveRuleImpl.setIfAdminCanAssign(ifAdminCanAssign);
		leaveRuleImpl.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
		leaveRuleImpl.setIfLeaveAccruable(ifLeaveAccruable);
		leaveRuleImpl.setIfCarryForwardable(ifCarryForwardable);

		leaveRuleImpl.resetOriginalValues();

		return leaveRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveRuleId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		leavePeriodTypeId = objectInput.readInt();
		startMonth = objectInput.readInt();
		startDayOfMonth = objectInput.readInt();
		duration = objectInput.readUTF();
		ifEmployeesCanApply = objectInput.readBoolean();
		ifAdminCanAssign = objectInput.readBoolean();
		ifAdminCanManageEntitlements = objectInput.readBoolean();
		ifLeaveAccruable = objectInput.readBoolean();
		ifCarryForwardable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveRuleId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeInt(leavePeriodTypeId);
		objectOutput.writeInt(startMonth);
		objectOutput.writeInt(startDayOfMonth);

		if (duration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration);
		}

		objectOutput.writeBoolean(ifEmployeesCanApply);
		objectOutput.writeBoolean(ifAdminCanAssign);
		objectOutput.writeBoolean(ifAdminCanManageEntitlements);
		objectOutput.writeBoolean(ifLeaveAccruable);
		objectOutput.writeBoolean(ifCarryForwardable);
	}

	public long leaveRuleId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public int leavePeriodTypeId;
	public int startMonth;
	public int startDayOfMonth;
	public String duration;
	public boolean ifEmployeesCanApply;
	public boolean ifAdminCanAssign;
	public boolean ifAdminCanManageEntitlements;
	public boolean ifLeaveAccruable;
	public boolean ifCarryForwardable;
}