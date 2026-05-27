package com.huawei.hianalytics.framework.listener;

/* JADX INFO: loaded from: classes5.dex */
public class HAEventManager {
    public static final HAEventManager b = new HAEventManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IHAEventListener f4008a;

    public void setEventListener(IHAEventListener iHAEventListener) {
        this.f4008a = iHAEventListener;
    }

    public IHAEventListener getEventListener() {
        return this.f4008a;
    }

    public static HAEventManager getInstance() {
        return b;
    }
}
