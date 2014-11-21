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

import com.rknowsys.eapp.hrm.model.LeaveRestriction;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveRestriction in entity cache.
 *
 * @author rknowsys
 * @see LeaveRestriction
 * @generated
 */
public class LeaveRestrictionCacheModel implements CacheModel<LeaveRestriction>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{leaveRestrictionId=");
		sb.append(leaveRestrictionId);
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
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", cannotExceedBalance=");
		sb.append(cannotExceedBalance);
		sb.append(", cannotApplyForPartialDay=");
		sb.append(cannotApplyForPartialDay);
		sb.append(", ifATermsQuestion=");
		sb.append(ifATermsQuestion);
		sb.append(", termsQuestion=");
		sb.append(termsQuestion);
		sb.append(", errorTextIfTermsDeclined=");
		sb.append(errorTextIfTermsDeclined);
		sb.append(", isMinimumServicePeriodApplicable=");
		sb.append(isMinimumServicePeriodApplicable);
		sb.append(", minimumServicePeriod=");
		sb.append(minimumServicePeriod);
		sb.append(", isMaxConsecutiveLeavesApplicable=");
		sb.append(isMaxConsecutiveLeavesApplicable);
		sb.append(", maxConsecutiveLeaves=");
		sb.append(maxConsecutiveLeaves);
		sb.append(", isSmallChildCriterionApplicable=");
		sb.append(isSmallChildCriterionApplicable);
		sb.append(", maxSmallChildAgeApplicable=");
		sb.append(maxSmallChildAgeApplicable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveRestriction toEntityModel() {
		LeaveRestrictionImpl leaveRestrictionImpl = new LeaveRestrictionImpl();

		leaveRestrictionImpl.setLeaveRestrictionId(leaveRestrictionId);
		leaveRestrictionImpl.setCompanyId(companyId);
		leaveRestrictionImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveRestrictionImpl.setCreateDate(null);
		}
		else {
			leaveRestrictionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveRestrictionImpl.setModifiedDate(null);
		}
		else {
			leaveRestrictionImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveRestrictionImpl.setUserId(userId);
		leaveRestrictionImpl.setLeaveTypeId(leaveTypeId);
		leaveRestrictionImpl.setCannotExceedBalance(cannotExceedBalance);
		leaveRestrictionImpl.setCannotApplyForPartialDay(cannotApplyForPartialDay);
		leaveRestrictionImpl.setIfATermsQuestion(ifATermsQuestion);

		if (termsQuestion == null) {
			leaveRestrictionImpl.setTermsQuestion(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setTermsQuestion(termsQuestion);
		}

		if (errorTextIfTermsDeclined == null) {
			leaveRestrictionImpl.setErrorTextIfTermsDeclined(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
		}

		leaveRestrictionImpl.setIsMinimumServicePeriodApplicable(isMinimumServicePeriodApplicable);

		if (minimumServicePeriod == null) {
			leaveRestrictionImpl.setMinimumServicePeriod(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMinimumServicePeriod(minimumServicePeriod);
		}

		leaveRestrictionImpl.setIsMaxConsecutiveLeavesApplicable(isMaxConsecutiveLeavesApplicable);

		if (maxConsecutiveLeaves == null) {
			leaveRestrictionImpl.setMaxConsecutiveLeaves(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		}

		leaveRestrictionImpl.setIsSmallChildCriterionApplicable(isSmallChildCriterionApplicable);

		if (maxSmallChildAgeApplicable == null) {
			leaveRestrictionImpl.setMaxSmallChildAgeApplicable(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		}

		leaveRestrictionImpl.resetOriginalValues();

		return leaveRestrictionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveRestrictionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		leaveTypeId = objectInput.readLong();
		cannotExceedBalance = objectInput.readBoolean();
		cannotApplyForPartialDay = objectInput.readBoolean();
		ifATermsQuestion = objectInput.readBoolean();
		termsQuestion = objectInput.readUTF();
		errorTextIfTermsDeclined = objectInput.readUTF();
		isMinimumServicePeriodApplicable = objectInput.readBoolean();
		minimumServicePeriod = objectInput.readUTF();
		isMaxConsecutiveLeavesApplicable = objectInput.readBoolean();
		maxConsecutiveLeaves = objectInput.readUTF();
		isSmallChildCriterionApplicable = objectInput.readBoolean();
		maxSmallChildAgeApplicable = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(leaveRestrictionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(leaveTypeId);
		objectOutput.writeBoolean(cannotExceedBalance);
		objectOutput.writeBoolean(cannotApplyForPartialDay);
		objectOutput.writeBoolean(ifATermsQuestion);

		if (termsQuestion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(termsQuestion);
		}

		if (errorTextIfTermsDeclined == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorTextIfTermsDeclined);
		}

		objectOutput.writeBoolean(isMinimumServicePeriodApplicable);

		if (minimumServicePeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minimumServicePeriod);
		}

		objectOutput.writeBoolean(isMaxConsecutiveLeavesApplicable);

		if (maxConsecutiveLeaves == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxConsecutiveLeaves);
		}

		objectOutput.writeBoolean(isSmallChildCriterionApplicable);

		if (maxSmallChildAgeApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxSmallChildAgeApplicable);
		}
	}

	public long leaveRestrictionId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long leaveTypeId;
	public boolean cannotExceedBalance;
	public boolean cannotApplyForPartialDay;
	public boolean ifATermsQuestion;
	public String termsQuestion;
	public String errorTextIfTermsDeclined;
	public boolean isMinimumServicePeriodApplicable;
	public String minimumServicePeriod;
	public boolean isMaxConsecutiveLeavesApplicable;
	public String maxConsecutiveLeaves;
	public boolean isSmallChildCriterionApplicable;
	public String maxSmallChildAgeApplicable;
}