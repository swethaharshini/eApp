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
		StringBundler sb = new StringBundler(41);

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
		sb.append(", cantExceedBalForRoleIds=");
		sb.append(cantExceedBalForRoleIds);
		sb.append(", cannotApplyForPartialDay=");
		sb.append(cannotApplyForPartialDay);
		sb.append(", cantApplyPartialDayForRoleIds=");
		sb.append(cantApplyPartialDayForRoleIds);
		sb.append(", termsQuestion=");
		sb.append(termsQuestion);
		sb.append(", termsQsnForRoleIds=");
		sb.append(termsQsnForRoleIds);
		sb.append(", errorTextIfTermsDeclined=");
		sb.append(errorTextIfTermsDeclined);
		sb.append(", minimumServicePeriod=");
		sb.append(minimumServicePeriod);
		sb.append(", minServicePeriodForRoleIds=");
		sb.append(minServicePeriodForRoleIds);
		sb.append(", maxConsecutiveLeaves=");
		sb.append(maxConsecutiveLeaves);
		sb.append(", maxConsecLeavesForRoleIds=");
		sb.append(maxConsecLeavesForRoleIds);
		sb.append(", maxSmallChildAgeApplicable=");
		sb.append(maxSmallChildAgeApplicable);
		sb.append(", maxSmallChildAgeForRoleIds=");
		sb.append(maxSmallChildAgeForRoleIds);
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

		if (cantExceedBalForRoleIds == null) {
			leaveRestrictionImpl.setCantExceedBalForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setCantExceedBalForRoleIds(cantExceedBalForRoleIds);
		}

		leaveRestrictionImpl.setCannotApplyForPartialDay(cannotApplyForPartialDay);

		if (cantApplyPartialDayForRoleIds == null) {
			leaveRestrictionImpl.setCantApplyPartialDayForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setCantApplyPartialDayForRoleIds(cantApplyPartialDayForRoleIds);
		}

		if (termsQuestion == null) {
			leaveRestrictionImpl.setTermsQuestion(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setTermsQuestion(termsQuestion);
		}

		if (termsQsnForRoleIds == null) {
			leaveRestrictionImpl.setTermsQsnForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setTermsQsnForRoleIds(termsQsnForRoleIds);
		}

		if (errorTextIfTermsDeclined == null) {
			leaveRestrictionImpl.setErrorTextIfTermsDeclined(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
		}

		if (minimumServicePeriod == null) {
			leaveRestrictionImpl.setMinimumServicePeriod(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMinimumServicePeriod(minimumServicePeriod);
		}

		if (minServicePeriodForRoleIds == null) {
			leaveRestrictionImpl.setMinServicePeriodForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMinServicePeriodForRoleIds(minServicePeriodForRoleIds);
		}

		if (maxConsecutiveLeaves == null) {
			leaveRestrictionImpl.setMaxConsecutiveLeaves(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		}

		if (maxConsecLeavesForRoleIds == null) {
			leaveRestrictionImpl.setMaxConsecLeavesForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxConsecLeavesForRoleIds(maxConsecLeavesForRoleIds);
		}

		if (maxSmallChildAgeApplicable == null) {
			leaveRestrictionImpl.setMaxSmallChildAgeApplicable(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		}

		if (maxSmallChildAgeForRoleIds == null) {
			leaveRestrictionImpl.setMaxSmallChildAgeForRoleIds(StringPool.BLANK);
		}
		else {
			leaveRestrictionImpl.setMaxSmallChildAgeForRoleIds(maxSmallChildAgeForRoleIds);
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
		cantExceedBalForRoleIds = objectInput.readUTF();
		cannotApplyForPartialDay = objectInput.readBoolean();
		cantApplyPartialDayForRoleIds = objectInput.readUTF();
		termsQuestion = objectInput.readUTF();
		termsQsnForRoleIds = objectInput.readUTF();
		errorTextIfTermsDeclined = objectInput.readUTF();
		minimumServicePeriod = objectInput.readUTF();
		minServicePeriodForRoleIds = objectInput.readUTF();
		maxConsecutiveLeaves = objectInput.readUTF();
		maxConsecLeavesForRoleIds = objectInput.readUTF();
		maxSmallChildAgeApplicable = objectInput.readUTF();
		maxSmallChildAgeForRoleIds = objectInput.readUTF();
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

		if (cantExceedBalForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cantExceedBalForRoleIds);
		}

		objectOutput.writeBoolean(cannotApplyForPartialDay);

		if (cantApplyPartialDayForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cantApplyPartialDayForRoleIds);
		}

		if (termsQuestion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(termsQuestion);
		}

		if (termsQsnForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(termsQsnForRoleIds);
		}

		if (errorTextIfTermsDeclined == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorTextIfTermsDeclined);
		}

		if (minimumServicePeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minimumServicePeriod);
		}

		if (minServicePeriodForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minServicePeriodForRoleIds);
		}

		if (maxConsecutiveLeaves == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxConsecutiveLeaves);
		}

		if (maxConsecLeavesForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxConsecLeavesForRoleIds);
		}

		if (maxSmallChildAgeApplicable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxSmallChildAgeApplicable);
		}

		if (maxSmallChildAgeForRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxSmallChildAgeForRoleIds);
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
	public String cantExceedBalForRoleIds;
	public boolean cannotApplyForPartialDay;
	public String cantApplyPartialDayForRoleIds;
	public String termsQuestion;
	public String termsQsnForRoleIds;
	public String errorTextIfTermsDeclined;
	public String minimumServicePeriod;
	public String minServicePeriodForRoleIds;
	public String maxConsecutiveLeaves;
	public String maxConsecLeavesForRoleIds;
	public String maxSmallChildAgeApplicable;
	public String maxSmallChildAgeForRoleIds;
}