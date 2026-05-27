package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes5.dex */
final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f6038a;
    private final int[] b;

    p3(o3 o3Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f6038a = o3Var;
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

    boolean c() {
        return this.b[0] == 0;
    }

    p3 a(p3 p3Var) {
        if (this.f6038a.equals(p3Var.f6038a)) {
            if (c()) {
                return p3Var;
            }
            if (p3Var.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = p3Var.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = o3.a(iArr2[i - length], iArr[i]);
            }
            return new p3(this.f6038a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    p3[] b(p3 p3Var) {
        if (this.f6038a.equals(p3Var.f6038a)) {
            if (!p3Var.c()) {
                p3 p3VarD = this.f6038a.d();
                int iB = this.f6038a.b(p3Var.b(p3Var.b()));
                p3 p3VarA = this;
                while (p3VarA.b() >= p3Var.b() && !p3VarA.c()) {
                    int iB2 = p3VarA.b() - p3Var.b();
                    int iC = this.f6038a.c(p3VarA.b(p3VarA.b()), iB);
                    p3 p3VarA2 = p3Var.a(iB2, iC);
                    p3VarD = p3VarD.a(this.f6038a.b(iB2, iC));
                    p3VarA = p3VarA.a(p3VarA2);
                }
                return new p3[]{p3VarD, p3VarA};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iB2 = b(iB);
            if (iB2 != 0) {
                if (iB2 < 0) {
                    sb.append(" - ");
                    iB2 = -iB2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iB2 != 1) {
                    int iC = this.f6038a.c(iB2);
                    if (iC == 0) {
                        sb.append('1');
                    } else if (iC == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
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
                iA = o3.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = o3.a(this.f6038a.c(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    p3 c(int i) {
        if (i == 0) {
            return this.f6038a.d();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f6038a.c(this.b[i2], i);
        }
        return new p3(this.f6038a, iArr);
    }

    int b(int i) {
        return this.b[(r0.length - 1) - i];
    }

    int[] a() {
        return this.b;
    }

    int b() {
        return this.b.length - 1;
    }

    p3 c(p3 p3Var) {
        if (this.f6038a.equals(p3Var.f6038a)) {
            if (!c() && !p3Var.c()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = p3Var.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i + i3;
                        iArr3[i4] = o3.a(iArr3[i4], this.f6038a.c(i2, iArr2[i3]));
                    }
                }
                return new p3(this.f6038a, iArr3);
            }
            return this.f6038a.d();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    p3 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f6038a.d();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f6038a.c(this.b[i3], i2);
        }
        return new p3(this.f6038a, iArr);
    }
}
