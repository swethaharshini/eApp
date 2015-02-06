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

import com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups;

import java.util.List;

/**
 * The persistence utility for the leave type employee groups service. This utility wraps {@link LeaveTypeEmployeeGroupsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeEmployeeGroupsPersistence
 * @see LeaveTypeEmployeeGroupsPersistenceImpl
 * @generated
 */
public class LeaveTypeEmployeeGroupsUtil {
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
	public static void clearCache(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		getPersistence().clearCache(leaveTypeEmployeeGroups);
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
	public static List<LeaveTypeEmployeeGroups> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveTypeEmployeeGroups> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveTypeEmployeeGroups> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LeaveTypeEmployeeGroups update(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws SystemException {
		return getPersistence().update(leaveTypeEmployeeGroups);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LeaveTypeEmployeeGroups update(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leaveTypeEmployeeGroups, serviceContext);
	}

	/**
	* Returns all the leave type employee groupses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the leave type employee groupses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @return the range of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the leave type employee groupses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave type employee groups in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first leave type employee groups in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last leave type employee groups in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last leave type employee groups in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the leave type employee groupses before and after the current leave type employee groups in the ordered set where groupId = &#63;.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the current leave type employee groups
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups[] findByGroupId_PrevAndNext(
		long leaveTypeEmployeeGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(leaveTypeEmployeeGroupId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the leave type employee groupses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of leave type employee groupses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the leave type employee groupses where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns a range of all the leave type employee groupses where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @return the range of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByLeaveTypeId(
		long leaveTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the leave type employee groupses where leaveTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param leaveTypeId the leave type ID
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findByLeaveTypeId(
		long leaveTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLeaveTypeId(leaveTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave type employee groups in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups findByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence()
				   .findByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the first leave type employee groups in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave type employee groups in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups findByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence()
				   .findByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave type employee groups in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the leave type employee groupses before and after the current leave type employee groups in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the current leave type employee groups
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups[] findByLeaveTypeId_PrevAndNext(
		long leaveTypeEmployeeGroupId, long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence()
				   .findByLeaveTypeId_PrevAndNext(leaveTypeEmployeeGroupId,
			leaveTypeId, orderByComparator);
	}

	/**
	* Removes all the leave type employee groupses where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the number of leave type employee groupses where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeId(leaveTypeId);
	}

	/**
	* Caches the leave type employee groups in the entity cache if it is enabled.
	*
	* @param leaveTypeEmployeeGroups the leave type employee groups
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		getPersistence().cacheResult(leaveTypeEmployeeGroups);
	}

	/**
	* Caches the leave type employee groupses in the entity cache if it is enabled.
	*
	* @param leaveTypeEmployeeGroupses the leave type employee groupses
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> leaveTypeEmployeeGroupses) {
		getPersistence().cacheResult(leaveTypeEmployeeGroupses);
	}

	/**
	* Creates a new leave type employee groups with the primary key. Does not add the leave type employee groups to the database.
	*
	* @param leaveTypeEmployeeGroupId the primary key for the new leave type employee groups
	* @return the new leave type employee groups
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups create(
		long leaveTypeEmployeeGroupId) {
		return getPersistence().create(leaveTypeEmployeeGroupId);
	}

	/**
	* Removes the leave type employee groups with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	* @return the leave type employee groups that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups remove(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence().remove(leaveTypeEmployeeGroupId);
	}

	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leaveTypeEmployeeGroups);
	}

	/**
	* Returns the leave type employee groups with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException} if it could not be found.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	* @return the leave type employee groups
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups findByPrimaryKey(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException {
		return getPersistence().findByPrimaryKey(leaveTypeEmployeeGroupId);
	}

	/**
	* Returns the leave type employee groups with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	* @return the leave type employee groups, or <code>null</code> if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchByPrimaryKey(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(leaveTypeEmployeeGroupId);
	}

	/**
	* Returns all the leave type employee groupses.
	*
	* @return the leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave type employee groupses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @return the range of leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave type employee groupses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the leave type employee groupses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave type employee groupses.
	*
	* @return the number of leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LeaveTypeEmployeeGroupsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LeaveTypeEmployeeGroupsPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					LeaveTypeEmployeeGroupsPersistence.class.getName());

			ReferenceRegistry.registerReference(LeaveTypeEmployeeGroupsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LeaveTypeEmployeeGroupsPersistence persistence) {
	}

	private static LeaveTypeEmployeeGroupsPersistence _persistence;
}