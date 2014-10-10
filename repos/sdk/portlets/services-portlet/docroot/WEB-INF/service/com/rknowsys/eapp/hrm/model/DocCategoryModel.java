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
 * The base model interface for the DocCategory service. Represents a row in the &quot;doc_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl}.
 * </p>
 *
 * @author rknowsys
 * @see DocCategory
 * @see com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl
 * @see com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl
 * @generated
 */
public interface DocCategoryModel extends BaseModel<DocCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a doc category model instance should use the {@link DocCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this doc category.
	 *
	 * @return the primary key of this doc category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this doc category.
	 *
	 * @param primaryKey the primary key of this doc category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the doc category ID of this doc category.
	 *
	 * @return the doc category ID of this doc category
	 */
	public long getDocCategoryId();

	/**
	 * Sets the doc category ID of this doc category.
	 *
	 * @param docCategoryId the doc category ID of this doc category
	 */
	public void setDocCategoryId(long docCategoryId);

	/**
	 * Returns the company ID of this doc category.
	 *
	 * @return the company ID of this doc category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this doc category.
	 *
	 * @param companyId the company ID of this doc category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this doc category.
	 *
	 * @return the group ID of this doc category
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this doc category.
	 *
	 * @param groupId the group ID of this doc category
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this doc category.
	 *
	 * @return the create date of this doc category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this doc category.
	 *
	 * @param createDate the create date of this doc category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this doc category.
	 *
	 * @return the modified date of this doc category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this doc category.
	 *
	 * @param modifiedDate the modified date of this doc category
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this doc category.
	 *
	 * @return the user ID of this doc category
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this doc category.
	 *
	 * @param userId the user ID of this doc category
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this doc category.
	 *
	 * @return the user uuid of this doc category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this doc category.
	 *
	 * @param userUuid the user uuid of this doc category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the doc name of this doc category.
	 *
	 * @return the doc name of this doc category
	 */
	@AutoEscape
	public String getDocName();

	/**
	 * Sets the doc name of this doc category.
	 *
	 * @param docName the doc name of this doc category
	 */
	public void setDocName(String docName);

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
	public int compareTo(DocCategory docCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DocCategory> toCacheModel();

	@Override
	public DocCategory toEscapedModel();

	@Override
	public DocCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}