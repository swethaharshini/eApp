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
 * Provides a wrapper for {@link EmpSupervisorLocalService}.
 *
 * @author rknowsys
 * @see EmpSupervisorLocalService
 * @generated
 */
public class EmpSupervisorLocalServiceWrapper
	implements EmpSupervisorLocalService,
		ServiceWrapper<EmpSupervisorLocalService> {
	public EmpSupervisorLocalServiceWrapper(
		EmpSupervisorLocalService empSupervisorLocalService) {
		_empSupervisorLocalService = empSupervisorLocalService;
	}

	/**
	* Adds the EmpSupervisor to the database. Also notifies the appropriate model listeners.
	*
	* @param empSupervisor the EmpSupervisor
	* @return the EmpSupervisor that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor addEmpSupervisor(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.addEmpSupervisor(empSupervisor);
	}

	/**
	* Creates a new EmpSupervisor with the primary key. Does not add the EmpSupervisor to the database.
	*
	* @param empSupervisorId the primary key for the new EmpSupervisor
	* @return the new EmpSupervisor
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor createEmpSupervisor(
		long empSupervisorId) {
		return _empSupervisorLocalService.createEmpSupervisor(empSupervisorId);
	}

	/**
	* Deletes the EmpSupervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSupervisorId the primary key of the EmpSupervisor
	* @return the EmpSupervisor that was removed
	* @throws PortalException if a EmpSupervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor deleteEmpSupervisor(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.deleteEmpSupervisor(empSupervisorId);
	}

	/**
	* Deletes the EmpSupervisor from the database. Also notifies the appropriate model listeners.
	*
	* @param empSupervisor the EmpSupervisor
	* @return the EmpSupervisor that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor deleteEmpSupervisor(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.deleteEmpSupervisor(empSupervisor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empSupervisorLocalService.dynamicQuery();
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
		return _empSupervisorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSupervisorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSupervisorLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empSupervisorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empSupervisorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor fetchEmpSupervisor(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.fetchEmpSupervisor(empSupervisorId);
	}

	/**
	* Returns the EmpSupervisor with the primary key.
	*
	* @param empSupervisorId the primary key of the EmpSupervisor
	* @return the EmpSupervisor
	* @throws PortalException if a EmpSupervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor getEmpSupervisor(
		long empSupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.getEmpSupervisor(empSupervisorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the EmpSupervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSupervisors
	* @param end the upper bound of the range of EmpSupervisors (not inclusive)
	* @return the range of EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSupervisor> getEmpSupervisors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.getEmpSupervisors(start, end);
	}

	/**
	* Returns the number of EmpSupervisors.
	*
	* @return the number of EmpSupervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpSupervisorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.getEmpSupervisorsCount();
	}

	/**
	* Updates the EmpSupervisor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empSupervisor the EmpSupervisor
	* @return the EmpSupervisor that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSupervisor updateEmpSupervisor(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSupervisorLocalService.updateEmpSupervisor(empSupervisor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empSupervisorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empSupervisorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empSupervisorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpSupervisorLocalService getWrappedEmpSupervisorLocalService() {
		return _empSupervisorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpSupervisorLocalService(
		EmpSupervisorLocalService empSupervisorLocalService) {
		_empSupervisorLocalService = empSupervisorLocalService;
	}

	@Override
	public EmpSupervisorLocalService getWrappedService() {
		return _empSupervisorLocalService;
	}

	@Override
	public void setWrappedService(
		EmpSupervisorLocalService empSupervisorLocalService) {
		_empSupervisorLocalService = empSupervisorLocalService;
	}

	private EmpSupervisorLocalService _empSupervisorLocalService;
}