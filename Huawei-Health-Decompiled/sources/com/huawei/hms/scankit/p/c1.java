package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.a8;

/* JADX INFO: loaded from: classes10.dex */
final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5939a;
    private final byte[] b;

    private c1(int i, byte[] bArr) {
        this.f5939a = i;
        this.b = bArr;
    }

    byte[] a() {
        return this.b;
    }

    int b() {
        return this.f5939a;
    }

    static c1[] a(byte[] bArr, a8 a8Var, c3 c3Var) {
        if (bArr.length == a8Var.l()) {
            a8.b bVarA = a8Var.a(c3Var);
            a8.a[] aVarArrA = bVarA.a();
            int iA = 0;
            for (a8.a aVar : aVarArrA) {
                iA += aVar.a();
            }
            c1[] c1VarArr = new c1[iA];
            int i = 0;
            for (a8.a aVar2 : aVarArrA) {
                int i2 = 0;
                while (i2 < aVar2.a()) {
                    int iB = aVar2.b();
                    c1VarArr[i] = new c1(iB, new byte[bVarA.b() + iB]);
                    i2++;
                    i++;
                }
            }
            int length = c1VarArr[0].b.length;
            do {
                iA--;
                if (iA < 0) {
                    break;
                }
            } while (c1VarArr[iA].b.length != length);
            int i3 = iA + 1;
            int iB2 = length - bVarA.b();
            int i4 = 0;
            for (int i5 = 0; i5 < iB2; i5++) {
                int i6 = 0;
                while (i6 < i) {
                    c1VarArr[i6].b[i5] = bArr[i4];
                    i6++;
                    i4++;
                }
            }
            int i7 = i3;
            while (i7 < i) {
                c1VarArr[i7].b[iB2] = bArr[i4];
                i7++;
                i4++;
            }
            int length2 = c1VarArr[0].b.length;
            while (iB2 < length2) {
                int i8 = 0;
                while (i8 < i) {
                    c1VarArr[i8].b[i8 < i3 ? iB2 : iB2 + 1] = bArr[i4];
                    i8++;
                    i4++;
                }
                iB2++;
            }
            return c1VarArr;
        }
        throw new IllegalArgumentException();
    }
}
