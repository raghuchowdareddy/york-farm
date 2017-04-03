/**
 * 
 */
package com.enuminfo.farm.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author Kumar
 */
public class DateTimeUtil {

	public static String convertTimestamp2Date(Timestamp timestamp) {
		String dateStr = null;
		if (timestamp != null) {
			Date date = new Date(timestamp.getTime());
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    dateStr = formatter.format(date);
		}
		return dateStr;
	}
	
	public static java.sql.Date convertString2SqlDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date convertedDate = null;
		try {
			convertedDate = (java.sql.Date) formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return convertedDate;
	}
	
	public static java.util.Date convertString2UtilDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date convertedDate = null;
		try {
			convertedDate = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return convertedDate;
	}
	
	public static java.sql.Time convertString2Time(String strTime) {
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time convertedTime = null;
		try {
			convertedTime = new java.sql.Time(formatter.parse(strTime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertedTime;
	}
	
	public static java.sql.Timestamp convertUtilDate2Timestamp() {
		java.util.Date utilDate = new java.util.Date(); 
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		return timestamp;
	}
	
	public static java.sql.Timestamp convertUtilDate2Timestamp(java.util.Date utilDate) {
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		return timestamp;
	}
	
	public static Date convertGMT2ISTDateTime(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:MM:SS");
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public static Date convertGMT2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public static Date convertGMTTime2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy HH:MM:SS.ZZZ");
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public static String convertGMT2ISTDateTimestamp(String datetime) {
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        return dTime.toString();
	}
	
	public static String convertSqlDate2String(String sqlDate) {
		String strDate = null;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sqlDate);
			strDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}
	
	public static Date convertSqlDate2UtilDate(String sqlDate) {
		String[] strDate = convertSqlDate2String(sqlDate).split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(strDate[2]), Integer.parseInt(strDate[0])-1, Integer.parseInt(strDate[1]));
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static List<Date> getWeekStartNEndDates() {
		List<Date> weekDates = new ArrayList<Date>();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		weekDates.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 6); 
		weekDates.add(calendar.getTime());
		return weekDates;		
	}
}
