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

import com.rknowsys.eapp.hrm.model.Workshift;

import java.util.List;

/**
 * The persistence utility for the workshift service. This utility wraps {@link WorkshiftPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkshiftPersistence
 * @see WorkshiftPersistenceImpl
 * @generated
 */
public class WorkshiftUtil {
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
	public static void clearCache(Workshift workshift) {
		getPersistence().clearCache(workshift);
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
	public static List<Workshift> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Workshift> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Workshift> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Workshift update(Workshift workshift)
		throws SystemException {
		return getPersistence().update(workshift);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Workshift update(Workshift workshift,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workshift, serviceContext);
	}

	/**
	* Returns all the workshifts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last workshift in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.Workshift[] findByGroupId_PrevAndNext(
		long shiftId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(shiftId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the workshifts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of workshifts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the workshifts where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByshiftId(shiftId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByshiftId(shiftId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findByshiftId(
		long shiftId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByshiftId(shiftId, start, end, orderByComparator);
	}

	/**
	* Returns the first workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift findByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().findByshiftId_First(shiftId, orderByComparator);
	}

	/**
	* Returns the first workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift fetchByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByshiftId_First(shiftId, orderByComparator);
	}

	/**
	* Returns the last workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift findByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().findByshiftId_Last(shiftId, orderByComparator);
	}

	/**
	* Returns the last workshift in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift fetchByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByshiftId_Last(shiftId, orderByComparator);
	}

	/**
	* Removes all the workshifts where shiftId = &#63; from the database.
	*
	* @param shiftId the shift ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByshiftId(shiftId);
	}

	/**
	* Returns the number of workshifts where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the number of matching workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByshiftId(shiftId);
	}

	/**
	* Caches the workshift in the entity cache if it is enabled.
	*
	* @param workshift the workshift
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.Workshift workshift) {
		getPersistence().cacheResult(workshift);
	}

	/**
	* Caches the workshifts in the entity cache if it is enabled.
	*
	* @param workshifts the workshifts
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> workshifts) {
		getPersistence().cacheResult(workshifts);
	}

	/**
	* Creates a new workshift with the primary key. Does not add the workshift to the database.
	*
	* @param shiftId the primary key for the new workshift
	* @return the new workshift
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift create(long shiftId) {
		return getPersistence().create(shiftId);
	}

	/**
	* Removes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift remove(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().remove(shiftId);
	}

	public static com.rknowsys.eapp.hrm.model.Workshift updateImpl(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workshift);
	}

	/**
	* Returns the workshift with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkshiftException} if it could not be found.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift findByPrimaryKey(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkshiftException {
		return getPersistence().findByPrimaryKey(shiftId);
	}

	/**
	* Returns the workshift with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift, or <code>null</code> if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift fetchByPrimaryKey(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(shiftId);
	}

	/**
	* Returns all the workshifts.
	*
	* @return the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the workshifts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workshifts.
	*
	* @return the number of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the Employees associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @return the Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmployees(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmployees(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmployees(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of Employees associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @return the number of Employees associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEmployeesSize(pk);
	}

	/**
	* Returns <code>true</code> if the Employee is associated with the workshift.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @return <code>true</code> if the Employee is associated with the workshift; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEmployee(pk, employeePK);
	}

	/**
	* Returns <code>true</code> if the workshift has any Employees associated with it.
	*
	* @param pk the primary key of the workshift to check for associations with Employees
	* @return <code>true</code> if the workshift has any Employees associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEmployees(pk);
	}

	/**
	* Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmployee(pk, employeePK);
	}

	/**
	* Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employee the Employee
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmployee(pk, employee);
	}

	/**
	* Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmployees(pk, employeePKs);
	}

	/**
	* Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addEmployees(pk, employees);
	}

	/**
	* Clears all associations between the workshift and its Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift to clear the associated Employees from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearEmployees(pk);
	}

	/**
	* Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePK the primary key of the Employee
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmployee(pk, employeePK);
	}

	/**
	* Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employee the Employee
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmployee(pk, employee);
	}

	/**
	* Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmployees(pk, employeePKs);
	}

	/**
	* Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees
	* @throws SystemException if a system exception occurred
	*/
	public static void removeEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeEmployees(pk, employees);
	}

	/**
	* Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employeePKs the primary keys of the Employees to be associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setEmployees(pk, employeePKs);
	}

	/**
	* Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workshift
	* @param employees the Employees to be associated with the workshift
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmployees(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setEmployees(pk, employees);
	}

	public static WorkshiftPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkshiftPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					WorkshiftPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkshiftUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkshiftPersistence persistence) {
	}

	private static WorkshiftPersistence _persistence;
}