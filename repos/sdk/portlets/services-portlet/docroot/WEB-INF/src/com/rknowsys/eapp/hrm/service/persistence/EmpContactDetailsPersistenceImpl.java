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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsImpl;
import com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the EmpContactDetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmpContactDetailsPersistence
 * @see EmpContactDetailsUtil
 * @generated
 */
public class EmpContactDetailsPersistenceImpl extends BasePersistenceImpl<EmpContactDetails>
	implements EmpContactDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpContactDetailsUtil} to access the EmpContactDetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpContactDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpContactDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmpContactDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpContactDetailsPersistenceImpl() {
		setModelClass(EmpContactDetails.class);
	}

	/**
	 * Caches the EmpContactDetails in the entity cache if it is enabled.
	 *
	 * @param empContactDetails the EmpContactDetails
	 */
	@Override
	public void cacheResult(EmpContactDetails empContactDetails) {
		EntityCacheUtil.putResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsImpl.class, empContactDetails.getPrimaryKey(),
			empContactDetails);

		empContactDetails.resetOriginalValues();
	}

	/**
	 * Caches the EmpContactDetailses in the entity cache if it is enabled.
	 *
	 * @param empContactDetailses the EmpContactDetailses
	 */
	@Override
	public void cacheResult(List<EmpContactDetails> empContactDetailses) {
		for (EmpContactDetails empContactDetails : empContactDetailses) {
			if (EntityCacheUtil.getResult(
						EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpContactDetailsImpl.class,
						empContactDetails.getPrimaryKey()) == null) {
				cacheResult(empContactDetails);
			}
			else {
				empContactDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EmpContactDetailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpContactDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpContactDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EmpContactDetails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpContactDetails empContactDetails) {
		EntityCacheUtil.removeResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsImpl.class, empContactDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpContactDetails> empContactDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpContactDetails empContactDetails : empContactDetailses) {
			EntityCacheUtil.removeResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpContactDetailsImpl.class, empContactDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EmpContactDetails with the primary key. Does not add the EmpContactDetails to the database.
	 *
	 * @param empContactDetailsId the primary key for the new EmpContactDetails
	 * @return the new EmpContactDetails
	 */
	@Override
	public EmpContactDetails create(long empContactDetailsId) {
		EmpContactDetails empContactDetails = new EmpContactDetailsImpl();

		empContactDetails.setNew(true);
		empContactDetails.setPrimaryKey(empContactDetailsId);

		return empContactDetails;
	}

	/**
	 * Removes the EmpContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empContactDetailsId the primary key of the EmpContactDetails
	 * @return the EmpContactDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails remove(long empContactDetailsId)
		throws NoSuchEmpContactDetailsException, SystemException {
		return remove((Serializable)empContactDetailsId);
	}

	/**
	 * Removes the EmpContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmpContactDetails
	 * @return the EmpContactDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails remove(Serializable primaryKey)
		throws NoSuchEmpContactDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpContactDetails empContactDetails = (EmpContactDetails)session.get(EmpContactDetailsImpl.class,
					primaryKey);

			if (empContactDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpContactDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empContactDetails);
		}
		catch (NoSuchEmpContactDetailsException nsee) {
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
	protected EmpContactDetails removeImpl(EmpContactDetails empContactDetails)
		throws SystemException {
		empContactDetails = toUnwrappedModel(empContactDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empContactDetails)) {
				empContactDetails = (EmpContactDetails)session.get(EmpContactDetailsImpl.class,
						empContactDetails.getPrimaryKeyObj());
			}

			if (empContactDetails != null) {
				session.delete(empContactDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empContactDetails != null) {
			clearCache(empContactDetails);
		}

		return empContactDetails;
	}

	@Override
	public EmpContactDetails updateImpl(
		com.rknowsys.eapp.hrm.model.EmpContactDetails empContactDetails)
		throws SystemException {
		empContactDetails = toUnwrappedModel(empContactDetails);

		boolean isNew = empContactDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empContactDetails.isNew()) {
				session.save(empContactDetails);

				empContactDetails.setNew(false);
			}
			else {
				session.merge(empContactDetails);
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

		EntityCacheUtil.putResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmpContactDetailsImpl.class, empContactDetails.getPrimaryKey(),
			empContactDetails);

		return empContactDetails;
	}

	protected EmpContactDetails toUnwrappedModel(
		EmpContactDetails empContactDetails) {
		if (empContactDetails instanceof EmpContactDetailsImpl) {
			return empContactDetails;
		}

		EmpContactDetailsImpl empContactDetailsImpl = new EmpContactDetailsImpl();

		empContactDetailsImpl.setNew(empContactDetails.isNew());
		empContactDetailsImpl.setPrimaryKey(empContactDetails.getPrimaryKey());

		empContactDetailsImpl.setEmpContactDetailsId(empContactDetails.getEmpContactDetailsId());
		empContactDetailsImpl.setEmployeeId(empContactDetails.getEmployeeId());
		empContactDetailsImpl.setGroupId(empContactDetails.getGroupId());
		empContactDetailsImpl.setCompanyId(empContactDetails.getCompanyId());
		empContactDetailsImpl.setUserId(empContactDetails.getUserId());
		empContactDetailsImpl.setUserName(empContactDetails.getUserName());
		empContactDetailsImpl.setCreateDate(empContactDetails.getCreateDate());
		empContactDetailsImpl.setModifiedDate(empContactDetails.getModifiedDate());
		empContactDetailsImpl.setAddressStreet1(empContactDetails.getAddressStreet1());
		empContactDetailsImpl.setAddressStreet2(empContactDetails.getAddressStreet2());
		empContactDetailsImpl.setCity(empContactDetails.getCity());
		empContactDetailsImpl.setState(empContactDetails.getState());
		empContactDetailsImpl.setPostalCode(empContactDetails.getPostalCode());
		empContactDetailsImpl.setCountry(empContactDetails.getCountry());
		empContactDetailsImpl.setHomeTelephone(empContactDetails.getHomeTelephone());
		empContactDetailsImpl.setMobile(empContactDetails.getMobile());
		empContactDetailsImpl.setWorkTelephone(empContactDetails.getWorkTelephone());
		empContactDetailsImpl.setWorkEmail(empContactDetails.getWorkEmail());
		empContactDetailsImpl.setOtherEmail(empContactDetails.getOtherEmail());

		return empContactDetailsImpl;
	}

	/**
	 * Returns the EmpContactDetails with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpContactDetails
	 * @return the EmpContactDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpContactDetailsException, SystemException {
		EmpContactDetails empContactDetails = fetchByPrimaryKey(primaryKey);

		if (empContactDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpContactDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empContactDetails;
	}

	/**
	 * Returns the EmpContactDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException} if it could not be found.
	 *
	 * @param empContactDetailsId the primary key of the EmpContactDetails
	 * @return the EmpContactDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmpContactDetailsException if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails findByPrimaryKey(long empContactDetailsId)
		throws NoSuchEmpContactDetailsException, SystemException {
		return findByPrimaryKey((Serializable)empContactDetailsId);
	}

	/**
	 * Returns the EmpContactDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmpContactDetails
	 * @return the EmpContactDetails, or <code>null</code> if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpContactDetails empContactDetails = (EmpContactDetails)EntityCacheUtil.getResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmpContactDetailsImpl.class, primaryKey);

		if (empContactDetails == _nullEmpContactDetails) {
			return null;
		}

		if (empContactDetails == null) {
			Session session = null;

			try {
				session = openSession();

				empContactDetails = (EmpContactDetails)session.get(EmpContactDetailsImpl.class,
						primaryKey);

				if (empContactDetails != null) {
					cacheResult(empContactDetails);
				}
				else {
					EntityCacheUtil.putResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmpContactDetailsImpl.class, primaryKey,
						_nullEmpContactDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmpContactDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empContactDetails;
	}

	/**
	 * Returns the EmpContactDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empContactDetailsId the primary key of the EmpContactDetails
	 * @return the EmpContactDetails, or <code>null</code> if a EmpContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpContactDetails fetchByPrimaryKey(long empContactDetailsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empContactDetailsId);
	}

	/**
	 * Returns all the EmpContactDetailses.
	 *
	 * @return the EmpContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpContactDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmpContactDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpContactDetailses
	 * @param end the upper bound of the range of EmpContactDetailses (not inclusive)
	 * @return the range of EmpContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpContactDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmpContactDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpContactDetailses
	 * @param end the upper bound of the range of EmpContactDetailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmpContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpContactDetails> findAll(int start, int end,
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

		List<EmpContactDetails> list = (List<EmpContactDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPCONTACTDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPCONTACTDETAILS;

				if (pagination) {
					sql = sql.concat(EmpContactDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpContactDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpContactDetails>(list);
				}
				else {
					list = (List<EmpContactDetails>)QueryUtil.list(q,
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
	 * Removes all the EmpContactDetailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpContactDetails empContactDetails : findAll()) {
			remove(empContactDetails);
		}
	}

	/**
	 * Returns the number of EmpContactDetailses.
	 *
	 * @return the number of EmpContactDetailses
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

				Query q = session.createQuery(_SQL_COUNT_EMPCONTACTDETAILS);

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
	 * Initializes the EmpContactDetails persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmpContactDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpContactDetails>> listenersList = new ArrayList<ModelListener<EmpContactDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpContactDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpContactDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPCONTACTDETAILS = "SELECT empContactDetails FROM EmpContactDetails empContactDetails";
	private static final String _SQL_COUNT_EMPCONTACTDETAILS = "SELECT COUNT(empContactDetails) FROM EmpContactDetails empContactDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empContactDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpContactDetails exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpContactDetailsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static EmpContactDetails _nullEmpContactDetails = new EmpContactDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpContactDetails> toCacheModel() {
				return _nullEmpContactDetailsCacheModel;
			}
		};

	private static CacheModel<EmpContactDetails> _nullEmpContactDetailsCacheModel =
		new CacheModel<EmpContactDetails>() {
			@Override
			public EmpContactDetails toEntityModel() {
				return _nullEmpContactDetails;
			}
		};
}