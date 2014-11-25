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

import com.rknowsys.eapp.hrm.model.JobTitle;

/**
 * The persistence interface for the job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobTitlePersistenceImpl
 * @see JobTitleUtil
 * @generated
 */
public interface JobTitlePersistence extends BasePersistence<JobTitle> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobTitleUtil} to access the job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the job titles where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job titles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @return the range of matching job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job titles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job title in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job title
	* @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a matching job title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobTitleException;

	/**
	* Returns the first job title in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job title, or <code>null</code> if a matching job title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job title in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job title
	* @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a matching job title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobTitleException;

	/**
	* Returns the last job title in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job title, or <code>null</code> if a matching job title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job titles before and after the current job title in the ordered set where groupId = &#63;.
	*
	* @param jobTitleId the primary key of the current job title
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job title
	* @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle[] findByGroupId_PrevAndNext(
		long jobTitleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobTitleException;

	/**
	* Removes all the job titles where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job titles where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching job titles
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the job title in the entity cache if it is enabled.
	*
	* @param jobTitle the job title
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.JobTitle jobTitle);

	/**
	* Caches the job titles in the entity cache if it is enabled.
	*
	* @param jobTitles the job titles
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles);

	/**
	* Creates a new job title with the primary key. Does not add the job title to the database.
	*
	* @param jobTitleId the primary key for the new job title
	* @return the new job title
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle create(long jobTitleId);

	/**
	* Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobTitleId the primary key of the job title
	* @return the job title that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle remove(long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobTitleException;

	public com.rknowsys.eapp.hrm.model.JobTitle updateImpl(
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job title with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobTitleException} if it could not be found.
	*
	* @param jobTitleId the primary key of the job title
	* @return the job title
	* @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle findByPrimaryKey(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobTitleException;

	/**
	* Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobTitleId the primary key of the job title
	* @return the job title, or <code>null</code> if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobTitle fetchByPrimaryKey(
		long jobTitleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job titles.
	*
	* @return the job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @return the range of job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job titles.
	*
	* @return the number of job titles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave type applicabilities associated with the job title.
	*
	* @param pk the primary key of the job title
	* @return the leave type applicabilities associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave type applicabilities associated with the job title.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job title
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @return the range of leave type applicabilities associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave type applicabilities associated with the job title.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job title
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave type applicabilities associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> getLeaveTypeApplicabilities(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave type applicabilities associated with the job title.
	*
	* @param pk the primary key of the job title
	* @return the number of leave type applicabilities associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public int getLeaveTypeApplicabilitiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave type applicability is associated with the job title.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @return <code>true</code> if the leave type applicability is associated with the job title; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveTypeApplicability(long pk,
		long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job title has any leave type applicabilities associated with it.
	*
	* @param pk the primary key of the job title to check for associations with leave type applicabilities
	* @return <code>true</code> if the job title has any leave type applicabilities associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveTypeApplicabilities(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job title and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicability(long pk, long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job title and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicability the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicability(long pk,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job title and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job title and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilities the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the job title and its leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title to clear the associated leave type applicabilities from
	* @throws SystemException if a system exception occurred
	*/
	public void clearLeaveTypeApplicabilities(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job title and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPK the primary key of the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicability(long pk,
		long leaveTypeApplicabilityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job title and the leave type applicability. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicability the leave type applicability
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicability(long pk,
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job title and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job title and the leave type applicabilities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilities the leave type applicabilities
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave type applicabilities associated with the job title, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilityPKs the primary keys of the leave type applicabilities to be associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveTypeApplicabilities(long pk,
		long[] leaveTypeApplicabilityPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave type applicabilities associated with the job title, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job title
	* @param leaveTypeApplicabilities the leave type applicabilities to be associated with the job title
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveTypeApplicabilities(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveTypeApplicability> leaveTypeApplicabilities)
		throws com.liferay.portal.kernel.exception.SystemException;
}