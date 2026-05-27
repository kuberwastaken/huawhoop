package com.huawei.appgallery.marketinstallerservice.b.b.e;

import defpackage.bbf;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static byte[] a(byte[] bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        if (bArr == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = null;
        dataOutputStream2 = null;
        dataOutputStream2 = null;
        try {
            try {
                try {
                    dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                } catch (IOException e) {
                    bbf.c("GZIPUtil", "", e);
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            dataOutputStream = dataOutputStream2;
        }
        try {
            int length = bArr.length;
            dataOutputStream.write(bArr, 0, length);
            dataOutputStream.flush();
            dataOutputStream.close();
            dataOutputStream2 = length;
        } catch (IOException e3) {
            e = e3;
            dataOutputStream2 = dataOutputStream;
            bbf.c("GZIPUtil", "gzip error!", e);
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
                dataOutputStream2 = dataOutputStream2;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e4) {
                    bbf.c("GZIPUtil", "", e4);
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
