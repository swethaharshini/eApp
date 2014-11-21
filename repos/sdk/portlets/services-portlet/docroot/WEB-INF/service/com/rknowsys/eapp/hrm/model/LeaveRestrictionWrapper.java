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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeaveRestriction}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveRestriction
 * @generated
 */
public class LeaveRestrictionWrapper implements LeaveRestriction,
	ModelWrapper<LeaveRestriction> {
	public LeaveRestrictionWrapper(LeaveRestriction leaveRestriction) {
		_leaveRestriction = leaveRestriction;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRestriction.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRestriction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveRestrictionId", getLeaveRestrictionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("cannotExceedBalance", getCannotExceedBalance());
		attributes.put("cannotApplyForPartialDay", getCannotApplyForPartialDay());
		attributes.put("ifATermsQuestion", getIfATermsQuestion());
		attributes.put("termsQuestion", getTermsQuestion());
		attributes.put("errorTextIfTermsDeclined", getErrorTextIfTermsDeclined());
		attributes.put("isMinimumServicePeriodApplicable",
			getIsMinimumServicePeriodApplicable());
		attributes.put("minimumServicePeriod", getMinimumServicePeriod());
		attributes.put("isMaxConsecutiveLeavesApplicable",
			getIsMaxConsecutiveLeavesApplicable());
		attributes.put("maxConsecutiveLeaves", getMaxConsecutiveLeaves());
		attributes.put("isSmallChildCriterionApplicable",
			getIsSmallChildCriterionApplicable());
		attributes.put("maxSmallChildAgeApplicable",
			getMaxSmallChildAgeApplicable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveRestrictionId = (Long)attributes.get("leaveRestrictionId");

		if (leaveRestrictionId != null) {
			setLeaveRestrictionId(leaveRestrictionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Boolean cannotExceedBalance = (Boolean)attributes.get(
				"cannotExceedBalance");

		if (cannotExceedBalance != null) {
			setCannotExceedBalance(cannotExceedBalance);
		}

		Boolean cannotApplyForPartialDay = (Boolean)attributes.get(
				"cannotApplyForPartialDay");

		if (cannotApplyForPartialDay != null) {
			setCannotApplyForPartialDay(cannotApplyForPartialDay);
		}

		Boolean ifATermsQuestion = (Boolean)attributes.get("ifATermsQuestion");

		if (ifATermsQuestion != null) {
			setIfATermsQuestion(ifATermsQuestion);
		}

		String termsQuestion = (String)attributes.get("termsQuestion");

		if (termsQuestion != null) {
			setTermsQuestion(termsQuestion);
		}

		String errorTextIfTermsDeclined = (String)attributes.get(
				"errorTextIfTermsDeclined");

		if (errorTextIfTermsDeclined != null) {
			setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
		}

		Boolean isMinimumServicePeriodApplicable = (Boolean)attributes.get(
				"isMinimumServicePeriodApplicable");

		if (isMinimumServicePeriodApplicable != null) {
			setIsMinimumServicePeriodApplicable(isMinimumServicePeriodApplicable);
		}

		String minimumServicePeriod = (String)attributes.get(
				"minimumServicePeriod");

		if (minimumServicePeriod != null) {
			setMinimumServicePeriod(minimumServicePeriod);
		}

		Boolean isMaxConsecutiveLeavesApplicable = (Boolean)attributes.get(
				"isMaxConsecutiveLeavesApplicable");

		if (isMaxConsecutiveLeavesApplicable != null) {
			setIsMaxConsecutiveLeavesApplicable(isMaxConsecutiveLeavesApplicable);
		}

		String maxConsecutiveLeaves = (String)attributes.get(
				"maxConsecutiveLeaves");

		if (maxConsecutiveLeaves != null) {
			setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		}

		Boolean isSmallChildCriterionApplicable = (Boolean)attributes.get(
				"isSmallChildCriterionApplicable");

		if (isSmallChildCriterionApplicable != null) {
			setIsSmallChildCriterionApplicable(isSmallChildCriterionApplicable);
		}

		String maxSmallChildAgeApplicable = (String)attributes.get(
				"maxSmallChildAgeApplicable");

		if (maxSmallChildAgeApplicable != null) {
			setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		}
	}

	/**
	* Returns the primary key of this leave restriction.
	*
	* @return the primary key of this leave restriction
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveRestriction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leave restriction.
	*
	* @param primaryKey the primary key of this leave restriction
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveRestriction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the leave restriction ID of this leave restriction.
	*
	* @return the leave restriction ID of this leave restriction
	*/
	@Override
	public long getLeaveRestrictionId() {
		return _leaveRestriction.getLeaveRestrictionId();
	}

	/**
	* Sets the leave restriction ID of this leave restriction.
	*
	* @param leaveRestrictionId the leave restriction ID of this leave restriction
	*/
	@Override
	public void setLeaveRestrictionId(long leaveRestrictionId) {
		_leaveRestriction.setLeaveRestrictionId(leaveRestrictionId);
	}

	/**
	* Returns the company ID of this leave restriction.
	*
	* @return the company ID of this leave restriction
	*/
	@Override
	public long getCompanyId() {
		return _leaveRestriction.getCompanyId();
	}

	/**
	* Sets the company ID of this leave restriction.
	*
	* @param companyId the company ID of this leave restriction
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveRestriction.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this leave restriction.
	*
	* @return the group ID of this leave restriction
	*/
	@Override
	public long getGroupId() {
		return _leaveRestriction.getGroupId();
	}

	/**
	* Sets the group ID of this leave restriction.
	*
	* @param groupId the group ID of this leave restriction
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaveRestriction.setGroupId(groupId);
	}

	/**
	* Returns the create date of this leave restriction.
	*
	* @return the create date of this leave restriction
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leaveRestriction.getCreateDate();
	}

	/**
	* Sets the create date of this leave restriction.
	*
	* @param createDate the create date of this leave restriction
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leaveRestriction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this leave restriction.
	*
	* @return the modified date of this leave restriction
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leaveRestriction.getModifiedDate();
	}

	/**
	* Sets the modified date of this leave restriction.
	*
	* @param modifiedDate the modified date of this leave restriction
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leaveRestriction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this leave restriction.
	*
	* @return the user ID of this leave restriction
	*/
	@Override
	public long getUserId() {
		return _leaveRestriction.getUserId();
	}

	/**
	* Sets the user ID of this leave restriction.
	*
	* @param userId the user ID of this leave restriction
	*/
	@Override
	public void setUserId(long userId) {
		_leaveRestriction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leave restriction.
	*
	* @return the user uuid of this leave restriction
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestriction.getUserUuid();
	}

	/**
	* Sets the user uuid of this leave restriction.
	*
	* @param userUuid the user uuid of this leave restriction
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaveRestriction.setUserUuid(userUuid);
	}

	/**
	* Returns the leave type ID of this leave restriction.
	*
	* @return the leave type ID of this leave restriction
	*/
	@Override
	public long getLeaveTypeId() {
		return _leaveRestriction.getLeaveTypeId();
	}

	/**
	* Sets the leave type ID of this leave restriction.
	*
	* @param leaveTypeId the leave type ID of this leave restriction
	*/
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		_leaveRestriction.setLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the cannot exceed balance of this leave restriction.
	*
	* @return the cannot exceed balance of this leave restriction
	*/
	@Override
	public boolean getCannotExceedBalance() {
		return _leaveRestriction.getCannotExceedBalance();
	}

	/**
	* Returns <code>true</code> if this leave restriction is cannot exceed balance.
	*
	* @return <code>true</code> if this leave restriction is cannot exceed balance; <code>false</code> otherwise
	*/
	@Override
	public boolean isCannotExceedBalance() {
		return _leaveRestriction.isCannotExceedBalance();
	}

	/**
	* Sets whether this leave restriction is cannot exceed balance.
	*
	* @param cannotExceedBalance the cannot exceed balance of this leave restriction
	*/
	@Override
	public void setCannotExceedBalance(boolean cannotExceedBalance) {
		_leaveRestriction.setCannotExceedBalance(cannotExceedBalance);
	}

	/**
	* Returns the cannot apply for partial day of this leave restriction.
	*
	* @return the cannot apply for partial day of this leave restriction
	*/
	@Override
	public boolean getCannotApplyForPartialDay() {
		return _leaveRestriction.getCannotApplyForPartialDay();
	}

	/**
	* Returns <code>true</code> if this leave restriction is cannot apply for partial day.
	*
	* @return <code>true</code> if this leave restriction is cannot apply for partial day; <code>false</code> otherwise
	*/
	@Override
	public boolean isCannotApplyForPartialDay() {
		return _leaveRestriction.isCannotApplyForPartialDay();
	}

	/**
	* Sets whether this leave restriction is cannot apply for partial day.
	*
	* @param cannotApplyForPartialDay the cannot apply for partial day of this leave restriction
	*/
	@Override
	public void setCannotApplyForPartialDay(boolean cannotApplyForPartialDay) {
		_leaveRestriction.setCannotApplyForPartialDay(cannotApplyForPartialDay);
	}

	/**
	* Returns the if a terms question of this leave restriction.
	*
	* @return the if a terms question of this leave restriction
	*/
	@Override
	public boolean getIfATermsQuestion() {
		return _leaveRestriction.getIfATermsQuestion();
	}

	/**
	* Returns <code>true</code> if this leave restriction is if a terms question.
	*
	* @return <code>true</code> if this leave restriction is if a terms question; <code>false</code> otherwise
	*/
	@Override
	public boolean isIfATermsQuestion() {
		return _leaveRestriction.isIfATermsQuestion();
	}

	/**
	* Sets whether this leave restriction is if a terms question.
	*
	* @param ifATermsQuestion the if a terms question of this leave restriction
	*/
	@Override
	public void setIfATermsQuestion(boolean ifATermsQuestion) {
		_leaveRestriction.setIfATermsQuestion(ifATermsQuestion);
	}

	/**
	* Returns the terms question of this leave restriction.
	*
	* @return the terms question of this leave restriction
	*/
	@Override
	public java.lang.String getTermsQuestion() {
		return _leaveRestriction.getTermsQuestion();
	}

	/**
	* Sets the terms question of this leave restriction.
	*
	* @param termsQuestion the terms question of this leave restriction
	*/
	@Override
	public void setTermsQuestion(java.lang.String termsQuestion) {
		_leaveRestriction.setTermsQuestion(termsQuestion);
	}

	/**
	* Returns the error text if terms declined of this leave restriction.
	*
	* @return the error text if terms declined of this leave restriction
	*/
	@Override
	public java.lang.String getErrorTextIfTermsDeclined() {
		return _leaveRestriction.getErrorTextIfTermsDeclined();
	}

	/**
	* Sets the error text if terms declined of this leave restriction.
	*
	* @param errorTextIfTermsDeclined the error text if terms declined of this leave restriction
	*/
	@Override
	public void setErrorTextIfTermsDeclined(
		java.lang.String errorTextIfTermsDeclined) {
		_leaveRestriction.setErrorTextIfTermsDeclined(errorTextIfTermsDeclined);
	}

	/**
	* Returns the is minimum service period applicable of this leave restriction.
	*
	* @return the is minimum service period applicable of this leave restriction
	*/
	@Override
	public boolean getIsMinimumServicePeriodApplicable() {
		return _leaveRestriction.getIsMinimumServicePeriodApplicable();
	}

	/**
	* Returns <code>true</code> if this leave restriction is is minimum service period applicable.
	*
	* @return <code>true</code> if this leave restriction is is minimum service period applicable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMinimumServicePeriodApplicable() {
		return _leaveRestriction.isIsMinimumServicePeriodApplicable();
	}

	/**
	* Sets whether this leave restriction is is minimum service period applicable.
	*
	* @param isMinimumServicePeriodApplicable the is minimum service period applicable of this leave restriction
	*/
	@Override
	public void setIsMinimumServicePeriodApplicable(
		boolean isMinimumServicePeriodApplicable) {
		_leaveRestriction.setIsMinimumServicePeriodApplicable(isMinimumServicePeriodApplicable);
	}

	/**
	* Returns the minimum service period of this leave restriction.
	*
	* @return the minimum service period of this leave restriction
	*/
	@Override
	public java.lang.String getMinimumServicePeriod() {
		return _leaveRestriction.getMinimumServicePeriod();
	}

	/**
	* Sets the minimum service period of this leave restriction.
	*
	* @param minimumServicePeriod the minimum service period of this leave restriction
	*/
	@Override
	public void setMinimumServicePeriod(java.lang.String minimumServicePeriod) {
		_leaveRestriction.setMinimumServicePeriod(minimumServicePeriod);
	}

	/**
	* Returns the is max consecutive leaves applicable of this leave restriction.
	*
	* @return the is max consecutive leaves applicable of this leave restriction
	*/
	@Override
	public boolean getIsMaxConsecutiveLeavesApplicable() {
		return _leaveRestriction.getIsMaxConsecutiveLeavesApplicable();
	}

	/**
	* Returns <code>true</code> if this leave restriction is is max consecutive leaves applicable.
	*
	* @return <code>true</code> if this leave restriction is is max consecutive leaves applicable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMaxConsecutiveLeavesApplicable() {
		return _leaveRestriction.isIsMaxConsecutiveLeavesApplicable();
	}

	/**
	* Sets whether this leave restriction is is max consecutive leaves applicable.
	*
	* @param isMaxConsecutiveLeavesApplicable the is max consecutive leaves applicable of this leave restriction
	*/
	@Override
	public void setIsMaxConsecutiveLeavesApplicable(
		boolean isMaxConsecutiveLeavesApplicable) {
		_leaveRestriction.setIsMaxConsecutiveLeavesApplicable(isMaxConsecutiveLeavesApplicable);
	}

	/**
	* Returns the max consecutive leaves of this leave restriction.
	*
	* @return the max consecutive leaves of this leave restriction
	*/
	@Override
	public java.lang.String getMaxConsecutiveLeaves() {
		return _leaveRestriction.getMaxConsecutiveLeaves();
	}

	/**
	* Sets the max consecutive leaves of this leave restriction.
	*
	* @param maxConsecutiveLeaves the max consecutive leaves of this leave restriction
	*/
	@Override
	public void setMaxConsecutiveLeaves(java.lang.String maxConsecutiveLeaves) {
		_leaveRestriction.setMaxConsecutiveLeaves(maxConsecutiveLeaves);
	}

	/**
	* Returns the is small child criterion applicable of this leave restriction.
	*
	* @return the is small child criterion applicable of this leave restriction
	*/
	@Override
	public boolean getIsSmallChildCriterionApplicable() {
		return _leaveRestriction.getIsSmallChildCriterionApplicable();
	}

	/**
	* Returns <code>true</code> if this leave restriction is is small child criterion applicable.
	*
	* @return <code>true</code> if this leave restriction is is small child criterion applicable; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSmallChildCriterionApplicable() {
		return _leaveRestriction.isIsSmallChildCriterionApplicable();
	}

	/**
	* Sets whether this leave restriction is is small child criterion applicable.
	*
	* @param isSmallChildCriterionApplicable the is small child criterion applicable of this leave restriction
	*/
	@Override
	public void setIsSmallChildCriterionApplicable(
		boolean isSmallChildCriterionApplicable) {
		_leaveRestriction.setIsSmallChildCriterionApplicable(isSmallChildCriterionApplicable);
	}

	/**
	* Returns the max small child age applicable of this leave restriction.
	*
	* @return the max small child age applicable of this leave restriction
	*/
	@Override
	public java.lang.String getMaxSmallChildAgeApplicable() {
		return _leaveRestriction.getMaxSmallChildAgeApplicable();
	}

	/**
	* Sets the max small child age applicable of this leave restriction.
	*
	* @param maxSmallChildAgeApplicable the max small child age applicable of this leave restriction
	*/
	@Override
	public void setMaxSmallChildAgeApplicable(
		java.lang.String maxSmallChildAgeApplicable) {
		_leaveRestriction.setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
	}

	@Override
	public boolean isNew() {
		return _leaveRestriction.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaveRestriction.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaveRestriction.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveRestriction.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveRestriction.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaveRestriction.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaveRestriction.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaveRestriction.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaveRestriction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaveRestriction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaveRestriction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaveRestrictionWrapper((LeaveRestriction)_leaveRestriction.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.LeaveRestriction leaveRestriction) {
		return _leaveRestriction.compareTo(leaveRestriction);
	}

	@Override
	public int hashCode() {
		return _leaveRestriction.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.LeaveRestriction> toCacheModel() {
		return _leaveRestriction.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction toEscapedModel() {
		return new LeaveRestrictionWrapper(_leaveRestriction.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction toUnescapedModel() {
		return new LeaveRestrictionWrapper(_leaveRestriction.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaveRestriction.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaveRestriction.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRestriction.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRestrictionWrapper)) {
			return false;
		}

		LeaveRestrictionWrapper leaveRestrictionWrapper = (LeaveRestrictionWrapper)obj;

		if (Validator.equals(_leaveRestriction,
					leaveRestrictionWrapper._leaveRestriction)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaveRestriction getWrappedLeaveRestriction() {
		return _leaveRestriction;
	}

	@Override
	public LeaveRestriction getWrappedModel() {
		return _leaveRestriction;
	}

	@Override
	public void resetOriginalValues() {
		_leaveRestriction.resetOriginalValues();
	}

	private LeaveRestriction _leaveRestriction;
}