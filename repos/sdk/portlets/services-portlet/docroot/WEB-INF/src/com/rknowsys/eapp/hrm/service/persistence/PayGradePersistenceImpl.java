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

import com.rknowsys.eapp.hrm.NoSuchPayGradeException;
import com.rknowsys.eapp.hrm.model.PayGrade;
import com.rknowsys.eapp.hrm.model.impl.PayGradeImpl;
import com.rknowsys.eapp.hrm.model.impl.PayGradeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the pay grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see PayGradePersistence
 * @see PayGradeUtil
 * @generated
 */
public class PayGradePersistenceImpl extends BasePersistenceImpl<PayGrade>
	implements PayGradePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayGradeUtil} to access the pay grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayGradeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, PayGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, PayGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, PayGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, PayGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PayGradeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the pay grades where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay grades where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pay grades
	 * @param end the upper bound of the range of pay grades (not inclusive)
	 * @return the range of matching pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay grades where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pay grades
	 * @param end the upper bound of the range of pay grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findByGroupId(long groupId, int start, int end,
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

		List<PayGrade> list = (List<PayGrade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PayGrade payGrade : list) {
				if ((groupId != payGrade.getGroupId())) {
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

			query.append(_SQL_SELECT_PAYGRADE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayGradeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PayGrade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PayGrade>(list);
				}
				else {
					list = (List<PayGrade>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay grade in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay grade
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a matching pay grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeException, SystemException {
		PayGrade payGrade = fetchByGroupId_First(groupId, orderByComparator);

		if (payGrade != null) {
			return payGrade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayGradeException(msg.toString());
	}

	/**
	 * Returns the first pay grade in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay grade, or <code>null</code> if a matching pay grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PayGrade> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay grade in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay grade
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a matching pay grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeException, SystemException {
		PayGrade payGrade = fetchByGroupId_Last(groupId, orderByComparator);

		if (payGrade != null) {
			return payGrade;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayGradeException(msg.toString());
	}

	/**
	 * Returns the last pay grade in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay grade, or <code>null</code> if a matching pay grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PayGrade> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pay grades before and after the current pay grade in the ordered set where groupId = &#63;.
	 *
	 * @param payGradeId the primary key of the current pay grade
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pay grade
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade[] findByGroupId_PrevAndNext(long payGradeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeException, SystemException {
		PayGrade payGrade = findByPrimaryKey(payGradeId);

		Session session = null;

		try {
			session = openSession();

			PayGrade[] array = new PayGradeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, payGrade, groupId,
					orderByComparator, true);

			array[1] = payGrade;

			array[2] = getByGroupId_PrevAndNext(session, payGrade, groupId,
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

	protected PayGrade getByGroupId_PrevAndNext(Session session,
		PayGrade payGrade, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYGRADE_WHERE);

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
			query.append(PayGradeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payGrade);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayGrade> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pay grades where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (PayGrade payGrade : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payGrade);
		}
	}

	/**
	 * Returns the number of pay grades where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pay grades
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

			query.append(_SQL_COUNT_PAYGRADE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "payGrade.groupId = ?";

	public PayGradePersistenceImpl() {
		setModelClass(PayGrade.class);
	}

	/**
	 * Caches the pay grade in the entity cache if it is enabled.
	 *
	 * @param payGrade the pay grade
	 */
	@Override
	public void cacheResult(PayGrade payGrade) {
		EntityCacheUtil.putResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeImpl.class, payGrade.getPrimaryKey(), payGrade);

		payGrade.resetOriginalValues();
	}

	/**
	 * Caches the pay grades in the entity cache if it is enabled.
	 *
	 * @param payGrades the pay grades
	 */
	@Override
	public void cacheResult(List<PayGrade> payGrades) {
		for (PayGrade payGrade : payGrades) {
			if (EntityCacheUtil.getResult(
						PayGradeModelImpl.ENTITY_CACHE_ENABLED,
						PayGradeImpl.class, payGrade.getPrimaryKey()) == null) {
				cacheResult(payGrade);
			}
			else {
				payGrade.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pay grades.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PayGradeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PayGradeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay grade.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayGrade payGrade) {
		EntityCacheUtil.removeResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeImpl.class, payGrade.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PayGrade> payGrades) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayGrade payGrade : payGrades) {
			EntityCacheUtil.removeResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
				PayGradeImpl.class, payGrade.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pay grade with the primary key. Does not add the pay grade to the database.
	 *
	 * @param payGradeId the primary key for the new pay grade
	 * @return the new pay grade
	 */
	@Override
	public PayGrade create(long payGradeId) {
		PayGrade payGrade = new PayGradeImpl();

		payGrade.setNew(true);
		payGrade.setPrimaryKey(payGradeId);

		return payGrade;
	}

	/**
	 * Removes the pay grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payGradeId the primary key of the pay grade
	 * @return the pay grade that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade remove(long payGradeId)
		throws NoSuchPayGradeException, SystemException {
		return remove((Serializable)payGradeId);
	}

	/**
	 * Removes the pay grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay grade
	 * @return the pay grade that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade remove(Serializable primaryKey)
		throws NoSuchPayGradeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PayGrade payGrade = (PayGrade)session.get(PayGradeImpl.class,
					primaryKey);

			if (payGrade == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayGradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payGrade);
		}
		catch (NoSuchPayGradeException nsee) {
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
	protected PayGrade removeImpl(PayGrade payGrade) throws SystemException {
		payGrade = toUnwrappedModel(payGrade);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payGrade)) {
				payGrade = (PayGrade)session.get(PayGradeImpl.class,
						payGrade.getPrimaryKeyObj());
			}

			if (payGrade != null) {
				session.delete(payGrade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payGrade != null) {
			clearCache(payGrade);
		}

		return payGrade;
	}

	@Override
	public PayGrade updateImpl(com.rknowsys.eapp.hrm.model.PayGrade payGrade)
		throws SystemException {
		payGrade = toUnwrappedModel(payGrade);

		boolean isNew = payGrade.isNew();

		PayGradeModelImpl payGradeModelImpl = (PayGradeModelImpl)payGrade;

		Session session = null;

		try {
			session = openSession();

			if (payGrade.isNew()) {
				session.save(payGrade);

				payGrade.setNew(false);
			}
			else {
				session.merge(payGrade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PayGradeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((payGradeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payGradeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { payGradeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeImpl.class, payGrade.getPrimaryKey(), payGrade);

		return payGrade;
	}

	protected PayGrade toUnwrappedModel(PayGrade payGrade) {
		if (payGrade instanceof PayGradeImpl) {
			return payGrade;
		}

		PayGradeImpl payGradeImpl = new PayGradeImpl();

		payGradeImpl.setNew(payGrade.isNew());
		payGradeImpl.setPrimaryKey(payGrade.getPrimaryKey());

		payGradeImpl.setPayGradeId(payGrade.getPayGradeId());
		payGradeImpl.setCompanyId(payGrade.getCompanyId());
		payGradeImpl.setGroupId(payGrade.getGroupId());
		payGradeImpl.setCreateDate(payGrade.getCreateDate());
		payGradeImpl.setModifiedDate(payGrade.getModifiedDate());
		payGradeImpl.setUserId(payGrade.getUserId());
		payGradeImpl.setPayGradeName(payGrade.getPayGradeName());

		return payGradeImpl;
	}

	/**
	 * Returns the pay grade with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay grade
	 * @return the pay grade
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayGradeException, SystemException {
		PayGrade payGrade = fetchByPrimaryKey(primaryKey);

		if (payGrade == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayGradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payGrade;
	}

	/**
	 * Returns the pay grade with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchPayGradeException} if it could not be found.
	 *
	 * @param payGradeId the primary key of the pay grade
	 * @return the pay grade
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeException if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade findByPrimaryKey(long payGradeId)
		throws NoSuchPayGradeException, SystemException {
		return findByPrimaryKey((Serializable)payGradeId);
	}

	/**
	 * Returns the pay grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay grade
	 * @return the pay grade, or <code>null</code> if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PayGrade payGrade = (PayGrade)EntityCacheUtil.getResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
				PayGradeImpl.class, primaryKey);

		if (payGrade == _nullPayGrade) {
			return null;
		}

		if (payGrade == null) {
			Session session = null;

			try {
				session = openSession();

				payGrade = (PayGrade)session.get(PayGradeImpl.class, primaryKey);

				if (payGrade != null) {
					cacheResult(payGrade);
				}
				else {
					EntityCacheUtil.putResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
						PayGradeImpl.class, primaryKey, _nullPayGrade);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PayGradeModelImpl.ENTITY_CACHE_ENABLED,
					PayGradeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payGrade;
	}

	/**
	 * Returns the pay grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payGradeId the primary key of the pay grade
	 * @return the pay grade, or <code>null</code> if a pay grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGrade fetchByPrimaryKey(long payGradeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)payGradeId);
	}

	/**
	 * Returns all the pay grades.
	 *
	 * @return the pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay grades
	 * @param end the upper bound of the range of pay grades (not inclusive)
	 * @return the range of pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay grades
	 * @param end the upper bound of the range of pay grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGrade> findAll(int start, int end,
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

		List<PayGrade> list = (List<PayGrade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PAYGRADE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYGRADE;

				if (pagination) {
					sql = sql.concat(PayGradeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayGrade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PayGrade>(list);
				}
				else {
					list = (List<PayGrade>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the pay grades from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PayGrade payGrade : findAll()) {
			remove(payGrade);
		}
	}

	/**
	 * Returns the number of pay grades.
	 *
	 * @return the number of pay grades
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

				Query q = session.createQuery(_SQL_COUNT_PAYGRADE);

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
	 * Initializes the pay grade persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.PayGrade")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PayGrade>> listenersList = new ArrayList<ModelListener<PayGrade>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PayGrade>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PayGradeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PAYGRADE = "SELECT payGrade FROM PayGrade payGrade";
	private static final String _SQL_SELECT_PAYGRADE_WHERE = "SELECT payGrade FROM PayGrade payGrade WHERE ";
	private static final String _SQL_COUNT_PAYGRADE = "SELECT COUNT(payGrade) FROM PayGrade payGrade";
	private static final String _SQL_COUNT_PAYGRADE_WHERE = "SELECT COUNT(payGrade) FROM PayGrade payGrade WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payGrade.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayGrade exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayGrade exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PayGradePersistenceImpl.class);
	private static PayGrade _nullPayGrade = new PayGradeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PayGrade> toCacheModel() {
				return _nullPayGradeCacheModel;
			}
		};

	private static CacheModel<PayGrade> _nullPayGradeCacheModel = new CacheModel<PayGrade>() {
			@Override
			public PayGrade toEntityModel() {
				return _nullPayGrade;
			}
		};
}