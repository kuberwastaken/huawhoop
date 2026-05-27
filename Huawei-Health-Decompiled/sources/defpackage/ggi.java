package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ggi implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("task_type")
    private int f13442a;

    @SerializedName("task_code")
    private String b;

    @SerializedName("daily_task_card")
    private ggj c;

    @SerializedName("task_id")
    private int d;

    public void e(int i) {
        this.d = i;
    }

    public int e() {
        return this.d;
    }

    public void b(int i) {
        this.f13442a = i;
    }

    public int d() {
        return this.f13442a;
    }

    public void d(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(ggj ggjVar) {
        this.c = ggjVar;
    }

    public ggj c() {
        return this.c;
    }

    public String toString() {
        return "{\"DailyTask\": {\"taskId\":" + this.d + ", \"taskType\":" + this.f13442a + ", \"taskCode\": \"" + this.b + "\", \"dailyTaskCard\":" + this.c + "}}";
    }
}
