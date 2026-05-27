package defpackage;

import com.huawei.wearengine.channel.WearEngineChannel;

/* JADX INFO: loaded from: classes8.dex */
public class wrf implements WearEngineChannel {
    private volatile int e = 0;
    private final Object c = new Object();

    @Override // com.huawei.wearengine.channel.WearEngineChannel
    public void updateChannelState(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("state can only be 0 or 1.");
        }
        this.e = i;
    }

    @Override // com.huawei.wearengine.channel.WearEngineChannel
    public void reset() {
        this.e = 0;
    }

    @Override // com.huawei.wearengine.channel.WearEngineChannel
    public int getState() {
        return this.e;
    }

    @Override // com.huawei.wearengine.channel.WearEngineChannel
    public boolean isChannelOpen() {
        return this.e == 0;
    }
}
