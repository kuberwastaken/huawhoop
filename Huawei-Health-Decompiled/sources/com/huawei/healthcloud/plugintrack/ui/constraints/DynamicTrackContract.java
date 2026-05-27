package com.huawei.healthcloud.plugintrack.ui.constraints;

import androidx.lifecycle.LifecycleObserver;

/* JADX INFO: loaded from: classes5.dex */
public interface DynamicTrackContract {

    /* JADX INFO: loaded from: classes.dex */
    public interface Ipresenter<T extends Iview> extends LifecycleObserver {
        void judgeVipStatus();

        void switchPremiumEdition(boolean z);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface Iview {
        void judgeVipResult(boolean z);
    }
}
