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
import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.service.base.EmpDetailsLocalServiceBaseImpl;
import com.rknowsys.eapp.hrm.service.persistence.EmpDetailsFinderUtil;

/**
 * The implementation of the emp details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rknowsys.eapp.hrm.service.EmpDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.EmpDetailsLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil
 */
public class EmpDetailsLocalServiceImpl extends EmpDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil} to access the emp details local service.
	 */
	
	public List<EmpDetails> findEmpDetails(String empname,String empid,String empstatus,String supervisorname,String jobtitle,String subunit,int begin, int end)
			throws SystemException {
		      System.out.println("in empdetailslocalserviceimpl.....");

			    return EmpDetailsFinderUtil.findEmpDetails(empname,empid,empstatus,supervisorname,jobtitle,subunit,begin, end);
		}
}