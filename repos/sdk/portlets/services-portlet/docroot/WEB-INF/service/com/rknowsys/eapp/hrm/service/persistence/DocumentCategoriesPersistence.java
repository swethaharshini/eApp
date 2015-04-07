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

import com.rknowsys.eapp.hrm.model.DocumentCategories;

/**
 * The persistence interface for the document categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DocumentCategoriesPersistenceImpl
 * @see DocumentCategoriesUtil
 * @generated
 */
public interface DocumentCategoriesPersistence extends BasePersistence<DocumentCategories> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentCategoriesUtil} to access the document categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the document categorieses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the document categorieses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of document categorieses
	* @param end the upper bound of the range of document categorieses (not inclusive)
	* @return the range of matching document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the document categorieses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of document categorieses
	* @param end the upper bound of the range of document categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first document categories in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document categories
	* @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a matching document categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;

	/**
	* Returns the first document categories in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document categories, or <code>null</code> if a matching document categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last document categories in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document categories
	* @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a matching document categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;

	/**
	* Returns the last document categories in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document categories, or <code>null</code> if a matching document categories could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document categorieses before and after the current document categories in the ordered set where groupId = &#63;.
	*
	* @param documentcategoryId the primary key of the current document categories
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document categories
	* @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories[] findByGroupId_PrevAndNext(
		long documentcategoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;

	/**
	* Removes all the document categorieses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of document categorieses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the document categories in the entity cache if it is enabled.
	*
	* @param documentCategories the document categories
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories);

	/**
	* Caches the document categorieses in the entity cache if it is enabled.
	*
	* @param documentCategorieses the document categorieses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> documentCategorieses);

	/**
	* Creates a new document categories with the primary key. Does not add the document categories to the database.
	*
	* @param documentcategoryId the primary key for the new document categories
	* @return the new document categories
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories create(
		long documentcategoryId);

	/**
	* Removes the document categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentcategoryId the primary key of the document categories
	* @return the document categories that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories remove(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;

	public com.rknowsys.eapp.hrm.model.DocumentCategories updateImpl(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document categories with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException} if it could not be found.
	*
	* @param documentcategoryId the primary key of the document categories
	* @return the document categories
	* @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories findByPrimaryKey(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;

	/**
	* Returns the document categories with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentcategoryId the primary key of the document categories
	* @return the document categories, or <code>null</code> if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.DocumentCategories fetchByPrimaryKey(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the document categorieses.
	*
	* @return the document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the document categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document categorieses
	* @param end the upper bound of the range of document categorieses (not inclusive)
	* @return the range of document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the document categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document categorieses
	* @param end the upper bound of the range of document categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the document categorieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of document categorieses.
	*
	* @return the number of document categorieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}