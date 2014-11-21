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

import com.rknowsys.eapp.hrm.NoSuchSkillException;
import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.model.impl.SkillImpl;
import com.rknowsys.eapp.hrm.model.impl.SkillModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the skill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SkillPersistence
 * @see SkillUtil
 * @generated
 */
public class SkillPersistenceImpl extends BasePersistenceImpl<Skill>
	implements SkillPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkillUtil} to access the skill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkillImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SkillModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the skills where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skills where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @return the range of matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the skills where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByGroupId(long groupId, int start, int end,
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

		List<Skill> list = (List<Skill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Skill skill : list) {
				if ((groupId != skill.getGroupId())) {
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

			query.append(_SQL_SELECT_SKILL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SkillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Skill>(list);
				}
				else {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByGroupId_First(groupId, orderByComparator);

		if (skill != null) {
			return skill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkillException(msg.toString());
	}

	/**
	 * Returns the first skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill, or <code>null</code> if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Skill> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByGroupId_Last(groupId, orderByComparator);

		if (skill != null) {
			return skill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkillException(msg.toString());
	}

	/**
	 * Returns the last skill in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill, or <code>null</code> if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Skill> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the skills before and after the current skill in the ordered set where groupId = &#63;.
	 *
	 * @param skillId the primary key of the current skill
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill[] findByGroupId_PrevAndNext(long skillId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSkillException, SystemException {
		Skill skill = findByPrimaryKey(skillId);

		Session session = null;

		try {
			session = openSession();

			Skill[] array = new SkillImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, skill, groupId,
					orderByComparator, true);

			array[1] = skill;

			array[2] = getByGroupId_PrevAndNext(session, skill, groupId,
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

	protected Skill getByGroupId_PrevAndNext(Session session, Skill skill,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKILL_WHERE);

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
			query.append(SkillModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skill);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Skill> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the skills where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Skill skill : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(skill);
		}
	}

	/**
	 * Returns the number of skills where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching skills
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

			query.append(_SQL_COUNT_SKILL_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "skill.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SKILLID = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByskillId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID =
		new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByskillId",
			new String[] { Long.class.getName() },
			SkillModelImpl.SKILLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SKILLID = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByskillId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the skills where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @return the matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByskillId(long skillId) throws SystemException {
		return findByskillId(skillId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skills where skillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param skillId the skill ID
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @return the range of matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByskillId(long skillId, int start, int end)
		throws SystemException {
		return findByskillId(skillId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the skills where skillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param skillId the skill ID
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findByskillId(long skillId, int start, int end,
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

		List<Skill> list = (List<Skill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Skill skill : list) {
				if ((skillId != skill.getSkillId())) {
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

			query.append(_SQL_SELECT_SKILL_WHERE);

			query.append(_FINDER_COLUMN_SKILLID_SKILLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SkillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skillId);

				if (!pagination) {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Skill>(list);
				}
				else {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByskillId_First(long skillId,
		OrderByComparator orderByComparator)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByskillId_First(skillId, orderByComparator);

		if (skill != null) {
			return skill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skillId=");
		msg.append(skillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkillException(msg.toString());
	}

	/**
	 * Returns the first skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill, or <code>null</code> if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByskillId_First(long skillId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Skill> list = findByskillId(skillId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByskillId_Last(long skillId,
		OrderByComparator orderByComparator)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByskillId_Last(skillId, orderByComparator);

		if (skill != null) {
			return skill;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skillId=");
		msg.append(skillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkillException(msg.toString());
	}

	/**
	 * Returns the last skill in the ordered set where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill, or <code>null</code> if a matching skill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByskillId_Last(long skillId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByskillId(skillId);

		if (count == 0) {
			return null;
		}

		List<Skill> list = findByskillId(skillId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the skills where skillId = &#63; from the database.
	 *
	 * @param skillId the skill ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByskillId(long skillId) throws SystemException {
		for (Skill skill : findByskillId(skillId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(skill);
		}
	}

	/**
	 * Returns the number of skills where skillId = &#63;.
	 *
	 * @param skillId the skill ID
	 * @return the number of matching skills
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

			query.append(_SQL_COUNT_SKILL_WHERE);

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

	private static final String _FINDER_COLUMN_SKILLID_SKILLID_2 = "skill.skillId = ?";

	public SkillPersistenceImpl() {
		setModelClass(Skill.class);
	}

	/**
	 * Caches the skill in the entity cache if it is enabled.
	 *
	 * @param skill the skill
	 */
	@Override
	public void cacheResult(Skill skill) {
		EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey(), skill);

		skill.resetOriginalValues();
	}

	/**
	 * Caches the skills in the entity cache if it is enabled.
	 *
	 * @param skills the skills
	 */
	@Override
	public void cacheResult(List<Skill> skills) {
		for (Skill skill : skills) {
			if (EntityCacheUtil.getResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
						SkillImpl.class, skill.getPrimaryKey()) == null) {
				cacheResult(skill);
			}
			else {
				skill.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skills.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SkillImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SkillImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skill.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Skill skill) {
		EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Skill> skills) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Skill skill : skills) {
			EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
				SkillImpl.class, skill.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skill with the primary key. Does not add the skill to the database.
	 *
	 * @param skillId the primary key for the new skill
	 * @return the new skill
	 */
	@Override
	public Skill create(long skillId) {
		Skill skill = new SkillImpl();

		skill.setNew(true);
		skill.setPrimaryKey(skillId);

		return skill;
	}

	/**
	 * Removes the skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill remove(long skillId)
		throws NoSuchSkillException, SystemException {
		return remove((Serializable)skillId);
	}

	/**
	 * Removes the skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill remove(Serializable primaryKey)
		throws NoSuchSkillException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Skill skill = (Skill)session.get(SkillImpl.class, primaryKey);

			if (skill == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skill);
		}
		catch (NoSuchSkillException nsee) {
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
	protected Skill removeImpl(Skill skill) throws SystemException {
		skill = toUnwrappedModel(skill);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skill)) {
				skill = (Skill)session.get(SkillImpl.class,
						skill.getPrimaryKeyObj());
			}

			if (skill != null) {
				session.delete(skill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skill != null) {
			clearCache(skill);
		}

		return skill;
	}

	@Override
	public Skill updateImpl(com.rknowsys.eapp.hrm.model.Skill skill)
		throws SystemException {
		skill = toUnwrappedModel(skill);

		boolean isNew = skill.isNew();

		SkillModelImpl skillModelImpl = (SkillModelImpl)skill;

		Session session = null;

		try {
			session = openSession();

			if (skill.isNew()) {
				session.save(skill);

				skill.setNew(false);
			}
			else {
				session.merge(skill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SkillModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { skillModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { skillModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((skillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { skillModelImpl.getOriginalSkillId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SKILLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID,
					args);

				args = new Object[] { skillModelImpl.getSkillId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SKILLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SKILLID,
					args);
			}
		}

		EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey(), skill);

		return skill;
	}

	protected Skill toUnwrappedModel(Skill skill) {
		if (skill instanceof SkillImpl) {
			return skill;
		}

		SkillImpl skillImpl = new SkillImpl();

		skillImpl.setNew(skill.isNew());
		skillImpl.setPrimaryKey(skill.getPrimaryKey());

		skillImpl.setSkillId(skill.getSkillId());
		skillImpl.setCompanyId(skill.getCompanyId());
		skillImpl.setGroupId(skill.getGroupId());
		skillImpl.setCreateDate(skill.getCreateDate());
		skillImpl.setModifiedDate(skill.getModifiedDate());
		skillImpl.setUserId(skill.getUserId());
		skillImpl.setSkillName(skill.getSkillName());
		skillImpl.setDescription(skill.getDescription());

		return skillImpl;
	}

	/**
	 * Returns the skill with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByPrimaryKey(primaryKey);

		if (skill == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skill;
	}

	/**
	 * Returns the skill with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSkillException} if it could not be found.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill
	 * @throws com.rknowsys.eapp.hrm.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByPrimaryKey(long skillId)
		throws NoSuchSkillException, SystemException {
		return findByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns the skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill, or <code>null</code> if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Skill skill = (Skill)EntityCacheUtil.getResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
				SkillImpl.class, primaryKey);

		if (skill == _nullSkill) {
			return null;
		}

		if (skill == null) {
			Session session = null;

			try {
				session = openSession();

				skill = (Skill)session.get(SkillImpl.class, primaryKey);

				if (skill != null) {
					cacheResult(skill);
				}
				else {
					EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
						SkillImpl.class, primaryKey, _nullSkill);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
					SkillImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skill;
	}

	/**
	 * Returns the skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill, or <code>null</code> if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByPrimaryKey(long skillId) throws SystemException {
		return fetchByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns all the skills.
	 *
	 * @return the skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @return the range of skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll(int start, int end,
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

		List<Skill> list = (List<Skill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKILL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKILL;

				if (pagination) {
					sql = sql.concat(SkillModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Skill>(list);
				}
				else {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the skills from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Skill skill : findAll()) {
			remove(skill);
		}
	}

	/**
	 * Returns the number of skills.
	 *
	 * @return the number of skills
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

				Query q = session.createQuery(_SQL_COUNT_SKILL);

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
	 * Initializes the skill persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Skill")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Skill>> listenersList = new ArrayList<ModelListener<Skill>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Skill>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SkillImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKILL = "SELECT skill FROM Skill skill";
	private static final String _SQL_SELECT_SKILL_WHERE = "SELECT skill FROM Skill skill WHERE ";
	private static final String _SQL_COUNT_SKILL = "SELECT COUNT(skill) FROM Skill skill";
	private static final String _SQL_COUNT_SKILL_WHERE = "SELECT COUNT(skill) FROM Skill skill WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skill.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Skill exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Skill exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SkillPersistenceImpl.class);
	private static Skill _nullSkill = new SkillImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Skill> toCacheModel() {
				return _nullSkillCacheModel;
			}
		};

	private static CacheModel<Skill> _nullSkillCacheModel = new CacheModel<Skill>() {
			@Override
			public Skill toEntityModel() {
				return _nullSkill;
			}
		};
}