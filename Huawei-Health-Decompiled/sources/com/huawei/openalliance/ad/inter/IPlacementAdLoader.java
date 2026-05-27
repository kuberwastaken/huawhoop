package com.huawei.openalliance.ad.inter;

import com.huawei.openalliance.ad.inter.listeners.PlacementAdListener;

/* JADX INFO: loaded from: classes6.dex */
public interface IPlacementAdLoader {
    void loadAds(PlacementAdListener placementAdListener);

    void loadAds(PlacementAdListener placementAdListener, int i);

    void loadAds(PlacementAdListener placementAdListener, int i, int i2);

    void preLoadAds();

    void startCache(int i);

    void stopCache();
}
