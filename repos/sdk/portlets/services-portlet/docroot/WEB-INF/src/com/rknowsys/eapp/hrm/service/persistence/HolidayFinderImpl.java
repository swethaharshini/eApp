package com.rknowsys.eapp.hrm.service.persistence;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rknowsys.eapp.hrm.model.Holiday;
import com.rknowsys.eapp.hrm.model.impl.HolidayImpl;

public class HolidayFinderImpl extends BasePersistenceImpl<Holiday> implements
		HolidayFinder {
	
	public static String GET_SEARCHED_HOLIDAYS = HolidayFinder.class
	        .getName() + ".getSearchHolidays";

	public List<Holiday> getSearchHolidays(Date fromDate, Date toDate, long nationalityId, List<Long> locationIds){
	    Session session = null;
	    List<Holiday> holidays = null;
	    try {
	        session = openSession();
	        StringBuffer sqlbuff = new StringBuffer("SELECT Holiday.* FROM Holiday WHERE holidayDate  between  ? AND  ? ");
	        if (nationalityId != -1) {
	            sqlbuff.append(" and nationalityId = ? ");
	        }
	        String sql = sqlbuff.toString();
	        		//CustomSQLUtil.get(GET_SEARCHED_HOLIDAYS);
	        System.out.println("sql= " + sql);
	        SQLQuery q = session.createSQLQuery(sql);
	        System.out.println("q = " + q);
	 
	        q.addEntity("Holiday", HolidayImpl.class);
	        QueryPos qPos = QueryPos.getInstance(q);
System.out.println("fromDAte = " + fromDate + " toDate = " + toDate + " nationality = " + nationalityId);
	        qPos.add(fromDate);
	        qPos.add(toDate);
	        if (nationalityId != -1) {
	            qPos.add(nationalityId);
	        }
//	        qPos.add(locationIds);
	       // qPos.add(locationIds.toArray(new Long[locationIds.size()]));
	        holidays = (List<Holiday>) q.list();
	        if (holidays == null) {
	            holidays = Collections.emptyList();
	                                 }
	           } finally {
	        closeSession(session);
	     }
	    System.out.println(" In HolidayFinder - " + holidays);
	    return holidays;
	}
}
