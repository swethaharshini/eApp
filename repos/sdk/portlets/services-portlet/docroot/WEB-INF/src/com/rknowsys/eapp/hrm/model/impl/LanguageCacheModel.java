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

import com.rknowsys.eapp.hrm.model.Language;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Language in entity cache.
 *
 * @author rknowsys
 * @see Language
 * @generated
 */
public class LanguageCacheModel implements CacheModel<Language>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{languageId=");
		sb.append(languageId);
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
		sb.append(", languageName=");
		sb.append(languageName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Language toEntityModel() {
		LanguageImpl languageImpl = new LanguageImpl();

		languageImpl.setLanguageId(languageId);
		languageImpl.setCompanyId(companyId);
		languageImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			languageImpl.setCreateDate(null);
		}
		else {
			languageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			languageImpl.setModifiedDate(null);
		}
		else {
			languageImpl.setModifiedDate(new Date(modifiedDate));
		}

		languageImpl.setUserId(userId);

		if (languageName == null) {
			languageImpl.setLanguageName(StringPool.BLANK);
		}
		else {
			languageImpl.setLanguageName(languageName);
		}

		languageImpl.resetOriginalValues();

		return languageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		languageId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		languageName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(languageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (languageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageName);
		}
	}

	public long languageId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String languageName;
}