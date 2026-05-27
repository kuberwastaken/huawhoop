package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class dvt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12459a;
    private long b;
    private Map<String, Object> d;

    public Map<String, Object> d() {
        return this.d;
    }

    public void e(Map<String, Object> map) {
        this.d = map;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public String e() {
        return this.f12459a;
    }

    public void b(String str) {
        this.f12459a = str;
    }

    public String toString() {
        return "BiAnalyticsInfo{mTime=" + this.b + ", mEventId='" + this.f12459a + "', mBiMap=" + this.d + '}';
    }
}
