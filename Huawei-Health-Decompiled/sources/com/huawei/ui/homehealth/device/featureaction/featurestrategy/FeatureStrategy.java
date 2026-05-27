package com.huawei.ui.homehealth.device.featureaction.featurestrategy;

import android.os.Bundle;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import com.huawei.hwcommonmodel.utils.SimpleChain;

/* JADX INFO: loaded from: classes7.dex */
public interface FeatureStrategy {
    default boolean jumpToFeaturePage(DeviceInfo deviceInfo, Bundle bundle, SimpleChain.Emitter emitter) {
        return false;
    }

    boolean jumpToFeaturePage(DeviceInfo deviceInfo, SimpleChain.Emitter emitter);
}
