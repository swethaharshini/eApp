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

import com.rknowsys.eapp.hrm.model.EmpSubordinate;

/**
 * The persistence interface for the EmpSubordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSubordinatePersistenceImpl
 * @see EmpSubordinateUtil
 * @generated
 */
public interface EmpSubordinatePersistence extends BasePersistence<EmpSubordinate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpSubordinateUtil} to access the EmpSubordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the EmpSubordinate in the entity cache if it is enabled.
	*
	* @param empSubordinate the EmpSubordinate
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate);

	/**
	* Caches the EmpSubordinates in the entity cache if it is enabled.
	*
	* @param empSubordinates the EmpSubordinates
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpSubordinate> empSubordinates);

	/**
	* Creates a new EmpSubordinate with the primary key. Does not add the EmpSubordinate to the database.
	*
	* @param empSubordinateId the primary key for the new EmpSubordinate
	* @return the new EmpSubordinate
	*/
	public com.rknowsys.eapp.hrm.model.EmpSubordinate create(
		long empSubordinateId);

	/**
	* Removes the EmpSubordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSubordinateId the primary key of the EmpSubordinate
	* @return the EmpSubordinate that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpSubordinate remove(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException;

	public com.rknowsys.eapp.hrm.model.EmpSubordinate updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpSubordinate with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException} if it could not be found.
	*
	* @param empSubordinateId the primary key of the EmpSubordinate
	* @return the EmpSubordinate
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpSubordinate findByPrimaryKey(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException;

	/**
	* Returns the EmpSubordinate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empSubordinateId the primary key of the EmpSubordinate
	* @return the EmpSubordinate, or <code>null</code> if a EmpSubordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpSubordinate fetchByPrimaryKey(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpSubordinates.
	*
	* @return the EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSubordinate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpSubordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSubordinates
	* @param end the upper bound of the range of EmpSubordinates (not inclusive)
	* @return the range of EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSubordinate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpSubordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSubordinates
	* @param end the upper bound of the range of EmpSubordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSubordinate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpSubordinates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpSubordinates.
	*
	* @return the number of EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}