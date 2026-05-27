package com.huawei.agconnect.common.aaid;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.AAID;
import com.huawei.agconnect.common.api.AgcCrypto;
import com.huawei.agconnect.datastore.annotation.SharedPreference;

/* JADX INFO: loaded from: classes10.dex */
public class AAIDImpl implements AAID {

    @SharedPreference(crypto = AgcCrypto.class, fileName = "com.huawei.agconnect", key = AaidUtils.f1731a)
    String aaidString;

    @Override // com.huawei.agconnect.common.api.AAID
    public String getId() {
        if (!TextUtils.isEmpty(this.aaidString)) {
            return this.aaidString;
        }
        AAIDImplPreference.b().a(this);
        if (!TextUtils.isEmpty(this.aaidString)) {
            return this.aaidString;
        }
        Context context = AGConnectInstance.getInstance().getContext();
        this.aaidString = AaidUtils.b(context.getPackageName() + AaidUtils.a(context));
        AAIDImplPreference.b().c(this);
        return this.aaidString;
    }
}
