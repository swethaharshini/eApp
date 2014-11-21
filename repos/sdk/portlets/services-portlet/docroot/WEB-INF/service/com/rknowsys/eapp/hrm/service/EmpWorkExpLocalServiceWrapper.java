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
 * Provides a wrapper for {@link EmpWorkExpLocalService}.
 *
 * @author rknowsys
 * @see EmpWorkExpLocalService
 * @generated
 */
public class EmpWorkExpLocalServiceWrapper implements EmpWorkExpLocalService,
	ServiceWrapper<EmpWorkExpLocalService> {
	public EmpWorkExpLocalServiceWrapper(
		EmpWorkExpLocalService empWorkExpLocalService) {
		_empWorkExpLocalService = empWorkExpLocalService;
	}

	/**
	* Adds the EmpWorkExp to the database. Also notifies the appropriate model listeners.
	*
	* @param empWorkExp the EmpWorkExp
	* @return the EmpWorkExp that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp addEmpWorkExp(
		com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.addEmpWorkExp(empWorkExp);
	}

	/**
	* Creates a new EmpWorkExp with the primary key. Does not add the EmpWorkExp to the database.
	*
	* @param empWorkExpId the primary key for the new EmpWorkExp
	* @return the new EmpWorkExp
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp createEmpWorkExp(
		long empWorkExpId) {
		return _empWorkExpLocalService.createEmpWorkExp(empWorkExpId);
	}

	/**
	* Deletes the EmpWorkExp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empWorkExpId the primary key of the EmpWorkExp
	* @return the EmpWorkExp that was removed
	* @throws PortalException if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp deleteEmpWorkExp(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.deleteEmpWorkExp(empWorkExpId);
	}

	/**
	* Deletes the EmpWorkExp from the database. Also notifies the appropriate model listeners.
	*
	* @param empWorkExp the EmpWorkExp
	* @return the EmpWorkExp that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp deleteEmpWorkExp(
		com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.deleteEmpWorkExp(empWorkExp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empWorkExpLocalService.dynamicQuery();
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
		return _empWorkExpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empWorkExpLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empWorkExpLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _empWorkExpLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empWorkExpLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp fetchEmpWorkExp(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.fetchEmpWorkExp(empWorkExpId);
	}

	/**
	* Returns the EmpWorkExp with the primary key.
	*
	* @param empWorkExpId the primary key of the EmpWorkExp
	* @return the EmpWorkExp
	* @throws PortalException if a EmpWorkExp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp getEmpWorkExp(
		long empWorkExpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.getEmpWorkExp(empWorkExpId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the EmpWorkExps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpWorkExps
	* @param end the upper bound of the range of EmpWorkExps (not inclusive)
	* @return the range of EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpWorkExp> getEmpWorkExps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.getEmpWorkExps(start, end);
	}

	/**
	* Returns the number of EmpWorkExps.
	*
	* @return the number of EmpWorkExps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpWorkExpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.getEmpWorkExpsCount();
	}

	/**
	* Updates the EmpWorkExp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empWorkExp the EmpWorkExp
	* @return the EmpWorkExp that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp updateEmpWorkExp(
		com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empWorkExpLocalService.updateEmpWorkExp(empWorkExp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empWorkExpLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empWorkExpLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empWorkExpLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpWorkExpLocalService getWrappedEmpWorkExpLocalService() {
		return _empWorkExpLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpWorkExpLocalService(
		EmpWorkExpLocalService empWorkExpLocalService) {
		_empWorkExpLocalService = empWorkExpLocalService;
	}

	@Override
	public EmpWorkExpLocalService getWrappedService() {
		return _empWorkExpLocalService;
	}

	@Override
	public void setWrappedService(EmpWorkExpLocalService empWorkExpLocalService) {
		_empWorkExpLocalService = empWorkExpLocalService;
	}

	private EmpWorkExpLocalService _empWorkExpLocalService;
}