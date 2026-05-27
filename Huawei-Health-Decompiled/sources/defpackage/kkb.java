package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kkb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pageExposureTime")
    private long f14719a;

    @SerializedName("pageId")
    private String b;

    @SerializedName("pageName")
    private String c;

    @SerializedName("pageClass")
    private String d;

    @SerializedName("exposureInfo")
    private List<kjy> e;

    public kkb(String str, String str2, String str3, long j, List<kjy> list) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f14719a = j;
        this.e = list;
    }

    public String e() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public long c() {
        return this.f14719a;
    }

    public List<kjy> a() {
        return this.e;
    }
}
