package com.huawei.hianalytics.visual;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f4099a;
    public final String b;

    public z(Activity activity, String str) {
        this.f4099a = new WeakReference<>(activity);
        this.b = str;
    }

    public Activity a() {
        return this.f4099a.get();
    }
}
