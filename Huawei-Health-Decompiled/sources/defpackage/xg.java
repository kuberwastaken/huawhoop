package defpackage;

import com.huawei.operation.OpAnalyticsConstants;

/* JADX INFO: loaded from: classes9.dex */
public final class xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f19004a = 1000000000;
    private static int b = 1000000000;
    private static long d = 2147483647L;
    private static long f = -2147483648L;
    private static int g = 1000000;
    private static final String[] i;
    private static final String[] j;
    static final String c = String.valueOf(Integer.MIN_VALUE);
    static final String e = String.valueOf(Long.MIN_VALUE);
    private static final int[] h = new int[1000];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                int i5 = 0;
                while (i5 < 10) {
                    h[i2] = ((i3 + 48) << 16) | ((i4 + 48) << 8) | (i5 + 48);
                    i5++;
                    i2++;
                }
            }
        }
        i = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        j = new String[]{"-1", "-2", OpAnalyticsConstants.WATCH_FAIL_CODE, OpAnalyticsConstants.SSL_FAIL_CODE, "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int c(int i2, char[] cArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return c(cArr, i3);
            }
            cArr[i3] = '-';
            i2 = -i2;
            i3++;
        }
        if (i2 < g) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return e(i2 - (i5 * 1000), cArr, b(i5, cArr, i3));
            }
            if (i2 < 10) {
                cArr[i3] = (char) (i2 + 48);
                return i3 + 1;
            }
            return b(i2, cArr, i3);
        }
        int i6 = b;
        if (i2 >= i6) {
            int i7 = i2 - i6;
            if (i7 >= i6) {
                i7 -= i6;
                i4 = i3 + 1;
                cArr[i3] = '2';
            } else {
                i4 = i3 + 1;
                cArr[i3] = '1';
            }
            return a(i7, cArr, i4);
        }
        int i8 = i2 / 1000;
        int i9 = i8 / 1000;
        return e(i2 - (i8 * 1000), cArr, e(i8 - (i9 * 1000), cArr, b(i9, cArr, i3)));
    }

    public static int d(int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return a(bArr, i3);
            }
            bArr[i3] = 45;
            i2 = -i2;
            i3++;
        }
        if (i2 < g) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return a(i2 - (i5 * 1000), bArr, e(i5, bArr, i3));
            }
            if (i2 < 10) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) (i2 + 48);
                return i6;
            }
            return e(i2, bArr, i3);
        }
        int i7 = b;
        if (i2 >= i7) {
            int i8 = i2 - i7;
            if (i8 >= i7) {
                i8 -= i7;
                i4 = i3 + 1;
                bArr[i3] = 50;
            } else {
                i4 = i3 + 1;
                bArr[i3] = 49;
            }
            return b(i8, bArr, i4);
        }
        int i9 = i2 / 1000;
        int i10 = i9 / 1000;
        return a(i2 - (i9 * 1000), bArr, a(i9 - (i10 * 1000), bArr, e(i10, bArr, i3)));
    }

    public static int e(long j2, char[] cArr, int i2) {
        int iA;
        if (j2 < 0) {
            if (j2 > f) {
                return c((int) j2, cArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return a(cArr, i2);
            }
            cArr[i2] = '-';
            j2 = -j2;
            i2++;
        } else if (j2 <= d) {
            return c((int) j2, cArr, i2);
        }
        long j3 = f19004a;
        long j4 = j2 / j3;
        if (j4 < j3) {
            iA = d((int) j4, cArr, i2);
        } else {
            long j5 = j4 / j3;
            iA = a((int) (j4 - (j5 * j3)), cArr, b((int) j5, cArr, i2));
        }
        return a((int) (j2 - (j4 * j3)), cArr, iA);
    }

    public static int b(long j2, byte[] bArr, int i2) {
        int iB;
        if (j2 < 0) {
            if (j2 > f) {
                return d((int) j2, bArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return c(bArr, i2);
            }
            bArr[i2] = 45;
            j2 = -j2;
            i2++;
        } else if (j2 <= d) {
            return d((int) j2, bArr, i2);
        }
        long j3 = f19004a;
        long j4 = j2 / j3;
        if (j4 < j3) {
            iB = c((int) j4, bArr, i2);
        } else {
            long j5 = j4 / j3;
            iB = b((int) (j4 - (j5 * j3)), bArr, e((int) j5, bArr, i2));
        }
        return b((int) (j2 - (j4 * j3)), bArr, iB);
    }

    public static String e(int i2) {
        String[] strArr = i;
        if (i2 < strArr.length) {
            if (i2 >= 0) {
                return strArr[i2];
            }
            int i3 = (-i2) - 1;
            String[] strArr2 = j;
            if (i3 < strArr2.length) {
                return strArr2[i3];
            }
        }
        return Integer.toString(i2);
    }

    public static String c(long j2) {
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return e((int) j2);
        }
        return Long.toString(j2);
    }

    public static String e(double d2) {
        return Double.toString(d2);
    }

    public static String d(float f2) {
        return Float.toString(f2);
    }

    public static boolean c(double d2) {
        return Double.isNaN(d2) || Double.isInfinite(d2);
    }

    public static boolean e(float f2) {
        return Float.isNaN(f2) || Float.isInfinite(f2);
    }

    private static int d(int i2, char[] cArr, int i3) {
        if (i2 < g) {
            if (i2 < 1000) {
                return b(i2, cArr, i3);
            }
            int i4 = i2 / 1000;
            return c(cArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i5 / 1000;
        int iB = b(i6, cArr, i3);
        int[] iArr = h;
        int i7 = iArr[i5 - (i6 * 1000)];
        cArr[iB] = (char) (i7 >> 16);
        cArr[iB + 1] = (char) ((i7 >> 8) & 127);
        cArr[iB + 2] = (char) (i7 & 127);
        int i8 = iArr[i2 - (i5 * 1000)];
        cArr[iB + 3] = (char) (i8 >> 16);
        cArr[iB + 4] = (char) ((i8 >> 8) & 127);
        cArr[iB + 5] = (char) (i8 & 127);
        return iB + 6;
    }

    private static int a(int i2, char[] cArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i4 / 1000;
        int[] iArr = h;
        int i6 = iArr[i5];
        cArr[i3] = (char) (i6 >> 16);
        cArr[i3 + 1] = (char) ((i6 >> 8) & 127);
        cArr[i3 + 2] = (char) (i6 & 127);
        int i7 = iArr[i4 - (i5 * 1000)];
        cArr[i3 + 3] = (char) (i7 >> 16);
        cArr[i3 + 4] = (char) ((i7 >> 8) & 127);
        cArr[i3 + 5] = (char) (i7 & 127);
        int i8 = iArr[i2 - (i4 * 1000)];
        cArr[i3 + 6] = (char) (i8 >> 16);
        cArr[i3 + 7] = (char) ((i8 >> 8) & 127);
        cArr[i3 + 8] = (char) (i8 & 127);
        return i3 + 9;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        if (i2 < g) {
            if (i2 < 1000) {
                return e(i2, bArr, i3);
            }
            int i4 = i2 / 1000;
            return c(bArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i5 / 1000;
        int iE = e(i6, bArr, i3);
        int[] iArr = h;
        int i7 = iArr[i5 - (i6 * 1000)];
        bArr[iE] = (byte) (i7 >> 16);
        bArr[iE + 1] = (byte) (i7 >> 8);
        bArr[iE + 2] = (byte) i7;
        int i8 = iArr[i2 - (i5 * 1000)];
        bArr[iE + 3] = (byte) (i8 >> 16);
        bArr[iE + 4] = (byte) (i8 >> 8);
        bArr[iE + 5] = (byte) i8;
        return iE + 6;
    }

    private static int b(int i2, byte[] bArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i4 / 1000;
        int[] iArr = h;
        int i6 = iArr[i5];
        bArr[i3] = (byte) (i6 >> 16);
        bArr[i3 + 1] = (byte) (i6 >> 8);
        bArr[i3 + 2] = (byte) i6;
        int i7 = iArr[i4 - (i5 * 1000)];
        bArr[i3 + 3] = (byte) (i7 >> 16);
        bArr[i3 + 4] = (byte) (i7 >> 8);
        bArr[i3 + 5] = (byte) i7;
        int i8 = iArr[i2 - (i4 * 1000)];
        bArr[i3 + 6] = (byte) (i8 >> 16);
        bArr[i3 + 7] = (byte) (i8 >> 8);
        bArr[i3 + 8] = (byte) i8;
        return i3 + 9;
    }

    private static int c(char[] cArr, int i2, int i3, int i4) {
        int[] iArr = h;
        int i5 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                cArr[i2] = (char) (i5 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i5 >> 8) & 127);
            i2++;
        }
        cArr[i2] = (char) (i5 & 127);
        int i6 = iArr[i4];
        cArr[i2 + 1] = (char) (i6 >> 16);
        cArr[i2 + 2] = (char) ((i6 >> 8) & 127);
        cArr[i2 + 3] = (char) (i6 & 127);
        return i2 + 4;
    }

    private static int c(byte[] bArr, int i2, int i3, int i4) {
        int[] iArr = h;
        int i5 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                bArr[i2] = (byte) (i5 >> 16);
                i2++;
            }
            bArr[i2] = (byte) (i5 >> 8);
            i2++;
        }
        bArr[i2] = (byte) i5;
        int i6 = iArr[i4];
        bArr[i2 + 1] = (byte) (i6 >> 16);
        bArr[i2 + 2] = (byte) (i6 >> 8);
        bArr[i2 + 3] = (byte) i6;
        return i2 + 4;
    }

    private static int b(int i2, char[] cArr, int i3) {
        int i4 = h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                cArr[i3] = (char) (i4 >> 16);
                i3++;
            }
            cArr[i3] = (char) ((i4 >> 8) & 127);
            i3++;
        }
        cArr[i3] = (char) (i4 & 127);
        return i3 + 1;
    }

    private static int e(int i2, byte[] bArr, int i3) {
        int i4 = h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                bArr[i3] = (byte) (i4 >> 16);
                i3++;
            }
            bArr[i3] = (byte) (i4 >> 8);
            i3++;
        }
        bArr[i3] = (byte) i4;
        return i3 + 1;
    }

    private static int e(int i2, char[] cArr, int i3) {
        int i4 = h[i2];
        cArr[i3] = (char) (i4 >> 16);
        cArr[i3 + 1] = (char) ((i4 >> 8) & 127);
        cArr[i3 + 2] = (char) (i4 & 127);
        return i3 + 3;
    }

    private static int a(int i2, byte[] bArr, int i3) {
        int i4 = h[i2];
        bArr[i3] = (byte) (i4 >> 16);
        bArr[i3 + 1] = (byte) (i4 >> 8);
        bArr[i3 + 2] = (byte) i4;
        return i3 + 3;
    }

    private static int a(char[] cArr, int i2) {
        String str = e;
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int c(byte[] bArr, int i2) {
        int length = e.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) e.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }

    private static int c(char[] cArr, int i2) {
        String str = c;
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int a(byte[] bArr, int i2) {
        int length = c.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) c.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }
}
