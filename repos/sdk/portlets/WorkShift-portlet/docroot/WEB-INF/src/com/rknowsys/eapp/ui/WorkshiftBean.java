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

package com.rknowsys.eapp.ui;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.Workshift;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;

/**
 * The extended model implementation for the Workshift service. Represents a row in the &quot;work_shift&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic are added in this class.
 * </p>
 *
 * @author rknowsys
 */
public class WorkshiftBean{
	
	private Workshift workshift;
	
	public Workshift getWorkshift() {
		return workshift;
	}

	public WorkshiftBean(Workshift workshift) {
	    this.workshift = workshift;
	}
	
	public Date getDuration(){
		 
		return new Date(workshift.getToWorkHours().getTime() - workshift.getFromWorkHours().getTime());
	}
	
	public String getFormattedDurationStr(){
		
		 
		 return formatDate(getDuration(),"H:mm");
		
	}
	
	public String getFormattedFromWorkHoursStr(){
		return formatDate(workshift.getFromWorkHours(), "H:mm");
	}

	public String getFormattedToWorkHoursStr(){
		return formatDate(workshift.getToWorkHours(), "H:mm");
	}
	
	private static String formatDate(Date date, String formatMask){
		DateFormat df = new SimpleDateFormat(formatMask);
		StringBuffer buf = new StringBuffer();
		return df.format(date, buf, new FieldPosition(0)).toString();
	}

}