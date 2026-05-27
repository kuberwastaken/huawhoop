package com.huawei.health.main.api;

import android.content.Context;
import com.huawei.health.main.model.AppLangItem;
import defpackage.fhr;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CloudAuthApi {
    void constructInstance(Context context, String str);

    List<AppLangItem> getAppLangItem(String str, String str2, String str3);

    String getAppLangItemUrl(String str, String str2);

    String getLang();

    fhr getScopeLangItem(String str, String str2, String str3);

    String getScopeLangItemUrl(String str, String str2);
}
