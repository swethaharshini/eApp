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
 * Provides a wrapper for {@link EmpDetailsLocalService}.
 *
 * @author rknowsys
 * @see EmpDetailsLocalService
 * @generated
 */
public class EmpDetailsLocalServiceWrapper implements EmpDetailsLocalService,
	ServiceWrapper<EmpDetailsLocalService> {
	public EmpDetailsLocalServiceWrapper(
		EmpDetailsLocalService empDetailsLocalService) {
		_empDetailsLocalService = empDetailsLocalService;
	}

	/**
	* Adds the emp details to the database. Also notifies the appropriate model listeners.
	*
	* @param empDetails the emp details
	* @return the emp details that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails addEmpDetails(
		com.rknowsys.eapp.hrm.model.EmpDetails empDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.addEmpDetails(empDetails);
	}

	/**
	* Creates a new emp details with the primary key. Does not add the emp details to the database.
	*
	* @param empdetailsId the primary key for the new emp details
	* @return the new emp details
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails createEmpDetails(
		long empdetailsId) {
		return _empDetailsLocalService.createEmpDetails(empdetailsId);
	}

	/**
	* Deletes the emp details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empdetailsId the primary key of the emp details
	* @return the emp details that was removed
	* @throws PortalException if a emp details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails deleteEmpDetails(
		long empdetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.deleteEmpDetails(empdetailsId);
	}

	/**
	* Deletes the emp details from the database. Also notifies the appropriate model listeners.
	*
	* @param empDetails the emp details
	* @return the emp details that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails deleteEmpDetails(
		com.rknowsys.eapp.hrm.model.EmpDetails empDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.deleteEmpDetails(empDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empDetailsLocalService.dynamicQuery();
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
		return _empDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empDetailsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _empDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails fetchEmpDetails(
		long empdetailsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.fetchEmpDetails(empdetailsId);
	}

	/**
	* Returns the emp details with the primary key.
	*
	* @param empdetailsId the primary key of the emp details
	* @return the emp details
	* @throws PortalException if a emp details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails getEmpDetails(
		long empdetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.getEmpDetails(empdetailsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp detailses
	* @param end the upper bound of the range of emp detailses (not inclusive)
	* @return the range of emp detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpDetails> getEmpDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.getEmpDetailses(start, end);
	}

	/**
	* Returns the number of emp detailses.
	*
	* @return the number of emp detailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.getEmpDetailsesCount();
	}

	/**
	* Updates the emp details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empDetails the emp details
	* @return the emp details that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpDetails updateEmpDetails(
		com.rknowsys.eapp.hrm.model.EmpDetails empDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.updateEmpDetails(empDetails);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empDetailsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empDetailsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empDetailsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpDetails> findEmpDetails(
		java.lang.String empname, java.lang.String empid,
		java.lang.String empstatus, java.lang.String supervisorname,
		java.lang.String jobtitle, java.lang.String subunit, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDetailsLocalService.findEmpDetails(empname, empid,
			empstatus, supervisorname, jobtitle, subunit, begin, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpDetailsLocalService getWrappedEmpDetailsLocalService() {
		return _empDetailsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpDetailsLocalService(
		EmpDetailsLocalService empDetailsLocalService) {
		_empDetailsLocalService = empDetailsLocalService;
	}

	@Override
	public EmpDetailsLocalService getWrappedService() {
		return _empDetailsLocalService;
	}

	@Override
	public void setWrappedService(EmpDetailsLocalService empDetailsLocalService) {
		_empDetailsLocalService = empDetailsLocalService;
	}

	private EmpDetailsLocalService _empDetailsLocalService;
}