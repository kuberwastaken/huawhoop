package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class awp {
    public static awi e(awi awiVar, int i) {
        boolean z = i <= 6;
        int i2 = z ? 6 - i : i - 6;
        return new awi(a(awiVar, i2, z), e(awiVar, i2, z), d(awiVar, i2, z), awiVar.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[PHI: r3 r4
      0x0027: PHI (r3v10 float) = (r3v1 float), (r3v12 float) binds: [B:10:0x0025, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x0027: PHI (r4v7 float) = (r4v2 float), (r4v9 float) binds: [B:10:0x0025, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[PHI: r3 r4
      0x0029: PHI (r3v2 float) = (r3v1 float), (r3v12 float) binds: [B:10:0x0025, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r4v3 float) = (r4v2 float), (r4v9 float) binds: [B:10:0x0025, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float a(defpackage.awi r3, int r4, boolean r5) {
        /*
            float r0 = r3.d()
            r1 = 1114636288(0x42700000, float:60.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 < 0) goto L1f
            float r0 = r3.d()
            r2 = 1131413504(0x43700000, float:240.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L1f
            float r3 = r3.d()
            float r4 = (float) r4
            float r4 = r4 * r1
            if (r5 == 0) goto L27
            goto L29
        L1f:
            float r3 = r3.d()
            float r4 = (float) r4
            float r4 = r4 * r1
            if (r5 == 0) goto L29
        L27:
            float r3 = r3 + r4
            goto L2a
        L29:
            float r3 = r3 - r4
        L2a:
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            r5 = 1135869952(0x43b40000, float:360.0)
            if (r4 >= 0) goto L33
            float r3 = r3 + r5
            goto L38
        L33:
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 < 0) goto L38
            float r3 = r3 - r5
        L38:
            int r3 = java.lang.Math.round(r3)
            float r3 = (float) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.awp.a(awi, int, boolean):float");
    }

    private static float e(awi awiVar, int i, boolean z) {
        float fB;
        float fB2;
        float f = 0.16f;
        if (z) {
            fB2 = awiVar.b() - (i * 0.16f);
        } else {
            if (i == 4) {
                fB = awiVar.b();
            } else {
                fB = awiVar.b();
                f = i * 0.05f;
            }
            fB2 = fB + f;
        }
        if (fB2 > 1.0f) {
            fB2 = 1.0f;
        }
        if (z && i == 5 && fB2 > 0.1f) {
            fB2 = 0.1f;
        }
        if (fB2 < 0.06f) {
            return 0.06f;
        }
        return fB2;
    }

    private static float d(awi awiVar, int i, boolean z) {
        float fC;
        if (z) {
            fC = awiVar.c() + (i * 0.05f);
        } else {
            fC = awiVar.c() - (i * 0.15f);
        }
        if (fC > 1.0f) {
            return 1.0f;
        }
        return fC;
    }
}
