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

import com.rknowsys.eapp.hrm.NoSuchLanguageException;
import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.model.impl.LanguageImpl;
import com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see LanguagePersistence
 * @see LanguageUtil
 * @generated
 */
public class LanguagePersistenceImpl extends BasePersistenceImpl<Language>
	implements LanguagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LanguageUtil} to access the language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LanguageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LanguageModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the languages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @return the range of matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findByGroupId(long groupId, int start, int end,
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

		List<Language> list = (List<Language>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Language language : list) {
				if ((groupId != language.getGroupId())) {
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

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Language>(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLanguageException, SystemException {
		Language language = fetchByGroupId_First(groupId, orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the first language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language, or <code>null</code> if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Language> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLanguageException, SystemException {
		Language language = fetchByGroupId_Last(groupId, orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the last language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language, or <code>null</code> if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Language> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the languages before and after the current language in the ordered set where groupId = &#63;.
	 *
	 * @param languageId the primary key of the current language
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language[] findByGroupId_PrevAndNext(long languageId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLanguageException, SystemException {
		Language language = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Language[] array = new LanguageImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, language, groupId,
					orderByComparator, true);

			array[1] = language;

			array[2] = getByGroupId_PrevAndNext(session, language, groupId,
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

	protected Language getByGroupId_PrevAndNext(Session session,
		Language language, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANGUAGE_WHERE);

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
			query.append(LanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(language);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Language> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languages where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Language language : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching languages
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

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "language.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGEID =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylanguageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylanguageId",
			new String[] { Long.class.getName() },
			LanguageModelImpl.LANGUAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGEID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylanguageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the languages where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findBylanguageId(long languageId)
		throws SystemException {
		return findBylanguageId(languageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languages where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @return the range of matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findBylanguageId(long languageId, int start, int end)
		throws SystemException {
		return findBylanguageId(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the languages where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findBylanguageId(long languageId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID;
			finderArgs = new Object[] { languageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGEID;
			finderArgs = new Object[] { languageId, start, end, orderByComparator };
		}

		List<Language> list = (List<Language>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Language language : list) {
				if ((languageId != language.getLanguageId())) {
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

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(languageId);

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Language>(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findBylanguageId_First(long languageId,
		OrderByComparator orderByComparator)
		throws NoSuchLanguageException, SystemException {
		Language language = fetchBylanguageId_First(languageId,
				orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageId=");
		msg.append(languageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the first language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language, or <code>null</code> if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchBylanguageId_First(long languageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Language> list = findBylanguageId(languageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findBylanguageId_Last(long languageId,
		OrderByComparator orderByComparator)
		throws NoSuchLanguageException, SystemException {
		Language language = fetchBylanguageId_Last(languageId, orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageId=");
		msg.append(languageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the last language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language, or <code>null</code> if a matching language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchBylanguageId_Last(long languageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylanguageId(languageId);

		if (count == 0) {
			return null;
		}

		List<Language> list = findBylanguageId(languageId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the languages where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylanguageId(long languageId) throws SystemException {
		for (Language language : findBylanguageId(languageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylanguageId(long languageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANGUAGEID;

		Object[] finderArgs = new Object[] { languageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(languageId);

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

	private static final String _FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2 = "language.languageId = ?";

	public LanguagePersistenceImpl() {
		setModelClass(Language.class);
	}

	/**
	 * Caches the language in the entity cache if it is enabled.
	 *
	 * @param language the language
	 */
	@Override
	public void cacheResult(Language language) {
		EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey(), language);

		language.resetOriginalValues();
	}

	/**
	 * Caches the languages in the entity cache if it is enabled.
	 *
	 * @param languages the languages
	 */
	@Override
	public void cacheResult(List<Language> languages) {
		for (Language language : languages) {
			if (EntityCacheUtil.getResult(
						LanguageModelImpl.ENTITY_CACHE_ENABLED,
						LanguageImpl.class, language.getPrimaryKey()) == null) {
				cacheResult(language);
			}
			else {
				language.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all languages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LanguageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LanguageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the language.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Language language) {
		EntityCacheUtil.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Language> languages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Language language : languages) {
			EntityCacheUtil.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
				LanguageImpl.class, language.getPrimaryKey());
		}
	}

	/**
	 * Creates a new language with the primary key. Does not add the language to the database.
	 *
	 * @param languageId the primary key for the new language
	 * @return the new language
	 */
	@Override
	public Language create(long languageId) {
		Language language = new LanguageImpl();

		language.setNew(true);
		language.setPrimaryKey(languageId);

		return language;
	}

	/**
	 * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languageId the primary key of the language
	 * @return the language that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language remove(long languageId)
		throws NoSuchLanguageException, SystemException {
		return remove((Serializable)languageId);
	}

	/**
	 * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language remove(Serializable primaryKey)
		throws NoSuchLanguageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Language language = (Language)session.get(LanguageImpl.class,
					primaryKey);

			if (language == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(language);
		}
		catch (NoSuchLanguageException nsee) {
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
	protected Language removeImpl(Language language) throws SystemException {
		language = toUnwrappedModel(language);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(language)) {
				language = (Language)session.get(LanguageImpl.class,
						language.getPrimaryKeyObj());
			}

			if (language != null) {
				session.delete(language);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (language != null) {
			clearCache(language);
		}

		return language;
	}

	@Override
	public Language updateImpl(com.rknowsys.eapp.hrm.model.Language language)
		throws SystemException {
		language = toUnwrappedModel(language);

		boolean isNew = language.isNew();

		LanguageModelImpl languageModelImpl = (LanguageModelImpl)language;

		Session session = null;

		try {
			session = openSession();

			if (language.isNew()) {
				session.save(language);

				language.setNew(false);
			}
			else {
				session.merge(language);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LanguageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((languageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						languageModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { languageModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((languageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						languageModelImpl.getOriginalLanguageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID,
					args);

				args = new Object[] { languageModelImpl.getLanguageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey(), language);

		return language;
	}

	protected Language toUnwrappedModel(Language language) {
		if (language instanceof LanguageImpl) {
			return language;
		}

		LanguageImpl languageImpl = new LanguageImpl();

		languageImpl.setNew(language.isNew());
		languageImpl.setPrimaryKey(language.getPrimaryKey());

		languageImpl.setLanguageId(language.getLanguageId());
		languageImpl.setCompanyId(language.getCompanyId());
		languageImpl.setGroupId(language.getGroupId());
		languageImpl.setCreateDate(language.getCreateDate());
		languageImpl.setModifiedDate(language.getModifiedDate());
		languageImpl.setUserId(language.getUserId());
		languageImpl.setLanguageName(language.getLanguageName());

		return languageImpl;
	}

	/**
	 * Returns the language with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLanguageException, SystemException {
		Language language = fetchByPrimaryKey(primaryKey);

		if (language == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return language;
	}

	/**
	 * Returns the language with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchLanguageException} if it could not be found.
	 *
	 * @param languageId the primary key of the language
	 * @return the language
	 * @throws com.rknowsys.eapp.hrm.NoSuchLanguageException if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language findByPrimaryKey(long languageId)
		throws NoSuchLanguageException, SystemException {
		return findByPrimaryKey((Serializable)languageId);
	}

	/**
	 * Returns the language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language, or <code>null</code> if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Language language = (Language)EntityCacheUtil.getResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
				LanguageImpl.class, primaryKey);

		if (language == _nullLanguage) {
			return null;
		}

		if (language == null) {
			Session session = null;

			try {
				session = openSession();

				language = (Language)session.get(LanguageImpl.class, primaryKey);

				if (language != null) {
					cacheResult(language);
				}
				else {
					EntityCacheUtil.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
						LanguageImpl.class, primaryKey, _nullLanguage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
					LanguageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return language;
	}

	/**
	 * Returns the language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param languageId the primary key of the language
	 * @return the language, or <code>null</code> if a language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Language fetchByPrimaryKey(long languageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)languageId);
	}

	/**
	 * Returns all the languages.
	 *
	 * @return the languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the languages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @return the range of languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the languages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of languages
	 * @param end the upper bound of the range of languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Language> findAll(int start, int end,
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

		List<Language> list = (List<Language>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LANGUAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANGUAGE;

				if (pagination) {
					sql = sql.concat(LanguageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Language>(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the languages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Language language : findAll()) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages.
	 *
	 * @return the number of languages
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

				Query q = session.createQuery(_SQL_COUNT_LANGUAGE);

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
	 * Initializes the language persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Language")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Language>> listenersList = new ArrayList<ModelListener<Language>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Language>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LanguageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LANGUAGE = "SELECT language FROM Language language";
	private static final String _SQL_SELECT_LANGUAGE_WHERE = "SELECT language FROM Language language WHERE ";
	private static final String _SQL_COUNT_LANGUAGE = "SELECT COUNT(language) FROM Language language";
	private static final String _SQL_COUNT_LANGUAGE_WHERE = "SELECT COUNT(language) FROM Language language WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "language.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Language exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Language exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LanguagePersistenceImpl.class);
	private static Language _nullLanguage = new LanguageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Language> toCacheModel() {
				return _nullLanguageCacheModel;
			}
		};

	private static CacheModel<Language> _nullLanguageCacheModel = new CacheModel<Language>() {
			@Override
			public Language toEntityModel() {
				return _nullLanguage;
			}
		};
}