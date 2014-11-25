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
 * Provides a wrapper for {@link WorkshiftLocalService}.
 *
 * @author rknowsys
 * @see WorkshiftLocalService
 * @generated
 */
public class WorkshiftLocalServiceWrapper implements WorkshiftLocalService,
	ServiceWrapper<WorkshiftLocalService> {
	public WorkshiftLocalServiceWrapper(
		WorkshiftLocalService workshiftLocalService) {
		_workshiftLocalService = workshiftLocalService;
	}

	/**
	* Adds the workshift to the database. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift addWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.addWorkshift(workshift);
	}

	/**
	* Creates a new workshift with the primary key. Does not add the workshift to the database.
	*
	* @param shiftId the primary key for the new workshift
	* @return the new workshift
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift createWorkshift(long shiftId) {
		return _workshiftLocalService.createWorkshift(shiftId);
	}

	/**
	* Deletes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift that was removed
	* @throws PortalException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift deleteWorkshift(long shiftId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.deleteWorkshift(shiftId);
	}

	/**
	* Deletes the workshift from the database. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift deleteWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.deleteWorkshift(workshift);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workshiftLocalService.dynamicQuery();
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
		return _workshiftLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workshiftLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workshiftLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _workshiftLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workshiftLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Workshift fetchWorkshift(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.fetchWorkshift(shiftId);
	}

	/**
	* Returns the workshift with the primary key.
	*
	* @param shiftId the primary key of the workshift
	* @return the workshift
	* @throws PortalException if a workshift with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift getWorkshift(long shiftId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getWorkshift(shiftId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the workshifts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workshifts
	* @param end the upper bound of the range of workshifts (not inclusive)
	* @return the range of workshifts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getWorkshifts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getWorkshifts(start, end);
	}

	/**
	* Returns the number of workshifts.
	*
	* @return the number of workshifts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkshiftsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getWorkshiftsCount();
	}

	/**
	* Updates the workshift in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workshift the workshift
	* @return the workshift that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.Workshift updateWorkshift(
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.updateWorkshift(workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.addEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeWorkshift(long employeeId,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.addEmployeeWorkshift(employeeId, workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.addEmployeeWorkshifts(employeeId, shiftIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeWorkshifts(long employeeId,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> Workshifts)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.addEmployeeWorkshifts(employeeId, Workshifts);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearEmployeeWorkshifts(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.clearEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.deleteEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeWorkshift(long employeeId,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.deleteEmployeeWorkshift(employeeId, workshift);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.deleteEmployeeWorkshifts(employeeId, shiftIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeWorkshifts(long employeeId,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> Workshifts)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.deleteEmployeeWorkshifts(employeeId, Workshifts);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getEmployeeWorkshifts(employeeId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getEmployeeWorkshifts(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getEmployeeWorkshifts(employeeId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmployeeWorkshiftsCount(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.getEmployeeWorkshiftsCount(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmployeeWorkshift(long employeeId, long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.hasEmployeeWorkshift(employeeId, shiftId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmployeeWorkshifts(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workshiftLocalService.hasEmployeeWorkshifts(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setEmployeeWorkshifts(long employeeId, long[] shiftIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workshiftLocalService.setEmployeeWorkshifts(employeeId, shiftIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workshiftLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workshiftLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workshiftLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkshiftLocalService getWrappedWorkshiftLocalService() {
		return _workshiftLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkshiftLocalService(
		WorkshiftLocalService workshiftLocalService) {
		_workshiftLocalService = workshiftLocalService;
	}

	@Override
	public WorkshiftLocalService getWrappedService() {
		return _workshiftLocalService;
	}

	@Override
	public void setWrappedService(WorkshiftLocalService workshiftLocalService) {
		_workshiftLocalService = workshiftLocalService;
	}

	private WorkshiftLocalService _workshiftLocalService;
}