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

import com.rknowsys.eapp.hrm.NoSuchWorkshiftException;
import com.rknowsys.eapp.hrm.model.Workshift;
import com.rknowsys.eapp.hrm.model.impl.WorkshiftImpl;
import com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the workshift service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkshiftPersistence
 * @see WorkshiftUtil
 * @generated
 */
public class WorkshiftPersistenceImpl extends BasePersistenceImpl<Workshift>
	implements WorkshiftPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkshiftUtil} to access the workshift persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkshiftImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			WorkshiftModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the workshifts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshifts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @return the range of matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshifts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByGroupId(long groupId, int start, int end,
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

		List<Workshift> list = (List<Workshift>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Workshift workshift : list) {
				if ((groupId != workshift.getGroupId())) {
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

			query.append(_SQL_SELECT_WORKSHIFT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkshiftModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workshift>(list);
				}
				else {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first workshift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = fetchByGroupId_First(groupId, orderByComparator);

		if (workshift != null) {
			return workshift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkshiftException(msg.toString());
	}

	/**
	 * Returns the first workshift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Workshift> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workshift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = fetchByGroupId_Last(groupId, orderByComparator);

		if (workshift != null) {
			return workshift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkshiftException(msg.toString());
	}

	/**
	 * Returns the last workshift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Workshift> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workshifts before and after the current workshift in the ordered set where groupId = &#63;.
	 *
	 * @param shiftId the primary key of the current workshift
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift[] findByGroupId_PrevAndNext(long shiftId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = findByPrimaryKey(shiftId);

		Session session = null;

		try {
			session = openSession();

			Workshift[] array = new WorkshiftImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, workshift, groupId,
					orderByComparator, true);

			array[1] = workshift;

			array[2] = getByGroupId_PrevAndNext(session, workshift, groupId,
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

	protected Workshift getByGroupId_PrevAndNext(Session session,
		Workshift workshift, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKSHIFT_WHERE);

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
			query.append(WorkshiftModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workshift);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Workshift> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workshifts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Workshift workshift : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workshift);
		}
	}

	/**
	 * Returns the number of workshifts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching workshifts
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

			query.append(_SQL_COUNT_WORKSHIFT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "workshift.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIFTID = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByshiftId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIFTID =
		new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, WorkshiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByshiftId",
			new String[] { Long.class.getName() },
			WorkshiftModelImpl.SHIFTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SHIFTID = new FinderPath(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByshiftId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the workshifts where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @return the matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByshiftId(long shiftId)
		throws SystemException {
		return findByshiftId(shiftId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshifts where shiftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shiftId the shift ID
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @return the range of matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByshiftId(long shiftId, int start, int end)
		throws SystemException {
		return findByshiftId(shiftId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshifts where shiftId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shiftId the shift ID
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findByshiftId(long shiftId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIFTID;
			finderArgs = new Object[] { shiftId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIFTID;
			finderArgs = new Object[] { shiftId, start, end, orderByComparator };
		}

		List<Workshift> list = (List<Workshift>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Workshift workshift : list) {
				if ((shiftId != workshift.getShiftId())) {
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

			query.append(_SQL_SELECT_WORKSHIFT_WHERE);

			query.append(_FINDER_COLUMN_SHIFTID_SHIFTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkshiftModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shiftId);

				if (!pagination) {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workshift>(list);
				}
				else {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first workshift in the ordered set where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByshiftId_First(long shiftId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = fetchByshiftId_First(shiftId, orderByComparator);

		if (workshift != null) {
			return workshift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shiftId=");
		msg.append(shiftId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkshiftException(msg.toString());
	}

	/**
	 * Returns the first workshift in the ordered set where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshift, or <code>null</code> if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByshiftId_First(long shiftId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Workshift> list = findByshiftId(shiftId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workshift in the ordered set where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByshiftId_Last(long shiftId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = fetchByshiftId_Last(shiftId, orderByComparator);

		if (workshift != null) {
			return workshift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shiftId=");
		msg.append(shiftId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkshiftException(msg.toString());
	}

	/**
	 * Returns the last workshift in the ordered set where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshift, or <code>null</code> if a matching workshift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByshiftId_Last(long shiftId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByshiftId(shiftId);

		if (count == 0) {
			return null;
		}

		List<Workshift> list = findByshiftId(shiftId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the workshifts where shiftId = &#63; from the database.
	 *
	 * @param shiftId the shift ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByshiftId(long shiftId) throws SystemException {
		for (Workshift workshift : findByshiftId(shiftId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workshift);
		}
	}

	/**
	 * Returns the number of workshifts where shiftId = &#63;.
	 *
	 * @param shiftId the shift ID
	 * @return the number of matching workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByshiftId(long shiftId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SHIFTID;

		Object[] finderArgs = new Object[] { shiftId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKSHIFT_WHERE);

			query.append(_FINDER_COLUMN_SHIFTID_SHIFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shiftId);

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

	private static final String _FINDER_COLUMN_SHIFTID_SHIFTID_2 = "workshift.shiftId = ?";

	public WorkshiftPersistenceImpl() {
		setModelClass(Workshift.class);
	}

	/**
	 * Caches the workshift in the entity cache if it is enabled.
	 *
	 * @param workshift the workshift
	 */
	@Override
	public void cacheResult(Workshift workshift) {
		EntityCacheUtil.putResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftImpl.class, workshift.getPrimaryKey(), workshift);

		workshift.resetOriginalValues();
	}

	/**
	 * Caches the workshifts in the entity cache if it is enabled.
	 *
	 * @param workshifts the workshifts
	 */
	@Override
	public void cacheResult(List<Workshift> workshifts) {
		for (Workshift workshift : workshifts) {
			if (EntityCacheUtil.getResult(
						WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
						WorkshiftImpl.class, workshift.getPrimaryKey()) == null) {
				cacheResult(workshift);
			}
			else {
				workshift.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workshifts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkshiftImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkshiftImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workshift.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Workshift workshift) {
		EntityCacheUtil.removeResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftImpl.class, workshift.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Workshift> workshifts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Workshift workshift : workshifts) {
			EntityCacheUtil.removeResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
				WorkshiftImpl.class, workshift.getPrimaryKey());
		}
	}

	/**
	 * Creates a new workshift with the primary key. Does not add the workshift to the database.
	 *
	 * @param shiftId the primary key for the new workshift
	 * @return the new workshift
	 */
	@Override
	public Workshift create(long shiftId) {
		Workshift workshift = new WorkshiftImpl();

		workshift.setNew(true);
		workshift.setPrimaryKey(shiftId);

		return workshift;
	}

	/**
	 * Removes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shiftId the primary key of the workshift
	 * @return the workshift that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift remove(long shiftId)
		throws NoSuchWorkshiftException, SystemException {
		return remove((Serializable)shiftId);
	}

	/**
	 * Removes the workshift with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workshift
	 * @return the workshift that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift remove(Serializable primaryKey)
		throws NoSuchWorkshiftException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Workshift workshift = (Workshift)session.get(WorkshiftImpl.class,
					primaryKey);

			if (workshift == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkshiftException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workshift);
		}
		catch (NoSuchWorkshiftException nsee) {
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
	protected Workshift removeImpl(Workshift workshift)
		throws SystemException {
		workshift = toUnwrappedModel(workshift);

		workshiftToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(workshift.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workshift)) {
				workshift = (Workshift)session.get(WorkshiftImpl.class,
						workshift.getPrimaryKeyObj());
			}

			if (workshift != null) {
				session.delete(workshift);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workshift != null) {
			clearCache(workshift);
		}

		return workshift;
	}

	@Override
	public Workshift updateImpl(com.rknowsys.eapp.hrm.model.Workshift workshift)
		throws SystemException {
		workshift = toUnwrappedModel(workshift);

		boolean isNew = workshift.isNew();

		WorkshiftModelImpl workshiftModelImpl = (WorkshiftModelImpl)workshift;

		Session session = null;

		try {
			session = openSession();

			if (workshift.isNew()) {
				session.save(workshift);

				workshift.setNew(false);
			}
			else {
				session.merge(workshift);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkshiftModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workshiftModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workshiftModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { workshiftModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((workshiftModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIFTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workshiftModelImpl.getOriginalShiftId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIFTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIFTID,
					args);

				args = new Object[] { workshiftModelImpl.getShiftId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIFTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIFTID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkshiftImpl.class, workshift.getPrimaryKey(), workshift);

		return workshift;
	}

	protected Workshift toUnwrappedModel(Workshift workshift) {
		if (workshift instanceof WorkshiftImpl) {
			return workshift;
		}

		WorkshiftImpl workshiftImpl = new WorkshiftImpl();

		workshiftImpl.setNew(workshift.isNew());
		workshiftImpl.setPrimaryKey(workshift.getPrimaryKey());

		workshiftImpl.setShiftId(workshift.getShiftId());
		workshiftImpl.setCompanyId(workshift.getCompanyId());
		workshiftImpl.setGroupId(workshift.getGroupId());
		workshiftImpl.setCreateDate(workshift.getCreateDate());
		workshiftImpl.setModifiedDate(workshift.getModifiedDate());
		workshiftImpl.setUserId(workshift.getUserId());
		workshiftImpl.setWorkshiftName(workshift.getWorkshiftName());
		workshiftImpl.setFromWorkHours(workshift.getFromWorkHours());
		workshiftImpl.setToWorkHours(workshift.getToWorkHours());

		return workshiftImpl;
	}

	/**
	 * Returns the workshift with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workshift
	 * @return the workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkshiftException, SystemException {
		Workshift workshift = fetchByPrimaryKey(primaryKey);

		if (workshift == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkshiftException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workshift;
	}

	/**
	 * Returns the workshift with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkshiftException} if it could not be found.
	 *
	 * @param shiftId the primary key of the workshift
	 * @return the workshift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkshiftException if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift findByPrimaryKey(long shiftId)
		throws NoSuchWorkshiftException, SystemException {
		return findByPrimaryKey((Serializable)shiftId);
	}

	/**
	 * Returns the workshift with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workshift
	 * @return the workshift, or <code>null</code> if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Workshift workshift = (Workshift)EntityCacheUtil.getResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
				WorkshiftImpl.class, primaryKey);

		if (workshift == _nullWorkshift) {
			return null;
		}

		if (workshift == null) {
			Session session = null;

			try {
				session = openSession();

				workshift = (Workshift)session.get(WorkshiftImpl.class,
						primaryKey);

				if (workshift != null) {
					cacheResult(workshift);
				}
				else {
					EntityCacheUtil.putResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
						WorkshiftImpl.class, primaryKey, _nullWorkshift);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkshiftModelImpl.ENTITY_CACHE_ENABLED,
					WorkshiftImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workshift;
	}

	/**
	 * Returns the workshift with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shiftId the primary key of the workshift
	 * @return the workshift, or <code>null</code> if a workshift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workshift fetchByPrimaryKey(long shiftId) throws SystemException {
		return fetchByPrimaryKey((Serializable)shiftId);
	}

	/**
	 * Returns all the workshifts.
	 *
	 * @return the workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshifts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @return the range of workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshifts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workshifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workshift> findAll(int start, int end,
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

		List<Workshift> list = (List<Workshift>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKSHIFT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSHIFT;

				if (pagination) {
					sql = sql.concat(WorkshiftModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workshift>(list);
				}
				else {
					list = (List<Workshift>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the workshifts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Workshift workshift : findAll()) {
			remove(workshift);
		}
	}

	/**
	 * Returns the number of workshifts.
	 *
	 * @return the number of workshifts
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

				Query q = session.createQuery(_SQL_COUNT_WORKSHIFT);

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
	 * Returns all the Employees associated with the workshift.
	 *
	 * @param pk the primary key of the workshift
	 * @return the Employees associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(long pk)
		throws SystemException {
		return getEmployees(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Employees associated with the workshift.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workshift
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @return the range of Employees associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(long pk,
		int start, int end) throws SystemException {
		return getEmployees(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Employees associated with the workshift.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workshift
	 * @param start the lower bound of the range of workshifts
	 * @param end the upper bound of the range of workshifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Employees associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Employee> getEmployees(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return workshiftToEmployeeTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of Employees associated with the workshift.
	 *
	 * @param pk the primary key of the workshift
	 * @return the number of Employees associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEmployeesSize(long pk) throws SystemException {
		long[] pks = workshiftToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the Employee is associated with the workshift.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePK the primary key of the Employee
	 * @return <code>true</code> if the Employee is associated with the workshift; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmployee(long pk, long employeePK)
		throws SystemException {
		return workshiftToEmployeeTableMapper.containsTableMapping(pk,
			employeePK);
	}

	/**
	 * Returns <code>true</code> if the workshift has any Employees associated with it.
	 *
	 * @param pk the primary key of the workshift to check for associations with Employees
	 * @return <code>true</code> if the workshift has any Employees associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmployees(long pk) throws SystemException {
		if (getEmployeesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePK the primary key of the Employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployee(long pk, long employeePK) throws SystemException {
		workshiftToEmployeeTableMapper.addTableMapping(pk, employeePK);
	}

	/**
	 * Adds an association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employee the Employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws SystemException {
		workshiftToEmployeeTableMapper.addTableMapping(pk,
			employee.getPrimaryKey());
	}

	/**
	 * Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePKs the primary keys of the Employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployees(long pk, long[] employeePKs)
		throws SystemException {
		for (long employeePK : employeePKs) {
			workshiftToEmployeeTableMapper.addTableMapping(pk, employeePK);
		}
	}

	/**
	 * Adds an association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employees the Employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployees(long pk,
		List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.Employee employee : employees) {
			workshiftToEmployeeTableMapper.addTableMapping(pk,
				employee.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the workshift and its Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift to clear the associated Employees from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearEmployees(long pk) throws SystemException {
		workshiftToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePK the primary key of the Employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployee(long pk, long employeePK)
		throws SystemException {
		workshiftToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
	}

	/**
	 * Removes the association between the workshift and the Employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employee the Employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployee(long pk,
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws SystemException {
		workshiftToEmployeeTableMapper.deleteTableMapping(pk,
			employee.getPrimaryKey());
	}

	/**
	 * Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePKs the primary keys of the Employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployees(long pk, long[] employeePKs)
		throws SystemException {
		for (long employeePK : employeePKs) {
			workshiftToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
		}
	}

	/**
	 * Removes the association between the workshift and the Employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employees the Employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployees(long pk,
		List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.Employee employee : employees) {
			workshiftToEmployeeTableMapper.deleteTableMapping(pk,
				employee.getPrimaryKey());
		}
	}

	/**
	 * Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employeePKs the primary keys of the Employees to be associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmployees(long pk, long[] employeePKs)
		throws SystemException {
		Set<Long> newEmployeePKsSet = SetUtil.fromArray(employeePKs);
		Set<Long> oldEmployeePKsSet = SetUtil.fromArray(workshiftToEmployeeTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeEmployeePKsSet = new HashSet<Long>(oldEmployeePKsSet);

		removeEmployeePKsSet.removeAll(newEmployeePKsSet);

		for (long removeEmployeePK : removeEmployeePKsSet) {
			workshiftToEmployeeTableMapper.deleteTableMapping(pk,
				removeEmployeePK);
		}

		newEmployeePKsSet.removeAll(oldEmployeePKsSet);

		for (long newEmployeePK : newEmployeePKsSet) {
			workshiftToEmployeeTableMapper.addTableMapping(pk, newEmployeePK);
		}
	}

	/**
	 * Sets the Employees associated with the workshift, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workshift
	 * @param employees the Employees to be associated with the workshift
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmployees(long pk,
		List<com.rknowsys.eapp.hrm.model.Employee> employees)
		throws SystemException {
		try {
			long[] employeePKs = new long[employees.size()];

			for (int i = 0; i < employees.size(); i++) {
				com.rknowsys.eapp.hrm.model.Employee employee = employees.get(i);

				employeePKs[i] = employee.getPrimaryKey();
			}

			setEmployees(pk, employeePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(WorkshiftModelImpl.MAPPING_TABLE_HRM_EMP_WORKSHIFT_NAME);
		}
	}

	/**
	 * Initializes the workshift persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Workshift")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Workshift>> listenersList = new ArrayList<ModelListener<Workshift>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Workshift>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		workshiftToEmployeeTableMapper = TableMapperFactory.getTableMapper("hrm_emp_workshift",
				"shiftId", "employeeId", this, employeePersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WorkshiftImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	protected TableMapper<Workshift, com.rknowsys.eapp.hrm.model.Employee> workshiftToEmployeeTableMapper;
	private static final String _SQL_SELECT_WORKSHIFT = "SELECT workshift FROM Workshift workshift";
	private static final String _SQL_SELECT_WORKSHIFT_WHERE = "SELECT workshift FROM Workshift workshift WHERE ";
	private static final String _SQL_COUNT_WORKSHIFT = "SELECT COUNT(workshift) FROM Workshift workshift";
	private static final String _SQL_COUNT_WORKSHIFT_WHERE = "SELECT COUNT(workshift) FROM Workshift workshift WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workshift.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Workshift exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Workshift exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkshiftPersistenceImpl.class);
	private static Workshift _nullWorkshift = new WorkshiftImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Workshift> toCacheModel() {
				return _nullWorkshiftCacheModel;
			}
		};

	private static CacheModel<Workshift> _nullWorkshiftCacheModel = new CacheModel<Workshift>() {
			@Override
			public Workshift toEntityModel() {
				return _nullWorkshift;
			}
		};
}