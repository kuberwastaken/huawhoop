package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class igr {

    @SerializedName("mRecordNum")
    private int d;

    @SerializedName("mPace")
    private float e;

    public void e(int i) {
        this.d = i;
    }

    public void b(float f) {
        this.e = f;
    }

    public String toString() {
        return "HistoryBestResult{mRecordNum=" + this.d + ", mPace=" + this.e + '}';
    }
}
