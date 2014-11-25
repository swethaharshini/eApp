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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException;
import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;
import com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the EmpEmergencyContact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpEmergencyContactPersistence
 * @see EmpEmergencyContactUtil
 * @generated
 */
public class EmpEmergencyContactPersistenceImpl extends BasePersistenceImpl<EmpEmergencyContact>
	implements EmpEmergencyContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpEmergencyContactUtil} to access the EmpEmergencyContact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpEmergencyContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID =
		new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempEmergencyContactId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID =
		new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempEmergencyContactId",
			new String[] { Long.class.getName() },
			EmpEmergencyContactModelImpl.EMPEMERGENCYCONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPEMERGENCYCONTACTID = new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempEmergencyContactId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @return the matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId) throws SystemException {
		return findByempEmergencyContactId(empEmergencyContactId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @return the range of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end)
		throws SystemException {
		return findByempEmergencyContactId(empEmergencyContactId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the EmpEmergencyContacts where empEmergencyContactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByempEmergencyContactId(
		long empEmergencyContactId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID;
			finderArgs = new Object[] { empEmergencyContactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID;
			finderArgs = new Object[] {
					empEmergencyContactId,
					
					start, end, orderByComparator
				};
		}

		List<EmpEmergencyContact> list = (List<EmpEmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpEmergencyContact empEmergencyContact : list) {
				if ((empEmergencyContactId != empEmergencyContact.getEmpEmergencyContactId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EMPEMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMPEMERGENCYCONTACTID_EMPEMERGENCYCONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpEmergencyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empEmergencyContactId);

				if (!pagination) {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpEmergencyContact>(list);
				}
				else {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByempEmergencyContactId_First(
		long empEmergencyContactId, OrderByComparator orderByComparator)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = fetchByempEmergencyContactId_First(empEmergencyContactId,
				orderByComparator);

		if (empEmergencyContact != null) {
			return empEmergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empEmergencyContactId=");
		msg.append(empEmergencyContactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the first EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByempEmergencyContactId_First(
		long empEmergencyContactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmpEmergencyContact> list = findByempEmergencyContactId(empEmergencyContactId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByempEmergencyContactId_Last(
		long empEmergencyContactId, OrderByComparator orderByComparator)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = fetchByempEmergencyContactId_Last(empEmergencyContactId,
				orderByComparator);

		if (empEmergencyContact != null) {
			return empEmergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empEmergencyContactId=");
		msg.append(empEmergencyContactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the last EmpEmergencyContact in the ordered set where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByempEmergencyContactId_Last(
		long empEmergencyContactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByempEmergencyContactId(empEmergencyContactId);

		if (count == 0) {
			return null;
		}

		List<EmpEmergencyContact> list = findByempEmergencyContactId(empEmergencyContactId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the EmpEmergencyContacts where empEmergencyContactId = &#63; from the database.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempEmergencyContactId(long empEmergencyContactId)
		throws SystemException {
		for (EmpEmergencyContact empEmergencyContact : findByempEmergencyContactId(
				empEmergencyContactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(empEmergencyContact);
		}
	}

	/**
	 * Returns the number of EmpEmergencyContacts where empEmergencyContactId = &#63;.
	 *
	 * @param empEmergencyContactId the emp emergency contact ID
	 * @return the number of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempEmergencyContactId(long empEmergencyContactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPEMERGENCYCONTACTID;

		Object[] finderArgs = new Object[] { empEmergencyContactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPEMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMPEMERGENCYCONTACTID_EMPEMERGENCYCONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empEmergencyContactId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPEMERGENCYCONTACTID_EMPEMERGENCYCONTACTID_2 =
		"empEmergencyContact.empEmergencyContactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmpEmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpEmergencyContactModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpEmergencyContacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpEmergencyContacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @return the range of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByemployeeId(long employeeId,
		int start, int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpEmergencyContacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<EmpEmergencyContact> list = (List<EmpEmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpEmergencyContact empEmergencyContact : list) {
				if ((employeeId != empEmergencyContact.getEmployeeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EMPEMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpEmergencyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpEmergencyContact>(list);
				}
				else {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empEmergencyContact != null) {
			return empEmergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the first EmpEmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpEmergencyContact> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empEmergencyContact != null) {
			return empEmergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the last EmpEmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpEmergencyContact, or <code>null</code> if a matching EmpEmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpEmergencyContact> list = findByemployeeId(employeeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the EmpEmergencyContacts before and after the current EmpEmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param empEmergencyContactId the primary key of the current EmpEmergencyContact
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact[] findByemployeeId_PrevAndNext(
		long empEmergencyContactId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = findByPrimaryKey(empEmergencyContactId);

		Session session = null;

		try {
			session = openSession();

			EmpEmergencyContact[] array = new EmpEmergencyContactImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session,
					empEmergencyContact, employeeId, orderByComparator, true);

			array[1] = empEmergencyContact;

			array[2] = getByemployeeId_PrevAndNext(session,
					empEmergencyContact, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpEmergencyContact getByemployeeId_PrevAndNext(Session session,
		EmpEmergencyContact empEmergencyContact, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPEMERGENCYCONTACT_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EmpEmergencyContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empEmergencyContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpEmergencyContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EmpEmergencyContacts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpEmergencyContact empEmergencyContact : findByemployeeId(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empEmergencyContact);
		}
	}

	/**
	 * Returns the number of EmpEmergencyContacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemployeeId(long employeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPEMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empEmergencyContact.employeeId = ?";

	public EmpEmergencyContactPersistenceImpl() {
		setModelClass(EmpEmergencyContact.class);
	}

	/**
	 * Caches the EmpEmergencyContact in the entity cache if it is enabled.
	 *
	 * @param empEmergencyContact the EmpEmergencyContact
	 */
	@Override
	public void cacheResult(EmpEmergencyContact empEmergencyContact) {
		EntityCacheUtil.putResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactImpl.class, empEmergencyContact.getPrimaryKey(),
			empEmergencyContact);

		empEmergencyContact.resetOriginalValues();
	}

	/**
	 * Caches the EmpEmergencyContacts in the entity cache if it is enabled.
	 *
	 * @param empEmergencyContacts the EmpEmergencyContacts
	 */
	@Override
	public void cacheResult(List<EmpEmergencyContact> empEmergencyContacts) {
		for (EmpEmergencyContact empEmergencyContact : empEmergencyContacts) {
			if (EntityCacheUtil.getResult(
						EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
						EmpEmergencyContactImpl.class,
						empEmergencyContact.getPrimaryKey()) == null) {
				cacheResult(empEmergencyContact);
			}
			else {
				empEmergencyContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpEmergencyContacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpEmergencyContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpEmergencyContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpEmergencyContact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpEmergencyContact empEmergencyContact) {
		EntityCacheUtil.removeResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactImpl.class, empEmergencyContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpEmergencyContact> empEmergencyContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpEmergencyContact empEmergencyContact : empEmergencyContacts) {
			EntityCacheUtil.removeResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
				EmpEmergencyContactImpl.class,
				empEmergencyContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpEmergencyContact with the primary key. Does not add the EmpEmergencyContact to the database.
	 *
	 * @param empEmergencyContactId the primary key for the new EmpEmergencyContact
	 * @return the new EmpEmergencyContact
	 */
	@Override
	public EmpEmergencyContact create(long empEmergencyContactId) {
		EmpEmergencyContact empEmergencyContact = new EmpEmergencyContactImpl();

		empEmergencyContact.setNew(true);
		empEmergencyContact.setPrimaryKey(empEmergencyContactId);

		return empEmergencyContact;
	}

	/**
	 * Removes the EmpEmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empEmergencyContactId the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact remove(long empEmergencyContactId)
		throws NoSuchEmpEmergencyContactException, SystemException {
		return remove((Serializable)empEmergencyContactId);
	}

	/**
	 * Removes the EmpEmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact remove(Serializable primaryKey)
		throws NoSuchEmpEmergencyContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpEmergencyContact empEmergencyContact = (EmpEmergencyContact)session.get(EmpEmergencyContactImpl.class,
					primaryKey);

			if (empEmergencyContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpEmergencyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empEmergencyContact);
		}
		catch (NoSuchEmpEmergencyContactException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmpEmergencyContact removeImpl(
		EmpEmergencyContact empEmergencyContact) throws SystemException {
		empEmergencyContact = toUnwrappedModel(empEmergencyContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empEmergencyContact)) {
				empEmergencyContact = (EmpEmergencyContact)session.get(EmpEmergencyContactImpl.class,
						empEmergencyContact.getPrimaryKeyObj());
			}

			if (empEmergencyContact != null) {
				session.delete(empEmergencyContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empEmergencyContact != null) {
			clearCache(empEmergencyContact);
		}

		return empEmergencyContact;
	}

	@Override
	public EmpEmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmpEmergencyContact empEmergencyContact)
		throws SystemException {
		empEmergencyContact = toUnwrappedModel(empEmergencyContact);

		boolean isNew = empEmergencyContact.isNew();

		EmpEmergencyContactModelImpl empEmergencyContactModelImpl = (EmpEmergencyContactModelImpl)empEmergencyContact;

		Session session = null;

		try {
			session = openSession();

			if (empEmergencyContact.isNew()) {
				session.save(empEmergencyContact);

				empEmergencyContact.setNew(false);
			}
			else {
				session.merge(empEmergencyContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpEmergencyContactModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empEmergencyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empEmergencyContactModelImpl.getOriginalEmpEmergencyContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPEMERGENCYCONTACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID,
					args);

				args = new Object[] {
						empEmergencyContactModelImpl.getEmpEmergencyContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPEMERGENCYCONTACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPEMERGENCYCONTACTID,
					args);
			}

			if ((empEmergencyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empEmergencyContactModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empEmergencyContactModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmpEmergencyContactImpl.class, empEmergencyContact.getPrimaryKey(),
			empEmergencyContact);

		return empEmergencyContact;
	}

	protected EmpEmergencyContact toUnwrappedModel(
		EmpEmergencyContact empEmergencyContact) {
		if (empEmergencyContact instanceof EmpEmergencyContactImpl) {
			return empEmergencyContact;
		}

		EmpEmergencyContactImpl empEmergencyContactImpl = new EmpEmergencyContactImpl();

		empEmergencyContactImpl.setNew(empEmergencyContact.isNew());
		empEmergencyContactImpl.setPrimaryKey(empEmergencyContact.getPrimaryKey());

		empEmergencyContactImpl.setEmpEmergencyContactId(empEmergencyContact.getEmpEmergencyContactId());
		empEmergencyContactImpl.setEmployeeId(empEmergencyContact.getEmployeeId());
		empEmergencyContactImpl.setGroupId(empEmergencyContact.getGroupId());
		empEmergencyContactImpl.setCompanyId(empEmergencyContact.getCompanyId());
		empEmergencyContactImpl.setUserId(empEmergencyContact.getUserId());
		empEmergencyContactImpl.setCreateDate(empEmergencyContact.getCreateDate());
		empEmergencyContactImpl.setModifiedDate(empEmergencyContact.getModifiedDate());
		empEmergencyContactImpl.setName(empEmergencyContact.getName());
		empEmergencyContactImpl.setRelationship(empEmergencyContact.getRelationship());
		empEmergencyContactImpl.setHomeTelephone(empEmergencyContact.getHomeTelephone());
		empEmergencyContactImpl.setMobile(empEmergencyContact.getMobile());
		empEmergencyContactImpl.setWorkTelephone(empEmergencyContact.getWorkTelephone());

		return empEmergencyContactImpl;
	}

	/**
	 * Returns the EmpEmergencyContact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpEmergencyContactException, SystemException {
		EmpEmergencyContact empEmergencyContact = fetchByPrimaryKey(primaryKey);

		if (empEmergencyContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpEmergencyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empEmergencyContact;
	}

	/**
	 * Returns the EmpEmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException} if it could not be found.
	 *
	 * @param empEmergencyContactId the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEmergencyContactException if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact findByPrimaryKey(long empEmergencyContactId)
		throws NoSuchEmpEmergencyContactException, SystemException {
		return findByPrimaryKey((Serializable)empEmergencyContactId);
	}

	/**
	 * Returns the EmpEmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact, or <code>null</code> if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpEmergencyContact empEmergencyContact = (EmpEmergencyContact)EntityCacheUtil.getResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
				EmpEmergencyContactImpl.class, primaryKey);

		if (empEmergencyContact == _nullEmpEmergencyContact) {
			return null;
		}

		if (empEmergencyContact == null) {
			Session session = null;

			try {
				session = openSession();

				empEmergencyContact = (EmpEmergencyContact)session.get(EmpEmergencyContactImpl.class,
						primaryKey);

				if (empEmergencyContact != null) {
					cacheResult(empEmergencyContact);
				}
				else {
					EntityCacheUtil.putResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
						EmpEmergencyContactImpl.class, primaryKey,
						_nullEmpEmergencyContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpEmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
					EmpEmergencyContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empEmergencyContact;
	}

	/**
	 * Returns the EmpEmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empEmergencyContactId the primary key of the EmpEmergencyContact
	 * @return the EmpEmergencyContact, or <code>null</code> if a EmpEmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEmergencyContact fetchByPrimaryKey(long empEmergencyContactId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empEmergencyContactId);
	}

	/**
	 * Returns all the EmpEmergencyContacts.
	 *
	 * @return the EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpEmergencyContacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @return the range of EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpEmergencyContacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpEmergencyContacts
	 * @param end the upper bound of the range of EmpEmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEmergencyContact> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmpEmergencyContact> list = (List<EmpEmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPEMERGENCYCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPEMERGENCYCONTACT;

				if (pagination) {
					sql = sql.concat(EmpEmergencyContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpEmergencyContact>(list);
				}
				else {
					list = (List<EmpEmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the EmpEmergencyContacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpEmergencyContact empEmergencyContact : findAll()) {
			remove(empEmergencyContact);
		}
	}

	/**
	 * Returns the number of EmpEmergencyContacts.
	 *
	 * @return the number of EmpEmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPEMERGENCYCONTACT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the EmpEmergencyContact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpEmergencyContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpEmergencyContact>> listenersList = new ArrayList<ModelListener<EmpEmergencyContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpEmergencyContact>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmpEmergencyContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPEMERGENCYCONTACT = "SELECT empEmergencyContact FROM EmpEmergencyContact empEmergencyContact";
	private static final String _SQL_SELECT_EMPEMERGENCYCONTACT_WHERE = "SELECT empEmergencyContact FROM EmpEmergencyContact empEmergencyContact WHERE ";
	private static final String _SQL_COUNT_EMPEMERGENCYCONTACT = "SELECT COUNT(empEmergencyContact) FROM EmpEmergencyContact empEmergencyContact";
	private static final String _SQL_COUNT_EMPEMERGENCYCONTACT_WHERE = "SELECT COUNT(empEmergencyContact) FROM EmpEmergencyContact empEmergencyContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empEmergencyContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpEmergencyContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpEmergencyContact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpEmergencyContactPersistenceImpl.class);
	private static EmpEmergencyContact _nullEmpEmergencyContact = new EmpEmergencyContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpEmergencyContact> toCacheModel() {
				return _nullEmpEmergencyContactCacheModel;
			}
		};

	private static CacheModel<EmpEmergencyContact> _nullEmpEmergencyContactCacheModel =
		new CacheModel<EmpEmergencyContact>() {
			@Override
			public EmpEmergencyContact toEntityModel() {
				return _nullEmpEmergencyContact;
			}
		};
}