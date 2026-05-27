package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class gib implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mMarkPoints")
    private List<irt> f13468a;

    @SerializedName("mMarkIndexList")
    private List<Integer> b;

    @SerializedName("mDataMap")
    private Map<String, String> c = new HashMap();

    @SerializedName("mPoints")
    private List<irt> d;

    @SerializedName("mDataList")
    private List<gie> e;

    @SerializedName("mThumbnail")
    private String j;

    public void c(Map<String, String> map) {
        this.c = map;
    }

    public Map<String, String> d() {
        return this.c;
    }

    public void d(List<irt> list) {
        this.d = list;
    }

    public List<irt> e() {
        return this.d;
    }

    public String h() {
        return this.j;
    }

    public void e(String str) {
        this.j = str;
    }

    public List<gie> b() {
        return this.e;
    }

    public void a(List<gie> list) {
        this.e = list;
    }

    public List<irt> a() {
        return this.f13468a;
    }

    public void e(List<irt> list) {
        this.f13468a = list;
    }

    public List<Integer> c() {
        return this.b;
    }

    public void b(List<Integer> list) {
        this.b = list;
    }
}
