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

import com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException;
import com.rknowsys.eapp.hrm.model.LeaveRestriction;
import com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave restriction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveRestrictionPersistence
 * @see LeaveRestrictionUtil
 * @generated
 */
public class LeaveRestrictionPersistenceImpl extends BasePersistenceImpl<LeaveRestriction>
	implements LeaveRestrictionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveRestrictionUtil} to access the leave restriction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveRestrictionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveRestrictionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave restrictions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave restrictions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @return the range of matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave restrictions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByGroupId(long groupId, int start,
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

		List<LeaveRestriction> list = (List<LeaveRestriction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRestriction leaveRestriction : list) {
				if ((groupId != leaveRestriction.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVERESTRICTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRestrictionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRestriction>(list);
				}
				else {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
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
	 * Returns the first leave restriction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveRestriction != null) {
			return leaveRestriction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRestrictionException(msg.toString());
	}

	/**
	 * Returns the first leave restriction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave restriction, or <code>null</code> if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRestriction> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave restriction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveRestriction != null) {
			return leaveRestriction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRestrictionException(msg.toString());
	}

	/**
	 * Returns the last leave restriction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave restriction, or <code>null</code> if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveRestriction> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave restrictions before and after the current leave restriction in the ordered set where groupId = &#63;.
	 *
	 * @param leaveRestrictionId the primary key of the current leave restriction
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction[] findByGroupId_PrevAndNext(
		long leaveRestrictionId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = findByPrimaryKey(leaveRestrictionId);

		Session session = null;

		try {
			session = openSession();

			LeaveRestriction[] array = new LeaveRestrictionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveRestriction,
					groupId, orderByComparator, true);

			array[1] = leaveRestriction;

			array[2] = getByGroupId_PrevAndNext(session, leaveRestriction,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveRestriction getByGroupId_PrevAndNext(Session session,
		LeaveRestriction leaveRestriction, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERESTRICTION_WHERE);

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
			query.append(LeaveRestrictionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRestriction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRestriction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave restrictions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveRestriction leaveRestriction : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveRestriction);
		}
	}

	/**
	 * Returns the number of leave restrictions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave restrictions
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

			query.append(_SQL_COUNT_LEAVERESTRICTION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveRestriction.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED,
			LeaveRestrictionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveRestrictionModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave restrictions where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave restrictions where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @return the range of matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByLeaveTypeId(long leaveTypeId,
		int start, int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave restrictions where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findByLeaveTypeId(long leaveTypeId,
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

		List<LeaveRestriction> list = (List<LeaveRestriction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRestriction leaveRestriction : list) {
				if ((leaveTypeId != leaveRestriction.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVERESTRICTION_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRestrictionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRestriction>(list);
				}
				else {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
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
	 * Returns the first leave restriction in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveRestriction != null) {
			return leaveRestriction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRestrictionException(msg.toString());
	}

	/**
	 * Returns the first leave restriction in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave restriction, or <code>null</code> if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRestriction> list = findByLeaveTypeId(leaveTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave restriction in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveRestriction != null) {
			return leaveRestriction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRestrictionException(msg.toString());
	}

	/**
	 * Returns the last leave restriction in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave restriction, or <code>null</code> if a matching leave restriction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveRestriction> list = findByLeaveTypeId(leaveTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave restrictions before and after the current leave restriction in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveRestrictionId the primary key of the current leave restriction
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction[] findByLeaveTypeId_PrevAndNext(
		long leaveRestrictionId, long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = findByPrimaryKey(leaveRestrictionId);

		Session session = null;

		try {
			session = openSession();

			LeaveRestriction[] array = new LeaveRestrictionImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session, leaveRestriction,
					leaveTypeId, orderByComparator, true);

			array[1] = leaveRestriction;

			array[2] = getByLeaveTypeId_PrevAndNext(session, leaveRestriction,
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

	protected LeaveRestriction getByLeaveTypeId_PrevAndNext(Session session,
		LeaveRestriction leaveRestriction, long leaveTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERESTRICTION_WHERE);

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
			query.append(LeaveRestrictionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRestriction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRestriction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave restrictions where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveRestriction leaveRestriction : findByLeaveTypeId(
				leaveTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveRestriction);
		}
	}

	/**
	 * Returns the number of leave restrictions where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave restrictions
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

			query.append(_SQL_COUNT_LEAVERESTRICTION_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveRestriction.leaveTypeId = ?";

	public LeaveRestrictionPersistenceImpl() {
		setModelClass(LeaveRestriction.class);
	}

	/**
	 * Caches the leave restriction in the entity cache if it is enabled.
	 *
	 * @param leaveRestriction the leave restriction
	 */
	@Override
	public void cacheResult(LeaveRestriction leaveRestriction) {
		EntityCacheUtil.putResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionImpl.class, leaveRestriction.getPrimaryKey(),
			leaveRestriction);

		leaveRestriction.resetOriginalValues();
	}

	/**
	 * Caches the leave restrictions in the entity cache if it is enabled.
	 *
	 * @param leaveRestrictions the leave restrictions
	 */
	@Override
	public void cacheResult(List<LeaveRestriction> leaveRestrictions) {
		for (LeaveRestriction leaveRestriction : leaveRestrictions) {
			if (EntityCacheUtil.getResult(
						LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRestrictionImpl.class,
						leaveRestriction.getPrimaryKey()) == null) {
				cacheResult(leaveRestriction);
			}
			else {
				leaveRestriction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave restrictions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveRestrictionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveRestrictionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave restriction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveRestriction leaveRestriction) {
		EntityCacheUtil.removeResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionImpl.class, leaveRestriction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveRestriction> leaveRestrictions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveRestriction leaveRestriction : leaveRestrictions) {
			EntityCacheUtil.removeResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRestrictionImpl.class, leaveRestriction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave restriction with the primary key. Does not add the leave restriction to the database.
	 *
	 * @param leaveRestrictionId the primary key for the new leave restriction
	 * @return the new leave restriction
	 */
	@Override
	public LeaveRestriction create(long leaveRestrictionId) {
		LeaveRestriction leaveRestriction = new LeaveRestrictionImpl();

		leaveRestriction.setNew(true);
		leaveRestriction.setPrimaryKey(leaveRestrictionId);

		return leaveRestriction;
	}

	/**
	 * Removes the leave restriction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveRestrictionId the primary key of the leave restriction
	 * @return the leave restriction that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction remove(long leaveRestrictionId)
		throws NoSuchLeaveRestrictionException, SystemException {
		return remove((Serializable)leaveRestrictionId);
	}

	/**
	 * Removes the leave restriction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave restriction
	 * @return the leave restriction that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction remove(Serializable primaryKey)
		throws NoSuchLeaveRestrictionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveRestriction leaveRestriction = (LeaveRestriction)session.get(LeaveRestrictionImpl.class,
					primaryKey);

			if (leaveRestriction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveRestrictionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveRestriction);
		}
		catch (NoSuchLeaveRestrictionException nsee) {
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
	protected LeaveRestriction removeImpl(LeaveRestriction leaveRestriction)
		throws SystemException {
		leaveRestriction = toUnwrappedModel(leaveRestriction);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveRestriction)) {
				leaveRestriction = (LeaveRestriction)session.get(LeaveRestrictionImpl.class,
						leaveRestriction.getPrimaryKeyObj());
			}

			if (leaveRestriction != null) {
				session.delete(leaveRestriction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveRestriction != null) {
			clearCache(leaveRestriction);
		}

		return leaveRestriction;
	}

	@Override
	public LeaveRestriction updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveRestriction leaveRestriction)
		throws SystemException {
		leaveRestriction = toUnwrappedModel(leaveRestriction);

		boolean isNew = leaveRestriction.isNew();

		LeaveRestrictionModelImpl leaveRestrictionModelImpl = (LeaveRestrictionModelImpl)leaveRestriction;

		Session session = null;

		try {
			session = openSession();

			if (leaveRestriction.isNew()) {
				session.save(leaveRestriction);

				leaveRestriction.setNew(false);
			}
			else {
				session.merge(leaveRestriction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveRestrictionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveRestrictionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRestrictionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveRestrictionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveRestrictionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRestrictionModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] { leaveRestrictionModelImpl.getLeaveTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRestrictionImpl.class, leaveRestriction.getPrimaryKey(),
			leaveRestriction);

		return leaveRestriction;
	}

	protected LeaveRestriction toUnwrappedModel(
		LeaveRestriction leaveRestriction) {
		if (leaveRestriction instanceof LeaveRestrictionImpl) {
			return leaveRestriction;
		}

		LeaveRestrictionImpl leaveRestrictionImpl = new LeaveRestrictionImpl();

		leaveRestrictionImpl.setNew(leaveRestriction.isNew());
		leaveRestrictionImpl.setPrimaryKey(leaveRestriction.getPrimaryKey());

		leaveRestrictionImpl.setLeaveRestrictionId(leaveRestriction.getLeaveRestrictionId());
		leaveRestrictionImpl.setCompanyId(leaveRestriction.getCompanyId());
		leaveRestrictionImpl.setGroupId(leaveRestriction.getGroupId());
		leaveRestrictionImpl.setCreateDate(leaveRestriction.getCreateDate());
		leaveRestrictionImpl.setModifiedDate(leaveRestriction.getModifiedDate());
		leaveRestrictionImpl.setUserId(leaveRestriction.getUserId());
		leaveRestrictionImpl.setLeaveTypeId(leaveRestriction.getLeaveTypeId());
		leaveRestrictionImpl.setCannotExceedBalance(leaveRestriction.isCannotExceedBalance());
		leaveRestrictionImpl.setCannotApplyForPartialDay(leaveRestriction.isCannotApplyForPartialDay());
		leaveRestrictionImpl.setIfATermsQuestion(leaveRestriction.isIfATermsQuestion());
		leaveRestrictionImpl.setTermsQuestion(leaveRestriction.getTermsQuestion());
		leaveRestrictionImpl.setErrorTextIfTermsDeclined(leaveRestriction.getErrorTextIfTermsDeclined());
		leaveRestrictionImpl.setIsMinimumServicePeriodApplicable(leaveRestriction.isIsMinimumServicePeriodApplicable());
		leaveRestrictionImpl.setMinimumServicePeriod(leaveRestriction.getMinimumServicePeriod());
		leaveRestrictionImpl.setIsMaxConsecutiveLeavesApplicable(leaveRestriction.isIsMaxConsecutiveLeavesApplicable());
		leaveRestrictionImpl.setMaxConsecutiveLeaves(leaveRestriction.getMaxConsecutiveLeaves());
		leaveRestrictionImpl.setIsSmallChildCriterionApplicable(leaveRestriction.isIsSmallChildCriterionApplicable());
		leaveRestrictionImpl.setMaxSmallChildAgeApplicable(leaveRestriction.getMaxSmallChildAgeApplicable());

		return leaveRestrictionImpl;
	}

	/**
	 * Returns the leave restriction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave restriction
	 * @return the leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveRestrictionException, SystemException {
		LeaveRestriction leaveRestriction = fetchByPrimaryKey(primaryKey);

		if (leaveRestriction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveRestrictionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveRestriction;
	}

	/**
	 * Returns the leave restriction with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException} if it could not be found.
	 *
	 * @param leaveRestrictionId the primary key of the leave restriction
	 * @return the leave restriction
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRestrictionException if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction findByPrimaryKey(long leaveRestrictionId)
		throws NoSuchLeaveRestrictionException, SystemException {
		return findByPrimaryKey((Serializable)leaveRestrictionId);
	}

	/**
	 * Returns the leave restriction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave restriction
	 * @return the leave restriction, or <code>null</code> if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveRestriction leaveRestriction = (LeaveRestriction)EntityCacheUtil.getResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRestrictionImpl.class, primaryKey);

		if (leaveRestriction == _nullLeaveRestriction) {
			return null;
		}

		if (leaveRestriction == null) {
			Session session = null;

			try {
				session = openSession();

				leaveRestriction = (LeaveRestriction)session.get(LeaveRestrictionImpl.class,
						primaryKey);

				if (leaveRestriction != null) {
					cacheResult(leaveRestriction);
				}
				else {
					EntityCacheUtil.putResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRestrictionImpl.class, primaryKey,
						_nullLeaveRestriction);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveRestrictionModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRestrictionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveRestriction;
	}

	/**
	 * Returns the leave restriction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveRestrictionId the primary key of the leave restriction
	 * @return the leave restriction, or <code>null</code> if a leave restriction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRestriction fetchByPrimaryKey(long leaveRestrictionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveRestrictionId);
	}

	/**
	 * Returns all the leave restrictions.
	 *
	 * @return the leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave restrictions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @return the range of leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave restrictions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRestrictionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave restrictions
	 * @param end the upper bound of the range of leave restrictions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave restrictions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRestriction> findAll(int start, int end,
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

		List<LeaveRestriction> list = (List<LeaveRestriction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVERESTRICTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVERESTRICTION;

				if (pagination) {
					sql = sql.concat(LeaveRestrictionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRestriction>(list);
				}
				else {
					list = (List<LeaveRestriction>)QueryUtil.list(q,
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
	 * Removes all the leave restrictions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveRestriction leaveRestriction : findAll()) {
			remove(leaveRestriction);
		}
	}

	/**
	 * Returns the number of leave restrictions.
	 *
	 * @return the number of leave restrictions
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

				Query q = session.createQuery(_SQL_COUNT_LEAVERESTRICTION);

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
	 * Initializes the leave restriction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveRestriction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveRestriction>> listenersList = new ArrayList<ModelListener<LeaveRestriction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveRestriction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveRestrictionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVERESTRICTION = "SELECT leaveRestriction FROM LeaveRestriction leaveRestriction";
	private static final String _SQL_SELECT_LEAVERESTRICTION_WHERE = "SELECT leaveRestriction FROM LeaveRestriction leaveRestriction WHERE ";
	private static final String _SQL_COUNT_LEAVERESTRICTION = "SELECT COUNT(leaveRestriction) FROM LeaveRestriction leaveRestriction";
	private static final String _SQL_COUNT_LEAVERESTRICTION_WHERE = "SELECT COUNT(leaveRestriction) FROM LeaveRestriction leaveRestriction WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveRestriction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveRestriction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveRestriction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveRestrictionPersistenceImpl.class);
	private static LeaveRestriction _nullLeaveRestriction = new LeaveRestrictionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveRestriction> toCacheModel() {
				return _nullLeaveRestrictionCacheModel;
			}
		};

	private static CacheModel<LeaveRestriction> _nullLeaveRestrictionCacheModel = new CacheModel<LeaveRestriction>() {
			@Override
			public LeaveRestriction toEntityModel() {
				return _nullLeaveRestriction;
			}
		};
}