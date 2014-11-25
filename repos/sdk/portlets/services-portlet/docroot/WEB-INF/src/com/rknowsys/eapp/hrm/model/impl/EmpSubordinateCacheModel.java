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

import com.rknowsys.eapp.hrm.model.EmpSubordinate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpSubordinate in entity cache.
 *
 * @author rknowsys
 * @see EmpSubordinate
 * @generated
 */
public class EmpSubordinateCacheModel implements CacheModel<EmpSubordinate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{empSubordinateId=");
		sb.append(empSubordinateId);
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
		sb.append(", reporterEmployeeId=");
		sb.append(reporterEmployeeId);
		sb.append(", reportingMethod=");
		sb.append(reportingMethod);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpSubordinate toEntityModel() {
		EmpSubordinateImpl empSubordinateImpl = new EmpSubordinateImpl();

		empSubordinateImpl.setEmpSubordinateId(empSubordinateId);
		empSubordinateImpl.setEmployeeId(employeeId);
		empSubordinateImpl.setGroupId(groupId);
		empSubordinateImpl.setCompanyId(companyId);
		empSubordinateImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empSubordinateImpl.setCreateDate(null);
		}
		else {
			empSubordinateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empSubordinateImpl.setModifiedDate(null);
		}
		else {
			empSubordinateImpl.setModifiedDate(new Date(modifiedDate));
		}

		empSubordinateImpl.setReporterEmployeeId(reporterEmployeeId);
		empSubordinateImpl.setReportingMethod(reportingMethod);

		empSubordinateImpl.resetOriginalValues();

		return empSubordinateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empSubordinateId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		reporterEmployeeId = objectInput.readLong();
		reportingMethod = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empSubordinateId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(reporterEmployeeId);
		objectOutput.writeLong(reportingMethod);
	}

	public long empSubordinateId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long reporterEmployeeId;
	public long reportingMethod;
}