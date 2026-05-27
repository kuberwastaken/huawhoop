package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ozk {

    @SerializedName("dataExceptionItem")
    private int c;

    @SerializedName("trendChangeItem")
    private int d;

    public int d() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "DataStatictics{dataExceptionItem=" + this.c + ", trendChangeItem=" + this.d + '}';
    }
}
