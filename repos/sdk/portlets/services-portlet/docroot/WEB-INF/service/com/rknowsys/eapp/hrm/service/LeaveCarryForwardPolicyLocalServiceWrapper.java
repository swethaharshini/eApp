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
 * Provides a wrapper for {@link LeaveCarryForwardPolicyLocalService}.
 *
 * @author rknowsys
 * @see LeaveCarryForwardPolicyLocalService
 * @generated
 */
public class LeaveCarryForwardPolicyLocalServiceWrapper
	implements LeaveCarryForwardPolicyLocalService,
		ServiceWrapper<LeaveCarryForwardPolicyLocalService> {
	public LeaveCarryForwardPolicyLocalServiceWrapper(
		LeaveCarryForwardPolicyLocalService leaveCarryForwardPolicyLocalService) {
		_leaveCarryForwardPolicyLocalService = leaveCarryForwardPolicyLocalService;
	}

	/**
	* Adds the leave carry forward policy to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveCarryForwardPolicy the leave carry forward policy
	* @return the leave carry forward policy that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy addLeaveCarryForwardPolicy(
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.addLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
	}

	/**
	* Creates a new leave carry forward policy with the primary key. Does not add the leave carry forward policy to the database.
	*
	* @param leaveCarryForwardPolicyId the primary key for the new leave carry forward policy
	* @return the new leave carry forward policy
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy createLeaveCarryForwardPolicy(
		long leaveCarryForwardPolicyId) {
		return _leaveCarryForwardPolicyLocalService.createLeaveCarryForwardPolicy(leaveCarryForwardPolicyId);
	}

	/**
	* Deletes the leave carry forward policy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveCarryForwardPolicyId the primary key of the leave carry forward policy
	* @return the leave carry forward policy that was removed
	* @throws PortalException if a leave carry forward policy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy deleteLeaveCarryForwardPolicy(
		long leaveCarryForwardPolicyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.deleteLeaveCarryForwardPolicy(leaveCarryForwardPolicyId);
	}

	/**
	* Deletes the leave carry forward policy from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveCarryForwardPolicy the leave carry forward policy
	* @return the leave carry forward policy that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy deleteLeaveCarryForwardPolicy(
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.deleteLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveCarryForwardPolicyLocalService.dynamicQuery();
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
		return _leaveCarryForwardPolicyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveCarryForwardPolicyLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaveCarryForwardPolicyLocalService.dynamicQuery(dynamicQuery,
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
		return _leaveCarryForwardPolicyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaveCarryForwardPolicyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy fetchLeaveCarryForwardPolicy(
		long leaveCarryForwardPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.fetchLeaveCarryForwardPolicy(leaveCarryForwardPolicyId);
	}

	/**
	* Returns the leave carry forward policy with the primary key.
	*
	* @param leaveCarryForwardPolicyId the primary key of the leave carry forward policy
	* @return the leave carry forward policy
	* @throws PortalException if a leave carry forward policy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy getLeaveCarryForwardPolicy(
		long leaveCarryForwardPolicyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.getLeaveCarryForwardPolicy(leaveCarryForwardPolicyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leave carry forward policies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave carry forward policies
	* @param end the upper bound of the range of leave carry forward policies (not inclusive)
	* @return the range of leave carry forward policies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy> getLeaveCarryForwardPolicies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.getLeaveCarryForwardPolicies(start,
			end);
	}

	/**
	* Returns the number of leave carry forward policies.
	*
	* @return the number of leave carry forward policies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaveCarryForwardPoliciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.getLeaveCarryForwardPoliciesCount();
	}

	/**
	* Updates the leave carry forward policy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveCarryForwardPolicy the leave carry forward policy
	* @return the leave carry forward policy that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy updateLeaveCarryForwardPolicy(
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.updateLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaveCarryForwardPolicyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaveCarryForwardPolicyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaveCarryForwardPolicyLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy> findByLeaveTypeId(
		long leaveTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaveCarryForwardPolicyLocalService.findByLeaveTypeId(leaveTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaveCarryForwardPolicyLocalService getWrappedLeaveCarryForwardPolicyLocalService() {
		return _leaveCarryForwardPolicyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaveCarryForwardPolicyLocalService(
		LeaveCarryForwardPolicyLocalService leaveCarryForwardPolicyLocalService) {
		_leaveCarryForwardPolicyLocalService = leaveCarryForwardPolicyLocalService;
	}

	@Override
	public LeaveCarryForwardPolicyLocalService getWrappedService() {
		return _leaveCarryForwardPolicyLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveCarryForwardPolicyLocalService leaveCarryForwardPolicyLocalService) {
		_leaveCarryForwardPolicyLocalService = leaveCarryForwardPolicyLocalService;
	}

	private LeaveCarryForwardPolicyLocalService _leaveCarryForwardPolicyLocalService;
}