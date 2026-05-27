package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("dtStart")
    private long f13334a;

    @SerializedName("dtEnd")
    private long b;

    @SerializedName("cycleInterval")
    private int c;

    @SerializedName("cyclePeriod")
    private fxg d;

    @SerializedName("allDayType")
    private boolean e;

    @SerializedName("objectiveRelation")
    private int f;

    @SerializedName("endDay")
    private int g;

    @SerializedName("name")
    private String h;

    @SerializedName("objectiveInfos")
    private List<fxj> i;

    @SerializedName("metadata")
    private String j;

    @SerializedName("originalFlag")
    private int k;

    @SerializedName("taskId")
    private String l;

    @SerializedName("scheduleResults")
    private List<fxk> m;

    @SerializedName("scheduleId")
    private String n;

    @SerializedName("startDay")
    private int o;

    @SerializedName("timeZone")
    private String q;

    public String d() {
        return this.n;
    }

    public List<fxj> a() {
        return this.i;
    }

    public String b() {
        return this.j;
    }

    public List<fxk> e() {
        return this.m;
    }
}
