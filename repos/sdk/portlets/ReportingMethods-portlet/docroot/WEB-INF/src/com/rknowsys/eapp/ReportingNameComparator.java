package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.ReportingMethods;

/**
 * 
 * @author Laxminarayana 10th october 2014 6:58:02 PM
 * 
 */
public class ReportingNameComparator extends OrderByComparator {
	private static Logger log = Logger.getLogger(ReportingNameComparator.class);
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";

	public static String ORDER_BY_DESC = "status DESC";

	public ReportingNameComparator() {
		this(false);
	}

	public ReportingNameComparator(boolean asc) {
		log.info("ReportingNameComparator");
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		ReportingMethods instance1 = (ReportingMethods) obj1;
		ReportingMethods instance2 = (ReportingMethods) obj2;

		int value = instance1.getReportingmethodName().toLowerCase()
				.compareTo(instance2.getReportingmethodName().toLowerCase());

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
