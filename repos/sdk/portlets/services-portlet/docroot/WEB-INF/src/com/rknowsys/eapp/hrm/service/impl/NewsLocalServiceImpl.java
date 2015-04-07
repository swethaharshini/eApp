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
import com.rknowsys.eapp.hrm.model.News;
import com.rknowsys.eapp.hrm.service.base.NewsLocalServiceBaseImpl;
import com.rknowsys.eapp.hrm.service.persistence.NewsFinderUtil;

/**
 * The implementation of the news local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rknowsys.eapp.hrm.service.NewsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.NewsLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil
 */
public class NewsLocalServiceImpl extends NewsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil} to access the news local service.
	 */
	 public List<News> findNewsDetails(String topic,String status,long groupId,int begin, int end)
	            throws SystemException {
	            
	                return NewsFinderUtil.findNewsDetails(topic, status, groupId, begin, end);
	        }
}