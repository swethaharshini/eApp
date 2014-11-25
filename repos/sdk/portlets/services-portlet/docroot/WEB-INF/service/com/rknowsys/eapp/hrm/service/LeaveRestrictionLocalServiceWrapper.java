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
 * Provides a wrapper for {@link LeaveRestrictionLocalService}.
 *
 * @author rknowsys
 * @see LeaveRestrictionLocalService
 * @generated
 */
public class LeaveRestrictionLocalServiceWrapper
	implements LeaveRestrictionLocalService,
		ServiceWrapper<LeaveRestrictionLocalService> {
	public LeaveRestrictionLocalServiceWrapper(
		LeaveRestrictionLocalService leaveRestrictionLocalService) {
		_leaveRestrictionLocalService = leaveRestrictionLocalService;
	}

	/**
	* Adds the leave restriction to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRestriction the leave restriction
	* @return the leave restriction that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction addLeaveRestriction(
		com.rknowsys.eapp.hrm.model.LeaveRestriction leaveRestriction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.addLeaveRestriction(leaveRestriction);
	}

	/**
	* Creates a new leave restriction with the primary key. Does not add the leave restriction to the database.
	*
	* @param leaveRestrictionId the primary key for the new leave restriction
	* @return the new leave restriction
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction createLeaveRestriction(
		long leaveRestrictionId) {
		return _leaveRestrictionLocalService.createLeaveRestriction(leaveRestrictionId);
	}

	/**
	* Deletes the leave restriction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRestrictionId the primary key of the leave restriction
	* @return the leave restriction that was removed
	* @throws PortalException if a leave restriction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction deleteLeaveRestriction(
		long leaveRestrictionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.deleteLeaveRestriction(leaveRestrictionId);
	}

	/**
	* Deletes the leave restriction from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRestriction the leave restriction
	* @return the leave restriction that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction deleteLeaveRestriction(
		com.rknowsys.eapp.hrm.model.LeaveRestriction leaveRestriction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.deleteLeaveRestriction(leaveRestriction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveRestrictionLocalService.dynamicQuery();
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
		return _leaveRestrictionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveRestrictionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveRestrictionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _leaveRestrictionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveRestrictionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction fetchLeaveRestriction(
		long leaveRestrictionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.fetchLeaveRestriction(leaveRestrictionId);
	}

	/**
	* Returns the leave restriction with the primary key.
	*
	* @param leaveRestrictionId the primary key of the leave restriction
	* @return the leave restriction
	* @throws PortalException if a leave restriction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction getLeaveRestriction(
		long leaveRestrictionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.getLeaveRestriction(leaveRestrictionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave restrictions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave restrictions
	* @param end the upper bound of the range of leave restrictions (not inclusive)
	* @return the range of leave restrictions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRestriction> getLeaveRestrictions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.getLeaveRestrictions(start, end);
	}

	/**
	* Returns the number of leave restrictions.
	*
	* @return the number of leave restrictions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveRestrictionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.getLeaveRestrictionsCount();
	}

	/**
	* Updates the leave restriction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveRestriction the leave restriction
	* @return the leave restriction that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveRestriction updateLeaveRestriction(
		com.rknowsys.eapp.hrm.model.LeaveRestriction leaveRestriction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.updateLeaveRestriction(leaveRestriction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveRestrictionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveRestrictionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveRestrictionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRestriction> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveRestrictionLocalService.findByLeaveTypeId(leaveTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveRestrictionLocalService getWrappedLeaveRestrictionLocalService() {
		return _leaveRestrictionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveRestrictionLocalService(
		LeaveRestrictionLocalService leaveRestrictionLocalService) {
		_leaveRestrictionLocalService = leaveRestrictionLocalService;
	}

	@Override
	public LeaveRestrictionLocalService getWrappedService() {
		return _leaveRestrictionLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveRestrictionLocalService leaveRestrictionLocalService) {
		_leaveRestrictionLocalService = leaveRestrictionLocalService;
	}

	private LeaveRestrictionLocalService _leaveRestrictionLocalService;
}