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
 * Provides the local service utility for LeaveRuleApplicable. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.LeaveRuleApplicableLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see LeaveRuleApplicableLocalService
 * @see com.rknowsys.eapp.hrm.service.base.LeaveRuleApplicableLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.LeaveRuleApplicableLocalServiceImpl
 * @generated
 */
public class LeaveRuleApplicableLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.LeaveRuleApplicableLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave rule applicable to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable addLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLeaveRuleApplicable(leaveRuleApplicable);
	}

	/**
	* Creates a new leave rule applicable with the primary key. Does not add the leave rule applicable to the database.
	*
	* @param leaveRuleApplicableId the primary key for the new leave rule applicable
	* @return the new leave rule applicable
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable createLeaveRuleApplicable(
		long leaveRuleApplicableId) {
		return getService().createLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Deletes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws PortalException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable deleteLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Deletes the leave rule applicable from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable deleteLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLeaveRuleApplicable(leaveRuleApplicable);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Returns the leave rule applicable with the primary key.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable
	* @throws PortalException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable getLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveRuleApplicable(leaveRuleApplicableId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave rule applicables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave rule applicables
	* @param end the upper bound of the range of leave rule applicables (not inclusive)
	* @return the range of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveRuleApplicables(start, end);
	}

	/**
	* Returns the number of leave rule applicables.
	*
	* @return the number of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static int getLeaveRuleApplicablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLeaveRuleApplicablesCount();
	}

	/**
	* Updates the leave rule applicable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.LeaveRuleApplicable updateLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLeaveRuleApplicable(leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategoryLeaveRuleApplicable(long jobCategoryId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategoryLeaveRuleApplicable(long jobCategoryId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategoryLeaveRuleApplicables(long jobCategoryId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobCategoryLeaveRuleApplicables(long jobCategoryId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobCategoryLeaveRuleApplicables(jobCategoryId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobCategoryLeaveRuleApplicables(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobCategoryLeaveRuleApplicable(
		long jobCategoryId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobCategoryLeaveRuleApplicable(
		long jobCategoryId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobCategoryLeaveRuleApplicables(
		long jobCategoryId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobCategoryLeaveRuleApplicables(
		long jobCategoryId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobCategoryLeaveRuleApplicables(jobCategoryId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobCategoryLeaveRuleApplicables(jobCategoryId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobCategoryLeaveRuleApplicables(jobCategoryId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobCategoryLeaveRuleApplicablesCount(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobCategoryLeaveRuleApplicablesCount(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobCategoryLeaveRuleApplicable(
		long jobCategoryId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobCategoryLeaveRuleApplicables(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobCategoryLeaveRuleApplicables(long jobCategoryId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveRuleApplicable(jobTitleId, leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveRuleApplicable(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveRuleApplicable(jobTitleId, leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveRuleApplicables(jobTitleId, leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobTitleLeaveRuleApplicables(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addJobTitleLeaveRuleApplicables(jobTitleId, LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobTitleLeaveRuleApplicables(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveRuleApplicable(jobTitleId, leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveRuleApplicable(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveRuleApplicable(jobTitleId, leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveRuleApplicables(jobTitleId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobTitleLeaveRuleApplicables(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteJobTitleLeaveRuleApplicables(jobTitleId, LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobTitleLeaveRuleApplicables(jobTitleId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobTitleLeaveRuleApplicables(jobTitleId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobTitleLeaveRuleApplicablesCount(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobTitleLeaveRuleApplicablesCount(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobTitleLeaveRuleApplicables(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setJobTitleLeaveRuleApplicables(jobTitleId, leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.clearEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmploymentStatusLeaveRuleApplicablesCount(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmploymentStatusLeaveRuleApplicablesCount(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
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

	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLeaveTypeId(leaveTypeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LeaveRuleApplicableLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LeaveRuleApplicableLocalService.class.getName());

			if (invokableLocalService instanceof LeaveRuleApplicableLocalService) {
				_service = (LeaveRuleApplicableLocalService)invokableLocalService;
			}
			else {
				_service = new LeaveRuleApplicableLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LeaveRuleApplicableLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LeaveRuleApplicableLocalService service) {
	}

	private static LeaveRuleApplicableLocalService _service;
}