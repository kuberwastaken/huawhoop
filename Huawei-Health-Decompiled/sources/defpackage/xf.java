package defpackage;

import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int[] f19000a;
    protected static final int[] b;
    protected static final byte[] c;
    protected static final char[] d;
    protected static final int[] e;
    protected static final int[] f;
    protected static final int[] g;
    protected static final int[] h;
    protected static final int[] i;
    protected static final int[] j;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        d = charArray;
        int length = charArray.length;
        c = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            c[i2] = (byte) d[i2];
        }
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr[i3] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        b = iArr;
        int[] iArr2 = new int[256];
        System.arraycopy(iArr, 0, iArr2, 0, 256);
        for (int i4 = 128; i4 < 256; i4++) {
            iArr2[i4] = (i4 & 224) == 192 ? 2 : (i4 & 240) == 224 ? 3 : (i4 & 248) == 240 ? 4 : -1;
        }
        i = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i5 = 33; i5 < 256; i5++) {
            if (Character.isJavaIdentifierPart((char) i5)) {
                iArr3[i5] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        h = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, 128, 128, 0);
        g = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = i;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        e = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        f = iArr7;
        int[] iArr8 = new int[128];
        for (int i6 = 0; i6 < 32; i6++) {
            iArr8[i6] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        j = iArr8;
        int[] iArr9 = new int[256];
        f19000a = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i7 = 0; i7 < 10; i7++) {
            f19000a[i7 + 48] = i7;
        }
        for (int i8 = 0; i8 < 6; i8++) {
            int[] iArr10 = f19000a;
            int i9 = i8 + 10;
            iArr10[i8 + 97] = i9;
            iArr10[i8 + 65] = i9;
        }
    }

    public static int[] e() {
        return b;
    }

    public static int[] g() {
        return i;
    }

    public static int[] j() {
        return h;
    }

    public static int[] i() {
        return g;
    }

    public static int[] a() {
        return e;
    }

    public static int[] c() {
        return j;
    }

    public static int[] a(int i2) {
        if (i2 == 34) {
            return j;
        }
        return c.b.c(i2);
    }

    public static int e(int i2) {
        return f19000a[i2 & 255];
    }

    public static void a(StringBuilder sb, String str) {
        int[] iArr = j;
        int length = iArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb.append(cCharAt);
            } else {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                int i3 = iArr[cCharAt];
                if (i3 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    char[] cArr = d;
                    sb.append(cArr[cCharAt >> 4]);
                    sb.append(cArr[cCharAt & 15]);
                } else {
                    sb.append((char) i3);
                }
            }
        }
    }

    public static char[] d() {
        return (char[]) d.clone();
    }

    public static byte[] b() {
        return (byte[]) c.clone();
    }

    static class c {
        public static final c b = new c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[][] f19001a = new int[128][];

        private c() {
        }

        public int[] c(int i) {
            int[] iArrCopyOf = this.f19001a[i];
            if (iArrCopyOf == null) {
                iArrCopyOf = Arrays.copyOf(xf.j, 128);
                if (iArrCopyOf[i] == 0) {
                    iArrCopyOf[i] = -1;
                }
                this.f19001a[i] = iArrCopyOf;
            }
            return iArrCopyOf;
        }
    }
}
