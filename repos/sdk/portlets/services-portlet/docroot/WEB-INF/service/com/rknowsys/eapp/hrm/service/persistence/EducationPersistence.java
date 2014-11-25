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

import com.rknowsys.eapp.hrm.model.Education;

/**
 * The persistence interface for the education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EducationPersistenceImpl
 * @see EducationUtil
 * @generated
 */
public interface EducationPersistence extends BasePersistence<Education> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EducationUtil} to access the education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the educations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the educations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @return the range of matching educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the educations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first education in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching education
	* @throws com.rknowsys.eapp.hrm.NoSuchEducationException if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEducationException;

	/**
	* Returns the first education in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching education, or <code>null</code> if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last education in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching education
	* @throws com.rknowsys.eapp.hrm.NoSuchEducationException if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEducationException;

	/**
	* Returns the last education in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching education, or <code>null</code> if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the educations before and after the current education in the ordered set where groupId = &#63;.
	*
	* @param educationId the primary key of the current education
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next education
	* @throws com.rknowsys.eapp.hrm.NoSuchEducationException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education[] findByGroupId_PrevAndNext(
		long educationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEducationException;

	/**
	* Removes all the educations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of educations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching educations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the education in the entity cache if it is enabled.
	*
	* @param education the education
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Education education);

	/**
	* Caches the educations in the entity cache if it is enabled.
	*
	* @param educations the educations
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Education> educations);

	/**
	* Creates a new education with the primary key. Does not add the education to the database.
	*
	* @param educationId the primary key for the new education
	* @return the new education
	*/
	public com.rknowsys.eapp.hrm.model.Education create(long educationId);

	/**
	* Removes the education with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param educationId the primary key of the education
	* @return the education that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEducationException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education remove(long educationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEducationException;

	public com.rknowsys.eapp.hrm.model.Education updateImpl(
		com.rknowsys.eapp.hrm.model.Education education)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the education with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEducationException} if it could not be found.
	*
	* @param educationId the primary key of the education
	* @return the education
	* @throws com.rknowsys.eapp.hrm.NoSuchEducationException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education findByPrimaryKey(
		long educationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEducationException;

	/**
	* Returns the education with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param educationId the primary key of the education
	* @return the education, or <code>null</code> if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Education fetchByPrimaryKey(
		long educationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the educations.
	*
	* @return the educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the educations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @return the range of educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the educations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the educations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of educations.
	*
	* @return the number of educations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}