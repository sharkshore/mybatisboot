package com.shark.springboot.common.utils;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {
    public static final String timePattern = "HHmmss";
    public static final String timesPattern = "yyyy/MM/ddHH:mm:ss";
    public static final String datePattern = "yyyyMMdd";
    public static final String shortDatePattern = "yyMMdd";
    public static final String fullPattern = "yyyyMMddHHmmss";
    public static final String fullPatterns = "yyyyMMddHHmmssSS";
    public static final String partPattern = "yyMMddHHmmss";
    public static final String settlePattern = "yyyy-MM-dd HH:mm:ss";
    public static final String hour_of_minute = "HHmm";
    public static final String yyyyMM = "yyyyMM";
    public static final String datefullPattern = "yyyyMMdd HH:mm:ss";
    public static final String year_of_minute = "yyyyMMddHHmm";
    public static final String ymdhm = "yyyy-MM-dd HH:mm";
    public static final String smallDateFormat = "yyyy-MM-dd";
    public static final String smallDatePattern = "yyyy/MM/dd";
    public static final String millisDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String utcDateFormat = "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'";

    public DateUtil() {
    }

    public static Date getCurrentDate() {
        return DateTime.now().toDate();
    }

    public static String getCurrent() {
        return getCurrent("yyyyMMddHHmmss");
    }

    public static String getCurrentStr() {
        return getCurrent("yyyyMMdd");
    }

    public static String getCurrent(String pattern) {
        return DateTime.now().toString(pattern);
    }

    public static Date parse(String date) {
        return !StringUtils.isBlank(date) && date.length() > 14?parse(date, "yyyyMMddHHmmssSS"):parse(date, "yyyyMMddHHmmss");
    }

    public static Date parse(String date, String pattern) {
        DateTime dateTime = parseTime(date, pattern);
        return dateTime == null?null:dateTime.toDate();
    }

    public static DateTime parseTime(String date, String pattern) {
        if(StringUtils.isBlank(date)) {
            return null;
        } else {
            if("yyyyMMddHHmmss".equals(pattern)) {
                date = StringUtils.rightPad(date, 14, '0');
            }

            return DateTimeFormat.forPattern(pattern).parseDateTime(date);
        }
    }

    public static String format(Date date) {
        return format(date, "yyyyMMddHHmmss");
    }

    public static String formatDate(Date date) {
        return null == date?null:format(date, "yyyyMMdd");
    }

    public static String format(Date date, String pattern) {
        return date == null?null:(new DateTime(date)).toString(pattern);
    }

    public static String computeDate(String date, int day, String inPattern, String outPattern) {
        try {
            DateTime e = parseTime(date, inPattern);
            if(e == null) {
                return null;
            } else {
                e = e.minusDays(0 - day);
                return format(e.toDate(), outPattern);
            }
        } catch (Exception var5) {
            return null;
        }
    }

    private static Date addDate(Date date, int calendarField, int amount) {
        if(date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    public static Date addSeconds(Date source, int seconds) {
        return addDate(source, 13, seconds);
    }

    public static Date addDays(Date source, int addDays) {
        return addDate(source, 5, addDays);
    }

    public static Date addYear(Date date, int year) {
        if(date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        } else {
            DateTime dateTime = new DateTime(date);
            return dateTime.plusYears(year).toDate();
        }
    }

    public static Date addDay(Date date, int day) {
        if(date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        } else {
            DateTime dateTime = new DateTime(date);
            return dateTime.plusDays(day).toDate();
        }
    }

    public static DateTime thisMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMaximumValue();
    }

    public static DateTime thisMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMinimumValue();
    }

    public static boolean isMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMinimumValue();
        return beginDT.equals(dateTime);
    }

    public static boolean isMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMaximumValue();
        return beginDT.equals(dateTime);
    }

    public static String getYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getYear());
    }

    public static String getMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getMonthOfYear());
    }

    public static Date getCurrentDate(String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        return DateTime.parse((new DateTime()).toString(pattern), format).toDate();
    }

    public static long getBetweenDays(Date startDate, Date endDate) {
        if(endDate != null && startDate != null) {
            Long days = Long.valueOf(endDate.getTime() - startDate.getTime());
            return days.longValue() / 86400000L;
        } else {
            return -1L;
        }
    }
}
