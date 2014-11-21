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

import com.rknowsys.eapp.hrm.model.TerminationReasons;

/**
 * The persistence interface for the termination reasons service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see TerminationReasonsPersistenceImpl
 * @see TerminationReasonsUtil
 * @generated
 */
public interface TerminationReasonsPersistence extends BasePersistence<TerminationReasons> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TerminationReasonsUtil} to access the termination reasons persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the termination reasons in the entity cache if it is enabled.
	*
	* @param terminationReasons the termination reasons
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons);

	/**
	* Caches the termination reasonses in the entity cache if it is enabled.
	*
	* @param terminationReasonses the termination reasonses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> terminationReasonses);

	/**
	* Creates a new termination reasons with the primary key. Does not add the termination reasons to the database.
	*
	* @param terminationreasonsId the primary key for the new termination reasons
	* @return the new termination reasons
	*/
	public com.rknowsys.eapp.hrm.model.TerminationReasons create(
		long terminationreasonsId);

	/**
	* Removes the termination reasons with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.TerminationReasons remove(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException;

	public com.rknowsys.eapp.hrm.model.TerminationReasons updateImpl(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the termination reasons with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException} if it could not be found.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons
	* @throws com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.TerminationReasons findByPrimaryKey(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchTerminationReasonsException;

	/**
	* Returns the termination reasons with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons, or <code>null</code> if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.TerminationReasons fetchByPrimaryKey(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the termination reasonses.
	*
	* @return the termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the termination reasonses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of termination reasonses.
	*
	* @return the number of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}