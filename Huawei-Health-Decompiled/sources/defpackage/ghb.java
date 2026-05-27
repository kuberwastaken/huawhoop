package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ghb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("task_code")
    private String f13456a;

    @SerializedName("daily_task_card")
    private ggj b;

    @SerializedName("task_type")
    private int c;

    @SerializedName("task_id")
    private int d;

    @SerializedName("task_prob")
    private String e;

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.f13456a = str;
    }

    public void a(ggj ggjVar) {
        this.b = ggjVar;
    }
}
