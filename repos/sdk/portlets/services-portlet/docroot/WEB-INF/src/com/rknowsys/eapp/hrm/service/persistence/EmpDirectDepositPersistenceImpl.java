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

import com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException;
import com.rknowsys.eapp.hrm.model.EmpDirectDeposit;
import com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp direct deposit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpDirectDepositPersistence
 * @see EmpDirectDepositUtil
 * @generated
 */
public class EmpDirectDepositPersistenceImpl extends BasePersistenceImpl<EmpDirectDeposit>
	implements EmpDirectDepositPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpDirectDepositUtil} to access the emp direct deposit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpDirectDepositImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpDirectDepositModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp direct deposits where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp direct deposits where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @return the range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp direct deposits where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByGroupId(long groupId, int start,
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

		List<EmpDirectDeposit> list = (List<EmpDirectDeposit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpDirectDeposit empDirectDeposit : list) {
				if ((groupId != empDirectDeposit.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPDIRECTDEPOSIT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDirectDeposit>(list);
				}
				else {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
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
	 * Returns the first emp direct deposit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the first emp direct deposit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpDirectDeposit> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpDirectDeposit> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp direct deposits before and after the current emp direct deposit in the ordered set where groupId = &#63;.
	 *
	 * @param empDirectDepositId the primary key of the current emp direct deposit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit[] findByGroupId_PrevAndNext(
		long empDirectDepositId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = findByPrimaryKey(empDirectDepositId);

		Session session = null;

		try {
			session = openSession();

			EmpDirectDeposit[] array = new EmpDirectDepositImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empDirectDeposit,
					groupId, orderByComparator, true);

			array[1] = empDirectDeposit;

			array[2] = getByGroupId_PrevAndNext(session, empDirectDeposit,
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

	protected EmpDirectDeposit getByGroupId_PrevAndNext(Session session,
		EmpDirectDeposit empDirectDeposit, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPDIRECTDEPOSIT_WHERE);

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
			query.append(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empDirectDeposit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpDirectDeposit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp direct deposits where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpDirectDeposit empDirectDeposit : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empDirectDeposit);
		}
	}

	/**
	 * Returns the number of emp direct deposits where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp direct deposits
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

			query.append(_SQL_COUNT_EMPDIRECTDEPOSIT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empDirectDeposit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID =
		new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempDirectDepositId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID =
		new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempDirectDepositId", new String[] { Long.class.getName() },
			EmpDirectDepositModelImpl.EMPDIRECTDEPOSITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPDIRECTDEPOSITID = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempDirectDepositId", new String[] { Long.class.getName() });

	/**
	 * Returns all the emp direct deposits where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @return the matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByempDirectDepositId(
		long empDirectDepositId) throws SystemException {
		return findByempDirectDepositId(empDirectDepositId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp direct deposits where empDirectDepositId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @return the range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByempDirectDepositId(
		long empDirectDepositId, int start, int end) throws SystemException {
		return findByempDirectDepositId(empDirectDepositId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp direct deposits where empDirectDepositId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByempDirectDepositId(
		long empDirectDepositId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID;
			finderArgs = new Object[] { empDirectDepositId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID;
			finderArgs = new Object[] {
					empDirectDepositId,
					
					start, end, orderByComparator
				};
		}

		List<EmpDirectDeposit> list = (List<EmpDirectDeposit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpDirectDeposit empDirectDeposit : list) {
				if ((empDirectDepositId != empDirectDeposit.getEmpDirectDepositId())) {
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

			query.append(_SQL_SELECT_EMPDIRECTDEPOSIT_WHERE);

			query.append(_FINDER_COLUMN_EMPDIRECTDEPOSITID_EMPDIRECTDEPOSITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empDirectDepositId);

				if (!pagination) {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDirectDeposit>(list);
				}
				else {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
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
	 * Returns the first emp direct deposit in the ordered set where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByempDirectDepositId_First(
		long empDirectDepositId, OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByempDirectDepositId_First(empDirectDepositId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empDirectDepositId=");
		msg.append(empDirectDepositId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the first emp direct deposit in the ordered set where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByempDirectDepositId_First(
		long empDirectDepositId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmpDirectDeposit> list = findByempDirectDepositId(empDirectDepositId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByempDirectDepositId_Last(
		long empDirectDepositId, OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByempDirectDepositId_Last(empDirectDepositId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empDirectDepositId=");
		msg.append(empDirectDepositId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByempDirectDepositId_Last(
		long empDirectDepositId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByempDirectDepositId(empDirectDepositId);

		if (count == 0) {
			return null;
		}

		List<EmpDirectDeposit> list = findByempDirectDepositId(empDirectDepositId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the emp direct deposits where empDirectDepositId = &#63; from the database.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempDirectDepositId(long empDirectDepositId)
		throws SystemException {
		for (EmpDirectDeposit empDirectDeposit : findByempDirectDepositId(
				empDirectDepositId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empDirectDeposit);
		}
	}

	/**
	 * Returns the number of emp direct deposits where empDirectDepositId = &#63;.
	 *
	 * @param empDirectDepositId the emp direct deposit ID
	 * @return the number of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempDirectDepositId(long empDirectDepositId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPDIRECTDEPOSITID;

		Object[] finderArgs = new Object[] { empDirectDepositId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPDIRECTDEPOSIT_WHERE);

			query.append(_FINDER_COLUMN_EMPDIRECTDEPOSITID_EMPDIRECTDEPOSITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empDirectDepositId);

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

	private static final String _FINDER_COLUMN_EMPDIRECTDEPOSITID_EMPDIRECTDEPOSITID_2 =
		"empDirectDeposit.empDirectDepositId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED,
			EmpDirectDepositImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpDirectDepositModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp direct deposits where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp direct deposits where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @return the range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp direct deposits where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findByemployeeId(long employeeId, int start,
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

		List<EmpDirectDeposit> list = (List<EmpDirectDeposit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpDirectDeposit empDirectDeposit : list) {
				if ((employeeId != empDirectDeposit.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPDIRECTDEPOSIT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDirectDeposit>(list);
				}
				else {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
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
	 * Returns the first emp direct deposit in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the first emp direct deposit in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpDirectDeposit> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empDirectDeposit != null) {
			return empDirectDeposit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpDirectDepositException(msg.toString());
	}

	/**
	 * Returns the last emp direct deposit in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp direct deposit, or <code>null</code> if a matching emp direct deposit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpDirectDeposit> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp direct deposits before and after the current emp direct deposit in the ordered set where employeeId = &#63;.
	 *
	 * @param empDirectDepositId the primary key of the current emp direct deposit
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit[] findByemployeeId_PrevAndNext(
		long empDirectDepositId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = findByPrimaryKey(empDirectDepositId);

		Session session = null;

		try {
			session = openSession();

			EmpDirectDeposit[] array = new EmpDirectDepositImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empDirectDeposit,
					employeeId, orderByComparator, true);

			array[1] = empDirectDeposit;

			array[2] = getByemployeeId_PrevAndNext(session, empDirectDeposit,
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

	protected EmpDirectDeposit getByemployeeId_PrevAndNext(Session session,
		EmpDirectDeposit empDirectDeposit, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPDIRECTDEPOSIT_WHERE);

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
			query.append(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empDirectDeposit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpDirectDeposit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp direct deposits where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpDirectDeposit empDirectDeposit : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empDirectDeposit);
		}
	}

	/**
	 * Returns the number of emp direct deposits where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp direct deposits
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

			query.append(_SQL_COUNT_EMPDIRECTDEPOSIT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empDirectDeposit.employeeId = ?";

	public EmpDirectDepositPersistenceImpl() {
		setModelClass(EmpDirectDeposit.class);
	}

	/**
	 * Caches the emp direct deposit in the entity cache if it is enabled.
	 *
	 * @param empDirectDeposit the emp direct deposit
	 */
	@Override
	public void cacheResult(EmpDirectDeposit empDirectDeposit) {
		EntityCacheUtil.putResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositImpl.class, empDirectDeposit.getPrimaryKey(),
			empDirectDeposit);

		empDirectDeposit.resetOriginalValues();
	}

	/**
	 * Caches the emp direct deposits in the entity cache if it is enabled.
	 *
	 * @param empDirectDeposits the emp direct deposits
	 */
	@Override
	public void cacheResult(List<EmpDirectDeposit> empDirectDeposits) {
		for (EmpDirectDeposit empDirectDeposit : empDirectDeposits) {
			if (EntityCacheUtil.getResult(
						EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
						EmpDirectDepositImpl.class,
						empDirectDeposit.getPrimaryKey()) == null) {
				cacheResult(empDirectDeposit);
			}
			else {
				empDirectDeposit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp direct deposits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpDirectDepositImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpDirectDepositImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp direct deposit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpDirectDeposit empDirectDeposit) {
		EntityCacheUtil.removeResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositImpl.class, empDirectDeposit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpDirectDeposit> empDirectDeposits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpDirectDeposit empDirectDeposit : empDirectDeposits) {
			EntityCacheUtil.removeResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
				EmpDirectDepositImpl.class, empDirectDeposit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp direct deposit with the primary key. Does not add the emp direct deposit to the database.
	 *
	 * @param empDirectDepositId the primary key for the new emp direct deposit
	 * @return the new emp direct deposit
	 */
	@Override
	public EmpDirectDeposit create(long empDirectDepositId) {
		EmpDirectDeposit empDirectDeposit = new EmpDirectDepositImpl();

		empDirectDeposit.setNew(true);
		empDirectDeposit.setPrimaryKey(empDirectDepositId);

		return empDirectDeposit;
	}

	/**
	 * Removes the emp direct deposit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empDirectDepositId the primary key of the emp direct deposit
	 * @return the emp direct deposit that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit remove(long empDirectDepositId)
		throws NoSuchEmpDirectDepositException, SystemException {
		return remove((Serializable)empDirectDepositId);
	}

	/**
	 * Removes the emp direct deposit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp direct deposit
	 * @return the emp direct deposit that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit remove(Serializable primaryKey)
		throws NoSuchEmpDirectDepositException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpDirectDeposit empDirectDeposit = (EmpDirectDeposit)session.get(EmpDirectDepositImpl.class,
					primaryKey);

			if (empDirectDeposit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpDirectDepositException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empDirectDeposit);
		}
		catch (NoSuchEmpDirectDepositException nsee) {
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
	protected EmpDirectDeposit removeImpl(EmpDirectDeposit empDirectDeposit)
		throws SystemException {
		empDirectDeposit = toUnwrappedModel(empDirectDeposit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empDirectDeposit)) {
				empDirectDeposit = (EmpDirectDeposit)session.get(EmpDirectDepositImpl.class,
						empDirectDeposit.getPrimaryKeyObj());
			}

			if (empDirectDeposit != null) {
				session.delete(empDirectDeposit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empDirectDeposit != null) {
			clearCache(empDirectDeposit);
		}

		return empDirectDeposit;
	}

	@Override
	public EmpDirectDeposit updateImpl(
		com.rknowsys.eapp.hrm.model.EmpDirectDeposit empDirectDeposit)
		throws SystemException {
		empDirectDeposit = toUnwrappedModel(empDirectDeposit);

		boolean isNew = empDirectDeposit.isNew();

		EmpDirectDepositModelImpl empDirectDepositModelImpl = (EmpDirectDepositModelImpl)empDirectDeposit;

		Session session = null;

		try {
			session = openSession();

			if (empDirectDeposit.isNew()) {
				session.save(empDirectDeposit);

				empDirectDeposit.setNew(false);
			}
			else {
				session.merge(empDirectDeposit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpDirectDepositModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empDirectDepositModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empDirectDepositModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empDirectDepositModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empDirectDepositModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empDirectDepositModelImpl.getOriginalEmpDirectDepositId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPDIRECTDEPOSITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID,
					args);

				args = new Object[] {
						empDirectDepositModelImpl.getEmpDirectDepositId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPDIRECTDEPOSITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPDIRECTDEPOSITID,
					args);
			}

			if ((empDirectDepositModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empDirectDepositModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empDirectDepositModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
			EmpDirectDepositImpl.class, empDirectDeposit.getPrimaryKey(),
			empDirectDeposit);

		return empDirectDeposit;
	}

	protected EmpDirectDeposit toUnwrappedModel(
		EmpDirectDeposit empDirectDeposit) {
		if (empDirectDeposit instanceof EmpDirectDepositImpl) {
			return empDirectDeposit;
		}

		EmpDirectDepositImpl empDirectDepositImpl = new EmpDirectDepositImpl();

		empDirectDepositImpl.setNew(empDirectDeposit.isNew());
		empDirectDepositImpl.setPrimaryKey(empDirectDeposit.getPrimaryKey());

		empDirectDepositImpl.setEmpDirectDepositId(empDirectDeposit.getEmpDirectDepositId());
		empDirectDepositImpl.setEmployeeId(empDirectDeposit.getEmployeeId());
		empDirectDepositImpl.setGroupId(empDirectDeposit.getGroupId());
		empDirectDepositImpl.setCompanyId(empDirectDeposit.getCompanyId());
		empDirectDepositImpl.setCreateDate(empDirectDeposit.getCreateDate());
		empDirectDepositImpl.setModifiedDate(empDirectDeposit.getModifiedDate());
		empDirectDepositImpl.setUserId(empDirectDeposit.getUserId());
		empDirectDepositImpl.setAmount(empDirectDeposit.getAmount());
		empDirectDepositImpl.setAccountNumber(empDirectDeposit.getAccountNumber());
		empDirectDepositImpl.setBankName(empDirectDeposit.getBankName());
		empDirectDepositImpl.setAccountType(empDirectDeposit.getAccountType());
		empDirectDepositImpl.setBranchLocation(empDirectDeposit.getBranchLocation());
		empDirectDepositImpl.setRoutingNumber(empDirectDeposit.getRoutingNumber());

		return empDirectDepositImpl;
	}

	/**
	 * Returns the emp direct deposit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp direct deposit
	 * @return the emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpDirectDepositException, SystemException {
		EmpDirectDeposit empDirectDeposit = fetchByPrimaryKey(primaryKey);

		if (empDirectDeposit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpDirectDepositException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empDirectDeposit;
	}

	/**
	 * Returns the emp direct deposit with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException} if it could not be found.
	 *
	 * @param empDirectDepositId the primary key of the emp direct deposit
	 * @return the emp direct deposit
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDirectDepositException if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit findByPrimaryKey(long empDirectDepositId)
		throws NoSuchEmpDirectDepositException, SystemException {
		return findByPrimaryKey((Serializable)empDirectDepositId);
	}

	/**
	 * Returns the emp direct deposit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp direct deposit
	 * @return the emp direct deposit, or <code>null</code> if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpDirectDeposit empDirectDeposit = (EmpDirectDeposit)EntityCacheUtil.getResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
				EmpDirectDepositImpl.class, primaryKey);

		if (empDirectDeposit == _nullEmpDirectDeposit) {
			return null;
		}

		if (empDirectDeposit == null) {
			Session session = null;

			try {
				session = openSession();

				empDirectDeposit = (EmpDirectDeposit)session.get(EmpDirectDepositImpl.class,
						primaryKey);

				if (empDirectDeposit != null) {
					cacheResult(empDirectDeposit);
				}
				else {
					EntityCacheUtil.putResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
						EmpDirectDepositImpl.class, primaryKey,
						_nullEmpDirectDeposit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpDirectDepositModelImpl.ENTITY_CACHE_ENABLED,
					EmpDirectDepositImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empDirectDeposit;
	}

	/**
	 * Returns the emp direct deposit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empDirectDepositId the primary key of the emp direct deposit
	 * @return the emp direct deposit, or <code>null</code> if a emp direct deposit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDirectDeposit fetchByPrimaryKey(long empDirectDepositId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empDirectDepositId);
	}

	/**
	 * Returns all the emp direct deposits.
	 *
	 * @return the emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp direct deposits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @return the range of emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp direct deposits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDirectDepositModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp direct deposits
	 * @param end the upper bound of the range of emp direct deposits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp direct deposits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDirectDeposit> findAll(int start, int end,
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

		List<EmpDirectDeposit> list = (List<EmpDirectDeposit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPDIRECTDEPOSIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPDIRECTDEPOSIT;

				if (pagination) {
					sql = sql.concat(EmpDirectDepositModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDirectDeposit>(list);
				}
				else {
					list = (List<EmpDirectDeposit>)QueryUtil.list(q,
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
	 * Removes all the emp direct deposits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpDirectDeposit empDirectDeposit : findAll()) {
			remove(empDirectDeposit);
		}
	}

	/**
	 * Returns the number of emp direct deposits.
	 *
	 * @return the number of emp direct deposits
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

				Query q = session.createQuery(_SQL_COUNT_EMPDIRECTDEPOSIT);

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
	 * Initializes the emp direct deposit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpDirectDeposit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpDirectDeposit>> listenersList = new ArrayList<ModelListener<EmpDirectDeposit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpDirectDeposit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpDirectDepositImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPDIRECTDEPOSIT = "SELECT empDirectDeposit FROM EmpDirectDeposit empDirectDeposit";
	private static final String _SQL_SELECT_EMPDIRECTDEPOSIT_WHERE = "SELECT empDirectDeposit FROM EmpDirectDeposit empDirectDeposit WHERE ";
	private static final String _SQL_COUNT_EMPDIRECTDEPOSIT = "SELECT COUNT(empDirectDeposit) FROM EmpDirectDeposit empDirectDeposit";
	private static final String _SQL_COUNT_EMPDIRECTDEPOSIT_WHERE = "SELECT COUNT(empDirectDeposit) FROM EmpDirectDeposit empDirectDeposit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empDirectDeposit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpDirectDeposit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpDirectDeposit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpDirectDepositPersistenceImpl.class);
	private static EmpDirectDeposit _nullEmpDirectDeposit = new EmpDirectDepositImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpDirectDeposit> toCacheModel() {
				return _nullEmpDirectDepositCacheModel;
			}
		};

	private static CacheModel<EmpDirectDeposit> _nullEmpDirectDepositCacheModel = new CacheModel<EmpDirectDeposit>() {
			@Override
			public EmpDirectDeposit toEntityModel() {
				return _nullEmpDirectDeposit;
			}
		};
}