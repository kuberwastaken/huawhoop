package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class vvs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f18810a = {"Service/app/v", "WiseCloudVirtualCardMgmtService/api/v1/client/getUserInfo"};
    private static volatile vvs c = null;
    private static volatile boolean b = false;

    public static boolean c(String str) {
        if (b && !TextUtils.isEmpty(str)) {
            int length = f18810a.length;
            for (int i = 0; i < length; i++) {
                if (str.contains(f18810a[i])) {
                    return true;
                }
            }
        }
        return b && str.contains("WiseCloudWalletMallSpikeService");
    }
}
