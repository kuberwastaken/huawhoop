package com.fasterxml.jackson.core;

import com.google.common.primitives.UnsignedBytes;
import com.huawei.operation.utils.Constants;
import defpackage.wu;
import defpackage.ye;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class Base64Variant implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1658a;
    private final transient byte[] b;
    private final transient int[] c;
    private final transient char[] d;
    private final int e;
    private final char h;
    private final boolean i;
    private final PaddingReadBehaviour j;

    public enum PaddingReadBehaviour {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int[] iArr = new int[128];
        this.c = iArr;
        char[] cArr = new char[64];
        this.d = cArr;
        this.b = new byte[64];
        this.f1658a = str;
        this.i = z;
        this.h = c;
        this.e = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + Constants.RIGHT_BRACKET_ONLY);
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this.d[i2];
            this.b[i2] = (byte) c2;
            this.c[c2] = i2;
        }
        if (z) {
            this.c[c] = -2;
        }
        this.j = z ? PaddingReadBehaviour.PADDING_REQUIRED : PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant.i, base64Variant.h, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        this(base64Variant, str, z, c, base64Variant.j, i);
    }

    private Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, PaddingReadBehaviour paddingReadBehaviour, int i) {
        int[] iArr = new int[128];
        this.c = iArr;
        char[] cArr = new char[64];
        this.d = cArr;
        byte[] bArr = new byte[64];
        this.b = bArr;
        this.f1658a = str;
        byte[] bArr2 = base64Variant.b;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant.d;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant.c;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.i = z;
        this.h = c;
        this.e = i;
        this.j = paddingReadBehaviour;
    }

    protected Object readResolve() {
        Base64Variant base64VariantC = wu.c(this.f1658a);
        boolean z = this.i;
        boolean z2 = base64VariantC.i;
        return (z == z2 && this.h == base64VariantC.h && this.j == base64VariantC.j && this.e == base64VariantC.e && z == z2) ? base64VariantC : new Base64Variant(base64VariantC, this.f1658a, z, this.h, this.j, this.e);
    }

    public String c() {
        return this.f1658a;
    }

    public boolean h() {
        return this.i;
    }

    public boolean j() {
        return this.j == PaddingReadBehaviour.PADDING_REQUIRED;
    }

    public boolean a() {
        return this.j != PaddingReadBehaviour.PADDING_FORBIDDEN;
    }

    public boolean a(char c) {
        return c == this.h;
    }

    public boolean a(int i) {
        return i == this.h;
    }

    public char i() {
        return this.h;
    }

    public int e() {
        return this.e;
    }

    public int d(char c) {
        if (c <= 127) {
            return this.c[c];
        }
        return -1;
    }

    public int d(int i) {
        if (i <= 127) {
            return this.c[i];
        }
        return -1;
    }

    public int d(int i, char[] cArr, int i2) {
        char[] cArr2 = this.d;
        cArr[i2] = cArr2[(i >> 18) & 63];
        cArr[i2 + 1] = cArr2[(i >> 12) & 63];
        cArr[i2 + 2] = cArr2[(i >> 6) & 63];
        cArr[i2 + 3] = cArr2[i & 63];
        return i2 + 4;
    }

    public void c(StringBuilder sb, int i) {
        sb.append(this.d[(i >> 18) & 63]);
        sb.append(this.d[(i >> 12) & 63]);
        sb.append(this.d[(i >> 6) & 63]);
        sb.append(this.d[i & 63]);
    }

    public int e(int i, int i2, char[] cArr, int i3) {
        char[] cArr2 = this.d;
        cArr[i3] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 2;
        cArr[i3 + 1] = cArr2[(i >> 12) & 63];
        if (!h()) {
            if (i2 != 2) {
                return i4;
            }
            cArr[i4] = this.d[(i >> 6) & 63];
            return i3 + 3;
        }
        int i5 = i3 + 3;
        cArr[i4] = i2 == 2 ? this.d[(i >> 6) & 63] : this.h;
        int i6 = i3 + 4;
        cArr[i5] = this.h;
        return i6;
    }

    public void c(StringBuilder sb, int i, int i2) {
        sb.append(this.d[(i >> 18) & 63]);
        sb.append(this.d[(i >> 12) & 63]);
        if (h()) {
            sb.append(i2 == 2 ? this.d[(i >> 6) & 63] : this.h);
            sb.append(this.h);
        } else if (i2 == 2) {
            sb.append(this.d[(i >> 6) & 63]);
        }
    }

    public int c(int i, byte[] bArr, int i2) {
        byte[] bArr2 = this.b;
        bArr[i2] = bArr2[(i >> 18) & 63];
        bArr[i2 + 1] = bArr2[(i >> 12) & 63];
        bArr[i2 + 2] = bArr2[(i >> 6) & 63];
        bArr[i2 + 3] = bArr2[i & 63];
        return i2 + 4;
    }

    public int d(int i, int i2, byte[] bArr, int i3) {
        byte[] bArr2 = this.b;
        bArr[i3] = bArr2[(i >> 18) & 63];
        int i4 = i3 + 2;
        bArr[i3 + 1] = bArr2[(i >> 12) & 63];
        if (!h()) {
            if (i2 != 2) {
                return i4;
            }
            bArr[i4] = this.b[(i >> 6) & 63];
            return i3 + 3;
        }
        byte b = (byte) this.h;
        int i5 = i3 + 3;
        bArr[i4] = i2 == 2 ? this.b[(i >> 6) & 63] : b;
        int i6 = i3 + 4;
        bArr[i5] = b;
        return i6;
    }

    public String c(byte[] bArr) {
        return a(bArr, false);
    }

    public String a(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int iE = e() >> 2;
        int i = 0;
        while (i <= length - 3) {
            byte b = bArr[i];
            c(sb, (((bArr[i + 1] & UnsignedBytes.MAX_VALUE) | (b << 8)) << 8) | (bArr[i + 2] & UnsignedBytes.MAX_VALUE));
            iE--;
            if (iE <= 0) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append('n');
                iE = e() >> 2;
            }
            i += 3;
        }
        int i2 = length - i;
        if (i2 > 0) {
            int i3 = bArr[i] << 16;
            if (i2 == 2) {
                i3 |= (bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8;
            }
            c(sb, i3, i2);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public byte[] d(String str) throws IllegalArgumentException {
        ye yeVar = new ye();
        c(str, yeVar);
        return yeVar.i();
    }

    public void c(String str, ye yeVar) throws IllegalArgumentException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt > ' ') {
                int iD = d(cCharAt);
                if (iD < 0) {
                    d(cCharAt, 0, (String) null);
                }
                if (i2 >= length) {
                    d();
                }
                int i3 = i + 2;
                char cCharAt2 = str.charAt(i2);
                int iD2 = d(cCharAt2);
                if (iD2 < 0) {
                    d(cCharAt2, 1, (String) null);
                }
                int i4 = (iD << 6) | iD2;
                if (i3 >= length) {
                    if (!j()) {
                        yeVar.e(i4 >> 4);
                        return;
                    }
                    d();
                }
                int i5 = i + 3;
                char cCharAt3 = str.charAt(i3);
                int iD3 = d(cCharAt3);
                if (iD3 < 0) {
                    if (iD3 != -2) {
                        d(cCharAt3, 2, (String) null);
                    }
                    if (!a()) {
                        b();
                    }
                    if (i5 >= length) {
                        d();
                    }
                    i += 4;
                    char cCharAt4 = str.charAt(i5);
                    if (!a(cCharAt4)) {
                        d(cCharAt4, 3, "expected padding character '" + i() + "'");
                    }
                    yeVar.e(i4 >> 4);
                } else {
                    int i6 = (i4 << 6) | iD3;
                    if (i5 >= length) {
                        if (!j()) {
                            yeVar.d(i6 >> 2);
                            return;
                        }
                        d();
                    }
                    i += 4;
                    char cCharAt5 = str.charAt(i5);
                    int iD4 = d(cCharAt5);
                    if (iD4 < 0) {
                        if (iD4 != -2) {
                            d(cCharAt5, 3, (String) null);
                        }
                        if (!a()) {
                            b();
                        }
                        yeVar.d(i6 >> 2);
                    } else {
                        yeVar.a((i6 << 6) | iD4);
                    }
                }
            } else {
                i = i2;
            }
        }
    }

    public String toString() {
        return this.f1658a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Base64Variant base64Variant = (Base64Variant) obj;
        return base64Variant.h == this.h && base64Variant.e == this.e && base64Variant.i == this.i && base64Variant.j == this.j && this.f1658a.equals(base64Variant.f1658a);
    }

    public int hashCode() {
        return this.f1658a.hashCode();
    }

    protected void d(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (a(c)) {
            str2 = "Unexpected padding character ('" + i() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    protected void d() throws IllegalArgumentException {
        throw new IllegalArgumentException(g());
    }

    protected void b() throws IllegalArgumentException {
        throw new IllegalArgumentException(f());
    }

    protected String f() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", c());
    }

    public String g() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", c(), Character.valueOf(i()));
    }
}
