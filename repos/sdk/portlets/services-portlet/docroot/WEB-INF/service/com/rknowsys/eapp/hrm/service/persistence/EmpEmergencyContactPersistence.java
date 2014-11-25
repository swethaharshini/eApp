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

import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;

/**
 * The persistence interface for the EmpEmergencyContact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpEmergencyContactPersistenceImpl
 * @see EmpEmergencyContactUtil
 * @generated
 */
public interface EmpEmergencyContactPersistence extends BasePersistence<EmpEmergencyContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpEmergencyContactUtil} to access the EmpEmergencyContact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @return the matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByempEmergencyContactId_First(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByempEmergencyContactId_First(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByempEmergencyContactId_Last(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByempEmergencyContactId_Last(
		long empEmergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpEmergencyContacts where empEmergencyContactId = &#63; from the database.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByempEmergencyContactId(long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpEmergencyContacts where empEmergencyContactId = &#63;.
	*
	* @param empEmergencyContactId the emp emergency contact ID
	* @return the number of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByempEmergencyContactId(long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpEmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact[] findByemployeeId_PrevAndNext(
		long empEmergencyContactId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Removes all the EmpEmergencyContacts where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpEmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the EmpEmergencyContact in the entity cache if it is enabled.
	*
	* @param empEmergencyContact the EmpEmergencyContact
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact);

	/**
	* Caches the EmpEmergencyContacts in the entity cache if it is enabled.
	*
	* @param empEmergencyContacts the EmpEmergencyContacts
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> empEmergencyContacts);

	/**
	* Creates a new EmpEmergencyContact with the primary key. Does not add the EmpEmergencyContact to the database.
	*
	* @param empEmergencyContactId the primary key for the new EmpEmergencyContact
	* @return the new EmpEmergencyContact
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact create(
		long empEmergencyContactId);

	/**
	* Removes the EmpEmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact remove(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpEmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException} if it could not be found.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact findByPrimaryKey(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;

	/**
	* Returns the EmpEmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empEmergencyContactId the primary key of the EmpEmergencyContact
	* @return the EmpEmergencyContact, or <code>null</code> if a EmpEmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpEmergencyContact fetchByPrimaryKey(
		long empEmergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpEmergencyContacts.
	*
	* @return the EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpEmergencyContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpEmergencyContacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpEmergencyContacts.
	*
	* @return the number of EmpEmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}