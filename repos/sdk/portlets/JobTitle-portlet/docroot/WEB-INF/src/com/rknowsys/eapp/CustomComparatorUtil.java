package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	
	
	public static OrderByComparator getJobtitleOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("title")) {
			    
			    orderByComparator = new JobtitleComparator(orderByAsc);
			   }
			   else if(orderByCol.equalsIgnoreCase("description"))
			   {
				   orderByComparator = new JobdescriptionComparator(orderByAsc);
			   }
			   else if(orderByCol.equalsIgnoreCase("notes")){
				   
				   orderByComparator = new JobnotesComparator(orderByAsc);
			   }
			  		   
			   return orderByComparator;
			   }

}
