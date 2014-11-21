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
public class EmpDetailsFinderUtil {
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpDetails> findEmpDetails(
		java.lang.String empname, java.lang.String empid,
		java.lang.String empstatus, java.lang.String supervisorname,
		java.lang.String jobtitle, java.lang.String subunit, int begin, int end) {
		return getFinder()
				   .findEmpDetails(empname, empid, empstatus, supervisorname,
			jobtitle, subunit, begin, end);
	}

	public static EmpDetailsFinder getFinder() {
		if (_finder == null) {
			_finder = (EmpDetailsFinder)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpDetailsFinder.class.getName());

			ReferenceRegistry.registerReference(EmpDetailsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EmpDetailsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EmpDetailsFinderUtil.class,
			"_finder");
	}

	private static EmpDetailsFinder _finder;
}