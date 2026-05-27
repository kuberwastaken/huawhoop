package defpackage;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwonesdk.process.HiHealthProcess;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class mnj {
    public static void a(String str, HiHealthProcess hiHealthProcess, IBaseResponseCallback iBaseResponseCallback) {
        if (iBaseResponseCallback == null) {
            LogUtil.d("HiHealthProcess_OneSdkFactory", "callback is null in execute");
        } else if (hiHealthProcess == null) {
            LogUtil.a("HiHealthProcess_OneSdkFactory", "hiHealthProcess is null in execute");
            iBaseResponseCallback.onResponse(-1, "");
        } else {
            hiHealthProcess.doAction(str, iBaseResponseCallback);
        }
    }
}
