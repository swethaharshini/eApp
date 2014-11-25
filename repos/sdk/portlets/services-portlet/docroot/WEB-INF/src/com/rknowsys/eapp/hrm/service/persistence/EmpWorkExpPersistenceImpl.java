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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException;
import com.rknowsys.eapp.hrm.model.EmpWorkExp;
import com.rknowsys.eapp.hrm.model.impl.EmpWorkExpImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the EmpWorkExp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpWorkExpPersistence
 * @see EmpWorkExpUtil
 * @generated
 */
public class EmpWorkExpPersistenceImpl extends BasePersistenceImpl<EmpWorkExp>
	implements EmpWorkExpPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpWorkExpUtil} to access the EmpWorkExp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpWorkExpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpWorkExpModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpWorkExps where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpWorkExps where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @return the range of matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByemployeeId(long employeeId, int start, int end)
		throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpWorkExps where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByemployeeId(long employeeId, int start,
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

		List<EmpWorkExp> list = (List<EmpWorkExp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpWorkExp empWorkExp : list) {
				if ((employeeId != empWorkExp.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPWORKEXP_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpWorkExpModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpWorkExp>(list);
				}
				else {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first EmpWorkExp in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empWorkExp != null) {
			return empWorkExp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpWorkExpException(msg.toString());
	}

	/**
	 * Returns the first EmpWorkExp in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpWorkExp> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpWorkExp in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empWorkExp != null) {
			return empWorkExp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpWorkExpException(msg.toString());
	}

	/**
	 * Returns the last EmpWorkExp in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpWorkExp> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the EmpWorkExps before and after the current EmpWorkExp in the ordered set where employeeId = &#63;.
	 *
	 * @param empWorkExpId the primary key of the current EmpWorkExp
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp[] findByemployeeId_PrevAndNext(long empWorkExpId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = findByPrimaryKey(empWorkExpId);

		Session session = null;

		try {
			session = openSession();

			EmpWorkExp[] array = new EmpWorkExpImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empWorkExp,
					employeeId, orderByComparator, true);

			array[1] = empWorkExp;

			array[2] = getByemployeeId_PrevAndNext(session, empWorkExp,
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

	protected EmpWorkExp getByemployeeId_PrevAndNext(Session session,
		EmpWorkExp empWorkExp, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPWORKEXP_WHERE);

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
			query.append(EmpWorkExpModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empWorkExp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpWorkExp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EmpWorkExps where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpWorkExp empWorkExp : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empWorkExp);
		}
	}

	/**
	 * Returns the number of EmpWorkExps where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching EmpWorkExps
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

			query.append(_SQL_COUNT_EMPWORKEXP_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empWorkExp.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPWORKEXPID =
		new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempWorkExpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPWORKEXPID =
		new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, EmpWorkExpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempWorkExpId",
			new String[] { Long.class.getName() },
			EmpWorkExpModelImpl.EMPWORKEXPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPWORKEXPID = new FinderPath(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempWorkExpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpWorkExps where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @return the matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByempWorkExpId(long empWorkExpId)
		throws SystemException {
		return findByempWorkExpId(empWorkExpId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpWorkExps where empWorkExpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @return the range of matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByempWorkExpId(long empWorkExpId, int start,
		int end) throws SystemException {
		return findByempWorkExpId(empWorkExpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpWorkExps where empWorkExpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findByempWorkExpId(long empWorkExpId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPWORKEXPID;
			finderArgs = new Object[] { empWorkExpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPWORKEXPID;
			finderArgs = new Object[] {
					empWorkExpId,
					
					start, end, orderByComparator
				};
		}

		List<EmpWorkExp> list = (List<EmpWorkExp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpWorkExp empWorkExp : list) {
				if ((empWorkExpId != empWorkExp.getEmpWorkExpId())) {
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

			query.append(_SQL_SELECT_EMPWORKEXP_WHERE);

			query.append(_FINDER_COLUMN_EMPWORKEXPID_EMPWORKEXPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpWorkExpModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empWorkExpId);

				if (!pagination) {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpWorkExp>(list);
				}
				else {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByempWorkExpId_First(long empWorkExpId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = fetchByempWorkExpId_First(empWorkExpId,
				orderByComparator);

		if (empWorkExp != null) {
			return empWorkExp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empWorkExpId=");
		msg.append(empWorkExpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpWorkExpException(msg.toString());
	}

	/**
	 * Returns the first EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByempWorkExpId_First(long empWorkExpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpWorkExp> list = findByempWorkExpId(empWorkExpId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByempWorkExpId_Last(long empWorkExpId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = fetchByempWorkExpId_Last(empWorkExpId,
				orderByComparator);

		if (empWorkExp != null) {
			return empWorkExp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empWorkExpId=");
		msg.append(empWorkExpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpWorkExpException(msg.toString());
	}

	/**
	 * Returns the last EmpWorkExp in the ordered set where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpWorkExp, or <code>null</code> if a matching EmpWorkExp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByempWorkExpId_Last(long empWorkExpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByempWorkExpId(empWorkExpId);

		if (count == 0) {
			return null;
		}

		List<EmpWorkExp> list = findByempWorkExpId(empWorkExpId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the EmpWorkExps where empWorkExpId = &#63; from the database.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempWorkExpId(long empWorkExpId)
		throws SystemException {
		for (EmpWorkExp empWorkExp : findByempWorkExpId(empWorkExpId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empWorkExp);
		}
	}

	/**
	 * Returns the number of EmpWorkExps where empWorkExpId = &#63;.
	 *
	 * @param empWorkExpId the emp work exp ID
	 * @return the number of matching EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempWorkExpId(long empWorkExpId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPWORKEXPID;

		Object[] finderArgs = new Object[] { empWorkExpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPWORKEXP_WHERE);

			query.append(_FINDER_COLUMN_EMPWORKEXPID_EMPWORKEXPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empWorkExpId);

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

	private static final String _FINDER_COLUMN_EMPWORKEXPID_EMPWORKEXPID_2 = "empWorkExp.empWorkExpId = ?";

	public EmpWorkExpPersistenceImpl() {
		setModelClass(EmpWorkExp.class);
	}

	/**
	 * Caches the EmpWorkExp in the entity cache if it is enabled.
	 *
	 * @param empWorkExp the EmpWorkExp
	 */
	@Override
	public void cacheResult(EmpWorkExp empWorkExp) {
		EntityCacheUtil.putResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpImpl.class, empWorkExp.getPrimaryKey(), empWorkExp);

		empWorkExp.resetOriginalValues();
	}

	/**
	 * Caches the EmpWorkExps in the entity cache if it is enabled.
	 *
	 * @param empWorkExps the EmpWorkExps
	 */
	@Override
	public void cacheResult(List<EmpWorkExp> empWorkExps) {
		for (EmpWorkExp empWorkExp : empWorkExps) {
			if (EntityCacheUtil.getResult(
						EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
						EmpWorkExpImpl.class, empWorkExp.getPrimaryKey()) == null) {
				cacheResult(empWorkExp);
			}
			else {
				empWorkExp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpWorkExps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpWorkExpImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpWorkExpImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpWorkExp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpWorkExp empWorkExp) {
		EntityCacheUtil.removeResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpImpl.class, empWorkExp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpWorkExp> empWorkExps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpWorkExp empWorkExp : empWorkExps) {
			EntityCacheUtil.removeResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
				EmpWorkExpImpl.class, empWorkExp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpWorkExp with the primary key. Does not add the EmpWorkExp to the database.
	 *
	 * @param empWorkExpId the primary key for the new EmpWorkExp
	 * @return the new EmpWorkExp
	 */
	@Override
	public EmpWorkExp create(long empWorkExpId) {
		EmpWorkExp empWorkExp = new EmpWorkExpImpl();

		empWorkExp.setNew(true);
		empWorkExp.setPrimaryKey(empWorkExpId);

		return empWorkExp;
	}

	/**
	 * Removes the EmpWorkExp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empWorkExpId the primary key of the EmpWorkExp
	 * @return the EmpWorkExp that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp remove(long empWorkExpId)
		throws NoSuchEmpWorkExpException, SystemException {
		return remove((Serializable)empWorkExpId);
	}

	/**
	 * Removes the EmpWorkExp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpWorkExp
	 * @return the EmpWorkExp that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp remove(Serializable primaryKey)
		throws NoSuchEmpWorkExpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpWorkExp empWorkExp = (EmpWorkExp)session.get(EmpWorkExpImpl.class,
					primaryKey);

			if (empWorkExp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpWorkExpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empWorkExp);
		}
		catch (NoSuchEmpWorkExpException nsee) {
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
	protected EmpWorkExp removeImpl(EmpWorkExp empWorkExp)
		throws SystemException {
		empWorkExp = toUnwrappedModel(empWorkExp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empWorkExp)) {
				empWorkExp = (EmpWorkExp)session.get(EmpWorkExpImpl.class,
						empWorkExp.getPrimaryKeyObj());
			}

			if (empWorkExp != null) {
				session.delete(empWorkExp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empWorkExp != null) {
			clearCache(empWorkExp);
		}

		return empWorkExp;
	}

	@Override
	public EmpWorkExp updateImpl(
		com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp)
		throws SystemException {
		empWorkExp = toUnwrappedModel(empWorkExp);

		boolean isNew = empWorkExp.isNew();

		EmpWorkExpModelImpl empWorkExpModelImpl = (EmpWorkExpModelImpl)empWorkExp;

		Session session = null;

		try {
			session = openSession();

			if (empWorkExp.isNew()) {
				session.save(empWorkExp);

				empWorkExp.setNew(false);
			}
			else {
				session.merge(empWorkExp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpWorkExpModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empWorkExpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empWorkExpModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empWorkExpModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((empWorkExpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPWORKEXPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empWorkExpModelImpl.getOriginalEmpWorkExpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPWORKEXPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPWORKEXPID,
					args);

				args = new Object[] { empWorkExpModelImpl.getEmpWorkExpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPWORKEXPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPWORKEXPID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
			EmpWorkExpImpl.class, empWorkExp.getPrimaryKey(), empWorkExp);

		return empWorkExp;
	}

	protected EmpWorkExp toUnwrappedModel(EmpWorkExp empWorkExp) {
		if (empWorkExp instanceof EmpWorkExpImpl) {
			return empWorkExp;
		}

		EmpWorkExpImpl empWorkExpImpl = new EmpWorkExpImpl();

		empWorkExpImpl.setNew(empWorkExp.isNew());
		empWorkExpImpl.setPrimaryKey(empWorkExp.getPrimaryKey());

		empWorkExpImpl.setEmpWorkExpId(empWorkExp.getEmpWorkExpId());
		empWorkExpImpl.setEmployeeId(empWorkExp.getEmployeeId());
		empWorkExpImpl.setGroupId(empWorkExp.getGroupId());
		empWorkExpImpl.setCompanyId(empWorkExp.getCompanyId());
		empWorkExpImpl.setUserId(empWorkExp.getUserId());
		empWorkExpImpl.setCreateDate(empWorkExp.getCreateDate());
		empWorkExpImpl.setModifiedDate(empWorkExp.getModifiedDate());
		empWorkExpImpl.setCompany(empWorkExp.getCompany());
		empWorkExpImpl.setJobTitle(empWorkExp.getJobTitle());
		empWorkExpImpl.setFromDate(empWorkExp.getFromDate());
		empWorkExpImpl.setToDate(empWorkExp.getToDate());
		empWorkExpImpl.setComment(empWorkExp.getComment());

		return empWorkExpImpl;
	}

	/**
	 * Returns the EmpWorkExp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpWorkExp
	 * @return the EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpWorkExpException, SystemException {
		EmpWorkExp empWorkExp = fetchByPrimaryKey(primaryKey);

		if (empWorkExp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpWorkExpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empWorkExp;
	}

	/**
	 * Returns the EmpWorkExp with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException} if it could not be found.
	 *
	 * @param empWorkExpId the primary key of the EmpWorkExp
	 * @return the EmpWorkExp
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpWorkExpException if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp findByPrimaryKey(long empWorkExpId)
		throws NoSuchEmpWorkExpException, SystemException {
		return findByPrimaryKey((Serializable)empWorkExpId);
	}

	/**
	 * Returns the EmpWorkExp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpWorkExp
	 * @return the EmpWorkExp, or <code>null</code> if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpWorkExp empWorkExp = (EmpWorkExp)EntityCacheUtil.getResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
				EmpWorkExpImpl.class, primaryKey);

		if (empWorkExp == _nullEmpWorkExp) {
			return null;
		}

		if (empWorkExp == null) {
			Session session = null;

			try {
				session = openSession();

				empWorkExp = (EmpWorkExp)session.get(EmpWorkExpImpl.class,
						primaryKey);

				if (empWorkExp != null) {
					cacheResult(empWorkExp);
				}
				else {
					EntityCacheUtil.putResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
						EmpWorkExpImpl.class, primaryKey, _nullEmpWorkExp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpWorkExpModelImpl.ENTITY_CACHE_ENABLED,
					EmpWorkExpImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empWorkExp;
	}

	/**
	 * Returns the EmpWorkExp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empWorkExpId the primary key of the EmpWorkExp
	 * @return the EmpWorkExp, or <code>null</code> if a EmpWorkExp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpWorkExp fetchByPrimaryKey(long empWorkExpId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empWorkExpId);
	}

	/**
	 * Returns all the EmpWorkExps.
	 *
	 * @return the EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpWorkExps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @return the range of EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpWorkExps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpWorkExps
	 * @param end the upper bound of the range of EmpWorkExps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpWorkExps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpWorkExp> findAll(int start, int end,
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

		List<EmpWorkExp> list = (List<EmpWorkExp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPWORKEXP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPWORKEXP;

				if (pagination) {
					sql = sql.concat(EmpWorkExpModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpWorkExp>(list);
				}
				else {
					list = (List<EmpWorkExp>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the EmpWorkExps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpWorkExp empWorkExp : findAll()) {
			remove(empWorkExp);
		}
	}

	/**
	 * Returns the number of EmpWorkExps.
	 *
	 * @return the number of EmpWorkExps
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

				Query q = session.createQuery(_SQL_COUNT_EMPWORKEXP);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the EmpWorkExp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpWorkExp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpWorkExp>> listenersList = new ArrayList<ModelListener<EmpWorkExp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpWorkExp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpWorkExpImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPWORKEXP = "SELECT empWorkExp FROM EmpWorkExp empWorkExp";
	private static final String _SQL_SELECT_EMPWORKEXP_WHERE = "SELECT empWorkExp FROM EmpWorkExp empWorkExp WHERE ";
	private static final String _SQL_COUNT_EMPWORKEXP = "SELECT COUNT(empWorkExp) FROM EmpWorkExp empWorkExp";
	private static final String _SQL_COUNT_EMPWORKEXP_WHERE = "SELECT COUNT(empWorkExp) FROM EmpWorkExp empWorkExp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empWorkExp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpWorkExp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpWorkExp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpWorkExpPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static EmpWorkExp _nullEmpWorkExp = new EmpWorkExpImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpWorkExp> toCacheModel() {
				return _nullEmpWorkExpCacheModel;
			}
		};

	private static CacheModel<EmpWorkExp> _nullEmpWorkExpCacheModel = new CacheModel<EmpWorkExp>() {
			@Override
			public EmpWorkExp toEntityModel() {
				return _nullEmpWorkExp;
			}
		};
}