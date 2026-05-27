package com.huawei.haf.common.log;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class LogBuilder {
    private static final ArrayDeque<StringBuilder> b = new ArrayDeque<>(3);

    private LogBuilder() {
    }

    public static void e() {
        ArrayDeque<StringBuilder> arrayDeque = b;
        synchronized (arrayDeque) {
            arrayDeque.clear();
        }
    }

    public static String d(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sbA = a();
        for (Object obj : objArr) {
            sbA.append(obj);
        }
        String string = sbA.toString();
        b(sbA);
        return string;
    }

    private static StringBuilder a() {
        StringBuilder sbPollLast;
        ArrayDeque<StringBuilder> arrayDeque = b;
        synchronized (arrayDeque) {
            sbPollLast = arrayDeque.pollLast();
        }
        if (sbPollLast == null) {
            return new StringBuilder(256);
        }
        sbPollLast.delete(0, sbPollLast.length());
        return sbPollLast;
    }

    private static void b(StringBuilder sb) {
        if (sb.capacity() > 256) {
            return;
        }
        ArrayDeque<StringBuilder> arrayDeque = b;
        synchronized (arrayDeque) {
            if (arrayDeque.size() < 3) {
                arrayDeque.addLast(sb);
            }
        }
    }
}
