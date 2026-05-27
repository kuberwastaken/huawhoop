package defpackage;

import health.compact.a.WhiteBoxManager;

/* JADX INFO: loaded from: classes4.dex */
public class drh {
    public static byte[] c(byte[] bArr) {
        return WhiteBoxManager.c().d(bArr);
    }

    public static String e() {
        WhiteBoxManager whiteBoxManagerC = WhiteBoxManager.c();
        return whiteBoxManagerC.a(1, 22) + whiteBoxManagerC.a(1, 1022) + whiteBoxManagerC.a(1, 2022);
    }

    public static byte[] a(int i, byte[] bArr, byte[] bArr2) {
        byte[] bArrB;
        try {
        } catch (UnsatisfiedLinkError e) {
            dna.d(false, "WhiteBoxUtil", "whiteBoxEncrypt UnsatisfiedLinkError: ", e.getMessage());
        }
        if (i == 100) {
            bArrB = WhiteBoxManager.c().b(2, bArr, bArr2);
        } else {
            if (i != 101) {
                if (i == 110) {
                    bArrB = WhiteBoxManager.c().b(0, bArr, bArr2);
                }
                return null;
            }
            bArrB = WhiteBoxManager.c().b(1, bArr, bArr2);
        }
        return bArrB;
    }
}
