package com.huawei.phoneservice.faq.base.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f8534a = null;
    private static boolean c = false;

    public static void d(String str, String str2) throws Throwable {
        e(5, str, str2);
    }

    public static void c(String str, String str2) throws Throwable {
        e(8, str, str2);
    }

    public static void b(String str, String str2) throws Throwable {
        e(4, str, str2);
    }

    public static void d(String str, Throwable th) throws Throwable {
        a(5, str, th);
    }

    public static void c(String str, String str2, Object... objArr) throws Throwable {
        b(5, str, null, str2, objArr);
    }

    public static void e(String str, String str2) {
        e(5, str, str2);
    }

    public static void a(String str, String str2, Object... objArr) throws Throwable {
        b(3, str, null, str2, objArr);
    }

    public static void a(String str, String str2) {
        e(3, str, str2);
    }

    private static String a() {
        return f8534a.getFilesDir().getAbsolutePath() + File.separator + "feedbackLog";
    }

    public static void a(boolean z, Application application) {
        c = z;
        f8534a = application;
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) throws Throwable {
        b(5, str, th, str2, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "  fileWriter Exception  "
            java.lang.String r1 = "  bufferedWriter Exception  "
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy-MM-dd"
            java.util.Locale r5 = java.util.Locale.getDefault()
            r3.<init>(r4, r5)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r6 = java.util.Locale.getDefault()
            r4.<init>(r5, r6)
            java.lang.String r3 = r3.format(r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = r4.format(r2)
            r5.append(r2)
            java.lang.String r2 = " "
            r5.append(r2)
            r5.append(r8)
            r5.append(r2)
            r5.append(r9)
            java.lang.String r8 = r5.toString()
            java.io.File r9 = new java.io.File
            java.lang.String r2 = a()
            r9.<init>(r2)
            boolean r2 = r9.exists()
            if (r2 != 0) goto L55
            r9.mkdirs()
        L55:
            java.io.File r2 = new java.io.File
            java.lang.String r9 = r9.toString()
            r2.<init>(r9, r3)
            boolean r9 = r2.exists()
            java.lang.String r3 = "FaqLogger"
            if (r9 != 0) goto L6f
            r2.createNewFile()     // Catch: java.io.IOException -> L6a
            goto L6f
        L6a:
            java.lang.String r9 = "  createNewFile Exception  "
            android.util.Log.e(r3, r9)
        L6f:
            r9 = 0
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L91 java.io.IOException -> L94
            r5 = 1
            r4.<init>(r2, r5)     // Catch: java.lang.Throwable -> L91 java.io.IOException -> L94
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            r2.write(r8)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8f
            r2.newLine()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> L8f
            r2.close()     // Catch: java.io.IOException -> L85
            goto La6
        L85:
            android.util.Log.e(r3, r1)
            goto La6
        L89:
            r8 = move-exception
            r9 = r2
            goto Lb3
        L8c:
            r8 = move-exception
            goto Lb3
        L8e:
            r2 = r9
        L8f:
            r9 = r4
            goto L95
        L91:
            r8 = move-exception
            r2 = r9
            goto Lb2
        L94:
            r2 = r9
        L95:
            java.lang.String r8 = "  IOException "
            android.util.Log.e(r3, r8)     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto La3
            r2.close()     // Catch: java.io.IOException -> La0
            goto La3
        La0:
            android.util.Log.e(r3, r1)
        La3:
            if (r9 == 0) goto Lad
            r4 = r9
        La6:
            r4.close()     // Catch: java.io.IOException -> Laa
            goto Lad
        Laa:
            android.util.Log.e(r3, r0)
        Lad:
            return
        Lae:
            r8 = move-exception
            r7 = r2
            r2 = r9
            r9 = r7
        Lb2:
            r4 = r2
        Lb3:
            if (r9 == 0) goto Lbc
            r9.close()     // Catch: java.io.IOException -> Lb9
            goto Lbc
        Lb9:
            android.util.Log.e(r3, r1)
        Lbc:
            if (r4 == 0) goto Lc5
            r4.close()     // Catch: java.io.IOException -> Lc2
            goto Lc5
        Lc2:
            android.util.Log.e(r3, r0)
        Lc5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.base.util.h.j(java.lang.String, java.lang.String):void");
    }

    private static void e(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static void c(Context context) {
        f8534a = context.getApplicationContext();
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(e());
        File file = new File(a());
        try {
            if (file.exists()) {
                String[] list = file.list();
                long jA = o.a(str);
                if (list != null) {
                    for (String str2 : list) {
                        if (jA >= o.a(str2)) {
                            e(new File(a() + File.separator + str2));
                        }
                    }
                }
            }
        } catch (ParseException unused) {
            Log.e("FaqLogger", "  ParseException ");
        }
    }

    private static void b(int i, String str, Throwable th, String str2, Object... objArr) throws Throwable {
        String strE = e(str2, objArr);
        if (th != null) {
            strE = strE + " : " + d(th);
        }
        if (TextUtils.isEmpty(str2)) {
            strE = "Empty/NULL log message";
        }
        e(i, str, strE);
    }

    private static void a(int i, String str, Throwable th) throws Throwable {
        e(i, str, d(th));
    }

    private static void e(int i, String str, String str2) throws Throwable {
        if (8 == i) {
            try {
                j(str, str2);
            } catch (Exception unused) {
                Log.e("FaqLogger", "  writeLogToFile Exception  ");
            }
        }
        if (!c || TextUtils.isEmpty(str2)) {
            return;
        }
        if (i == 3) {
            Log.d(str, str2);
            return;
        }
        if (i == 4) {
            Log.i(str, str2);
            return;
        }
        if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.v(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    private static Date e() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - 1);
        return calendar.getTime();
    }

    private static String d(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    private static String e(String str, Object... objArr) {
        if (objArr == null) {
            return str;
        }
        try {
            return objArr.length == 0 ? str : String.format(str, objArr);
        } catch (FormatterClosedException | IllegalFormatException unused) {
            return str;
        }
    }
}
