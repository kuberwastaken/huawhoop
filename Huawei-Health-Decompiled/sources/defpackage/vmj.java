package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.mlsdk.asr.MLAsrConstants;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class vmj {
    public static boolean c(Context context) {
        return context != null && d(context) && e(context);
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return MLAsrConstants.LAN_ZH.equals(context.getResources().getConfiguration().locale.getLanguage());
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        String country = context.getResources().getConfiguration().locale.getCountry();
        return "CN".equals(country) || "HK".equals(country) || "MO".equals(country) || "TW".equals(country);
    }

    public static boolean evC_(View view) {
        return view != null && view.getLayoutDirection() == 1;
    }

    public static boolean evD_(View view) {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || view == null) {
            return false;
        }
        return (language.contains("ar") || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG)) || evC_(view);
    }
}
