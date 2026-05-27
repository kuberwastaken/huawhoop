package com.huawei.openalliance.ad.magazine.inter.listener;

import com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo;

/* JADX INFO: loaded from: classes11.dex */
public interface MagLockListener {
    void onAdFailed(int i);

    void onAdSuccess(MagLockAdInfo magLockAdInfo);

    void onNoSupport();
}
