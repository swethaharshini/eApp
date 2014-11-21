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

import com.rknowsys.eapp.hrm.model.Workshift;

/**
 * The persistence interface for the workshift service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkshiftPersistenceImpl
 * @see WorkshiftUtil
 * @generated
 */
public interface WorkshiftPersistence extends BasePersistence<Workshift> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkshiftUtil} to access the workshift persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workshifts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workshifts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workshifts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Returns the first workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Returns the last workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workshifts before and after the current workshift in the ordered set where groupId = &#63;.
	*
	* @param shiftId the primary key of the current workshift
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift[] findByGroupId_PrevAndNext(
		long shiftId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Removes all the workshifts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workshifts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workshifts where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workshifts where shiftId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shiftId the shift ID
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workshifts where shiftId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shiftId the shift ID
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift findByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Returns the first workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift fetchByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift findByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Returns the last workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift fetchByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workshifts where shiftId = &#63; from the database.
	*
	* @param shiftId the shift ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workshifts where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the number of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public int countByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the workshift in the entity cache if it is enabled.
	*
	* @param workshift the workshift
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Workshift workshift);

	/**
	* Caches the workshifts in the entity cache if it is enabled.
	*
	* @param workshifts the workshifts
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> workshifts);

	/**
	* Creates a new workshift with the primary key. Does not add the workshift to the database.
	*
	* @param shiftId the primary key for the new workshift
	* @return the new workshift
	*/
	public com.rknowsys.eapp.hrm.model.Workshift create(long shiftId);

	/**
	* Removes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift remove(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	public com.rknowsys.eapp.hrm.model.Workshift updateImpl(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workshift with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkshiftException} if it could not be found.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift findByPrimaryKey(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException;

	/**
	* Returns the workshift with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift, or <code>null</code> if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Workshift fetchByPrimaryKey(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workshifts.
	*
	* @return the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workshifts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workshifts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workshifts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workshifts.
	*
	* @return the number of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Employees associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @return the Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Employees associated with the workshift.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workshift
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Employees associated with the workshift.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workshift
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Employees associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @return the number of Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public int getEmployeesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Employee is associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @return <code>true</code> if the Employee is associated with the workshift; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workshift has any Employees associated with it.
	*
	* @param pk the primary key of the workshift to check for associations with Employees
	* @return <code>true</code> if the workshift has any Employees associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employee the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the workshift and its Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift to clear the associated Employees from
	* @throws SystemException if a system exception occurred
	*/
	public void clearEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employee the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees to be associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void setEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees to be associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void setEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;
}