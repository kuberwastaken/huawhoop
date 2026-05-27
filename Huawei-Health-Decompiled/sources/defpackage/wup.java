package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes8.dex */
public final class wup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f18939a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static char[] c(byte[] bArr, boolean z) {
        return a(bArr, z ? e : f18939a);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[0];
        if (bArr == null) {
            wrm.b("HexUtil", "encodeHex dataByte is null");
            return cArr2;
        }
        if (cArr == null) {
            wrm.b("HexUtil", "encodeHex toDigits is null");
            return cArr2;
        }
        if (bArr.length > 65535) {
            wrm.b("HexUtil", "encodeHex dataByte's length is too large");
            return cArr2;
        }
        char[] cArr3 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr3[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr3[i2] = cArr[b & 15];
        }
        return cArr3;
    }

    public static String a(byte[] bArr, boolean z) {
        return new String(c(bArr, z));
    }

    public static String e(File file) {
        FileInputStream fileInputStream;
        if (file == null) {
            wrm.b("HexUtil", "getFileShaHex file is null");
            return null;
        }
        if (!file.exists()) {
            wrm.b("HexUtil", "getFileShaHex file not exit");
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            wrm.b("HexUtil", "getFileShaHex FileNotFoundException");
            fileInputStream = null;
        }
        try {
            if (fileInputStream == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] bArr = new byte[4096];
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    messageDigest.update(bArr, 0, 0);
                } else {
                    messageDigest.update(bArr, 0, i);
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                }
                return a(messageDigest.digest(), true);
            } catch (IOException unused2) {
                wrm.b("HexUtil", "getFileShaHex IOException");
                try {
                    fileInputStream.close();
                    return "";
                } catch (IOException unused3) {
                    wrm.b("HexUtil", "getFileShaHex IOException");
                    return "";
                }
            } catch (NoSuchAlgorithmException unused4) {
                wrm.b("HexUtil", "getFileShaHex NoSuchAlgorithmException");
                fileInputStream.close();
                return "";
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused5) {
                wrm.b("HexUtil", "getFileShaHex IOException");
            }
        }
    }
}
