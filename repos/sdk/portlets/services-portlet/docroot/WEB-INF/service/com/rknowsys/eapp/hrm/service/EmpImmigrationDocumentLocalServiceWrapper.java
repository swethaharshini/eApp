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
 * Provides a wrapper for {@link EmpImmigrationDocumentLocalService}.
 *
 * @author rknowsys
 * @see EmpImmigrationDocumentLocalService
 * @generated
 */
public class EmpImmigrationDocumentLocalServiceWrapper
	implements EmpImmigrationDocumentLocalService,
		ServiceWrapper<EmpImmigrationDocumentLocalService> {
	public EmpImmigrationDocumentLocalServiceWrapper(
		EmpImmigrationDocumentLocalService empImmigrationDocumentLocalService) {
		_empImmigrationDocumentLocalService = empImmigrationDocumentLocalService;
	}

	/**
	* Adds the ImmigrationDocument to the database. Also notifies the appropriate model listeners.
	*
	* @param empImmigrationDocument the ImmigrationDocument
	* @return the ImmigrationDocument that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument addEmpImmigrationDocument(
		com.rknowsys.eapp.hrm.model.EmpImmigrationDocument empImmigrationDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.addEmpImmigrationDocument(empImmigrationDocument);
	}

	/**
	* Creates a new ImmigrationDocument with the primary key. Does not add the ImmigrationDocument to the database.
	*
	* @param empImmigrationDocumentId the primary key for the new ImmigrationDocument
	* @return the new ImmigrationDocument
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument createEmpImmigrationDocument(
		long empImmigrationDocumentId) {
		return _empImmigrationDocumentLocalService.createEmpImmigrationDocument(empImmigrationDocumentId);
	}

	/**
	* Deletes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empImmigrationDocumentId the primary key of the ImmigrationDocument
	* @return the ImmigrationDocument that was removed
	* @throws PortalException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument deleteEmpImmigrationDocument(
		long empImmigrationDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.deleteEmpImmigrationDocument(empImmigrationDocumentId);
	}

	/**
	* Deletes the ImmigrationDocument from the database. Also notifies the appropriate model listeners.
	*
	* @param empImmigrationDocument the ImmigrationDocument
	* @return the ImmigrationDocument that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument deleteEmpImmigrationDocument(
		com.rknowsys.eapp.hrm.model.EmpImmigrationDocument empImmigrationDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.deleteEmpImmigrationDocument(empImmigrationDocument);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empImmigrationDocumentLocalService.dynamicQuery();
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
		return _empImmigrationDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empImmigrationDocumentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empImmigrationDocumentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _empImmigrationDocumentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empImmigrationDocumentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument fetchEmpImmigrationDocument(
		long empImmigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.fetchEmpImmigrationDocument(empImmigrationDocumentId);
	}

	/**
	* Returns the ImmigrationDocument with the primary key.
	*
	* @param empImmigrationDocumentId the primary key of the ImmigrationDocument
	* @return the ImmigrationDocument
	* @throws PortalException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument getEmpImmigrationDocument(
		long empImmigrationDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.getEmpImmigrationDocument(empImmigrationDocumentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ImmigrationDocuments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @return the range of ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpImmigrationDocument> getEmpImmigrationDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.getEmpImmigrationDocuments(start,
			end);
	}

	/**
	* Returns the number of ImmigrationDocuments.
	*
	* @return the number of ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpImmigrationDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.getEmpImmigrationDocumentsCount();
	}

	/**
	* Updates the ImmigrationDocument in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empImmigrationDocument the ImmigrationDocument
	* @return the ImmigrationDocument that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpImmigrationDocument updateEmpImmigrationDocument(
		com.rknowsys.eapp.hrm.model.EmpImmigrationDocument empImmigrationDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empImmigrationDocumentLocalService.updateEmpImmigrationDocument(empImmigrationDocument);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empImmigrationDocumentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empImmigrationDocumentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empImmigrationDocumentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpImmigrationDocumentLocalService getWrappedEmpImmigrationDocumentLocalService() {
		return _empImmigrationDocumentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpImmigrationDocumentLocalService(
		EmpImmigrationDocumentLocalService empImmigrationDocumentLocalService) {
		_empImmigrationDocumentLocalService = empImmigrationDocumentLocalService;
	}

	@Override
	public EmpImmigrationDocumentLocalService getWrappedService() {
		return _empImmigrationDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		EmpImmigrationDocumentLocalService empImmigrationDocumentLocalService) {
		_empImmigrationDocumentLocalService = empImmigrationDocumentLocalService;
	}

	private EmpImmigrationDocumentLocalService _empImmigrationDocumentLocalService;
}