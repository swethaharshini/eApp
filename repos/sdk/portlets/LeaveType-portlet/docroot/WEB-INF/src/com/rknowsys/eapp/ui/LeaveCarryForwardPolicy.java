package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.ApplicationConstants;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class LeaveCarryForwardPolicy {

	private String leaveCarryForwardPolicyId;
	
	private String expiryDuration;
	
	private String expiryDurationUOM;
	
	private List<IdNamePair> expiryDurationUOMs=ApplicationConstants.durationUOMs;
	
	private String isMaxCarryForwardLimitApplicable;
	
	private String maxCarryForwardLimit;

	public String getExpiryDuration() {
		return expiryDuration;
	}

	public void setExpiryDuration(String expiryDuration) {
		this.expiryDuration = expiryDuration;
	}

	public String getExpiryDurationUOM() {
		return expiryDurationUOM;
	}

	public void setExpiryDurationUOM(String expiryDurationUOM) {
		this.expiryDurationUOM = expiryDurationUOM;
	}

	public List<IdNamePair> getExpiryDurationUOMs() {
		return expiryDurationUOMs;
	}

	public void setExpiryDurationUOMs(List<IdNamePair> expiryDurationUOMs) {
		this.expiryDurationUOMs = expiryDurationUOMs;
	}

	public String getIsMaxCarryForwardLimitApplicable() {
		return isMaxCarryForwardLimitApplicable;
	}

	public void setIsMaxCarryForwardLimitApplicable(
			String isMaxCarryForwardLimitApplicable) {
		this.isMaxCarryForwardLimitApplicable = isMaxCarryForwardLimitApplicable;
	}

	public String getMaxCarryForwardLimit() {
		return maxCarryForwardLimit;
	}

	public void setMaxCarryForwardLimit(String maxCarryForwardLimit) {
		this.maxCarryForwardLimit = maxCarryForwardLimit;
	}


	public String getLeaveCarryForwardPolicyId() {
		return leaveCarryForwardPolicyId;
	}

	public void setLeaveCarryForwardPolicyId(String leaveCarryForwardPolicyId) {
		this.leaveCarryForwardPolicyId = leaveCarryForwardPolicyId;
	}
	
	@Override
	public String toString() {
		return "LeaveCarryForwardPolicy [leaveCarryForwardPolicyId="
				+ leaveCarryForwardPolicyId + ", expiryDuration="
				+ expiryDuration + ", expiryDurationUOM=" + expiryDurationUOM
				+ ", expiryDurationUOMs=" + expiryDurationUOMs
				+ ", isMaxCarryForwardLimitApplicable="
				+ isMaxCarryForwardLimitApplicable + ", maxCarryForwardLimit="
				+ maxCarryForwardLimit + "]";
	}
	
	
}
