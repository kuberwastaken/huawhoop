package com.huawei.devicesdk.connect.handshake;

import com.huawei.devicesdk.entity.DeviceInfo;
import defpackage.ced;
import defpackage.cel;
import defpackage.cem;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HandshakeCommandBase {
    private static final String TAG = "HandshakeCommandBase";
    protected HandshakeCommandBase mNextCommand;

    public abstract ced getDeviceCommand(DeviceInfo deviceInfo);

    public abstract String getTag();

    public abstract cel processReceivedData(DeviceInfo deviceInfo, cem cemVar);

    HandshakeCommandBase() {
    }

    public HandshakeCommandBase getNextCommand() {
        return this.mNextCommand;
    }
}
