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

import com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException;
import com.rknowsys.eapp.hrm.model.EmpSalaryComponent;
import com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp salary component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSalaryComponentPersistence
 * @see EmpSalaryComponentUtil
 * @generated
 */
public class EmpSalaryComponentPersistenceImpl extends BasePersistenceImpl<EmpSalaryComponent>
	implements EmpSalaryComponentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpSalaryComponentUtil} to access the emp salary component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpSalaryComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpSalaryComponentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salary components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salary components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @return the range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salary components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByGroupId(long groupId, int start,
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

		List<EmpSalaryComponent> list = (List<EmpSalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalaryComponent empSalaryComponent : list) {
				if ((groupId != empSalaryComponent.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPSALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalaryComponent>(list);
				}
				else {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
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
	 * Returns the first emp salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the first emp salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSalaryComponent> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the last emp salary component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpSalaryComponent> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp salary components before and after the current emp salary component in the ordered set where groupId = &#63;.
	 *
	 * @param empSalaryEarningId the primary key of the current emp salary component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent[] findByGroupId_PrevAndNext(
		long empSalaryEarningId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = findByPrimaryKey(empSalaryEarningId);

		Session session = null;

		try {
			session = openSession();

			EmpSalaryComponent[] array = new EmpSalaryComponentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empSalaryComponent,
					groupId, orderByComparator, true);

			array[1] = empSalaryComponent;

			array[2] = getByGroupId_PrevAndNext(session, empSalaryComponent,
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

	protected EmpSalaryComponent getByGroupId_PrevAndNext(Session session,
		EmpSalaryComponent empSalaryComponent, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSALARYCOMPONENT_WHERE);

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
			query.append(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSalaryComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSalaryComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp salary components where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpSalaryComponent empSalaryComponent : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSalaryComponent);
		}
	}

	/**
	 * Returns the number of emp salary components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp salary components
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

			query.append(_SQL_COUNT_EMPSALARYCOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empSalaryComponent.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYEARNINGID =
		new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempSalaryEarningId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYEARNINGID =
		new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempSalaryEarningId", new String[] { Long.class.getName() },
			EmpSalaryComponentModelImpl.EMPSALARYEARNINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPSALARYEARNINGID = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempSalaryEarningId", new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salary components where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @return the matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId) throws SystemException {
		return findByempSalaryEarningId(empSalaryEarningId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salary components where empSalaryEarningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @return the range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId, int start, int end) throws SystemException {
		return findByempSalaryEarningId(empSalaryEarningId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salary components where empSalaryEarningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryEarningId(
		long empSalaryEarningId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYEARNINGID;
			finderArgs = new Object[] { empSalaryEarningId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYEARNINGID;
			finderArgs = new Object[] {
					empSalaryEarningId,
					
					start, end, orderByComparator
				};
		}

		List<EmpSalaryComponent> list = (List<EmpSalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalaryComponent empSalaryComponent : list) {
				if ((empSalaryEarningId != empSalaryComponent.getEmpSalaryEarningId())) {
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

			query.append(_SQL_SELECT_EMPSALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYEARNINGID_EMPSALARYEARNINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryEarningId);

				if (!pagination) {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalaryComponent>(list);
				}
				else {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
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
	 * Returns the first emp salary component in the ordered set where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByempSalaryEarningId_First(
		long empSalaryEarningId, OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByempSalaryEarningId_First(empSalaryEarningId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryEarningId=");
		msg.append(empSalaryEarningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the first emp salary component in the ordered set where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByempSalaryEarningId_First(
		long empSalaryEarningId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmpSalaryComponent> list = findByempSalaryEarningId(empSalaryEarningId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary component in the ordered set where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByempSalaryEarningId_Last(
		long empSalaryEarningId, OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByempSalaryEarningId_Last(empSalaryEarningId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryEarningId=");
		msg.append(empSalaryEarningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the last emp salary component in the ordered set where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByempSalaryEarningId_Last(
		long empSalaryEarningId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByempSalaryEarningId(empSalaryEarningId);

		if (count == 0) {
			return null;
		}

		List<EmpSalaryComponent> list = findByempSalaryEarningId(empSalaryEarningId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the emp salary components where empSalaryEarningId = &#63; from the database.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempSalaryEarningId(long empSalaryEarningId)
		throws SystemException {
		for (EmpSalaryComponent empSalaryComponent : findByempSalaryEarningId(
				empSalaryEarningId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSalaryComponent);
		}
	}

	/**
	 * Returns the number of emp salary components where empSalaryEarningId = &#63;.
	 *
	 * @param empSalaryEarningId the emp salary earning ID
	 * @return the number of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempSalaryEarningId(long empSalaryEarningId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPSALARYEARNINGID;

		Object[] finderArgs = new Object[] { empSalaryEarningId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPSALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYEARNINGID_EMPSALARYEARNINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryEarningId);

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

	private static final String _FINDER_COLUMN_EMPSALARYEARNINGID_EMPSALARYEARNINGID_2 =
		"empSalaryComponent.empSalaryEarningId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYID =
		new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByempSalaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID =
		new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED,
			EmpSalaryComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByempSalaryId",
			new String[] { Long.class.getName() },
			EmpSalaryComponentModelImpl.EMPSALARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPSALARYID = new FinderPath(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByempSalaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp salary components where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @return the matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryId(long empSalaryId)
		throws SystemException {
		return findByempSalaryId(empSalaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salary components where empSalaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryId the emp salary ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @return the range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryId(long empSalaryId,
		int start, int end) throws SystemException {
		return findByempSalaryId(empSalaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salary components where empSalaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empSalaryId the emp salary ID
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findByempSalaryId(long empSalaryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID;
			finderArgs = new Object[] { empSalaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPSALARYID;
			finderArgs = new Object[] { empSalaryId, start, end, orderByComparator };
		}

		List<EmpSalaryComponent> list = (List<EmpSalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSalaryComponent empSalaryComponent : list) {
				if ((empSalaryId != empSalaryComponent.getEmpSalaryId())) {
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

			query.append(_SQL_SELECT_EMPSALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryId);

				if (!pagination) {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalaryComponent>(list);
				}
				else {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
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
	 * Returns the first emp salary component in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByempSalaryId_First(long empSalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByempSalaryId_First(empSalaryId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryId=");
		msg.append(empSalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the first emp salary component in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByempSalaryId_First(long empSalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSalaryComponent> list = findByempSalaryId(empSalaryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp salary component in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByempSalaryId_Last(long empSalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByempSalaryId_Last(empSalaryId,
				orderByComparator);

		if (empSalaryComponent != null) {
			return empSalaryComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empSalaryId=");
		msg.append(empSalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSalaryComponentException(msg.toString());
	}

	/**
	 * Returns the last emp salary component in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp salary component, or <code>null</code> if a matching emp salary component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByempSalaryId_Last(long empSalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByempSalaryId(empSalaryId);

		if (count == 0) {
			return null;
		}

		List<EmpSalaryComponent> list = findByempSalaryId(empSalaryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp salary components before and after the current emp salary component in the ordered set where empSalaryId = &#63;.
	 *
	 * @param empSalaryEarningId the primary key of the current emp salary component
	 * @param empSalaryId the emp salary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent[] findByempSalaryId_PrevAndNext(
		long empSalaryEarningId, long empSalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = findByPrimaryKey(empSalaryEarningId);

		Session session = null;

		try {
			session = openSession();

			EmpSalaryComponent[] array = new EmpSalaryComponentImpl[3];

			array[0] = getByempSalaryId_PrevAndNext(session,
					empSalaryComponent, empSalaryId, orderByComparator, true);

			array[1] = empSalaryComponent;

			array[2] = getByempSalaryId_PrevAndNext(session,
					empSalaryComponent, empSalaryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpSalaryComponent getByempSalaryId_PrevAndNext(Session session,
		EmpSalaryComponent empSalaryComponent, long empSalaryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSALARYCOMPONENT_WHERE);

		query.append(_FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2);

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
			query.append(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empSalaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSalaryComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSalaryComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp salary components where empSalaryId = &#63; from the database.
	 *
	 * @param empSalaryId the emp salary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempSalaryId(long empSalaryId) throws SystemException {
		for (EmpSalaryComponent empSalaryComponent : findByempSalaryId(
				empSalaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSalaryComponent);
		}
	}

	/**
	 * Returns the number of emp salary components where empSalaryId = &#63;.
	 *
	 * @param empSalaryId the emp salary ID
	 * @return the number of matching emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempSalaryId(long empSalaryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPSALARYID;

		Object[] finderArgs = new Object[] { empSalaryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPSALARYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empSalaryId);

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

	private static final String _FINDER_COLUMN_EMPSALARYID_EMPSALARYID_2 = "empSalaryComponent.empSalaryId = ?";

	public EmpSalaryComponentPersistenceImpl() {
		setModelClass(EmpSalaryComponent.class);
	}

	/**
	 * Caches the emp salary component in the entity cache if it is enabled.
	 *
	 * @param empSalaryComponent the emp salary component
	 */
	@Override
	public void cacheResult(EmpSalaryComponent empSalaryComponent) {
		EntityCacheUtil.putResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentImpl.class, empSalaryComponent.getPrimaryKey(),
			empSalaryComponent);

		empSalaryComponent.resetOriginalValues();
	}

	/**
	 * Caches the emp salary components in the entity cache if it is enabled.
	 *
	 * @param empSalaryComponents the emp salary components
	 */
	@Override
	public void cacheResult(List<EmpSalaryComponent> empSalaryComponents) {
		for (EmpSalaryComponent empSalaryComponent : empSalaryComponents) {
			if (EntityCacheUtil.getResult(
						EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
						EmpSalaryComponentImpl.class,
						empSalaryComponent.getPrimaryKey()) == null) {
				cacheResult(empSalaryComponent);
			}
			else {
				empSalaryComponent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp salary components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpSalaryComponentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpSalaryComponentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp salary component.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpSalaryComponent empSalaryComponent) {
		EntityCacheUtil.removeResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentImpl.class, empSalaryComponent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpSalaryComponent> empSalaryComponents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpSalaryComponent empSalaryComponent : empSalaryComponents) {
			EntityCacheUtil.removeResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
				EmpSalaryComponentImpl.class, empSalaryComponent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp salary component with the primary key. Does not add the emp salary component to the database.
	 *
	 * @param empSalaryEarningId the primary key for the new emp salary component
	 * @return the new emp salary component
	 */
	@Override
	public EmpSalaryComponent create(long empSalaryEarningId) {
		EmpSalaryComponent empSalaryComponent = new EmpSalaryComponentImpl();

		empSalaryComponent.setNew(true);
		empSalaryComponent.setPrimaryKey(empSalaryEarningId);

		return empSalaryComponent;
	}

	/**
	 * Removes the emp salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empSalaryEarningId the primary key of the emp salary component
	 * @return the emp salary component that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent remove(long empSalaryEarningId)
		throws NoSuchEmpSalaryComponentException, SystemException {
		return remove((Serializable)empSalaryEarningId);
	}

	/**
	 * Removes the emp salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp salary component
	 * @return the emp salary component that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent remove(Serializable primaryKey)
		throws NoSuchEmpSalaryComponentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpSalaryComponent empSalaryComponent = (EmpSalaryComponent)session.get(EmpSalaryComponentImpl.class,
					primaryKey);

			if (empSalaryComponent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpSalaryComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empSalaryComponent);
		}
		catch (NoSuchEmpSalaryComponentException nsee) {
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
	protected EmpSalaryComponent removeImpl(
		EmpSalaryComponent empSalaryComponent) throws SystemException {
		empSalaryComponent = toUnwrappedModel(empSalaryComponent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empSalaryComponent)) {
				empSalaryComponent = (EmpSalaryComponent)session.get(EmpSalaryComponentImpl.class,
						empSalaryComponent.getPrimaryKeyObj());
			}

			if (empSalaryComponent != null) {
				session.delete(empSalaryComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empSalaryComponent != null) {
			clearCache(empSalaryComponent);
		}

		return empSalaryComponent;
	}

	@Override
	public EmpSalaryComponent updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent)
		throws SystemException {
		empSalaryComponent = toUnwrappedModel(empSalaryComponent);

		boolean isNew = empSalaryComponent.isNew();

		EmpSalaryComponentModelImpl empSalaryComponentModelImpl = (EmpSalaryComponentModelImpl)empSalaryComponent;

		Session session = null;

		try {
			session = openSession();

			if (empSalaryComponent.isNew()) {
				session.save(empSalaryComponent);

				empSalaryComponent.setNew(false);
			}
			else {
				session.merge(empSalaryComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpSalaryComponentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empSalaryComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryComponentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empSalaryComponentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empSalaryComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYEARNINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryComponentModelImpl.getOriginalEmpSalaryEarningId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYEARNINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYEARNINGID,
					args);

				args = new Object[] {
						empSalaryComponentModelImpl.getEmpSalaryEarningId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYEARNINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYEARNINGID,
					args);
			}

			if ((empSalaryComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSalaryComponentModelImpl.getOriginalEmpSalaryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID,
					args);

				args = new Object[] { empSalaryComponentModelImpl.getEmpSalaryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPSALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPSALARYID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
			EmpSalaryComponentImpl.class, empSalaryComponent.getPrimaryKey(),
			empSalaryComponent);

		return empSalaryComponent;
	}

	protected EmpSalaryComponent toUnwrappedModel(
		EmpSalaryComponent empSalaryComponent) {
		if (empSalaryComponent instanceof EmpSalaryComponentImpl) {
			return empSalaryComponent;
		}

		EmpSalaryComponentImpl empSalaryComponentImpl = new EmpSalaryComponentImpl();

		empSalaryComponentImpl.setNew(empSalaryComponent.isNew());
		empSalaryComponentImpl.setPrimaryKey(empSalaryComponent.getPrimaryKey());

		empSalaryComponentImpl.setEmpSalaryEarningId(empSalaryComponent.getEmpSalaryEarningId());
		empSalaryComponentImpl.setEmpSalaryId(empSalaryComponent.getEmpSalaryId());
		empSalaryComponentImpl.setGroupId(empSalaryComponent.getGroupId());
		empSalaryComponentImpl.setCompanyId(empSalaryComponent.getCompanyId());
		empSalaryComponentImpl.setCreateDate(empSalaryComponent.getCreateDate());
		empSalaryComponentImpl.setModifiedDate(empSalaryComponent.getModifiedDate());
		empSalaryComponentImpl.setUserId(empSalaryComponent.getUserId());
		empSalaryComponentImpl.setSalaryComponentId(empSalaryComponent.getSalaryComponentId());
		empSalaryComponentImpl.setAmount(empSalaryComponent.getAmount());
		empSalaryComponentImpl.setEffectiveDate(empSalaryComponent.getEffectiveDate());

		return empSalaryComponentImpl;
	}

	/**
	 * Returns the emp salary component with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp salary component
	 * @return the emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpSalaryComponentException, SystemException {
		EmpSalaryComponent empSalaryComponent = fetchByPrimaryKey(primaryKey);

		if (empSalaryComponent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpSalaryComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empSalaryComponent;
	}

	/**
	 * Returns the emp salary component with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException} if it could not be found.
	 *
	 * @param empSalaryEarningId the primary key of the emp salary component
	 * @return the emp salary component
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSalaryComponentException if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent findByPrimaryKey(long empSalaryEarningId)
		throws NoSuchEmpSalaryComponentException, SystemException {
		return findByPrimaryKey((Serializable)empSalaryEarningId);
	}

	/**
	 * Returns the emp salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp salary component
	 * @return the emp salary component, or <code>null</code> if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpSalaryComponent empSalaryComponent = (EmpSalaryComponent)EntityCacheUtil.getResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
				EmpSalaryComponentImpl.class, primaryKey);

		if (empSalaryComponent == _nullEmpSalaryComponent) {
			return null;
		}

		if (empSalaryComponent == null) {
			Session session = null;

			try {
				session = openSession();

				empSalaryComponent = (EmpSalaryComponent)session.get(EmpSalaryComponentImpl.class,
						primaryKey);

				if (empSalaryComponent != null) {
					cacheResult(empSalaryComponent);
				}
				else {
					EntityCacheUtil.putResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
						EmpSalaryComponentImpl.class, primaryKey,
						_nullEmpSalaryComponent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpSalaryComponentModelImpl.ENTITY_CACHE_ENABLED,
					EmpSalaryComponentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empSalaryComponent;
	}

	/**
	 * Returns the emp salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empSalaryEarningId the primary key of the emp salary component
	 * @return the emp salary component, or <code>null</code> if a emp salary component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSalaryComponent fetchByPrimaryKey(long empSalaryEarningId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empSalaryEarningId);
	}

	/**
	 * Returns all the emp salary components.
	 *
	 * @return the emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @return the range of emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp salary components
	 * @param end the upper bound of the range of emp salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp salary components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSalaryComponent> findAll(int start, int end,
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

		List<EmpSalaryComponent> list = (List<EmpSalaryComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPSALARYCOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPSALARYCOMPONENT;

				if (pagination) {
					sql = sql.concat(EmpSalaryComponentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSalaryComponent>(list);
				}
				else {
					list = (List<EmpSalaryComponent>)QueryUtil.list(q,
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
	 * Removes all the emp salary components from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpSalaryComponent empSalaryComponent : findAll()) {
			remove(empSalaryComponent);
		}
	}

	/**
	 * Returns the number of emp salary components.
	 *
	 * @return the number of emp salary components
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

				Query q = session.createQuery(_SQL_COUNT_EMPSALARYCOMPONENT);

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
	 * Initializes the emp salary component persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpSalaryComponent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpSalaryComponent>> listenersList = new ArrayList<ModelListener<EmpSalaryComponent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpSalaryComponent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpSalaryComponentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPSALARYCOMPONENT = "SELECT empSalaryComponent FROM EmpSalaryComponent empSalaryComponent";
	private static final String _SQL_SELECT_EMPSALARYCOMPONENT_WHERE = "SELECT empSalaryComponent FROM EmpSalaryComponent empSalaryComponent WHERE ";
	private static final String _SQL_COUNT_EMPSALARYCOMPONENT = "SELECT COUNT(empSalaryComponent) FROM EmpSalaryComponent empSalaryComponent";
	private static final String _SQL_COUNT_EMPSALARYCOMPONENT_WHERE = "SELECT COUNT(empSalaryComponent) FROM EmpSalaryComponent empSalaryComponent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empSalaryComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpSalaryComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpSalaryComponent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpSalaryComponentPersistenceImpl.class);
	private static EmpSalaryComponent _nullEmpSalaryComponent = new EmpSalaryComponentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpSalaryComponent> toCacheModel() {
				return _nullEmpSalaryComponentCacheModel;
			}
		};

	private static CacheModel<EmpSalaryComponent> _nullEmpSalaryComponentCacheModel =
		new CacheModel<EmpSalaryComponent>() {
			@Override
			public EmpSalaryComponent toEntityModel() {
				return _nullEmpSalaryComponent;
			}
		};
}