package net.openid.appauth.internal;

import android.util.Log;
import defpackage.xym;

/* JADX INFO: loaded from: classes8.dex */
public final class Logger {
    private static Logger c;
    private final int b;
    private final LogWrapper e;

    public interface LogWrapper {
        String getStackTraceString(Throwable th);

        boolean isLoggable(String str, int i);

        void println(int i, String str, String str2);
    }

    public static Logger e() {
        Logger logger;
        synchronized (Logger.class) {
            if (c == null) {
                c = new Logger(b.c);
            }
            logger = c;
        }
        return logger;
    }

    Logger(LogWrapper logWrapper) {
        this.e = (LogWrapper) xym.d(logWrapper);
        int i = 7;
        while (i >= 2 && this.e.isLoggable("AppAuth", i)) {
            i--;
        }
        this.b = i + 1;
    }

    public static void d(String str, Object... objArr) {
        e().b(3, null, str, objArr);
    }

    public static void c(Throwable th, String str, Object... objArr) {
        e().b(3, th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        e().b(5, null, str, objArr);
    }

    public static void a(String str, Object... objArr) {
        e().b(6, null, str, objArr);
    }

    public static void b(Throwable th, String str, Object... objArr) {
        e().b(6, th, str, objArr);
    }

    public void b(int i, Throwable th, String str, Object... objArr) {
        if (this.b > i) {
            return;
        }
        if (objArr != null && objArr.length >= 1) {
            str = String.format(str, objArr);
        }
        if (th != null) {
            str = str + "\n" + this.e.getStackTraceString(th);
        }
        this.e.println(i, "AppAuth", str);
    }

    static final class b implements LogWrapper {
        private static final b c = new b();

        private b() {
        }

        @Override // net.openid.appauth.internal.Logger.LogWrapper
        public void println(int i, String str, String str2) {
            Log.println(i, str, str2);
        }

        @Override // net.openid.appauth.internal.Logger.LogWrapper
        public boolean isLoggable(String str, int i) {
            return Log.isLoggable(str, i);
        }

        @Override // net.openid.appauth.internal.Logger.LogWrapper
        public String getStackTraceString(Throwable th) {
            return Log.getStackTraceString(th);
        }
    }
}
