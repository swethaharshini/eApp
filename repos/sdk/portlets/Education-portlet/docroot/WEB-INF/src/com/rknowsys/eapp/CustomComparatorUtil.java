package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);

	public static OrderByComparator getEducationOrderByComparator(
			String orderByCol, String orderByType) {

		log.info("getEducationOrderByComparator method in CustomComparatorUtil");
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("eduLevel")) {
			log.info("Sorting on EducationName based");

			orderByComparator = new EduLevelComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
