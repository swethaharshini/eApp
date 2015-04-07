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

import com.rknowsys.eapp.hrm.model.DocumentCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentCategories in entity cache.
 *
 * @author rknowsys
 * @see DocumentCategories
 * @generated
 */
public class DocumentCategoriesCacheModel implements CacheModel<DocumentCategories>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{documentcategoryId=");
		sb.append(documentcategoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", documentCategory=");
		sb.append(documentCategory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentCategories toEntityModel() {
		DocumentCategoriesImpl documentCategoriesImpl = new DocumentCategoriesImpl();

		documentCategoriesImpl.setDocumentcategoryId(documentcategoryId);
		documentCategoriesImpl.setCompanyId(companyId);
		documentCategoriesImpl.setGroupId(groupId);
		documentCategoriesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			documentCategoriesImpl.setCreateDate(null);
		}
		else {
			documentCategoriesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentCategoriesImpl.setModifiedDate(null);
		}
		else {
			documentCategoriesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (documentCategory == null) {
			documentCategoriesImpl.setDocumentCategory(StringPool.BLANK);
		}
		else {
			documentCategoriesImpl.setDocumentCategory(documentCategory);
		}

		documentCategoriesImpl.resetOriginalValues();

		return documentCategoriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentcategoryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		documentCategory = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentcategoryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (documentCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentCategory);
		}
	}

	public long documentcategoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String documentCategory;
}