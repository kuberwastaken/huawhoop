package com.huawei.multisimsdk.multidevicemanager.common;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsPrimaryDevice {
    private static final int MULTI_SIM = 0;

    public abstract String getCompanionTerminalService();

    public abstract String getPrimaryID();

    public abstract int getPrimaryIDType();

    public int getService() {
        return 0;
    }

    public abstract String getTerminalId();

    public abstract String getTerminalModel();

    public abstract String getTerminalSwVersion();

    public abstract String getTerminalVendor();
}
