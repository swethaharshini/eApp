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

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentCategoriesLocalService}.
 *
 * @author rknowsys
 * @see DocumentCategoriesLocalService
 * @generated
 */
public class DocumentCategoriesLocalServiceWrapper
	implements DocumentCategoriesLocalService,
		ServiceWrapper<DocumentCategoriesLocalService> {
	public DocumentCategoriesLocalServiceWrapper(
		DocumentCategoriesLocalService documentCategoriesLocalService) {
		_documentCategoriesLocalService = documentCategoriesLocalService;
	}

	/**
	* Adds the document categories to the database. Also notifies the appropriate model listeners.
	*
	* @param documentCategories the document categories
	* @return the document categories that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories addDocumentCategories(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.addDocumentCategories(documentCategories);
	}

	/**
	* Creates a new document categories with the primary key. Does not add the document categories to the database.
	*
	* @param documentcategoryId the primary key for the new document categories
	* @return the new document categories
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories createDocumentCategories(
		long documentcategoryId) {
		return _documentCategoriesLocalService.createDocumentCategories(documentcategoryId);
	}

	/**
	* Deletes the document categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentcategoryId the primary key of the document categories
	* @return the document categories that was removed
	* @throws PortalException if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories deleteDocumentCategories(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.deleteDocumentCategories(documentcategoryId);
	}

	/**
	* Deletes the document categories from the database. Also notifies the appropriate model listeners.
	*
	* @param documentCategories the document categories
	* @return the document categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories deleteDocumentCategories(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.deleteDocumentCategories(documentCategories);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentCategoriesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories fetchDocumentCategories(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.fetchDocumentCategories(documentcategoryId);
	}

	/**
	* Returns the document categories with the primary key.
	*
	* @param documentcategoryId the primary key of the document categories
	* @return the document categories
	* @throws PortalException if a document categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories getDocumentCategories(
		long documentcategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.getDocumentCategories(documentcategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the document categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document categorieses
	* @param end the upper bound of the range of document categorieses (not inclusive)
	* @return the range of document categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentCategories> getDocumentCategorieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.getDocumentCategorieses(start,
			end);
	}

	/**
	* Returns the number of document categorieses.
	*
	* @return the number of document categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDocumentCategoriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.getDocumentCategoriesesCount();
	}

	/**
	* Updates the document categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentCategories the document categories
	* @return the document categories that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentCategories updateDocumentCategories(
		com.rknowsys.eapp.hrm.model.DocumentCategories documentCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentCategoriesLocalService.updateDocumentCategories(documentCategories);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _documentCategoriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_documentCategoriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _documentCategoriesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DocumentCategoriesLocalService getWrappedDocumentCategoriesLocalService() {
		return _documentCategoriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDocumentCategoriesLocalService(
		DocumentCategoriesLocalService documentCategoriesLocalService) {
		_documentCategoriesLocalService = documentCategoriesLocalService;
	}

	@Override
	public DocumentCategoriesLocalService getWrappedService() {
		return _documentCategoriesLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentCategoriesLocalService documentCategoriesLocalService) {
		_documentCategoriesLocalService = documentCategoriesLocalService;
	}

	private DocumentCategoriesLocalService _documentCategoriesLocalService;
}