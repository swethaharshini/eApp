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
 * Provides a wrapper for {@link LeaveRuleApplicableLocalService}.
 *
 * @author rknowsys
 * @see LeaveRuleApplicableLocalService
 * @generated
 */
public class LeaveRuleApplicableLocalServiceWrapper
	implements LeaveRuleApplicableLocalService,
		ServiceWrapper<LeaveRuleApplicableLocalService> {
	public LeaveRuleApplicableLocalServiceWrapper(
		LeaveRuleApplicableLocalService leaveRuleApplicableLocalService) {
		_leaveRuleApplicableLocalService = leaveRuleApplicableLocalService;
	}

	/**
	* Adds the leave rule applicable to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable addLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.addLeaveRuleApplicable(leaveRuleApplicable);
	}

	/**
	* Creates a new leave rule applicable with the primary key. Does not add the leave rule applicable to the database.
	*
	* @param leaveRuleApplicableId the primary key for the new leave rule applicable
	* @return the new leave rule applicable
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable createLeaveRuleApplicable(
		long leaveRuleApplicableId) {
		return _leaveRuleApplicableLocalService.createLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Deletes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws PortalException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable deleteLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.deleteLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Deletes the leave rule applicable from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable deleteLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.deleteLeaveRuleApplicable(leaveRuleApplicable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveRuleApplicableLocalService.dynamicQuery();
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
		return _leaveRuleApplicableLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _leaveRuleApplicableLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveRuleApplicableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable fetchLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.fetchLeaveRuleApplicable(leaveRuleApplicableId);
	}

	/**
	* Returns the leave rule applicable with the primary key.
	*
	* @param leaveRuleApplicableId the primary key of the leave rule applicable
	* @return the leave rule applicable
	* @throws PortalException if a leave rule applicable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable getLeaveRuleApplicable(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getLeaveRuleApplicable(leaveRuleApplicableId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getLeaveRuleApplicables(start,
			end);
	}

	/**
	* Returns the number of leave rule applicables.
	*
	* @return the number of leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveRuleApplicablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getLeaveRuleApplicablesCount();
	}

	/**
	* Updates the leave rule applicable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveRuleApplicable the leave rule applicable
	* @return the leave rule applicable that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRuleApplicable updateLeaveRuleApplicable(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.updateLeaveRuleApplicable(leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobCategoryLeaveRuleApplicable(long jobCategoryId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobCategoryLeaveRuleApplicable(long jobCategoryId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobCategoryLeaveRuleApplicables(long jobCategoryId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobCategoryLeaveRuleApplicables(long jobCategoryId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobCategoryLeaveRuleApplicables(jobCategoryId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearJobCategoryLeaveRuleApplicables(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.clearJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobCategoryLeaveRuleApplicable(long jobCategoryId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobCategoryLeaveRuleApplicable(long jobCategoryId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobCategoryLeaveRuleApplicables(long jobCategoryId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobCategoryLeaveRuleApplicables(long jobCategoryId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobCategoryLeaveRuleApplicables(jobCategoryId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobCategoryLeaveRuleApplicables(jobCategoryId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobCategoryLeaveRuleApplicables(
		long jobCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobCategoryLeaveRuleApplicables(jobCategoryId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobCategoryLeaveRuleApplicablesCount(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobCategoryLeaveRuleApplicablesCount(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobCategoryLeaveRuleApplicable(long jobCategoryId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasJobCategoryLeaveRuleApplicable(jobCategoryId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobCategoryLeaveRuleApplicables(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasJobCategoryLeaveRuleApplicables(jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setJobCategoryLeaveRuleApplicables(long jobCategoryId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.setJobCategoryLeaveRuleApplicables(jobCategoryId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveRuleApplicable(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobTitleLeaveRuleApplicables(jobTitleId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveRuleApplicables(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addJobTitleLeaveRuleApplicables(jobTitleId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearJobTitleLeaveRuleApplicables(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.clearJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveRuleApplicable(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobTitleLeaveRuleApplicables(jobTitleId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveRuleApplicables(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteJobTitleLeaveRuleApplicables(jobTitleId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobTitleLeaveRuleApplicables(jobTitleId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getJobTitleLeaveRuleApplicables(
		long jobTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobTitleLeaveRuleApplicables(jobTitleId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobTitleLeaveRuleApplicablesCount(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getJobTitleLeaveRuleApplicablesCount(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobTitleLeaveRuleApplicable(long jobTitleId,
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasJobTitleLeaveRuleApplicable(jobTitleId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobTitleLeaveRuleApplicables(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasJobTitleLeaveRuleApplicables(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setJobTitleLeaveRuleApplicables(long jobTitleId,
		long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.setJobTitleLeaveRuleApplicables(jobTitleId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.addEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.clearEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicable);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> LeaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.deleteEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			LeaveRuleApplicables);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmploymentStatusLeaveRuleApplicablesCount(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.getEmploymentStatusLeaveRuleApplicablesCount(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmploymentStatusLeaveRuleApplicable(
		long employmentStatusId, long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasEmploymentStatusLeaveRuleApplicable(employmentStatusId,
			leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.hasEmploymentStatusLeaveRuleApplicables(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setEmploymentStatusLeaveRuleApplicables(
		long employmentStatusId, long[] leaveRuleApplicableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveRuleApplicableLocalService.setEmploymentStatusLeaveRuleApplicables(employmentStatusId,
			leaveRuleApplicableIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveRuleApplicableLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveRuleApplicableLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveRuleApplicableLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRuleApplicableLocalService.findByLeaveTypeId(leaveTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveRuleApplicableLocalService getWrappedLeaveRuleApplicableLocalService() {
		return _leaveRuleApplicableLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveRuleApplicableLocalService(
		LeaveRuleApplicableLocalService leaveRuleApplicableLocalService) {
		_leaveRuleApplicableLocalService = leaveRuleApplicableLocalService;
	}

	@Override
	public LeaveRuleApplicableLocalService getWrappedService() {
		return _leaveRuleApplicableLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveRuleApplicableLocalService leaveRuleApplicableLocalService) {
		_leaveRuleApplicableLocalService = leaveRuleApplicableLocalService;
	}

	private LeaveRuleApplicableLocalService _leaveRuleApplicableLocalService;
}