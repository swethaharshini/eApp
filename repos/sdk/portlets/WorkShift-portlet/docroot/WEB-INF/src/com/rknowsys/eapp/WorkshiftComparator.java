package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Workshift;

public class WorkshiftComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "workshiftName ASC";
	 
	 public static String ORDER_BY_DESC = "workshiftName DESC";
	 private static Logger log = Logger.getLogger(WorkshiftComparator.class);
	 
	  public WorkshiftComparator() 
	  {
	   this(false);
	  }
	 
	  public WorkshiftComparator(boolean asc) {
		  log.info("WorkshiftComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Workshift instance1 = (Workshift) obj1;
	   Workshift instance2 = (Workshift) obj2;
	  
	   
	   int value = instance1.getWorkshiftName().toLowerCase().compareTo(instance2.getWorkshiftName().toLowerCase());
	 
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
