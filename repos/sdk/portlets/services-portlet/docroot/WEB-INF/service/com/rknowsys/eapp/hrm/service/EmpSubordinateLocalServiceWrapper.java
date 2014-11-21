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
 * Provides a wrapper for {@link EmpSubordinateLocalService}.
 *
 * @author rknowsys
 * @see EmpSubordinateLocalService
 * @generated
 */
public class EmpSubordinateLocalServiceWrapper
	implements EmpSubordinateLocalService,
		ServiceWrapper<EmpSubordinateLocalService> {
	public EmpSubordinateLocalServiceWrapper(
		EmpSubordinateLocalService empSubordinateLocalService) {
		_empSubordinateLocalService = empSubordinateLocalService;
	}

	/**
	* Adds the EmpSubordinate to the database. Also notifies the appropriate model listeners.
	*
	* @param empSubordinate the EmpSubordinate
	* @return the EmpSubordinate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate addEmpSubordinate(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.addEmpSubordinate(empSubordinate);
	}

	/**
	* Creates a new EmpSubordinate with the primary key. Does not add the EmpSubordinate to the database.
	*
	* @param empSubordinateId the primary key for the new EmpSubordinate
	* @return the new EmpSubordinate
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate createEmpSubordinate(
		long empSubordinateId) {
		return _empSubordinateLocalService.createEmpSubordinate(empSubordinateId);
	}

	/**
	* Deletes the EmpSubordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSubordinateId the primary key of the EmpSubordinate
	* @return the EmpSubordinate that was removed
	* @throws PortalException if a EmpSubordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate deleteEmpSubordinate(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.deleteEmpSubordinate(empSubordinateId);
	}

	/**
	* Deletes the EmpSubordinate from the database. Also notifies the appropriate model listeners.
	*
	* @param empSubordinate the EmpSubordinate
	* @return the EmpSubordinate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate deleteEmpSubordinate(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.deleteEmpSubordinate(empSubordinate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empSubordinateLocalService.dynamicQuery();
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
		return _empSubordinateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSubordinateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSubordinateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empSubordinateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empSubordinateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate fetchEmpSubordinate(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.fetchEmpSubordinate(empSubordinateId);
	}

	/**
	* Returns the EmpSubordinate with the primary key.
	*
	* @param empSubordinateId the primary key of the EmpSubordinate
	* @return the EmpSubordinate
	* @throws PortalException if a EmpSubordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate getEmpSubordinate(
		long empSubordinateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.getEmpSubordinate(empSubordinateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the EmpSubordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpSubordinates
	* @param end the upper bound of the range of EmpSubordinates (not inclusive)
	* @return the range of EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSubordinate> getEmpSubordinates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.getEmpSubordinates(start, end);
	}

	/**
	* Returns the number of EmpSubordinates.
	*
	* @return the number of EmpSubordinates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpSubordinatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.getEmpSubordinatesCount();
	}

	/**
	* Updates the EmpSubordinate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empSubordinate the EmpSubordinate
	* @return the EmpSubordinate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSubordinate updateEmpSubordinate(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSubordinateLocalService.updateEmpSubordinate(empSubordinate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empSubordinateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empSubordinateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empSubordinateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpSubordinateLocalService getWrappedEmpSubordinateLocalService() {
		return _empSubordinateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpSubordinateLocalService(
		EmpSubordinateLocalService empSubordinateLocalService) {
		_empSubordinateLocalService = empSubordinateLocalService;
	}

	@Override
	public EmpSubordinateLocalService getWrappedService() {
		return _empSubordinateLocalService;
	}

	@Override
	public void setWrappedService(
		EmpSubordinateLocalService empSubordinateLocalService) {
		_empSubordinateLocalService = empSubordinateLocalService;
	}

	private EmpSubordinateLocalService _empSubordinateLocalService;
}