package com.huawei.hms.scankit.p;

import com.google.common.primitives.UnsignedBytes;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6039a;
    private final int b;

    public abstract p4 a(int i, int i2, int i3, int i4);

    public abstract byte[] a(int i, byte[] bArr);

    public abstract byte[] b();

    protected p4(int i, int i2) {
        this.f6039a = i;
        this.b = i2;
    }

    public final int c() {
        return this.f6039a;
    }

    public final int a() {
        return this.b;
    }

    public final String toString() {
        int i = this.f6039a;
        byte[] bArrA = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrA = a(i2, bArrA);
            for (int i3 = 0; i3 < this.f6039a; i3++) {
                int i4 = bArrA[i3] & UnsignedBytes.MAX_VALUE;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? FilenameUtils.EXTENSION_SEPARATOR : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
