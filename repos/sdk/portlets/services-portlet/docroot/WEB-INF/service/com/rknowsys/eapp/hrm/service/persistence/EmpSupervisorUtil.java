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

import com.rknowsys.eapp.hrm.model.EmpSupervisor;

import java.util.List;

/**
 * The persistence utility for the EmpSupervisor service. This utility wraps {@link EmpSupervisorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSupervisorPersistence
 * @see EmpSupervisorPersistenceImpl
 * @generated
 */
public class EmpSupervisorUtil {
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
	public static void clearCache(EmpSupervisor empSupervisor) {
		getPersistence().clearCache(empSupervisor);
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
	public static List<EmpSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpSupervisor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpSupervisor update(EmpSupervisor empSupervisor)
		throws SystemException {
		return getPersistence().update(empSupervisor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpSupervisor update(EmpSupervisor empSupervisor,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empSupervisor, serviceContext);
	}

	/**
	* Caches the EmpSupervisor in the entity cache if it is enabled.
	*
	* @param empSupervisor the EmpSupervisor
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor) {
		getPersistence().cacheResult(empSupervisor);
	}

	/**
	* Caches the EmpSupervisors in the entity cache if it is enabled.
	*
	* @param empSupervisors the EmpSupervisors
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpSupervisor> empSupervisors) {
		getPersistence().cacheResult(empSupervisors);
	}

	/**
	* Creates a new EmpSupervisor with the primary key. Does not add the EmpSupervisor to the database.
	*
	* @param empSupervisorId the primary key for the new EmpSupervisor
	* @return the new EmpSupervisor
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSupervisor create(
		long empSupervisorId) {
		return getPersistence().create(empSupervisorId);
	}

	/**
	* Removes the EmpSupervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSupervisorId the primary key of the EmpSupervisor
	* @return the EmpSupervisor that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSupervisor remove(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException {
		return getPersistence().remove(empSupervisorId);
	}

	public static com.rknowsys.eapp.hrm.model.EmpSupervisor updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empSupervisor);
	}

	/**
	* Returns the EmpSupervisor with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException} if it could not be found.
	*
	* @param empSupervisorId the primary key of the EmpSupervisor
	* @return the EmpSupervisor
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSupervisor findByPrimaryKey(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException {
		return getPersistence().findByPrimaryKey(empSupervisorId);
	}

	/**
	* Returns the EmpSupervisor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empSupervisorId the primary key of the EmpSupervisor
	* @return the EmpSupervisor, or <code>null</code> if a EmpSupervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSupervisor fetchByPrimaryKey(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empSupervisorId);
	}

	/**
	* Returns all the EmpSupervisors.
	*
	* @return the EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSupervisor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the EmpSupervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSupervisors
	* @param end the upper bound of the range of EmpSupervisors (not inclusive)
	* @return the range of EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSupervisor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the EmpSupervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSupervisors
	* @param end the upper bound of the range of EmpSupervisors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSupervisor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the EmpSupervisors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of EmpSupervisors.
	*
	* @return the number of EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpSupervisorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpSupervisorPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpSupervisorPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpSupervisorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpSupervisorPersistence persistence) {
	}

	private static EmpSupervisorPersistence _persistence;
}