package com.rknowsys.eapp.hrm;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	
	public static OrderByComparator getPayGradeCurrencyOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("currency")) {
			    
			    orderByComparator = new CurrencyComparator(orderByAsc);
			   }
			  			  		   
			   return orderByComparator;
			   }

}
