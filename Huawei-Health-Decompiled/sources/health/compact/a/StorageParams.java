package health.compact.a;

import defpackage.kqt;

/* JADX INFO: loaded from: classes.dex */
public class StorageParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13780a;
    private int b;

    public StorageParams() {
        this.f13780a = 0;
        this.b = 0;
    }

    public StorageParams(int i) {
        this.f13780a = 0;
        this.b = i;
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public void e(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
