package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class nzz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("realIntensityZone")
    private List<Integer> f16254a;

    @SerializedName("lastWeekCalorie")
    private float b;

    @SerializedName("realLastWeekDuration")
    private int c;

    @SerializedName("lastWeekDistance")
    private double d;

    @SerializedName("coachComments")
    private String e;

    @SerializedName("targetIntensityZone")
    private List<Integer> i;

    @SerializedName("targetWeekDuration")
    private int j;

    public double b() {
        return this.d;
    }

    public void c(double d) {
        this.d = d;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public float a() {
        return this.b;
    }

    public void a(float f) {
        this.b = f;
    }

    public List<Integer> d() {
        return this.i;
    }

    public void b(List<Integer> list) {
        this.i = list;
    }

    public List<Integer> c() {
        return this.f16254a;
    }

    public void c(List<Integer> list) {
        this.f16254a = list;
    }
}
