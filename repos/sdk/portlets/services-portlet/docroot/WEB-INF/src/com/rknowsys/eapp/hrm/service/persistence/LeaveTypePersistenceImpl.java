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

import com.rknowsys.eapp.hrm.NoSuchLeaveTypeException;
import com.rknowsys.eapp.hrm.model.LeaveType;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypePersistence
 * @see LeaveTypeUtil
 * @generated
 */
public class LeaveTypePersistenceImpl extends BasePersistenceImpl<LeaveType>
	implements LeaveTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveTypeUtil} to access the leave type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @return the range of matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findByGroupId(long groupId, int start, int end,
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

		List<LeaveType> list = (List<LeaveType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveType leaveType : list) {
				if ((groupId != leaveType.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVETYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveType>(list);
				}
				else {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = fetchByGroupId_First(groupId, orderByComparator);

		if (leaveType != null) {
			return leaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the first leave type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type, or <code>null</code> if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = fetchByGroupId_Last(groupId, orderByComparator);

		if (leaveType != null) {
			return leaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the last leave type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type, or <code>null</code> if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave types before and after the current leave type in the ordered set where groupId = &#63;.
	 *
	 * @param leaveTypeId the primary key of the current leave type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType[] findByGroupId_PrevAndNext(long leaveTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = findByPrimaryKey(leaveTypeId);

		Session session = null;

		try {
			session = openSession();

			LeaveType[] array = new LeaveTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveType, groupId,
					orderByComparator, true);

			array[1] = leaveType;

			array[2] = getByGroupId_PrevAndNext(session, leaveType, groupId,
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

	protected LeaveType getByGroupId_PrevAndNext(Session session,
		LeaveType leaveType, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPE_WHERE);

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
			query.append(LeaveTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveType leaveType : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(leaveType);
		}
	}

	/**
	 * Returns the number of leave types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave types
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

			query.append(_SQL_COUNT_LEAVETYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONALITYID =
		new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynationalityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITYID =
		new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynationalityId",
			new String[] { Long.class.getName() },
			LeaveTypeModelImpl.NATIONALITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NATIONALITYID = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynationalityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave types where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @return the matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findBynationalityId(long nationalityId)
		throws SystemException {
		return findBynationalityId(nationalityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave types where nationalityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nationalityId the nationality ID
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @return the range of matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findBynationalityId(long nationalityId, int start,
		int end) throws SystemException {
		return findBynationalityId(nationalityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave types where nationalityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nationalityId the nationality ID
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findBynationalityId(long nationalityId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITYID;
			finderArgs = new Object[] { nationalityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONALITYID;
			finderArgs = new Object[] {
					nationalityId,
					
					start, end, orderByComparator
				};
		}

		List<LeaveType> list = (List<LeaveType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveType leaveType : list) {
				if ((nationalityId != leaveType.getNationalityId())) {
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

			query.append(_SQL_SELECT_LEAVETYPE_WHERE);

			query.append(_FINDER_COLUMN_NATIONALITYID_NATIONALITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nationalityId);

				if (!pagination) {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveType>(list);
				}
				else {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave type in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findBynationalityId_First(long nationalityId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = fetchBynationalityId_First(nationalityId,
				orderByComparator);

		if (leaveType != null) {
			return leaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nationalityId=");
		msg.append(nationalityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the first leave type in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type, or <code>null</code> if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchBynationalityId_First(long nationalityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveType> list = findBynationalityId(nationalityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findBynationalityId_Last(long nationalityId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = fetchBynationalityId_Last(nationalityId,
				orderByComparator);

		if (leaveType != null) {
			return leaveType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nationalityId=");
		msg.append(nationalityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeException(msg.toString());
	}

	/**
	 * Returns the last leave type in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type, or <code>null</code> if a matching leave type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchBynationalityId_Last(long nationalityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBynationalityId(nationalityId);

		if (count == 0) {
			return null;
		}

		List<LeaveType> list = findBynationalityId(nationalityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave types before and after the current leave type in the ordered set where nationalityId = &#63;.
	 *
	 * @param leaveTypeId the primary key of the current leave type
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType[] findBynationalityId_PrevAndNext(long leaveTypeId,
		long nationalityId, OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = findByPrimaryKey(leaveTypeId);

		Session session = null;

		try {
			session = openSession();

			LeaveType[] array = new LeaveTypeImpl[3];

			array[0] = getBynationalityId_PrevAndNext(session, leaveType,
					nationalityId, orderByComparator, true);

			array[1] = leaveType;

			array[2] = getBynationalityId_PrevAndNext(session, leaveType,
					nationalityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveType getBynationalityId_PrevAndNext(Session session,
		LeaveType leaveType, long nationalityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPE_WHERE);

		query.append(_FINDER_COLUMN_NATIONALITYID_NATIONALITYID_2);

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
			query.append(LeaveTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nationalityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave types where nationalityId = &#63; from the database.
	 *
	 * @param nationalityId the nationality ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBynationalityId(long nationalityId)
		throws SystemException {
		for (LeaveType leaveType : findBynationalityId(nationalityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveType);
		}
	}

	/**
	 * Returns the number of leave types where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @return the number of matching leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBynationalityId(long nationalityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NATIONALITYID;

		Object[] finderArgs = new Object[] { nationalityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVETYPE_WHERE);

			query.append(_FINDER_COLUMN_NATIONALITYID_NATIONALITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nationalityId);

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

	private static final String _FINDER_COLUMN_NATIONALITYID_NATIONALITYID_2 = "leaveType.nationalityId = ?";

	public LeaveTypePersistenceImpl() {
		setModelClass(LeaveType.class);
	}

	/**
	 * Caches the leave type in the entity cache if it is enabled.
	 *
	 * @param leaveType the leave type
	 */
	@Override
	public void cacheResult(LeaveType leaveType) {
		EntityCacheUtil.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey(), leaveType);

		leaveType.resetOriginalValues();
	}

	/**
	 * Caches the leave types in the entity cache if it is enabled.
	 *
	 * @param leaveTypes the leave types
	 */
	@Override
	public void cacheResult(List<LeaveType> leaveTypes) {
		for (LeaveType leaveType : leaveTypes) {
			if (EntityCacheUtil.getResult(
						LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeImpl.class, leaveType.getPrimaryKey()) == null) {
				cacheResult(leaveType);
			}
			else {
				leaveType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveType leaveType) {
		EntityCacheUtil.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveType> leaveTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveType leaveType : leaveTypes) {
			EntityCacheUtil.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeImpl.class, leaveType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave type with the primary key. Does not add the leave type to the database.
	 *
	 * @param leaveTypeId the primary key for the new leave type
	 * @return the new leave type
	 */
	@Override
	public LeaveType create(long leaveTypeId) {
		LeaveType leaveType = new LeaveTypeImpl();

		leaveType.setNew(true);
		leaveType.setPrimaryKey(leaveTypeId);

		return leaveType;
	}

	/**
	 * Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType remove(long leaveTypeId)
		throws NoSuchLeaveTypeException, SystemException {
		return remove((Serializable)leaveTypeId);
	}

	/**
	 * Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType remove(Serializable primaryKey)
		throws NoSuchLeaveTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveType leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
					primaryKey);

			if (leaveType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveType);
		}
		catch (NoSuchLeaveTypeException nsee) {
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
	protected LeaveType removeImpl(LeaveType leaveType)
		throws SystemException {
		leaveType = toUnwrappedModel(leaveType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveType)) {
				leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
						leaveType.getPrimaryKeyObj());
			}

			if (leaveType != null) {
				session.delete(leaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveType != null) {
			clearCache(leaveType);
		}

		return leaveType;
	}

	@Override
	public LeaveType updateImpl(com.rknowsys.eapp.hrm.model.LeaveType leaveType)
		throws SystemException {
		leaveType = toUnwrappedModel(leaveType);

		boolean isNew = leaveType.isNew();

		LeaveTypeModelImpl leaveTypeModelImpl = (LeaveTypeModelImpl)leaveType;

		Session session = null;

		try {
			session = openSession();

			if (leaveType.isNew()) {
				session.save(leaveType);

				leaveType.setNew(false);
			}
			else {
				session.merge(leaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeModelImpl.getOriginalNationalityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONALITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITYID,
					args);

				args = new Object[] { leaveTypeModelImpl.getNationalityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONALITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITYID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey(), leaveType);

		return leaveType;
	}

	protected LeaveType toUnwrappedModel(LeaveType leaveType) {
		if (leaveType instanceof LeaveTypeImpl) {
			return leaveType;
		}

		LeaveTypeImpl leaveTypeImpl = new LeaveTypeImpl();

		leaveTypeImpl.setNew(leaveType.isNew());
		leaveTypeImpl.setPrimaryKey(leaveType.getPrimaryKey());

		leaveTypeImpl.setLeaveTypeId(leaveType.getLeaveTypeId());
		leaveTypeImpl.setCompanyId(leaveType.getCompanyId());
		leaveTypeImpl.setGroupId(leaveType.getGroupId());
		leaveTypeImpl.setCreateDate(leaveType.getCreateDate());
		leaveTypeImpl.setModifiedDate(leaveType.getModifiedDate());
		leaveTypeImpl.setUserId(leaveType.getUserId());
		leaveTypeImpl.setNationalityId(leaveType.getNationalityId());
		leaveTypeImpl.setLeaveTypeName(leaveType.getLeaveTypeName());
		leaveTypeImpl.setIsSituational(leaveType.isIsSituational());

		return leaveTypeImpl;
	}

	/**
	 * Returns the leave type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeException, SystemException {
		LeaveType leaveType = fetchByPrimaryKey(primaryKey);

		if (leaveType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveType;
	}

	/**
	 * Returns the leave type with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType findByPrimaryKey(long leaveTypeId)
		throws NoSuchLeaveTypeException, SystemException {
		return findByPrimaryKey((Serializable)leaveTypeId);
	}

	/**
	 * Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveType leaveType = (LeaveType)EntityCacheUtil.getResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeImpl.class, primaryKey);

		if (leaveType == _nullLeaveType) {
			return null;
		}

		if (leaveType == null) {
			Session session = null;

			try {
				session = openSession();

				leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
						primaryKey);

				if (leaveType != null) {
					cacheResult(leaveType);
				}
				else {
					EntityCacheUtil.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeImpl.class, primaryKey, _nullLeaveType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveType;
	}

	/**
	 * Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveType fetchByPrimaryKey(long leaveTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveTypeId);
	}

	/**
	 * Returns all the leave types.
	 *
	 * @return the leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @return the range of leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveType> findAll(int start, int end,
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

		List<LeaveType> list = (List<LeaveType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPE;

				if (pagination) {
					sql = sql.concat(LeaveTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveType>(list);
				}
				else {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveType leaveType : findAll()) {
			remove(leaveType);
		}
	}

	/**
	 * Returns the number of leave types.
	 *
	 * @return the number of leave types
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

				Query q = session.createQuery(_SQL_COUNT_LEAVETYPE);

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
	 * Initializes the leave type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveType>> listenersList = new ArrayList<ModelListener<LeaveType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVETYPE = "SELECT leaveType FROM LeaveType leaveType";
	private static final String _SQL_SELECT_LEAVETYPE_WHERE = "SELECT leaveType FROM LeaveType leaveType WHERE ";
	private static final String _SQL_COUNT_LEAVETYPE = "SELECT COUNT(leaveType) FROM LeaveType leaveType";
	private static final String _SQL_COUNT_LEAVETYPE_WHERE = "SELECT COUNT(leaveType) FROM LeaveType leaveType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveTypePersistenceImpl.class);
	private static LeaveType _nullLeaveType = new LeaveTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveType> toCacheModel() {
				return _nullLeaveTypeCacheModel;
			}
		};

	private static CacheModel<LeaveType> _nullLeaveTypeCacheModel = new CacheModel<LeaveType>() {
			@Override
			public LeaveType toEntityModel() {
				return _nullLeaveType;
			}
		};
}