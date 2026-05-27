package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class guv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("balanceScore")
    private int f13632a;

    @SerializedName("completionScore")
    private int b;

    @SerializedName("beautyScore")
    private int c;

    @SerializedName("coordinatingScore")
    private int d;

    @SerializedName("softScore")
    private int e;

    @SerializedName("trickScore")
    private int f;

    public int b() {
        return this.f13632a;
    }

    public int a() {
        return this.d;
    }

    public int f() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("CompletedActionScoreBean{balanceScore=");
        stringBuffer.append(this.f13632a);
        stringBuffer.append(", coordinatingScore=").append(this.d);
        stringBuffer.append(", trickScore=").append(this.f);
        stringBuffer.append(", softScore=").append(this.e);
        stringBuffer.append(", beautyScore=").append(this.c);
        stringBuffer.append(", completionScore=").append(this.b);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
