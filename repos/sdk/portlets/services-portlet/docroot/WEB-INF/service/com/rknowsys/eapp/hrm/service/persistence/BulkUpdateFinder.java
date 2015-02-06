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

/**
 * @author rknowsys
 */
public interface BulkUpdateFinder {
	public java.util.List<com.rknowsys.eapp.hrm.model.BulkUpdate> findBulkUpdate(
		java.lang.String empname, java.lang.String empstatus,
		java.lang.String supervisorname, java.lang.String jobtitle,
		java.lang.String subunit, java.lang.String location,
		java.lang.String workshift, java.lang.String include, int begin, int end);
}