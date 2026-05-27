package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class tsc {

    @SerializedName("setting")
    private tsh c;

    @SerializedName("id")
    private int d = 0;

    public tsc(tsh tshVar) {
        this.c = tshVar;
    }

    public int d() {
        return this.d;
    }

    public tsh e() {
        return this.c;
    }

    public String toString() {
        return "FastingLiteMode{mId=" + this.d + ", mSetting=" + this.c + '}';
    }
}
