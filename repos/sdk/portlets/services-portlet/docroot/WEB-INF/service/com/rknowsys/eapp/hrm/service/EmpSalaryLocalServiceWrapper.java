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
 * Provides a wrapper for {@link EmpSalaryLocalService}.
 *
 * @author rknowsys
 * @see EmpSalaryLocalService
 * @generated
 */
public class EmpSalaryLocalServiceWrapper implements EmpSalaryLocalService,
	ServiceWrapper<EmpSalaryLocalService> {
	public EmpSalaryLocalServiceWrapper(
		EmpSalaryLocalService empSalaryLocalService) {
		_empSalaryLocalService = empSalaryLocalService;
	}

	/**
	* Adds the emp salary to the database. Also notifies the appropriate model listeners.
	*
	* @param empSalary the emp salary
	* @return the emp salary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary addEmpSalary(
		com.rknowsys.eapp.hrm.model.EmpSalary empSalary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.addEmpSalary(empSalary);
	}

	/**
	* Creates a new emp salary with the primary key. Does not add the emp salary to the database.
	*
	* @param empSalaryId the primary key for the new emp salary
	* @return the new emp salary
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary createEmpSalary(
		long empSalaryId) {
		return _empSalaryLocalService.createEmpSalary(empSalaryId);
	}

	/**
	* Deletes the emp salary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSalaryId the primary key of the emp salary
	* @return the emp salary that was removed
	* @throws PortalException if a emp salary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary deleteEmpSalary(
		long empSalaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.deleteEmpSalary(empSalaryId);
	}

	/**
	* Deletes the emp salary from the database. Also notifies the appropriate model listeners.
	*
	* @param empSalary the emp salary
	* @return the emp salary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary deleteEmpSalary(
		com.rknowsys.eapp.hrm.model.EmpSalary empSalary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.deleteEmpSalary(empSalary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empSalaryLocalService.dynamicQuery();
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
		return _empSalaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSalaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSalaryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _empSalaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empSalaryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary fetchEmpSalary(
		long empSalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.fetchEmpSalary(empSalaryId);
	}

	/**
	* Returns the emp salary with the primary key.
	*
	* @param empSalaryId the primary key of the emp salary
	* @return the emp salary
	* @throws PortalException if a emp salary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary getEmpSalary(long empSalaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.getEmpSalary(empSalaryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp salaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp salaries
	* @param end the upper bound of the range of emp salaries (not inclusive)
	* @return the range of emp salaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSalary> getEmpSalaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.getEmpSalaries(start, end);
	}

	/**
	* Returns the number of emp salaries.
	*
	* @return the number of emp salaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpSalariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.getEmpSalariesCount();
	}

	/**
	* Updates the emp salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empSalary the emp salary
	* @return the emp salary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalary updateEmpSalary(
		com.rknowsys.eapp.hrm.model.EmpSalary empSalary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryLocalService.updateEmpSalary(empSalary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empSalaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empSalaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empSalaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpSalaryLocalService getWrappedEmpSalaryLocalService() {
		return _empSalaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpSalaryLocalService(
		EmpSalaryLocalService empSalaryLocalService) {
		_empSalaryLocalService = empSalaryLocalService;
	}

	@Override
	public EmpSalaryLocalService getWrappedService() {
		return _empSalaryLocalService;
	}

	@Override
	public void setWrappedService(EmpSalaryLocalService empSalaryLocalService) {
		_empSalaryLocalService = empSalaryLocalService;
	}

	private EmpSalaryLocalService _empSalaryLocalService;
}