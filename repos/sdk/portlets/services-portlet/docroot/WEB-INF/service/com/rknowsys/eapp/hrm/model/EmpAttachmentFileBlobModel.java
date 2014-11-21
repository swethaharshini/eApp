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
 * The Blob model class for lazy loading the file column in EmpAttachment.
 *
 * @author rknowsys
 * @see EmpAttachment
 * @generated
 */
public class EmpAttachmentFileBlobModel {
	public EmpAttachmentFileBlobModel() {
	}

	public EmpAttachmentFileBlobModel(long empAttachmentId) {
		_empAttachmentId = empAttachmentId;
	}

	public EmpAttachmentFileBlobModel(long empAttachmentId, Blob fileBlob) {
		_empAttachmentId = empAttachmentId;
		_fileBlob = fileBlob;
	}

	public long getEmpAttachmentId() {
		return _empAttachmentId;
	}

	public void setEmpAttachmentId(long empAttachmentId) {
		_empAttachmentId = empAttachmentId;
	}

	public Blob getFileBlob() {
		return _fileBlob;
	}

	public void setFileBlob(Blob fileBlob) {
		_fileBlob = fileBlob;
	}

	private long _empAttachmentId;
	private Blob _fileBlob;
}