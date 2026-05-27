package com.huawei.hms.network.file.core;

import com.huawei.hms.network.file.core.util.FLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    private static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Long, Integer> f5811a = new HashMap<>();

    public void c(long j) {
        synchronized (this) {
            FLogger.v("ConcurrentStatisticsMan", "updateRecord : " + j);
            if (this.f5811a.size() > 1000) {
                FLogger.w("ConcurrentStatisticsMan", "record size attach threshold", new Object[0]);
                return;
            }
            if (!this.f5811a.containsKey(Long.valueOf(j))) {
                b();
                this.f5811a.put(Long.valueOf(j), Integer.valueOf(this.f5811a.size() + 1));
            } else {
                FLogger.v("ConcurrentStatisticsMan", "requestId exist : " + j);
            }
        }
    }

    public int b(long j) {
        int iIntValue;
        synchronized (this) {
            iIntValue = this.f5811a.containsKey(Long.valueOf(j)) ? this.f5811a.get(Long.valueOf(j)).intValue() : -1;
            FLogger.v("ConcurrentStatisticsMan", "getConcurrentNum : " + j + " num is " + iIntValue);
        }
        return iIntValue;
    }

    public void a(long j) {
        synchronized (this) {
            FLogger.v("ConcurrentStatisticsMan", "eraseRecord : " + j);
            this.f5811a.remove(Long.valueOf(j));
        }
    }

    private void b() {
        for (Map.Entry<Long, Integer> entry : this.f5811a.entrySet()) {
            entry.setValue(Integer.valueOf(entry.getValue().intValue() + 1));
        }
    }

    public static a a() {
        return b;
    }
}
