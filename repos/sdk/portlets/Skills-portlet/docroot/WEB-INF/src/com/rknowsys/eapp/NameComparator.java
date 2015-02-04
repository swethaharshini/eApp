package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Skill;

public class NameComparator extends OrderByComparator {
	private static Logger log = Logger.getLogger(NameComparator.class);
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";

	public static String ORDER_BY_DESC = "status DESC";

	public NameComparator() {
		this(false);
	}

	public NameComparator(boolean asc) {
		log.info("NameComparator");
		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		Skill instance1 = (Skill) obj1;
		Skill instance2 = (Skill) obj2;

		int value = instance1.getSkillName().toLowerCase()
				.compareTo(instance2.getSkillName().toLowerCase());

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
