package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class bsu {

    @SerializedName("challengeId")
    private int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("healthGoalName")
    private String f486a = "";

    @SerializedName("healthGoalDescription")
    private String d = "";

    @SerializedName("healthGoalSelected")
    private int c = 0;

    public int a() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public String d() {
        return this.f486a;
    }

    public void b(String str) {
        this.f486a = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public int e() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }
}
