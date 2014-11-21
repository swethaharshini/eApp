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

import com.rknowsys.eapp.hrm.NoSuchEmpSalaryException;
import com.rknowsys.eapp.hrm.model.EmpSalary;
import com.rknowsys.eapp.hrm.model.impl.EmpSalaryImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the emp salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSalaryPersistence
 * @see EmpSalaryUtil
 * @generated
 */
public class EmpSalaryPersistenceImpl extends BasePersistenceImpl<EmpSalary>
	implements EmpSalaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpSalaryUtil} to access the emp salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpSalaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpSalaryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salaries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salaries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @return the range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salaries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<EmpSalary> list = (List<EmpSalary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalary empSalary : list) {
				if ((groupId != empSalary.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPSALARY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalary>(list);
				}
				else {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp salary in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByGroupId_First(groupId, orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the first emp salary in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSalary> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByGroupId_Last(groupId, orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the last emp salary in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpSalary> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp salaries before and after the current emp salary in the ordered set where groupId = &#63;.
	 *
	 * @param empSalaryId the primary key of the current emp salary
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary[] findByGroupId_PrevAndNext(long empSalaryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = findByPrimaryKey(empSalaryId);

		Session session = null;

		try {
			session = openSession();

			EmpSalary[] array = new EmpSalaryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empSalary, groupId,
					orderByComparator, true);

			array[1] = empSalary;

			array[2] = getByGroupId_PrevAndNext(session, empSalary, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpSalary getByGroupId_PrevAndNext(Session session,
		EmpSalary empSalary, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSALARY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(EmpSalaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSalary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSalary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp salaries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpSalary empSalary : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empSalary);
		}
	}

	/**
	 * Returns the number of emp salaries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPSALARY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empSalary.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYID =
		new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempSalaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID =
		new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempSalaryId",
			new String[] { Long.class.getName() },
			EmpSalaryModelImpl.EMPSALARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPSALARYID = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempSalaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salaries where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @return the matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByempSalaryId(long empSalaryId)
		throws SystemException {
		return findByempSalaryId(empSalaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salaries where empSalaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryId the emp salary ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @return the range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByempSalaryId(long empSalaryId, int start,
		int end) throws SystemException {
		return findByempSalaryId(empSalaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salaries where empSalaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryId the emp salary ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByempSalaryId(long empSalaryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID;
			finderArgs = new Object[] { empSalaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYID;
			finderArgs = new Object[] { empSalaryId, start, end, orderByComparator };
		}

		List<EmpSalary> list = (List<EmpSalary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalary empSalary : list) {
				if ((empSalaryId != empSalary.getEmpSalaryId())) {
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

			query.append(_SQL_SELECT_EMPSALARY_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryId);

				if (!pagination) {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalary>(list);
				}
				else {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp salary in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByempSalaryId_First(long empSalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByempSalaryId_First(empSalaryId,
				orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryId=");
		msg.append(empSalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the first emp salary in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByempSalaryId_First(long empSalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSalary> list = findByempSalaryId(empSalaryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByempSalaryId_Last(long empSalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByempSalaryId_Last(empSalaryId,
				orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryId=");
		msg.append(empSalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the last emp salary in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByempSalaryId_Last(long empSalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByempSalaryId(empSalaryId);

		if (count == 0) {
			return null;
		}

		List<EmpSalary> list = findByempSalaryId(empSalaryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the emp salaries where empSalaryId = &#63; from the database.
	 *
	 * @param empSalaryId the emp salary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempSalaryId(long empSalaryId) throws SystemException {
		for (EmpSalary empSalary : findByempSalaryId(empSalaryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSalary);
		}
	}

	/**
	 * Returns the number of emp salaries where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @return the number of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempSalaryId(long empSalaryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPSALARYID;

		Object[] finderArgs = new Object[] { empSalaryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPSALARY_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryId);

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

	private static final String _FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2 = "empSalary.empSalaryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, EmpSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpSalaryModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salaries where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salaries where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @return the range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByemployeeId(long employeeId, int start, int end)
		throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salaries where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findByemployeeId(long employeeId, int start,
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

		List<EmpSalary> list = (List<EmpSalary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalary empSalary : list) {
				if ((employeeId != empSalary.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPSALARY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalary>(list);
				}
				else {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp salary in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the first emp salary in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSalary> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empSalary != null) {
			return empSalary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryException(msg.toString());
	}

	/**
	 * Returns the last emp salary in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary, or <code>null</code> if a matching emp salary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpSalary> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp salaries before and after the current emp salary in the ordered set where employeeId = &#63;.
	 *
	 * @param empSalaryId the primary key of the current emp salary
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary[] findByemployeeId_PrevAndNext(long empSalaryId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = findByPrimaryKey(empSalaryId);

		Session session = null;

		try {
			session = openSession();

			EmpSalary[] array = new EmpSalaryImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empSalary,
					employeeId, orderByComparator, true);

			array[1] = empSalary;

			array[2] = getByemployeeId_PrevAndNext(session, empSalary,
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

	protected EmpSalary getByemployeeId_PrevAndNext(Session session,
		EmpSalary empSalary, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSALARY_WHERE);

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
			query.append(EmpSalaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSalary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSalary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp salaries where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpSalary empSalary : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSalary);
		}
	}

	/**
	 * Returns the number of emp salaries where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp salaries
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

			query.append(_SQL_COUNT_EMPSALARY_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empSalary.employeeId = ?";

	public EmpSalaryPersistenceImpl() {
		setModelClass(EmpSalary.class);
	}

	/**
	 * Caches the emp salary in the entity cache if it is enabled.
	 *
	 * @param empSalary the emp salary
	 */
	@Override
	public void cacheResult(EmpSalary empSalary) {
		EntityCacheUtil.putResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryImpl.class, empSalary.getPrimaryKey(), empSalary);

		empSalary.resetOriginalValues();
	}

	/**
	 * Caches the emp salaries in the entity cache if it is enabled.
	 *
	 * @param empSalaries the emp salaries
	 */
	@Override
	public void cacheResult(List<EmpSalary> empSalaries) {
		for (EmpSalary empSalary : empSalaries) {
			if (EntityCacheUtil.getResult(
						EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
						EmpSalaryImpl.class, empSalary.getPrimaryKey()) == null) {
				cacheResult(empSalary);
			}
			else {
				empSalary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp salaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpSalaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpSalaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp salary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpSalary empSalary) {
		EntityCacheUtil.removeResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryImpl.class, empSalary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpSalary> empSalaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpSalary empSalary : empSalaries) {
			EntityCacheUtil.removeResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
				EmpSalaryImpl.class, empSalary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp salary with the primary key. Does not add the emp salary to the database.
	 *
	 * @param empSalaryId the primary key for the new emp salary
	 * @return the new emp salary
	 */
	@Override
	public EmpSalary create(long empSalaryId) {
		EmpSalary empSalary = new EmpSalaryImpl();

		empSalary.setNew(true);
		empSalary.setPrimaryKey(empSalaryId);

		return empSalary;
	}

	/**
	 * Removes the emp salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empSalaryId the primary key of the emp salary
	 * @return the emp salary that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary remove(long empSalaryId)
		throws NoSuchEmpSalaryException, SystemException {
		return remove((Serializable)empSalaryId);
	}

	/**
	 * Removes the emp salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp salary
	 * @return the emp salary that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary remove(Serializable primaryKey)
		throws NoSuchEmpSalaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpSalary empSalary = (EmpSalary)session.get(EmpSalaryImpl.class,
					primaryKey);

			if (empSalary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpSalaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empSalary);
		}
		catch (NoSuchEmpSalaryException nsee) {
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
	protected EmpSalary removeImpl(EmpSalary empSalary)
		throws SystemException {
		empSalary = toUnwrappedModel(empSalary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empSalary)) {
				empSalary = (EmpSalary)session.get(EmpSalaryImpl.class,
						empSalary.getPrimaryKeyObj());
			}

			if (empSalary != null) {
				session.delete(empSalary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empSalary != null) {
			clearCache(empSalary);
		}

		return empSalary;
	}

	@Override
	public EmpSalary updateImpl(com.rknowsys.eapp.hrm.model.EmpSalary empSalary)
		throws SystemException {
		empSalary = toUnwrappedModel(empSalary);

		boolean isNew = empSalary.isNew();

		EmpSalaryModelImpl empSalaryModelImpl = (EmpSalaryModelImpl)empSalary;

		Session session = null;

		try {
			session = openSession();

			if (empSalary.isNew()) {
				session.save(empSalary);

				empSalary.setNew(false);
			}
			else {
				session.merge(empSalary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpSalaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empSalaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empSalaryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empSalaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryModelImpl.getOriginalEmpSalaryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID,
					args);

				args = new Object[] { empSalaryModelImpl.getEmpSalaryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID,
					args);
			}

			if ((empSalaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empSalaryModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryImpl.class, empSalary.getPrimaryKey(), empSalary);

		return empSalary;
	}

	protected EmpSalary toUnwrappedModel(EmpSalary empSalary) {
		if (empSalary instanceof EmpSalaryImpl) {
			return empSalary;
		}

		EmpSalaryImpl empSalaryImpl = new EmpSalaryImpl();

		empSalaryImpl.setNew(empSalary.isNew());
		empSalaryImpl.setPrimaryKey(empSalary.getPrimaryKey());

		empSalaryImpl.setEmpSalaryId(empSalary.getEmpSalaryId());
		empSalaryImpl.setEmployeeId(empSalary.getEmployeeId());
		empSalaryImpl.setGroupId(empSalary.getGroupId());
		empSalaryImpl.setCompanyId(empSalary.getCompanyId());
		empSalaryImpl.setCreateDate(empSalary.getCreateDate());
		empSalaryImpl.setModifiedDate(empSalary.getModifiedDate());
		empSalaryImpl.setUserId(empSalary.getUserId());
		empSalaryImpl.setPayGradeId(empSalary.getPayGradeId());
		empSalaryImpl.setPayGradeCurrencyId(empSalary.getPayGradeCurrencyId());
		empSalaryImpl.setComment(empSalary.getComment());

		return empSalaryImpl;
	}

	/**
	 * Returns the emp salary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp salary
	 * @return the emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpSalaryException, SystemException {
		EmpSalary empSalary = fetchByPrimaryKey(primaryKey);

		if (empSalary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpSalaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empSalary;
	}

	/**
	 * Returns the emp salary with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSalaryException} if it could not be found.
	 *
	 * @param empSalaryId the primary key of the emp salary
	 * @return the emp salary
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryException if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary findByPrimaryKey(long empSalaryId)
		throws NoSuchEmpSalaryException, SystemException {
		return findByPrimaryKey((Serializable)empSalaryId);
	}

	/**
	 * Returns the emp salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp salary
	 * @return the emp salary, or <code>null</code> if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpSalary empSalary = (EmpSalary)EntityCacheUtil.getResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
				EmpSalaryImpl.class, primaryKey);

		if (empSalary == _nullEmpSalary) {
			return null;
		}

		if (empSalary == null) {
			Session session = null;

			try {
				session = openSession();

				empSalary = (EmpSalary)session.get(EmpSalaryImpl.class,
						primaryKey);

				if (empSalary != null) {
					cacheResult(empSalary);
				}
				else {
					EntityCacheUtil.putResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
						EmpSalaryImpl.class, primaryKey, _nullEmpSalary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpSalaryModelImpl.ENTITY_CACHE_ENABLED,
					EmpSalaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empSalary;
	}

	/**
	 * Returns the emp salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empSalaryId the primary key of the emp salary
	 * @return the emp salary, or <code>null</code> if a emp salary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalary fetchByPrimaryKey(long empSalaryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empSalaryId);
	}

	/**
	 * Returns all the emp salaries.
	 *
	 * @return the emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @return the range of emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp salaries
	 * @param end the upper bound of the range of emp salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp salaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalary> findAll(int start, int end,
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

		List<EmpSalary> list = (List<EmpSalary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPSALARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPSALARY;

				if (pagination) {
					sql = sql.concat(EmpSalaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalary>(list);
				}
				else {
					list = (List<EmpSalary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp salaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpSalary empSalary : findAll()) {
			remove(empSalary);
		}
	}

	/**
	 * Returns the number of emp salaries.
	 *
	 * @return the number of emp salaries
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

				Query q = session.createQuery(_SQL_COUNT_EMPSALARY);

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
	 * Initializes the emp salary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpSalary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpSalary>> listenersList = new ArrayList<ModelListener<EmpSalary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpSalary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpSalaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPSALARY = "SELECT empSalary FROM EmpSalary empSalary";
	private static final String _SQL_SELECT_EMPSALARY_WHERE = "SELECT empSalary FROM EmpSalary empSalary WHERE ";
	private static final String _SQL_COUNT_EMPSALARY = "SELECT COUNT(empSalary) FROM EmpSalary empSalary";
	private static final String _SQL_COUNT_EMPSALARY_WHERE = "SELECT COUNT(empSalary) FROM EmpSalary empSalary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empSalary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpSalary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpSalary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpSalaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static EmpSalary _nullEmpSalary = new EmpSalaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpSalary> toCacheModel() {
				return _nullEmpSalaryCacheModel;
			}
		};

	private static CacheModel<EmpSalary> _nullEmpSalaryCacheModel = new CacheModel<EmpSalary>() {
			@Override
			public EmpSalary toEntityModel() {
				return _nullEmpSalary;
			}
		};
}