package utillities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth() {
        //Create Date Object
        Date dNow = new Date();
        //Create calendar object for Gregorian Calendar
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dNow);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(calendar.MONTH, 1);
        String date = sdf.format(calendar.getTime());
        //return the value of month and year in an array
        return date.split("-");

    }
}
