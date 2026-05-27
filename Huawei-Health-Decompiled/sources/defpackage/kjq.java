package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class kjq {
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] b(byte[] bArr, boolean z) {
        return c(bArr, z ? d : c);
    }

    private static char[] c(byte[] bArr, char[] cArr) {
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

    public static String d(byte[] bArr, boolean z) {
        return new String(b(bArr, z));
    }

    private static byte[] c(char[] cArr) throws IllegalArgumentException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Number of characters illegal.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iC = c(cArr[i], i);
            int i3 = i + 1;
            i += 2;
            bArr[i2] = (byte) (((iC << 4) | c(cArr[i3], i3)) & 255);
            i2++;
        }
        return bArr;
    }

    private static int c(char c2, int i) throws IllegalArgumentException {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new IllegalArgumentException("toDigitInt IllegalArgumentException " + c2 + " at index " + i);
    }

    public static byte[] b(String str) throws IllegalArgumentException {
        return c(str.toCharArray());
    }
}
