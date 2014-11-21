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

import com.rknowsys.eapp.hrm.NoSuchEmpSkillException;
import com.rknowsys.eapp.hrm.model.EmpSkill;
import com.rknowsys.eapp.hrm.model.impl.EmpSkillImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp skill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSkillPersistence
 * @see EmpSkillUtil
 * @generated
 */
public class EmpSkillPersistenceImpl extends BasePersistenceImpl<EmpSkill>
	implements EmpSkillPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpSkillUtil} to access the emp skill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpSkillImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpSkillModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp skills where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp skills where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @return the range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp skills where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByGroupId(long groupId, int start, int end,
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

		List<EmpSkill> list = (List<EmpSkill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSkill empSkill : list) {
				if ((groupId != empSkill.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPSKILL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSkill>(list);
				}
				else {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByGroupId_First(groupId, orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the first emp skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSkill> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByGroupId_Last(groupId, orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the last emp skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpSkill> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp skills before and after the current emp skill in the ordered set where groupId = &#63;.
	 *
	 * @param empSkillId the primary key of the current emp skill
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill[] findByGroupId_PrevAndNext(long empSkillId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = findByPrimaryKey(empSkillId);

		Session session = null;

		try {
			session = openSession();

			EmpSkill[] array = new EmpSkillImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empSkill, groupId,
					orderByComparator, true);

			array[1] = empSkill;

			array[2] = getByGroupId_PrevAndNext(session, empSkill, groupId,
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

	protected EmpSkill getByGroupId_PrevAndNext(Session session,
		EmpSkill empSkill, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSKILL_WHERE);

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
			query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSkill);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSkill> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp skills where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpSkill empSkill : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empSkill);
		}
	}

	/**
	 * Returns the number of emp skills where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp skills
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

			query.append(_SQL_COUNT_EMPSKILL_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empSkill.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SKILLID = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByskillId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID =
		new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByskillId",
			new String[] { Long.class.getName() },
			EmpSkillModelImpl.SKILLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SKILLID = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByskillId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp skills where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @return the matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByskillId(long skillId) throws SystemException {
		return findByskillId(skillId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp skills where skillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param skillId the skill ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @return the range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByskillId(long skillId, int start, int end)
		throws SystemException {
		return findByskillId(skillId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp skills where skillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param skillId the skill ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByskillId(long skillId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID;
			finderArgs = new Object[] { skillId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SKILLID;
			finderArgs = new Object[] { skillId, start, end, orderByComparator };
		}

		List<EmpSkill> list = (List<EmpSkill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSkill empSkill : list) {
				if ((skillId != empSkill.getSkillId())) {
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

			query.append(_SQL_SELECT_EMPSKILL_WHERE);

			query.append(_FINDER_COLUMN_SKILLID_SKILLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skillId);

				if (!pagination) {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSkill>(list);
				}
				else {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByskillId_First(long skillId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByskillId_First(skillId, orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skillId=");
		msg.append(skillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the first emp skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByskillId_First(long skillId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSkill> list = findByskillId(skillId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByskillId_Last(long skillId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByskillId_Last(skillId, orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skillId=");
		msg.append(skillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the last emp skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByskillId_Last(long skillId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByskillId(skillId);

		if (count == 0) {
			return null;
		}

		List<EmpSkill> list = findByskillId(skillId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp skills before and after the current emp skill in the ordered set where skillId = &#63;.
	 *
	 * @param empSkillId the primary key of the current emp skill
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill[] findByskillId_PrevAndNext(long empSkillId, long skillId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = findByPrimaryKey(empSkillId);

		Session session = null;

		try {
			session = openSession();

			EmpSkill[] array = new EmpSkillImpl[3];

			array[0] = getByskillId_PrevAndNext(session, empSkill, skillId,
					orderByComparator, true);

			array[1] = empSkill;

			array[2] = getByskillId_PrevAndNext(session, empSkill, skillId,
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

	protected EmpSkill getByskillId_PrevAndNext(Session session,
		EmpSkill empSkill, long skillId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSKILL_WHERE);

		query.append(_FINDER_COLUMN_SKILLID_SKILLID_2);

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
			query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skillId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSkill);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSkill> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp skills where skillId = &#63; from the database.
	 *
	 * @param skillId the skill ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByskillId(long skillId) throws SystemException {
		for (EmpSkill empSkill : findByskillId(skillId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empSkill);
		}
	}

	/**
	 * Returns the number of emp skills where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @return the number of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByskillId(long skillId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SKILLID;

		Object[] finderArgs = new Object[] { skillId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPSKILL_WHERE);

			query.append(_FINDER_COLUMN_SKILLID_SKILLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skillId);

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

	private static final String _FINDER_COLUMN_SKILLID_SKILLID_2 = "empSkill.skillId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, EmpSkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpSkillModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp skills where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp skills where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @return the range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByemployeeId(long employeeId, int start, int end)
		throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp skills where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findByemployeeId(long employeeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<EmpSkill> list = (List<EmpSkill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpSkill empSkill : list) {
				if ((employeeId != empSkill.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPSKILL_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSkill>(list);
				}
				else {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp skill in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the first emp skill in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpSkill> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp skill in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByemployeeId_Last(employeeId, orderByComparator);

		if (empSkill != null) {
			return empSkill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpSkillException(msg.toString());
	}

	/**
	 * Returns the last emp skill in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp skill, or <code>null</code> if a matching emp skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpSkill> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp skills before and after the current emp skill in the ordered set where employeeId = &#63;.
	 *
	 * @param empSkillId the primary key of the current emp skill
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill[] findByemployeeId_PrevAndNext(long empSkillId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = findByPrimaryKey(empSkillId);

		Session session = null;

		try {
			session = openSession();

			EmpSkill[] array = new EmpSkillImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empSkill,
					employeeId, orderByComparator, true);

			array[1] = empSkill;

			array[2] = getByemployeeId_PrevAndNext(session, empSkill,
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

	protected EmpSkill getByemployeeId_PrevAndNext(Session session,
		EmpSkill empSkill, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPSKILL_WHERE);

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
			query.append(EmpSkillModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empSkill);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpSkill> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp skills where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpSkill empSkill : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empSkill);
		}
	}

	/**
	 * Returns the number of emp skills where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp skills
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

			query.append(_SQL_COUNT_EMPSKILL_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empSkill.employeeId = ?";

	public EmpSkillPersistenceImpl() {
		setModelClass(EmpSkill.class);
	}

	/**
	 * Caches the emp skill in the entity cache if it is enabled.
	 *
	 * @param empSkill the emp skill
	 */
	@Override
	public void cacheResult(EmpSkill empSkill) {
		EntityCacheUtil.putResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillImpl.class, empSkill.getPrimaryKey(), empSkill);

		empSkill.resetOriginalValues();
	}

	/**
	 * Caches the emp skills in the entity cache if it is enabled.
	 *
	 * @param empSkills the emp skills
	 */
	@Override
	public void cacheResult(List<EmpSkill> empSkills) {
		for (EmpSkill empSkill : empSkills) {
			if (EntityCacheUtil.getResult(
						EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
						EmpSkillImpl.class, empSkill.getPrimaryKey()) == null) {
				cacheResult(empSkill);
			}
			else {
				empSkill.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp skills.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpSkillImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpSkillImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp skill.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpSkill empSkill) {
		EntityCacheUtil.removeResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillImpl.class, empSkill.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpSkill> empSkills) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpSkill empSkill : empSkills) {
			EntityCacheUtil.removeResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
				EmpSkillImpl.class, empSkill.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp skill with the primary key. Does not add the emp skill to the database.
	 *
	 * @param empSkillId the primary key for the new emp skill
	 * @return the new emp skill
	 */
	@Override
	public EmpSkill create(long empSkillId) {
		EmpSkill empSkill = new EmpSkillImpl();

		empSkill.setNew(true);
		empSkill.setPrimaryKey(empSkillId);

		return empSkill;
	}

	/**
	 * Removes the emp skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empSkillId the primary key of the emp skill
	 * @return the emp skill that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill remove(long empSkillId)
		throws NoSuchEmpSkillException, SystemException {
		return remove((Serializable)empSkillId);
	}

	/**
	 * Removes the emp skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp skill
	 * @return the emp skill that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill remove(Serializable primaryKey)
		throws NoSuchEmpSkillException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpSkill empSkill = (EmpSkill)session.get(EmpSkillImpl.class,
					primaryKey);

			if (empSkill == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empSkill);
		}
		catch (NoSuchEmpSkillException nsee) {
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
	protected EmpSkill removeImpl(EmpSkill empSkill) throws SystemException {
		empSkill = toUnwrappedModel(empSkill);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empSkill)) {
				empSkill = (EmpSkill)session.get(EmpSkillImpl.class,
						empSkill.getPrimaryKeyObj());
			}

			if (empSkill != null) {
				session.delete(empSkill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empSkill != null) {
			clearCache(empSkill);
		}

		return empSkill;
	}

	@Override
	public EmpSkill updateImpl(com.rknowsys.eapp.hrm.model.EmpSkill empSkill)
		throws SystemException {
		empSkill = toUnwrappedModel(empSkill);

		boolean isNew = empSkill.isNew();

		EmpSkillModelImpl empSkillModelImpl = (EmpSkillModelImpl)empSkill;

		Session session = null;

		try {
			session = openSession();

			if (empSkill.isNew()) {
				session.save(empSkill);

				empSkill.setNew(false);
			}
			else {
				session.merge(empSkill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpSkillModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empSkillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSkillModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empSkillModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empSkillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSkillModelImpl.getOriginalSkillId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SKILLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID,
					args);

				args = new Object[] { empSkillModelImpl.getSkillId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SKILLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID,
					args);
			}

			if ((empSkillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empSkillModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empSkillModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
			EmpSkillImpl.class, empSkill.getPrimaryKey(), empSkill);

		return empSkill;
	}

	protected EmpSkill toUnwrappedModel(EmpSkill empSkill) {
		if (empSkill instanceof EmpSkillImpl) {
			return empSkill;
		}

		EmpSkillImpl empSkillImpl = new EmpSkillImpl();

		empSkillImpl.setNew(empSkill.isNew());
		empSkillImpl.setPrimaryKey(empSkill.getPrimaryKey());

		empSkillImpl.setEmpSkillId(empSkill.getEmpSkillId());
		empSkillImpl.setEmployeeId(empSkill.getEmployeeId());
		empSkillImpl.setGroupId(empSkill.getGroupId());
		empSkillImpl.setCompanyId(empSkill.getCompanyId());
		empSkillImpl.setCreateDate(empSkill.getCreateDate());
		empSkillImpl.setModifiedDate(empSkill.getModifiedDate());
		empSkillImpl.setUserId(empSkill.getUserId());
		empSkillImpl.setSkillId(empSkill.getSkillId());
		empSkillImpl.setYears(empSkill.getYears());
		empSkillImpl.setComments(empSkill.getComments());

		return empSkillImpl;
	}

	/**
	 * Returns the emp skill with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp skill
	 * @return the emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpSkillException, SystemException {
		EmpSkill empSkill = fetchByPrimaryKey(primaryKey);

		if (empSkill == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empSkill;
	}

	/**
	 * Returns the emp skill with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSkillException} if it could not be found.
	 *
	 * @param empSkillId the primary key of the emp skill
	 * @return the emp skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSkillException if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill findByPrimaryKey(long empSkillId)
		throws NoSuchEmpSkillException, SystemException {
		return findByPrimaryKey((Serializable)empSkillId);
	}

	/**
	 * Returns the emp skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp skill
	 * @return the emp skill, or <code>null</code> if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpSkill empSkill = (EmpSkill)EntityCacheUtil.getResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
				EmpSkillImpl.class, primaryKey);

		if (empSkill == _nullEmpSkill) {
			return null;
		}

		if (empSkill == null) {
			Session session = null;

			try {
				session = openSession();

				empSkill = (EmpSkill)session.get(EmpSkillImpl.class, primaryKey);

				if (empSkill != null) {
					cacheResult(empSkill);
				}
				else {
					EntityCacheUtil.putResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
						EmpSkillImpl.class, primaryKey, _nullEmpSkill);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpSkillModelImpl.ENTITY_CACHE_ENABLED,
					EmpSkillImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empSkill;
	}

	/**
	 * Returns the emp skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empSkillId the primary key of the emp skill
	 * @return the emp skill, or <code>null</code> if a emp skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSkill fetchByPrimaryKey(long empSkillId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empSkillId);
	}

	/**
	 * Returns all the emp skills.
	 *
	 * @return the emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @return the range of emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp skills
	 * @param end the upper bound of the range of emp skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSkill> findAll(int start, int end,
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

		List<EmpSkill> list = (List<EmpSkill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPSKILL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPSKILL;

				if (pagination) {
					sql = sql.concat(EmpSkillModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSkill>(list);
				}
				else {
					list = (List<EmpSkill>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp skills from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpSkill empSkill : findAll()) {
			remove(empSkill);
		}
	}

	/**
	 * Returns the number of emp skills.
	 *
	 * @return the number of emp skills
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

				Query q = session.createQuery(_SQL_COUNT_EMPSKILL);

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
	 * Initializes the emp skill persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpSkill")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpSkill>> listenersList = new ArrayList<ModelListener<EmpSkill>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpSkill>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpSkillImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPSKILL = "SELECT empSkill FROM EmpSkill empSkill";
	private static final String _SQL_SELECT_EMPSKILL_WHERE = "SELECT empSkill FROM EmpSkill empSkill WHERE ";
	private static final String _SQL_COUNT_EMPSKILL = "SELECT COUNT(empSkill) FROM EmpSkill empSkill";
	private static final String _SQL_COUNT_EMPSKILL_WHERE = "SELECT COUNT(empSkill) FROM EmpSkill empSkill WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empSkill.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpSkill exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpSkill exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpSkillPersistenceImpl.class);
	private static EmpSkill _nullEmpSkill = new EmpSkillImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpSkill> toCacheModel() {
				return _nullEmpSkillCacheModel;
			}
		};

	private static CacheModel<EmpSkill> _nullEmpSkillCacheModel = new CacheModel<EmpSkill>() {
			@Override
			public EmpSkill toEntityModel() {
				return _nullEmpSkill;
			}
		};
}