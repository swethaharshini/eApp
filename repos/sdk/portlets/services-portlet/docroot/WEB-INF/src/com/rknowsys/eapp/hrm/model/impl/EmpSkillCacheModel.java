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

import com.rknowsys.eapp.hrm.model.EmpSkill;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpSkill in entity cache.
 *
 * @author rknowsys
 * @see EmpSkill
 * @generated
 */
public class EmpSkillCacheModel implements CacheModel<EmpSkill>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{empSkillId=");
		sb.append(empSkillId);
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
		sb.append(", skillId=");
		sb.append(skillId);
		sb.append(", years=");
		sb.append(years);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpSkill toEntityModel() {
		EmpSkillImpl empSkillImpl = new EmpSkillImpl();

		empSkillImpl.setEmpSkillId(empSkillId);
		empSkillImpl.setEmployeeId(employeeId);
		empSkillImpl.setGroupId(groupId);
		empSkillImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empSkillImpl.setCreateDate(null);
		}
		else {
			empSkillImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empSkillImpl.setModifiedDate(null);
		}
		else {
			empSkillImpl.setModifiedDate(new Date(modifiedDate));
		}

		empSkillImpl.setUserId(userId);
		empSkillImpl.setSkillId(skillId);

		if (years == null) {
			empSkillImpl.setYears(StringPool.BLANK);
		}
		else {
			empSkillImpl.setYears(years);
		}

		if (comments == null) {
			empSkillImpl.setComments(StringPool.BLANK);
		}
		else {
			empSkillImpl.setComments(comments);
		}

		empSkillImpl.resetOriginalValues();

		return empSkillImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empSkillId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		skillId = objectInput.readLong();
		years = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empSkillId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(skillId);

		if (years == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(years);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long empSkillId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long skillId;
	public String years;
	public String comments;
}