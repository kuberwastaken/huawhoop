package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.magazine.inter.MagLockAd;
import com.huawei.openalliance.ad.magazine.inter.MagLockAdContent;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class hz implements MagLockAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7181a;
    private String b;
    private List<MagLockAdContent> c;

    public String toString() {
        return "MagLockAdImpl [slotId=" + this.b + ", contentList=" + this.c + ", code=" + this.f7181a + "]";
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public void setSlotId(String str) {
        this.b = str;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public void setRetCode(int i) {
        this.f7181a = i;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public void setAdList(List<MagLockAdContent> list) {
        this.c = list;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public String getSlotId() {
        return this.b;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public int getRetCode() {
        return this.f7181a;
    }

    @Override // com.huawei.openalliance.ad.magazine.inter.MagLockAd
    public List<MagLockAdContent> getAdList() {
        return this.c;
    }
}
