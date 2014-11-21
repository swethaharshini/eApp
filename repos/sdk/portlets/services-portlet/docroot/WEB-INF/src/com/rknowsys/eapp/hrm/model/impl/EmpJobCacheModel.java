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

import com.rknowsys.eapp.hrm.model.EmpJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpJob in entity cache.
 *
 * @author rknowsys
 * @see EmpJob
 * @generated
 */
public class EmpJobCacheModel implements CacheModel<EmpJob>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{empJobId=");
		sb.append(empJobId);
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
		sb.append(", joinedDate=");
		sb.append(joinedDate);
		sb.append(", probationEndDate=");
		sb.append(probationEndDate);
		sb.append(", permanentDate=");
		sb.append(permanentDate);
		sb.append(", jobTitleId=");
		sb.append(jobTitleId);
		sb.append(", employmentStatusId=");
		sb.append(employmentStatusId);
		sb.append(", jobCategoryId=");
		sb.append(jobCategoryId);
		sb.append(", subUnitId=");
		sb.append(subUnitId);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", shiftId=");
		sb.append(shiftId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", employmentContractStartDate=");
		sb.append(employmentContractStartDate);
		sb.append(", employmentContractEndDate=");
		sb.append(employmentContractEndDate);

		return sb.toString();
	}

	@Override
	public EmpJob toEntityModel() {
		EmpJobImpl empJobImpl = new EmpJobImpl();

		empJobImpl.setEmpJobId(empJobId);
		empJobImpl.setEmployeeId(employeeId);
		empJobImpl.setGroupId(groupId);
		empJobImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empJobImpl.setCreateDate(null);
		}
		else {
			empJobImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empJobImpl.setModifiedDate(null);
		}
		else {
			empJobImpl.setModifiedDate(new Date(modifiedDate));
		}

		empJobImpl.setUserId(userId);

		if (joinedDate == Long.MIN_VALUE) {
			empJobImpl.setJoinedDate(null);
		}
		else {
			empJobImpl.setJoinedDate(new Date(joinedDate));
		}

		if (probationEndDate == Long.MIN_VALUE) {
			empJobImpl.setProbationEndDate(null);
		}
		else {
			empJobImpl.setProbationEndDate(new Date(probationEndDate));
		}

		if (permanentDate == Long.MIN_VALUE) {
			empJobImpl.setPermanentDate(null);
		}
		else {
			empJobImpl.setPermanentDate(new Date(permanentDate));
		}

		empJobImpl.setJobTitleId(jobTitleId);
		empJobImpl.setEmploymentStatusId(employmentStatusId);
		empJobImpl.setJobCategoryId(jobCategoryId);
		empJobImpl.setSubUnitId(subUnitId);
		empJobImpl.setLocationId(locationId);

		if (effectiveDate == Long.MIN_VALUE) {
			empJobImpl.setEffectiveDate(null);
		}
		else {
			empJobImpl.setEffectiveDate(new Date(effectiveDate));
		}

		empJobImpl.setShiftId(shiftId);

		if (comments == null) {
			empJobImpl.setComments(StringPool.BLANK);
		}
		else {
			empJobImpl.setComments(comments);
		}

		if (employmentContractStartDate == Long.MIN_VALUE) {
			empJobImpl.setEmploymentContractStartDate(null);
		}
		else {
			empJobImpl.setEmploymentContractStartDate(new Date(
					employmentContractStartDate));
		}

		if (employmentContractEndDate == Long.MIN_VALUE) {
			empJobImpl.setEmploymentContractEndDate(null);
		}
		else {
			empJobImpl.setEmploymentContractEndDate(new Date(
					employmentContractEndDate));
		}

		empJobImpl.resetOriginalValues();

		return empJobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empJobId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		joinedDate = objectInput.readLong();
		probationEndDate = objectInput.readLong();
		permanentDate = objectInput.readLong();
		jobTitleId = objectInput.readLong();
		employmentStatusId = objectInput.readLong();
		jobCategoryId = objectInput.readLong();
		subUnitId = objectInput.readLong();
		locationId = objectInput.readLong();
		effectiveDate = objectInput.readLong();
		shiftId = objectInput.readLong();
		comments = objectInput.readUTF();
		employmentContractStartDate = objectInput.readLong();
		employmentContractEndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empJobId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(joinedDate);
		objectOutput.writeLong(probationEndDate);
		objectOutput.writeLong(permanentDate);
		objectOutput.writeLong(jobTitleId);
		objectOutput.writeLong(employmentStatusId);
		objectOutput.writeLong(jobCategoryId);
		objectOutput.writeLong(subUnitId);
		objectOutput.writeLong(locationId);
		objectOutput.writeLong(effectiveDate);
		objectOutput.writeLong(shiftId);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(employmentContractStartDate);
		objectOutput.writeLong(employmentContractEndDate);
	}

	public long empJobId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long joinedDate;
	public long probationEndDate;
	public long permanentDate;
	public long jobTitleId;
	public long employmentStatusId;
	public long jobCategoryId;
	public long subUnitId;
	public long locationId;
	public long effectiveDate;
	public long shiftId;
	public String comments;
	public long employmentContractStartDate;
	public long employmentContractEndDate;
}