package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public final class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f19355a = new char[0];
    private int b;
    private char[] c;
    private final yd d;
    private boolean e;
    private String f;
    private int g;
    private char[] h;
    private char[] i;
    private int j;
    private int l;
    private ArrayList<char[]> o;

    public yk(yd ydVar) {
        this.d = ydVar;
    }

    protected yk(yd ydVar, char[] cArr) {
        this.d = ydVar;
        this.c = cArr;
        this.b = cArr.length;
        this.g = -1;
    }

    public static yk a(char[] cArr) {
        return new yk(null, cArr);
    }

    public void l() {
        char[] cArr;
        this.g = -1;
        this.b = 0;
        this.j = 0;
        this.i = null;
        this.h = null;
        if (this.e) {
            s();
        }
        yd ydVar = this.d;
        if (ydVar == null || (cArr = this.c) == null) {
            return;
        }
        this.c = null;
        ydVar.c(2, cArr);
    }

    public void e(char[] cArr, int i, int i2) {
        this.f = null;
        this.h = null;
        this.i = cArr;
        this.g = i;
        this.j = i2;
        if (this.e) {
            s();
        }
    }

    public void b(char[] cArr, int i, int i2) {
        this.i = null;
        this.g = -1;
        this.j = 0;
        this.f = null;
        this.h = null;
        if (this.e) {
            s();
        } else if (this.c == null) {
            this.c = a(i2);
        }
        this.l = 0;
        this.b = 0;
        c(cArr, i, i2);
    }

    public void d(String str, int i, int i2) {
        this.i = null;
        this.g = -1;
        this.j = 0;
        this.f = null;
        this.h = null;
        if (this.e) {
            s();
        } else if (this.c == null) {
            this.c = a(i2);
        }
        this.l = 0;
        this.b = 0;
        c(str, i, i2);
    }

    public void e(String str) {
        this.i = null;
        this.g = -1;
        this.j = 0;
        this.f = str;
        this.h = null;
        if (this.e) {
            s();
        }
        this.b = 0;
    }

    public char[] j() {
        return this.c;
    }

    private char[] a(int i) {
        yd ydVar = this.d;
        if (ydVar != null) {
            return ydVar.a(2, i);
        }
        return new char[Math.max(i, 500)];
    }

    private void s() {
        this.e = false;
        this.o.clear();
        this.l = 0;
        this.b = 0;
    }

    public int k() {
        if (this.g >= 0) {
            return this.j;
        }
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f;
        if (str != null) {
            return str.length();
        }
        return this.l + this.b;
    }

    public int o() {
        int i = this.g;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public boolean n() {
        return this.g >= 0 || this.h != null || this.f == null;
    }

    public char[] m() {
        if (this.g >= 0) {
            return this.i;
        }
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.h = charArray;
            return charArray;
        }
        if (!this.e) {
            char[] cArr2 = this.c;
            return cArr2 == null ? f19355a : cArr2;
        }
        return d();
    }

    public String b() {
        if (this.f == null) {
            char[] cArr = this.h;
            if (cArr != null) {
                this.f = new String(cArr);
            } else {
                int i = this.g;
                if (i >= 0) {
                    int i2 = this.j;
                    if (i2 < 1) {
                        this.f = "";
                        return "";
                    }
                    this.f = new String(this.i, i, i2);
                } else {
                    int i3 = this.l;
                    int i4 = this.b;
                    if (i3 == 0) {
                        this.f = i4 != 0 ? new String(this.c, 0, i4) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList<char[]> arrayList = this.o;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = this.o.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.c, 0, this.b);
                        this.f = sb.toString();
                    }
                }
            }
        }
        return this.f;
    }

    public char[] d() {
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrT = t();
        this.h = cArrT;
        return cArrT;
    }

    public BigDecimal c() throws NumberFormatException {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this.h;
        if (cArr3 != null) {
            return xh.a(cArr3);
        }
        int i = this.g;
        if (i >= 0 && (cArr2 = this.i) != null) {
            return xh.e(cArr2, i, this.j);
        }
        if (this.l == 0 && (cArr = this.c) != null) {
            return xh.e(cArr, 0, this.b);
        }
        return xh.a(d());
    }

    public double e() throws NumberFormatException {
        return xh.b(b());
    }

    public int b(boolean z) {
        char[] cArr;
        int i = this.g;
        if (i < 0 || (cArr = this.i) == null) {
            if (z) {
                return -xh.c(this.c, 1, this.b - 1);
            }
            return xh.c(this.c, 0, this.b);
        }
        if (z) {
            return -xh.c(cArr, i + 1, this.j - 1);
        }
        return xh.c(cArr, i, this.j);
    }

    public long c(boolean z) {
        char[] cArr;
        int i = this.g;
        if (i < 0 || (cArr = this.i) == null) {
            if (z) {
                return -xh.a(this.c, 1, this.b - 1);
            }
            return xh.a(this.c, 0, this.b);
        }
        if (z) {
            return -xh.a(cArr, i + 1, this.j - 1);
        }
        return xh.a(cArr, i, this.j);
    }

    public int e(Writer writer) throws IOException {
        int i;
        char[] cArr = this.h;
        if (cArr != null) {
            writer.write(cArr);
            return this.h.length;
        }
        String str = this.f;
        if (str != null) {
            writer.write(str);
            return this.f.length();
        }
        int i2 = this.g;
        if (i2 >= 0) {
            int i3 = this.j;
            if (i3 > 0) {
                writer.write(this.i, i2, i3);
            }
            return i3;
        }
        ArrayList<char[]> arrayList = this.o;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr2 = this.o.get(i4);
                int length = cArr2.length;
                writer.write(cArr2, 0, length);
                i += length;
            }
        } else {
            i = 0;
        }
        int i5 = this.b;
        if (i5 <= 0) {
            return i;
        }
        writer.write(this.c, 0, i5);
        return i + i5;
    }

    public void a(char c) {
        if (this.g >= 0) {
            g(16);
        }
        this.f = null;
        this.h = null;
        char[] cArr = this.c;
        if (this.b >= cArr.length) {
            d(1);
            cArr = this.c;
        }
        int i = this.b;
        this.b = i + 1;
        cArr[i] = c;
    }

    public void c(char[] cArr, int i, int i2) {
        if (this.g >= 0) {
            g(i2);
        }
        this.f = null;
        this.h = null;
        char[] cArr2 = this.c;
        int length = cArr2.length;
        int i3 = this.b;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.b += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            d(i2);
            int iMin = Math.min(this.c.length, i2);
            System.arraycopy(cArr, i, this.c, 0, iMin);
            this.b += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public void c(String str, int i, int i2) {
        if (this.g >= 0) {
            g(i2);
        }
        this.f = null;
        this.h = null;
        char[] cArr = this.c;
        int length = cArr.length;
        int i3 = this.b;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(i, i + i2, cArr, i3);
            this.b += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = i + i4;
            str.getChars(i, i5, cArr, i3);
            i2 -= i4;
            i = i5;
        }
        while (true) {
            d(i2);
            int iMin = Math.min(this.c.length, i2);
            int i6 = i + iMin;
            str.getChars(i, i6, this.c, 0);
            this.b += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i6;
            }
        }
    }

    public char[] f() {
        if (this.g >= 0) {
            g(1);
        } else {
            char[] cArr = this.c;
            if (cArr == null) {
                this.c = a(0);
            } else if (this.b >= cArr.length) {
                d(1);
            }
        }
        return this.c;
    }

    public char[] a() {
        this.g = -1;
        this.b = 0;
        this.j = 0;
        this.i = null;
        this.f = null;
        this.h = null;
        if (this.e) {
            s();
        }
        char[] cArr = this.c;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrA = a(0);
        this.c = cArrA;
        return cArrA;
    }

    public int g() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public String b(int i) {
        this.b = i;
        if (this.l > 0) {
            return b();
        }
        String str = i == 0 ? "" : new String(this.c, 0, i);
        this.f = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[PHI: r1
      0x0027: PHI (r1v7 int) = (r1v5 int), (r1v6 int) binds: [B:6:0x0025, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] i() {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r0 = r2.o
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.o = r0
        Lb:
            r0 = 1
            r2.e = r0
            java.util.ArrayList<char[]> r0 = r2.o
            char[] r1 = r2.c
            r0.add(r1)
            char[] r0 = r2.c
            int r0 = r0.length
            int r1 = r2.l
            int r1 = r1 + r0
            r2.l = r1
            r1 = 0
            r2.b = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L29
        L27:
            r0 = r1
            goto L2e
        L29:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L2e
            goto L27
        L2e:
            char[] r0 = r2.e(r0)
            r2.c = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yk.i():char[]");
    }

    public char[] h() {
        char[] cArr = this.c;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 65536) {
            i = (length >> 2) + length;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i);
        this.c = cArrCopyOf;
        return cArrCopyOf;
    }

    public String toString() {
        return b();
    }

    private void g(int i) {
        int i2 = this.j;
        this.j = 0;
        char[] cArr = this.i;
        this.i = null;
        int i3 = this.g;
        this.g = -1;
        int i4 = i + i2;
        char[] cArr2 = this.c;
        if (cArr2 == null || i4 > cArr2.length) {
            this.c = a(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.c, 0, i2);
        }
        this.l = 0;
        this.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[PHI: r0
      0x0026: PHI (r0v8 int) = (r0v6 int), (r0v7 int) binds: [B:6:0x0024, B:9:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r3) {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r3 = r2.o
            if (r3 != 0) goto Lb
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.o = r3
        Lb:
            char[] r3 = r2.c
            r0 = 1
            r2.e = r0
            java.util.ArrayList<char[]> r0 = r2.o
            r0.add(r3)
            int r0 = r2.l
            int r1 = r3.length
            int r0 = r0 + r1
            r2.l = r0
            r0 = 0
            r2.b = r0
            int r3 = r3.length
            int r0 = r3 >> 1
            int r3 = r3 + r0
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 >= r0) goto L28
        L26:
            r3 = r0
            goto L2d
        L28:
            r0 = 65536(0x10000, float:9.1835E-41)
            if (r3 <= r0) goto L2d
            goto L26
        L2d:
            char[] r3 = r2.e(r3)
            r2.c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yk.d(int):void");
    }

    private char[] t() {
        int i;
        String str = this.f;
        if (str != null) {
            return str.toCharArray();
        }
        int i2 = this.g;
        if (i2 >= 0) {
            int i3 = this.j;
            if (i3 < 1) {
                return f19355a;
            }
            if (i2 == 0) {
                return Arrays.copyOf(this.i, i3);
            }
            return Arrays.copyOfRange(this.i, i2, i3 + i2);
        }
        int iK = k();
        if (iK < 1) {
            return f19355a;
        }
        char[] cArrE = e(iK);
        ArrayList<char[]> arrayList = this.o;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr = this.o.get(i4);
                int length = cArr.length;
                System.arraycopy(cArr, 0, cArrE, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this.c, 0, cArrE, i, this.b);
        return cArrE;
    }

    private char[] e(int i) {
        return new char[i];
    }
}
