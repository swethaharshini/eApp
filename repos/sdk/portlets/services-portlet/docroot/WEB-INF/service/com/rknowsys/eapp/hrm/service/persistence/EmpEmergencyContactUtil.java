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

import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;

import java.util.List;

/**
 * The persistence utility for the EmpEmergencyContact service. This utility wraps {@link EmpEmergencyContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpEmergencyContactPersistence
 * @see EmpEmergencyContactPersistenceImpl
 * @generated
 */
public class EmpEmergencyContactUtil {
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
	public static void clearCache(EmpEmergencyContact empEmergencyContact) {
		getPersistence().clearCache(empEmergencyContact);
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
	public static List<EmpEmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpEmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpEmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpEmergencyContact update(
		EmpEmergencyContact empEmergencyContact) throws SystemException {
		return getPersistence().update(empEmergencyContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpEmergencyContact update(
		EmpEmergencyContact empEmergencyContact, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(empEmergencyContact, serviceContext);
	}

	/**
	* Returns all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @return the matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempEmergencyContactId(empEmergencyContactId);
	}

	/**
	* Returns a range of all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @return the range of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempEmergencyContactId(empEmergencyContactId, start,
			end);
	}

	/**
	* Returns an ordered range of all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempEmergencyContactId(empEmergencyContactId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByempEmergencyContactId_First(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence()
				   .findByempEmergencyContactId_First(empEmergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByempEmergencyContactId_First(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempEmergencyContactId_First(empEmergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByempEmergencyContactId_Last(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence()
				   .findByempEmergencyContactId_Last(empEmergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByempEmergencyContactId_Last(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempEmergencyContactId_Last(empEmergencyContactId,
			orderByComparator);
	}

	/**
	* Removes all the EmpEmergencyContacts where empEmergencyContactId = &#63; from the database.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByempEmergencyContactId(long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByempEmergencyContactId(empEmergencyContactId);
	}

	/**
	* Returns the number of EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @return the number of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByempEmergencyContactId(long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByempEmergencyContactId(empEmergencyContactId);
	}

	/**
	* Returns all the EmpEmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the EmpEmergencyContacts where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @return the range of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the EmpEmergencyContacts where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the EmpEmergencyContacts before and after the current EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param empEmergencyContactId the primary key of the current EmpEmergencyContact
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact[] findByemployeeId_PrevAndNext(
		long empEmergencyContactId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(empEmergencyContactId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the EmpEmergencyContacts where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of EmpEmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Caches the EmpEmergencyContact in the entity cache if it is enabled.
	*
	* @param empEmergencyContact the EmpEmergencyContact
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact) {
		getPersistence().cacheResult(empEmergencyContact);
	}

	/**
	* Caches the EmpEmergencyContacts in the entity cache if it is enabled.
	*
	* @param empEmergencyContacts the EmpEmergencyContacts
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> empEmergencyContacts) {
		getPersistence().cacheResult(empEmergencyContacts);
	}

	/**
	* Creates a new EmpEmergencyContact with the primary key. Does not add the EmpEmergencyContact to the database.
	*
	* @param empEmergencyContactId the primary key for the new EmpEmergencyContact
	* @return the new EmpEmergencyContact
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact create(
		long empEmergencyContactId) {
		return getPersistence().create(empEmergencyContactId);
	}

	/**
	* Removes the EmpEmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact remove(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence().remove(empEmergencyContactId);
	}

	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empEmergencyContact);
	}

	/**
	* Returns the EmpEmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException} if it could not be found.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByPrimaryKey(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException {
		return getPersistence().findByPrimaryKey(empEmergencyContactId);
	}

	/**
	* Returns the EmpEmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact, or <code>null</code> if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByPrimaryKey(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empEmergencyContactId);
	}

	/**
	* Returns all the EmpEmergencyContacts.
	*
	* @return the EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the EmpEmergencyContacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @return the range of EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the EmpEmergencyContacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpEmergencyContacts
	* @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the EmpEmergencyContacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of EmpEmergencyContacts.
	*
	* @return the number of EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpEmergencyContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpEmergencyContactPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpEmergencyContactPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpEmergencyContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpEmergencyContactPersistence persistence) {
	}

	private static EmpEmergencyContactPersistence _persistence;
}