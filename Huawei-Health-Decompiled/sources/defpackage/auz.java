package defpackage;

import android.net.Uri;

/* JADX INFO: loaded from: classes10.dex */
public class auz extends auy {
    private static final Uri c = Uri.parse("content://com.huawei.android.sync.genSyncProvider/switchState");
    private static final Uri e = Uri.parse("content://com.huawei.android.sync.genSyncProvider/isSyncRecycle");
    private static final Uri d = Uri.parse("content://com.huawei.android.sync.genSyncProvider/reportPrepare");
    private static final Uri b = Uri.parse("content://com.huawei.android.sync.genSyncProvider/login_status");

    public static Uri gf_() {
        return d;
    }
}
