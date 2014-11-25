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

import com.rknowsys.eapp.hrm.model.SalaryComponent;

/**
 * The persistence interface for the salary component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SalaryComponentPersistenceImpl
 * @see SalaryComponentUtil
 * @generated
 */
public interface SalaryComponentPersistence extends BasePersistence<SalaryComponent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalaryComponentUtil} to access the salary component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the salary components where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Returns the first salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Returns the last salary component in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the salary components before and after the current salary component in the ordered set where groupId = &#63;.
	*
	* @param salaryComponentId the primary key of the current salary component
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent[] findByGroupId_PrevAndNext(
		long salaryComponentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Removes all the salary components where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of salary components where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the salary components where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @return the matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the salary components where salaryComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param salaryComponentId the salary component ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the salary components where salaryComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param salaryComponentId the salary component ID
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent findBysalaryComponentId_First(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchBysalaryComponentId_First(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent findBysalaryComponentId_Last(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchBysalaryComponentId_Last(
		long salaryComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the salary components where salaryComponentId = &#63; from the database.
	*
	* @param salaryComponentId the salary component ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysalaryComponentId(long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of salary components where salaryComponentId = &#63;.
	*
	* @param salaryComponentId the salary component ID
	* @return the number of matching salary components
	* @throws SystemException if a system exception occurred
	*/
	public int countBysalaryComponentId(long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the salary component in the entity cache if it is enabled.
	*
	* @param salaryComponent the salary component
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent);

	/**
	* Caches the salary components in the entity cache if it is enabled.
	*
	* @param salaryComponents the salary components
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> salaryComponents);

	/**
	* Creates a new salary component with the primary key. Does not add the salary component to the database.
	*
	* @param salaryComponentId the primary key for the new salary component
	* @return the new salary component
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent create(
		long salaryComponentId);

	/**
	* Removes the salary component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent remove(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	public com.rknowsys.eapp.hrm.model.SalaryComponent updateImpl(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the salary component with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSalaryComponentException} if it could not be found.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component
	* @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent findByPrimaryKey(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;

	/**
	* Returns the salary component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param salaryComponentId the primary key of the salary component
	* @return the salary component, or <code>null</code> if a salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.SalaryComponent fetchByPrimaryKey(
		long salaryComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the salary components.
	*
	* @return the salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @return the range of salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salary components
	* @param end the upper bound of the range of salary components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of salary components
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the salary components from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of salary components.
	*
	* @return the number of salary components
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}