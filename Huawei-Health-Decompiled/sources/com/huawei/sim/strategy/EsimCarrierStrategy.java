package com.huawei.sim.strategy;

import android.content.Context;
import android.os.Handler;
import defpackage.otk;

/* JADX INFO: loaded from: classes7.dex */
public interface EsimCarrierStrategy {
    void activateEsim();

    void authenticate();

    void deactivateEsim();

    void getEsimStatus();

    void init(Context context, Handler handler);

    void setRequest(otk otkVar);
}
