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
import com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpDirectDepositClp extends BaseModelImpl<EmpDirectDeposit>
	implements EmpDirectDeposit {
	public EmpDirectDepositClp() {
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
	public long getPrimaryKey() {
		return _empDirectDepositId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpDirectDepositId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empDirectDepositId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmpDirectDepositId() {
		return _empDirectDepositId;
	}

	@Override
	public void setEmpDirectDepositId(long empDirectDepositId) {
		_empDirectDepositId = empDirectDepositId;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpDirectDepositId",
						long.class);

				method.invoke(_empDirectDepositRemoteModel, empDirectDepositId);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empDirectDepositRemoteModel, employeeId);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empDirectDepositRemoteModel, groupId);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empDirectDepositRemoteModel, companyId);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empDirectDepositRemoteModel, createDate);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empDirectDepositRemoteModel, modifiedDate);
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

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empDirectDepositRemoteModel, userId);
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
	public long getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(long amount) {
		_amount = amount;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", long.class);

				method.invoke(_empDirectDepositRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccountNumber() {
		return _accountNumber;
	}

	@Override
	public void setAccountNumber(long accountNumber) {
		_accountNumber = accountNumber;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountNumber", long.class);

				method.invoke(_empDirectDepositRemoteModel, accountNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankName() {
		return _bankName;
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setBankName", String.class);

				method.invoke(_empDirectDepositRemoteModel, bankName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccountType() {
		return _accountType;
	}

	@Override
	public void setAccountType(String accountType) {
		_accountType = accountType;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountType", String.class);

				method.invoke(_empDirectDepositRemoteModel, accountType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBranchLocation() {
		return _branchLocation;
	}

	@Override
	public void setBranchLocation(String branchLocation) {
		_branchLocation = branchLocation;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setBranchLocation",
						String.class);

				method.invoke(_empDirectDepositRemoteModel, branchLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRoutingNumber() {
		return _routingNumber;
	}

	@Override
	public void setRoutingNumber(String routingNumber) {
		_routingNumber = routingNumber;

		if (_empDirectDepositRemoteModel != null) {
			try {
				Class<?> clazz = _empDirectDepositRemoteModel.getClass();

				Method method = clazz.getMethod("setRoutingNumber", String.class);

				method.invoke(_empDirectDepositRemoteModel, routingNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpDirectDepositRemoteModel() {
		return _empDirectDepositRemoteModel;
	}

	public void setEmpDirectDepositRemoteModel(
		BaseModel<?> empDirectDepositRemoteModel) {
		_empDirectDepositRemoteModel = empDirectDepositRemoteModel;
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

		Class<?> remoteModelClass = _empDirectDepositRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empDirectDepositRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpDirectDepositLocalServiceUtil.addEmpDirectDeposit(this);
		}
		else {
			EmpDirectDepositLocalServiceUtil.updateEmpDirectDeposit(this);
		}
	}

	@Override
	public EmpDirectDeposit toEscapedModel() {
		return (EmpDirectDeposit)ProxyUtil.newProxyInstance(EmpDirectDeposit.class.getClassLoader(),
			new Class[] { EmpDirectDeposit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpDirectDepositClp clone = new EmpDirectDepositClp();

		clone.setEmpDirectDepositId(getEmpDirectDepositId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setAmount(getAmount());
		clone.setAccountNumber(getAccountNumber());
		clone.setBankName(getBankName());
		clone.setAccountType(getAccountType());
		clone.setBranchLocation(getBranchLocation());
		clone.setRoutingNumber(getRoutingNumber());

		return clone;
	}

	@Override
	public int compareTo(EmpDirectDeposit empDirectDeposit) {
		long primaryKey = empDirectDeposit.getPrimaryKey();

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

		if (!(obj instanceof EmpDirectDepositClp)) {
			return false;
		}

		EmpDirectDepositClp empDirectDeposit = (EmpDirectDepositClp)obj;

		long primaryKey = empDirectDeposit.getPrimaryKey();

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

		sb.append("{empDirectDepositId=");
		sb.append(getEmpDirectDepositId());
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
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", accountNumber=");
		sb.append(getAccountNumber());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", accountType=");
		sb.append(getAccountType());
		sb.append(", branchLocation=");
		sb.append(getBranchLocation());
		sb.append(", routingNumber=");
		sb.append(getRoutingNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpDirectDeposit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empDirectDepositId</column-name><column-value><![CDATA[");
		sb.append(getEmpDirectDepositId());
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
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountNumber</column-name><column-value><![CDATA[");
		sb.append(getAccountNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountType</column-name><column-value><![CDATA[");
		sb.append(getAccountType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>branchLocation</column-name><column-value><![CDATA[");
		sb.append(getBranchLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>routingNumber</column-name><column-value><![CDATA[");
		sb.append(getRoutingNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empDirectDepositId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _amount;
	private long _accountNumber;
	private String _bankName;
	private String _accountType;
	private String _branchLocation;
	private String _routingNumber;
	private BaseModel<?> _empDirectDepositRemoteModel;
}