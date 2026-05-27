package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w4 f5918a = w4.f;

    public int a(int[] iArr, int i, int[] iArr2) throws a {
        x4 x4Var = new x4(this.f5918a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iA = x4Var.a(this.f5918a.a(i2));
            iArr3[i - i2] = iA;
            if (iA != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        x4 x4VarA = this.f5918a.a();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iA2 = this.f5918a.a((iArr.length - 1) - i3);
                w4 w4Var = this.f5918a;
                x4VarA = x4VarA.b(new x4(w4Var, new int[]{w4Var.d(0, iA2), 1}));
            }
        }
        x4[] x4VarArrA = a(this.f5918a.b(i, 1), new x4(this.f5918a, iArr3), i);
        x4 x4Var2 = x4VarArrA[0];
        x4 x4Var3 = x4VarArrA[1];
        int[] iArrA = a(x4Var2);
        int[] iArrA2 = a(x4Var3, x4Var2, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.f5918a.c(iArrA[i4]);
            if (length >= 0) {
                iArr[length] = this.f5918a.d(iArr[length], iArrA2[i4]);
            } else {
                throw a.a();
            }
        }
        return iArrA.length;
    }

    private int[] a(x4 x4Var) throws a {
        int iA = x4Var.a();
        int[] iArr = new int[iA];
        int i = 0;
        for (int i2 = 1; i2 < this.f5918a.b() && i < iA; i2++) {
            if (x4Var.a(i2) == 0) {
                iArr[i] = this.f5918a.b(i2);
                i++;
            }
        }
        if (i == iA) {
            return iArr;
        }
        throw a.a();
    }

    private int[] a(x4 x4Var, x4 x4Var2, int[] iArr) {
        int iA = x4Var2.a();
        int[] iArr2 = new int[iA];
        for (int i = 1; i <= iA; i++) {
            iArr2[iA - i] = this.f5918a.c(i, x4Var2.b(i));
        }
        x4 x4Var3 = new x4(this.f5918a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iB = this.f5918a.b(iArr[i2]);
            iArr3[i2] = this.f5918a.c(this.f5918a.d(0, x4Var.a(iB)), this.f5918a.b(x4Var3.a(iB)));
        }
        return iArr3;
    }

    private x4[] a(x4 x4Var, x4 x4Var2, int i) throws a {
        if (x4Var.a() < x4Var2.a()) {
            x4Var2 = x4Var;
            x4Var = x4Var2;
        }
        x4 x4VarC = this.f5918a.c();
        x4 x4VarA = this.f5918a.a();
        while (true) {
            x4 x4Var3 = x4Var2;
            x4Var2 = x4Var;
            x4Var = x4Var3;
            x4 x4Var4 = x4VarA;
            x4 x4Var5 = x4VarC;
            x4VarC = x4Var4;
            if (x4Var.a() >= i / 2) {
                if (!x4Var.b()) {
                    x4 x4VarC2 = this.f5918a.c();
                    int iB = this.f5918a.b(x4Var.b(x4Var.a()));
                    while (x4Var2.a() >= x4Var.a() && !x4Var2.b()) {
                        int iA = x4Var2.a() - x4Var.a();
                        int iC = this.f5918a.c(x4Var2.b(x4Var2.a()), iB);
                        x4VarC2 = x4VarC2.a(this.f5918a.b(iA, iC));
                        x4Var2 = x4Var2.c(x4Var.a(iA, iC));
                    }
                    x4VarA = x4VarC2.b(x4VarC).c(x4Var5).c();
                } else {
                    throw a.a();
                }
            } else {
                int iB2 = x4VarC.b(0);
                if (iB2 != 0) {
                    int iB3 = this.f5918a.b(iB2);
                    return new x4[]{x4VarC.c(iB3), x4Var.c(iB3)};
                }
                throw a.a();
            }
        }
    }
}
