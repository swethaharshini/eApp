package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.IdNamePair;

public class LeaveType {

	private String leaveTypeId;
	
	private String leaveTypeName;
	
	private String isSituational;
	
	private String nationalityId;
	
	private String countryName;
	
	private List<IdNamePair> orgCountries;

	public String getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getIsSituational() {
		return isSituational;
	}

	public void setIsSituational(String isSituational) {
		this.isSituational = isSituational;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<IdNamePair> getOrgCountries() {
		return orgCountries;
	}

	public void setOrgCountries(List<IdNamePair> orgCountries) {
		this.orgCountries = orgCountries;
	}

	@Override
	public String toString() {
		return "LeaveType [leaveTypeId=" + leaveTypeId + ", leaveTypeName="
				+ leaveTypeName + ", isSituational=" + isSituational
				+ ", nationalityId=" + nationalityId + ", countryName="
				+ countryName + ", orgCountries=" + orgCountries + "]";
	}
	
}
 