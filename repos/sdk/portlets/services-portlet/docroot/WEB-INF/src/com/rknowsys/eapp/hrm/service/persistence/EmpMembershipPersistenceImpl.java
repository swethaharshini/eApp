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

import com.rknowsys.eapp.hrm.NoSuchEmpMembershipException;
import com.rknowsys.eapp.hrm.model.EmpMembership;
import com.rknowsys.eapp.hrm.model.impl.EmpMembershipImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the emp membership service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpMembershipPersistence
 * @see EmpMembershipUtil
 * @generated
 */
public class EmpMembershipPersistenceImpl extends BasePersistenceImpl<EmpMembership>
	implements EmpMembershipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpMembershipUtil} to access the emp membership persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpMembershipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			EmpMembershipModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp memberships where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp memberships where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @return the range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp memberships where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByGroupId(long groupId, int start, int end,
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

		List<EmpMembership> list = (List<EmpMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpMembership empMembership : list) {
				if ((groupId != empMembership.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpMembership>(list);
				}
				else {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the first emp membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpMembership> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the last emp membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpMembership> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp memberships before and after the current emp membership in the ordered set where groupId = &#63;.
	 *
	 * @param empMembershipId the primary key of the current emp membership
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership[] findByGroupId_PrevAndNext(long empMembershipId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = findByPrimaryKey(empMembershipId);

		Session session = null;

		try {
			session = openSession();

			EmpMembership[] array = new EmpMembershipImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empMembership,
					groupId, orderByComparator, true);

			array[1] = empMembership;

			array[2] = getByGroupId_PrevAndNext(session, empMembership,
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

	protected EmpMembership getByGroupId_PrevAndNext(Session session,
		EmpMembership empMembership, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

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
			query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empMembership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpMembership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp memberships where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpMembership empMembership : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empMembership);
		}
	}

	/**
	 * Returns the number of emp memberships where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp memberships
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

			query.append(_SQL_COUNT_EMPMEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empMembership.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPID =
		new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymembershipId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID =
		new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymembershipId", new String[] { Long.class.getName() },
			EmpMembershipModelImpl.MEMBERSHIPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPID = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymembershipId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp memberships where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @return the matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findBymembershipId(long membershipId)
		throws SystemException {
		return findBymembershipId(membershipId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp memberships where membershipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param membershipId the membership ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @return the range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findBymembershipId(long membershipId, int start,
		int end) throws SystemException {
		return findBymembershipId(membershipId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp memberships where membershipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param membershipId the membership ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findBymembershipId(long membershipId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID;
			finderArgs = new Object[] { membershipId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPID;
			finderArgs = new Object[] {
					membershipId,
					
					start, end, orderByComparator
				};
		}

		List<EmpMembership> list = (List<EmpMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpMembership empMembership : list) {
				if ((membershipId != empMembership.getMembershipId())) {
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

			query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(membershipId);

				if (!pagination) {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpMembership>(list);
				}
				else {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findBymembershipId_First(long membershipId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchBymembershipId_First(membershipId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipId=");
		msg.append(membershipId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the first emp membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchBymembershipId_First(long membershipId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpMembership> list = findBymembershipId(membershipId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findBymembershipId_Last(long membershipId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchBymembershipId_Last(membershipId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipId=");
		msg.append(membershipId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the last emp membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchBymembershipId_Last(long membershipId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymembershipId(membershipId);

		if (count == 0) {
			return null;
		}

		List<EmpMembership> list = findBymembershipId(membershipId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp memberships before and after the current emp membership in the ordered set where membershipId = &#63;.
	 *
	 * @param empMembershipId the primary key of the current emp membership
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership[] findBymembershipId_PrevAndNext(
		long empMembershipId, long membershipId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = findByPrimaryKey(empMembershipId);

		Session session = null;

		try {
			session = openSession();

			EmpMembership[] array = new EmpMembershipImpl[3];

			array[0] = getBymembershipId_PrevAndNext(session, empMembership,
					membershipId, orderByComparator, true);

			array[1] = empMembership;

			array[2] = getBymembershipId_PrevAndNext(session, empMembership,
					membershipId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpMembership getBymembershipId_PrevAndNext(Session session,
		EmpMembership empMembership, long membershipId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2);

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
			query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(membershipId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empMembership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpMembership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp memberships where membershipId = &#63; from the database.
	 *
	 * @param membershipId the membership ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymembershipId(long membershipId)
		throws SystemException {
		for (EmpMembership empMembership : findBymembershipId(membershipId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empMembership);
		}
	}

	/**
	 * Returns the number of emp memberships where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @return the number of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymembershipId(long membershipId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPID;

		Object[] finderArgs = new Object[] { membershipId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPMEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(membershipId);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2 = "empMembership.membershipId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED,
			EmpMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeId", new String[] { Long.class.getName() },
			EmpMembershipModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp memberships where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp memberships where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @return the range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp memberships where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findByemployeeId(long employeeId, int start,
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

		List<EmpMembership> list = (List<EmpMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpMembership empMembership : list) {
				if ((employeeId != empMembership.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpMembership>(list);
				}
				else {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp membership in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the first emp membership in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpMembership> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp membership in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empMembership != null) {
			return empMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpMembershipException(msg.toString());
	}

	/**
	 * Returns the last emp membership in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp membership, or <code>null</code> if a matching emp membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpMembership> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp memberships before and after the current emp membership in the ordered set where employeeId = &#63;.
	 *
	 * @param empMembershipId the primary key of the current emp membership
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership[] findByemployeeId_PrevAndNext(long empMembershipId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = findByPrimaryKey(empMembershipId);

		Session session = null;

		try {
			session = openSession();

			EmpMembership[] array = new EmpMembershipImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empMembership,
					employeeId, orderByComparator, true);

			array[1] = empMembership;

			array[2] = getByemployeeId_PrevAndNext(session, empMembership,
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

	protected EmpMembership getByemployeeId_PrevAndNext(Session session,
		EmpMembership empMembership, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPMEMBERSHIP_WHERE);

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
			query.append(EmpMembershipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empMembership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpMembership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp memberships where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpMembership empMembership : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empMembership);
		}
	}

	/**
	 * Returns the number of emp memberships where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp memberships
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

			query.append(_SQL_COUNT_EMPMEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empMembership.employeeId = ?";

	public EmpMembershipPersistenceImpl() {
		setModelClass(EmpMembership.class);
	}

	/**
	 * Caches the emp membership in the entity cache if it is enabled.
	 *
	 * @param empMembership the emp membership
	 */
	@Override
	public void cacheResult(EmpMembership empMembership) {
		EntityCacheUtil.putResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipImpl.class, empMembership.getPrimaryKey(),
			empMembership);

		empMembership.resetOriginalValues();
	}

	/**
	 * Caches the emp memberships in the entity cache if it is enabled.
	 *
	 * @param empMemberships the emp memberships
	 */
	@Override
	public void cacheResult(List<EmpMembership> empMemberships) {
		for (EmpMembership empMembership : empMemberships) {
			if (EntityCacheUtil.getResult(
						EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
						EmpMembershipImpl.class, empMembership.getPrimaryKey()) == null) {
				cacheResult(empMembership);
			}
			else {
				empMembership.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp memberships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpMembershipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpMembershipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp membership.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpMembership empMembership) {
		EntityCacheUtil.removeResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipImpl.class, empMembership.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpMembership> empMemberships) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpMembership empMembership : empMemberships) {
			EntityCacheUtil.removeResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
				EmpMembershipImpl.class, empMembership.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp membership with the primary key. Does not add the emp membership to the database.
	 *
	 * @param empMembershipId the primary key for the new emp membership
	 * @return the new emp membership
	 */
	@Override
	public EmpMembership create(long empMembershipId) {
		EmpMembership empMembership = new EmpMembershipImpl();

		empMembership.setNew(true);
		empMembership.setPrimaryKey(empMembershipId);

		return empMembership;
	}

	/**
	 * Removes the emp membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empMembershipId the primary key of the emp membership
	 * @return the emp membership that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership remove(long empMembershipId)
		throws NoSuchEmpMembershipException, SystemException {
		return remove((Serializable)empMembershipId);
	}

	/**
	 * Removes the emp membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp membership
	 * @return the emp membership that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership remove(Serializable primaryKey)
		throws NoSuchEmpMembershipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpMembership empMembership = (EmpMembership)session.get(EmpMembershipImpl.class,
					primaryKey);

			if (empMembership == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empMembership);
		}
		catch (NoSuchEmpMembershipException nsee) {
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
	protected EmpMembership removeImpl(EmpMembership empMembership)
		throws SystemException {
		empMembership = toUnwrappedModel(empMembership);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empMembership)) {
				empMembership = (EmpMembership)session.get(EmpMembershipImpl.class,
						empMembership.getPrimaryKeyObj());
			}

			if (empMembership != null) {
				session.delete(empMembership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empMembership != null) {
			clearCache(empMembership);
		}

		return empMembership;
	}

	@Override
	public EmpMembership updateImpl(
		com.rknowsys.eapp.hrm.model.EmpMembership empMembership)
		throws SystemException {
		empMembership = toUnwrappedModel(empMembership);

		boolean isNew = empMembership.isNew();

		EmpMembershipModelImpl empMembershipModelImpl = (EmpMembershipModelImpl)empMembership;

		Session session = null;

		try {
			session = openSession();

			if (empMembership.isNew()) {
				session.save(empMembership);

				empMembership.setNew(false);
			}
			else {
				session.merge(empMembership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpMembershipModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empMembershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empMembershipModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empMembershipModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empMembershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empMembershipModelImpl.getOriginalMembershipId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID,
					args);

				args = new Object[] { empMembershipModelImpl.getMembershipId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID,
					args);
			}

			if ((empMembershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empMembershipModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empMembershipModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
			EmpMembershipImpl.class, empMembership.getPrimaryKey(),
			empMembership);

		return empMembership;
	}

	protected EmpMembership toUnwrappedModel(EmpMembership empMembership) {
		if (empMembership instanceof EmpMembershipImpl) {
			return empMembership;
		}

		EmpMembershipImpl empMembershipImpl = new EmpMembershipImpl();

		empMembershipImpl.setNew(empMembership.isNew());
		empMembershipImpl.setPrimaryKey(empMembership.getPrimaryKey());

		empMembershipImpl.setEmpMembershipId(empMembership.getEmpMembershipId());
		empMembershipImpl.setEmployeeId(empMembership.getEmployeeId());
		empMembershipImpl.setGroupId(empMembership.getGroupId());
		empMembershipImpl.setCompanyId(empMembership.getCompanyId());
		empMembershipImpl.setCreateDate(empMembership.getCreateDate());
		empMembershipImpl.setModifiedDate(empMembership.getModifiedDate());
		empMembershipImpl.setUserId(empMembership.getUserId());
		empMembershipImpl.setMembershipId(empMembership.getMembershipId());
		empMembershipImpl.setSubscriptionPaidBy(empMembership.getSubscriptionPaidBy());
		empMembershipImpl.setSubscriptionAmt(empMembership.getSubscriptionAmt());
		empMembershipImpl.setCurrency(empMembership.getCurrency());
		empMembershipImpl.setCommenceDate(empMembership.getCommenceDate());
		empMembershipImpl.setRenewalDate(empMembership.getRenewalDate());

		return empMembershipImpl;
	}

	/**
	 * Returns the emp membership with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp membership
	 * @return the emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpMembershipException, SystemException {
		EmpMembership empMembership = fetchByPrimaryKey(primaryKey);

		if (empMembership == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empMembership;
	}

	/**
	 * Returns the emp membership with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpMembershipException} if it could not be found.
	 *
	 * @param empMembershipId the primary key of the emp membership
	 * @return the emp membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpMembershipException if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership findByPrimaryKey(long empMembershipId)
		throws NoSuchEmpMembershipException, SystemException {
		return findByPrimaryKey((Serializable)empMembershipId);
	}

	/**
	 * Returns the emp membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp membership
	 * @return the emp membership, or <code>null</code> if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpMembership empMembership = (EmpMembership)EntityCacheUtil.getResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
				EmpMembershipImpl.class, primaryKey);

		if (empMembership == _nullEmpMembership) {
			return null;
		}

		if (empMembership == null) {
			Session session = null;

			try {
				session = openSession();

				empMembership = (EmpMembership)session.get(EmpMembershipImpl.class,
						primaryKey);

				if (empMembership != null) {
					cacheResult(empMembership);
				}
				else {
					EntityCacheUtil.putResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
						EmpMembershipImpl.class, primaryKey, _nullEmpMembership);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpMembershipModelImpl.ENTITY_CACHE_ENABLED,
					EmpMembershipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empMembership;
	}

	/**
	 * Returns the emp membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empMembershipId the primary key of the emp membership
	 * @return the emp membership, or <code>null</code> if a emp membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpMembership fetchByPrimaryKey(long empMembershipId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empMembershipId);
	}

	/**
	 * Returns all the emp memberships.
	 *
	 * @return the emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @return the range of emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp memberships
	 * @param end the upper bound of the range of emp memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpMembership> findAll(int start, int end,
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

		List<EmpMembership> list = (List<EmpMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPMEMBERSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPMEMBERSHIP;

				if (pagination) {
					sql = sql.concat(EmpMembershipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpMembership>(list);
				}
				else {
					list = (List<EmpMembership>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp memberships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpMembership empMembership : findAll()) {
			remove(empMembership);
		}
	}

	/**
	 * Returns the number of emp memberships.
	 *
	 * @return the number of emp memberships
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

				Query q = session.createQuery(_SQL_COUNT_EMPMEMBERSHIP);

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
	 * Initializes the emp membership persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpMembership")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpMembership>> listenersList = new ArrayList<ModelListener<EmpMembership>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpMembership>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpMembershipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPMEMBERSHIP = "SELECT empMembership FROM EmpMembership empMembership";
	private static final String _SQL_SELECT_EMPMEMBERSHIP_WHERE = "SELECT empMembership FROM EmpMembership empMembership WHERE ";
	private static final String _SQL_COUNT_EMPMEMBERSHIP = "SELECT COUNT(empMembership) FROM EmpMembership empMembership";
	private static final String _SQL_COUNT_EMPMEMBERSHIP_WHERE = "SELECT COUNT(empMembership) FROM EmpMembership empMembership WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empMembership.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpMembership exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpMembership exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpMembershipPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static EmpMembership _nullEmpMembership = new EmpMembershipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpMembership> toCacheModel() {
				return _nullEmpMembershipCacheModel;
			}
		};

	private static CacheModel<EmpMembership> _nullEmpMembershipCacheModel = new CacheModel<EmpMembership>() {
			@Override
			public EmpMembership toEntityModel() {
				return _nullEmpMembership;
			}
		};
}