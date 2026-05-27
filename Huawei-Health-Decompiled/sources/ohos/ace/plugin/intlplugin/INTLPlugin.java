package ohos.ace.plugin.intlplugin;

import android.content.Context;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class INTLPlugin {
    private static final String DEVICE_TYPE_PHONES = "phones";
    private static final String DEVICE_TYPE_TABLET = "tablet";
    private static final String LOG_TAG = "INTLPlugin";
    private static final int SQUARE = 2;
    private static final int THRESHOLD_DP = 600;
    private static final double THRESHOLD_INCH = 6.9d;
    private Context mContext;

    protected native void nativeInit();

    public INTLPlugin(Context context) {
        this.mContext = context;
        nativeInit();
    }

    public boolean is24HourClock() {
        Context context = this.mContext;
        if (context == null) {
            Log.w(LOG_TAG, "INTLPlugin: context not registered");
            return true;
        }
        return DateFormat.is24HourFormat(context);
    }

    public String getSystemLocale() {
        Locale locale = LocaleList.getDefault().get(0);
        if (locale == null) {
            return "";
        }
        String str = "" + locale.getLanguage();
        if (locale.getScript().length() > 0) {
            str = str + Constants.LINK + locale.getScript();
        }
        if (locale.getCountry().length() <= 0) {
            return str;
        }
        return str + Constants.LINK + locale.getCountry();
    }

    public String getSystemTimezone() {
        return TimeZone.getDefault().getID();
    }

    public String getDeviceType() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources().getConfiguration().smallestScreenWidthDp >= 600 ? DEVICE_TYPE_TABLET : getDeviceTypeByPhysicalSize();
        }
        Log.e(LOG_TAG, "The mContext is null, getDeviceType failed.");
        return DEVICE_TYPE_PHONES;
    }

    private String getDeviceTypeByPhysicalSize() {
        Context context = this.mContext;
        if (context == null) {
            Log.e(LOG_TAG, "The mContext is null, getDeviceTypeByPhysicalSize failed.");
            return DEVICE_TYPE_PHONES;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager == null) {
            Log.e(LOG_TAG, "The mContext is null, getDeviceTypeByPhysicalSize failed.");
            return DEVICE_TYPE_PHONES;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            Log.e(LOG_TAG, "The display is null, getDeviceTypeByPhysicalSize failed.");
            return DEVICE_TYPE_PHONES;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= THRESHOLD_INCH ? DEVICE_TYPE_TABLET : DEVICE_TYPE_PHONES;
    }
}
