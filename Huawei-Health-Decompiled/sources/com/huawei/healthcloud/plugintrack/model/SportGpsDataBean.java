package com.huawei.healthcloud.plugintrack.model;

/* JADX INFO: loaded from: classes10.dex */
public class SportGpsDataBean {
    private GpsSourcesState e = GpsSourcesState.CONTINUE;

    public enum GpsSourcesState {
        RECOVERY,
        RESUME,
        CONTINUE,
        IDLE
    }
}
