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
public class NewsFinderUtil {
	public static java.util.List<com.rknowsys.eapp.hrm.model.News> findNewsDetails(
		java.lang.String topic, java.lang.String status, long groupId,
		int begin, int end) {
		return getFinder().findNewsDetails(topic, status, groupId, begin, end);
	}

	public static NewsFinder getFinder() {
		if (_finder == null) {
			_finder = (NewsFinder)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					NewsFinder.class.getName());

			ReferenceRegistry.registerReference(NewsFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(NewsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(NewsFinderUtil.class, "_finder");
	}

	private static NewsFinder _finder;
}