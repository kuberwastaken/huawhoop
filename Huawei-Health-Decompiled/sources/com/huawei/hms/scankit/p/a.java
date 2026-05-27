package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes5.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f5914a;
    protected static final StackTraceElement[] b;
    private static final a c;

    static {
        f5914a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        b = stackTraceElementArr;
        a aVar = new a();
        c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    public static a a() {
        return f5914a ? new a() : c;
    }

    public static a a(String str) {
        return new a(str);
    }

    private a() {
    }

    private a(String str) {
        super(str);
    }
}
