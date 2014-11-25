package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.IdNamePair;

public class LeaveTypeApplicability {
	
	private String leaveTypeApplicabilityId;

	private List<IdNamePair> jobTitles;
	
	private List<IdNamePair> applicableToJobTitles;
	
	private List<IdNamePair> employmentStatuses;
	
	private List<IdNamePair> applicableToEmploymentStatuses;
	
	private String ifYearsOfServiceCriterionApplicable;
	
	private String minYearsOfService;
	
	private String maxYearsOfService;

	public List<IdNamePair> getJobTitles() {
		return jobTitles;
	}

	public void setJobTitles(List<IdNamePair> jobTitles) {
		this.jobTitles = jobTitles;
	}

	public List<IdNamePair> getEmploymentStatuses() {
		return employmentStatuses;
	}

	public void setEmploymentStatuses(List<IdNamePair> employmentStatuses) {
		this.employmentStatuses = employmentStatuses;
	}

	public List<IdNamePair> getApplicableToJobTitles() {
		return applicableToJobTitles;
	}

	public void setApplicableToJobTitles(List<IdNamePair> applicableToJobTitles) {
		this.applicableToJobTitles = applicableToJobTitles;
	}

	public List<IdNamePair> getApplicableToEmploymentStatuses() {
		return applicableToEmploymentStatuses;
	}

	public void setApplicableToEmploymentStatuses(List<IdNamePair> applicableToEmploymentStatuses) {
		this.applicableToEmploymentStatuses = applicableToEmploymentStatuses;
	}

	public String getIfYearsOfServiceCriterionApplicable() {
		return ifYearsOfServiceCriterionApplicable;
	}

	public void setIfYearsOfServiceCriterionApplicable(String ifYearsOfServiceCriterionApplicable) {
		this.ifYearsOfServiceCriterionApplicable = ifYearsOfServiceCriterionApplicable;
	}

	public String getMinYearsOfService() {
		return minYearsOfService;
	}

	public void setMinYearsOfService(String minYearsOfService) {
		this.minYearsOfService = minYearsOfService;
	}

	public String getMaxYearsOfService() {
		return maxYearsOfService;
	}

	public void setMaxYearsOfService(String maxYearsOfService) {
		this.maxYearsOfService = maxYearsOfService;
	}

	@Override
	public String toString() {
		return "LeaveTypeApplicability [leaveTypeApplicabilityId=" + leaveTypeApplicabilityId + ", jobTitles="
				+ jobTitles + ", applicableToJobTitles=" + applicableToJobTitles + ", employmentStatuses="
				+ employmentStatuses + ", applicableToEmploymentStatuses=" + applicableToEmploymentStatuses
				+ ", ifYearsOfServiceCriterionApplicable=" + ifYearsOfServiceCriterionApplicable
				+ ", minYearsOfService=" + minYearsOfService + ", maxYearsOfService=" + maxYearsOfService + "]";
	}

	public String getLeaveTypeApplicabilityId() {
		return leaveTypeApplicabilityId;
	}

	public void setLeaveTypeApplicabilityId(String leaveTypeApplicabilityId) {
		this.leaveTypeApplicabilityId = leaveTypeApplicabilityId;
	}

}
