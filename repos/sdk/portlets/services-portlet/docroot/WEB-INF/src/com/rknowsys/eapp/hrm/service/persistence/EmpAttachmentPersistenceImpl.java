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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException;
import com.rknowsys.eapp.hrm.model.EmpAttachment;
import com.rknowsys.eapp.hrm.model.impl.EmpAttachmentImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the EmpAttachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachmentPersistence
 * @see EmpAttachmentUtil
 * @generated
 */
public class EmpAttachmentPersistenceImpl extends BasePersistenceImpl<EmpAttachment>
	implements EmpAttachmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpAttachmentUtil} to access the EmpAttachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpAttachmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPATTACHMENTID =
		new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByempAttachmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPATTACHMENTID =
		new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByempAttachmentId", new String[] { Long.class.getName() },
			EmpAttachmentModelImpl.EMPATTACHMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPATTACHMENTID = new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempAttachmentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpAttachments where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @return the matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByempAttachmentId(long empAttachmentId)
		throws SystemException {
		return findByempAttachmentId(empAttachmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpAttachments where empAttachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @return the range of matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByempAttachmentId(long empAttachmentId,
		int start, int end) throws SystemException {
		return findByempAttachmentId(empAttachmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpAttachments where empAttachmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByempAttachmentId(long empAttachmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPATTACHMENTID;
			finderArgs = new Object[] { empAttachmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPATTACHMENTID;
			finderArgs = new Object[] {
					empAttachmentId,
					
					start, end, orderByComparator
				};
		}

		List<EmpAttachment> list = (List<EmpAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpAttachment empAttachment : list) {
				if ((empAttachmentId != empAttachment.getEmpAttachmentId())) {
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

			query.append(_SQL_SELECT_EMPATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPATTACHMENTID_EMPATTACHMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empAttachmentId);

				if (!pagination) {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpAttachment>(list);
				}
				else {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByempAttachmentId_First(long empAttachmentId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = fetchByempAttachmentId_First(empAttachmentId,
				orderByComparator);

		if (empAttachment != null) {
			return empAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empAttachmentId=");
		msg.append(empAttachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpAttachmentException(msg.toString());
	}

	/**
	 * Returns the first EmpAttachment in the ordered set where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByempAttachmentId_First(long empAttachmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpAttachment> list = findByempAttachmentId(empAttachmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByempAttachmentId_Last(long empAttachmentId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = fetchByempAttachmentId_Last(empAttachmentId,
				orderByComparator);

		if (empAttachment != null) {
			return empAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empAttachmentId=");
		msg.append(empAttachmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpAttachmentException(msg.toString());
	}

	/**
	 * Returns the last EmpAttachment in the ordered set where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByempAttachmentId_Last(long empAttachmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByempAttachmentId(empAttachmentId);

		if (count == 0) {
			return null;
		}

		List<EmpAttachment> list = findByempAttachmentId(empAttachmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the EmpAttachments where empAttachmentId = &#63; from the database.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByempAttachmentId(long empAttachmentId)
		throws SystemException {
		for (EmpAttachment empAttachment : findByempAttachmentId(
				empAttachmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empAttachment);
		}
	}

	/**
	 * Returns the number of EmpAttachments where empAttachmentId = &#63;.
	 *
	 * @param empAttachmentId the emp attachment ID
	 * @return the number of matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByempAttachmentId(long empAttachmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPATTACHMENTID;

		Object[] finderArgs = new Object[] { empAttachmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPATTACHMENTID_EMPATTACHMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empAttachmentId);

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

	private static final String _FINDER_COLUMN_EMPATTACHMENTID_EMPATTACHMENTID_2 =
		"empAttachment.empAttachmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmpAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeId", new String[] { Long.class.getName() },
			EmpAttachmentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmpAttachments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpAttachments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @return the range of matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpAttachments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findByemployeeId(long employeeId, int start,
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

		List<EmpAttachment> list = (List<EmpAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpAttachment empAttachment : list) {
				if ((employeeId != empAttachment.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpAttachment>(list);
				}
				else {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empAttachment != null) {
			return empAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpAttachmentException(msg.toString());
	}

	/**
	 * Returns the first EmpAttachment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpAttachment> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empAttachment != null) {
			return empAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpAttachmentException(msg.toString());
	}

	/**
	 * Returns the last EmpAttachment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmpAttachment, or <code>null</code> if a matching EmpAttachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpAttachment> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the EmpAttachments before and after the current EmpAttachment in the ordered set where employeeId = &#63;.
	 *
	 * @param empAttachmentId the primary key of the current EmpAttachment
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment[] findByemployeeId_PrevAndNext(long empAttachmentId,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = findByPrimaryKey(empAttachmentId);

		Session session = null;

		try {
			session = openSession();

			EmpAttachment[] array = new EmpAttachmentImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empAttachment,
					employeeId, orderByComparator, true);

			array[1] = empAttachment;

			array[2] = getByemployeeId_PrevAndNext(session, empAttachment,
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

	protected EmpAttachment getByemployeeId_PrevAndNext(Session session,
		EmpAttachment empAttachment, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPATTACHMENT_WHERE);

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
			query.append(EmpAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EmpAttachments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmpAttachment empAttachment : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empAttachment);
		}
	}

	/**
	 * Returns the number of EmpAttachments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching EmpAttachments
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

			query.append(_SQL_COUNT_EMPATTACHMENT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empAttachment.employeeId = ?";

	public EmpAttachmentPersistenceImpl() {
		setModelClass(EmpAttachment.class);
	}

	/**
	 * Caches the EmpAttachment in the entity cache if it is enabled.
	 *
	 * @param empAttachment the EmpAttachment
	 */
	@Override
	public void cacheResult(EmpAttachment empAttachment) {
		EntityCacheUtil.putResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentImpl.class, empAttachment.getPrimaryKey(),
			empAttachment);

		empAttachment.resetOriginalValues();
	}

	/**
	 * Caches the EmpAttachments in the entity cache if it is enabled.
	 *
	 * @param empAttachments the EmpAttachments
	 */
	@Override
	public void cacheResult(List<EmpAttachment> empAttachments) {
		for (EmpAttachment empAttachment : empAttachments) {
			if (EntityCacheUtil.getResult(
						EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						EmpAttachmentImpl.class, empAttachment.getPrimaryKey()) == null) {
				cacheResult(empAttachment);
			}
			else {
				empAttachment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpAttachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpAttachmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpAttachmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpAttachment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpAttachment empAttachment) {
		EntityCacheUtil.removeResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentImpl.class, empAttachment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpAttachment> empAttachments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpAttachment empAttachment : empAttachments) {
			EntityCacheUtil.removeResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				EmpAttachmentImpl.class, empAttachment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpAttachment with the primary key. Does not add the EmpAttachment to the database.
	 *
	 * @param empAttachmentId the primary key for the new EmpAttachment
	 * @return the new EmpAttachment
	 */
	@Override
	public EmpAttachment create(long empAttachmentId) {
		EmpAttachment empAttachment = new EmpAttachmentImpl();

		empAttachment.setNew(true);
		empAttachment.setPrimaryKey(empAttachmentId);

		return empAttachment;
	}

	/**
	 * Removes the EmpAttachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empAttachmentId the primary key of the EmpAttachment
	 * @return the EmpAttachment that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment remove(long empAttachmentId)
		throws NoSuchEmpAttachmentException, SystemException {
		return remove((Serializable)empAttachmentId);
	}

	/**
	 * Removes the EmpAttachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpAttachment
	 * @return the EmpAttachment that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment remove(Serializable primaryKey)
		throws NoSuchEmpAttachmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpAttachment empAttachment = (EmpAttachment)session.get(EmpAttachmentImpl.class,
					primaryKey);

			if (empAttachment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empAttachment);
		}
		catch (NoSuchEmpAttachmentException nsee) {
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
	protected EmpAttachment removeImpl(EmpAttachment empAttachment)
		throws SystemException {
		empAttachment = toUnwrappedModel(empAttachment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empAttachment)) {
				empAttachment = (EmpAttachment)session.get(EmpAttachmentImpl.class,
						empAttachment.getPrimaryKeyObj());
			}

			if (empAttachment != null) {
				session.delete(empAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empAttachment != null) {
			clearCache(empAttachment);
		}

		return empAttachment;
	}

	@Override
	public EmpAttachment updateImpl(
		com.rknowsys.eapp.hrm.model.EmpAttachment empAttachment)
		throws SystemException {
		empAttachment = toUnwrappedModel(empAttachment);

		boolean isNew = empAttachment.isNew();

		EmpAttachmentModelImpl empAttachmentModelImpl = (EmpAttachmentModelImpl)empAttachment;

		Session session = null;

		try {
			session = openSession();

			if (empAttachment.isNew()) {
				session.save(empAttachment);

				empAttachment.setNew(false);
			}
			else {
				session.evict(empAttachment);
				session.saveOrUpdate(empAttachment);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpAttachmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empAttachmentModelImpl.getOriginalEmpAttachmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPATTACHMENTID,
					args);

				args = new Object[] { empAttachmentModelImpl.getEmpAttachmentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPATTACHMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPATTACHMENTID,
					args);
			}

			if ((empAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empAttachmentModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empAttachmentModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmpAttachmentImpl.class, empAttachment.getPrimaryKey(),
			empAttachment);

		empAttachment.resetOriginalValues();

		return empAttachment;
	}

	protected EmpAttachment toUnwrappedModel(EmpAttachment empAttachment) {
		if (empAttachment instanceof EmpAttachmentImpl) {
			return empAttachment;
		}

		EmpAttachmentImpl empAttachmentImpl = new EmpAttachmentImpl();

		empAttachmentImpl.setNew(empAttachment.isNew());
		empAttachmentImpl.setPrimaryKey(empAttachment.getPrimaryKey());

		empAttachmentImpl.setEmpAttachmentId(empAttachment.getEmpAttachmentId());
		empAttachmentImpl.setEmployeeId(empAttachment.getEmployeeId());
		empAttachmentImpl.setGroupId(empAttachment.getGroupId());
		empAttachmentImpl.setCompanyId(empAttachment.getCompanyId());
		empAttachmentImpl.setUserId(empAttachment.getUserId());
		empAttachmentImpl.setCreateDate(empAttachment.getCreateDate());
		empAttachmentImpl.setModifiedDate(empAttachment.getModifiedDate());
		empAttachmentImpl.setAttachmentTypeId(empAttachment.getAttachmentTypeId());
		empAttachmentImpl.setFileName(empAttachment.getFileName());
		empAttachmentImpl.setFileSize(empAttachment.getFileSize());
		empAttachmentImpl.setFileType(empAttachment.getFileType());
		empAttachmentImpl.setFile(empAttachment.getFile());
		empAttachmentImpl.setComment(empAttachment.getComment());

		return empAttachmentImpl;
	}

	/**
	 * Returns the EmpAttachment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpAttachment
	 * @return the EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpAttachmentException, SystemException {
		EmpAttachment empAttachment = fetchByPrimaryKey(primaryKey);

		if (empAttachment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empAttachment;
	}

	/**
	 * Returns the EmpAttachment with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException} if it could not be found.
	 *
	 * @param empAttachmentId the primary key of the EmpAttachment
	 * @return the EmpAttachment
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpAttachmentException if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment findByPrimaryKey(long empAttachmentId)
		throws NoSuchEmpAttachmentException, SystemException {
		return findByPrimaryKey((Serializable)empAttachmentId);
	}

	/**
	 * Returns the EmpAttachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpAttachment
	 * @return the EmpAttachment, or <code>null</code> if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpAttachment empAttachment = (EmpAttachment)EntityCacheUtil.getResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				EmpAttachmentImpl.class, primaryKey);

		if (empAttachment == _nullEmpAttachment) {
			return null;
		}

		if (empAttachment == null) {
			Session session = null;

			try {
				session = openSession();

				empAttachment = (EmpAttachment)session.get(EmpAttachmentImpl.class,
						primaryKey);

				if (empAttachment != null) {
					cacheResult(empAttachment);
				}
				else {
					EntityCacheUtil.putResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						EmpAttachmentImpl.class, primaryKey, _nullEmpAttachment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					EmpAttachmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empAttachment;
	}

	/**
	 * Returns the EmpAttachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empAttachmentId the primary key of the EmpAttachment
	 * @return the EmpAttachment, or <code>null</code> if a EmpAttachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAttachment fetchByPrimaryKey(long empAttachmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empAttachmentId);
	}

	/**
	 * Returns all the EmpAttachments.
	 *
	 * @return the EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpAttachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @return the range of EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpAttachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpAttachments
	 * @param end the upper bound of the range of EmpAttachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpAttachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAttachment> findAll(int start, int end,
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

		List<EmpAttachment> list = (List<EmpAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPATTACHMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPATTACHMENT;

				if (pagination) {
					sql = sql.concat(EmpAttachmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpAttachment>(list);
				}
				else {
					list = (List<EmpAttachment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the EmpAttachments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpAttachment empAttachment : findAll()) {
			remove(empAttachment);
		}
	}

	/**
	 * Returns the number of EmpAttachments.
	 *
	 * @return the number of EmpAttachments
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

				Query q = session.createQuery(_SQL_COUNT_EMPATTACHMENT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the EmpAttachment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpAttachment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpAttachment>> listenersList = new ArrayList<ModelListener<EmpAttachment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpAttachment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpAttachmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPATTACHMENT = "SELECT empAttachment FROM EmpAttachment empAttachment";
	private static final String _SQL_SELECT_EMPATTACHMENT_WHERE = "SELECT empAttachment FROM EmpAttachment empAttachment WHERE ";
	private static final String _SQL_COUNT_EMPATTACHMENT = "SELECT COUNT(empAttachment) FROM EmpAttachment empAttachment";
	private static final String _SQL_COUNT_EMPATTACHMENT_WHERE = "SELECT COUNT(empAttachment) FROM EmpAttachment empAttachment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empAttachment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpAttachment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpAttachment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpAttachmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static EmpAttachment _nullEmpAttachment = new EmpAttachmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpAttachment> toCacheModel() {
				return _nullEmpAttachmentCacheModel;
			}
		};

	private static CacheModel<EmpAttachment> _nullEmpAttachmentCacheModel = new CacheModel<EmpAttachment>() {
			@Override
			public EmpAttachment toEntityModel() {
				return _nullEmpAttachment;
			}
		};
}