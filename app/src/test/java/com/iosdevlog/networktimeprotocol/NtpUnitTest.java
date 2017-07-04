package com.iosdevlog.networktimeprotocol;

import com.iosdevlog.networktimeprotocol.Util.Util;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NtpUnitTest {
    @Test
    public void ntp_isCorrect() throws Exception {
        long longTime = Util.getCurrentNetworkTime();
        Date date = new Date(longTime);
        // You can specify styles if you want
        DateFormat format = DateFormat.getDateInstance();
        // Set time zone information if you want.
        String text = format.format(date);

        System.out.print(text);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        //Add one to month {0 - 11}
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millis = calendar.get(Calendar.MILLISECOND);

        assertEquals(2017, year);
        assertEquals(7, month);
        assertEquals(4, day);
        assertEquals(12, hour);
//        assertEquals(6, minute);
    }
}