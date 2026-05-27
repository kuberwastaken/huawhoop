package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class mzj {
    private char[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15960a = 0;
    private int b = 0;
    private int e = 0;
    private int d = 0;

    mzj() {
    }

    private boolean a() {
        return this.f15960a < this.b;
    }

    private String d(boolean z) {
        while (true) {
            int i = this.e;
            if (i >= this.d || !Character.isWhitespace(this.c[i])) {
                break;
            }
            this.e++;
        }
        while (true) {
            int i2 = this.d;
            if (i2 <= this.e || !Character.isWhitespace(this.c[i2 - 1])) {
                break;
            }
            this.d--;
        }
        if (z) {
            int i3 = this.d;
            int i4 = this.e;
            if (i3 - i4 >= 2) {
                char[] cArr = this.c;
                if (cArr[i4] == '\"') {
                    int i5 = i3 - 1;
                    if (cArr[i5] == '\"') {
                        this.e = i4 + 1;
                        this.d = i5;
                    }
                }
            }
        }
        int i6 = this.d;
        int i7 = this.e;
        if (i6 >= i7) {
            return new String(this.c, i7, i6 - i7);
        }
        return null;
    }

    private boolean e(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    private String c(char[] cArr) {
        int i = this.f15960a;
        this.e = i;
        this.d = i;
        while (a() && !e(this.c[this.f15960a], cArr)) {
            this.d++;
            this.f15960a++;
        }
        return d(false);
    }

    private String b(char[] cArr) {
        int i = this.f15960a;
        this.e = i;
        this.d = i;
        boolean z = false;
        boolean z2 = false;
        while (a()) {
            char c = this.c[this.f15960a];
            if (!z && e(c, cArr)) {
                break;
            }
            if (!z2 && c == '\"') {
                z = !z;
            }
            z2 = !z2 && c == '\\';
            this.d++;
            this.f15960a++;
        }
        return d(true);
    }

    List e(String str, char c) {
        if (str == null) {
            return new ArrayList();
        }
        return b(str.toCharArray(), c);
    }

    private List b(char[] cArr, char c) {
        if (cArr == null) {
            return new ArrayList();
        }
        return b(cArr, 0, cArr.length, c);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List b(char[] r6, int r7, int r8, char r9) {
        /*
            r5 = this;
            if (r6 != 0) goto L8
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.c = r6
            r5.f15960a = r7
            r5.b = r8
        L13:
            boolean r7 = r5.a()
            if (r7 == 0) goto L67
            r7 = 2
            char[] r7 = new char[r7]
            r8 = 0
            r1 = 61
            r7[r8] = r1
            r2 = 1
            r7[r2] = r9
            java.lang.String r7 = r5.c(r7)
            boolean r3 = r5.a()
            if (r3 == 0) goto L41
            int r3 = r5.f15960a
            char r4 = r6[r3]
            if (r4 != r1) goto L41
            int r3 = r3 + 1
            r5.f15960a = r3
            char[] r1 = new char[r2]
            r1[r8] = r9
            java.lang.String r8 = r5.b(r1)
            goto L42
        L41:
            r8 = 0
        L42:
            boolean r1 = r5.a()
            if (r1 == 0) goto L52
            int r1 = r5.f15960a
            char r2 = r6[r1]
            if (r2 != r9) goto L52
            int r1 = r1 + 1
            r5.f15960a = r1
        L52:
            if (r7 == 0) goto L13
            java.lang.String r1 = ""
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L5e
            if (r8 == 0) goto L13
        L5e:
            mzi r1 = new mzi
            r1.<init>(r7, r8)
            r0.add(r1)
            goto L13
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzj.b(char[], int, int, char):java.util.List");
    }
}
