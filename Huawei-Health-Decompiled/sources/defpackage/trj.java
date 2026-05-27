package defpackage;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class trj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("carbohydrate")
    private float f18124a;

    @SerializedName("addedTime")
    private long b;

    @SerializedName("fileTag")
    private String c;

    @SerializedName("fat")
    private float d;

    @SerializedName("count")
    private float e;

    @SerializedName("foodId")
    private String f;

    @SerializedName("protein")
    private float g;

    @SerializedName("foodName")
    private String h;

    @SerializedName("gi")
    private float i;

    @SerializedName("kiloCalorie")
    private float j;

    @SerializedName("timeZone")
    private String k;

    @SerializedName("sodium")
    private float l;

    @SerializedName("unitId")
    private String m;

    @SerializedName("provider")
    private int n = 1;

    @SerializedName("unit")
    private String o;

    public void a(String str) {
        this.k = str;
    }

    public trj(String str, long j) {
        this.f = str;
        this.b = j;
    }

    public void l() {
        if (String.valueOf(this.b).matches("\\d{13}")) {
            this.b /= 1000;
        }
    }

    public void e(float f) {
        this.e = f;
    }

    public float d() {
        return this.e;
    }

    public String m() {
        return this.o;
    }

    public void c(String str) {
        this.o = str;
    }

    public int g() {
        return this.n;
    }

    public void k() {
        if (String.valueOf(this.b).matches("\\d{10}")) {
            this.b *= 1000;
        }
    }

    public String a() {
        return this.f;
    }

    public float f() {
        return this.i;
    }

    public void b(float f) {
        this.i = f;
    }

    public float e() {
        return this.f18124a;
    }

    public void a(float f) {
        this.f18124a = f;
    }

    public String b() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public float c() {
        return this.d;
    }

    public void d(float f) {
        this.d = f;
    }

    public float j() {
        return this.g;
    }

    public void f(float f) {
        this.g = f;
    }

    public float i() {
        return this.j;
    }

    public void c(float f) {
        this.j = f;
    }

    public float h() {
        return this.l;
    }

    public void i(float f) {
        this.l = f;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
