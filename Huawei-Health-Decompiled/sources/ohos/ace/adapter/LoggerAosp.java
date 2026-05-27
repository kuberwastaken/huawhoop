package ohos.ace.adapter;

import android.util.Log;

/* JADX INFO: loaded from: classes11.dex */
public class LoggerAosp implements ILogger {
    @Override // ohos.ace.adapter.ILogger
    public void f(String str, String str2) {
    }

    @Override // ohos.ace.adapter.ILogger
    public boolean isDebuggable() {
        return false;
    }

    @Override // ohos.ace.adapter.ILogger
    public void jankLog(int i, String str) {
    }

    @Override // ohos.ace.adapter.ILogger
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // ohos.ace.adapter.ILogger
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // ohos.ace.adapter.ILogger
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // ohos.ace.adapter.ILogger
    public void e(String str, String str2) {
        Log.e(str, str2);
    }
}
