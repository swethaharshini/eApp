package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.JobTitle;

public class JobdescriptionComparator extends OrderByComparator {
	
	private static Logger log = Logger.getLogger(JobdescriptionComparator.class);
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public JobdescriptionComparator() 
	  {
	   this(false);
	  }
	 
	  public JobdescriptionComparator(boolean asc) {
		  log.info("JobdescriptionComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   JobTitle instance1 = (JobTitle) obj1;
	   JobTitle instance2 = (JobTitle) obj2;
	   
	   
	   int value = instance1.getDescription().toLowerCase().compareTo(instance2.getDescription().toLowerCase());
	 
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
