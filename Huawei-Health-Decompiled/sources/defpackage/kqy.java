package defpackage;

import android.text.TextUtils;
import android.text.format.DateUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class kqy {
    public static String w(Date date) {
        return date == null ? "" : DateFormat.getDateInstance().format(date);
    }

    public static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        return calendar.getTimeInMillis();
    }

    public static long g(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 12);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Date a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5));
        return calendar.getTime();
    }

    public static Date b() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return calendar.getTime();
    }

    public static long c() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return k(calendar.getTime());
    }

    public static long b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5) - 1, 20, 0, 0);
        return k(calendar.getTime());
    }

    public static int e() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int e(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int t(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static int x(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static Date p(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static Date q(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 1);
        return calendar.getTime();
    }

    public static Date f(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date e(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            LogUtil.j("TimeDateFormatUtil", "getOffsetDate date is null.");
        } else {
            calendar.setTime(date);
            calendar.add(5, i);
        }
        return calendar.getTime();
    }

    public static Date c(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, i);
        return calendar.getTime();
    }

    public static long b(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, i);
        return n(calendar.getTime());
    }

    public static long a(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, i);
        return n(calendar.getTime());
    }

    public static long k(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime() / 1000;
    }

    public static long n(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        return k(calendar.getTime());
    }

    public static long o(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        return k(calendar.getTime());
    }

    public static Date c(long j) {
        return new Date((j * 1000) + ((long) TimeZone.getDefault().getRawOffset()));
    }

    public static String d(Date date) {
        return b(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String b(Date date, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.setTime(date);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static boolean ac(Date date) {
        return c(date, a());
    }

    public static boolean c(Date date, Date date2) {
        boolean z;
        boolean z2;
        if (date == null || date2 == null) {
            z = false;
            z2 = false;
        } else {
            z2 = date.getTime() >= c(date2).getTime();
            z = date.getTime() <= a(date2).getTime();
        }
        return z2 && z;
    }

    public static Date c(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (stringBuffer.length() == 1) {
            stringBuffer.insert(0, "0:0");
        } else if (stringBuffer.length() == 2) {
            stringBuffer.insert(0, "0:");
        } else if (stringBuffer.length() == 3) {
            stringBuffer.insert(1, ":");
        } else {
            stringBuffer.insert(2, ":");
        }
        return stringBuffer.toString();
    }

    public static String a(int i) {
        return d(String.valueOf(i));
    }

    public static int j(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7);
    }

    public static String d(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (RuntimeException e) {
            LogUtil.a("TimeDateFormatUtil", "Date Format exception = ", e.getMessage());
            return null;
        }
    }

    public static Date h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            LogUtil.a("TimeDateFormatUtil", "ParseException = ", e.getMessage());
            return null;
        }
    }

    public static Date v(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date u(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 11);
        calendar.set(5, 31);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static int d() {
        return Calendar.getInstance().get(1);
    }

    public static Date y(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(7, calendar.getFirstDayOfWeek());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.add(7, 7);
        return calendar.getTime();
    }

    public static Date i(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(2, 1);
        return calendar.getTime();
    }

    public static Date g(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(2, -1);
        return calendar.getTime();
    }

    public static Date h(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static Date m(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.add(2, 2);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static Date s(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.add(2, 0);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static Date l(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(5, 1);
        calendar.add(2, 1);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static int r(Date date) {
        Date dateL = l(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateL);
        return calendar.get(5);
    }

    public static long j(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        for (int i = calendar.get(5); i != 1; i = calendar.get(5)) {
            calendar.add(5, -1);
        }
        calendar.set(9, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int e(long j) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(j);
        return calendar.get(11);
    }

    public static long f() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar.getTimeInMillis();
    }

    public static long i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(jCurrentTimeMillis));
        calendar.add(14, -(calendar.get(15) + calendar.get(16)));
        return calendar.getTimeInMillis();
    }

    public static String e(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String strC = c(str, str2);
        if (TextUtils.isEmpty(strC)) {
            LogUtil.j("TimeDateFormatUtil", "getLocalTimeFromUtc standardDateTime is empty.");
            return str;
        }
        try {
            Date date = simpleDateFormat.parse(strC);
            if (date == null) {
                LogUtil.j("TimeDateFormatUtil", "getLocalTimeFromUtc localDate is null.");
                return str;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return c(gregorianCalendar, 65552);
        } catch (ParseException e) {
            LogUtil.a("TimeDateFormatUtil", "getLocalTimeFromUtc parse standardDateTime exception =  ", e.getMessage());
            return str;
        }
    }

    private static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date date = simpleDateFormat.parse(str);
            if (date == null) {
                LogUtil.j("TimeDateFormatUtil", "getStandardDateTimeFromUtc localDate is null.");
                return str;
            }
            if (!TextUtils.isEmpty(str2)) {
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + str2));
            }
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            LogUtil.a("TimeDateFormatUtil", "getStandardDateTimeFromUtc parse origin exception =  ", e.getMessage());
            return str;
        }
    }

    public static String c(Calendar calendar, int i) {
        String dateTime;
        if (calendar != null) {
            dateTime = DateUtils.formatDateTime(BaseApplication.getContext(), calendar.getTimeInMillis(), i);
        } else {
            LogUtil.j("TimeDateFormatUtil", "formatDateAndTime error, calendar is null");
            dateTime = "";
        }
        LogUtil.e("TimeDateFormatUtil", "formatDateAndTime myDateStr = ", dateTime);
        return dateTime;
    }

    public static long a(String str) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e) {
                LogUtil.a("TimeDateFormatUtil", "dateStringToLong ParseException :", e.getMessage());
            }
        }
        return date.getTime();
    }

    public static String i(String str) {
        if (!f(str)) {
            return str;
        }
        String[] strArrSplit = str.split("/");
        return strArrSplit[1] + "/" + strArrSplit[0] + "/" + strArrSplit[2];
    }

    public static String e(String str) {
        if (!f(str)) {
            return str;
        }
        String[] strArrSplit = str.split("/");
        String str2 = strArrSplit[0];
        return strArrSplit[1] + "/" + str2 + "/" + strArrSplit[2];
    }

    public static String c(String str) {
        if (!f(str)) {
            return str;
        }
        String[] strArrSplit = str.split("/");
        return strArrSplit[2] + "/" + strArrSplit[1] + "/" + strArrSplit[0];
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "") : str;
    }

    private static boolean f(String str) {
        return !TextUtils.isEmpty(str) && str.split("/").length == 3;
    }
}
