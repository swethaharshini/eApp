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
 * Provides a wrapper for {@link EmpJobLocalService}.
 *
 * @author rknowsys
 * @see EmpJobLocalService
 * @generated
 */
public class EmpJobLocalServiceWrapper implements EmpJobLocalService,
	ServiceWrapper<EmpJobLocalService> {
	public EmpJobLocalServiceWrapper(EmpJobLocalService empJobLocalService) {
		_empJobLocalService = empJobLocalService;
	}

	/**
	* Adds the emp job to the database. Also notifies the appropriate model listeners.
	*
	* @param empJob the emp job
	* @return the emp job that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob addEmpJob(
		com.rknowsys.eapp.hrm.model.EmpJob empJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.addEmpJob(empJob);
	}

	/**
	* Creates a new emp job with the primary key. Does not add the emp job to the database.
	*
	* @param empJobId the primary key for the new emp job
	* @return the new emp job
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob createEmpJob(long empJobId) {
		return _empJobLocalService.createEmpJob(empJobId);
	}

	/**
	* Deletes the emp job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empJobId the primary key of the emp job
	* @return the emp job that was removed
	* @throws PortalException if a emp job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob deleteEmpJob(long empJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.deleteEmpJob(empJobId);
	}

	/**
	* Deletes the emp job from the database. Also notifies the appropriate model listeners.
	*
	* @param empJob the emp job
	* @return the emp job that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob deleteEmpJob(
		com.rknowsys.eapp.hrm.model.EmpJob empJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.deleteEmpJob(empJob);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empJobLocalService.dynamicQuery();
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
		return _empJobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empJobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empJobLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _empJobLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empJobLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob fetchEmpJob(long empJobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.fetchEmpJob(empJobId);
	}

	/**
	* Returns the emp job with the primary key.
	*
	* @param empJobId the primary key of the emp job
	* @return the emp job
	* @throws PortalException if a emp job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob getEmpJob(long empJobId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.getEmpJob(empJobId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp jobs
	* @param end the upper bound of the range of emp jobs (not inclusive)
	* @return the range of emp jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpJob> getEmpJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.getEmpJobs(start, end);
	}

	/**
	* Returns the number of emp jobs.
	*
	* @return the number of emp jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.getEmpJobsCount();
	}

	/**
	* Updates the emp job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empJob the emp job
	* @return the emp job that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob updateEmpJob(
		com.rknowsys.eapp.hrm.model.EmpJob empJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.updateEmpJob(empJob);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpJobContractDetailsBlobModel getContractDetailsBlobModel(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empJobLocalService.getContractDetailsBlobModel(primaryKey);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empJobLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empJobLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empJobLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns EmpJob based on the give EmployeeId.
	*
	* @param EmployeeId
	* @return the emp job
	* @throws SystemException if a system exception occurred
	* @author Laxminarayana 27 october 2014 7:39:55 PM
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpJob getEmpJobByEmpId(long empid) {
		return _empJobLocalService.getEmpJobByEmpId(empid);
	}

	/**
	* Returns EmpJob list based on the give shiftId.
	*
	* @param shiftId
	* @return the empjob list
	* @throws SystemException if a system exception occurred
	* @author Laxminarayana 29 october 2014 6:38:55 PM
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpJob> findEmpJobListByShiftId(
		long shiftId) {
		return _empJobLocalService.findEmpJobListByShiftId(shiftId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpJobLocalService getWrappedEmpJobLocalService() {
		return _empJobLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpJobLocalService(
		EmpJobLocalService empJobLocalService) {
		_empJobLocalService = empJobLocalService;
	}

	@Override
	public EmpJobLocalService getWrappedService() {
		return _empJobLocalService;
	}

	@Override
	public void setWrappedService(EmpJobLocalService empJobLocalService) {
		_empJobLocalService = empJobLocalService;
	}

	private EmpJobLocalService _empJobLocalService;
}