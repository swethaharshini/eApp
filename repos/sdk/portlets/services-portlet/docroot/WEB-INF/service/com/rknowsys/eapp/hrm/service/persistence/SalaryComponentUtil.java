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

import com.rknowsys.eapp.hrm.model.SalaryComponent;

import java.util.List;

/**
 * The persistence utility for the salary component service. This utility wraps {@link SalaryComponentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SalaryComponentPersistence
 * @see SalaryComponentPersistenceImpl
 * @generated
 */
public class SalaryComponentUtil {
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
	public static void clearCache(SalaryComponent salaryComponent) {
		getPersistence().clearCache(salaryComponent);
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
	public static List<SalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SalaryComponent update(SalaryComponent salaryComponent)
		throws SystemException {
		return getPersistence().update(salaryComponent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SalaryComponent update(SalaryComponent salaryComponent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(salaryComponent, serviceContext);
	}

	/**
	* Returns all the salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the salary components before and after the current salary component in the ordered set where groupId = &#63;.
	*
	* @param salaryComponentId the primary key of the current salary component
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent[] findByGroupId_PrevAndNext(
		long salaryComponentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(salaryComponentId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the salary components where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the salary components where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @return the matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysalaryComponentId(salaryComponentId);
	}

	/**
	* Returns a range of all the salary components where salaryComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param salaryComponentId the salary component ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysalaryComponentId(salaryComponentId, start, end);
	}

	/**
	* Returns an ordered range of all the salary components where salaryComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param salaryComponentId the salary component ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysalaryComponentId(salaryComponentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent findBysalaryComponentId_First(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence()
				   .findBysalaryComponentId_First(salaryComponentId,
			orderByComparator);
	}

	/**
	* Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent fetchBysalaryComponentId_First(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysalaryComponentId_First(salaryComponentId,
			orderByComparator);
	}

	/**
	* Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent findBysalaryComponentId_Last(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence()
				   .findBysalaryComponentId_Last(salaryComponentId,
			orderByComparator);
	}

	/**
	* Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent fetchBysalaryComponentId_Last(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysalaryComponentId_Last(salaryComponentId,
			orderByComparator);
	}

	/**
	* Removes all the salary components where salaryComponentId = &#63; from the database.
	*
	* @param salaryComponentId the salary component ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysalaryComponentId(long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysalaryComponentId(salaryComponentId);
	}

	/**
	* Returns the number of salary components where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @return the number of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysalaryComponentId(long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysalaryComponentId(salaryComponentId);
	}

	/**
	* Caches the salary component in the entity cache if it is enabled.
	*
	* @param salaryComponent the salary component
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent) {
		getPersistence().cacheResult(salaryComponent);
	}

	/**
	* Caches the salary components in the entity cache if it is enabled.
	*
	* @param salaryComponents the salary components
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> salaryComponents) {
		getPersistence().cacheResult(salaryComponents);
	}

	/**
	* Creates a new salary component with the primary key. Does not add the salary component to the database.
	*
	* @param salaryComponentId the primary key for the new salary component
	* @return the new salary component
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent create(
		long salaryComponentId) {
		return getPersistence().create(salaryComponentId);
	}

	/**
	* Removes the salary component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent remove(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence().remove(salaryComponentId);
	}

	public static com.rknowsys.eapp.hrm.model.SalaryComponent updateImpl(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(salaryComponent);
	}

	/**
	* Returns the salary component with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSalaryComponentException} if it could not be found.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent findByPrimaryKey(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException {
		return getPersistence().findByPrimaryKey(salaryComponentId);
	}

	/**
	* Returns the salary component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component, or <code>null</code> if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.SalaryComponent fetchByPrimaryKey(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(salaryComponentId);
	}

	/**
	* Returns all the salary components.
	*
	* @return the salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the salary components from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of salary components.
	*
	* @return the number of salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SalaryComponentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SalaryComponentPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					SalaryComponentPersistence.class.getName());

			ReferenceRegistry.registerReference(SalaryComponentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SalaryComponentPersistence persistence) {
	}

	private static SalaryComponentPersistence _persistence;
}