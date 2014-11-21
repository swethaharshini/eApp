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

import com.rknowsys.eapp.hrm.NoSuchEmpLicenseException;
import com.rknowsys.eapp.hrm.model.EmpLicense;
import com.rknowsys.eapp.hrm.model.impl.EmpLicenseImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpLicensePersistence
 * @see EmpLicenseUtil
 * @generated
 */
public class EmpLicensePersistenceImpl extends BasePersistenceImpl<EmpLicense>
	implements EmpLicensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpLicenseUtil} to access the emp license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpLicenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpLicenseModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp licenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp licenses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @return the range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp licenses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByGroupId(long groupId, int start, int end,
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

		List<EmpLicense> list = (List<EmpLicense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLicense empLicense : list) {
				if ((groupId != empLicense.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPLICENSE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLicense>(list);
				}
				else {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp license in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchByGroupId_First(groupId, orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the first emp license in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLicense> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp license in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchByGroupId_Last(groupId, orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the last emp license in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpLicense> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp licenses before and after the current emp license in the ordered set where groupId = &#63;.
	 *
	 * @param empLicenseId the primary key of the current emp license
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense[] findByGroupId_PrevAndNext(long empLicenseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = findByPrimaryKey(empLicenseId);

		Session session = null;

		try {
			session = openSession();

			EmpLicense[] array = new EmpLicenseImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empLicense, groupId,
					orderByComparator, true);

			array[1] = empLicense;

			array[2] = getByGroupId_PrevAndNext(session, empLicense, groupId,
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

	protected EmpLicense getByGroupId_PrevAndNext(Session session,
		EmpLicense empLicense, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLICENSE_WHERE);

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
			query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLicense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLicense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp licenses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpLicense empLicense : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empLicense);
		}
	}

	/**
	 * Returns the number of emp licenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp licenses
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

			query.append(_SQL_COUNT_EMPLICENSE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empLicense.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LICENSEID =
		new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylicenseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LICENSEID =
		new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylicenseId",
			new String[] { Long.class.getName() },
			EmpLicenseModelImpl.LICENSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LICENSEID = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylicenseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp licenses where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findBylicenseId(long licenseId)
		throws SystemException {
		return findBylicenseId(licenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the emp licenses where licenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param licenseId the license ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @return the range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findBylicenseId(long licenseId, int start, int end)
		throws SystemException {
		return findBylicenseId(licenseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp licenses where licenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param licenseId the license ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findBylicenseId(long licenseId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LICENSEID;
			finderArgs = new Object[] { licenseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LICENSEID;
			finderArgs = new Object[] { licenseId, start, end, orderByComparator };
		}

		List<EmpLicense> list = (List<EmpLicense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLicense empLicense : list) {
				if ((licenseId != empLicense.getLicenseId())) {
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

			query.append(_SQL_SELECT_EMPLICENSE_WHERE);

			query.append(_FINDER_COLUMN_LICENSEID_LICENSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(licenseId);

				if (!pagination) {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLicense>(list);
				}
				else {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp license in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findBylicenseId_First(long licenseId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchBylicenseId_First(licenseId,
				orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("licenseId=");
		msg.append(licenseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the first emp license in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchBylicenseId_First(long licenseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLicense> list = findBylicenseId(licenseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp license in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findBylicenseId_Last(long licenseId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchBylicenseId_Last(licenseId,
				orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("licenseId=");
		msg.append(licenseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the last emp license in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchBylicenseId_Last(long licenseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylicenseId(licenseId);

		if (count == 0) {
			return null;
		}

		List<EmpLicense> list = findBylicenseId(licenseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp licenses before and after the current emp license in the ordered set where licenseId = &#63;.
	 *
	 * @param empLicenseId the primary key of the current emp license
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense[] findBylicenseId_PrevAndNext(long empLicenseId,
		long licenseId, OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = findByPrimaryKey(empLicenseId);

		Session session = null;

		try {
			session = openSession();

			EmpLicense[] array = new EmpLicenseImpl[3];

			array[0] = getBylicenseId_PrevAndNext(session, empLicense,
					licenseId, orderByComparator, true);

			array[1] = empLicense;

			array[2] = getBylicenseId_PrevAndNext(session, empLicense,
					licenseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpLicense getBylicenseId_PrevAndNext(Session session,
		EmpLicense empLicense, long licenseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLICENSE_WHERE);

		query.append(_FINDER_COLUMN_LICENSEID_LICENSEID_2);

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
			query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(licenseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLicense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLicense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp licenses where licenseId = &#63; from the database.
	 *
	 * @param licenseId the license ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylicenseId(long licenseId) throws SystemException {
		for (EmpLicense empLicense : findBylicenseId(licenseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLicense);
		}
	}

	/**
	 * Returns the number of emp licenses where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the number of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylicenseId(long licenseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LICENSEID;

		Object[] finderArgs = new Object[] { licenseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLICENSE_WHERE);

			query.append(_FINDER_COLUMN_LICENSEID_LICENSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(licenseId);

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

	private static final String _FINDER_COLUMN_LICENSEID_LICENSEID_2 = "empLicense.licenseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, EmpLicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpLicenseModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp licenses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp licenses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @return the range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByemployeeId(long employeeId, int start, int end)
		throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp licenses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findByemployeeId(long employeeId, int start,
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

		List<EmpLicense> list = (List<EmpLicense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLicense empLicense : list) {
				if ((employeeId != empLicense.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPLICENSE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLicense>(list);
				}
				else {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp license in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the first emp license in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLicense> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp license in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empLicense != null) {
			return empLicense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLicenseException(msg.toString());
	}

	/**
	 * Returns the last emp license in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp license, or <code>null</code> if a matching emp license could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpLicense> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp licenses before and after the current emp license in the ordered set where employeeId = &#63;.
	 *
	 * @param empLicenseId the primary key of the current emp license
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense[] findByemployeeId_PrevAndNext(long empLicenseId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = findByPrimaryKey(empLicenseId);

		Session session = null;

		try {
			session = openSession();

			EmpLicense[] array = new EmpLicenseImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empLicense,
					employeeId, orderByComparator, true);

			array[1] = empLicense;

			array[2] = getByemployeeId_PrevAndNext(session, empLicense,
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

	protected EmpLicense getByemployeeId_PrevAndNext(Session session,
		EmpLicense empLicense, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLICENSE_WHERE);

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
			query.append(EmpLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLicense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLicense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp licenses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpLicense empLicense : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLicense);
		}
	}

	/**
	 * Returns the number of emp licenses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp licenses
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

			query.append(_SQL_COUNT_EMPLICENSE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empLicense.employeeId = ?";

	public EmpLicensePersistenceImpl() {
		setModelClass(EmpLicense.class);
	}

	/**
	 * Caches the emp license in the entity cache if it is enabled.
	 *
	 * @param empLicense the emp license
	 */
	@Override
	public void cacheResult(EmpLicense empLicense) {
		EntityCacheUtil.putResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseImpl.class, empLicense.getPrimaryKey(), empLicense);

		empLicense.resetOriginalValues();
	}

	/**
	 * Caches the emp licenses in the entity cache if it is enabled.
	 *
	 * @param empLicenses the emp licenses
	 */
	@Override
	public void cacheResult(List<EmpLicense> empLicenses) {
		for (EmpLicense empLicense : empLicenses) {
			if (EntityCacheUtil.getResult(
						EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
						EmpLicenseImpl.class, empLicense.getPrimaryKey()) == null) {
				cacheResult(empLicense);
			}
			else {
				empLicense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp licenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpLicenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpLicenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp license.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpLicense empLicense) {
		EntityCacheUtil.removeResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseImpl.class, empLicense.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpLicense> empLicenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpLicense empLicense : empLicenses) {
			EntityCacheUtil.removeResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
				EmpLicenseImpl.class, empLicense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp license with the primary key. Does not add the emp license to the database.
	 *
	 * @param empLicenseId the primary key for the new emp license
	 * @return the new emp license
	 */
	@Override
	public EmpLicense create(long empLicenseId) {
		EmpLicense empLicense = new EmpLicenseImpl();

		empLicense.setNew(true);
		empLicense.setPrimaryKey(empLicenseId);

		return empLicense;
	}

	/**
	 * Removes the emp license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empLicenseId the primary key of the emp license
	 * @return the emp license that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense remove(long empLicenseId)
		throws NoSuchEmpLicenseException, SystemException {
		return remove((Serializable)empLicenseId);
	}

	/**
	 * Removes the emp license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp license
	 * @return the emp license that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense remove(Serializable primaryKey)
		throws NoSuchEmpLicenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpLicense empLicense = (EmpLicense)session.get(EmpLicenseImpl.class,
					primaryKey);

			if (empLicense == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empLicense);
		}
		catch (NoSuchEmpLicenseException nsee) {
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
	protected EmpLicense removeImpl(EmpLicense empLicense)
		throws SystemException {
		empLicense = toUnwrappedModel(empLicense);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empLicense)) {
				empLicense = (EmpLicense)session.get(EmpLicenseImpl.class,
						empLicense.getPrimaryKeyObj());
			}

			if (empLicense != null) {
				session.delete(empLicense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empLicense != null) {
			clearCache(empLicense);
		}

		return empLicense;
	}

	@Override
	public EmpLicense updateImpl(
		com.rknowsys.eapp.hrm.model.EmpLicense empLicense)
		throws SystemException {
		empLicense = toUnwrappedModel(empLicense);

		boolean isNew = empLicense.isNew();

		EmpLicenseModelImpl empLicenseModelImpl = (EmpLicenseModelImpl)empLicense;

		Session session = null;

		try {
			session = openSession();

			if (empLicense.isNew()) {
				session.save(empLicense);

				empLicense.setNew(false);
			}
			else {
				session.merge(empLicense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpLicenseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empLicenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLicenseModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empLicenseModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empLicenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LICENSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLicenseModelImpl.getOriginalLicenseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LICENSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LICENSEID,
					args);

				args = new Object[] { empLicenseModelImpl.getLicenseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LICENSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LICENSEID,
					args);
			}

			if ((empLicenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLicenseModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empLicenseModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
			EmpLicenseImpl.class, empLicense.getPrimaryKey(), empLicense);

		return empLicense;
	}

	protected EmpLicense toUnwrappedModel(EmpLicense empLicense) {
		if (empLicense instanceof EmpLicenseImpl) {
			return empLicense;
		}

		EmpLicenseImpl empLicenseImpl = new EmpLicenseImpl();

		empLicenseImpl.setNew(empLicense.isNew());
		empLicenseImpl.setPrimaryKey(empLicense.getPrimaryKey());

		empLicenseImpl.setEmpLicenseId(empLicense.getEmpLicenseId());
		empLicenseImpl.setEmployeeId(empLicense.getEmployeeId());
		empLicenseImpl.setGroupId(empLicense.getGroupId());
		empLicenseImpl.setCompanyId(empLicense.getCompanyId());
		empLicenseImpl.setCreateDate(empLicense.getCreateDate());
		empLicenseImpl.setModifiedDate(empLicense.getModifiedDate());
		empLicenseImpl.setUserId(empLicense.getUserId());
		empLicenseImpl.setLicenseId(empLicense.getLicenseId());
		empLicenseImpl.setLicenseNumber(empLicense.getLicenseNumber());
		empLicenseImpl.setIssuedDate(empLicense.getIssuedDate());
		empLicenseImpl.setExpiryDate(empLicense.getExpiryDate());

		return empLicenseImpl;
	}

	/**
	 * Returns the emp license with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp license
	 * @return the emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpLicenseException, SystemException {
		EmpLicense empLicense = fetchByPrimaryKey(primaryKey);

		if (empLicense == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpLicenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empLicense;
	}

	/**
	 * Returns the emp license with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpLicenseException} if it could not be found.
	 *
	 * @param empLicenseId the primary key of the emp license
	 * @return the emp license
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLicenseException if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense findByPrimaryKey(long empLicenseId)
		throws NoSuchEmpLicenseException, SystemException {
		return findByPrimaryKey((Serializable)empLicenseId);
	}

	/**
	 * Returns the emp license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp license
	 * @return the emp license, or <code>null</code> if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpLicense empLicense = (EmpLicense)EntityCacheUtil.getResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
				EmpLicenseImpl.class, primaryKey);

		if (empLicense == _nullEmpLicense) {
			return null;
		}

		if (empLicense == null) {
			Session session = null;

			try {
				session = openSession();

				empLicense = (EmpLicense)session.get(EmpLicenseImpl.class,
						primaryKey);

				if (empLicense != null) {
					cacheResult(empLicense);
				}
				else {
					EntityCacheUtil.putResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
						EmpLicenseImpl.class, primaryKey, _nullEmpLicense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpLicenseModelImpl.ENTITY_CACHE_ENABLED,
					EmpLicenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empLicense;
	}

	/**
	 * Returns the emp license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empLicenseId the primary key of the emp license
	 * @return the emp license, or <code>null</code> if a emp license with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLicense fetchByPrimaryKey(long empLicenseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empLicenseId);
	}

	/**
	 * Returns all the emp licenses.
	 *
	 * @return the emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @return the range of emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp licenses
	 * @param end the upper bound of the range of emp licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp licenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLicense> findAll(int start, int end,
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

		List<EmpLicense> list = (List<EmpLicense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLICENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLICENSE;

				if (pagination) {
					sql = sql.concat(EmpLicenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLicense>(list);
				}
				else {
					list = (List<EmpLicense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp licenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpLicense empLicense : findAll()) {
			remove(empLicense);
		}
	}

	/**
	 * Returns the number of emp licenses.
	 *
	 * @return the number of emp licenses
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

				Query q = session.createQuery(_SQL_COUNT_EMPLICENSE);

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
	 * Initializes the emp license persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpLicense")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpLicense>> listenersList = new ArrayList<ModelListener<EmpLicense>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpLicense>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpLicenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLICENSE = "SELECT empLicense FROM EmpLicense empLicense";
	private static final String _SQL_SELECT_EMPLICENSE_WHERE = "SELECT empLicense FROM EmpLicense empLicense WHERE ";
	private static final String _SQL_COUNT_EMPLICENSE = "SELECT COUNT(empLicense) FROM EmpLicense empLicense";
	private static final String _SQL_COUNT_EMPLICENSE_WHERE = "SELECT COUNT(empLicense) FROM EmpLicense empLicense WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empLicense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpLicense exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpLicense exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpLicensePersistenceImpl.class);
	private static EmpLicense _nullEmpLicense = new EmpLicenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpLicense> toCacheModel() {
				return _nullEmpLicenseCacheModel;
			}
		};

	private static CacheModel<EmpLicense> _nullEmpLicenseCacheModel = new CacheModel<EmpLicense>() {
			@Override
			public EmpLicense toEntityModel() {
				return _nullEmpLicense;
			}
		};
}