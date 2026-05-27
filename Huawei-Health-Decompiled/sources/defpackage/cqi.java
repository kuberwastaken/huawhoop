package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cqi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("endTime")
    private long f11986a;

    @SerializedName("completeValue")
    private double b;

    @SerializedName("createTime")
    private long c;

    @SerializedName("currentWeight")
    private double d;

    @SerializedName("frequency")
    private int e;

    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long f;

    @SerializedName("recordDays")
    private List<Long> g;

    @SerializedName("id")
    private long h;

    @SerializedName("goalType")
    private int i;

    @SerializedName("goalValue")
    private double j;

    @SerializedName("status")
    private int l;

    @SerializedName("timeZone")
    private String m;

    @SerializedName("unitValue")
    private double n;

    @SerializedName("startTime")
    private long o;

    public long g() {
        return this.h;
    }

    public int d() {
        return this.i;
    }

    public double e() {
        return this.j;
    }

    public void c(double d) {
        this.b = d;
    }

    public double c() {
        return this.b;
    }

    public void e(List<Long> list) {
        this.g = list;
    }

    public List<Long> f() {
        return this.g;
    }

    public double a() {
        return this.d;
    }

    public long h() {
        return this.o;
    }

    public long b() {
        return this.f11986a;
    }

    public String j() {
        return this.m;
    }

    public int i() {
        return this.l;
    }

    public void d(int i) {
        this.l = i;
    }

    public String toString() {
        return "GoalBean{id=" + this.h + ", goalType=" + this.i + ", goalValue=" + this.j + ", completeValue=" + this.b + ", recordDays=" + this.g + ", currentWeight=" + this.d + ", frequency=" + this.e + ", unitValue=" + this.n + ", startTime=" + this.o + ", endTime=" + this.f11986a + ", createTime=" + this.c + ", modifyTime=" + this.f + ", status=" + this.l + ", timeZone='" + this.m + "'}";
    }
}
