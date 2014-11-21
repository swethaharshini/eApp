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

package com.rknowsys.eapp.hrm.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the contractDetails column in EmpJob.
 *
 * @author rknowsys
 * @see EmpJob
 * @generated
 */
public class EmpJobContractDetailsBlobModel {
	public EmpJobContractDetailsBlobModel() {
	}

	public EmpJobContractDetailsBlobModel(long empJobId) {
		_empJobId = empJobId;
	}

	public EmpJobContractDetailsBlobModel(long empJobId,
		Blob contractDetailsBlob) {
		_empJobId = empJobId;
		_contractDetailsBlob = contractDetailsBlob;
	}

	public long getEmpJobId() {
		return _empJobId;
	}

	public void setEmpJobId(long empJobId) {
		_empJobId = empJobId;
	}

	public Blob getContractDetailsBlob() {
		return _contractDetailsBlob;
	}

	public void setContractDetailsBlob(Blob contractDetailsBlob) {
		_contractDetailsBlob = contractDetailsBlob;
	}

	private long _empJobId;
	private Blob _contractDetailsBlob;
}