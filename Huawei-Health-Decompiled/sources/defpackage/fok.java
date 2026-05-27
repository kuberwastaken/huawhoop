package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.trackprocess.model.GpsPoint;
import com.huawei.operation.ble.BleConstants;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fok implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("description")
    private String f13058a;

    @SerializedName(BleConstants.TOTAL_DISTANCE)
    private double ab;

    @SerializedName("timeRanking")
    private List<foq> ac;

    @SerializedName("cityId")
    private String b;

    @SerializedName("coordinate")
    private String c;

    @SerializedName("distanceTypeId")
    private int d;

    @SerializedName("cpPoint")
    private fnm e;

    @SerializedName("participateNum")
    private long f;

    @SerializedName("minTime")
    private long g;

    @SerializedName("numsRanking")
    private List<foq> h;

    @SerializedName("num")
    private int i;

    @SerializedName("flag")
    private int j;

    @SerializedName("pathBehaviorwait")
    private foi k;

    @SerializedName("pathFlag")
    private int l;

    @SerializedName("participateUserNum")
    private long m;

    @SerializedName("pathClass")
    private int n;

    @SerializedName("pathComment")
    private String o;

    @SerializedName("pathId")
    private String p;

    @SerializedName("pathLocation")
    private GpsPoint q;

    @SerializedName("pathName")
    private String r;

    @SerializedName("pathLabel")
    private List<String> s;

    @SerializedName("pathImageInfo")
    private fop t;

    @SerializedName("pathType")
    private int u;

    @SerializedName("pathPoints")
    private List<GpsPoint> v;

    @SerializedName("pathTypes")
    private List<Integer> w;

    @SerializedName("pathThemes")
    private List<Integer> x;

    @SerializedName("state")
    private int y;

    @SerializedName("validEndDay")
    private int z;

    public String k() {
        return this.p;
    }

    public String c() {
        return this.b;
    }

    public List<GpsPoint> o() {
        return this.v;
    }

    public int i() {
        return this.l;
    }

    public int s() {
        return this.u;
    }

    public List<Integer> q() {
        return this.w;
    }

    public String m() {
        return this.r;
    }

    public fop l() {
        return this.t;
    }

    public long h() {
        return this.m;
    }

    public long j() {
        return this.f;
    }

    public double v() {
        return this.ab;
    }

    public GpsPoint n() {
        return this.q;
    }

    public long b() {
        return this.g;
    }

    public List<foq> g() {
        return this.h;
    }

    public List<foq> p() {
        return this.ac;
    }

    public String d() {
        return this.f13058a;
    }

    public int t() {
        return this.y;
    }

    public fnm a() {
        return this.e;
    }

    public String e() {
        return this.c;
    }

    public List<Integer> r() {
        return this.x;
    }

    public int f() {
        return this.n;
    }

    public String toString() {
        return "HotPathDetailInfo{pathId='" + this.p + "', pathPoints=" + this.v + ", pathFlag=" + this.l + ", pathType=" + this.u + ", pathTypes=" + this.w + ", pathClass=" + this.n + ", pathThemes=" + this.x + ", pathName='" + this.r + "', pathLabel=" + this.s + ", pathImageInfo=" + this.t + ", participateUserNum=" + this.m + ", participateNum=" + this.f + ", validEndDay=" + this.z + ", totalDistance=" + this.ab + ", pathLocation=" + this.q + ", num=" + this.i + ", minTime=" + this.g + ", numsRanking=" + this.h + ", timeRanking=" + this.ac + ", description='" + this.f13058a + "', flag=" + this.j + ", state=" + this.y + ", cpPoint=" + this.e + ", pathComment=" + this.o + ", coordinate=" + this.c + ", pathBehavior=" + this.k + '}';
    }
}
