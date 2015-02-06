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

import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;

import java.util.List;

/**
 * The persistence utility for the leave rule applicable service. This utility wraps {@link LeaveRuleApplicablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveRuleApplicablePersistence
 * @see LeaveRuleApplicablePersistenceImpl
 * @generated
 */
public class LeaveRuleApplicableUtil {
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
	public static void clearCache(LeaveRuleApplicable leaveRuleApplicable) {
		getPersistence().clearCache(leaveRuleApplicable);
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
	public static List<LeaveRuleApplicable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveRuleApplicable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveRuleApplicable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LeaveRuleApplicable update(
		LeaveRuleApplicable leaveRuleApplicable) throws SystemException {
		return getPersistence().update(leaveRuleApplicable);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LeaveRuleApplicable update(
		LeaveRuleApplicable leaveRuleApplicable, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(leaveRuleApplicable, serviceContext);
	}

	/**
	* Returns all the leave rule applicables where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable[] findByGroupId_PrevAndNext(
		long leaveRuleApplicableId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(leaveRuleApplicableId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the leave rule applicables where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of leave rule applicables where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the leave rule applicables where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLeaveTypeId(leaveTypeId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLeaveTypeId(leaveTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence()
				   .findByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByLeaveTypeId_First(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_First(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence()
				   .findByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

	/**
	* Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByLeaveTypeId_Last(
		long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLeaveTypeId_Last(leaveTypeId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable[] findByLeaveTypeId_PrevAndNext(
		long leaveRuleApplicableId, long leaveTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence()
				   .findByLeaveTypeId_PrevAndNext(leaveRuleApplicableId,
			leaveTypeId, orderByComparator);
	}

	/**
	* Removes all the leave rule applicables where leaveTypeId = &#63; from the database.
	*
	* @param leaveTypeId the leave type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLeaveTypeId(leaveTypeId);
	}

	/**
	* Returns the number of leave rule applicables where leaveTypeId = &#63;.
	*
	* @param leaveTypeId the leave type ID
	* @return the number of matching leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLeaveTypeId(long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLeaveTypeId(leaveTypeId);
	}

	/**
	* Caches the leave rule applicable in the entity cache if it is enabled.
	*
	* @param leaveRuleApplicable the leave rule applicable
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable) {
		getPersistence().cacheResult(leaveRuleApplicable);
	}

	/**
	* Caches the leave rule applicables in the entity cache if it is enabled.
	*
	* @param leaveRuleApplicables the leave rule applicables
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables) {
		getPersistence().cacheResult(leaveRuleApplicables);
	}

	/**
	* Creates a new leave rule applicable with the primary key. Does not add the leave rule applicable to the database.
	*
	* @param leaveRuleApplicableId the primary key for the new leave rule applicable
	* @return the new leave rule applicable
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable create(
		long leaveRuleApplicableId) {
		return getPersistence().create(leaveRuleApplicableId);
	}

	/**
	* Removes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable remove(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence().remove(leaveRuleApplicableId);
	}

	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leaveRuleApplicable);
	}

	/**
	* Returns the leave rule applicable with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException} if it could not be found.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable
	* @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable findByPrimaryKey(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException {
		return getPersistence().findByPrimaryKey(leaveRuleApplicableId);
	}

	/**
	* Returns the leave rule applicable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable, or <code>null</code> if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchByPrimaryKey(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(leaveRuleApplicableId);
	}

	/**
	* Returns all the leave rule applicables.
	*
	* @return the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the leave rule applicables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave rule applicables.
	*
	* @return the number of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the job categories associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobCategories(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobCategories(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getJobCategories(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of job categories associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of job categories associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobCategoriesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobCategoriesSize(pk);
	}

	/**
	* Returns <code>true</code> if the job category is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @return <code>true</code> if the job category is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobCategory(pk, jobCategoryPK);
	}

	/**
	* Returns <code>true</code> if the leave rule applicable has any job categories associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with job categories
	* @return <code>true</code> if the leave rule applicable has any job categories associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobCategories(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobCategories(pk);
	}

	/**
	* Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobCategory(pk, jobCategoryPK);
	}

	/**
	* Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategory the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobCategory(pk, jobCategory);
	}

	/**
	* Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobCategories(pk, jobCategoryPKs);
	}

	/**
	* Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobCategories(pk, jobCategories);
	}

	/**
	* Clears all associations between the leave rule applicable and its job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated job categories from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobCategories(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearJobCategories(pk);
	}

	/**
	* Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPK the primary key of the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobCategory(long pk, long jobCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobCategory(pk, jobCategoryPK);
	}

	/**
	* Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategory the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobCategory(pk, jobCategory);
	}

	/**
	* Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobCategories(pk, jobCategoryPKs);
	}

	/**
	* Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobCategories(pk, jobCategories);
	}

	/**
	* Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategoryPKs the primary keys of the job categories to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobCategories(long pk, long[] jobCategoryPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobCategories(pk, jobCategoryPKs);
	}

	/**
	* Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobCategories the job categories to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobCategories(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobCategories(pk, jobCategories);
	}

	/**
	* Returns all the job titles associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobTitles(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobTitles(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobTitles(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of job titles associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of job titles associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobTitlesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobTitlesSize(pk);
	}

	/**
	* Returns <code>true</code> if the job title is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @return <code>true</code> if the job title is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobTitle(pk, jobTitlePK);
	}

	/**
	* Returns <code>true</code> if the leave rule applicable has any job titles associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with job titles
	* @return <code>true</code> if the leave rule applicable has any job titles associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobTitles(pk);
	}

	/**
	* Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobTitle(pk, jobTitlePK);
	}

	/**
	* Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobTitle(pk, jobTitle);
	}

	/**
	* Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobTitles(pk, jobTitlePKs);
	}

	/**
	* Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobTitles(pk, jobTitles);
	}

	/**
	* Clears all associations between the leave rule applicable and its job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated job titles from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobTitles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearJobTitles(pk);
	}

	/**
	* Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePK the primary key of the job title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobTitle(long pk, long jobTitlePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobTitle(pk, jobTitlePK);
	}

	/**
	* Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobTitle(pk, jobTitle);
	}

	/**
	* Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobTitles(pk, jobTitlePKs);
	}

	/**
	* Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobTitles(pk, jobTitles);
	}

	/**
	* Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitlePKs the primary keys of the job titles to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobTitles(long pk, long[] jobTitlePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobTitles(pk, jobTitlePKs);
	}

	/**
	* Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param jobTitles the job titles to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobTitles(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobTitles(pk, jobTitles);
	}

	/**
	* Returns all the employment statuses associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmploymentStatuses(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmploymentStatuses(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getEmploymentStatuses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of employment statuses associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @return the number of employment statuses associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmploymentStatusesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmploymentStatusesSize(pk);
	}

	/**
	* Returns <code>true</code> if the employment status is associated with the leave rule applicable.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @return <code>true</code> if the employment status is associated with the leave rule applicable; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEmploymentStatus(long pk,
		long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEmploymentStatus(pk, employmentStatusPK);
	}

	/**
	* Returns <code>true</code> if the leave rule applicable has any employment statuses associated with it.
	*
	* @param pk the primary key of the leave rule applicable to check for associations with employment statuses
	* @return <code>true</code> if the leave rule applicable has any employment statuses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEmploymentStatuses(pk);
	}

	/**
	* Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmploymentStatus(pk, employmentStatusPK);
	}

	/**
	* Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmploymentStatus(pk, employmentStatus);
	}

	/**
	* Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmploymentStatuses(pk, employmentStatusPKs);
	}

	/**
	* Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmploymentStatuses(pk, employmentStatuses);
	}

	/**
	* Clears all associations between the leave rule applicable and its employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable to clear the associated employment statuses from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmploymentStatuses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearEmploymentStatuses(pk);
	}

	/**
	* Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPK the primary key of the employment status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmploymentStatus(long pk, long employmentStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmploymentStatus(pk, employmentStatusPK);
	}

	/**
	* Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatus the employment status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmploymentStatus(pk, employmentStatus);
	}

	/**
	* Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmploymentStatuses(long pk,
		long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmploymentStatuses(pk, employmentStatusPKs);
	}

	/**
	* Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmploymentStatuses(pk, employmentStatuses);
	}

	/**
	* Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatusPKs the primary keys of the employment statuses to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setEmploymentStatuses(pk, employmentStatusPKs);
	}

	/**
	* Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the leave rule applicable
	* @param employmentStatuses the employment statuses to be associated with the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmploymentStatuses(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setEmploymentStatuses(pk, employmentStatuses);
	}

	public static LeaveRuleApplicablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LeaveRuleApplicablePersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					LeaveRuleApplicablePersistence.class.getName());

			ReferenceRegistry.registerReference(LeaveRuleApplicableUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LeaveRuleApplicablePersistence persistence) {
	}

	private static LeaveRuleApplicablePersistence _persistence;
}