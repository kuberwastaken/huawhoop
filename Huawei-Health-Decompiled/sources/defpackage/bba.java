package defpackage;

import android.text.TextUtils;
import com.huawei.hms.mlsdk.asr.MLAsrConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class bba {
    private static int e = -1;

    public static boolean b() {
        if (e == -1) {
            e = (MLAsrConstants.LAN_ZH.equals(bbb.b("ro.product.locale.language")) && "CN".equals(bbb.b("ro.product.locale.region"))) ? 0 : 1;
        }
        return e == 1;
    }

    public static String c() {
        StringBuilder sb;
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        String script = locale.getScript();
        if (TextUtils.isEmpty(script) && TextUtils.isEmpty(variant)) {
            sb = new StringBuilder();
            sb.append(language);
            sb.append("_");
            sb.append(country);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(language);
            sb2.append("_");
            sb2.append(script);
            sb2.append("_");
            sb2.append(country);
            sb2.append("_");
            sb2.append(variant);
            sb = sb2;
        }
        return sb.toString();
    }
}
