package ohos.ace.adapter;

/* JADX INFO: loaded from: classes11.dex */
public class AppModeConfig {
    private static native void nativeInitAppMode();

    private AppModeConfig() {
    }

    public static void initAppMode() {
        nativeInitAppMode();
    }
}
