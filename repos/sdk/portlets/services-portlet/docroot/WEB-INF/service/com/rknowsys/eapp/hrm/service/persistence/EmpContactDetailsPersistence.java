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

import com.rknowsys.eapp.hrm.model.EmpContactDetails;

/**
 * The persistence interface for the EmpContactDetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpContactDetailsPersistenceImpl
 * @see EmpContactDetailsUtil
 * @generated
 */
public interface EmpContactDetailsPersistence extends BasePersistence<EmpContactDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpContactDetailsUtil} to access the EmpContactDetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the EmpContactDetails in the entity cache if it is enabled.
	*
	* @param empContactDetails the EmpContactDetails
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails);

	/**
	* Caches the EmpContactDetailses in the entity cache if it is enabled.
	*
	* @param empContactDetailses the EmpContactDetailses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpContactDetails> empContactDetailses);

	/**
	* Creates a new EmpContactDetails with the primary key. Does not add the EmpContactDetails to the database.
	*
	* @param empContactDetailsId the primary key for the new EmpContactDetails
	* @return the new EmpContactDetails
	*/
	public com.rknowsys.eapp.hrm.model.EmpContactDetails create(
		long empContactDetailsId);

	/**
	* Removes the EmpContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empContactDetailsId the primary key of the EmpContactDetails
	* @return the EmpContactDetails that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpContactDetails remove(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException;

	public com.rknowsys.eapp.hrm.model.EmpContactDetails updateImpl(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpContactDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException} if it could not be found.
	*
	* @param empContactDetailsId the primary key of the EmpContactDetails
	* @return the EmpContactDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpContactDetails findByPrimaryKey(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException;

	/**
	* Returns the EmpContactDetails with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empContactDetailsId the primary key of the EmpContactDetails
	* @return the EmpContactDetails, or <code>null</code> if a EmpContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpContactDetails fetchByPrimaryKey(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpContactDetailses.
	*
	* @return the EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpContactDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpContactDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpContactDetailses
	* @param end the upper bound of the range of EmpContactDetailses (not inclusive)
	* @return the range of EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpContactDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpContactDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpContactDetailses
	* @param end the upper bound of the range of EmpContactDetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpContactDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpContactDetailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpContactDetailses.
	*
	* @return the number of EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}