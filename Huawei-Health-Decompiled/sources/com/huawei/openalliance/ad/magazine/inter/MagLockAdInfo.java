package com.huawei.openalliance.ad.magazine.inter;

import com.huawei.openalliance.ad.ia;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface MagLockAdInfo {
    List<MagLockAd> getMultiAds();

    int getRetCode();

    void setMultiAds(List<MagLockAd> list);

    void setRetCode(int i);

    public static final class Builder {
        public final MagLockAdInfo build() {
            return new ia();
        }
    }
}
