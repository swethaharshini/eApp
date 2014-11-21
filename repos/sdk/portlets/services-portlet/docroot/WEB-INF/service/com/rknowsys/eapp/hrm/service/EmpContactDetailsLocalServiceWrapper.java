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
 * Provides a wrapper for {@link EmpContactDetailsLocalService}.
 *
 * @author rknowsys
 * @see EmpContactDetailsLocalService
 * @generated
 */
public class EmpContactDetailsLocalServiceWrapper
	implements EmpContactDetailsLocalService,
		ServiceWrapper<EmpContactDetailsLocalService> {
	public EmpContactDetailsLocalServiceWrapper(
		EmpContactDetailsLocalService empContactDetailsLocalService) {
		_empContactDetailsLocalService = empContactDetailsLocalService;
	}

	/**
	* Adds the EmpContactDetails to the database. Also notifies the appropriate model listeners.
	*
	* @param empContactDetails the EmpContactDetails
	* @return the EmpContactDetails that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails addEmpContactDetails(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.addEmpContactDetails(empContactDetails);
	}

	/**
	* Creates a new EmpContactDetails with the primary key. Does not add the EmpContactDetails to the database.
	*
	* @param empContactDetailsId the primary key for the new EmpContactDetails
	* @return the new EmpContactDetails
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails createEmpContactDetails(
		long empContactDetailsId) {
		return _empContactDetailsLocalService.createEmpContactDetails(empContactDetailsId);
	}

	/**
	* Deletes the EmpContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empContactDetailsId the primary key of the EmpContactDetails
	* @return the EmpContactDetails that was removed
	* @throws PortalException if a EmpContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails deleteEmpContactDetails(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.deleteEmpContactDetails(empContactDetailsId);
	}

	/**
	* Deletes the EmpContactDetails from the database. Also notifies the appropriate model listeners.
	*
	* @param empContactDetails the EmpContactDetails
	* @return the EmpContactDetails that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails deleteEmpContactDetails(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.deleteEmpContactDetails(empContactDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empContactDetailsLocalService.dynamicQuery();
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
		return _empContactDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empContactDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empContactDetailsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empContactDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empContactDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails fetchEmpContactDetails(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.fetchEmpContactDetails(empContactDetailsId);
	}

	/**
	* Returns the EmpContactDetails with the primary key.
	*
	* @param empContactDetailsId the primary key of the EmpContactDetails
	* @return the EmpContactDetails
	* @throws PortalException if a EmpContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails getEmpContactDetails(
		long empContactDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.getEmpContactDetails(empContactDetailsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the EmpContactDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpContactDetailses
	* @param end the upper bound of the range of EmpContactDetailses (not inclusive)
	* @return the range of EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpContactDetails> getEmpContactDetailses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.getEmpContactDetailses(start, end);
	}

	/**
	* Returns the number of EmpContactDetailses.
	*
	* @return the number of EmpContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpContactDetailsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.getEmpContactDetailsesCount();
	}

	/**
	* Updates the EmpContactDetails in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empContactDetails the EmpContactDetails
	* @return the EmpContactDetails that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpContactDetails updateEmpContactDetails(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empContactDetailsLocalService.updateEmpContactDetails(empContactDetails);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empContactDetailsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empContactDetailsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empContactDetailsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpContactDetailsLocalService getWrappedEmpContactDetailsLocalService() {
		return _empContactDetailsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpContactDetailsLocalService(
		EmpContactDetailsLocalService empContactDetailsLocalService) {
		_empContactDetailsLocalService = empContactDetailsLocalService;
	}

	@Override
	public EmpContactDetailsLocalService getWrappedService() {
		return _empContactDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EmpContactDetailsLocalService empContactDetailsLocalService) {
		_empContactDetailsLocalService = empContactDetailsLocalService;
	}

	private EmpContactDetailsLocalService _empContactDetailsLocalService;
}