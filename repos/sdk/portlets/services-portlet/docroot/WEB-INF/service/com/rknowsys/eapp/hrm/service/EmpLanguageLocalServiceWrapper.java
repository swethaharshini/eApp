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
 * Provides a wrapper for {@link EmpLanguageLocalService}.
 *
 * @author rknowsys
 * @see EmpLanguageLocalService
 * @generated
 */
public class EmpLanguageLocalServiceWrapper implements EmpLanguageLocalService,
	ServiceWrapper<EmpLanguageLocalService> {
	public EmpLanguageLocalServiceWrapper(
		EmpLanguageLocalService empLanguageLocalService) {
		_empLanguageLocalService = empLanguageLocalService;
	}

	/**
	* Adds the emp language to the database. Also notifies the appropriate model listeners.
	*
	* @param empLanguage the emp language
	* @return the emp language that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage addEmpLanguage(
		com.rknowsys.eapp.hrm.model.EmpLanguage empLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.addEmpLanguage(empLanguage);
	}

	/**
	* Creates a new emp language with the primary key. Does not add the emp language to the database.
	*
	* @param empLanguageId the primary key for the new emp language
	* @return the new emp language
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage createEmpLanguage(
		long empLanguageId) {
		return _empLanguageLocalService.createEmpLanguage(empLanguageId);
	}

	/**
	* Deletes the emp language with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empLanguageId the primary key of the emp language
	* @return the emp language that was removed
	* @throws PortalException if a emp language with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage deleteEmpLanguage(
		long empLanguageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.deleteEmpLanguage(empLanguageId);
	}

	/**
	* Deletes the emp language from the database. Also notifies the appropriate model listeners.
	*
	* @param empLanguage the emp language
	* @return the emp language that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage deleteEmpLanguage(
		com.rknowsys.eapp.hrm.model.EmpLanguage empLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.deleteEmpLanguage(empLanguage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empLanguageLocalService.dynamicQuery();
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
		return _empLanguageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empLanguageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empLanguageLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _empLanguageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empLanguageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage fetchEmpLanguage(
		long empLanguageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.fetchEmpLanguage(empLanguageId);
	}

	/**
	* Returns the emp language with the primary key.
	*
	* @param empLanguageId the primary key of the emp language
	* @return the emp language
	* @throws PortalException if a emp language with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage getEmpLanguage(
		long empLanguageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.getEmpLanguage(empLanguageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp languages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp languages
	* @param end the upper bound of the range of emp languages (not inclusive)
	* @return the range of emp languages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpLanguage> getEmpLanguages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.getEmpLanguages(start, end);
	}

	/**
	* Returns the number of emp languages.
	*
	* @return the number of emp languages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpLanguagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.getEmpLanguagesCount();
	}

	/**
	* Updates the emp language in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empLanguage the emp language
	* @return the emp language that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpLanguage updateEmpLanguage(
		com.rknowsys.eapp.hrm.model.EmpLanguage empLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLanguageLocalService.updateEmpLanguage(empLanguage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empLanguageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empLanguageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empLanguageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpLanguageLocalService getWrappedEmpLanguageLocalService() {
		return _empLanguageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpLanguageLocalService(
		EmpLanguageLocalService empLanguageLocalService) {
		_empLanguageLocalService = empLanguageLocalService;
	}

	@Override
	public EmpLanguageLocalService getWrappedService() {
		return _empLanguageLocalService;
	}

	@Override
	public void setWrappedService(
		EmpLanguageLocalService empLanguageLocalService) {
		_empLanguageLocalService = empLanguageLocalService;
	}

	private EmpLanguageLocalService _empLanguageLocalService;
}