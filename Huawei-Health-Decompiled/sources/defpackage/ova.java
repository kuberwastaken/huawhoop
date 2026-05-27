package defpackage;

import android.util.Log;
import com.huawei.skinner.facade.template.ILogger;

/* JADX INFO: loaded from: classes7.dex */
public class ova implements ILogger {
    private boolean e = false;
    private boolean d = false;

    @Override // com.huawei.skinner.facade.template.ILogger
    public void showLog(boolean z) {
        this.e = z;
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void showDetailedStackTrace(boolean z) {
        this.d = z;
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void debug(String str) {
        debug("HwSkinner", str);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void info(String str) {
        info("HwSkinner", str);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void warn(String str) {
        warn("HwSkinner", str);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void error(String str) {
        error("HwSkinner", str);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void error(String str, Throwable th) {
        error("HwSkinner", str, th);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void debug(String str, String str2) {
        if (this.e) {
            Log.d("HwSkinner", c(str, str2));
        }
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void info(String str, String str2) {
        Log.i("HwSkinner", c(str, str2));
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void warn(String str, String str2) {
        if (this.e) {
            Log.w("HwSkinner", c(str, str2));
        }
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void error(String str, String str2) {
        Log.e("HwSkinner", c(str, str2));
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public void error(String str, String str2, Throwable th) {
        if (this.d) {
            Log.e("HwSkinner", c(str, str2), th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("throwable is null!");
        }
        Throwable cause = th.getCause();
        error(str, "Error:" + (cause == null ? th.getMessage() : cause.getMessage()) + "; " + str2);
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public boolean isShowLog() {
        return this.e;
    }

    @Override // com.huawei.skinner.facade.template.ILogger
    public boolean isShowDetailedStackTrace() {
        return this.d;
    }

    private String c(String str, String str2) {
        if ("HwSkinner".equals(str)) {
            return str2;
        }
        return str + "#" + str2;
    }
}
