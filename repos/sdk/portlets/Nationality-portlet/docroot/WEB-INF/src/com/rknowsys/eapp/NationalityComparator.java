package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Nationality;

public class NationalityComparator extends OrderByComparator {
	
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 private static Logger log = Logger.getLogger(NationalityComparator.class);
	 
	 
	  public NationalityComparator() 
	  {
	   this(false);
	  }
	 
	  public NationalityComparator(boolean asc) {
		  log.info("NationalityComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Nationality instance1 = (Nationality) obj1;
	   Nationality instance2 = (Nationality) obj2;
	   
	      
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
