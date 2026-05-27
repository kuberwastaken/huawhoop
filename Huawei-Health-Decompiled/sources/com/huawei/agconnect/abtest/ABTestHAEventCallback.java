package com.huawei.agconnect.abtest;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.abtest.internal.ABTestHAEventCallbackImpl;
import com.huawei.agconnect.common.api.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class ABTestHAEventCallback {
    private ABTestHAEventCallbackImpl impl = new ABTestHAEventCallbackImpl();

    public void onEvent(String str, Bundle bundle, Bundle bundle2) {
        Logger.d("ABTest", "abtest ha event :" + str);
        this.impl.a(str, bundle, bundle2);
    }

    public void initialize(Context context) {
        this.impl.a(context);
    }
}
