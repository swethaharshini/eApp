package com.rknowsys.eapp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.SalaryComponent;

public class CTCComparator extends OrderByComparator {
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 private static Log log = LogFactoryUtil.getLog(CTCComparator.class);
	 
	 
	  public CTCComparator() 
	  {
	   this(false);
	  }
	 
	  public CTCComparator(boolean asc) {
		  log.info("CTCComparator");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   SalaryComponent instance1 = (SalaryComponent) obj1;
	   SalaryComponent instance2 = (SalaryComponent) obj2;
	   
	   
	   
	   int value = instance1.getCostToCompany().toLowerCase().compareTo(instance2.getCostToCompany().toLowerCase());
	 
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
