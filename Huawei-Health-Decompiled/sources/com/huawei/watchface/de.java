package com.huawei.watchface;

import com.huawei.watchface.utils.HwLog;
import java.io.Closeable;

/* JADX INFO: loaded from: classes8.dex */
public class de {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            HwLog.e("CloseUtils", HwLog.printException(e));
        }
    }
}
