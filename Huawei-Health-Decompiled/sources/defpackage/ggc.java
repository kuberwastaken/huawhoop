package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ggc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("advice_type")
    private int f13440a;

    @SerializedName("advice_code")
    private String b;

    @SerializedName("advice_id")
    private int c;

    public void b(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.f13440a = i;
    }

    public void d(String str) {
        this.b = str;
    }
}
