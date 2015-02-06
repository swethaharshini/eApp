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

import com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException;
import com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave type employee groups service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeEmployeeGroupsPersistence
 * @see LeaveTypeEmployeeGroupsUtil
 * @generated
 */
public class LeaveTypeEmployeeGroupsPersistenceImpl extends BasePersistenceImpl<LeaveTypeEmployeeGroups>
	implements LeaveTypeEmployeeGroupsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveTypeEmployeeGroupsUtil} to access the leave type employee groups persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveTypeEmployeeGroupsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveTypeEmployeeGroupsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave type employee groupses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type employee groupses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @return the range of matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type employee groupses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByGroupId(long groupId, int start,
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

		List<LeaveTypeEmployeeGroups> list = (List<LeaveTypeEmployeeGroups>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : list) {
				if ((groupId != leaveTypeEmployeeGroups.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeEmployeeGroupsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeEmployeeGroups>(list);
				}
				else {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
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
	 * Returns the first leave type employee groups in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveTypeEmployeeGroups != null) {
			return leaveTypeEmployeeGroups;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeEmployeeGroupsException(msg.toString());
	}

	/**
	 * Returns the first leave type employee groups in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveTypeEmployeeGroups> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type employee groups in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveTypeEmployeeGroups != null) {
			return leaveTypeEmployeeGroups;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeEmployeeGroupsException(msg.toString());
	}

	/**
	 * Returns the last leave type employee groups in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeEmployeeGroups> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type employee groupses before and after the current leave type employee groups in the ordered set where groupId = &#63;.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key of the current leave type employee groups
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups[] findByGroupId_PrevAndNext(
		long leaveTypeEmployeeGroupId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = findByPrimaryKey(leaveTypeEmployeeGroupId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeEmployeeGroups[] array = new LeaveTypeEmployeeGroupsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					leaveTypeEmployeeGroups, groupId, orderByComparator, true);

			array[1] = leaveTypeEmployeeGroups;

			array[2] = getByGroupId_PrevAndNext(session,
					leaveTypeEmployeeGroups, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveTypeEmployeeGroups getByGroupId_PrevAndNext(
		Session session, LeaveTypeEmployeeGroups leaveTypeEmployeeGroups,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

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
			query.append(LeaveTypeEmployeeGroupsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveTypeEmployeeGroups);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveTypeEmployeeGroups> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type employee groupses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveTypeEmployeeGroups);
		}
	}

	/**
	 * Returns the number of leave type employee groupses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave type employee groupses
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

			query.append(_SQL_COUNT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveTypeEmployeeGroups.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveTypeEmployeeGroupsModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave type employee groupses where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type employee groupses where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @return the range of matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByLeaveTypeId(long leaveTypeId,
		int start, int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type employee groupses where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findByLeaveTypeId(long leaveTypeId,
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

		List<LeaveTypeEmployeeGroups> list = (List<LeaveTypeEmployeeGroups>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : list) {
				if ((leaveTypeId != leaveTypeEmployeeGroups.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeEmployeeGroupsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeEmployeeGroups>(list);
				}
				else {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
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
	 * Returns the first leave type employee groups in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveTypeEmployeeGroups != null) {
			return leaveTypeEmployeeGroups;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeEmployeeGroupsException(msg.toString());
	}

	/**
	 * Returns the first leave type employee groups in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveTypeEmployeeGroups> list = findByLeaveTypeId(leaveTypeId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type employee groups in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveTypeEmployeeGroups != null) {
			return leaveTypeEmployeeGroups;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeEmployeeGroupsException(msg.toString());
	}

	/**
	 * Returns the last leave type employee groups in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type employee groups, or <code>null</code> if a matching leave type employee groups could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeEmployeeGroups> list = findByLeaveTypeId(leaveTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type employee groupses before and after the current leave type employee groups in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key of the current leave type employee groups
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups[] findByLeaveTypeId_PrevAndNext(
		long leaveTypeEmployeeGroupId, long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = findByPrimaryKey(leaveTypeEmployeeGroupId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeEmployeeGroups[] array = new LeaveTypeEmployeeGroupsImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session,
					leaveTypeEmployeeGroups, leaveTypeId, orderByComparator,
					true);

			array[1] = leaveTypeEmployeeGroups;

			array[2] = getByLeaveTypeId_PrevAndNext(session,
					leaveTypeEmployeeGroups, leaveTypeId, orderByComparator,
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

	protected LeaveTypeEmployeeGroups getByLeaveTypeId_PrevAndNext(
		Session session, LeaveTypeEmployeeGroups leaveTypeEmployeeGroups,
		long leaveTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

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
			query.append(LeaveTypeEmployeeGroupsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveTypeEmployeeGroups);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveTypeEmployeeGroups> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type employee groupses where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : findByLeaveTypeId(
				leaveTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveTypeEmployeeGroups);
		}
	}

	/**
	 * Returns the number of leave type employee groupses where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave type employee groupses
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

			query.append(_SQL_COUNT_LEAVETYPEEMPLOYEEGROUPS_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveTypeEmployeeGroups.leaveTypeId = ?";

	public LeaveTypeEmployeeGroupsPersistenceImpl() {
		setModelClass(LeaveTypeEmployeeGroups.class);
	}

	/**
	 * Caches the leave type employee groups in the entity cache if it is enabled.
	 *
	 * @param leaveTypeEmployeeGroups the leave type employee groups
	 */
	@Override
	public void cacheResult(LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		EntityCacheUtil.putResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			leaveTypeEmployeeGroups.getPrimaryKey(), leaveTypeEmployeeGroups);

		leaveTypeEmployeeGroups.resetOriginalValues();
	}

	/**
	 * Caches the leave type employee groupses in the entity cache if it is enabled.
	 *
	 * @param leaveTypeEmployeeGroupses the leave type employee groupses
	 */
	@Override
	public void cacheResult(
		List<LeaveTypeEmployeeGroups> leaveTypeEmployeeGroupses) {
		for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : leaveTypeEmployeeGroupses) {
			if (EntityCacheUtil.getResult(
						LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeEmployeeGroupsImpl.class,
						leaveTypeEmployeeGroups.getPrimaryKey()) == null) {
				cacheResult(leaveTypeEmployeeGroups);
			}
			else {
				leaveTypeEmployeeGroups.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave type employee groupses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveTypeEmployeeGroupsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveTypeEmployeeGroupsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave type employee groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		EntityCacheUtil.removeResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			leaveTypeEmployeeGroups.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<LeaveTypeEmployeeGroups> leaveTypeEmployeeGroupses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : leaveTypeEmployeeGroupses) {
			EntityCacheUtil.removeResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeEmployeeGroupsImpl.class,
				leaveTypeEmployeeGroups.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave type employee groups with the primary key. Does not add the leave type employee groups to the database.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key for the new leave type employee groups
	 * @return the new leave type employee groups
	 */
	@Override
	public LeaveTypeEmployeeGroups create(long leaveTypeEmployeeGroupId) {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = new LeaveTypeEmployeeGroupsImpl();

		leaveTypeEmployeeGroups.setNew(true);
		leaveTypeEmployeeGroups.setPrimaryKey(leaveTypeEmployeeGroupId);

		return leaveTypeEmployeeGroups;
	}

	/**
	 * Removes the leave type employee groups with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	 * @return the leave type employee groups that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups remove(long leaveTypeEmployeeGroupId)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		return remove((Serializable)leaveTypeEmployeeGroupId);
	}

	/**
	 * Removes the leave type employee groups with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type employee groups
	 * @return the leave type employee groups that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups remove(Serializable primaryKey)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = (LeaveTypeEmployeeGroups)session.get(LeaveTypeEmployeeGroupsImpl.class,
					primaryKey);

			if (leaveTypeEmployeeGroups == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeEmployeeGroupsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveTypeEmployeeGroups);
		}
		catch (NoSuchLeaveTypeEmployeeGroupsException nsee) {
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
	protected LeaveTypeEmployeeGroups removeImpl(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws SystemException {
		leaveTypeEmployeeGroups = toUnwrappedModel(leaveTypeEmployeeGroups);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTypeEmployeeGroups)) {
				leaveTypeEmployeeGroups = (LeaveTypeEmployeeGroups)session.get(LeaveTypeEmployeeGroupsImpl.class,
						leaveTypeEmployeeGroups.getPrimaryKeyObj());
			}

			if (leaveTypeEmployeeGroups != null) {
				session.delete(leaveTypeEmployeeGroups);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveTypeEmployeeGroups != null) {
			clearCache(leaveTypeEmployeeGroups);
		}

		return leaveTypeEmployeeGroups;
	}

	@Override
	public LeaveTypeEmployeeGroups updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups leaveTypeEmployeeGroups)
		throws SystemException {
		leaveTypeEmployeeGroups = toUnwrappedModel(leaveTypeEmployeeGroups);

		boolean isNew = leaveTypeEmployeeGroups.isNew();

		LeaveTypeEmployeeGroupsModelImpl leaveTypeEmployeeGroupsModelImpl = (LeaveTypeEmployeeGroupsModelImpl)leaveTypeEmployeeGroups;

		Session session = null;

		try {
			session = openSession();

			if (leaveTypeEmployeeGroups.isNew()) {
				session.save(leaveTypeEmployeeGroups);

				leaveTypeEmployeeGroups.setNew(false);
			}
			else {
				session.merge(leaveTypeEmployeeGroups);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveTypeEmployeeGroupsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveTypeEmployeeGroupsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeEmployeeGroupsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						leaveTypeEmployeeGroupsModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveTypeEmployeeGroupsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeEmployeeGroupsModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] {
						leaveTypeEmployeeGroupsModelImpl.getLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeEmployeeGroupsImpl.class,
			leaveTypeEmployeeGroups.getPrimaryKey(), leaveTypeEmployeeGroups);

		return leaveTypeEmployeeGroups;
	}

	protected LeaveTypeEmployeeGroups toUnwrappedModel(
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups) {
		if (leaveTypeEmployeeGroups instanceof LeaveTypeEmployeeGroupsImpl) {
			return leaveTypeEmployeeGroups;
		}

		LeaveTypeEmployeeGroupsImpl leaveTypeEmployeeGroupsImpl = new LeaveTypeEmployeeGroupsImpl();

		leaveTypeEmployeeGroupsImpl.setNew(leaveTypeEmployeeGroups.isNew());
		leaveTypeEmployeeGroupsImpl.setPrimaryKey(leaveTypeEmployeeGroups.getPrimaryKey());

		leaveTypeEmployeeGroupsImpl.setLeaveTypeEmployeeGroupId(leaveTypeEmployeeGroups.getLeaveTypeEmployeeGroupId());
		leaveTypeEmployeeGroupsImpl.setCompanyId(leaveTypeEmployeeGroups.getCompanyId());
		leaveTypeEmployeeGroupsImpl.setGroupId(leaveTypeEmployeeGroups.getGroupId());
		leaveTypeEmployeeGroupsImpl.setCreateDate(leaveTypeEmployeeGroups.getCreateDate());
		leaveTypeEmployeeGroupsImpl.setModifiedDate(leaveTypeEmployeeGroups.getModifiedDate());
		leaveTypeEmployeeGroupsImpl.setUserId(leaveTypeEmployeeGroups.getUserId());
		leaveTypeEmployeeGroupsImpl.setLeaveTypeId(leaveTypeEmployeeGroups.getLeaveTypeId());
		leaveTypeEmployeeGroupsImpl.setGroupName(leaveTypeEmployeeGroups.getGroupName());
		leaveTypeEmployeeGroupsImpl.setForJobTitles(leaveTypeEmployeeGroups.isForJobTitles());
		leaveTypeEmployeeGroupsImpl.setForJobCategories(leaveTypeEmployeeGroups.isForJobCategories());
		leaveTypeEmployeeGroupsImpl.setForEmploymentStatus(leaveTypeEmployeeGroups.isForEmploymentStatus());
		leaveTypeEmployeeGroupsImpl.setForGender(leaveTypeEmployeeGroups.isForGender());
		leaveTypeEmployeeGroupsImpl.setForFemale(leaveTypeEmployeeGroups.isForFemale());
		leaveTypeEmployeeGroupsImpl.setForMale(leaveTypeEmployeeGroups.isForMale());
		leaveTypeEmployeeGroupsImpl.setForYearsOfService(leaveTypeEmployeeGroups.isForYearsOfService());
		leaveTypeEmployeeGroupsImpl.setFromYears(leaveTypeEmployeeGroups.getFromYears());
		leaveTypeEmployeeGroupsImpl.setToYears(leaveTypeEmployeeGroups.getToYears());

		return leaveTypeEmployeeGroupsImpl;
	}

	/**
	 * Returns the leave type employee groups with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type employee groups
	 * @return the leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = fetchByPrimaryKey(primaryKey);

		if (leaveTypeEmployeeGroups == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeEmployeeGroupsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveTypeEmployeeGroups;
	}

	/**
	 * Returns the leave type employee groups with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException} if it could not be found.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	 * @return the leave type employee groups
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeEmployeeGroupsException if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups findByPrimaryKey(
		long leaveTypeEmployeeGroupId)
		throws NoSuchLeaveTypeEmployeeGroupsException, SystemException {
		return findByPrimaryKey((Serializable)leaveTypeEmployeeGroupId);
	}

	/**
	 * Returns the leave type employee groups with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type employee groups
	 * @return the leave type employee groups, or <code>null</code> if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = (LeaveTypeEmployeeGroups)EntityCacheUtil.getResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeEmployeeGroupsImpl.class, primaryKey);

		if (leaveTypeEmployeeGroups == _nullLeaveTypeEmployeeGroups) {
			return null;
		}

		if (leaveTypeEmployeeGroups == null) {
			Session session = null;

			try {
				session = openSession();

				leaveTypeEmployeeGroups = (LeaveTypeEmployeeGroups)session.get(LeaveTypeEmployeeGroupsImpl.class,
						primaryKey);

				if (leaveTypeEmployeeGroups != null) {
					cacheResult(leaveTypeEmployeeGroups);
				}
				else {
					EntityCacheUtil.putResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeEmployeeGroupsImpl.class, primaryKey,
						_nullLeaveTypeEmployeeGroups);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveTypeEmployeeGroupsModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeEmployeeGroupsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveTypeEmployeeGroups;
	}

	/**
	 * Returns the leave type employee groups with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeEmployeeGroupId the primary key of the leave type employee groups
	 * @return the leave type employee groups, or <code>null</code> if a leave type employee groups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeEmployeeGroups fetchByPrimaryKey(
		long leaveTypeEmployeeGroupId) throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveTypeEmployeeGroupId);
	}

	/**
	 * Returns all the leave type employee groupses.
	 *
	 * @return the leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type employee groupses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @return the range of leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type employee groupses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeEmployeeGroupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type employee groupses
	 * @param end the upper bound of the range of leave type employee groupses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type employee groupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeEmployeeGroups> findAll(int start, int end,
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

		List<LeaveTypeEmployeeGroups> list = (List<LeaveTypeEmployeeGroups>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS;

				if (pagination) {
					sql = sql.concat(LeaveTypeEmployeeGroupsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeEmployeeGroups>(list);
				}
				else {
					list = (List<LeaveTypeEmployeeGroups>)QueryUtil.list(q,
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
	 * Removes all the leave type employee groupses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveTypeEmployeeGroups leaveTypeEmployeeGroups : findAll()) {
			remove(leaveTypeEmployeeGroups);
		}
	}

	/**
	 * Returns the number of leave type employee groupses.
	 *
	 * @return the number of leave type employee groupses
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

				Query q = session.createQuery(_SQL_COUNT_LEAVETYPEEMPLOYEEGROUPS);

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
	 * Initializes the leave type employee groups persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveTypeEmployeeGroups>> listenersList = new ArrayList<ModelListener<LeaveTypeEmployeeGroups>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveTypeEmployeeGroups>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveTypeEmployeeGroupsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS = "SELECT leaveTypeEmployeeGroups FROM LeaveTypeEmployeeGroups leaveTypeEmployeeGroups";
	private static final String _SQL_SELECT_LEAVETYPEEMPLOYEEGROUPS_WHERE = "SELECT leaveTypeEmployeeGroups FROM LeaveTypeEmployeeGroups leaveTypeEmployeeGroups WHERE ";
	private static final String _SQL_COUNT_LEAVETYPEEMPLOYEEGROUPS = "SELECT COUNT(leaveTypeEmployeeGroups) FROM LeaveTypeEmployeeGroups leaveTypeEmployeeGroups";
	private static final String _SQL_COUNT_LEAVETYPEEMPLOYEEGROUPS_WHERE = "SELECT COUNT(leaveTypeEmployeeGroups) FROM LeaveTypeEmployeeGroups leaveTypeEmployeeGroups WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTypeEmployeeGroups.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveTypeEmployeeGroups exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveTypeEmployeeGroups exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveTypeEmployeeGroupsPersistenceImpl.class);
	private static LeaveTypeEmployeeGroups _nullLeaveTypeEmployeeGroups = new LeaveTypeEmployeeGroupsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveTypeEmployeeGroups> toCacheModel() {
				return _nullLeaveTypeEmployeeGroupsCacheModel;
			}
		};

	private static CacheModel<LeaveTypeEmployeeGroups> _nullLeaveTypeEmployeeGroupsCacheModel =
		new CacheModel<LeaveTypeEmployeeGroups>() {
			@Override
			public LeaveTypeEmployeeGroups toEntityModel() {
				return _nullLeaveTypeEmployeeGroups;
			}
		};
}