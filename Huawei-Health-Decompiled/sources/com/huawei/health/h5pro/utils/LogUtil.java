package com.huawei.health.h5pro.utils;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.health.h5pro.utils.EnvironmentHelper;
import com.huawei.health.h5pro.vengine.H5ProInstance;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class LogUtil {
    public static HandlerThread c;
    public static Handler d;
    public static LinkedHashMap<String, LogLevel> e;
    public static final Object b = new Object();
    public static final List<String> f = Collections.synchronizedList(new ArrayList());
    public static volatile boolean g = false;
    public static File i = null;
    public static File j = null;
    public static SimpleDateFormat h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayDeque<StringBuilder> f2500a = null;

    public static void w(String str, String... strArr) {
        w(str, false, strArr);
    }

    public static void w(String str, boolean z, String... strArr) {
        print(z, LogLevel.WARN, str, strArr);
    }

    public static void setPrintAble(boolean z) {
        if (z == g) {
            return;
        }
        g = z;
    }

    public static void setDisableLogLevel(LogLevel... logLevelArr) {
        LinkedHashMap<String, LogLevel> linkedHashMap = e;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        if (logLevelArr == null || logLevelArr.length <= 0) {
            return;
        }
        if (e == null) {
            e = new LinkedHashMap<>();
        }
        for (LogLevel logLevel : logLevelArr) {
            if (logLevel != null) {
                e.put(logLevel.level, logLevel);
            }
        }
    }

    public static void saveToFile(LogLevel logLevel, String str, StringBuilder sb) {
        if (f2500a == null) {
            f2500a = new ArrayDeque<>(20);
        }
        sb.insert(0, "  ");
        sb.insert(0, str);
        sb.insert(0, "  ");
        sb.insert(0, logLevel.level);
        sb.insert(0, "  ");
        sb.insert(0, Binder.getCallingPid());
        sb.insert(0, "  ");
        SimpleDateFormat simpleDateFormat = h;
        sb.insert(0, simpleDateFormat == null ? "" : simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        f2500a.add(sb);
        if (f2500a.size() >= 20) {
            saveCacheToFile();
        }
    }

    public static void saveCacheToFile(final StringBuilder sb) {
        if (j == null) {
            return;
        }
        printThreadCheck();
        d.post(new Runnable() { // from class: com.huawei.health.h5pro.utils.LogUtil.1
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.fileCheck();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(LogUtil.j, true);
                    try {
                        fileOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    public static void saveCacheToFile() {
        ArrayDeque<StringBuilder> arrayDeque = f2500a;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder(f2500a.size());
        Iterator<StringBuilder> it = f2500a.iterator();
        while (it.hasNext()) {
            sb.append((CharSequence) it.next());
        }
        f2500a.clear();
        saveCacheToFile(sb);
    }

    public static void printThreadCheck() {
        if (c == null) {
            HandlerThread handlerThread = new HandlerThread("h5proFilePrintThread");
            c = handlerThread;
            handlerThread.start();
        }
        if (d == null) {
            d = new Handler(c.getLooper());
        }
    }

    public static void print(boolean z, LogLevel logLevel, String str, String... strArr) {
        print(z, logLevel, str, null, strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void print(boolean r6, com.huawei.health.h5pro.utils.LogUtil.LogLevel r7, java.lang.String r8, java.lang.Throwable r9, java.lang.String... r10) {
        /*
            java.lang.Object r0 = com.huawei.health.h5pro.utils.LogUtil.b
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L38
            int r3 = r10.length     // Catch: java.lang.Throwable -> L35
            if (r3 <= 0) goto L38
            r3 = r10[r1]     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L18
            java.lang.String r4 = "[RELEASE]"
            boolean r4 = r3.startsWith(r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L18
            r4 = r2
            goto L19
        L18:
            r4 = r1
        L19:
            if (r4 == 0) goto L39
            r5 = 9
            java.lang.String r3 = r3.substring(r5)     // Catch: java.lang.Throwable -> L35
            r10[r1] = r3     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r3.<init>()     // Catch: java.lang.Throwable -> L35
            r3.append(r8)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = "[R]"
            r3.append(r8)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L35
            goto L39
        L35:
            r6 = move-exception
            goto L9e
        L38:
            r4 = r1
        L39:
            boolean r3 = com.huawei.health.h5pro.utils.LogUtil.g     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L41
            if (r4 != 0) goto L41
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            return
        L41:
            java.util.LinkedHashMap<java.lang.String, com.huawei.health.h5pro.utils.LogUtil$LogLevel> r3 = com.huawei.health.h5pro.utils.LogUtil.e     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L51
            java.lang.String r5 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.access$000(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.Object r3 = r3.get(r5)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L51
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            return
        L51:
            boolean r3 = com.huawei.health.h5pro.utils.LogUtil.g     // Catch: java.lang.Throwable -> L35
            if (r3 != 0) goto L59
            if (r4 == 0) goto L5a
            if (r6 == 0) goto L5a
        L59:
            r1 = r2
        L5a:
            java.lang.StringBuilder r6 = formatLog(r1, r9, r10)     // Catch: java.lang.Throwable -> L35
            com.huawei.health.h5pro.utils.LogUtil$LogLevel r9 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.VERBOSE     // Catch: java.lang.Throwable -> L35
            if (r7 != r9) goto L6a
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.v(r8, r9)     // Catch: java.lang.Throwable -> L35
            goto L99
        L6a:
            com.huawei.health.h5pro.utils.LogUtil$LogLevel r9 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.DEBUG     // Catch: java.lang.Throwable -> L35
            if (r7 != r9) goto L76
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.d(r8, r9)     // Catch: java.lang.Throwable -> L35
            goto L99
        L76:
            com.huawei.health.h5pro.utils.LogUtil$LogLevel r9 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.INFO     // Catch: java.lang.Throwable -> L35
            if (r7 != r9) goto L82
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.i(r8, r9)     // Catch: java.lang.Throwable -> L35
            goto L99
        L82:
            com.huawei.health.h5pro.utils.LogUtil$LogLevel r9 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.WARN     // Catch: java.lang.Throwable -> L35
            if (r7 != r9) goto L8e
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.w(r8, r9)     // Catch: java.lang.Throwable -> L35
            goto L99
        L8e:
            com.huawei.health.h5pro.utils.LogUtil$LogLevel r9 = com.huawei.health.h5pro.utils.LogUtil.LogLevel.ERROR     // Catch: java.lang.Throwable -> L35
            if (r7 != r9) goto L99
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Log.e(r8, r9)     // Catch: java.lang.Throwable -> L35
        L99:
            saveToFile(r7, r8, r6)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            return
        L9e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.health.h5pro.utils.LogUtil.print(boolean, com.huawei.health.h5pro.utils.LogUtil$LogLevel, java.lang.String, java.lang.Throwable, java.lang.String[]):void");
    }

    public static void logCacheFlushing() {
        synchronized (b) {
            saveCacheToFile();
            HandlerThread handlerThread = c;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                c = null;
                d = null;
            }
        }
    }

    public static boolean isPrint() {
        return g;
    }

    public static void init(Context context) {
        if (context == null) {
            Log.w("H5PRO_LogUtil", "context is null");
            return;
        }
        h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);
        String packageName = context.getPackageName();
        if (EnvironmentHelper.getInstance().getBuildType() == EnvironmentHelper.BuildType.RELEASE) {
            i = new File(context.getFilesDir(), String.format(Locale.ENGLISH, "%s/%s.h5pro", packageName, packageName));
        } else {
            i = context.getExternalFilesDir(String.format(Locale.ENGLISH, "huaweisystem/%s/%s.h5pro", packageName, packageName));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.ROOT);
        long jCurrentTimeMillis = System.currentTimeMillis();
        j = new File(i, String.format(Locale.ENGLISH, "%s.log", simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis))));
        List<String> list = f;
        list.clear();
        list.add(String.format(Locale.ENGLISH, "%s.log", simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis - 86400000))));
        list.add(String.format(Locale.ENGLISH, "%s.log", simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis - com.huawei.openalliance.ad.constant.Constants.ANALYSIS_EVENT_KEEP_TIME))));
    }

    public static void i(String str, String... strArr) {
        i(str, false, strArr);
    }

    public static void i(String str, boolean z, String... strArr) {
        print(z, LogLevel.INFO, str, strArr);
    }

    public static String getTag(String str, String str2) {
        return String.format(Locale.ROOT, "H5PRO_%1$s[%2$s]", str2, str);
    }

    public static String getTag(H5ProInstance h5ProInstance, String str) {
        return getTag(h5ProInstance != null ? h5ProInstance.getAppFlag() : "", str);
    }

    public static StringBuilder formatLog(boolean z, Throwable th, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr == null) {
            sb.append("messages: null");
            sb.append(System.getProperty("line.separator"));
        } else {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String strEncodingLog = strArr[i2];
                if (strEncodingLog == null) {
                    sb.append("index: ");
                    sb.append(i2);
                    strEncodingLog = " - value：null";
                } else if (!z) {
                    strEncodingLog = LogPrintOperate.encodingLog(strEncodingLog);
                }
                sb.append(strEncodingLog);
                sb.append(System.getProperty("line.separator"));
            }
        }
        if (th != null) {
            sb.append(th.getMessage());
            sb.append(System.getProperty("line.separator"));
        }
        return sb;
    }

    public static void fileCheck() {
        if (j == null || i == null || f.isEmpty()) {
            return;
        }
        try {
            if (j.exists()) {
                return;
            }
            if (!i.exists()) {
                i.mkdirs();
            }
            File[] fileArrListFiles = i.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 1) {
                for (File file : fileArrListFiles) {
                    if (!f.contains(file.getName())) {
                        file.delete();
                    }
                }
            }
            j.createNewFile();
        } catch (IOException unused) {
        }
    }

    public static void e(String str, String... strArr) {
        e(str, (Throwable) null, strArr);
    }

    public static void e(String str, boolean z, Throwable th, String... strArr) {
        print(z, LogLevel.ERROR, str, th, strArr);
    }

    public static void e(String str, Throwable th, String... strArr) {
        e(str, false, th, strArr);
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, th, str2);
    }

    public static void d(String str, String... strArr) {
        d(str, false, strArr);
    }

    public static void d(String str, boolean z, String... strArr) {
        print(z, LogLevel.DEBUG, str, strArr);
    }

    public enum LogLevel {
        VERBOSE(ExifInterface.GPS_MEASUREMENT_INTERRUPTED),
        DEBUG("D"),
        INFO("I"),
        WARN("W"),
        ERROR(ExifInterface.LONGITUDE_EAST);

        public final String level;

        LogLevel(String str) {
            this.level = str;
        }
    }
}
