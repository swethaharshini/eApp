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
 * This class is a wrapper for {@link EmpDirectDeposit}.
 * </p>
 *
 * @author rknowsys
 * @see EmpDirectDeposit
 * @generated
 */
public class EmpDirectDepositWrapper implements EmpDirectDeposit,
	ModelWrapper<EmpDirectDeposit> {
	public EmpDirectDepositWrapper(EmpDirectDeposit empDirectDeposit) {
		_empDirectDeposit = empDirectDeposit;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDirectDeposit.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDirectDeposit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empDirectDepositId", getEmpDirectDepositId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("amount", getAmount());
		attributes.put("accountNumber", getAccountNumber());
		attributes.put("bankName", getBankName());
		attributes.put("accountType", getAccountType());
		attributes.put("branchLocation", getBranchLocation());
		attributes.put("routingNumber", getRoutingNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empDirectDepositId = (Long)attributes.get("empDirectDepositId");

		if (empDirectDepositId != null) {
			setEmpDirectDepositId(empDirectDepositId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long accountNumber = (Long)attributes.get("accountNumber");

		if (accountNumber != null) {
			setAccountNumber(accountNumber);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String accountType = (String)attributes.get("accountType");

		if (accountType != null) {
			setAccountType(accountType);
		}

		String branchLocation = (String)attributes.get("branchLocation");

		if (branchLocation != null) {
			setBranchLocation(branchLocation);
		}

		String routingNumber = (String)attributes.get("routingNumber");

		if (routingNumber != null) {
			setRoutingNumber(routingNumber);
		}
	}

	/**
	* Returns the primary key of this emp direct deposit.
	*
	* @return the primary key of this emp direct deposit
	*/
	@Override
	public long getPrimaryKey() {
		return _empDirectDeposit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp direct deposit.
	*
	* @param primaryKey the primary key of this emp direct deposit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empDirectDeposit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp direct deposit ID of this emp direct deposit.
	*
	* @return the emp direct deposit ID of this emp direct deposit
	*/
	@Override
	public long getEmpDirectDepositId() {
		return _empDirectDeposit.getEmpDirectDepositId();
	}

	/**
	* Sets the emp direct deposit ID of this emp direct deposit.
	*
	* @param empDirectDepositId the emp direct deposit ID of this emp direct deposit
	*/
	@Override
	public void setEmpDirectDepositId(long empDirectDepositId) {
		_empDirectDeposit.setEmpDirectDepositId(empDirectDepositId);
	}

	/**
	* Returns the employee ID of this emp direct deposit.
	*
	* @return the employee ID of this emp direct deposit
	*/
	@Override
	public long getEmployeeId() {
		return _empDirectDeposit.getEmployeeId();
	}

	/**
	* Sets the employee ID of this emp direct deposit.
	*
	* @param employeeId the employee ID of this emp direct deposit
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empDirectDeposit.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this emp direct deposit.
	*
	* @return the group ID of this emp direct deposit
	*/
	@Override
	public long getGroupId() {
		return _empDirectDeposit.getGroupId();
	}

	/**
	* Sets the group ID of this emp direct deposit.
	*
	* @param groupId the group ID of this emp direct deposit
	*/
	@Override
	public void setGroupId(long groupId) {
		_empDirectDeposit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp direct deposit.
	*
	* @return the company ID of this emp direct deposit
	*/
	@Override
	public long getCompanyId() {
		return _empDirectDeposit.getCompanyId();
	}

	/**
	* Sets the company ID of this emp direct deposit.
	*
	* @param companyId the company ID of this emp direct deposit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empDirectDeposit.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this emp direct deposit.
	*
	* @return the create date of this emp direct deposit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empDirectDeposit.getCreateDate();
	}

	/**
	* Sets the create date of this emp direct deposit.
	*
	* @param createDate the create date of this emp direct deposit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empDirectDeposit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp direct deposit.
	*
	* @return the modified date of this emp direct deposit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empDirectDeposit.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp direct deposit.
	*
	* @param modifiedDate the modified date of this emp direct deposit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empDirectDeposit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this emp direct deposit.
	*
	* @return the user ID of this emp direct deposit
	*/
	@Override
	public long getUserId() {
		return _empDirectDeposit.getUserId();
	}

	/**
	* Sets the user ID of this emp direct deposit.
	*
	* @param userId the user ID of this emp direct deposit
	*/
	@Override
	public void setUserId(long userId) {
		_empDirectDeposit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp direct deposit.
	*
	* @return the user uuid of this emp direct deposit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDirectDeposit.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp direct deposit.
	*
	* @param userUuid the user uuid of this emp direct deposit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empDirectDeposit.setUserUuid(userUuid);
	}

	/**
	* Returns the amount of this emp direct deposit.
	*
	* @return the amount of this emp direct deposit
	*/
	@Override
	public long getAmount() {
		return _empDirectDeposit.getAmount();
	}

	/**
	* Sets the amount of this emp direct deposit.
	*
	* @param amount the amount of this emp direct deposit
	*/
	@Override
	public void setAmount(long amount) {
		_empDirectDeposit.setAmount(amount);
	}

	/**
	* Returns the account number of this emp direct deposit.
	*
	* @return the account number of this emp direct deposit
	*/
	@Override
	public long getAccountNumber() {
		return _empDirectDeposit.getAccountNumber();
	}

	/**
	* Sets the account number of this emp direct deposit.
	*
	* @param accountNumber the account number of this emp direct deposit
	*/
	@Override
	public void setAccountNumber(long accountNumber) {
		_empDirectDeposit.setAccountNumber(accountNumber);
	}

	/**
	* Returns the bank name of this emp direct deposit.
	*
	* @return the bank name of this emp direct deposit
	*/
	@Override
	public java.lang.String getBankName() {
		return _empDirectDeposit.getBankName();
	}

	/**
	* Sets the bank name of this emp direct deposit.
	*
	* @param bankName the bank name of this emp direct deposit
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_empDirectDeposit.setBankName(bankName);
	}

	/**
	* Returns the account type of this emp direct deposit.
	*
	* @return the account type of this emp direct deposit
	*/
	@Override
	public java.lang.String getAccountType() {
		return _empDirectDeposit.getAccountType();
	}

	/**
	* Sets the account type of this emp direct deposit.
	*
	* @param accountType the account type of this emp direct deposit
	*/
	@Override
	public void setAccountType(java.lang.String accountType) {
		_empDirectDeposit.setAccountType(accountType);
	}

	/**
	* Returns the branch location of this emp direct deposit.
	*
	* @return the branch location of this emp direct deposit
	*/
	@Override
	public java.lang.String getBranchLocation() {
		return _empDirectDeposit.getBranchLocation();
	}

	/**
	* Sets the branch location of this emp direct deposit.
	*
	* @param branchLocation the branch location of this emp direct deposit
	*/
	@Override
	public void setBranchLocation(java.lang.String branchLocation) {
		_empDirectDeposit.setBranchLocation(branchLocation);
	}

	/**
	* Returns the routing number of this emp direct deposit.
	*
	* @return the routing number of this emp direct deposit
	*/
	@Override
	public java.lang.String getRoutingNumber() {
		return _empDirectDeposit.getRoutingNumber();
	}

	/**
	* Sets the routing number of this emp direct deposit.
	*
	* @param routingNumber the routing number of this emp direct deposit
	*/
	@Override
	public void setRoutingNumber(java.lang.String routingNumber) {
		_empDirectDeposit.setRoutingNumber(routingNumber);
	}

	@Override
	public boolean isNew() {
		return _empDirectDeposit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empDirectDeposit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empDirectDeposit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empDirectDeposit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empDirectDeposit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empDirectDeposit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empDirectDeposit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empDirectDeposit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empDirectDeposit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empDirectDeposit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empDirectDeposit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpDirectDepositWrapper((EmpDirectDeposit)_empDirectDeposit.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpDirectDeposit empDirectDeposit) {
		return _empDirectDeposit.compareTo(empDirectDeposit);
	}

	@Override
	public int hashCode() {
		return _empDirectDeposit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpDirectDeposit> toCacheModel() {
		return _empDirectDeposit.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDirectDeposit toEscapedModel() {
		return new EmpDirectDepositWrapper(_empDirectDeposit.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDirectDeposit toUnescapedModel() {
		return new EmpDirectDepositWrapper(_empDirectDeposit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empDirectDeposit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empDirectDeposit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empDirectDeposit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpDirectDepositWrapper)) {
			return false;
		}

		EmpDirectDepositWrapper empDirectDepositWrapper = (EmpDirectDepositWrapper)obj;

		if (Validator.equals(_empDirectDeposit,
					empDirectDepositWrapper._empDirectDeposit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpDirectDeposit getWrappedEmpDirectDeposit() {
		return _empDirectDeposit;
	}

	@Override
	public EmpDirectDeposit getWrappedModel() {
		return _empDirectDeposit;
	}

	@Override
	public void resetOriginalValues() {
		_empDirectDeposit.resetOriginalValues();
	}

	private EmpDirectDeposit _empDirectDeposit;
}