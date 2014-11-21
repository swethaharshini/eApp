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

import com.rknowsys.eapp.hrm.NoSuchLeaveRuleException;
import com.rknowsys.eapp.hrm.model.LeaveRule;
import com.rknowsys.eapp.hrm.model.impl.LeaveRuleImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveRulePersistence
 * @see LeaveRuleUtil
 * @generated
 */
public class LeaveRulePersistenceImpl extends BasePersistenceImpl<LeaveRule>
	implements LeaveRulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveRuleUtil} to access the leave rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveRuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveRuleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave rules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @return the range of matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByGroupId(long groupId, int start, int end,
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

		List<LeaveRule> list = (List<LeaveRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRule leaveRule : list) {
				if ((groupId != leaveRule.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVERULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRule>(list);
				}
				else {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = fetchByGroupId_First(groupId, orderByComparator);

		if (leaveRule != null) {
			return leaveRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleException(msg.toString());
	}

	/**
	 * Returns the first leave rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule, or <code>null</code> if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRule> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = fetchByGroupId_Last(groupId, orderByComparator);

		if (leaveRule != null) {
			return leaveRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleException(msg.toString());
	}

	/**
	 * Returns the last leave rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule, or <code>null</code> if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveRule> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave rules before and after the current leave rule in the ordered set where groupId = &#63;.
	 *
	 * @param leaveRuleId the primary key of the current leave rule
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule[] findByGroupId_PrevAndNext(long leaveRuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = findByPrimaryKey(leaveRuleId);

		Session session = null;

		try {
			session = openSession();

			LeaveRule[] array = new LeaveRuleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveRule, groupId,
					orderByComparator, true);

			array[1] = leaveRule;

			array[2] = getByGroupId_PrevAndNext(session, leaveRule, groupId,
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

	protected LeaveRule getByGroupId_PrevAndNext(Session session,
		LeaveRule leaveRule, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERULE_WHERE);

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
			query.append(LeaveRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave rules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveRule leaveRule : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(leaveRule);
		}
	}

	/**
	 * Returns the number of leave rules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave rules
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

			query.append(_SQL_COUNT_LEAVERULE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveRule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, LeaveRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveRuleModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave rules where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rules where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @return the range of matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByLeaveTypeId(long leaveTypeId, int start,
		int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rules where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findByLeaveTypeId(long leaveTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID;
			finderArgs = new Object[] { leaveTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID;
			finderArgs = new Object[] { leaveTypeId, start, end, orderByComparator };
		}

		List<LeaveRule> list = (List<LeaveRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRule leaveRule : list) {
				if ((leaveTypeId != leaveRule.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVERULE_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRule>(list);
				}
				else {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave rule in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveRule != null) {
			return leaveRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleException(msg.toString());
	}

	/**
	 * Returns the first leave rule in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule, or <code>null</code> if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRule> list = findByLeaveTypeId(leaveTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave rule in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveRule != null) {
			return leaveRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleException(msg.toString());
	}

	/**
	 * Returns the last leave rule in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule, or <code>null</code> if a matching leave rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveRule> list = findByLeaveTypeId(leaveTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave rules before and after the current leave rule in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveRuleId the primary key of the current leave rule
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule[] findByLeaveTypeId_PrevAndNext(long leaveRuleId,
		long leaveTypeId, OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = findByPrimaryKey(leaveRuleId);

		Session session = null;

		try {
			session = openSession();

			LeaveRule[] array = new LeaveRuleImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session, leaveRule,
					leaveTypeId, orderByComparator, true);

			array[1] = leaveRule;

			array[2] = getByLeaveTypeId_PrevAndNext(session, leaveRule,
					leaveTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveRule getByLeaveTypeId_PrevAndNext(Session session,
		LeaveRule leaveRule, long leaveTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERULE_WHERE);

		query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

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
			query.append(LeaveRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave rules where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveRule leaveRule : findByLeaveTypeId(leaveTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveRule);
		}
	}

	/**
	 * Returns the number of leave rules where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave rules
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

			query.append(_SQL_COUNT_LEAVERULE_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveRule.leaveTypeId = ?";

	public LeaveRulePersistenceImpl() {
		setModelClass(LeaveRule.class);
	}

	/**
	 * Caches the leave rule in the entity cache if it is enabled.
	 *
	 * @param leaveRule the leave rule
	 */
	@Override
	public void cacheResult(LeaveRule leaveRule) {
		EntityCacheUtil.putResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleImpl.class, leaveRule.getPrimaryKey(), leaveRule);

		leaveRule.resetOriginalValues();
	}

	/**
	 * Caches the leave rules in the entity cache if it is enabled.
	 *
	 * @param leaveRules the leave rules
	 */
	@Override
	public void cacheResult(List<LeaveRule> leaveRules) {
		for (LeaveRule leaveRule : leaveRules) {
			if (EntityCacheUtil.getResult(
						LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRuleImpl.class, leaveRule.getPrimaryKey()) == null) {
				cacheResult(leaveRule);
			}
			else {
				leaveRule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveRuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveRuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveRule leaveRule) {
		EntityCacheUtil.removeResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleImpl.class, leaveRule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveRule> leaveRules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveRule leaveRule : leaveRules) {
			EntityCacheUtil.removeResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRuleImpl.class, leaveRule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave rule with the primary key. Does not add the leave rule to the database.
	 *
	 * @param leaveRuleId the primary key for the new leave rule
	 * @return the new leave rule
	 */
	@Override
	public LeaveRule create(long leaveRuleId) {
		LeaveRule leaveRule = new LeaveRuleImpl();

		leaveRule.setNew(true);
		leaveRule.setPrimaryKey(leaveRuleId);

		return leaveRule;
	}

	/**
	 * Removes the leave rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveRuleId the primary key of the leave rule
	 * @return the leave rule that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule remove(long leaveRuleId)
		throws NoSuchLeaveRuleException, SystemException {
		return remove((Serializable)leaveRuleId);
	}

	/**
	 * Removes the leave rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave rule
	 * @return the leave rule that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule remove(Serializable primaryKey)
		throws NoSuchLeaveRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveRule leaveRule = (LeaveRule)session.get(LeaveRuleImpl.class,
					primaryKey);

			if (leaveRule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveRule);
		}
		catch (NoSuchLeaveRuleException nsee) {
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
	protected LeaveRule removeImpl(LeaveRule leaveRule)
		throws SystemException {
		leaveRule = toUnwrappedModel(leaveRule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveRule)) {
				leaveRule = (LeaveRule)session.get(LeaveRuleImpl.class,
						leaveRule.getPrimaryKeyObj());
			}

			if (leaveRule != null) {
				session.delete(leaveRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveRule != null) {
			clearCache(leaveRule);
		}

		return leaveRule;
	}

	@Override
	public LeaveRule updateImpl(com.rknowsys.eapp.hrm.model.LeaveRule leaveRule)
		throws SystemException {
		leaveRule = toUnwrappedModel(leaveRule);

		boolean isNew = leaveRule.isNew();

		LeaveRuleModelImpl leaveRuleModelImpl = (LeaveRuleModelImpl)leaveRule;

		Session session = null;

		try {
			session = openSession();

			if (leaveRule.isNew()) {
				session.save(leaveRule);

				leaveRule.setNew(false);
			}
			else {
				session.merge(leaveRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveRuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRuleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveRuleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRuleModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] { leaveRuleModelImpl.getLeaveTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleImpl.class, leaveRule.getPrimaryKey(), leaveRule);

		return leaveRule;
	}

	protected LeaveRule toUnwrappedModel(LeaveRule leaveRule) {
		if (leaveRule instanceof LeaveRuleImpl) {
			return leaveRule;
		}

		LeaveRuleImpl leaveRuleImpl = new LeaveRuleImpl();

		leaveRuleImpl.setNew(leaveRule.isNew());
		leaveRuleImpl.setPrimaryKey(leaveRule.getPrimaryKey());

		leaveRuleImpl.setLeaveRuleId(leaveRule.getLeaveRuleId());
		leaveRuleImpl.setCompanyId(leaveRule.getCompanyId());
		leaveRuleImpl.setGroupId(leaveRule.getGroupId());
		leaveRuleImpl.setCreateDate(leaveRule.getCreateDate());
		leaveRuleImpl.setModifiedDate(leaveRule.getModifiedDate());
		leaveRuleImpl.setUserId(leaveRule.getUserId());
		leaveRuleImpl.setLeaveTypeId(leaveRule.getLeaveTypeId());
		leaveRuleImpl.setLeavePeriodTypeId(leaveRule.getLeavePeriodTypeId());
		leaveRuleImpl.setStartMonth(leaveRule.getStartMonth());
		leaveRuleImpl.setStartDayOfMonth(leaveRule.getStartDayOfMonth());
		leaveRuleImpl.setDuration(leaveRule.getDuration());
		leaveRuleImpl.setIfEmployeesCanApply(leaveRule.isIfEmployeesCanApply());
		leaveRuleImpl.setIfAdminCanAssign(leaveRule.isIfAdminCanAssign());
		leaveRuleImpl.setIfAdminCanManageEntitlements(leaveRule.isIfAdminCanManageEntitlements());
		leaveRuleImpl.setIfLeaveAccruable(leaveRule.isIfLeaveAccruable());
		leaveRuleImpl.setIfCarryForwardable(leaveRule.isIfCarryForwardable());

		return leaveRuleImpl;
	}

	/**
	 * Returns the leave rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave rule
	 * @return the leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveRuleException, SystemException {
		LeaveRule leaveRule = fetchByPrimaryKey(primaryKey);

		if (leaveRule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveRule;
	}

	/**
	 * Returns the leave rule with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveRuleException} if it could not be found.
	 *
	 * @param leaveRuleId the primary key of the leave rule
	 * @return the leave rule
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleException if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule findByPrimaryKey(long leaveRuleId)
		throws NoSuchLeaveRuleException, SystemException {
		return findByPrimaryKey((Serializable)leaveRuleId);
	}

	/**
	 * Returns the leave rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave rule
	 * @return the leave rule, or <code>null</code> if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveRule leaveRule = (LeaveRule)EntityCacheUtil.getResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRuleImpl.class, primaryKey);

		if (leaveRule == _nullLeaveRule) {
			return null;
		}

		if (leaveRule == null) {
			Session session = null;

			try {
				session = openSession();

				leaveRule = (LeaveRule)session.get(LeaveRuleImpl.class,
						primaryKey);

				if (leaveRule != null) {
					cacheResult(leaveRule);
				}
				else {
					EntityCacheUtil.putResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRuleImpl.class, primaryKey, _nullLeaveRule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveRuleModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveRule;
	}

	/**
	 * Returns the leave rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveRuleId the primary key of the leave rule
	 * @return the leave rule, or <code>null</code> if a leave rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRule fetchByPrimaryKey(long leaveRuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveRuleId);
	}

	/**
	 * Returns all the leave rules.
	 *
	 * @return the leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @return the range of leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave rules
	 * @param end the upper bound of the range of leave rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRule> findAll(int start, int end,
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

		List<LeaveRule> list = (List<LeaveRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVERULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVERULE;

				if (pagination) {
					sql = sql.concat(LeaveRuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRule>(list);
				}
				else {
					list = (List<LeaveRule>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveRule leaveRule : findAll()) {
			remove(leaveRule);
		}
	}

	/**
	 * Returns the number of leave rules.
	 *
	 * @return the number of leave rules
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

				Query q = session.createQuery(_SQL_COUNT_LEAVERULE);

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
	 * Initializes the leave rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveRule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveRule>> listenersList = new ArrayList<ModelListener<LeaveRule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveRule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveRuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVERULE = "SELECT leaveRule FROM LeaveRule leaveRule";
	private static final String _SQL_SELECT_LEAVERULE_WHERE = "SELECT leaveRule FROM LeaveRule leaveRule WHERE ";
	private static final String _SQL_COUNT_LEAVERULE = "SELECT COUNT(leaveRule) FROM LeaveRule leaveRule";
	private static final String _SQL_COUNT_LEAVERULE_WHERE = "SELECT COUNT(leaveRule) FROM LeaveRule leaveRule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveRule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveRule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveRule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveRulePersistenceImpl.class);
	private static LeaveRule _nullLeaveRule = new LeaveRuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveRule> toCacheModel() {
				return _nullLeaveRuleCacheModel;
			}
		};

	private static CacheModel<LeaveRule> _nullLeaveRuleCacheModel = new CacheModel<LeaveRule>() {
			@Override
			public LeaveRule toEntityModel() {
				return _nullLeaveRule;
			}
		};
}