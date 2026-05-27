package defpackage;

import com.google.common.base.Ascii;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class kp {
    public static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        if (r2 != (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        r0.append((char) (r2 | ((r5 & 3) << 6)));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r8) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "US-ASCII"
            byte[] r8 = r8.getBytes(r1)
            int r1 = r8.length
            r2 = 0
        Ld:
            if (r2 >= r1) goto L84
        Lf:
            byte[] r3 = defpackage.kp.b
            int r4 = r2 + 1
            r2 = r8[r2]
            r2 = r3[r2]
            r3 = -1
            if (r4 >= r1) goto L1f
            if (r2 == r3) goto L1d
            goto L1f
        L1d:
            r2 = r4
            goto Lf
        L1f:
            if (r2 != r3) goto L23
            goto L84
        L23:
            byte[] r5 = defpackage.kp.b
            int r6 = r4 + 1
            r4 = r8[r4]
            r4 = r5[r4]
            if (r6 >= r1) goto L32
            if (r4 == r3) goto L30
            goto L32
        L30:
            r4 = r6
            goto L23
        L32:
            if (r4 != r3) goto L35
            goto L84
        L35:
            int r2 = r2 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r2 = r2 | r5
            char r2 = (char) r2
            r0.append(r2)
        L40:
            int r2 = r6 + 1
            r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L49
            goto L84
        L49:
            byte[] r7 = defpackage.kp.b
            r5 = r7[r5]
            if (r2 >= r1) goto L54
            if (r5 == r3) goto L52
            goto L54
        L52:
            r6 = r2
            goto L40
        L54:
            if (r5 != r3) goto L57
            goto L84
        L57:
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            char r4 = (char) r4
            r0.append(r4)
        L64:
            int r4 = r2 + 1
            r2 = r8[r2]
            if (r2 != r6) goto L6b
            goto L84
        L6b:
            byte[] r7 = defpackage.kp.b
            r2 = r7[r2]
            if (r4 >= r1) goto L76
            if (r2 == r3) goto L74
            goto L76
        L74:
            r2 = r4
            goto L64
        L76:
            if (r2 != r3) goto L79
            goto L84
        L79:
            r3 = r5 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            char r2 = (char) r2
            r0.append(r2)
            r2 = r4
            goto Ld
        L84:
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "iso8859-1"
            byte[] r8 = r8.getBytes(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kp.a(java.lang.String):byte[]");
    }
}
