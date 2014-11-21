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

package com.rknowsys.eapp.hrm.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rknowsys.eapp.hrm.model.EmploymentStatus;

/**
 * The persistence interface for the employment status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmploymentStatusPersistenceImpl
 * @see EmploymentStatusUtil
 * @generated
 */
public interface EmploymentStatusPersistence extends BasePersistence<EmploymentStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmploymentStatusUtil} to access the employment status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employment status in the entity cache if it is enabled.
	*
	* @param employmentStatus the employment status
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus);

	/**
	* Caches the employment statuses in the entity cache if it is enabled.
	*
	* @param employmentStatuses the employment statuses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses);

	/**
	* Creates a new employment status with the primary key. Does not add the employment status to the database.
	*
	* @param employmentStatusId the primary key for the new employment status
	* @return the new employment status
	*/
	public com.rknowsys.eapp.hrm.model.EmploymentStatus create(
		long employmentStatusId);

	/**
	* Removes the employment status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmploymentStatus remove(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException;

	public com.rknowsys.eapp.hrm.model.EmploymentStatus updateImpl(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the employment status with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException} if it could not be found.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status
	* @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmploymentStatus findByPrimaryKey(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException;

	/**
	* Returns the employment status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employmentStatusId the primary key of the employment status
	* @return the employment status, or <code>null</code> if a employment status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmploymentStatus fetchByPrimaryKey(
		long employmentStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employment statuses.
	*
	* @return the employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employment statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employment statuses
	* @param end the upper bound of the range of employment statuses (not inclusive)
	* @return the range of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employment statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employment statuses
	* @param end the upper bound of the range of employment statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmploymentStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the employment statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employment statuses.
	*
	* @return the number of employment statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave type applicabilities associated with the employment status.
	*
	* @param pk the primary key of the employment status
	* @return the leave type applicabilities associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave type applicabilities associated with the employment status.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the employment status
	* @param start the lower bound of the range of employment statuses
	* @param end the upper bound of the range of employment statuses (not inclusive)
	* @return the range of leave type applicabilities associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave type applicabilities associated with the employment status.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the employment status
	* @param start the lower bound of the range of employment statuses
	* @param end the upper bound of the range of employment statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave type applicabilities associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave type applicabilities associated with the employment status.
	*
	* @param pk the primary key of the employment status
	* @return the number of leave type applicabilities associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public int getLeaveTypeApplicabilitiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave type applicability is associated with the employment status.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @return <code>true</code> if the leave type applicability is associated with the employment status; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveTypeApplicability(long pk,
		long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the employment status has any leave type applicabilities associated with it.
	*
	* @param pk the primary key of the employment status to check for associations with leave type applicabilities
	* @return <code>true</code> if the employment status has any leave type applicabilities associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveTypeApplicabilities(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the employment status and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicability(long pk, long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the employment status and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicability the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicability(long pk,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the employment status and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the employment status and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilities the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the employment status and its leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status to clear the associated leave type applicabilities from
	* @throws SystemException if a system exception occurred
	*/
	public void clearLeaveTypeApplicabilities(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the employment status and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicability(long pk,
		long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the employment status and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicability the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicability(long pk,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the employment status and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the employment status and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilities the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave type applicabilities associated with the employment status, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities to be associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave type applicabilities associated with the employment status, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the employment status
	* @param leaveTypeApplicabilities the leave type applicabilities to be associated with the employment status
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;
}