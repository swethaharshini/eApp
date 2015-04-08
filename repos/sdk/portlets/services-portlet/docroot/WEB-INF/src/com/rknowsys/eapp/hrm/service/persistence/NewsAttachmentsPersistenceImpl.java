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

import com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException;
import com.rknowsys.eapp.hrm.model.NewsAttachments;
import com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsImpl;
import com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the news attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NewsAttachmentsPersistence
 * @see NewsAttachmentsUtil
 * @generated
 */
public class NewsAttachmentsPersistenceImpl extends BasePersistenceImpl<NewsAttachments>
	implements NewsAttachmentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsAttachmentsUtil} to access the news attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsAttachmentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			NewsAttachmentsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			NewsAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NewsAttachmentsPersistenceImpl() {
		setModelClass(NewsAttachments.class);
	}

	/**
	 * Caches the news attachments in the entity cache if it is enabled.
	 *
	 * @param newsAttachments the news attachments
	 */
	@Override
	public void cacheResult(NewsAttachments newsAttachments) {
		EntityCacheUtil.putResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsImpl.class, newsAttachments.getPrimaryKey(),
			newsAttachments);

		newsAttachments.resetOriginalValues();
	}

	/**
	 * Caches the news attachmentses in the entity cache if it is enabled.
	 *
	 * @param newsAttachmentses the news attachmentses
	 */
	@Override
	public void cacheResult(List<NewsAttachments> newsAttachmentses) {
		for (NewsAttachments newsAttachments : newsAttachmentses) {
			if (EntityCacheUtil.getResult(
						NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						NewsAttachmentsImpl.class,
						newsAttachments.getPrimaryKey()) == null) {
				cacheResult(newsAttachments);
			}
			else {
				newsAttachments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all news attachmentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NewsAttachmentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NewsAttachmentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewsAttachments newsAttachments) {
		EntityCacheUtil.removeResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsImpl.class, newsAttachments.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NewsAttachments> newsAttachmentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NewsAttachments newsAttachments : newsAttachmentses) {
			EntityCacheUtil.removeResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				NewsAttachmentsImpl.class, newsAttachments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new news attachments with the primary key. Does not add the news attachments to the database.
	 *
	 * @param newsAttachmentId the primary key for the new news attachments
	 * @return the new news attachments
	 */
	@Override
	public NewsAttachments create(long newsAttachmentId) {
		NewsAttachments newsAttachments = new NewsAttachmentsImpl();

		newsAttachments.setNew(true);
		newsAttachments.setPrimaryKey(newsAttachmentId);

		return newsAttachments;
	}

	/**
	 * Removes the news attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsAttachmentId the primary key of the news attachments
	 * @return the news attachments that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments remove(long newsAttachmentId)
		throws NoSuchNewsAttachmentsException, SystemException {
		return remove((Serializable)newsAttachmentId);
	}

	/**
	 * Removes the news attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news attachments
	 * @return the news attachments that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments remove(Serializable primaryKey)
		throws NoSuchNewsAttachmentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NewsAttachments newsAttachments = (NewsAttachments)session.get(NewsAttachmentsImpl.class,
					primaryKey);

			if (newsAttachments == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newsAttachments);
		}
		catch (NoSuchNewsAttachmentsException nsee) {
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
	protected NewsAttachments removeImpl(NewsAttachments newsAttachments)
		throws SystemException {
		newsAttachments = toUnwrappedModel(newsAttachments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsAttachments)) {
				newsAttachments = (NewsAttachments)session.get(NewsAttachmentsImpl.class,
						newsAttachments.getPrimaryKeyObj());
			}

			if (newsAttachments != null) {
				session.delete(newsAttachments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (newsAttachments != null) {
			clearCache(newsAttachments);
		}

		return newsAttachments;
	}

	@Override
	public NewsAttachments updateImpl(
		com.rknowsys.eapp.hrm.model.NewsAttachments newsAttachments)
		throws SystemException {
		newsAttachments = toUnwrappedModel(newsAttachments);

		boolean isNew = newsAttachments.isNew();

		Session session = null;

		try {
			session = openSession();

			if (newsAttachments.isNew()) {
				session.save(newsAttachments);

				newsAttachments.setNew(false);
			}
			else {
				session.merge(newsAttachments);
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

		EntityCacheUtil.putResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			NewsAttachmentsImpl.class, newsAttachments.getPrimaryKey(),
			newsAttachments);

		return newsAttachments;
	}

	protected NewsAttachments toUnwrappedModel(NewsAttachments newsAttachments) {
		if (newsAttachments instanceof NewsAttachmentsImpl) {
			return newsAttachments;
		}

		NewsAttachmentsImpl newsAttachmentsImpl = new NewsAttachmentsImpl();

		newsAttachmentsImpl.setNew(newsAttachments.isNew());
		newsAttachmentsImpl.setPrimaryKey(newsAttachments.getPrimaryKey());

		newsAttachmentsImpl.setNewsAttachmentId(newsAttachments.getNewsAttachmentId());
		newsAttachmentsImpl.setCompanyId(newsAttachments.getCompanyId());
		newsAttachmentsImpl.setGroupId(newsAttachments.getGroupId());
		newsAttachmentsImpl.setCreateDate(newsAttachments.getCreateDate());
		newsAttachmentsImpl.setModifiedDate(newsAttachments.getModifiedDate());
		newsAttachmentsImpl.setUserId(newsAttachments.getUserId());
		newsAttachmentsImpl.setAttachmentTypeId(newsAttachments.getAttachmentTypeId());
		newsAttachmentsImpl.setNewsId(newsAttachments.getNewsId());
		newsAttachmentsImpl.setDescription(newsAttachments.getDescription());
		newsAttachmentsImpl.setUuid(newsAttachments.getUuid());
		newsAttachmentsImpl.setFileName(newsAttachments.getFileName());
		newsAttachmentsImpl.setFileSize(newsAttachments.getFileSize());
		newsAttachmentsImpl.setFileType(newsAttachments.getFileType());

		return newsAttachmentsImpl;
	}

	/**
	 * Returns the news attachments with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the news attachments
	 * @return the news attachments
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsAttachmentsException, SystemException {
		NewsAttachments newsAttachments = fetchByPrimaryKey(primaryKey);

		if (newsAttachments == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return newsAttachments;
	}

	/**
	 * Returns the news attachments with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException} if it could not be found.
	 *
	 * @param newsAttachmentId the primary key of the news attachments
	 * @return the news attachments
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsAttachmentsException if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments findByPrimaryKey(long newsAttachmentId)
		throws NoSuchNewsAttachmentsException, SystemException {
		return findByPrimaryKey((Serializable)newsAttachmentId);
	}

	/**
	 * Returns the news attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news attachments
	 * @return the news attachments, or <code>null</code> if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NewsAttachments newsAttachments = (NewsAttachments)EntityCacheUtil.getResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				NewsAttachmentsImpl.class, primaryKey);

		if (newsAttachments == _nullNewsAttachments) {
			return null;
		}

		if (newsAttachments == null) {
			Session session = null;

			try {
				session = openSession();

				newsAttachments = (NewsAttachments)session.get(NewsAttachmentsImpl.class,
						primaryKey);

				if (newsAttachments != null) {
					cacheResult(newsAttachments);
				}
				else {
					EntityCacheUtil.putResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						NewsAttachmentsImpl.class, primaryKey,
						_nullNewsAttachments);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NewsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
					NewsAttachmentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return newsAttachments;
	}

	/**
	 * Returns the news attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsAttachmentId the primary key of the news attachments
	 * @return the news attachments, or <code>null</code> if a news attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NewsAttachments fetchByPrimaryKey(long newsAttachmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)newsAttachmentId);
	}

	/**
	 * Returns all the news attachmentses.
	 *
	 * @return the news attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NewsAttachments> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news attachmentses
	 * @param end the upper bound of the range of news attachmentses (not inclusive)
	 * @return the range of news attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NewsAttachments> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news attachmentses
	 * @param end the upper bound of the range of news attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NewsAttachments> findAll(int start, int end,
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

		List<NewsAttachments> list = (List<NewsAttachments>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NEWSATTACHMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSATTACHMENTS;

				if (pagination) {
					sql = sql.concat(NewsAttachmentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NewsAttachments>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NewsAttachments>(list);
				}
				else {
					list = (List<NewsAttachments>)QueryUtil.list(q,
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
	 * Removes all the news attachmentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NewsAttachments newsAttachments : findAll()) {
			remove(newsAttachments);
		}
	}

	/**
	 * Returns the number of news attachmentses.
	 *
	 * @return the number of news attachmentses
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

				Query q = session.createQuery(_SQL_COUNT_NEWSATTACHMENTS);

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
	 * Initializes the news attachments persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.NewsAttachments")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NewsAttachments>> listenersList = new ArrayList<ModelListener<NewsAttachments>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NewsAttachments>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NewsAttachmentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NEWSATTACHMENTS = "SELECT newsAttachments FROM NewsAttachments newsAttachments";
	private static final String _SQL_COUNT_NEWSATTACHMENTS = "SELECT COUNT(newsAttachments) FROM NewsAttachments newsAttachments";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newsAttachments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NewsAttachments exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NewsAttachmentsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static NewsAttachments _nullNewsAttachments = new NewsAttachmentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NewsAttachments> toCacheModel() {
				return _nullNewsAttachmentsCacheModel;
			}
		};

	private static CacheModel<NewsAttachments> _nullNewsAttachmentsCacheModel = new CacheModel<NewsAttachments>() {
			@Override
			public NewsAttachments toEntityModel() {
				return _nullNewsAttachments;
			}
		};
}