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

import com.rknowsys.eapp.hrm.NoSuchEmpEducationException;
import com.rknowsys.eapp.hrm.model.EmpEducation;
import com.rknowsys.eapp.hrm.model.impl.EmpEducationImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpEducationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpEducationPersistence
 * @see EmpEducationUtil
 * @generated
 */
public class EmpEducationPersistenceImpl extends BasePersistenceImpl<EmpEducation>
	implements EmpEducationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpEducationUtil} to access the emp education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpEducationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, EmpEducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, EmpEducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, EmpEducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, EmpEducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpEducationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp educations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp educations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp educations
	 * @param end the upper bound of the range of emp educations (not inclusive)
	 * @return the range of matching emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp educations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp educations
	 * @param end the upper bound of the range of emp educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findByGroupId(long groupId, int start, int end,
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

		List<EmpEducation> list = (List<EmpEducation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpEducation empEducation : list) {
				if ((groupId != empEducation.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPEDUCATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpEducationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpEducation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpEducation>(list);
				}
				else {
					list = (List<EmpEducation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp education in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp education
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a matching emp education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpEducationException, SystemException {
		EmpEducation empEducation = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empEducation != null) {
			return empEducation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEducationException(msg.toString());
	}

	/**
	 * Returns the first emp education in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp education, or <code>null</code> if a matching emp education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpEducation> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp education in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp education
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a matching emp education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpEducationException, SystemException {
		EmpEducation empEducation = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (empEducation != null) {
			return empEducation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpEducationException(msg.toString());
	}

	/**
	 * Returns the last emp education in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp education, or <code>null</code> if a matching emp education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpEducation> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp educations before and after the current emp education in the ordered set where groupId = &#63;.
	 *
	 * @param empEducationId the primary key of the current emp education
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp education
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation[] findByGroupId_PrevAndNext(long empEducationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmpEducationException, SystemException {
		EmpEducation empEducation = findByPrimaryKey(empEducationId);

		Session session = null;

		try {
			session = openSession();

			EmpEducation[] array = new EmpEducationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empEducation, groupId,
					orderByComparator, true);

			array[1] = empEducation;

			array[2] = getByGroupId_PrevAndNext(session, empEducation, groupId,
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

	protected EmpEducation getByGroupId_PrevAndNext(Session session,
		EmpEducation empEducation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPEDUCATION_WHERE);

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
			query.append(EmpEducationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empEducation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpEducation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp educations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpEducation empEducation : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empEducation);
		}
	}

	/**
	 * Returns the number of emp educations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp educations
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

			query.append(_SQL_COUNT_EMPEDUCATION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empEducation.groupId = ?";

	public EmpEducationPersistenceImpl() {
		setModelClass(EmpEducation.class);
	}

	/**
	 * Caches the emp education in the entity cache if it is enabled.
	 *
	 * @param empEducation the emp education
	 */
	@Override
	public void cacheResult(EmpEducation empEducation) {
		EntityCacheUtil.putResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationImpl.class, empEducation.getPrimaryKey(), empEducation);

		empEducation.resetOriginalValues();
	}

	/**
	 * Caches the emp educations in the entity cache if it is enabled.
	 *
	 * @param empEducations the emp educations
	 */
	@Override
	public void cacheResult(List<EmpEducation> empEducations) {
		for (EmpEducation empEducation : empEducations) {
			if (EntityCacheUtil.getResult(
						EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
						EmpEducationImpl.class, empEducation.getPrimaryKey()) == null) {
				cacheResult(empEducation);
			}
			else {
				empEducation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp educations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpEducationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpEducationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp education.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpEducation empEducation) {
		EntityCacheUtil.removeResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationImpl.class, empEducation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpEducation> empEducations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpEducation empEducation : empEducations) {
			EntityCacheUtil.removeResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
				EmpEducationImpl.class, empEducation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp education with the primary key. Does not add the emp education to the database.
	 *
	 * @param empEducationId the primary key for the new emp education
	 * @return the new emp education
	 */
	@Override
	public EmpEducation create(long empEducationId) {
		EmpEducation empEducation = new EmpEducationImpl();

		empEducation.setNew(true);
		empEducation.setPrimaryKey(empEducationId);

		return empEducation;
	}

	/**
	 * Removes the emp education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empEducationId the primary key of the emp education
	 * @return the emp education that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation remove(long empEducationId)
		throws NoSuchEmpEducationException, SystemException {
		return remove((Serializable)empEducationId);
	}

	/**
	 * Removes the emp education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp education
	 * @return the emp education that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation remove(Serializable primaryKey)
		throws NoSuchEmpEducationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpEducation empEducation = (EmpEducation)session.get(EmpEducationImpl.class,
					primaryKey);

			if (empEducation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpEducationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empEducation);
		}
		catch (NoSuchEmpEducationException nsee) {
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
	protected EmpEducation removeImpl(EmpEducation empEducation)
		throws SystemException {
		empEducation = toUnwrappedModel(empEducation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empEducation)) {
				empEducation = (EmpEducation)session.get(EmpEducationImpl.class,
						empEducation.getPrimaryKeyObj());
			}

			if (empEducation != null) {
				session.delete(empEducation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empEducation != null) {
			clearCache(empEducation);
		}

		return empEducation;
	}

	@Override
	public EmpEducation updateImpl(
		com.rknowsys.eapp.hrm.model.EmpEducation empEducation)
		throws SystemException {
		empEducation = toUnwrappedModel(empEducation);

		boolean isNew = empEducation.isNew();

		EmpEducationModelImpl empEducationModelImpl = (EmpEducationModelImpl)empEducation;

		Session session = null;

		try {
			session = openSession();

			if (empEducation.isNew()) {
				session.save(empEducation);

				empEducation.setNew(false);
			}
			else {
				session.merge(empEducation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpEducationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empEducationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empEducationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empEducationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
			EmpEducationImpl.class, empEducation.getPrimaryKey(), empEducation);

		return empEducation;
	}

	protected EmpEducation toUnwrappedModel(EmpEducation empEducation) {
		if (empEducation instanceof EmpEducationImpl) {
			return empEducation;
		}

		EmpEducationImpl empEducationImpl = new EmpEducationImpl();

		empEducationImpl.setNew(empEducation.isNew());
		empEducationImpl.setPrimaryKey(empEducation.getPrimaryKey());

		empEducationImpl.setEmpEducationId(empEducation.getEmpEducationId());
		empEducationImpl.setEmployeeId(empEducation.getEmployeeId());
		empEducationImpl.setGroupId(empEducation.getGroupId());
		empEducationImpl.setCompanyId(empEducation.getCompanyId());
		empEducationImpl.setCreateDate(empEducation.getCreateDate());
		empEducationImpl.setModifiedDate(empEducation.getModifiedDate());
		empEducationImpl.setUserId(empEducation.getUserId());
		empEducationImpl.setEducationId(empEducation.getEducationId());
		empEducationImpl.setInstitute(empEducation.getInstitute());
		empEducationImpl.setMajor(empEducation.getMajor());
		empEducationImpl.setYear(empEducation.getYear());
		empEducationImpl.setStartDate(empEducation.getStartDate());
		empEducationImpl.setEndDate(empEducation.getEndDate());

		return empEducationImpl;
	}

	/**
	 * Returns the emp education with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp education
	 * @return the emp education
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpEducationException, SystemException {
		EmpEducation empEducation = fetchByPrimaryKey(primaryKey);

		if (empEducation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpEducationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empEducation;
	}

	/**
	 * Returns the emp education with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpEducationException} if it could not be found.
	 *
	 * @param empEducationId the primary key of the emp education
	 * @return the emp education
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpEducationException if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation findByPrimaryKey(long empEducationId)
		throws NoSuchEmpEducationException, SystemException {
		return findByPrimaryKey((Serializable)empEducationId);
	}

	/**
	 * Returns the emp education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp education
	 * @return the emp education, or <code>null</code> if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpEducation empEducation = (EmpEducation)EntityCacheUtil.getResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
				EmpEducationImpl.class, primaryKey);

		if (empEducation == _nullEmpEducation) {
			return null;
		}

		if (empEducation == null) {
			Session session = null;

			try {
				session = openSession();

				empEducation = (EmpEducation)session.get(EmpEducationImpl.class,
						primaryKey);

				if (empEducation != null) {
					cacheResult(empEducation);
				}
				else {
					EntityCacheUtil.putResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
						EmpEducationImpl.class, primaryKey, _nullEmpEducation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpEducationModelImpl.ENTITY_CACHE_ENABLED,
					EmpEducationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empEducation;
	}

	/**
	 * Returns the emp education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empEducationId the primary key of the emp education
	 * @return the emp education, or <code>null</code> if a emp education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpEducation fetchByPrimaryKey(long empEducationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empEducationId);
	}

	/**
	 * Returns all the emp educations.
	 *
	 * @return the emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp educations
	 * @param end the upper bound of the range of emp educations (not inclusive)
	 * @return the range of emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpEducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp educations
	 * @param end the upper bound of the range of emp educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpEducation> findAll(int start, int end,
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

		List<EmpEducation> list = (List<EmpEducation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPEDUCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPEDUCATION;

				if (pagination) {
					sql = sql.concat(EmpEducationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpEducation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpEducation>(list);
				}
				else {
					list = (List<EmpEducation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp educations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpEducation empEducation : findAll()) {
			remove(empEducation);
		}
	}

	/**
	 * Returns the number of emp educations.
	 *
	 * @return the number of emp educations
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

				Query q = session.createQuery(_SQL_COUNT_EMPEDUCATION);

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
	 * Initializes the emp education persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpEducation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpEducation>> listenersList = new ArrayList<ModelListener<EmpEducation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpEducation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpEducationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPEDUCATION = "SELECT empEducation FROM EmpEducation empEducation";
	private static final String _SQL_SELECT_EMPEDUCATION_WHERE = "SELECT empEducation FROM EmpEducation empEducation WHERE ";
	private static final String _SQL_COUNT_EMPEDUCATION = "SELECT COUNT(empEducation) FROM EmpEducation empEducation";
	private static final String _SQL_COUNT_EMPEDUCATION_WHERE = "SELECT COUNT(empEducation) FROM EmpEducation empEducation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empEducation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpEducation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpEducation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpEducationPersistenceImpl.class);
	private static EmpEducation _nullEmpEducation = new EmpEducationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpEducation> toCacheModel() {
				return _nullEmpEducationCacheModel;
			}
		};

	private static CacheModel<EmpEducation> _nullEmpEducationCacheModel = new CacheModel<EmpEducation>() {
			@Override
			public EmpEducation toEntityModel() {
				return _nullEmpEducation;
			}
		};
}