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
 * Provides a wrapper for {@link SalaryComponentLocalService}.
 *
 * @author rknowsys
 * @see SalaryComponentLocalService
 * @generated
 */
public class SalaryComponentLocalServiceWrapper
	implements SalaryComponentLocalService,
		ServiceWrapper<SalaryComponentLocalService> {
	public SalaryComponentLocalServiceWrapper(
		SalaryComponentLocalService salaryComponentLocalService) {
		_salaryComponentLocalService = salaryComponentLocalService;
	}

	/**
	* Adds the salary component to the database. Also notifies the appropriate model listeners.
	*
	* @param salaryComponent the salary component
	* @return the salary component that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent addSalaryComponent(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.addSalaryComponent(salaryComponent);
	}

	/**
	* Creates a new salary component with the primary key. Does not add the salary component to the database.
	*
	* @param salaryComponentId the primary key for the new salary component
	* @return the new salary component
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent createSalaryComponent(
		long salaryComponentId) {
		return _salaryComponentLocalService.createSalaryComponent(salaryComponentId);
	}

	/**
	* Deletes the salary component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component that was removed
	* @throws PortalException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent deleteSalaryComponent(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.deleteSalaryComponent(salaryComponentId);
	}

	/**
	* Deletes the salary component from the database. Also notifies the appropriate model listeners.
	*
	* @param salaryComponent the salary component
	* @return the salary component that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent deleteSalaryComponent(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.deleteSalaryComponent(salaryComponent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salaryComponentLocalService.dynamicQuery();
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
		return _salaryComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _salaryComponentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _salaryComponentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _salaryComponentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _salaryComponentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchSalaryComponent(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.fetchSalaryComponent(salaryComponentId);
	}

	/**
	* Returns the salary component with the primary key.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component
	* @throws PortalException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent getSalaryComponent(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.getSalaryComponent(salaryComponentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of salary components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> getSalaryComponents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.getSalaryComponents(start, end);
	}

	/**
	* Returns the number of salary components.
	*
	* @return the number of salary components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSalaryComponentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.getSalaryComponentsCount();
	}

	/**
	* Updates the salary component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param salaryComponent the salary component
	* @return the salary component that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.SalaryComponent updateSalaryComponent(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salaryComponentLocalService.updateSalaryComponent(salaryComponent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _salaryComponentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_salaryComponentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _salaryComponentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SalaryComponentLocalService getWrappedSalaryComponentLocalService() {
		return _salaryComponentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSalaryComponentLocalService(
		SalaryComponentLocalService salaryComponentLocalService) {
		_salaryComponentLocalService = salaryComponentLocalService;
	}

	@Override
	public SalaryComponentLocalService getWrappedService() {
		return _salaryComponentLocalService;
	}

	@Override
	public void setWrappedService(
		SalaryComponentLocalService salaryComponentLocalService) {
		_salaryComponentLocalService = salaryComponentLocalService;
	}

	private SalaryComponentLocalService _salaryComponentLocalService;
}