package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lqj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("uuid")
    private String f15399a;

    @SerializedName("sortLetter")
    private String b;

    @SerializedName("phoneList")
    private List<lql> c;

    @SerializedName("name")
    private String d;

    @SerializedName("sortKey")
    private String e;

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f15399a = str;
    }

    public void a(List<lql> list) {
        this.c = list;
    }

    public void c(String str) {
        this.b = str;
    }
}
