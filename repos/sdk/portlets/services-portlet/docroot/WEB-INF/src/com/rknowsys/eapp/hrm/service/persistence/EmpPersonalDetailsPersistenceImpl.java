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

import com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the EmpPersonalDetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpPersonalDetailsPersistence
 * @see EmpPersonalDetailsUtil
 * @generated
 */
public class EmpPersonalDetailsPersistenceImpl extends BasePersistenceImpl<EmpPersonalDetails>
	implements EmpPersonalDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpPersonalDetailsUtil} to access the EmpPersonalDetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpPersonalDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpPersonalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpPersonalDetailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpPersonalDetailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpPersonalDetailses
	 * @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	 * @return the range of matching EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findByemployeeId(long employeeId,
		int start, int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpPersonalDetailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpPersonalDetailses
	 * @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<EmpPersonalDetails> list = (List<EmpPersonalDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpPersonalDetails empPersonalDetails : list) {
				if ((employeeId != empPersonalDetails.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPPERSONALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpPersonalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpPersonalDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpPersonalDetails>(list);
				}
				else {
					list = (List<EmpPersonalDetails>)QueryUtil.list(q,
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
	 * Returns the first EmpPersonalDetails in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpPersonalDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a matching EmpPersonalDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		EmpPersonalDetails empPersonalDetails = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empPersonalDetails != null) {
			return empPersonalDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpPersonalDetailsException(msg.toString());
	}

	/**
	 * Returns the first EmpPersonalDetails in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpPersonalDetails, or <code>null</code> if a matching EmpPersonalDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpPersonalDetails> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpPersonalDetails in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpPersonalDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a matching EmpPersonalDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		EmpPersonalDetails empPersonalDetails = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empPersonalDetails != null) {
			return empPersonalDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpPersonalDetailsException(msg.toString());
	}

	/**
	 * Returns the last EmpPersonalDetails in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpPersonalDetails, or <code>null</code> if a matching EmpPersonalDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpPersonalDetails> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the EmpPersonalDetailses before and after the current EmpPersonalDetails in the ordered set where employeeId = &#63;.
	 *
	 * @param empPersonalDetailsId the primary key of the current EmpPersonalDetails
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next EmpPersonalDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails[] findByemployeeId_PrevAndNext(
		long empPersonalDetailsId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		EmpPersonalDetails empPersonalDetails = findByPrimaryKey(empPersonalDetailsId);

		Session session = null;

		try {
			session = openSession();

			EmpPersonalDetails[] array = new EmpPersonalDetailsImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empPersonalDetails,
					employeeId, orderByComparator, true);

			array[1] = empPersonalDetails;

			array[2] = getByemployeeId_PrevAndNext(session, empPersonalDetails,
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

	protected EmpPersonalDetails getByemployeeId_PrevAndNext(Session session,
		EmpPersonalDetails empPersonalDetails, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPPERSONALDETAILS_WHERE);

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
			query.append(EmpPersonalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empPersonalDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpPersonalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EmpPersonalDetailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpPersonalDetails empPersonalDetails : findByemployeeId(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empPersonalDetails);
		}
	}

	/**
	 * Returns the number of EmpPersonalDetailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching EmpPersonalDetailses
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

			query.append(_SQL_COUNT_EMPPERSONALDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empPersonalDetails.employeeId = ?";

	public EmpPersonalDetailsPersistenceImpl() {
		setModelClass(EmpPersonalDetails.class);
	}

	/**
	 * Caches the EmpPersonalDetails in the entity cache if it is enabled.
	 *
	 * @param empPersonalDetails the EmpPersonalDetails
	 */
	@Override
	public void cacheResult(EmpPersonalDetails empPersonalDetails) {
		EntityCacheUtil.putResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class, empPersonalDetails.getPrimaryKey(),
			empPersonalDetails);

		empPersonalDetails.resetOriginalValues();
	}

	/**
	 * Caches the EmpPersonalDetailses in the entity cache if it is enabled.
	 *
	 * @param empPersonalDetailses the EmpPersonalDetailses
	 */
	@Override
	public void cacheResult(List<EmpPersonalDetails> empPersonalDetailses) {
		for (EmpPersonalDetails empPersonalDetails : empPersonalDetailses) {
			if (EntityCacheUtil.getResult(
						EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpPersonalDetailsImpl.class,
						empPersonalDetails.getPrimaryKey()) == null) {
				cacheResult(empPersonalDetails);
			}
			else {
				empPersonalDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpPersonalDetailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpPersonalDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpPersonalDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpPersonalDetails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpPersonalDetails empPersonalDetails) {
		EntityCacheUtil.removeResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class, empPersonalDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpPersonalDetails> empPersonalDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpPersonalDetails empPersonalDetails : empPersonalDetailses) {
			EntityCacheUtil.removeResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpPersonalDetailsImpl.class, empPersonalDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpPersonalDetails with the primary key. Does not add the EmpPersonalDetails to the database.
	 *
	 * @param empPersonalDetailsId the primary key for the new EmpPersonalDetails
	 * @return the new EmpPersonalDetails
	 */
	@Override
	public EmpPersonalDetails create(long empPersonalDetailsId) {
		EmpPersonalDetails empPersonalDetails = new EmpPersonalDetailsImpl();

		empPersonalDetails.setNew(true);
		empPersonalDetails.setPrimaryKey(empPersonalDetailsId);

		return empPersonalDetails;
	}

	/**
	 * Removes the EmpPersonalDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails remove(long empPersonalDetailsId)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		return remove((Serializable)empPersonalDetailsId);
	}

	/**
	 * Removes the EmpPersonalDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails remove(Serializable primaryKey)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpPersonalDetails empPersonalDetails = (EmpPersonalDetails)session.get(EmpPersonalDetailsImpl.class,
					primaryKey);

			if (empPersonalDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpPersonalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empPersonalDetails);
		}
		catch (NoSuchEmpPersonalDetailsException nsee) {
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
	protected EmpPersonalDetails removeImpl(
		EmpPersonalDetails empPersonalDetails) throws SystemException {
		empPersonalDetails = toUnwrappedModel(empPersonalDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empPersonalDetails)) {
				empPersonalDetails = (EmpPersonalDetails)session.get(EmpPersonalDetailsImpl.class,
						empPersonalDetails.getPrimaryKeyObj());
			}

			if (empPersonalDetails != null) {
				session.delete(empPersonalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empPersonalDetails != null) {
			clearCache(empPersonalDetails);
		}

		return empPersonalDetails;
	}

	@Override
	public EmpPersonalDetails updateImpl(
		com.rknowsys.eapp.hrm.model.EmpPersonalDetails empPersonalDetails)
		throws SystemException {
		empPersonalDetails = toUnwrappedModel(empPersonalDetails);

		boolean isNew = empPersonalDetails.isNew();

		EmpPersonalDetailsModelImpl empPersonalDetailsModelImpl = (EmpPersonalDetailsModelImpl)empPersonalDetails;

		Session session = null;

		try {
			session = openSession();

			if (empPersonalDetails.isNew()) {
				session.save(empPersonalDetails);

				empPersonalDetails.setNew(false);
			}
			else {
				session.merge(empPersonalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpPersonalDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empPersonalDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empPersonalDetailsModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empPersonalDetailsModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpPersonalDetailsImpl.class, empPersonalDetails.getPrimaryKey(),
			empPersonalDetails);

		return empPersonalDetails;
	}

	protected EmpPersonalDetails toUnwrappedModel(
		EmpPersonalDetails empPersonalDetails) {
		if (empPersonalDetails instanceof EmpPersonalDetailsImpl) {
			return empPersonalDetails;
		}

		EmpPersonalDetailsImpl empPersonalDetailsImpl = new EmpPersonalDetailsImpl();

		empPersonalDetailsImpl.setNew(empPersonalDetails.isNew());
		empPersonalDetailsImpl.setPrimaryKey(empPersonalDetails.getPrimaryKey());

		empPersonalDetailsImpl.setEmpPersonalDetailsId(empPersonalDetails.getEmpPersonalDetailsId());
		empPersonalDetailsImpl.setEmployeeId(empPersonalDetails.getEmployeeId());
		empPersonalDetailsImpl.setGroupId(empPersonalDetails.getGroupId());
		empPersonalDetailsImpl.setCompanyId(empPersonalDetails.getCompanyId());
		empPersonalDetailsImpl.setUserId(empPersonalDetails.getUserId());
		empPersonalDetailsImpl.setCreateDate(empPersonalDetails.getCreateDate());
		empPersonalDetailsImpl.setModifiedDate(empPersonalDetails.getModifiedDate());
		empPersonalDetailsImpl.setFirstName(empPersonalDetails.getFirstName());
		empPersonalDetailsImpl.setLastName(empPersonalDetails.getLastName());
		empPersonalDetailsImpl.setMiddleName(empPersonalDetails.getMiddleName());
		empPersonalDetailsImpl.setEmployeeNo(empPersonalDetails.getEmployeeNo());
		empPersonalDetailsImpl.setOtherId(empPersonalDetails.getOtherId());
		empPersonalDetailsImpl.setLicenseNo(empPersonalDetails.getLicenseNo());
		empPersonalDetailsImpl.setLicenseExpDate(empPersonalDetails.getLicenseExpDate());
		empPersonalDetailsImpl.setGender(empPersonalDetails.getGender());
		empPersonalDetailsImpl.setMaritalStatus(empPersonalDetails.getMaritalStatus());
		empPersonalDetailsImpl.setNationalityId(empPersonalDetails.getNationalityId());
		empPersonalDetailsImpl.setDateOfBirth(empPersonalDetails.getDateOfBirth());

		return empPersonalDetailsImpl;
	}

	/**
	 * Returns the EmpPersonalDetails with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		EmpPersonalDetails empPersonalDetails = fetchByPrimaryKey(primaryKey);

		if (empPersonalDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpPersonalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empPersonalDetails;
	}

	/**
	 * Returns the EmpPersonalDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException} if it could not be found.
	 *
	 * @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpPersonalDetailsException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails findByPrimaryKey(long empPersonalDetailsId)
		throws NoSuchEmpPersonalDetailsException, SystemException {
		return findByPrimaryKey((Serializable)empPersonalDetailsId);
	}

	/**
	 * Returns the EmpPersonalDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails, or <code>null</code> if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpPersonalDetails empPersonalDetails = (EmpPersonalDetails)EntityCacheUtil.getResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpPersonalDetailsImpl.class, primaryKey);

		if (empPersonalDetails == _nullEmpPersonalDetails) {
			return null;
		}

		if (empPersonalDetails == null) {
			Session session = null;

			try {
				session = openSession();

				empPersonalDetails = (EmpPersonalDetails)session.get(EmpPersonalDetailsImpl.class,
						primaryKey);

				if (empPersonalDetails != null) {
					cacheResult(empPersonalDetails);
				}
				else {
					EntityCacheUtil.putResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpPersonalDetailsImpl.class, primaryKey,
						_nullEmpPersonalDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpPersonalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmpPersonalDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empPersonalDetails;
	}

	/**
	 * Returns the EmpPersonalDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails, or <code>null</code> if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails fetchByPrimaryKey(long empPersonalDetailsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empPersonalDetailsId);
	}

	/**
	 * Returns all the EmpPersonalDetailses.
	 *
	 * @return the EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpPersonalDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpPersonalDetailses
	 * @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	 * @return the range of EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpPersonalDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpPersonalDetailses
	 * @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> findAll(int start, int end,
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

		List<EmpPersonalDetails> list = (List<EmpPersonalDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPPERSONALDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPPERSONALDETAILS;

				if (pagination) {
					sql = sql.concat(EmpPersonalDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpPersonalDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpPersonalDetails>(list);
				}
				else {
					list = (List<EmpPersonalDetails>)QueryUtil.list(q,
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
	 * Removes all the EmpPersonalDetailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpPersonalDetails empPersonalDetails : findAll()) {
			remove(empPersonalDetails);
		}
	}

	/**
	 * Returns the number of EmpPersonalDetailses.
	 *
	 * @return the number of EmpPersonalDetailses
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

				Query q = session.createQuery(_SQL_COUNT_EMPPERSONALDETAILS);

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
	 * Initializes the EmpPersonalDetails persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpPersonalDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpPersonalDetails>> listenersList = new ArrayList<ModelListener<EmpPersonalDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpPersonalDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpPersonalDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPPERSONALDETAILS = "SELECT empPersonalDetails FROM EmpPersonalDetails empPersonalDetails";
	private static final String _SQL_SELECT_EMPPERSONALDETAILS_WHERE = "SELECT empPersonalDetails FROM EmpPersonalDetails empPersonalDetails WHERE ";
	private static final String _SQL_COUNT_EMPPERSONALDETAILS = "SELECT COUNT(empPersonalDetails) FROM EmpPersonalDetails empPersonalDetails";
	private static final String _SQL_COUNT_EMPPERSONALDETAILS_WHERE = "SELECT COUNT(empPersonalDetails) FROM EmpPersonalDetails empPersonalDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empPersonalDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpPersonalDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpPersonalDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpPersonalDetailsPersistenceImpl.class);
	private static EmpPersonalDetails _nullEmpPersonalDetails = new EmpPersonalDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpPersonalDetails> toCacheModel() {
				return _nullEmpPersonalDetailsCacheModel;
			}
		};

	private static CacheModel<EmpPersonalDetails> _nullEmpPersonalDetailsCacheModel =
		new CacheModel<EmpPersonalDetails>() {
			@Override
			public EmpPersonalDetails toEntityModel() {
				return _nullEmpPersonalDetails;
			}
		};
}