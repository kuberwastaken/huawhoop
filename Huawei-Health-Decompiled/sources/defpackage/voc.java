package defpackage;

import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes8.dex */
public class voc {
    GregorianCalendar b;

    public voc() {
        this(TimeZone.getDefault());
    }

    private int a() {
        return this.b.get(11);
    }

    public static long c() {
        return new GregorianCalendar().getTimeInMillis();
    }

    private int f() {
        return this.b.get(13);
    }

    private int g() {
        return this.b.get(12);
    }

    public int b() {
        return this.b.get(5);
    }

    public int d() {
        if (this.b.get(0) == 0) {
            return 0;
        }
        return this.b.get(1);
    }

    public void d(long j) {
        if (j == -1) {
            return;
        }
        this.b.setTimeInMillis(j);
    }

    public int e() {
        return this.b.get(2);
    }

    public String toString() {
        return " year:" + d() + " month:" + e() + " monthDay:" + b() + " hour:" + a() + " minute:" + g() + " second:" + f();
    }

    public voc(TimeZone timeZone) {
        this.b = null;
        this.b = new GregorianCalendar(timeZone);
    }
}
