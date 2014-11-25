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

import com.rknowsys.eapp.hrm.model.EmpSalaryComponent;

import java.util.List;

/**
 * The persistence utility for the emp salary component service. This utility wraps {@link EmpSalaryComponentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSalaryComponentPersistence
 * @see EmpSalaryComponentPersistenceImpl
 * @generated
 */
public class EmpSalaryComponentUtil {
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
	public static void clearCache(EmpSalaryComponent empSalaryComponent) {
		getPersistence().clearCache(empSalaryComponent);
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
	public static List<EmpSalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpSalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpSalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpSalaryComponent update(
		EmpSalaryComponent empSalaryComponent) throws SystemException {
		return getPersistence().update(empSalaryComponent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpSalaryComponent update(
		EmpSalaryComponent empSalaryComponent, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(empSalaryComponent, serviceContext);
	}

	/**
	* Returns all the emp salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the emp salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @return the range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the emp salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the emp salary components before and after the current emp salary component in the ordered set where groupId = &#63;.
	*
	* @param empSalaryEarningId the primary key of the current emp salary component
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent[] findByGroupId_PrevAndNext(
		long empSalaryEarningId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(empSalaryEarningId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the emp salary components where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of emp salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the emp salary components where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @return the matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByempSalaryEarningId(empSalaryEarningId);
	}

	/**
	* Returns a range of all the emp salary components where empSalaryEarningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @return the range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempSalaryEarningId(empSalaryEarningId, start, end);
	}

	/**
	* Returns an ordered range of all the emp salary components where empSalaryEarningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempSalaryEarningId(empSalaryEarningId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByempSalaryEarningId_First(
		long empSalaryEarningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByempSalaryEarningId_First(empSalaryEarningId,
			orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByempSalaryEarningId_First(
		long empSalaryEarningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempSalaryEarningId_First(empSalaryEarningId,
			orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByempSalaryEarningId_Last(
		long empSalaryEarningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByempSalaryEarningId_Last(empSalaryEarningId,
			orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByempSalaryEarningId_Last(
		long empSalaryEarningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempSalaryEarningId_Last(empSalaryEarningId,
			orderByComparator);
	}

	/**
	* Removes all the emp salary components where empSalaryEarningId = &#63; from the database.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByempSalaryEarningId(long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByempSalaryEarningId(empSalaryEarningId);
	}

	/**
	* Returns the number of emp salary components where empSalaryEarningId = &#63;.
	*
	* @param empSalaryEarningId the emp salary earning ID
	* @return the number of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByempSalaryEarningId(long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByempSalaryEarningId(empSalaryEarningId);
	}

	/**
	* Returns all the emp salary components where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @return the matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryId(
		long empSalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByempSalaryId(empSalaryId);
	}

	/**
	* Returns a range of all the emp salary components where empSalaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empSalaryId the emp salary ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @return the range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryId(
		long empSalaryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByempSalaryId(empSalaryId, start, end);
	}

	/**
	* Returns an ordered range of all the emp salary components where empSalaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empSalaryId the emp salary ID
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findByempSalaryId(
		long empSalaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempSalaryId(empSalaryId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByempSalaryId_First(
		long empSalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByempSalaryId_First(empSalaryId, orderByComparator);
	}

	/**
	* Returns the first emp salary component in the ordered set where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByempSalaryId_First(
		long empSalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempSalaryId_First(empSalaryId, orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByempSalaryId_Last(
		long empSalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByempSalaryId_Last(empSalaryId, orderByComparator);
	}

	/**
	* Returns the last emp salary component in the ordered set where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByempSalaryId_Last(
		long empSalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempSalaryId_Last(empSalaryId, orderByComparator);
	}

	/**
	* Returns the emp salary components before and after the current emp salary component in the ordered set where empSalaryId = &#63;.
	*
	* @param empSalaryEarningId the primary key of the current emp salary component
	* @param empSalaryId the emp salary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent[] findByempSalaryId_PrevAndNext(
		long empSalaryEarningId, long empSalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence()
				   .findByempSalaryId_PrevAndNext(empSalaryEarningId,
			empSalaryId, orderByComparator);
	}

	/**
	* Removes all the emp salary components where empSalaryId = &#63; from the database.
	*
	* @param empSalaryId the emp salary ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByempSalaryId(long empSalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByempSalaryId(empSalaryId);
	}

	/**
	* Returns the number of emp salary components where empSalaryId = &#63;.
	*
	* @param empSalaryId the emp salary ID
	* @return the number of matching emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByempSalaryId(long empSalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByempSalaryId(empSalaryId);
	}

	/**
	* Caches the emp salary component in the entity cache if it is enabled.
	*
	* @param empSalaryComponent the emp salary component
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent) {
		getPersistence().cacheResult(empSalaryComponent);
	}

	/**
	* Caches the emp salary components in the entity cache if it is enabled.
	*
	* @param empSalaryComponents the emp salary components
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> empSalaryComponents) {
		getPersistence().cacheResult(empSalaryComponents);
	}

	/**
	* Creates a new emp salary component with the primary key. Does not add the emp salary component to the database.
	*
	* @param empSalaryEarningId the primary key for the new emp salary component
	* @return the new emp salary component
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent create(
		long empSalaryEarningId) {
		return getPersistence().create(empSalaryEarningId);
	}

	/**
	* Removes the emp salary component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSalaryEarningId the primary key of the emp salary component
	* @return the emp salary component that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent remove(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence().remove(empSalaryEarningId);
	}

	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empSalaryComponent);
	}

	/**
	* Returns the emp salary component with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException} if it could not be found.
	*
	* @param empSalaryEarningId the primary key of the emp salary component
	* @return the emp salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent findByPrimaryKey(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException {
		return getPersistence().findByPrimaryKey(empSalaryEarningId);
	}

	/**
	* Returns the emp salary component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empSalaryEarningId the primary key of the emp salary component
	* @return the emp salary component, or <code>null</code> if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchByPrimaryKey(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empSalaryEarningId);
	}

	/**
	* Returns all the emp salary components.
	*
	* @return the emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @return the range of emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp salary components from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp salary components.
	*
	* @return the number of emp salary components
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpSalaryComponentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpSalaryComponentPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpSalaryComponentPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpSalaryComponentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpSalaryComponentPersistence persistence) {
	}

	private static EmpSalaryComponentPersistence _persistence;
}