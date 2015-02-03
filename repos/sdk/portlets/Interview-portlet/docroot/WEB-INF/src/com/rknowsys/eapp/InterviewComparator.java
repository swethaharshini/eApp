package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Interview;

public class InterviewComparator extends OrderByComparator {
	private static Logger log = Logger.getLogger(InterviewComparator.class);
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
		 
	 
	  public InterviewComparator() 
	  {
	   this(false);
	  }
	 
	  public InterviewComparator(boolean asc) {
		  log.info("InterviewComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Interview instance1 = (Interview) obj1;
	   Interview instance2 = (Interview) obj2;
	   
	  	   
	   int value = instance1.getName().toLowerCase().compareTo(instance2.getName().toLowerCase());
	 
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
