package com.huawei.maps.offlinedata.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class e {
    public static void a(String str, Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                    g.d(str, "IOException ::: cannot close io stream !");
                }
            }
        }
    }
}
