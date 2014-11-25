package com.rknowsys.eapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.rknowsys.eapp.hrm.util.IdNamePair;

public class Holiday {

	private String holidayId;
	
	private String holidayName;
	
	private String holidayDate;
	
	private String searchFromDate;
	
	private String searchToDate;

	private String isAnnual;
	
	private String isFullDay;

	private List<IdNamePair> orgCountries;
	
	private String nationalityId;
	
	private String nationalityName;
	
	private List<IdNamePair> orgLocations;
	
	private List<IdNamePair> checkedLocations;
	
	private String[] checkedLocationsAsStringArray;
	
	public String[] getCheckedLocationsAsStringArray() {
		return checkedLocationsAsStringArray;
	}

	public void setCheckedLocationsAsStringArray(String[] checkedLocationsAsStringArray) {
		this.checkedLocationsAsStringArray = checkedLocationsAsStringArray;
	}

	private String locationsDivContent;
	
	public String getLocationsDivContent() {
		return locationsDivContent;
	}

	public void setLocationsDivContent(String locationsDivContent) {
		this.locationsDivContent = locationsDivContent;
	}

	public List<IdNamePair> getCheckedLocations() {
		return checkedLocations;
	}

	public void setCheckedLocations(List<IdNamePair> checkedLocations) {
		this.checkedLocations = checkedLocations;
	}
   
	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	
	public String getSearchFromDate() {
		return searchFromDate;
	}

	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}

	public String getSearchToDate() {
		return searchToDate;
	}

	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}

	public String getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(String holidayId) {
		this.holidayId = holidayId;
	}

	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	public List<IdNamePair> getOrgCountries() {
		return orgCountries;
	}

	public void setOrgCountries(List<IdNamePair> orgCountries) {
		this.orgCountries = orgCountries;
	}

	public List<IdNamePair> getOrgLocations() {
		return orgLocations;
	}

	public void setOrgLocations(List<IdNamePair> orgLocations) {
		this.orgLocations = orgLocations;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", holidayName=" + holidayName + ", holidayDate=" + holidayDate
				+ ", searchFromDate=" + searchFromDate + ", searchToDate=" + searchToDate + ", isAnnual=" + isAnnual
				+ ", isFullDay=" + isFullDay + ", orgCountries=" + orgCountries + ", nationalityId=" + nationalityId
				+ ", nationalityName=" + nationalityName + ", orgLocations=" + orgLocations + "]";
	}

	public String getIsAnnual() {
		if (isAnnual == "true") {
			return "Yes";
		}else
		{
			return "No";
		}
	}

	public void setIsAnnual(String isAnnual) {
		this.isAnnual = isAnnual;
	}

	public String getIsFullDay() {
		if (isFullDay == "true"){
			return "Full Day";
		}else
		{
			return "Half Day";
		}
	}

	public void setIsFullDay(String isFullDay) {
		this.isFullDay = isFullDay;
	}

	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	
	public String getCheckedLocationsAsJSArray(){
	    StringBuffer sb = new StringBuffer();
    	sb.append("[");
	    if (checkedLocationsAsStringArray != null){
	    	for(int i=0; i<checkedLocationsAsStringArray.length; i++){
	    		sb.append("\"").append(checkedLocationsAsStringArray[i]).append("\"");
	    		if(i+1 < checkedLocationsAsStringArray.length){
	    			sb.append(",");
	    		}
	    	}
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
}
 