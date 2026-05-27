package com.huawei.openalliance.ad.magazine.inter;

import com.huawei.openalliance.ad.hz;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface MagLockAd {
    List<MagLockAdContent> getAdList();

    int getRetCode();

    String getSlotId();

    void setAdList(List<MagLockAdContent> list);

    void setRetCode(int i);

    void setSlotId(String str);

    public static final class Builder {
        public final MagLockAd build() {
            return new hz();
        }
    }
}
