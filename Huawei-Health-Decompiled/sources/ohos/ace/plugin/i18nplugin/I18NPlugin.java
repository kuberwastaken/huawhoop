package ohos.ace.plugin.i18nplugin;

import android.content.Context;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class I18NPlugin {
    private static final String LOG_TAG = "I18NPlugin";
    private Context mContext;

    protected native void nativeInit();

    public I18NPlugin(Context context) {
        this.mContext = context;
        nativeInit();
    }

    public boolean is24HourClock() {
        Context context = this.mContext;
        if (context == null) {
            Log.w(LOG_TAG, "I18NPlugin: context not registered");
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

    public String getSystemLanguage() {
        Locale locale = LocaleList.getDefault().get(0);
        if (locale == null) {
            return "";
        }
        String str = "" + locale.getLanguage();
        if (locale.getScript().length() <= 0) {
            return str;
        }
        return str + Constants.LINK + locale.getScript();
    }

    public String getSystemRegion() {
        Locale locale = LocaleList.getDefault().get(0);
        return locale == null ? "" : locale.getCountry();
    }

    public String getSystemTimezone() {
        return TimeZone.getDefault().getID();
    }
}
