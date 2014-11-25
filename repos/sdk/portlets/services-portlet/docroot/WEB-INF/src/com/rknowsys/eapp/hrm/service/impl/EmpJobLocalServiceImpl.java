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
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.service.base.EmpJobLocalServiceBaseImpl;
import com.rknowsys.eapp.hrm.service.persistence.EmpJobFinderUtil;

/**
 * The implementation of the emp job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rknowsys.eapp.hrm.service.EmpJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.EmpJobLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil
 */
public class EmpJobLocalServiceImpl extends EmpJobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil} to access the emp job local service.
	 */
	/** 
	 * Returns EmpJob based on the give EmployeeId.
	 * @param EmployeeId
	 * @return the emp job
	 * @throws SystemException if a system exception occurred
	 * @author Laxminarayana 27 october 2014 7:39:55 PM
	 */
	public EmpJob getEmpJobByEmpId(long empid){
		return EmpJobFinderUtil.getEmpJobByEmployeeId(empid);
	}
	/** 
	 * Returns EmpJob list based on the give shiftId.
	 * @param shiftId
	 * @return the empjob list
	 * @throws SystemException if a system exception occurred
	 * @author Laxminarayana 29 october 2014 6:38:55 PM
	 */
	public List<EmpJob> findEmpJobListByShiftId(long shiftId){
		return EmpJobFinderUtil.getEmpJobListByShiftId(shiftId);
	}
}