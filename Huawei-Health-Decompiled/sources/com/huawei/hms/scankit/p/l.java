package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes5.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6006a;
    private int b = 0;

    l(int i) {
        this.f6006a = new byte[i];
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    byte[] a(int i) {
        int length = this.f6006a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f6006a[i2 / i];
        }
        return bArr;
    }

    private void a(int i, boolean z) {
        if (w7.a(this.f6006a, i)) {
            this.f6006a[i] = z ? (byte) 1 : (byte) 0;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
