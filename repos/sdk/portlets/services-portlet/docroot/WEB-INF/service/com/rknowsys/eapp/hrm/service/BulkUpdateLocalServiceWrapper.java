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
 * Provides a wrapper for {@link BulkUpdateLocalService}.
 *
 * @author rknowsys
 * @see BulkUpdateLocalService
 * @generated
 */
public class BulkUpdateLocalServiceWrapper implements BulkUpdateLocalService,
	ServiceWrapper<BulkUpdateLocalService> {
	public BulkUpdateLocalServiceWrapper(
		BulkUpdateLocalService bulkUpdateLocalService) {
		_bulkUpdateLocalService = bulkUpdateLocalService;
	}

	/**
	* Adds the bulk update to the database. Also notifies the appropriate model listeners.
	*
	* @param bulkUpdate the bulk update
	* @return the bulk update that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate addBulkUpdate(
		com.rknowsys.eapp.hrm.model.BulkUpdate bulkUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.addBulkUpdate(bulkUpdate);
	}

	/**
	* Creates a new bulk update with the primary key. Does not add the bulk update to the database.
	*
	* @param bulkupdateId the primary key for the new bulk update
	* @return the new bulk update
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate createBulkUpdate(
		long bulkupdateId) {
		return _bulkUpdateLocalService.createBulkUpdate(bulkupdateId);
	}

	/**
	* Deletes the bulk update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bulkupdateId the primary key of the bulk update
	* @return the bulk update that was removed
	* @throws PortalException if a bulk update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate deleteBulkUpdate(
		long bulkupdateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.deleteBulkUpdate(bulkupdateId);
	}

	/**
	* Deletes the bulk update from the database. Also notifies the appropriate model listeners.
	*
	* @param bulkUpdate the bulk update
	* @return the bulk update that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate deleteBulkUpdate(
		com.rknowsys.eapp.hrm.model.BulkUpdate bulkUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.deleteBulkUpdate(bulkUpdate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bulkUpdateLocalService.dynamicQuery();
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
		return _bulkUpdateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bulkUpdateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bulkUpdateLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _bulkUpdateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bulkUpdateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate fetchBulkUpdate(
		long bulkupdateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.fetchBulkUpdate(bulkupdateId);
	}

	/**
	* Returns the bulk update with the primary key.
	*
	* @param bulkupdateId the primary key of the bulk update
	* @return the bulk update
	* @throws PortalException if a bulk update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate getBulkUpdate(
		long bulkupdateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.getBulkUpdate(bulkupdateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bulk updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bulk updates
	* @param end the upper bound of the range of bulk updates (not inclusive)
	* @return the range of bulk updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.BulkUpdate> getBulkUpdates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.getBulkUpdates(start, end);
	}

	/**
	* Returns the number of bulk updates.
	*
	* @return the number of bulk updates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBulkUpdatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.getBulkUpdatesCount();
	}

	/**
	* Updates the bulk update in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bulkUpdate the bulk update
	* @return the bulk update that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.BulkUpdate updateBulkUpdate(
		com.rknowsys.eapp.hrm.model.BulkUpdate bulkUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.updateBulkUpdate(bulkUpdate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bulkUpdateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bulkUpdateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bulkUpdateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.BulkUpdate> searchBulkUpdate(
		java.lang.String empname, java.lang.String empstatus,
		java.lang.String supervisorname, java.lang.String jobtitle,
		java.lang.String subunit, java.lang.String location,
		java.lang.String workshift, java.lang.String include, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bulkUpdateLocalService.searchBulkUpdate(empname, empstatus,
			supervisorname, jobtitle, subunit, location, workshift, include,
			begin, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BulkUpdateLocalService getWrappedBulkUpdateLocalService() {
		return _bulkUpdateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBulkUpdateLocalService(
		BulkUpdateLocalService bulkUpdateLocalService) {
		_bulkUpdateLocalService = bulkUpdateLocalService;
	}

	@Override
	public BulkUpdateLocalService getWrappedService() {
		return _bulkUpdateLocalService;
	}

	@Override
	public void setWrappedService(BulkUpdateLocalService bulkUpdateLocalService) {
		_bulkUpdateLocalService = bulkUpdateLocalService;
	}

	private BulkUpdateLocalService _bulkUpdateLocalService;
}