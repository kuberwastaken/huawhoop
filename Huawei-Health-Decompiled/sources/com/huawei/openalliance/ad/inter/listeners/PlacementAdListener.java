package com.huawei.openalliance.ad.inter.listeners;

import com.huawei.openalliance.ad.inter.data.IPlacementAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface PlacementAdListener {
    void onAdFailed(int i);

    void onAdsLoaded(Map<String, List<IPlacementAd>> map);
}
