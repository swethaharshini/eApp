package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.JobCategory;

public class JobCategoryComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public JobCategoryComparator() 
	  {
	   this(false);
	  }
	 
	  public JobCategoryComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   JobCategory instance1 = (JobCategory) obj1;
	   JobCategory instance2 = (JobCategory) obj2;
	   
	   System.out.println("============");
	   System.out.println("instance1 === " +instance1.getJobcategory().toLowerCase());
	   System.out.println("instance2 == " +instance2.getJobcategory().toLowerCase());
	   
	   int value = instance1.getJobcategory().toLowerCase().compareTo(instance2.getJobcategory().toLowerCase());
	 
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
