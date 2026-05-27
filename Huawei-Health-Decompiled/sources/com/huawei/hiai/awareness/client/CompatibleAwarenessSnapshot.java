package com.huawei.hiai.awareness.client;

import android.os.Bundle;

/* JADX INFO: loaded from: classes10.dex */
public class CompatibleAwarenessSnapshot {
    private Bundle bundle;
    private String callerPackageName = "";
    private boolean isCustom;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean isCustom() {
        return this.isCustom;
    }

    public void setCustom(boolean z) {
        this.isCustom = z;
    }

    public String getCallerPackageName() {
        return this.callerPackageName;
    }

    public void setCallerPackageName(String str) {
        this.callerPackageName = str;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
