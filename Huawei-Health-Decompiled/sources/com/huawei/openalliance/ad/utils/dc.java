package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.hq;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public abstract class dc {
    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                hq.c(com.huawei.hms.ads.uiengineloader.aj.f4559a, "read stream ex: %s", th.getClass().getSimpleName());
                return null;
            } finally {
                a(byteArrayOutputStream);
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                hq.c(com.huawei.hms.ads.uiengineloader.aj.f4559a, "close HttpURLConnection Exception:" + th.getClass().getSimpleName());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                hq.c(com.huawei.hms.ads.uiengineloader.aj.f4559a, "close " + th.getClass().getSimpleName());
            }
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    static String a() {
        return "818f41d42d2b7048a92678b7309e0f04a60a6dd9562b567d3de93f849e5a4c31";
    }
}
