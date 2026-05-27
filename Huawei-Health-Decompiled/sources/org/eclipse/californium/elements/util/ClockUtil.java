package org.eclipse.californium.elements.util;

/* JADX INFO: loaded from: classes8.dex */
public class ClockUtil {
    private static volatile Realtime d = new Realtime() { // from class: org.eclipse.californium.elements.util.ClockUtil.3
        @Override // org.eclipse.californium.elements.util.ClockUtil.Realtime
        public long nanoRealtime() {
            return System.nanoTime();
        }
    };

    public interface Realtime {
        long nanoRealtime();
    }

    public static long b() {
        return d.nanoRealtime();
    }
}
