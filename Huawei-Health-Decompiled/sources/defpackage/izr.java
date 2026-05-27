package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes10.dex */
public class izr {

    @SerializedName("version")
    private int b;

    @SerializedName(ParsedFieldTag.RECORD_DAY)
    private int d;

    public int c() {
        return this.d;
    }

    public int d() {
        return this.b;
    }

    public String toString() {
        return "HealthLifeVersionDTO{mRecordDay=" + this.d + ", mVersion=" + this.b + '}';
    }
}
