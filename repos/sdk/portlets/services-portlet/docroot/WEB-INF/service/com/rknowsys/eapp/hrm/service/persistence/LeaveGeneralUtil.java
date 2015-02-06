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

import com.rknowsys.eapp.hrm.model.LeaveGeneral;

import java.util.List;

/**
 * The persistence utility for the leave general service. This utility wraps {@link LeaveGeneralPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveGeneralPersistence
 * @see LeaveGeneralPersistenceImpl
 * @generated
 */
public class LeaveGeneralUtil {
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
	public static void clearCache(LeaveGeneral leaveGeneral) {
		getPersistence().clearCache(leaveGeneral);
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
	public static List<LeaveGeneral> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveGeneral> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveGeneral> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LeaveGeneral update(LeaveGeneral leaveGeneral)
		throws SystemException {
		return getPersistence().update(leaveGeneral);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LeaveGeneral update(LeaveGeneral leaveGeneral,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leaveGeneral, serviceContext);
	}

	/**
	* Returns all the leave generals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the leave generals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @return the range of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the leave generals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave general in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first leave general in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave general, or <code>null</code> if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last leave general in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last leave general in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave general, or <code>null</code> if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the leave generals before and after the current leave general in the ordered set where groupId = &#63;.
	*
	* @param leaveGeneralId the primary key of the current leave general
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral[] findByGroupId_PrevAndNext(
		long leaveGeneralId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(leaveGeneralId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the leave generals where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of leave generals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the leave generals where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns a range of all the leave generals where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @return the range of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByLeaveTypeId(
		long leaveTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the leave generals where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findByLeaveTypeId(
		long leaveTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLeaveTypeId(leaveTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave general in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral findByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence()
				   .findByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the first leave general in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave general, or <code>null</code> if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral fetchByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave general in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral findByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence()
				   .findByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave general in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave general, or <code>null</code> if a matching leave general could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral fetchByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the leave generals before and after the current leave general in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveGeneralId the primary key of the current leave general
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral[] findByLeaveTypeId_PrevAndNext(
		long leaveGeneralId, long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence()
				   .findByLeaveTypeId_PrevAndNext(leaveGeneralId, leaveTypeId,
			orderByComparator);
	}

	/**
	* Removes all the leave generals where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the number of leave generals where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeId(leaveTypeId);
	}

	/**
	* Caches the leave general in the entity cache if it is enabled.
	*
	* @param leaveGeneral the leave general
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveGeneral leaveGeneral) {
		getPersistence().cacheResult(leaveGeneral);
	}

	/**
	* Caches the leave generals in the entity cache if it is enabled.
	*
	* @param leaveGenerals the leave generals
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> leaveGenerals) {
		getPersistence().cacheResult(leaveGenerals);
	}

	/**
	* Creates a new leave general with the primary key. Does not add the leave general to the database.
	*
	* @param leaveGeneralId the primary key for the new leave general
	* @return the new leave general
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral create(
		long leaveGeneralId) {
		return getPersistence().create(leaveGeneralId);
	}

	/**
	* Removes the leave general with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveGeneralId the primary key of the leave general
	* @return the leave general that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral remove(
		long leaveGeneralId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence().remove(leaveGeneralId);
	}

	public static com.rknowsys.eapp.hrm.model.LeaveGeneral updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveGeneral leaveGeneral)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leaveGeneral);
	}

	/**
	* Returns the leave general with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException} if it could not be found.
	*
	* @param leaveGeneralId the primary key of the leave general
	* @return the leave general
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral findByPrimaryKey(
		long leaveGeneralId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException {
		return getPersistence().findByPrimaryKey(leaveGeneralId);
	}

	/**
	* Returns the leave general with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveGeneralId the primary key of the leave general
	* @return the leave general, or <code>null</code> if a leave general with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveGeneral fetchByPrimaryKey(
		long leaveGeneralId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(leaveGeneralId);
	}

	/**
	* Returns all the leave generals.
	*
	* @return the leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave generals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @return the range of leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave generals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave generals
	* @param end the upper bound of the range of leave generals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveGeneral> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the leave generals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave generals.
	*
	* @return the number of leave generals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LeaveGeneralPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LeaveGeneralPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					LeaveGeneralPersistence.class.getName());

			ReferenceRegistry.registerReference(LeaveGeneralUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LeaveGeneralPersistence persistence) {
	}

	private static LeaveGeneralPersistence _persistence;
}