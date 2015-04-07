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
import com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class NewsAttachmentsClp extends BaseModelImpl<NewsAttachments>
	implements NewsAttachments {
	public NewsAttachmentsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NewsAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return NewsAttachments.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _newsAttachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsAttachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsAttachmentId", getNewsAttachmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("attachmentTypeId", getAttachmentTypeId());
		attributes.put("newsId", getNewsId());
		attributes.put("description", getDescription());
		attributes.put("uuid", getUuid());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileType", getFileType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsAttachmentId = (Long)attributes.get("newsAttachmentId");

		if (newsAttachmentId != null) {
			setNewsAttachmentId(newsAttachmentId);
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

		Long attachmentTypeId = (Long)attributes.get("attachmentTypeId");

		if (attachmentTypeId != null) {
			setAttachmentTypeId(attachmentTypeId);
		}

		Long newsId = (Long)attributes.get("newsId");

		if (newsId != null) {
			setNewsId(newsId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileSize = (Long)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}
	}

	@Override
	public long getNewsAttachmentId() {
		return _newsAttachmentId;
	}

	@Override
	public void setNewsAttachmentId(long newsAttachmentId) {
		_newsAttachmentId = newsAttachmentId;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsAttachmentId",
						long.class);

				method.invoke(_newsAttachmentsRemoteModel, newsAttachmentId);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_newsAttachmentsRemoteModel, companyId);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_newsAttachmentsRemoteModel, groupId);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_newsAttachmentsRemoteModel, createDate);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_newsAttachmentsRemoteModel, modifiedDate);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_newsAttachmentsRemoteModel, userId);
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
	public long getAttachmentTypeId() {
		return _attachmentTypeId;
	}

	@Override
	public void setAttachmentTypeId(long attachmentTypeId) {
		_attachmentTypeId = attachmentTypeId;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentTypeId",
						long.class);

				method.invoke(_newsAttachmentsRemoteModel, attachmentTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNewsId() {
		return _newsId;
	}

	@Override
	public void setNewsId(long newsId) {
		_newsId = newsId;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsId", long.class);

				method.invoke(_newsAttachmentsRemoteModel, newsId);
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

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_newsAttachmentsRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_newsAttachmentsRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_newsAttachmentsRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(long fileSize) {
		_fileSize = fileSize;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", long.class);

				method.invoke(_newsAttachmentsRemoteModel, fileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileType() {
		return _fileType;
	}

	@Override
	public void setFileType(String fileType) {
		_fileType = fileType;

		if (_newsAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _newsAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setFileType", String.class);

				method.invoke(_newsAttachmentsRemoteModel, fileType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNewsAttachmentsRemoteModel() {
		return _newsAttachmentsRemoteModel;
	}

	public void setNewsAttachmentsRemoteModel(
		BaseModel<?> newsAttachmentsRemoteModel) {
		_newsAttachmentsRemoteModel = newsAttachmentsRemoteModel;
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

		Class<?> remoteModelClass = _newsAttachmentsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_newsAttachmentsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NewsAttachmentsLocalServiceUtil.addNewsAttachments(this);
		}
		else {
			NewsAttachmentsLocalServiceUtil.updateNewsAttachments(this);
		}
	}

	@Override
	public NewsAttachments toEscapedModel() {
		return (NewsAttachments)ProxyUtil.newProxyInstance(NewsAttachments.class.getClassLoader(),
			new Class[] { NewsAttachments.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NewsAttachmentsClp clone = new NewsAttachmentsClp();

		clone.setNewsAttachmentId(getNewsAttachmentId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setAttachmentTypeId(getAttachmentTypeId());
		clone.setNewsId(getNewsId());
		clone.setDescription(getDescription());
		clone.setUuid(getUuid());
		clone.setFileName(getFileName());
		clone.setFileSize(getFileSize());
		clone.setFileType(getFileType());

		return clone;
	}

	@Override
	public int compareTo(NewsAttachments newsAttachments) {
		long primaryKey = newsAttachments.getPrimaryKey();

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

		if (!(obj instanceof NewsAttachmentsClp)) {
			return false;
		}

		NewsAttachmentsClp newsAttachments = (NewsAttachmentsClp)obj;

		long primaryKey = newsAttachments.getPrimaryKey();

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

		sb.append("{newsAttachmentId=");
		sb.append(getNewsAttachmentId());
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
		sb.append(", attachmentTypeId=");
		sb.append(getAttachmentTypeId());
		sb.append(", newsId=");
		sb.append(getNewsId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", fileType=");
		sb.append(getFileType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.NewsAttachments");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newsAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getNewsAttachmentId());
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
			"<column><column-name>attachmentTypeId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsId</column-name><column-value><![CDATA[");
		sb.append(getNewsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileType</column-name><column-value><![CDATA[");
		sb.append(getFileType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _newsAttachmentId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _attachmentTypeId;
	private long _newsId;
	private String _description;
	private String _uuid;
	private String _fileName;
	private long _fileSize;
	private String _fileType;
	private BaseModel<?> _newsAttachmentsRemoteModel;
}