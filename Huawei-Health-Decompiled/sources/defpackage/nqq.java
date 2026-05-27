package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes7.dex */
public class nqq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ParsedFieldTag.MEDAL_ID)
    private String f16125a;

    @SerializedName("timestamp")
    private long b;

    @SerializedName(ParsedFieldTag.MEDAL_TYPE)
    private String c;

    @SerializedName("gainTime")
    private String d;

    @SerializedName(ParsedFieldTag.GAIN_COUNT)
    private int e;

    public String b() {
        return this.f16125a;
    }

    public void c(String str) {
        this.f16125a = str;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(long j) {
        this.b = j;
    }

    public String c() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }
}
