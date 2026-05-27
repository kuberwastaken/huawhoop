package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;

/* JADX INFO: loaded from: classes.dex */
public class htm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("extendData")
    private String f13966a;

    @SerializedName("examinationReport")
    private String b;

    @SerializedName("deviceCode")
    private String c;

    @SerializedName("examinationDate")
    private int d;

    @SerializedName("examinationInstitution")
    private String e;

    @SerializedName(CommonConstant.KEY_GENDER)
    private int f;

    @SerializedName("name")
    private String g;

    @SerializedName("generateTime")
    private long h;

    @SerializedName("recordType")
    private int i;

    @SerializedName("recordName")
    private String j;

    @SerializedName("reminderTime")
    private long m;

    @SerializedName("reportTime")
    private long n;

    @SerializedName("remarks")
    private String o;

    public long n() {
        return this.n;
    }

    public void e(long j) {
        this.n = j;
    }

    public long f() {
        return this.h;
    }

    public void d(long j) {
        this.h = j;
    }

    public int g() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.i = i;
    }

    public int h() {
        return this.i;
    }

    public void g(String str) {
        this.j = str;
    }

    public String i() {
        return this.j;
    }

    public String j() {
        return this.g;
    }

    public void e(String str) {
        this.g = str;
    }

    public void i(String str) {
        this.o = str;
    }

    public String l() {
        return this.o;
    }

    public String e() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public long k() {
        return this.m;
    }

    public void c(long j) {
        this.m = j;
    }

    public String d() {
        return this.f13966a;
    }

    public void b(String str) {
        this.f13966a = str;
    }

    public String b() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }
}
