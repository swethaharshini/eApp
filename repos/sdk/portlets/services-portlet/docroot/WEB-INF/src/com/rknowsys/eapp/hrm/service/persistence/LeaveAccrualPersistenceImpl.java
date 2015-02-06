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

import com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException;
import com.rknowsys.eapp.hrm.model.LeaveAccrual;
import com.rknowsys.eapp.hrm.model.impl.LeaveAccrualImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave accrual service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveAccrualPersistence
 * @see LeaveAccrualUtil
 * @generated
 */
public class LeaveAccrualPersistenceImpl extends BasePersistenceImpl<LeaveAccrual>
	implements LeaveAccrualPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveAccrualUtil} to access the leave accrual persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveAccrualImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, LeaveAccrualImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, LeaveAccrualImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, LeaveAccrualImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, LeaveAccrualImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveAccrualModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave accruals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave accruals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave accruals
	 * @param end the upper bound of the range of leave accruals (not inclusive)
	 * @return the range of matching leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave accruals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave accruals
	 * @param end the upper bound of the range of leave accruals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findByGroupId(long groupId, int start, int end,
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

		List<LeaveAccrual> list = (List<LeaveAccrual>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveAccrual leaveAccrual : list) {
				if ((groupId != leaveAccrual.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVEACCRUAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveAccrualModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveAccrual>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveAccrual>(list);
				}
				else {
					list = (List<LeaveAccrual>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave accrual in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveAccrual != null) {
			return leaveAccrual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveAccrualException(msg.toString());
	}

	/**
	 * Returns the first leave accrual in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveAccrual> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave accrual in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveAccrual != null) {
			return leaveAccrual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveAccrualException(msg.toString());
	}

	/**
	 * Returns the last leave accrual in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveAccrual> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave accruals before and after the current leave accrual in the ordered set where groupId = &#63;.
	 *
	 * @param leaveAccrualId the primary key of the current leave accrual
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual[] findByGroupId_PrevAndNext(long leaveAccrualId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = findByPrimaryKey(leaveAccrualId);

		Session session = null;

		try {
			session = openSession();

			LeaveAccrual[] array = new LeaveAccrualImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveAccrual, groupId,
					orderByComparator, true);

			array[1] = leaveAccrual;

			array[2] = getByGroupId_PrevAndNext(session, leaveAccrual, groupId,
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

	protected LeaveAccrual getByGroupId_PrevAndNext(Session session,
		LeaveAccrual leaveAccrual, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEACCRUAL_WHERE);

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
			query.append(LeaveAccrualModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveAccrual);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveAccrual> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave accruals where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveAccrual leaveAccrual : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveAccrual);
		}
	}

	/**
	 * Returns the number of leave accruals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave accruals
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

			query.append(_SQL_COUNT_LEAVEACCRUAL_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveAccrual.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVETYPEID = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, LeaveAccrualImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveAccrualModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the leave accrual where leaveTypeId = &#63; or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException} if it could not be found.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual findByLeaveTypeId(long leaveTypeId)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = fetchByLeaveTypeId(leaveTypeId);

		if (leaveAccrual == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("leaveTypeId=");
			msg.append(leaveTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLeaveAccrualException(msg.toString());
		}

		return leaveAccrual;
	}

	/**
	 * Returns the leave accrual where leaveTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return fetchByLeaveTypeId(leaveTypeId, true);
	}

	/**
	 * Returns the leave accrual where leaveTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching leave accrual, or <code>null</code> if a matching leave accrual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByLeaveTypeId(long leaveTypeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { leaveTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
					finderArgs, this);
		}

		if (result instanceof LeaveAccrual) {
			LeaveAccrual leaveAccrual = (LeaveAccrual)result;

			if ((leaveTypeId != leaveAccrual.getLeaveTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEAVEACCRUAL_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				List<LeaveAccrual> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LeaveAccrualPersistenceImpl.fetchByLeaveTypeId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LeaveAccrual leaveAccrual = list.get(0);

					result = leaveAccrual;

					cacheResult(leaveAccrual);

					if ((leaveAccrual.getLeaveTypeId() != leaveTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
							finderArgs, leaveAccrual);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LeaveAccrual)result;
		}
	}

	/**
	 * Removes the leave accrual where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the leave accrual that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual removeByLeaveTypeId(long leaveTypeId)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = findByLeaveTypeId(leaveTypeId);

		return remove(leaveAccrual);
	}

	/**
	 * Returns the number of leave accruals where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLeaveTypeId(long leaveTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVETYPEID;

		Object[] finderArgs = new Object[] { leaveTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEACCRUAL_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveAccrual.leaveTypeId = ?";

	public LeaveAccrualPersistenceImpl() {
		setModelClass(LeaveAccrual.class);
	}

	/**
	 * Caches the leave accrual in the entity cache if it is enabled.
	 *
	 * @param leaveAccrual the leave accrual
	 */
	@Override
	public void cacheResult(LeaveAccrual leaveAccrual) {
		EntityCacheUtil.putResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualImpl.class, leaveAccrual.getPrimaryKey(), leaveAccrual);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
			new Object[] { leaveAccrual.getLeaveTypeId() }, leaveAccrual);

		leaveAccrual.resetOriginalValues();
	}

	/**
	 * Caches the leave accruals in the entity cache if it is enabled.
	 *
	 * @param leaveAccruals the leave accruals
	 */
	@Override
	public void cacheResult(List<LeaveAccrual> leaveAccruals) {
		for (LeaveAccrual leaveAccrual : leaveAccruals) {
			if (EntityCacheUtil.getResult(
						LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
						LeaveAccrualImpl.class, leaveAccrual.getPrimaryKey()) == null) {
				cacheResult(leaveAccrual);
			}
			else {
				leaveAccrual.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave accruals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveAccrualImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveAccrualImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave accrual.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveAccrual leaveAccrual) {
		EntityCacheUtil.removeResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualImpl.class, leaveAccrual.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(leaveAccrual);
	}

	@Override
	public void clearCache(List<LeaveAccrual> leaveAccruals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveAccrual leaveAccrual : leaveAccruals) {
			EntityCacheUtil.removeResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
				LeaveAccrualImpl.class, leaveAccrual.getPrimaryKey());

			clearUniqueFindersCache(leaveAccrual);
		}
	}

	protected void cacheUniqueFindersCache(LeaveAccrual leaveAccrual) {
		if (leaveAccrual.isNew()) {
			Object[] args = new Object[] { leaveAccrual.getLeaveTypeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPEID, args,
				leaveAccrual);
		}
		else {
			LeaveAccrualModelImpl leaveAccrualModelImpl = (LeaveAccrualModelImpl)leaveAccrual;

			if ((leaveAccrualModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { leaveAccrual.getLeaveTypeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LEAVETYPEID,
					args, leaveAccrual);
			}
		}
	}

	protected void clearUniqueFindersCache(LeaveAccrual leaveAccrual) {
		LeaveAccrualModelImpl leaveAccrualModelImpl = (LeaveAccrualModelImpl)leaveAccrual;

		Object[] args = new Object[] { leaveAccrual.getLeaveTypeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPEID, args);

		if ((leaveAccrualModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
			args = new Object[] { leaveAccrualModelImpl.getOriginalLeaveTypeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LEAVETYPEID, args);
		}
	}

	/**
	 * Creates a new leave accrual with the primary key. Does not add the leave accrual to the database.
	 *
	 * @param leaveAccrualId the primary key for the new leave accrual
	 * @return the new leave accrual
	 */
	@Override
	public LeaveAccrual create(long leaveAccrualId) {
		LeaveAccrual leaveAccrual = new LeaveAccrualImpl();

		leaveAccrual.setNew(true);
		leaveAccrual.setPrimaryKey(leaveAccrualId);

		return leaveAccrual;
	}

	/**
	 * Removes the leave accrual with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAccrualId the primary key of the leave accrual
	 * @return the leave accrual that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual remove(long leaveAccrualId)
		throws NoSuchLeaveAccrualException, SystemException {
		return remove((Serializable)leaveAccrualId);
	}

	/**
	 * Removes the leave accrual with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave accrual
	 * @return the leave accrual that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual remove(Serializable primaryKey)
		throws NoSuchLeaveAccrualException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveAccrual leaveAccrual = (LeaveAccrual)session.get(LeaveAccrualImpl.class,
					primaryKey);

			if (leaveAccrual == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveAccrualException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveAccrual);
		}
		catch (NoSuchLeaveAccrualException nsee) {
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
	protected LeaveAccrual removeImpl(LeaveAccrual leaveAccrual)
		throws SystemException {
		leaveAccrual = toUnwrappedModel(leaveAccrual);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveAccrual)) {
				leaveAccrual = (LeaveAccrual)session.get(LeaveAccrualImpl.class,
						leaveAccrual.getPrimaryKeyObj());
			}

			if (leaveAccrual != null) {
				session.delete(leaveAccrual);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveAccrual != null) {
			clearCache(leaveAccrual);
		}

		return leaveAccrual;
	}

	@Override
	public LeaveAccrual updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveAccrual leaveAccrual)
		throws SystemException {
		leaveAccrual = toUnwrappedModel(leaveAccrual);

		boolean isNew = leaveAccrual.isNew();

		LeaveAccrualModelImpl leaveAccrualModelImpl = (LeaveAccrualModelImpl)leaveAccrual;

		Session session = null;

		try {
			session = openSession();

			if (leaveAccrual.isNew()) {
				session.save(leaveAccrual);

				leaveAccrual.setNew(false);
			}
			else {
				session.merge(leaveAccrual);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveAccrualModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveAccrualModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveAccrualModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveAccrualModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
			LeaveAccrualImpl.class, leaveAccrual.getPrimaryKey(), leaveAccrual);

		clearUniqueFindersCache(leaveAccrual);
		cacheUniqueFindersCache(leaveAccrual);

		return leaveAccrual;
	}

	protected LeaveAccrual toUnwrappedModel(LeaveAccrual leaveAccrual) {
		if (leaveAccrual instanceof LeaveAccrualImpl) {
			return leaveAccrual;
		}

		LeaveAccrualImpl leaveAccrualImpl = new LeaveAccrualImpl();

		leaveAccrualImpl.setNew(leaveAccrual.isNew());
		leaveAccrualImpl.setPrimaryKey(leaveAccrual.getPrimaryKey());

		leaveAccrualImpl.setLeaveAccrualId(leaveAccrual.getLeaveAccrualId());
		leaveAccrualImpl.setCompanyId(leaveAccrual.getCompanyId());
		leaveAccrualImpl.setGroupId(leaveAccrual.getGroupId());
		leaveAccrualImpl.setCreateDate(leaveAccrual.getCreateDate());
		leaveAccrualImpl.setModifiedDate(leaveAccrual.getModifiedDate());
		leaveAccrualImpl.setUserId(leaveAccrual.getUserId());
		leaveAccrualImpl.setLeaveTypeId(leaveAccrual.getLeaveTypeId());
		leaveAccrualImpl.setAccrualFrequency(leaveAccrual.getAccrualFrequency());
		leaveAccrualImpl.setAccrueEvery(leaveAccrual.getAccrueEvery());
		leaveAccrualImpl.setDayOfCredit(leaveAccrual.getDayOfCredit());
		leaveAccrualImpl.setAccrualStartsOn(leaveAccrual.getAccrualStartsOn());
		leaveAccrualImpl.setMonthOfCredit(leaveAccrual.getMonthOfCredit());
		leaveAccrualImpl.setAccrualValidFrom(leaveAccrual.getAccrualValidFrom());
		leaveAccrualImpl.setFirstAccrual(leaveAccrual.getFirstAccrual());

		return leaveAccrualImpl;
	}

	/**
	 * Returns the leave accrual with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave accrual
	 * @return the leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveAccrualException, SystemException {
		LeaveAccrual leaveAccrual = fetchByPrimaryKey(primaryKey);

		if (leaveAccrual == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveAccrualException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveAccrual;
	}

	/**
	 * Returns the leave accrual with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException} if it could not be found.
	 *
	 * @param leaveAccrualId the primary key of the leave accrual
	 * @return the leave accrual
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveAccrualException if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual findByPrimaryKey(long leaveAccrualId)
		throws NoSuchLeaveAccrualException, SystemException {
		return findByPrimaryKey((Serializable)leaveAccrualId);
	}

	/**
	 * Returns the leave accrual with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave accrual
	 * @return the leave accrual, or <code>null</code> if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveAccrual leaveAccrual = (LeaveAccrual)EntityCacheUtil.getResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
				LeaveAccrualImpl.class, primaryKey);

		if (leaveAccrual == _nullLeaveAccrual) {
			return null;
		}

		if (leaveAccrual == null) {
			Session session = null;

			try {
				session = openSession();

				leaveAccrual = (LeaveAccrual)session.get(LeaveAccrualImpl.class,
						primaryKey);

				if (leaveAccrual != null) {
					cacheResult(leaveAccrual);
				}
				else {
					EntityCacheUtil.putResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
						LeaveAccrualImpl.class, primaryKey, _nullLeaveAccrual);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveAccrualModelImpl.ENTITY_CACHE_ENABLED,
					LeaveAccrualImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveAccrual;
	}

	/**
	 * Returns the leave accrual with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAccrualId the primary key of the leave accrual
	 * @return the leave accrual, or <code>null</code> if a leave accrual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveAccrual fetchByPrimaryKey(long leaveAccrualId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveAccrualId);
	}

	/**
	 * Returns all the leave accruals.
	 *
	 * @return the leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave accruals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave accruals
	 * @param end the upper bound of the range of leave accruals (not inclusive)
	 * @return the range of leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave accruals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveAccrualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave accruals
	 * @param end the upper bound of the range of leave accruals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave accruals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveAccrual> findAll(int start, int end,
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

		List<LeaveAccrual> list = (List<LeaveAccrual>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVEACCRUAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEACCRUAL;

				if (pagination) {
					sql = sql.concat(LeaveAccrualModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveAccrual>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveAccrual>(list);
				}
				else {
					list = (List<LeaveAccrual>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave accruals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveAccrual leaveAccrual : findAll()) {
			remove(leaveAccrual);
		}
	}

	/**
	 * Returns the number of leave accruals.
	 *
	 * @return the number of leave accruals
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

				Query q = session.createQuery(_SQL_COUNT_LEAVEACCRUAL);

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
	 * Initializes the leave accrual persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveAccrual")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveAccrual>> listenersList = new ArrayList<ModelListener<LeaveAccrual>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveAccrual>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveAccrualImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVEACCRUAL = "SELECT leaveAccrual FROM LeaveAccrual leaveAccrual";
	private static final String _SQL_SELECT_LEAVEACCRUAL_WHERE = "SELECT leaveAccrual FROM LeaveAccrual leaveAccrual WHERE ";
	private static final String _SQL_COUNT_LEAVEACCRUAL = "SELECT COUNT(leaveAccrual) FROM LeaveAccrual leaveAccrual";
	private static final String _SQL_COUNT_LEAVEACCRUAL_WHERE = "SELECT COUNT(leaveAccrual) FROM LeaveAccrual leaveAccrual WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveAccrual.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveAccrual exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveAccrual exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveAccrualPersistenceImpl.class);
	private static LeaveAccrual _nullLeaveAccrual = new LeaveAccrualImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveAccrual> toCacheModel() {
				return _nullLeaveAccrualCacheModel;
			}
		};

	private static CacheModel<LeaveAccrual> _nullLeaveAccrualCacheModel = new CacheModel<LeaveAccrual>() {
			@Override
			public LeaveAccrual toEntityModel() {
				return _nullLeaveAccrual;
			}
		};
}