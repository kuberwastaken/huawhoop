package com.huawei.hms.update.ui;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigChangeHolder {
    private static volatile ConfigChangeHolder b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6271a = false;

    private ConfigChangeHolder() {
    }

    public static ConfigChangeHolder getInstance() {
        if (b == null) {
            synchronized (ConfigChangeHolder.class) {
                if (b == null) {
                    b = new ConfigChangeHolder();
                }
            }
        }
        return b;
    }

    public boolean isChanged() {
        return this.f6271a;
    }

    public void setChanged(boolean z) {
        this.f6271a = z;
    }
}
