package com.rknowsys.eapp.hrm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static final String DATE_FORMAT_HRM = "dd/mm/yyyy";

	public static String format(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = "";
		if (date != null)
			dateStr = formatter.format(date);
		return dateStr;
	}


	public static String format(Calendar calendar) {
		return format(calendar.getTime());
	}

	
	public static void main(String args[]) {
//		System.out.println(parse("29/10/2014"));
		System.out.println("date = " + format(Calendar.getInstance()));

	}

	public static Date parse(String strDate, String dateFormat) {
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			if (strDate != null && !strDate.isEmpty())
				date = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date parse(String strDate) {
		return parse(strDate, DATE_FORMAT_HRM);
	}

}
