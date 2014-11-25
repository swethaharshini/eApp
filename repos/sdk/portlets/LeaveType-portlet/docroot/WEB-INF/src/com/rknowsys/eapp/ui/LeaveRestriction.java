package com.rknowsys.eapp.ui;

public class LeaveRestriction {

	private String leaveRestrictionId;
	
	private String cannotExceedBalance;
 
	private String cannotApplyForPartialDay;

	private String ifATermsQuestion;
	
	private String termsQuestion;
	
	private String errorTextIfTermsDeclined;
	
	private String isMinimumServicePeriodApplicable;
	
	private String minimumServicePeriod;
	
	private String isMaxConsecutiveLeavesApplicable;
	
	private String maxConsecutiveLeaves;
	
	private String isSmallChildCriterionApplicable;
	
	private String maxSmallChildAgeApplicable;

	public String getCannotExceedBalance() {
		return cannotExceedBalance;
	}

	public void setCannotExceedBalance(String cannotExceedBalance) {
		this.cannotExceedBalance = cannotExceedBalance;
	}

	public String getCannotApplyForPartialDay() {
		return cannotApplyForPartialDay;
	}

	public void setCannotApplyForPartialDay(String cannotApplyForPartialDay) {
		this.cannotApplyForPartialDay = cannotApplyForPartialDay;
	}

	public String getTermsQuestion() {
		return termsQuestion;
	}

	public void setTermsQuestion(String termsQuestion) {
		this.termsQuestion = termsQuestion;
	}

	public String getErrorTextIfTermsDeclined() {
		return errorTextIfTermsDeclined;
	}

	public void setErrorTextIfTermsDeclined(String errorTextIfTermsDeclined) {
		this.errorTextIfTermsDeclined = errorTextIfTermsDeclined;
	}

	public String getIfATermsQuestion() {
		return ifATermsQuestion;
	}

	public void setIfATermsQuestion(String ifATermsQuestion) {
		this.ifATermsQuestion = ifATermsQuestion;
	}

	public String getIsMinimumServicePeriodApplicable() {
		return isMinimumServicePeriodApplicable;
	}

	public void setIsMinimumServicePeriodApplicable(
			String isMinimumServicePeriodApplicable) {
		this.isMinimumServicePeriodApplicable = isMinimumServicePeriodApplicable;
	}

	public String getMinimumServicePeriod() {
		return minimumServicePeriod;
	}

	public void setMinimumServicePeriod(String minimumServicePeriod) {
		this.minimumServicePeriod = minimumServicePeriod;
	}

	public String getIsMaxConsecutiveLeavesApplicable() {
		return isMaxConsecutiveLeavesApplicable;
	}

	public void setIsMaxConsecutiveLeavesApplicable(
			String isMaxConsecutiveLeavesApplicable) {
		this.isMaxConsecutiveLeavesApplicable = isMaxConsecutiveLeavesApplicable;
	}

	public String getMaxConsecutiveLeaves() {
		return maxConsecutiveLeaves;
	}

	public void setMaxConsecutiveLeaves(String maxConsecutiveLeaves) {
		this.maxConsecutiveLeaves = maxConsecutiveLeaves;
	}

	public String getIsSmallChildCriterionApplicable() {
		return isSmallChildCriterionApplicable;
	}

	public void setIsSmallChildCriterionApplicable(
			String isSmallChildCriterionApplicable) {
		this.isSmallChildCriterionApplicable = isSmallChildCriterionApplicable;
	}

	public String getMaxSmallChildAgeApplicable() {
		return maxSmallChildAgeApplicable;
	}

	public void setMaxSmallChildAgeApplicable(String maxSmallChildAgeApplicable) {
		this.maxSmallChildAgeApplicable = maxSmallChildAgeApplicable;
	}

	@Override
	public String toString() {
		return "LeaveRestrictions [leaveRestrictionId=" + leaveRestrictionId
				+ ", cannotExceedBalance=" + cannotExceedBalance
				+ ", cannotApplyForPartialDay=" + cannotApplyForPartialDay
				+ ", ifATermsQuestion=" + ifATermsQuestion + ", termsQuestion="
				+ termsQuestion + ", errorTextIfTermsDeclined="
				+ errorTextIfTermsDeclined
				+ ", isMinimumServicePeriodApplicable="
				+ isMinimumServicePeriodApplicable + ", minimumServicePeriod="
				+ minimumServicePeriod + ", isMaxConsecutiveLeavesApplicable="
				+ isMaxConsecutiveLeavesApplicable + ", maxConsecutiveLeaves="
				+ maxConsecutiveLeaves + ", isSmallChildCriterionApplicable="
				+ isSmallChildCriterionApplicable
				+ ", maxSmallChildAgeApplicable=" + maxSmallChildAgeApplicable
				+ "]";
	}

	public String getLeaveRestrictionId() {
		return leaveRestrictionId;
	}

	public void setLeaveRestrictionId(String leaveRestrictionId) {
		this.leaveRestrictionId = leaveRestrictionId;
	}
	
	
}
