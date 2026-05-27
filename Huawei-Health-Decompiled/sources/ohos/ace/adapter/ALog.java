package ohos.ace.adapter;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes8.dex */
public class ALog {
    private static ILogger logger;
    private static final ReentrantLock loggerLock = new ReentrantLock();
    private static int logLevel = 0;

    private ALog() {
    }

    public static void setLogger(ILogger iLogger) {
        if (iLogger == null) {
            return;
        }
        ReentrantLock reentrantLock = loggerLock;
        reentrantLock.lock();
        logger = iLogger;
        reentrantLock.unlock();
    }

    public static void setLoggerLevel(int i) {
        logLevel = i;
    }

    public static boolean isDebuggable() {
        return logger.isDebuggable();
    }

    public static void d(String str, String str2) {
        ILogger iLogger = logger;
        if (iLogger == null || logLevel > 0) {
            return;
        }
        iLogger.d(str, str2);
    }

    public static void i(String str, String str2) {
        ILogger iLogger = logger;
        if (iLogger == null || logLevel > 1) {
            return;
        }
        iLogger.i(str, str2);
    }

    public static void w(String str, String str2) {
        ILogger iLogger = logger;
        if (iLogger == null || logLevel > 2) {
            return;
        }
        iLogger.w(str, str2);
    }

    public static void e(String str, String str2) {
        ILogger iLogger = logger;
        if (iLogger == null || logLevel > 3) {
            return;
        }
        iLogger.e(str, str2);
    }

    public static void jankLog(int i, String str) {
        ILogger iLogger = logger;
        if (iLogger == null) {
            return;
        }
        iLogger.jankLog(i, str);
    }
}
