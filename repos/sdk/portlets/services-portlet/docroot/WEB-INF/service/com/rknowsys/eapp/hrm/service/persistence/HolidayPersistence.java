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

import com.rknowsys.eapp.hrm.model.Holiday;

/**
 * The persistence interface for the Holiday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see HolidayPersistenceImpl
 * @see HolidayUtil
 * @generated
 */
public interface HolidayPersistence extends BasePersistence<Holiday> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HolidayUtil} to access the Holiday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Holiday in the entity cache if it is enabled.
	*
	* @param holiday the Holiday
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Holiday holiday);

	/**
	* Caches the Holidaies in the entity cache if it is enabled.
	*
	* @param holidaies the Holidaies
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> holidaies);

	/**
	* Creates a new Holiday with the primary key. Does not add the Holiday to the database.
	*
	* @param holidayId the primary key for the new Holiday
	* @return the new Holiday
	*/
	public com.rknowsys.eapp.hrm.model.Holiday create(long holidayId);

	/**
	* Removes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Holiday remove(long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchHolidayException;

	public com.rknowsys.eapp.hrm.model.Holiday updateImpl(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Holiday with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchHolidayException} if it could not be found.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday
	* @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Holiday findByPrimaryKey(long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchHolidayException;

	/**
	* Returns the Holiday with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday, or <code>null</code> if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Holiday fetchByPrimaryKey(long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Holidaies.
	*
	* @return the Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Holidaies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Holidaies
	* @param end the upper bound of the range of Holidaies (not inclusive)
	* @return the range of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Holidaies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Holidaies
	* @param end the upper bound of the range of Holidaies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Holidaies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Holidaies.
	*
	* @return the number of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the locations associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @return the locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the locations associated with the Holiday.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the Holiday
	* @param start the lower bound of the range of Holidaies
	* @param end the upper bound of the range of Holidaies (not inclusive)
	* @return the range of locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the locations associated with the Holiday.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the Holiday
	* @param start the lower bound of the range of Holidaies
	* @param end the upper bound of the range of Holidaies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of locations associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @return the number of locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public int getLocationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the location is associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @return <code>true</code> if the location is associated with the Holiday; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Holiday has any locations associated with it.
	*
	* @param pk the primary key of the Holiday to check for associations with locations
	* @return <code>true</code> if the Holiday has any locations associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLocations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @throws SystemException if a system exception occurred
	*/
	public void addLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param location the location
	* @throws SystemException if a system exception occurred
	*/
	public void addLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations
	* @throws SystemException if a system exception occurred
	*/
	public void addLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations
	* @throws SystemException if a system exception occurred
	*/
	public void addLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the Holiday and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday to clear the associated locations from
	* @throws SystemException if a system exception occurred
	*/
	public void clearLocations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @throws SystemException if a system exception occurred
	*/
	public void removeLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param location the location
	* @throws SystemException if a system exception occurred
	*/
	public void removeLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations
	* @throws SystemException if a system exception occurred
	*/
	public void removeLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations
	* @throws SystemException if a system exception occurred
	*/
	public void removeLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations to be associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public void setLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations to be associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public void setLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException;
}