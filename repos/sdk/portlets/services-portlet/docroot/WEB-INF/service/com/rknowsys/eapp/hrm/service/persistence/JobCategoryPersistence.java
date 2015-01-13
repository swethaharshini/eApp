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

import com.rknowsys.eapp.hrm.model.JobCategory;

/**
 * The persistence interface for the job category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobCategoryPersistenceImpl
 * @see JobCategoryUtil
 * @generated
 */
public interface JobCategoryPersistence extends BasePersistence<JobCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobCategoryUtil} to access the job category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the job categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @return the range of matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException;

	/**
	* Returns the first job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job category, or <code>null</code> if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException;

	/**
	* Returns the last job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job category, or <code>null</code> if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job categories before and after the current job category in the ordered set where groupId = &#63;.
	*
	* @param jobCategoryId the primary key of the current job category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory[] findByGroupId_PrevAndNext(
		long jobCategoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException;

	/**
	* Removes all the job categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the job category in the entity cache if it is enabled.
	*
	* @param jobCategory the job category
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.JobCategory jobCategory);

	/**
	* Caches the job categories in the entity cache if it is enabled.
	*
	* @param jobCategories the job categories
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories);

	/**
	* Creates a new job category with the primary key. Does not add the job category to the database.
	*
	* @param jobCategoryId the primary key for the new job category
	* @return the new job category
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory create(long jobCategoryId);

	/**
	* Removes the job category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory remove(long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException;

	public com.rknowsys.eapp.hrm.model.JobCategory updateImpl(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job category with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobCategoryException} if it could not be found.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory findByPrimaryKey(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException;

	/**
	* Returns the job category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category, or <code>null</code> if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.JobCategory fetchByPrimaryKey(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job categories.
	*
	* @return the job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @return the range of job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job categories.
	*
	* @return the number of job categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leave rule applicables associated with the job category.
	*
	* @param pk the primary key of the job category
	* @return the leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leave rule applicables associated with the job category.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job category
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @return the range of leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leave rule applicables associated with the job category.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job category
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leave rule applicables associated with the job category.
	*
	* @param pk the primary key of the job category
	* @return the number of leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public int getLeaveRuleApplicablesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the leave rule applicable is associated with the job category.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @return <code>true</code> if the leave rule applicable is associated with the job category; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveRuleApplicable(long pk,
		long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job category has any leave rule applicables associated with it.
	*
	* @param pk the primary key of the job category to check for associations with leave rule applicables
	* @return <code>true</code> if the job category has any leave rule applicables associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLeaveRuleApplicables(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveRuleApplicable(long pk, long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicable the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveRuleApplicable(long pk,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveRuleApplicables(long pk, long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public void addLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the job category and its leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category to clear the associated leave rule applicables from
	* @throws SystemException if a system exception occurred
	*/
	public void clearLeaveRuleApplicables(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveRuleApplicable(long pk, long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicable the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveRuleApplicable(long pk,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveRuleApplicables(long pk,
		long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public void removeLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave rule applicables associated with the job category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables to be associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveRuleApplicables(long pk, long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the leave rule applicables associated with the job category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables to be associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public void setLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException;
}