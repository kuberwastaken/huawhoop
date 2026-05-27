package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class ni {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f16033a;
        public int b;
        public int d;

        public b() {
            this.f16033a = new int[256];
        }
    }

    public static byte[] d(byte[] bArr) {
        b bVarC;
        if (bArr == null || (bVarC = c("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return b(bArr, bVarC);
    }

    public static b c(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        for (int i = 0; i < 256; i++) {
            bVar.f16033a[i] = i;
        }
        bVar.b = 0;
        bVar.d = 0;
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            try {
                char cCharAt = str.charAt(length);
                int[] iArr = bVar.f16033a;
                int i4 = iArr[i3];
                i2 = ((cCharAt + i4) + i2) % 256;
                iArr[i3] = iArr[i2];
                iArr[i2] = i4;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] b(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i = bVar.b;
        int i2 = bVar.d;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = bVar.f16033a;
            int i4 = iArr[i];
            i2 = (i2 + i4) % 256;
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            int i5 = iArr[i];
            bArr[i3] = (byte) (iArr[(i5 + i4) % 256] ^ bArr[i3]);
        }
        bVar.b = i;
        bVar.d = i2;
        return bArr;
    }
}
