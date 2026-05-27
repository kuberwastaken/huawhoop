package com.huawei.nfc;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.pluginbase.PluginBaseAdapter;
import defpackage.nyc;

/* JADX INFO: loaded from: classes6.dex */
public class PluginPay extends nyc {
    private static final Object SYNC_LOCK = new Object();
    private static final String TAG = "PluginPay";
    private static PluginPay sInstance;
    private Context mContext;
    private boolean mIsShowPay = false;

    private PluginPay(Context context) {
        this.mContext = context;
    }

    public static PluginPay getInstance(Context context) {
        PluginPay pluginPay;
        synchronized (SYNC_LOCK) {
            if (sInstance == null) {
                sInstance = new PluginPay(BaseApplication.getContext());
            }
            pluginPay = sInstance;
        }
        return pluginPay;
    }

    @Override // defpackage.nyc
    public void setAdapter(PluginBaseAdapter pluginBaseAdapter) {
        super.setAdapter(pluginBaseAdapter);
    }

    @Override // defpackage.nyc
    public void finish() {
        super.finish();
    }

    public boolean isShowPay() {
        return this.mIsShowPay;
    }

    public void setShowPay(boolean z) {
        this.mIsShowPay = z;
    }
}
