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

import com.rknowsys.eapp.hrm.model.EmpAttachment;

import java.util.List;

/**
 * The persistence utility for the EmpAttachment service. This utility wraps {@link EmpAttachmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachmentPersistence
 * @see EmpAttachmentPersistenceImpl
 * @generated
 */
public class EmpAttachmentUtil {
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
	public static void clearCache(EmpAttachment empAttachment) {
		getPersistence().clearCache(empAttachment);
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
	public static List<EmpAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpAttachment update(EmpAttachment empAttachment)
		throws SystemException {
		return getPersistence().update(empAttachment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpAttachment update(EmpAttachment empAttachment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empAttachment, serviceContext);
	}

	/**
	* Returns all the EmpAttachments where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @return the matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByempAttachmentId(empAttachmentId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempAttachmentId(empAttachmentId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByempAttachmentId(
		long empAttachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByempAttachmentId(empAttachmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment findByempAttachmentId_First(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence()
				   .findByempAttachmentId_First(empAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment fetchByempAttachmentId_First(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempAttachmentId_First(empAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment findByempAttachmentId_Last(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence()
				   .findByempAttachmentId_Last(empAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment fetchByempAttachmentId_Last(
		long empAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByempAttachmentId_Last(empAttachmentId,
			orderByComparator);
	}

	/**
	* Removes all the EmpAttachments where empAttachmentId = &#63; from the database.
	*
	* @param empAttachmentId the emp attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByempAttachmentId(long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByempAttachmentId(empAttachmentId);
	}

	/**
	* Returns the number of EmpAttachments where empAttachmentId = &#63;.
	*
	* @param empAttachmentId the emp attachment ID
	* @return the number of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByempAttachmentId(long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByempAttachmentId(empAttachmentId);
	}

	/**
	* Returns all the EmpAttachments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.EmpAttachment[] findByemployeeId_PrevAndNext(
		long empAttachmentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(empAttachmentId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the EmpAttachments where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of EmpAttachments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Caches the EmpAttachment in the entity cache if it is enabled.
	*
	* @param empAttachment the EmpAttachment
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment) {
		getPersistence().cacheResult(empAttachment);
	}

	/**
	* Caches the EmpAttachments in the entity cache if it is enabled.
	*
	* @param empAttachments the EmpAttachments
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> empAttachments) {
		getPersistence().cacheResult(empAttachments);
	}

	/**
	* Creates a new EmpAttachment with the primary key. Does not add the EmpAttachment to the database.
	*
	* @param empAttachmentId the primary key for the new EmpAttachment
	* @return the new EmpAttachment
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment create(
		long empAttachmentId) {
		return getPersistence().create(empAttachmentId);
	}

	/**
	* Removes the EmpAttachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment remove(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence().remove(empAttachmentId);
	}

	public static com.rknowsys.eapp.hrm.model.EmpAttachment updateImpl(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empAttachment);
	}

	/**
	* Returns the EmpAttachment with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException} if it could not be found.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment
	* @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment findByPrimaryKey(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException {
		return getPersistence().findByPrimaryKey(empAttachmentId);
	}

	/**
	* Returns the EmpAttachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empAttachmentId the primary key of the EmpAttachment
	* @return the EmpAttachment, or <code>null</code> if a EmpAttachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmpAttachment fetchByPrimaryKey(
		long empAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empAttachmentId);
	}

	/**
	* Returns all the EmpAttachments.
	*
	* @return the EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the EmpAttachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of EmpAttachments.
	*
	* @return the number of EmpAttachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpAttachmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpAttachmentPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpAttachmentPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpAttachmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpAttachmentPersistence persistence) {
	}

	private static EmpAttachmentPersistence _persistence;
}