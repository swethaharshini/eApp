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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Holiday. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.HolidayLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see HolidayLocalService
 * @see com.rknowsys.eapp.hrm.service.base.HolidayLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.HolidayLocalServiceImpl
 * @generated
 */
public class HolidayLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.HolidayLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the Holiday to the database. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday addHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHoliday(holiday);
	}

	/**
	* Creates a new Holiday with the primary key. Does not add the Holiday to the database.
	*
	* @param holidayId the primary key for the new Holiday
	* @return the new Holiday
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday createHoliday(
		long holidayId) {
		return getService().createHoliday(holidayId);
	}

	/**
	* Deletes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday that was removed
	* @throws PortalException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday deleteHoliday(
		long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHoliday(holidayId);
	}

	/**
	* Deletes the Holiday from the database. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday deleteHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHoliday(holiday);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rknowsys.eapp.hrm.model.Holiday fetchHoliday(
		long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHoliday(holidayId);
	}

	/**
	* Returns the Holiday with the primary key.
	*
	* @param holidayId the primary key of the Holiday
	* @return the Holiday
	* @throws PortalException if a Holiday with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday getHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHoliday(holidayId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getHolidaies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHolidaies(start, end);
	}

	/**
	* Returns the number of Holidaies.
	*
	* @return the number of Holidaies
	* @throws SystemException if a system exception occurred
	*/
	public static int getHolidaiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHolidaiesCount();
	}

	/**
	* Updates the Holiday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param holiday the Holiday
	* @return the Holiday that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Holiday updateHoliday(
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHoliday(holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocationHoliday(long locationId,
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLocationHoliday(locationId, holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocationHolidaies(long locationId, long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLocationHolidaies(locationId, holidayIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLocationHolidaies(long locationId,
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> Holidaies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addLocationHolidaies(locationId, Holidaies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLocationHolidaies(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLocationHoliday(long locationId,
		com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLocationHoliday(locationId, holiday);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLocationHolidaies(long locationId,
		long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLocationHolidaies(locationId, holidayIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLocationHolidaies(long locationId,
		java.util.List<com.rknowsys.eapp.hrm.model.Holiday> Holidaies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLocationHolidaies(locationId, Holidaies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationHolidaies(locationId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getLocationHolidaies(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLocationHolidaies(locationId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getLocationHolidaiesCount(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationHolidaiesCount(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLocationHoliday(long locationId, long holidayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasLocationHoliday(locationId, holidayId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLocationHolidaies(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasLocationHolidaies(locationId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setLocationHolidaies(long locationId, long[] holidayIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setLocationHolidaies(locationId, holidayIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getSearchHolidays(
		java.util.Date fromDate, java.util.Date toDate, long nationalityId,
		java.util.List<java.lang.Long> locationIds) {
		return getService()
				   .getSearchHolidays(fromDate, toDate, nationalityId,
			locationIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static HolidayLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HolidayLocalService.class.getName());

			if (invokableLocalService instanceof HolidayLocalService) {
				_service = (HolidayLocalService)invokableLocalService;
			}
			else {
				_service = new HolidayLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(HolidayLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(HolidayLocalService service) {
	}

	private static HolidayLocalService _service;
}