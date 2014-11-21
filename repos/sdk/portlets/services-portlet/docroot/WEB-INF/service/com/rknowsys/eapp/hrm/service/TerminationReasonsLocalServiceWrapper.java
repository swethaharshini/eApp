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
 * Provides a wrapper for {@link TerminationReasonsLocalService}.
 *
 * @author rknowsys
 * @see TerminationReasonsLocalService
 * @generated
 */
public class TerminationReasonsLocalServiceWrapper
	implements TerminationReasonsLocalService,
		ServiceWrapper<TerminationReasonsLocalService> {
	public TerminationReasonsLocalServiceWrapper(
		TerminationReasonsLocalService terminationReasonsLocalService) {
		_terminationReasonsLocalService = terminationReasonsLocalService;
	}

	/**
	* Adds the termination reasons to the database. Also notifies the appropriate model listeners.
	*
	* @param terminationReasons the termination reasons
	* @return the termination reasons that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons addTerminationReasons(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.addTerminationReasons(terminationReasons);
	}

	/**
	* Creates a new termination reasons with the primary key. Does not add the termination reasons to the database.
	*
	* @param terminationreasonsId the primary key for the new termination reasons
	* @return the new termination reasons
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons createTerminationReasons(
		long terminationreasonsId) {
		return _terminationReasonsLocalService.createTerminationReasons(terminationreasonsId);
	}

	/**
	* Deletes the termination reasons with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons that was removed
	* @throws PortalException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons deleteTerminationReasons(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.deleteTerminationReasons(terminationreasonsId);
	}

	/**
	* Deletes the termination reasons from the database. Also notifies the appropriate model listeners.
	*
	* @param terminationReasons the termination reasons
	* @return the termination reasons that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons deleteTerminationReasons(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.deleteTerminationReasons(terminationReasons);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _terminationReasonsLocalService.dynamicQuery();
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
		return _terminationReasonsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.TerminationReasonsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _terminationReasonsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.TerminationReasonsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _terminationReasonsLocalService.dynamicQuery(dynamicQuery,
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
		return _terminationReasonsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _terminationReasonsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons fetchTerminationReasons(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.fetchTerminationReasons(terminationreasonsId);
	}

	/**
	* Returns the termination reasons with the primary key.
	*
	* @param terminationreasonsId the primary key of the termination reasons
	* @return the termination reasons
	* @throws PortalException if a termination reasons with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons getTerminationReasons(
		long terminationreasonsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.getTerminationReasons(terminationreasonsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the termination reasonses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.TerminationReasonsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of termination reasonses
	* @param end the upper bound of the range of termination reasonses (not inclusive)
	* @return the range of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.TerminationReasons> getTerminationReasonses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.getTerminationReasonses(start,
			end);
	}

	/**
	* Returns the number of termination reasonses.
	*
	* @return the number of termination reasonses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTerminationReasonsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.getTerminationReasonsesCount();
	}

	/**
	* Updates the termination reasons in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param terminationReasons the termination reasons
	* @return the termination reasons that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.TerminationReasons updateTerminationReasons(
		com.rknowsys.eapp.hrm.model.TerminationReasons terminationReasons)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _terminationReasonsLocalService.updateTerminationReasons(terminationReasons);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _terminationReasonsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_terminationReasonsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _terminationReasonsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TerminationReasonsLocalService getWrappedTerminationReasonsLocalService() {
		return _terminationReasonsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTerminationReasonsLocalService(
		TerminationReasonsLocalService terminationReasonsLocalService) {
		_terminationReasonsLocalService = terminationReasonsLocalService;
	}

	@Override
	public TerminationReasonsLocalService getWrappedService() {
		return _terminationReasonsLocalService;
	}

	@Override
	public void setWrappedService(
		TerminationReasonsLocalService terminationReasonsLocalService) {
		_terminationReasonsLocalService = terminationReasonsLocalService;
	}

	private TerminationReasonsLocalService _terminationReasonsLocalService;
}