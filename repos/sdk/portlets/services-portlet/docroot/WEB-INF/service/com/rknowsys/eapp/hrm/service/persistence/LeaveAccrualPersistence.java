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

import com.rknowsys.eapp.hrm.model.LeaveAccrual;

/**
 * The persistence interface for the leave accrual service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveAccrualPersistenceImpl
 * @see LeaveAccrualUtil
 * @generated
 */
public interface LeaveAccrualPersistence extends BasePersistence<LeaveAccrual> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveAccrualUtil} to access the leave accrual persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave accruals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave accruals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave accruals
	* @param end the upper bound of the range of leave accruals (not inclusive)
	* @return the range of matching leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave accruals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave accruals
	* @param end the upper bound of the range of leave accruals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave accrual in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave accrual
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Returns the first leave accrual in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave accrual in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave accrual
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Returns the last leave accrual in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave accruals before and after the current leave accrual in the ordered set where groupId = &#63;.
	*
	* @param leaveAccrualId the primary key of the current leave accrual
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave accrual
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual[] findByGroupId_PrevAndNext(
		long leaveAccrualId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Removes all the leave accruals where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave accruals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave accrual where leaveTypeId = &#63; or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException} if it could not be found.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave accrual
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Returns the leave accrual where leaveTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave accrual where leaveTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param leaveTypeId the leave type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchByLeaveTypeId(
		long leaveTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the leave accrual where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @return the leave accrual that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual removeByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Returns the number of leave accruals where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the leave accrual in the entity cache if it is enabled.
	*
	* @param leaveAccrual the leave accrual
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual);

	/**
	* Caches the leave accruals in the entity cache if it is enabled.
	*
	* @param leaveAccruals the leave accruals
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> leaveAccruals);

	/**
	* Creates a new leave accrual with the primary key. Does not add the leave accrual to the database.
	*
	* @param leaveAccrualId the primary key for the new leave accrual
	* @return the new leave accrual
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual create(long leaveAccrualId);

	/**
	* Removes the leave accrual with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveAccrualId the primary key of the leave accrual
	* @return the leave accrual that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual remove(long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	public com.rknowsys.eapp.hrm.model.LeaveAccrual updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave accrual with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException} if it could not be found.
	*
	* @param leaveAccrualId the primary key of the leave accrual
	* @return the leave accrual
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual findByPrimaryKey(
		long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;

	/**
	* Returns the leave accrual with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveAccrualId the primary key of the leave accrual
	* @return the leave accrual, or <code>null</code> if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchByPrimaryKey(
		long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave accruals.
	*
	* @return the leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave accruals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave accruals
	* @param end the upper bound of the range of leave accruals (not inclusive)
	* @return the range of leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave accruals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave accruals
	* @param end the upper bound of the range of leave accruals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leave accruals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave accruals.
	*
	* @return the number of leave accruals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}