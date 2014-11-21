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

import com.rknowsys.eapp.hrm.model.EmpMembership;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpMembership in entity cache.
 *
 * @author rknowsys
 * @see EmpMembership
 * @generated
 */
public class EmpMembershipCacheModel implements CacheModel<EmpMembership>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empMembershipId=");
		sb.append(empMembershipId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", membershipId=");
		sb.append(membershipId);
		sb.append(", subscriptionPaidBy=");
		sb.append(subscriptionPaidBy);
		sb.append(", subscriptionAmt=");
		sb.append(subscriptionAmt);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", commenceDate=");
		sb.append(commenceDate);
		sb.append(", renewalDate=");
		sb.append(renewalDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpMembership toEntityModel() {
		EmpMembershipImpl empMembershipImpl = new EmpMembershipImpl();

		empMembershipImpl.setEmpMembershipId(empMembershipId);
		empMembershipImpl.setEmployeeId(employeeId);
		empMembershipImpl.setGroupId(groupId);
		empMembershipImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empMembershipImpl.setCreateDate(null);
		}
		else {
			empMembershipImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empMembershipImpl.setModifiedDate(null);
		}
		else {
			empMembershipImpl.setModifiedDate(new Date(modifiedDate));
		}

		empMembershipImpl.setUserId(userId);
		empMembershipImpl.setMembershipId(membershipId);

		if (subscriptionPaidBy == null) {
			empMembershipImpl.setSubscriptionPaidBy(StringPool.BLANK);
		}
		else {
			empMembershipImpl.setSubscriptionPaidBy(subscriptionPaidBy);
		}

		empMembershipImpl.setSubscriptionAmt(subscriptionAmt);

		if (currency == null) {
			empMembershipImpl.setCurrency(StringPool.BLANK);
		}
		else {
			empMembershipImpl.setCurrency(currency);
		}

		if (commenceDate == Long.MIN_VALUE) {
			empMembershipImpl.setCommenceDate(null);
		}
		else {
			empMembershipImpl.setCommenceDate(new Date(commenceDate));
		}

		if (renewalDate == Long.MIN_VALUE) {
			empMembershipImpl.setRenewalDate(null);
		}
		else {
			empMembershipImpl.setRenewalDate(new Date(renewalDate));
		}

		empMembershipImpl.resetOriginalValues();

		return empMembershipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empMembershipId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		membershipId = objectInput.readLong();
		subscriptionPaidBy = objectInput.readUTF();
		subscriptionAmt = objectInput.readLong();
		currency = objectInput.readUTF();
		commenceDate = objectInput.readLong();
		renewalDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empMembershipId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(membershipId);

		if (subscriptionPaidBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subscriptionPaidBy);
		}

		objectOutput.writeLong(subscriptionAmt);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(commenceDate);
		objectOutput.writeLong(renewalDate);
	}

	public long empMembershipId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long membershipId;
	public String subscriptionPaidBy;
	public long subscriptionAmt;
	public String currency;
	public long commenceDate;
	public long renewalDate;
}