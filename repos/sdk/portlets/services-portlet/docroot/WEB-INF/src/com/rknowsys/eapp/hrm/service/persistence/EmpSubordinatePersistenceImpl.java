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

import com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException;
import com.rknowsys.eapp.hrm.model.EmpSubordinate;
import com.rknowsys.eapp.hrm.model.impl.EmpSubordinateImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the EmpSubordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpSubordinatePersistence
 * @see EmpSubordinateUtil
 * @generated
 */
public class EmpSubordinatePersistenceImpl extends BasePersistenceImpl<EmpSubordinate>
	implements EmpSubordinatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpSubordinateUtil} to access the EmpSubordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpSubordinateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateModelImpl.FINDER_CACHE_ENABLED,
			EmpSubordinateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateModelImpl.FINDER_CACHE_ENABLED,
			EmpSubordinateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpSubordinatePersistenceImpl() {
		setModelClass(EmpSubordinate.class);
	}

	/**
	 * Caches the EmpSubordinate in the entity cache if it is enabled.
	 *
	 * @param empSubordinate the EmpSubordinate
	 */
	@Override
	public void cacheResult(EmpSubordinate empSubordinate) {
		EntityCacheUtil.putResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateImpl.class, empSubordinate.getPrimaryKey(),
			empSubordinate);

		empSubordinate.resetOriginalValues();
	}

	/**
	 * Caches the EmpSubordinates in the entity cache if it is enabled.
	 *
	 * @param empSubordinates the EmpSubordinates
	 */
	@Override
	public void cacheResult(List<EmpSubordinate> empSubordinates) {
		for (EmpSubordinate empSubordinate : empSubordinates) {
			if (EntityCacheUtil.getResult(
						EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
						EmpSubordinateImpl.class, empSubordinate.getPrimaryKey()) == null) {
				cacheResult(empSubordinate);
			}
			else {
				empSubordinate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpSubordinates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpSubordinateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpSubordinateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpSubordinate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpSubordinate empSubordinate) {
		EntityCacheUtil.removeResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateImpl.class, empSubordinate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpSubordinate> empSubordinates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpSubordinate empSubordinate : empSubordinates) {
			EntityCacheUtil.removeResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
				EmpSubordinateImpl.class, empSubordinate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpSubordinate with the primary key. Does not add the EmpSubordinate to the database.
	 *
	 * @param empSubordinateId the primary key for the new EmpSubordinate
	 * @return the new EmpSubordinate
	 */
	@Override
	public EmpSubordinate create(long empSubordinateId) {
		EmpSubordinate empSubordinate = new EmpSubordinateImpl();

		empSubordinate.setNew(true);
		empSubordinate.setPrimaryKey(empSubordinateId);

		return empSubordinate;
	}

	/**
	 * Removes the EmpSubordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empSubordinateId the primary key of the EmpSubordinate
	 * @return the EmpSubordinate that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate remove(long empSubordinateId)
		throws NoSuchEmpSubordinateException, SystemException {
		return remove((Serializable)empSubordinateId);
	}

	/**
	 * Removes the EmpSubordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpSubordinate
	 * @return the EmpSubordinate that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate remove(Serializable primaryKey)
		throws NoSuchEmpSubordinateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpSubordinate empSubordinate = (EmpSubordinate)session.get(EmpSubordinateImpl.class,
					primaryKey);

			if (empSubordinate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpSubordinateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empSubordinate);
		}
		catch (NoSuchEmpSubordinateException nsee) {
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
	protected EmpSubordinate removeImpl(EmpSubordinate empSubordinate)
		throws SystemException {
		empSubordinate = toUnwrappedModel(empSubordinate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empSubordinate)) {
				empSubordinate = (EmpSubordinate)session.get(EmpSubordinateImpl.class,
						empSubordinate.getPrimaryKeyObj());
			}

			if (empSubordinate != null) {
				session.delete(empSubordinate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empSubordinate != null) {
			clearCache(empSubordinate);
		}

		return empSubordinate;
	}

	@Override
	public EmpSubordinate updateImpl(
		com.rknowsys.eapp.hrm.model.EmpSubordinate empSubordinate)
		throws SystemException {
		empSubordinate = toUnwrappedModel(empSubordinate);

		boolean isNew = empSubordinate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empSubordinate.isNew()) {
				session.save(empSubordinate);

				empSubordinate.setNew(false);
			}
			else {
				session.merge(empSubordinate);
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

		EntityCacheUtil.putResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
			EmpSubordinateImpl.class, empSubordinate.getPrimaryKey(),
			empSubordinate);

		return empSubordinate;
	}

	protected EmpSubordinate toUnwrappedModel(EmpSubordinate empSubordinate) {
		if (empSubordinate instanceof EmpSubordinateImpl) {
			return empSubordinate;
		}

		EmpSubordinateImpl empSubordinateImpl = new EmpSubordinateImpl();

		empSubordinateImpl.setNew(empSubordinate.isNew());
		empSubordinateImpl.setPrimaryKey(empSubordinate.getPrimaryKey());

		empSubordinateImpl.setEmpSubordinateId(empSubordinate.getEmpSubordinateId());
		empSubordinateImpl.setEmployeeId(empSubordinate.getEmployeeId());
		empSubordinateImpl.setGroupId(empSubordinate.getGroupId());
		empSubordinateImpl.setCompanyId(empSubordinate.getCompanyId());
		empSubordinateImpl.setUserId(empSubordinate.getUserId());
		empSubordinateImpl.setCreateDate(empSubordinate.getCreateDate());
		empSubordinateImpl.setModifiedDate(empSubordinate.getModifiedDate());
		empSubordinateImpl.setReporterEmployeeId(empSubordinate.getReporterEmployeeId());
		empSubordinateImpl.setReportingMethod(empSubordinate.getReportingMethod());

		return empSubordinateImpl;
	}

	/**
	 * Returns the EmpSubordinate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpSubordinate
	 * @return the EmpSubordinate
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpSubordinateException, SystemException {
		EmpSubordinate empSubordinate = fetchByPrimaryKey(primaryKey);

		if (empSubordinate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpSubordinateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empSubordinate;
	}

	/**
	 * Returns the EmpSubordinate with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException} if it could not be found.
	 *
	 * @param empSubordinateId the primary key of the EmpSubordinate
	 * @return the EmpSubordinate
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpSubordinateException if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate findByPrimaryKey(long empSubordinateId)
		throws NoSuchEmpSubordinateException, SystemException {
		return findByPrimaryKey((Serializable)empSubordinateId);
	}

	/**
	 * Returns the EmpSubordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpSubordinate
	 * @return the EmpSubordinate, or <code>null</code> if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpSubordinate empSubordinate = (EmpSubordinate)EntityCacheUtil.getResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
				EmpSubordinateImpl.class, primaryKey);

		if (empSubordinate == _nullEmpSubordinate) {
			return null;
		}

		if (empSubordinate == null) {
			Session session = null;

			try {
				session = openSession();

				empSubordinate = (EmpSubordinate)session.get(EmpSubordinateImpl.class,
						primaryKey);

				if (empSubordinate != null) {
					cacheResult(empSubordinate);
				}
				else {
					EntityCacheUtil.putResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
						EmpSubordinateImpl.class, primaryKey,
						_nullEmpSubordinate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpSubordinateModelImpl.ENTITY_CACHE_ENABLED,
					EmpSubordinateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empSubordinate;
	}

	/**
	 * Returns the EmpSubordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empSubordinateId the primary key of the EmpSubordinate
	 * @return the EmpSubordinate, or <code>null</code> if a EmpSubordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpSubordinate fetchByPrimaryKey(long empSubordinateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empSubordinateId);
	}

	/**
	 * Returns all the EmpSubordinates.
	 *
	 * @return the EmpSubordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSubordinate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpSubordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpSubordinates
	 * @param end the upper bound of the range of EmpSubordinates (not inclusive)
	 * @return the range of EmpSubordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSubordinate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpSubordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSubordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpSubordinates
	 * @param end the upper bound of the range of EmpSubordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpSubordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpSubordinate> findAll(int start, int end,
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

		List<EmpSubordinate> list = (List<EmpSubordinate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPSUBORDINATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPSUBORDINATE;

				if (pagination) {
					sql = sql.concat(EmpSubordinateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpSubordinate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpSubordinate>(list);
				}
				else {
					list = (List<EmpSubordinate>)QueryUtil.list(q,
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
	 * Removes all the EmpSubordinates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpSubordinate empSubordinate : findAll()) {
			remove(empSubordinate);
		}
	}

	/**
	 * Returns the number of EmpSubordinates.
	 *
	 * @return the number of EmpSubordinates
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

				Query q = session.createQuery(_SQL_COUNT_EMPSUBORDINATE);

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
	 * Initializes the EmpSubordinate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpSubordinate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpSubordinate>> listenersList = new ArrayList<ModelListener<EmpSubordinate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpSubordinate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpSubordinateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPSUBORDINATE = "SELECT empSubordinate FROM EmpSubordinate empSubordinate";
	private static final String _SQL_COUNT_EMPSUBORDINATE = "SELECT COUNT(empSubordinate) FROM EmpSubordinate empSubordinate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empSubordinate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpSubordinate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpSubordinatePersistenceImpl.class);
	private static EmpSubordinate _nullEmpSubordinate = new EmpSubordinateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpSubordinate> toCacheModel() {
				return _nullEmpSubordinateCacheModel;
			}
		};

	private static CacheModel<EmpSubordinate> _nullEmpSubordinateCacheModel = new CacheModel<EmpSubordinate>() {
			@Override
			public EmpSubordinate toEntityModel() {
				return _nullEmpSubordinate;
			}
		};
}