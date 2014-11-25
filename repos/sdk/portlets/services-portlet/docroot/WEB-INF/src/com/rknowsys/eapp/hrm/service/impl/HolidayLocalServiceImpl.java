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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.rknowsys.eapp.hrm.model.Holiday;
import com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.base.HolidayLocalServiceBaseImpl;

/**
 * The implementation of the Holiday local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rknowsys.eapp.hrm.service.HolidayLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.HolidayLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil
 */
public class HolidayLocalServiceImpl extends HolidayLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil} to access the
	 * Holiday local service.
	 */
	public List<Holiday> getSearchHolidays(Date fromDate, Date toDate,
			long nationalityId, List<Long> locationIds) {
		System.out.println("in get serach holidays");
		System.out.println(locationIds);
		List<Holiday> allSearchResults = holidayFinder.getSearchHolidays(
				fromDate, toDate, nationalityId, locationIds);
		
		if (locationIds==null || locationIds.size()==0) {
			System.out.println("no loc ids selected");
			return allSearchResults;
		}
		List<Holiday> locationResults = new ArrayList<Holiday>();
		for (Long locationId : locationIds) {
			try {
				
				locationResults.addAll(HolidayLocalServiceUtil
						.getLocationHolidaies(locationId));
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
			System.out.println("locationResults = " + locationResults);
		}
		System.out.println("locationResults = "+locationResults );
		List<Holiday> filteredResults = new ArrayList<Holiday>();
		for (Holiday result : allSearchResults) {
			for (Holiday lResult : locationResults) {
				if (result.getHolidayId() == lResult.getHolidayId()) {
					filteredResults.add(result);
					System.out.println("added holiday: "+result);
					break;
				}
			}
		}
		return filteredResults;
	}
	
}