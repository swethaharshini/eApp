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

import com.rknowsys.eapp.hrm.model.WorkWeek;

/**
 * The persistence interface for the WorkWeek service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkWeekPersistenceImpl
 * @see WorkWeekUtil
 * @generated
 */
public interface WorkWeekPersistence extends BasePersistence<WorkWeek> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkWeekUtil} to access the WorkWeek persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WorkWeeks where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @return the matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the WorkWeeks where nationalityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nationalityId the nationality ID
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @return the range of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WorkWeeks where nationalityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nationalityId the nationality ID
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek findByNationality_First(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException;

	/**
	* Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek fetchByNationality_First(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek findByNationality_Last(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException;

	/**
	* Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek fetchByNationality_Last(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WorkWeeks before and after the current WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param workWeekId the primary key of the current WorkWeek
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek[] findByNationality_PrevAndNext(
		long workWeekId, long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException;

	/**
	* Removes all the WorkWeeks where nationalityId = &#63; from the database.
	*
	* @param nationalityId the nationality ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNationality(long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WorkWeeks where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @return the number of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public int countByNationality(long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the WorkWeek in the entity cache if it is enabled.
	*
	* @param workWeek the WorkWeek
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.WorkWeek workWeek);

	/**
	* Caches the WorkWeeks in the entity cache if it is enabled.
	*
	* @param workWeeks the WorkWeeks
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> workWeeks);

	/**
	* Creates a new WorkWeek with the primary key. Does not add the WorkWeek to the database.
	*
	* @param workWeekId the primary key for the new WorkWeek
	* @return the new WorkWeek
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek create(long workWeekId);

	/**
	* Removes the WorkWeek with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek remove(long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException;

	public com.rknowsys.eapp.hrm.model.WorkWeek updateImpl(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WorkWeek with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkWeekException} if it could not be found.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek findByPrimaryKey(
		long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException;

	/**
	* Returns the WorkWeek with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek, or <code>null</code> if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkWeek fetchByPrimaryKey(
		long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the WorkWeeks.
	*
	* @return the WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the WorkWeeks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @return the range of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WorkWeeks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the WorkWeeks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WorkWeeks.
	*
	* @return the number of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}