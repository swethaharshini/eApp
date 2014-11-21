package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.ApplicationConstants;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class LeaveRule {

	private String leaveRuleId;
	
	private String ifEmployeesCanApply;
	
	private String ifAdminCanAssign;
	
	private String ifAdminCanManageEntitlements;
	
	private String ifLeaveAccruable;
	
	private String ifCarryForwardable;
	
	private List<IdNamePair> leavePeriodTypeOptions=ApplicationConstants.leavePeriodTypes;
	
	private String leavePeriodType;
	
	private List<IdNamePair> durationOptions=ApplicationConstants.leavePeriodDurationUOMs;
	
	private String duration;
	
	private List<IdNamePair> startMonthOptions=ApplicationConstants.months;
	
	private String startMonth;
	
	private String startDayOfMonth;

	public String getLeaveRuleId() {
		return leaveRuleId;
	}

	public void setLeaveRuleId(String leaveRuleId) {
		this.leaveRuleId = leaveRuleId;
	}

	public String getIfEmployeesCanApply() {
		return ifEmployeesCanApply;
	}

	public void setIfEmployeesCanApply(String ifEmployeesCanApply) {
		this.ifEmployeesCanApply = ifEmployeesCanApply;
	}

	public String getIfAdminCanAssign() {
		return ifAdminCanAssign;
	}

	public void setIfAdminCanAssign(String ifAdminCanAssign) {
		this.ifAdminCanAssign = ifAdminCanAssign;
	}

	public String getIfAdminCanManageEntitlements() {
		return ifAdminCanManageEntitlements;
	}

	public void setIfAdminCanManageEntitlements(String ifAdminCanManageEntitlements) {
		this.ifAdminCanManageEntitlements = ifAdminCanManageEntitlements;
	}

	public String getIfLeaveAccruable() {
		return ifLeaveAccruable;
	}

	public void setIfLeaveAccruable(String ifLeaveAccruable) {
		this.ifLeaveAccruable = ifLeaveAccruable;
	}

	public String getIfCarryForwardable() {
		return ifCarryForwardable;
	}

	public void setIfCarryForwardable(String ifCarryForwardable) {
		this.ifCarryForwardable = ifCarryForwardable;
	}

	public List<IdNamePair> getLeavePeriodTypeOptions() {
		return leavePeriodTypeOptions;
	}

	public void setLeavePeriodTypeOptions(List<IdNamePair> leavePeriodTypeOptions) {
		this.leavePeriodTypeOptions = leavePeriodTypeOptions;
	}

	public String getLeavePeriodType() {
		return leavePeriodType;
	}

	public void setLeavePeriodType(String leavePeriodType) {
		this.leavePeriodType = leavePeriodType;
	}

	public List<IdNamePair> getDurationOptions() {
		return durationOptions;
	}

	public void setDurationOptions(List<IdNamePair> durationOptions) {
		this.durationOptions = durationOptions;
	}

	public List<IdNamePair> getStartMonthOptions() {
		return startMonthOptions;
	}

	public void setStartMonthOptions(List<IdNamePair> startMonthOptions) {
		this.startMonthOptions = startMonthOptions;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartDayOfMonth() {
		return startDayOfMonth;
	}

	public void setStartDayOfMonth(String startDayOfMonth) {
		this.startDayOfMonth = startDayOfMonth;
	}

	@Override
	public String toString() {
		return "LeaveRule [leaveRuleId=" + leaveRuleId
				+ ", ifEmployeesCanApply=" + ifEmployeesCanApply
				+ ", ifAdminCanAssign=" + ifAdminCanAssign
				+ ", ifAdminCanManageEntitlements="
				+ ifAdminCanManageEntitlements + ", ifLeaveAccruable="
				+ ifLeaveAccruable + ", ifCarryForwardable="
				+ ifCarryForwardable + ", leavePeriodTypeOptions="
				+ leavePeriodTypeOptions + ", leavePeriodType="
				+ leavePeriodType + ", durationOptions=" + durationOptions
				+ ", duration=" + duration + ", startMonthOptions="
				+ startMonthOptions + ", startMonth=" + startMonth
				+ ", startDayOfMonth=" + startDayOfMonth + "]";
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
}
