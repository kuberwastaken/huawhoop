package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes5.dex */
abstract class r4 {
    static int a(c0 c0Var) {
        return a(c0Var, true) + a(c0Var, false);
    }

    static int b(c0 c0Var) {
        byte[][] bArrA = c0Var.a();
        int iC = c0Var.c();
        int iB = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < iB - 1; i2++) {
            byte[] bArr = bArrA[i2];
            int i3 = 0;
            while (i3 < iC - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                if (b == bArr[i4]) {
                    byte[] bArr2 = bArrA[i2 + 1];
                    if (b == bArr2[i3] && b == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    static int c(c0 c0Var) {
        byte[][] bArrA = c0Var.a();
        int iC = c0Var.c();
        int iB = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            for (int i3 = 0; i3 < iC; i3++) {
                byte[] bArr = bArrA[i2];
                int i4 = i3 + 6;
                if (i4 < iC && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (a(bArr, i3 - 4, i3) || a(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < iB && bArrA[i2][i3] == 1 && bArrA[i2 + 1][i3] == 0 && bArrA[i2 + 2][i3] == 1 && bArrA[i2 + 3][i3] == 1 && bArrA[i2 + 4][i3] == 1 && bArrA[i2 + 5][i3] == 0 && bArrA[i5][i3] == 1 && (a(bArrA, i3, i2 - 4, i2) || a(bArrA, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    static int d(c0 c0Var) {
        byte[][] bArrA = c0Var.a();
        int iC = c0Var.c();
        int iB = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            byte[] bArr = bArrA[i2];
            for (int i3 = 0; i3 < iC; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int iB2 = c0Var.b() * c0Var.c();
        return ((Math.abs((i * 2) - iB2) * 10) / iB2) * 10;
    }

    private static int a(c0 c0Var, boolean z) {
        int iB = z ? c0Var.b() : c0Var.c();
        int iC = z ? c0Var.c() : c0Var.b();
        byte[][] bArrA = c0Var.a();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < iC; i4++) {
                byte b2 = z ? bArrA[i2][i4] : bArrA[i4][i2];
                if (b2 == b) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += i3 - 2;
                    }
                    i3 = 1;
                    b = b2;
                }
            }
            if (i3 >= 5) {
                i += i3 - 2;
            }
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L3c;
                case 1: goto L3d;
                case 2: goto L39;
                case 3: goto L35;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L21;
                case 7: goto L18;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid mask pattern: "
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L18:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L27
        L21:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L27:
            r1 = r1 & r0
            goto L3f
        L29:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3f
        L30:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L3c
        L35:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3f
        L39:
            int r1 = r2 % 3
            goto L3f
        L3c:
            int r3 = r3 + r2
        L3d:
            r1 = r3 & 1
        L3f:
            if (r1 != 0) goto L42
            goto L43
        L42:
            r0 = 0
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r4.a(int, int, int):boolean");
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, bArr.length);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (iMax < bArr.length && i < bArr[0].length && bArr[iMax][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
