package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class trv {

    @SerializedName("biMetaDataList")
    private List<trp> c;

    @SerializedName("version")
    private int d;

    @SerializedName("needSync")
    private boolean e;

    public int c() {
        return this.d;
    }

    public boolean a() {
        return this.e;
    }

    public List<trp> e() {
        return this.c;
    }

    public String toString() {
        return "FastingLiteDeviceMessage{mVersion=" + this.d + ", mNeedSync=" + this.e + ", mBiMetaDataList=" + this.c + '}';
    }
}
