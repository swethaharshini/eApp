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

import com.rknowsys.eapp.hrm.model.SalaryComponent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SalaryComponent in entity cache.
 *
 * @author rknowsys
 * @see SalaryComponent
 * @generated
 */
public class SalaryComponentCacheModel implements CacheModel<SalaryComponent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{salaryComponentId=");
		sb.append(salaryComponentId);
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
		sb.append(", componentName=");
		sb.append(componentName);
		sb.append(", type=");
		sb.append(type);
		sb.append(", onlyCTC=");
		sb.append(onlyCTC);
		sb.append(", valueType=");
		sb.append(valueType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SalaryComponent toEntityModel() {
		SalaryComponentImpl salaryComponentImpl = new SalaryComponentImpl();

		salaryComponentImpl.setSalaryComponentId(salaryComponentId);
		salaryComponentImpl.setCompanyId(companyId);
		salaryComponentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			salaryComponentImpl.setCreateDate(null);
		}
		else {
			salaryComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			salaryComponentImpl.setModifiedDate(null);
		}
		else {
			salaryComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		salaryComponentImpl.setUserId(userId);

		if (componentName == null) {
			salaryComponentImpl.setComponentName(StringPool.BLANK);
		}
		else {
			salaryComponentImpl.setComponentName(componentName);
		}

		salaryComponentImpl.setType(type);
		salaryComponentImpl.setOnlyCTC(onlyCTC);

		if (valueType == null) {
			salaryComponentImpl.setValueType(StringPool.BLANK);
		}
		else {
			salaryComponentImpl.setValueType(valueType);
		}

		salaryComponentImpl.resetOriginalValues();

		return salaryComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		salaryComponentId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		componentName = objectInput.readUTF();
		type = objectInput.readBoolean();
		onlyCTC = objectInput.readBoolean();
		valueType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(salaryComponentId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (componentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(componentName);
		}

		objectOutput.writeBoolean(type);
		objectOutput.writeBoolean(onlyCTC);

		if (valueType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(valueType);
		}
	}

	public long salaryComponentId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String componentName;
	public boolean type;
	public boolean onlyCTC;
	public String valueType;
}