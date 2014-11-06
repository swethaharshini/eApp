package com.rknowsys.eapp.hrm.util;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConstants {

	public static final List<IdNamePair> months=new ArrayList<IdNamePair>();
	static {
		months.add(new IdNamePair("0","January"));
		months.add(new IdNamePair("1","February"));
		months.add(new IdNamePair("2","March"));
		months.add(new IdNamePair("3","April"));
		months.add(new IdNamePair("4","May"));
		months.add(new IdNamePair("5","June"));
		months.add(new IdNamePair("6","July"));
		months.add(new IdNamePair("7", "August"));
		months.add(new IdNamePair("8","September"));
		months.add(new IdNamePair("9","October"));
		months.add(new IdNamePair("10","November"));
		months.add(new IdNamePair("11","December"));
	}

	public static final List<IdNamePair> workSchedules=new ArrayList<IdNamePair>();
	static {
		workSchedules.add(new IdNamePair("0","Full Day"));
		workSchedules.add(new IdNamePair("1","Half Day"));
		workSchedules.add(new IdNamePair("2","Non-working Day"));
	}

	public static final List<IdNamePair> durationUOMs=new ArrayList<IdNamePair>();
	static {
		durationUOMs.add(new IdNamePair("0","Days"));
		durationUOMs.add(new IdNamePair("1","Weeks"));
		durationUOMs.add(new IdNamePair("2","Months"));
	}

	public static final List<IdNamePair> leavePeriodDurationUOMs=new ArrayList<IdNamePair>();
	static {
		leavePeriodDurationUOMs.add(new IdNamePair("1","1 Year"));
		leavePeriodDurationUOMs.add(new IdNamePair("2","2 Year"));
		leavePeriodDurationUOMs.add(new IdNamePair("3","3 Year"));
		leavePeriodDurationUOMs.add(new IdNamePair("4","4 Year"));
		leavePeriodDurationUOMs.add(new IdNamePair("5","5 Year"));
	}

	public static final List<IdNamePair> leavePeriodTypes=new ArrayList<IdNamePair>();
	static {
		leavePeriodTypes.add(new IdNamePair("0","Default"));
		leavePeriodTypes.add(new IdNamePair("1","Hire Date Base Leave Period"));
		leavePeriodTypes.add(new IdNamePair("2","Custom Leave Period"));
	}

}
