package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class s implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6058a;
    private final int b;
    private final int c;
    private final int[] d;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public s m917clone() {
        return new s(this.f6058a, this.b, this.c, (int[]) this.d.clone());
    }

    public s(int i) {
        this(i, i);
    }

    public s(int i, int i2) {
        if (i >= 1 && i2 >= 1) {
            this.f6058a = i;
            this.b = i2;
            int i3 = (i + 31) / 32;
            this.c = i3;
            this.d = new int[i3 * i2];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public boolean b(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        return w7.a(this.d, i3) && ((this.d[i3] >>> (i & 31)) & 1) != 0;
    }

    public s(int i, int i2, int i3, int[] iArr) {
        this.f6058a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public void e() {
        int iD = d();
        int iB = b();
        r rVar = new r(iD);
        r rVar2 = new r(iD);
        for (int i = 0; i < (iB + 1) / 2; i++) {
            rVar = a(i, rVar);
            int i2 = (iB - 1) - i;
            rVar2 = a(i2, rVar2);
            rVar.g();
            rVar2.g();
            b(i, rVar2);
            b(i2, rVar);
        }
    }

    public int d() {
        return this.f6058a;
    }

    public void a(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (w7.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f6058a == sVar.f6058a && this.b == sVar.b && this.c == sVar.c && Arrays.equals(this.d, sVar.d);
    }

    public int hashCode() {
        int i = this.f6058a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public s c() {
        int[] iArr = new int[this.d.length];
        int i = 0;
        while (true) {
            int[] iArr2 = this.d;
            if (i < iArr2.length) {
                iArr[i] = ~iArr2[i];
                i++;
            } else {
                return new s(this.f6058a, this.b, this.c, iArr);
            }
        }
    }

    public int b() {
        return this.b;
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (w7.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) | iArr[i3];
        }
    }

    public r a(int i, r rVar) {
        if (rVar != null && rVar.d() >= this.f6058a) {
            rVar.a();
        } else {
            rVar = new r(this.f6058a);
        }
        int i2 = this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            rVar.b(i3 * 32, this.d[(i * i2) + i3]);
        }
        return rVar;
    }

    public void b(int i, r rVar) {
        int[] iArrC = rVar.c();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(iArrC, 0, iArr, i * i2, i2);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 >= 1 && i3 >= 1) {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.b || i5 > this.f6058a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + (i7 * i2);
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.f6058a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.f6058a; i2++) {
                sb.append(b(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
