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

import com.rknowsys.eapp.hrm.model.LeaveGeneral;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveGeneral in entity cache.
 *
 * @author rknowsys
 * @see LeaveGeneral
 * @generated
 */
public class LeaveGeneralCacheModel implements CacheModel<LeaveGeneral>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{leaveGeneralId=");
		sb.append(leaveGeneralId);
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
		sb.append(", showProjectBalance=");
		sb.append(showProjectBalance);
		sb.append(", enableAttachment=");
		sb.append(enableAttachment);
		sb.append(", isAttachmentMandatory=");
		sb.append(isAttachmentMandatory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveGeneral toEntityModel() {
		LeaveGeneralImpl leaveGeneralImpl = new LeaveGeneralImpl();

		leaveGeneralImpl.setLeaveGeneralId(leaveGeneralId);
		leaveGeneralImpl.setCompanyId(companyId);
		leaveGeneralImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveGeneralImpl.setCreateDate(null);
		}
		else {
			leaveGeneralImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveGeneralImpl.setModifiedDate(null);
		}
		else {
			leaveGeneralImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveGeneralImpl.setUserId(userId);
		leaveGeneralImpl.setLeaveTypeId(leaveTypeId);
		leaveGeneralImpl.setLeavePeriodTypeId(leavePeriodTypeId);
		leaveGeneralImpl.setStartMonth(startMonth);
		leaveGeneralImpl.setStartDayOfMonth(startDayOfMonth);

		if (duration == null) {
			leaveGeneralImpl.setDuration(StringPool.BLANK);
		}
		else {
			leaveGeneralImpl.setDuration(duration);
		}

		leaveGeneralImpl.setIfEmployeesCanApply(ifEmployeesCanApply);
		leaveGeneralImpl.setIfAdminCanAssign(ifAdminCanAssign);
		leaveGeneralImpl.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
		leaveGeneralImpl.setIfLeaveAccruable(ifLeaveAccruable);
		leaveGeneralImpl.setIfCarryForwardable(ifCarryForwardable);
		leaveGeneralImpl.setShowProjectBalance(showProjectBalance);
		leaveGeneralImpl.setEnableAttachment(enableAttachment);
		leaveGeneralImpl.setIsAttachmentMandatory(isAttachmentMandatory);

		leaveGeneralImpl.resetOriginalValues();

		return leaveGeneralImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveGeneralId = objectInput.readLong();
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
		showProjectBalance = objectInput.readBoolean();
		enableAttachment = objectInput.readBoolean();
		isAttachmentMandatory = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveGeneralId);
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
		objectOutput.writeBoolean(showProjectBalance);
		objectOutput.writeBoolean(enableAttachment);
		objectOutput.writeBoolean(isAttachmentMandatory);
	}

	public long leaveGeneralId;
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
	public boolean showProjectBalance;
	public boolean enableAttachment;
	public boolean isAttachmentMandatory;
}