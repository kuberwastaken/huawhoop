package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.EventMonitorRecord;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
class trp {

    @SerializedName("biMap")
    private Map<String, Object> d;

    @SerializedName(EventMonitorRecord.EVENT_ID)
    private String e;

    trp() {
    }

    public String e() {
        return this.e;
    }

    public Map<String, Object> c() {
        return this.d;
    }

    public String toString() {
        return "BiMetaData{mEventId='" + this.e + "', mBiMap=" + this.d + '}';
    }
}
