package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.TerminationReasons;

/**
 * 
 * @author Laxminarayana 10th october 2014 7:00:02 PM
 * 
 */
public class TerminationReasonNameComparator extends OrderByComparator {
	private static Logger log = Logger
.getLogger(TerminationReasonNameComparator.class);
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";

	public static String ORDER_BY_DESC = "status DESC";

	public TerminationReasonNameComparator() {
		this(false);
	}

	public TerminationReasonNameComparator(boolean asc) {
		log.info("TerminationReasonNameComparator");
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		TerminationReasons instance1 = (TerminationReasons) obj1;
		TerminationReasons instance2 = (TerminationReasons) obj2;

		int value = instance1.getTerminationreasonsName().toLowerCase()
				.compareTo(instance2.getTerminationreasonsName().toLowerCase());

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
