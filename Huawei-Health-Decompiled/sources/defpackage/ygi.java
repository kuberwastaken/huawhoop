package defpackage;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.elements.util.ClockUtil;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes8.dex */
public class ygi {
    private static final boolean e = !Boolean.FALSE.equals(ygp.e("COAP_LOGGING_FILTER"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f19296a;
    private long b;
    private final long c;
    private final long d;
    private long j;

    public ygi(Logger logger, long j, long j2) {
        this(logger, j, j2, TimeUnit.NANOSECONDS);
    }

    public ygi(Logger logger, long j, long j2, TimeUnit timeUnit) {
        this.f19296a = logger;
        this.c = j;
        this.d = timeUnit.toNanos(j2);
        this.j = ClockUtil.b();
    }

    public void a(String str, Object... objArr) {
        if (this.f19296a.isWarnEnabled()) {
            d(Level.WARN, str, objArr);
        }
    }

    public void b(String str, Object... objArr) {
        if (this.f19296a.isInfoEnabled()) {
            d(Level.INFO, str, objArr);
        }
    }

    public void e(String str, Object... objArr) {
        if (this.f19296a.isDebugEnabled()) {
            d(Level.DEBUG, str, objArr);
        }
    }

    private void d(Level level, String str, Object... objArr) {
        boolean z;
        if (e) {
            long jB = ClockUtil.b();
            long j = this.d;
            long j2 = this.j;
            synchronized (this) {
                long j3 = this.b;
                z = j3 < this.c;
                if ((j + j2) - jB > 0) {
                    this.b = j3 + 1;
                } else {
                    this.j = jB;
                    if (!z) {
                        int length = objArr.length;
                        objArr = Arrays.copyOf(objArr, length + 1);
                        objArr[length] = Long.valueOf(this.b);
                        str = str + " ({} additional errors.)";
                        z = true;
                    }
                    this.b = 0L;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            int i = AnonymousClass5.d[level.ordinal()];
            if (i == 1) {
                this.f19296a.error(str, objArr);
                return;
            }
            if (i == 2) {
                this.f19296a.warn(str, objArr);
                return;
            }
            if (i == 3) {
                this.f19296a.info(str, objArr);
            } else if (i == 4) {
                this.f19296a.debug(str, objArr);
            } else {
                if (i != 5) {
                    return;
                }
                this.f19296a.trace(str, objArr);
            }
        }
    }

    /* JADX INFO: renamed from: ygi$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[Level.values().length];
            d = iArr;
            try {
                iArr[Level.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[Level.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[Level.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[Level.TRACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
