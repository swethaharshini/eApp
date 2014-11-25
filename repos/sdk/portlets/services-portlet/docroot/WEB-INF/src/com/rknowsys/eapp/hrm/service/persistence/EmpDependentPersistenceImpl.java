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

import com.rknowsys.eapp.hrm.NoSuchEmpDependentException;
import com.rknowsys.eapp.hrm.model.EmpDependent;
import com.rknowsys.eapp.hrm.model.impl.EmpDependentImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp dependent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpDependentPersistence
 * @see EmpDependentUtil
 * @generated
 */
public class EmpDependentPersistenceImpl extends BasePersistenceImpl<EmpDependent>
	implements EmpDependentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpDependentUtil} to access the emp dependent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpDependentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPDEPENDENTID =
		new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempDependentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDEPENDENTID =
		new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempDependentId",
			new String[] { Long.class.getName() },
			EmpDependentModelImpl.EMPDEPENDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPDEPENDENTID = new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempDependentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp dependents where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @return the matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByempDependentId(long empDependentId)
		throws SystemException {
		return findByempDependentId(empDependentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp dependents where empDependentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empDependentId the emp dependent ID
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @return the range of matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByempDependentId(long empDependentId,
		int start, int end) throws SystemException {
		return findByempDependentId(empDependentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp dependents where empDependentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empDependentId the emp dependent ID
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByempDependentId(long empDependentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDEPENDENTID;
			finderArgs = new Object[] { empDependentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPDEPENDENTID;
			finderArgs = new Object[] {
					empDependentId,
					
					start, end, orderByComparator
				};
		}

		List<EmpDependent> list = (List<EmpDependent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpDependent empDependent : list) {
				if ((empDependentId != empDependent.getEmpDependentId())) {
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

			query.append(_SQL_SELECT_EMPDEPENDENT_WHERE);

			query.append(_FINDER_COLUMN_EMPDEPENDENTID_EMPDEPENDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpDependentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empDependentId);

				if (!pagination) {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDependent>(list);
				}
				else {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first emp dependent in the ordered set where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByempDependentId_First(long empDependentId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = fetchByempDependentId_First(empDependentId,
				orderByComparator);

		if (empDependent != null) {
			return empDependent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empDependentId=");
		msg.append(empDependentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDependentException(msg.toString());
	}

	/**
	 * Returns the first emp dependent in the ordered set where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp dependent, or <code>null</code> if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByempDependentId_First(long empDependentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpDependent> list = findByempDependentId(empDependentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp dependent in the ordered set where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByempDependentId_Last(long empDependentId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = fetchByempDependentId_Last(empDependentId,
				orderByComparator);

		if (empDependent != null) {
			return empDependent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empDependentId=");
		msg.append(empDependentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDependentException(msg.toString());
	}

	/**
	 * Returns the last emp dependent in the ordered set where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp dependent, or <code>null</code> if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByempDependentId_Last(long empDependentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByempDependentId(empDependentId);

		if (count == 0) {
			return null;
		}

		List<EmpDependent> list = findByempDependentId(empDependentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the emp dependents where empDependentId = &#63; from the database.
	 *
	 * @param empDependentId the emp dependent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempDependentId(long empDependentId)
		throws SystemException {
		for (EmpDependent empDependent : findByempDependentId(empDependentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empDependent);
		}
	}

	/**
	 * Returns the number of emp dependents where empDependentId = &#63;.
	 *
	 * @param empDependentId the emp dependent ID
	 * @return the number of matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempDependentId(long empDependentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPDEPENDENTID;

		Object[] finderArgs = new Object[] { empDependentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPDEPENDENT_WHERE);

			query.append(_FINDER_COLUMN_EMPDEPENDENTID_EMPDEPENDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empDependentId);

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

	private static final String _FINDER_COLUMN_EMPDEPENDENTID_EMPDEPENDENTID_2 = "empDependent.empDependentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, EmpDependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpDependentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp dependents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp dependents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @return the range of matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp dependents where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<EmpDependent> list = (List<EmpDependent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpDependent empDependent : list) {
				if ((employeeId != empDependent.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPDEPENDENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpDependentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDependent>(list);
				}
				else {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first emp dependent in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empDependent != null) {
			return empDependent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDependentException(msg.toString());
	}

	/**
	 * Returns the first emp dependent in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp dependent, or <code>null</code> if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpDependent> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp dependent in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empDependent != null) {
			return empDependent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDependentException(msg.toString());
	}

	/**
	 * Returns the last emp dependent in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp dependent, or <code>null</code> if a matching emp dependent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpDependent> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp dependents before and after the current emp dependent in the ordered set where employeeId = &#63;.
	 *
	 * @param empDependentId the primary key of the current emp dependent
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent[] findByemployeeId_PrevAndNext(long empDependentId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = findByPrimaryKey(empDependentId);

		Session session = null;

		try {
			session = openSession();

			EmpDependent[] array = new EmpDependentImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empDependent,
					employeeId, orderByComparator, true);

			array[1] = empDependent;

			array[2] = getByemployeeId_PrevAndNext(session, empDependent,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpDependent getByemployeeId_PrevAndNext(Session session,
		EmpDependent empDependent, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPDEPENDENT_WHERE);

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
			query.append(EmpDependentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empDependent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpDependent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp dependents where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpDependent empDependent : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empDependent);
		}
	}

	/**
	 * Returns the number of emp dependents where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp dependents
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

			query.append(_SQL_COUNT_EMPDEPENDENT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empDependent.employeeId = ?";

	public EmpDependentPersistenceImpl() {
		setModelClass(EmpDependent.class);
	}

	/**
	 * Caches the emp dependent in the entity cache if it is enabled.
	 *
	 * @param empDependent the emp dependent
	 */
	@Override
	public void cacheResult(EmpDependent empDependent) {
		EntityCacheUtil.putResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentImpl.class, empDependent.getPrimaryKey(), empDependent);

		empDependent.resetOriginalValues();
	}

	/**
	 * Caches the emp dependents in the entity cache if it is enabled.
	 *
	 * @param empDependents the emp dependents
	 */
	@Override
	public void cacheResult(List<EmpDependent> empDependents) {
		for (EmpDependent empDependent : empDependents) {
			if (EntityCacheUtil.getResult(
						EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
						EmpDependentImpl.class, empDependent.getPrimaryKey()) == null) {
				cacheResult(empDependent);
			}
			else {
				empDependent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp dependents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpDependentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpDependentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp dependent.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpDependent empDependent) {
		EntityCacheUtil.removeResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentImpl.class, empDependent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpDependent> empDependents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpDependent empDependent : empDependents) {
			EntityCacheUtil.removeResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
				EmpDependentImpl.class, empDependent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp dependent with the primary key. Does not add the emp dependent to the database.
	 *
	 * @param empDependentId the primary key for the new emp dependent
	 * @return the new emp dependent
	 */
	@Override
	public EmpDependent create(long empDependentId) {
		EmpDependent empDependent = new EmpDependentImpl();

		empDependent.setNew(true);
		empDependent.setPrimaryKey(empDependentId);

		return empDependent;
	}

	/**
	 * Removes the emp dependent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empDependentId the primary key of the emp dependent
	 * @return the emp dependent that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent remove(long empDependentId)
		throws NoSuchEmpDependentException, SystemException {
		return remove((Serializable)empDependentId);
	}

	/**
	 * Removes the emp dependent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp dependent
	 * @return the emp dependent that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent remove(Serializable primaryKey)
		throws NoSuchEmpDependentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpDependent empDependent = (EmpDependent)session.get(EmpDependentImpl.class,
					primaryKey);

			if (empDependent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpDependentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empDependent);
		}
		catch (NoSuchEmpDependentException nsee) {
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
	protected EmpDependent removeImpl(EmpDependent empDependent)
		throws SystemException {
		empDependent = toUnwrappedModel(empDependent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empDependent)) {
				empDependent = (EmpDependent)session.get(EmpDependentImpl.class,
						empDependent.getPrimaryKeyObj());
			}

			if (empDependent != null) {
				session.delete(empDependent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empDependent != null) {
			clearCache(empDependent);
		}

		return empDependent;
	}

	@Override
	public EmpDependent updateImpl(
		com.rknowsys.eapp.hrm.model.EmpDependent empDependent)
		throws SystemException {
		empDependent = toUnwrappedModel(empDependent);

		boolean isNew = empDependent.isNew();

		EmpDependentModelImpl empDependentModelImpl = (EmpDependentModelImpl)empDependent;

		Session session = null;

		try {
			session = openSession();

			if (empDependent.isNew()) {
				session.save(empDependent);

				empDependent.setNew(false);
			}
			else {
				session.merge(empDependent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpDependentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empDependentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDEPENDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empDependentModelImpl.getOriginalEmpDependentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPDEPENDENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDEPENDENTID,
					args);

				args = new Object[] { empDependentModelImpl.getEmpDependentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPDEPENDENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDEPENDENTID,
					args);
			}

			if ((empDependentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empDependentModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empDependentModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
			EmpDependentImpl.class, empDependent.getPrimaryKey(), empDependent);

		return empDependent;
	}

	protected EmpDependent toUnwrappedModel(EmpDependent empDependent) {
		if (empDependent instanceof EmpDependentImpl) {
			return empDependent;
		}

		EmpDependentImpl empDependentImpl = new EmpDependentImpl();

		empDependentImpl.setNew(empDependent.isNew());
		empDependentImpl.setPrimaryKey(empDependent.getPrimaryKey());

		empDependentImpl.setEmpDependentId(empDependent.getEmpDependentId());
		empDependentImpl.setEmployeeId(empDependent.getEmployeeId());
		empDependentImpl.setGroupId(empDependent.getGroupId());
		empDependentImpl.setCompanyId(empDependent.getCompanyId());
		empDependentImpl.setUserId(empDependent.getUserId());
		empDependentImpl.setCreateDate(empDependent.getCreateDate());
		empDependentImpl.setModifiedDate(empDependent.getModifiedDate());
		empDependentImpl.setName(empDependent.getName());
		empDependentImpl.setRelationship(empDependent.getRelationship());
		empDependentImpl.setDateOfBirth(empDependent.getDateOfBirth());

		return empDependentImpl;
	}

	/**
	 * Returns the emp dependent with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp dependent
	 * @return the emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpDependentException, SystemException {
		EmpDependent empDependent = fetchByPrimaryKey(primaryKey);

		if (empDependent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpDependentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empDependent;
	}

	/**
	 * Returns the emp dependent with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpDependentException} if it could not be found.
	 *
	 * @param empDependentId the primary key of the emp dependent
	 * @return the emp dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDependentException if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent findByPrimaryKey(long empDependentId)
		throws NoSuchEmpDependentException, SystemException {
		return findByPrimaryKey((Serializable)empDependentId);
	}

	/**
	 * Returns the emp dependent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp dependent
	 * @return the emp dependent, or <code>null</code> if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpDependent empDependent = (EmpDependent)EntityCacheUtil.getResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
				EmpDependentImpl.class, primaryKey);

		if (empDependent == _nullEmpDependent) {
			return null;
		}

		if (empDependent == null) {
			Session session = null;

			try {
				session = openSession();

				empDependent = (EmpDependent)session.get(EmpDependentImpl.class,
						primaryKey);

				if (empDependent != null) {
					cacheResult(empDependent);
				}
				else {
					EntityCacheUtil.putResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
						EmpDependentImpl.class, primaryKey, _nullEmpDependent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpDependentModelImpl.ENTITY_CACHE_ENABLED,
					EmpDependentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empDependent;
	}

	/**
	 * Returns the emp dependent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empDependentId the primary key of the emp dependent
	 * @return the emp dependent, or <code>null</code> if a emp dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDependent fetchByPrimaryKey(long empDependentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empDependentId);
	}

	/**
	 * Returns all the emp dependents.
	 *
	 * @return the emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp dependents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @return the range of emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp dependents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp dependents
	 * @param end the upper bound of the range of emp dependents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDependent> findAll(int start, int end,
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

		List<EmpDependent> list = (List<EmpDependent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPDEPENDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPDEPENDENT;

				if (pagination) {
					sql = sql.concat(EmpDependentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDependent>(list);
				}
				else {
					list = (List<EmpDependent>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the emp dependents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpDependent empDependent : findAll()) {
			remove(empDependent);
		}
	}

	/**
	 * Returns the number of emp dependents.
	 *
	 * @return the number of emp dependents
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

				Query q = session.createQuery(_SQL_COUNT_EMPDEPENDENT);

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
	 * Initializes the emp dependent persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpDependent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpDependent>> listenersList = new ArrayList<ModelListener<EmpDependent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpDependent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpDependentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPDEPENDENT = "SELECT empDependent FROM EmpDependent empDependent";
	private static final String _SQL_SELECT_EMPDEPENDENT_WHERE = "SELECT empDependent FROM EmpDependent empDependent WHERE ";
	private static final String _SQL_COUNT_EMPDEPENDENT = "SELECT COUNT(empDependent) FROM EmpDependent empDependent";
	private static final String _SQL_COUNT_EMPDEPENDENT_WHERE = "SELECT COUNT(empDependent) FROM EmpDependent empDependent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empDependent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpDependent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpDependent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpDependentPersistenceImpl.class);
	private static EmpDependent _nullEmpDependent = new EmpDependentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpDependent> toCacheModel() {
				return _nullEmpDependentCacheModel;
			}
		};

	private static CacheModel<EmpDependent> _nullEmpDependentCacheModel = new CacheModel<EmpDependent>() {
			@Override
			public EmpDependent toEntityModel() {
				return _nullEmpDependent;
			}
		};
}