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

import com.rknowsys.eapp.hrm.model.EmpDirectDeposit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpDirectDeposit in entity cache.
 *
 * @author rknowsys
 * @see EmpDirectDeposit
 * @generated
 */
public class EmpDirectDepositCacheModel implements CacheModel<EmpDirectDeposit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empDirectDepositId=");
		sb.append(empDirectDepositId);
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
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", accountNumber=");
		sb.append(accountNumber);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", accountType=");
		sb.append(accountType);
		sb.append(", branchLocation=");
		sb.append(branchLocation);
		sb.append(", routingNumber=");
		sb.append(routingNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpDirectDeposit toEntityModel() {
		EmpDirectDepositImpl empDirectDepositImpl = new EmpDirectDepositImpl();

		empDirectDepositImpl.setEmpDirectDepositId(empDirectDepositId);
		empDirectDepositImpl.setEmployeeId(employeeId);
		empDirectDepositImpl.setGroupId(groupId);
		empDirectDepositImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empDirectDepositImpl.setCreateDate(null);
		}
		else {
			empDirectDepositImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empDirectDepositImpl.setModifiedDate(null);
		}
		else {
			empDirectDepositImpl.setModifiedDate(new Date(modifiedDate));
		}

		empDirectDepositImpl.setUserId(userId);
		empDirectDepositImpl.setAmount(amount);
		empDirectDepositImpl.setAccountNumber(accountNumber);

		if (bankName == null) {
			empDirectDepositImpl.setBankName(StringPool.BLANK);
		}
		else {
			empDirectDepositImpl.setBankName(bankName);
		}

		if (accountType == null) {
			empDirectDepositImpl.setAccountType(StringPool.BLANK);
		}
		else {
			empDirectDepositImpl.setAccountType(accountType);
		}

		if (branchLocation == null) {
			empDirectDepositImpl.setBranchLocation(StringPool.BLANK);
		}
		else {
			empDirectDepositImpl.setBranchLocation(branchLocation);
		}

		if (routingNumber == null) {
			empDirectDepositImpl.setRoutingNumber(StringPool.BLANK);
		}
		else {
			empDirectDepositImpl.setRoutingNumber(routingNumber);
		}

		empDirectDepositImpl.resetOriginalValues();

		return empDirectDepositImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empDirectDepositId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		amount = objectInput.readLong();
		accountNumber = objectInput.readLong();
		bankName = objectInput.readUTF();
		accountType = objectInput.readUTF();
		branchLocation = objectInput.readUTF();
		routingNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empDirectDepositId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(amount);
		objectOutput.writeLong(accountNumber);

		if (bankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (accountType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountType);
		}

		if (branchLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(branchLocation);
		}

		if (routingNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(routingNumber);
		}
	}

	public long empDirectDepositId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long amount;
	public long accountNumber;
	public String bankName;
	public String accountType;
	public String branchLocation;
	public String routingNumber;
}