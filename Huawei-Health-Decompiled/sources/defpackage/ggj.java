package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ggj implements Serializable {

    @SerializedName("task_time")
    private int c;

    @SerializedName("task_num")
    private int e;

    public void b(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public void e(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "{\"DailyTaskCard\": {\"taskNum\":" + this.e + ", \"taskTime\":" + this.c + "}}";
    }
}
