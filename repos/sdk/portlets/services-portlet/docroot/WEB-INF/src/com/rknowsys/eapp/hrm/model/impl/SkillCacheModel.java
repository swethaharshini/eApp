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

import com.rknowsys.eapp.hrm.model.Skill;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Skill in entity cache.
 *
 * @author rknowsys
 * @see Skill
 * @generated
 */
public class SkillCacheModel implements CacheModel<Skill>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{skillId=");
		sb.append(skillId);
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
		sb.append(", skillName=");
		sb.append(skillName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Skill toEntityModel() {
		SkillImpl skillImpl = new SkillImpl();

		skillImpl.setSkillId(skillId);
		skillImpl.setCompanyId(companyId);
		skillImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			skillImpl.setCreateDate(null);
		}
		else {
			skillImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			skillImpl.setModifiedDate(null);
		}
		else {
			skillImpl.setModifiedDate(new Date(modifiedDate));
		}

		skillImpl.setUserId(userId);

		if (skillName == null) {
			skillImpl.setSkillName(StringPool.BLANK);
		}
		else {
			skillImpl.setSkillName(skillName);
		}

		if (description == null) {
			skillImpl.setDescription(StringPool.BLANK);
		}
		else {
			skillImpl.setDescription(description);
		}

		skillImpl.resetOriginalValues();

		return skillImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skillId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		skillName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(skillId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (skillName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skillName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long skillId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String skillName;
	public String description;
}