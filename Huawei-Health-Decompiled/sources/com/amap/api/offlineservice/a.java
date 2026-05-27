package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected OfflineMapActivity f1423a = null;

    public abstract void a(View view);

    public abstract void b();

    public boolean c() {
        return true;
    }

    public abstract RelativeLayout d();

    public abstract void e();

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.f1423a = offlineMapActivity;
    }

    public final void a() {
        this.f1423a.showScr();
    }

    public final int a(float f) {
        return this.f1423a != null ? (int) ((f * (r0.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }
}
