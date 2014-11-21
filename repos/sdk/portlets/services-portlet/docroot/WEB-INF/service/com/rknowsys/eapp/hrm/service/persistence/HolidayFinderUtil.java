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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author rknowsys
 */
public class HolidayFinderUtil {
	public static java.util.List<com.rknowsys.eapp.hrm.model.Holiday> getSearchHolidays(
		java.util.Date fromDate, java.util.Date toDate, long nationalityId,
		java.util.List<java.lang.Long> locationIds) {
		return getFinder()
				   .getSearchHolidays(fromDate, toDate, nationalityId,
			locationIds);
	}

	public static HolidayFinder getFinder() {
		if (_finder == null) {
			_finder = (HolidayFinder)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					HolidayFinder.class.getName());

			ReferenceRegistry.registerReference(HolidayFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HolidayFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HolidayFinderUtil.class, "_finder");
	}

	private static HolidayFinder _finder;
}