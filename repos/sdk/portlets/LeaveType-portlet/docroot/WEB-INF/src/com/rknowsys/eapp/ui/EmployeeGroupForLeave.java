package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.IdNamePair;

public class EmployeeGroupForLeave {

	private String groupName;
	
	private String daysAccrued;
	
	private String maxAccrueEntitlements;
	
	private List<IdNamePair> jobTitlesApplicability;
	
	private List<IdNamePair> empStatusesApplicability;
	
	private String ifServiceYearsCriterionApplicable;
	
	private String minServiceYearsApplicable;
	
	private String maxServiceYearsApplicable;
}
