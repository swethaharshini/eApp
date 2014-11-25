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

import com.rknowsys.eapp.hrm.model.EmpWorkExp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpWorkExp in entity cache.
 *
 * @author rknowsys
 * @see EmpWorkExp
 * @generated
 */
public class EmpWorkExpCacheModel implements CacheModel<EmpWorkExp>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empWorkExpId=");
		sb.append(empWorkExpId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", company=");
		sb.append(company);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpWorkExp toEntityModel() {
		EmpWorkExpImpl empWorkExpImpl = new EmpWorkExpImpl();

		empWorkExpImpl.setEmpWorkExpId(empWorkExpId);
		empWorkExpImpl.setEmployeeId(employeeId);
		empWorkExpImpl.setGroupId(groupId);
		empWorkExpImpl.setCompanyId(companyId);
		empWorkExpImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empWorkExpImpl.setCreateDate(null);
		}
		else {
			empWorkExpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empWorkExpImpl.setModifiedDate(null);
		}
		else {
			empWorkExpImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (company == null) {
			empWorkExpImpl.setCompany(StringPool.BLANK);
		}
		else {
			empWorkExpImpl.setCompany(company);
		}

		if (jobTitle == null) {
			empWorkExpImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			empWorkExpImpl.setJobTitle(jobTitle);
		}

		if (fromDate == Long.MIN_VALUE) {
			empWorkExpImpl.setFromDate(null);
		}
		else {
			empWorkExpImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			empWorkExpImpl.setToDate(null);
		}
		else {
			empWorkExpImpl.setToDate(new Date(toDate));
		}

		if (comment == null) {
			empWorkExpImpl.setComment(StringPool.BLANK);
		}
		else {
			empWorkExpImpl.setComment(comment);
		}

		empWorkExpImpl.resetOriginalValues();

		return empWorkExpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empWorkExpId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		company = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empWorkExpId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long empWorkExpId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String company;
	public String jobTitle;
	public long fromDate;
	public long toDate;
	public String comment;
}