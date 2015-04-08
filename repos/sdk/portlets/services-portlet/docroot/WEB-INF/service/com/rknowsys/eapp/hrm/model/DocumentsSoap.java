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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class DocumentsSoap implements Serializable {
	public static DocumentsSoap toSoapModel(Documents model) {
		DocumentsSoap soapModel = new DocumentsSoap();

		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setTopic(model.getTopic());
		soapModel.setCategory(model.getCategory());
		soapModel.setDescription(model.getDescription());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setAdmin(model.getAdmin());
		soapModel.setSupervisor(model.getSupervisor());
		soapModel.setAllEmployees(model.getAllEmployees());
		soapModel.setPublishedTo(model.getPublishedTo());

		return soapModel;
	}

	public static DocumentsSoap[] toSoapModels(Documents[] models) {
		DocumentsSoap[] soapModels = new DocumentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentsSoap[][] toSoapModels(Documents[][] models) {
		DocumentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentsSoap[] toSoapModels(List<Documents> models) {
		List<DocumentsSoap> soapModels = new ArrayList<DocumentsSoap>(models.size());

		for (Documents model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentsSoap[soapModels.size()]);
	}

	public DocumentsSoap() {
	}

	public long getPrimaryKey() {
		return _documentId;
	}

	public void setPrimaryKey(long pk) {
		setDocumentId(pk);
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getTopic() {
		return _topic;
	}

	public void setTopic(String topic) {
		_topic = topic;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public boolean getAdmin() {
		return _admin;
	}

	public boolean isAdmin() {
		return _admin;
	}

	public void setAdmin(boolean admin) {
		_admin = admin;
	}

	public boolean getSupervisor() {
		return _supervisor;
	}

	public boolean isSupervisor() {
		return _supervisor;
	}

	public void setSupervisor(boolean supervisor) {
		_supervisor = supervisor;
	}

	public boolean getAllEmployees() {
		return _allEmployees;
	}

	public boolean isAllEmployees() {
		return _allEmployees;
	}

	public void setAllEmployees(boolean allEmployees) {
		_allEmployees = allEmployees;
	}

	public String getPublishedTo() {
		return _publishedTo;
	}

	public void setPublishedTo(String publishedTo) {
		_publishedTo = publishedTo;
	}

	private long _documentId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _topic;
	private String _category;
	private String _description;
	private Date _publishDate;
	private boolean _status;
	private boolean _admin;
	private boolean _supervisor;
	private boolean _allEmployees;
	private String _publishedTo;
}