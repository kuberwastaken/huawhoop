package ohos.ace.adapter.capability.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class ClipboardAosp extends ClipboardPluginBase {
    private static final String LOG_TAG = "ClipboardPlugin";
    private ClipboardManager clipManager;
    private Context context;

    public ClipboardAosp(Context context) {
        this.context = context;
        nativeInit();
    }

    private void initClipManager() {
        Context context = this.context;
        if (context != null) {
            Object systemService = context.getSystemService("clipboard");
            if (systemService instanceof ClipboardManager) {
                this.clipManager = (ClipboardManager) systemService;
                return;
            } else {
                ALog.e(LOG_TAG, "unable to get clipboard service");
                this.clipManager = null;
                return;
            }
        }
        ALog.e(LOG_TAG, "context is null");
        this.clipManager = null;
    }

    @Override // ohos.ace.adapter.capability.clipboard.ClipboardPluginBase
    public String getData() {
        if (this.clipManager == null) {
            initClipManager();
        }
        ClipboardManager clipboardManager = this.clipManager;
        if (clipboardManager == null) {
            return "";
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        CharSequence text = (primaryClip == null || primaryClip.getItemCount() <= 0) ? null : primaryClip.getItemAt(0).getText();
        return text != null ? text.toString() : "";
    }

    @Override // ohos.ace.adapter.capability.clipboard.ClipboardPluginBase
    public void setData(String str) {
        if (this.clipManager == null) {
            initClipManager();
        }
        if (this.clipManager != null) {
            this.clipManager.setPrimaryClip(ClipData.newPlainText(null, str));
        }
    }

    @Override // ohos.ace.adapter.capability.clipboard.ClipboardPluginBase
    public boolean hasData() {
        if (this.clipManager == null) {
            initClipManager();
        }
        ClipboardManager clipboardManager = this.clipManager;
        if (clipboardManager != null) {
            return clipboardManager.hasPrimaryClip();
        }
        return false;
    }

    @Override // ohos.ace.adapter.capability.clipboard.ClipboardPluginBase
    public void clear() {
        if (this.clipManager == null) {
            initClipManager();
        }
        ClipboardManager clipboardManager = this.clipManager;
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, null));
        }
    }
}
