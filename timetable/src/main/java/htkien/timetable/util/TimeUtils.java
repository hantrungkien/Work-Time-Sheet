package htkien.timetable.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kienht on 4/28/17.
 */

public class TimeUtils {

    public static final int FIRST_YEAR = 2000;
    public static final int LAST_YEAR = 2050;

    public static int getWeekOfTime() {
        Calendar firstDayOfTime = Calendar.getInstance();
        firstDayOfTime.set(FIRST_YEAR, Calendar.JANUARY, 1);
        Calendar lasDayOfTime = Calendar.getInstance();
        lasDayOfTime.set(LAST_YEAR, Calendar.DECEMBER, 31);
        return (int) ((lasDayOfTime.getTimeInMillis() - firstDayOfTime.getTimeInMillis()) / (86400000 * 7));
    }

    // 86400000 = 24 * 60 * 60 * 1000
    // 7 is total date of week
    // +1 because start week = 0 , 1, 2, 3
    public static int getPositionForWeek(Calendar day) {
        Calendar firstDayOfTime = Calendar.getInstance();
        firstDayOfTime.set(FIRST_YEAR, Calendar.JANUARY, 1);
        if (day != null) {
            return (int) (((day.getTimeInMillis() - firstDayOfTime.getTimeInMillis()) / (86400000 * 7)) + 1);
        }
        return 0;
    }

    public static Calendar getWeekForPosition(int position) throws IllegalArgumentException {
        if (position < 0) {
            throw new IllegalArgumentException("position cannot be negative");
        }
        Calendar firstDayOfTime = Calendar.getInstance();
        firstDayOfTime.set(FIRST_YEAR, Calendar.JANUARY, 1);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(firstDayOfTime.getTimeInMillis());
        cal.add(Calendar.WEEK_OF_YEAR, position);
        return cal;
    }

    public static String getFormattedDate(long date) {
        String defaultPattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultPattern, Locale.GERMANY);
        return simpleDateFormat.format(new Date(date));
    }

    public static String getFirstDayOfWeek(Calendar calendar) {
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getFormattedDate(calendar.getTimeInMillis());
    }

    public static String getLastDayOfWeek(Calendar calendar) {
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getFormattedDate(calendar.getTimeInMillis());
    }

    public static float calculatorHour(String fromHour, String toHour) {
        Calendar calFrom = getCalendarFromStringDate(fromHour, "dd.MM.yyyy HH:mm");
        Calendar calTo = getCalendarFromStringDate(toHour, "dd.MM.yyyy HH:mm");
        long time = calTo.getTimeInMillis() - calFrom.getTimeInMillis();
        return (float) time / 3600000;
    }

    public static Calendar getCalendarFromStringDate(String date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseStringToDate(date, pattern));
        return cal;
    }

    public static Date parseStringToDate(String date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
