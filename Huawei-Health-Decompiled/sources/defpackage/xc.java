package defpackage;

import com.fasterxml.jackson.core.base.GeneratorBase;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f18999a = xf.d();
    private static final byte[] e = xf.b();
    private static final xc d = new xc();

    public static xc d() {
        return d;
    }

    public char[] b(String str) {
        int iB;
        char[] cArrI = new char[30];
        int[] iArrC = xf.c();
        int length = iArrC.length;
        int length2 = str.length();
        yk ykVarA = null;
        char[] cArrA = null;
        int i = 0;
        int i2 = 0;
        loop0: while (i2 < length2) {
            do {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= length || iArrC[cCharAt] == 0) {
                    if (i >= cArrI.length) {
                        if (ykVarA == null) {
                            ykVarA = yk.a(cArrI);
                        }
                        cArrI = ykVarA.i();
                        i = 0;
                    }
                    cArrI[i] = cCharAt;
                    i2++;
                    i++;
                } else {
                    if (cArrA == null) {
                        cArrA = a();
                    }
                    char cCharAt2 = str.charAt(i2);
                    int i3 = iArrC[cCharAt2];
                    if (i3 < 0) {
                        iB = c(cCharAt2, cArrA);
                    } else {
                        iB = b(i3, cArrA);
                    }
                    int i4 = i + iB;
                    if (i4 > cArrI.length) {
                        int length3 = cArrI.length - i;
                        if (length3 > 0) {
                            System.arraycopy(cArrA, 0, cArrI, i, length3);
                        }
                        if (ykVarA == null) {
                            ykVarA = yk.a(cArrI);
                        }
                        cArrI = ykVarA.i();
                        int i5 = iB - length3;
                        System.arraycopy(cArrA, length3, cArrI, 0, i5);
                        i = i5;
                    } else {
                        System.arraycopy(cArrA, 0, cArrI, i, iB);
                        i = i4;
                    }
                    i2++;
                }
            } while (i2 < length2);
        }
        if (ykVarA == null) {
            return Arrays.copyOfRange(cArrI, 0, i);
        }
        ykVarA.c(i);
        return ykVarA.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] c(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xc.c(java.lang.String):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xc.a(java.lang.String):byte[]");
    }

    private int c(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f18999a;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int b(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int a(int i, int i2, ye yeVar, int i3) {
        yeVar.b(i3);
        yeVar.e(92);
        if (i2 < 0) {
            yeVar.e(117);
            if (i > 255) {
                byte[] bArr = e;
                yeVar.e(bArr[i >> 12]);
                yeVar.e(bArr[(i >> 8) & 15]);
                i &= 255;
            } else {
                yeVar.e(48);
                yeVar.e(48);
            }
            byte[] bArr2 = e;
            yeVar.e(bArr2[i >> 4]);
            yeVar.e(bArr2[i & 15]);
        } else {
            yeVar.e((byte) i2);
        }
        return yeVar.e();
    }

    private static int d(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - GeneratorBase.SURR1_FIRST) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void c(int i) {
        throw new IllegalArgumentException(xl.e(i));
    }

    private char[] a() {
        return new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 0, '0', '0', 0, 0};
    }
}
