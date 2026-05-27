package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l[] f5989a;
    private int b;
    private final int c;
    private final int d;

    j(int i, int i2) {
        this.f5989a = new l[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.f5989a[i3] = new l(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    void b() {
        this.b++;
    }

    l a() {
        int i = this.b;
        if (i >= 0) {
            l[] lVarArr = this.f5989a;
            if (i < lVarArr.length) {
                return lVarArr[i];
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public byte[][] a(int i, int i2) {
        int i3 = this.c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i3, this.d * i);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f5989a[i4 / i2].a(i);
        }
        return bArr;
    }
}
