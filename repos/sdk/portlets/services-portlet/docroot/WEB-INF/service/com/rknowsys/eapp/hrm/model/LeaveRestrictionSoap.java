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

package com.rknowsys.eapp.hrm.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class LeaveRestrictionSoap implements Serializable {
	public static LeaveRestrictionSoap toSoapModel(LeaveRestriction model) {
		LeaveRestrictionSoap soapModel = new LeaveRestrictionSoap();

		soapModel.setLeaveRestrictionId(model.getLeaveRestrictionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setCannotExceedBalance(model.getCannotExceedBalance());
		soapModel.setCantExceedBalForRoleIds(model.getCantExceedBalForRoleIds());
		soapModel.setCannotApplyForPartialDay(model.getCannotApplyForPartialDay());
		soapModel.setCantApplyPartialDayForRoleIds(model.getCantApplyPartialDayForRoleIds());
		soapModel.setTermsQuestion(model.getTermsQuestion());
		soapModel.setTermsQsnForRoleIds(model.getTermsQsnForRoleIds());
		soapModel.setErrorTextIfTermsDeclined(model.getErrorTextIfTermsDeclined());
		soapModel.setMinimumServicePeriod(model.getMinimumServicePeriod());
		soapModel.setMinServicePeriodForRoleIds(model.getMinServicePeriodForRoleIds());
		soapModel.setMaxConsecutiveLeaves(model.getMaxConsecutiveLeaves());
		soapModel.setMaxConsecLeavesForRoleIds(model.getMaxConsecLeavesForRoleIds());
		soapModel.setMaxSmallChildAgeApplicable(model.getMaxSmallChildAgeApplicable());
		soapModel.setMaxSmallChildAgeForRoleIds(model.getMaxSmallChildAgeForRoleIds());

		return soapModel;
	}

	public static LeaveRestrictionSoap[] toSoapModels(LeaveRestriction[] models) {
		LeaveRestrictionSoap[] soapModels = new LeaveRestrictionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveRestrictionSoap[][] toSoapModels(
		LeaveRestriction[][] models) {
		LeaveRestrictionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveRestrictionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveRestrictionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveRestrictionSoap[] toSoapModels(
		List<LeaveRestriction> models) {
		List<LeaveRestrictionSoap> soapModels = new ArrayList<LeaveRestrictionSoap>(models.size());

		for (LeaveRestriction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveRestrictionSoap[soapModels.size()]);
	}

	public LeaveRestrictionSoap() {
	}

	public long getPrimaryKey() {
		return _leaveRestrictionId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveRestrictionId(pk);
	}

	public long getLeaveRestrictionId() {
		return _leaveRestrictionId;
	}

	public void setLeaveRestrictionId(long leaveRestrictionId) {
		_leaveRestrictionId = leaveRestrictionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public boolean getCannotExceedBalance() {
		return _cannotExceedBalance;
	}

	public boolean isCannotExceedBalance() {
		return _cannotExceedBalance;
	}

	public void setCannotExceedBalance(boolean cannotExceedBalance) {
		_cannotExceedBalance = cannotExceedBalance;
	}

	public String getCantExceedBalForRoleIds() {
		return _cantExceedBalForRoleIds;
	}

	public void setCantExceedBalForRoleIds(String cantExceedBalForRoleIds) {
		_cantExceedBalForRoleIds = cantExceedBalForRoleIds;
	}

	public boolean getCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	public boolean isCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	public void setCannotApplyForPartialDay(boolean cannotApplyForPartialDay) {
		_cannotApplyForPartialDay = cannotApplyForPartialDay;
	}

	public String getCantApplyPartialDayForRoleIds() {
		return _cantApplyPartialDayForRoleIds;
	}

	public void setCantApplyPartialDayForRoleIds(
		String cantApplyPartialDayForRoleIds) {
		_cantApplyPartialDayForRoleIds = cantApplyPartialDayForRoleIds;
	}

	public String getTermsQuestion() {
		return _termsQuestion;
	}

	public void setTermsQuestion(String termsQuestion) {
		_termsQuestion = termsQuestion;
	}

	public String getTermsQsnForRoleIds() {
		return _termsQsnForRoleIds;
	}

	public void setTermsQsnForRoleIds(String termsQsnForRoleIds) {
		_termsQsnForRoleIds = termsQsnForRoleIds;
	}

	public String getErrorTextIfTermsDeclined() {
		return _errorTextIfTermsDeclined;
	}

	public void setErrorTextIfTermsDeclined(String errorTextIfTermsDeclined) {
		_errorTextIfTermsDeclined = errorTextIfTermsDeclined;
	}

	public String getMinimumServicePeriod() {
		return _minimumServicePeriod;
	}

	public void setMinimumServicePeriod(String minimumServicePeriod) {
		_minimumServicePeriod = minimumServicePeriod;
	}

	public String getMinServicePeriodForRoleIds() {
		return _minServicePeriodForRoleIds;
	}

	public void setMinServicePeriodForRoleIds(String minServicePeriodForRoleIds) {
		_minServicePeriodForRoleIds = minServicePeriodForRoleIds;
	}

	public String getMaxConsecutiveLeaves() {
		return _maxConsecutiveLeaves;
	}

	public void setMaxConsecutiveLeaves(String maxConsecutiveLeaves) {
		_maxConsecutiveLeaves = maxConsecutiveLeaves;
	}

	public String getMaxConsecLeavesForRoleIds() {
		return _maxConsecLeavesForRoleIds;
	}

	public void setMaxConsecLeavesForRoleIds(String maxConsecLeavesForRoleIds) {
		_maxConsecLeavesForRoleIds = maxConsecLeavesForRoleIds;
	}

	public String getMaxSmallChildAgeApplicable() {
		return _maxSmallChildAgeApplicable;
	}

	public void setMaxSmallChildAgeApplicable(String maxSmallChildAgeApplicable) {
		_maxSmallChildAgeApplicable = maxSmallChildAgeApplicable;
	}

	public String getMaxSmallChildAgeForRoleIds() {
		return _maxSmallChildAgeForRoleIds;
	}

	public void setMaxSmallChildAgeForRoleIds(String maxSmallChildAgeForRoleIds) {
		_maxSmallChildAgeForRoleIds = maxSmallChildAgeForRoleIds;
	}

	private long _leaveRestrictionId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private boolean _cannotExceedBalance;
	private String _cantExceedBalForRoleIds;
	private boolean _cannotApplyForPartialDay;
	private String _cantApplyPartialDayForRoleIds;
	private String _termsQuestion;
	private String _termsQsnForRoleIds;
	private String _errorTextIfTermsDeclined;
	private String _minimumServicePeriod;
	private String _minServicePeriodForRoleIds;
	private String _maxConsecutiveLeaves;
	private String _maxConsecLeavesForRoleIds;
	private String _maxSmallChildAgeApplicable;
	private String _maxSmallChildAgeForRoleIds;
}