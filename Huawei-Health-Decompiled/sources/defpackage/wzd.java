package defpackage;

import android.util.Log;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;

/* JADX INFO: loaded from: classes8.dex */
public class wzd implements ILogUcs {
    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
    public void d(String str, String str2) {
        Log.d(str, str2);
    }
}
