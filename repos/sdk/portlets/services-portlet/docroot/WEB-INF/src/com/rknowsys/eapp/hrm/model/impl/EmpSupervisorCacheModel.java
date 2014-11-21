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

import com.rknowsys.eapp.hrm.model.EmpSupervisor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpSupervisor in entity cache.
 *
 * @author rknowsys
 * @see EmpSupervisor
 * @generated
 */
public class EmpSupervisorCacheModel implements CacheModel<EmpSupervisor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{empSupervisorId=");
		sb.append(empSupervisorId);
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
	public EmpSupervisor toEntityModel() {
		EmpSupervisorImpl empSupervisorImpl = new EmpSupervisorImpl();

		empSupervisorImpl.setEmpSupervisorId(empSupervisorId);
		empSupervisorImpl.setEmployeeId(employeeId);
		empSupervisorImpl.setGroupId(groupId);
		empSupervisorImpl.setCompanyId(companyId);
		empSupervisorImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empSupervisorImpl.setCreateDate(null);
		}
		else {
			empSupervisorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empSupervisorImpl.setModifiedDate(null);
		}
		else {
			empSupervisorImpl.setModifiedDate(new Date(modifiedDate));
		}

		empSupervisorImpl.setReporterEmployeeId(reporterEmployeeId);
		empSupervisorImpl.setReportingMethod(reportingMethod);

		empSupervisorImpl.resetOriginalValues();

		return empSupervisorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empSupervisorId = objectInput.readLong();
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
		objectOutput.writeLong(empSupervisorId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(reporterEmployeeId);
		objectOutput.writeLong(reportingMethod);
	}

	public long empSupervisorId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long reporterEmployeeId;
	public long reportingMethod;
}