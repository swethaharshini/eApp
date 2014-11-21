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

import com.rknowsys.eapp.hrm.model.Employee;

/**
 * The persistence interface for the Employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmployeePersistenceImpl
 * @see EmployeeUtil
 * @generated
 */
public interface EmployeePersistence extends BasePersistence<Employee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the Employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException;

	/**
	* Returns the first Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException;

	/**
	* Returns the last Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Employees where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Employee in the entity cache if it is enabled.
	*
	* @param employee the Employee
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Employee employee);

	/**
	* Caches the Employees in the entity cache if it is enabled.
	*
	* @param employees the Employees
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees);

	/**
	* Creates a new Employee with the primary key. Does not add the Employee to the database.
	*
	* @param employeeId the primary key for the new Employee
	* @return the new Employee
	*/
	public com.rknowsys.eapp.hrm.model.Employee create(long employeeId);

	/**
	* Removes the Employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee remove(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException;

	public com.rknowsys.eapp.hrm.model.Employee updateImpl(
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Employee with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee findByPrimaryKey(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException;

	/**
	* Returns the Employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee, or <code>null</code> if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Employee fetchByPrimaryKey(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Employees.
	*
	* @return the Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Employees.
	*
	* @return the number of Employees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workshifts associated with the Employee.
	*
	* @param pk the primary key of the Employee
	* @return the workshifts associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getWorkshifts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workshifts associated with the Employee.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the Employee
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of workshifts associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getWorkshifts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workshifts associated with the Employee.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the Employee
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workshifts associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Workshift> getWorkshifts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workshifts associated with the Employee.
	*
	* @param pk the primary key of the Employee
	* @return the number of workshifts associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public int getWorkshiftsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workshift is associated with the Employee.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPK the primary key of the workshift
	* @return <code>true</code> if the workshift is associated with the Employee; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkshift(long pk, long workshiftPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Employee has any workshifts associated with it.
	*
	* @param pk the primary key of the Employee to check for associations with workshifts
	* @return <code>true</code> if the Employee has any workshifts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkshifts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Employee and the workshift. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPK the primary key of the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkshift(long pk, long workshiftPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Employee and the workshift. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshift the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkshift(long pk,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Employee and the workshifts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPKs the primary keys of the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkshifts(long pk, long[] workshiftPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Employee and the workshifts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshifts the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkshifts(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> workshifts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the Employee and its workshifts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee to clear the associated workshifts from
	* @throws SystemException if a system exception occurred
	*/
	public void clearWorkshifts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Employee and the workshift. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPK the primary key of the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkshift(long pk, long workshiftPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Employee and the workshift. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshift the workshift
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkshift(long pk,
		com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Employee and the workshifts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPKs the primary keys of the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkshifts(long pk, long[] workshiftPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Employee and the workshifts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshifts the workshifts
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkshifts(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> workshifts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workshifts associated with the Employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshiftPKs the primary keys of the workshifts to be associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkshifts(long pk, long[] workshiftPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workshifts associated with the Employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Employee
	* @param workshifts the workshifts to be associated with the Employee
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkshifts(long pk,
		java.util.List<com.rknowsys.eapp.hrm.model.Workshift> workshifts)
		throws com.liferay.portal.kernel.exception.SystemException;
}