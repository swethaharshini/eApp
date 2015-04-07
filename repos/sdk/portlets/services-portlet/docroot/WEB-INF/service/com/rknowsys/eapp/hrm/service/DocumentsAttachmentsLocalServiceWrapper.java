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
 * Provides a wrapper for {@link DocumentsAttachmentsLocalService}.
 *
 * @author rknowsys
 * @see DocumentsAttachmentsLocalService
 * @generated
 */
public class DocumentsAttachmentsLocalServiceWrapper
	implements DocumentsAttachmentsLocalService,
		ServiceWrapper<DocumentsAttachmentsLocalService> {
	public DocumentsAttachmentsLocalServiceWrapper(
		DocumentsAttachmentsLocalService documentsAttachmentsLocalService) {
		_documentsAttachmentsLocalService = documentsAttachmentsLocalService;
	}

	/**
	* Adds the documents attachments to the database. Also notifies the appropriate model listeners.
	*
	* @param documentsAttachments the documents attachments
	* @return the documents attachments that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments addDocumentsAttachments(
		com.rknowsys.eapp.hrm.model.DocumentsAttachments documentsAttachments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.addDocumentsAttachments(documentsAttachments);
	}

	/**
	* Creates a new documents attachments with the primary key. Does not add the documents attachments to the database.
	*
	* @param documentAttachmentId the primary key for the new documents attachments
	* @return the new documents attachments
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments createDocumentsAttachments(
		long documentAttachmentId) {
		return _documentsAttachmentsLocalService.createDocumentsAttachments(documentAttachmentId);
	}

	/**
	* Deletes the documents attachments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentAttachmentId the primary key of the documents attachments
	* @return the documents attachments that was removed
	* @throws PortalException if a documents attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments deleteDocumentsAttachments(
		long documentAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.deleteDocumentsAttachments(documentAttachmentId);
	}

	/**
	* Deletes the documents attachments from the database. Also notifies the appropriate model listeners.
	*
	* @param documentsAttachments the documents attachments
	* @return the documents attachments that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments deleteDocumentsAttachments(
		com.rknowsys.eapp.hrm.model.DocumentsAttachments documentsAttachments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.deleteDocumentsAttachments(documentsAttachments);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentsAttachmentsLocalService.dynamicQuery();
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
		return _documentsAttachmentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _documentsAttachmentsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocumentsAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _documentsAttachmentsLocalService.dynamicQuery(dynamicQuery,
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
		return _documentsAttachmentsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _documentsAttachmentsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments fetchDocumentsAttachments(
		long documentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.fetchDocumentsAttachments(documentAttachmentId);
	}

	/**
	* Returns the documents attachments with the primary key.
	*
	* @param documentAttachmentId the primary key of the documents attachments
	* @return the documents attachments
	* @throws PortalException if a documents attachments with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments getDocumentsAttachments(
		long documentAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.getDocumentsAttachments(documentAttachmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rknowsys.eapp.hrm.model.DocumentsAttachments> getDocumentsAttachmentses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.getDocumentsAttachmentses(start,
			end);
	}

	/**
	* Returns the number of documents attachmentses.
	*
	* @return the number of documents attachmentses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDocumentsAttachmentsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.getDocumentsAttachmentsesCount();
	}

	/**
	* Updates the documents attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentsAttachments the documents attachments
	* @return the documents attachments that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.DocumentsAttachments updateDocumentsAttachments(
		com.rknowsys.eapp.hrm.model.DocumentsAttachments documentsAttachments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentsAttachmentsLocalService.updateDocumentsAttachments(documentsAttachments);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _documentsAttachmentsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_documentsAttachmentsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _documentsAttachmentsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DocumentsAttachmentsLocalService getWrappedDocumentsAttachmentsLocalService() {
		return _documentsAttachmentsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDocumentsAttachmentsLocalService(
		DocumentsAttachmentsLocalService documentsAttachmentsLocalService) {
		_documentsAttachmentsLocalService = documentsAttachmentsLocalService;
	}

	@Override
	public DocumentsAttachmentsLocalService getWrappedService() {
		return _documentsAttachmentsLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentsAttachmentsLocalService documentsAttachmentsLocalService) {
		_documentsAttachmentsLocalService = documentsAttachmentsLocalService;
	}

	private DocumentsAttachmentsLocalService _documentsAttachmentsLocalService;
}