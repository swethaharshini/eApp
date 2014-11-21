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

import com.rknowsys.eapp.hrm.NoSuchWorkWeekException;
import com.rknowsys.eapp.hrm.model.WorkWeek;
import com.rknowsys.eapp.hrm.model.impl.WorkWeekImpl;
import com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the WorkWeek service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkWeekPersistence
 * @see WorkWeekUtil
 * @generated
 */
public class WorkWeekPersistenceImpl extends BasePersistenceImpl<WorkWeek>
	implements WorkWeekPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkWeekUtil} to access the WorkWeek persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkWeekImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, WorkWeekImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, WorkWeekImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONALITY =
		new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, WorkWeekImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNationality",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITY =
		new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, WorkWeekImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNationality",
			new String[] { Long.class.getName() },
			WorkWeekModelImpl.NATIONALITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NATIONALITY = new FinderPath(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationality",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the WorkWeeks where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @return the matching WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findByNationality(long nationalityId)
		throws SystemException {
		return findByNationality(nationalityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WorkWeeks where nationalityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nationalityId the nationality ID
	 * @param start the lower bound of the range of WorkWeeks
	 * @param end the upper bound of the range of WorkWeeks (not inclusive)
	 * @return the range of matching WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findByNationality(long nationalityId, int start,
		int end) throws SystemException {
		return findByNationality(nationalityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the WorkWeeks where nationalityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nationalityId the nationality ID
	 * @param start the lower bound of the range of WorkWeeks
	 * @param end the upper bound of the range of WorkWeeks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findByNationality(long nationalityId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITY;
			finderArgs = new Object[] { nationalityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONALITY;
			finderArgs = new Object[] {
					nationalityId,
					
					start, end, orderByComparator
				};
		}

		List<WorkWeek> list = (List<WorkWeek>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkWeek workWeek : list) {
				if ((nationalityId != workWeek.getNationalityId())) {
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

			query.append(_SQL_SELECT_WORKWEEK_WHERE);

			query.append(_FINDER_COLUMN_NATIONALITY_NATIONALITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkWeekModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nationalityId);

				if (!pagination) {
					list = (List<WorkWeek>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkWeek>(list);
				}
				else {
					list = (List<WorkWeek>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkWeek
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek findByNationality_First(long nationalityId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkWeekException, SystemException {
		WorkWeek workWeek = fetchByNationality_First(nationalityId,
				orderByComparator);

		if (workWeek != null) {
			return workWeek;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nationalityId=");
		msg.append(nationalityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkWeekException(msg.toString());
	}

	/**
	 * Returns the first WorkWeek in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek fetchByNationality_First(long nationalityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkWeek> list = findByNationality(nationalityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkWeek
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a matching WorkWeek could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek findByNationality_Last(long nationalityId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkWeekException, SystemException {
		WorkWeek workWeek = fetchByNationality_Last(nationalityId,
				orderByComparator);

		if (workWeek != null) {
			return workWeek;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nationalityId=");
		msg.append(nationalityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkWeekException(msg.toString());
	}

	/**
	 * Returns the last WorkWeek in the ordered set where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkWeek, or <code>null</code> if a matching WorkWeek could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek fetchByNationality_Last(long nationalityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNationality(nationalityId);

		if (count == 0) {
			return null;
		}

		List<WorkWeek> list = findByNationality(nationalityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the WorkWeeks before and after the current WorkWeek in the ordered set where nationalityId = &#63;.
	 *
	 * @param workWeekId the primary key of the current WorkWeek
	 * @param nationalityId the nationality ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next WorkWeek
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek[] findByNationality_PrevAndNext(long workWeekId,
		long nationalityId, OrderByComparator orderByComparator)
		throws NoSuchWorkWeekException, SystemException {
		WorkWeek workWeek = findByPrimaryKey(workWeekId);

		Session session = null;

		try {
			session = openSession();

			WorkWeek[] array = new WorkWeekImpl[3];

			array[0] = getByNationality_PrevAndNext(session, workWeek,
					nationalityId, orderByComparator, true);

			array[1] = workWeek;

			array[2] = getByNationality_PrevAndNext(session, workWeek,
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

	protected WorkWeek getByNationality_PrevAndNext(Session session,
		WorkWeek workWeek, long nationalityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKWEEK_WHERE);

		query.append(_FINDER_COLUMN_NATIONALITY_NATIONALITYID_2);

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
			query.append(WorkWeekModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nationalityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workWeek);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkWeek> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WorkWeeks where nationalityId = &#63; from the database.
	 *
	 * @param nationalityId the nationality ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNationality(long nationalityId)
		throws SystemException {
		for (WorkWeek workWeek : findByNationality(nationalityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workWeek);
		}
	}

	/**
	 * Returns the number of WorkWeeks where nationalityId = &#63;.
	 *
	 * @param nationalityId the nationality ID
	 * @return the number of matching WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNationality(long nationalityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NATIONALITY;

		Object[] finderArgs = new Object[] { nationalityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKWEEK_WHERE);

			query.append(_FINDER_COLUMN_NATIONALITY_NATIONALITYID_2);

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

	private static final String _FINDER_COLUMN_NATIONALITY_NATIONALITYID_2 = "workWeek.nationalityId = ?";

	public WorkWeekPersistenceImpl() {
		setModelClass(WorkWeek.class);
	}

	/**
	 * Caches the WorkWeek in the entity cache if it is enabled.
	 *
	 * @param workWeek the WorkWeek
	 */
	@Override
	public void cacheResult(WorkWeek workWeek) {
		EntityCacheUtil.putResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekImpl.class, workWeek.getPrimaryKey(), workWeek);

		workWeek.resetOriginalValues();
	}

	/**
	 * Caches the WorkWeeks in the entity cache if it is enabled.
	 *
	 * @param workWeeks the WorkWeeks
	 */
	@Override
	public void cacheResult(List<WorkWeek> workWeeks) {
		for (WorkWeek workWeek : workWeeks) {
			if (EntityCacheUtil.getResult(
						WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
						WorkWeekImpl.class, workWeek.getPrimaryKey()) == null) {
				cacheResult(workWeek);
			}
			else {
				workWeek.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WorkWeeks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkWeekImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkWeekImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WorkWeek.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkWeek workWeek) {
		EntityCacheUtil.removeResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekImpl.class, workWeek.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkWeek> workWeeks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkWeek workWeek : workWeeks) {
			EntityCacheUtil.removeResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
				WorkWeekImpl.class, workWeek.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WorkWeek with the primary key. Does not add the WorkWeek to the database.
	 *
	 * @param workWeekId the primary key for the new WorkWeek
	 * @return the new WorkWeek
	 */
	@Override
	public WorkWeek create(long workWeekId) {
		WorkWeek workWeek = new WorkWeekImpl();

		workWeek.setNew(true);
		workWeek.setPrimaryKey(workWeekId);

		return workWeek;
	}

	/**
	 * Removes the WorkWeek with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workWeekId the primary key of the WorkWeek
	 * @return the WorkWeek that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek remove(long workWeekId)
		throws NoSuchWorkWeekException, SystemException {
		return remove((Serializable)workWeekId);
	}

	/**
	 * Removes the WorkWeek with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WorkWeek
	 * @return the WorkWeek that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek remove(Serializable primaryKey)
		throws NoSuchWorkWeekException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkWeek workWeek = (WorkWeek)session.get(WorkWeekImpl.class,
					primaryKey);

			if (workWeek == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkWeekException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workWeek);
		}
		catch (NoSuchWorkWeekException nsee) {
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
	protected WorkWeek removeImpl(WorkWeek workWeek) throws SystemException {
		workWeek = toUnwrappedModel(workWeek);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workWeek)) {
				workWeek = (WorkWeek)session.get(WorkWeekImpl.class,
						workWeek.getPrimaryKeyObj());
			}

			if (workWeek != null) {
				session.delete(workWeek);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workWeek != null) {
			clearCache(workWeek);
		}

		return workWeek;
	}

	@Override
	public WorkWeek updateImpl(com.rknowsys.eapp.hrm.model.WorkWeek workWeek)
		throws SystemException {
		workWeek = toUnwrappedModel(workWeek);

		boolean isNew = workWeek.isNew();

		WorkWeekModelImpl workWeekModelImpl = (WorkWeekModelImpl)workWeek;

		Session session = null;

		try {
			session = openSession();

			if (workWeek.isNew()) {
				session.save(workWeek);

				workWeek.setNew(false);
			}
			else {
				session.merge(workWeek);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkWeekModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workWeekModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workWeekModelImpl.getOriginalNationalityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONALITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITY,
					args);

				args = new Object[] { workWeekModelImpl.getNationalityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONALITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONALITY,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
			WorkWeekImpl.class, workWeek.getPrimaryKey(), workWeek);

		return workWeek;
	}

	protected WorkWeek toUnwrappedModel(WorkWeek workWeek) {
		if (workWeek instanceof WorkWeekImpl) {
			return workWeek;
		}

		WorkWeekImpl workWeekImpl = new WorkWeekImpl();

		workWeekImpl.setNew(workWeek.isNew());
		workWeekImpl.setPrimaryKey(workWeek.getPrimaryKey());

		workWeekImpl.setWorkWeekId(workWeek.getWorkWeekId());
		workWeekImpl.setNationalityId(workWeek.getNationalityId());
		workWeekImpl.setMondayWorkSchedule(workWeek.getMondayWorkSchedule());
		workWeekImpl.setTuesdayWorkSchedule(workWeek.getTuesdayWorkSchedule());
		workWeekImpl.setWednesdayWorkSchedule(workWeek.getWednesdayWorkSchedule());
		workWeekImpl.setThursdayWorkSchedule(workWeek.getThursdayWorkSchedule());
		workWeekImpl.setFridayWorkSchedule(workWeek.getFridayWorkSchedule());
		workWeekImpl.setSaturdayWorkSchedule(workWeek.getSaturdayWorkSchedule());
		workWeekImpl.setSundayWorkSchedule(workWeek.getSundayWorkSchedule());
		workWeekImpl.setGroupId(workWeek.getGroupId());
		workWeekImpl.setCompanyId(workWeek.getCompanyId());
		workWeekImpl.setUserId(workWeek.getUserId());
		workWeekImpl.setUserName(workWeek.getUserName());
		workWeekImpl.setCreateDate(workWeek.getCreateDate());
		workWeekImpl.setModifiedDate(workWeek.getModifiedDate());

		return workWeekImpl;
	}

	/**
	 * Returns the WorkWeek with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WorkWeek
	 * @return the WorkWeek
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkWeekException, SystemException {
		WorkWeek workWeek = fetchByPrimaryKey(primaryKey);

		if (workWeek == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkWeekException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workWeek;
	}

	/**
	 * Returns the WorkWeek with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkWeekException} if it could not be found.
	 *
	 * @param workWeekId the primary key of the WorkWeek
	 * @return the WorkWeek
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkWeekException if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek findByPrimaryKey(long workWeekId)
		throws NoSuchWorkWeekException, SystemException {
		return findByPrimaryKey((Serializable)workWeekId);
	}

	/**
	 * Returns the WorkWeek with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WorkWeek
	 * @return the WorkWeek, or <code>null</code> if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkWeek workWeek = (WorkWeek)EntityCacheUtil.getResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
				WorkWeekImpl.class, primaryKey);

		if (workWeek == _nullWorkWeek) {
			return null;
		}

		if (workWeek == null) {
			Session session = null;

			try {
				session = openSession();

				workWeek = (WorkWeek)session.get(WorkWeekImpl.class, primaryKey);

				if (workWeek != null) {
					cacheResult(workWeek);
				}
				else {
					EntityCacheUtil.putResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
						WorkWeekImpl.class, primaryKey, _nullWorkWeek);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkWeekModelImpl.ENTITY_CACHE_ENABLED,
					WorkWeekImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workWeek;
	}

	/**
	 * Returns the WorkWeek with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workWeekId the primary key of the WorkWeek
	 * @return the WorkWeek, or <code>null</code> if a WorkWeek with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkWeek fetchByPrimaryKey(long workWeekId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workWeekId);
	}

	/**
	 * Returns all the WorkWeeks.
	 *
	 * @return the WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WorkWeeks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WorkWeeks
	 * @param end the upper bound of the range of WorkWeeks (not inclusive)
	 * @return the range of WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WorkWeeks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkWeekModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of WorkWeeks
	 * @param end the upper bound of the range of WorkWeeks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WorkWeeks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkWeek> findAll(int start, int end,
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

		List<WorkWeek> list = (List<WorkWeek>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKWEEK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKWEEK;

				if (pagination) {
					sql = sql.concat(WorkWeekModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkWeek>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkWeek>(list);
				}
				else {
					list = (List<WorkWeek>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the WorkWeeks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkWeek workWeek : findAll()) {
			remove(workWeek);
		}
	}

	/**
	 * Returns the number of WorkWeeks.
	 *
	 * @return the number of WorkWeeks
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

				Query q = session.createQuery(_SQL_COUNT_WORKWEEK);

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
	 * Initializes the WorkWeek persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.WorkWeek")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkWeek>> listenersList = new ArrayList<ModelListener<WorkWeek>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkWeek>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkWeekImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKWEEK = "SELECT workWeek FROM WorkWeek workWeek";
	private static final String _SQL_SELECT_WORKWEEK_WHERE = "SELECT workWeek FROM WorkWeek workWeek WHERE ";
	private static final String _SQL_COUNT_WORKWEEK = "SELECT COUNT(workWeek) FROM WorkWeek workWeek";
	private static final String _SQL_COUNT_WORKWEEK_WHERE = "SELECT COUNT(workWeek) FROM WorkWeek workWeek WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workWeek.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkWeek exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkWeek exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkWeekPersistenceImpl.class);
	private static WorkWeek _nullWorkWeek = new WorkWeekImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkWeek> toCacheModel() {
				return _nullWorkWeekCacheModel;
			}
		};

	private static CacheModel<WorkWeek> _nullWorkWeekCacheModel = new CacheModel<WorkWeek>() {
			@Override
			public WorkWeek toEntityModel() {
				return _nullWorkWeek;
			}
		};
}