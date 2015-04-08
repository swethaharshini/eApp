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

import com.rknowsys.eapp.hrm.model.NewsAttachments;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NewsAttachments in entity cache.
 *
 * @author rknowsys
 * @see NewsAttachments
 * @generated
 */
public class NewsAttachmentsCacheModel implements CacheModel<NewsAttachments>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{newsAttachmentId=");
		sb.append(newsAttachmentId);
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
		sb.append(", attachmentTypeId=");
		sb.append(attachmentTypeId);
		sb.append(", newsId=");
		sb.append(newsId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsAttachments toEntityModel() {
		NewsAttachmentsImpl newsAttachmentsImpl = new NewsAttachmentsImpl();

		newsAttachmentsImpl.setNewsAttachmentId(newsAttachmentId);
		newsAttachmentsImpl.setCompanyId(companyId);
		newsAttachmentsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			newsAttachmentsImpl.setCreateDate(null);
		}
		else {
			newsAttachmentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			newsAttachmentsImpl.setModifiedDate(null);
		}
		else {
			newsAttachmentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		newsAttachmentsImpl.setUserId(userId);
		newsAttachmentsImpl.setAttachmentTypeId(attachmentTypeId);
		newsAttachmentsImpl.setNewsId(newsId);

		if (description == null) {
			newsAttachmentsImpl.setDescription(StringPool.BLANK);
		}
		else {
			newsAttachmentsImpl.setDescription(description);
		}

		if (uuid == null) {
			newsAttachmentsImpl.setUuid(StringPool.BLANK);
		}
		else {
			newsAttachmentsImpl.setUuid(uuid);
		}

		if (fileName == null) {
			newsAttachmentsImpl.setFileName(StringPool.BLANK);
		}
		else {
			newsAttachmentsImpl.setFileName(fileName);
		}

		newsAttachmentsImpl.setFileSize(fileSize);

		if (fileType == null) {
			newsAttachmentsImpl.setFileType(StringPool.BLANK);
		}
		else {
			newsAttachmentsImpl.setFileType(fileType);
		}

		newsAttachmentsImpl.resetOriginalValues();

		return newsAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		newsAttachmentId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		attachmentTypeId = objectInput.readLong();
		newsId = objectInput.readLong();
		description = objectInput.readUTF();
		uuid = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readLong();
		fileType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(newsAttachmentId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(attachmentTypeId);
		objectOutput.writeLong(newsId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(fileSize);

		if (fileType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileType);
		}
	}

	public long newsAttachmentId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long attachmentTypeId;
	public long newsId;
	public String description;
	public String uuid;
	public String fileName;
	public long fileSize;
	public String fileType;
}