package com.rknowsys.eapp;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.DocumentCategories;

public class DocumentCategoryComparator extends OrderByComparator {
	
	private static Logger log = Logger.getLogger(DocumentCategoryComparator.class);

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public DocumentCategoryComparator() 
	  {
		  this(false);
		  log.info("inside Constructor DocumentCategoryComparator");
	  }
	 
	  public DocumentCategoryComparator(boolean asc) {
		  log.info("DocumentCategoryComparator ");
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
		 
	   DocumentCategories instance1 = (DocumentCategories) obj1;
	   DocumentCategories instance2 = (DocumentCategories) obj2;
	   
	     int value = instance1.getDocumentCategory().toLowerCase().compareTo(instance2.getDocumentCategory().toLowerCase());
	 
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
