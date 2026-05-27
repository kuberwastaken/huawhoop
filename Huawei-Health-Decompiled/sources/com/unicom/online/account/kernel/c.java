package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11944a;
    public long b;
    public long c;
    public int d;
    public g e;
    public g f;
    public g g;
    public g h;

    public final String toString() {
        return "{ifProtal:" + this.f11944a + ", step1:" + this.e + ", step2:" + this.f + ", step3:" + this.g + ", step4:" + this.h + '}';
    }

    public final void a(g gVar) {
        int i = this.d + 1;
        this.d = i;
        if (i == 1) {
            this.e = gVar;
            return;
        }
        if (i == 2) {
            this.f = gVar;
        } else if (i == 3) {
            this.g = gVar;
        } else {
            if (i != 4) {
                return;
            }
            this.h = gVar;
        }
    }
}
