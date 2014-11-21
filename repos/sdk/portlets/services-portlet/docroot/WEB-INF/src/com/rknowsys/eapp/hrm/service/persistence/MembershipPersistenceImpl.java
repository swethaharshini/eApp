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

import com.rknowsys.eapp.hrm.NoSuchMembershipException;
import com.rknowsys.eapp.hrm.model.Membership;
import com.rknowsys.eapp.hrm.model.impl.MembershipImpl;
import com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see MembershipPersistence
 * @see MembershipUtil
 * @generated
 */
public class MembershipPersistenceImpl extends BasePersistenceImpl<Membership>
	implements MembershipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipUtil} to access the membership persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			MembershipModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the memberships where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memberships where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @return the range of matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memberships where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findByGroupId(long groupId, int start, int end,
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

		List<Membership> list = (List<Membership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Membership membership : list) {
				if ((groupId != membership.getGroupId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Membership>(list);
				}
				else {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipException, SystemException {
		Membership membership = fetchByGroupId_First(groupId, orderByComparator);

		if (membership != null) {
			return membership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipException(msg.toString());
	}

	/**
	 * Returns the first membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership, or <code>null</code> if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Membership> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipException, SystemException {
		Membership membership = fetchByGroupId_Last(groupId, orderByComparator);

		if (membership != null) {
			return membership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipException(msg.toString());
	}

	/**
	 * Returns the last membership in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership, or <code>null</code> if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Membership> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the memberships before and after the current membership in the ordered set where groupId = &#63;.
	 *
	 * @param membershipId the primary key of the current membership
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership[] findByGroupId_PrevAndNext(long membershipId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMembershipException, SystemException {
		Membership membership = findByPrimaryKey(membershipId);

		Session session = null;

		try {
			session = openSession();

			Membership[] array = new MembershipImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, membership, groupId,
					orderByComparator, true);

			array[1] = membership;

			array[2] = getByGroupId_PrevAndNext(session, membership, groupId,
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

	protected Membership getByGroupId_PrevAndNext(Session session,
		Membership membership, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIP_WHERE);

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
			query.append(MembershipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Membership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the memberships where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Membership membership : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(membership);
		}
	}

	/**
	 * Returns the number of memberships where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching memberships
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

			query.append(_SQL_COUNT_MEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "membership.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPID =
		new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymembershipId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID =
		new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, MembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymembershipId",
			new String[] { Long.class.getName() },
			MembershipModelImpl.MEMBERSHIPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPID = new FinderPath(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymembershipId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the memberships where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @return the matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findBymembershipId(long membershipId)
		throws SystemException {
		return findBymembershipId(membershipId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memberships where membershipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param membershipId the membership ID
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @return the range of matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findBymembershipId(long membershipId, int start,
		int end) throws SystemException {
		return findBymembershipId(membershipId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the memberships where membershipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param membershipId the membership ID
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findBymembershipId(long membershipId, int start,
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

		List<Membership> list = (List<Membership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Membership membership : list) {
				if ((membershipId != membership.getMembershipId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(membershipId);

				if (!pagination) {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Membership>(list);
				}
				else {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findBymembershipId_First(long membershipId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipException, SystemException {
		Membership membership = fetchBymembershipId_First(membershipId,
				orderByComparator);

		if (membership != null) {
			return membership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipId=");
		msg.append(membershipId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipException(msg.toString());
	}

	/**
	 * Returns the first membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership, or <code>null</code> if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchBymembershipId_First(long membershipId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Membership> list = findBymembershipId(membershipId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findBymembershipId_Last(long membershipId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipException, SystemException {
		Membership membership = fetchBymembershipId_Last(membershipId,
				orderByComparator);

		if (membership != null) {
			return membership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipId=");
		msg.append(membershipId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipException(msg.toString());
	}

	/**
	 * Returns the last membership in the ordered set where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership, or <code>null</code> if a matching membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchBymembershipId_Last(long membershipId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymembershipId(membershipId);

		if (count == 0) {
			return null;
		}

		List<Membership> list = findBymembershipId(membershipId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the memberships where membershipId = &#63; from the database.
	 *
	 * @param membershipId the membership ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymembershipId(long membershipId)
		throws SystemException {
		for (Membership membership : findBymembershipId(membershipId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membership);
		}
	}

	/**
	 * Returns the number of memberships where membershipId = &#63;.
	 *
	 * @param membershipId the membership ID
	 * @return the number of matching memberships
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

			query.append(_SQL_COUNT_MEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPID_MEMBERSHIPID_2 = "membership.membershipId = ?";

	public MembershipPersistenceImpl() {
		setModelClass(Membership.class);
	}

	/**
	 * Caches the membership in the entity cache if it is enabled.
	 *
	 * @param membership the membership
	 */
	@Override
	public void cacheResult(Membership membership) {
		EntityCacheUtil.putResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipImpl.class, membership.getPrimaryKey(), membership);

		membership.resetOriginalValues();
	}

	/**
	 * Caches the memberships in the entity cache if it is enabled.
	 *
	 * @param memberships the memberships
	 */
	@Override
	public void cacheResult(List<Membership> memberships) {
		for (Membership membership : memberships) {
			if (EntityCacheUtil.getResult(
						MembershipModelImpl.ENTITY_CACHE_ENABLED,
						MembershipImpl.class, membership.getPrimaryKey()) == null) {
				cacheResult(membership);
			}
			else {
				membership.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all memberships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Membership membership) {
		EntityCacheUtil.removeResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipImpl.class, membership.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Membership> memberships) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Membership membership : memberships) {
			EntityCacheUtil.removeResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
				MembershipImpl.class, membership.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership with the primary key. Does not add the membership to the database.
	 *
	 * @param membershipId the primary key for the new membership
	 * @return the new membership
	 */
	@Override
	public Membership create(long membershipId) {
		Membership membership = new MembershipImpl();

		membership.setNew(true);
		membership.setPrimaryKey(membershipId);

		return membership;
	}

	/**
	 * Removes the membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param membershipId the primary key of the membership
	 * @return the membership that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership remove(long membershipId)
		throws NoSuchMembershipException, SystemException {
		return remove((Serializable)membershipId);
	}

	/**
	 * Removes the membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership
	 * @return the membership that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership remove(Serializable primaryKey)
		throws NoSuchMembershipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Membership membership = (Membership)session.get(MembershipImpl.class,
					primaryKey);

			if (membership == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membership);
		}
		catch (NoSuchMembershipException nsee) {
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
	protected Membership removeImpl(Membership membership)
		throws SystemException {
		membership = toUnwrappedModel(membership);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membership)) {
				membership = (Membership)session.get(MembershipImpl.class,
						membership.getPrimaryKeyObj());
			}

			if (membership != null) {
				session.delete(membership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membership != null) {
			clearCache(membership);
		}

		return membership;
	}

	@Override
	public Membership updateImpl(
		com.rknowsys.eapp.hrm.model.Membership membership)
		throws SystemException {
		membership = toUnwrappedModel(membership);

		boolean isNew = membership.isNew();

		MembershipModelImpl membershipModelImpl = (MembershipModelImpl)membership;

		Session session = null;

		try {
			session = openSession();

			if (membership.isNew()) {
				session.save(membership);

				membership.setNew(false);
			}
			else {
				session.merge(membership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MembershipModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { membershipModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((membershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipModelImpl.getOriginalMembershipId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID,
					args);

				args = new Object[] { membershipModelImpl.getMembershipId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
			MembershipImpl.class, membership.getPrimaryKey(), membership);

		return membership;
	}

	protected Membership toUnwrappedModel(Membership membership) {
		if (membership instanceof MembershipImpl) {
			return membership;
		}

		MembershipImpl membershipImpl = new MembershipImpl();

		membershipImpl.setNew(membership.isNew());
		membershipImpl.setPrimaryKey(membership.getPrimaryKey());

		membershipImpl.setMembershipId(membership.getMembershipId());
		membershipImpl.setCompanyId(membership.getCompanyId());
		membershipImpl.setGroupId(membership.getGroupId());
		membershipImpl.setCreateDate(membership.getCreateDate());
		membershipImpl.setModifiedDate(membership.getModifiedDate());
		membershipImpl.setUserId(membership.getUserId());
		membershipImpl.setMembershipName(membership.getMembershipName());

		return membershipImpl;
	}

	/**
	 * Returns the membership with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership
	 * @return the membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMembershipException, SystemException {
		Membership membership = fetchByPrimaryKey(primaryKey);

		if (membership == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membership;
	}

	/**
	 * Returns the membership with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchMembershipException} if it could not be found.
	 *
	 * @param membershipId the primary key of the membership
	 * @return the membership
	 * @throws com.rknowsys.eapp.hrm.NoSuchMembershipException if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership findByPrimaryKey(long membershipId)
		throws NoSuchMembershipException, SystemException {
		return findByPrimaryKey((Serializable)membershipId);
	}

	/**
	 * Returns the membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership
	 * @return the membership, or <code>null</code> if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Membership membership = (Membership)EntityCacheUtil.getResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
				MembershipImpl.class, primaryKey);

		if (membership == _nullMembership) {
			return null;
		}

		if (membership == null) {
			Session session = null;

			try {
				session = openSession();

				membership = (Membership)session.get(MembershipImpl.class,
						primaryKey);

				if (membership != null) {
					cacheResult(membership);
				}
				else {
					EntityCacheUtil.putResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
						MembershipImpl.class, primaryKey, _nullMembership);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipModelImpl.ENTITY_CACHE_ENABLED,
					MembershipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membership;
	}

	/**
	 * Returns the membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param membershipId the primary key of the membership
	 * @return the membership, or <code>null</code> if a membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Membership fetchByPrimaryKey(long membershipId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)membershipId);
	}

	/**
	 * Returns all the memberships.
	 *
	 * @return the memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @return the range of memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.MembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberships
	 * @param end the upper bound of the range of memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Membership> findAll(int start, int end,
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

		List<Membership> list = (List<Membership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIP;

				if (pagination) {
					sql = sql.concat(MembershipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Membership>(list);
				}
				else {
					list = (List<Membership>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the memberships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Membership membership : findAll()) {
			remove(membership);
		}
	}

	/**
	 * Returns the number of memberships.
	 *
	 * @return the number of memberships
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIP);

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
	 * Initializes the membership persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Membership")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Membership>> listenersList = new ArrayList<ModelListener<Membership>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Membership>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIP = "SELECT membership FROM Membership membership";
	private static final String _SQL_SELECT_MEMBERSHIP_WHERE = "SELECT membership FROM Membership membership WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIP = "SELECT COUNT(membership) FROM Membership membership";
	private static final String _SQL_COUNT_MEMBERSHIP_WHERE = "SELECT COUNT(membership) FROM Membership membership WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membership.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Membership exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Membership exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPersistenceImpl.class);
	private static Membership _nullMembership = new MembershipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Membership> toCacheModel() {
				return _nullMembershipCacheModel;
			}
		};

	private static CacheModel<Membership> _nullMembershipCacheModel = new CacheModel<Membership>() {
			@Override
			public Membership toEntityModel() {
				return _nullMembership;
			}
		};
}