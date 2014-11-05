package com.rknowsys.eapp.hrm;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;

public class CurrencyComparator extends OrderByComparator {
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 private static Log log = LogFactoryUtil.getLog(CurrencyComparator.class);
	 
	 
	  public CurrencyComparator() 
	  {
	   this(false);
	  }
	 
	  public CurrencyComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   PayGradeCurrency instance1 = (PayGradeCurrency) obj1;
	   PayGradeCurrency instance2 = (PayGradeCurrency) obj2;
	   
	   log.info("=====");
	   log.info("instance1 === " +instance1.getCurrency().toLowerCase());
	   log.info("instance2 == " +instance2.getCurrency().toLowerCase());
	   
	   int value = instance1.getCurrency().toLowerCase().compareTo(instance2.getCurrency().toLowerCase());
	 
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
