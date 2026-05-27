package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lvw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15501a;
    private long b;
    private int c;
    private int d;
    private long e;
    private List<lvv> j;

    public long d() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public long e() {
        return this.e;
    }

    public void d(long j) {
        this.e = j;
    }

    public void c(int i) {
        this.f15501a = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public List<lvv> a() {
        return this.j;
    }

    public void a(List<lvv> list) {
        this.j = list;
    }

    public int b() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public String toString() {
        return "BloodOxygenDownRemindStruct{mBloodOxygenDownRemindStartTime=" + this.b + ", mBloodOxygenDownRemindEndTime=" + this.e + ", mBloodOxygenDownRemindMinNumber=" + this.f15501a + ", mBloodOxygenDownRemindMaxNumber=" + this.d + ", mBloodOxygenDownValueStructs=" + this.j + ", mBloodOxygenDownThresholdNumber=" + this.c + '}';
    }
}
