package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class nzq implements Serializable, Cloneable {
    private static final long serialVersionUID = 5664805502014025933L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("duration")
    private long f16245a;

    @SerializedName("id")
    private String b;

    @SerializedName("name")
    private String c;

    @SerializedName("durationMan")
    private long d;

    @SerializedName("picture")
    private String e;

    public String d() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String b() {
        return this.e;
    }

    public long e() {
        if (hmv.a() == 0) {
            long j = this.d;
            if (j != 0) {
                return j;
            }
        }
        return this.f16245a;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
