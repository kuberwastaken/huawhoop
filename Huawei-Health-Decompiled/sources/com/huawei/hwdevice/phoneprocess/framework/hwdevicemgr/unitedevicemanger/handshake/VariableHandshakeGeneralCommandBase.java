package com.huawei.hwdevice.phoneprocess.framework.hwdevicemgr.unitedevicemanger.handshake;

import com.huawei.unitedevice.entity.UniteDevice;
import defpackage.ced;

/* JADX INFO: loaded from: classes6.dex */
public abstract class VariableHandshakeGeneralCommandBase {
    protected String mCurrentCommandTag;
    protected VariableHandshakeGeneralCommandBase mNextVariableHandshakeCommand;

    public abstract int constructCommandMessage(ced cedVar);

    public abstract String getCurrentCommandTag();

    public abstract int processReceivedData(UniteDevice uniteDevice, String str);

    public VariableHandshakeGeneralCommandBase getNextCommand() {
        return this.mNextVariableHandshakeCommand;
    }
}
