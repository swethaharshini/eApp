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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Interview service. Represents a row in the &quot;interview&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.InterviewImpl}.
 * </p>
 *
 * @author rknowsys
 * @see Interview
 * @see com.rknowsys.eapp.hrm.model.impl.InterviewImpl
 * @see com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl
 * @generated
 */
public interface InterviewModel extends BaseModel<Interview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interview model instance should use the {@link Interview} interface instead.
	 */

	/**
	 * Returns the primary key of this interview.
	 *
	 * @return the primary key of this interview
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interview.
	 *
	 * @param primaryKey the primary key of this interview
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the interview ID of this interview.
	 *
	 * @return the interview ID of this interview
	 */
	public long getInterviewId();

	/**
	 * Sets the interview ID of this interview.
	 *
	 * @param interviewId the interview ID of this interview
	 */
	public void setInterviewId(long interviewId);

	/**
	 * Returns the company ID of this interview.
	 *
	 * @return the company ID of this interview
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this interview.
	 *
	 * @param companyId the company ID of this interview
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this interview.
	 *
	 * @return the group ID of this interview
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this interview.
	 *
	 * @param groupId the group ID of this interview
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this interview.
	 *
	 * @return the create date of this interview
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this interview.
	 *
	 * @param createDate the create date of this interview
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this interview.
	 *
	 * @return the modified date of this interview
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this interview.
	 *
	 * @param modifiedDate the modified date of this interview
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this interview.
	 *
	 * @return the user ID of this interview
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this interview.
	 *
	 * @param userId the user ID of this interview
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this interview.
	 *
	 * @return the user uuid of this interview
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this interview.
	 *
	 * @param userUuid the user uuid of this interview
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the name of this interview.
	 *
	 * @return the name of this interview
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this interview.
	 *
	 * @param name the name of this interview
	 */
	public void setName(String name);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Interview interview);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Interview> toCacheModel();

	@Override
	public Interview toEscapedModel();

	@Override
	public Interview toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}