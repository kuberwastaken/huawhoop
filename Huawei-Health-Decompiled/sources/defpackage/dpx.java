package defpackage;

import com.huawei.health.ecologydevice.connectivity.ScanFilter;

/* JADX INFO: loaded from: classes4.dex */
public class dpx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScanFilter f12352a;
    private String b;
    private int[] d;
    private String e;

    public String e() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public ScanFilter d() {
        return this.f12352a;
    }

    public void d(ScanFilter scanFilter) {
        this.f12352a = scanFilter;
    }

    public String a() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public int[] c() {
        int[] iArr = this.d;
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public void e(int[] iArr) {
        if (iArr != null) {
            this.d = (int[]) iArr.clone();
        }
    }
}
