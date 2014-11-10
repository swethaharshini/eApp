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

import com.rknowsys.eapp.hrm.model.EmpAttachment;
import com.rknowsys.eapp.hrm.model.EmpAttachmentFileBlobModel;
import com.rknowsys.eapp.hrm.model.EmpAttachmentModel;
import com.rknowsys.eapp.hrm.service.EmpAttachmentLocalServiceUtil;

import java.io.Serializable;

import java.sql.Blob;
import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EmpAttachment service. Represents a row in the &quot;emp_attachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.EmpAttachmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmpAttachmentImpl}.
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachmentImpl
 * @see com.rknowsys.eapp.hrm.model.EmpAttachment
 * @see com.rknowsys.eapp.hrm.model.EmpAttachmentModel
 * @generated
 */
public class EmpAttachmentModelImpl extends BaseModelImpl<EmpAttachment>
	implements EmpAttachmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a EmpAttachment model instance should use the {@link com.rknowsys.eapp.hrm.model.EmpAttachment} interface instead.
	 */
	public static final String TABLE_NAME = "emp_attachment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "empAttachmentId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "attachmentTypeId", Types.BIGINT },
			{ "fileName", Types.VARCHAR },
			{ "fileSize", Types.BIGINT },
			{ "fileType", Types.VARCHAR },
			{ "file", Types.BLOB },
			{ "comment_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table emp_attachment (empAttachmentId LONG not null primary key,employeeId LONG,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,attachmentTypeId LONG,fileName VARCHAR(75) null,fileSize LONG,fileType VARCHAR(75) null,file BLOB,comment_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table emp_attachment";
	public static final String ORDER_BY_JPQL = " ORDER BY empAttachment.empAttachmentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY emp_attachment.empAttachmentId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.EmpAttachment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.EmpAttachment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.EmpAttachment"),
			true);
	public static long EMPATTACHMENTID_COLUMN_BITMASK = 1L;
	public static long EMPLOYEEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.EmpAttachment"));

	public EmpAttachmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _empAttachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empAttachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmpAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return EmpAttachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empAttachmentId", getEmpAttachmentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("attachmentTypeId", getAttachmentTypeId());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("fileType", getFileType());
		attributes.put("file", getFile());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empAttachmentId = (Long)attributes.get("empAttachmentId");

		if (empAttachmentId != null) {
			setEmpAttachmentId(empAttachmentId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long attachmentTypeId = (Long)attributes.get("attachmentTypeId");

		if (attachmentTypeId != null) {
			setAttachmentTypeId(attachmentTypeId);
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

		Blob file = (Blob)attributes.get("file");

		if (file != null) {
			setFile(file);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	@Override
	public long getEmpAttachmentId() {
		return _empAttachmentId;
	}

	@Override
	public void setEmpAttachmentId(long empAttachmentId) {
		_columnBitmask |= EMPATTACHMENTID_COLUMN_BITMASK;

		if (!_setOriginalEmpAttachmentId) {
			_setOriginalEmpAttachmentId = true;

			_originalEmpAttachmentId = _empAttachmentId;
		}

		_empAttachmentId = empAttachmentId;
	}

	public long getOriginalEmpAttachmentId() {
		return _originalEmpAttachmentId;
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	public long getAttachmentTypeId() {
		return _attachmentTypeId;
	}

	@Override
	public void setAttachmentTypeId(long attachmentTypeId) {
		_attachmentTypeId = attachmentTypeId;
	}

	@Override
	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	@Override
	public long getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(long fileSize) {
		_fileSize = fileSize;
	}

	@Override
	public String getFileType() {
		if (_fileType == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileType;
		}
	}

	@Override
	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	@Override
	public Blob getFile() {
		if (_fileBlobModel == null) {
			try {
				_fileBlobModel = EmpAttachmentLocalServiceUtil.getFileBlobModel(getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_fileBlobModel != null) {
			blob = _fileBlobModel.getFileBlob();
		}

		return blob;
	}

	@Override
	public void setFile(Blob file) {
		if (_fileBlobModel == null) {
			_fileBlobModel = new EmpAttachmentFileBlobModel(getPrimaryKey(),
					file);
		}
		else {
			_fileBlobModel.setFileBlob(file);
		}
	}

	@Override
	public String getComment() {
		if (_comment == null) {
			return StringPool.BLANK;
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EmpAttachment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmpAttachment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EmpAttachment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmpAttachmentImpl empAttachmentImpl = new EmpAttachmentImpl();

		empAttachmentImpl.setEmpAttachmentId(getEmpAttachmentId());
		empAttachmentImpl.setEmployeeId(getEmployeeId());
		empAttachmentImpl.setGroupId(getGroupId());
		empAttachmentImpl.setCompanyId(getCompanyId());
		empAttachmentImpl.setUserId(getUserId());
		empAttachmentImpl.setCreateDate(getCreateDate());
		empAttachmentImpl.setModifiedDate(getModifiedDate());
		empAttachmentImpl.setAttachmentTypeId(getAttachmentTypeId());
		empAttachmentImpl.setFileName(getFileName());
		empAttachmentImpl.setFileSize(getFileSize());
		empAttachmentImpl.setFileType(getFileType());
		empAttachmentImpl.setComment(getComment());

		empAttachmentImpl.resetOriginalValues();

		return empAttachmentImpl;
	}

	@Override
	public int compareTo(EmpAttachment empAttachment) {
		long primaryKey = empAttachment.getPrimaryKey();

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

		if (!(obj instanceof EmpAttachment)) {
			return false;
		}

		EmpAttachment empAttachment = (EmpAttachment)obj;

		long primaryKey = empAttachment.getPrimaryKey();

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
		EmpAttachmentModelImpl empAttachmentModelImpl = this;

		empAttachmentModelImpl._originalEmpAttachmentId = empAttachmentModelImpl._empAttachmentId;

		empAttachmentModelImpl._setOriginalEmpAttachmentId = false;

		empAttachmentModelImpl._originalEmployeeId = empAttachmentModelImpl._employeeId;

		empAttachmentModelImpl._setOriginalEmployeeId = false;

		empAttachmentModelImpl._fileBlobModel = null;

		empAttachmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EmpAttachment> toCacheModel() {
		EmpAttachmentCacheModel empAttachmentCacheModel = new EmpAttachmentCacheModel();

		empAttachmentCacheModel.empAttachmentId = getEmpAttachmentId();

		empAttachmentCacheModel.employeeId = getEmployeeId();

		empAttachmentCacheModel.groupId = getGroupId();

		empAttachmentCacheModel.companyId = getCompanyId();

		empAttachmentCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			empAttachmentCacheModel.createDate = createDate.getTime();
		}
		else {
			empAttachmentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			empAttachmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			empAttachmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		empAttachmentCacheModel.attachmentTypeId = getAttachmentTypeId();

		empAttachmentCacheModel.fileName = getFileName();

		String fileName = empAttachmentCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			empAttachmentCacheModel.fileName = null;
		}

		empAttachmentCacheModel.fileSize = getFileSize();

		empAttachmentCacheModel.fileType = getFileType();

		String fileType = empAttachmentCacheModel.fileType;

		if ((fileType != null) && (fileType.length() == 0)) {
			empAttachmentCacheModel.fileType = null;
		}

		empAttachmentCacheModel.comment = getComment();

		String comment = empAttachmentCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			empAttachmentCacheModel.comment = null;
		}

		return empAttachmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empAttachmentId=");
		sb.append(getEmpAttachmentId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", attachmentTypeId=");
		sb.append(getAttachmentTypeId());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", fileType=");
		sb.append(getFileType());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getEmpAttachmentId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>attachmentTypeId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentTypeId());
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
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EmpAttachment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EmpAttachment.class
		};
	private long _empAttachmentId;
	private long _originalEmpAttachmentId;
	private boolean _setOriginalEmpAttachmentId;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _attachmentTypeId;
	private String _fileName;
	private long _fileSize;
	private String _fileType;
	private EmpAttachmentFileBlobModel _fileBlobModel;
	private String _comment;
	private long _columnBitmask;
	private EmpAttachment _escapedModel;
}