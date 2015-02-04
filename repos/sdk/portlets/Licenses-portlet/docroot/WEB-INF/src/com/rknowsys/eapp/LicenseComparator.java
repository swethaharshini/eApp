package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.License;

public class LicenseComparator extends OrderByComparator{
	private static Logger log = Logger.getLogger(LicenseComparator.class);
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public LicenseComparator() 
	  {
	   this(false);
	  }
	 
	  public LicenseComparator(boolean asc) {
		  log.info("LicenseComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   License instance1 = (License) obj1;
	   License instance2 = (License) obj2;
	   
	     int value = instance1.getLicenseName().toLowerCase().compareTo(instance2.getLicenseName().toLowerCase());
	 
	   if(_asc) 
	   {
	    return value;
	   } else 
	   {
	    return -value;
	   }
	    
	 }
	 
	 
	 public String getOrderBy() {
	  
	  if (_asc) {
	   return ORDER_BY_ASC;
	  } 
	  else {
	   return ORDER_BY_DESC;
	  }
	  }
	 
	 private boolean _asc;

}
