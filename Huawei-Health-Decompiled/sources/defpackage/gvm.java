package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class gvm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cheerCount")
    private int f13638a;

    @SerializedName("actionName")
    private String b;

    @SerializedName("goodCount")
    private int c;

    @SerializedName("actType")
    private String d;

    @SerializedName("finishedAct")
    private int e;

    @SerializedName("perfectCount")
    private int f;

    @SerializedName("theoryAct")
    private int g;

    @SerializedName("greatCount")
    private int i;

    @SerializedName("missCount")
    private int j;

    public String c() {
        return this.b;
    }

    public int a() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public int e() {
        return this.i;
    }

    public int b() {
        return this.c;
    }

    public int d() {
        return this.f13638a;
    }

    public int g() {
        return this.j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("SingleActionSummaryBean{actionName=");
        stringBuffer.append(this.b);
        stringBuffer.append(", actType=").append(this.d);
        stringBuffer.append(", finishedAct=").append(this.e);
        stringBuffer.append(", theoryAct=").append(this.g);
        stringBuffer.append(", perfectCount=").append(this.f);
        stringBuffer.append(", greatCount=").append(this.i);
        stringBuffer.append(", goodCount=").append(this.c);
        stringBuffer.append(", cheerCount=").append(this.f13638a);
        stringBuffer.append(", missCount=").append(this.j);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
