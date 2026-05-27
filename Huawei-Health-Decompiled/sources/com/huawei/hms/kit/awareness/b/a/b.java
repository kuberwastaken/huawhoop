package com.huawei.hms.kit.awareness.b.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5011a = "ConcurrentUtils";

    /* JADX INFO: renamed from: com.huawei.hms.kit.awareness.b.a.b$b, reason: collision with other inner class name */
    public static class C0142b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f5013a;

        public final boolean c() {
            return this.f5013a.getCount() == 0;
        }

        public final void b() {
            this.f5013a.countDown();
        }

        public final boolean a(long j) {
            return b.b(this.f5013a, j);
        }

        public static C0142b a(int i) {
            return new C0142b(i);
        }

        private C0142b(int i) {
            this.f5013a = new CountDownLatch(i);
        }
    }

    public static final class a extends C0142b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f5012a = 1;

        public static a a() {
            return new a();
        }

        private a() {
            super(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(CountDownLatch countDownLatch, long j) {
        try {
            return countDownLatch.await(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            c.d(f5011a, "CountDownLatch Waiting Failed.", new Object[0]);
            return false;
        }
    }

    private b() {
    }
}
