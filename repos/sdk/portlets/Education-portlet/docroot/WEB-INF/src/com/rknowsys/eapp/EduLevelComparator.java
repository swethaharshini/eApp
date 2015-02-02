package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Education;

public class EduLevelComparator extends OrderByComparator{
	private static Logger log = Logger.getLogger(EduLevelComparator.class);

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public EduLevelComparator() 
	  {
		  this(false);
		  log.info("inside Constructor EduLevelComparator");
	  }
	 
	  public EduLevelComparator(boolean asc) {
		  log.info("EduLevelComparator ");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Education instance1 = (Education) obj1;
	   Education instance2 = (Education) obj2;
	   
	     int value = instance1.getEduLevel().toLowerCase().compareTo(instance2.getEduLevel().toLowerCase());
	 
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
