package com.huawei.hihealth;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class HiZipUtil {
    private HiZipUtil() {
    }

    public static void d(String str, OutputStream outputStream) throws IOException {
        if (str == null || str.length() == 0 || outputStream == null) {
            Log.e("HiZipUtil", "uncompress null param");
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i = gZIPInputStream.read(bArr);
                    if (i >= 0) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return;
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String d(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        try {
            byte[] bArr = new byte[256];
            while (true) {
                int i = gZIPInputStream.read(bArr);
                if (i >= 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toString(str);
                }
            }
        } finally {
            d(gZIPInputStream);
            byteArrayOutputStream.toString("utf-8");
            d(byteArrayInputStream);
            d(byteArrayOutputStream);
        }
    }

    private static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("HiZipUtil", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }
}
