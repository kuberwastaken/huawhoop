package com.huawei.profile.executor;

import com.huawei.profile.trace.TraceIdManager;

/* JADX INFO: loaded from: classes7.dex */
public final class TracedRunnable implements Runnable {
    private Runnable runnable;
    private String traceId = TraceIdManager.getTraceId();

    public TracedRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String strGenTraceId = this.traceId;
            if (strGenTraceId == null) {
                strGenTraceId = TraceIdManager.genTraceId();
            }
            TraceIdManager.resetTraceId(strGenTraceId);
            this.runnable.run();
        } finally {
            TraceIdManager.clearTraceId();
        }
    }
}
