package com.huawei.policy;

import defpackage.mxm;
import defpackage.vsa;

/* JADX INFO: loaded from: classes7.dex */
public interface MedalSyncPolicy {
    void onLaunchPageStart(mxm mxmVar);

    void onLightMedalListStart(mxm mxmVar);

    void onLightMedalMessageListStart(mxm mxmVar);

    void onLightMedalStart(mxm mxmVar);

    void onSyncMedalsStart(mxm mxmVar);

    void receiveFromDevice(int i, vsa vsaVar);
}
