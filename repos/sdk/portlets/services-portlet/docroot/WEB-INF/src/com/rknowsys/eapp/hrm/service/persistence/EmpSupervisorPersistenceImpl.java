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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException;
import com.rknowsys.eapp.hrm.model.EmpSupervisor;
import com.rknowsys.eapp.hrm.model.impl.EmpSupervisorImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the EmpSupervisor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSupervisorPersistence
 * @see EmpSupervisorUtil
 * @generated
 */
public class EmpSupervisorPersistenceImpl extends BasePersistenceImpl<EmpSupervisor>
	implements EmpSupervisorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpSupervisorUtil} to access the EmpSupervisor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpSupervisorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorModelImpl.FINDER_CACHE_ENABLED,
			EmpSupervisorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorModelImpl.FINDER_CACHE_ENABLED,
			EmpSupervisorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpSupervisorPersistenceImpl() {
		setModelClass(EmpSupervisor.class);
	}

	/**
	 * Caches the EmpSupervisor in the entity cache if it is enabled.
	 *
	 * @param empSupervisor the EmpSupervisor
	 */
	@Override
	public void cacheResult(EmpSupervisor empSupervisor) {
		EntityCacheUtil.putResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorImpl.class, empSupervisor.getPrimaryKey(),
			empSupervisor);

		empSupervisor.resetOriginalValues();
	}

	/**
	 * Caches the EmpSupervisors in the entity cache if it is enabled.
	 *
	 * @param empSupervisors the EmpSupervisors
	 */
	@Override
	public void cacheResult(List<EmpSupervisor> empSupervisors) {
		for (EmpSupervisor empSupervisor : empSupervisors) {
			if (EntityCacheUtil.getResult(
						EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
						EmpSupervisorImpl.class, empSupervisor.getPrimaryKey()) == null) {
				cacheResult(empSupervisor);
			}
			else {
				empSupervisor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpSupervisors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpSupervisorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpSupervisorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpSupervisor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpSupervisor empSupervisor) {
		EntityCacheUtil.removeResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorImpl.class, empSupervisor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpSupervisor> empSupervisors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpSupervisor empSupervisor : empSupervisors) {
			EntityCacheUtil.removeResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
				EmpSupervisorImpl.class, empSupervisor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpSupervisor with the primary key. Does not add the EmpSupervisor to the database.
	 *
	 * @param empSupervisorId the primary key for the new EmpSupervisor
	 * @return the new EmpSupervisor
	 */
	@Override
	public EmpSupervisor create(long empSupervisorId) {
		EmpSupervisor empSupervisor = new EmpSupervisorImpl();

		empSupervisor.setNew(true);
		empSupervisor.setPrimaryKey(empSupervisorId);

		return empSupervisor;
	}

	/**
	 * Removes the EmpSupervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empSupervisorId the primary key of the EmpSupervisor
	 * @return the EmpSupervisor that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor remove(long empSupervisorId)
		throws NoSuchEmpSupervisorException, SystemException {
		return remove((Serializable)empSupervisorId);
	}

	/**
	 * Removes the EmpSupervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpSupervisor
	 * @return the EmpSupervisor that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor remove(Serializable primaryKey)
		throws NoSuchEmpSupervisorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpSupervisor empSupervisor = (EmpSupervisor)session.get(EmpSupervisorImpl.class,
					primaryKey);

			if (empSupervisor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empSupervisor);
		}
		catch (NoSuchEmpSupervisorException nsee) {
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
	protected EmpSupervisor removeImpl(EmpSupervisor empSupervisor)
		throws SystemException {
		empSupervisor = toUnwrappedModel(empSupervisor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empSupervisor)) {
				empSupervisor = (EmpSupervisor)session.get(EmpSupervisorImpl.class,
						empSupervisor.getPrimaryKeyObj());
			}

			if (empSupervisor != null) {
				session.delete(empSupervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empSupervisor != null) {
			clearCache(empSupervisor);
		}

		return empSupervisor;
	}

	@Override
	public EmpSupervisor updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSupervisor empSupervisor)
		throws SystemException {
		empSupervisor = toUnwrappedModel(empSupervisor);

		boolean isNew = empSupervisor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empSupervisor.isNew()) {
				session.save(empSupervisor);

				empSupervisor.setNew(false);
			}
			else {
				session.merge(empSupervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			EmpSupervisorImpl.class, empSupervisor.getPrimaryKey(),
			empSupervisor);

		return empSupervisor;
	}

	protected EmpSupervisor toUnwrappedModel(EmpSupervisor empSupervisor) {
		if (empSupervisor instanceof EmpSupervisorImpl) {
			return empSupervisor;
		}

		EmpSupervisorImpl empSupervisorImpl = new EmpSupervisorImpl();

		empSupervisorImpl.setNew(empSupervisor.isNew());
		empSupervisorImpl.setPrimaryKey(empSupervisor.getPrimaryKey());

		empSupervisorImpl.setEmpSupervisorId(empSupervisor.getEmpSupervisorId());
		empSupervisorImpl.setEmployeeId(empSupervisor.getEmployeeId());
		empSupervisorImpl.setGroupId(empSupervisor.getGroupId());
		empSupervisorImpl.setCompanyId(empSupervisor.getCompanyId());
		empSupervisorImpl.setUserId(empSupervisor.getUserId());
		empSupervisorImpl.setCreateDate(empSupervisor.getCreateDate());
		empSupervisorImpl.setModifiedDate(empSupervisor.getModifiedDate());
		empSupervisorImpl.setReporterEmployeeId(empSupervisor.getReporterEmployeeId());
		empSupervisorImpl.setReportingMethod(empSupervisor.getReportingMethod());

		return empSupervisorImpl;
	}

	/**
	 * Returns the EmpSupervisor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpSupervisor
	 * @return the EmpSupervisor
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpSupervisorException, SystemException {
		EmpSupervisor empSupervisor = fetchByPrimaryKey(primaryKey);

		if (empSupervisor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empSupervisor;
	}

	/**
	 * Returns the EmpSupervisor with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException} if it could not be found.
	 *
	 * @param empSupervisorId the primary key of the EmpSupervisor
	 * @return the EmpSupervisor
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSupervisorException if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor findByPrimaryKey(long empSupervisorId)
		throws NoSuchEmpSupervisorException, SystemException {
		return findByPrimaryKey((Serializable)empSupervisorId);
	}

	/**
	 * Returns the EmpSupervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpSupervisor
	 * @return the EmpSupervisor, or <code>null</code> if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpSupervisor empSupervisor = (EmpSupervisor)EntityCacheUtil.getResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
				EmpSupervisorImpl.class, primaryKey);

		if (empSupervisor == _nullEmpSupervisor) {
			return null;
		}

		if (empSupervisor == null) {
			Session session = null;

			try {
				session = openSession();

				empSupervisor = (EmpSupervisor)session.get(EmpSupervisorImpl.class,
						primaryKey);

				if (empSupervisor != null) {
					cacheResult(empSupervisor);
				}
				else {
					EntityCacheUtil.putResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
						EmpSupervisorImpl.class, primaryKey, _nullEmpSupervisor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpSupervisorModelImpl.ENTITY_CACHE_ENABLED,
					EmpSupervisorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empSupervisor;
	}

	/**
	 * Returns the EmpSupervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empSupervisorId the primary key of the EmpSupervisor
	 * @return the EmpSupervisor, or <code>null</code> if a EmpSupervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSupervisor fetchByPrimaryKey(long empSupervisorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empSupervisorId);
	}

	/**
	 * Returns all the EmpSupervisors.
	 *
	 * @return the EmpSupervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSupervisor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpSupervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpSupervisors
	 * @param end the upper bound of the range of EmpSupervisors (not inclusive)
	 * @return the range of EmpSupervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSupervisor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpSupervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpSupervisors
	 * @param end the upper bound of the range of EmpSupervisors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpSupervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSupervisor> findAll(int start, int end,
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

		List<EmpSupervisor> list = (List<EmpSupervisor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPSUPERVISOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPSUPERVISOR;

				if (pagination) {
					sql = sql.concat(EmpSupervisorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpSupervisor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSupervisor>(list);
				}
				else {
					list = (List<EmpSupervisor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the EmpSupervisors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpSupervisor empSupervisor : findAll()) {
			remove(empSupervisor);
		}
	}

	/**
	 * Returns the number of EmpSupervisors.
	 *
	 * @return the number of EmpSupervisors
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

				Query q = session.createQuery(_SQL_COUNT_EMPSUPERVISOR);

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
	 * Initializes the EmpSupervisor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpSupervisor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpSupervisor>> listenersList = new ArrayList<ModelListener<EmpSupervisor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpSupervisor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpSupervisorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPSUPERVISOR = "SELECT empSupervisor FROM EmpSupervisor empSupervisor";
	private static final String _SQL_COUNT_EMPSUPERVISOR = "SELECT COUNT(empSupervisor) FROM EmpSupervisor empSupervisor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empSupervisor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpSupervisor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpSupervisorPersistenceImpl.class);
	private static EmpSupervisor _nullEmpSupervisor = new EmpSupervisorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpSupervisor> toCacheModel() {
				return _nullEmpSupervisorCacheModel;
			}
		};

	private static CacheModel<EmpSupervisor> _nullEmpSupervisorCacheModel = new CacheModel<EmpSupervisor>() {
			@Override
			public EmpSupervisor toEntityModel() {
				return _nullEmpSupervisor;
			}
		};
}