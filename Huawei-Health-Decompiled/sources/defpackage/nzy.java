package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.operation.ble.BleConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class nzy implements Serializable, Cloneable {
    private static final long serialVersionUID = -6971445234843367795L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("duration")
    private long f16253a;

    @SerializedName("endTime")
    private long b;

    @SerializedName("actualCalorie")
    private float c;

    @SerializedName("actualDistance")
    private int d;

    @SerializedName("completionRate")
    private float e;

    @SerializedName("startTime")
    private long f;

    @SerializedName(BleConstants.SPORT_TYPE)
    private int g;

    @SerializedName("extraInfo")
    private String h;

    @SerializedName("recordId")
    private String i;

    @SerializedName("inPlan")
    private int j;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String m;

    @SerializedName(HwExerciseConstants.JSON_NAME_TRAINING_POINTS)
    private int n;

    @SerializedName("userWeight")
    private double o;

    public String m() {
        return this.m;
    }

    public void c(String str) {
        this.m = str;
    }

    public String g() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }

    public int j() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public long i() {
        return this.f;
    }

    public void a(long j) {
        this.f = j;
    }

    public long a() {
        return this.b;
    }

    public void e(long j) {
        this.b = j;
    }

    public long c() {
        return this.f16253a;
    }

    public void d(long j) {
        this.f16253a = j;
    }

    public int f() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public String h() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public int b() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public float d() {
        return this.c;
    }

    public void a(float f) {
        this.c = f;
    }

    public int l() {
        return this.n;
    }

    public void c(int i) {
        this.n = i;
    }

    public float e() {
        return this.e;
    }

    public void d(float f) {
        this.e = f;
    }

    public void c(double d) {
        this.o = d;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
