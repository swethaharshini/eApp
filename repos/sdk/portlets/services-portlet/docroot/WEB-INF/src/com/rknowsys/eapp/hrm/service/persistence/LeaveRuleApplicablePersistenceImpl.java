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

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException;
import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;
import com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the leave rule applicable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveRuleApplicablePersistence
 * @see LeaveRuleApplicableUtil
 * @generated
 */
public class LeaveRuleApplicablePersistenceImpl extends BasePersistenceImpl<LeaveRuleApplicable>
	implements LeaveRuleApplicablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveRuleApplicableUtil} to access the leave rule applicable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveRuleApplicableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveRuleApplicableModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave rule applicables where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rule applicables where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rule applicables where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByGroupId(long groupId, int start,
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

		List<LeaveRuleApplicable> list = (List<LeaveRuleApplicable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRuleApplicable leaveRuleApplicable : list) {
				if ((groupId != leaveRuleApplicable.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVERULEAPPLICABLE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRuleApplicableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRuleApplicable>(list);
				}
				else {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
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
	 * Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveRuleApplicable != null) {
			return leaveRuleApplicable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleApplicableException(msg.toString());
	}

	/**
	 * Returns the first leave rule applicable in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRuleApplicable> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveRuleApplicable != null) {
			return leaveRuleApplicable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleApplicableException(msg.toString());
	}

	/**
	 * Returns the last leave rule applicable in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveRuleApplicable> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave rule applicables before and after the current leave rule applicable in the ordered set where groupId = &#63;.
	 *
	 * @param leaveRuleApplicableId the primary key of the current leave rule applicable
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable[] findByGroupId_PrevAndNext(
		long leaveRuleApplicableId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = findByPrimaryKey(leaveRuleApplicableId);

		Session session = null;

		try {
			session = openSession();

			LeaveRuleApplicable[] array = new LeaveRuleApplicableImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveRuleApplicable,
					groupId, orderByComparator, true);

			array[1] = leaveRuleApplicable;

			array[2] = getByGroupId_PrevAndNext(session, leaveRuleApplicable,
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

	protected LeaveRuleApplicable getByGroupId_PrevAndNext(Session session,
		LeaveRuleApplicable leaveRuleApplicable, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERULEAPPLICABLE_WHERE);

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
			query.append(LeaveRuleApplicableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRuleApplicable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRuleApplicable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave rule applicables where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveRuleApplicable leaveRuleApplicable : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveRuleApplicable);
		}
	}

	/**
	 * Returns the number of leave rule applicables where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave rule applicables
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

			query.append(_SQL_COUNT_LEAVERULEAPPLICABLE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveRuleApplicable.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveRuleApplicableModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave rule applicables where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rule applicables where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByLeaveTypeId(long leaveTypeId,
		int start, int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rule applicables where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findByLeaveTypeId(long leaveTypeId,
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

		List<LeaveRuleApplicable> list = (List<LeaveRuleApplicable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveRuleApplicable leaveRuleApplicable : list) {
				if ((leaveTypeId != leaveRuleApplicable.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVERULEAPPLICABLE_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveRuleApplicableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRuleApplicable>(list);
				}
				else {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
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
	 * Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveRuleApplicable != null) {
			return leaveRuleApplicable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleApplicableException(msg.toString());
	}

	/**
	 * Returns the first leave rule applicable in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveRuleApplicable> list = findByLeaveTypeId(leaveTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveRuleApplicable != null) {
			return leaveRuleApplicable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveRuleApplicableException(msg.toString());
	}

	/**
	 * Returns the last leave rule applicable in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave rule applicable, or <code>null</code> if a matching leave rule applicable could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveRuleApplicable> list = findByLeaveTypeId(leaveTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave rule applicables before and after the current leave rule applicable in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveRuleApplicableId the primary key of the current leave rule applicable
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable[] findByLeaveTypeId_PrevAndNext(
		long leaveRuleApplicableId, long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = findByPrimaryKey(leaveRuleApplicableId);

		Session session = null;

		try {
			session = openSession();

			LeaveRuleApplicable[] array = new LeaveRuleApplicableImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session,
					leaveRuleApplicable, leaveTypeId, orderByComparator, true);

			array[1] = leaveRuleApplicable;

			array[2] = getByLeaveTypeId_PrevAndNext(session,
					leaveRuleApplicable, leaveTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveRuleApplicable getByLeaveTypeId_PrevAndNext(
		Session session, LeaveRuleApplicable leaveRuleApplicable,
		long leaveTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVERULEAPPLICABLE_WHERE);

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
			query.append(LeaveRuleApplicableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveRuleApplicable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveRuleApplicable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave rule applicables where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveRuleApplicable leaveRuleApplicable : findByLeaveTypeId(
				leaveTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveRuleApplicable);
		}
	}

	/**
	 * Returns the number of leave rule applicables where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave rule applicables
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

			query.append(_SQL_COUNT_LEAVERULEAPPLICABLE_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveRuleApplicable.leaveTypeId = ?";

	public LeaveRuleApplicablePersistenceImpl() {
		setModelClass(LeaveRuleApplicable.class);
	}

	/**
	 * Caches the leave rule applicable in the entity cache if it is enabled.
	 *
	 * @param leaveRuleApplicable the leave rule applicable
	 */
	@Override
	public void cacheResult(LeaveRuleApplicable leaveRuleApplicable) {
		EntityCacheUtil.putResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class, leaveRuleApplicable.getPrimaryKey(),
			leaveRuleApplicable);

		leaveRuleApplicable.resetOriginalValues();
	}

	/**
	 * Caches the leave rule applicables in the entity cache if it is enabled.
	 *
	 * @param leaveRuleApplicables the leave rule applicables
	 */
	@Override
	public void cacheResult(List<LeaveRuleApplicable> leaveRuleApplicables) {
		for (LeaveRuleApplicable leaveRuleApplicable : leaveRuleApplicables) {
			if (EntityCacheUtil.getResult(
						LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRuleApplicableImpl.class,
						leaveRuleApplicable.getPrimaryKey()) == null) {
				cacheResult(leaveRuleApplicable);
			}
			else {
				leaveRuleApplicable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave rule applicables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveRuleApplicableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveRuleApplicableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave rule applicable.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveRuleApplicable leaveRuleApplicable) {
		EntityCacheUtil.removeResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class, leaveRuleApplicable.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveRuleApplicable> leaveRuleApplicables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveRuleApplicable leaveRuleApplicable : leaveRuleApplicables) {
			EntityCacheUtil.removeResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRuleApplicableImpl.class,
				leaveRuleApplicable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave rule applicable with the primary key. Does not add the leave rule applicable to the database.
	 *
	 * @param leaveRuleApplicableId the primary key for the new leave rule applicable
	 * @return the new leave rule applicable
	 */
	@Override
	public LeaveRuleApplicable create(long leaveRuleApplicableId) {
		LeaveRuleApplicable leaveRuleApplicable = new LeaveRuleApplicableImpl();

		leaveRuleApplicable.setNew(true);
		leaveRuleApplicable.setPrimaryKey(leaveRuleApplicableId);

		return leaveRuleApplicable;
	}

	/**
	 * Removes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveRuleApplicableId the primary key of the leave rule applicable
	 * @return the leave rule applicable that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable remove(long leaveRuleApplicableId)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		return remove((Serializable)leaveRuleApplicableId);
	}

	/**
	 * Removes the leave rule applicable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave rule applicable
	 * @return the leave rule applicable that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable remove(Serializable primaryKey)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveRuleApplicable leaveRuleApplicable = (LeaveRuleApplicable)session.get(LeaveRuleApplicableImpl.class,
					primaryKey);

			if (leaveRuleApplicable == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveRuleApplicableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveRuleApplicable);
		}
		catch (NoSuchLeaveRuleApplicableException nsee) {
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
	protected LeaveRuleApplicable removeImpl(
		LeaveRuleApplicable leaveRuleApplicable) throws SystemException {
		leaveRuleApplicable = toUnwrappedModel(leaveRuleApplicable);

		leaveRuleApplicableToJobCategoryTableMapper.deleteLeftPrimaryKeyTableMappings(leaveRuleApplicable.getPrimaryKey());

		leaveRuleApplicableToJobTitleTableMapper.deleteLeftPrimaryKeyTableMappings(leaveRuleApplicable.getPrimaryKey());

		leaveRuleApplicableToEmploymentStatusTableMapper.deleteLeftPrimaryKeyTableMappings(leaveRuleApplicable.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveRuleApplicable)) {
				leaveRuleApplicable = (LeaveRuleApplicable)session.get(LeaveRuleApplicableImpl.class,
						leaveRuleApplicable.getPrimaryKeyObj());
			}

			if (leaveRuleApplicable != null) {
				session.delete(leaveRuleApplicable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveRuleApplicable != null) {
			clearCache(leaveRuleApplicable);
		}

		return leaveRuleApplicable;
	}

	@Override
	public LeaveRuleApplicable updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveRuleApplicable leaveRuleApplicable)
		throws SystemException {
		leaveRuleApplicable = toUnwrappedModel(leaveRuleApplicable);

		boolean isNew = leaveRuleApplicable.isNew();

		LeaveRuleApplicableModelImpl leaveRuleApplicableModelImpl = (LeaveRuleApplicableModelImpl)leaveRuleApplicable;

		Session session = null;

		try {
			session = openSession();

			if (leaveRuleApplicable.isNew()) {
				session.save(leaveRuleApplicable);

				leaveRuleApplicable.setNew(false);
			}
			else {
				session.merge(leaveRuleApplicable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveRuleApplicableModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveRuleApplicableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRuleApplicableModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveRuleApplicableModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveRuleApplicableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveRuleApplicableModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] {
						leaveRuleApplicableModelImpl.getLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRuleApplicableImpl.class, leaveRuleApplicable.getPrimaryKey(),
			leaveRuleApplicable);

		return leaveRuleApplicable;
	}

	protected LeaveRuleApplicable toUnwrappedModel(
		LeaveRuleApplicable leaveRuleApplicable) {
		if (leaveRuleApplicable instanceof LeaveRuleApplicableImpl) {
			return leaveRuleApplicable;
		}

		LeaveRuleApplicableImpl leaveRuleApplicableImpl = new LeaveRuleApplicableImpl();

		leaveRuleApplicableImpl.setNew(leaveRuleApplicable.isNew());
		leaveRuleApplicableImpl.setPrimaryKey(leaveRuleApplicable.getPrimaryKey());

		leaveRuleApplicableImpl.setLeaveRuleApplicableId(leaveRuleApplicable.getLeaveRuleApplicableId());
		leaveRuleApplicableImpl.setCompanyId(leaveRuleApplicable.getCompanyId());
		leaveRuleApplicableImpl.setGroupId(leaveRuleApplicable.getGroupId());
		leaveRuleApplicableImpl.setCreateDate(leaveRuleApplicable.getCreateDate());
		leaveRuleApplicableImpl.setModifiedDate(leaveRuleApplicable.getModifiedDate());
		leaveRuleApplicableImpl.setUserId(leaveRuleApplicable.getUserId());
		leaveRuleApplicableImpl.setLeaveTypeId(leaveRuleApplicable.getLeaveTypeId());
		leaveRuleApplicableImpl.setForFemale(leaveRuleApplicable.isForFemale());
		leaveRuleApplicableImpl.setForMale(leaveRuleApplicable.isForMale());
		leaveRuleApplicableImpl.setForYearsOfService(leaveRuleApplicable.isForYearsOfService());
		leaveRuleApplicableImpl.setFromYears(leaveRuleApplicable.getFromYears());
		leaveRuleApplicableImpl.setToYears(leaveRuleApplicable.getToYears());
		leaveRuleApplicableImpl.setForJobTitles(leaveRuleApplicable.isForJobTitles());
		leaveRuleApplicableImpl.setForJobCategories(leaveRuleApplicable.isForJobCategories());
		leaveRuleApplicableImpl.setForEmploymentStatus(leaveRuleApplicable.isForEmploymentStatus());
		leaveRuleApplicableImpl.setForGender(leaveRuleApplicable.isForGender());

		return leaveRuleApplicableImpl;
	}

	/**
	 * Returns the leave rule applicable with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave rule applicable
	 * @return the leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		LeaveRuleApplicable leaveRuleApplicable = fetchByPrimaryKey(primaryKey);

		if (leaveRuleApplicable == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveRuleApplicableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveRuleApplicable;
	}

	/**
	 * Returns the leave rule applicable with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException} if it could not be found.
	 *
	 * @param leaveRuleApplicableId the primary key of the leave rule applicable
	 * @return the leave rule applicable
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveRuleApplicableException if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable findByPrimaryKey(long leaveRuleApplicableId)
		throws NoSuchLeaveRuleApplicableException, SystemException {
		return findByPrimaryKey((Serializable)leaveRuleApplicableId);
	}

	/**
	 * Returns the leave rule applicable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave rule applicable
	 * @return the leave rule applicable, or <code>null</code> if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveRuleApplicable leaveRuleApplicable = (LeaveRuleApplicable)EntityCacheUtil.getResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRuleApplicableImpl.class, primaryKey);

		if (leaveRuleApplicable == _nullLeaveRuleApplicable) {
			return null;
		}

		if (leaveRuleApplicable == null) {
			Session session = null;

			try {
				session = openSession();

				leaveRuleApplicable = (LeaveRuleApplicable)session.get(LeaveRuleApplicableImpl.class,
						primaryKey);

				if (leaveRuleApplicable != null) {
					cacheResult(leaveRuleApplicable);
				}
				else {
					EntityCacheUtil.putResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRuleApplicableImpl.class, primaryKey,
						_nullLeaveRuleApplicable);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveRuleApplicableModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRuleApplicableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveRuleApplicable;
	}

	/**
	 * Returns the leave rule applicable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveRuleApplicableId the primary key of the leave rule applicable
	 * @return the leave rule applicable, or <code>null</code> if a leave rule applicable with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveRuleApplicable fetchByPrimaryKey(long leaveRuleApplicableId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveRuleApplicableId);
	}

	/**
	 * Returns all the leave rule applicables.
	 *
	 * @return the leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave rule applicables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave rule applicables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave rule applicables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveRuleApplicable> findAll(int start, int end,
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

		List<LeaveRuleApplicable> list = (List<LeaveRuleApplicable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVERULEAPPLICABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVERULEAPPLICABLE;

				if (pagination) {
					sql = sql.concat(LeaveRuleApplicableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveRuleApplicable>(list);
				}
				else {
					list = (List<LeaveRuleApplicable>)QueryUtil.list(q,
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
	 * Removes all the leave rule applicables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveRuleApplicable leaveRuleApplicable : findAll()) {
			remove(leaveRuleApplicable);
		}
	}

	/**
	 * Returns the number of leave rule applicables.
	 *
	 * @return the number of leave rule applicables
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

				Query q = session.createQuery(_SQL_COUNT_LEAVERULEAPPLICABLE);

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
	 * Returns all the job categories associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the job categories associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk) throws SystemException {
		return getJobCategories(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the job categories associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of job categories associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end) throws SystemException {
		return getJobCategories(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job categories associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job categories associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return leaveRuleApplicableToJobCategoryTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of job categories associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the number of job categories associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJobCategoriesSize(long pk) throws SystemException {
		long[] pks = leaveRuleApplicableToJobCategoryTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the job category is associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPK the primary key of the job category
	 * @return <code>true</code> if the job category is associated with the leave rule applicable; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobCategory(long pk, long jobCategoryPK)
		throws SystemException {
		return leaveRuleApplicableToJobCategoryTableMapper.containsTableMapping(pk,
			jobCategoryPK);
	}

	/**
	 * Returns <code>true</code> if the leave rule applicable has any job categories associated with it.
	 *
	 * @param pk the primary key of the leave rule applicable to check for associations with job categories
	 * @return <code>true</code> if the leave rule applicable has any job categories associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobCategories(long pk) throws SystemException {
		if (getJobCategoriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPK the primary key of the job category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobCategory(long pk, long jobCategoryPK)
		throws SystemException {
		leaveRuleApplicableToJobCategoryTableMapper.addTableMapping(pk,
			jobCategoryPK);
	}

	/**
	 * Adds an association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategory the job category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws SystemException {
		leaveRuleApplicableToJobCategoryTableMapper.addTableMapping(pk,
			jobCategory.getPrimaryKey());
	}

	/**
	 * Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPKs the primary keys of the job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobCategories(long pk, long[] jobCategoryPKs)
		throws SystemException {
		for (long jobCategoryPK : jobCategoryPKs) {
			leaveRuleApplicableToJobCategoryTableMapper.addTableMapping(pk,
				jobCategoryPK);
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategories the job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobCategories(long pk,
		List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobCategory jobCategory : jobCategories) {
			leaveRuleApplicableToJobCategoryTableMapper.addTableMapping(pk,
				jobCategory.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the leave rule applicable and its job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable to clear the associated job categories from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearJobCategories(long pk) throws SystemException {
		leaveRuleApplicableToJobCategoryTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPK the primary key of the job category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobCategory(long pk, long jobCategoryPK)
		throws SystemException {
		leaveRuleApplicableToJobCategoryTableMapper.deleteTableMapping(pk,
			jobCategoryPK);
	}

	/**
	 * Removes the association between the leave rule applicable and the job category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategory the job category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobCategory(long pk,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws SystemException {
		leaveRuleApplicableToJobCategoryTableMapper.deleteTableMapping(pk,
			jobCategory.getPrimaryKey());
	}

	/**
	 * Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPKs the primary keys of the job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobCategories(long pk, long[] jobCategoryPKs)
		throws SystemException {
		for (long jobCategoryPK : jobCategoryPKs) {
			leaveRuleApplicableToJobCategoryTableMapper.deleteTableMapping(pk,
				jobCategoryPK);
		}
	}

	/**
	 * Removes the association between the leave rule applicable and the job categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategories the job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobCategories(long pk,
		List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobCategory jobCategory : jobCategories) {
			leaveRuleApplicableToJobCategoryTableMapper.deleteTableMapping(pk,
				jobCategory.getPrimaryKey());
		}
	}

	/**
	 * Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategoryPKs the primary keys of the job categories to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobCategories(long pk, long[] jobCategoryPKs)
		throws SystemException {
		Set<Long> newJobCategoryPKsSet = SetUtil.fromArray(jobCategoryPKs);
		Set<Long> oldJobCategoryPKsSet = SetUtil.fromArray(leaveRuleApplicableToJobCategoryTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeJobCategoryPKsSet = new HashSet<Long>(oldJobCategoryPKsSet);

		removeJobCategoryPKsSet.removeAll(newJobCategoryPKsSet);

		for (long removeJobCategoryPK : removeJobCategoryPKsSet) {
			leaveRuleApplicableToJobCategoryTableMapper.deleteTableMapping(pk,
				removeJobCategoryPK);
		}

		newJobCategoryPKsSet.removeAll(oldJobCategoryPKsSet);

		for (long newJobCategoryPK : newJobCategoryPKsSet) {
			leaveRuleApplicableToJobCategoryTableMapper.addTableMapping(pk,
				newJobCategoryPK);
		}
	}

	/**
	 * Sets the job categories associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobCategories the job categories to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobCategories(long pk,
		List<com.rknowsys.eapp.hrm.model.JobCategory> jobCategories)
		throws SystemException {
		try {
			long[] jobCategoryPKs = new long[jobCategories.size()];

			for (int i = 0; i < jobCategories.size(); i++) {
				com.rknowsys.eapp.hrm.model.JobCategory jobCategory = jobCategories.get(i);

				jobCategoryPKs[i] = jobCategory.getPrimaryKey();
			}

			setJobCategories(pk, jobCategoryPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(LeaveRuleApplicableModelImpl.MAPPING_TABLE_HRM_LRA_JOBCATEGORIES_NAME);
		}
	}

	/**
	 * Returns all the job titles associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the job titles associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk)
		throws SystemException {
		return getJobTitles(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the job titles associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of job titles associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk,
		int start, int end) throws SystemException {
		return getJobTitles(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titles associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job titles associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return leaveRuleApplicableToJobTitleTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of job titles associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the number of job titles associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJobTitlesSize(long pk) throws SystemException {
		long[] pks = leaveRuleApplicableToJobTitleTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the job title is associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePK the primary key of the job title
	 * @return <code>true</code> if the job title is associated with the leave rule applicable; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobTitle(long pk, long jobTitlePK)
		throws SystemException {
		return leaveRuleApplicableToJobTitleTableMapper.containsTableMapping(pk,
			jobTitlePK);
	}

	/**
	 * Returns <code>true</code> if the leave rule applicable has any job titles associated with it.
	 *
	 * @param pk the primary key of the leave rule applicable to check for associations with job titles
	 * @return <code>true</code> if the leave rule applicable has any job titles associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobTitles(long pk) throws SystemException {
		if (getJobTitlesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePK the primary key of the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitle(long pk, long jobTitlePK) throws SystemException {
		leaveRuleApplicableToJobTitleTableMapper.addTableMapping(pk, jobTitlePK);
	}

	/**
	 * Adds an association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitle the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws SystemException {
		leaveRuleApplicableToJobTitleTableMapper.addTableMapping(pk,
			jobTitle.getPrimaryKey());
	}

	/**
	 * Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePKs the primary keys of the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		for (long jobTitlePK : jobTitlePKs) {
			leaveRuleApplicableToJobTitleTableMapper.addTableMapping(pk,
				jobTitlePK);
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitles the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitles(long pk,
		List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobTitle jobTitle : jobTitles) {
			leaveRuleApplicableToJobTitleTableMapper.addTableMapping(pk,
				jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the leave rule applicable and its job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable to clear the associated job titles from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearJobTitles(long pk) throws SystemException {
		leaveRuleApplicableToJobTitleTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePK the primary key of the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitle(long pk, long jobTitlePK)
		throws SystemException {
		leaveRuleApplicableToJobTitleTableMapper.deleteTableMapping(pk,
			jobTitlePK);
	}

	/**
	 * Removes the association between the leave rule applicable and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitle the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws SystemException {
		leaveRuleApplicableToJobTitleTableMapper.deleteTableMapping(pk,
			jobTitle.getPrimaryKey());
	}

	/**
	 * Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePKs the primary keys of the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		for (long jobTitlePK : jobTitlePKs) {
			leaveRuleApplicableToJobTitleTableMapper.deleteTableMapping(pk,
				jobTitlePK);
		}
	}

	/**
	 * Removes the association between the leave rule applicable and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitles the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitles(long pk,
		List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobTitle jobTitle : jobTitles) {
			leaveRuleApplicableToJobTitleTableMapper.deleteTableMapping(pk,
				jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitlePKs the primary keys of the job titles to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		Set<Long> newJobTitlePKsSet = SetUtil.fromArray(jobTitlePKs);
		Set<Long> oldJobTitlePKsSet = SetUtil.fromArray(leaveRuleApplicableToJobTitleTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeJobTitlePKsSet = new HashSet<Long>(oldJobTitlePKsSet);

		removeJobTitlePKsSet.removeAll(newJobTitlePKsSet);

		for (long removeJobTitlePK : removeJobTitlePKsSet) {
			leaveRuleApplicableToJobTitleTableMapper.deleteTableMapping(pk,
				removeJobTitlePK);
		}

		newJobTitlePKsSet.removeAll(oldJobTitlePKsSet);

		for (long newJobTitlePK : newJobTitlePKsSet) {
			leaveRuleApplicableToJobTitleTableMapper.addTableMapping(pk,
				newJobTitlePK);
		}
	}

	/**
	 * Sets the job titles associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param jobTitles the job titles to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobTitles(long pk,
		List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws SystemException {
		try {
			long[] jobTitlePKs = new long[jobTitles.size()];

			for (int i = 0; i < jobTitles.size(); i++) {
				com.rknowsys.eapp.hrm.model.JobTitle jobTitle = jobTitles.get(i);

				jobTitlePKs[i] = jobTitle.getPrimaryKey();
			}

			setJobTitles(pk, jobTitlePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(LeaveRuleApplicableModelImpl.MAPPING_TABLE_HRM_LRA_JOBTITLES_NAME);
		}
	}

	/**
	 * Returns all the employment statuses associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the employment statuses associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk) throws SystemException {
		return getEmploymentStatuses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the employment statuses associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @return the range of employment statuses associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end) throws SystemException {
		return getEmploymentStatuses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employment statuses associated with the leave rule applicable.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveRuleApplicableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param start the lower bound of the range of leave rule applicables
	 * @param end the upper bound of the range of leave rule applicables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employment statuses associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return leaveRuleApplicableToEmploymentStatusTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of employment statuses associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @return the number of employment statuses associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEmploymentStatusesSize(long pk) throws SystemException {
		long[] pks = leaveRuleApplicableToEmploymentStatusTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the employment status is associated with the leave rule applicable.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPK the primary key of the employment status
	 * @return <code>true</code> if the employment status is associated with the leave rule applicable; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		return leaveRuleApplicableToEmploymentStatusTableMapper.containsTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Returns <code>true</code> if the leave rule applicable has any employment statuses associated with it.
	 *
	 * @param pk the primary key of the leave rule applicable to check for associations with employment statuses
	 * @return <code>true</code> if the leave rule applicable has any employment statuses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmploymentStatuses(long pk)
		throws SystemException {
		if (getEmploymentStatusesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPK the primary key of the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		leaveRuleApplicableToEmploymentStatusTableMapper.addTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Adds an association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatus the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws SystemException {
		leaveRuleApplicableToEmploymentStatusTableMapper.addTableMapping(pk,
			employmentStatus.getPrimaryKey());
	}

	/**
	 * Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPKs the primary keys of the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		for (long employmentStatusPK : employmentStatusPKs) {
			leaveRuleApplicableToEmploymentStatusTableMapper.addTableMapping(pk,
				employmentStatusPK);
		}
	}

	/**
	 * Adds an association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatuses the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatuses(long pk,
		List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus : employmentStatuses) {
			leaveRuleApplicableToEmploymentStatusTableMapper.addTableMapping(pk,
				employmentStatus.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the leave rule applicable and its employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable to clear the associated employment statuses from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearEmploymentStatuses(long pk) throws SystemException {
		leaveRuleApplicableToEmploymentStatusTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPK the primary key of the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		leaveRuleApplicableToEmploymentStatusTableMapper.deleteTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Removes the association between the leave rule applicable and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatus the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws SystemException {
		leaveRuleApplicableToEmploymentStatusTableMapper.deleteTableMapping(pk,
			employmentStatus.getPrimaryKey());
	}

	/**
	 * Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPKs the primary keys of the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		for (long employmentStatusPK : employmentStatusPKs) {
			leaveRuleApplicableToEmploymentStatusTableMapper.deleteTableMapping(pk,
				employmentStatusPK);
		}
	}

	/**
	 * Removes the association between the leave rule applicable and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatuses the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatuses(long pk,
		List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus : employmentStatuses) {
			leaveRuleApplicableToEmploymentStatusTableMapper.deleteTableMapping(pk,
				employmentStatus.getPrimaryKey());
		}
	}

	/**
	 * Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatusPKs the primary keys of the employment statuses to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		Set<Long> newEmploymentStatusPKsSet = SetUtil.fromArray(employmentStatusPKs);
		Set<Long> oldEmploymentStatusPKsSet = SetUtil.fromArray(leaveRuleApplicableToEmploymentStatusTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeEmploymentStatusPKsSet = new HashSet<Long>(oldEmploymentStatusPKsSet);

		removeEmploymentStatusPKsSet.removeAll(newEmploymentStatusPKsSet);

		for (long removeEmploymentStatusPK : removeEmploymentStatusPKsSet) {
			leaveRuleApplicableToEmploymentStatusTableMapper.deleteTableMapping(pk,
				removeEmploymentStatusPK);
		}

		newEmploymentStatusPKsSet.removeAll(oldEmploymentStatusPKsSet);

		for (long newEmploymentStatusPK : newEmploymentStatusPKsSet) {
			leaveRuleApplicableToEmploymentStatusTableMapper.addTableMapping(pk,
				newEmploymentStatusPK);
		}
	}

	/**
	 * Sets the employment statuses associated with the leave rule applicable, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave rule applicable
	 * @param employmentStatuses the employment statuses to be associated with the leave rule applicable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmploymentStatuses(long pk,
		List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws SystemException {
		try {
			long[] employmentStatusPKs = new long[employmentStatuses.size()];

			for (int i = 0; i < employmentStatuses.size(); i++) {
				com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus = employmentStatuses.get(i);

				employmentStatusPKs[i] = employmentStatus.getPrimaryKey();
			}

			setEmploymentStatuses(pk, employmentStatusPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(LeaveRuleApplicableModelImpl.MAPPING_TABLE_HRM_LRA_EMPLOYMENTSTATUS_NAME);
		}
	}

	/**
	 * Initializes the leave rule applicable persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveRuleApplicable")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveRuleApplicable>> listenersList = new ArrayList<ModelListener<LeaveRuleApplicable>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveRuleApplicable>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		leaveRuleApplicableToJobCategoryTableMapper = TableMapperFactory.getTableMapper("hrm_lra_jobCategories",
				"leaveRuleApplicableId", "jobCategoryId", this,
				jobCategoryPersistence);

		leaveRuleApplicableToJobTitleTableMapper = TableMapperFactory.getTableMapper("hrm_lra_jobTitles",
				"leaveRuleApplicableId", "jobTitleId", this, jobTitlePersistence);

		leaveRuleApplicableToEmploymentStatusTableMapper = TableMapperFactory.getTableMapper("hrm_lra_employmentStatus",
				"leaveRuleApplicableId", "employmentStatusId", this,
				employmentStatusPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LeaveRuleApplicableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = JobCategoryPersistence.class)
	protected JobCategoryPersistence jobCategoryPersistence;
	protected TableMapper<LeaveRuleApplicable, com.rknowsys.eapp.hrm.model.JobCategory> leaveRuleApplicableToJobCategoryTableMapper;
	@BeanReference(type = JobTitlePersistence.class)
	protected JobTitlePersistence jobTitlePersistence;
	protected TableMapper<LeaveRuleApplicable, com.rknowsys.eapp.hrm.model.JobTitle> leaveRuleApplicableToJobTitleTableMapper;
	@BeanReference(type = EmploymentStatusPersistence.class)
	protected EmploymentStatusPersistence employmentStatusPersistence;
	protected TableMapper<LeaveRuleApplicable, com.rknowsys.eapp.hrm.model.EmploymentStatus> leaveRuleApplicableToEmploymentStatusTableMapper;
	private static final String _SQL_SELECT_LEAVERULEAPPLICABLE = "SELECT leaveRuleApplicable FROM LeaveRuleApplicable leaveRuleApplicable";
	private static final String _SQL_SELECT_LEAVERULEAPPLICABLE_WHERE = "SELECT leaveRuleApplicable FROM LeaveRuleApplicable leaveRuleApplicable WHERE ";
	private static final String _SQL_COUNT_LEAVERULEAPPLICABLE = "SELECT COUNT(leaveRuleApplicable) FROM LeaveRuleApplicable leaveRuleApplicable";
	private static final String _SQL_COUNT_LEAVERULEAPPLICABLE_WHERE = "SELECT COUNT(leaveRuleApplicable) FROM LeaveRuleApplicable leaveRuleApplicable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveRuleApplicable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveRuleApplicable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveRuleApplicable exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveRuleApplicablePersistenceImpl.class);
	private static LeaveRuleApplicable _nullLeaveRuleApplicable = new LeaveRuleApplicableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveRuleApplicable> toCacheModel() {
				return _nullLeaveRuleApplicableCacheModel;
			}
		};

	private static CacheModel<LeaveRuleApplicable> _nullLeaveRuleApplicableCacheModel =
		new CacheModel<LeaveRuleApplicable>() {
			@Override
			public LeaveRuleApplicable toEntityModel() {
				return _nullLeaveRuleApplicable;
			}
		};
}