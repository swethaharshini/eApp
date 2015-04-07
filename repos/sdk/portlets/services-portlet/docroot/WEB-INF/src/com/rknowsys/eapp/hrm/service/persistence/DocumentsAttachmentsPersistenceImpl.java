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

import com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException;
import com.rknowsys.eapp.hrm.model.DocumentsAttachments;
import com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsImpl;
import com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the documents attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DocumentsAttachmentsPersistence
 * @see DocumentsAttachmentsUtil
 * @generated
 */
public class DocumentsAttachmentsPersistenceImpl extends BasePersistenceImpl<DocumentsAttachments>
	implements DocumentsAttachmentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentsAttachmentsUtil} to access the documents attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentsAttachmentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			DocumentsAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			DocumentsAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DocumentsAttachmentsPersistenceImpl() {
		setModelClass(DocumentsAttachments.class);
	}

	/**
	 * Caches the documents attachments in the entity cache if it is enabled.
	 *
	 * @param documentsAttachments the documents attachments
	 */
	@Override
	public void cacheResult(DocumentsAttachments documentsAttachments) {
		EntityCacheUtil.putResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsImpl.class,
			documentsAttachments.getPrimaryKey(), documentsAttachments);

		documentsAttachments.resetOriginalValues();
	}

	/**
	 * Caches the documents attachmentses in the entity cache if it is enabled.
	 *
	 * @param documentsAttachmentses the documents attachmentses
	 */
	@Override
	public void cacheResult(List<DocumentsAttachments> documentsAttachmentses) {
		for (DocumentsAttachments documentsAttachments : documentsAttachmentses) {
			if (EntityCacheUtil.getResult(
						DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsAttachmentsImpl.class,
						documentsAttachments.getPrimaryKey()) == null) {
				cacheResult(documentsAttachments);
			}
			else {
				documentsAttachments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documents attachmentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocumentsAttachmentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocumentsAttachmentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the documents attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentsAttachments documentsAttachments) {
		EntityCacheUtil.removeResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsImpl.class, documentsAttachments.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DocumentsAttachments> documentsAttachmentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentsAttachments documentsAttachments : documentsAttachmentses) {
			EntityCacheUtil.removeResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsAttachmentsImpl.class,
				documentsAttachments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new documents attachments with the primary key. Does not add the documents attachments to the database.
	 *
	 * @param documentAttachmentId the primary key for the new documents attachments
	 * @return the new documents attachments
	 */
	@Override
	public DocumentsAttachments create(long documentAttachmentId) {
		DocumentsAttachments documentsAttachments = new DocumentsAttachmentsImpl();

		documentsAttachments.setNew(true);
		documentsAttachments.setPrimaryKey(documentAttachmentId);

		return documentsAttachments;
	}

	/**
	 * Removes the documents attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentAttachmentId the primary key of the documents attachments
	 * @return the documents attachments that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments remove(long documentAttachmentId)
		throws NoSuchDocumentsAttachmentsException, SystemException {
		return remove((Serializable)documentAttachmentId);
	}

	/**
	 * Removes the documents attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the documents attachments
	 * @return the documents attachments that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments remove(Serializable primaryKey)
		throws NoSuchDocumentsAttachmentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DocumentsAttachments documentsAttachments = (DocumentsAttachments)session.get(DocumentsAttachmentsImpl.class,
					primaryKey);

			if (documentsAttachments == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentsAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documentsAttachments);
		}
		catch (NoSuchDocumentsAttachmentsException nsee) {
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
	protected DocumentsAttachments removeImpl(
		DocumentsAttachments documentsAttachments) throws SystemException {
		documentsAttachments = toUnwrappedModel(documentsAttachments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentsAttachments)) {
				documentsAttachments = (DocumentsAttachments)session.get(DocumentsAttachmentsImpl.class,
						documentsAttachments.getPrimaryKeyObj());
			}

			if (documentsAttachments != null) {
				session.delete(documentsAttachments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentsAttachments != null) {
			clearCache(documentsAttachments);
		}

		return documentsAttachments;
	}

	@Override
	public DocumentsAttachments updateImpl(
		com.rknowsys.eapp.hrm.model.DocumentsAttachments documentsAttachments)
		throws SystemException {
		documentsAttachments = toUnwrappedModel(documentsAttachments);

		boolean isNew = documentsAttachments.isNew();

		Session session = null;

		try {
			session = openSession();

			if (documentsAttachments.isNew()) {
				session.save(documentsAttachments);

				documentsAttachments.setNew(false);
			}
			else {
				session.merge(documentsAttachments);
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

		EntityCacheUtil.putResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsAttachmentsImpl.class,
			documentsAttachments.getPrimaryKey(), documentsAttachments);

		return documentsAttachments;
	}

	protected DocumentsAttachments toUnwrappedModel(
		DocumentsAttachments documentsAttachments) {
		if (documentsAttachments instanceof DocumentsAttachmentsImpl) {
			return documentsAttachments;
		}

		DocumentsAttachmentsImpl documentsAttachmentsImpl = new DocumentsAttachmentsImpl();

		documentsAttachmentsImpl.setNew(documentsAttachments.isNew());
		documentsAttachmentsImpl.setPrimaryKey(documentsAttachments.getPrimaryKey());

		documentsAttachmentsImpl.setDocumentAttachmentId(documentsAttachments.getDocumentAttachmentId());
		documentsAttachmentsImpl.setCompanyId(documentsAttachments.getCompanyId());
		documentsAttachmentsImpl.setGroupId(documentsAttachments.getGroupId());
		documentsAttachmentsImpl.setCreateDate(documentsAttachments.getCreateDate());
		documentsAttachmentsImpl.setModifiedDate(documentsAttachments.getModifiedDate());
		documentsAttachmentsImpl.setUserId(documentsAttachments.getUserId());
		documentsAttachmentsImpl.setAttachmentTypeId(documentsAttachments.getAttachmentTypeId());
		documentsAttachmentsImpl.setDocumentId(documentsAttachments.getDocumentId());
		documentsAttachmentsImpl.setDescription(documentsAttachments.getDescription());
		documentsAttachmentsImpl.setUuid(documentsAttachments.getUuid());
		documentsAttachmentsImpl.setFileName(documentsAttachments.getFileName());
		documentsAttachmentsImpl.setFileSize(documentsAttachments.getFileSize());
		documentsAttachmentsImpl.setFileType(documentsAttachments.getFileType());

		return documentsAttachmentsImpl;
	}

	/**
	 * Returns the documents attachments with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents attachments
	 * @return the documents attachments
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentsAttachmentsException, SystemException {
		DocumentsAttachments documentsAttachments = fetchByPrimaryKey(primaryKey);

		if (documentsAttachments == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentsAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documentsAttachments;
	}

	/**
	 * Returns the documents attachments with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException} if it could not be found.
	 *
	 * @param documentAttachmentId the primary key of the documents attachments
	 * @return the documents attachments
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsAttachmentsException if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments findByPrimaryKey(long documentAttachmentId)
		throws NoSuchDocumentsAttachmentsException, SystemException {
		return findByPrimaryKey((Serializable)documentAttachmentId);
	}

	/**
	 * Returns the documents attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents attachments
	 * @return the documents attachments, or <code>null</code> if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DocumentsAttachments documentsAttachments = (DocumentsAttachments)EntityCacheUtil.getResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsAttachmentsImpl.class, primaryKey);

		if (documentsAttachments == _nullDocumentsAttachments) {
			return null;
		}

		if (documentsAttachments == null) {
			Session session = null;

			try {
				session = openSession();

				documentsAttachments = (DocumentsAttachments)session.get(DocumentsAttachmentsImpl.class,
						primaryKey);

				if (documentsAttachments != null) {
					cacheResult(documentsAttachments);
				}
				else {
					EntityCacheUtil.putResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsAttachmentsImpl.class, primaryKey,
						_nullDocumentsAttachments);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DocumentsAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
					DocumentsAttachmentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentsAttachments;
	}

	/**
	 * Returns the documents attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentAttachmentId the primary key of the documents attachments
	 * @return the documents attachments, or <code>null</code> if a documents attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocumentsAttachments fetchByPrimaryKey(long documentAttachmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)documentAttachmentId);
	}

	/**
	 * Returns all the documents attachmentses.
	 *
	 * @return the documents attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentsAttachments> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the documents attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents attachmentses
	 * @param end the upper bound of the range of documents attachmentses (not inclusive)
	 * @return the range of documents attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentsAttachments> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the documents attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents attachmentses
	 * @param end the upper bound of the range of documents attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documents attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocumentsAttachments> findAll(int start, int end,
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

		List<DocumentsAttachments> list = (List<DocumentsAttachments>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCUMENTSATTACHMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTSATTACHMENTS;

				if (pagination) {
					sql = sql.concat(DocumentsAttachmentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentsAttachments>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DocumentsAttachments>(list);
				}
				else {
					list = (List<DocumentsAttachments>)QueryUtil.list(q,
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
	 * Removes all the documents attachmentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DocumentsAttachments documentsAttachments : findAll()) {
			remove(documentsAttachments);
		}
	}

	/**
	 * Returns the number of documents attachmentses.
	 *
	 * @return the number of documents attachmentses
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

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTSATTACHMENTS);

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
	 * Initializes the documents attachments persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.DocumentsAttachments")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DocumentsAttachments>> listenersList = new ArrayList<ModelListener<DocumentsAttachments>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DocumentsAttachments>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocumentsAttachmentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOCUMENTSATTACHMENTS = "SELECT documentsAttachments FROM DocumentsAttachments documentsAttachments";
	private static final String _SQL_COUNT_DOCUMENTSATTACHMENTS = "SELECT COUNT(documentsAttachments) FROM DocumentsAttachments documentsAttachments";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documentsAttachments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocumentsAttachments exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocumentsAttachmentsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static DocumentsAttachments _nullDocumentsAttachments = new DocumentsAttachmentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DocumentsAttachments> toCacheModel() {
				return _nullDocumentsAttachmentsCacheModel;
			}
		};

	private static CacheModel<DocumentsAttachments> _nullDocumentsAttachmentsCacheModel =
		new CacheModel<DocumentsAttachments>() {
			@Override
			public DocumentsAttachments toEntityModel() {
				return _nullDocumentsAttachments;
			}
		};
}