package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.magazine.inter.MagLockAd;
import com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class ia implements MagLockAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7183a;
    private List<MagLockAd> b;

    public String toString() {
        return "MagLockAdInfoImpl [multiAds=" + this.b + ", code=" + this.f7183a + "]";
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo
    public void setRetCode(int i) {
        this.f7183a = i;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo
    public void setMultiAds(List<MagLockAd> list) {
        this.b = list;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo
    public int getRetCode() {
        return this.f7183a;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAdInfo
    public List<MagLockAd> getMultiAds() {
        return this.b;
    }
}
