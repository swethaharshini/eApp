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

import com.rknowsys.eapp.hrm.NoSuchReportingMethodsException;
import com.rknowsys.eapp.hrm.model.ReportingMethods;
import com.rknowsys.eapp.hrm.model.impl.ReportingMethodsImpl;
import com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the reporting methods service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethodsPersistence
 * @see ReportingMethodsUtil
 * @generated
 */
public class ReportingMethodsPersistenceImpl extends BasePersistenceImpl<ReportingMethods>
	implements ReportingMethodsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReportingMethodsUtil} to access the reporting methods persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReportingMethodsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ReportingMethodsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the reporting methodses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reporting methodses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @return the range of matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reporting methodses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByGroupId(long groupId, int start,
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

		List<ReportingMethods> list = (List<ReportingMethods>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportingMethods reportingMethods : list) {
				if ((groupId != reportingMethods.getGroupId())) {
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

			query.append(_SQL_SELECT_REPORTINGMETHODS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportingMethodsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ReportingMethods>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportingMethods>(list);
				}
				else {
					list = (List<ReportingMethods>)QueryUtil.list(q,
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
	 * Returns the first reporting methods in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = fetchByGroupId_First(groupId,
				orderByComparator);

		if (reportingMethods != null) {
			return reportingMethods;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportingMethodsException(msg.toString());
	}

	/**
	 * Returns the first reporting methods in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReportingMethods> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reporting methods in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (reportingMethods != null) {
			return reportingMethods;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportingMethodsException(msg.toString());
	}

	/**
	 * Returns the last reporting methods in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ReportingMethods> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reporting methodses before and after the current reporting methods in the ordered set where groupId = &#63;.
	 *
	 * @param reportingmethodId the primary key of the current reporting methods
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods[] findByGroupId_PrevAndNext(
		long reportingmethodId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = findByPrimaryKey(reportingmethodId);

		Session session = null;

		try {
			session = openSession();

			ReportingMethods[] array = new ReportingMethodsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, reportingMethods,
					groupId, orderByComparator, true);

			array[1] = reportingMethods;

			array[2] = getByGroupId_PrevAndNext(session, reportingMethods,
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

	protected ReportingMethods getByGroupId_PrevAndNext(Session session,
		ReportingMethods reportingMethods, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORTINGMETHODS_WHERE);

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
			query.append(ReportingMethodsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reportingMethods);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReportingMethods> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reporting methodses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ReportingMethods reportingMethods : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportingMethods);
		}
	}

	/**
	 * Returns the number of reporting methodses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching reporting methodses
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

			query.append(_SQL_COUNT_REPORTINGMETHODS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "reportingMethods.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINGMETHODID =
		new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByreportingmethodId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINGMETHODID =
		new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED,
			ReportingMethodsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByreportingmethodId", new String[] { Long.class.getName() },
			ReportingMethodsModelImpl.REPORTINGMETHODID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTINGMETHODID = new FinderPath(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByreportingmethodId", new String[] { Long.class.getName() });

	/**
	 * Returns all the reporting methodses where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @return the matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByreportingmethodId(
		long reportingmethodId) throws SystemException {
		return findByreportingmethodId(reportingmethodId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reporting methodses where reportingmethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @return the range of matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end) throws SystemException {
		return findByreportingmethodId(reportingmethodId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reporting methodses where reportingmethodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findByreportingmethodId(
		long reportingmethodId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINGMETHODID;
			finderArgs = new Object[] { reportingmethodId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINGMETHODID;
			finderArgs = new Object[] {
					reportingmethodId,
					
					start, end, orderByComparator
				};
		}

		List<ReportingMethods> list = (List<ReportingMethods>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportingMethods reportingMethods : list) {
				if ((reportingmethodId != reportingMethods.getReportingmethodId())) {
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

			query.append(_SQL_SELECT_REPORTINGMETHODS_WHERE);

			query.append(_FINDER_COLUMN_REPORTINGMETHODID_REPORTINGMETHODID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportingMethodsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportingmethodId);

				if (!pagination) {
					list = (List<ReportingMethods>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportingMethods>(list);
				}
				else {
					list = (List<ReportingMethods>)QueryUtil.list(q,
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
	 * Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByreportingmethodId_First(
		long reportingmethodId, OrderByComparator orderByComparator)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = fetchByreportingmethodId_First(reportingmethodId,
				orderByComparator);

		if (reportingMethods != null) {
			return reportingMethods;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportingmethodId=");
		msg.append(reportingmethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportingMethodsException(msg.toString());
	}

	/**
	 * Returns the first reporting methods in the ordered set where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByreportingmethodId_First(
		long reportingmethodId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ReportingMethods> list = findByreportingmethodId(reportingmethodId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByreportingmethodId_Last(
		long reportingmethodId, OrderByComparator orderByComparator)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = fetchByreportingmethodId_Last(reportingmethodId,
				orderByComparator);

		if (reportingMethods != null) {
			return reportingMethods;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportingmethodId=");
		msg.append(reportingmethodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportingMethodsException(msg.toString());
	}

	/**
	 * Returns the last reporting methods in the ordered set where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reporting methods, or <code>null</code> if a matching reporting methods could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByreportingmethodId_Last(
		long reportingmethodId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByreportingmethodId(reportingmethodId);

		if (count == 0) {
			return null;
		}

		List<ReportingMethods> list = findByreportingmethodId(reportingmethodId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the reporting methodses where reportingmethodId = &#63; from the database.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByreportingmethodId(long reportingmethodId)
		throws SystemException {
		for (ReportingMethods reportingMethods : findByreportingmethodId(
				reportingmethodId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportingMethods);
		}
	}

	/**
	 * Returns the number of reporting methodses where reportingmethodId = &#63;.
	 *
	 * @param reportingmethodId the reportingmethod ID
	 * @return the number of matching reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByreportingmethodId(long reportingmethodId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTINGMETHODID;

		Object[] finderArgs = new Object[] { reportingmethodId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REPORTINGMETHODS_WHERE);

			query.append(_FINDER_COLUMN_REPORTINGMETHODID_REPORTINGMETHODID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportingmethodId);

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

	private static final String _FINDER_COLUMN_REPORTINGMETHODID_REPORTINGMETHODID_2 =
		"reportingMethods.reportingmethodId = ?";

	public ReportingMethodsPersistenceImpl() {
		setModelClass(ReportingMethods.class);
	}

	/**
	 * Caches the reporting methods in the entity cache if it is enabled.
	 *
	 * @param reportingMethods the reporting methods
	 */
	@Override
	public void cacheResult(ReportingMethods reportingMethods) {
		EntityCacheUtil.putResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsImpl.class, reportingMethods.getPrimaryKey(),
			reportingMethods);

		reportingMethods.resetOriginalValues();
	}

	/**
	 * Caches the reporting methodses in the entity cache if it is enabled.
	 *
	 * @param reportingMethodses the reporting methodses
	 */
	@Override
	public void cacheResult(List<ReportingMethods> reportingMethodses) {
		for (ReportingMethods reportingMethods : reportingMethodses) {
			if (EntityCacheUtil.getResult(
						ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
						ReportingMethodsImpl.class,
						reportingMethods.getPrimaryKey()) == null) {
				cacheResult(reportingMethods);
			}
			else {
				reportingMethods.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reporting methodses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReportingMethodsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReportingMethodsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reporting methods.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReportingMethods reportingMethods) {
		EntityCacheUtil.removeResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsImpl.class, reportingMethods.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ReportingMethods> reportingMethodses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReportingMethods reportingMethods : reportingMethodses) {
			EntityCacheUtil.removeResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
				ReportingMethodsImpl.class, reportingMethods.getPrimaryKey());
		}
	}

	/**
	 * Creates a new reporting methods with the primary key. Does not add the reporting methods to the database.
	 *
	 * @param reportingmethodId the primary key for the new reporting methods
	 * @return the new reporting methods
	 */
	@Override
	public ReportingMethods create(long reportingmethodId) {
		ReportingMethods reportingMethods = new ReportingMethodsImpl();

		reportingMethods.setNew(true);
		reportingMethods.setPrimaryKey(reportingmethodId);

		return reportingMethods;
	}

	/**
	 * Removes the reporting methods with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportingmethodId the primary key of the reporting methods
	 * @return the reporting methods that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods remove(long reportingmethodId)
		throws NoSuchReportingMethodsException, SystemException {
		return remove((Serializable)reportingmethodId);
	}

	/**
	 * Removes the reporting methods with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reporting methods
	 * @return the reporting methods that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods remove(Serializable primaryKey)
		throws NoSuchReportingMethodsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReportingMethods reportingMethods = (ReportingMethods)session.get(ReportingMethodsImpl.class,
					primaryKey);

			if (reportingMethods == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReportingMethodsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reportingMethods);
		}
		catch (NoSuchReportingMethodsException nsee) {
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
	protected ReportingMethods removeImpl(ReportingMethods reportingMethods)
		throws SystemException {
		reportingMethods = toUnwrappedModel(reportingMethods);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reportingMethods)) {
				reportingMethods = (ReportingMethods)session.get(ReportingMethodsImpl.class,
						reportingMethods.getPrimaryKeyObj());
			}

			if (reportingMethods != null) {
				session.delete(reportingMethods);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (reportingMethods != null) {
			clearCache(reportingMethods);
		}

		return reportingMethods;
	}

	@Override
	public ReportingMethods updateImpl(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods)
		throws SystemException {
		reportingMethods = toUnwrappedModel(reportingMethods);

		boolean isNew = reportingMethods.isNew();

		ReportingMethodsModelImpl reportingMethodsModelImpl = (ReportingMethodsModelImpl)reportingMethods;

		Session session = null;

		try {
			session = openSession();

			if (reportingMethods.isNew()) {
				session.save(reportingMethods);

				reportingMethods.setNew(false);
			}
			else {
				session.merge(reportingMethods);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReportingMethodsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reportingMethodsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportingMethodsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { reportingMethodsModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((reportingMethodsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINGMETHODID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportingMethodsModelImpl.getOriginalReportingmethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTINGMETHODID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINGMETHODID,
					args);

				args = new Object[] {
						reportingMethodsModelImpl.getReportingmethodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTINGMETHODID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINGMETHODID,
					args);
			}
		}

		EntityCacheUtil.putResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
			ReportingMethodsImpl.class, reportingMethods.getPrimaryKey(),
			reportingMethods);

		return reportingMethods;
	}

	protected ReportingMethods toUnwrappedModel(
		ReportingMethods reportingMethods) {
		if (reportingMethods instanceof ReportingMethodsImpl) {
			return reportingMethods;
		}

		ReportingMethodsImpl reportingMethodsImpl = new ReportingMethodsImpl();

		reportingMethodsImpl.setNew(reportingMethods.isNew());
		reportingMethodsImpl.setPrimaryKey(reportingMethods.getPrimaryKey());

		reportingMethodsImpl.setReportingmethodId(reportingMethods.getReportingmethodId());
		reportingMethodsImpl.setCompanyId(reportingMethods.getCompanyId());
		reportingMethodsImpl.setGroupId(reportingMethods.getGroupId());
		reportingMethodsImpl.setCreateDate(reportingMethods.getCreateDate());
		reportingMethodsImpl.setModifiedDate(reportingMethods.getModifiedDate());
		reportingMethodsImpl.setUserId(reportingMethods.getUserId());
		reportingMethodsImpl.setReportingmethodName(reportingMethods.getReportingmethodName());

		return reportingMethodsImpl;
	}

	/**
	 * Returns the reporting methods with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the reporting methods
	 * @return the reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReportingMethodsException, SystemException {
		ReportingMethods reportingMethods = fetchByPrimaryKey(primaryKey);

		if (reportingMethods == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReportingMethodsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return reportingMethods;
	}

	/**
	 * Returns the reporting methods with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchReportingMethodsException} if it could not be found.
	 *
	 * @param reportingmethodId the primary key of the reporting methods
	 * @return the reporting methods
	 * @throws com.rknowsys.eapp.hrm.NoSuchReportingMethodsException if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods findByPrimaryKey(long reportingmethodId)
		throws NoSuchReportingMethodsException, SystemException {
		return findByPrimaryKey((Serializable)reportingmethodId);
	}

	/**
	 * Returns the reporting methods with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reporting methods
	 * @return the reporting methods, or <code>null</code> if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ReportingMethods reportingMethods = (ReportingMethods)EntityCacheUtil.getResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
				ReportingMethodsImpl.class, primaryKey);

		if (reportingMethods == _nullReportingMethods) {
			return null;
		}

		if (reportingMethods == null) {
			Session session = null;

			try {
				session = openSession();

				reportingMethods = (ReportingMethods)session.get(ReportingMethodsImpl.class,
						primaryKey);

				if (reportingMethods != null) {
					cacheResult(reportingMethods);
				}
				else {
					EntityCacheUtil.putResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
						ReportingMethodsImpl.class, primaryKey,
						_nullReportingMethods);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReportingMethodsModelImpl.ENTITY_CACHE_ENABLED,
					ReportingMethodsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return reportingMethods;
	}

	/**
	 * Returns the reporting methods with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportingmethodId the primary key of the reporting methods
	 * @return the reporting methods, or <code>null</code> if a reporting methods with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportingMethods fetchByPrimaryKey(long reportingmethodId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)reportingmethodId);
	}

	/**
	 * Returns all the reporting methodses.
	 *
	 * @return the reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reporting methodses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @return the range of reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the reporting methodses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reporting methodses
	 * @param end the upper bound of the range of reporting methodses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reporting methodses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportingMethods> findAll(int start, int end,
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

		List<ReportingMethods> list = (List<ReportingMethods>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REPORTINGMETHODS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPORTINGMETHODS;

				if (pagination) {
					sql = sql.concat(ReportingMethodsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ReportingMethods>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportingMethods>(list);
				}
				else {
					list = (List<ReportingMethods>)QueryUtil.list(q,
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
	 * Removes all the reporting methodses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ReportingMethods reportingMethods : findAll()) {
			remove(reportingMethods);
		}
	}

	/**
	 * Returns the number of reporting methodses.
	 *
	 * @return the number of reporting methodses
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

				Query q = session.createQuery(_SQL_COUNT_REPORTINGMETHODS);

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
	 * Initializes the reporting methods persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.ReportingMethods")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReportingMethods>> listenersList = new ArrayList<ModelListener<ReportingMethods>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReportingMethods>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReportingMethodsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REPORTINGMETHODS = "SELECT reportingMethods FROM ReportingMethods reportingMethods";
	private static final String _SQL_SELECT_REPORTINGMETHODS_WHERE = "SELECT reportingMethods FROM ReportingMethods reportingMethods WHERE ";
	private static final String _SQL_COUNT_REPORTINGMETHODS = "SELECT COUNT(reportingMethods) FROM ReportingMethods reportingMethods";
	private static final String _SQL_COUNT_REPORTINGMETHODS_WHERE = "SELECT COUNT(reportingMethods) FROM ReportingMethods reportingMethods WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reportingMethods.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReportingMethods exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ReportingMethods exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReportingMethodsPersistenceImpl.class);
	private static ReportingMethods _nullReportingMethods = new ReportingMethodsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReportingMethods> toCacheModel() {
				return _nullReportingMethodsCacheModel;
			}
		};

	private static CacheModel<ReportingMethods> _nullReportingMethodsCacheModel = new CacheModel<ReportingMethods>() {
			@Override
			public ReportingMethods toEntityModel() {
				return _nullReportingMethods;
			}
		};
}