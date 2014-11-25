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

import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;

/**
 * The persistence interface for the EmpPersonalDetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpPersonalDetailsPersistenceImpl
 * @see EmpPersonalDetailsUtil
 * @generated
 */
public interface EmpPersonalDetailsPersistence extends BasePersistence<EmpPersonalDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpPersonalDetailsUtil} to access the EmpPersonalDetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EmpPersonalDetailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpPersonalDetailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpPersonalDetailses
	* @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	* @return the range of matching EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpPersonalDetailses where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpPersonalDetailses
	* @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpPersonalDetails in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpPersonalDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a matching EmpPersonalDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;

	/**
	* Returns the first EmpPersonalDetails in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpPersonalDetails, or <code>null</code> if a matching EmpPersonalDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpPersonalDetails in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpPersonalDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a matching EmpPersonalDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;

	/**
	* Returns the last EmpPersonalDetails in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpPersonalDetails, or <code>null</code> if a matching EmpPersonalDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpPersonalDetailses before and after the current EmpPersonalDetails in the ordered set where employeeId = &#63;.
	*
	* @param empPersonalDetailsId the primary key of the current EmpPersonalDetails
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EmpPersonalDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails[] findByemployeeId_PrevAndNext(
		long empPersonalDetailsId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;

	/**
	* Removes all the EmpPersonalDetailses where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpPersonalDetailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the EmpPersonalDetails in the entity cache if it is enabled.
	*
	* @param empPersonalDetails the EmpPersonalDetails
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpPersonalDetails empPersonalDetails);

	/**
	* Caches the EmpPersonalDetailses in the entity cache if it is enabled.
	*
	* @param empPersonalDetailses the EmpPersonalDetailses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> empPersonalDetailses);

	/**
	* Creates a new EmpPersonalDetails with the primary key. Does not add the EmpPersonalDetails to the database.
	*
	* @param empPersonalDetailsId the primary key for the new EmpPersonalDetails
	* @return the new EmpPersonalDetails
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails create(
		long empPersonalDetailsId);

	/**
	* Removes the EmpPersonalDetails with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	* @return the EmpPersonalDetails that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails remove(
		long empPersonalDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;

	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails updateImpl(
		com.rknowsys.eapp.hrm.model.EmpPersonalDetails empPersonalDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpPersonalDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException} if it could not be found.
	*
	* @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	* @return the EmpPersonalDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails findByPrimaryKey(
		long empPersonalDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;

	/**
	* Returns the EmpPersonalDetails with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	* @return the EmpPersonalDetails, or <code>null</code> if a EmpPersonalDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpPersonalDetails fetchByPrimaryKey(
		long empPersonalDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpPersonalDetailses.
	*
	* @return the EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpPersonalDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpPersonalDetailses
	* @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	* @return the range of EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpPersonalDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpPersonalDetailses
	* @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpPersonalDetailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpPersonalDetailses.
	*
	* @return the number of EmpPersonalDetailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}