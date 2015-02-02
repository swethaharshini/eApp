package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);

	public static OrderByComparator getLanguagesOrderByComparator(
			String orderByCol, String orderByType) {

		log.info("getLanguagesOrderByComparator method in CustomComparatorUtil");
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("languageName")) {

			orderByComparator = new languageNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
