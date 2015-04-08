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

import com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException;
import com.rknowsys.eapp.hrm.model.DocumentCategories;
import com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesImpl;
import com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the document categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DocumentCategoriesPersistence
 * @see DocumentCategoriesUtil
 * @generated
 */
public class DocumentCategoriesPersistenceImpl extends BasePersistenceImpl<DocumentCategories>
	implements DocumentCategoriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentCategoriesUtil} to access the document categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentCategoriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED,
			DocumentCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED,
			DocumentCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED,
			DocumentCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED,
			DocumentCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			DocumentCategoriesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the document categorieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document categorieses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of document categorieses
	 * @param end the upper bound of the range of document categorieses (not inclusive)
	 * @return the range of matching document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document categorieses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of document categorieses
	 * @param end the upper bound of the range of document categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findByGroupId(long groupId, int start,
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

		List<DocumentCategories> list = (List<DocumentCategories>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DocumentCategories documentCategories : list) {
				if ((groupId != documentCategories.getGroupId())) {
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

			query.append(_SQL_SELECT_DOCUMENTCATEGORIES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocumentCategoriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DocumentCategories>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DocumentCategories>(list);
				}
				else {
					list = (List<DocumentCategories>)QueryUtil.list(q,
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
	 * Returns the first document categories in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document categories
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a matching document categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentCategoriesException, SystemException {
		DocumentCategories documentCategories = fetchByGroupId_First(groupId,
				orderByComparator);

		if (documentCategories != null) {
			return documentCategories;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentCategoriesException(msg.toString());
	}

	/**
	 * Returns the first document categories in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document categories, or <code>null</code> if a matching document categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DocumentCategories> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document categories in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document categories
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a matching document categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentCategoriesException, SystemException {
		DocumentCategories documentCategories = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (documentCategories != null) {
			return documentCategories;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentCategoriesException(msg.toString());
	}

	/**
	 * Returns the last document categories in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document categories, or <code>null</code> if a matching document categories could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DocumentCategories> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document categorieses before and after the current document categories in the ordered set where groupId = &#63;.
	 *
	 * @param documentcategoryId the primary key of the current document categories
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document categories
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories[] findByGroupId_PrevAndNext(
		long documentcategoryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentCategoriesException, SystemException {
		DocumentCategories documentCategories = findByPrimaryKey(documentcategoryId);

		Session session = null;

		try {
			session = openSession();

			DocumentCategories[] array = new DocumentCategoriesImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, documentCategories,
					groupId, orderByComparator, true);

			array[1] = documentCategories;

			array[2] = getByGroupId_PrevAndNext(session, documentCategories,
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

	protected DocumentCategories getByGroupId_PrevAndNext(Session session,
		DocumentCategories documentCategories, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENTCATEGORIES_WHERE);

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
			query.append(DocumentCategoriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(documentCategories);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DocumentCategories> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document categorieses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (DocumentCategories documentCategories : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(documentCategories);
		}
	}

	/**
	 * Returns the number of document categorieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching document categorieses
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

			query.append(_SQL_COUNT_DOCUMENTCATEGORIES_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "documentCategories.groupId = ?";

	public DocumentCategoriesPersistenceImpl() {
		setModelClass(DocumentCategories.class);
	}

	/**
	 * Caches the document categories in the entity cache if it is enabled.
	 *
	 * @param documentCategories the document categories
	 */
	@Override
	public void cacheResult(DocumentCategories documentCategories) {
		EntityCacheUtil.putResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesImpl.class, documentCategories.getPrimaryKey(),
			documentCategories);

		documentCategories.resetOriginalValues();
	}

	/**
	 * Caches the document categorieses in the entity cache if it is enabled.
	 *
	 * @param documentCategorieses the document categorieses
	 */
	@Override
	public void cacheResult(List<DocumentCategories> documentCategorieses) {
		for (DocumentCategories documentCategories : documentCategorieses) {
			if (EntityCacheUtil.getResult(
						DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						DocumentCategoriesImpl.class,
						documentCategories.getPrimaryKey()) == null) {
				cacheResult(documentCategories);
			}
			else {
				documentCategories.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all document categorieses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocumentCategoriesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocumentCategoriesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentCategories documentCategories) {
		EntityCacheUtil.removeResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesImpl.class, documentCategories.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DocumentCategories> documentCategorieses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentCategories documentCategories : documentCategorieses) {
			EntityCacheUtil.removeResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				DocumentCategoriesImpl.class, documentCategories.getPrimaryKey());
		}
	}

	/**
	 * Creates a new document categories with the primary key. Does not add the document categories to the database.
	 *
	 * @param documentcategoryId the primary key for the new document categories
	 * @return the new document categories
	 */
	@Override
	public DocumentCategories create(long documentcategoryId) {
		DocumentCategories documentCategories = new DocumentCategoriesImpl();

		documentCategories.setNew(true);
		documentCategories.setPrimaryKey(documentcategoryId);

		return documentCategories;
	}

	/**
	 * Removes the document categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentcategoryId the primary key of the document categories
	 * @return the document categories that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories remove(long documentcategoryId)
		throws NoSuchDocumentCategoriesException, SystemException {
		return remove((Serializable)documentcategoryId);
	}

	/**
	 * Removes the document categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document categories
	 * @return the document categories that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories remove(Serializable primaryKey)
		throws NoSuchDocumentCategoriesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DocumentCategories documentCategories = (DocumentCategories)session.get(DocumentCategoriesImpl.class,
					primaryKey);

			if (documentCategories == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documentCategories);
		}
		catch (NoSuchDocumentCategoriesException nsee) {
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
	protected DocumentCategories removeImpl(
		DocumentCategories documentCategories) throws SystemException {
		documentCategories = toUnwrappedModel(documentCategories);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentCategories)) {
				documentCategories = (DocumentCategories)session.get(DocumentCategoriesImpl.class,
						documentCategories.getPrimaryKeyObj());
			}

			if (documentCategories != null) {
				session.delete(documentCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentCategories != null) {
			clearCache(documentCategories);
		}

		return documentCategories;
	}

	@Override
	public DocumentCategories updateImpl(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories)
		throws SystemException {
		documentCategories = toUnwrappedModel(documentCategories);

		boolean isNew = documentCategories.isNew();

		DocumentCategoriesModelImpl documentCategoriesModelImpl = (DocumentCategoriesModelImpl)documentCategories;

		Session session = null;

		try {
			session = openSession();

			if (documentCategories.isNew()) {
				session.save(documentCategories);

				documentCategories.setNew(false);
			}
			else {
				session.merge(documentCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DocumentCategoriesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((documentCategoriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentCategoriesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { documentCategoriesModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			DocumentCategoriesImpl.class, documentCategories.getPrimaryKey(),
			documentCategories);

		return documentCategories;
	}

	protected DocumentCategories toUnwrappedModel(
		DocumentCategories documentCategories) {
		if (documentCategories instanceof DocumentCategoriesImpl) {
			return documentCategories;
		}

		DocumentCategoriesImpl documentCategoriesImpl = new DocumentCategoriesImpl();

		documentCategoriesImpl.setNew(documentCategories.isNew());
		documentCategoriesImpl.setPrimaryKey(documentCategories.getPrimaryKey());

		documentCategoriesImpl.setDocumentcategoryId(documentCategories.getDocumentcategoryId());
		documentCategoriesImpl.setCompanyId(documentCategories.getCompanyId());
		documentCategoriesImpl.setGroupId(documentCategories.getGroupId());
		documentCategoriesImpl.setUserId(documentCategories.getUserId());
		documentCategoriesImpl.setCreateDate(documentCategories.getCreateDate());
		documentCategoriesImpl.setModifiedDate(documentCategories.getModifiedDate());
		documentCategoriesImpl.setDocumentCategory(documentCategories.getDocumentCategory());

		return documentCategoriesImpl;
	}

	/**
	 * Returns the document categories with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document categories
	 * @return the document categories
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentCategoriesException, SystemException {
		DocumentCategories documentCategories = fetchByPrimaryKey(primaryKey);

		if (documentCategories == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documentCategories;
	}

	/**
	 * Returns the document categories with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException} if it could not be found.
	 *
	 * @param documentcategoryId the primary key of the document categories
	 * @return the document categories
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentCategoriesException if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories findByPrimaryKey(long documentcategoryId)
		throws NoSuchDocumentCategoriesException, SystemException {
		return findByPrimaryKey((Serializable)documentcategoryId);
	}

	/**
	 * Returns the document categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document categories
	 * @return the document categories, or <code>null</code> if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DocumentCategories documentCategories = (DocumentCategories)EntityCacheUtil.getResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				DocumentCategoriesImpl.class, primaryKey);

		if (documentCategories == _nullDocumentCategories) {
			return null;
		}

		if (documentCategories == null) {
			Session session = null;

			try {
				session = openSession();

				documentCategories = (DocumentCategories)session.get(DocumentCategoriesImpl.class,
						primaryKey);

				if (documentCategories != null) {
					cacheResult(documentCategories);
				}
				else {
					EntityCacheUtil.putResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						DocumentCategoriesImpl.class, primaryKey,
						_nullDocumentCategories);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DocumentCategoriesModelImpl.ENTITY_CACHE_ENABLED,
					DocumentCategoriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentCategories;
	}

	/**
	 * Returns the document categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentcategoryId the primary key of the document categories
	 * @return the document categories, or <code>null</code> if a document categories with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentCategories fetchByPrimaryKey(long documentcategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)documentcategoryId);
	}

	/**
	 * Returns all the document categorieses.
	 *
	 * @return the document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document categorieses
	 * @param end the upper bound of the range of document categorieses (not inclusive)
	 * @return the range of document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document categorieses
	 * @param end the upper bound of the range of document categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document categorieses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentCategories> findAll(int start, int end,
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

		List<DocumentCategories> list = (List<DocumentCategories>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCUMENTCATEGORIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTCATEGORIES;

				if (pagination) {
					sql = sql.concat(DocumentCategoriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentCategories>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DocumentCategories>(list);
				}
				else {
					list = (List<DocumentCategories>)QueryUtil.list(q,
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
	 * Removes all the document categorieses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DocumentCategories documentCategories : findAll()) {
			remove(documentCategories);
		}
	}

	/**
	 * Returns the number of document categorieses.
	 *
	 * @return the number of document categorieses
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

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTCATEGORIES);

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
	 * Initializes the document categories persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.DocumentCategories")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DocumentCategories>> listenersList = new ArrayList<ModelListener<DocumentCategories>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DocumentCategories>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocumentCategoriesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOCUMENTCATEGORIES = "SELECT documentCategories FROM DocumentCategories documentCategories";
	private static final String _SQL_SELECT_DOCUMENTCATEGORIES_WHERE = "SELECT documentCategories FROM DocumentCategories documentCategories WHERE ";
	private static final String _SQL_COUNT_DOCUMENTCATEGORIES = "SELECT COUNT(documentCategories) FROM DocumentCategories documentCategories";
	private static final String _SQL_COUNT_DOCUMENTCATEGORIES_WHERE = "SELECT COUNT(documentCategories) FROM DocumentCategories documentCategories WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documentCategories.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocumentCategories exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DocumentCategories exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocumentCategoriesPersistenceImpl.class);
	private static DocumentCategories _nullDocumentCategories = new DocumentCategoriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DocumentCategories> toCacheModel() {
				return _nullDocumentCategoriesCacheModel;
			}
		};

	private static CacheModel<DocumentCategories> _nullDocumentCategoriesCacheModel =
		new CacheModel<DocumentCategories>() {
			@Override
			public DocumentCategories toEntityModel() {
				return _nullDocumentCategories;
			}
		};
}