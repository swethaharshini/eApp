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
 * Provides a wrapper for {@link EmploymentStatusLocalService}.
 *
 * @author rknowsys
 * @see EmploymentStatusLocalService
 * @generated
 */
public class EmploymentStatusLocalServiceWrapper
	implements EmploymentStatusLocalService,
		ServiceWrapper<EmploymentStatusLocalService> {
	public EmploymentStatusLocalServiceWrapper(
		EmploymentStatusLocalService employmentStatusLocalService) {
		_employmentStatusLocalService = employmentStatusLocalService;
	}

	/**
	* Adds the employment status to the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus addEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.addEmploymentStatus(employmentStatus);
	}

	/**
	* Creates a new employment status with the primary key. Does not add the employment status to the database.
	*
	* @param employmentStatusId the primary key for the new employment status
	* @return the new employment status
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus createEmploymentStatus(
		long employmentStatusId) {
		return _employmentStatusLocalService.createEmploymentStatus(employmentStatusId);
	}

	/**
	* Deletes the employment status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status that was removed
	* @throws PortalException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus deleteEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.deleteEmploymentStatus(employmentStatusId);
	}

	/**
	* Deletes the employment status from the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus deleteEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.deleteEmploymentStatus(employmentStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employmentStatusLocalService.dynamicQuery();
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
		return _employmentStatusLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _employmentStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _employmentStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus fetchEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.fetchEmploymentStatus(employmentStatusId);
	}

	/**
	* Returns the employment status with the primary key.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status
	* @throws PortalException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus getEmploymentStatus(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getEmploymentStatus(employmentStatusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getEmploymentStatuses(start, end);
	}

	/**
	* Returns the number of employment statuses.
	*
	* @return the number of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmploymentStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getEmploymentStatusesCount();
	}

	/**
	* Updates the employment status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employmentStatus the employment status
	* @return the employment status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus updateEmploymentStatus(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.updateEmploymentStatus(employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLeaveRuleApplicableEmploymentStatus(
		long leaveRuleApplicableId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.addLeaveRuleApplicableEmploymentStatus(leaveRuleApplicableId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLeaveRuleApplicableEmploymentStatus(
		long leaveRuleApplicableId,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.addLeaveRuleApplicableEmploymentStatus(leaveRuleApplicableId,
			employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.addLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			employmentStatusIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> EmploymentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.addLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			EmploymentStatuses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.clearLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLeaveRuleApplicableEmploymentStatus(
		long leaveRuleApplicableId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.deleteLeaveRuleApplicableEmploymentStatus(leaveRuleApplicableId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLeaveRuleApplicableEmploymentStatus(
		long leaveRuleApplicableId,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.deleteLeaveRuleApplicableEmploymentStatus(leaveRuleApplicableId,
			employmentStatus);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.deleteLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			employmentStatusIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId,
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> EmploymentStatuses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.deleteLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			EmploymentStatuses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveRuleApplicableEmploymentStatusesCount(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.getLeaveRuleApplicableEmploymentStatusesCount(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLeaveRuleApplicableEmploymentStatus(
		long leaveRuleApplicableId, long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.hasLeaveRuleApplicableEmploymentStatus(leaveRuleApplicableId,
			employmentStatusId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatusLocalService.hasLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setLeaveRuleApplicableEmploymentStatuses(
		long leaveRuleApplicableId, long[] employmentStatusIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatusLocalService.setLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicableId,
			employmentStatusIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _employmentStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_employmentStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _employmentStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmploymentStatusLocalService getWrappedEmploymentStatusLocalService() {
		return _employmentStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmploymentStatusLocalService(
		EmploymentStatusLocalService employmentStatusLocalService) {
		_employmentStatusLocalService = employmentStatusLocalService;
	}

	@Override
	public EmploymentStatusLocalService getWrappedService() {
		return _employmentStatusLocalService;
	}

	@Override
	public void setWrappedService(
		EmploymentStatusLocalService employmentStatusLocalService) {
		_employmentStatusLocalService = employmentStatusLocalService;
	}

	private EmploymentStatusLocalService _employmentStatusLocalService;
}