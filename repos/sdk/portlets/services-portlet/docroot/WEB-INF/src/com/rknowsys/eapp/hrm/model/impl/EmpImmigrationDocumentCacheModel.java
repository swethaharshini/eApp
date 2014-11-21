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

import com.rknowsys.eapp.hrm.model.EmpImmigrationDocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpImmigrationDocument in entity cache.
 *
 * @author rknowsys
 * @see EmpImmigrationDocument
 * @generated
 */
public class EmpImmigrationDocumentCacheModel implements CacheModel<EmpImmigrationDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{empImmigrationDocumentId=");
		sb.append(empImmigrationDocumentId);
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
		sb.append(", docType=");
		sb.append(docType);
		sb.append(", docNumber=");
		sb.append(docNumber);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", eligibleStatus=");
		sb.append(eligibleStatus);
		sb.append(", issuedBy=");
		sb.append(issuedBy);
		sb.append(", eligibleReviewDate=");
		sb.append(eligibleReviewDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpImmigrationDocument toEntityModel() {
		EmpImmigrationDocumentImpl empImmigrationDocumentImpl = new EmpImmigrationDocumentImpl();

		empImmigrationDocumentImpl.setEmpImmigrationDocumentId(empImmigrationDocumentId);
		empImmigrationDocumentImpl.setEmployeeId(employeeId);
		empImmigrationDocumentImpl.setGroupId(groupId);
		empImmigrationDocumentImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			empImmigrationDocumentImpl.setCreateDate(null);
		}
		else {
			empImmigrationDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empImmigrationDocumentImpl.setModifiedDate(null);
		}
		else {
			empImmigrationDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		empImmigrationDocumentImpl.setUserId(userId);

		if (docType == null) {
			empImmigrationDocumentImpl.setDocType(StringPool.BLANK);
		}
		else {
			empImmigrationDocumentImpl.setDocType(docType);
		}

		if (docNumber == null) {
			empImmigrationDocumentImpl.setDocNumber(StringPool.BLANK);
		}
		else {
			empImmigrationDocumentImpl.setDocNumber(docNumber);
		}

		if (issuedDate == Long.MIN_VALUE) {
			empImmigrationDocumentImpl.setIssuedDate(null);
		}
		else {
			empImmigrationDocumentImpl.setIssuedDate(new Date(issuedDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			empImmigrationDocumentImpl.setExpiryDate(null);
		}
		else {
			empImmigrationDocumentImpl.setExpiryDate(new Date(expiryDate));
		}

		if (eligibleStatus == null) {
			empImmigrationDocumentImpl.setEligibleStatus(StringPool.BLANK);
		}
		else {
			empImmigrationDocumentImpl.setEligibleStatus(eligibleStatus);
		}

		if (issuedBy == null) {
			empImmigrationDocumentImpl.setIssuedBy(StringPool.BLANK);
		}
		else {
			empImmigrationDocumentImpl.setIssuedBy(issuedBy);
		}

		if (eligibleReviewDate == Long.MIN_VALUE) {
			empImmigrationDocumentImpl.setEligibleReviewDate(null);
		}
		else {
			empImmigrationDocumentImpl.setEligibleReviewDate(new Date(
					eligibleReviewDate));
		}

		if (comments == null) {
			empImmigrationDocumentImpl.setComments(StringPool.BLANK);
		}
		else {
			empImmigrationDocumentImpl.setComments(comments);
		}

		empImmigrationDocumentImpl.resetOriginalValues();

		return empImmigrationDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empImmigrationDocumentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		docType = objectInput.readUTF();
		docNumber = objectInput.readUTF();
		issuedDate = objectInput.readLong();
		expiryDate = objectInput.readLong();
		eligibleStatus = objectInput.readUTF();
		issuedBy = objectInput.readUTF();
		eligibleReviewDate = objectInput.readLong();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empImmigrationDocumentId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (docType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docType);
		}

		if (docNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docNumber);
		}

		objectOutput.writeLong(issuedDate);
		objectOutput.writeLong(expiryDate);

		if (eligibleStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eligibleStatus);
		}

		if (issuedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issuedBy);
		}

		objectOutput.writeLong(eligibleReviewDate);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long empImmigrationDocumentId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String docType;
	public String docNumber;
	public long issuedDate;
	public long expiryDate;
	public String eligibleStatus;
	public String issuedBy;
	public long eligibleReviewDate;
	public String comments;
}