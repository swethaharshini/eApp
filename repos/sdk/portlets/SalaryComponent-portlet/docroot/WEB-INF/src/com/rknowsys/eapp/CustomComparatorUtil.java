package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	

	
	public static OrderByComparator getSalaryComponentOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("componentName")) {
			    
			    orderByComparator = new ComponentComparator(orderByAsc);
			   }
			   if (orderByCol.equalsIgnoreCase("type")) {
				    
				    orderByComparator = new ComponentComparator(orderByAsc);
				   } 
			   if (orderByCol.equalsIgnoreCase("totalPayable")) {
				    
				    orderByComparator = new ComponentComparator(orderByAsc);
				   } 
			   if (orderByCol.equalsIgnoreCase("costToCompany")) {
				    
				    orderByComparator = new ComponentComparator(orderByAsc);
				   } 
			  		   
			   return orderByComparator;
			   }

}
