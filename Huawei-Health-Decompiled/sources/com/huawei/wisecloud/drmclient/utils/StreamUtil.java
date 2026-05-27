package com.huawei.wisecloud.drmclient.utils;

import com.huawei.hms.ads.uiengineloader.aj;
import com.huawei.wisecloud.drmclient.exception.HwDrmException;
import com.huawei.wisecloud.drmclient.log.HwDrmLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class StreamUtil {
    public static byte[] toByteArray(InputStream inputStream) throws HwDrmException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[4096];
            } finally {
            }
        } catch (IOException e) {
            String str = "fail to convert InputStream, IOException: " + HwDrmLog.printException((Exception) e);
            HwDrmLog.e(aj.f4559a, str);
            throw new HwDrmException(str);
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            String str2 = "fail to convert InputStream, IOException: " + HwDrmLog.printException((Exception) e);
            HwDrmLog.e(aj.f4559a, str2);
            throw new HwDrmException(str2);
        }
    }
}
