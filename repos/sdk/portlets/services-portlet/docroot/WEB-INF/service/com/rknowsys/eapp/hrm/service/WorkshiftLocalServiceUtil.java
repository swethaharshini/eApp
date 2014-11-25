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
 * Provides the local service utility for Workshift. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.WorkshiftLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see WorkshiftLocalService
 * @see com.rknowsys.eapp.hrm.service.base.WorkshiftLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.WorkshiftLocalServiceImpl
 * @generated
 */
public class WorkshiftLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.WorkshiftLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the workshift to the database. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift addWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWorkshift(workshift);
	}

	/**
	* Creates a new workshift with the primary key. Does not add the workshift to the database.
	*
	* @param shiftId the primary key for the new workshift
	* @return the new workshift
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift createWorkshift(
		long shiftId) {
		return getService().createWorkshift(shiftId);
	}

	/**
	* Deletes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift that was removed
	* @throws PortalException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift deleteWorkshift(
		long shiftId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkshift(shiftId);
	}

	/**
	* Deletes the workshift from the database. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift deleteWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkshift(workshift);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rknowsys.eapp.hrm.model.Workshift fetchWorkshift(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWorkshift(shiftId);
	}

	/**
	* Returns the workshift with the primary key.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift
	* @throws PortalException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift getWorkshift(
		long shiftId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkshift(shiftId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the workshifts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getWorkshifts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkshifts(start, end);
	}

	/**
	* Returns the number of workshifts.
	*
	* @return the number of workshifts
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkshiftsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkshiftsCount();
	}

	/**
	* Updates the workshift in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Workshift updateWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWorkshift(workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeWorkshift(long employeeId,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeWorkshift(employeeId, workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeWorkshifts(employeeId, shiftIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeWorkshifts(long employeeId,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> Workshifts)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeWorkshifts(employeeId, Workshifts);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmployeeWorkshifts(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeWorkshift(long employeeId,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeWorkshift(employeeId, workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeWorkshifts(employeeId, shiftIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeWorkshifts(long employeeId,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> Workshifts)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeWorkshifts(employeeId, Workshifts);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeWorkshifts(employeeId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployeeWorkshifts(employeeId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeeWorkshiftsCount(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeWorkshiftsCount(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmployeeWorkshifts(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setEmployeeWorkshifts(employeeId, shiftIds);
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

	public static void clearService() {
		_service = null;
	}

	public static WorkshiftLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkshiftLocalService.class.getName());

			if (invokableLocalService instanceof WorkshiftLocalService) {
				_service = (WorkshiftLocalService)invokableLocalService;
			}
			else {
				_service = new WorkshiftLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WorkshiftLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WorkshiftLocalService service) {
	}

	private static WorkshiftLocalService _service;
}