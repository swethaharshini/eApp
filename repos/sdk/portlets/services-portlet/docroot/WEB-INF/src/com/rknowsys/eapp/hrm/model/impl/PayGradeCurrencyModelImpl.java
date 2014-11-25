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

import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.model.PayGradeCurrencyModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PayGradeCurrency service. Represents a row in the &quot;pay_grade_currency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.PayGradeCurrencyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PayGradeCurrencyImpl}.
 * </p>
 *
 * @author rknowsys
 * @see PayGradeCurrencyImpl
 * @see com.rknowsys.eapp.hrm.model.PayGradeCurrency
 * @see com.rknowsys.eapp.hrm.model.PayGradeCurrencyModel
 * @generated
 */
public class PayGradeCurrencyModelImpl extends BaseModelImpl<PayGradeCurrency>
	implements PayGradeCurrencyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pay grade currency model instance should use the {@link com.rknowsys.eapp.hrm.model.PayGradeCurrency} interface instead.
	 */
	public static final String TABLE_NAME = "pay_grade_currency";
	public static final Object[][] TABLE_COLUMNS = {
			{ "payGradeCurrencyId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "payGradeId", Types.BIGINT },
			{ "currency_", Types.VARCHAR },
			{ "minSalary", Types.BIGINT },
			{ "maxSalary", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table pay_grade_currency (payGradeCurrencyId LONG not null primary key,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,payGradeId LONG,currency_ VARCHAR(75) null,minSalary LONG,maxSalary LONG)";
	public static final String TABLE_SQL_DROP = "drop table pay_grade_currency";
	public static final String ORDER_BY_JPQL = " ORDER BY payGradeCurrency.payGradeCurrencyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pay_grade_currency.payGradeCurrencyId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.PayGradeCurrency"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.PayGradeCurrency"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.PayGradeCurrency"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long PAYGRADECURRENCYID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.PayGradeCurrency"));

	public PayGradeCurrencyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPayGradeCurrencyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PayGradeCurrency.class;
	}

	@Override
	public String getModelClassName() {
		return PayGradeCurrency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payGradeCurrencyId", getPayGradeCurrencyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("payGradeId", getPayGradeId());
		attributes.put("currency", getCurrency());
		attributes.put("minSalary", getMinSalary());
		attributes.put("maxSalary", getMaxSalary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payGradeCurrencyId = (Long)attributes.get("payGradeCurrencyId");

		if (payGradeCurrencyId != null) {
			setPayGradeCurrencyId(payGradeCurrencyId);
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

		Long payGradeId = (Long)attributes.get("payGradeId");

		if (payGradeId != null) {
			setPayGradeId(payGradeId);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Long minSalary = (Long)attributes.get("minSalary");

		if (minSalary != null) {
			setMinSalary(minSalary);
		}

		Long maxSalary = (Long)attributes.get("maxSalary");

		if (maxSalary != null) {
			setMaxSalary(maxSalary);
		}
	}

	@Override
	public long getPayGradeCurrencyId() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrencyId = payGradeCurrencyId;
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
	public long getPayGradeId() {
		return _payGradeId;
	}

	@Override
	public void setPayGradeId(long payGradeId) {
		_payGradeId = payGradeId;
	}

	@Override
	public String getCurrency() {
		if (_currency == null) {
			return StringPool.BLANK;
		}
		else {
			return _currency;
		}
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;
	}

	@Override
	public long getMinSalary() {
		return _minSalary;
	}

	@Override
	public void setMinSalary(long minSalary) {
		_minSalary = minSalary;
	}

	@Override
	public long getMaxSalary() {
		return _maxSalary;
	}

	@Override
	public void setMaxSalary(long maxSalary) {
		_maxSalary = maxSalary;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PayGradeCurrency.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PayGradeCurrency toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PayGradeCurrency)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PayGradeCurrencyImpl payGradeCurrencyImpl = new PayGradeCurrencyImpl();

		payGradeCurrencyImpl.setPayGradeCurrencyId(getPayGradeCurrencyId());
		payGradeCurrencyImpl.setCompanyId(getCompanyId());
		payGradeCurrencyImpl.setGroupId(getGroupId());
		payGradeCurrencyImpl.setCreateDate(getCreateDate());
		payGradeCurrencyImpl.setModifiedDate(getModifiedDate());
		payGradeCurrencyImpl.setUserId(getUserId());
		payGradeCurrencyImpl.setPayGradeId(getPayGradeId());
		payGradeCurrencyImpl.setCurrency(getCurrency());
		payGradeCurrencyImpl.setMinSalary(getMinSalary());
		payGradeCurrencyImpl.setMaxSalary(getMaxSalary());

		payGradeCurrencyImpl.resetOriginalValues();

		return payGradeCurrencyImpl;
	}

	@Override
	public int compareTo(PayGradeCurrency payGradeCurrency) {
		long primaryKey = payGradeCurrency.getPrimaryKey();

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

		if (!(obj instanceof PayGradeCurrency)) {
			return false;
		}

		PayGradeCurrency payGradeCurrency = (PayGradeCurrency)obj;

		long primaryKey = payGradeCurrency.getPrimaryKey();

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
		PayGradeCurrencyModelImpl payGradeCurrencyModelImpl = this;

		payGradeCurrencyModelImpl._originalGroupId = payGradeCurrencyModelImpl._groupId;

		payGradeCurrencyModelImpl._setOriginalGroupId = false;

		payGradeCurrencyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PayGradeCurrency> toCacheModel() {
		PayGradeCurrencyCacheModel payGradeCurrencyCacheModel = new PayGradeCurrencyCacheModel();

		payGradeCurrencyCacheModel.payGradeCurrencyId = getPayGradeCurrencyId();

		payGradeCurrencyCacheModel.companyId = getCompanyId();

		payGradeCurrencyCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			payGradeCurrencyCacheModel.createDate = createDate.getTime();
		}
		else {
			payGradeCurrencyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			payGradeCurrencyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			payGradeCurrencyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		payGradeCurrencyCacheModel.userId = getUserId();

		payGradeCurrencyCacheModel.payGradeId = getPayGradeId();

		payGradeCurrencyCacheModel.currency = getCurrency();

		String currency = payGradeCurrencyCacheModel.currency;

		if ((currency != null) && (currency.length() == 0)) {
			payGradeCurrencyCacheModel.currency = null;
		}

		payGradeCurrencyCacheModel.minSalary = getMinSalary();

		payGradeCurrencyCacheModel.maxSalary = getMaxSalary();

		return payGradeCurrencyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{payGradeCurrencyId=");
		sb.append(getPayGradeCurrencyId());
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
		sb.append(", payGradeId=");
		sb.append(getPayGradeId());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", minSalary=");
		sb.append(getMinSalary());
		sb.append(", maxSalary=");
		sb.append(getMaxSalary());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.PayGradeCurrency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>payGradeCurrencyId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeCurrencyId());
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
			"<column><column-name>payGradeId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minSalary</column-name><column-value><![CDATA[");
		sb.append(getMinSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxSalary</column-name><column-value><![CDATA[");
		sb.append(getMaxSalary());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PayGradeCurrency.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PayGradeCurrency.class
		};
	private long _payGradeCurrencyId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _payGradeId;
	private String _currency;
	private long _minSalary;
	private long _maxSalary;
	private long _columnBitmask;
	private PayGradeCurrency _escapedModel;
}