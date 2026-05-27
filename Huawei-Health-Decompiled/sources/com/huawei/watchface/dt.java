package com.huawei.watchface;

import com.huawei.watchface.utils.HwLog;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class dt {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HwLog.e("IoUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }
}
