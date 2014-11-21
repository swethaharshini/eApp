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

import com.rknowsys.eapp.hrm.model.WorkWeek;

import java.util.List;

/**
 * The persistence utility for the WorkWeek service. This utility wraps {@link WorkWeekPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkWeekPersistence
 * @see WorkWeekPersistenceImpl
 * @generated
 */
public class WorkWeekUtil {
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
	public static void clearCache(WorkWeek workWeek) {
		getPersistence().clearCache(workWeek);
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
	public static List<WorkWeek> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkWeek> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkWeek> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WorkWeek update(WorkWeek workWeek) throws SystemException {
		return getPersistence().update(workWeek);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WorkWeek update(WorkWeek workWeek,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workWeek, serviceContext);
	}

	/**
	* Returns all the WorkWeeks where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @return the matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNationality(nationalityId);
	}

	/**
	* Returns a range of all the WorkWeeks where nationalityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nationalityId the nationality ID
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @return the range of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNationality(nationalityId, start, end);
	}

	/**
	* Returns an ordered range of all the WorkWeeks where nationalityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nationalityId the nationality ID
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long nationalityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNationality(nationalityId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek findByNationality_First(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException {
		return getPersistence()
				   .findByNationality_First(nationalityId, orderByComparator);
	}

	/**
	* Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek fetchByNationality_First(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNationality_First(nationalityId, orderByComparator);
	}

	/**
	* Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek findByNationality_Last(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException {
		return getPersistence()
				   .findByNationality_Last(nationalityId, orderByComparator);
	}

	/**
	* Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek fetchByNationality_Last(
		long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNationality_Last(nationalityId, orderByComparator);
	}

	/**
	* Returns the WorkWeeks before and after the current WorkWeek in the ordered set where nationalityId = &#63;.
	*
	* @param workWeekId the primary key of the current WorkWeek
	* @param nationalityId the nationality ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek[] findByNationality_PrevAndNext(
		long workWeekId, long nationalityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException {
		return getPersistence()
				   .findByNationality_PrevAndNext(workWeekId, nationalityId,
			orderByComparator);
	}

	/**
	* Removes all the WorkWeeks where nationalityId = &#63; from the database.
	*
	* @param nationalityId the nationality ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNationality(long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNationality(nationalityId);
	}

	/**
	* Returns the number of WorkWeeks where nationalityId = &#63;.
	*
	* @param nationalityId the nationality ID
	* @return the number of matching WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNationality(long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNationality(nationalityId);
	}

	/**
	* Caches the WorkWeek in the entity cache if it is enabled.
	*
	* @param workWeek the WorkWeek
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek) {
		getPersistence().cacheResult(workWeek);
	}

	/**
	* Caches the WorkWeeks in the entity cache if it is enabled.
	*
	* @param workWeeks the WorkWeeks
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> workWeeks) {
		getPersistence().cacheResult(workWeeks);
	}

	/**
	* Creates a new WorkWeek with the primary key. Does not add the WorkWeek to the database.
	*
	* @param workWeekId the primary key for the new WorkWeek
	* @return the new WorkWeek
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek create(long workWeekId) {
		return getPersistence().create(workWeekId);
	}

	/**
	* Removes the WorkWeek with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek remove(long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException {
		return getPersistence().remove(workWeekId);
	}

	public static com.rknowsys.eapp.hrm.model.WorkWeek updateImpl(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workWeek);
	}

	/**
	* Returns the WorkWeek with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkWeekException} if it could not be found.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek findByPrimaryKey(
		long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkWeekException {
		return getPersistence().findByPrimaryKey(workWeekId);
	}

	/**
	* Returns the WorkWeek with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek, or <code>null</code> if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.WorkWeek fetchByPrimaryKey(
		long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workWeekId);
	}

	/**
	* Returns all the WorkWeeks.
	*
	* @return the WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WorkWeeks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @return the range of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WorkWeeks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the WorkWeeks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WorkWeeks.
	*
	* @return the number of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WorkWeekPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkWeekPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					WorkWeekPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkWeekUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkWeekPersistence persistence) {
	}

	private static WorkWeekPersistence _persistence;
}