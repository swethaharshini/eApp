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
 * Provides a wrapper for {@link LeaveTypeEmployeeGroupsLocalService}.
 *
 * @author rknowsys
 * @see LeaveTypeEmployeeGroupsLocalService
 * @generated
 */
public class LeaveTypeEmployeeGroupsLocalServiceWrapper
	implements LeaveTypeEmployeeGroupsLocalService,
		ServiceWrapper<LeaveTypeEmployeeGroupsLocalService> {
	public LeaveTypeEmployeeGroupsLocalServiceWrapper(
		LeaveTypeEmployeeGroupsLocalService leaveTypeEmployeeGroupsLocalService) {
		_leaveTypeEmployeeGroupsLocalService = leaveTypeEmployeeGroupsLocalService;
	}

	/**
	* Adds the leave type employee groups to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeEmployeeGroups the leave type employee groups
	* @return the leave type employee groups that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups addLeaveTypeEmployeeGroups(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.addLeaveTypeEmployeeGroups(leaveTypeEmployeeGroups);
	}

	/**
	* Creates a new leave type employee groups with the primary key. Does not add the leave type employee groups to the database.
	*
	* @param leaveTypeEmployeeGroupId the primary key for the new leave type employee groups
	* @return the new leave type employee groups
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups createLeaveTypeEmployeeGroups(
		long leaveTypeEmployeeGroupId) {
		return _leaveTypeEmployeeGroupsLocalService.createLeaveTypeEmployeeGroups(leaveTypeEmployeeGroupId);
	}

	/**
	* Deletes the leave type employee groups with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	* @return the leave type employee groups that was removed
	* @throws PortalException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups deleteLeaveTypeEmployeeGroups(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.deleteLeaveTypeEmployeeGroups(leaveTypeEmployeeGroupId);
	}

	/**
	* Deletes the leave type employee groups from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeEmployeeGroups the leave type employee groups
	* @return the leave type employee groups that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups deleteLeaveTypeEmployeeGroups(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.deleteLeaveTypeEmployeeGroups(leaveTypeEmployeeGroups);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTypeEmployeeGroupsLocalService.dynamicQuery();
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
		return _leaveTypeEmployeeGroupsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveTypeEmployeeGroupsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveTypeEmployeeGroupsLocalService.dynamicQuery(dynamicQuery,
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
		return _leaveTypeEmployeeGroupsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveTypeEmployeeGroupsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups fetchLeaveTypeEmployeeGroups(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.fetchLeaveTypeEmployeeGroups(leaveTypeEmployeeGroupId);
	}

	/**
	* Returns the leave type employee groups with the primary key.
	*
	* @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	* @return the leave type employee groups
	* @throws PortalException if a leave type employee groups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups getLeaveTypeEmployeeGroups(
		long leaveTypeEmployeeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.getLeaveTypeEmployeeGroups(leaveTypeEmployeeGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave type employee groupses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave type employee groupses
	* @param end the upper bound of the range of leave type employee groupses (not inclusive)
	* @return the range of leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups> getLeaveTypeEmployeeGroupses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.getLeaveTypeEmployeeGroupses(start,
			end);
	}

	/**
	* Returns the number of leave type employee groupses.
	*
	* @return the number of leave type employee groupses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveTypeEmployeeGroupsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.getLeaveTypeEmployeeGroupsesCount();
	}

	/**
	* Updates the leave type employee groups in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveTypeEmployeeGroups the leave type employee groups
	* @return the leave type employee groups that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups updateLeaveTypeEmployeeGroups(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveTypeEmployeeGroupsLocalService.updateLeaveTypeEmployeeGroups(leaveTypeEmployeeGroups);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveTypeEmployeeGroupsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveTypeEmployeeGroupsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveTypeEmployeeGroupsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveTypeEmployeeGroupsLocalService getWrappedLeaveTypeEmployeeGroupsLocalService() {
		return _leaveTypeEmployeeGroupsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveTypeEmployeeGroupsLocalService(
		LeaveTypeEmployeeGroupsLocalService leaveTypeEmployeeGroupsLocalService) {
		_leaveTypeEmployeeGroupsLocalService = leaveTypeEmployeeGroupsLocalService;
	}

	@Override
	public LeaveTypeEmployeeGroupsLocalService getWrappedService() {
		return _leaveTypeEmployeeGroupsLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeEmployeeGroupsLocalService leaveTypeEmployeeGroupsLocalService) {
		_leaveTypeEmployeeGroupsLocalService = leaveTypeEmployeeGroupsLocalService;
	}

	private LeaveTypeEmployeeGroupsLocalService _leaveTypeEmployeeGroupsLocalService;
}