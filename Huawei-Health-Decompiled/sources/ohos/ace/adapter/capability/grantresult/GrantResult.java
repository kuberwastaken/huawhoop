package ohos.ace.adapter.capability.grantresult;

import android.content.Context;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes8.dex */
public class GrantResult {
    private static final String LOG_TAG = "GrantResult";
    private Context mContext;

    public native void onRequestPremissionCallback(String[] strArr, int[] iArr);

    public GrantResult(Context context) {
        ALog.i(LOG_TAG, "GrantResult start");
        this.mContext = context;
    }
}
