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
 * Provides a wrapper for {@link LeaveTypeApplicabilityLocalService}.
 *
 * @author rknowsys
 * @see LeaveTypeApplicabilityLocalService
 * @generated
 */
public class LeaveTypeApplicabilityLocalServiceWrapper
	implements LeaveTypeApplicabilityLocalService,
		ServiceWrapper<LeaveTypeApplicabilityLocalService> {
	public LeaveTypeApplicabilityLocalServiceWrapper(
		LeaveTypeApplicabilityLocalService leaveTypeApplicabilityLocalService) {
		_leaveTypeApplicabilityLocalService = leaveTypeApplicabilityLocalService;
	}

	/**
	* Adds the leave type applicability to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability addLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.addLeaveTypeApplicability(leaveTypeApplicability);
	}

	/**
	* Creates a new leave type applicability with the primary key. Does not add the leave type applicability to the database.
	*
	* @param leaveTypeApplicabilityId the primary key for the new leave type applicability
	* @return the new leave type applicability
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability createLeaveTypeApplicability(
		long leaveTypeApplicabilityId) {
		return _leaveTypeApplicabilityLocalService.createLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Deletes the leave type applicability with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability that was removed
	* @throws PortalException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability deleteLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.deleteLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Deletes the leave type applicability from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability deleteLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.deleteLeaveTypeApplicability(leaveTypeApplicability);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTypeApplicabilityLocalService.dynamicQuery();
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
		return _leaveTypeApplicabilityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.dynamicQuery(dynamicQuery,
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
		return _leaveTypeApplicabilityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveTypeApplicabilityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability fetchLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.fetchLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	/**
	* Returns the leave type applicability with the primary key.
	*
	* @param leaveTypeApplicabilityId the primary key of the leave type applicability
	* @return the leave type applicability
	* @throws PortalException if a leave type applicability with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability getLeaveTypeApplicability(
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getLeaveTypeApplicability(leaveTypeApplicabilityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getLeaveTypeApplicabilities(start,
			end);
	}

	/**
	* Returns the number of leave type applicabilities.
	*
	* @return the number of leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveTypeApplicabilitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getLeaveTypeApplicabilitiesCount();
	}

	/**
	* Updates the leave type applicability in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeApplicability the leave type applicability
	* @return the leave type applicability that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeApplicability updateLeaveTypeApplicability(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.updateLeaveTypeApplicability(leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveTypeApplicability(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobTitleLeaveTypeApplicabilities(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addJobTitleLeaveTypeApplicabilities(jobTitleId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearJobTitleLeaveTypeApplicabilities(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.clearJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveTypeApplicability(long jobTitleId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobTitleLeaveTypeApplicabilities(long jobTitleId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteJobTitleLeaveTypeApplicabilities(jobTitleId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getJobTitleLeaveTypeApplicabilities(jobTitleId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getJobTitleLeaveTypeApplicabilities(
		long jobTitleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getJobTitleLeaveTypeApplicabilities(jobTitleId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobTitleLeaveTypeApplicabilitiesCount(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getJobTitleLeaveTypeApplicabilitiesCount(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobTitleLeaveTypeApplicability(long jobTitleId,
		long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.hasJobTitleLeaveTypeApplicability(jobTitleId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobTitleLeaveTypeApplicabilities(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.hasJobTitleLeaveTypeApplicabilities(jobTitleId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setJobTitleLeaveTypeApplicabilities(long jobTitleId,
		long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.setJobTitleLeaveTypeApplicabilities(jobTitleId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.addEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.clearEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicability);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> LeaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.deleteEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			LeaveTypeApplicabilities);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmploymentStatusLeaveTypeApplicabilitiesCount(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.getEmploymentStatusLeaveTypeApplicabilitiesCount(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmploymentStatusLeaveTypeApplicability(
		long employmentStatusId, long leaveTypeApplicabilityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.hasEmploymentStatusLeaveTypeApplicability(employmentStatusId,
			leaveTypeApplicabilityId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.hasEmploymentStatusLeaveTypeApplicabilities(employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setEmploymentStatusLeaveTypeApplicabilities(
		long employmentStatusId, long[] leaveTypeApplicabilityIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaveTypeApplicabilityLocalService.setEmploymentStatusLeaveTypeApplicabilities(employmentStatusId,
			leaveTypeApplicabilityIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveTypeApplicabilityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveTypeApplicabilityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveTypeApplicabilityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeApplicabilityLocalService.findByLeaveTypeId(leaveTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveTypeApplicabilityLocalService getWrappedLeaveTypeApplicabilityLocalService() {
		return _leaveTypeApplicabilityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveTypeApplicabilityLocalService(
		LeaveTypeApplicabilityLocalService leaveTypeApplicabilityLocalService) {
		_leaveTypeApplicabilityLocalService = leaveTypeApplicabilityLocalService;
	}

	@Override
	public LeaveTypeApplicabilityLocalService getWrappedService() {
		return _leaveTypeApplicabilityLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeApplicabilityLocalService leaveTypeApplicabilityLocalService) {
		_leaveTypeApplicabilityLocalService = leaveTypeApplicabilityLocalService;
	}

	private LeaveTypeApplicabilityLocalService _leaveTypeApplicabilityLocalService;
}