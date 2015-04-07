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
import com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class NewsClp extends BaseModelImpl<News> implements News {
	public NewsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return News.class;
	}

	@Override
	public String getModelClassName() {
		return News.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _newsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsId", getNewsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("topic", getTopic());
		attributes.put("description", getDescription());
		attributes.put("publishDate", getPublishDate());
		attributes.put("status", getStatus());
		attributes.put("admin", getAdmin());
		attributes.put("supervisor", getSupervisor());
		attributes.put("allEmployees", getAllEmployees());
		attributes.put("publishedTo", getPublishedTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsId = (Long)attributes.get("newsId");

		if (newsId != null) {
			setNewsId(newsId);
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

		String topic = (String)attributes.get("topic");

		if (topic != null) {
			setTopic(topic);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean admin = (Boolean)attributes.get("admin");

		if (admin != null) {
			setAdmin(admin);
		}

		Boolean supervisor = (Boolean)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}

		Boolean allEmployees = (Boolean)attributes.get("allEmployees");

		if (allEmployees != null) {
			setAllEmployees(allEmployees);
		}

		String publishedTo = (String)attributes.get("publishedTo");

		if (publishedTo != null) {
			setPublishedTo(publishedTo);
		}
	}

	@Override
	public long getNewsId() {
		return _newsId;
	}

	@Override
	public void setNewsId(long newsId) {
		_newsId = newsId;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsId", long.class);

				method.invoke(_newsRemoteModel, newsId);
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

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_newsRemoteModel, companyId);
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

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_newsRemoteModel, groupId);
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

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_newsRemoteModel, createDate);
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

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_newsRemoteModel, modifiedDate);
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

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_newsRemoteModel, userId);
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
	public String getTopic() {
		return _topic;
	}

	@Override
	public void setTopic(String topic) {
		_topic = topic;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setTopic", String.class);

				method.invoke(_newsRemoteModel, topic);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_newsRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDate", Date.class);

				method.invoke(_newsRemoteModel, publishDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_newsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdmin() {
		return _admin;
	}

	@Override
	public boolean isAdmin() {
		return _admin;
	}

	@Override
	public void setAdmin(boolean admin) {
		_admin = admin;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setAdmin", boolean.class);

				method.invoke(_newsRemoteModel, admin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSupervisor() {
		return _supervisor;
	}

	@Override
	public boolean isSupervisor() {
		return _supervisor;
	}

	@Override
	public void setSupervisor(boolean supervisor) {
		_supervisor = supervisor;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisor", boolean.class);

				method.invoke(_newsRemoteModel, supervisor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllEmployees() {
		return _allEmployees;
	}

	@Override
	public boolean isAllEmployees() {
		return _allEmployees;
	}

	@Override
	public void setAllEmployees(boolean allEmployees) {
		_allEmployees = allEmployees;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setAllEmployees", boolean.class);

				method.invoke(_newsRemoteModel, allEmployees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishedTo() {
		return _publishedTo;
	}

	@Override
	public void setPublishedTo(String publishedTo) {
		_publishedTo = publishedTo;

		if (_newsRemoteModel != null) {
			try {
				Class<?> clazz = _newsRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishedTo", String.class);

				method.invoke(_newsRemoteModel, publishedTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNewsRemoteModel() {
		return _newsRemoteModel;
	}

	public void setNewsRemoteModel(BaseModel<?> newsRemoteModel) {
		_newsRemoteModel = newsRemoteModel;
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

		Class<?> remoteModelClass = _newsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_newsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NewsLocalServiceUtil.addNews(this);
		}
		else {
			NewsLocalServiceUtil.updateNews(this);
		}
	}

	@Override
	public News toEscapedModel() {
		return (News)ProxyUtil.newProxyInstance(News.class.getClassLoader(),
			new Class[] { News.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NewsClp clone = new NewsClp();

		clone.setNewsId(getNewsId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setTopic(getTopic());
		clone.setDescription(getDescription());
		clone.setPublishDate(getPublishDate());
		clone.setStatus(getStatus());
		clone.setAdmin(getAdmin());
		clone.setSupervisor(getSupervisor());
		clone.setAllEmployees(getAllEmployees());
		clone.setPublishedTo(getPublishedTo());

		return clone;
	}

	@Override
	public int compareTo(News news) {
		long primaryKey = news.getPrimaryKey();

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

		if (!(obj instanceof NewsClp)) {
			return false;
		}

		NewsClp news = (NewsClp)obj;

		long primaryKey = news.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{newsId=");
		sb.append(getNewsId());
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
		sb.append(", topic=");
		sb.append(getTopic());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", admin=");
		sb.append(getAdmin());
		sb.append(", supervisor=");
		sb.append(getSupervisor());
		sb.append(", allEmployees=");
		sb.append(getAllEmployees());
		sb.append(", publishedTo=");
		sb.append(getPublishedTo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.News");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newsId</column-name><column-value><![CDATA[");
		sb.append(getNewsId());
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
			"<column><column-name>topic</column-name><column-value><![CDATA[");
		sb.append(getTopic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>admin</column-name><column-value><![CDATA[");
		sb.append(getAdmin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisor</column-name><column-value><![CDATA[");
		sb.append(getSupervisor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allEmployees</column-name><column-value><![CDATA[");
		sb.append(getAllEmployees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishedTo</column-name><column-value><![CDATA[");
		sb.append(getPublishedTo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _newsId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _topic;
	private String _description;
	private Date _publishDate;
	private boolean _status;
	private boolean _admin;
	private boolean _supervisor;
	private boolean _allEmployees;
	private String _publishedTo;
	private BaseModel<?> _newsRemoteModel;
}