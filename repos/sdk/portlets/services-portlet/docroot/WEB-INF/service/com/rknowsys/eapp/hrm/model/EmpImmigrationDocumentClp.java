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
import com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpImmigrationDocumentClp extends BaseModelImpl<EmpImmigrationDocument>
	implements EmpImmigrationDocument {
	public EmpImmigrationDocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpImmigrationDocument.class;
	}

	@Override
	public String getModelClassName() {
		return EmpImmigrationDocument.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empImmigrationDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpImmigrationDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empImmigrationDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empImmigrationDocumentId", getEmpImmigrationDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("docType", getDocType());
		attributes.put("docNumber", getDocNumber());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("eligibleStatus", getEligibleStatus());
		attributes.put("issuedBy", getIssuedBy());
		attributes.put("eligibleReviewDate", getEligibleReviewDate());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empImmigrationDocumentId = (Long)attributes.get(
				"empImmigrationDocumentId");

		if (empImmigrationDocumentId != null) {
			setEmpImmigrationDocumentId(empImmigrationDocumentId);
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

		String docType = (String)attributes.get("docType");

		if (docType != null) {
			setDocType(docType);
		}

		String docNumber = (String)attributes.get("docNumber");

		if (docNumber != null) {
			setDocNumber(docNumber);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		String eligibleStatus = (String)attributes.get("eligibleStatus");

		if (eligibleStatus != null) {
			setEligibleStatus(eligibleStatus);
		}

		String issuedBy = (String)attributes.get("issuedBy");

		if (issuedBy != null) {
			setIssuedBy(issuedBy);
		}

		Date eligibleReviewDate = (Date)attributes.get("eligibleReviewDate");

		if (eligibleReviewDate != null) {
			setEligibleReviewDate(eligibleReviewDate);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public long getEmpImmigrationDocumentId() {
		return _empImmigrationDocumentId;
	}

	@Override
	public void setEmpImmigrationDocumentId(long empImmigrationDocumentId) {
		_empImmigrationDocumentId = empImmigrationDocumentId;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpImmigrationDocumentId",
						long.class);

				method.invoke(_empImmigrationDocumentRemoteModel,
					empImmigrationDocumentId);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empImmigrationDocumentRemoteModel, employeeId);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empImmigrationDocumentRemoteModel, groupId);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empImmigrationDocumentRemoteModel, companyId);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empImmigrationDocumentRemoteModel, createDate);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empImmigrationDocumentRemoteModel, modifiedDate);
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

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empImmigrationDocumentRemoteModel, userId);
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
	public String getDocType() {
		return _docType;
	}

	@Override
	public void setDocType(String docType) {
		_docType = docType;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocType", String.class);

				method.invoke(_empImmigrationDocumentRemoteModel, docType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocNumber() {
		return _docNumber;
	}

	@Override
	public void setDocNumber(String docNumber) {
		_docNumber = docNumber;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocNumber", String.class);

				method.invoke(_empImmigrationDocumentRemoteModel, docNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIssuedDate() {
		return _issuedDate;
	}

	@Override
	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedDate", Date.class);

				method.invoke(_empImmigrationDocumentRemoteModel, issuedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDate", Date.class);

				method.invoke(_empImmigrationDocumentRemoteModel, expiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEligibleStatus() {
		return _eligibleStatus;
	}

	@Override
	public void setEligibleStatus(String eligibleStatus) {
		_eligibleStatus = eligibleStatus;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEligibleStatus",
						String.class);

				method.invoke(_empImmigrationDocumentRemoteModel, eligibleStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssuedBy() {
		return _issuedBy;
	}

	@Override
	public void setIssuedBy(String issuedBy) {
		_issuedBy = issuedBy;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedBy", String.class);

				method.invoke(_empImmigrationDocumentRemoteModel, issuedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEligibleReviewDate() {
		return _eligibleReviewDate;
	}

	@Override
	public void setEligibleReviewDate(Date eligibleReviewDate) {
		_eligibleReviewDate = eligibleReviewDate;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEligibleReviewDate",
						Date.class);

				method.invoke(_empImmigrationDocumentRemoteModel,
					eligibleReviewDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_empImmigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _empImmigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_empImmigrationDocumentRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpImmigrationDocumentRemoteModel() {
		return _empImmigrationDocumentRemoteModel;
	}

	public void setEmpImmigrationDocumentRemoteModel(
		BaseModel<?> empImmigrationDocumentRemoteModel) {
		_empImmigrationDocumentRemoteModel = empImmigrationDocumentRemoteModel;
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

		Class<?> remoteModelClass = _empImmigrationDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empImmigrationDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpImmigrationDocumentLocalServiceUtil.addEmpImmigrationDocument(this);
		}
		else {
			EmpImmigrationDocumentLocalServiceUtil.updateEmpImmigrationDocument(this);
		}
	}

	@Override
	public EmpImmigrationDocument toEscapedModel() {
		return (EmpImmigrationDocument)ProxyUtil.newProxyInstance(EmpImmigrationDocument.class.getClassLoader(),
			new Class[] { EmpImmigrationDocument.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpImmigrationDocumentClp clone = new EmpImmigrationDocumentClp();

		clone.setEmpImmigrationDocumentId(getEmpImmigrationDocumentId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setDocType(getDocType());
		clone.setDocNumber(getDocNumber());
		clone.setIssuedDate(getIssuedDate());
		clone.setExpiryDate(getExpiryDate());
		clone.setEligibleStatus(getEligibleStatus());
		clone.setIssuedBy(getIssuedBy());
		clone.setEligibleReviewDate(getEligibleReviewDate());
		clone.setComments(getComments());

		return clone;
	}

	@Override
	public int compareTo(EmpImmigrationDocument empImmigrationDocument) {
		long primaryKey = empImmigrationDocument.getPrimaryKey();

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

		if (!(obj instanceof EmpImmigrationDocumentClp)) {
			return false;
		}

		EmpImmigrationDocumentClp empImmigrationDocument = (EmpImmigrationDocumentClp)obj;

		long primaryKey = empImmigrationDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{empImmigrationDocumentId=");
		sb.append(getEmpImmigrationDocumentId());
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
		sb.append(", docType=");
		sb.append(getDocType());
		sb.append(", docNumber=");
		sb.append(getDocNumber());
		sb.append(", issuedDate=");
		sb.append(getIssuedDate());
		sb.append(", expiryDate=");
		sb.append(getExpiryDate());
		sb.append(", eligibleStatus=");
		sb.append(getEligibleStatus());
		sb.append(", issuedBy=");
		sb.append(getIssuedBy());
		sb.append(", eligibleReviewDate=");
		sb.append(getEligibleReviewDate());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpImmigrationDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empImmigrationDocumentId</column-name><column-value><![CDATA[");
		sb.append(getEmpImmigrationDocumentId());
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
			"<column><column-name>docType</column-name><column-value><![CDATA[");
		sb.append(getDocType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docNumber</column-name><column-value><![CDATA[");
		sb.append(getDocNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedDate</column-name><column-value><![CDATA[");
		sb.append(getIssuedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDate</column-name><column-value><![CDATA[");
		sb.append(getExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eligibleStatus</column-name><column-value><![CDATA[");
		sb.append(getEligibleStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedBy</column-name><column-value><![CDATA[");
		sb.append(getIssuedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eligibleReviewDate</column-name><column-value><![CDATA[");
		sb.append(getEligibleReviewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empImmigrationDocumentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _docType;
	private String _docNumber;
	private Date _issuedDate;
	private Date _expiryDate;
	private String _eligibleStatus;
	private String _issuedBy;
	private Date _eligibleReviewDate;
	private String _comments;
	private BaseModel<?> _empImmigrationDocumentRemoteModel;
}