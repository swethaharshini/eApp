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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rknowsys.eapp.hrm.model.NewsAttachments;

import java.util.List;

/**
 * The persistence utility for the news attachments service. This utility wraps {@link NewsAttachmentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NewsAttachmentsPersistence
 * @see NewsAttachmentsPersistenceImpl
 * @generated
 */
public class NewsAttachmentsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NewsAttachments newsAttachments) {
		getPersistence().clearCache(newsAttachments);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NewsAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewsAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewsAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NewsAttachments update(NewsAttachments newsAttachments)
		throws SystemException {
		return getPersistence().update(newsAttachments);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NewsAttachments update(NewsAttachments newsAttachments,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(newsAttachments, serviceContext);
	}

	/**
	* Caches the news attachments in the entity cache if it is enabled.
	*
	* @param newsAttachments the news attachments
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments) {
		getPersistence().cacheResult(newsAttachments);
	}

	/**
	* Caches the news attachmentses in the entity cache if it is enabled.
	*
	* @param newsAttachmentses the news attachmentses
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> newsAttachmentses) {
		getPersistence().cacheResult(newsAttachmentses);
	}

	/**
	* Creates a new news attachments with the primary key. Does not add the news attachments to the database.
	*
	* @param newsAttachmentId the primary key for the new news attachments
	* @return the new news attachments
	*/
	public static com.rknowsys.eapp.hrm.model.NewsAttachments create(
		long newsAttachmentId) {
		return getPersistence().create(newsAttachmentId);
	}

	/**
	* Removes the news attachments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.NewsAttachments remove(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException {
		return getPersistence().remove(newsAttachmentId);
	}

	public static com.rknowsys.eapp.hrm.model.NewsAttachments updateImpl(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(newsAttachments);
	}

	/**
	* Returns the news attachments with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException} if it could not be found.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments
	* @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.NewsAttachments findByPrimaryKey(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException {
		return getPersistence().findByPrimaryKey(newsAttachmentId);
	}

	/**
	* Returns the news attachments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsAttachmentId the primary key of the news attachments
	* @return the news attachments, or <code>null</code> if a news attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.NewsAttachments fetchByPrimaryKey(
		long newsAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(newsAttachmentId);
	}

	/**
	* Returns all the news attachmentses.
	*
	* @return the news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.NewsAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the news attachmentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of news attachmentses.
	*
	* @return the number of news attachmentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NewsAttachmentsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NewsAttachmentsPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					NewsAttachmentsPersistence.class.getName());

			ReferenceRegistry.registerReference(NewsAttachmentsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NewsAttachmentsPersistence persistence) {
	}

	private static NewsAttachmentsPersistence _persistence;
}