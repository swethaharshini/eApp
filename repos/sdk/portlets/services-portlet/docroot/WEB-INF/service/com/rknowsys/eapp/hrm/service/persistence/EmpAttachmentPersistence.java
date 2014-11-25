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

import com.rknowsys.eapp.hrm.model.EmpAttachment;

/**
 * The persistence interface for the EmpAttachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachmentPersistenceImpl
 * @see EmpAttachmentUtil
 * @generated
 */
public interface EmpAttachmentPersistence extends BasePersistence<EmpAttachment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpAttachmentUtil} to access the EmpAttachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EmpAttachments where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @return the matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpAttachments where empAttachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empAttachmentId the emp attachment ID
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @return the range of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpAttachments where empAttachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empAttachmentId the emp attachment ID
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment findByempAttachmentId_First(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment fetchByempAttachmentId_First(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment findByempAttachmentId_Last(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment fetchByempAttachmentId_Last(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpAttachments where empAttachmentId = &#63; from the database.
	*
	* @param empAttachmentId the emp attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByempAttachmentId(long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpAttachments where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @return the number of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByempAttachmentId(long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpAttachments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpAttachments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @return the range of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpAttachments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpAttachments before and after the current EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param empAttachmentId the primary key of the current EmpAttachment
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment[] findByemployeeId_PrevAndNext(
		long empAttachmentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Removes all the EmpAttachments where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpAttachments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the EmpAttachment in the entity cache if it is enabled.
	*
	* @param empAttachment the EmpAttachment
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment);

	/**
	* Caches the EmpAttachments in the entity cache if it is enabled.
	*
	* @param empAttachments the EmpAttachments
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> empAttachments);

	/**
	* Creates a new EmpAttachment with the primary key. Does not add the EmpAttachment to the database.
	*
	* @param empAttachmentId the primary key for the new EmpAttachment
	* @return the new EmpAttachment
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment create(
		long empAttachmentId);

	/**
	* Removes the EmpAttachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment remove(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	public com.rknowsys.eapp.hrm.model.EmpAttachment updateImpl(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmpAttachment with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException} if it could not be found.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment findByPrimaryKey(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;

	/**
	* Returns the EmpAttachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment, or <code>null</code> if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmpAttachment fetchByPrimaryKey(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmpAttachments.
	*
	* @return the EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmpAttachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @return the range of EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmpAttachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmpAttachments
	* @param end the upper bound of the range of EmpAttachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmpAttachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmpAttachments.
	*
	* @return the number of EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}