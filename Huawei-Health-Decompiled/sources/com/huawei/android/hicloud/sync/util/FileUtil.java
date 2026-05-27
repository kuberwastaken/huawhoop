package com.huawei.android.hicloud.sync.util;

import defpackage.avi;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FileUtil {
    public static final String TAG = "FileUtil";

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                avi.c(TAG, "Closeable exception" + e);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(1:74)|(5:68|3|4|75|5)|(3:6|(1:8)(1:78)|59)|9|(2:11|12)|70|13|59|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        defpackage.avi.c(com.huawei.android.hicloud.sync.util.FileUtil.TAG, "Close FileInputStream failed!");
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00da: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:61:0x00da */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.util.FileUtil.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }
}
