package ohos.ace.adapter.capability.vibrator;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class VibratorAosp extends VibratorPluginBase {
    private static final String LOG_TAG = "Ace_Vibrator";
    private final Vibrator vibrator;

    @Override // ohos.ace.adapter.capability.vibrator.VibratorPluginBase
    public void vibrate(String str) {
    }

    public VibratorAosp(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("vibrator");
            if (systemService instanceof Vibrator) {
                this.vibrator = (Vibrator) systemService;
            } else {
                ALog.e(LOG_TAG, "Unable to get VIBRATOR_SERVICE");
                this.vibrator = null;
            }
        } else {
            ALog.e(LOG_TAG, "VibratorPluginAosp context is null");
            this.vibrator = null;
        }
        nativeInit();
    }

    @Override // ohos.ace.adapter.capability.vibrator.VibratorPluginBase
    public void vibrate(int i) {
        try {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                vibrator.vibrate(VibrationEffect.createOneShot(i, -1));
            }
        } catch (SecurityException unused) {
            ALog.e(LOG_TAG, "Has no vibrate permission");
        }
    }
}
