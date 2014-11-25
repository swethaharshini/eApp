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
 * Provides the local service utility for LeaveTypeApplicability. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.LeaveTypeApplicabilityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see LeaveTypeApplicabilityLocalService
 * @see com.rknowsys.eapp.hrm.service.base.LeaveTypeApplicabilityLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.LeaveTypeApplicabilityLocalServiceImpl
 * @generated
 */
public class LeaveTypeApplicabilityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.LeaveTypeApplicabilityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave type applicability to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability addLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLeaveTypeApplicability(leaveTypeApplicability);
	}

	/**
	* Creates a new leave type applicability with the primary key. Does not add the leave type applicability to the database.
	*
	* @param leaveTypeApplicabilityId the primary key for the new leave type applicability
	* @return the new leave type applicability
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability createLeaveTypeApplicability(
		long leaveTypeApplicabilityId) {
		return getService()
				   .createLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Deletes the leave type applicability with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability that was removed
	* @throws PortalException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability deleteLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Deletes the leave type applicability from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability deleteLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLeaveTypeApplicability(leaveTypeApplicability);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Returns the leave type applicability with the primary key.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability
	* @throws PortalException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability getLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave type applicabilities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type applicabilities
	* @param end the upper bound of the range of leave type applicabilities (not inclusive)
	* @return the range of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveTypeApplicabilities(start, end);
	}

	/**
	* Returns the number of leave type applicabilities.
	*
	* @return the number of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public static int getLeaveTypeApplicabilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveTypeApplicabilitiesCount();
	}

	/**
	* Updates the leave type applicability in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveTypeApplicability updateLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLeaveTypeApplicability(leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveTypeApplicability(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveTypeApplicabilities(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveTypeApplicabilities(jobTitleId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobTitleLeaveTypeApplicabilities(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveTypeApplicability(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveTypeApplicabilities(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveTypeApplicabilities(jobTitleId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobTitleLeaveTypeApplicabilities(jobTitleId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobTitleLeaveTypeApplicabilities(jobTitleId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobTitleLeaveTypeApplicabilitiesCount(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobTitleLeaveTypeApplicabilitiesCount(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobTitleLeaveTypeApplicabilities(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.clearEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmploymentStatusLeaveTypeApplicabilitiesCount(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveTypeApplicabilitiesCount(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
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

	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLeaveTypeId(leaveTypeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LeaveTypeApplicabilityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LeaveTypeApplicabilityLocalService.class.getName());

			if (invokableLocalService instanceof LeaveTypeApplicabilityLocalService) {
				_service = (LeaveTypeApplicabilityLocalService)invokableLocalService;
			}
			else {
				_service = new LeaveTypeApplicabilityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LeaveTypeApplicabilityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LeaveTypeApplicabilityLocalService service) {
	}

	private static LeaveTypeApplicabilityLocalService _service;
}