package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.messagecenter.model.CommonUtil;
import com.huawei.operation.utils.TodoTaskInterface;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import com.huawei.ui.thirdpartservice.syncdata.constants.SyncDataConstant;

/* JADX INFO: loaded from: classes4.dex */
public class dad implements TodoTaskInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("imgUrl")
    private String f12123a;

    @SerializedName("activityName")
    private String b;

    @SerializedName("activityId")
    private String c;

    @SerializedName("activityContext")
    private String d;

    @SerializedName("activityLink")
    private String e;

    @SerializedName("activityTargetTodo")
    private int f;

    @SerializedName(SyncDataConstant.BI_KEY_ACTIVITY_TYPE)
    private int h;

    @SerializedName("activityPosition")
    private int i;

    @SerializedName("activityStatus")
    private int j;

    @SerializedName("completeFlagTodo")
    private int k;

    @SerializedName("continuityTodo")
    private int l;

    @SerializedName("endDate")
    private String m;

    @SerializedName("haveHistoryTodo")
    private int n;

    @SerializedName("numberOfPeople")
    private String o;

    @SerializedName(CommonUtil.IMAGE_TEXT_SEPARATE_SWITCH)
    private int p;

    @SerializedName("timeZone")
    private String r;

    @SerializedName(CommonUtil.PAGE_TYPE)
    private String s;

    @SerializedName("matchBeginDate")
    private String t;

    @SerializedName("rotinePosition")
    private int u;

    @SerializedName("targetDaysTodo")
    private int v;

    @SerializedName("templateType")
    private int w;

    @SerializedName("teamFlag")
    private int x;

    @SerializedName(ParsedFieldTag.BEGIN_DATE)
    private String y;

    @SerializedName("appVersion")
    private String g = "";

    @SerializedName("workoutUserLable")
    private String q = "";

    @Override // com.huawei.operation.utils.TodoTaskInterface
    public int getIconId() {
        return 0;
    }

    public String v() {
        return this.q;
    }

    public void k(String str) {
        this.q = str;
    }

    public String x() {
        return this.s;
    }

    public void m(String str) {
        this.s = str;
    }

    public String u() {
        return this.r;
    }

    public void n(String str) {
        this.r = str;
    }

    public String a() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String d() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String e() {
        return this.f12123a;
    }

    public void d(String str) {
        this.f12123a = str;
    }

    public String t() {
        return this.y;
    }

    public void j(String str) {
        this.y = str;
    }

    public String o() {
        return this.m;
    }

    public void i(String str) {
        this.m = str;
    }

    public String l() {
        return this.o;
    }

    public void g(String str) {
        this.o = str;
    }

    public int g() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public int i() {
        return this.h;
    }

    public void b(int i) {
        this.h = i;
    }

    public int p() {
        return this.w;
    }

    public void h(int i) {
        this.w = i;
    }

    public String c() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public int r() {
        return this.u;
    }

    public void f(int i) {
        this.u = i;
    }

    public int j() {
        return this.i;
    }

    public void d(int i) {
        this.i = i;
    }

    public String s() {
        return this.t;
    }

    public void h(String str) {
        this.t = str;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public int m() {
        return this.n;
    }

    public void g(int i) {
        this.n = i;
    }

    public int f() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public int k() {
        return this.l;
    }

    public void j(int i) {
        this.l = i;
    }

    public int q() {
        return this.v;
    }

    public void i(int i) {
        this.v = i;
    }

    public int n() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public String h() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public void k(int i) {
        this.p = i;
    }

    public int w() {
        return this.p;
    }

    public int y() {
        return this.x;
    }

    public void l(int i) {
        this.x = i;
    }

    public boolean z() {
        return this.x == 1;
    }

    public String toString() {
        return "OperationObject{activityId='" + this.c + "', activityName='" + this.b + "', activityImgUrl='" + this.f12123a + "', startDate='" + this.y + "', endDate='" + this.m + "', mTimeZone='" + this.r + "', joinNum='" + this.o + "', activityStatus=" + this.j + ", activityType=" + this.h + ", teamFlag=" + this.x + ", matchBeginDate='" + this.t + "', activityContext='" + this.d + "', haveHistoryTodo=" + this.n + ", activityTargetTodo=" + this.f + ", continuityTodo=" + this.l + ", targetDaysTodo=" + this.v + ", completeFlagTodo=" + this.k + ", templateType=" + this.w + ", activityLink='" + this.e + "', rotinePosition=" + this.u + ", activityPosition=" + this.i + ", mPageType=" + this.s + ", mWorkoutUserLable=" + this.q + '}';
    }

    @Override // com.huawei.operation.utils.TodoTaskInterface
    public String getProgress() {
        return "";
    }
}
