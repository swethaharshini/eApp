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

import com.rknowsys.eapp.hrm.model.EmpLanguage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpLanguage in entity cache.
 *
 * @author rknowsys
 * @see EmpLanguage
 * @generated
 */
public class EmpLanguageCacheModel implements CacheModel<EmpLanguage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{empLanguageId=");
		sb.append(empLanguageId);
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
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", languageSkill=");
		sb.append(languageSkill);
		sb.append(", languageFluency=");
		sb.append(languageFluency);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpLanguage toEntityModel() {
		EmpLanguageImpl empLanguageImpl = new EmpLanguageImpl();

		empLanguageImpl.setEmpLanguageId(empLanguageId);
		empLanguageImpl.setEmployeeId(employeeId);
		empLanguageImpl.setGroupId(groupId);
		empLanguageImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empLanguageImpl.setCreateDate(null);
		}
		else {
			empLanguageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empLanguageImpl.setModifiedDate(null);
		}
		else {
			empLanguageImpl.setModifiedDate(new Date(modifiedDate));
		}

		empLanguageImpl.setUserId(userId);
		empLanguageImpl.setLanguageId(languageId);

		if (languageSkill == null) {
			empLanguageImpl.setLanguageSkill(StringPool.BLANK);
		}
		else {
			empLanguageImpl.setLanguageSkill(languageSkill);
		}

		if (languageFluency == null) {
			empLanguageImpl.setLanguageFluency(StringPool.BLANK);
		}
		else {
			empLanguageImpl.setLanguageFluency(languageFluency);
		}

		if (comments == null) {
			empLanguageImpl.setComments(StringPool.BLANK);
		}
		else {
			empLanguageImpl.setComments(comments);
		}

		empLanguageImpl.resetOriginalValues();

		return empLanguageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empLanguageId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		languageId = objectInput.readLong();
		languageSkill = objectInput.readUTF();
		languageFluency = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empLanguageId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(languageId);

		if (languageSkill == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageSkill);
		}

		if (languageFluency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageFluency);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long empLanguageId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long languageId;
	public String languageSkill;
	public String languageFluency;
	public String comments;
}