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

import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;

/**
 * The persistence interface for the leave rule applicable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveRuleApplicablePersistenceImpl
 * @see LeaveRuleApplicableUtil
 * @generated
 */
public interface LeaveRuleApplicablePersistence extends BasePersistence<LeaveRuleApplicable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveRuleApplicableUtil} to access the leave rule applicable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave rule applicables where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave rule applicables where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave rule applicables where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave rule applicables before and after the current leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param leaveRuleApplicableId the primary key of the current leave rule applicable
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable[] findByGroupId_PrevAndNext(
		long leaveRuleApplicableId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Removes all the leave rule applicables where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave rule applicables where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave rule applicables where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave rule applicables where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave rule applicables where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave rule applicables before and after the current leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveRuleApplicableId the primary key of the current leave rule applicable
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable[] findByLeaveTypeId_PrevAndNext(
		long leaveRuleApplicableId, long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Removes all the leave rule applicables where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave rule applicables where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the leave rule applicable in the entity cache if it is enabled.
	*
	* @param leaveRuleApplicable the leave rule applicable
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable);

	/**
	* Caches the leave rule applicables in the entity cache if it is enabled.
	*
	* @param leaveRuleApplicables the leave rule applicables
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables);

	/**
	* Creates a new leave rule applicable with the primary key. Does not add the leave rule applicable to the database.
	*
	* @param leaveRuleApplicableId the primary key for the new leave rule applicable
	* @return the new leave rule applicable
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable create(
		long leaveRuleApplicableId);

	/**
	* Removes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable remove(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave rule applicable with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException} if it could not be found.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByPrimaryKey(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;

	/**
	* Returns the leave rule applicable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable, or <code>null</code> if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByPrimaryKey(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave rule applicables.
	*
	* @return the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave rule applicables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave rule applicables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leave rule applicables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave rule applicables.
	*
	* @return the number of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job categories associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job categories associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job categories associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job categories associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public int getJobCategoriesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job category is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @return <code>true</code> if the job category is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave rule applicable has any job categories associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with job categories
	* @return <code>true</code> if the leave rule applicable has any job categories associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobCategories(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @throws SystemException if a system exception occurred
	*/
	public void addJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategory the job category
	* @throws SystemException if a system exception occurred
	*/
	public void addJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories
	* @throws SystemException if a system exception occurred
	*/
	public void addJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories
	* @throws SystemException if a system exception occurred
	*/
	public void addJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the leave rule applicable and its job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated job categories from
	* @throws SystemException if a system exception occurred
	*/
	public void clearJobCategories(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategory the job category
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job titles associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job titles associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job titles associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job titles associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public int getJobTitlesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job title is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @return <code>true</code> if the job title is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave rule applicable has any job titles associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with job titles
	* @return <code>true</code> if the leave rule applicable has any job titles associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the leave rule applicable and its job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated job titles from
	* @throws SystemException if a system exception occurred
	*/
	public void clearJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employment statuses associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employment statuses associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employment statuses associated with the leave rule applicable.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave rule applicable
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employment statuses associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public int getEmploymentStatusesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the employment status is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @return <code>true</code> if the employment status is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave rule applicable has any employment statuses associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with employment statuses
	* @return <code>true</code> if the leave rule applicable has any employment statuses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the leave rule applicable and its employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated employment statuses from
	* @throws SystemException if a system exception occurred
	*/
	public void clearEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void setEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;
}