package com.huawei.maps.offlinedata.utils;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f6765a = new HashMap<String, String>() { // from class: com.huawei.maps.offlinedata.utils.f.1
        {
            put("iw", "he");
            put("in", "id");
            put("fil", "tl");
        }
    };

    public static String a(String str) {
        Map<String, String> map = f6765a;
        return map.containsKey(str) ? map.get(str) : str;
    }

    public static String a() {
        Locale locale = Locale.getDefault();
        String strA = a(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getScript())) {
            strA = strA + Constants.LINK + locale.getScript();
        }
        g.a("LanguageUtil", "systemLanguage is: " + strA);
        return strA;
    }
}
