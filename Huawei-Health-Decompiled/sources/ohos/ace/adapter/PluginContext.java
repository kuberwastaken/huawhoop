package ohos.ace.adapter;

import android.content.Context;
import java.io.File;
import ohos.ace.adapter.capability.bridge.BridgeManager;

/* JADX INFO: loaded from: classes8.dex */
public class PluginContext {
    private BridgeManager bridgeManager;
    private Context context;
    private String moduleName;

    public PluginContext(Context context, BridgeManager bridgeManager, String str) {
        this.context = context;
        this.bridgeManager = bridgeManager;
        this.moduleName = str;
    }

    public Context getContext() {
        return this.context;
    }

    public BridgeManager getBridgeManager() {
        return this.bridgeManager;
    }

    public String getRawFilePath(String str, String str2) {
        String str3 = this.context.getFilesDir().getAbsolutePath() + "/arkui-x/" + str + "/resources/rawfile/" + str2;
        if (new File(str3).exists()) {
            return str3;
        }
        return null;
    }

    public String getRawFilePath(String str) {
        return getRawFilePath(this.moduleName, str);
    }
}
