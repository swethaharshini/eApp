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
 * This class is a wrapper for {@link EmpContactDetails}.
 * </p>
 *
 * @author rknowsys
 * @see EmpContactDetails
 * @generated
 */
public class EmpContactDetailsWrapper implements EmpContactDetails,
	ModelWrapper<EmpContactDetails> {
	public EmpContactDetailsWrapper(EmpContactDetails empContactDetails) {
		_empContactDetails = empContactDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpContactDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpContactDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empContactDetailsId", getEmpContactDetailsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("addressStreet1", getAddressStreet1());
		attributes.put("addressStreet2", getAddressStreet2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("postalCode", getPostalCode());
		attributes.put("country", getCountry());
		attributes.put("homeTelephone", getHomeTelephone());
		attributes.put("mobile", getMobile());
		attributes.put("workTelephone", getWorkTelephone());
		attributes.put("workEmail", getWorkEmail());
		attributes.put("otherEmail", getOtherEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empContactDetailsId = (Long)attributes.get("empContactDetailsId");

		if (empContactDetailsId != null) {
			setEmpContactDetailsId(empContactDetailsId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String addressStreet1 = (String)attributes.get("addressStreet1");

		if (addressStreet1 != null) {
			setAddressStreet1(addressStreet1);
		}

		String addressStreet2 = (String)attributes.get("addressStreet2");

		if (addressStreet2 != null) {
			setAddressStreet2(addressStreet2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String homeTelephone = (String)attributes.get("homeTelephone");

		if (homeTelephone != null) {
			setHomeTelephone(homeTelephone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String workTelephone = (String)attributes.get("workTelephone");

		if (workTelephone != null) {
			setWorkTelephone(workTelephone);
		}

		String workEmail = (String)attributes.get("workEmail");

		if (workEmail != null) {
			setWorkEmail(workEmail);
		}

		String otherEmail = (String)attributes.get("otherEmail");

		if (otherEmail != null) {
			setOtherEmail(otherEmail);
		}
	}

	/**
	* Returns the primary key of this EmpContactDetails.
	*
	* @return the primary key of this EmpContactDetails
	*/
	@Override
	public long getPrimaryKey() {
		return _empContactDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmpContactDetails.
	*
	* @param primaryKey the primary key of this EmpContactDetails
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empContactDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp contact details ID of this EmpContactDetails.
	*
	* @return the emp contact details ID of this EmpContactDetails
	*/
	@Override
	public long getEmpContactDetailsId() {
		return _empContactDetails.getEmpContactDetailsId();
	}

	/**
	* Sets the emp contact details ID of this EmpContactDetails.
	*
	* @param empContactDetailsId the emp contact details ID of this EmpContactDetails
	*/
	@Override
	public void setEmpContactDetailsId(long empContactDetailsId) {
		_empContactDetails.setEmpContactDetailsId(empContactDetailsId);
	}

	/**
	* Returns the employee ID of this EmpContactDetails.
	*
	* @return the employee ID of this EmpContactDetails
	*/
	@Override
	public long getEmployeeId() {
		return _empContactDetails.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmpContactDetails.
	*
	* @param employeeId the employee ID of this EmpContactDetails
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empContactDetails.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmpContactDetails.
	*
	* @return the group ID of this EmpContactDetails
	*/
	@Override
	public long getGroupId() {
		return _empContactDetails.getGroupId();
	}

	/**
	* Sets the group ID of this EmpContactDetails.
	*
	* @param groupId the group ID of this EmpContactDetails
	*/
	@Override
	public void setGroupId(long groupId) {
		_empContactDetails.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmpContactDetails.
	*
	* @return the company ID of this EmpContactDetails
	*/
	@Override
	public long getCompanyId() {
		return _empContactDetails.getCompanyId();
	}

	/**
	* Sets the company ID of this EmpContactDetails.
	*
	* @param companyId the company ID of this EmpContactDetails
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empContactDetails.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmpContactDetails.
	*
	* @return the user ID of this EmpContactDetails
	*/
	@Override
	public long getUserId() {
		return _empContactDetails.getUserId();
	}

	/**
	* Sets the user ID of this EmpContactDetails.
	*
	* @param userId the user ID of this EmpContactDetails
	*/
	@Override
	public void setUserId(long userId) {
		_empContactDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmpContactDetails.
	*
	* @return the user uuid of this EmpContactDetails
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmpContactDetails.
	*
	* @param userUuid the user uuid of this EmpContactDetails
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empContactDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this EmpContactDetails.
	*
	* @return the user name of this EmpContactDetails
	*/
	@Override
	public java.lang.String getUserName() {
		return _empContactDetails.getUserName();
	}

	/**
	* Sets the user name of this EmpContactDetails.
	*
	* @param userName the user name of this EmpContactDetails
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empContactDetails.setUserName(userName);
	}

	/**
	* Returns the create date of this EmpContactDetails.
	*
	* @return the create date of this EmpContactDetails
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empContactDetails.getCreateDate();
	}

	/**
	* Sets the create date of this EmpContactDetails.
	*
	* @param createDate the create date of this EmpContactDetails
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empContactDetails.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmpContactDetails.
	*
	* @return the modified date of this EmpContactDetails
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empContactDetails.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmpContactDetails.
	*
	* @param modifiedDate the modified date of this EmpContactDetails
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empContactDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the address street1 of this EmpContactDetails.
	*
	* @return the address street1 of this EmpContactDetails
	*/
	@Override
	public java.lang.String getAddressStreet1() {
		return _empContactDetails.getAddressStreet1();
	}

	/**
	* Sets the address street1 of this EmpContactDetails.
	*
	* @param addressStreet1 the address street1 of this EmpContactDetails
	*/
	@Override
	public void setAddressStreet1(java.lang.String addressStreet1) {
		_empContactDetails.setAddressStreet1(addressStreet1);
	}

	/**
	* Returns the address street2 of this EmpContactDetails.
	*
	* @return the address street2 of this EmpContactDetails
	*/
	@Override
	public java.lang.String getAddressStreet2() {
		return _empContactDetails.getAddressStreet2();
	}

	/**
	* Sets the address street2 of this EmpContactDetails.
	*
	* @param addressStreet2 the address street2 of this EmpContactDetails
	*/
	@Override
	public void setAddressStreet2(java.lang.String addressStreet2) {
		_empContactDetails.setAddressStreet2(addressStreet2);
	}

	/**
	* Returns the city of this EmpContactDetails.
	*
	* @return the city of this EmpContactDetails
	*/
	@Override
	public java.lang.String getCity() {
		return _empContactDetails.getCity();
	}

	/**
	* Sets the city of this EmpContactDetails.
	*
	* @param city the city of this EmpContactDetails
	*/
	@Override
	public void setCity(java.lang.String city) {
		_empContactDetails.setCity(city);
	}

	/**
	* Returns the state of this EmpContactDetails.
	*
	* @return the state of this EmpContactDetails
	*/
	@Override
	public java.lang.String getState() {
		return _empContactDetails.getState();
	}

	/**
	* Sets the state of this EmpContactDetails.
	*
	* @param state the state of this EmpContactDetails
	*/
	@Override
	public void setState(java.lang.String state) {
		_empContactDetails.setState(state);
	}

	/**
	* Returns the postal code of this EmpContactDetails.
	*
	* @return the postal code of this EmpContactDetails
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _empContactDetails.getPostalCode();
	}

	/**
	* Sets the postal code of this EmpContactDetails.
	*
	* @param postalCode the postal code of this EmpContactDetails
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_empContactDetails.setPostalCode(postalCode);
	}

	/**
	* Returns the country of this EmpContactDetails.
	*
	* @return the country of this EmpContactDetails
	*/
	@Override
	public java.lang.String getCountry() {
		return _empContactDetails.getCountry();
	}

	/**
	* Sets the country of this EmpContactDetails.
	*
	* @param country the country of this EmpContactDetails
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_empContactDetails.setCountry(country);
	}

	/**
	* Returns the home telephone of this EmpContactDetails.
	*
	* @return the home telephone of this EmpContactDetails
	*/
	@Override
	public java.lang.String getHomeTelephone() {
		return _empContactDetails.getHomeTelephone();
	}

	/**
	* Sets the home telephone of this EmpContactDetails.
	*
	* @param homeTelephone the home telephone of this EmpContactDetails
	*/
	@Override
	public void setHomeTelephone(java.lang.String homeTelephone) {
		_empContactDetails.setHomeTelephone(homeTelephone);
	}

	/**
	* Returns the mobile of this EmpContactDetails.
	*
	* @return the mobile of this EmpContactDetails
	*/
	@Override
	public java.lang.String getMobile() {
		return _empContactDetails.getMobile();
	}

	/**
	* Sets the mobile of this EmpContactDetails.
	*
	* @param mobile the mobile of this EmpContactDetails
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_empContactDetails.setMobile(mobile);
	}

	/**
	* Returns the work telephone of this EmpContactDetails.
	*
	* @return the work telephone of this EmpContactDetails
	*/
	@Override
	public java.lang.String getWorkTelephone() {
		return _empContactDetails.getWorkTelephone();
	}

	/**
	* Sets the work telephone of this EmpContactDetails.
	*
	* @param workTelephone the work telephone of this EmpContactDetails
	*/
	@Override
	public void setWorkTelephone(java.lang.String workTelephone) {
		_empContactDetails.setWorkTelephone(workTelephone);
	}

	/**
	* Returns the work email of this EmpContactDetails.
	*
	* @return the work email of this EmpContactDetails
	*/
	@Override
	public java.lang.String getWorkEmail() {
		return _empContactDetails.getWorkEmail();
	}

	/**
	* Sets the work email of this EmpContactDetails.
	*
	* @param workEmail the work email of this EmpContactDetails
	*/
	@Override
	public void setWorkEmail(java.lang.String workEmail) {
		_empContactDetails.setWorkEmail(workEmail);
	}

	/**
	* Returns the other email of this EmpContactDetails.
	*
	* @return the other email of this EmpContactDetails
	*/
	@Override
	public java.lang.String getOtherEmail() {
		return _empContactDetails.getOtherEmail();
	}

	/**
	* Sets the other email of this EmpContactDetails.
	*
	* @param otherEmail the other email of this EmpContactDetails
	*/
	@Override
	public void setOtherEmail(java.lang.String otherEmail) {
		_empContactDetails.setOtherEmail(otherEmail);
	}

	@Override
	public boolean isNew() {
		return _empContactDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empContactDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empContactDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empContactDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empContactDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empContactDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empContactDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empContactDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empContactDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empContactDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empContactDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpContactDetailsWrapper((EmpContactDetails)_empContactDetails.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails) {
		return _empContactDetails.compareTo(empContactDetails);
	}

	@Override
	public int hashCode() {
		return _empContactDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpContactDetails> toCacheModel() {
		return _empContactDetails.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails toEscapedModel() {
		return new EmpContactDetailsWrapper(_empContactDetails.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails toUnescapedModel() {
		return new EmpContactDetailsWrapper(_empContactDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empContactDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empContactDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empContactDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpContactDetailsWrapper)) {
			return false;
		}

		EmpContactDetailsWrapper empContactDetailsWrapper = (EmpContactDetailsWrapper)obj;

		if (Validator.equals(_empContactDetails,
					empContactDetailsWrapper._empContactDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpContactDetails getWrappedEmpContactDetails() {
		return _empContactDetails;
	}

	@Override
	public EmpContactDetails getWrappedModel() {
		return _empContactDetails;
	}

	@Override
	public void resetOriginalValues() {
		_empContactDetails.resetOriginalValues();
	}

	private EmpContactDetails _empContactDetails;
}