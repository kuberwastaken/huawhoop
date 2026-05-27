package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes10.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6001a;
    private Rect b;

    public k0(int i, Rect rect) {
        this.f6001a = i;
        this.b = new Rect(rect);
    }

    public int a() {
        return this.f6001a;
    }

    public Rect b() {
        return this.b;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f6002a;
        public int b;

        public a(Rect rect, int i) {
            this.f6002a = rect;
            this.b = i;
        }
    }
}
