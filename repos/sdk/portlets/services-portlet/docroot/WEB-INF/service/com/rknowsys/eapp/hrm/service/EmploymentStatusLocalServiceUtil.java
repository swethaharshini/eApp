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
 * Provides the local service utility for EmploymentStatus. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.EmploymentStatusLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see EmploymentStatusLocalService
 * @see com.rknowsys.eapp.hrm.service.base.EmploymentStatusLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.EmploymentStatusLocalServiceImpl
 * @generated
 */
public class EmploymentStatusLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.EmploymentStatusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employment status to the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus addEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmploymentStatus(employmentStatus);
	}

	/**
	* Creates a new employment status with the primary key. Does not add the employment status to the database.
	*
	* @param employmentStatusId the primary key for the new employment status
	* @return the new employment status
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus createEmploymentStatus(
		long employmentStatusId) {
		return getService().createEmploymentStatus(employmentStatusId);
	}

	/**
	* Deletes the employment status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status that was removed
	* @throws PortalException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus deleteEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmploymentStatus(employmentStatusId);
	}

	/**
	* Deletes the employment status from the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus deleteEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmploymentStatus(employmentStatus);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rknowsys.eapp.hrm.model.EmploymentStatus fetchEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmploymentStatus(employmentStatusId);
	}

	/**
	* Returns the employment status with the primary key.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status
	* @throws PortalException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus getEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmploymentStatus(employmentStatusId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the employment statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employment statuses
	* @param end the upper bound of the range of employment statuses (not inclusive)
	* @return the range of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmploymentStatuses(start, end);
	}

	/**
	* Returns the number of employment statuses.
	*
	* @return the number of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmploymentStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmploymentStatusesCount();
	}

	/**
	* Updates the employment status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmploymentStatus updateEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmploymentStatus(employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveTypeApplicabilityEmploymentStatus(
		long leaveTypeApplicabilityId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveTypeApplicabilityEmploymentStatus(leaveTypeApplicabilityId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveTypeApplicabilityEmploymentStatus(
		long leaveTypeApplicabilityId,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveTypeApplicabilityEmploymentStatus(leaveTypeApplicabilityId,
			employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			employmentStatusIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> EmploymentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			EmploymentStatuses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.clearLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveTypeApplicabilityEmploymentStatus(
		long leaveTypeApplicabilityId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveTypeApplicabilityEmploymentStatus(leaveTypeApplicabilityId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveTypeApplicabilityEmploymentStatus(
		long leaveTypeApplicabilityId,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveTypeApplicabilityEmploymentStatus(leaveTypeApplicabilityId,
			employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			employmentStatusIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> EmploymentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			EmploymentStatuses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getLeaveTypeApplicabilityEmploymentStatusesCount(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveTypeApplicabilityEmploymentStatusesCount(leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLeaveTypeApplicabilityEmploymentStatus(
		long leaveTypeApplicabilityId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasLeaveTypeApplicabilityEmploymentStatus(leaveTypeApplicabilityId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setLeaveTypeApplicabilityEmploymentStatuses(
		long leaveTypeApplicabilityId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setLeaveTypeApplicabilityEmploymentStatuses(leaveTypeApplicabilityId,
			employmentStatusIds);
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

	public static EmploymentStatusLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmploymentStatusLocalService.class.getName());

			if (invokableLocalService instanceof EmploymentStatusLocalService) {
				_service = (EmploymentStatusLocalService)invokableLocalService;
			}
			else {
				_service = new EmploymentStatusLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmploymentStatusLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmploymentStatusLocalService service) {
	}

	private static EmploymentStatusLocalService _service;
}