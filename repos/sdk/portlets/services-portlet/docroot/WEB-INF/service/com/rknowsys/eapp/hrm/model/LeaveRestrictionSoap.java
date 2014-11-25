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
		soapModel.setCannotApplyForPartialDay(model.getCannotApplyForPartialDay());
		soapModel.setIfATermsQuestion(model.getIfATermsQuestion());
		soapModel.setTermsQuestion(model.getTermsQuestion());
		soapModel.setErrorTextIfTermsDeclined(model.getErrorTextIfTermsDeclined());
		soapModel.setIsMinimumServicePeriodApplicable(model.getIsMinimumServicePeriodApplicable());
		soapModel.setMinimumServicePeriod(model.getMinimumServicePeriod());
		soapModel.setIsMaxConsecutiveLeavesApplicable(model.getIsMaxConsecutiveLeavesApplicable());
		soapModel.setMaxConsecutiveLeaves(model.getMaxConsecutiveLeaves());
		soapModel.setIsSmallChildCriterionApplicable(model.getIsSmallChildCriterionApplicable());
		soapModel.setMaxSmallChildAgeApplicable(model.getMaxSmallChildAgeApplicable());

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

	public boolean getCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	public boolean isCannotApplyForPartialDay() {
		return _cannotApplyForPartialDay;
	}

	public void setCannotApplyForPartialDay(boolean cannotApplyForPartialDay) {
		_cannotApplyForPartialDay = cannotApplyForPartialDay;
	}

	public boolean getIfATermsQuestion() {
		return _ifATermsQuestion;
	}

	public boolean isIfATermsQuestion() {
		return _ifATermsQuestion;
	}

	public void setIfATermsQuestion(boolean ifATermsQuestion) {
		_ifATermsQuestion = ifATermsQuestion;
	}

	public String getTermsQuestion() {
		return _termsQuestion;
	}

	public void setTermsQuestion(String termsQuestion) {
		_termsQuestion = termsQuestion;
	}

	public String getErrorTextIfTermsDeclined() {
		return _errorTextIfTermsDeclined;
	}

	public void setErrorTextIfTermsDeclined(String errorTextIfTermsDeclined) {
		_errorTextIfTermsDeclined = errorTextIfTermsDeclined;
	}

	public boolean getIsMinimumServicePeriodApplicable() {
		return _isMinimumServicePeriodApplicable;
	}

	public boolean isIsMinimumServicePeriodApplicable() {
		return _isMinimumServicePeriodApplicable;
	}

	public void setIsMinimumServicePeriodApplicable(
		boolean isMinimumServicePeriodApplicable) {
		_isMinimumServicePeriodApplicable = isMinimumServicePeriodApplicable;
	}

	public String getMinimumServicePeriod() {
		return _minimumServicePeriod;
	}

	public void setMinimumServicePeriod(String minimumServicePeriod) {
		_minimumServicePeriod = minimumServicePeriod;
	}

	public boolean getIsMaxConsecutiveLeavesApplicable() {
		return _isMaxConsecutiveLeavesApplicable;
	}

	public boolean isIsMaxConsecutiveLeavesApplicable() {
		return _isMaxConsecutiveLeavesApplicable;
	}

	public void setIsMaxConsecutiveLeavesApplicable(
		boolean isMaxConsecutiveLeavesApplicable) {
		_isMaxConsecutiveLeavesApplicable = isMaxConsecutiveLeavesApplicable;
	}

	public String getMaxConsecutiveLeaves() {
		return _maxConsecutiveLeaves;
	}

	public void setMaxConsecutiveLeaves(String maxConsecutiveLeaves) {
		_maxConsecutiveLeaves = maxConsecutiveLeaves;
	}

	public boolean getIsSmallChildCriterionApplicable() {
		return _isSmallChildCriterionApplicable;
	}

	public boolean isIsSmallChildCriterionApplicable() {
		return _isSmallChildCriterionApplicable;
	}

	public void setIsSmallChildCriterionApplicable(
		boolean isSmallChildCriterionApplicable) {
		_isSmallChildCriterionApplicable = isSmallChildCriterionApplicable;
	}

	public String getMaxSmallChildAgeApplicable() {
		return _maxSmallChildAgeApplicable;
	}

	public void setMaxSmallChildAgeApplicable(String maxSmallChildAgeApplicable) {
		_maxSmallChildAgeApplicable = maxSmallChildAgeApplicable;
	}

	private long _leaveRestrictionId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _leaveTypeId;
	private boolean _cannotExceedBalance;
	private boolean _cannotApplyForPartialDay;
	private boolean _ifATermsQuestion;
	private String _termsQuestion;
	private String _errorTextIfTermsDeclined;
	private boolean _isMinimumServicePeriodApplicable;
	private String _minimumServicePeriod;
	private boolean _isMaxConsecutiveLeavesApplicable;
	private String _maxConsecutiveLeaves;
	private boolean _isSmallChildCriterionApplicable;
	private String _maxSmallChildAgeApplicable;
}