package com.huawei.hms.activity.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public class BusResponseResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f4443a;
    private int b;

    public int getCode() {
        return this.b;
    }

    public Intent getIntent() {
        return this.f4443a;
    }

    public void setCode(int i) {
        this.b = i;
    }

    public void setIntent(Intent intent) {
        this.f4443a = intent;
    }
}
