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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author rknowsys
 * @see Location
 * @generated
 */
public class LocationWrapper implements Location, ModelWrapper<Location> {
	public LocationWrapper(Location location) {
		_location = location;
	}

	@Override
	public Class<?> getModelClass() {
		return Location.class;
	}

	@Override
	public String getModelClassName() {
		return Location.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("city", getCity());
		attributes.put("address", getAddress());
		attributes.put("postalcode", getPostalcode());
		attributes.put("phone", getPhone());
		attributes.put("fax", getFax());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String postalcode = (String)attributes.get("postalcode");

		if (postalcode != null) {
			setPostalcode(postalcode);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	/**
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	@Override
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this location.
	*
	* @return the location ID of this location
	*/
	@Override
	public long getLocationId() {
		return _location.getLocationId();
	}

	/**
	* Sets the location ID of this location.
	*
	* @param locationId the location ID of this location
	*/
	@Override
	public void setLocationId(long locationId) {
		_location.setLocationId(locationId);
	}

	/**
	* Returns the nationality ID of this location.
	*
	* @return the nationality ID of this location
	*/
	@Override
	public long getNationalityId() {
		return _location.getNationalityId();
	}

	/**
	* Sets the nationality ID of this location.
	*
	* @param nationalityId the nationality ID of this location
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_location.setNationalityId(nationalityId);
	}

	/**
	* Returns the company ID of this location.
	*
	* @return the company ID of this location
	*/
	@Override
	public long getCompanyId() {
		return _location.getCompanyId();
	}

	/**
	* Sets the company ID of this location.
	*
	* @param companyId the company ID of this location
	*/
	@Override
	public void setCompanyId(long companyId) {
		_location.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this location.
	*
	* @return the group ID of this location
	*/
	@Override
	public long getGroupId() {
		return _location.getGroupId();
	}

	/**
	* Sets the group ID of this location.
	*
	* @param groupId the group ID of this location
	*/
	@Override
	public void setGroupId(long groupId) {
		_location.setGroupId(groupId);
	}

	/**
	* Returns the create date of this location.
	*
	* @return the create date of this location
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _location.getCreateDate();
	}

	/**
	* Sets the create date of this location.
	*
	* @param createDate the create date of this location
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_location.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this location.
	*
	* @return the modified date of this location
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _location.getModifiedDate();
	}

	/**
	* Sets the modified date of this location.
	*
	* @param modifiedDate the modified date of this location
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_location.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this location.
	*
	* @return the user ID of this location
	*/
	@Override
	public long getUserId() {
		return _location.getUserId();
	}

	/**
	* Sets the user ID of this location.
	*
	* @param userId the user ID of this location
	*/
	@Override
	public void setUserId(long userId) {
		_location.setUserId(userId);
	}

	/**
	* Returns the user uuid of this location.
	*
	* @return the user uuid of this location
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _location.getUserUuid();
	}

	/**
	* Sets the user uuid of this location.
	*
	* @param userUuid the user uuid of this location
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_location.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this location.
	*
	* @return the name of this location
	*/
	@Override
	public java.lang.String getName() {
		return _location.getName();
	}

	/**
	* Sets the name of this location.
	*
	* @param name the name of this location
	*/
	@Override
	public void setName(java.lang.String name) {
		_location.setName(name);
	}

	/**
	* Returns the country of this location.
	*
	* @return the country of this location
	*/
	@Override
	public java.lang.String getCountry() {
		return _location.getCountry();
	}

	/**
	* Sets the country of this location.
	*
	* @param country the country of this location
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_location.setCountry(country);
	}

	/**
	* Returns the state of this location.
	*
	* @return the state of this location
	*/
	@Override
	public java.lang.String getState() {
		return _location.getState();
	}

	/**
	* Sets the state of this location.
	*
	* @param state the state of this location
	*/
	@Override
	public void setState(java.lang.String state) {
		_location.setState(state);
	}

	/**
	* Returns the city of this location.
	*
	* @return the city of this location
	*/
	@Override
	public java.lang.String getCity() {
		return _location.getCity();
	}

	/**
	* Sets the city of this location.
	*
	* @param city the city of this location
	*/
	@Override
	public void setCity(java.lang.String city) {
		_location.setCity(city);
	}

	/**
	* Returns the address of this location.
	*
	* @return the address of this location
	*/
	@Override
	public java.lang.String getAddress() {
		return _location.getAddress();
	}

	/**
	* Sets the address of this location.
	*
	* @param address the address of this location
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_location.setAddress(address);
	}

	/**
	* Returns the postalcode of this location.
	*
	* @return the postalcode of this location
	*/
	@Override
	public java.lang.String getPostalcode() {
		return _location.getPostalcode();
	}

	/**
	* Sets the postalcode of this location.
	*
	* @param postalcode the postalcode of this location
	*/
	@Override
	public void setPostalcode(java.lang.String postalcode) {
		_location.setPostalcode(postalcode);
	}

	/**
	* Returns the phone of this location.
	*
	* @return the phone of this location
	*/
	@Override
	public java.lang.String getPhone() {
		return _location.getPhone();
	}

	/**
	* Sets the phone of this location.
	*
	* @param phone the phone of this location
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_location.setPhone(phone);
	}

	/**
	* Returns the fax of this location.
	*
	* @return the fax of this location
	*/
	@Override
	public java.lang.String getFax() {
		return _location.getFax();
	}

	/**
	* Sets the fax of this location.
	*
	* @param fax the fax of this location
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_location.setFax(fax);
	}

	/**
	* Returns the notes of this location.
	*
	* @return the notes of this location
	*/
	@Override
	public java.lang.String getNotes() {
		return _location.getNotes();
	}

	/**
	* Sets the notes of this location.
	*
	* @param notes the notes of this location
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_location.setNotes(notes);
	}

	@Override
	public boolean isNew() {
		return _location.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_location.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _location.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_location.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_location.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationWrapper((Location)_location.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Location> toCacheModel() {
		return _location.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Location toEscapedModel() {
		return new LocationWrapper(_location.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Location toUnescapedModel() {
		return new LocationWrapper(_location.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_location.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationWrapper)) {
			return false;
		}

		LocationWrapper locationWrapper = (LocationWrapper)obj;

		if (Validator.equals(_location, locationWrapper._location)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Location getWrappedLocation() {
		return _location;
	}

	@Override
	public Location getWrappedModel() {
		return _location;
	}

	@Override
	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private Location _location;
}