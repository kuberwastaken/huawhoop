package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cew {

    @SerializedName("scanType")
    private int b;
    private int e = -32768;

    @SerializedName("rssi")
    public int c() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }
}
