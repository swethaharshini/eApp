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

import com.rknowsys.eapp.hrm.model.TerminationReasons;

import java.util.List;

/**
 * The persistence utility for the termination reasons service. This utility wraps {@link TerminationReasonsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see TerminationReasonsPersistence
 * @see TerminationReasonsPersistenceImpl
 * @generated
 */
public class TerminationReasonsUtil {
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
	public static void clearCache(TerminationReasons terminationReasons) {
		getPersistence().clearCache(terminationReasons);
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
	public static List<TerminationReasons> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TerminationReasons> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TerminationReasons> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TerminationReasons update(
		TerminationReasons terminationReasons) throws SystemException {
		return getPersistence().update(terminationReasons);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TerminationReasons update(
		TerminationReasons terminationReasons, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(terminationReasons, serviceContext);
	}

	/**
	* Caches the termination reasons in the entity cache if it is enabled.
	*
	* @param terminationReasons the termination reasons
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons) {
		getPersistence().cacheResult(terminationReasons);
	}

	/**
	* Caches the termination reasonses in the entity cache if it is enabled.
	*
	* @param terminationReasonses the termination reasonses
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> terminationReasonses) {
		getPersistence().cacheResult(terminationReasonses);
	}

	/**
	* Creates a new termination reasons with the primary key. Does not add the termination reasons to the database.
	*
	* @param terminationreasonsId the primary key for the new termination reasons
	* @return the new termination reasons
	*/
	public static com.rknowsys.eapp.hrm.model.TerminationReasons create(
		long terminationreasonsId) {
		return getPersistence().create(terminationreasonsId);
	}

	/**
	* Removes the termination reasons with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.TerminationReasons remove(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException {
		return getPersistence().remove(terminationreasonsId);
	}

	public static com.rknowsys.eapp.hrm.model.TerminationReasons updateImpl(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(terminationReasons);
	}

	/**
	* Returns the termination reasons with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException} if it could not be found.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons
	* @throws com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.TerminationReasons findByPrimaryKey(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException {
		return getPersistence().findByPrimaryKey(terminationreasonsId);
	}

	/**
	* Returns the termination reasons with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons, or <code>null</code> if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.TerminationReasons fetchByPrimaryKey(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(terminationreasonsId);
	}

	/**
	* Returns all the termination reasonses.
	*
	* @return the termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the termination reasonses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.TerminationReasonsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of termination reasonses
	* @param end the upper bound of the range of termination reasonses (not inclusive)
	* @return the range of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the termination reasonses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.TerminationReasonsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of termination reasonses
	* @param end the upper bound of the range of termination reasonses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the termination reasonses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of termination reasonses.
	*
	* @return the number of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TerminationReasonsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TerminationReasonsPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					TerminationReasonsPersistence.class.getName());

			ReferenceRegistry.registerReference(TerminationReasonsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TerminationReasonsPersistence persistence) {
	}

	private static TerminationReasonsPersistence _persistence;
}