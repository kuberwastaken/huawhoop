package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ggh {

    @SerializedName("taskNum")
    private int b;

    @SerializedName("taskTime")
    private int c;

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public String toString() {
        return "{\"DailyTaskCard\": {\"taskNum\":" + this.b + ", \"taskTime\":" + this.c + "}}";
    }
}
