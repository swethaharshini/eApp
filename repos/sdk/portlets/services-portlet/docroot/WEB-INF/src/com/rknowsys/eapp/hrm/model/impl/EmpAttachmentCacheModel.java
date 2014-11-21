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

import com.rknowsys.eapp.hrm.model.EmpAttachment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpAttachment in entity cache.
 *
 * @author rknowsys
 * @see EmpAttachment
 * @generated
 */
public class EmpAttachmentCacheModel implements CacheModel<EmpAttachment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empAttachmentId=");
		sb.append(empAttachmentId);
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
		sb.append(", attachmentTypeId=");
		sb.append(attachmentTypeId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpAttachment toEntityModel() {
		EmpAttachmentImpl empAttachmentImpl = new EmpAttachmentImpl();

		empAttachmentImpl.setEmpAttachmentId(empAttachmentId);
		empAttachmentImpl.setEmployeeId(employeeId);
		empAttachmentImpl.setGroupId(groupId);
		empAttachmentImpl.setCompanyId(companyId);
		empAttachmentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			empAttachmentImpl.setCreateDate(null);
		}
		else {
			empAttachmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empAttachmentImpl.setModifiedDate(null);
		}
		else {
			empAttachmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		empAttachmentImpl.setAttachmentTypeId(attachmentTypeId);

		if (fileName == null) {
			empAttachmentImpl.setFileName(StringPool.BLANK);
		}
		else {
			empAttachmentImpl.setFileName(fileName);
		}

		empAttachmentImpl.setFileSize(fileSize);

		if (fileType == null) {
			empAttachmentImpl.setFileType(StringPool.BLANK);
		}
		else {
			empAttachmentImpl.setFileType(fileType);
		}

		if (comment == null) {
			empAttachmentImpl.setComment(StringPool.BLANK);
		}
		else {
			empAttachmentImpl.setComment(comment);
		}

		empAttachmentImpl.resetOriginalValues();

		return empAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empAttachmentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		attachmentTypeId = objectInput.readLong();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readLong();
		fileType = objectInput.readUTF();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empAttachmentId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(attachmentTypeId);

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

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long empAttachmentId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long attachmentTypeId;
	public String fileName;
	public long fileSize;
	public String fileType;
	public String comment;
}