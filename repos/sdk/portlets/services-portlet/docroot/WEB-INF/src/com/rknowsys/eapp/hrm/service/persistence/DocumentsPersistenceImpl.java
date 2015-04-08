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

import com.rknowsys.eapp.hrm.NoSuchDocumentsException;
import com.rknowsys.eapp.hrm.model.Documents;
import com.rknowsys.eapp.hrm.model.impl.DocumentsImpl;
import com.rknowsys.eapp.hrm.model.impl.DocumentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DocumentsPersistence
 * @see DocumentsUtil
 * @generated
 */
public class DocumentsPersistenceImpl extends BasePersistenceImpl<Documents>
	implements DocumentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentsUtil} to access the documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsModelImpl.FINDER_CACHE_ENABLED, DocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsModelImpl.FINDER_CACHE_ENABLED, DocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DocumentsPersistenceImpl() {
		setModelClass(Documents.class);
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	@Override
	public void cacheResult(Documents documents) {
		EntityCacheUtil.putResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsImpl.class, documents.getPrimaryKey(), documents);

		documents.resetOriginalValues();
	}

	/**
	 * Caches the documentses in the entity cache if it is enabled.
	 *
	 * @param documentses the documentses
	 */
	@Override
	public void cacheResult(List<Documents> documentses) {
		for (Documents documents : documentses) {
			if (EntityCacheUtil.getResult(
						DocumentsModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsImpl.class, documents.getPrimaryKey()) == null) {
				cacheResult(documents);
			}
			else {
				documents.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocumentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocumentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Documents documents) {
		EntityCacheUtil.removeResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsImpl.class, documents.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Documents> documentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Documents documents : documentses) {
			EntityCacheUtil.removeResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsImpl.class, documents.getPrimaryKey());
		}
	}

	/**
	 * Creates a new documents with the primary key. Does not add the documents to the database.
	 *
	 * @param documentId the primary key for the new documents
	 * @return the new documents
	 */
	@Override
	public Documents create(long documentId) {
		Documents documents = new DocumentsImpl();

		documents.setNew(true);
		documents.setPrimaryKey(documentId);

		return documents;
	}

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsException if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents remove(long documentId)
		throws NoSuchDocumentsException, SystemException {
		return remove((Serializable)documentId);
	}

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the documents
	 * @return the documents that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsException if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents remove(Serializable primaryKey)
		throws NoSuchDocumentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Documents documents = (Documents)session.get(DocumentsImpl.class,
					primaryKey);

			if (documents == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documents);
		}
		catch (NoSuchDocumentsException nsee) {
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
	protected Documents removeImpl(Documents documents)
		throws SystemException {
		documents = toUnwrappedModel(documents);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documents)) {
				documents = (Documents)session.get(DocumentsImpl.class,
						documents.getPrimaryKeyObj());
			}

			if (documents != null) {
				session.delete(documents);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documents != null) {
			clearCache(documents);
		}

		return documents;
	}

	@Override
	public Documents updateImpl(com.rknowsys.eapp.hrm.model.Documents documents)
		throws SystemException {
		documents = toUnwrappedModel(documents);

		boolean isNew = documents.isNew();

		Session session = null;

		try {
			session = openSession();

			if (documents.isNew()) {
				session.save(documents);

				documents.setNew(false);
			}
			else {
				session.merge(documents);
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

		EntityCacheUtil.putResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsImpl.class, documents.getPrimaryKey(), documents);

		return documents;
	}

	protected Documents toUnwrappedModel(Documents documents) {
		if (documents instanceof DocumentsImpl) {
			return documents;
		}

		DocumentsImpl documentsImpl = new DocumentsImpl();

		documentsImpl.setNew(documents.isNew());
		documentsImpl.setPrimaryKey(documents.getPrimaryKey());

		documentsImpl.setDocumentId(documents.getDocumentId());
		documentsImpl.setCompanyId(documents.getCompanyId());
		documentsImpl.setGroupId(documents.getGroupId());
		documentsImpl.setCreateDate(documents.getCreateDate());
		documentsImpl.setModifiedDate(documents.getModifiedDate());
		documentsImpl.setUserId(documents.getUserId());
		documentsImpl.setTopic(documents.getTopic());
		documentsImpl.setCategory(documents.getCategory());
		documentsImpl.setDescription(documents.getDescription());
		documentsImpl.setPublishDate(documents.getPublishDate());
		documentsImpl.setStatus(documents.isStatus());
		documentsImpl.setAdmin(documents.isAdmin());
		documentsImpl.setSupervisor(documents.isSupervisor());
		documentsImpl.setAllEmployees(documents.isAllEmployees());
		documentsImpl.setPublishedTo(documents.getPublishedTo());

		return documentsImpl;
	}

	/**
	 * Returns the documents with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents
	 * @return the documents
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsException if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentsException, SystemException {
		Documents documents = fetchByPrimaryKey(primaryKey);

		if (documents == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documents;
	}

	/**
	 * Returns the documents with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDocumentsException} if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocumentsException if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents findByPrimaryKey(long documentId)
		throws NoSuchDocumentsException, SystemException {
		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents
	 * @return the documents, or <code>null</code> if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Documents documents = (Documents)EntityCacheUtil.getResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsImpl.class, primaryKey);

		if (documents == _nullDocuments) {
			return null;
		}

		if (documents == null) {
			Session session = null;

			try {
				session = openSession();

				documents = (Documents)session.get(DocumentsImpl.class,
						primaryKey);

				if (documents != null) {
					cacheResult(documents);
				}
				else {
					EntityCacheUtil.putResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsImpl.class, primaryKey, _nullDocuments);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DocumentsModelImpl.ENTITY_CACHE_ENABLED,
					DocumentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documents;
	}

	/**
	 * Returns the documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents, or <code>null</code> if a documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Documents fetchByPrimaryKey(long documentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns all the documentses.
	 *
	 * @return the documentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Documents> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of documentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Documents> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Documents> findAll(int start, int end,
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

		List<Documents> list = (List<Documents>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCUMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTS;

				if (pagination) {
					sql = sql.concat(DocumentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Documents>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Documents>(list);
				}
				else {
					list = (List<Documents>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the documentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Documents documents : findAll()) {
			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses.
	 *
	 * @return the number of documentses
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

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTS);

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
	 * Initializes the documents persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Documents")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Documents>> listenersList = new ArrayList<ModelListener<Documents>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Documents>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocumentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOCUMENTS = "SELECT documents FROM Documents documents";
	private static final String _SQL_COUNT_DOCUMENTS = "SELECT COUNT(documents) FROM Documents documents";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documents.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Documents exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocumentsPersistenceImpl.class);
	private static Documents _nullDocuments = new DocumentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Documents> toCacheModel() {
				return _nullDocumentsCacheModel;
			}
		};

	private static CacheModel<Documents> _nullDocumentsCacheModel = new CacheModel<Documents>() {
			@Override
			public Documents toEntityModel() {
				return _nullDocuments;
			}
		};
}