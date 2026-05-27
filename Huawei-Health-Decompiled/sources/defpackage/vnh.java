package defpackage;

import android.content.Context;
import android.util.Pair;
import com.huawei.uikit.hwcolumnsystem.widget.bqmxo;

/* JADX INFO: loaded from: classes8.dex */
public class vnh extends bqmxo {
    private int ao;
    private int ar;
    private static final int[] ag = {4, 8, 12};
    private static final int[] ah = {4, 6, 8};
    private static final int[] af = {4, 6, 8};
    private static final int[] ae = {2, 3, 4};
    private static final int[] ai = {4, 6, 8};
    private static final int[] aj = {2, 3, 4};
    private static final int[] am = {4, 6, 8};
    private static final int[] al = {4, 6, 8};
    private static final int[] an = {4, 6, 8};
    private static final int[] ak = {4, 6, 6};
    private static final int[] as = {4, 6, 6};
    private static final int[] d = {4, 6, 8};
    private static final int[] e = {4, 6, 8};
    private static final int[] j = {4, 6, 8};
    private static final int[] h = {4, 6, 8};
    private static final int[] i = {2, 2, 2};
    private static final int[] g = {4, 6, 6};
    private static final int[] o = {2, 2, 2};
    private static final int[] m = {4, 6, 6};
    private static final int[] l = {4, 6, 10};
    private static final int[] n = {4, 6, 10};
    private static final int[] k = {-2, 8, 12};
    private static final int[] t = {-2, 8, 12};
    private static final int[] q = {4, 6, 6};
    private static final int[] p = {4, 6, 6};
    private static final int[] r = {-2, 8, 8};
    private static final int[] s = {-2, 8, 8};
    private static final int[] x = {4, 6, 10};
    private static final int[] w = {4, 6, 10};
    private static final int[] v = {4, 6, 8};
    private static final int[] u = {4, 6, 8};
    private static final int[] y = {4, 6, 6};
    private static final int[] ab = {4, 6, 6};
    private static final int[] ac = {-2, 6, 6};
    private static final int[] ad = {-2, 6, 6};
    private static final int[][] aa = {new int[]{4, 6, 8}, new int[]{2, 3, 4}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{2, 2, 2}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{2, 2, 2}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{2, 3, 4}, new int[]{4, 6, 8}, new int[]{-2, 6, 6}, new int[]{4, 6, 10}, new int[]{4, 6, 6}};
    private static final int[][] z = {new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{4, 6, 6}, new int[]{-2, 8, 8}, new int[]{4, 6, 10}, new int[]{-2, 8, 12}, new int[]{4, 6, 6}, new int[]{4, 6, 8}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 4, 5}, new int[]{4, 6, 8}, new int[]{4, 6, 8}, new int[]{-2, 6, 6}, new int[]{4, 6, 10}, new int[]{4, 6, 6}};

    public vnh(Context context) {
        super(context);
        this.ar = 32;
        this.ao = 16;
        this.f11116a = 520;
        this.b = 840;
    }

    private int p() {
        return a(this.ao);
    }

    private int t() {
        return a(this.ar);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public Pair<Integer, String> a(int i2, String[] strArr, float f) {
        String str;
        int i3;
        if (i2 >= a(840, f)) {
            str = strArr[2];
            i3 = 12;
        } else if (i2 >= a(520, f)) {
            str = strArr[1];
            i3 = 8;
        } else {
            str = strArr[0];
            i3 = 4;
        }
        return new Pair<>(Integer.valueOf(i3), str);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public int b(int i2, int i3, int i4) {
        return 0;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj b() {
        int iT = t();
        int iP = p();
        int[] iArr = ak;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], as[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj c() {
        int iT = t();
        int iP = p();
        int[] iArr = ae;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], ai[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj d() {
        int iT = t();
        int iP = p();
        int[] iArr = aj;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], am[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj e() {
        int iT = t();
        int iP = p();
        int[] iArr = al;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], an[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj f() {
        int iT = t();
        int iP = p();
        int[] iArr = j;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], h[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj g() {
        int iT = t();
        int iP = p();
        int[] iArr = ah;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], af[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj h() {
        int iT = t();
        int iP = p();
        int[] iArr = d;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], e[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj i() {
        int iT = t();
        int iP = p();
        int[] iArr = k;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], t[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj j() {
        int iT = t();
        int iP = p();
        int[] iArr = r;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], s[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj k() {
        int iT = t();
        int iP = p();
        int[] iArr = o;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], m[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj l() {
        int iT = t();
        int iP = p();
        int[] iArr = l;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], n[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj m() {
        int iT = t();
        int iP = p();
        int[] iArr = q;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], p[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj n() {
        int iT = t();
        int iP = p();
        int[] iArr = i;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], g[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public int o() {
        return ag[this.c];
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public boolean b(int i2) {
        return i2 >= 0 && i2 < aa.length && i2 < z.length;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj c(int i2, int i3, int i4) {
        int iT = t();
        int iP = p();
        int[] iArr = x;
        int i5 = this.c;
        return new vnj(iT, iP, iArr[i5], w[i5]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj d(int i2, int i3, int i4) {
        int iT = t();
        int iP = p();
        int[] iArr = y;
        int i5 = this.c;
        return new vnj(iT, iP, iArr[i5], ab[i5]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public Pair<Integer, Integer> a(float f) {
        int i2;
        int i3;
        if (f > 840.0f || a(f, 840.0f)) {
            i2 = 12;
            i3 = 2;
        } else if (f > 520.0f || a(f, 520.0f)) {
            i2 = 8;
            i3 = 1;
        } else {
            i2 = 4;
            i3 = 0;
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj a(int i2, int i3, int i4) {
        int iT = t();
        int iP = p();
        int[] iArr = v;
        int i5 = this.c;
        return new vnj(iT, iP, iArr[i5], u[i5]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj a() {
        int iT = t();
        int iP = p();
        int[] iArr = ac;
        int i2 = this.c;
        return new vnj(iT, iP, iArr[i2], ad[i2]);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.bqmxo
    public vnj a(int i2, Pair<Integer, Integer> pair, int i3, int i4, float f) {
        return new vnj(t(), p(), aa[i3][i4], z[i3][i4]);
    }
}
