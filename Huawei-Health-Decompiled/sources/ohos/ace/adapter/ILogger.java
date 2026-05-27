package ohos.ace.adapter;

/* JADX INFO: loaded from: classes8.dex */
public interface ILogger {
    public static final int LOG_DEBUG = 0;
    public static final int LOG_ERROR = 3;
    public static final int LOG_FATAL = 4;
    public static final int LOG_INFO = 1;
    public static final int LOG_WARN = 2;

    void d(String str, String str2);

    void e(String str, String str2);

    void f(String str, String str2);

    void i(String str, String str2);

    boolean isDebuggable();

    void jankLog(int i, String str);

    void w(String str, String str2);
}
