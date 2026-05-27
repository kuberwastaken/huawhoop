package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.R;
import com.huawei.health.sport.model.WorkoutRecord;
import com.huawei.operation.utils.TodoTaskInterface;
import health.compact.a.UnitUtil;

/* JADX INFO: loaded from: classes5.dex */
public class hqp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13930a;

    @SerializedName("currentValue")
    private String b;

    @SerializedName("linkUrl")
    private String c;

    @SerializedName("toDoId")
    private long d;
    private String e;

    @SerializedName(WorkoutRecord.Extend.COURSE_TARGET_VALUE)
    private String f;

    @SerializedName("createTime")
    private long g;

    @SerializedName("targetUnit")
    private String h;

    @SerializedName("status")
    private int i;

    @SerializedName("title")
    private String j;

    @SerializedName("toDoType")
    private int k;
    private TodoTaskInterface l;

    @SerializedName("toDoContent")
    private String n;

    public String toString() {
        return "TodoCardRecyModel{title='" + this.j + "', name='" + this.e + "', type=" + this.k + ", time=" + this.g + ", todoTaskObject=" + this.l + ", id=" + this.d + ", status=" + this.i + ", linkUrl='" + this.c + "', todoContent='" + this.n + "', targetValue='" + this.f + "', targetUnit='" + this.h + "', currentValue='" + this.b + "'}";
    }

    public String m() {
        return this.j;
    }

    public void e(String str) {
        this.j = str;
    }

    public String e() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public long i() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public int n() {
        return this.k;
    }

    public void d(int i) {
        this.k = i;
    }

    public TodoTaskInterface k() {
        return this.l;
    }

    public void a(TodoTaskInterface todoTaskInterface) {
        this.l = todoTaskInterface;
    }

    public long b() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public void c(int i) {
        this.i = i;
    }

    public String a() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String l() {
        return this.n;
    }

    public void a(String str) {
        this.n = str;
    }

    public String f() {
        return this.f;
    }

    public String h() {
        return this.h;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String j() {
        TodoTaskInterface todoTaskInterface = this.l;
        if (todoTaskInterface != null) {
            return todoTaskInterface.getProgress();
        }
        if (TextUtils.isEmpty(this.f)) {
            return "";
        }
        int iB = plt.b(this.f);
        return pla.a(R.plurals._2130903361_res_0x7f030141, iB, UnitUtil.e(plt.b(this.b), 1, 0), UnitUtil.e(iB, 1, 0));
    }

    public int d() {
        return this.f13930a;
    }

    public void e(int i) {
        this.f13930a = i;
    }
}
