package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class bor {

    @SerializedName("minute")
    private final int c;

    @SerializedName("hour")
    private final int d;

    public bor(int i, int i2) {
        this.d = i;
        this.c = i2;
    }

    public int c() {
        return this.d;
    }

    public int a() {
        return this.c;
    }

    public String toString() {
        return "ReminderPlanBean{mHour=" + this.d + ", mMinute=" + this.c + '}';
    }
}
