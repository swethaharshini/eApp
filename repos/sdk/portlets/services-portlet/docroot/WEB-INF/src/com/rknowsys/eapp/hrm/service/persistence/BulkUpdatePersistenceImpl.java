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

import com.rknowsys.eapp.hrm.NoSuchBulkUpdateException;
import com.rknowsys.eapp.hrm.model.BulkUpdate;
import com.rknowsys.eapp.hrm.model.impl.BulkUpdateImpl;
import com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bulk update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see BulkUpdatePersistence
 * @see BulkUpdateUtil
 * @generated
 */
public class BulkUpdatePersistenceImpl extends BasePersistenceImpl<BulkUpdate>
	implements BulkUpdatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BulkUpdateUtil} to access the bulk update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BulkUpdateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateModelImpl.FINDER_CACHE_ENABLED, BulkUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateModelImpl.FINDER_CACHE_ENABLED, BulkUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BulkUpdatePersistenceImpl() {
		setModelClass(BulkUpdate.class);
	}

	/**
	 * Caches the bulk update in the entity cache if it is enabled.
	 *
	 * @param bulkUpdate the bulk update
	 */
	@Override
	public void cacheResult(BulkUpdate bulkUpdate) {
		EntityCacheUtil.putResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateImpl.class, bulkUpdate.getPrimaryKey(), bulkUpdate);

		bulkUpdate.resetOriginalValues();
	}

	/**
	 * Caches the bulk updates in the entity cache if it is enabled.
	 *
	 * @param bulkUpdates the bulk updates
	 */
	@Override
	public void cacheResult(List<BulkUpdate> bulkUpdates) {
		for (BulkUpdate bulkUpdate : bulkUpdates) {
			if (EntityCacheUtil.getResult(
						BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
						BulkUpdateImpl.class, bulkUpdate.getPrimaryKey()) == null) {
				cacheResult(bulkUpdate);
			}
			else {
				bulkUpdate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bulk updates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BulkUpdateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BulkUpdateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bulk update.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BulkUpdate bulkUpdate) {
		EntityCacheUtil.removeResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateImpl.class, bulkUpdate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BulkUpdate> bulkUpdates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BulkUpdate bulkUpdate : bulkUpdates) {
			EntityCacheUtil.removeResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
				BulkUpdateImpl.class, bulkUpdate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bulk update with the primary key. Does not add the bulk update to the database.
	 *
	 * @param bulkupdateId the primary key for the new bulk update
	 * @return the new bulk update
	 */
	@Override
	public BulkUpdate create(long bulkupdateId) {
		BulkUpdate bulkUpdate = new BulkUpdateImpl();

		bulkUpdate.setNew(true);
		bulkUpdate.setPrimaryKey(bulkupdateId);

		return bulkUpdate;
	}

	/**
	 * Removes the bulk update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bulkupdateId the primary key of the bulk update
	 * @return the bulk update that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchBulkUpdateException if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate remove(long bulkupdateId)
		throws NoSuchBulkUpdateException, SystemException {
		return remove((Serializable)bulkupdateId);
	}

	/**
	 * Removes the bulk update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bulk update
	 * @return the bulk update that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchBulkUpdateException if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate remove(Serializable primaryKey)
		throws NoSuchBulkUpdateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BulkUpdate bulkUpdate = (BulkUpdate)session.get(BulkUpdateImpl.class,
					primaryKey);

			if (bulkUpdate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBulkUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bulkUpdate);
		}
		catch (NoSuchBulkUpdateException nsee) {
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
	protected BulkUpdate removeImpl(BulkUpdate bulkUpdate)
		throws SystemException {
		bulkUpdate = toUnwrappedModel(bulkUpdate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bulkUpdate)) {
				bulkUpdate = (BulkUpdate)session.get(BulkUpdateImpl.class,
						bulkUpdate.getPrimaryKeyObj());
			}

			if (bulkUpdate != null) {
				session.delete(bulkUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bulkUpdate != null) {
			clearCache(bulkUpdate);
		}

		return bulkUpdate;
	}

	@Override
	public BulkUpdate updateImpl(
		com.rknowsys.eapp.hrm.model.BulkUpdate bulkUpdate)
		throws SystemException {
		bulkUpdate = toUnwrappedModel(bulkUpdate);

		boolean isNew = bulkUpdate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bulkUpdate.isNew()) {
				session.save(bulkUpdate);

				bulkUpdate.setNew(false);
			}
			else {
				session.merge(bulkUpdate);
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

		EntityCacheUtil.putResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
			BulkUpdateImpl.class, bulkUpdate.getPrimaryKey(), bulkUpdate);

		return bulkUpdate;
	}

	protected BulkUpdate toUnwrappedModel(BulkUpdate bulkUpdate) {
		if (bulkUpdate instanceof BulkUpdateImpl) {
			return bulkUpdate;
		}

		BulkUpdateImpl bulkUpdateImpl = new BulkUpdateImpl();

		bulkUpdateImpl.setNew(bulkUpdate.isNew());
		bulkUpdateImpl.setPrimaryKey(bulkUpdate.getPrimaryKey());

		bulkUpdateImpl.setBulkupdateId(bulkUpdate.getBulkupdateId());
		bulkUpdateImpl.setEmployeeId(bulkUpdate.getEmployeeId());
		bulkUpdateImpl.setEmployeeNo(bulkUpdate.getEmployeeNo());
		bulkUpdateImpl.setEmployeeName(bulkUpdate.getEmployeeName());
		bulkUpdateImpl.setEmploymentStatus(bulkUpdate.getEmploymentStatus());
		bulkUpdateImpl.setJobTitle(bulkUpdate.getJobTitle());
		bulkUpdateImpl.setJobtitleId(bulkUpdate.getJobtitleId());
		bulkUpdateImpl.setSubunit(bulkUpdate.getSubunit());
		bulkUpdateImpl.setSubunitId(bulkUpdate.getSubunitId());
		bulkUpdateImpl.setLocation(bulkUpdate.getLocation());
		bulkUpdateImpl.setLocationId(bulkUpdate.getLocationId());
		bulkUpdateImpl.setWorkshift(bulkUpdate.getWorkshift());
		bulkUpdateImpl.setShiftId(bulkUpdate.getShiftId());
		bulkUpdateImpl.setJoiningDate(bulkUpdate.getJoiningDate());
		bulkUpdateImpl.setSupervisor(bulkUpdate.getSupervisor());
		bulkUpdateImpl.setEmpStatus(bulkUpdate.getEmpStatus());

		return bulkUpdateImpl;
	}

	/**
	 * Returns the bulk update with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bulk update
	 * @return the bulk update
	 * @throws com.rknowsys.eapp.hrm.NoSuchBulkUpdateException if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBulkUpdateException, SystemException {
		BulkUpdate bulkUpdate = fetchByPrimaryKey(primaryKey);

		if (bulkUpdate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBulkUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bulkUpdate;
	}

	/**
	 * Returns the bulk update with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchBulkUpdateException} if it could not be found.
	 *
	 * @param bulkupdateId the primary key of the bulk update
	 * @return the bulk update
	 * @throws com.rknowsys.eapp.hrm.NoSuchBulkUpdateException if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate findByPrimaryKey(long bulkupdateId)
		throws NoSuchBulkUpdateException, SystemException {
		return findByPrimaryKey((Serializable)bulkupdateId);
	}

	/**
	 * Returns the bulk update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bulk update
	 * @return the bulk update, or <code>null</code> if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BulkUpdate bulkUpdate = (BulkUpdate)EntityCacheUtil.getResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
				BulkUpdateImpl.class, primaryKey);

		if (bulkUpdate == _nullBulkUpdate) {
			return null;
		}

		if (bulkUpdate == null) {
			Session session = null;

			try {
				session = openSession();

				bulkUpdate = (BulkUpdate)session.get(BulkUpdateImpl.class,
						primaryKey);

				if (bulkUpdate != null) {
					cacheResult(bulkUpdate);
				}
				else {
					EntityCacheUtil.putResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
						BulkUpdateImpl.class, primaryKey, _nullBulkUpdate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BulkUpdateModelImpl.ENTITY_CACHE_ENABLED,
					BulkUpdateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bulkUpdate;
	}

	/**
	 * Returns the bulk update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bulkupdateId the primary key of the bulk update
	 * @return the bulk update, or <code>null</code> if a bulk update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BulkUpdate fetchByPrimaryKey(long bulkupdateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bulkupdateId);
	}

	/**
	 * Returns all the bulk updates.
	 *
	 * @return the bulk updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BulkUpdate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bulk updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk updates
	 * @param end the upper bound of the range of bulk updates (not inclusive)
	 * @return the range of bulk updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BulkUpdate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bulk updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.BulkUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk updates
	 * @param end the upper bound of the range of bulk updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bulk updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BulkUpdate> findAll(int start, int end,
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

		List<BulkUpdate> list = (List<BulkUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BULKUPDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BULKUPDATE;

				if (pagination) {
					sql = sql.concat(BulkUpdateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BulkUpdate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BulkUpdate>(list);
				}
				else {
					list = (List<BulkUpdate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bulk updates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BulkUpdate bulkUpdate : findAll()) {
			remove(bulkUpdate);
		}
	}

	/**
	 * Returns the number of bulk updates.
	 *
	 * @return the number of bulk updates
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

				Query q = session.createQuery(_SQL_COUNT_BULKUPDATE);

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
	 * Initializes the bulk update persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.BulkUpdate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BulkUpdate>> listenersList = new ArrayList<ModelListener<BulkUpdate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BulkUpdate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BulkUpdateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BULKUPDATE = "SELECT bulkUpdate FROM BulkUpdate bulkUpdate";
	private static final String _SQL_COUNT_BULKUPDATE = "SELECT COUNT(bulkUpdate) FROM BulkUpdate bulkUpdate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bulkUpdate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BulkUpdate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BulkUpdatePersistenceImpl.class);
	private static BulkUpdate _nullBulkUpdate = new BulkUpdateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BulkUpdate> toCacheModel() {
				return _nullBulkUpdateCacheModel;
			}
		};

	private static CacheModel<BulkUpdate> _nullBulkUpdateCacheModel = new CacheModel<BulkUpdate>() {
			@Override
			public BulkUpdate toEntityModel() {
				return _nullBulkUpdate;
			}
		};
}