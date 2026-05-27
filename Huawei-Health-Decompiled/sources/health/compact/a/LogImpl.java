package health.compact.a;

import android.util.Log;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.haf.common.log.LogBuilder;
import com.huawei.haf.common.log.Logger;

/* JADX INFO: loaded from: classes.dex */
final class LogImpl implements Logger {
    @Override // com.huawei.haf.common.log.Logger
    public boolean isBetaVersion() {
        return false;
    }

    @Override // com.huawei.haf.common.log.Logger
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.huawei.haf.common.log.Logger
    public boolean isReleaseVersion() {
        return true;
    }

    LogImpl() {
    }

    @Override // com.huawei.haf.common.log.Logger
    public void v(String str, boolean z, Object... objArr) {
        if (LogConfig.a(0)) {
            Log.v(str, LogBuilder.d(objArr));
        }
    }

    @Override // com.huawei.haf.common.log.Logger
    public void d(String str, boolean z, Object... objArr) {
        if (LogConfig.a(1)) {
            Log.d(str, LogBuilder.d(objArr));
        }
    }

    @Override // com.huawei.haf.common.log.Logger
    public void i(String str, boolean z, Object... objArr) {
        if ((z || LogConfig.c()) && LogConfig.a(2)) {
            Log.i(str, LogBuilder.d(objArr));
        }
    }

    @Override // com.huawei.haf.common.log.Logger
    public void w(String str, boolean z, Object... objArr) {
        if ((z || LogConfig.c()) && LogConfig.a(3)) {
            Log.w(str, LogBuilder.d(objArr));
        }
    }

    @Override // com.huawei.haf.common.log.Logger
    public void e(String str, boolean z, Object... objArr) {
        if ((z || LogConfig.c()) && LogConfig.a(4)) {
            Log.e(str, LogBuilder.d(objArr));
        }
    }

    @Override // com.huawei.haf.common.log.Logger
    public String toString(Throwable th) {
        return ExceptionUtils.a(th);
    }
}
