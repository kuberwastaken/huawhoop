package defpackage;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public class phd {
    public static long k(long j) {
        return j + 1388505600000L;
    }

    public static int j(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MINUTES.toMillis(i) - 1388505600000L);
    }

    public static int h(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(TimeUnit.MINUTES.toMillis(i) + 1388505600000L);
    }

    public static long a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int d(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(a(TimeUnit.MINUTES.toMillis(i)));
    }

    public static int c(long j) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(a(j));
    }

    private static long aa(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int o(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(aa(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(5, -1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int a(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(b(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long d() {
        return TimeUnit.DAYS.toMillis(1L);
    }

    public static long a() {
        return TimeUnit.DAYS.toMinutes(1L);
    }

    public static long m(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        for (int i = calendar.get(7); i != phe.c(); i = calendar.get(7)) {
            calendar.add(5, -1);
        }
        return e(calendar).longValue();
    }

    public static int p(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(m(TimeUnit.MINUTES.toMillis(i)));
    }

    public static int o(long j) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(m(j));
    }

    public static long l(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(7);
        if (i == phe.c()) {
            calendar.add(5, 1);
            i = calendar.get(7);
        }
        while (i != phe.c()) {
            calendar.add(5, 1);
            i = calendar.get(7);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int m(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(l(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long x(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(7);
        if (i == phe.c()) {
            calendar.add(5, -1);
            i = calendar.get(7);
        }
        while (i != phe.c()) {
            calendar.add(5, -1);
            i = calendar.get(7);
        }
        return e(calendar).longValue();
    }

    public static int f(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(x(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long c() {
        return d() * 7;
    }

    public static long j(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return a(calendar).longValue();
    }

    public static int k(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(j(TimeUnit.MINUTES.toMillis(i)));
    }

    public static int f(long j) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(j(j));
    }

    private static long ac(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, 1);
        return a(calendar).longValue();
    }

    public static int l(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(ac(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long y(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, -1);
        return a(calendar).longValue();
    }

    public static int g(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(y(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long i(long j) {
        return ((long) g(j)) * d();
    }

    public static int g(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(5, 1);
        calendar.roll(5, -1);
        return calendar.get(5);
    }

    public static long d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = i - 2013;
        int i3 = i2 > 5 ? i2 : 5;
        if (i2 >= 10) {
            i3 = 10;
        }
        calendar.set(1, (i - i3) + 1);
        calendar.set(2, 0);
        calendar.set(9, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static int b(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(d(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long w(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(2, 0);
        calendar.set(9, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static int c(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(w(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long ab(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(1, 5);
        calendar.set(2, 0);
        calendar.set(9, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static int n(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(ab(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long v(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(1, -5);
        calendar.set(2, 0);
        calendar.set(9, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static int e(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(v(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long q(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return c(calendar).longValue();
    }

    public static int q(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(q(TimeUnit.MINUTES.toMillis(i)));
    }

    public static int r(long j) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(q(j));
    }

    public static long n(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(1, 1);
        return c(calendar).longValue();
    }

    public static int s(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(n(TimeUnit.MINUTES.toMillis(i)));
    }

    private static long z(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(1, -1);
        return c(calendar).longValue();
    }

    public static int i(int i) {
        return (int) TimeUnit.MILLISECONDS.toMinutes(z(TimeUnit.MINUTES.toMillis(i)));
    }

    public static long s(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(1, 1);
        return calendar.getTimeInMillis() - timeInMillis;
    }

    public static int e(long j) {
        return (int) Math.round((j * 1.0d) / d());
    }

    public static boolean t(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(2);
        calendar.add(13, -1);
        return i != calendar.get(2);
    }

    public static boolean u(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.add(13, -1);
        return i != calendar.get(1);
    }

    private static Long e(Calendar calendar) {
        d(calendar);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    private static Long a(Calendar calendar) {
        int i = calendar.get(5);
        while (i != 1) {
            calendar.add(5, -1);
            i = calendar.get(5);
        }
        d(calendar);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    private static Long c(Calendar calendar) {
        int i = calendar.get(2);
        while (i != 0) {
            calendar.add(2, -1);
            i = calendar.get(2);
        }
        d(calendar);
        calendar.set(5, 1);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    private static void d(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public static long h(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(5, (calendar.getActualMaximum(5) / 2) + 1);
        return calendar.getTimeInMillis();
    }

    public static boolean p(long j) {
        return TimeUnit.MILLISECONDS.toMinutes(j) == TimeUnit.MILLISECONDS.toMinutes(kql.r(j));
    }
}
