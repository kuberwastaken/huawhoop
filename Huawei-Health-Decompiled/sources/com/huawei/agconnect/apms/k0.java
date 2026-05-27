package com.huawei.agconnect.apms;

import android.os.Process;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class k0 {
    public static final AtomicInteger abc = new AtomicInteger(0);
    public static final AtomicInteger bcd = new AtomicInteger(0);
    public static final String cde;
    public static final String def;
    public static final String efg;

    static {
        String string;
        String strValueOf = String.valueOf(Process.myPid());
        if (strValueOf.length() >= 6) {
            string = strValueOf.substring(0, 6);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6 - strValueOf.length(); i++) {
                sb.append('0');
            }
            sb.append(strValueOf);
            string = sb.toString();
        }
        cde = string;
        String strSubstring = UUID.randomUUID().toString().substring(0, 8);
        def = strSubstring + string + "d";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strSubstring);
        sb2.append(string.substring(2, 6));
        efg = sb2.toString();
    }

    public static String abc() {
        StringBuilder sb = new StringBuilder(16);
        long jNanoTime = System.nanoTime();
        long jIncrementAndGet = (bcd.incrementAndGet() & 7) << 10;
        sb.append(efg);
        sb.append(((jNanoTime >> 10) & 1023) + jIncrementAndGet + 1000);
        return sb.toString();
    }

    public static String bcd() {
        StringBuilder sb = new StringBuilder(32);
        int iIncrementAndGet = abc.incrementAndGet();
        sb.append(def);
        sb.append(System.currentTimeMillis());
        sb.append((iIncrementAndGet & HmsScanBase.ALL_SCAN_TYPE) + 1000);
        return sb.toString();
    }
}
