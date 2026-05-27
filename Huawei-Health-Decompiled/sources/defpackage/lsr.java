package defpackage;

import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class lsr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15443a;
    private long b;
    private HashMap<Integer, String> c;
    private HashMap<Integer, Double> d;
    private long e;

    public long c() {
        return this.e;
    }

    public void c(long j) {
        this.e = j;
    }

    public long a() {
        return this.b;
    }

    public void e(long j) {
        this.b = j;
    }

    public long b() {
        return this.f15443a;
    }

    public void b(long j) {
        this.f15443a = j;
    }

    public HashMap<Integer, String> d() {
        return this.c;
    }

    public void a(HashMap<Integer, String> map) {
        this.c = map;
    }

    public HashMap<Integer, Double> e() {
        return this.d;
    }

    public void d(HashMap<Integer, Double> map) {
        this.d = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{mStartTime:");
        sb.append(this.e);
        sb.append(",mEndTime:");
        sb.append(this.b);
        sb.append(",mModifyTime:");
        sb.append(this.f15443a);
        sb.append(",mFieldsValueData:");
        HashMap<Integer, Double> map = this.d;
        sb.append(map == null ? null : map.toString());
        sb.append(",mFieldsMetaData:");
        HashMap<Integer, String> map2 = this.c;
        sb.append(map2 != null ? map2.toString() : null);
        sb.append("}");
        return sb.toString();
    }
}
