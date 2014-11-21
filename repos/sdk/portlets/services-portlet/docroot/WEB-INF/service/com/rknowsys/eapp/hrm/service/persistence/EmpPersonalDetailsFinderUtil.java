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
public class EmpPersonalDetailsFinderUtil {
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpPersonalDetails> getEmployeesByShiftId(
		long shiftId) {
		return getFinder().getEmployeesByShiftId(shiftId);
	}

	public static EmpPersonalDetailsFinder getFinder() {
		if (_finder == null) {
			_finder = (EmpPersonalDetailsFinder)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpPersonalDetailsFinder.class.getName());

			ReferenceRegistry.registerReference(EmpPersonalDetailsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EmpPersonalDetailsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EmpPersonalDetailsFinderUtil.class,
			"_finder");
	}

	private static EmpPersonalDetailsFinder _finder;
}