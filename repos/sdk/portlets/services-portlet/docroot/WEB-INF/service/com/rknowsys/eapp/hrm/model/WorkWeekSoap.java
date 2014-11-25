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
public class WorkWeekSoap implements Serializable {
	public static WorkWeekSoap toSoapModel(WorkWeek model) {
		WorkWeekSoap soapModel = new WorkWeekSoap();

		soapModel.setWorkWeekId(model.getWorkWeekId());
		soapModel.setNationalityId(model.getNationalityId());
		soapModel.setMondayWorkSchedule(model.getMondayWorkSchedule());
		soapModel.setTuesdayWorkSchedule(model.getTuesdayWorkSchedule());
		soapModel.setWednesdayWorkSchedule(model.getWednesdayWorkSchedule());
		soapModel.setThursdayWorkSchedule(model.getThursdayWorkSchedule());
		soapModel.setFridayWorkSchedule(model.getFridayWorkSchedule());
		soapModel.setSaturdayWorkSchedule(model.getSaturdayWorkSchedule());
		soapModel.setSundayWorkSchedule(model.getSundayWorkSchedule());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WorkWeekSoap[] toSoapModels(WorkWeek[] models) {
		WorkWeekSoap[] soapModels = new WorkWeekSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkWeekSoap[][] toSoapModels(WorkWeek[][] models) {
		WorkWeekSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkWeekSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkWeekSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkWeekSoap[] toSoapModels(List<WorkWeek> models) {
		List<WorkWeekSoap> soapModels = new ArrayList<WorkWeekSoap>(models.size());

		for (WorkWeek model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkWeekSoap[soapModels.size()]);
	}

	public WorkWeekSoap() {
	}

	public long getPrimaryKey() {
		return _workWeekId;
	}

	public void setPrimaryKey(long pk) {
		setWorkWeekId(pk);
	}

	public long getWorkWeekId() {
		return _workWeekId;
	}

	public void setWorkWeekId(long workWeekId) {
		_workWeekId = workWeekId;
	}

	public long getNationalityId() {
		return _nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	public int getMondayWorkSchedule() {
		return _mondayWorkSchedule;
	}

	public void setMondayWorkSchedule(int mondayWorkSchedule) {
		_mondayWorkSchedule = mondayWorkSchedule;
	}

	public int getTuesdayWorkSchedule() {
		return _tuesdayWorkSchedule;
	}

	public void setTuesdayWorkSchedule(int tuesdayWorkSchedule) {
		_tuesdayWorkSchedule = tuesdayWorkSchedule;
	}

	public int getWednesdayWorkSchedule() {
		return _wednesdayWorkSchedule;
	}

	public void setWednesdayWorkSchedule(int wednesdayWorkSchedule) {
		_wednesdayWorkSchedule = wednesdayWorkSchedule;
	}

	public int getThursdayWorkSchedule() {
		return _thursdayWorkSchedule;
	}

	public void setThursdayWorkSchedule(int thursdayWorkSchedule) {
		_thursdayWorkSchedule = thursdayWorkSchedule;
	}

	public int getFridayWorkSchedule() {
		return _fridayWorkSchedule;
	}

	public void setFridayWorkSchedule(int fridayWorkSchedule) {
		_fridayWorkSchedule = fridayWorkSchedule;
	}

	public int getSaturdayWorkSchedule() {
		return _saturdayWorkSchedule;
	}

	public void setSaturdayWorkSchedule(int saturdayWorkSchedule) {
		_saturdayWorkSchedule = saturdayWorkSchedule;
	}

	public int getSundayWorkSchedule() {
		return _sundayWorkSchedule;
	}

	public void setSundayWorkSchedule(int sundayWorkSchedule) {
		_sundayWorkSchedule = sundayWorkSchedule;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	private long _workWeekId;
	private long _nationalityId;
	private int _mondayWorkSchedule;
	private int _tuesdayWorkSchedule;
	private int _wednesdayWorkSchedule;
	private int _thursdayWorkSchedule;
	private int _fridayWorkSchedule;
	private int _saturdayWorkSchedule;
	private int _sundayWorkSchedule;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}