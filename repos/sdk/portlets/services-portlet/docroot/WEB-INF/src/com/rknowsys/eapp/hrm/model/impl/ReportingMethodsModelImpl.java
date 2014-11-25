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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rknowsys.eapp.hrm.model.ReportingMethods;
import com.rknowsys.eapp.hrm.model.ReportingMethodsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ReportingMethods service. Represents a row in the &quot;reportingmethods&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.ReportingMethodsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReportingMethodsImpl}.
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethodsImpl
 * @see com.rknowsys.eapp.hrm.model.ReportingMethods
 * @see com.rknowsys.eapp.hrm.model.ReportingMethodsModel
 * @generated
 */
public class ReportingMethodsModelImpl extends BaseModelImpl<ReportingMethods>
	implements ReportingMethodsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a reporting methods model instance should use the {@link com.rknowsys.eapp.hrm.model.ReportingMethods} interface instead.
	 */
	public static final String TABLE_NAME = "reportingmethods";
	public static final Object[][] TABLE_COLUMNS = {
			{ "reportingmethodId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "reportingmethodName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table reportingmethods (reportingmethodId LONG not null primary key,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,reportingmethodName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table reportingmethods";
	public static final String ORDER_BY_JPQL = " ORDER BY reportingMethods.reportingmethodId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY reportingmethods.reportingmethodId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.ReportingMethods"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.ReportingMethods"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.ReportingMethods"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long REPORTINGMETHODID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.ReportingMethods"));

	public ReportingMethodsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _reportingmethodId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportingmethodId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportingmethodId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getReportingmethodId() {
		return _reportingmethodId;
	}

	@Override
	public void setReportingmethodId(long reportingmethodId) {
		_columnBitmask |= REPORTINGMETHODID_COLUMN_BITMASK;

		if (!_setOriginalReportingmethodId) {
			_setOriginalReportingmethodId = true;

			_originalReportingmethodId = _reportingmethodId;
		}

		_reportingmethodId = reportingmethodId;
	}

	public long getOriginalReportingmethodId() {
		return _originalReportingmethodId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
	public String getReportingmethodName() {
		if (_reportingmethodName == null) {
			return StringPool.BLANK;
		}
		else {
			return _reportingmethodName;
		}
	}

	@Override
	public void setReportingmethodName(String reportingmethodName) {
		_reportingmethodName = reportingmethodName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ReportingMethods.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ReportingMethods toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ReportingMethods)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReportingMethodsImpl reportingMethodsImpl = new ReportingMethodsImpl();

		reportingMethodsImpl.setReportingmethodId(getReportingmethodId());
		reportingMethodsImpl.setCompanyId(getCompanyId());
		reportingMethodsImpl.setGroupId(getGroupId());
		reportingMethodsImpl.setCreateDate(getCreateDate());
		reportingMethodsImpl.setModifiedDate(getModifiedDate());
		reportingMethodsImpl.setUserId(getUserId());
		reportingMethodsImpl.setReportingmethodName(getReportingmethodName());

		reportingMethodsImpl.resetOriginalValues();

		return reportingMethodsImpl;
	}

	@Override
	public int compareTo(ReportingMethods reportingMethods) {
		long primaryKey = reportingMethods.getPrimaryKey();

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

		if (!(obj instanceof ReportingMethods)) {
			return false;
		}

		ReportingMethods reportingMethods = (ReportingMethods)obj;

		long primaryKey = reportingMethods.getPrimaryKey();

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
	public void resetOriginalValues() {
		ReportingMethodsModelImpl reportingMethodsModelImpl = this;

		reportingMethodsModelImpl._originalReportingmethodId = reportingMethodsModelImpl._reportingmethodId;

		reportingMethodsModelImpl._setOriginalReportingmethodId = false;

		reportingMethodsModelImpl._originalGroupId = reportingMethodsModelImpl._groupId;

		reportingMethodsModelImpl._setOriginalGroupId = false;

		reportingMethodsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ReportingMethods> toCacheModel() {
		ReportingMethodsCacheModel reportingMethodsCacheModel = new ReportingMethodsCacheModel();

		reportingMethodsCacheModel.reportingmethodId = getReportingmethodId();

		reportingMethodsCacheModel.companyId = getCompanyId();

		reportingMethodsCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			reportingMethodsCacheModel.createDate = createDate.getTime();
		}
		else {
			reportingMethodsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			reportingMethodsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			reportingMethodsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		reportingMethodsCacheModel.userId = getUserId();

		reportingMethodsCacheModel.reportingmethodName = getReportingmethodName();

		String reportingmethodName = reportingMethodsCacheModel.reportingmethodName;

		if ((reportingmethodName != null) &&
				(reportingmethodName.length() == 0)) {
			reportingMethodsCacheModel.reportingmethodName = null;
		}

		return reportingMethodsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{reportingmethodId=");
		sb.append(getReportingmethodId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", reportingmethodName=");
		sb.append(getReportingmethodName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.ReportingMethods");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportingmethodId</column-name><column-value><![CDATA[");
		sb.append(getReportingmethodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>reportingmethodName</column-name><column-value><![CDATA[");
		sb.append(getReportingmethodName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ReportingMethods.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ReportingMethods.class
		};
	private long _reportingmethodId;
	private long _originalReportingmethodId;
	private boolean _setOriginalReportingmethodId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _reportingmethodName;
	private long _columnBitmask;
	private ReportingMethods _escapedModel;
}