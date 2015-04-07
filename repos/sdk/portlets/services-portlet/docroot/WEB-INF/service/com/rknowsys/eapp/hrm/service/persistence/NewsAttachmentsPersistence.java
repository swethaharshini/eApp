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

package com.rknowsys.eapp.hrm.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rknowsys.eapp.hrm.model.NewsAttachments;

/**
 * The persistence interface for the news attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NewsAttachmentsPersistenceImpl
 * @see NewsAttachmentsUtil
 * @generated
 */
public interface NewsAttachmentsPersistence extends BasePersistence<NewsAttachments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsAttachmentsUtil} to access the news attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the news attachments in the entity cache if it is enabled.
	*
	* @param newsAttachments the news attachments
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments);

	/**
	* Caches the news attachmentses in the entity cache if it is enabled.
	*
	* @param newsAttachmentses the news attachmentses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> newsAttachmentses);

	/**
	* Creates a new news attachments with the primary key. Does not add the news attachments to the database.
	*
	* @param newsAttachmentId the primary key for the new news attachments
	* @return the new news attachments
	*/
	public com.rknowsys.eapp.hrm.model.NewsAttachments create(
		long newsAttachmentId);

	/**
	* Removes the news attachments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.NewsAttachments remove(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException;

	public com.rknowsys.eapp.hrm.model.NewsAttachments updateImpl(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the news attachments with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException} if it could not be found.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments
	* @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.NewsAttachments findByPrimaryKey(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException;

	/**
	* Returns the news attachments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments, or <code>null</code> if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.NewsAttachments fetchByPrimaryKey(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the news attachmentses.
	*
	* @return the news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the news attachmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news attachmentses
	* @param end the upper bound of the range of news attachmentses (not inclusive)
	* @return the range of news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the news attachmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news attachmentses
	* @param end the upper bound of the range of news attachmentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the news attachmentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of news attachmentses.
	*
	* @return the number of news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}