package com.huawei.wearengine.channel;

/* JADX INFO: loaded from: classes8.dex */
public interface WearEngineChannel {
    public static final int CHANNEL_CLOSE = 1;
    public static final int CHANNEL_OPEN = 0;

    int getState();

    boolean isChannelOpen();

    void reset();

    void updateChannelState(int i);
}
