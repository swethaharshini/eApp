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

import com.rknowsys.eapp.hrm.model.ReportingMethods;

import java.util.List;

/**
 * The persistence utility for the reporting methods service. This utility wraps {@link ReportingMethodsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethodsPersistence
 * @see ReportingMethodsPersistenceImpl
 * @generated
 */
public class ReportingMethodsUtil {
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
	public static void clearCache(ReportingMethods reportingMethods) {
		getPersistence().clearCache(reportingMethods);
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
	public static List<ReportingMethods> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReportingMethods> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReportingMethods> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ReportingMethods update(ReportingMethods reportingMethods)
		throws SystemException {
		return getPersistence().update(reportingMethods);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ReportingMethods update(ReportingMethods reportingMethods,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(reportingMethods, serviceContext);
	}

	/**
	* Returns all the reporting methodses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the reporting methodses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @return the range of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the reporting methodses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the reporting methodses before and after the current reporting methods in the ordered set where groupId = &#63;.
	*
	* @param reportingmethodId the primary key of the current reporting methods
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods[] findByGroupId_PrevAndNext(
		long reportingmethodId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(reportingmethodId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the reporting methodses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of reporting methodses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the reporting methodses where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @return the matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreportingmethodId(reportingmethodId);
	}

	/**
	* Returns a range of all the reporting methodses where reportingmethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportingmethodId the reportingmethod ID
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @return the range of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreportingmethodId(reportingmethodId, start, end);
	}

	/**
	* Returns an ordered range of all the reporting methodses where reportingmethodId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportingmethodId the reportingmethod ID
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreportingmethodId(reportingmethodId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods findByreportingmethodId_First(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence()
				   .findByreportingmethodId_First(reportingmethodId,
			orderByComparator);
	}

	/**
	* Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods fetchByreportingmethodId_First(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreportingmethodId_First(reportingmethodId,
			orderByComparator);
	}

	/**
	* Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods findByreportingmethodId_Last(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence()
				   .findByreportingmethodId_Last(reportingmethodId,
			orderByComparator);
	}

	/**
	* Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods fetchByreportingmethodId_Last(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreportingmethodId_Last(reportingmethodId,
			orderByComparator);
	}

	/**
	* Removes all the reporting methodses where reportingmethodId = &#63; from the database.
	*
	* @param reportingmethodId the reportingmethod ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByreportingmethodId(long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByreportingmethodId(reportingmethodId);
	}

	/**
	* Returns the number of reporting methodses where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @return the number of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByreportingmethodId(long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByreportingmethodId(reportingmethodId);
	}

	/**
	* Caches the reporting methods in the entity cache if it is enabled.
	*
	* @param reportingMethods the reporting methods
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods) {
		getPersistence().cacheResult(reportingMethods);
	}

	/**
	* Caches the reporting methodses in the entity cache if it is enabled.
	*
	* @param reportingMethodses the reporting methodses
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> reportingMethodses) {
		getPersistence().cacheResult(reportingMethodses);
	}

	/**
	* Creates a new reporting methods with the primary key. Does not add the reporting methods to the database.
	*
	* @param reportingmethodId the primary key for the new reporting methods
	* @return the new reporting methods
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods create(
		long reportingmethodId) {
		return getPersistence().create(reportingmethodId);
	}

	/**
	* Removes the reporting methods with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods remove(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence().remove(reportingmethodId);
	}

	public static com.rknowsys.eapp.hrm.model.ReportingMethods updateImpl(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reportingMethods);
	}

	/**
	* Returns the reporting methods with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchReportingMethodsException} if it could not be found.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods findByPrimaryKey(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException {
		return getPersistence().findByPrimaryKey(reportingmethodId);
	}

	/**
	* Returns the reporting methods with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods, or <code>null</code> if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ReportingMethods fetchByPrimaryKey(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reportingmethodId);
	}

	/**
	* Returns all the reporting methodses.
	*
	* @return the reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the reporting methodses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @return the range of reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the reporting methodses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reporting methodses
	* @param end the upper bound of the range of reporting methodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the reporting methodses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of reporting methodses.
	*
	* @return the number of reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReportingMethodsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReportingMethodsPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					ReportingMethodsPersistence.class.getName());

			ReferenceRegistry.registerReference(ReportingMethodsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ReportingMethodsPersistence persistence) {
	}

	private static ReportingMethodsPersistence _persistence;
}