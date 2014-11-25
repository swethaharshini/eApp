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

import com.rknowsys.eapp.hrm.model.EmpWorkExp;

/**
 * The persistence interface for the EmpWorkExp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpWorkExpPersistenceImpl
 * @see EmpWorkExpUtil
 * @generated
 */
public interface EmpWorkExpPersistence extends BasePersistence<EmpWorkExp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpWorkExpUtil} to access the EmpWorkExp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EmpWorkExps where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpWorkExps where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @return the range of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpWorkExps where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpWorkExp in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Returns the first EmpWorkExp in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpWorkExp in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Returns the last EmpWorkExp in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpWorkExps before and after the current EmpWorkExp in the ordered set where employeeId = &#63;.
	*
	* @param empWorkExpId the primary key of the current EmpWorkExp
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp[] findByemployeeId_PrevAndNext(
		long empWorkExpId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Removes all the EmpWorkExps where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpWorkExps where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpWorkExps where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @return the matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByempWorkExpId(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpWorkExps where empWorkExpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empWorkExpId the emp work exp ID
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @return the range of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByempWorkExpId(
		long empWorkExpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpWorkExps where empWorkExpId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empWorkExpId the emp work exp ID
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findByempWorkExpId(
		long empWorkExpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp findByempWorkExpId_First(
		long empWorkExpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Returns the first EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchByempWorkExpId_First(
		long empWorkExpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp findByempWorkExpId_Last(
		long empWorkExpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Returns the last EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchByempWorkExpId_Last(
		long empWorkExpId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpWorkExps where empWorkExpId = &#63; from the database.
	*
	* @param empWorkExpId the emp work exp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByempWorkExpId(long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpWorkExps where empWorkExpId = &#63;.
	*
	* @param empWorkExpId the emp work exp ID
	* @return the number of matching EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public int countByempWorkExpId(long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the EmpWorkExp in the entity cache if it is enabled.
	*
	* @param empWorkExp the EmpWorkExp
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp);

	/**
	* Caches the EmpWorkExps in the entity cache if it is enabled.
	*
	* @param empWorkExps the EmpWorkExps
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> empWorkExps);

	/**
	* Creates a new EmpWorkExp with the primary key. Does not add the EmpWorkExp to the database.
	*
	* @param empWorkExpId the primary key for the new EmpWorkExp
	* @return the new EmpWorkExp
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp create(long empWorkExpId);

	/**
	* Removes the EmpWorkExp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empWorkExpId the primary key of the EmpWorkExp
	* @return the EmpWorkExp that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp remove(long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	public com.rknowsys.eapp.hrm.model.EmpWorkExp updateImpl(
		com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpWorkExp with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException} if it could not be found.
	*
	* @param empWorkExpId the primary key of the EmpWorkExp
	* @return the EmpWorkExp
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp findByPrimaryKey(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;

	/**
	* Returns the EmpWorkExp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empWorkExpId the primary key of the EmpWorkExp
	* @return the EmpWorkExp, or <code>null</code> if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchByPrimaryKey(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpWorkExps.
	*
	* @return the EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpWorkExps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @return the range of EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpWorkExps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpWorkExps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpWorkExps.
	*
	* @return the number of EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}