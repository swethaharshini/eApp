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

import com.rknowsys.eapp.hrm.NoSuchEmpDetailsException;
import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.model.impl.EmpDetailsImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpDetailsPersistence
 * @see EmpDetailsUtil
 * @generated
 */
public class EmpDetailsPersistenceImpl extends BasePersistenceImpl<EmpDetails>
	implements EmpDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpDetailsUtil} to access the emp details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsModelImpl.FINDER_CACHE_ENABLED, EmpDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsModelImpl.FINDER_CACHE_ENABLED, EmpDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpDetailsPersistenceImpl() {
		setModelClass(EmpDetails.class);
	}

	/**
	 * Caches the emp details in the entity cache if it is enabled.
	 *
	 * @param empDetails the emp details
	 */
	@Override
	public void cacheResult(EmpDetails empDetails) {
		EntityCacheUtil.putResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsImpl.class, empDetails.getPrimaryKey(), empDetails);

		empDetails.resetOriginalValues();
	}

	/**
	 * Caches the emp detailses in the entity cache if it is enabled.
	 *
	 * @param empDetailses the emp detailses
	 */
	@Override
	public void cacheResult(List<EmpDetails> empDetailses) {
		for (EmpDetails empDetails : empDetailses) {
			if (EntityCacheUtil.getResult(
						EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpDetailsImpl.class, empDetails.getPrimaryKey()) == null) {
				cacheResult(empDetails);
			}
			else {
				empDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpDetails empDetails) {
		EntityCacheUtil.removeResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsImpl.class, empDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpDetails> empDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpDetails empDetails : empDetailses) {
			EntityCacheUtil.removeResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpDetailsImpl.class, empDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp details with the primary key. Does not add the emp details to the database.
	 *
	 * @param empdetailsId the primary key for the new emp details
	 * @return the new emp details
	 */
	@Override
	public EmpDetails create(long empdetailsId) {
		EmpDetails empDetails = new EmpDetailsImpl();

		empDetails.setNew(true);
		empDetails.setPrimaryKey(empdetailsId);

		return empDetails;
	}

	/**
	 * Removes the emp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empdetailsId the primary key of the emp details
	 * @return the emp details that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDetailsException if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails remove(long empdetailsId)
		throws NoSuchEmpDetailsException, SystemException {
		return remove((Serializable)empdetailsId);
	}

	/**
	 * Removes the emp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp details
	 * @return the emp details that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDetailsException if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails remove(Serializable primaryKey)
		throws NoSuchEmpDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpDetails empDetails = (EmpDetails)session.get(EmpDetailsImpl.class,
					primaryKey);

			if (empDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empDetails);
		}
		catch (NoSuchEmpDetailsException nsee) {
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
	protected EmpDetails removeImpl(EmpDetails empDetails)
		throws SystemException {
		empDetails = toUnwrappedModel(empDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empDetails)) {
				empDetails = (EmpDetails)session.get(EmpDetailsImpl.class,
						empDetails.getPrimaryKeyObj());
			}

			if (empDetails != null) {
				session.delete(empDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empDetails != null) {
			clearCache(empDetails);
		}

		return empDetails;
	}

	@Override
	public EmpDetails updateImpl(
		com.rknowsys.eapp.hrm.model.EmpDetails empDetails)
		throws SystemException {
		empDetails = toUnwrappedModel(empDetails);

		boolean isNew = empDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empDetails.isNew()) {
				session.save(empDetails);

				empDetails.setNew(false);
			}
			else {
				session.merge(empDetails);
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

		EntityCacheUtil.putResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpDetailsImpl.class, empDetails.getPrimaryKey(), empDetails);

		return empDetails;
	}

	protected EmpDetails toUnwrappedModel(EmpDetails empDetails) {
		if (empDetails instanceof EmpDetailsImpl) {
			return empDetails;
		}

		EmpDetailsImpl empDetailsImpl = new EmpDetailsImpl();

		empDetailsImpl.setNew(empDetails.isNew());
		empDetailsImpl.setPrimaryKey(empDetails.getPrimaryKey());

		empDetailsImpl.setEmpdetailsId(empDetails.getEmpdetailsId());
		empDetailsImpl.setEmployeeNo(empDetails.getEmployeeNo());
		empDetailsImpl.setCompanyId(empDetails.getCompanyId());
		empDetailsImpl.setUserId(empDetails.getUserId());
		empDetailsImpl.setCreateDate(empDetails.getCreateDate());
		empDetailsImpl.setModifiedDate(empDetails.getModifiedDate());
		empDetailsImpl.setFirstName(empDetails.getFirstName());
		empDetailsImpl.setLastName(empDetails.getLastName());
		empDetailsImpl.setTitle(empDetails.getTitle());
		empDetailsImpl.setEmploymentstatus(empDetails.getEmploymentstatus());
		empDetailsImpl.setName(empDetails.getName());
		empDetailsImpl.setSupervisor(empDetails.getSupervisor());

		return empDetailsImpl;
	}

	/**
	 * Returns the emp details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp details
	 * @return the emp details
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDetailsException if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpDetailsException, SystemException {
		EmpDetails empDetails = fetchByPrimaryKey(primaryKey);

		if (empDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empDetails;
	}

	/**
	 * Returns the emp details with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpDetailsException} if it could not be found.
	 *
	 * @param empdetailsId the primary key of the emp details
	 * @return the emp details
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpDetailsException if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails findByPrimaryKey(long empdetailsId)
		throws NoSuchEmpDetailsException, SystemException {
		return findByPrimaryKey((Serializable)empdetailsId);
	}

	/**
	 * Returns the emp details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp details
	 * @return the emp details, or <code>null</code> if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpDetails empDetails = (EmpDetails)EntityCacheUtil.getResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpDetailsImpl.class, primaryKey);

		if (empDetails == _nullEmpDetails) {
			return null;
		}

		if (empDetails == null) {
			Session session = null;

			try {
				session = openSession();

				empDetails = (EmpDetails)session.get(EmpDetailsImpl.class,
						primaryKey);

				if (empDetails != null) {
					cacheResult(empDetails);
				}
				else {
					EntityCacheUtil.putResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpDetailsImpl.class, primaryKey, _nullEmpDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmpDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empDetails;
	}

	/**
	 * Returns the emp details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empdetailsId the primary key of the emp details
	 * @return the emp details, or <code>null</code> if a emp details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDetails fetchByPrimaryKey(long empdetailsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empdetailsId);
	}

	/**
	 * Returns all the emp detailses.
	 *
	 * @return the emp detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp detailses
	 * @param end the upper bound of the range of emp detailses (not inclusive)
	 * @return the range of emp detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp detailses
	 * @param end the upper bound of the range of emp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDetails> findAll(int start, int end,
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

		List<EmpDetails> list = (List<EmpDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPDETAILS;

				if (pagination) {
					sql = sql.concat(EmpDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDetails>(list);
				}
				else {
					list = (List<EmpDetails>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpDetails empDetails : findAll()) {
			remove(empDetails);
		}
	}

	/**
	 * Returns the number of emp detailses.
	 *
	 * @return the number of emp detailses
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

				Query q = session.createQuery(_SQL_COUNT_EMPDETAILS);

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
	 * Initializes the emp details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpDetails>> listenersList = new ArrayList<ModelListener<EmpDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPDETAILS = "SELECT empDetails FROM EmpDetails empDetails";
	private static final String _SQL_COUNT_EMPDETAILS = "SELECT COUNT(empDetails) FROM EmpDetails empDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpDetails exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpDetailsPersistenceImpl.class);
	private static EmpDetails _nullEmpDetails = new EmpDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpDetails> toCacheModel() {
				return _nullEmpDetailsCacheModel;
			}
		};

	private static CacheModel<EmpDetails> _nullEmpDetailsCacheModel = new CacheModel<EmpDetails>() {
			@Override
			public EmpDetails toEntityModel() {
				return _nullEmpDetails;
			}
		};
}