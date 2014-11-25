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
 * This class is a wrapper for {@link EmpImmigrationDocument}.
 * </p>
 *
 * @author rknowsys
 * @see EmpImmigrationDocument
 * @generated
 */
public class EmpImmigrationDocumentWrapper implements EmpImmigrationDocument,
	ModelWrapper<EmpImmigrationDocument> {
	public EmpImmigrationDocumentWrapper(
		EmpImmigrationDocument empImmigrationDocument) {
		_empImmigrationDocument = empImmigrationDocument;
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

	/**
	* Returns the primary key of this ImmigrationDocument.
	*
	* @return the primary key of this ImmigrationDocument
	*/
	@Override
	public long getPrimaryKey() {
		return _empImmigrationDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ImmigrationDocument.
	*
	* @param primaryKey the primary key of this ImmigrationDocument
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empImmigrationDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp immigration document ID of this ImmigrationDocument.
	*
	* @return the emp immigration document ID of this ImmigrationDocument
	*/
	@Override
	public long getEmpImmigrationDocumentId() {
		return _empImmigrationDocument.getEmpImmigrationDocumentId();
	}

	/**
	* Sets the emp immigration document ID of this ImmigrationDocument.
	*
	* @param empImmigrationDocumentId the emp immigration document ID of this ImmigrationDocument
	*/
	@Override
	public void setEmpImmigrationDocumentId(long empImmigrationDocumentId) {
		_empImmigrationDocument.setEmpImmigrationDocumentId(empImmigrationDocumentId);
	}

	/**
	* Returns the employee ID of this ImmigrationDocument.
	*
	* @return the employee ID of this ImmigrationDocument
	*/
	@Override
	public long getEmployeeId() {
		return _empImmigrationDocument.getEmployeeId();
	}

	/**
	* Sets the employee ID of this ImmigrationDocument.
	*
	* @param employeeId the employee ID of this ImmigrationDocument
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_empImmigrationDocument.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this ImmigrationDocument.
	*
	* @return the group ID of this ImmigrationDocument
	*/
	@Override
	public long getGroupId() {
		return _empImmigrationDocument.getGroupId();
	}

	/**
	* Sets the group ID of this ImmigrationDocument.
	*
	* @param groupId the group ID of this ImmigrationDocument
	*/
	@Override
	public void setGroupId(long groupId) {
		_empImmigrationDocument.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this ImmigrationDocument.
	*
	* @return the company ID of this ImmigrationDocument
	*/
	@Override
	public long getCompanyId() {
		return _empImmigrationDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this ImmigrationDocument.
	*
	* @param companyId the company ID of this ImmigrationDocument
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empImmigrationDocument.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this ImmigrationDocument.
	*
	* @return the create date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empImmigrationDocument.getCreateDate();
	}

	/**
	* Sets the create date of this ImmigrationDocument.
	*
	* @param createDate the create date of this ImmigrationDocument
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empImmigrationDocument.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this ImmigrationDocument.
	*
	* @return the modified date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empImmigrationDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this ImmigrationDocument.
	*
	* @param modifiedDate the modified date of this ImmigrationDocument
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empImmigrationDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this ImmigrationDocument.
	*
	* @return the user ID of this ImmigrationDocument
	*/
	@Override
	public long getUserId() {
		return _empImmigrationDocument.getUserId();
	}

	/**
	* Sets the user ID of this ImmigrationDocument.
	*
	* @param userId the user ID of this ImmigrationDocument
	*/
	@Override
	public void setUserId(long userId) {
		_empImmigrationDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ImmigrationDocument.
	*
	* @return the user uuid of this ImmigrationDocument
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this ImmigrationDocument.
	*
	* @param userUuid the user uuid of this ImmigrationDocument
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empImmigrationDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the doc type of this ImmigrationDocument.
	*
	* @return the doc type of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getDocType() {
		return _empImmigrationDocument.getDocType();
	}

	/**
	* Sets the doc type of this ImmigrationDocument.
	*
	* @param docType the doc type of this ImmigrationDocument
	*/
	@Override
	public void setDocType(java.lang.String docType) {
		_empImmigrationDocument.setDocType(docType);
	}

	/**
	* Returns the doc number of this ImmigrationDocument.
	*
	* @return the doc number of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getDocNumber() {
		return _empImmigrationDocument.getDocNumber();
	}

	/**
	* Sets the doc number of this ImmigrationDocument.
	*
	* @param docNumber the doc number of this ImmigrationDocument
	*/
	@Override
	public void setDocNumber(java.lang.String docNumber) {
		_empImmigrationDocument.setDocNumber(docNumber);
	}

	/**
	* Returns the issued date of this ImmigrationDocument.
	*
	* @return the issued date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _empImmigrationDocument.getIssuedDate();
	}

	/**
	* Sets the issued date of this ImmigrationDocument.
	*
	* @param issuedDate the issued date of this ImmigrationDocument
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_empImmigrationDocument.setIssuedDate(issuedDate);
	}

	/**
	* Returns the expiry date of this ImmigrationDocument.
	*
	* @return the expiry date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _empImmigrationDocument.getExpiryDate();
	}

	/**
	* Sets the expiry date of this ImmigrationDocument.
	*
	* @param expiryDate the expiry date of this ImmigrationDocument
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_empImmigrationDocument.setExpiryDate(expiryDate);
	}

	/**
	* Returns the eligible status of this ImmigrationDocument.
	*
	* @return the eligible status of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getEligibleStatus() {
		return _empImmigrationDocument.getEligibleStatus();
	}

	/**
	* Sets the eligible status of this ImmigrationDocument.
	*
	* @param eligibleStatus the eligible status of this ImmigrationDocument
	*/
	@Override
	public void setEligibleStatus(java.lang.String eligibleStatus) {
		_empImmigrationDocument.setEligibleStatus(eligibleStatus);
	}

	/**
	* Returns the issued by of this ImmigrationDocument.
	*
	* @return the issued by of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getIssuedBy() {
		return _empImmigrationDocument.getIssuedBy();
	}

	/**
	* Sets the issued by of this ImmigrationDocument.
	*
	* @param issuedBy the issued by of this ImmigrationDocument
	*/
	@Override
	public void setIssuedBy(java.lang.String issuedBy) {
		_empImmigrationDocument.setIssuedBy(issuedBy);
	}

	/**
	* Returns the eligible review date of this ImmigrationDocument.
	*
	* @return the eligible review date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getEligibleReviewDate() {
		return _empImmigrationDocument.getEligibleReviewDate();
	}

	/**
	* Sets the eligible review date of this ImmigrationDocument.
	*
	* @param eligibleReviewDate the eligible review date of this ImmigrationDocument
	*/
	@Override
	public void setEligibleReviewDate(java.util.Date eligibleReviewDate) {
		_empImmigrationDocument.setEligibleReviewDate(eligibleReviewDate);
	}

	/**
	* Returns the comments of this ImmigrationDocument.
	*
	* @return the comments of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getComments() {
		return _empImmigrationDocument.getComments();
	}

	/**
	* Sets the comments of this ImmigrationDocument.
	*
	* @param comments the comments of this ImmigrationDocument
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_empImmigrationDocument.setComments(comments);
	}

	@Override
	public boolean isNew() {
		return _empImmigrationDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empImmigrationDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empImmigrationDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empImmigrationDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empImmigrationDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empImmigrationDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empImmigrationDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empImmigrationDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empImmigrationDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empImmigrationDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empImmigrationDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpImmigrationDocumentWrapper((EmpImmigrationDocument)_empImmigrationDocument.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpImmigrationDocument empImmigrationDocument) {
		return _empImmigrationDocument.compareTo(empImmigrationDocument);
	}

	@Override
	public int hashCode() {
		return _empImmigrationDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmpImmigrationDocument> toCacheModel() {
		return _empImmigrationDocument.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument toEscapedModel() {
		return new EmpImmigrationDocumentWrapper(_empImmigrationDocument.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument toUnescapedModel() {
		return new EmpImmigrationDocumentWrapper(_empImmigrationDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empImmigrationDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empImmigrationDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empImmigrationDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpImmigrationDocumentWrapper)) {
			return false;
		}

		EmpImmigrationDocumentWrapper empImmigrationDocumentWrapper = (EmpImmigrationDocumentWrapper)obj;

		if (Validator.equals(_empImmigrationDocument,
					empImmigrationDocumentWrapper._empImmigrationDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpImmigrationDocument getWrappedEmpImmigrationDocument() {
		return _empImmigrationDocument;
	}

	@Override
	public EmpImmigrationDocument getWrappedModel() {
		return _empImmigrationDocument;
	}

	@Override
	public void resetOriginalValues() {
		_empImmigrationDocument.resetOriginalValues();
	}

	private EmpImmigrationDocument _empImmigrationDocument;
}