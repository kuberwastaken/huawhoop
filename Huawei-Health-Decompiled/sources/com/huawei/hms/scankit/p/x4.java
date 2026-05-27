package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w4 f6106a;
    private final int[] b;

    x4(w4 w4Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f6106a = w4Var;
            int length = iArr.length;
            int i = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i < length && iArr[i] == 0) {
                    i++;
                }
                if (i == length) {
                    this.b = new int[]{0};
                    return;
                }
                int i2 = length - i;
                int[] iArr2 = new int[i2];
                this.b = iArr2;
                System.arraycopy(iArr, i, iArr2, 0, i2);
                return;
            }
            this.b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    int b(int i) {
        return this.b[(r0.length - 1) - i];
    }

    x4 a(x4 x4Var) {
        if (this.f6106a.equals(x4Var.f6106a)) {
            if (b()) {
                return x4Var;
            }
            if (x4Var.b()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = x4Var.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = this.f6106a.a(iArr2[i - length], iArr[i]);
            }
            return new x4(this.f6106a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    boolean b() {
        return this.b[0] == 0;
    }

    x4 c(int i) {
        if (i == 0) {
            return this.f6106a.c();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f6106a.c(this.b[i2], i);
        }
        return new x4(this.f6106a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int iA = a(); iA >= 0; iA--) {
            int iB = b(iA);
            if (iB != 0) {
                if (iB < 0) {
                    sb.append(" - ");
                    iB = -iB;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iA == 0 || iB != 1) {
                    sb.append(iB);
                }
                if (iA != 0) {
                    if (iA == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iA);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = this.f6106a.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            w4 w4Var = this.f6106a;
            iA2 = w4Var.a(w4Var.c(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    x4 b(x4 x4Var) {
        if (this.f6106a.equals(x4Var.f6106a)) {
            if (!b() && !x4Var.b()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = x4Var.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i + i3;
                        w4 w4Var = this.f6106a;
                        iArr3[i4] = w4Var.a(iArr3[i4], w4Var.c(i2, iArr2[i3]));
                    }
                }
                return new x4(this.f6106a, iArr3);
            }
            return this.f6106a.c();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    int a() {
        return this.b.length - 1;
    }

    x4 c() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f6106a.d(0, this.b[i]);
        }
        return new x4(this.f6106a, iArr);
    }

    x4 c(x4 x4Var) {
        if (this.f6106a.equals(x4Var.f6106a)) {
            return x4Var.b() ? this : a(x4Var.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    x4 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f6106a.c();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f6106a.c(this.b[i3], i2);
        }
        return new x4(this.f6106a, iArr);
    }
}
