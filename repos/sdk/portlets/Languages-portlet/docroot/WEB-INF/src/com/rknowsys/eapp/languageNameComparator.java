package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Language;

public class languageNameComparator extends OrderByComparator {
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";

	public static String ORDER_BY_DESC = "status DESC";

	public languageNameComparator() {
		this(false);
	}

	public languageNameComparator(boolean asc) {
		log.info("languageNameComparator");
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		Language instance1 = (Language) obj1;
		Language instance2 = (Language) obj2;

		int value = instance1.getLanguageName().toLowerCase()
				.compareTo(instance2.getLanguageName().toLowerCase());

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
