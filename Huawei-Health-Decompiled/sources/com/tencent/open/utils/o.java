package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11919a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public o(byte[] bArr, int i) {
        this.f11919a = ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    public o(int i) {
        this.f11919a = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.f11919a == ((o) obj).b();
    }

    public byte[] a() {
        int i = this.f11919a;
        return new byte[]{(byte) (i & 255), (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f11919a;
    }

    public int hashCode() {
        return this.f11919a;
    }
}
