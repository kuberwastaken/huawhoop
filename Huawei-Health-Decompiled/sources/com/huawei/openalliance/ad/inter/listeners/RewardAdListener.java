package com.huawei.openalliance.ad.inter.listeners;

import com.huawei.openalliance.ad.inter.data.IRewardAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface RewardAdListener {
    void onAdFailed(int i);

    void onAdsLoaded(Map<String, List<IRewardAd>> map);
}
