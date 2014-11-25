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
 * This class is a wrapper for {@link ReportingMethods}.
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethods
 * @generated
 */
public class ReportingMethodsWrapper implements ReportingMethods,
	ModelWrapper<ReportingMethods> {
	public ReportingMethodsWrapper(ReportingMethods reportingMethods) {
		_reportingMethods = reportingMethods;
	}

	@Override
	public Class<?> getModelClass() {
		return ReportingMethods.class;
	}

	@Override
	public String getModelClassName() {
		return ReportingMethods.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportingmethodId", getReportingmethodId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("reportingmethodName", getReportingmethodName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportingmethodId = (Long)attributes.get("reportingmethodId");

		if (reportingmethodId != null) {
			setReportingmethodId(reportingmethodId);
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

		String reportingmethodName = (String)attributes.get(
				"reportingmethodName");

		if (reportingmethodName != null) {
			setReportingmethodName(reportingmethodName);
		}
	}

	/**
	* Returns the primary key of this reporting methods.
	*
	* @return the primary key of this reporting methods
	*/
	@Override
	public long getPrimaryKey() {
		return _reportingMethods.getPrimaryKey();
	}

	/**
	* Sets the primary key of this reporting methods.
	*
	* @param primaryKey the primary key of this reporting methods
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_reportingMethods.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the reportingmethod ID of this reporting methods.
	*
	* @return the reportingmethod ID of this reporting methods
	*/
	@Override
	public long getReportingmethodId() {
		return _reportingMethods.getReportingmethodId();
	}

	/**
	* Sets the reportingmethod ID of this reporting methods.
	*
	* @param reportingmethodId the reportingmethod ID of this reporting methods
	*/
	@Override
	public void setReportingmethodId(long reportingmethodId) {
		_reportingMethods.setReportingmethodId(reportingmethodId);
	}

	/**
	* Returns the company ID of this reporting methods.
	*
	* @return the company ID of this reporting methods
	*/
	@Override
	public long getCompanyId() {
		return _reportingMethods.getCompanyId();
	}

	/**
	* Sets the company ID of this reporting methods.
	*
	* @param companyId the company ID of this reporting methods
	*/
	@Override
	public void setCompanyId(long companyId) {
		_reportingMethods.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this reporting methods.
	*
	* @return the group ID of this reporting methods
	*/
	@Override
	public long getGroupId() {
		return _reportingMethods.getGroupId();
	}

	/**
	* Sets the group ID of this reporting methods.
	*
	* @param groupId the group ID of this reporting methods
	*/
	@Override
	public void setGroupId(long groupId) {
		_reportingMethods.setGroupId(groupId);
	}

	/**
	* Returns the create date of this reporting methods.
	*
	* @return the create date of this reporting methods
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _reportingMethods.getCreateDate();
	}

	/**
	* Sets the create date of this reporting methods.
	*
	* @param createDate the create date of this reporting methods
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_reportingMethods.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this reporting methods.
	*
	* @return the modified date of this reporting methods
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _reportingMethods.getModifiedDate();
	}

	/**
	* Sets the modified date of this reporting methods.
	*
	* @param modifiedDate the modified date of this reporting methods
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_reportingMethods.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this reporting methods.
	*
	* @return the user ID of this reporting methods
	*/
	@Override
	public long getUserId() {
		return _reportingMethods.getUserId();
	}

	/**
	* Sets the user ID of this reporting methods.
	*
	* @param userId the user ID of this reporting methods
	*/
	@Override
	public void setUserId(long userId) {
		_reportingMethods.setUserId(userId);
	}

	/**
	* Returns the user uuid of this reporting methods.
	*
	* @return the user uuid of this reporting methods
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportingMethods.getUserUuid();
	}

	/**
	* Sets the user uuid of this reporting methods.
	*
	* @param userUuid the user uuid of this reporting methods
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_reportingMethods.setUserUuid(userUuid);
	}

	/**
	* Returns the reportingmethod name of this reporting methods.
	*
	* @return the reportingmethod name of this reporting methods
	*/
	@Override
	public java.lang.String getReportingmethodName() {
		return _reportingMethods.getReportingmethodName();
	}

	/**
	* Sets the reportingmethod name of this reporting methods.
	*
	* @param reportingmethodName the reportingmethod name of this reporting methods
	*/
	@Override
	public void setReportingmethodName(java.lang.String reportingmethodName) {
		_reportingMethods.setReportingmethodName(reportingmethodName);
	}

	@Override
	public boolean isNew() {
		return _reportingMethods.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_reportingMethods.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _reportingMethods.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_reportingMethods.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _reportingMethods.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _reportingMethods.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reportingMethods.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reportingMethods.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_reportingMethods.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_reportingMethods.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reportingMethods.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportingMethodsWrapper((ReportingMethods)_reportingMethods.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods) {
		return _reportingMethods.compareTo(reportingMethods);
	}

	@Override
	public int hashCode() {
		return _reportingMethods.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.ReportingMethods> toCacheModel() {
		return _reportingMethods.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ReportingMethods toEscapedModel() {
		return new ReportingMethodsWrapper(_reportingMethods.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ReportingMethods toUnescapedModel() {
		return new ReportingMethodsWrapper(_reportingMethods.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportingMethods.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _reportingMethods.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportingMethods.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportingMethodsWrapper)) {
			return false;
		}

		ReportingMethodsWrapper reportingMethodsWrapper = (ReportingMethodsWrapper)obj;

		if (Validator.equals(_reportingMethods,
					reportingMethodsWrapper._reportingMethods)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ReportingMethods getWrappedReportingMethods() {
		return _reportingMethods;
	}

	@Override
	public ReportingMethods getWrappedModel() {
		return _reportingMethods;
	}

	@Override
	public void resetOriginalValues() {
		_reportingMethods.resetOriginalValues();
	}

	private ReportingMethods _reportingMethods;
}