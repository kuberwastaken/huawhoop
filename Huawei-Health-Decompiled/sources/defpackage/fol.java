package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.trackprocess.model.GpsPoint;
import com.huawei.operation.ble.BleConstants;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fol implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("distanceTypeId")
    private int f13059a;

    @SerializedName("cityId")
    private String b;

    @SerializedName("distanceToUser")
    private double c;

    @SerializedName("description")
    private String d;

    @SerializedName("createTime")
    private long e;

    @SerializedName("participateNum")
    private long f;

    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long g;

    @SerializedName("flag")
    private int h;

    @SerializedName("feedbackNum")
    private long i;

    @SerializedName("geoHash")
    private String j;

    @SerializedName("pathClass")
    private int k;

    @SerializedName("pathId")
    private String l;

    @SerializedName("pathImageInfo")
    private fop m;

    @SerializedName("participateUserNum")
    private long n;

    @SerializedName("pathFlag")
    private int o;

    @SerializedName("pathName")
    private String p;

    @SerializedName("pathType")
    private int q;

    @SerializedName("pathLabel")
    private List<String> r;

    @SerializedName("pathLocation")
    private GpsPoint s;

    @SerializedName("pathThemes")
    private List<Integer> t;

    @SerializedName("state")
    private int u;

    @SerializedName("pathTypes")
    private List<Integer> v;

    @SerializedName("validEndDay")
    private int x;

    @SerializedName(BleConstants.TOTAL_DISTANCE)
    private double y;

    public String g() {
        return this.l;
    }

    public List<Integer> l() {
        return this.t;
    }

    public int b() {
        return this.k;
    }

    public int e() {
        return this.f13059a;
    }

    public List<Integer> o() {
        return this.v;
    }

    public String j() {
        return this.p;
    }

    public List<String> f() {
        return this.r;
    }

    public fop h() {
        return this.m;
    }

    public long c() {
        return this.n;
    }

    public double m() {
        return this.y;
    }

    public GpsPoint i() {
        return this.s;
    }

    public double a() {
        return this.c;
    }

    public void a(double d) {
        this.c = d;
    }

    public long d() {
        return this.f;
    }

    public int n() {
        return this.u;
    }

    public String toString() {
        return "HotPathOperationInfo{pathId='" + this.l + "', cityId='" + this.b + "', geoHash='" + this.j + "', pathFlag=" + this.o + ", pathClass=" + this.k + ", pathThemes=" + this.t + ", pathType=" + this.q + ", distanceTypeId=" + this.f13059a + ", pathTypes=" + this.v + ", pathName='" + this.p + "', pathLabel=" + this.r + ", pathImageInfo=" + this.m + ", participateUserNum=" + this.n + ", totalDistance=" + this.y + ", pathLocation=" + this.s + ", validEndDay=" + this.x + ", feedbackNum=" + this.i + ", distanceToUser=" + this.c + ", description='" + this.d + "', flag=" + this.h + ", createTime=" + this.e + ", modifyTime=" + this.g + ", participateNum=" + this.f + ", state=" + this.u + '}';
    }
}
