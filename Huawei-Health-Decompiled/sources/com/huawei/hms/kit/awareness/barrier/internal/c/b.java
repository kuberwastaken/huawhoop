package com.huawei.hms.kit.awareness.barrier.internal.c;

import com.huawei.hms.kit.awareness.barrier.BarrierStatus;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends BarrierStatus {
    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public long getLastBarrierUpdateTime() {
        return 0L;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public int getLastStatus() {
        return 0;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public int getPresentStatus() {
        return 0;
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5049a = new b();

        private a() {
        }
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public String getBarrierLabel() {
        return "mock";
    }

    public static b a() {
        return a.f5049a;
    }

    private b() {
    }
}
