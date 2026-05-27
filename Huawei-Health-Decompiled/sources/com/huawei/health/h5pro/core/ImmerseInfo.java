package com.huawei.health.h5pro.core;

/* JADX INFO: loaded from: classes4.dex */
public class ImmerseInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2427a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;

    public boolean isStatusBarTextBlack() {
        return this.b;
    }

    public boolean isStartAtBottomOfStatusBar() {
        return this.d;
    }

    public boolean isShowStatusBar() {
        return this.c;
    }

    public boolean isImmerse() {
        return this.e;
    }

    public boolean isHideBottomVirtualKeys() {
        return this.f2427a;
    }

    public ImmerseInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.e = z;
        this.c = z2;
        this.b = z3;
        this.d = z4;
        this.f2427a = z5;
    }
}
