package ohos.ace.adapter.capability.plugin;

import android.content.Context;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class PluginManager {
    private static final String LOG_TAG = "Ace_PluginManager";
    private Context context;

    private native void nativeInit();

    private native void nativeRegister(long j, String str);

    public PluginManager(Context context) {
        this.context = context;
        nativeInit();
    }

    public void registerPlugin(long j, String str) {
        nativeRegister(j, str);
    }

    public void initPlugin(String str) {
        try {
            ALog.d(LOG_TAG, "init plugin: " + str);
            Class.forName(str).getConstructor(Context.class).newInstance(this.context);
        } catch (Exception e) {
            ALog.e(LOG_TAG, "init plugin failed: " + e);
        }
    }
}
