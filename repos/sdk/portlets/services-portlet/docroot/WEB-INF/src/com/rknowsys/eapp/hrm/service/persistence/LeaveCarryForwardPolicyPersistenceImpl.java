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

import com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException;
import com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy;
import com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave carry forward policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveCarryForwardPolicyPersistence
 * @see LeaveCarryForwardPolicyUtil
 * @generated
 */
public class LeaveCarryForwardPolicyPersistenceImpl extends BasePersistenceImpl<LeaveCarryForwardPolicy>
	implements LeaveCarryForwardPolicyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveCarryForwardPolicyUtil} to access the leave carry forward policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveCarryForwardPolicyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveCarryForwardPolicyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave carry forward policies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave carry forward policies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @return the range of matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave carry forward policies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<LeaveCarryForwardPolicy> list = (List<LeaveCarryForwardPolicy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : list) {
				if ((groupId != leaveCarryForwardPolicy.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVECARRYFORWARDPOLICY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveCarryForwardPolicyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveCarryForwardPolicy>(list);
				}
				else {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
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
	 * Returns the first leave carry forward policy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveCarryForwardPolicy != null) {
			return leaveCarryForwardPolicy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCarryForwardPolicyException(msg.toString());
	}

	/**
	 * Returns the first leave carry forward policy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave carry forward policy, or <code>null</code> if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveCarryForwardPolicy> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave carry forward policy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveCarryForwardPolicy != null) {
			return leaveCarryForwardPolicy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCarryForwardPolicyException(msg.toString());
	}

	/**
	 * Returns the last leave carry forward policy in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave carry forward policy, or <code>null</code> if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveCarryForwardPolicy> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave carry forward policies before and after the current leave carry forward policy in the ordered set where groupId = &#63;.
	 *
	 * @param leaveCarryForwardPolicyId the primary key of the current leave carry forward policy
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy[] findByGroupId_PrevAndNext(
		long leaveCarryForwardPolicyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = findByPrimaryKey(leaveCarryForwardPolicyId);

		Session session = null;

		try {
			session = openSession();

			LeaveCarryForwardPolicy[] array = new LeaveCarryForwardPolicyImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					leaveCarryForwardPolicy, groupId, orderByComparator, true);

			array[1] = leaveCarryForwardPolicy;

			array[2] = getByGroupId_PrevAndNext(session,
					leaveCarryForwardPolicy, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveCarryForwardPolicy getByGroupId_PrevAndNext(
		Session session, LeaveCarryForwardPolicy leaveCarryForwardPolicy,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVECARRYFORWARDPOLICY_WHERE);

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
			query.append(LeaveCarryForwardPolicyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveCarryForwardPolicy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveCarryForwardPolicy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave carry forward policies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveCarryForwardPolicy);
		}
	}

	/**
	 * Returns the number of leave carry forward policies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave carry forward policies
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

			query.append(_SQL_COUNT_LEAVECARRYFORWARDPOLICY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveCarryForwardPolicy.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveCarryForwardPolicyModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave carry forward policies where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave carry forward policies where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @return the range of matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByLeaveTypeId(long leaveTypeId,
		int start, int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave carry forward policies where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findByLeaveTypeId(long leaveTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<LeaveCarryForwardPolicy> list = (List<LeaveCarryForwardPolicy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : list) {
				if ((leaveTypeId != leaveCarryForwardPolicy.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVECARRYFORWARDPOLICY_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveCarryForwardPolicyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveCarryForwardPolicy>(list);
				}
				else {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
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
	 * Returns the first leave carry forward policy in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveCarryForwardPolicy != null) {
			return leaveCarryForwardPolicy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCarryForwardPolicyException(msg.toString());
	}

	/**
	 * Returns the first leave carry forward policy in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave carry forward policy, or <code>null</code> if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveCarryForwardPolicy> list = findByLeaveTypeId(leaveTypeId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave carry forward policy in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveCarryForwardPolicy != null) {
			return leaveCarryForwardPolicy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveCarryForwardPolicyException(msg.toString());
	}

	/**
	 * Returns the last leave carry forward policy in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave carry forward policy, or <code>null</code> if a matching leave carry forward policy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveCarryForwardPolicy> list = findByLeaveTypeId(leaveTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave carry forward policies before and after the current leave carry forward policy in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveCarryForwardPolicyId the primary key of the current leave carry forward policy
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy[] findByLeaveTypeId_PrevAndNext(
		long leaveCarryForwardPolicyId, long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = findByPrimaryKey(leaveCarryForwardPolicyId);

		Session session = null;

		try {
			session = openSession();

			LeaveCarryForwardPolicy[] array = new LeaveCarryForwardPolicyImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session,
					leaveCarryForwardPolicy, leaveTypeId, orderByComparator,
					true);

			array[1] = leaveCarryForwardPolicy;

			array[2] = getByLeaveTypeId_PrevAndNext(session,
					leaveCarryForwardPolicy, leaveTypeId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveCarryForwardPolicy getByLeaveTypeId_PrevAndNext(
		Session session, LeaveCarryForwardPolicy leaveCarryForwardPolicy,
		long leaveTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVECARRYFORWARDPOLICY_WHERE);

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
			query.append(LeaveCarryForwardPolicyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveCarryForwardPolicy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveCarryForwardPolicy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave carry forward policies where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : findByLeaveTypeId(
				leaveTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveCarryForwardPolicy);
		}
	}

	/**
	 * Returns the number of leave carry forward policies where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave carry forward policies
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

			query.append(_SQL_COUNT_LEAVECARRYFORWARDPOLICY_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveCarryForwardPolicy.leaveTypeId = ?";

	public LeaveCarryForwardPolicyPersistenceImpl() {
		setModelClass(LeaveCarryForwardPolicy.class);
	}

	/**
	 * Caches the leave carry forward policy in the entity cache if it is enabled.
	 *
	 * @param leaveCarryForwardPolicy the leave carry forward policy
	 */
	@Override
	public void cacheResult(LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		EntityCacheUtil.putResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			leaveCarryForwardPolicy.getPrimaryKey(), leaveCarryForwardPolicy);

		leaveCarryForwardPolicy.resetOriginalValues();
	}

	/**
	 * Caches the leave carry forward policies in the entity cache if it is enabled.
	 *
	 * @param leaveCarryForwardPolicies the leave carry forward policies
	 */
	@Override
	public void cacheResult(
		List<LeaveCarryForwardPolicy> leaveCarryForwardPolicies) {
		for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : leaveCarryForwardPolicies) {
			if (EntityCacheUtil.getResult(
						LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
						LeaveCarryForwardPolicyImpl.class,
						leaveCarryForwardPolicy.getPrimaryKey()) == null) {
				cacheResult(leaveCarryForwardPolicy);
			}
			else {
				leaveCarryForwardPolicy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave carry forward policies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveCarryForwardPolicyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveCarryForwardPolicyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave carry forward policy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		EntityCacheUtil.removeResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			leaveCarryForwardPolicy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<LeaveCarryForwardPolicy> leaveCarryForwardPolicies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : leaveCarryForwardPolicies) {
			EntityCacheUtil.removeResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
				LeaveCarryForwardPolicyImpl.class,
				leaveCarryForwardPolicy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave carry forward policy with the primary key. Does not add the leave carry forward policy to the database.
	 *
	 * @param leaveCarryForwardPolicyId the primary key for the new leave carry forward policy
	 * @return the new leave carry forward policy
	 */
	@Override
	public LeaveCarryForwardPolicy create(long leaveCarryForwardPolicyId) {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = new LeaveCarryForwardPolicyImpl();

		leaveCarryForwardPolicy.setNew(true);
		leaveCarryForwardPolicy.setPrimaryKey(leaveCarryForwardPolicyId);

		return leaveCarryForwardPolicy;
	}

	/**
	 * Removes the leave carry forward policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveCarryForwardPolicyId the primary key of the leave carry forward policy
	 * @return the leave carry forward policy that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy remove(long leaveCarryForwardPolicyId)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		return remove((Serializable)leaveCarryForwardPolicyId);
	}

	/**
	 * Removes the leave carry forward policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave carry forward policy
	 * @return the leave carry forward policy that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy remove(Serializable primaryKey)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveCarryForwardPolicy leaveCarryForwardPolicy = (LeaveCarryForwardPolicy)session.get(LeaveCarryForwardPolicyImpl.class,
					primaryKey);

			if (leaveCarryForwardPolicy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveCarryForwardPolicyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveCarryForwardPolicy);
		}
		catch (NoSuchLeaveCarryForwardPolicyException nsee) {
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
	protected LeaveCarryForwardPolicy removeImpl(
		LeaveCarryForwardPolicy leaveCarryForwardPolicy)
		throws SystemException {
		leaveCarryForwardPolicy = toUnwrappedModel(leaveCarryForwardPolicy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveCarryForwardPolicy)) {
				leaveCarryForwardPolicy = (LeaveCarryForwardPolicy)session.get(LeaveCarryForwardPolicyImpl.class,
						leaveCarryForwardPolicy.getPrimaryKeyObj());
			}

			if (leaveCarryForwardPolicy != null) {
				session.delete(leaveCarryForwardPolicy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveCarryForwardPolicy != null) {
			clearCache(leaveCarryForwardPolicy);
		}

		return leaveCarryForwardPolicy;
	}

	@Override
	public LeaveCarryForwardPolicy updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy)
		throws SystemException {
		leaveCarryForwardPolicy = toUnwrappedModel(leaveCarryForwardPolicy);

		boolean isNew = leaveCarryForwardPolicy.isNew();

		LeaveCarryForwardPolicyModelImpl leaveCarryForwardPolicyModelImpl = (LeaveCarryForwardPolicyModelImpl)leaveCarryForwardPolicy;

		Session session = null;

		try {
			session = openSession();

			if (leaveCarryForwardPolicy.isNew()) {
				session.save(leaveCarryForwardPolicy);

				leaveCarryForwardPolicy.setNew(false);
			}
			else {
				session.merge(leaveCarryForwardPolicy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveCarryForwardPolicyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveCarryForwardPolicyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCarryForwardPolicyModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						leaveCarryForwardPolicyModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveCarryForwardPolicyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveCarryForwardPolicyModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] {
						leaveCarryForwardPolicyModelImpl.getLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
			LeaveCarryForwardPolicyImpl.class,
			leaveCarryForwardPolicy.getPrimaryKey(), leaveCarryForwardPolicy);

		return leaveCarryForwardPolicy;
	}

	protected LeaveCarryForwardPolicy toUnwrappedModel(
		LeaveCarryForwardPolicy leaveCarryForwardPolicy) {
		if (leaveCarryForwardPolicy instanceof LeaveCarryForwardPolicyImpl) {
			return leaveCarryForwardPolicy;
		}

		LeaveCarryForwardPolicyImpl leaveCarryForwardPolicyImpl = new LeaveCarryForwardPolicyImpl();

		leaveCarryForwardPolicyImpl.setNew(leaveCarryForwardPolicy.isNew());
		leaveCarryForwardPolicyImpl.setPrimaryKey(leaveCarryForwardPolicy.getPrimaryKey());

		leaveCarryForwardPolicyImpl.setLeaveCarryForwardPolicyId(leaveCarryForwardPolicy.getLeaveCarryForwardPolicyId());
		leaveCarryForwardPolicyImpl.setCompanyId(leaveCarryForwardPolicy.getCompanyId());
		leaveCarryForwardPolicyImpl.setGroupId(leaveCarryForwardPolicy.getGroupId());
		leaveCarryForwardPolicyImpl.setCreateDate(leaveCarryForwardPolicy.getCreateDate());
		leaveCarryForwardPolicyImpl.setModifiedDate(leaveCarryForwardPolicy.getModifiedDate());
		leaveCarryForwardPolicyImpl.setUserId(leaveCarryForwardPolicy.getUserId());
		leaveCarryForwardPolicyImpl.setLeaveTypeId(leaveCarryForwardPolicy.getLeaveTypeId());
		leaveCarryForwardPolicyImpl.setExpiryDuration(leaveCarryForwardPolicy.getExpiryDuration());
		leaveCarryForwardPolicyImpl.setExpiryDurationUOM(leaveCarryForwardPolicy.getExpiryDurationUOM());
		leaveCarryForwardPolicyImpl.setIsMaxCarryForwardLimitApplicable(leaveCarryForwardPolicy.isIsMaxCarryForwardLimitApplicable());
		leaveCarryForwardPolicyImpl.setMaxCarryForwardLimit(leaveCarryForwardPolicy.getMaxCarryForwardLimit());

		return leaveCarryForwardPolicyImpl;
	}

	/**
	 * Returns the leave carry forward policy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave carry forward policy
	 * @return the leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = fetchByPrimaryKey(primaryKey);

		if (leaveCarryForwardPolicy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveCarryForwardPolicyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveCarryForwardPolicy;
	}

	/**
	 * Returns the leave carry forward policy with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException} if it could not be found.
	 *
	 * @param leaveCarryForwardPolicyId the primary key of the leave carry forward policy
	 * @return the leave carry forward policy
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveCarryForwardPolicyException if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy findByPrimaryKey(
		long leaveCarryForwardPolicyId)
		throws NoSuchLeaveCarryForwardPolicyException, SystemException {
		return findByPrimaryKey((Serializable)leaveCarryForwardPolicyId);
	}

	/**
	 * Returns the leave carry forward policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave carry forward policy
	 * @return the leave carry forward policy, or <code>null</code> if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveCarryForwardPolicy leaveCarryForwardPolicy = (LeaveCarryForwardPolicy)EntityCacheUtil.getResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
				LeaveCarryForwardPolicyImpl.class, primaryKey);

		if (leaveCarryForwardPolicy == _nullLeaveCarryForwardPolicy) {
			return null;
		}

		if (leaveCarryForwardPolicy == null) {
			Session session = null;

			try {
				session = openSession();

				leaveCarryForwardPolicy = (LeaveCarryForwardPolicy)session.get(LeaveCarryForwardPolicyImpl.class,
						primaryKey);

				if (leaveCarryForwardPolicy != null) {
					cacheResult(leaveCarryForwardPolicy);
				}
				else {
					EntityCacheUtil.putResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
						LeaveCarryForwardPolicyImpl.class, primaryKey,
						_nullLeaveCarryForwardPolicy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveCarryForwardPolicyModelImpl.ENTITY_CACHE_ENABLED,
					LeaveCarryForwardPolicyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveCarryForwardPolicy;
	}

	/**
	 * Returns the leave carry forward policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveCarryForwardPolicyId the primary key of the leave carry forward policy
	 * @return the leave carry forward policy, or <code>null</code> if a leave carry forward policy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveCarryForwardPolicy fetchByPrimaryKey(
		long leaveCarryForwardPolicyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveCarryForwardPolicyId);
	}

	/**
	 * Returns all the leave carry forward policies.
	 *
	 * @return the leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave carry forward policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @return the range of leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave carry forward policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave carry forward policies
	 * @param end the upper bound of the range of leave carry forward policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave carry forward policies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveCarryForwardPolicy> findAll(int start, int end,
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

		List<LeaveCarryForwardPolicy> list = (List<LeaveCarryForwardPolicy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVECARRYFORWARDPOLICY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVECARRYFORWARDPOLICY;

				if (pagination) {
					sql = sql.concat(LeaveCarryForwardPolicyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveCarryForwardPolicy>(list);
				}
				else {
					list = (List<LeaveCarryForwardPolicy>)QueryUtil.list(q,
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
	 * Removes all the leave carry forward policies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveCarryForwardPolicy leaveCarryForwardPolicy : findAll()) {
			remove(leaveCarryForwardPolicy);
		}
	}

	/**
	 * Returns the number of leave carry forward policies.
	 *
	 * @return the number of leave carry forward policies
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

				Query q = session.createQuery(_SQL_COUNT_LEAVECARRYFORWARDPOLICY);

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
	 * Initializes the leave carry forward policy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveCarryForwardPolicy>> listenersList = new ArrayList<ModelListener<LeaveCarryForwardPolicy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveCarryForwardPolicy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveCarryForwardPolicyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVECARRYFORWARDPOLICY = "SELECT leaveCarryForwardPolicy FROM LeaveCarryForwardPolicy leaveCarryForwardPolicy";
	private static final String _SQL_SELECT_LEAVECARRYFORWARDPOLICY_WHERE = "SELECT leaveCarryForwardPolicy FROM LeaveCarryForwardPolicy leaveCarryForwardPolicy WHERE ";
	private static final String _SQL_COUNT_LEAVECARRYFORWARDPOLICY = "SELECT COUNT(leaveCarryForwardPolicy) FROM LeaveCarryForwardPolicy leaveCarryForwardPolicy";
	private static final String _SQL_COUNT_LEAVECARRYFORWARDPOLICY_WHERE = "SELECT COUNT(leaveCarryForwardPolicy) FROM LeaveCarryForwardPolicy leaveCarryForwardPolicy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveCarryForwardPolicy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveCarryForwardPolicy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveCarryForwardPolicy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveCarryForwardPolicyPersistenceImpl.class);
	private static LeaveCarryForwardPolicy _nullLeaveCarryForwardPolicy = new LeaveCarryForwardPolicyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveCarryForwardPolicy> toCacheModel() {
				return _nullLeaveCarryForwardPolicyCacheModel;
			}
		};

	private static CacheModel<LeaveCarryForwardPolicy> _nullLeaveCarryForwardPolicyCacheModel =
		new CacheModel<LeaveCarryForwardPolicy>() {
			@Override
			public LeaveCarryForwardPolicy toEntityModel() {
				return _nullLeaveCarryForwardPolicy;
			}
		};
}