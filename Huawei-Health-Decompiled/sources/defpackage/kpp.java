package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class kpp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f14825a;
    private int b;
    private int c;
    private int d;
    private int e;

    public void c(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void e(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void d(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void d(byte[] bArr) {
        if (bArr != null) {
            this.f14825a = (byte[]) kqt.e(Arrays.copyOf(bArr, bArr.length));
        }
    }
}
