package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public final class wwx {
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String e(byte[] bArr, boolean z) {
        return new String(d(bArr, z));
    }

    public static byte[] c(String str) throws wwu {
        return d(str.toCharArray());
    }

    private static char[] d(byte[] bArr, boolean z) {
        return e(bArr, z ? d : c);
    }

    private static char[] e(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    private static byte[] d(char[] cArr) throws wwu {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new wwu("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iDigit = Character.digit(cArr[i], 16);
            if (iDigit == -1) {
                throw new wwu("Illegal hexadecimal character at index " + i);
            }
            int i3 = i + 1;
            int iDigit2 = Character.digit(cArr[i3], 16);
            if (iDigit2 == -1) {
                throw new wwu("Illegal hexadecimal character at index " + i3);
            }
            i += 2;
            bArr[i2] = (byte) (((iDigit << 4) | iDigit2) & 255);
            i2++;
        }
        return bArr;
    }
}
