package com.huawei.hms.utils;

import android.content.res.AssetManager;
import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Reader reader) {
        closeQuietly((Closeable) reader);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static byte[] readAssetsFile(AssetManager assetManager, String str) {
        byte[] bArr;
        if (assetManager == null || str == null) {
            HMSLog.e("IOUtils", "readAssetFile args error");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = assetManager.open(str);
                bArr = new byte[1024];
            } catch (IOException e) {
                HMSLog.e("IOUtils", String.format(Locale.ROOT, "Failed to open %s", str), e);
                closeQuietly(inputStreamOpen);
                closeQuietly((OutputStream) byteArrayOutputStream);
                return new byte[0];
            }
        } finally {
            closeQuietly(inputStreamOpen);
            closeQuietly((OutputStream) byteArrayOutputStream);
        }
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
            closeQuietly(inputStreamOpen);
            closeQuietly((OutputStream) byteArrayOutputStream);
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream toInputStream(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    public static void closeQuietly(Writer writer) {
        closeQuietly((Closeable) writer);
    }

    public static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    public static void closeQuietly(OutputStream outputStream) {
        closeQuietly((Closeable) outputStream);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.e("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        if (inputStream != null && outputStream != null) {
            if (bArr == null) {
                bArr = new byte[4096];
            }
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    break;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            }
        }
        return j;
    }
}
