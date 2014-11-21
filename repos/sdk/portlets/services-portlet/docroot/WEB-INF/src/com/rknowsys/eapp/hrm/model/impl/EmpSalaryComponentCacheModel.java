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
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.EmpSalaryComponent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpSalaryComponent in entity cache.
 *
 * @author rknowsys
 * @see EmpSalaryComponent
 * @generated
 */
public class EmpSalaryComponentCacheModel implements CacheModel<EmpSalaryComponent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{empSalaryEarningId=");
		sb.append(empSalaryEarningId);
		sb.append(", empSalaryId=");
		sb.append(empSalaryId);
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
		sb.append(", salaryComponentId=");
		sb.append(salaryComponentId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpSalaryComponent toEntityModel() {
		EmpSalaryComponentImpl empSalaryComponentImpl = new EmpSalaryComponentImpl();

		empSalaryComponentImpl.setEmpSalaryEarningId(empSalaryEarningId);
		empSalaryComponentImpl.setEmpSalaryId(empSalaryId);
		empSalaryComponentImpl.setGroupId(groupId);
		empSalaryComponentImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empSalaryComponentImpl.setCreateDate(null);
		}
		else {
			empSalaryComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empSalaryComponentImpl.setModifiedDate(null);
		}
		else {
			empSalaryComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		empSalaryComponentImpl.setUserId(userId);
		empSalaryComponentImpl.setSalaryComponentId(salaryComponentId);
		empSalaryComponentImpl.setAmount(amount);

		if (effectiveDate == Long.MIN_VALUE) {
			empSalaryComponentImpl.setEffectiveDate(null);
		}
		else {
			empSalaryComponentImpl.setEffectiveDate(new Date(effectiveDate));
		}

		empSalaryComponentImpl.resetOriginalValues();

		return empSalaryComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empSalaryEarningId = objectInput.readLong();
		empSalaryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		salaryComponentId = objectInput.readLong();
		amount = objectInput.readLong();
		effectiveDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empSalaryEarningId);
		objectOutput.writeLong(empSalaryId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(salaryComponentId);
		objectOutput.writeLong(amount);
		objectOutput.writeLong(effectiveDate);
	}

	public long empSalaryEarningId;
	public long empSalaryId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long salaryComponentId;
	public long amount;
	public long effectiveDate;
}