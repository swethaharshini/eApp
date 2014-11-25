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

import com.rknowsys.eapp.hrm.NoSuchSalaryComponentException;
import com.rknowsys.eapp.hrm.model.SalaryComponent;
import com.rknowsys.eapp.hrm.model.impl.SalaryComponentImpl;
import com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the salary component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SalaryComponentPersistence
 * @see SalaryComponentUtil
 * @generated
 */
public class SalaryComponentPersistenceImpl extends BasePersistenceImpl<SalaryComponent>
	implements SalaryComponentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SalaryComponentUtil} to access the salary component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SalaryComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SalaryComponentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the salary components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salary components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @return the range of matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the salary components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findByGroupId(long groupId, int start,
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

		List<SalaryComponent> list = (List<SalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SalaryComponent salaryComponent : list) {
				if ((groupId != salaryComponent.getGroupId())) {
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

			query.append(_SQL_SELECT_SALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalaryComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SalaryComponent>(list);
				}
				else {
					list = (List<SalaryComponent>)QueryUtil.list(q,
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
	 * Returns the first salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = fetchByGroupId_First(groupId,
				orderByComparator);

		if (salaryComponent != null) {
			return salaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the first salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SalaryComponent> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (salaryComponent != null) {
			return salaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the last salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SalaryComponent> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the salary components before and after the current salary component in the ordered set where groupId = &#63;.
	 *
	 * @param salaryComponentId the primary key of the current salary component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent[] findByGroupId_PrevAndNext(long salaryComponentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = findByPrimaryKey(salaryComponentId);

		Session session = null;

		try {
			session = openSession();

			SalaryComponent[] array = new SalaryComponentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, salaryComponent,
					groupId, orderByComparator, true);

			array[1] = salaryComponent;

			array[2] = getByGroupId_PrevAndNext(session, salaryComponent,
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

	protected SalaryComponent getByGroupId_PrevAndNext(Session session,
		SalaryComponent salaryComponent, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SALARYCOMPONENT_WHERE);

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
			query.append(SalaryComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salaryComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalaryComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the salary components where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (SalaryComponent salaryComponent : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salaryComponent);
		}
	}

	/**
	 * Returns the number of salary components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching salary components
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

			query.append(_SQL_COUNT_SALARYCOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "salaryComponent.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SALARYCOMPONENTID =
		new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysalaryComponentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SALARYCOMPONENTID =
		new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			SalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysalaryComponentId", new String[] { Long.class.getName() },
			SalaryComponentModelImpl.SALARYCOMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SALARYCOMPONENTID = new FinderPath(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysalaryComponentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the salary components where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @return the matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findBysalaryComponentId(long salaryComponentId)
		throws SystemException {
		return findBysalaryComponentId(salaryComponentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salary components where salaryComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param salaryComponentId the salary component ID
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @return the range of matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end) throws SystemException {
		return findBysalaryComponentId(salaryComponentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the salary components where salaryComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param salaryComponentId the salary component ID
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findBysalaryComponentId(
		long salaryComponentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SALARYCOMPONENTID;
			finderArgs = new Object[] { salaryComponentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SALARYCOMPONENTID;
			finderArgs = new Object[] {
					salaryComponentId,
					
					start, end, orderByComparator
				};
		}

		List<SalaryComponent> list = (List<SalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SalaryComponent salaryComponent : list) {
				if ((salaryComponentId != salaryComponent.getSalaryComponentId())) {
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

			query.append(_SQL_SELECT_SALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_SALARYCOMPONENTID_SALARYCOMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalaryComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(salaryComponentId);

				if (!pagination) {
					list = (List<SalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SalaryComponent>(list);
				}
				else {
					list = (List<SalaryComponent>)QueryUtil.list(q,
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
	 * Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findBysalaryComponentId_First(
		long salaryComponentId, OrderByComparator orderByComparator)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = fetchBysalaryComponentId_First(salaryComponentId,
				orderByComparator);

		if (salaryComponent != null) {
			return salaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("salaryComponentId=");
		msg.append(salaryComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the first salary component in the ordered set where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary component, or <code>null</code> if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchBysalaryComponentId_First(
		long salaryComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SalaryComponent> list = findBysalaryComponentId(salaryComponentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findBysalaryComponentId_Last(
		long salaryComponentId, OrderByComparator orderByComparator)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = fetchBysalaryComponentId_Last(salaryComponentId,
				orderByComparator);

		if (salaryComponent != null) {
			return salaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("salaryComponentId=");
		msg.append(salaryComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the last salary component in the ordered set where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary component, or <code>null</code> if a matching salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchBysalaryComponentId_Last(
		long salaryComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBysalaryComponentId(salaryComponentId);

		if (count == 0) {
			return null;
		}

		List<SalaryComponent> list = findBysalaryComponentId(salaryComponentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the salary components where salaryComponentId = &#63; from the database.
	 *
	 * @param salaryComponentId the salary component ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysalaryComponentId(long salaryComponentId)
		throws SystemException {
		for (SalaryComponent salaryComponent : findBysalaryComponentId(
				salaryComponentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salaryComponent);
		}
	}

	/**
	 * Returns the number of salary components where salaryComponentId = &#63;.
	 *
	 * @param salaryComponentId the salary component ID
	 * @return the number of matching salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysalaryComponentId(long salaryComponentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SALARYCOMPONENTID;

		Object[] finderArgs = new Object[] { salaryComponentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_SALARYCOMPONENTID_SALARYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(salaryComponentId);

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

	private static final String _FINDER_COLUMN_SALARYCOMPONENTID_SALARYCOMPONENTID_2 =
		"salaryComponent.salaryComponentId = ?";

	public SalaryComponentPersistenceImpl() {
		setModelClass(SalaryComponent.class);
	}

	/**
	 * Caches the salary component in the entity cache if it is enabled.
	 *
	 * @param salaryComponent the salary component
	 */
	@Override
	public void cacheResult(SalaryComponent salaryComponent) {
		EntityCacheUtil.putResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentImpl.class, salaryComponent.getPrimaryKey(),
			salaryComponent);

		salaryComponent.resetOriginalValues();
	}

	/**
	 * Caches the salary components in the entity cache if it is enabled.
	 *
	 * @param salaryComponents the salary components
	 */
	@Override
	public void cacheResult(List<SalaryComponent> salaryComponents) {
		for (SalaryComponent salaryComponent : salaryComponents) {
			if (EntityCacheUtil.getResult(
						SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
						SalaryComponentImpl.class,
						salaryComponent.getPrimaryKey()) == null) {
				cacheResult(salaryComponent);
			}
			else {
				salaryComponent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all salary components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SalaryComponentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SalaryComponentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the salary component.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalaryComponent salaryComponent) {
		EntityCacheUtil.removeResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentImpl.class, salaryComponent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SalaryComponent> salaryComponents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SalaryComponent salaryComponent : salaryComponents) {
			EntityCacheUtil.removeResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
				SalaryComponentImpl.class, salaryComponent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new salary component with the primary key. Does not add the salary component to the database.
	 *
	 * @param salaryComponentId the primary key for the new salary component
	 * @return the new salary component
	 */
	@Override
	public SalaryComponent create(long salaryComponentId) {
		SalaryComponent salaryComponent = new SalaryComponentImpl();

		salaryComponent.setNew(true);
		salaryComponent.setPrimaryKey(salaryComponentId);

		return salaryComponent;
	}

	/**
	 * Removes the salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryComponentId the primary key of the salary component
	 * @return the salary component that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent remove(long salaryComponentId)
		throws NoSuchSalaryComponentException, SystemException {
		return remove((Serializable)salaryComponentId);
	}

	/**
	 * Removes the salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the salary component
	 * @return the salary component that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent remove(Serializable primaryKey)
		throws NoSuchSalaryComponentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SalaryComponent salaryComponent = (SalaryComponent)session.get(SalaryComponentImpl.class,
					primaryKey);

			if (salaryComponent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalaryComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(salaryComponent);
		}
		catch (NoSuchSalaryComponentException nsee) {
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
	protected SalaryComponent removeImpl(SalaryComponent salaryComponent)
		throws SystemException {
		salaryComponent = toUnwrappedModel(salaryComponent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salaryComponent)) {
				salaryComponent = (SalaryComponent)session.get(SalaryComponentImpl.class,
						salaryComponent.getPrimaryKeyObj());
			}

			if (salaryComponent != null) {
				session.delete(salaryComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (salaryComponent != null) {
			clearCache(salaryComponent);
		}

		return salaryComponent;
	}

	@Override
	public SalaryComponent updateImpl(
		com.rknowsys.eapp.hrm.model.SalaryComponent salaryComponent)
		throws SystemException {
		salaryComponent = toUnwrappedModel(salaryComponent);

		boolean isNew = salaryComponent.isNew();

		SalaryComponentModelImpl salaryComponentModelImpl = (SalaryComponentModelImpl)salaryComponent;

		Session session = null;

		try {
			session = openSession();

			if (salaryComponent.isNew()) {
				session.save(salaryComponent);

				salaryComponent.setNew(false);
			}
			else {
				session.merge(salaryComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SalaryComponentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((salaryComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salaryComponentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { salaryComponentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((salaryComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SALARYCOMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salaryComponentModelImpl.getOriginalSalaryComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SALARYCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SALARYCOMPONENTID,
					args);

				args = new Object[] {
						salaryComponentModelImpl.getSalaryComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SALARYCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SALARYCOMPONENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			SalaryComponentImpl.class, salaryComponent.getPrimaryKey(),
			salaryComponent);

		return salaryComponent;
	}

	protected SalaryComponent toUnwrappedModel(SalaryComponent salaryComponent) {
		if (salaryComponent instanceof SalaryComponentImpl) {
			return salaryComponent;
		}

		SalaryComponentImpl salaryComponentImpl = new SalaryComponentImpl();

		salaryComponentImpl.setNew(salaryComponent.isNew());
		salaryComponentImpl.setPrimaryKey(salaryComponent.getPrimaryKey());

		salaryComponentImpl.setSalaryComponentId(salaryComponent.getSalaryComponentId());
		salaryComponentImpl.setCompanyId(salaryComponent.getCompanyId());
		salaryComponentImpl.setGroupId(salaryComponent.getGroupId());
		salaryComponentImpl.setCreateDate(salaryComponent.getCreateDate());
		salaryComponentImpl.setModifiedDate(salaryComponent.getModifiedDate());
		salaryComponentImpl.setUserId(salaryComponent.getUserId());
		salaryComponentImpl.setComponentName(salaryComponent.getComponentName());
		salaryComponentImpl.setType(salaryComponent.isType());
		salaryComponentImpl.setOnlyCTC(salaryComponent.isOnlyCTC());
		salaryComponentImpl.setValueType(salaryComponent.getValueType());

		return salaryComponentImpl;
	}

	/**
	 * Returns the salary component with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the salary component
	 * @return the salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalaryComponentException, SystemException {
		SalaryComponent salaryComponent = fetchByPrimaryKey(primaryKey);

		if (salaryComponent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalaryComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return salaryComponent;
	}

	/**
	 * Returns the salary component with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSalaryComponentException} if it could not be found.
	 *
	 * @param salaryComponentId the primary key of the salary component
	 * @return the salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchSalaryComponentException if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent findByPrimaryKey(long salaryComponentId)
		throws NoSuchSalaryComponentException, SystemException {
		return findByPrimaryKey((Serializable)salaryComponentId);
	}

	/**
	 * Returns the salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the salary component
	 * @return the salary component, or <code>null</code> if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SalaryComponent salaryComponent = (SalaryComponent)EntityCacheUtil.getResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
				SalaryComponentImpl.class, primaryKey);

		if (salaryComponent == _nullSalaryComponent) {
			return null;
		}

		if (salaryComponent == null) {
			Session session = null;

			try {
				session = openSession();

				salaryComponent = (SalaryComponent)session.get(SalaryComponentImpl.class,
						primaryKey);

				if (salaryComponent != null) {
					cacheResult(salaryComponent);
				}
				else {
					EntityCacheUtil.putResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
						SalaryComponentImpl.class, primaryKey,
						_nullSalaryComponent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
					SalaryComponentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return salaryComponent;
	}

	/**
	 * Returns the salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryComponentId the primary key of the salary component
	 * @return the salary component, or <code>null</code> if a salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SalaryComponent fetchByPrimaryKey(long salaryComponentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)salaryComponentId);
	}

	/**
	 * Returns all the salary components.
	 *
	 * @return the salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @return the range of salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary components
	 * @param end the upper bound of the range of salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SalaryComponent> findAll(int start, int end,
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

		List<SalaryComponent> list = (List<SalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SALARYCOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SALARYCOMPONENT;

				if (pagination) {
					sql = sql.concat(SalaryComponentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SalaryComponent>(list);
				}
				else {
					list = (List<SalaryComponent>)QueryUtil.list(q,
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
	 * Removes all the salary components from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SalaryComponent salaryComponent : findAll()) {
			remove(salaryComponent);
		}
	}

	/**
	 * Returns the number of salary components.
	 *
	 * @return the number of salary components
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

				Query q = session.createQuery(_SQL_COUNT_SALARYCOMPONENT);

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
	 * Initializes the salary component persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.SalaryComponent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SalaryComponent>> listenersList = new ArrayList<ModelListener<SalaryComponent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SalaryComponent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SalaryComponentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SALARYCOMPONENT = "SELECT salaryComponent FROM SalaryComponent salaryComponent";
	private static final String _SQL_SELECT_SALARYCOMPONENT_WHERE = "SELECT salaryComponent FROM SalaryComponent salaryComponent WHERE ";
	private static final String _SQL_COUNT_SALARYCOMPONENT = "SELECT COUNT(salaryComponent) FROM SalaryComponent salaryComponent";
	private static final String _SQL_COUNT_SALARYCOMPONENT_WHERE = "SELECT COUNT(salaryComponent) FROM SalaryComponent salaryComponent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "salaryComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SalaryComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SalaryComponent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SalaryComponentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static SalaryComponent _nullSalaryComponent = new SalaryComponentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SalaryComponent> toCacheModel() {
				return _nullSalaryComponentCacheModel;
			}
		};

	private static CacheModel<SalaryComponent> _nullSalaryComponentCacheModel = new CacheModel<SalaryComponent>() {
			@Override
			public SalaryComponent toEntityModel() {
				return _nullSalaryComponent;
			}
		};
}