package defpackage;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class hoo {
    public static long a(long j) {
        return j * 1000;
    }

    public static long a(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        Date dateE = hnb.e(str, str2);
        if (dateE != null) {
            calendar.setTime(dateE);
        }
        return calendar.getTimeInMillis() / 1000;
    }

    public static String c(long j, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j * 1000);
        return hnb.a(calendar.getTime(), str);
    }

    public static String a(long j, TimeZone timeZone, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j * 1000);
        return hnb.c(calendar.getTime(), timeZone, str);
    }

    public static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j * 1000);
        return calendar.getTimeInMillis();
    }

    public static long e(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTimeInMillis() / 1000;
    }

    public static long c(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTimeInMillis();
    }
}
