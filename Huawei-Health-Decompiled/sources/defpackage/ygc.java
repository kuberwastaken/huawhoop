package defpackage;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: classes8.dex */
public class ygc {
    public static final byte[] d = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19292a;
    private String b;
    private final int c;
    private final byte[] e;

    public ygc(byte[] bArr) {
        this(bArr, 255, false);
    }

    public ygc(byte[] bArr, int i, boolean z) {
        this(bArr, i, z, false);
    }

    public ygc(byte[] bArr, int i, boolean z, boolean z2) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null");
        }
        if (bArr.length > i) {
            throw new IllegalArgumentException("bytes length must be between 0 and " + i + " inclusive");
        }
        this.f19292a = z2;
        this.e = z ? Arrays.copyOf(bArr, bArr.length) : bArr;
        this.c = Arrays.hashCode(bArr);
    }

    public String toString() {
        return "BYTES=" + d();
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ygc)) {
            return false;
        }
        ygc ygcVar = (ygc) obj;
        if (((this.f19292a || ygcVar.f19292a) && getClass() != obj.getClass()) || this.c != ygcVar.c) {
            return false;
        }
        return Arrays.equals(this.e, ygcVar.e);
    }

    public final byte[] c() {
        return this.e;
    }

    public final String d() {
        if (this.b == null) {
            this.b = ygp.e(this.e);
        }
        return this.b;
    }

    public final boolean b() {
        return this.e.length == 0;
    }

    public final int a() {
        return this.e.length;
    }

    public static byte[] b(Random random, int i) {
        byte[] bArr = new byte[i];
        try {
            random.nextBytes(bArr);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Number of bits per request limited ") && i > 4096) {
                byte[] bArr2 = new byte[4096];
                int i2 = 0;
                while (i2 < i) {
                    random.nextBytes(bArr2);
                    int iMin = Math.min(i - i2, 4096);
                    System.arraycopy(bArr2, 0, bArr, i2, iMin);
                    i2 += iMin;
                }
            }
        }
        return bArr;
    }

    public static byte[] d(ygc ygcVar, ygc ygcVar2) {
        return d(ygcVar.c(), ygcVar2.c());
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length + length2];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr2, 0, bArr3, length, length2);
        return bArr3;
    }

    public static void e(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }

    public static boolean a(ygc ygcVar, ygc ygcVar2) {
        if (ygcVar == ygcVar2) {
            return true;
        }
        if (ygcVar == null || ygcVar2 == null) {
            return false;
        }
        return ygcVar.equals(ygcVar2);
    }
}
