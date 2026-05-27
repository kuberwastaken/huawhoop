package com.huawei.hms.scankit.p;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
abstract class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f6052a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    static abstract /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6053a;

        static {
            int[] iArr = new int[b.values().length];
            f6053a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6053a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6053a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6053a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6053a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6053a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private static boolean a(int i) {
        return i == 901 || i == 924 || i == 902 || i == 928 || i == 923 || i == 922;
    }

    private static b[] f(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i < 29) {
            iArr2[2] = f6052a[i];
        } else {
            if (i == 29 || i == 900) {
                bVar3 = b.ALPHA;
                return new b[]{bVar3, bVar2};
            }
            if (i == 913) {
                sb.append((char) iArr[iArr2[0]]);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static b[] b(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 65);
        } else {
            if (i != 26) {
                if (i == 900) {
                    bVar3 = b.ALPHA;
                    return new b[]{bVar3, bVar2};
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            iArr2[2] = 32;
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static b[] e(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i = iArr2[1];
        if (i < 29) {
            iArr2[2] = f6052a[i];
        } else if (i == 29 || i == 900) {
            bVar = b.ALPHA;
        } else if (i == 913) {
            sb.append((char) iArr[iArr2[0]]);
        } else {
            throw com.huawei.hms.scankit.p.a.a();
        }
        return new b[]{bVar, bVar2};
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.scankit.p.r1.b[] d(java.lang.StringBuilder r3, int[] r4, com.huawei.hms.scankit.p.r1.b r5, com.huawei.hms.scankit.p.r1.b r6, int[] r7) throws com.huawei.hms.scankit.p.a {
        /*
            r0 = 1
            r0 = r7[r0]
            r1 = 25
            r2 = 2
            if (r0 >= r1) goto Lf
            char[] r3 = com.huawei.hms.scankit.p.r1.b
            char r3 = r3[r0]
            r7[r2] = r3
            goto L3b
        Lf:
            r1 = 900(0x384, float:1.261E-42)
            if (r0 == r1) goto L39
            r1 = 913(0x391, float:1.28E-42)
            if (r0 == r1) goto L2f
            switch(r0) {
                case 25: goto L2c;
                case 26: goto L27;
                case 27: goto L24;
                case 28: goto L39;
                case 29: goto L1f;
                default: goto L1a;
            }
        L1a:
            com.huawei.hms.scankit.p.a r3 = com.huawei.hms.scankit.p.a.a()
            throw r3
        L1f:
            com.huawei.hms.scankit.p.r1$b r3 = com.huawei.hms.scankit.p.r1.b.PUNCT_SHIFT
            r6 = r5
            r5 = r3
            goto L3b
        L24:
            com.huawei.hms.scankit.p.r1$b r5 = com.huawei.hms.scankit.p.r1.b.LOWER
            goto L3b
        L27:
            r3 = 32
            r7[r2] = r3
            goto L3b
        L2c:
            com.huawei.hms.scankit.p.r1$b r5 = com.huawei.hms.scankit.p.r1.b.PUNCT
            goto L3b
        L2f:
            r0 = 0
            r7 = r7[r0]
            r4 = r4[r7]
            char r4 = (char) r4
            r3.append(r4)
            goto L3b
        L39:
            com.huawei.hms.scankit.p.r1$b r5 = com.huawei.hms.scankit.p.r1.b.ALPHA
        L3b:
            com.huawei.hms.scankit.p.r1$b[] r3 = new com.huawei.hms.scankit.p.r1.b[]{r5, r6}
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r1.d(java.lang.StringBuilder, int[], com.huawei.hms.scankit.p.r1$b, com.huawei.hms.scankit.p.r1$b, int[]):com.huawei.hms.scankit.p.r1$b[]");
    }

    private static b[] c(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        b bVar3;
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 97);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar3 = b.ALPHA_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar3 = b.PUNCT_SHIFT;
                    bVar2 = bVar;
                    bVar = bVar3;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int iA;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i == 901) {
            int[] iArr2 = new int[6];
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            boolean z = false;
            int i6 = 0;
            long j = 0;
            while (true) {
                i3 = iArr[0];
                if (i4 < i3 && !z) {
                    int i7 = i6 + 1;
                    iArr2[i6] = i5;
                    j = (j * 900) + ((long) i5);
                    int i8 = i4 + 1;
                    int i9 = iArr[i4];
                    if (i9 != 928) {
                        switch (i9) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i9) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i7 % 5 != 0 || i7 <= 0) {
                                            i4 = i8;
                                            i5 = i9;
                                            i6 = i7;
                                        } else {
                                            for (int i10 = 0; i10 < 6; i10++) {
                                                byteArrayOutputStream.write((byte) (j >> ((5 - i10) * 8)));
                                            }
                                            i4 = i8;
                                            j = 0;
                                            i5 = i9;
                                            i6 = 0;
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    z = true;
                    i5 = i9;
                    i6 = i7;
                }
            }
            if (i4 == i3 && i5 < 900) {
                iArr2[i6] = i5;
                i6++;
            }
            for (int i11 = 0; i11 < i6; i11++) {
                byteArrayOutputStream.write((byte) iArr2[i11]);
            }
            iA = i4;
        } else {
            iA = i == 924 ? a(i2, iArr, false, 0, 0L, byteArrayOutputStream) : i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return iA;
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int i2 = (iArr[0] - i) * 2;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 == 900) {
                iArr2[i3] = 900;
                i3++;
            } else if (i5 == 913) {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            } else {
                if (!a(i5)) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                z = true;
            }
            i = i4;
        }
        a(iArr2, iArr3, i3, sb);
        return i;
    }

    private static int a(int i, int[] iArr, boolean z, int i2, long j, ByteArrayOutputStream byteArrayOutputStream) throws com.huawei.hms.scankit.p.a {
        while (i < iArr[0] && !z) {
            int i3 = iArr[i];
            if (i3 < 900) {
                i2++;
                j = (j * 900) + ((long) i3);
                i++;
            } else {
                if (i3 != 928) {
                    switch (i3) {
                        default:
                            switch (i3) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    throw com.huawei.hms.scankit.p.a.a();
                            }
                        case 900:
                        case 901:
                        case 902:
                            z = true;
                            break;
                    }
                }
                z = true;
            }
            if (i2 % 5 == 0 && i2 > 0) {
                for (int i4 = 0; i4 < 6; i4++) {
                    byteArrayOutputStream.write((byte) (j >> ((5 - i4) * 8)));
                }
                j = 0;
                i2 = 0;
            }
        }
        return i;
    }

    private static b[] a(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws com.huawei.hms.scankit.p.a {
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 65);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar = b.LOWER;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar2 = bVar;
                    bVar = b.PUNCT_SHIFT;
                    break;
                default:
                    throw com.huawei.hms.scankit.p.a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r6.length() == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r8 != java.nio.charset.StandardCharsets.ISO_8859_1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        r9 = r6.length();
        r2 = new byte[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        if (r0 >= r9) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        r2[r0] = (byte) r6.charAt(r0);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        r9 = new com.huawei.hms.scankit.p.x1(null, new java.lang.String(r2, com.huawei.hms.scankit.p.c7.a(r2, r11)), null, r10);
        r9.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        throw com.huawei.hms.scankit.p.a.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        r9 = new com.huawei.hms.scankit.p.x1(null, r6.toString(), null, r10);
        r9.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
    
        throw com.huawei.hms.scankit.p.a.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.huawei.hms.scankit.p.x1 a(int[] r9, java.lang.String r10, java.util.Map r11) throws com.huawei.hms.scankit.p.a {
        /*
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r0 = r9.length
            r1 = 2
            int r0 = r0 * r1
            r6.<init>(r0)
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = 1
            r2 = r9[r2]
            com.huawei.hms.scankit.p.s5 r7 = new com.huawei.hms.scankit.p.s5
            r7.<init>()
            r8 = r0
            r3 = r1
            r1 = r2
        L15:
            r0 = 0
            r2 = r9[r0]
            if (r3 > r2) goto L4e
            if (r3 != r2) goto L23
            int r2 = r6.length()
            if (r2 <= 0) goto L23
            goto L4e
        L23:
            r0 = 927(0x39f, float:1.299E-42)
            if (r1 != r0) goto L39
            int r0 = r3 + 1
            r1 = r9[r3]
            com.huawei.hms.scankit.p.o0 r1 = com.huawei.hms.scankit.p.o0.a(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            r8 = r1
            goto L41
        L39:
            r0 = r6
            r2 = r9
            r4 = r8
            r5 = r7
            int r0 = a(r0, r1, r2, r3, r4, r5)
        L41:
            int r1 = r9.length
            if (r0 >= r1) goto L49
            int r3 = r0 + 1
            r1 = r9[r0]
            goto L15
        L49:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()
            throw r9
        L4e:
            int r9 = r6.length()
            if (r9 == 0) goto L8f
            java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.ISO_8859_1
            r1 = 0
            if (r8 != r9) goto L82
            int r9 = r6.length()
            byte[] r2 = new byte[r9]
        L5f:
            if (r0 >= r9) goto L6b
            char r3 = r6.charAt(r0)
            byte r3 = (byte) r3
            r2[r0] = r3
            int r0 = r0 + 1
            goto L5f
        L6b:
            java.lang.String r9 = com.huawei.hms.scankit.p.c7.a(r2, r11)
            java.lang.String r11 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L7d
            r11.<init>(r2, r9)     // Catch: java.io.UnsupportedEncodingException -> L7d
            com.huawei.hms.scankit.p.x1 r9 = new com.huawei.hms.scankit.p.x1
            r9.<init>(r1, r11, r1, r10)
            r9.a(r7)
            return r9
        L7d:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()
            throw r9
        L82:
            com.huawei.hms.scankit.p.x1 r9 = new com.huawei.hms.scankit.p.x1
            java.lang.String r11 = r6.toString()
            r9.<init>(r1, r11, r1, r10)
            r9.a(r7)
            return r9
        L8f:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r1.a(int[], java.lang.String, java.util.Map):com.huawei.hms.scankit.p.x1");
    }

    static int a(int[] iArr, int i, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        int i2 = 0;
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            try {
                s5Var.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int iB = b(iArr, i, sb);
                s5Var.b(sb.toString());
                int i3 = iArr[iB] == 923 ? iB + 1 : -1;
                a(iB, iArr, s5Var);
                if (i3 != -1) {
                    int i4 = iB - i3;
                    if (s5Var.a()) {
                        i4--;
                    }
                    s5Var.a(Arrays.copyOfRange(iArr, i3, i4 + i3));
                }
                return iB;
            } catch (Exception unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int[] r8, int r9, java.lang.StringBuilder r10) throws com.huawei.hms.scankit.p.a {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L47
            if (r2 != 0) goto L47
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r2 = 901(0x385, float:1.263E-42)
            if (r6 == r2) goto L31
            r2 = 928(0x3a0, float:1.3E-42)
            if (r6 == r2) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L2c;
            }
        L2c:
            com.huawei.hms.scankit.p.a r8 = com.huawei.hms.scankit.p.a.a()
            throw r8
        L31:
            r2 = r7
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = a(r0, r3)
            r10.append(r3)
            r3 = r1
            goto L7
        L47:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r1.a(int[], int, java.lang.StringBuilder):int");
    }

    private static int a(StringBuilder sb, int i, int[] iArr, int i2, Charset charset, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        if (i != 913) {
            if (i != 928) {
                switch (i) {
                    case 900:
                        return b(iArr, i2, sb);
                    case 901:
                        break;
                    case 902:
                        return a(iArr, i2, sb);
                    default:
                        switch (i) {
                            case 922:
                            case 923:
                                throw com.huawei.hms.scankit.p.a.a();
                            case 924:
                                break;
                            case 925:
                                break;
                            case 926:
                                return i2 + 2;
                            default:
                                return b(iArr, i2 - 1, sb);
                        }
                        break;
                }
                return a(i, iArr, charset, i2, sb);
            }
            return a(iArr, i2, s5Var);
        }
        sb.append((char) iArr[i2]);
        return i2 + 1;
    }

    private static void a(int i, int[] iArr, s5 s5Var) throws com.huawei.hms.scankit.p.a {
        while (i < iArr[0]) {
            int i2 = iArr[i];
            if (i2 == 923) {
                int i3 = iArr[i + 1];
                if (i3 == 0) {
                    StringBuilder sb = new StringBuilder();
                    i = b(iArr, i + 2, sb);
                    s5Var.c(sb.toString());
                } else if (i3 == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    i = b(iArr, i + 2, sb2);
                    s5Var.d(sb2.toString());
                } else if (i3 == 4) {
                    StringBuilder sb3 = new StringBuilder();
                    i = b(iArr, i + 2, sb3);
                    s5Var.a(sb3.toString());
                } else if (i3 == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    i = a(iArr, i + 2, sb4);
                    s5Var.b(Integer.parseInt(sb4.toString()));
                } else if (i3 == 2) {
                    StringBuilder sb5 = new StringBuilder();
                    i = a(iArr, i + 2, sb5);
                    s5Var.b(Long.parseLong(sb5.toString()));
                } else if (i3 == 6) {
                    StringBuilder sb6 = new StringBuilder();
                    i = a(iArr, i + 2, sb6);
                    s5Var.a(Integer.parseInt(sb6.toString()));
                } else if (i3 == 5) {
                    StringBuilder sb7 = new StringBuilder();
                    i = a(iArr, i + 2, sb7);
                    s5Var.a(Long.parseLong(sb7.toString()));
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else if (i2 == 922) {
                i++;
                s5Var.a(true);
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        b bVar = b.ALPHA;
        b bVar2 = bVar;
        int i2 = 0;
        while (i2 < i) {
            int[] iArr3 = {i2, iArr[i2], 0};
            b[] bVarArrA = {bVar, bVar2};
            switch (a.f6053a[bVar.ordinal()]) {
                case 1:
                    bVarArrA = a(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 2:
                    bVarArrA = c(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 3:
                    bVarArrA = d(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 4:
                    bVarArrA = e(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 5:
                    bVarArrA = b(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 6:
                    bVarArrA = f(sb, iArr2, bVar, bVar2, iArr3);
                    break;
            }
            bVar = bVarArrA[0];
            b bVar3 = bVarArrA[1];
            int i3 = iArr3[0];
            char c2 = (char) iArr3[2];
            if (c2 != 0) {
                sb.append(c2);
            }
            i2 = i3 + 1;
            bVar2 = bVar3;
        }
    }

    private static String a(int[] iArr, int i) throws com.huawei.hms.scankit.p.a {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
