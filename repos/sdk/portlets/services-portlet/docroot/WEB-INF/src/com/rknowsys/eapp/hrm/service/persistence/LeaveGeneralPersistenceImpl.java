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

import com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException;
import com.rknowsys.eapp.hrm.model.LeaveGeneral;
import com.rknowsys.eapp.hrm.model.impl.LeaveGeneralImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the leave general service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveGeneralPersistence
 * @see LeaveGeneralUtil
 * @generated
 */
public class LeaveGeneralPersistenceImpl extends BasePersistenceImpl<LeaveGeneral>
	implements LeaveGeneralPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveGeneralUtil} to access the leave general persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveGeneralImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveGeneralModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave generals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave generals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @return the range of matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave generals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByGroupId(long groupId, int start, int end,
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

		List<LeaveGeneral> list = (List<LeaveGeneral>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveGeneral leaveGeneral : list) {
				if ((groupId != leaveGeneral.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVEGENERAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveGeneralModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveGeneral>(list);
				}
				else {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave general in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveGeneral != null) {
			return leaveGeneral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveGeneralException(msg.toString());
	}

	/**
	 * Returns the first leave general in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave general, or <code>null</code> if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveGeneral> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave general in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveGeneral != null) {
			return leaveGeneral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveGeneralException(msg.toString());
	}

	/**
	 * Returns the last leave general in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave general, or <code>null</code> if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveGeneral> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave generals before and after the current leave general in the ordered set where groupId = &#63;.
	 *
	 * @param leaveGeneralId the primary key of the current leave general
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral[] findByGroupId_PrevAndNext(long leaveGeneralId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = findByPrimaryKey(leaveGeneralId);

		Session session = null;

		try {
			session = openSession();

			LeaveGeneral[] array = new LeaveGeneralImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, leaveGeneral, groupId,
					orderByComparator, true);

			array[1] = leaveGeneral;

			array[2] = getByGroupId_PrevAndNext(session, leaveGeneral, groupId,
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

	protected LeaveGeneral getByGroupId_PrevAndNext(Session session,
		LeaveGeneral leaveGeneral, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEGENERAL_WHERE);

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
			query.append(LeaveGeneralModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveGeneral);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveGeneral> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave generals where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveGeneral leaveGeneral : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveGeneral);
		}
	}

	/**
	 * Returns the number of leave generals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave generals
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

			query.append(_SQL_COUNT_LEAVEGENERAL_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveGeneral.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, LeaveGeneralImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveGeneralModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave generals where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave generals where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @return the range of matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByLeaveTypeId(long leaveTypeId, int start,
		int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave generals where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findByLeaveTypeId(long leaveTypeId, int start,
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

		List<LeaveGeneral> list = (List<LeaveGeneral>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveGeneral leaveGeneral : list) {
				if ((leaveTypeId != leaveGeneral.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVEGENERAL_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveGeneralModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveGeneral>(list);
				}
				else {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first leave general in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveGeneral != null) {
			return leaveGeneral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveGeneralException(msg.toString());
	}

	/**
	 * Returns the first leave general in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave general, or <code>null</code> if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveGeneral> list = findByLeaveTypeId(leaveTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave general in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveGeneral != null) {
			return leaveGeneral;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveGeneralException(msg.toString());
	}

	/**
	 * Returns the last leave general in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave general, or <code>null</code> if a matching leave general could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveGeneral> list = findByLeaveTypeId(leaveTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave generals before and after the current leave general in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveGeneralId the primary key of the current leave general
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral[] findByLeaveTypeId_PrevAndNext(long leaveGeneralId,
		long leaveTypeId, OrderByComparator orderByComparator)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = findByPrimaryKey(leaveGeneralId);

		Session session = null;

		try {
			session = openSession();

			LeaveGeneral[] array = new LeaveGeneralImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session, leaveGeneral,
					leaveTypeId, orderByComparator, true);

			array[1] = leaveGeneral;

			array[2] = getByLeaveTypeId_PrevAndNext(session, leaveGeneral,
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

	protected LeaveGeneral getByLeaveTypeId_PrevAndNext(Session session,
		LeaveGeneral leaveGeneral, long leaveTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVEGENERAL_WHERE);

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
			query.append(LeaveGeneralModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveGeneral);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveGeneral> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave generals where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveGeneral leaveGeneral : findByLeaveTypeId(leaveTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveGeneral);
		}
	}

	/**
	 * Returns the number of leave generals where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave generals
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

			query.append(_SQL_COUNT_LEAVEGENERAL_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveGeneral.leaveTypeId = ?";

	public LeaveGeneralPersistenceImpl() {
		setModelClass(LeaveGeneral.class);
	}

	/**
	 * Caches the leave general in the entity cache if it is enabled.
	 *
	 * @param leaveGeneral the leave general
	 */
	@Override
	public void cacheResult(LeaveGeneral leaveGeneral) {
		EntityCacheUtil.putResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralImpl.class, leaveGeneral.getPrimaryKey(), leaveGeneral);

		leaveGeneral.resetOriginalValues();
	}

	/**
	 * Caches the leave generals in the entity cache if it is enabled.
	 *
	 * @param leaveGenerals the leave generals
	 */
	@Override
	public void cacheResult(List<LeaveGeneral> leaveGenerals) {
		for (LeaveGeneral leaveGeneral : leaveGenerals) {
			if (EntityCacheUtil.getResult(
						LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
						LeaveGeneralImpl.class, leaveGeneral.getPrimaryKey()) == null) {
				cacheResult(leaveGeneral);
			}
			else {
				leaveGeneral.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave generals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveGeneralImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveGeneralImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave general.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveGeneral leaveGeneral) {
		EntityCacheUtil.removeResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralImpl.class, leaveGeneral.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveGeneral> leaveGenerals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveGeneral leaveGeneral : leaveGenerals) {
			EntityCacheUtil.removeResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
				LeaveGeneralImpl.class, leaveGeneral.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave general with the primary key. Does not add the leave general to the database.
	 *
	 * @param leaveGeneralId the primary key for the new leave general
	 * @return the new leave general
	 */
	@Override
	public LeaveGeneral create(long leaveGeneralId) {
		LeaveGeneral leaveGeneral = new LeaveGeneralImpl();

		leaveGeneral.setNew(true);
		leaveGeneral.setPrimaryKey(leaveGeneralId);

		return leaveGeneral;
	}

	/**
	 * Removes the leave general with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveGeneralId the primary key of the leave general
	 * @return the leave general that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral remove(long leaveGeneralId)
		throws NoSuchLeaveGeneralException, SystemException {
		return remove((Serializable)leaveGeneralId);
	}

	/**
	 * Removes the leave general with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave general
	 * @return the leave general that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral remove(Serializable primaryKey)
		throws NoSuchLeaveGeneralException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveGeneral leaveGeneral = (LeaveGeneral)session.get(LeaveGeneralImpl.class,
					primaryKey);

			if (leaveGeneral == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveGeneralException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveGeneral);
		}
		catch (NoSuchLeaveGeneralException nsee) {
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
	protected LeaveGeneral removeImpl(LeaveGeneral leaveGeneral)
		throws SystemException {
		leaveGeneral = toUnwrappedModel(leaveGeneral);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveGeneral)) {
				leaveGeneral = (LeaveGeneral)session.get(LeaveGeneralImpl.class,
						leaveGeneral.getPrimaryKeyObj());
			}

			if (leaveGeneral != null) {
				session.delete(leaveGeneral);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveGeneral != null) {
			clearCache(leaveGeneral);
		}

		return leaveGeneral;
	}

	@Override
	public LeaveGeneral updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveGeneral leaveGeneral)
		throws SystemException {
		leaveGeneral = toUnwrappedModel(leaveGeneral);

		boolean isNew = leaveGeneral.isNew();

		LeaveGeneralModelImpl leaveGeneralModelImpl = (LeaveGeneralModelImpl)leaveGeneral;

		Session session = null;

		try {
			session = openSession();

			if (leaveGeneral.isNew()) {
				session.save(leaveGeneral);

				leaveGeneral.setNew(false);
			}
			else {
				session.merge(leaveGeneral);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveGeneralModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveGeneralModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveGeneralModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveGeneralModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveGeneralModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveGeneralModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] { leaveGeneralModelImpl.getLeaveTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
			LeaveGeneralImpl.class, leaveGeneral.getPrimaryKey(), leaveGeneral);

		return leaveGeneral;
	}

	protected LeaveGeneral toUnwrappedModel(LeaveGeneral leaveGeneral) {
		if (leaveGeneral instanceof LeaveGeneralImpl) {
			return leaveGeneral;
		}

		LeaveGeneralImpl leaveGeneralImpl = new LeaveGeneralImpl();

		leaveGeneralImpl.setNew(leaveGeneral.isNew());
		leaveGeneralImpl.setPrimaryKey(leaveGeneral.getPrimaryKey());

		leaveGeneralImpl.setLeaveGeneralId(leaveGeneral.getLeaveGeneralId());
		leaveGeneralImpl.setCompanyId(leaveGeneral.getCompanyId());
		leaveGeneralImpl.setGroupId(leaveGeneral.getGroupId());
		leaveGeneralImpl.setCreateDate(leaveGeneral.getCreateDate());
		leaveGeneralImpl.setModifiedDate(leaveGeneral.getModifiedDate());
		leaveGeneralImpl.setUserId(leaveGeneral.getUserId());
		leaveGeneralImpl.setLeaveTypeId(leaveGeneral.getLeaveTypeId());
		leaveGeneralImpl.setLeavePeriodTypeId(leaveGeneral.getLeavePeriodTypeId());
		leaveGeneralImpl.setStartMonth(leaveGeneral.getStartMonth());
		leaveGeneralImpl.setStartDayOfMonth(leaveGeneral.getStartDayOfMonth());
		leaveGeneralImpl.setDuration(leaveGeneral.getDuration());
		leaveGeneralImpl.setIfEmployeesCanApply(leaveGeneral.isIfEmployeesCanApply());
		leaveGeneralImpl.setIfAdminCanAssign(leaveGeneral.isIfAdminCanAssign());
		leaveGeneralImpl.setIfAdminCanManageEntitlements(leaveGeneral.isIfAdminCanManageEntitlements());
		leaveGeneralImpl.setIfLeaveAccruable(leaveGeneral.isIfLeaveAccruable());
		leaveGeneralImpl.setIfCarryForwardable(leaveGeneral.isIfCarryForwardable());
		leaveGeneralImpl.setShowProjectBalance(leaveGeneral.isShowProjectBalance());
		leaveGeneralImpl.setEnableAttachment(leaveGeneral.isEnableAttachment());
		leaveGeneralImpl.setIsAttachmentMandatory(leaveGeneral.isIsAttachmentMandatory());

		return leaveGeneralImpl;
	}

	/**
	 * Returns the leave general with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave general
	 * @return the leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveGeneralException, SystemException {
		LeaveGeneral leaveGeneral = fetchByPrimaryKey(primaryKey);

		if (leaveGeneral == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveGeneralException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveGeneral;
	}

	/**
	 * Returns the leave general with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException} if it could not be found.
	 *
	 * @param leaveGeneralId the primary key of the leave general
	 * @return the leave general
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveGeneralException if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral findByPrimaryKey(long leaveGeneralId)
		throws NoSuchLeaveGeneralException, SystemException {
		return findByPrimaryKey((Serializable)leaveGeneralId);
	}

	/**
	 * Returns the leave general with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave general
	 * @return the leave general, or <code>null</code> if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveGeneral leaveGeneral = (LeaveGeneral)EntityCacheUtil.getResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
				LeaveGeneralImpl.class, primaryKey);

		if (leaveGeneral == _nullLeaveGeneral) {
			return null;
		}

		if (leaveGeneral == null) {
			Session session = null;

			try {
				session = openSession();

				leaveGeneral = (LeaveGeneral)session.get(LeaveGeneralImpl.class,
						primaryKey);

				if (leaveGeneral != null) {
					cacheResult(leaveGeneral);
				}
				else {
					EntityCacheUtil.putResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
						LeaveGeneralImpl.class, primaryKey, _nullLeaveGeneral);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveGeneralModelImpl.ENTITY_CACHE_ENABLED,
					LeaveGeneralImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveGeneral;
	}

	/**
	 * Returns the leave general with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveGeneralId the primary key of the leave general
	 * @return the leave general, or <code>null</code> if a leave general with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveGeneral fetchByPrimaryKey(long leaveGeneralId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveGeneralId);
	}

	/**
	 * Returns all the leave generals.
	 *
	 * @return the leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave generals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @return the range of leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave generals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveGeneralModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave generals
	 * @param end the upper bound of the range of leave generals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave generals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveGeneral> findAll(int start, int end,
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

		List<LeaveGeneral> list = (List<LeaveGeneral>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVEGENERAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEGENERAL;

				if (pagination) {
					sql = sql.concat(LeaveGeneralModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveGeneral>(list);
				}
				else {
					list = (List<LeaveGeneral>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave generals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveGeneral leaveGeneral : findAll()) {
			remove(leaveGeneral);
		}
	}

	/**
	 * Returns the number of leave generals.
	 *
	 * @return the number of leave generals
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

				Query q = session.createQuery(_SQL_COUNT_LEAVEGENERAL);

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
	 * Initializes the leave general persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveGeneral")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveGeneral>> listenersList = new ArrayList<ModelListener<LeaveGeneral>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveGeneral>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaveGeneralImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEAVEGENERAL = "SELECT leaveGeneral FROM LeaveGeneral leaveGeneral";
	private static final String _SQL_SELECT_LEAVEGENERAL_WHERE = "SELECT leaveGeneral FROM LeaveGeneral leaveGeneral WHERE ";
	private static final String _SQL_COUNT_LEAVEGENERAL = "SELECT COUNT(leaveGeneral) FROM LeaveGeneral leaveGeneral";
	private static final String _SQL_COUNT_LEAVEGENERAL_WHERE = "SELECT COUNT(leaveGeneral) FROM LeaveGeneral leaveGeneral WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveGeneral.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveGeneral exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveGeneral exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveGeneralPersistenceImpl.class);
	private static LeaveGeneral _nullLeaveGeneral = new LeaveGeneralImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveGeneral> toCacheModel() {
				return _nullLeaveGeneralCacheModel;
			}
		};

	private static CacheModel<LeaveGeneral> _nullLeaveGeneralCacheModel = new CacheModel<LeaveGeneral>() {
			@Override
			public LeaveGeneral toEntityModel() {
				return _nullLeaveGeneral;
			}
		};
}