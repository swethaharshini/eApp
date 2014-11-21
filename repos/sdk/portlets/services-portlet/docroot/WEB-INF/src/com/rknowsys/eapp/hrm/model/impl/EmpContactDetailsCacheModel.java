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

import com.rknowsys.eapp.hrm.model.EmpContactDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpContactDetails in entity cache.
 *
 * @author rknowsys
 * @see EmpContactDetails
 * @generated
 */
public class EmpContactDetailsCacheModel implements CacheModel<EmpContactDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{empContactDetailsId=");
		sb.append(empContactDetailsId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", addressStreet1=");
		sb.append(addressStreet1);
		sb.append(", addressStreet2=");
		sb.append(addressStreet2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", country=");
		sb.append(country);
		sb.append(", homeTelephone=");
		sb.append(homeTelephone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", workTelephone=");
		sb.append(workTelephone);
		sb.append(", workEmail=");
		sb.append(workEmail);
		sb.append(", otherEmail=");
		sb.append(otherEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpContactDetails toEntityModel() {
		EmpContactDetailsImpl empContactDetailsImpl = new EmpContactDetailsImpl();

		empContactDetailsImpl.setEmpContactDetailsId(empContactDetailsId);
		empContactDetailsImpl.setEmployeeId(employeeId);
		empContactDetailsImpl.setGroupId(groupId);
		empContactDetailsImpl.setCompanyId(companyId);
		empContactDetailsImpl.setUserId(userId);

		if (userName == null) {
			empContactDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empContactDetailsImpl.setCreateDate(null);
		}
		else {
			empContactDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empContactDetailsImpl.setModifiedDate(null);
		}
		else {
			empContactDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (addressStreet1 == null) {
			empContactDetailsImpl.setAddressStreet1(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setAddressStreet1(addressStreet1);
		}

		if (addressStreet2 == null) {
			empContactDetailsImpl.setAddressStreet2(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setAddressStreet2(addressStreet2);
		}

		if (city == null) {
			empContactDetailsImpl.setCity(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setCity(city);
		}

		if (state == null) {
			empContactDetailsImpl.setState(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setState(state);
		}

		if (postalCode == null) {
			empContactDetailsImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setPostalCode(postalCode);
		}

		if (country == null) {
			empContactDetailsImpl.setCountry(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setCountry(country);
		}

		if (homeTelephone == null) {
			empContactDetailsImpl.setHomeTelephone(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setHomeTelephone(homeTelephone);
		}

		if (mobile == null) {
			empContactDetailsImpl.setMobile(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setMobile(mobile);
		}

		if (workTelephone == null) {
			empContactDetailsImpl.setWorkTelephone(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setWorkTelephone(workTelephone);
		}

		if (workEmail == null) {
			empContactDetailsImpl.setWorkEmail(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setWorkEmail(workEmail);
		}

		if (otherEmail == null) {
			empContactDetailsImpl.setOtherEmail(StringPool.BLANK);
		}
		else {
			empContactDetailsImpl.setOtherEmail(otherEmail);
		}

		empContactDetailsImpl.resetOriginalValues();

		return empContactDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empContactDetailsId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		addressStreet1 = objectInput.readUTF();
		addressStreet2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		country = objectInput.readUTF();
		homeTelephone = objectInput.readUTF();
		mobile = objectInput.readUTF();
		workTelephone = objectInput.readUTF();
		workEmail = objectInput.readUTF();
		otherEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empContactDetailsId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (addressStreet1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet1);
		}

		if (addressStreet2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (homeTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeTelephone);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (workTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workTelephone);
		}

		if (workEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workEmail);
		}

		if (otherEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherEmail);
		}
	}

	public long empContactDetailsId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String addressStreet1;
	public String addressStreet2;
	public String city;
	public String state;
	public String postalCode;
	public String country;
	public String homeTelephone;
	public String mobile;
	public String workTelephone;
	public String workEmail;
	public String otherEmail;
}