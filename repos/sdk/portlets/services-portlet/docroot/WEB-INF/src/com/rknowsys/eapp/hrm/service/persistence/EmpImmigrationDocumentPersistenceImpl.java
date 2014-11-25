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

import com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException;
import com.rknowsys.eapp.hrm.model.EmpImmigrationDocument;
import com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ImmigrationDocument service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpImmigrationDocumentPersistence
 * @see EmpImmigrationDocumentUtil
 * @generated
 */
public class EmpImmigrationDocumentPersistenceImpl extends BasePersistenceImpl<EmpImmigrationDocument>
	implements EmpImmigrationDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpImmigrationDocumentUtil} to access the ImmigrationDocument persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpImmigrationDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmpImmigrationDocumentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByGroupId(long groupId, int start,
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

		List<EmpImmigrationDocument> list = (List<EmpImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpImmigrationDocument empImmigrationDocument : list) {
				if ((groupId != empImmigrationDocument.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpImmigrationDocument>(list);
				}
				else {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByGroupId_First(groupId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpImmigrationDocument> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EmpImmigrationDocument> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param empImmigrationDocumentId the primary key of the current ImmigrationDocument
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument[] findByGroupId_PrevAndNext(
		long empImmigrationDocumentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = findByPrimaryKey(empImmigrationDocumentId);

		Session session = null;

		try {
			session = openSession();

			EmpImmigrationDocument[] array = new EmpImmigrationDocumentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					empImmigrationDocument, groupId, orderByComparator, true);

			array[1] = empImmigrationDocument;

			array[2] = getByGroupId_PrevAndNext(session,
					empImmigrationDocument, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpImmigrationDocument getByGroupId_PrevAndNext(Session session,
		EmpImmigrationDocument empImmigrationDocument, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE);

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
			query.append(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empImmigrationDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpImmigrationDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ImmigrationDocuments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EmpImmigrationDocument empImmigrationDocument : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empImmigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching ImmigrationDocuments
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

			query.append(_SQL_COUNT_EMPIMMIGRATIONDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empImmigrationDocument.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempImmigrationDocumentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempImmigrationDocumentId",
			new String[] { Long.class.getName() },
			EmpImmigrationDocumentModelImpl.EMPIMMIGRATIONDOCUMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIMMIGRATIONDOCUMENTID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempImmigrationDocumentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByempImmigrationDocumentId(
		long empImmigrationDocumentId) throws SystemException {
		return findByempImmigrationDocumentId(empImmigrationDocumentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where empImmigrationDocumentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByempImmigrationDocumentId(
		long empImmigrationDocumentId, int start, int end)
		throws SystemException {
		return findByempImmigrationDocumentId(empImmigrationDocumentId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where empImmigrationDocumentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByempImmigrationDocumentId(
		long empImmigrationDocumentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID;
			finderArgs = new Object[] { empImmigrationDocumentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID;
			finderArgs = new Object[] {
					empImmigrationDocumentId,
					
					start, end, orderByComparator
				};
		}

		List<EmpImmigrationDocument> list = (List<EmpImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpImmigrationDocument empImmigrationDocument : list) {
				if ((empImmigrationDocumentId != empImmigrationDocument.getEmpImmigrationDocumentId())) {
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

			query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPIMMIGRATIONDOCUMENTID_EMPIMMIGRATIONDOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empImmigrationDocumentId);

				if (!pagination) {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpImmigrationDocument>(list);
				}
				else {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByempImmigrationDocumentId_First(
		long empImmigrationDocumentId, OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByempImmigrationDocumentId_First(empImmigrationDocumentId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empImmigrationDocumentId=");
		msg.append(empImmigrationDocumentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByempImmigrationDocumentId_First(
		long empImmigrationDocumentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmpImmigrationDocument> list = findByempImmigrationDocumentId(empImmigrationDocumentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByempImmigrationDocumentId_Last(
		long empImmigrationDocumentId, OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByempImmigrationDocumentId_Last(empImmigrationDocumentId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empImmigrationDocumentId=");
		msg.append(empImmigrationDocumentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByempImmigrationDocumentId_Last(
		long empImmigrationDocumentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByempImmigrationDocumentId(empImmigrationDocumentId);

		if (count == 0) {
			return null;
		}

		List<EmpImmigrationDocument> list = findByempImmigrationDocumentId(empImmigrationDocumentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the ImmigrationDocuments where empImmigrationDocumentId = &#63; from the database.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempImmigrationDocumentId(long empImmigrationDocumentId)
		throws SystemException {
		for (EmpImmigrationDocument empImmigrationDocument : findByempImmigrationDocumentId(
				empImmigrationDocumentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(empImmigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where empImmigrationDocumentId = &#63;.
	 *
	 * @param empImmigrationDocumentId the emp immigration document ID
	 * @return the number of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempImmigrationDocumentId(long empImmigrationDocumentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIMMIGRATIONDOCUMENTID;

		Object[] finderArgs = new Object[] { empImmigrationDocumentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPIMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPIMMIGRATIONDOCUMENTID_EMPIMMIGRATIONDOCUMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empImmigrationDocumentId);

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

	private static final String _FINDER_COLUMN_EMPIMMIGRATIONDOCUMENTID_EMPIMMIGRATIONDOCUMENTID_2 =
		"empImmigrationDocument.empImmigrationDocumentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpImmigrationDocumentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByemployeeId(long employeeId,
		int start, int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findByemployeeId(long employeeId,
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

		List<EmpImmigrationDocument> list = (List<EmpImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpImmigrationDocument empImmigrationDocument : list) {
				if ((employeeId != empImmigrationDocument.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpImmigrationDocument>(list);
				}
				else {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpImmigrationDocument> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empImmigrationDocument != null) {
			return empImmigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpImmigrationDocument> list = findByemployeeId(employeeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param empImmigrationDocumentId the primary key of the current ImmigrationDocument
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument[] findByemployeeId_PrevAndNext(
		long empImmigrationDocumentId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = findByPrimaryKey(empImmigrationDocumentId);

		Session session = null;

		try {
			session = openSession();

			EmpImmigrationDocument[] array = new EmpImmigrationDocumentImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session,
					empImmigrationDocument, employeeId, orderByComparator, true);

			array[1] = empImmigrationDocument;

			array[2] = getByemployeeId_PrevAndNext(session,
					empImmigrationDocument, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpImmigrationDocument getByemployeeId_PrevAndNext(
		Session session, EmpImmigrationDocument empImmigrationDocument,
		long employeeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE);

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
			query.append(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empImmigrationDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpImmigrationDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ImmigrationDocuments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpImmigrationDocument empImmigrationDocument : findByemployeeId(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empImmigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching ImmigrationDocuments
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

			query.append(_SQL_COUNT_EMPIMMIGRATIONDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empImmigrationDocument.employeeId = ?";

	public EmpImmigrationDocumentPersistenceImpl() {
		setModelClass(EmpImmigrationDocument.class);
	}

	/**
	 * Caches the ImmigrationDocument in the entity cache if it is enabled.
	 *
	 * @param empImmigrationDocument the ImmigrationDocument
	 */
	@Override
	public void cacheResult(EmpImmigrationDocument empImmigrationDocument) {
		EntityCacheUtil.putResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			empImmigrationDocument.getPrimaryKey(), empImmigrationDocument);

		empImmigrationDocument.resetOriginalValues();
	}

	/**
	 * Caches the ImmigrationDocuments in the entity cache if it is enabled.
	 *
	 * @param empImmigrationDocuments the ImmigrationDocuments
	 */
	@Override
	public void cacheResult(
		List<EmpImmigrationDocument> empImmigrationDocuments) {
		for (EmpImmigrationDocument empImmigrationDocument : empImmigrationDocuments) {
			if (EntityCacheUtil.getResult(
						EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
						EmpImmigrationDocumentImpl.class,
						empImmigrationDocument.getPrimaryKey()) == null) {
				cacheResult(empImmigrationDocument);
			}
			else {
				empImmigrationDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ImmigrationDocuments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpImmigrationDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpImmigrationDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ImmigrationDocument.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpImmigrationDocument empImmigrationDocument) {
		EntityCacheUtil.removeResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			empImmigrationDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpImmigrationDocument> empImmigrationDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpImmigrationDocument empImmigrationDocument : empImmigrationDocuments) {
			EntityCacheUtil.removeResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
				EmpImmigrationDocumentImpl.class,
				empImmigrationDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ImmigrationDocument with the primary key. Does not add the ImmigrationDocument to the database.
	 *
	 * @param empImmigrationDocumentId the primary key for the new ImmigrationDocument
	 * @return the new ImmigrationDocument
	 */
	@Override
	public EmpImmigrationDocument create(long empImmigrationDocumentId) {
		EmpImmigrationDocument empImmigrationDocument = new EmpImmigrationDocumentImpl();

		empImmigrationDocument.setNew(true);
		empImmigrationDocument.setPrimaryKey(empImmigrationDocumentId);

		return empImmigrationDocument;
	}

	/**
	 * Removes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empImmigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument remove(long empImmigrationDocumentId)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		return remove((Serializable)empImmigrationDocumentId);
	}

	/**
	 * Removes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument remove(Serializable primaryKey)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpImmigrationDocument empImmigrationDocument = (EmpImmigrationDocument)session.get(EmpImmigrationDocumentImpl.class,
					primaryKey);

			if (empImmigrationDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpImmigrationDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empImmigrationDocument);
		}
		catch (NoSuchEmpImmigrationDocumentException nsee) {
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
	protected EmpImmigrationDocument removeImpl(
		EmpImmigrationDocument empImmigrationDocument)
		throws SystemException {
		empImmigrationDocument = toUnwrappedModel(empImmigrationDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empImmigrationDocument)) {
				empImmigrationDocument = (EmpImmigrationDocument)session.get(EmpImmigrationDocumentImpl.class,
						empImmigrationDocument.getPrimaryKeyObj());
			}

			if (empImmigrationDocument != null) {
				session.delete(empImmigrationDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empImmigrationDocument != null) {
			clearCache(empImmigrationDocument);
		}

		return empImmigrationDocument;
	}

	@Override
	public EmpImmigrationDocument updateImpl(
		com.rknowsys.eapp.hrm.model.EmpImmigrationDocument empImmigrationDocument)
		throws SystemException {
		empImmigrationDocument = toUnwrappedModel(empImmigrationDocument);

		boolean isNew = empImmigrationDocument.isNew();

		EmpImmigrationDocumentModelImpl empImmigrationDocumentModelImpl = (EmpImmigrationDocumentModelImpl)empImmigrationDocument;

		Session session = null;

		try {
			session = openSession();

			if (empImmigrationDocument.isNew()) {
				session.save(empImmigrationDocument);

				empImmigrationDocument.setNew(false);
			}
			else {
				session.merge(empImmigrationDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpImmigrationDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empImmigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empImmigrationDocumentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { empImmigrationDocumentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((empImmigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empImmigrationDocumentModelImpl.getOriginalEmpImmigrationDocumentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPIMMIGRATIONDOCUMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID,
					args);

				args = new Object[] {
						empImmigrationDocumentModelImpl.getEmpImmigrationDocumentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPIMMIGRATIONDOCUMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPIMMIGRATIONDOCUMENTID,
					args);
			}

			if ((empImmigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empImmigrationDocumentModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] {
						empImmigrationDocumentModelImpl.getEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			EmpImmigrationDocumentImpl.class,
			empImmigrationDocument.getPrimaryKey(), empImmigrationDocument);

		return empImmigrationDocument;
	}

	protected EmpImmigrationDocument toUnwrappedModel(
		EmpImmigrationDocument empImmigrationDocument) {
		if (empImmigrationDocument instanceof EmpImmigrationDocumentImpl) {
			return empImmigrationDocument;
		}

		EmpImmigrationDocumentImpl empImmigrationDocumentImpl = new EmpImmigrationDocumentImpl();

		empImmigrationDocumentImpl.setNew(empImmigrationDocument.isNew());
		empImmigrationDocumentImpl.setPrimaryKey(empImmigrationDocument.getPrimaryKey());

		empImmigrationDocumentImpl.setEmpImmigrationDocumentId(empImmigrationDocument.getEmpImmigrationDocumentId());
		empImmigrationDocumentImpl.setEmployeeId(empImmigrationDocument.getEmployeeId());
		empImmigrationDocumentImpl.setGroupId(empImmigrationDocument.getGroupId());
		empImmigrationDocumentImpl.setCompanyId(empImmigrationDocument.getCompanyId());
		empImmigrationDocumentImpl.setCreateDate(empImmigrationDocument.getCreateDate());
		empImmigrationDocumentImpl.setModifiedDate(empImmigrationDocument.getModifiedDate());
		empImmigrationDocumentImpl.setUserId(empImmigrationDocument.getUserId());
		empImmigrationDocumentImpl.setDocType(empImmigrationDocument.getDocType());
		empImmigrationDocumentImpl.setDocNumber(empImmigrationDocument.getDocNumber());
		empImmigrationDocumentImpl.setIssuedDate(empImmigrationDocument.getIssuedDate());
		empImmigrationDocumentImpl.setExpiryDate(empImmigrationDocument.getExpiryDate());
		empImmigrationDocumentImpl.setEligibleStatus(empImmigrationDocument.getEligibleStatus());
		empImmigrationDocumentImpl.setIssuedBy(empImmigrationDocument.getIssuedBy());
		empImmigrationDocumentImpl.setEligibleReviewDate(empImmigrationDocument.getEligibleReviewDate());
		empImmigrationDocumentImpl.setComments(empImmigrationDocument.getComments());

		return empImmigrationDocumentImpl;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		EmpImmigrationDocument empImmigrationDocument = fetchByPrimaryKey(primaryKey);

		if (empImmigrationDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpImmigrationDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empImmigrationDocument;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException} if it could not be found.
	 *
	 * @param empImmigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument findByPrimaryKey(
		long empImmigrationDocumentId)
		throws NoSuchEmpImmigrationDocumentException, SystemException {
		return findByPrimaryKey((Serializable)empImmigrationDocumentId);
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument, or <code>null</code> if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpImmigrationDocument empImmigrationDocument = (EmpImmigrationDocument)EntityCacheUtil.getResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
				EmpImmigrationDocumentImpl.class, primaryKey);

		if (empImmigrationDocument == _nullEmpImmigrationDocument) {
			return null;
		}

		if (empImmigrationDocument == null) {
			Session session = null;

			try {
				session = openSession();

				empImmigrationDocument = (EmpImmigrationDocument)session.get(EmpImmigrationDocumentImpl.class,
						primaryKey);

				if (empImmigrationDocument != null) {
					cacheResult(empImmigrationDocument);
				}
				else {
					EntityCacheUtil.putResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
						EmpImmigrationDocumentImpl.class, primaryKey,
						_nullEmpImmigrationDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
					EmpImmigrationDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empImmigrationDocument;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empImmigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument, or <code>null</code> if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpImmigrationDocument fetchByPrimaryKey(
		long empImmigrationDocumentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)empImmigrationDocumentId);
	}

	/**
	 * Returns all the ImmigrationDocuments.
	 *
	 * @return the ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpImmigrationDocument> findAll(int start, int end,
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

		List<EmpImmigrationDocument> list = (List<EmpImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPIMMIGRATIONDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPIMMIGRATIONDOCUMENT;

				if (pagination) {
					sql = sql.concat(EmpImmigrationDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpImmigrationDocument>(list);
				}
				else {
					list = (List<EmpImmigrationDocument>)QueryUtil.list(q,
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
	 * Removes all the ImmigrationDocuments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpImmigrationDocument empImmigrationDocument : findAll()) {
			remove(empImmigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments.
	 *
	 * @return the number of ImmigrationDocuments
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

				Query q = session.createQuery(_SQL_COUNT_EMPIMMIGRATIONDOCUMENT);

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
	 * Initializes the ImmigrationDocument persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpImmigrationDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpImmigrationDocument>> listenersList = new ArrayList<ModelListener<EmpImmigrationDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpImmigrationDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpImmigrationDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPIMMIGRATIONDOCUMENT = "SELECT empImmigrationDocument FROM EmpImmigrationDocument empImmigrationDocument";
	private static final String _SQL_SELECT_EMPIMMIGRATIONDOCUMENT_WHERE = "SELECT empImmigrationDocument FROM EmpImmigrationDocument empImmigrationDocument WHERE ";
	private static final String _SQL_COUNT_EMPIMMIGRATIONDOCUMENT = "SELECT COUNT(empImmigrationDocument) FROM EmpImmigrationDocument empImmigrationDocument";
	private static final String _SQL_COUNT_EMPIMMIGRATIONDOCUMENT_WHERE = "SELECT COUNT(empImmigrationDocument) FROM EmpImmigrationDocument empImmigrationDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empImmigrationDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpImmigrationDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpImmigrationDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpImmigrationDocumentPersistenceImpl.class);
	private static EmpImmigrationDocument _nullEmpImmigrationDocument = new EmpImmigrationDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpImmigrationDocument> toCacheModel() {
				return _nullEmpImmigrationDocumentCacheModel;
			}
		};

	private static CacheModel<EmpImmigrationDocument> _nullEmpImmigrationDocumentCacheModel =
		new CacheModel<EmpImmigrationDocument>() {
			@Override
			public EmpImmigrationDocument toEntityModel() {
				return _nullEmpImmigrationDocument;
			}
		};
}