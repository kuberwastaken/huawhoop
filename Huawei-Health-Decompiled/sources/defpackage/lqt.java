package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lqt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("operation")
    private int f15412a;

    @SerializedName("major")
    private String b;

    @SerializedName("minor")
    private long c;

    @SerializedName("contactsList")
    private List<lqj> d;

    @SerializedName("sortLetter")
    private String e;

    public void a(String str) {
        this.b = str;
    }

    public void a(long j) {
        this.c = j;
    }

    public void e(int i) {
        this.f15412a = i;
    }

    public void c(String str) {
        this.e = str;
    }

    public void c(List<lqj> list) {
        this.d = list;
    }
}
