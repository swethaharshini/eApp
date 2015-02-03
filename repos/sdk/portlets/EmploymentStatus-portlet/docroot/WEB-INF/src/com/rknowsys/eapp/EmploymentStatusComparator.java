package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;

public class EmploymentStatusComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(EmploymentStatusComparator.class);
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";

	public static String ORDER_BY_DESC = "status DESC";

	public EmploymentStatusComparator() {
		this(false);
	}

	public EmploymentStatusComparator(boolean asc) {
		log.info("EmploymentStatusComparator");
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		EmploymentStatus instance1 = (EmploymentStatus) obj1;
		EmploymentStatus instance2 = (EmploymentStatus) obj2;

		int value = instance1.getEmploymentstatus().toLowerCase()
				.compareTo(instance2.getEmploymentstatus().toLowerCase());

		if (_asc) {
			return value;
		} else {
			return -value;
		}

	}

	public String getOrderBy() {

		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}

	private boolean _asc;

}
