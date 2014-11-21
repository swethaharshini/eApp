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

import com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveCarryForwardPolicy in entity cache.
 *
 * @author rknowsys
 * @see LeaveCarryForwardPolicy
 * @generated
 */
public class LeaveCarryForwardPolicyCacheModel implements CacheModel<LeaveCarryForwardPolicy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{leaveCarryForwardPolicyId=");
		sb.append(leaveCarryForwardPolicyId);
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
		sb.append(", expiryDuration=");
		sb.append(expiryDuration);
		sb.append(", expiryDurationUOM=");
		sb.append(expiryDurationUOM);
		sb.append(", isMaxCarryForwardLimitApplicable=");
		sb.append(isMaxCarryForwardLimitApplicable);
		sb.append(", maxCarryForwardLimit=");
		sb.append(maxCarryForwardLimit);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveCarryForwardPolicy toEntityModel() {
		LeaveCarryForwardPolicyImpl leaveCarryForwardPolicyImpl = new LeaveCarryForwardPolicyImpl();

		leaveCarryForwardPolicyImpl.setLeaveCarryForwardPolicyId(leaveCarryForwardPolicyId);
		leaveCarryForwardPolicyImpl.setCompanyId(companyId);
		leaveCarryForwardPolicyImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveCarryForwardPolicyImpl.setCreateDate(null);
		}
		else {
			leaveCarryForwardPolicyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveCarryForwardPolicyImpl.setModifiedDate(null);
		}
		else {
			leaveCarryForwardPolicyImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveCarryForwardPolicyImpl.setUserId(userId);
		leaveCarryForwardPolicyImpl.setLeaveTypeId(leaveTypeId);
		leaveCarryForwardPolicyImpl.setExpiryDuration(expiryDuration);

		if (expiryDurationUOM == null) {
			leaveCarryForwardPolicyImpl.setExpiryDurationUOM(StringPool.BLANK);
		}
		else {
			leaveCarryForwardPolicyImpl.setExpiryDurationUOM(expiryDurationUOM);
		}

		leaveCarryForwardPolicyImpl.setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);

		if (maxCarryForwardLimit == null) {
			leaveCarryForwardPolicyImpl.setMaxCarryForwardLimit(StringPool.BLANK);
		}
		else {
			leaveCarryForwardPolicyImpl.setMaxCarryForwardLimit(maxCarryForwardLimit);
		}

		leaveCarryForwardPolicyImpl.resetOriginalValues();

		return leaveCarryForwardPolicyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveCarryForwardPolicyId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		expiryDuration = objectInput.readInt();
		expiryDurationUOM = objectInput.readUTF();
		isMaxCarryForwardLimitApplicable = objectInput.readBoolean();
		maxCarryForwardLimit = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveCarryForwardPolicyId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeInt(expiryDuration);

		if (expiryDurationUOM == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiryDurationUOM);
		}

		objectOutput.writeBoolean(isMaxCarryForwardLimitApplicable);

		if (maxCarryForwardLimit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxCarryForwardLimit);
		}
	}

	public long leaveCarryForwardPolicyId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public int expiryDuration;
	public String expiryDurationUOM;
	public boolean isMaxCarryForwardLimitApplicable;
	public String maxCarryForwardLimit;
}