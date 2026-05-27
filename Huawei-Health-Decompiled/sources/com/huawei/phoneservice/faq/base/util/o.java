package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.text.format.DateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class o {
    public static String c(String str, Context context) {
        String strD = !l.c(str) ? d(a(e(str)), context) : "";
        return l.c(strD) ? "" : strD;
    }

    public static long a(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime();
    }

    private static Date d(String str, String str2) {
        if (str2 != null && str != null) {
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (ParseException unused) {
                h.e("TimeStringUtil", "convertStringToDate ParseException Exception ...");
            }
        }
        return null;
    }

    public static Date e(String str) {
        Date dateD = d(str, "yyyy-M-d");
        return dateD == null ? d(str, "yyyy/M/d") : dateD;
    }

    private static Calendar a(Date date) {
        if (date == null) {
            h.a("TimeStringUtil", "convertDateToCalendar::date is null");
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static String b(Calendar calendar, Context context, int i) {
        if (context == null || calendar == null) {
            h.a("TimeStringUtil", "convertCalendarToString::context or calendar is null");
            return null;
        }
        try {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), i);
        } catch (IllegalArgumentException unused) {
            h.e("TimeStringUtil", "get formatTime error");
            return null;
        }
    }

    private static String d(Calendar calendar, Context context) {
        return b(calendar, context, 196628);
    }
}
