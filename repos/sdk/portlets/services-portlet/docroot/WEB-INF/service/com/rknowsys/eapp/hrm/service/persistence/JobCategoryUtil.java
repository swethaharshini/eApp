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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rknowsys.eapp.hrm.model.JobCategory;

import java.util.List;

/**
 * The persistence utility for the job category service. This utility wraps {@link JobCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobCategoryPersistence
 * @see JobCategoryPersistenceImpl
 * @generated
 */
public class JobCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(JobCategory jobCategory) {
		getPersistence().clearCache(jobCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JobCategory update(JobCategory jobCategory)
		throws SystemException {
		return getPersistence().update(jobCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JobCategory update(JobCategory jobCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jobCategory, serviceContext);
	}

	/**
	* Returns all the job categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job category, or <code>null</code> if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last job category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job category, or <code>null</code> if a matching job category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.JobCategory[] findByGroupId_PrevAndNext(
		long jobCategoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(jobCategoryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the job categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of job categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching job categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the job category in the entity cache if it is enabled.
	*
	* @param jobCategory the job category
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory) {
		getPersistence().cacheResult(jobCategory);
	}

	/**
	* Caches the job categories in the entity cache if it is enabled.
	*
	* @param jobCategories the job categories
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories) {
		getPersistence().cacheResult(jobCategories);
	}

	/**
	* Creates a new job category with the primary key. Does not add the job category to the database.
	*
	* @param jobCategoryId the primary key for the new job category
	* @return the new job category
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory create(
		long jobCategoryId) {
		return getPersistence().create(jobCategoryId);
	}

	/**
	* Removes the job category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory remove(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException {
		return getPersistence().remove(jobCategoryId);
	}

	public static com.rknowsys.eapp.hrm.model.JobCategory updateImpl(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jobCategory);
	}

	/**
	* Returns the job category with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobCategoryException} if it could not be found.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category
	* @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory findByPrimaryKey(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchJobCategoryException {
		return getPersistence().findByPrimaryKey(jobCategoryId);
	}

	/**
	* Returns the job category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category, or <code>null</code> if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory fetchByPrimaryKey(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jobCategoryId);
	}

	/**
	* Returns all the job categories.
	*
	* @return the job categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the job categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of job categories.
	*
	* @return the number of job categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the leave rule applicables associated with the job category.
	*
	* @param pk the primary key of the job category
	* @return the leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLeaveRuleApplicables(pk);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLeaveRuleApplicables(pk, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> getLeaveRuleApplicables(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getLeaveRuleApplicables(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of leave rule applicables associated with the job category.
	*
	* @param pk the primary key of the job category
	* @return the number of leave rule applicables associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public static int getLeaveRuleApplicablesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLeaveRuleApplicablesSize(pk);
	}

	/**
	* Returns <code>true</code> if the leave rule applicable is associated with the job category.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @return <code>true</code> if the leave rule applicable is associated with the job category; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLeaveRuleApplicable(long pk,
		long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .containsLeaveRuleApplicable(pk, leaveRuleApplicablePK);
	}

	/**
	* Returns <code>true</code> if the job category has any leave rule applicables associated with it.
	*
	* @param pk the primary key of the job category to check for associations with leave rule applicables
	* @return <code>true</code> if the job category has any leave rule applicables associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLeaveRuleApplicables(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsLeaveRuleApplicables(pk);
	}

	/**
	* Adds an association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicable(long pk,
		long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLeaveRuleApplicable(pk, leaveRuleApplicablePK);
	}

	/**
	* Adds an association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicable the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicable(long pk,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLeaveRuleApplicable(pk, leaveRuleApplicable);
	}

	/**
	* Adds an association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicables(long pk,
		long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLeaveRuleApplicables(pk, leaveRuleApplicablePKs);
	}

	/**
	* Adds an association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLeaveRuleApplicables(pk, leaveRuleApplicables);
	}

	/**
	* Clears all associations between the job category and its leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category to clear the associated leave rule applicables from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLeaveRuleApplicables(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearLeaveRuleApplicables(pk);
	}

	/**
	* Removes the association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePK the primary key of the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLeaveRuleApplicable(long pk,
		long leaveRuleApplicablePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLeaveRuleApplicable(pk, leaveRuleApplicablePK);
	}

	/**
	* Removes the association between the job category and the leave rule applicable. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicable the leave rule applicable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLeaveRuleApplicable(long pk,
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLeaveRuleApplicable(pk, leaveRuleApplicable);
	}

	/**
	* Removes the association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLeaveRuleApplicables(long pk,
		long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLeaveRuleApplicables(pk, leaveRuleApplicablePKs);
	}

	/**
	* Removes the association between the job category and the leave rule applicables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLeaveRuleApplicables(pk, leaveRuleApplicables);
	}

	/**
	* Sets the leave rule applicables associated with the job category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicablePKs the primary keys of the leave rule applicables to be associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void setLeaveRuleApplicables(long pk,
		long[] leaveRuleApplicablePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLeaveRuleApplicables(pk, leaveRuleApplicablePKs);
	}

	/**
	* Sets the leave rule applicables associated with the job category, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job category
	* @param leaveRuleApplicables the leave rule applicables to be associated with the job category
	* @throws SystemException if a system exception occurred
	*/
	public static void setLeaveRuleApplicables(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.LeaveRuleApplicable> leaveRuleApplicables)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLeaveRuleApplicables(pk, leaveRuleApplicables);
	}

	public static JobCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JobCategoryPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					JobCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(JobCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JobCategoryPersistence persistence) {
	}

	private static JobCategoryPersistence _persistence;
}