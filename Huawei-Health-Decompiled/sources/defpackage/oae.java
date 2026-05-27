package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class oae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("actionId")
    private String f16258a;

    @SerializedName("dayNo")
    private int b;

    @SerializedName(ParsedFieldTag.ACTION_TYPE)
    private int c;

    @SerializedName("actions")
    private List<nzo> d;

    @SerializedName("operationType")
    private int e;

    @SerializedName("planType")
    private int f;

    @SerializedName("planId")
    private String g;

    @SerializedName("weekNo")
    private int h;

    public String b() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public int e() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.b = i;
    }

    public int d() {
        return this.b;
    }

    public List<nzo> c() {
        return this.d;
    }

    public void e(List<nzo> list) {
        this.d = list;
    }
}
