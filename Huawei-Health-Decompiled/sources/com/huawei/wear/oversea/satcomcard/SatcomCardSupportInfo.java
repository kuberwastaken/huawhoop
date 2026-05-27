package com.huawei.wear.oversea.satcomcard;

/* JADX INFO: loaded from: classes8.dex */
public class SatcomCardSupportInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11737a;
    private int c;
    private int d;

    /* JADX INFO: loaded from: classes11.dex */
    public interface ActivityPeriodConstant {
        public static final int ACTIVITY_PERIOD_FORMAL = 2;
        public static final int ACTIVITY_PERIOD_MASSTEST = 1;
        public static final int ACTIVITY_PERIOD_STOP = 0;
    }

    public boolean d() {
        return this.f11737a;
    }

    public void b(boolean z) {
        this.f11737a = z;
    }

    public int b() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public String toString() {
        return "SatcomCardSupportInfo{isSupportSatcomCard=" + this.f11737a + ", activityPeriod=" + this.c + ", returnCode=" + this.d + '}';
    }
}
