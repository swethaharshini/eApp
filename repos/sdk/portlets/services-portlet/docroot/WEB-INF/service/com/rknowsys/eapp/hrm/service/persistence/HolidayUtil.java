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

import com.rknowsys.eapp.hrm.model.Holiday;

import java.util.List;

/**
 * The persistence utility for the Holiday service. This utility wraps {@link HolidayPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see HolidayPersistence
 * @see HolidayPersistenceImpl
 * @generated
 */
public class HolidayUtil {
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
	public static void clearCache(Holiday holiday) {
		getPersistence().clearCache(holiday);
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
	public static List<Holiday> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Holiday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Holiday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Holiday update(Holiday holiday) throws SystemException {
		return getPersistence().update(holiday);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Holiday update(Holiday holiday, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(holiday, serviceContext);
	}

	/**
	* Caches the Holiday in the entity cache if it is enabled.
	*
	* @param holiday the Holiday
	*/
	public static void cacheResult(com.rknowsys.eapp.hrm.model.Holiday holiday) {
		getPersistence().cacheResult(holiday);
	}

	/**
	* Caches the Holidaies in the entity cache if it is enabled.
	*
	* @param holidaies the Holidaies
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> holidaies) {
		getPersistence().cacheResult(holidaies);
	}

	/**
	* Creates a new Holiday with the primary key. Does not add the Holiday to the database.
	*
	* @param holidayId the primary key for the new Holiday
	* @return the new Holiday
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday create(long holidayId) {
		return getPersistence().create(holidayId);
	}

	/**
	* Removes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday remove(long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchHolidayException {
		return getPersistence().remove(holidayId);
	}

	public static com.rknowsys.eapp.hrm.model.Holiday updateImpl(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(holiday);
	}

	/**
	* Returns the Holiday with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchHolidayException} if it could not be found.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday
	* @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday findByPrimaryKey(
		long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchHolidayException {
		return getPersistence().findByPrimaryKey(holidayId);
	}

	/**
	* Returns the Holiday with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday, or <code>null</code> if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday fetchByPrimaryKey(
		long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(holidayId);
	}

	/**
	* Returns all the Holidaies.
	*
	* @return the Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Holidaies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Holidaies.
	*
	* @return the number of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the locations associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @return the locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLocations(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLocations(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Location> getLocations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLocations(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of locations associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @return the number of locations associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public static int getLocationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLocationsSize(pk);
	}

	/**
	* Returns <code>true</code> if the location is associated with the Holiday.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @return <code>true</code> if the location is associated with the Holiday; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsLocation(pk, locationPK);
	}

	/**
	* Returns <code>true</code> if the Holiday has any locations associated with it.
	*
	* @param pk the primary key of the Holiday to check for associations with locations
	* @return <code>true</code> if the Holiday has any locations associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLocations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsLocations(pk);
	}

	/**
	* Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLocation(pk, locationPK);
	}

	/**
	* Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param location the location
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLocation(pk, location);
	}

	/**
	* Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLocations(pk, locationPKs);
	}

	/**
	* Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLocations(pk, locations);
	}

	/**
	* Clears all associations between the Holiday and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday to clear the associated locations from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLocations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearLocations(pk);
	}

	/**
	* Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPK the primary key of the location
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLocation(long pk, long locationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLocation(pk, locationPK);
	}

	/**
	* Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param location the location
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLocation(pk, location);
	}

	/**
	* Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLocations(pk, locationPKs);
	}

	/**
	* Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLocations(pk, locations);
	}

	/**
	* Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locationPKs the primary keys of the locations to be associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public static void setLocations(long pk, long[] locationPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLocations(pk, locationPKs);
	}

	/**
	* Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Holiday
	* @param locations the locations to be associated with the Holiday
	* @throws SystemException if a system exception occurred
	*/
	public static void setLocations(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLocations(pk, locations);
	}

	public static HolidayPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HolidayPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					HolidayPersistence.class.getName());

			ReferenceRegistry.registerReference(HolidayUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HolidayPersistence persistence) {
	}

	private static HolidayPersistence _persistence;
}