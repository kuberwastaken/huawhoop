package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class mny {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("min")
    private Object f15751a;

    @SerializedName("count")
    private Object b;

    @SerializedName("max")
    private Object c;

    @SerializedName("sum")
    private Object d;

    @SerializedName("avg")
    private Object e;

    public void a(Object obj) {
        this.e = obj;
    }

    public void e(Object obj) {
        this.c = obj;
    }

    public void c(Object obj) {
        this.f15751a = obj;
    }

    public void d(Object obj) {
        this.d = obj;
    }

    public void b(Object obj) {
        this.b = obj;
    }
}
