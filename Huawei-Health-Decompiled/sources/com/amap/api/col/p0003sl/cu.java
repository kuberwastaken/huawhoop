package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f881a;
    private b b;
    private b c;

    public static final class a extends ct {
    }

    public static final class b extends ct {
    }

    public final void a() {
        synchronized (this) {
            a aVar = this.f881a;
            if (aVar != null) {
                aVar.a();
                this.f881a = null;
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.a();
                this.b = null;
            }
            b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a();
                this.c = null;
            }
        }
    }
}
