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

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.rknowsys.eapp.hrm.NoSuchHolidayException;
import com.rknowsys.eapp.hrm.model.Holiday;
import com.rknowsys.eapp.hrm.model.impl.HolidayImpl;
import com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the Holiday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see HolidayPersistence
 * @see HolidayUtil
 * @generated
 */
public class HolidayPersistenceImpl extends BasePersistenceImpl<Holiday>
	implements HolidayPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HolidayUtil} to access the Holiday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HolidayImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayModelImpl.FINDER_CACHE_ENABLED, HolidayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayModelImpl.FINDER_CACHE_ENABLED, HolidayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HolidayPersistenceImpl() {
		setModelClass(Holiday.class);
	}

	/**
	 * Caches the Holiday in the entity cache if it is enabled.
	 *
	 * @param holiday the Holiday
	 */
	@Override
	public void cacheResult(Holiday holiday) {
		EntityCacheUtil.putResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayImpl.class, holiday.getPrimaryKey(), holiday);

		holiday.resetOriginalValues();
	}

	/**
	 * Caches the Holidaies in the entity cache if it is enabled.
	 *
	 * @param holidaies the Holidaies
	 */
	@Override
	public void cacheResult(List<Holiday> holidaies) {
		for (Holiday holiday : holidaies) {
			if (EntityCacheUtil.getResult(
						HolidayModelImpl.ENTITY_CACHE_ENABLED,
						HolidayImpl.class, holiday.getPrimaryKey()) == null) {
				cacheResult(holiday);
			}
			else {
				holiday.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Holidaies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HolidayImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HolidayImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Holiday.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Holiday holiday) {
		EntityCacheUtil.removeResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayImpl.class, holiday.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Holiday> holidaies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Holiday holiday : holidaies) {
			EntityCacheUtil.removeResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
				HolidayImpl.class, holiday.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Holiday with the primary key. Does not add the Holiday to the database.
	 *
	 * @param holidayId the primary key for the new Holiday
	 * @return the new Holiday
	 */
	@Override
	public Holiday create(long holidayId) {
		Holiday holiday = new HolidayImpl();

		holiday.setNew(true);
		holiday.setPrimaryKey(holidayId);

		return holiday;
	}

	/**
	 * Removes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayId the primary key of the Holiday
	 * @return the Holiday that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday remove(long holidayId)
		throws NoSuchHolidayException, SystemException {
		return remove((Serializable)holidayId);
	}

	/**
	 * Removes the Holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Holiday
	 * @return the Holiday that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday remove(Serializable primaryKey)
		throws NoSuchHolidayException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Holiday holiday = (Holiday)session.get(HolidayImpl.class, primaryKey);

			if (holiday == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHolidayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(holiday);
		}
		catch (NoSuchHolidayException nsee) {
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
	protected Holiday removeImpl(Holiday holiday) throws SystemException {
		holiday = toUnwrappedModel(holiday);

		holidayToLocationTableMapper.deleteLeftPrimaryKeyTableMappings(holiday.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(holiday)) {
				holiday = (Holiday)session.get(HolidayImpl.class,
						holiday.getPrimaryKeyObj());
			}

			if (holiday != null) {
				session.delete(holiday);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (holiday != null) {
			clearCache(holiday);
		}

		return holiday;
	}

	@Override
	public Holiday updateImpl(com.rknowsys.eapp.hrm.model.Holiday holiday)
		throws SystemException {
		holiday = toUnwrappedModel(holiday);

		boolean isNew = holiday.isNew();

		Session session = null;

		try {
			session = openSession();

			if (holiday.isNew()) {
				session.save(holiday);

				holiday.setNew(false);
			}
			else {
				session.merge(holiday);
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

		EntityCacheUtil.putResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
			HolidayImpl.class, holiday.getPrimaryKey(), holiday);

		return holiday;
	}

	protected Holiday toUnwrappedModel(Holiday holiday) {
		if (holiday instanceof HolidayImpl) {
			return holiday;
		}

		HolidayImpl holidayImpl = new HolidayImpl();

		holidayImpl.setNew(holiday.isNew());
		holidayImpl.setPrimaryKey(holiday.getPrimaryKey());

		holidayImpl.setHolidayId(holiday.getHolidayId());
		holidayImpl.setHolidayName(holiday.getHolidayName());
		holidayImpl.setIsAnnual(holiday.isIsAnnual());
		holidayImpl.setIsFullDay(holiday.isIsFullDay());
		holidayImpl.setHolidayDate(holiday.getHolidayDate());
		holidayImpl.setNationalityId(holiday.getNationalityId());
		holidayImpl.setGroupId(holiday.getGroupId());
		holidayImpl.setCompanyId(holiday.getCompanyId());
		holidayImpl.setUserId(holiday.getUserId());
		holidayImpl.setUserName(holiday.getUserName());
		holidayImpl.setCreateDate(holiday.getCreateDate());
		holidayImpl.setModifiedDate(holiday.getModifiedDate());

		return holidayImpl;
	}

	/**
	 * Returns the Holiday with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Holiday
	 * @return the Holiday
	 * @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHolidayException, SystemException {
		Holiday holiday = fetchByPrimaryKey(primaryKey);

		if (holiday == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHolidayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return holiday;
	}

	/**
	 * Returns the Holiday with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchHolidayException} if it could not be found.
	 *
	 * @param holidayId the primary key of the Holiday
	 * @return the Holiday
	 * @throws com.rknowsys.eapp.hrm.NoSuchHolidayException if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday findByPrimaryKey(long holidayId)
		throws NoSuchHolidayException, SystemException {
		return findByPrimaryKey((Serializable)holidayId);
	}

	/**
	 * Returns the Holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Holiday
	 * @return the Holiday, or <code>null</code> if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Holiday holiday = (Holiday)EntityCacheUtil.getResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
				HolidayImpl.class, primaryKey);

		if (holiday == _nullHoliday) {
			return null;
		}

		if (holiday == null) {
			Session session = null;

			try {
				session = openSession();

				holiday = (Holiday)session.get(HolidayImpl.class, primaryKey);

				if (holiday != null) {
					cacheResult(holiday);
				}
				else {
					EntityCacheUtil.putResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
						HolidayImpl.class, primaryKey, _nullHoliday);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HolidayModelImpl.ENTITY_CACHE_ENABLED,
					HolidayImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return holiday;
	}

	/**
	 * Returns the Holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the Holiday
	 * @return the Holiday, or <code>null</code> if a Holiday with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Holiday fetchByPrimaryKey(long holidayId) throws SystemException {
		return fetchByPrimaryKey((Serializable)holidayId);
	}

	/**
	 * Returns all the Holidaies.
	 *
	 * @return the Holidaies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Holiday> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Holidaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Holidaies
	 * @param end the upper bound of the range of Holidaies (not inclusive)
	 * @return the range of Holidaies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Holiday> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Holidaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Holidaies
	 * @param end the upper bound of the range of Holidaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Holidaies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Holiday> findAll(int start, int end,
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

		List<Holiday> list = (List<Holiday>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOLIDAY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOLIDAY;

				if (pagination) {
					sql = sql.concat(HolidayModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Holiday>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Holiday>(list);
				}
				else {
					list = (List<Holiday>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Holidaies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Holiday holiday : findAll()) {
			remove(holiday);
		}
	}

	/**
	 * Returns the number of Holidaies.
	 *
	 * @return the number of Holidaies
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

				Query q = session.createQuery(_SQL_COUNT_HOLIDAY);

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
	 * Returns all the locations associated with the Holiday.
	 *
	 * @param pk the primary key of the Holiday
	 * @return the locations associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Location> getLocations(long pk)
		throws SystemException {
		return getLocations(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the locations associated with the Holiday.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the Holiday
	 * @param start the lower bound of the range of Holidaies
	 * @param end the upper bound of the range of Holidaies (not inclusive)
	 * @return the range of locations associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Location> getLocations(long pk,
		int start, int end) throws SystemException {
		return getLocations(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations associated with the Holiday.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.HolidayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the Holiday
	 * @param start the lower bound of the range of Holidaies
	 * @param end the upper bound of the range of Holidaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.rknowsys.eapp.hrm.model.Location> getLocations(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return holidayToLocationTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of locations associated with the Holiday.
	 *
	 * @param pk the primary key of the Holiday
	 * @return the number of locations associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getLocationsSize(long pk) throws SystemException {
		long[] pks = holidayToLocationTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the location is associated with the Holiday.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPK the primary key of the location
	 * @return <code>true</code> if the location is associated with the Holiday; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsLocation(long pk, long locationPK)
		throws SystemException {
		return holidayToLocationTableMapper.containsTableMapping(pk, locationPK);
	}

	/**
	 * Returns <code>true</code> if the Holiday has any locations associated with it.
	 *
	 * @param pk the primary key of the Holiday to check for associations with locations
	 * @return <code>true</code> if the Holiday has any locations associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsLocations(long pk) throws SystemException {
		if (getLocationsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPK the primary key of the location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLocation(long pk, long locationPK) throws SystemException {
		holidayToLocationTableMapper.addTableMapping(pk, locationPK);
	}

	/**
	 * Adds an association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param location the location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws SystemException {
		holidayToLocationTableMapper.addTableMapping(pk,
			location.getPrimaryKey());
	}

	/**
	 * Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPKs the primary keys of the locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLocations(long pk, long[] locationPKs)
		throws SystemException {
		for (long locationPK : locationPKs) {
			holidayToLocationTableMapper.addTableMapping(pk, locationPK);
		}
	}

	/**
	 * Adds an association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locations the locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLocations(long pk,
		List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.Location location : locations) {
			holidayToLocationTableMapper.addTableMapping(pk,
				location.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the Holiday and its locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday to clear the associated locations from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearLocations(long pk) throws SystemException {
		holidayToLocationTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPK the primary key of the location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLocation(long pk, long locationPK)
		throws SystemException {
		holidayToLocationTableMapper.deleteTableMapping(pk, locationPK);
	}

	/**
	 * Removes the association between the Holiday and the location. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param location the location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLocation(long pk,
		com.rknowsys.eapp.hrm.model.Location location)
		throws SystemException {
		holidayToLocationTableMapper.deleteTableMapping(pk,
			location.getPrimaryKey());
	}

	/**
	 * Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPKs the primary keys of the locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLocations(long pk, long[] locationPKs)
		throws SystemException {
		for (long locationPK : locationPKs) {
			holidayToLocationTableMapper.deleteTableMapping(pk, locationPK);
		}
	}

	/**
	 * Removes the association between the Holiday and the locations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locations the locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLocations(long pk,
		List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws SystemException {
		for (com.rknowsys.eapp.hrm.model.Location location : locations) {
			holidayToLocationTableMapper.deleteTableMapping(pk,
				location.getPrimaryKey());
		}
	}

	/**
	 * Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locationPKs the primary keys of the locations to be associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setLocations(long pk, long[] locationPKs)
		throws SystemException {
		Set<Long> newLocationPKsSet = SetUtil.fromArray(locationPKs);
		Set<Long> oldLocationPKsSet = SetUtil.fromArray(holidayToLocationTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeLocationPKsSet = new HashSet<Long>(oldLocationPKsSet);

		removeLocationPKsSet.removeAll(newLocationPKsSet);

		for (long removeLocationPK : removeLocationPKsSet) {
			holidayToLocationTableMapper.deleteTableMapping(pk, removeLocationPK);
		}

		newLocationPKsSet.removeAll(oldLocationPKsSet);

		for (long newLocationPK : newLocationPKsSet) {
			holidayToLocationTableMapper.addTableMapping(pk, newLocationPK);
		}
	}

	/**
	 * Sets the locations associated with the Holiday, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Holiday
	 * @param locations the locations to be associated with the Holiday
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setLocations(long pk,
		List<com.rknowsys.eapp.hrm.model.Location> locations)
		throws SystemException {
		try {
			long[] locationPKs = new long[locations.size()];

			for (int i = 0; i < locations.size(); i++) {
				com.rknowsys.eapp.hrm.model.Location location = locations.get(i);

				locationPKs[i] = location.getPrimaryKey();
			}

			setLocations(pk, locationPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(HolidayModelImpl.MAPPING_TABLE_HRM_LOCATIONS_HOLIDAYS_NAME);
		}
	}

	/**
	 * Initializes the Holiday persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Holiday")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Holiday>> listenersList = new ArrayList<ModelListener<Holiday>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Holiday>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		holidayToLocationTableMapper = TableMapperFactory.getTableMapper("hrm_locations_holidays",
				"holidayId", "locationId", this, locationPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HolidayImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	protected TableMapper<Holiday, com.rknowsys.eapp.hrm.model.Location> holidayToLocationTableMapper;
	private static final String _SQL_SELECT_HOLIDAY = "SELECT holiday FROM Holiday holiday";
	private static final String _SQL_COUNT_HOLIDAY = "SELECT COUNT(holiday) FROM Holiday holiday";
	private static final String _ORDER_BY_ENTITY_ALIAS = "holiday.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Holiday exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HolidayPersistenceImpl.class);
	private static Holiday _nullHoliday = new HolidayImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Holiday> toCacheModel() {
				return _nullHolidayCacheModel;
			}
		};

	private static CacheModel<Holiday> _nullHolidayCacheModel = new CacheModel<Holiday>() {
			@Override
			public Holiday toEntityModel() {
				return _nullHoliday;
			}
		};
}