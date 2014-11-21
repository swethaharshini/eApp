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

import com.rknowsys.eapp.hrm.model.ReportingMethods;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReportingMethods in entity cache.
 *
 * @author rknowsys
 * @see ReportingMethods
 * @generated
 */
public class ReportingMethodsCacheModel implements CacheModel<ReportingMethods>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{reportingmethodId=");
		sb.append(reportingmethodId);
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
		sb.append(", reportingmethodName=");
		sb.append(reportingmethodName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReportingMethods toEntityModel() {
		ReportingMethodsImpl reportingMethodsImpl = new ReportingMethodsImpl();

		reportingMethodsImpl.setReportingmethodId(reportingmethodId);
		reportingMethodsImpl.setCompanyId(companyId);
		reportingMethodsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			reportingMethodsImpl.setCreateDate(null);
		}
		else {
			reportingMethodsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			reportingMethodsImpl.setModifiedDate(null);
		}
		else {
			reportingMethodsImpl.setModifiedDate(new Date(modifiedDate));
		}

		reportingMethodsImpl.setUserId(userId);

		if (reportingmethodName == null) {
			reportingMethodsImpl.setReportingmethodName(StringPool.BLANK);
		}
		else {
			reportingMethodsImpl.setReportingmethodName(reportingmethodName);
		}

		reportingMethodsImpl.resetOriginalValues();

		return reportingMethodsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportingmethodId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		reportingmethodName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportingmethodId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (reportingmethodName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportingmethodName);
		}
	}

	public long reportingmethodId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String reportingmethodName;
}