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

import com.rknowsys.eapp.hrm.model.EmpSalary;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpSalary in entity cache.
 *
 * @author rknowsys
 * @see EmpSalary
 * @generated
 */
public class EmpSalaryCacheModel implements CacheModel<EmpSalary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{empSalaryId=");
		sb.append(empSalaryId);
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
		sb.append(", payGradeId=");
		sb.append(payGradeId);
		sb.append(", payGradeCurrencyId=");
		sb.append(payGradeCurrencyId);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpSalary toEntityModel() {
		EmpSalaryImpl empSalaryImpl = new EmpSalaryImpl();

		empSalaryImpl.setEmpSalaryId(empSalaryId);
		empSalaryImpl.setEmployeeId(employeeId);
		empSalaryImpl.setGroupId(groupId);
		empSalaryImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empSalaryImpl.setCreateDate(null);
		}
		else {
			empSalaryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empSalaryImpl.setModifiedDate(null);
		}
		else {
			empSalaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		empSalaryImpl.setUserId(userId);
		empSalaryImpl.setPayGradeId(payGradeId);
		empSalaryImpl.setPayGradeCurrencyId(payGradeCurrencyId);

		if (comment == null) {
			empSalaryImpl.setComment(StringPool.BLANK);
		}
		else {
			empSalaryImpl.setComment(comment);
		}

		empSalaryImpl.resetOriginalValues();

		return empSalaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empSalaryId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		payGradeId = objectInput.readLong();
		payGradeCurrencyId = objectInput.readLong();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empSalaryId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(payGradeId);
		objectOutput.writeLong(payGradeCurrencyId);

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long empSalaryId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long payGradeId;
	public long payGradeCurrencyId;
	public String comment;
}