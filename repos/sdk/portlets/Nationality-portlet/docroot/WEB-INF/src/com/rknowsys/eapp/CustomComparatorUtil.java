package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	
	public static OrderByComparator getNationalityOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("interview")) {
			    
			    orderByComparator = new NationalityComparator(orderByAsc);
			   } 
			  		   
			   return orderByComparator;
			   }

}
