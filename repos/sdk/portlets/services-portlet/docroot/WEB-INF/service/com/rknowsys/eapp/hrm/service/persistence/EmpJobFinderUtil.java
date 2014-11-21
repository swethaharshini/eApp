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
public class EmpJobFinderUtil {
	public static com.rknowsys.eapp.hrm.model.EmpJob getEmpJobByEmployeeId(
		long empid) {
		return getFinder().getEmpJobByEmployeeId(empid);
	}

	public static java.util.List<com.rknowsys.eapp.hrm.model.EmpJob> getEmpJobListByShiftId(
		long shiftId) {
		return getFinder().getEmpJobListByShiftId(shiftId);
	}

	public static EmpJobFinder getFinder() {
		if (_finder == null) {
			_finder = (EmpJobFinder)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmpJobFinder.class.getName());

			ReferenceRegistry.registerReference(EmpJobFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EmpJobFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EmpJobFinderUtil.class, "_finder");
	}

	private static EmpJobFinder _finder;
}