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
 * This class is a wrapper for {@link PayGrade}.
 * </p>
 *
 * @author rknowsys
 * @see PayGrade
 * @generated
 */
public class PayGradeWrapper implements PayGrade, ModelWrapper<PayGrade> {
	public PayGradeWrapper(PayGrade payGrade) {
		_payGrade = payGrade;
	}

	@Override
	public Class<?> getModelClass() {
		return PayGrade.class;
	}

	@Override
	public String getModelClassName() {
		return PayGrade.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payGradeId", getPayGradeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("payGradeName", getPayGradeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payGradeId = (Long)attributes.get("payGradeId");

		if (payGradeId != null) {
			setPayGradeId(payGradeId);
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

		String payGradeName = (String)attributes.get("payGradeName");

		if (payGradeName != null) {
			setPayGradeName(payGradeName);
		}
	}

	/**
	* Returns the primary key of this pay grade.
	*
	* @return the primary key of this pay grade
	*/
	@Override
	public long getPrimaryKey() {
		return _payGrade.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pay grade.
	*
	* @param primaryKey the primary key of this pay grade
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payGrade.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the pay grade ID of this pay grade.
	*
	* @return the pay grade ID of this pay grade
	*/
	@Override
	public long getPayGradeId() {
		return _payGrade.getPayGradeId();
	}

	/**
	* Sets the pay grade ID of this pay grade.
	*
	* @param payGradeId the pay grade ID of this pay grade
	*/
	@Override
	public void setPayGradeId(long payGradeId) {
		_payGrade.setPayGradeId(payGradeId);
	}

	/**
	* Returns the company ID of this pay grade.
	*
	* @return the company ID of this pay grade
	*/
	@Override
	public long getCompanyId() {
		return _payGrade.getCompanyId();
	}

	/**
	* Sets the company ID of this pay grade.
	*
	* @param companyId the company ID of this pay grade
	*/
	@Override
	public void setCompanyId(long companyId) {
		_payGrade.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this pay grade.
	*
	* @return the group ID of this pay grade
	*/
	@Override
	public long getGroupId() {
		return _payGrade.getGroupId();
	}

	/**
	* Sets the group ID of this pay grade.
	*
	* @param groupId the group ID of this pay grade
	*/
	@Override
	public void setGroupId(long groupId) {
		_payGrade.setGroupId(groupId);
	}

	/**
	* Returns the create date of this pay grade.
	*
	* @return the create date of this pay grade
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _payGrade.getCreateDate();
	}

	/**
	* Sets the create date of this pay grade.
	*
	* @param createDate the create date of this pay grade
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_payGrade.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this pay grade.
	*
	* @return the modified date of this pay grade
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _payGrade.getModifiedDate();
	}

	/**
	* Sets the modified date of this pay grade.
	*
	* @param modifiedDate the modified date of this pay grade
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_payGrade.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this pay grade.
	*
	* @return the user ID of this pay grade
	*/
	@Override
	public long getUserId() {
		return _payGrade.getUserId();
	}

	/**
	* Sets the user ID of this pay grade.
	*
	* @param userId the user ID of this pay grade
	*/
	@Override
	public void setUserId(long userId) {
		_payGrade.setUserId(userId);
	}

	/**
	* Returns the user uuid of this pay grade.
	*
	* @return the user uuid of this pay grade
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGrade.getUserUuid();
	}

	/**
	* Sets the user uuid of this pay grade.
	*
	* @param userUuid the user uuid of this pay grade
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_payGrade.setUserUuid(userUuid);
	}

	/**
	* Returns the pay grade name of this pay grade.
	*
	* @return the pay grade name of this pay grade
	*/
	@Override
	public java.lang.String getPayGradeName() {
		return _payGrade.getPayGradeName();
	}

	/**
	* Sets the pay grade name of this pay grade.
	*
	* @param payGradeName the pay grade name of this pay grade
	*/
	@Override
	public void setPayGradeName(java.lang.String payGradeName) {
		_payGrade.setPayGradeName(payGradeName);
	}

	@Override
	public boolean isNew() {
		return _payGrade.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_payGrade.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _payGrade.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payGrade.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _payGrade.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _payGrade.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_payGrade.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _payGrade.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_payGrade.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_payGrade.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_payGrade.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PayGradeWrapper((PayGrade)_payGrade.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.PayGrade payGrade) {
		return _payGrade.compareTo(payGrade);
	}

	@Override
	public int hashCode() {
		return _payGrade.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.PayGrade> toCacheModel() {
		return _payGrade.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.PayGrade toEscapedModel() {
		return new PayGradeWrapper(_payGrade.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.PayGrade toUnescapedModel() {
		return new PayGradeWrapper(_payGrade.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _payGrade.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _payGrade.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_payGrade.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayGradeWrapper)) {
			return false;
		}

		PayGradeWrapper payGradeWrapper = (PayGradeWrapper)obj;

		if (Validator.equals(_payGrade, payGradeWrapper._payGrade)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PayGrade getWrappedPayGrade() {
		return _payGrade;
	}

	@Override
	public PayGrade getWrappedModel() {
		return _payGrade;
	}

	@Override
	public void resetOriginalValues() {
		_payGrade.resetOriginalValues();
	}

	private PayGrade _payGrade;
}