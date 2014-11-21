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

import com.rknowsys.eapp.hrm.model.LeaveTypeApplicability;

/**
 * The persistence interface for the leave type applicability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeApplicabilityPersistenceImpl
 * @see LeaveTypeApplicabilityUtil
 * @generated
 */
public interface LeaveTypeApplicabilityPersistence extends BasePersistence<LeaveTypeApplicability> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTypeApplicabilityUtil} to access the leave type applicability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the leave type applicabilities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave type applicabilities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave type applicabilities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave type applicability in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Returns the first leave type applicability in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave type applicability in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Returns the last leave type applicability in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave type applicabilities before and after the current leave type applicability in the ordered set where groupId = &#63;.
	*
	* @param leaveTypeApplicabilityId the primary key of the current leave type applicability
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability[] findByGroupId_PrevAndNext(
		long leaveTypeApplicabilityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Removes all the leave type applicabilities where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave type applicabilities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave type applicabilities where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave type applicabilities where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByLeaveTypeId(
		long leaveTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave type applicabilities where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByLeaveTypeId(
		long leaveTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first leave type applicability in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability findByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Returns the first leave type applicability in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last leave type applicability in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability findByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Returns the last leave type applicability in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave type applicabilities before and after the current leave type applicability in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeApplicabilityId the primary key of the current leave type applicability
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability[] findByLeaveTypeId_PrevAndNext(
		long leaveTypeApplicabilityId, long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Removes all the leave type applicabilities where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave type applicabilities where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the leave type applicability in the entity cache if it is enabled.
	*
	* @param leaveTypeApplicability the leave type applicability
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability);

	/**
	* Caches the leave type applicabilities in the entity cache if it is enabled.
	*
	* @param leaveTypeApplicabilities the leave type applicabilities
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities);

	/**
	* Creates a new leave type applicability with the primary key. Does not add the leave type applicability to the database.
	*
	* @param leaveTypeApplicabilityId the primary key for the new leave type applicability
	* @return the new leave type applicability
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability create(
		long leaveTypeApplicabilityId);

	/**
	* Removes the leave type applicability with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability remove(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leave type applicability with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException} if it could not be found.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability findByPrimaryKey(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;

	/**
	* Returns the leave type applicability with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability, or <code>null</code> if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchByPrimaryKey(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave type applicabilities.
	*
	* @return the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave type applicabilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave type applicabilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leave type applicabilities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave type applicabilities.
	*
	* @return the number of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job titles associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @return the job titles associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job titles associated with the leave type applicability.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave type applicability
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of job titles associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job titles associated with the leave type applicability.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave type applicability
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job titles associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job titles associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @return the number of job titles associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public int getJobTitlesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job title is associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePK the primary key of the job title
	* @return <code>true</code> if the job title is associated with the leave type applicability; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave type applicability has any job titles associated with it.
	*
	* @param pk the primary key of the leave type applicability to check for associations with job titles
	* @return <code>true</code> if the leave type applicability has any job titles associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void addJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the leave type applicability and its job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability to clear the associated job titles from
	* @throws SystemException if a system exception occurred
	*/
	public void clearJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job titles associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitlePKs the primary keys of the job titles to be associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void setJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job titles associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param jobTitles the job titles to be associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void setJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employment statuses associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @return the employment statuses associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employment statuses associated with the leave type applicability.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave type applicability
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of employment statuses associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employment statuses associated with the leave type applicability.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the leave type applicability
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employment statuses associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employment statuses associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @return the number of employment statuses associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public int getEmploymentStatusesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the employment status is associated with the leave type applicability.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPK the primary key of the employment status
	* @return <code>true</code> if the employment status is associated with the leave type applicability; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave type applicability has any employment statuses associated with it.
	*
	* @param pk the primary key of the leave type applicability to check for associations with employment statuses
	* @return <code>true</code> if the leave type applicability has any employment statuses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void addEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the leave type applicability and its employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability to clear the associated employment statuses from
	* @throws SystemException if a system exception occurred
	*/
	public void clearEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employment statuses associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatusPKs the primary keys of the employment statuses to be associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void setEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employment statuses associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave type applicability
	* @param employmentStatuses the employment statuses to be associated with the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void setEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException;
}