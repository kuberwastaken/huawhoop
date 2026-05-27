package ohos.ace.adapter.capability.environment;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes11.dex */
public class EnvironmentAosp extends EnvironmentBase {
    private static final String LOG_TAG = "EnvironmentAosp";
    private Context context;

    public EnvironmentAosp(Context context) {
        this.context = context;
        nativeInit();
    }

    @Override // ohos.ace.adapter.capability.environment.EnvironmentBase
    public String getAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        return (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) ? "true" : "false";
    }
}
