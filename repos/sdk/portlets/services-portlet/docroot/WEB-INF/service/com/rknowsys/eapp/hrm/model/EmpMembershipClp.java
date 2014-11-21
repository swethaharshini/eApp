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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.EmpMembershipLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpMembershipClp extends BaseModelImpl<EmpMembership>
	implements EmpMembership {
	public EmpMembershipClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpMembership.class;
	}

	@Override
	public String getModelClassName() {
		return EmpMembership.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empMembershipId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpMembershipId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empMembershipId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empMembershipId", getEmpMembershipId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("membershipId", getMembershipId());
		attributes.put("subscriptionPaidBy", getSubscriptionPaidBy());
		attributes.put("subscriptionAmt", getSubscriptionAmt());
		attributes.put("currency", getCurrency());
		attributes.put("commenceDate", getCommenceDate());
		attributes.put("renewalDate", getRenewalDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empMembershipId = (Long)attributes.get("empMembershipId");

		if (empMembershipId != null) {
			setEmpMembershipId(empMembershipId);
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

		Long membershipId = (Long)attributes.get("membershipId");

		if (membershipId != null) {
			setMembershipId(membershipId);
		}

		String subscriptionPaidBy = (String)attributes.get("subscriptionPaidBy");

		if (subscriptionPaidBy != null) {
			setSubscriptionPaidBy(subscriptionPaidBy);
		}

		Long subscriptionAmt = (Long)attributes.get("subscriptionAmt");

		if (subscriptionAmt != null) {
			setSubscriptionAmt(subscriptionAmt);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Date commenceDate = (Date)attributes.get("commenceDate");

		if (commenceDate != null) {
			setCommenceDate(commenceDate);
		}

		Date renewalDate = (Date)attributes.get("renewalDate");

		if (renewalDate != null) {
			setRenewalDate(renewalDate);
		}
	}

	@Override
	public long getEmpMembershipId() {
		return _empMembershipId;
	}

	@Override
	public void setEmpMembershipId(long empMembershipId) {
		_empMembershipId = empMembershipId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpMembershipId", long.class);

				method.invoke(_empMembershipRemoteModel, empMembershipId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empMembershipRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empMembershipRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empMembershipRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empMembershipRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empMembershipRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empMembershipRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getMembershipId() {
		return _membershipId;
	}

	@Override
	public void setMembershipId(long membershipId) {
		_membershipId = membershipId;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setMembershipId", long.class);

				method.invoke(_empMembershipRemoteModel, membershipId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubscriptionPaidBy() {
		return _subscriptionPaidBy;
	}

	@Override
	public void setSubscriptionPaidBy(String subscriptionPaidBy) {
		_subscriptionPaidBy = subscriptionPaidBy;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriptionPaidBy",
						String.class);

				method.invoke(_empMembershipRemoteModel, subscriptionPaidBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubscriptionAmt() {
		return _subscriptionAmt;
	}

	@Override
	public void setSubscriptionAmt(long subscriptionAmt) {
		_subscriptionAmt = subscriptionAmt;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriptionAmt", long.class);

				method.invoke(_empMembershipRemoteModel, subscriptionAmt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_empMembershipRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCommenceDate() {
		return _commenceDate;
	}

	@Override
	public void setCommenceDate(Date commenceDate) {
		_commenceDate = commenceDate;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCommenceDate", Date.class);

				method.invoke(_empMembershipRemoteModel, commenceDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRenewalDate() {
		return _renewalDate;
	}

	@Override
	public void setRenewalDate(Date renewalDate) {
		_renewalDate = renewalDate;

		if (_empMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _empMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewalDate", Date.class);

				method.invoke(_empMembershipRemoteModel, renewalDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpMembershipRemoteModel() {
		return _empMembershipRemoteModel;
	}

	public void setEmpMembershipRemoteModel(
		BaseModel<?> empMembershipRemoteModel) {
		_empMembershipRemoteModel = empMembershipRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _empMembershipRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_empMembershipRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpMembershipLocalServiceUtil.addEmpMembership(this);
		}
		else {
			EmpMembershipLocalServiceUtil.updateEmpMembership(this);
		}
	}

	@Override
	public EmpMembership toEscapedModel() {
		return (EmpMembership)ProxyUtil.newProxyInstance(EmpMembership.class.getClassLoader(),
			new Class[] { EmpMembership.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpMembershipClp clone = new EmpMembershipClp();

		clone.setEmpMembershipId(getEmpMembershipId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setMembershipId(getMembershipId());
		clone.setSubscriptionPaidBy(getSubscriptionPaidBy());
		clone.setSubscriptionAmt(getSubscriptionAmt());
		clone.setCurrency(getCurrency());
		clone.setCommenceDate(getCommenceDate());
		clone.setRenewalDate(getRenewalDate());

		return clone;
	}

	@Override
	public int compareTo(EmpMembership empMembership) {
		long primaryKey = empMembership.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpMembershipClp)) {
			return false;
		}

		EmpMembershipClp empMembership = (EmpMembershipClp)obj;

		long primaryKey = empMembership.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empMembershipId=");
		sb.append(getEmpMembershipId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", membershipId=");
		sb.append(getMembershipId());
		sb.append(", subscriptionPaidBy=");
		sb.append(getSubscriptionPaidBy());
		sb.append(", subscriptionAmt=");
		sb.append(getSubscriptionAmt());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", commenceDate=");
		sb.append(getCommenceDate());
		sb.append(", renewalDate=");
		sb.append(getRenewalDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpMembership");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empMembershipId</column-name><column-value><![CDATA[");
		sb.append(getEmpMembershipId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>membershipId</column-name><column-value><![CDATA[");
		sb.append(getMembershipId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriptionPaidBy</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionPaidBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriptionAmt</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionAmt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commenceDate</column-name><column-value><![CDATA[");
		sb.append(getCommenceDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalDate</column-name><column-value><![CDATA[");
		sb.append(getRenewalDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empMembershipId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _membershipId;
	private String _subscriptionPaidBy;
	private long _subscriptionAmt;
	private String _currency;
	private Date _commenceDate;
	private Date _renewalDate;
	private BaseModel<?> _empMembershipRemoteModel;
}