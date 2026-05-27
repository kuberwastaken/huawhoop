package com.huawei.hianalytics;

import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f4020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f42a;

    public abstract void a();

    public abstract void a(Bundle bundle);

    public j0(Handler handler, String str) {
        this.f4020a = handler;
        this.f42a = str;
    }
}
