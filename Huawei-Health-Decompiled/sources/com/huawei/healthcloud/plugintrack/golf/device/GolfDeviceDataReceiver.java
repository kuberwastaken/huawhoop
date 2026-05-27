package com.huawei.healthcloud.plugintrack.golf.device;

/* JADX INFO: loaded from: classes10.dex */
public class GolfDeviceDataReceiver implements GolfDataReceiver {
    private int mMsgId;

    @Override // com.huawei.healthcloud.plugintrack.golf.device.GolfDataReceiver
    public void onDataReceived(GolfMsgHeader golfMsgHeader, int i, byte[] bArr) {
    }

    public GolfDeviceDataReceiver(int i) {
        this.mMsgId = i;
    }

    @Override // com.huawei.healthcloud.plugintrack.golf.device.GolfDataReceiver
    public boolean isMatch(int i) {
        return this.mMsgId == i;
    }
}
