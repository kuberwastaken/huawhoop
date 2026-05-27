package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
final class m3 {
    private static final int[][] c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c3 f6016a;
    private final byte b;

    private m3(int i) {
        this.f6016a = c3.a((i >> 3) & 3);
        this.b = (byte) (i & 7);
    }

    static int c(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    static m3 a(int i, int i2) {
        m3 m3VarB = b(i, i2);
        return m3VarB != null ? m3VarB : b(i ^ 21522, i2 ^ 21522);
    }

    private static m3 b(int i, int i2) {
        int iC;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : c) {
            int i5 = iArr[0];
            if (i5 != i && i5 != i2) {
                int iC2 = c(i, i5);
                if (iC2 < i3) {
                    i4 = iArr[1];
                    i3 = iC2;
                }
                if (i2 != i && (iC = c(i2, i5)) < i3) {
                    i4 = iArr[1];
                    i3 = iC;
                }
            } else {
                return new m3(iArr[1]);
            }
        }
        if (i3 <= 3) {
            return new m3(i4);
        }
        return null;
    }

    public int hashCode() {
        return (this.f6016a.ordinal() << 3) | this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return this.f6016a == m3Var.f6016a && this.b == m3Var.b;
    }

    c3 a() {
        return this.f6016a;
    }

    byte b() {
        return this.b;
    }
}
