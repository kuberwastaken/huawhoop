package com.huawei.health.h5pro.load.expression;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class TimeFunctions {
    @ExpressionFunction(alias = "getSecondsBeforeTime")
    public long getSecondsBeforeTime(long j, long j2, String str) {
        return b(j, j2, str) / 1000;
    }

    @ExpressionFunction(alias = "getMilliSecondsBeforeTime")
    public long getMilliSecondsBeforeTime(long j, long j2, String str) {
        return b(j, j2, str);
    }

    @ExpressionFunction(alias = "getCurrentTimeZone")
    public String getCurrentTimeZone() {
        return new SimpleDateFormat("Z").format(Calendar.getInstance().getTime());
    }

    @ExpressionFunction(alias = "getCurrentSeconds")
    public long getCurrentSeconds() {
        return new Date().getTime() / 1000;
    }

    @ExpressionFunction(alias = "getCurrentMilliSeconds")
    public long getCurrentMilliSeconds() {
        return new Date().getTime();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long b(long r7, long r9, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.health.h5pro.load.expression.TimeFunctions.b(long, long, java.lang.String):long");
    }
}
