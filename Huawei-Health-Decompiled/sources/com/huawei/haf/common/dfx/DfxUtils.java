package com.huawei.haf.common.dfx;

import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.haf.common.utils.AppInfoUtils;
import health.compact.a.ProcessUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DfxUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static File f2123a;
    private static final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    private DfxUtils() {
    }

    public static File b() {
        File file = f2123a;
        if (file != null) {
            return file;
        }
        File file2 = new File(AppInfoUtils.h(null), AppInfoUtils.b());
        f2123a = file2;
        return file2;
    }

    public static File a(File file) {
        return new File(file, "dfx_log_" + AppInfoUtils.g());
    }

    public static String c(String str) {
        return ProcessUtil.d().replace(':', '_') + str;
    }

    public static String a(String str, boolean z) {
        if (!z) {
            return c(str);
        }
        return AppInfoUtils.b() + str;
    }

    public static String b(Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter(2048);
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ExceptionUtils.b(thread, th, printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static String b(long j) {
        String str;
        if (j <= 0) {
            return "N/A";
        }
        SimpleDateFormat simpleDateFormat = d;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    public static String d(String str, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
        if (date == null) {
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }
}
