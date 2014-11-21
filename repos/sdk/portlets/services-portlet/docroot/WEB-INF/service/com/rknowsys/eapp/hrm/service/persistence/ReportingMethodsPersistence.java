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

import com.rknowsys.eapp.hrm.model.ReportingMethods;

/**
 * The persistence interface for the reporting methods service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethodsPersistenceImpl
 * @see ReportingMethodsUtil
 * @generated
 */
public interface ReportingMethodsPersistence extends BasePersistence<ReportingMethods> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportingMethodsUtil} to access the reporting methods persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the reporting methodses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Returns the first reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Returns the last reporting methods in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rknowsys.eapp.hrm.model.ReportingMethods[] findByGroupId_PrevAndNext(
		long reportingmethodId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Removes all the reporting methodses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reporting methodses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reporting methodses where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @return the matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods findByreportingmethodId_First(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods fetchByreportingmethodId_First(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods findByreportingmethodId_Last(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods fetchByreportingmethodId_Last(
		long reportingmethodId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reporting methodses where reportingmethodId = &#63; from the database.
	*
	* @param reportingmethodId the reportingmethod ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByreportingmethodId(long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reporting methodses where reportingmethodId = &#63;.
	*
	* @param reportingmethodId the reportingmethod ID
	* @return the number of matching reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public int countByreportingmethodId(long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the reporting methods in the entity cache if it is enabled.
	*
	* @param reportingMethods the reporting methods
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods);

	/**
	* Caches the reporting methodses in the entity cache if it is enabled.
	*
	* @param reportingMethodses the reporting methodses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> reportingMethodses);

	/**
	* Creates a new reporting methods with the primary key. Does not add the reporting methods to the database.
	*
	* @param reportingmethodId the primary key for the new reporting methods
	* @return the new reporting methods
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods create(
		long reportingmethodId);

	/**
	* Removes the reporting methods with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods remove(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	public com.rknowsys.eapp.hrm.model.ReportingMethods updateImpl(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the reporting methods with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchReportingMethodsException} if it could not be found.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods
	* @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods findByPrimaryKey(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;

	/**
	* Returns the reporting methods with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportingmethodId the primary key of the reporting methods
	* @return the reporting methods, or <code>null</code> if a reporting methods with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ReportingMethods fetchByPrimaryKey(
		long reportingmethodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reporting methodses.
	*
	* @return the reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.ReportingMethods> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reporting methodses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reporting methodses.
	*
	* @return the number of reporting methodses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}