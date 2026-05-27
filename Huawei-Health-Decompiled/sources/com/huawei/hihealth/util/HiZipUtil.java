package com.huawei.hihealth.util;

import health.compact.a.util.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class HiZipUtil {
    public static String b(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(str.getBytes("utf-8"));
            return byteArrayOutputStream.toString(str);
        } finally {
            a(gZIPOutputStream);
            byteArrayOutputStream.toString("ISO-8859-1");
            a(byteArrayOutputStream);
        }
    }

    public static String c(String str) throws IOException {
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
            a(gZIPInputStream);
            byteArrayOutputStream.toString("utf-8");
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                LogUtil.d("HiZipUtil", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }
}
