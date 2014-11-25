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
 * Provides a wrapper for {@link WorkWeekLocalService}.
 *
 * @author rknowsys
 * @see WorkWeekLocalService
 * @generated
 */
public class WorkWeekLocalServiceWrapper implements WorkWeekLocalService,
	ServiceWrapper<WorkWeekLocalService> {
	public WorkWeekLocalServiceWrapper(
		WorkWeekLocalService workWeekLocalService) {
		_workWeekLocalService = workWeekLocalService;
	}

	/**
	* Adds the WorkWeek to the database. Also notifies the appropriate model listeners.
	*
	* @param workWeek the WorkWeek
	* @return the WorkWeek that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek addWorkWeek(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.addWorkWeek(workWeek);
	}

	/**
	* Creates a new WorkWeek with the primary key. Does not add the WorkWeek to the database.
	*
	* @param workWeekId the primary key for the new WorkWeek
	* @return the new WorkWeek
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek createWorkWeek(long workWeekId) {
		return _workWeekLocalService.createWorkWeek(workWeekId);
	}

	/**
	* Deletes the WorkWeek with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek that was removed
	* @throws PortalException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek deleteWorkWeek(long workWeekId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.deleteWorkWeek(workWeekId);
	}

	/**
	* Deletes the WorkWeek from the database. Also notifies the appropriate model listeners.
	*
	* @param workWeek the WorkWeek
	* @return the WorkWeek that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek deleteWorkWeek(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.deleteWorkWeek(workWeek);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workWeekLocalService.dynamicQuery();
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
		return _workWeekLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workWeekLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workWeekLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _workWeekLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workWeekLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek fetchWorkWeek(long workWeekId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.fetchWorkWeek(workWeekId);
	}

	/**
	* Returns the WorkWeek with the primary key.
	*
	* @param workWeekId the primary key of the WorkWeek
	* @return the WorkWeek
	* @throws PortalException if a WorkWeek with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek getWorkWeek(long workWeekId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.getWorkWeek(workWeekId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the WorkWeeks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkWeeks
	* @param end the upper bound of the range of WorkWeeks (not inclusive)
	* @return the range of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> getWorkWeeks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.getWorkWeeks(start, end);
	}

	/**
	* Returns the number of WorkWeeks.
	*
	* @return the number of WorkWeeks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkWeeksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.getWorkWeeksCount();
	}

	/**
	* Updates the WorkWeek in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workWeek the WorkWeek
	* @return the WorkWeek that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkWeek updateWorkWeek(
		com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.updateWorkWeek(workWeek);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workWeekLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workWeekLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workWeekLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkWeek> findByNationality(
		long natId) throws com.liferay.portal.kernel.exception.SystemException {
		return _workWeekLocalService.findByNationality(natId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkWeekLocalService getWrappedWorkWeekLocalService() {
		return _workWeekLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkWeekLocalService(
		WorkWeekLocalService workWeekLocalService) {
		_workWeekLocalService = workWeekLocalService;
	}

	@Override
	public WorkWeekLocalService getWrappedService() {
		return _workWeekLocalService;
	}

	@Override
	public void setWrappedService(WorkWeekLocalService workWeekLocalService) {
		_workWeekLocalService = workWeekLocalService;
	}

	private WorkWeekLocalService _workWeekLocalService;
}