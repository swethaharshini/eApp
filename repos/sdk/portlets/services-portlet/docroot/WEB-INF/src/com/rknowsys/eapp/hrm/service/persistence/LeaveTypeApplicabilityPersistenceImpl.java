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

import com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException;
import com.rknowsys.eapp.hrm.model.LeaveTypeApplicability;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityImpl;
import com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the leave type applicability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LeaveTypeApplicabilityPersistence
 * @see LeaveTypeApplicabilityUtil
 * @generated
 */
public class LeaveTypeApplicabilityPersistenceImpl extends BasePersistenceImpl<LeaveTypeApplicability>
	implements LeaveTypeApplicabilityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveTypeApplicabilityUtil} to access the leave type applicability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveTypeApplicabilityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LeaveTypeApplicabilityModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave type applicabilities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type applicabilities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @return the range of matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type applicabilities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByGroupId(long groupId, int start,
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

		List<LeaveTypeApplicability> list = (List<LeaveTypeApplicability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveTypeApplicability leaveTypeApplicability : list) {
				if ((groupId != leaveTypeApplicability.getGroupId())) {
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

			query.append(_SQL_SELECT_LEAVETYPEAPPLICABILITY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeApplicabilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeApplicability>(list);
				}
				else {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
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
	 * Returns the first leave type applicability in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = fetchByGroupId_First(groupId,
				orderByComparator);

		if (leaveTypeApplicability != null) {
			return leaveTypeApplicability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeApplicabilityException(msg.toString());
	}

	/**
	 * Returns the first leave type applicability in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveTypeApplicability> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type applicability in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (leaveTypeApplicability != null) {
			return leaveTypeApplicability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeApplicabilityException(msg.toString());
	}

	/**
	 * Returns the last leave type applicability in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeApplicability> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type applicabilities before and after the current leave type applicability in the ordered set where groupId = &#63;.
	 *
	 * @param leaveTypeApplicabilityId the primary key of the current leave type applicability
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability[] findByGroupId_PrevAndNext(
		long leaveTypeApplicabilityId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = findByPrimaryKey(leaveTypeApplicabilityId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeApplicability[] array = new LeaveTypeApplicabilityImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					leaveTypeApplicability, groupId, orderByComparator, true);

			array[1] = leaveTypeApplicability;

			array[2] = getByGroupId_PrevAndNext(session,
					leaveTypeApplicability, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveTypeApplicability getByGroupId_PrevAndNext(Session session,
		LeaveTypeApplicability leaveTypeApplicability, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPEAPPLICABILITY_WHERE);

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
			query.append(LeaveTypeApplicabilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveTypeApplicability);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveTypeApplicability> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type applicabilities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LeaveTypeApplicability leaveTypeApplicability : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveTypeApplicability);
		}
	}

	/**
	 * Returns the number of leave type applicabilities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching leave type applicabilities
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

			query.append(_SQL_COUNT_LEAVETYPEAPPLICABILITY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "leaveTypeApplicability.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID =
		new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveTypeId",
			new String[] { Long.class.getName() },
			LeaveTypeApplicabilityModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVETYPEID = new FinderPath(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the leave type applicabilities where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByLeaveTypeId(long leaveTypeId)
		throws SystemException {
		return findByLeaveTypeId(leaveTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type applicabilities where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @return the range of matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByLeaveTypeId(long leaveTypeId,
		int start, int end) throws SystemException {
		return findByLeaveTypeId(leaveTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type applicabilities where leaveTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param leaveTypeId the leave type ID
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findByLeaveTypeId(long leaveTypeId,
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

		List<LeaveTypeApplicability> list = (List<LeaveTypeApplicability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LeaveTypeApplicability leaveTypeApplicability : list) {
				if ((leaveTypeId != leaveTypeApplicability.getLeaveTypeId())) {
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

			query.append(_SQL_SELECT_LEAVETYPEAPPLICABILITY_WHERE);

			query.append(_FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LeaveTypeApplicabilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(leaveTypeId);

				if (!pagination) {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeApplicability>(list);
				}
				else {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
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
	 * Returns the first leave type applicability in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = fetchByLeaveTypeId_First(leaveTypeId,
				orderByComparator);

		if (leaveTypeApplicability != null) {
			return leaveTypeApplicability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeApplicabilityException(msg.toString());
	}

	/**
	 * Returns the first leave type applicability in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByLeaveTypeId_First(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LeaveTypeApplicability> list = findByLeaveTypeId(leaveTypeId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type applicability in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = fetchByLeaveTypeId_Last(leaveTypeId,
				orderByComparator);

		if (leaveTypeApplicability != null) {
			return leaveTypeApplicability;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("leaveTypeId=");
		msg.append(leaveTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLeaveTypeApplicabilityException(msg.toString());
	}

	/**
	 * Returns the last leave type applicability in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type applicability, or <code>null</code> if a matching leave type applicability could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByLeaveTypeId_Last(long leaveTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLeaveTypeId(leaveTypeId);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeApplicability> list = findByLeaveTypeId(leaveTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type applicabilities before and after the current leave type applicability in the ordered set where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeApplicabilityId the primary key of the current leave type applicability
	 * @param leaveTypeId the leave type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability[] findByLeaveTypeId_PrevAndNext(
		long leaveTypeApplicabilityId, long leaveTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = findByPrimaryKey(leaveTypeApplicabilityId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeApplicability[] array = new LeaveTypeApplicabilityImpl[3];

			array[0] = getByLeaveTypeId_PrevAndNext(session,
					leaveTypeApplicability, leaveTypeId, orderByComparator, true);

			array[1] = leaveTypeApplicability;

			array[2] = getByLeaveTypeId_PrevAndNext(session,
					leaveTypeApplicability, leaveTypeId, orderByComparator,
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

	protected LeaveTypeApplicability getByLeaveTypeId_PrevAndNext(
		Session session, LeaveTypeApplicability leaveTypeApplicability,
		long leaveTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEAVETYPEAPPLICABILITY_WHERE);

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
			query.append(LeaveTypeApplicabilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(leaveTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leaveTypeApplicability);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LeaveTypeApplicability> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type applicabilities where leaveTypeId = &#63; from the database.
	 *
	 * @param leaveTypeId the leave type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLeaveTypeId(long leaveTypeId) throws SystemException {
		for (LeaveTypeApplicability leaveTypeApplicability : findByLeaveTypeId(
				leaveTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(leaveTypeApplicability);
		}
	}

	/**
	 * Returns the number of leave type applicabilities where leaveTypeId = &#63;.
	 *
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave type applicabilities
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

			query.append(_SQL_COUNT_LEAVETYPEAPPLICABILITY_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVETYPEID_LEAVETYPEID_2 = "leaveTypeApplicability.leaveTypeId = ?";

	public LeaveTypeApplicabilityPersistenceImpl() {
		setModelClass(LeaveTypeApplicability.class);
	}

	/**
	 * Caches the leave type applicability in the entity cache if it is enabled.
	 *
	 * @param leaveTypeApplicability the leave type applicability
	 */
	@Override
	public void cacheResult(LeaveTypeApplicability leaveTypeApplicability) {
		EntityCacheUtil.putResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			leaveTypeApplicability.getPrimaryKey(), leaveTypeApplicability);

		leaveTypeApplicability.resetOriginalValues();
	}

	/**
	 * Caches the leave type applicabilities in the entity cache if it is enabled.
	 *
	 * @param leaveTypeApplicabilities the leave type applicabilities
	 */
	@Override
	public void cacheResult(
		List<LeaveTypeApplicability> leaveTypeApplicabilities) {
		for (LeaveTypeApplicability leaveTypeApplicability : leaveTypeApplicabilities) {
			if (EntityCacheUtil.getResult(
						LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeApplicabilityImpl.class,
						leaveTypeApplicability.getPrimaryKey()) == null) {
				cacheResult(leaveTypeApplicability);
			}
			else {
				leaveTypeApplicability.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave type applicabilities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaveTypeApplicabilityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaveTypeApplicabilityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave type applicability.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTypeApplicability leaveTypeApplicability) {
		EntityCacheUtil.removeResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			leaveTypeApplicability.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<LeaveTypeApplicability> leaveTypeApplicabilities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveTypeApplicability leaveTypeApplicability : leaveTypeApplicabilities) {
			EntityCacheUtil.removeResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeApplicabilityImpl.class,
				leaveTypeApplicability.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave type applicability with the primary key. Does not add the leave type applicability to the database.
	 *
	 * @param leaveTypeApplicabilityId the primary key for the new leave type applicability
	 * @return the new leave type applicability
	 */
	@Override
	public LeaveTypeApplicability create(long leaveTypeApplicabilityId) {
		LeaveTypeApplicability leaveTypeApplicability = new LeaveTypeApplicabilityImpl();

		leaveTypeApplicability.setNew(true);
		leaveTypeApplicability.setPrimaryKey(leaveTypeApplicabilityId);

		return leaveTypeApplicability;
	}

	/**
	 * Removes the leave type applicability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeApplicabilityId the primary key of the leave type applicability
	 * @return the leave type applicability that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability remove(long leaveTypeApplicabilityId)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		return remove((Serializable)leaveTypeApplicabilityId);
	}

	/**
	 * Removes the leave type applicability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type applicability
	 * @return the leave type applicability that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability remove(Serializable primaryKey)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaveTypeApplicability leaveTypeApplicability = (LeaveTypeApplicability)session.get(LeaveTypeApplicabilityImpl.class,
					primaryKey);

			if (leaveTypeApplicability == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeApplicabilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveTypeApplicability);
		}
		catch (NoSuchLeaveTypeApplicabilityException nsee) {
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
	protected LeaveTypeApplicability removeImpl(
		LeaveTypeApplicability leaveTypeApplicability)
		throws SystemException {
		leaveTypeApplicability = toUnwrappedModel(leaveTypeApplicability);

		leaveTypeApplicabilityToJobTitleTableMapper.deleteLeftPrimaryKeyTableMappings(leaveTypeApplicability.getPrimaryKey());

		leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteLeftPrimaryKeyTableMappings(leaveTypeApplicability.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTypeApplicability)) {
				leaveTypeApplicability = (LeaveTypeApplicability)session.get(LeaveTypeApplicabilityImpl.class,
						leaveTypeApplicability.getPrimaryKeyObj());
			}

			if (leaveTypeApplicability != null) {
				session.delete(leaveTypeApplicability);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveTypeApplicability != null) {
			clearCache(leaveTypeApplicability);
		}

		return leaveTypeApplicability;
	}

	@Override
	public LeaveTypeApplicability updateImpl(
		com.rknowsys.eapp.hrm.model.LeaveTypeApplicability leaveTypeApplicability)
		throws SystemException {
		leaveTypeApplicability = toUnwrappedModel(leaveTypeApplicability);

		boolean isNew = leaveTypeApplicability.isNew();

		LeaveTypeApplicabilityModelImpl leaveTypeApplicabilityModelImpl = (LeaveTypeApplicabilityModelImpl)leaveTypeApplicability;

		Session session = null;

		try {
			session = openSession();

			if (leaveTypeApplicability.isNew()) {
				session.save(leaveTypeApplicability);

				leaveTypeApplicability.setNew(false);
			}
			else {
				session.merge(leaveTypeApplicability);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LeaveTypeApplicabilityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leaveTypeApplicabilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeApplicabilityModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { leaveTypeApplicabilityModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((leaveTypeApplicabilityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leaveTypeApplicabilityModelImpl.getOriginalLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);

				args = new Object[] {
						leaveTypeApplicabilityModelImpl.getLeaveTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEAVETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEAVETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeApplicabilityImpl.class,
			leaveTypeApplicability.getPrimaryKey(), leaveTypeApplicability);

		return leaveTypeApplicability;
	}

	protected LeaveTypeApplicability toUnwrappedModel(
		LeaveTypeApplicability leaveTypeApplicability) {
		if (leaveTypeApplicability instanceof LeaveTypeApplicabilityImpl) {
			return leaveTypeApplicability;
		}

		LeaveTypeApplicabilityImpl leaveTypeApplicabilityImpl = new LeaveTypeApplicabilityImpl();

		leaveTypeApplicabilityImpl.setNew(leaveTypeApplicability.isNew());
		leaveTypeApplicabilityImpl.setPrimaryKey(leaveTypeApplicability.getPrimaryKey());

		leaveTypeApplicabilityImpl.setLeaveTypeApplicabilityId(leaveTypeApplicability.getLeaveTypeApplicabilityId());
		leaveTypeApplicabilityImpl.setCompanyId(leaveTypeApplicability.getCompanyId());
		leaveTypeApplicabilityImpl.setGroupId(leaveTypeApplicability.getGroupId());
		leaveTypeApplicabilityImpl.setCreateDate(leaveTypeApplicability.getCreateDate());
		leaveTypeApplicabilityImpl.setModifiedDate(leaveTypeApplicability.getModifiedDate());
		leaveTypeApplicabilityImpl.setUserId(leaveTypeApplicability.getUserId());
		leaveTypeApplicabilityImpl.setLeaveTypeId(leaveTypeApplicability.getLeaveTypeId());
		leaveTypeApplicabilityImpl.setIfYearsOfServiceCriterionApplicable(leaveTypeApplicability.isIfYearsOfServiceCriterionApplicable());
		leaveTypeApplicabilityImpl.setMinYearsOfService(leaveTypeApplicability.getMinYearsOfService());
		leaveTypeApplicabilityImpl.setMaxYearsOfService(leaveTypeApplicability.getMaxYearsOfService());

		return leaveTypeApplicabilityImpl;
	}

	/**
	 * Returns the leave type applicability with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type applicability
	 * @return the leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		LeaveTypeApplicability leaveTypeApplicability = fetchByPrimaryKey(primaryKey);

		if (leaveTypeApplicability == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeApplicabilityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveTypeApplicability;
	}

	/**
	 * Returns the leave type applicability with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException} if it could not be found.
	 *
	 * @param leaveTypeApplicabilityId the primary key of the leave type applicability
	 * @return the leave type applicability
	 * @throws com.rknowsys.eapp.hrm.NoSuchLeaveTypeApplicabilityException if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability findByPrimaryKey(
		long leaveTypeApplicabilityId)
		throws NoSuchLeaveTypeApplicabilityException, SystemException {
		return findByPrimaryKey((Serializable)leaveTypeApplicabilityId);
	}

	/**
	 * Returns the leave type applicability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type applicability
	 * @return the leave type applicability, or <code>null</code> if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaveTypeApplicability leaveTypeApplicability = (LeaveTypeApplicability)EntityCacheUtil.getResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeApplicabilityImpl.class, primaryKey);

		if (leaveTypeApplicability == _nullLeaveTypeApplicability) {
			return null;
		}

		if (leaveTypeApplicability == null) {
			Session session = null;

			try {
				session = openSession();

				leaveTypeApplicability = (LeaveTypeApplicability)session.get(LeaveTypeApplicabilityImpl.class,
						primaryKey);

				if (leaveTypeApplicability != null) {
					cacheResult(leaveTypeApplicability);
				}
				else {
					EntityCacheUtil.putResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeApplicabilityImpl.class, primaryKey,
						_nullLeaveTypeApplicability);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaveTypeApplicabilityModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeApplicabilityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveTypeApplicability;
	}

	/**
	 * Returns the leave type applicability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeApplicabilityId the primary key of the leave type applicability
	 * @return the leave type applicability, or <code>null</code> if a leave type applicability with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaveTypeApplicability fetchByPrimaryKey(
		long leaveTypeApplicabilityId) throws SystemException {
		return fetchByPrimaryKey((Serializable)leaveTypeApplicabilityId);
	}

	/**
	 * Returns all the leave type applicabilities.
	 *
	 * @return the leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type applicabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @return the range of leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type applicabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type applicabilities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaveTypeApplicability> findAll(int start, int end,
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

		List<LeaveTypeApplicability> list = (List<LeaveTypeApplicability>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEAVETYPEAPPLICABILITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPEAPPLICABILITY;

				if (pagination) {
					sql = sql.concat(LeaveTypeApplicabilityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaveTypeApplicability>(list);
				}
				else {
					list = (List<LeaveTypeApplicability>)QueryUtil.list(q,
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
	 * Removes all the leave type applicabilities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaveTypeApplicability leaveTypeApplicability : findAll()) {
			remove(leaveTypeApplicability);
		}
	}

	/**
	 * Returns the number of leave type applicabilities.
	 *
	 * @return the number of leave type applicabilities
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

				Query q = session.createQuery(_SQL_COUNT_LEAVETYPEAPPLICABILITY);

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
	 * Returns all the job titles associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @return the job titles associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk)
		throws SystemException {
		return getJobTitles(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the job titles associated with the leave type applicability.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @return the range of job titles associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk,
		int start, int end) throws SystemException {
		return getJobTitles(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titles associated with the leave type applicability.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job titles associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.JobTitle> getJobTitles(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return leaveTypeApplicabilityToJobTitleTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of job titles associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @return the number of job titles associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJobTitlesSize(long pk) throws SystemException {
		long[] pks = leaveTypeApplicabilityToJobTitleTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the job title is associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePK the primary key of the job title
	 * @return <code>true</code> if the job title is associated with the leave type applicability; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobTitle(long pk, long jobTitlePK)
		throws SystemException {
		return leaveTypeApplicabilityToJobTitleTableMapper.containsTableMapping(pk,
			jobTitlePK);
	}

	/**
	 * Returns <code>true</code> if the leave type applicability has any job titles associated with it.
	 *
	 * @param pk the primary key of the leave type applicability to check for associations with job titles
	 * @return <code>true</code> if the leave type applicability has any job titles associated with it; <code>false</code> otherwise
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
	 * Adds an association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePK the primary key of the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitle(long pk, long jobTitlePK) throws SystemException {
		leaveTypeApplicabilityToJobTitleTableMapper.addTableMapping(pk,
			jobTitlePK);
	}

	/**
	 * Adds an association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitle the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws SystemException {
		leaveTypeApplicabilityToJobTitleTableMapper.addTableMapping(pk,
			jobTitle.getPrimaryKey());
	}

	/**
	 * Adds an association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePKs the primary keys of the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		for (long jobTitlePK : jobTitlePKs) {
			leaveTypeApplicabilityToJobTitleTableMapper.addTableMapping(pk,
				jobTitlePK);
		}
	}

	/**
	 * Adds an association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitles the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobTitles(long pk,
		List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobTitle jobTitle : jobTitles) {
			leaveTypeApplicabilityToJobTitleTableMapper.addTableMapping(pk,
				jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the leave type applicability and its job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability to clear the associated job titles from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearJobTitles(long pk) throws SystemException {
		leaveTypeApplicabilityToJobTitleTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePK the primary key of the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitle(long pk, long jobTitlePK)
		throws SystemException {
		leaveTypeApplicabilityToJobTitleTableMapper.deleteTableMapping(pk,
			jobTitlePK);
	}

	/**
	 * Removes the association between the leave type applicability and the job title. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitle the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitle(long pk,
		com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws SystemException {
		leaveTypeApplicabilityToJobTitleTableMapper.deleteTableMapping(pk,
			jobTitle.getPrimaryKey());
	}

	/**
	 * Removes the association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePKs the primary keys of the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		for (long jobTitlePK : jobTitlePKs) {
			leaveTypeApplicabilityToJobTitleTableMapper.deleteTableMapping(pk,
				jobTitlePK);
		}
	}

	/**
	 * Removes the association between the leave type applicability and the job titles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitles the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobTitles(long pk,
		List<com.rknowsys.eapp.hrm.model.JobTitle> jobTitles)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.JobTitle jobTitle : jobTitles) {
			leaveTypeApplicabilityToJobTitleTableMapper.deleteTableMapping(pk,
				jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Sets the job titles associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitlePKs the primary keys of the job titles to be associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobTitles(long pk, long[] jobTitlePKs)
		throws SystemException {
		Set<Long> newJobTitlePKsSet = SetUtil.fromArray(jobTitlePKs);
		Set<Long> oldJobTitlePKsSet = SetUtil.fromArray(leaveTypeApplicabilityToJobTitleTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeJobTitlePKsSet = new HashSet<Long>(oldJobTitlePKsSet);

		removeJobTitlePKsSet.removeAll(newJobTitlePKsSet);

		for (long removeJobTitlePK : removeJobTitlePKsSet) {
			leaveTypeApplicabilityToJobTitleTableMapper.deleteTableMapping(pk,
				removeJobTitlePK);
		}

		newJobTitlePKsSet.removeAll(oldJobTitlePKsSet);

		for (long newJobTitlePK : newJobTitlePKsSet) {
			leaveTypeApplicabilityToJobTitleTableMapper.addTableMapping(pk,
				newJobTitlePK);
		}
	}

	/**
	 * Sets the job titles associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param jobTitles the job titles to be associated with the leave type applicability
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
			FinderCacheUtil.clearCache(LeaveTypeApplicabilityModelImpl.MAPPING_TABLE_HRM_APPLICABLE_JOB_TITLES_NAME);
		}
	}

	/**
	 * Returns all the employment statuses associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @return the employment statuses associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk) throws SystemException {
		return getEmploymentStatuses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the employment statuses associated with the leave type applicability.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @return the range of employment statuses associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end) throws SystemException {
		return getEmploymentStatuses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employment statuses associated with the leave type applicability.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeApplicabilityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param start the lower bound of the range of leave type applicabilities
	 * @param end the upper bound of the range of leave type applicabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employment statuses associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.EmploymentStatus> getEmploymentStatuses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return leaveTypeApplicabilityToEmploymentStatusTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of employment statuses associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @return the number of employment statuses associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEmploymentStatusesSize(long pk) throws SystemException {
		long[] pks = leaveTypeApplicabilityToEmploymentStatusTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the employment status is associated with the leave type applicability.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPK the primary key of the employment status
	 * @return <code>true</code> if the employment status is associated with the leave type applicability; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		return leaveTypeApplicabilityToEmploymentStatusTableMapper.containsTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Returns <code>true</code> if the leave type applicability has any employment statuses associated with it.
	 *
	 * @param pk the primary key of the leave type applicability to check for associations with employment statuses
	 * @return <code>true</code> if the leave type applicability has any employment statuses associated with it; <code>false</code> otherwise
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
	 * Adds an association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPK the primary key of the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		leaveTypeApplicabilityToEmploymentStatusTableMapper.addTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Adds an association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatus the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws SystemException {
		leaveTypeApplicabilityToEmploymentStatusTableMapper.addTableMapping(pk,
			employmentStatus.getPrimaryKey());
	}

	/**
	 * Adds an association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPKs the primary keys of the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		for (long employmentStatusPK : employmentStatusPKs) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.addTableMapping(pk,
				employmentStatusPK);
		}
	}

	/**
	 * Adds an association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatuses the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmploymentStatuses(long pk,
		List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus : employmentStatuses) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.addTableMapping(pk,
				employmentStatus.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the leave type applicability and its employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability to clear the associated employment statuses from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearEmploymentStatuses(long pk) throws SystemException {
		leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPK the primary key of the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatus(long pk, long employmentStatusPK)
		throws SystemException {
		leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteTableMapping(pk,
			employmentStatusPK);
	}

	/**
	 * Removes the association between the leave type applicability and the employment status. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatus the employment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatus(long pk,
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws SystemException {
		leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteTableMapping(pk,
			employmentStatus.getPrimaryKey());
	}

	/**
	 * Removes the association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPKs the primary keys of the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		for (long employmentStatusPK : employmentStatusPKs) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteTableMapping(pk,
				employmentStatusPK);
		}
	}

	/**
	 * Removes the association between the leave type applicability and the employment statuses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatuses the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmploymentStatuses(long pk,
		List<com.rknowsys.eapp.hrm.model.EmploymentStatus> employmentStatuses)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus : employmentStatuses) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteTableMapping(pk,
				employmentStatus.getPrimaryKey());
		}
	}

	/**
	 * Sets the employment statuses associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatusPKs the primary keys of the employment statuses to be associated with the leave type applicability
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmploymentStatuses(long pk, long[] employmentStatusPKs)
		throws SystemException {
		Set<Long> newEmploymentStatusPKsSet = SetUtil.fromArray(employmentStatusPKs);
		Set<Long> oldEmploymentStatusPKsSet = SetUtil.fromArray(leaveTypeApplicabilityToEmploymentStatusTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeEmploymentStatusPKsSet = new HashSet<Long>(oldEmploymentStatusPKsSet);

		removeEmploymentStatusPKsSet.removeAll(newEmploymentStatusPKsSet);

		for (long removeEmploymentStatusPK : removeEmploymentStatusPKsSet) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.deleteTableMapping(pk,
				removeEmploymentStatusPK);
		}

		newEmploymentStatusPKsSet.removeAll(oldEmploymentStatusPKsSet);

		for (long newEmploymentStatusPK : newEmploymentStatusPKsSet) {
			leaveTypeApplicabilityToEmploymentStatusTableMapper.addTableMapping(pk,
				newEmploymentStatusPK);
		}
	}

	/**
	 * Sets the employment statuses associated with the leave type applicability, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the leave type applicability
	 * @param employmentStatuses the employment statuses to be associated with the leave type applicability
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
			FinderCacheUtil.clearCache(LeaveTypeApplicabilityModelImpl.MAPPING_TABLE_HRM_APPLICABLE_EMPLOYMENT_STATUSES_NAME);
		}
	}

	/**
	 * Initializes the leave type applicability persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.LeaveTypeApplicability")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaveTypeApplicability>> listenersList = new ArrayList<ModelListener<LeaveTypeApplicability>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaveTypeApplicability>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		leaveTypeApplicabilityToJobTitleTableMapper = TableMapperFactory.getTableMapper("hrm_applicable_job_titles",
				"leaveTypeApplicabilityId", "jobTitleId", this,
				jobTitlePersistence);

		leaveTypeApplicabilityToEmploymentStatusTableMapper = TableMapperFactory.getTableMapper("hrm_applicable_employment_statuses",
				"leaveTypeApplicabilityId", "employmentStatusId", this,
				employmentStatusPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LeaveTypeApplicabilityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = JobTitlePersistence.class)
	protected JobTitlePersistence jobTitlePersistence;
	protected TableMapper<LeaveTypeApplicability, com.rknowsys.eapp.hrm.model.JobTitle> leaveTypeApplicabilityToJobTitleTableMapper;
	@BeanReference(type = EmploymentStatusPersistence.class)
	protected EmploymentStatusPersistence employmentStatusPersistence;
	protected TableMapper<LeaveTypeApplicability, com.rknowsys.eapp.hrm.model.EmploymentStatus> leaveTypeApplicabilityToEmploymentStatusTableMapper;
	private static final String _SQL_SELECT_LEAVETYPEAPPLICABILITY = "SELECT leaveTypeApplicability FROM LeaveTypeApplicability leaveTypeApplicability";
	private static final String _SQL_SELECT_LEAVETYPEAPPLICABILITY_WHERE = "SELECT leaveTypeApplicability FROM LeaveTypeApplicability leaveTypeApplicability WHERE ";
	private static final String _SQL_COUNT_LEAVETYPEAPPLICABILITY = "SELECT COUNT(leaveTypeApplicability) FROM LeaveTypeApplicability leaveTypeApplicability";
	private static final String _SQL_COUNT_LEAVETYPEAPPLICABILITY_WHERE = "SELECT COUNT(leaveTypeApplicability) FROM LeaveTypeApplicability leaveTypeApplicability WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTypeApplicability.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveTypeApplicability exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveTypeApplicability exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaveTypeApplicabilityPersistenceImpl.class);
	private static LeaveTypeApplicability _nullLeaveTypeApplicability = new LeaveTypeApplicabilityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaveTypeApplicability> toCacheModel() {
				return _nullLeaveTypeApplicabilityCacheModel;
			}
		};

	private static CacheModel<LeaveTypeApplicability> _nullLeaveTypeApplicabilityCacheModel =
		new CacheModel<LeaveTypeApplicability>() {
			@Override
			public LeaveTypeApplicability toEntityModel() {
				return _nullLeaveTypeApplicability;
			}
		};
}