package ohos.ace.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes8.dex */
public class DisplayInfo {
    private static final String TAG = "DisplayInfo";
    private static volatile DisplayInfo _sinstance;
    private WindowManager mWindowManager;

    private native void nativeSetupDisplayInfo();

    private DisplayInfo() {
        Log.d(TAG, "DisplayInfo created.");
    }

    public static final DisplayInfo getInstance() {
        if (_sinstance == null) {
            synchronized (DisplayInfo.class) {
                if (_sinstance == null) {
                    _sinstance = new DisplayInfo();
                }
            }
        }
        return _sinstance;
    }

    public void setContext(Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        nativeSetupDisplayInfo();
    }

    public int getDisplayId() {
        Log.d(TAG, "getDisplayId called.");
        return this.mWindowManager.getDefaultDisplay().getDisplayId();
    }

    public int getOrentation() {
        Log.d(TAG, "getOrentation called.");
        return this.mWindowManager.getDefaultDisplay().getRotation();
    }

    public int getWidth() {
        Log.d(TAG, "getWidth called.");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int getHeight() {
        Log.d(TAG, "getHeight called.");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public float getRefreshRate() {
        Log.d(TAG, "getRefreshRate called.");
        return this.mWindowManager.getDefaultDisplay().getRefreshRate();
    }

    public float getDensityPixels() {
        Log.d(TAG, "getDensityPixels called.");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public int getDensityDpi() {
        Log.d(TAG, "getDensityDpi called.");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public float getScaledDensity() {
        Log.d(TAG, "getScaledDensity called.");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.scaledDensity;
    }
}
