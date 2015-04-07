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

package com.rknowsys.eapp.hrm.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.rknowsys.eapp.hrm.model.Documents;
import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.service.base.DocumentsLocalServiceBaseImpl;
import com.rknowsys.eapp.hrm.service.persistence.DocumentsFinderUtil;
import com.rknowsys.eapp.hrm.service.persistence.EmpDetailsFinderUtil;

/**
 * The implementation of the documents local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rknowsys.eapp.hrm.service.DocumentsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.DocumentsLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.DocumentsLocalServiceUtil
 */
public class DocumentsLocalServiceImpl extends DocumentsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rknowsys.eapp.hrm.service.DocumentsLocalServiceUtil} to access the documents local service.
	 */
	
	 public List<Documents> findDocumentsDetails(String topic,String Category,String status,int begin, int end)
	            throws SystemException {
	              System.out.println("in documentdetailslocalserviceimpl.....");

	                return DocumentsFinderUtil.findDocumentDetails(topic, Category, status, begin, end);
	        }
	
	
}