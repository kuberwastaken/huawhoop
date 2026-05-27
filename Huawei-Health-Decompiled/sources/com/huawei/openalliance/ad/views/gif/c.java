package com.huawei.openalliance.ad.views.gif;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes6.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8368a;
    Bitmap b;
    int c;

    public String toString() {
        return "GifFrame{frameIndex=" + this.f8368a + ", delay=" + this.c + '}';
    }

    c a() {
        c cVar = new c();
        cVar.f8368a = this.f8368a;
        cVar.c = this.c;
        return cVar;
    }

    c(int i, Bitmap bitmap, int i2) {
        this.f8368a = i;
        this.b = bitmap;
        this.c = i2;
    }

    c() {
    }
}
