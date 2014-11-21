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

import com.rknowsys.eapp.hrm.NoSuchEmpLanguageException;
import com.rknowsys.eapp.hrm.model.EmpLanguage;
import com.rknowsys.eapp.hrm.model.impl.EmpLanguageImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpLanguagePersistence
 * @see EmpLanguageUtil
 * @generated
 */
public class EmpLanguagePersistenceImpl extends BasePersistenceImpl<EmpLanguage>
	implements EmpLanguagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpLanguageUtil} to access the emp language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpLanguageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpLanguageModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp languages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp languages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @return the range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp languages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByGroupId(long groupId, int start, int end,
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

		List<EmpLanguage> list = (List<EmpLanguage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLanguage empLanguage : list) {
				if ((groupId != empLanguage.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLanguage>(list);
				}
				else {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the first emp language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLanguage> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchByGroupId_Last(groupId, orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the last emp language in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpLanguage> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp languages before and after the current emp language in the ordered set where groupId = &#63;.
	 *
	 * @param empLanguageId the primary key of the current emp language
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage[] findByGroupId_PrevAndNext(long empLanguageId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = findByPrimaryKey(empLanguageId);

		Session session = null;

		try {
			session = openSession();

			EmpLanguage[] array = new EmpLanguageImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, empLanguage, groupId,
					orderByComparator, true);

			array[1] = empLanguage;

			array[2] = getByGroupId_PrevAndNext(session, empLanguage, groupId,
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

	protected EmpLanguage getByGroupId_PrevAndNext(Session session,
		EmpLanguage empLanguage, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

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
			query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLanguage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLanguage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp languages where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpLanguage empLanguage : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLanguage);
		}
	}

	/**
	 * Returns the number of emp languages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching emp languages
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

			query.append(_SQL_COUNT_EMPLANGUAGE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empLanguage.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGEID =
		new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylanguageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID =
		new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylanguageId",
			new String[] { Long.class.getName() },
			EmpLanguageModelImpl.LANGUAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGEID = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylanguageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp languages where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findBylanguageId(long languageId)
		throws SystemException {
		return findBylanguageId(languageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp languages where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @return the range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findBylanguageId(long languageId, int start,
		int end) throws SystemException {
		return findBylanguageId(languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp languages where languageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findBylanguageId(long languageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<EmpLanguage> list = (List<EmpLanguage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLanguage empLanguage : list) {
				if ((languageId != empLanguage.getLanguageId())) {
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

			query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(languageId);

				if (!pagination) {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLanguage>(list);
				}
				else {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findBylanguageId_First(long languageId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchBylanguageId_First(languageId,
				orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageId=");
		msg.append(languageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the first emp language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchBylanguageId_First(long languageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLanguage> list = findBylanguageId(languageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findBylanguageId_Last(long languageId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchBylanguageId_Last(languageId,
				orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageId=");
		msg.append(languageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the last emp language in the ordered set where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchBylanguageId_Last(long languageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylanguageId(languageId);

		if (count == 0) {
			return null;
		}

		List<EmpLanguage> list = findBylanguageId(languageId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp languages before and after the current emp language in the ordered set where languageId = &#63;.
	 *
	 * @param empLanguageId the primary key of the current emp language
	 * @param languageId the language ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage[] findBylanguageId_PrevAndNext(long empLanguageId,
		long languageId, OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = findByPrimaryKey(empLanguageId);

		Session session = null;

		try {
			session = openSession();

			EmpLanguage[] array = new EmpLanguageImpl[3];

			array[0] = getBylanguageId_PrevAndNext(session, empLanguage,
					languageId, orderByComparator, true);

			array[1] = empLanguage;

			array[2] = getBylanguageId_PrevAndNext(session, empLanguage,
					languageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpLanguage getBylanguageId_PrevAndNext(Session session,
		EmpLanguage empLanguage, long languageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

		query.append(_FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2);

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
			query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(languageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLanguage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLanguage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp languages where languageId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylanguageId(long languageId) throws SystemException {
		for (EmpLanguage empLanguage : findBylanguageId(languageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLanguage);
		}
	}

	/**
	 * Returns the number of emp languages where languageId = &#63;.
	 *
	 * @param languageId the language ID
	 * @return the number of matching emp languages
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

			query.append(_SQL_COUNT_EMPLANGUAGE_WHERE);

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

	private static final String _FINDER_COLUMN_LANGUAGEID_LANGUAGEID_2 = "empLanguage.languageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, EmpLanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpLanguageModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp languages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp languages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @return the range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp languages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findByemployeeId(long employeeId, int start,
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

		List<EmpLanguage> list = (List<EmpLanguage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLanguage empLanguage : list) {
				if ((employeeId != empLanguage.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLanguage>(list);
				}
				else {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first emp language in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the first emp language in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLanguage> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp language in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empLanguage != null) {
			return empLanguage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLanguageException(msg.toString());
	}

	/**
	 * Returns the last emp language in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp language, or <code>null</code> if a matching emp language could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpLanguage> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp languages before and after the current emp language in the ordered set where employeeId = &#63;.
	 *
	 * @param empLanguageId the primary key of the current emp language
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage[] findByemployeeId_PrevAndNext(long empLanguageId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = findByPrimaryKey(empLanguageId);

		Session session = null;

		try {
			session = openSession();

			EmpLanguage[] array = new EmpLanguageImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empLanguage,
					employeeId, orderByComparator, true);

			array[1] = empLanguage;

			array[2] = getByemployeeId_PrevAndNext(session, empLanguage,
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

	protected EmpLanguage getByemployeeId_PrevAndNext(Session session,
		EmpLanguage empLanguage, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLANGUAGE_WHERE);

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
			query.append(EmpLanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLanguage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLanguage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp languages where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpLanguage empLanguage : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLanguage);
		}
	}

	/**
	 * Returns the number of emp languages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp languages
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

			query.append(_SQL_COUNT_EMPLANGUAGE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empLanguage.employeeId = ?";

	public EmpLanguagePersistenceImpl() {
		setModelClass(EmpLanguage.class);
	}

	/**
	 * Caches the emp language in the entity cache if it is enabled.
	 *
	 * @param empLanguage the emp language
	 */
	@Override
	public void cacheResult(EmpLanguage empLanguage) {
		EntityCacheUtil.putResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageImpl.class, empLanguage.getPrimaryKey(), empLanguage);

		empLanguage.resetOriginalValues();
	}

	/**
	 * Caches the emp languages in the entity cache if it is enabled.
	 *
	 * @param empLanguages the emp languages
	 */
	@Override
	public void cacheResult(List<EmpLanguage> empLanguages) {
		for (EmpLanguage empLanguage : empLanguages) {
			if (EntityCacheUtil.getResult(
						EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
						EmpLanguageImpl.class, empLanguage.getPrimaryKey()) == null) {
				cacheResult(empLanguage);
			}
			else {
				empLanguage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp languages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpLanguageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpLanguageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp language.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpLanguage empLanguage) {
		EntityCacheUtil.removeResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageImpl.class, empLanguage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpLanguage> empLanguages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpLanguage empLanguage : empLanguages) {
			EntityCacheUtil.removeResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
				EmpLanguageImpl.class, empLanguage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp language with the primary key. Does not add the emp language to the database.
	 *
	 * @param empLanguageId the primary key for the new emp language
	 * @return the new emp language
	 */
	@Override
	public EmpLanguage create(long empLanguageId) {
		EmpLanguage empLanguage = new EmpLanguageImpl();

		empLanguage.setNew(true);
		empLanguage.setPrimaryKey(empLanguageId);

		return empLanguage;
	}

	/**
	 * Removes the emp language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empLanguageId the primary key of the emp language
	 * @return the emp language that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage remove(long empLanguageId)
		throws NoSuchEmpLanguageException, SystemException {
		return remove((Serializable)empLanguageId);
	}

	/**
	 * Removes the emp language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp language
	 * @return the emp language that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage remove(Serializable primaryKey)
		throws NoSuchEmpLanguageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpLanguage empLanguage = (EmpLanguage)session.get(EmpLanguageImpl.class,
					primaryKey);

			if (empLanguage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empLanguage);
		}
		catch (NoSuchEmpLanguageException nsee) {
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
	protected EmpLanguage removeImpl(EmpLanguage empLanguage)
		throws SystemException {
		empLanguage = toUnwrappedModel(empLanguage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empLanguage)) {
				empLanguage = (EmpLanguage)session.get(EmpLanguageImpl.class,
						empLanguage.getPrimaryKeyObj());
			}

			if (empLanguage != null) {
				session.delete(empLanguage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empLanguage != null) {
			clearCache(empLanguage);
		}

		return empLanguage;
	}

	@Override
	public EmpLanguage updateImpl(
		com.rknowsys.eapp.hrm.model.EmpLanguage empLanguage)
		throws SystemException {
		empLanguage = toUnwrappedModel(empLanguage);

		boolean isNew = empLanguage.isNew();

		EmpLanguageModelImpl empLanguageModelImpl = (EmpLanguageModelImpl)empLanguage;

		Session session = null;

		try {
			session = openSession();

			if (empLanguage.isNew()) {
				session.save(empLanguage);

				empLanguage.setNew(false);
			}
			else {
				session.merge(empLanguage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpLanguageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empLanguageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLanguageModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empLanguageModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empLanguageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLanguageModelImpl.getOriginalLanguageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID,
					args);

				args = new Object[] { empLanguageModelImpl.getLanguageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEID,
					args);
			}

			if ((empLanguageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLanguageModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empLanguageModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
			EmpLanguageImpl.class, empLanguage.getPrimaryKey(), empLanguage);

		return empLanguage;
	}

	protected EmpLanguage toUnwrappedModel(EmpLanguage empLanguage) {
		if (empLanguage instanceof EmpLanguageImpl) {
			return empLanguage;
		}

		EmpLanguageImpl empLanguageImpl = new EmpLanguageImpl();

		empLanguageImpl.setNew(empLanguage.isNew());
		empLanguageImpl.setPrimaryKey(empLanguage.getPrimaryKey());

		empLanguageImpl.setEmpLanguageId(empLanguage.getEmpLanguageId());
		empLanguageImpl.setEmployeeId(empLanguage.getEmployeeId());
		empLanguageImpl.setGroupId(empLanguage.getGroupId());
		empLanguageImpl.setCompanyId(empLanguage.getCompanyId());
		empLanguageImpl.setCreateDate(empLanguage.getCreateDate());
		empLanguageImpl.setModifiedDate(empLanguage.getModifiedDate());
		empLanguageImpl.setUserId(empLanguage.getUserId());
		empLanguageImpl.setLanguageId(empLanguage.getLanguageId());
		empLanguageImpl.setLanguageSkill(empLanguage.getLanguageSkill());
		empLanguageImpl.setLanguageFluency(empLanguage.getLanguageFluency());
		empLanguageImpl.setComments(empLanguage.getComments());

		return empLanguageImpl;
	}

	/**
	 * Returns the emp language with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp language
	 * @return the emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpLanguageException, SystemException {
		EmpLanguage empLanguage = fetchByPrimaryKey(primaryKey);

		if (empLanguage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empLanguage;
	}

	/**
	 * Returns the emp language with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpLanguageException} if it could not be found.
	 *
	 * @param empLanguageId the primary key of the emp language
	 * @return the emp language
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpLanguageException if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage findByPrimaryKey(long empLanguageId)
		throws NoSuchEmpLanguageException, SystemException {
		return findByPrimaryKey((Serializable)empLanguageId);
	}

	/**
	 * Returns the emp language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp language
	 * @return the emp language, or <code>null</code> if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpLanguage empLanguage = (EmpLanguage)EntityCacheUtil.getResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
				EmpLanguageImpl.class, primaryKey);

		if (empLanguage == _nullEmpLanguage) {
			return null;
		}

		if (empLanguage == null) {
			Session session = null;

			try {
				session = openSession();

				empLanguage = (EmpLanguage)session.get(EmpLanguageImpl.class,
						primaryKey);

				if (empLanguage != null) {
					cacheResult(empLanguage);
				}
				else {
					EntityCacheUtil.putResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
						EmpLanguageImpl.class, primaryKey, _nullEmpLanguage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpLanguageModelImpl.ENTITY_CACHE_ENABLED,
					EmpLanguageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empLanguage;
	}

	/**
	 * Returns the emp language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empLanguageId the primary key of the emp language
	 * @return the emp language, or <code>null</code> if a emp language with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLanguage fetchByPrimaryKey(long empLanguageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empLanguageId);
	}

	/**
	 * Returns all the emp languages.
	 *
	 * @return the emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp languages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @return the range of emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp languages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpLanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp languages
	 * @param end the upper bound of the range of emp languages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp languages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLanguage> findAll(int start, int end,
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

		List<EmpLanguage> list = (List<EmpLanguage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLANGUAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLANGUAGE;

				if (pagination) {
					sql = sql.concat(EmpLanguageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLanguage>(list);
				}
				else {
					list = (List<EmpLanguage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp languages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpLanguage empLanguage : findAll()) {
			remove(empLanguage);
		}
	}

	/**
	 * Returns the number of emp languages.
	 *
	 * @return the number of emp languages
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

				Query q = session.createQuery(_SQL_COUNT_EMPLANGUAGE);

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
	 * Initializes the emp language persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpLanguage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpLanguage>> listenersList = new ArrayList<ModelListener<EmpLanguage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpLanguage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpLanguageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLANGUAGE = "SELECT empLanguage FROM EmpLanguage empLanguage";
	private static final String _SQL_SELECT_EMPLANGUAGE_WHERE = "SELECT empLanguage FROM EmpLanguage empLanguage WHERE ";
	private static final String _SQL_COUNT_EMPLANGUAGE = "SELECT COUNT(empLanguage) FROM EmpLanguage empLanguage";
	private static final String _SQL_COUNT_EMPLANGUAGE_WHERE = "SELECT COUNT(empLanguage) FROM EmpLanguage empLanguage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empLanguage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpLanguage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpLanguage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpLanguagePersistenceImpl.class);
	private static EmpLanguage _nullEmpLanguage = new EmpLanguageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpLanguage> toCacheModel() {
				return _nullEmpLanguageCacheModel;
			}
		};

	private static CacheModel<EmpLanguage> _nullEmpLanguageCacheModel = new CacheModel<EmpLanguage>() {
			@Override
			public EmpLanguage toEntityModel() {
				return _nullEmpLanguage;
			}
		};
}