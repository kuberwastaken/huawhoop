package defpackage;

import androidx.core.os.TraceCompat;

/* JADX INFO: loaded from: classes3.dex */
public class jc {
    private final String[] e = new String[5];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f14386a = new long[5];
    private int b = 0;
    private int c = 0;

    public void d(String str) {
        int i = this.b;
        if (i == 5) {
            this.c++;
            return;
        }
        this.e[i] = str;
        this.f14386a[i] = System.nanoTime();
        TraceCompat.beginSection(str);
        this.b++;
    }

    public float e(String str) {
        int i = this.c;
        if (i > 0) {
            this.c = i - 1;
            return 0.0f;
        }
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(this.e[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.e[this.b] + ".");
        }
        TraceCompat.endSection();
        return (System.nanoTime() - this.f14386a[this.b]) / 1000000.0f;
    }
}
