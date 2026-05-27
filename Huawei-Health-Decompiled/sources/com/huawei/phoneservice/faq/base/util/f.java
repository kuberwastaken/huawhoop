package com.huawei.phoneservice.faq.base.util;

import android.content.res.Resources;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    public static String e() {
        return Resources.getSystem().getConfiguration().getLocales().get(0).getCountry();
    }

    public static String d() {
        return b() + Constants.LINK + e().toLowerCase(Locale.ENGLISH);
    }

    public static String b() {
        return Resources.getSystem().getConfiguration().getLocales().get(0).getLanguage();
    }
}
