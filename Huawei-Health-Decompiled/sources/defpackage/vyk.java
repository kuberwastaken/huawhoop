package defpackage;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.wear.oversea.util.PropertyUtil;
import com.huawei.wear.oversea.util.SystemPropertyValues;

/* JADX INFO: loaded from: classes8.dex */
public class vyk {
    public static String a() {
        int i;
        String prop = PropertyUtil.getProp("ro.product.locale.region");
        vwc.b("FetchCountryCodeHelp", "ro.product.locale.region region=" + prop, false);
        if (!TextUtils.isEmpty(prop)) {
            return prop;
        }
        String prop2 = PropertyUtil.getProp(SystemPropertyValues.PROP_LOCALE_KEY);
        vwc.b("FetchCountryCodeHelp", "ro.product.locale region=" + prop2, false);
        if (!TextUtils.isEmpty(prop2) && prop2.contains("CN")) {
            return "CN";
        }
        int iLastIndexOf = prop2.lastIndexOf(Constants.LINK);
        if (iLastIndexOf >= 0 && (i = iLastIndexOf + 1) < prop2.length()) {
            prop2 = prop2.substring(i);
        }
        TextUtils.isEmpty(prop2);
        return prop2;
    }
}
