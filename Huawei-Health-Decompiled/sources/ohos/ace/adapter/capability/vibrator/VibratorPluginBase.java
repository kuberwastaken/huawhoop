package ohos.ace.adapter.capability.vibrator;

/* JADX INFO: loaded from: classes11.dex */
public abstract class VibratorPluginBase {
    protected native void nativeInit();

    public abstract void vibrate(int i);

    public abstract void vibrate(String str);
}
