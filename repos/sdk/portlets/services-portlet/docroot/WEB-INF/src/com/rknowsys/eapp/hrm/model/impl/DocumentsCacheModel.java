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

import com.rknowsys.eapp.hrm.model.Documents;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Documents in entity cache.
 *
 * @author rknowsys
 * @see Documents
 * @generated
 */
public class DocumentsCacheModel implements CacheModel<Documents>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{documentId=");
		sb.append(documentId);
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
		sb.append(", topic=");
		sb.append(topic);
		sb.append(", category=");
		sb.append(category);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", admin=");
		sb.append(admin);
		sb.append(", supervisor=");
		sb.append(supervisor);
		sb.append(", allEmployees=");
		sb.append(allEmployees);
		sb.append(", publishedTo=");
		sb.append(publishedTo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Documents toEntityModel() {
		DocumentsImpl documentsImpl = new DocumentsImpl();

		documentsImpl.setDocumentId(documentId);
		documentsImpl.setCompanyId(companyId);
		documentsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			documentsImpl.setCreateDate(null);
		}
		else {
			documentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentsImpl.setModifiedDate(null);
		}
		else {
			documentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentsImpl.setUserId(userId);

		if (topic == null) {
			documentsImpl.setTopic(StringPool.BLANK);
		}
		else {
			documentsImpl.setTopic(topic);
		}

		if (category == null) {
			documentsImpl.setCategory(StringPool.BLANK);
		}
		else {
			documentsImpl.setCategory(category);
		}

		if (description == null) {
			documentsImpl.setDescription(StringPool.BLANK);
		}
		else {
			documentsImpl.setDescription(description);
		}

		if (publishDate == Long.MIN_VALUE) {
			documentsImpl.setPublishDate(null);
		}
		else {
			documentsImpl.setPublishDate(new Date(publishDate));
		}

		documentsImpl.setStatus(status);
		documentsImpl.setAdmin(admin);
		documentsImpl.setSupervisor(supervisor);
		documentsImpl.setAllEmployees(allEmployees);

		if (publishedTo == null) {
			documentsImpl.setPublishedTo(StringPool.BLANK);
		}
		else {
			documentsImpl.setPublishedTo(publishedTo);
		}

		documentsImpl.resetOriginalValues();

		return documentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		topic = objectInput.readUTF();
		category = objectInput.readUTF();
		description = objectInput.readUTF();
		publishDate = objectInput.readLong();
		status = objectInput.readBoolean();
		admin = objectInput.readBoolean();
		supervisor = objectInput.readBoolean();
		allEmployees = objectInput.readBoolean();
		publishedTo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (topic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topic);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(publishDate);
		objectOutput.writeBoolean(status);
		objectOutput.writeBoolean(admin);
		objectOutput.writeBoolean(supervisor);
		objectOutput.writeBoolean(allEmployees);

		if (publishedTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishedTo);
		}
	}

	public long documentId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String topic;
	public String category;
	public String description;
	public long publishDate;
	public boolean status;
	public boolean admin;
	public boolean supervisor;
	public boolean allEmployees;
	public String publishedTo;
}