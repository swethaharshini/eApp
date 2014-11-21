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

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HolidayLocalService}.
 *
 * @author rknowsys
 * @see HolidayLocalService
 * @generated
 */
public class HolidayLocalServiceWrapper implements HolidayLocalService,
	ServiceWrapper<HolidayLocalService> {
	public HolidayLocalServiceWrapper(HolidayLocalService holidayLocalService) {
		_holidayLocalService = holidayLocalService;
	}

	/**
	* Adds the Holiday to the database. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday addHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.addHoliday(holiday);
	}

	/**
	* Creates a new Holiday with the primary key. Does not add the Holiday to the database.
	*
	* @param holidayId the primary key for the new Holiday
	* @return the new Holiday
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday createHoliday(long holidayId) {
		return _holidayLocalService.createHoliday(holidayId);
	}

	/**
	* Deletes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday that was removed
	* @throws PortalException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday deleteHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.deleteHoliday(holidayId);
	}

	/**
	* Deletes the Holiday from the database. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday deleteHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.deleteHoliday(holiday);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _holidayLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Holiday fetchHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.fetchHoliday(holidayId);
	}

	/**
	* Returns the Holiday with the primary key.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday
	* @throws PortalException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday getHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getHoliday(holidayId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getHolidaies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getHolidaies(start, end);
	}

	/**
	* Returns the number of Holidaies.
	*
	* @return the number of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHolidaiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getHolidaiesCount();
	}

	/**
	* Updates the Holiday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Holiday updateHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.updateHoliday(holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.addLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLocationHoliday(long locationId,
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.addLocationHoliday(locationId, holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLocationHolidaies(long locationId, long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.addLocationHolidaies(locationId, holidayIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLocationHolidaies(long locationId,
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> Holidaies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.addLocationHolidaies(locationId, Holidaies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearLocationHolidaies(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.clearLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.deleteLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLocationHoliday(long locationId,
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.deleteLocationHoliday(locationId, holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLocationHolidaies(long locationId, long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.deleteLocationHolidaies(locationId, holidayIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLocationHolidaies(long locationId,
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> Holidaies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.deleteLocationHolidaies(locationId, Holidaies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getLocationHolidaies(locationId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getLocationHolidaies(locationId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLocationHolidaiesCount(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.getLocationHolidaiesCount(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.hasLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLocationHolidaies(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _holidayLocalService.hasLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setLocationHolidaies(long locationId, long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_holidayLocalService.setLocationHolidaies(locationId, holidayIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _holidayLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_holidayLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _holidayLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getSearchHolidays(
		java.util.Date fromDate, java.util.Date toDate, long nationalityId,
		java.util.List<java.lang.Long> locationIds) {
		return _holidayLocalService.getSearchHolidays(fromDate, toDate,
			nationalityId, locationIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HolidayLocalService getWrappedHolidayLocalService() {
		return _holidayLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHolidayLocalService(
		HolidayLocalService holidayLocalService) {
		_holidayLocalService = holidayLocalService;
	}

	@Override
	public HolidayLocalService getWrappedService() {
		return _holidayLocalService;
	}

	@Override
	public void setWrappedService(HolidayLocalService holidayLocalService) {
		_holidayLocalService = holidayLocalService;
	}

	private HolidayLocalService _holidayLocalService;
}