package defpackage;

import android.graphics.Rect;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes7.dex */
public class pjt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16731a;
    private long b;
    private long d;
    private int[] e;
    private pjo f;
    private int g;
    private int[] j;
    private int l;
    private int i = 0;
    private int c = 0;
    private int n = 0;
    private boolean h = false;
    private pjr o = new pjr();
    private Rect k = new Rect();

    private int b(int i, int i2, int i3) {
        return (i >= i2 && i2 + (-1) < i3) ? i3 + (i - i2) : i;
    }

    public pjt(pjo pjoVar) {
        this.f = pjoVar;
    }

    public void b() {
        this.j = new int[0];
        this.e = new int[0];
        this.d = 0L;
        this.b = 0L;
        this.f16731a = 0;
        this.g = 0;
        this.l = 0;
        this.h = false;
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        this.j = new int[i];
        this.e = new int[i2];
        this.c = i3;
        this.n = i4;
        this.i = i5;
        this.h = true;
    }

    void a() {
        if (!this.h) {
            throw new IllegalStateException("You need to init matrix before work!");
        }
    }

    public void m() {
        a();
        this.d = 0L;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.e;
            if (i2 >= iArr.length) {
                break;
            }
            long j = this.d + ((long) iArr[i2]);
            this.d = j;
            if (i2 == this.i - 1) {
                this.g = (int) j;
            }
            i2++;
        }
        this.b = 0L;
        this.l = 0;
        while (true) {
            int[] iArr2 = this.j;
            if (i >= iArr2.length) {
                return;
            }
            long j2 = this.b;
            int i3 = iArr2[i];
            long j3 = j2 + ((long) i3);
            this.b = j3;
            if (i == this.c - 1) {
                this.f16731a = (int) j3;
            } else if (i >= iArr2.length - this.n) {
                this.l += i3;
            }
            i++;
        }
    }

    public int d(int i) {
        a();
        if (i >= 0) {
            int[] iArr = this.e;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return 0;
    }

    public void c(int i, int i2) {
        a();
        if (i >= 0) {
            int[] iArr = this.e;
            if (i < iArr.length) {
                iArr[i] = i2;
            }
        }
    }

    public int d(int i, int i2) {
        a();
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            int[] iArr = this.e;
            if (iArr == null) {
                break;
            }
            i3 += iArr[i4];
        }
        return i3 + ((i2 - i) * this.f.d());
    }

    public int d() {
        int[] iArr = this.e;
        if (iArr != null) {
            return iArr.length;
        }
        return 0;
    }

    public int c(int i) {
        a();
        if (i >= 0) {
            int[] iArr = this.j;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return 0;
    }

    public void a(int i, int i2) {
        a();
        if (i >= 0) {
            int[] iArr = this.j;
            if (i < iArr.length) {
                iArr[i] = i2;
            }
        }
    }

    public int b(int i, int i2) {
        a();
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            int[] iArr = this.j;
            if (iArr == null) {
                break;
            }
            i3 += iArr[i4];
        }
        return i3 + ((i2 - i) * this.f.c());
    }

    public int j() {
        int[] iArr = this.j;
        if (iArr != null) {
            return iArr.length;
        }
        return 0;
    }

    public int o() {
        return this.n;
    }

    public long f() {
        a();
        return this.d + ((long) ((this.f.l() ? d() + 1 : d() - 1) * this.f.d()));
    }

    public long c() {
        a();
        return this.b + ((long) ((this.f.n() ? j() + 1 : j() - 1) * this.f.c()));
    }

    public int h() {
        return Math.max(0, this.g + ((this.f.l() ? this.i : this.i - 1) * this.f.d()));
    }

    public int e() {
        return Math.max(0, this.f16731a + ((this.f.n() ? this.c : this.c - 1) * this.f.c()));
    }

    public int i() {
        return Math.max(0, this.l + ((this.f.n() ? this.n : this.n - 1) * this.f.c()));
    }

    public int b(int i) {
        a();
        int iD = i - ((this.f.l() ? 1 : 0) * this.f.d());
        int i2 = 0;
        if (iD <= 0) {
            return 0;
        }
        int length = this.e.length;
        int i3 = 0;
        while (i2 < length) {
            int iD2 = this.e[i2] + i3 + this.f.d();
            if (iD > i3 && iD < iD2) {
                return i2;
            }
            if (iD < iD2) {
                return i2 - 1;
            }
            i2++;
            i3 = iD2;
        }
        return this.e.length - 1;
    }

    public int e(int i) {
        a();
        int iC = i - ((this.f.n() ? 1 : 0) * this.f.c());
        int i2 = 0;
        if (iC <= 0) {
            return 0;
        }
        int length = this.j.length;
        int i3 = 0;
        while (i2 < length) {
            int iC2 = this.j[i2] + i3 + this.f.c();
            if (iC > i3 && iC < iC2) {
                return i2;
            }
            if (iC < iC2) {
                return i2 - 1;
            }
            i2++;
            i3 = iC2;
        }
        return this.j.length - 1;
    }

    public d[][] cRv_(Rect rect) {
        int i;
        int i2 = this.f.i() ? this.c : 0;
        int i3 = this.f.o() ? this.n : 0;
        int i4 = this.f.m() ? this.i : 0;
        int iB = b(rect.left);
        int iB2 = b(rect.right);
        int iE = e(rect.top);
        int iE2 = e(rect.bottom);
        if (iB > iB2) {
            i = iB2;
        } else {
            i = iB;
            iB = iB2;
        }
        int i5 = (iB - i) + 1;
        int i6 = i4 + (-1) < i ? i5 + i4 : i5 + i;
        int iJ = (iE2 - iE) + 1 + (i2 + (-1) < iE ? i2 : iE) + (i3 < (j() + (-1)) - iE2 ? i3 : (j() - 1) - iE2);
        d[][] dVarArr = (d[][]) Array.newInstance((Class<?>) d.class, iJ, i6);
        int i7 = 0;
        while (i7 < iJ) {
            int i8 = i7;
            int iA = a(i7, iJ, iE, i2, i3);
            for (int i9 = 0; i9 < i6; i9++) {
                int iB3 = b(i9, i4, i);
                dVarArr[i8][i9] = new d(iA, iB3, e(iA, iB3));
            }
            i7 = i8 + 1;
        }
        return dVarArr;
    }

    private int a(int i, int i2, int i3, int i4, int i5) {
        if (i < i4) {
            return i;
        }
        if (i > (i2 - i5) - 1) {
            return j() - (i2 - i);
        }
        return i4 + (-1) < i3 ? i3 + (i - i4) : i;
    }

    int e(int i, int i2) {
        int i3;
        if (i < this.i) {
            i3 = 2;
        } else {
            i3 = i > (j() - 1) - this.n ? 4 : 0;
        }
        return i3 | (i2 < this.c ? 1 : 0);
    }

    public pjr g() {
        return this.o;
    }

    public Rect cRu_(boolean z) {
        if (z) {
            this.k.set(((int) Math.max(f(), this.f.e())) - this.o.b(), this.o.d(), ((int) Math.max(f(), this.f.e())) - (this.o.b() + this.f.e()), this.o.d() + this.f.b());
        } else {
            this.k.set(this.o.b(), this.o.d(), this.o.b() + this.f.e(), this.o.d() + this.f.b());
        }
        return this.k;
    }

    public boolean n() {
        return this.h;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16732a;
        private int d;
        private int e;

        d(int i, int i2, int i3) {
            this.f16732a = i;
            this.d = i2;
            this.e = i3;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.f16732a;
        }

        public int a() {
            return this.e;
        }
    }
}
