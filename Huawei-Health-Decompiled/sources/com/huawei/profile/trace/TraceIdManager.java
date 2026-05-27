package com.huawei.profile.trace;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final class TraceIdManager {
    private static final int SEQ_BIT_SIZE = 100;
    private static final int TIME_BIT = 268435455;
    private static final Object LOCK = new Object();
    private static InheritableThreadLocal<String> traceIdThreadLocal = new InheritableThreadLocal<>();
    private static int count = 0;

    private TraceIdManager() {
    }

    public static String genTraceId() {
        int i;
        synchronized (LOCK) {
            i = count;
            int i2 = i + 1;
            count = i2;
            count = i2 % 100;
        }
        String str = String.format(Locale.ENGLISH, "%07X", Long.valueOf(System.currentTimeMillis() & 268435455)) + String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i));
        traceIdThreadLocal.set(str);
        return str;
    }

    public static void resetTraceId(String str) {
        traceIdThreadLocal.set(str);
    }

    public static String getTraceId() {
        return traceIdThreadLocal.get();
    }

    public static void clearTraceId() {
        traceIdThreadLocal.remove();
    }
}
