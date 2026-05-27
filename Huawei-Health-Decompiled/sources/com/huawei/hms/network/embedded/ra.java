package com.huawei.hms.network.embedded;

import androidx.media3.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes10.dex */
public final class ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5649a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public char[] g;

    public String a(String str) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f5649a.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i = this.c;
            if (i == this.b) {
                return null;
            }
            char c = this.g[i];
            String strA = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : a() : d() : f();
            if (str.equalsIgnoreCase(strE)) {
                return strA;
            }
            int i2 = this.c;
            if (i2 >= this.b) {
                return null;
            }
            char c2 = this.g[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f5649a);
            }
            this.c = i2 + 1;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.f5649a);
    }

    private String f() {
        int i = this.c + 1;
        this.c = i;
        this.d = i;
        while (true) {
            this.e = i;
            int i2 = this.c;
            if (i2 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5649a);
            }
            char[] cArr = this.g;
            char c = cArr[i2];
            if (c == '\"') {
                do {
                    i2++;
                    this.c = i2;
                    if (i2 >= this.b) {
                        break;
                    }
                } while (this.g[i2] == ' ');
                char[] cArr2 = this.g;
                int i3 = this.d;
                return new String(cArr2, i3, this.e - i3);
            }
            if (c == '\\') {
                cArr[i] = b();
            } else {
                cArr[i] = c;
            }
            this.c++;
            i = this.e + 1;
        }
    }

    private String e() {
        int i;
        int i2;
        int i3;
        char c;
        char c2;
        char c3;
        int i4;
        int i5;
        char c4;
        char c5;
        while (true) {
            i = this.c;
            i2 = this.b;
            if (i >= i2 || this.g[i] != ' ') {
                break;
            }
            this.c = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.d = i;
        do {
            i++;
            this.c = i;
            i3 = this.b;
            if (i >= i3 || (c5 = this.g[i]) == '=') {
                break;
            }
        } while (c5 != ' ');
        if (i >= i3) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5649a);
        }
        this.e = i;
        if (this.g[i] == ' ') {
            while (true) {
                i4 = this.c;
                i5 = this.b;
                if (i4 >= i5 || (c4 = this.g[i4]) == '=' || c4 != ' ') {
                    break;
                }
                this.c = i4 + 1;
            }
            if (this.g[i4] != '=' || i4 == i5) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5649a);
            }
        }
        int i6 = this.c;
        do {
            i6++;
            this.c = i6;
            if (i6 >= this.b) {
                break;
            }
        } while (this.g[i6] == ' ');
        int i7 = this.e;
        int i8 = this.d;
        if (i7 - i8 > 4) {
            char[] cArr = this.g;
            if (cArr[i8 + 3] == '.' && (((c = cArr[i8]) == 'O' || c == 'o') && (((c2 = cArr[i8 + 1]) == 'I' || c2 == 'i') && ((c3 = cArr[i8 + 2]) == 'D' || c3 == 'd')))) {
                this.d = i8 + 4;
            }
        }
        char[] cArr2 = this.g;
        int i9 = this.d;
        return new String(cArr2, i9, i7 - i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r6.e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.c
            int r1 = r0 + 4
            int r2 = r6.b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L89
            r6.d = r0
        Lc:
            int r0 = r0 + 1
            r6.c = r0
            int r1 = r6.b
            if (r0 == r1) goto L48
            char[] r1 = r6.g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L48
            r4 = 44
            if (r2 == r4) goto L48
            r4 = 59
            if (r2 != r4) goto L25
            goto L48
        L25:
            r4 = 32
            if (r2 != r4) goto L3a
            r6.e = r0
        L2b:
            int r0 = r0 + 1
            r6.c = r0
            int r1 = r6.b
            if (r0 >= r1) goto L4a
            char[] r1 = r6.g
            char r1 = r1[r0]
            if (r1 != r4) goto L4a
            goto L2b
        L3a:
            r4 = 65
            if (r2 < r4) goto Lc
            r4 = 70
            if (r2 > r4) goto Lc
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
            goto Lc
        L48:
            r6.e = r0
        L4a:
            int r0 = r6.e
            int r1 = r6.d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L75
            r2 = r0 & 1
            if (r2 == 0) goto L75
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L5d:
            if (r4 >= r2) goto L6b
            int r5 = r6.a(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L5d
        L6b:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.g
            int r3 = r6.d
            r1.<init>(r2, r3, r0)
            return r1
        L75:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.f5649a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L89:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.f5649a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.ra.d():java.lang.String");
    }

    private char c() {
        int i;
        int i2;
        int iA = a(this.c);
        this.c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i = iA & 31;
            i2 = 1;
        } else if (iA <= 239) {
            i = iA & 15;
            i2 = 2;
        } else {
            i = iA & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i5 == this.b || this.g[i5] != '\\') {
                return '?';
            }
            int i6 = i4 + 2;
            this.c = i6;
            int iA2 = a(i6);
            this.c++;
            if ((iA2 & PsExtractor.AUDIO_STREAM) != 128) {
                return '?';
            }
            i = (i << 6) + (iA2 & 63);
        }
        return (char) i;
    }

    private char b() {
        int i = this.c + 1;
        this.c = i;
        if (i == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5649a);
        }
        char c = this.g[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return c();
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        r0 = r8.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return new java.lang.String(r1, r0, r8.e - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.c
            r8.d = r0
            r8.e = r0
        L6:
            int r0 = r8.c
            int r1 = r8.b
            if (r0 < r1) goto L19
            char[] r0 = r8.g
            int r1 = r8.d
            java.lang.String r2 = new java.lang.String
            int r3 = r8.e
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            return r2
        L19:
            char[] r1 = r8.g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L58
            if (r2 == r5) goto L4d
            r5 = 92
            if (r2 == r5) goto L3a
            if (r2 == r4) goto L4d
            if (r2 == r3) goto L4d
            int r3 = r8.e
            int r4 = r3 + 1
            r8.e = r4
            r1[r3] = r2
            goto L48
        L3a:
            int r0 = r8.e
            int r2 = r0 + 1
            r8.e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.c
        L48:
            int r0 = r0 + 1
            r8.c = r0
            goto L6
        L4d:
            int r0 = r8.d
            java.lang.String r2 = new java.lang.String
            int r3 = r8.e
            int r3 = r3 - r0
            r2.<init>(r1, r0, r3)
            return r2
        L58:
            int r2 = r8.e
            r8.f = r2
            int r0 = r0 + 1
            r8.c = r0
            int r0 = r2 + 1
            r8.e = r0
            r1[r2] = r6
        L66:
            int r0 = r8.c
            int r1 = r8.b
            if (r0 >= r1) goto L7f
            char[] r2 = r8.g
            char r7 = r2[r0]
            if (r7 != r6) goto L7f
            int r1 = r8.e
            int r7 = r1 + 1
            r8.e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.c = r0
            goto L66
        L7f:
            if (r0 == r1) goto L8b
            char[] r1 = r8.g
            char r0 = r1[r0]
            if (r0 == r3) goto L8b
            if (r0 == r4) goto L8b
            if (r0 != r5) goto L6
        L8b:
            char[] r0 = r8.g
            int r1 = r8.d
            java.lang.String r2 = new java.lang.String
            int r3 = r8.f
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.ra.a():java.lang.String");
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.f5649a);
        }
        char[] cArr = this.g;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5649a);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5649a);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public ra(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f5649a = name;
        this.b = name.length();
    }
}
