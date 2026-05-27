package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ubx implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("subtitle")
    private String f18259a;

    @SerializedName("jumpToManager")
    private List<String> b;

    @SerializedName("manufactures")
    private List<String> c;

    @SerializedName("jumpDetail")
    private List<String> d;

    @SerializedName("btn")
    private String e;

    @SerializedName("title")
    private String f;

    @SerializedName("type")
    private String i;

    public String i() {
        return this.i;
    }

    public String d() {
        return this.f;
    }

    public String b() {
        return this.e;
    }

    public List<String> e() {
        return this.c;
    }

    public List<String> a() {
        return this.d;
    }

    public List<String> c() {
        return this.b;
    }
}
