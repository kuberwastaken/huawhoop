package com.huawei.secure.android.common.detect;

import android.content.Context;
import android.os.Process;
import com.huawei.secure.android.common.detect.utils.b;
import com.huawei.secure.android.common.detect.utils.c;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes11.dex */
public class XposedDetect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8916a = "XpsDetect";
    private static final String b = "64652e726f62762e616e64726f69642e78706f7365642e696e7374616c6c6572";
    private static final String c = "64652e726f62762e616e64726f69642e78706f7365642e58706f736564427269646765";
    private static final String d = "58706f7365644272696467652e6a6172";

    private static boolean a() {
        try {
            throw new SecurityException("Xps detect exception");
        } catch (SecurityException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                try {
                    if (stackTraceElement.getClassName().equals(new String(com.huawei.secure.android.common.detect.utils.a.b(c), "UTF-8")) && stackTraceElement.getMethodName().equals("main")) {
                        c.b(f8916a, "find Xps Bridge by exception class name");
                        return true;
                    }
                } catch (UnsupportedEncodingException unused) {
                    c.b(f8916a, "UnsupportedEncodingException");
                }
            }
            return false;
        }
    }

    private static boolean b() throws Throwable {
        Throwable th;
        Reader inputStreamReader;
        FileInputStream fileInputStream;
        Reader reader;
        String line;
        Reader reader2 = null;
        try {
            String str = "/proc/" + Process.myPid() + "/maps";
            String str2 = new String(com.huawei.secure.android.common.detect.utils.a.b(d), "UTF-8");
            fileInputStream = new FileInputStream(str);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    do {
                        try {
                            line = bufferedReader.readLine();
                            if (line == null) {
                                b.a((Reader) bufferedReader);
                                b.a(inputStreamReader);
                                b.a((InputStream) fileInputStream);
                                return false;
                            }
                        } catch (IOException e) {
                            reader2 = bufferedReader;
                            e = e;
                            reader = reader2;
                            reader2 = inputStreamReader;
                            try {
                                c.b(f8916a, "Xps Jar Check " + e.getMessage());
                                b.a(reader);
                                b.a(reader2);
                                b.a((InputStream) fileInputStream);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                Reader reader3 = reader;
                                inputStreamReader = reader2;
                                reader2 = reader3;
                                b.a(reader2);
                                b.a(inputStreamReader);
                                b.a((InputStream) fileInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            reader2 = bufferedReader;
                            b.a(reader2);
                            b.a(inputStreamReader);
                            b.a((InputStream) fileInputStream);
                            throw th;
                        }
                    } while (!line.contains(str2));
                    c.b(f8916a, "Xps JAR found: ");
                    b.a((Reader) bufferedReader);
                    b.a(inputStreamReader);
                    b.a((InputStream) fileInputStream);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e3) {
                e = e3;
                reader = null;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
            }
        } catch (IOException e4) {
            e = e4;
            reader = null;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader = null;
            fileInputStream = null;
        }
    }

    public static boolean isXposedHook(Context context) {
        return a() && b();
    }
}
