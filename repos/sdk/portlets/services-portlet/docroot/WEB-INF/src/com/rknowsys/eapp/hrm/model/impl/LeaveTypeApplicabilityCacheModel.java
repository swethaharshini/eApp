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

import com.rknowsys.eapp.hrm.model.LeaveTypeApplicability;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTypeApplicability in entity cache.
 *
 * @author rknowsys
 * @see LeaveTypeApplicability
 * @generated
 */
public class LeaveTypeApplicabilityCacheModel implements CacheModel<LeaveTypeApplicability>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{leaveTypeApplicabilityId=");
		sb.append(leaveTypeApplicabilityId);
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
		sb.append(", ifYearsOfServiceCriterionApplicable=");
		sb.append(ifYearsOfServiceCriterionApplicable);
		sb.append(", minYearsOfService=");
		sb.append(minYearsOfService);
		sb.append(", maxYearsOfService=");
		sb.append(maxYearsOfService);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveTypeApplicability toEntityModel() {
		LeaveTypeApplicabilityImpl leaveTypeApplicabilityImpl = new LeaveTypeApplicabilityImpl();

		leaveTypeApplicabilityImpl.setLeaveTypeApplicabilityId(leaveTypeApplicabilityId);
		leaveTypeApplicabilityImpl.setCompanyId(companyId);
		leaveTypeApplicabilityImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveTypeApplicabilityImpl.setCreateDate(null);
		}
		else {
			leaveTypeApplicabilityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTypeApplicabilityImpl.setModifiedDate(null);
		}
		else {
			leaveTypeApplicabilityImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTypeApplicabilityImpl.setUserId(userId);
		leaveTypeApplicabilityImpl.setLeaveTypeId(leaveTypeId);
		leaveTypeApplicabilityImpl.setIfYearsOfServiceCriterionApplicable(ifYearsOfServiceCriterionApplicable);

		if (minYearsOfService == null) {
			leaveTypeApplicabilityImpl.setMinYearsOfService(StringPool.BLANK);
		}
		else {
			leaveTypeApplicabilityImpl.setMinYearsOfService(minYearsOfService);
		}

		if (maxYearsOfService == null) {
			leaveTypeApplicabilityImpl.setMaxYearsOfService(StringPool.BLANK);
		}
		else {
			leaveTypeApplicabilityImpl.setMaxYearsOfService(maxYearsOfService);
		}

		leaveTypeApplicabilityImpl.resetOriginalValues();

		return leaveTypeApplicabilityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTypeApplicabilityId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		ifYearsOfServiceCriterionApplicable = objectInput.readBoolean();
		minYearsOfService = objectInput.readUTF();
		maxYearsOfService = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveTypeApplicabilityId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeBoolean(ifYearsOfServiceCriterionApplicable);

		if (minYearsOfService == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minYearsOfService);
		}

		if (maxYearsOfService == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxYearsOfService);
		}
	}

	public long leaveTypeApplicabilityId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public boolean ifYearsOfServiceCriterionApplicable;
	public String minYearsOfService;
	public String maxYearsOfService;
}