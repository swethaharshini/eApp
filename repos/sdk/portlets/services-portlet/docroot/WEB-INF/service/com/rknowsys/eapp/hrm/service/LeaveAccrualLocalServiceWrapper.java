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
 * Provides a wrapper for {@link LeaveAccrualLocalService}.
 *
 * @author rknowsys
 * @see LeaveAccrualLocalService
 * @generated
 */
public class LeaveAccrualLocalServiceWrapper implements LeaveAccrualLocalService,
	ServiceWrapper<LeaveAccrualLocalService> {
	public LeaveAccrualLocalServiceWrapper(
		LeaveAccrualLocalService leaveAccrualLocalService) {
		_leaveAccrualLocalService = leaveAccrualLocalService;
	}

	/**
	* Adds the leave accrual to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveAccrual the leave accrual
	* @return the leave accrual that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual addLeaveAccrual(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.addLeaveAccrual(leaveAccrual);
	}

	/**
	* Creates a new leave accrual with the primary key. Does not add the leave accrual to the database.
	*
	* @param leaveAccrualId the primary key for the new leave accrual
	* @return the new leave accrual
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual createLeaveAccrual(
		long leaveAccrualId) {
		return _leaveAccrualLocalService.createLeaveAccrual(leaveAccrualId);
	}

	/**
	* Deletes the leave accrual with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveAccrualId the primary key of the leave accrual
	* @return the leave accrual that was removed
	* @throws PortalException if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual deleteLeaveAccrual(
		long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.deleteLeaveAccrual(leaveAccrualId);
	}

	/**
	* Deletes the leave accrual from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveAccrual the leave accrual
	* @return the leave accrual that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual deleteLeaveAccrual(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.deleteLeaveAccrual(leaveAccrual);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveAccrualLocalService.dynamicQuery();
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
		return _leaveAccrualLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveAccrualLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveAccrualLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _leaveAccrualLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveAccrualLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual fetchLeaveAccrual(
		long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.fetchLeaveAccrual(leaveAccrualId);
	}

	/**
	* Returns the leave accrual with the primary key.
	*
	* @param leaveAccrualId the primary key of the leave accrual
	* @return the leave accrual
	* @throws PortalException if a leave accrual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual getLeaveAccrual(
		long leaveAccrualId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.getLeaveAccrual(leaveAccrualId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave accruals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave accruals
	* @param end the upper bound of the range of leave accruals (not inclusive)
	* @return the range of leave accruals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveAccrual> getLeaveAccruals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.getLeaveAccruals(start, end);
	}

	/**
	* Returns the number of leave accruals.
	*
	* @return the number of leave accruals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveAccrualsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.getLeaveAccrualsCount();
	}

	/**
	* Updates the leave accrual in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveAccrual the leave accrual
	* @return the leave accrual that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveAccrual updateLeaveAccrual(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveAccrualLocalService.updateLeaveAccrual(leaveAccrual);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveAccrualLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveAccrualLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveAccrualLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveAccrualLocalService getWrappedLeaveAccrualLocalService() {
		return _leaveAccrualLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveAccrualLocalService(
		LeaveAccrualLocalService leaveAccrualLocalService) {
		_leaveAccrualLocalService = leaveAccrualLocalService;
	}

	@Override
	public LeaveAccrualLocalService getWrappedService() {
		return _leaveAccrualLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveAccrualLocalService leaveAccrualLocalService) {
		_leaveAccrualLocalService = leaveAccrualLocalService;
	}

	private LeaveAccrualLocalService _leaveAccrualLocalService;
}