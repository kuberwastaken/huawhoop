package defpackage;

import java.time.Instant;
import java.time.ZoneId;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes8.dex */
public class vjm {
    public static long b() {
        return (Instant.now().toEpochMilli() - 631065600000L) / 1000;
    }

    public static long e(long j) {
        return (j - 631065600000L) / 1000;
    }

    public static long a() {
        String id = ZoneId.systemDefault().getId();
        long jB = b();
        TimeZone timeZone = TimeZone.getTimeZone(id);
        return jB + ((long) ((timeZone.getRawOffset() + timeZone.getDSTSavings()) / 1000));
    }
}
